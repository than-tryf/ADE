/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *  Andreas Kastanas - added getDeploymentsStatus & setDeploymentStatus
 *******************************************************************************/
package org.eclipse.camf.core;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.camf.core.internal.Activator;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.model.impl.GenericCloudProviderCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class gives easy access to the core preferences of c-Eclipse.
 * 
 * @author Nicholas Loulloudes, Stalo Sofokleous
 */
public class Preferences {

	
	/**
	 * Set the name of the current default Cloud Provider.
	 * 
	 * @param defaultCloudProviderName
	 *            The name of the default Cloud Provider.
	 */
	static public void setDefaultCloudProviderName(
			final String defaultCloudProviderName) {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		preferenceStore.setValue(PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID,
				defaultCloudProviderName);
	}

	/**
	 * Get the name of the current default Cloud Provider.
	 * 
	 * @return The name of the default Cloud Provider.
	 */
	static public String getDefaultVoName() {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String defaultVoName = preferenceStore
				.getString(PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID);
		return defaultVoName;
	}

	/**
	 * Get the deployment JSON string.
	 * 
	 * @return The name of the default Cloud Provider.
	 */
	static public String getDeploymentsStatus() {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String deployments = preferenceStore
				.getString(PreferenceConstants.DEPLOYMENTS);
		return deployments;
	}

