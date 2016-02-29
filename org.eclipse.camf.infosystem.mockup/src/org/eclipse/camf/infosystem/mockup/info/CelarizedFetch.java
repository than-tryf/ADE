package org.eclipse.camf.infosystem.mockup.info;
/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 * 	Stalo Sofokleous - initial API and implementation
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageType;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class CelarizedFetch extends Job {

	  private Connection con = null;

	  private static CelarizedFetch instance = null;
	  
	  private ArrayList<ICloudProvider> selectedProviders = new ArrayList<ICloudProvider>();
	  
	  private ArrayList<VirtualMachineImage> base_images = new ArrayList<VirtualMachineImage>();
	  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
	  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
	  private ArrayList<VirtualMachineImageFlavor> vm_flavors = new ArrayList<VirtualMachineImageFlavor>();


	  /**
	   * @param name
	   */
	  private CelarizedFetch( final String name ) {
	    super( name );
	  }
	 
	  /**
	   * Get a singleton instance of FetchJob
	   * @param name the name that will be displayed in the progress view
	   * @return a FetchJob
	   */
	  public static CelarizedFetch getInstance (final String name) {
	    if (instance == null) {
	      instance = new CelarizedFetch( name );
	    }
	    return instance;
	  }
	  
	  @Override
	  protected IStatus run( final IProgressMonitor monitor ) {
	           
	    IProgressMonitor localMonitor
	    = ( monitor != null )
	      ? monitor
	      : new NullProgressMonitor();
	   
	    localMonitor.beginTask( "Retrieving information", 6 * 10 ); //$NON-NLS-1$

	      ICloudElement[] providers = Preferences.getDefinedCloudProviders();
	      GenericCloudProvider provider = (GenericCloudProvider) providers[0];
	      
	      String uri = provider.getUri();
	      if (uri!=null){
	        if (uri.endsWith( "/" )){
	          uri = uri.substring( 0, uri.length()-1 );
	        }
	      }
	      else{
	        localMonitor.done();
	        Status status = new Status( IStatus.ERROR,
	                             "eu.celar.infosystem", //$NON-NLS-1$
	                             "Cannot fetch data. URI is null" ); //$NON-NLS-1$
	        return status;
	      }
	      
	      String port = provider.getPort();
	      if ( port!=null){
	        if (port.endsWith( "/" )){
	          port = port.substring( 0, port.length()-1 );
	        }
	        uri = uri + ":" + port;
	      }
	      uri = uri + "/resources/";

	      try {
	        try {
	          fetchBaseMachineImages( uri, localMonitor );
	          //fetchMonitorProbes( localMonitor );
	          fetchJCatascopiaMonitorProbes( localMonitor );
	          //fetchResizingActions (localMonitor );
	          fetchFlavors ( uri, localMonitor );
	        } catch( JSONException e ) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }

	      } catch( SQLException e ) {     
	        e.printStackTrace();
	      } finally {
	        if (this.con != null) {
	          try {
	            this.con.close();
	          } catch( SQLException e ) {
	            e.printStackTrace();
	          }  
	        }      

	    }

	    localMonitor.done();
	    Status status = new Status( IStatus.OK,
	                         "eu.celar.infosystem", //$NON-NLS-1$
	                         "Information data fetched successfully." ); //$NON-NLS-1$
	    return status;
	  }
	   
	  private void fetchBaseMachineImages (String uri, final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get VM Images
	    String images = getFromCelarDB(uri, "images");

	    if ( images.equals( "" ) == false ) {

	      images = "{\"images\":" + images + "}";
	      String output_json = images;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray images_array = obj.getJSONArray( "images" ); //$NON-NLS-1$

	      if ( images_array != null ){
	        for (int i=0; i < images_array.length(); i++){
	          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
	          /*
	           * get the necessary vmi fields
	           */
	  
	          vmi.setDescription( "h" );
	          vmi.setURL( "h" );

	          vmi.setUID( images_array.getJSONObject( i ).getString( "name" ) );
	          vmi.setName( images_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
	          
	          vmi.setType( VirtualMachineImageType.BASE_IMAGE );
	         
	          //add new vmi to images list
	         instance.base_images.add( vmi ); 
	        }
	      }
	    }
	  }

	  
	  private void fetchFlavors (String uri, final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get Flavors
	    String flavors = getFromCelarDB(uri, "flavors");

	    if ( flavors.equals( "" ) == false ) {

	      flavors = "{\"flavors\":" + flavors + "}";
	      String output_json = flavors;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray images_array = obj.getJSONArray( "flavors" ); //$NON-NLS-1$

	      if ( images_array != null ){
	        for (int i=0; i < images_array.length(); i++){
	          VirtualMachineImageFlavor vmif = InfoSystemFactory.eINSTANCE.createVirtualMachineImageFlavor();
	          /*
	           * get the necessary vmif fields
	           */
	 
	          vmif.setUID( images_array.getJSONObject( i ).getString( "id" ) );
	          vmif.setName( images_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
	         //System.out.println(vmif.getName()+" "+vmif.getUID());
	          //add new vmi to images list
	         instance.vm_flavors.add( vmif ); 
	        }
	      }
	    }
	  }
	  
	  //fetch probes from JCatascopia Probe Library
	  private void fetchJCatascopiaMonitorProbes (final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get Monitoring Probes
	    String probes = getJCatascopiaProbes();
	    
	    if ( probes.equals( "" ) == false ) {
	      
	      probes = "{\"probes\":" + probes + "}";
	      String output_json = probes;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
	      
	      if ( probes_array != null ){
	        for (int i=0; i < probes_array.length(); i++){
	          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
	          /*
	           * get the necessary mp fields
	           */
	          mp.setName( probes_array.getJSONObject( i ).getString( "probe" )); //$NON-NLS-1$ );
	          mp.setMetrics( probes_array.getJSONObject( i ).getString( "metrics" ) );
	          mp.setDescription( probes_array.getJSONObject( i ).getString( "desc" ) );
	                    
	          //add new monitor probe to probes list
	          instance.monitor_probes.add( mp ); 
	        }
	        
	      }
	    }    
	  }
	  
	  //fetch probes from CELAR DB
	  private void fetchMonitorProbes (String uri, final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get Monitoring Probes
	    String probes = getFromCelarDB(uri, "probes");
	    
	    if ( probes.equals( "" ) == false ) {
	      
	      probes = "{\"probes\":" + probes + "}";
	      String output_json = probes;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
	      
	      if ( probes_array != null ){
	        for (int i=0; i < probes_array.length(); i++){
	          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
	          /*
	           * get the necessary mp fields
	           */
	          mp.setName( probes_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
	          mp.setDescription( probes_array.getJSONObject( i ).getString( "metrics" ) );
	          
	          System.out.println(mp.getName());
	          System.out.println(mp.getDescription());
	          
	          //add new monitor probe to probes list
	          instance.monitor_probes.add( mp ); 
	        }
	        
	      }
	    }    
	  }
	  
	  private void fetchResizingActions (String uri, final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get Resizing Actions
	    String actions = getFromCelarDB(uri, "actions"); 
	    
	    if ( actions.equals( "" ) == false ) {
	      
	      actions = "{\"actions\":" + actions + "}";
	      String output_json = actions;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray actions_array = obj.getJSONArray( "actions" ); //$NON-NLS-1$
	     
	      if ( actions_array != null ){
	        for (int i=0; i < actions_array.length(); i++){
	          ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
	          /*
	           * get the necessary ra fields
	           */
	          ra.setName( actions_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
	         
	          //add new ra to resizing_actions list
	          instance.resize_actions.add( ra ); 
	        }
	      }
	    }
	  }
	  
	  /**
	   * @return A list with the available Base Machine Images
	   */
	  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
	    return instance.base_images;
	  }
	    
	  /**
	   * @return A list with available Monitoring Probes
	   */
	  public ArrayList<MonitoringProbe> getMonitoringProbes () {
	    return instance.monitor_probes;
	  }
	  
	  /**
	   * @return A list with available Resizing Actions
	   */
	  public ArrayList<ResizingAction> getResizingActions () {
	    return instance.resize_actions;
	  }
	  
	  /**
	   * @return A list with available flavors
	   */
	  public ArrayList<VirtualMachineImageFlavor> getInstanceTypes () {
	    return instance.vm_flavors;
	  }
	  
	  String getJCatascopiaProbes(){
	    JCatascopiaProbeRepo repo = new JCatascopiaProbeRepo();
	    String probes = null;
	    try {
	      probes = repo.getProbes();

	    } catch( JCatascopiaProbeRepoException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    //System.out.println(probes);
	    return probes;
	  }

	  String getFromCelarDB(String uri, String categoryName){
	    URL url = null;
	    URLConnection connection = null;    
	    String categoryString = "";

	    // Create a trust manager that does not validate certificate chains
	    TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	        public void checkClientTrusted(X509Certificate[] certs, String authType) {
	        }
	        public void checkServerTrusted(X509Certificate[] certs, String authType) {
	        }
	    } };
	    // Install the all-trusting trust manager
	    SSLContext sc = null;
	    try {
	      sc = SSLContext.getInstance("SSL");
	    } catch( NoSuchAlgorithmException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    try {
	      sc.init(null, trustAllCerts, new java.security.SecureRandom());
	    } catch( KeyManagementException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	    // Create all-trusting host name verifier
	    HostnameVerifier allHostsValid = new HostnameVerifier() {
	        public boolean verify(String hostname, SSLSession session) {
	            return true;
	        }
	    };

	    // Install the all-trusting host verifier
	    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

	    String celarManagerURL = uri;
	    try {
	      url = new URL (celarManagerURL + categoryName + "/");
	    } catch( MalformedURLException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	 
	    Reader reader = null;
	    BufferedReader br = null;
	    try {
	      connection = url.openConnection();
	      connection.setRequestProperty("Accept", "application/json");
	      reader = new InputStreamReader(connection.getInputStream());
	      br = new BufferedReader(reader); 
	      String line = "";
	      while ((line = br.readLine()) != null) {
	        categoryString = categoryString + line;
	      }        
	      br.close();
	    } catch( IOException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	     
	    return categoryString;
	  }
	     

	  
	  //Add JCatascopiaProbes
	  private void addJCatascopiaProbes (final IProgressMonitor monitor) throws SQLException, JSONException {

	      //JCatascopia metrics
	      String probes = "{\"probes\":[{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"proxyBytesOUT\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"proxyBytesIN\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"errorRate\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"servers\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"requestRate\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"avgResponseTime\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"bytesSent\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memFree\",\"name\":\"memFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:arch\",\"name\":\"arch\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memTotal\",\"name\":\"memTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuTotal\",\"name\":\"cpuTotal\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memCache\",\"name\":\"memCache\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestThroughput\",\"name\":\"requestThroughput\",\"units\":\"req/s\",\"type\":\"DOUBLE\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:maxThreads\",\"name\":\"maxThreads\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsOut\",\"name\":\"netPacketsOut\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:errorCount\",\"name\":\"errorCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesIN\",\"name\":\"netBytesIN\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskUsed\",\"name\":\"diskUsed\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Disk\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIdle\",\"name\":\"cpuIdle\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIOwait\",\"name\":\"cpuIOwait\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapFree\",\"name\":\"memSwapFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuUser\",\"name\":\"cpuUser\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskTotal\",\"name\":\"diskTotal\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"b9ba52a9826e4c48b1976fdecdc592ab:servers\",\"name\":\"servers\",\"units\":\"\",\"type\":\"INTEGER\",\"group\":\"HAProxy\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:iotime\",\"name\":\"iotime\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsed\",\"name\":\"memUsed\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestCount\",\"name\":\"requestCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadCount\",\"name\":\"currentThreadCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsedPercent\",\"name\":\"memUsedPercent\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:os\",\"name\":\"os\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsIN\",\"name\":\"netPacketsIN\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuNum\",\"name\":\"cpuNum\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuSystem\",\"name\":\"cpuSystem\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:btime\",\"name\":\"btime\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:processingTime\",\"name\":\"processingTime\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapTotal\",\"name\":\"memSwapTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:readkbps\",\"name\":\"readkbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskFree\",\"name\":\"diskFree\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadsBusy\",\"name\":\"currentThreadsBusy\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesReceived\",\"name\":\"bytesReceived\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:writekbps\",\"name\":\"writekbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesOUT\",\"name\":\"netBytesOUT\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"}]}";
	      String output_json = probes;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
	      
	      String probeGroup = null;
	      String metricName;
	      HashMap<String, String> hm = new HashMap<String, String>();
	      
	      for (int i=0; i < probes_array.length(); i++){
	        probeGroup = probes_array.getJSONObject( i ).getString( "group" );
	        metricName = probes_array.getJSONObject(i).getString( "name" );
	          
	        String value = hm.get( probeGroup );
	        
	        if (value != null)
	          metricName = value + ", \"" + metricName + "\"";
	        else
	          metricName = "\"" + metricName + "\"";
	        
	        hm.put( probeGroup, metricName );
	      }
	      
	      // Get a set of the entries
	      Set set = hm.entrySet();
	      // Get an iterator
	      Iterator i = set.iterator();
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         String key = me.getKey().toString();
	         String value = me.getValue().toString().replace( "\"null,", "" );
	         
	         hm.put( key, value );
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	      }
	      
	      // Get a set of the entries
	      set = hm.entrySet();
	      // Get an iterator
	      i = set.iterator();
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         String key = me.getKey().toString();
	         String value = me.getValue().toString();
	         
	         MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
	 
	         mp.setName( key ); //$NON-NLS-1$ );
	         mp.setDescription( "[" + value + "]" );

	         
	         //add new monitor probe to probes list
	         instance.monitor_probes.add( mp ); 
	      }
	      
	  }
	  
	}







