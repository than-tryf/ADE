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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/





//package org.eclipse.camf.infosystem.mockup.info;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.NullProgressMonitor;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.core.runtime.SubProgressMonitor;
//import org.eclipse.core.runtime.jobs.Job;
//import org.eclipse.ui.console.ConsolePlugin;
//import org.eclipse.ui.console.IConsole;
//import org.eclipse.ui.console.IConsoleManager;
//import org.eclipse.ui.console.MessageConsole;
//
//import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
//import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
//import org.eclipse.camf.infosystem.model.base.ResizingAction;
//import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
//import org.eclipse.camf.infosystem.model.base.UserApplication;
//import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
//import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
//import org.eclipse.camf.infosystem.model.base.VirtualMachineImageType;
//
//
///**
// * @authors Nicholas Loulloudes, Stalo Sofokleous
// *
// */
//public class FetchJob extends Job {
//
//  private Connection con = null;
//
//  private static FetchJob instance = null;
//  
//  private ArrayList<VirtualMachineImage> base_images = new ArrayList<VirtualMachineImage>();
//  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
//  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
//  private ArrayList<VirtualMachineImageFlavor> vm_flavors = new ArrayList<VirtualMachineImageFlavor>();
//
//  /**
//   * @param name
//   */
//  private FetchJob( final String name ) {
//    super( name );
//  }
// 
//  /**
//   * Get a singleton instance of FetchJob
//   * @param name the name that will be displayed in the progress view
//   * @return a FetchJob
//   */
//  public static FetchJob getInstance (final String name) {
//    if (instance == null) {
//      instance = new FetchJob( name );
//    }
//    return instance;
//  }
//  
//  @Override
//  protected IStatus run( final IProgressMonitor monitor ) {
//           
//    IProgressMonitor localMonitor
//    = ( monitor != null )
//      ? monitor
//      : new NullProgressMonitor();
//   
//    localMonitor.beginTask( "Retrieving information", 6 * 10 ); //$NON-NLS-1$
//
//    //createStaticCelarDB();
//    
//    try {
//      try {
//        fetchBaseMachineImages( localMonitor );
//        fetchMonitorProbes( localMonitor );
//        fetchResizingActions (localMonitor );
//        fetchFlavors ( localMonitor );
//      } catch( JSONException e ) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//
//    } catch( SQLException e ) {     
//      e.printStackTrace();
//    } finally {
//      if (this.con != null) {
//        try {
//          this.con.close();
//        } catch( SQLException e ) {
//          e.printStackTrace();
//        }  
//      }      
//    }
//      
//    
//    localMonitor.done();
//    Status status = new Status( IStatus.OK,
//                         "org.eclipse.camf.infosystem", //$NON-NLS-1$
//                         "Information data fetched successfully." ); //$NON-NLS-1$
//    return status;
//  }
// 
//    
//  
//  private void fetchBaseMachineImages (final IProgressMonitor monitor) throws SQLException, JSONException {
//    
// 
//    //CELAR Manager call : Get VM Images
//    String celarManagerURL = "http://83.212.107.38:8080/resources/";
//    URL url = null;
//    HttpURLConnection connection = null;
//    BufferedReader in = null;
//    String inputLine = null;
//    
//    String images = "";
//    try {
//      url = new URL (celarManagerURL + "images/");
//  
//      connection = (HttpURLConnection) url.openConnection();
//      connection.setDoInput( true );
//      connection.setRequestProperty("Accept", "application/json");
//      connection.setRequestMethod( "GET" );
//              
//      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//      while ((inputLine = in.readLine()) != null) {
//          images = images + inputLine;
//      }
//      in.close();
//      System.out.println(images);
//      
//      connection.disconnect();
//    } catch( MalformedURLException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch( IOException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    
//    //Okeanos Images
//    images = "[{\"id\":\"5ed5a29b-292c-4fe0-b32c-2e2b65628635\",\"name\":\"Ubuntu 12.04.1 LTS\"},{\"id\":\"b4713f20-3a41-4eaf-81ae-88698c18b3e8\",\"name\":\"Archlinux base install 2012.12.01\"},{\"id\":\"5583fed1-5273-4c64-9e32-3fbe476bd7b7\",\"name\":\"Ubuntu 12.04.2 LTS\"},{\"id\":\"917ee618-c03a-4473-9024-9448e12890c1\",\"name\":\"Ubuntu 10.04.4 LTS\"},{\"id\":\"e5a74e94-890b-44cc-8951-0786eeef7140\",\"name\":\"BackTrack5R3 w/ SSH & Correct Locale\"},{\"id\":\"c9e811fa-39a9-4d13-8a6f-9102105801cb\",\"name\":\"Kali Linux 1.0 - Former BackTrack5R3 (with update option)\"},{\"id\":\"90554939-41c9-42e6-b654-1e167743c950\",\"name\":\"Ubuntu 12.10\"},{\"id\":\"505dcadb-d978-4f2b-ba68-02fc69fb50a8\",\"name\":\"Ubuntu 12.10\"},{\"id\":\"9f82e379-b111-4f72-8fbf-4fb37aa5ccc9\",\"name\":\"Backtrack 5 R3 Gnome i386\"},{\"id\":\"c9f3980d-6a82-4121-b24e-d7b5f29a4a00\",\"name\":\"03/10/2013\"},{\"id\":\"0f12a5e0-5369-4bed-abd6-5b03d87cc5da\",\"name\":\"Ubuntu 12.04.3 LTS\"},{\"id\":\"545d36df-53da-46bd-86ed-759ac3eb1995\",\"name\":\"Ubuntu server 13.04\"},{\"id\":\"e9ec7d24-96a1-412d-8e05-569bac5744a4\",\"name\":\"Scientific Linux SL release 5.5 (Boron)\"},{\"id\":\"01a4b2f1-2acd-4031-8801-3d94ebe3f4d4\",\"name\":\"Ubuntu 13.04\"},{\"id\":\"8ff7d98a-9beb-46d2-8977-39b29443a7b2\",\"name\":\"Ubuntu 13.04\"},{\"id\":\"b26866dd-4626-4c12-85e3-9435048dd8a7\",\"name\":\"Ubuntu 13.04\"},{\"id\":\"493e78e9-f469-4a71-abea-4d50db71f535\",\"name\":\"Ubuntu 13.04\"},{\"id\":\"0e399015-8723-4c78-8198-75bdf693cdde\",\"name\":\"CKAN 2.1 base installation on a debian 7.1 system\"},{\"id\":\"4a65772b-98fd-43b3-b3b9-cd083849e63b\",\"name\":\"unknown\"},{\"id\":\"83c4c2d5-50b4-4400-b95d-3d10a760e8d6\",\"name\":\"Ubuntu 12.04.3 Base install no Gui\"},{\"id\":\"d0ae1af2-eac0-453e-bb2e-720b10a2e2d4\",\"name\":\"Ubuntu 12.04.3 LTS no gui\"},{\"id\":\"890d0d9c-f9f6-4643-bc9d-f6eb387573a1\",\"name\":\"Openfiler 2.99\"},{\"id\":\"ca446474-a846-45ab-b8b9-7bcd41e7c905\",\"name\":\"Mageia 3\"},{\"id\":\"2953ee6f-7dac-4173-9c13-19a0b87162f9\",\"name\":\"Xubuntu 13.10\"},{\"id\":\"09ff8272-3018-422f-a91f-386615ef0fb2\",\"name\":\"Windows Server 2012 Datacenter\"},{\"id\":\"f00b0d29-62f4-46db-a78e-370d596fc553\",\"name\":\"okeanos-is-on-centos\"},{\"id\":\"726090b4-00d2-4f44-bb32-83429181bee3\",\"name\":\"Mininet on Ubuntu 13.04\"},{\"id\":\"f0ebd2e4-1a27-450e-8c83-e8d350c0dc24\",\"name\":\"Mininet on Ubuntu 13.04\"},{\"id\":\"88e185c5-fd22-452a-943d-de230d4a3be9\",\"name\":\"Mininet 2.1.0 for NetMan 2014 lab\"},{\"id\":\"2da09920-20c1-4f48-ac04-e5e18029ca0c\",\"name\":\"FreeBSD 9.2-RELEASE (GENERIC)\"},{\"id\":\"749b641d-46cc-4abe-9ff2-76d745b9214d\",\"name\":\"Ubuntu 13.04\"},{\"id\":\"0099593e-4f6d-48bf-8f03-0cec7fabb05b\",\"name\":\"Master clone\"},{\"id\":\"69e7c17c-a9c9-48aa-809a-9cb5d477abda\",\"name\":\"Windows Server 2008 R2 Datacenter\"},{\"id\":\"91302edf-5d32-4048-9982-475a466ce37e\",\"name\":\"Oracle Linux Server release 6.5\"},{\"id\":\"78e96a57-2436-45c8-96b5-5eda9eb69be9\",\"name\":\"Debian 7.4 (Wheezy) Base System\"},{\"id\":\"da7a80e3-1b5a-4052-8e34-50dab2e8c9df\",\"name\":\"Debian 6.0.9 (Squeeze) Base System\"},{\"id\":\"5bffb7a0-c362-4d45-b5db-56082749ca29\",\"name\":\"Debian 7.4 (Wheezy) Desktop\"},{\"id\":\"48644f1e-4faa-45d9-9ae7-be6b0f51c063\",\"name\":\"Fedora release 20 (Heisenbug)\"},{\"id\":\"bb9cca86-1a97-4323-aa7d-bcaf792aea14\",\"name\":\"openSUSE 13.1 (x86_64)\"},{\"id\":\"cbba7cad-9945-4af3-9f5a-3a2f83067422\",\"name\":\"NetBSD 6.1.4 (GENERIC)\"},{\"id\":\"f6db8d72-1ddc-4272-889b-a51ab1d0b5a2\",\"name\":\"Ubuntu 12.04 with collection of software needed by HMMY courses\"},{\"id\":\"3ea05769-7ec3-4795-bf18-67a2cbd6a07f\",\"name\":\"user@gmail.com\"},{\"id\":\"87de7f36-a22d-4249-9fba-aff4ed95fecd\",\"name\":\"20140505\"},{\"id\":\"fc1ed744-ae05-469a-a5b9-e561428ec0e0\",\"name\":\"Ubuntu 14.04 LTS\"},{\"id\":\"2e3ca7b7-eee6-40bc-a363-14ac4b3d5231\",\"name\":\"Ubuntu 12.04.4 LTS\"},{\"id\":\"bbcb5050-11ef-4a9d-8035-7afc9cb88a69\",\"name\":\"Ubuntu 14.04 LTS with MATE\"},{\"id\":\"1890becc-f706-48b3-9dbb-9a8941f737d4\",\"name\":\"Ubuntu 12.04.4 LTS\"},{\"id\":\"cfaece0c-d886-491e-b2a1-e35e5df277b5\",\"name\":\"Kubuntu 12.04.4 LTS\"},{\"id\":\"f4f4d102-ec25-4d67-90f3-1d2754f9bdec\",\"name\":\"Kubuntu 14.04 LTS\"},{\"id\":\"2e16ea31-e7f4-48f1-87f7-b3e15cc2d701\",\"name\":\"OpenBSD 5.5 (GENERIC)\"},{\"id\":\"5a235e31-8e3c-4ea6-bb11-3e73d3fdd79e\",\"name\":\"Windows Server 2012 R2 Datacenter\"},{\"id\":\"1966f2b4-be70-4d69-874f-bb76e9aa0313\",\"name\":\"Contains all the software for AristeiaUoM\"},{\"id\":\"64a65ad6-c4ef-4052-bc19-67480815219e\",\"name\":\"Ubuntu 12.04.4 LTS\"},{\"id\":\"5042d1cb-3f0a-436c-be71-beafda1d86f3\",\"name\":\"Lubuntu 14.04 LTS\"},{\"id\":\"34da7d52-ea8b-441c-bea1-cc0a684e1cd8\",\"name\":\"ArchLinux 2014.06.21 w/ openssh and iptables setup - Accepting only PubKeyAuth\"},{\"id\":\"b5340ff7-9eb2-4fb4-aa92-d33aecfca6f8\",\"name\":\"Oracle Linux 5.10\"},{\"id\":\"430c24b4-5c75-4d38-88a9-eb95cebe27f8\",\"name\":\"7.3\"},{\"id\":\"433b0442-4314-4f6f-8893-0e29b1ca0d75\",\"name\":\"Ubuntu 14.04 LTS Mate, with preinstall software, xrdp connection and web server configured\"}]";
//
//    if ( images.equals( "" ) == false ) {
//
//      images = "{\"images\":" + images + "}";
//      String output_json = images;
//      JSONObject obj = new JSONObject( output_json );
//      JSONArray images_array = obj.getJSONArray( "images" ); //$NON-NLS-1$
//
//      if ( images_array != null ){
//        for (int i=0; i < images_array.length(); i++){
//          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
//          /*
//           * get the necessary vmi fields
//           */
//  
//          vmi.setDescription( "h" );
//          vmi.setURL( "h" );
//
//          vmi.setUID( images_array.getJSONObject( i ).getString( "name" ) );
//          vmi.setName( images_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
//          
//          vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//         
//          //add new vmi to images list
//         instance.base_images.add( vmi ); 
//        }
//      }
//    }
//  }
//
//  
//  //fetch JCatascopiaProbes
//  private void fetchMonitorProbes (final IProgressMonitor monitor) throws SQLException, JSONException {
//
//      //JCatascopia metrics
//      String probes = "{\"probes\":[{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"avgResponseTime\",\"units\":\"ms\",\"type\":\"LONG\",\"group\":\"HAProxy\"}, {\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesSent\",\"name\":\"bytesSent\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memFree\",\"name\":\"memFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:arch\",\"name\":\"arch\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memTotal\",\"name\":\"memTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuTotal\",\"name\":\"cpuTotal\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memCache\",\"name\":\"memCache\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestThroughput\",\"name\":\"requestThroughput\",\"units\":\"req/s\",\"type\":\"DOUBLE\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:maxThreads\",\"name\":\"maxThreads\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsOut\",\"name\":\"netPacketsOut\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:errorCount\",\"name\":\"errorCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesIN\",\"name\":\"netBytesIN\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskUsed\",\"name\":\"diskUsed\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Disk\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIdle\",\"name\":\"cpuIdle\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"b9ba52a9826e4c48b1976fdecdc592ab:currentSessions\",\"name\":\"currentSessions\",\"units\":\"\",\"type\":\"INTEGER\",\"group\":\"HAProxy\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuIOwait\",\"name\":\"cpuIOwait\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapFree\",\"name\":\"memSwapFree\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuUser\",\"name\":\"cpuUser\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskTotal\",\"name\":\"diskTotal\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"b9ba52a9826e4c48b1976fdecdc592ab:servers\",\"name\":\"servers\",\"units\":\"\",\"type\":\"INTEGER\",\"group\":\"HAProxy\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:iotime\",\"name\":\"iotime\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsed\",\"name\":\"memUsed\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:requestCount\",\"name\":\"requestCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadCount\",\"name\":\"currentThreadCount\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memUsedPercent\",\"name\":\"memUsedPercent\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:os\",\"name\":\"os\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netPacketsIN\",\"name\":\"netPacketsIN\",\"units\":\"packets/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuNum\",\"name\":\"cpuNum\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:cpuSystem\",\"name\":\"cpuSystem\",\"units\":\"%\",\"type\":\"DOUBLE\",\"group\":\"CPU\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:btime\",\"name\":\"btime\",\"units\":\"\",\"type\":\"STRING\",\"group\":\"StaticInfo\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:processingTime\",\"name\":\"processingTime\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:memSwapTotal\",\"name\":\"memSwapTotal\",\"units\":\"KB\",\"type\":\"INTEGER\",\"group\":\"Memory\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:readkbps\",\"name\":\"readkbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:diskFree\",\"name\":\"diskFree\",\"units\":\"MB\",\"type\":\"LONG\",\"group\":\"Disk\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:currentThreadsBusy\",\"name\":\"currentThreadsBusy\",\"units\":\"\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"286cc7eff6df400f8121f3b16a8dd884:bytesReceived\",\"name\":\"bytesReceived\",\"units\":\"Bytes\",\"type\":\"LONG\",\"group\":\"Tomcat\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:writekbps\",\"name\":\"writekbps\",\"units\":\"KB/s\",\"type\":\"DOUBLE\",\"group\":\"DiskStats\"},{\"metricID\":\"912a98a72d0f47bc8768779a182ece60:netBytesOUT\",\"name\":\"netBytesOUT\",\"units\":\"bytes/s\",\"type\":\"DOUBLE\",\"group\":\"Network\"}]}";
//      String output_json = probes;
//      JSONObject obj = new JSONObject( output_json );
//      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
//      
//      String probeGroup = null;
//      String metricName;
//      HashMap<String, String> hm = new HashMap<String, String>();
//      
//      for (int i=0; i < probes_array.length(); i++){
//        probeGroup = probes_array.getJSONObject( i ).getString( "group" );
//        metricName = probes_array.getJSONObject(i).getString( "name" );
//          
//        String value = hm.get( probeGroup );
//        
//        if (value != null)
//          metricName = value + ", \"" + metricName + "\"";
//        else
//          metricName = "\"" + metricName + "\"";
//        
//        hm.put( probeGroup, metricName );
//      }
//      
//      // Get a set of the entries
//      Set set = hm.entrySet();
//      // Get an iterator
//      Iterator i = set.iterator();
//      // Display elements
//      while(i.hasNext()) {
//         Map.Entry me = (Map.Entry)i.next();
//         String key = me.getKey().toString();
//         String value = me.getValue().toString().replace( "\"null,", "" );
//         
//         hm.put( key, value );
//         System.out.print(me.getKey() + ": ");
//         System.out.println(me.getValue());
//      }
//      
//      // Get a set of the entries
//      set = hm.entrySet();
//      // Get an iterator
//      i = set.iterator();
//      // Display elements
//      while(i.hasNext()) {
//         Map.Entry me = (Map.Entry)i.next();
//         String key = me.getKey().toString();
//         String value = me.getValue().toString();
//         
//         MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
// 
//         mp.setName( key ); //$NON-NLS-1$ );
//         mp.setDescription( "[" + value + "]" );
//
//         
//         //add new monitor probe to probes list
//         instance.monitor_probes.add( mp ); 
//      }
//      
//      MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//      
//      mp.setName( "QueueLength" ); //$NON-NLS-1$ );
//      mp.setDescription( "[ \"q1Length\" , \"q2Length\", \"q3Length\", \"q4Length\" , \"q5Length\" , \"q6Length\", \"q7Length\", \"q8Length\"]" );
//
//      
//      //add new monitor probe to probes list
//      instance.monitor_probes.add( mp ); 
//      
//      MonitoringProbe mpWR = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//      
//      mpWR.setName( "WorkRate" ); //$NON-NLS-1$ );
//      mpWR.setDescription( "[ \"w1Rate\" , \"w2Rate\", \"w3Rate\", \"w4Rate\" , \"w5Rate\" , \"w6Rate\", \"w7Rate\", \"w8Rate\"]" );
//
//      
//      //add new monitor probe to probes list
//      instance.monitor_probes.add( mpWR ); 
//
//
//   
//  }
//  
//  
//  private void fetchFlavors (final IProgressMonitor monitor) throws SQLException, JSONException {
//    
//    
//    //CELAR Manager call : Get VM Images
//    String celarManagerURL = "http://83.212.107.38:8080/resources/";
//    URL url = null;
//    HttpURLConnection connection = null;
//    BufferedReader in = null;
//    String inputLine = null;
//    
//    String flavors = "";
//    try {
//      url = new URL (celarManagerURL + "flavors/");
//  
//      connection = (HttpURLConnection) url.openConnection();
//      connection.setDoInput( true );
//      connection.setRequestProperty("Accept", "application/json");
//      connection.setRequestMethod( "GET" );
//              
//      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//      while ((inputLine = in.readLine()) != null) {
//        flavors = flavors + inputLine;
//      }
//      in.close();
//      System.out.println(flavors);
//      
//      connection.disconnect();
//    } catch( MalformedURLException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch( IOException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    
//    //Okeanos Flavors
//    flavors = "[{\"id\":\"1\",\"name\":\"C1R1024D20drbd\"},{\"id\":\"3\",\"name\":\"C1R1024D40drbd\"},{\"id\":\"4\",\"name\":\"C1R2048D20drbd\"},{\"id\":\"6\",\"name\":\"C1R2048D40drbd\"},{\"id\":\"7\",\"name\":\"C1R4096D20drbd\"},{\"id\":\"9\",\"name\":\"C1R4096D40drbd\"},{\"id\":\"10\",\"name\":\"C2R1024D20drbd\"},{\"id\":\"12\",\"name\":\"C2R1024D40drbd\"},{\"id\":\"13\",\"name\":\"C2R2048D20drbd\"},{\"id\":\"15\",\"name\":\"C2R2048D40drbd\"},{\"id\":\"16\",\"name\":\"C2R4096D20drbd\"},{\"id\":\"18\",\"name\":\"C2R4096D40drbd\"},{\"id\":\"19\",\"name\":\"C4R1024D20drbd\"},{\"id\":\"21\",\"name\":\"C4R1024D40drbd\"},{\"id\":\"22\",\"name\":\"C4R2048D20drbd\"},{\"id\":\"24\",\"name\":\"C4R2048D40drbd\"},{\"id\":\"25\",\"name\":\"C4R4096D20drbd\"},{\"id\":\"27\",\"name\":\"C4R4096D40drbd\"},{\"id\":\"28\",\"name\":\"C1R1024D5drbd\"},{\"id\":\"29\",\"name\":\"C1R1024D10drbd\"},{\"id\":\"30\",\"name\":\"C1R2048D5drbd\"},{\"id\":\"31\",\"name\":\"C1R2048D10drbd\"},{\"id\":\"32\",\"name\":\"C1R4096D5drbd\"},{\"id\":\"33\",\"name\":\"C1R4096D10drbd\"},{\"id\":\"34\",\"name\":\"C2R1024D5drbd\"},{\"id\":\"35\",\"name\":\"C2R1024D10drbd\"},{\"id\":\"36\",\"name\":\"C2R2048D5drbd\"},{\"id\":\"37\",\"name\":\"C2R2048D10drbd\"},{\"id\":\"38\",\"name\":\"C2R4096D5drbd\"},{\"id\":\"39\",\"name\":\"C2R4096D10drbd\"},{\"id\":\"40\",\"name\":\"C4R1024D5drbd\"},{\"id\":\"41\",\"name\":\"C4R1024D10drbd\"},{\"id\":\"42\",\"name\":\"C4R2048D5drbd\"},{\"id\":\"43\",\"name\":\"C4R2048D10drbd\"},{\"id\":\"44\",\"name\":\"C4R4096D5drbd\"},{\"id\":\"45\",\"name\":\"C4R4096D10drbd\"},{\"id\":\"46\",\"name\":\"C1R512D5drbd\"},{\"id\":\"47\",\"name\":\"C1R512D10drbd\"},{\"id\":\"48\",\"name\":\"C1R512D20drbd\"},{\"id\":\"49\",\"name\":\"C1R512D40drbd\"},{\"id\":\"50\",\"name\":\"C1R512D60drbd\"},{\"id\":\"51\",\"name\":\"C1R512D80drbd\"},{\"id\":\"52\",\"name\":\"C1R512D100drbd\"},{\"id\":\"53\",\"name\":\"C1R1024D60drbd\"},{\"id\":\"54\",\"name\":\"C1R1024D80drbd\"},{\"id\":\"55\",\"name\":\"C1R1024D100drbd\"},{\"id\":\"56\",\"name\":\"C1R2048D60drbd\"},{\"id\":\"57\",\"name\":\"C1R2048D80drbd\"},{\"id\":\"58\",\"name\":\"C1R2048D100drbd\"},{\"id\":\"59\",\"name\":\"C1R4096D60drbd\"},{\"id\":\"60\",\"name\":\"C1R4096D80drbd\"},{\"id\":\"61\",\"name\":\"C1R4096D100drbd\"},{\"id\":\"62\",\"name\":\"C1R8192D5drbd\"},{\"id\":\"63\",\"name\":\"C1R8192D10drbd\"},{\"id\":\"64\",\"name\":\"C1R8192D20drbd\"},{\"id\":\"65\",\"name\":\"C1R8192D40drbd\"},{\"id\":\"66\",\"name\":\"C1R8192D60drbd\"},{\"id\":\"67\",\"name\":\"C1R8192D80drbd\"},{\"id\":\"68\",\"name\":\"C1R8192D100drbd\"},{\"id\":\"69\",\"name\":\"C2R512D5drbd\"},{\"id\":\"70\",\"name\":\"C2R512D10drbd\"},{\"id\":\"71\",\"name\":\"C2R512D20drbd\"},{\"id\":\"72\",\"name\":\"C2R512D40drbd\"},{\"id\":\"73\",\"name\":\"C2R512D60drbd\"},{\"id\":\"74\",\"name\":\"C2R512D80drbd\"},{\"id\":\"75\",\"name\":\"C2R512D100drbd\"},{\"id\":\"76\",\"name\":\"C2R1024D60drbd\"},{\"id\":\"77\",\"name\":\"C2R1024D80drbd\"},{\"id\":\"78\",\"name\":\"C2R1024D100drbd\"},{\"id\":\"79\",\"name\":\"C2R2048D60drbd\"},{\"id\":\"80\",\"name\":\"C2R2048D80drbd\"},{\"id\":\"81\",\"name\":\"C2R2048D100drbd\"},{\"id\":\"82\",\"name\":\"C2R4096D60drbd\"},{\"id\":\"83\",\"name\":\"C2R4096D80drbd\"},{\"id\":\"84\",\"name\":\"C2R4096D100drbd\"},{\"id\":\"85\",\"name\":\"C2R8192D5drbd\"},{\"id\":\"86\",\"name\":\"C2R8192D10drbd\"},{\"id\":\"87\",\"name\":\"C2R8192D20drbd\"},{\"id\":\"88\",\"name\":\"C2R8192D40drbd\"},{\"id\":\"89\",\"name\":\"C2R8192D60drbd\"},{\"id\":\"90\",\"name\":\"C2R8192D80drbd\"},{\"id\":\"91\",\"name\":\"C2R8192D100drbd\"},{\"id\":\"92\",\"name\":\"C4R512D5drbd\"},{\"id\":\"93\",\"name\":\"C4R512D10drbd\"},{\"id\":\"94\",\"name\":\"C4R512D20drbd\"},{\"id\":\"95\",\"name\":\"C4R512D40drbd\"},{\"id\":\"96\",\"name\":\"C4R512D60drbd\"},{\"id\":\"97\",\"name\":\"C4R512D80drbd\"},{\"id\":\"98\",\"name\":\"C4R512D100drbd\"},{\"id\":\"99\",\"name\":\"C4R1024D60drbd\"},{\"id\":\"100\",\"name\":\"C4R1024D80drbd\"},{\"id\":\"101\",\"name\":\"C4R1024D100drbd\"},{\"id\":\"102\",\"name\":\"C4R2048D60drbd\"},{\"id\":\"103\",\"name\":\"C4R2048D80drbd\"},{\"id\":\"104\",\"name\":\"C4R2048D100drbd\"},{\"id\":\"105\",\"name\":\"C4R4096D60drbd\"},{\"id\":\"106\",\"name\":\"C4R4096D80drbd\"},{\"id\":\"107\",\"name\":\"C4R4096D100drbd\"},{\"id\":\"108\",\"name\":\"C4R8192D5drbd\"},{\"id\":\"109\",\"name\":\"C4R8192D10drbd\"},{\"id\":\"110\",\"name\":\"C4R8192D20drbd\"},{\"id\":\"111\",\"name\":\"C4R8192D40drbd\"},{\"id\":\"112\",\"name\":\"C4R8192D60drbd\"},{\"id\":\"113\",\"name\":\"C4R8192D80drbd\"},{\"id\":\"114\",\"name\":\"C4R8192D100drbd\"},{\"id\":\"115\",\"name\":\"C8R512D5drbd\"},{\"id\":\"116\",\"name\":\"C8R512D10drbd\"},{\"id\":\"117\",\"name\":\"C8R512D20drbd\"},{\"id\":\"118\",\"name\":\"C8R512D40drbd\"},{\"id\":\"119\",\"name\":\"C8R512D60drbd\"},{\"id\":\"120\",\"name\":\"C8R512D80drbd\"},{\"id\":\"121\",\"name\":\"C8R512D100drbd\"},{\"id\":\"122\",\"name\":\"C8R1024D5drbd\"},{\"id\":\"123\",\"name\":\"C8R1024D10drbd\"},{\"id\":\"124\",\"name\":\"C8R1024D20drbd\"},{\"id\":\"125\",\"name\":\"C8R1024D40drbd\"},{\"id\":\"126\",\"name\":\"C8R1024D60drbd\"},{\"id\":\"127\",\"name\":\"C8R1024D80drbd\"},{\"id\":\"128\",\"name\":\"C8R1024D100drbd\"},{\"id\":\"129\",\"name\":\"C8R2048D5drbd\"},{\"id\":\"130\",\"name\":\"C8R2048D10drbd\"},{\"id\":\"131\",\"name\":\"C8R2048D20drbd\"},{\"id\":\"132\",\"name\":\"C8R2048D40drbd\"},{\"id\":\"133\",\"name\":\"C8R2048D60drbd\"},{\"id\":\"134\",\"name\":\"C8R2048D80drbd\"},{\"id\":\"135\",\"name\":\"C8R2048D100drbd\"},{\"id\":\"136\",\"name\":\"C8R4096D5drbd\"},{\"id\":\"137\",\"name\":\"C8R4096D10drbd\"},{\"id\":\"138\",\"name\":\"C8R4096D20drbd\"},{\"id\":\"139\",\"name\":\"C8R4096D40drbd\"},{\"id\":\"140\",\"name\":\"C8R4096D60drbd\"},{\"id\":\"141\",\"name\":\"C8R4096D80drbd\"},{\"id\":\"142\",\"name\":\"C8R4096D100drbd\"},{\"id\":\"143\",\"name\":\"C8R8192D5drbd\"},{\"id\":\"144\",\"name\":\"C8R8192D10drbd\"},{\"id\":\"145\",\"name\":\"C8R8192D20drbd\"},{\"id\":\"146\",\"name\":\"C8R8192D40drbd\"},{\"id\":\"147\",\"name\":\"C8R8192D60drbd\"},{\"id\":\"148\",\"name\":\"C8R8192D80drbd\"},{\"id\":\"149\",\"name\":\"C8R8192D100drbd\"},{\"id\":\"150\",\"name\":\"C1R512D5ext_vlmc\"},{\"id\":\"151\",\"name\":\"C1R512D10ext_vlmc\"},{\"id\":\"152\",\"name\":\"C1R512D20ext_vlmc\"},{\"id\":\"153\",\"name\":\"C1R512D40ext_vlmc\"},{\"id\":\"154\",\"name\":\"C1R512D60ext_vlmc\"},{\"id\":\"155\",\"name\":\"C1R512D80ext_vlmc\"},{\"id\":\"156\",\"name\":\"C1R512D100ext_vlmc\"},{\"id\":\"157\",\"name\":\"C1R1024D5ext_vlmc\"},{\"id\":\"158\",\"name\":\"C1R1024D10ext_vlmc\"},{\"id\":\"159\",\"name\":\"C1R1024D20ext_vlmc\"},{\"id\":\"160\",\"name\":\"C1R1024D40ext_vlmc\"},{\"id\":\"161\",\"name\":\"C1R1024D60ext_vlmc\"},{\"id\":\"162\",\"name\":\"C1R1024D80ext_vlmc\"},{\"id\":\"163\",\"name\":\"C1R1024D100ext_vlmc\"},{\"id\":\"164\",\"name\":\"C1R2048D5ext_vlmc\"},{\"id\":\"165\",\"name\":\"C1R2048D10ext_vlmc\"},{\"id\":\"166\",\"name\":\"C1R2048D20ext_vlmc\"},{\"id\":\"167\",\"name\":\"C1R2048D40ext_vlmc\"},{\"id\":\"168\",\"name\":\"C1R2048D60ext_vlmc\"},{\"id\":\"169\",\"name\":\"C1R2048D80ext_vlmc\"},{\"id\":\"170\",\"name\":\"C1R2048D100ext_vlmc\"},{\"id\":\"171\",\"name\":\"C1R4096D5ext_vlmc\"},{\"id\":\"172\",\"name\":\"C1R4096D10ext_vlmc\"},{\"id\":\"173\",\"name\":\"C1R4096D20ext_vlmc\"},{\"id\":\"174\",\"name\":\"C1R4096D40ext_vlmc\"},{\"id\":\"175\",\"name\":\"C1R4096D60ext_vlmc\"},{\"id\":\"176\",\"name\":\"C1R4096D80ext_vlmc\"},{\"id\":\"177\",\"name\":\"C1R4096D100ext_vlmc\"},{\"id\":\"178\",\"name\":\"C1R8192D5ext_vlmc\"},{\"id\":\"179\",\"name\":\"C1R8192D10ext_vlmc\"},{\"id\":\"180\",\"name\":\"C1R8192D20ext_vlmc\"},{\"id\":\"181\",\"name\":\"C1R8192D40ext_vlmc\"},{\"id\":\"182\",\"name\":\"C1R8192D60ext_vlmc\"},{\"id\":\"183\",\"name\":\"C1R8192D80ext_vlmc\"},{\"id\":\"184\",\"name\":\"C1R8192D100ext_vlmc\"},{\"id\":\"185\",\"name\":\"C2R512D5ext_vlmc\"},{\"id\":\"186\",\"name\":\"C2R512D10ext_vlmc\"},{\"id\":\"187\",\"name\":\"C2R512D20ext_vlmc\"},{\"id\":\"188\",\"name\":\"C2R512D40ext_vlmc\"},{\"id\":\"189\",\"name\":\"C2R512D60ext_vlmc\"},{\"id\":\"190\",\"name\":\"C2R512D80ext_vlmc\"},{\"id\":\"191\",\"name\":\"C2R512D100ext_vlmc\"},{\"id\":\"192\",\"name\":\"C2R1024D5ext_vlmc\"},{\"id\":\"193\",\"name\":\"C2R1024D10ext_vlmc\"},{\"id\":\"194\",\"name\":\"C2R1024D20ext_vlmc\"},{\"id\":\"195\",\"name\":\"C2R1024D40ext_vlmc\"},{\"id\":\"196\",\"name\":\"C2R1024D60ext_vlmc\"},{\"id\":\"197\",\"name\":\"C2R1024D80ext_vlmc\"},{\"id\":\"198\",\"name\":\"C2R1024D100ext_vlmc\"},{\"id\":\"199\",\"name\":\"C2R2048D5ext_vlmc\"},{\"id\":\"200\",\"name\":\"C2R2048D10ext_vlmc\"},{\"id\":\"201\",\"name\":\"C2R2048D20ext_vlmc\"},{\"id\":\"202\",\"name\":\"C2R2048D40ext_vlmc\"},{\"id\":\"203\",\"name\":\"C2R2048D60ext_vlmc\"},{\"id\":\"204\",\"name\":\"C2R2048D80ext_vlmc\"},{\"id\":\"205\",\"name\":\"C2R2048D100ext_vlmc\"},{\"id\":\"206\",\"name\":\"C2R4096D5ext_vlmc\"},{\"id\":\"207\",\"name\":\"C2R4096D10ext_vlmc\"},{\"id\":\"208\",\"name\":\"C2R4096D20ext_vlmc\"},{\"id\":\"209\",\"name\":\"C2R4096D40ext_vlmc\"},{\"id\":\"210\",\"name\":\"C2R4096D60ext_vlmc\"},{\"id\":\"211\",\"name\":\"C2R4096D80ext_vlmc\"},{\"id\":\"212\",\"name\":\"C2R4096D100ext_vlmc\"},{\"id\":\"213\",\"name\":\"C2R8192D5ext_vlmc\"},{\"id\":\"214\",\"name\":\"C2R8192D10ext_vlmc\"},{\"id\":\"215\",\"name\":\"C2R8192D20ext_vlmc\"},{\"id\":\"216\",\"name\":\"C2R8192D40ext_vlmc\"},{\"id\":\"217\",\"name\":\"C2R8192D60ext_vlmc\"},{\"id\":\"218\",\"name\":\"C2R8192D80ext_vlmc\"},{\"id\":\"219\",\"name\":\"C2R8192D100ext_vlmc\"},{\"id\":\"220\",\"name\":\"C4R512D5ext_vlmc\"},{\"id\":\"221\",\"name\":\"C4R512D10ext_vlmc\"},{\"id\":\"222\",\"name\":\"C4R512D20ext_vlmc\"},{\"id\":\"223\",\"name\":\"C4R512D40ext_vlmc\"},{\"id\":\"224\",\"name\":\"C4R512D60ext_vlmc\"},{\"id\":\"225\",\"name\":\"C4R512D80ext_vlmc\"},{\"id\":\"226\",\"name\":\"C4R512D100ext_vlmc\"},{\"id\":\"227\",\"name\":\"C4R1024D5ext_vlmc\"},{\"id\":\"228\",\"name\":\"C4R1024D10ext_vlmc\"},{\"id\":\"229\",\"name\":\"C4R1024D20ext_vlmc\"},{\"id\":\"230\",\"name\":\"C4R1024D40ext_vlmc\"},{\"id\":\"231\",\"name\":\"C4R1024D60ext_vlmc\"},{\"id\":\"232\",\"name\":\"C4R1024D80ext_vlmc\"},{\"id\":\"233\",\"name\":\"C4R1024D100ext_vlmc\"},{\"id\":\"234\",\"name\":\"C4R2048D5ext_vlmc\"},{\"id\":\"235\",\"name\":\"C4R2048D10ext_vlmc\"},{\"id\":\"236\",\"name\":\"C4R2048D20ext_vlmc\"},{\"id\":\"237\",\"name\":\"C4R2048D40ext_vlmc\"},{\"id\":\"238\",\"name\":\"C4R2048D60ext_vlmc\"},{\"id\":\"239\",\"name\":\"C4R2048D80ext_vlmc\"},{\"id\":\"240\",\"name\":\"C4R2048D100ext_vlmc\"},{\"id\":\"241\",\"name\":\"C4R4096D5ext_vlmc\"},{\"id\":\"242\",\"name\":\"C4R4096D10ext_vlmc\"},{\"id\":\"243\",\"name\":\"C4R4096D20ext_vlmc\"},{\"id\":\"244\",\"name\":\"C4R4096D40ext_vlmc\"},{\"id\":\"245\",\"name\":\"C4R4096D60ext_vlmc\"},{\"id\":\"246\",\"name\":\"C4R4096D80ext_vlmc\"},{\"id\":\"247\",\"name\":\"C4R4096D100ext_vlmc\"},{\"id\":\"248\",\"name\":\"C4R8192D5ext_vlmc\"},{\"id\":\"249\",\"name\":\"C4R8192D10ext_vlmc\"},{\"id\":\"250\",\"name\":\"C4R8192D20ext_vlmc\"},{\"id\":\"251\",\"name\":\"C4R8192D40ext_vlmc\"},{\"id\":\"252\",\"name\":\"C4R8192D60ext_vlmc\"},{\"id\":\"253\",\"name\":\"C4R8192D80ext_vlmc\"},{\"id\":\"254\",\"name\":\"C4R8192D100ext_vlmc\"},{\"id\":\"255\",\"name\":\"C8R512D5ext_vlmc\"},{\"id\":\"256\",\"name\":\"C8R512D10ext_vlmc\"},{\"id\":\"257\",\"name\":\"C8R512D20ext_vlmc\"},{\"id\":\"258\",\"name\":\"C8R512D40ext_vlmc\"},{\"id\":\"259\",\"name\":\"C8R512D60ext_vlmc\"},{\"id\":\"260\",\"name\":\"C8R512D80ext_vlmc\"},{\"id\":\"261\",\"name\":\"C8R512D100ext_vlmc\"},{\"id\":\"262\",\"name\":\"C8R1024D5ext_vlmc\"},{\"id\":\"263\",\"name\":\"C8R1024D10ext_vlmc\"},{\"id\":\"264\",\"name\":\"C8R1024D20ext_vlmc\"},{\"id\":\"265\",\"name\":\"C8R1024D40ext_vlmc\"},{\"id\":\"266\",\"name\":\"C8R1024D60ext_vlmc\"},{\"id\":\"267\",\"name\":\"C8R1024D80ext_vlmc\"},{\"id\":\"268\",\"name\":\"C8R1024D100ext_vlmc\"},{\"id\":\"269\",\"name\":\"C8R2048D5ext_vlmc\"},{\"id\":\"270\",\"name\":\"C8R2048D10ext_vlmc\"},{\"id\":\"271\",\"name\":\"C8R2048D20ext_vlmc\"},{\"id\":\"272\",\"name\":\"C8R2048D40ext_vlmc\"},{\"id\":\"273\",\"name\":\"C8R2048D60ext_vlmc\"},{\"id\":\"274\",\"name\":\"C8R2048D80ext_vlmc\"},{\"id\":\"275\",\"name\":\"C8R2048D100ext_vlmc\"},{\"id\":\"276\",\"name\":\"C8R4096D5ext_vlmc\"},{\"id\":\"277\",\"name\":\"C8R4096D10ext_vlmc\"},{\"id\":\"278\",\"name\":\"C8R4096D20ext_vlmc\"},{\"id\":\"279\",\"name\":\"C8R4096D40ext_vlmc\"},{\"id\":\"280\",\"name\":\"C8R4096D60ext_vlmc\"},{\"id\":\"281\",\"name\":\"C8R4096D80ext_vlmc\"},{\"id\":\"282\",\"name\":\"C8R4096D100ext_vlmc\"},{\"id\":\"283\",\"name\":\"C8R8192D5ext_vlmc\"},{\"id\":\"284\",\"name\":\"C8R8192D10ext_vlmc\"},{\"id\":\"285\",\"name\":\"C8R8192D20ext_vlmc\"},{\"id\":\"286\",\"name\":\"C8R8192D40ext_vlmc\"},{\"id\":\"287\",\"name\":\"C8R8192D60ext_vlmc\"},{\"id\":\"288\",\"name\":\"C8R8192D80ext_vlmc\"},{\"id\":\"289\",\"name\":\"C8R8192D100ext_vlmc\"},{\"id\":\"290\",\"name\":\"C1R6144D100drbd\"},{\"id\":\"291\",\"name\":\"C1R6144D100ext_vlmc\"},{\"id\":\"292\",\"name\":\"C2R6144D100ext_vlmc\"},{\"id\":\"293\",\"name\":\"C2R6144D100drbd\"},{\"id\":\"294\",\"name\":\"C2R6144D80drbd\"},{\"id\":\"295\",\"name\":\"C2R6144D60drbd\"},{\"id\":\"296\",\"name\":\"C2R6144D40drbd\"},{\"id\":\"297\",\"name\":\"C2R6144D40ext_vlmc\"},{\"id\":\"298\",\"name\":\"C2R6144D60ext_vlmc\"},{\"id\":\"299\",\"name\":\"C2R6144D80ext_vlmc\"},{\"id\":\"300\",\"name\":\"C1R6144D5ext_vlmc\"},{\"id\":\"301\",\"name\":\"C1R6144D10ext_vlmc\"},{\"id\":\"302\",\"name\":\"C1R6144D20ext_vlmc\"},{\"id\":\"303\",\"name\":\"C1R6144D40ext_vlmc\"},{\"id\":\"304\",\"name\":\"C1R6144D60ext_vlmc\"},{\"id\":\"305\",\"name\":\"C1R6144D80ext_vlmc\"},{\"id\":\"306\",\"name\":\"C1R6144D5drbd\"},{\"id\":\"307\",\"name\":\"C1R6144D10drbd\"},{\"id\":\"308\",\"name\":\"C1R6144D20drbd\"},{\"id\":\"309\",\"name\":\"C1R6144D40drbd\"},{\"id\":\"310\",\"name\":\"C1R6144D60drbd\"},{\"id\":\"311\",\"name\":\"C1R6144D80drbd\"},{\"id\":\"312\",\"name\":\"C2R6144D5ext_vlmc\"},{\"id\":\"313\",\"name\":\"C2R6144D10ext_vlmc\"},{\"id\":\"314\",\"name\":\"C2R6144D20ext_vlmc\"},{\"id\":\"315\",\"name\":\"C2R6144D5drbd\"},{\"id\":\"316\",\"name\":\"C2R6144D10drbd\"},{\"id\":\"317\",\"name\":\"C2R6144D20drbd\"},{\"id\":\"318\",\"name\":\"C4R6144D5ext_vlmc\"},{\"id\":\"319\",\"name\":\"C4R6144D10ext_vlmc\"},{\"id\":\"320\",\"name\":\"C4R6144D20ext_vlmc\"},{\"id\":\"321\",\"name\":\"C4R6144D40ext_vlmc\"},{\"id\":\"322\",\"name\":\"C4R6144D60ext_vlmc\"},{\"id\":\"323\",\"name\":\"C4R6144D80ext_vlmc\"},{\"id\":\"324\",\"name\":\"C4R6144D100ext_vlmc\"},{\"id\":\"325\",\"name\":\"C4R6144D5drbd\"},{\"id\":\"326\",\"name\":\"C4R6144D10drbd\"},{\"id\":\"327\",\"name\":\"C4R6144D20drbd\"},{\"id\":\"328\",\"name\":\"C4R6144D40drbd\"},{\"id\":\"329\",\"name\":\"C4R6144D60drbd\"},{\"id\":\"330\",\"name\":\"C4R6144D80drbd\"},{\"id\":\"331\",\"name\":\"C4R6144D100drbd\"},{\"id\":\"332\",\"name\":\"C8R6144D5ext_vlmc\"},{\"id\":\"333\",\"name\":\"C8R6144D10ext_vlmc\"},{\"id\":\"334\",\"name\":\"C8R6144D20ext_vlmc\"},{\"id\":\"335\",\"name\":\"C8R6144D40ext_vlmc\"},{\"id\":\"336\",\"name\":\"C8R6144D60ext_vlmc\"},{\"id\":\"337\",\"name\":\"C8R6144D80ext_vlmc\"},{\"id\":\"338\",\"name\":\"C8R6144D100ext_vlmc\"},{\"id\":\"339\",\"name\":\"C8R6144D5drbd\"},{\"id\":\"340\",\"name\":\"C8R6144D10drbd\"},{\"id\":\"341\",\"name\":\"C8R6144D20drbd\"},{\"id\":\"342\",\"name\":\"C8R6144D40drbd\"},{\"id\":\"343\",\"name\":\"C8R6144D60drbd\"},{\"id\":\"344\",\"name\":\"C8R6144D80drbd\"},{\"id\":\"345\",\"name\":\"C8R6144D100drbd\"},{\"id\":\"fa34e0a0-b474-464b-a563-9aea1bc3e9b5\",\"name\":\"CELAR_Jenkins_snapshot_111213\"},{\"id\":\"8258fe3d-3b6d-49c7-88aa-bc28cc44d609\",\"name\":\"CELAR_Nexus_snapshot_111213\"},{\"id\":\"df6dcbbf-4fe2-4550-8bfd-f65b57dc45eb\",\"name\":\"CentOS\"},{\"id\":\"8258fe3d-3b6d-49c7-88aa-bc28cc44d609\",\"name\":\"CELAR_Nexus_snapshot_111213\"},{\"id\":\"df6dcbbf-4fe2-4550-8bfd-f65b57dc45eb\",\"name\":\"CentOS\"},{\"id\":\"fa34e0a0-b474-464b-a563-9aea1bc3e9b5\",\"name\":\"CELAR_Jenkins_snapshot_111213\"}]";
//
//    if ( flavors.equals( "" ) == false ) {
//
//      flavors = "{\"flavors\":" + flavors + "}";
//      String output_json = flavors;
//      JSONObject obj = new JSONObject( output_json );
//      JSONArray images_array = obj.getJSONArray( "flavors" ); //$NON-NLS-1$
//
//      if ( images_array != null ){
//        for (int i=0; i < images_array.length(); i++){
//          VirtualMachineImageFlavor vmif = InfoSystemFactory.eINSTANCE.createVirtualMachineImageFlavor();
//          /*
//           * get the necessary vmif fields
//           */
// 
//          vmif.setUID( images_array.getJSONObject( i ).getString( "id" ) );
//          vmif.setName( images_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
//         System.out.println(vmif.getName()+" "+vmif.getUID());
//          //add new vmi to images list
//         instance.vm_flavors.add( vmif ); 
//        }
//      }
//    }
//  }
//  
//  
//  
//  
//  
//  
//  //fetch probes from CELAR DB
////  private void fetchMonitorProbes (final IProgressMonitor monitor) throws SQLException, JSONException {
////    
////    //CELAR Manager call : Get Monitoring Probes
////    String celarManagerURL = "http://83.212.107.38:8080/resources/";
////    URL url = null;
////    HttpURLConnection connection = null;
////    BufferedReader in = null;
////    String inputLine = null;
////    
////    String probes = "";
////    try {
////      url = new URL (celarManagerURL + "probes/");
////  
////      connection = (HttpURLConnection) url.openConnection();
////      connection.setDoInput( true );
////      connection.setRequestProperty("Accept", "application/json");
////      connection.setRequestMethod( "GET" );
////              
////      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////      while ((inputLine = in.readLine()) != null) {
////        probes = probes + inputLine;
////      }
////      
////      probes = probes.substring( 0, probes.length()-1 );
////      probes = probes + ",{\"name\":\"Queue Length probe\",\"metrics\":[\"Q1 length\",\"Q2 length\",\"Q3 length\", \"Q4 length\",\"Q5 length\",\"Q6 length\",\"Q7 length\", \"Q8 length\" ]}]" ;
////      
////      in.close();
////      System.out.println(probes);
////      
////      connection.disconnect();
////    } catch( MalformedURLException e ) {
////      // TODO Auto-generated catch block
////      e.printStackTrace();
////    } catch( IOException e ) {
////      // TODO Auto-generated catch block
////      e.printStackTrace();
////    }
////    if ( probes.equals( "" ) == false ) {
////      
////      probes = "{\"probes\":" + probes + "}";
////      String output_json = probes;
////      JSONObject obj = new JSONObject( output_json );
////      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
////      
////      if ( probes_array != null ){
////        for (int i=0; i < probes_array.length(); i++){
////          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
////          /*
////           * get the necessary mp fields
////           */
////          mp.setName( probes_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
////          mp.setDescription( probes_array.getJSONObject( i ).getString( "metrics" ) );
////          
////          System.out.println(mp.getName());
////          System.out.println(mp.getDescription());
////          
////          //add new monitor probe to probes list
////          instance.monitor_probes.add( mp ); 
////        }
////        
////      }
////    }    
////  }
////  
//  private void fetchResizingActions (final IProgressMonitor monitor) throws SQLException, JSONException {
//    
//    //CELAR Manager call : Get Resizing Actions
//    String celarManagerURL = "http://83.212.107.38:8080/resources/";
//    URL url = null;
//    HttpURLConnection connection = null;
//    BufferedReader in = null;
//    String inputLine = null;
//    
//    String actions = "";
//    try {
//      url = new URL (celarManagerURL + "actions/");
//  
//      connection = (HttpURLConnection) url.openConnection();
//      connection.setDoInput( true );
//      connection.setRequestProperty("Accept", "application/json");
//      connection.setRequestMethod( "GET" );
//              
//      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//      while ((inputLine = in.readLine()) != null) {
//        actions = actions + inputLine;
//      }
//      in.close();
//      System.out.println(actions);
//      
//      connection.disconnect();
//    } catch( MalformedURLException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch( IOException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    if ( actions.equals( "" ) == false ) {
//      
//      actions = "{\"actions\":" + actions + "}";
//      String output_json = actions;
//      JSONObject obj = new JSONObject( output_json );
//      JSONArray actions_array = obj.getJSONArray( "actions" ); //$NON-NLS-1$
//     
//      if ( actions_array != null ){
//        for (int i=0; i < actions_array.length(); i++){
//          ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
//          /*
//           * get the necessary ra fields
//           */
//          ra.setName( actions_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
//         
//          //add new ra to resizing_actions list
//          instance.resize_actions.add( ra ); 
//        }
//      }
//    }
//  }
//  
////  private void fetchFlavors (final IProgressMonitor monitor) throws SQLException, JSONException {
////    
////    //CELAR Manager call : Get Flavors
////    String celarManagerURL = "http://83.212.107.38:8080/resources/";
////    URL url = null;
////    HttpURLConnection connection = null;
////    BufferedReader in = null;
////    String inputLine = null;
////    
////    String flavors = "";
////    try {
////      url = new URL (celarManagerURL + "flavors/");
////  
////      connection = (HttpURLConnection) url.openConnection();
////      connection.setDoInput( true );
////      connection.setRequestProperty("Accept", "application/json");
////      connection.setRequestMethod( "GET" );
////              
////      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////      while ((inputLine = in.readLine()) != null) {
////        flavors = flavors + inputLine;
////      }
////      in.close();
////      System.out.println("Flavors: " + flavors);
////      
////      connection.disconnect();
////    } catch( MalformedURLException e ) {
////      // TODO Auto-generated catch block
////      e.printStackTrace();
////    } catch( IOException e ) {
////      // TODO Auto-generated catch block
////      e.printStackTrace();
////    }
////    if ( flavors.equals( "" ) == false ) {
////      
////      flavors = "{\"flavors\":" + flavors + "}";
////      String output_json = flavors;
////      JSONObject obj = new JSONObject( output_json );
////      JSONArray flavors_array = obj.getJSONArray( "flavors" ); //$NON-NLS-1$
////     
//////      if ( flavors_array != null ){
//////        for (int i=0; i < flavors_array.length(); i++){
//////          VirtualMachineImageType vmf = InfoSystemFactory.eINSTANCE.createVirtualMachineImageType();
//////          /*
//////           * get the necessary ra fields
//////           */
//////          vmf.setName( flavors_array.getJSONObject( i ).getString( "name" )); //$NON-NLS-1$ );
//////         
//////          //add new ra to resizing_actions list
//////          instance.vm_flavors.add( vmf ); 
//////        }
//////      }
////    }
////  }
//  /**
//   * @return A list with the available Base Machine Images
//   */
//  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
//    return instance.base_images;
//  }
//    
//  /**
//   * @return A list with available Monitoring Probes
//   */
//  public ArrayList<MonitoringProbe> getMonitoringProbes () {
//    return instance.monitor_probes;
//  }
//  
//  /**
//   * @return A list with available Resizing Actions
//   */
//  public ArrayList<ResizingAction> getResizingActions () {
//    return instance.resize_actions;
//  }
//  
//
//  
//  private MessageConsole findConsole(String name) {
//    ConsolePlugin plugin = ConsolePlugin.getDefault();
//    IConsoleManager conMan = plugin.getConsoleManager();
//    IConsole[] existing = conMan.getConsoles();
//    for (int i = 0; i < existing.length; i++)
//       if (name.equals(existing[i].getName()))
//          return (MessageConsole) existing[i];
//    //no console found, so create a new one
//    MessageConsole myConsole = new MessageConsole(name, null);
//    conMan.addConsoles(new IConsole[]{myConsole});
//    return myConsole;
// }
//   
// private void createStaticCelarDB() {
//   VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
//   vmi.setUID( "1" );
//   vmi.setName( "Ubuntu-12.04.3-64bit" );
//   vmi.setDescription( "h" );
//   vmi.setURL( "h" );
//   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//   instance.base_images.add( vmi ); 
//  
//   vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();      
//   vmi.setUID( "1" );
//   vmi.setName( "Ubuntu-12.04-32bit" );
//   vmi.setDescription( "h" );
//   vmi.setURL( "h" );
//   vmi.setType( VirtualMachineImageType.BASE_IMAGE );
//   instance.base_images.add( vmi ); 
//   
//   MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//   mp.setUID( "" );
//   mp.setName( "CPU Usage" );
//   mp.setDescription( "" );        
//   instance.monitor_probes.add( mp ); 
//   
//   mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
//   mp.setUID( "" );
//   mp.setName( "Memory Usage" );
//   mp.setDescription( "" );        
//   instance.monitor_probes.add( mp ); 
//   
//   ResizingAction ra = InfoSystemFactory.eINSTANCE.createResizingAction();
//   ra.setUID( "" );
//   ra.setName( "Add VM" );
//   ra.setDescription( "" );        
//   instance.resize_actions.add( ra ); 
//   
//   ra = InfoSystemFactory.eINSTANCE.createResizingAction();
//   ra.setUID( "" );
//   ra.setName( "Remove VM" );
//   ra.setDescription( "" );        
//   instance.resize_actions.add( ra ); 
// }
//}