	/**
	 * Set the value of the Deployment JSON string.
	 * 
	 * @param deploymentValue
	 *            The deployment JSON value.
	 */
	static public void setDeploymentStatus(final String deploymentValue) {
		
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String deploymentsString = preferenceStore
				.getString(PreferenceConstants.DEPLOYMENTS);

	    if (deploymentsString.equals( "" )){
			preferenceStore.setValue(PreferenceConstants.DEPLOYMENTS,
					deploymentValue);
			save();
	    }
	    else{
	      try {
	    	  
	    	  JSONObject newDeploymentValue = new JSONObject(deploymentValue);
	    	  JSONArray newDeploymentsArray = newDeploymentValue.getJSONArray("Deployments");
	    	  JSONObject newDeploymentObject = newDeploymentsArray.getJSONObject(0);
	    	
	    	  JSONObject preferencesDeployments = new JSONObject(deploymentsString);
	    	  JSONArray preferencesDeploymentsArray = preferencesDeployments.getJSONArray("Deployments");
	    	  preferencesDeploymentsArray.put(newDeploymentObject);
	    	  
				preferenceStore.setValue(PreferenceConstants.DEPLOYMENTS,
						preferencesDeployments.toString());
				save();
	      } catch( JSONException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	    
	}
	
	/**
	 * Remove the value of the Deployment JSON string.
	 * 
	 * @param deploymentValue
	 *            The deployment JSON value.
	 */
	static public void removeDeploymentStatus(final String deploymentName) {
		
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String deploymentsString = preferenceStore
				.getString(PreferenceConstants.DEPLOYMENTS);

	    if (deploymentsString.equals( "" )){
			return;
	    }
	    else{
	      try {
	    	  	    	
	    	  JSONObject preferencesDeployments = new JSONObject(deploymentsString);
	    	  JSONArray preferencesDeploymentsArray = preferencesDeployments.getJSONArray("Deployments");
	    	  for (int i=0; i<preferencesDeploymentsArray.length(); i++){
	    		  JSONObject deployment  = preferencesDeploymentsArray.getJSONObject(i);
	    		  if (deployment.get("appName").equals(deploymentName)){
	    			  preferencesDeploymentsArray.remove((i));
	    	    	  
	  				preferenceStore.setValue(PreferenceConstants.DEPLOYMENTS,
	  						preferencesDeployments.toString());
	  				save();
	  				return;
	    		  }
	    	  }
	    	  
	      } catch( JSONException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	    
	}

	/**
	 * Save these preferences to the preference store. This method just calls
	 * <code>Activator.getDefault().savePluginPreferences();</code>.
	 */
	static public void save() {
		Activator.getDefault().savePluginPreferences();
	}

	/**
	 * Get the preference store of the core preferences.
	 * 
	 * @return The preference store
	 */
	static protected org.eclipse.core.runtime.Preferences getPreferenceStore() {
		org.eclipse.core.runtime.Preferences preferenceStore = null;
		Activator activator = Activator.getDefault();
		if (activator != null) {
			preferenceStore = activator.getPluginPreferences();
		}
		return preferenceStore;
	}
	
	/**
	   * Add a new Cloud Provider.
	   * 
	   * @param newCloudProvider The new Cloud Provider.
	   */
	  static public void addCloudProvider(final ICloudProvider newCloudProvider){
	    
	    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
	    GenericCloudProviderCreator creator = null;
	    
	    creator = new GenericCloudProviderCreator();
	    creator.setVoName( ((GenericCloudProvider)newCloudProvider).getName());
	    creator.setVoURI( ((GenericCloudProvider)newCloudProvider).getUri());
	    creator.setVoPort( ((GenericCloudProvider)newCloudProvider).getPort());
	    
	    GenericCloudProvider cp = createVo( creator );
	    try {
	      manager.addElement( cp );
	    } catch( ProblemException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    
	    
	    
	    JSONObject provider = null;
	    try {
	      provider =  new JSONObject();
	      provider.put("name", ((GenericCloudProvider)newCloudProvider).getName() );
	      provider.put( "uri", ((GenericCloudProvider)newCloudProvider).getUri() );
	      provider.put( "port",((GenericCloudProvider)newCloudProvider).getPort() );
	    } catch( JSONException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();

	    JSONArray providersArray = null;
	    String providerString = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
	    if (providerString.equals( "" )){
	      providersArray = new JSONArray();
	    }
	    else{
	      try {
	        providersArray = new JSONArray( providerString );
	      } catch( JSONException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	        
	    
	    JSONObject tempProvider;
	    for (int i=0; i<providersArray.length(); i++){
	      try {
	        tempProvider = providersArray.getJSONObject( i );
	        if (tempProvider.getString( "name" ).compareTo( newCloudProvider.getName() )==0){
	          tempProvider.put( "uri", ((GenericCloudProvider) newCloudProvider).getUri() );
	          tempProvider.put( "port", ((GenericCloudProvider) newCloudProvider).getPort() );
	          preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
	          return;
	        }
	      } catch( JSONException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

	    }

	    providersArray.put( provider );
	    preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
	    save();
	    
	  }
	  
	  
	  /**
	   * Remove Cloud Provider.
	   * 
	   * @param removedCloudProvider The Cloud Provider to be removed.
	   */
	  static public void removeCloudProvider(final ICloudProvider removedCloudProvider){
	    
	    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
	    manager.removeElement( removedCloudProvider );
	    
	    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();

	    JSONArray providersArray = null;
	    String providerString = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
	    try {
	      providersArray = new JSONArray( providerString );
	    } catch( JSONException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    JSONObject tempProvider;
	    for (int i=0; i<providersArray.length(); i++){
	      try {
	        tempProvider = providersArray.getJSONObject( i );
	        if (tempProvider.getString( "name" ).compareTo( removedCloudProvider.getName() )==0){
	          providersArray.remove( i );
	          break;
	        }
	      } catch( JSONException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }

	    }
	    preferenceStore.setValue( PreferenceConstants.DEFINED_CPS_ID, providersArray.toString() );
	    save();
	  }
	  
	  
	  /**
	   * Get the name of the current default Cloud Provider.
	   * 
	   * @return The name of the default Cloud Provider.
	   */
	  static public String getDefinedCloudProvidersString() {
	    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
	    String cloudProviders = preferenceStore.getString( PreferenceConstants.DEFINED_CPS_ID );
	    return cloudProviders;
	  }
	  
	  /**
	   * Creates the Cloud Provider objects from the json string and adds them to the CloudProviderManager
	   * 
	   * @return The array with the defined Cloud Providers 
	   */
	  static public ICloudElement[] getDefinedCloudProviders() {
	    ICloudElement[] result = null;

	      ICloudProviderManager manager = CloudModel.getCloudProviderManager();

	      try {
	        result = manager.getChildren( null );
	        
	        if (result.length == 0){
	          
	          String providerName = getDefinedCloudProvidersString();
	          if (providerName.equals( "" )){
	            return result;
	          }
	          
	          JSONArray providersArray = null;
	          JSONObject provider = null;
	          GenericCloudProviderCreator creator = null;
	          try {
	            //Get Cloud providers from Preference Store
	            providersArray = new JSONArray(Preferences.getDefinedCloudProvidersString());
	            for (int i=0; i<providersArray.length();i++){
	              provider = providersArray.getJSONObject( i );
	              creator = new GenericCloudProviderCreator();
	              creator.setVoName( provider.getString( "name" ));
	              creator.setVoURI( provider.getString( "uri" ));
	              creator.setVoPort( provider.getString( "port" ));
	              
	              GenericCloudProvider cp = createVo( creator );
	              manager.addElement( cp );
	            }

	          } catch( JSONException e ) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }
	          

	          result = manager.getChildren( null );
	        }
	        
	        Arrays.sort( result, new Comparator< ICloudElement >() {
	          public int compare( final ICloudElement vo1,
	                              final ICloudElement vo2 ) {
	            return vo1.getName().compareTo( vo2.getName() );
	          }
	        } );
	      } catch ( ProblemException pExc ) {
	        pExc.printStackTrace();
	      }
	    
	    return result;
	  }
	  
	  // Method from class GenericCloudProviderWizard
	  private static GenericCloudProvider createVo( final GenericCloudProviderCreator creator ) {
	    
	    IStatus result = Status.OK_STATUS;
	    
	    GenericCloudProvider vo = null;
	    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
	    
	    try {
	      
	        vo = ( GenericCloudProvider ) manager.create( creator );
	      
	    } catch ( ProblemException pExc ) {
	      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, pExc.getLocalizedMessage(), pExc );
	    }
	    
	    if ( ! result.isOK() && ( vo != null ) ) {
	      try {
	        manager.delete( vo );
	      } catch ( ProblemException pExc ) {
	        Activator.logException( pExc );
	      }
	    }
	    
	    return vo;
	    
	  }


	//  @Override
	//  public void initializeDefaultPreferences() {
//	    org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
//	    String providerString = "[{\"port\"\\:\"8443\",\"name\"\\:\"Flexiant\",\"uri\"\\:\"https\\://83.212.122.157\"},{\"port\"\\:\"8443\",\"name\"\\:\"Okeanos\",\"uri\"\\:\"https\\://83.212.122.157\"}]";
//	    preferenceStore.setDefault( PreferenceConstants.DEFINED_CPS_ID, providerString);
	//    
	//  }
	//  


}
