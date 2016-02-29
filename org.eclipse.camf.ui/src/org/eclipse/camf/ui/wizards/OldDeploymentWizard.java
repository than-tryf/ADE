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
 *   Nicholas Loulloudes - initial API and implementation
 *   Stalo Sofokleous - TOSCA related extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudDeploymentCreator;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.editor.Activator;
import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


public abstract class OldDeploymentWizard extends Wizard implements IInitializableWizard, IExecutableExtension{

  private IStructuredSelection selection;
  private NewSubmissionWizardSecondPage secondPage;
  
  private ICloudDeploymentCreator creator;
  private TOSCAResource deploymentFile;
  private String deploymentString;
  private WrapperInitObject initObject;
  private ArrayList<ICloudApplicationDescription> applicationDescriptions;
  
  
  protected OldDeploymentWizard () {
    setNeedsProgressMonitor( true );
  }
  
//  @Override
//  public void init( final IWorkbench workbench, final IStructuredSelection selection ) {
//    setWindowTitle( Messages.getString( "NewApplicationSubmissionWizard.windowTitle" ) ); //$NON-NLS-1$
//    this.selection = selection;    
//    if (this.selection.getFirstElement() instanceof TOSCAResource) {
//      this.deploymentFile = (TOSCAResource) selection;  
//    }
//    
//  }
  
  @Override
  public void addPages() {
    
    this.secondPage = new NewSubmissionWizardSecondPage( Messages.getString( "NewSubmissionWizardSecondPage.pageName" )); //$NON-NLS-1$
    this.secondPage.setTitle( Messages.getString( "NewSubmissionWizardSecondPage.pageTitle" ) ); //$NON-NLS-1$
    this.secondPage.setDescription( Messages.getString( "NewSubmissionWizardSecondPage.pageDescription" ) ); //$NON-NLS-1$
    addPage( this.secondPage );
  }
  
  public static String convertToXml( final DocumentRoot eObject )
      throws IOException
    {
      XMLResourceImpl resource = new XMLResourceImpl();
      XMLProcessor processor = new XMLProcessor();
      resource.getDefaultSaveOptions()
        .put( XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE );
      resource.setEncoding( "UTF-8" ); //$NON-NLS-1$
      resource.getContents().add( eObject );
      return processor.saveToString( resource, null );
    }

  
  @Override
  public boolean performFinish() {
	  
    //Convert Deployment file to String
    TOSCAModel toscaModel = this.deploymentFile.getTOSCAModel();
//    EC2OpDeployApplication deployOperation = new EC2OpDeployApplication( EC2Client.getEC2(), toscaModel );
//	new OperationExecuter().execOp( deployOperation );
//	      localMonitor.worked( 1 );
	    
	    //Convert TOSCA Application Description file to String
	    BufferedReader br = null;
	    StringBuilder sb = new StringBuilder();
	    String line;
	    
//	    try {
//	      
//	      //br = new BufferedReader(new InputStreamReader(this.deploymentFile.getContents()));
//	      br = new BufferedReader(new InputStreamReader(convertToXml(toscaModel.getDocumentRoot())));
//	    } catch( CoreException e1 ) {
//	      e1.printStackTrace();
//	    }

	    try {
        this.deploymentString = convertToXml(toscaModel.getDocumentRoot());
      } catch( IOException e1 ) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
	    
//	    try {
//	      while ((line = br.readLine()) != null) {
//	          sb.append(line);
//	      }
//	    } catch( IOException e1 ) {
//	      e1.printStackTrace();
//	    }
//	    
//	    this.deploymentString = sb.toString();
//    
//	    String ycsbPattern = "ycsbmulti="+"\"";
//	    String[] ycsb = this.deploymentString.split(ycsbPattern);
//	    Integer ycsbMulti1 = Integer.parseInt(ycsb[1].substring(0, ycsb[1].indexOf("\"")));
//	    Integer ycsbMulti2 = Integer.parseInt(ycsb[2].substring(0, ycsb[2].indexOf("\"")));    
//	    Integer ycsbMulti;
//	    if (ycsbMulti1!=1)
//	    	ycsbMulti = ycsbMulti1;
//	    else if (ycsbMulti2!=1)
//	    	ycsbMulti = ycsbMulti2;
//	    else
//	    	ycsbMulti = 1;
//	    
//	    String casPattern = "casmulti="+"\"";
//	    String[] cas = this.deploymentString.split(casPattern);
//	    Integer casMulti1 = Integer.parseInt(cas[1].substring(0, cas[1].indexOf("\"")));
//	    Integer casMulti2 = Integer.parseInt(cas[2].substring(0, cas[2].indexOf("\"")));   
//	    Integer casMulti;
//	    if (casMulti1!=1)
//	    	casMulti = casMulti1;
//	    else if (casMulti2!=1)
//	    	casMulti = casMulti2;
//	    else
//	    	casMulti = 1;
//	    
    //Deploy Cassandra application using HTTP
    URL url = null;
    HttpURLConnection connection = null;
    try {
      //url = new URL ("http://83.212.116.50:8080/celar-server-api/deployment/deploy/?" + "casmulti=" + casMulti + "&ycsbmulti=" + ycsbMulti);
      //connection.setRequestMethod( "GET" );
      
      url = new URL ("http://cs7649.in.cs.ucy.ac.cy/ToscaContainer/rest/cloud/actions/deploy");
      
      connection = (HttpURLConnection) url.openConnection();
      
      connection.setRequestMethod( "POST" );
      
      connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
      
      OutputStream reqStream = connection.getOutputStream();
      reqStream.write(this.deploymentString.getBytes());
      
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          System.out.println(inputLine);
      }
      in.close();
      
      connection.disconnect();
      
    } catch( MalformedURLException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
   */
  @Override
  public void setInitializationData( final IConfigurationElement config,
                                     final String propertyName,
                                     final Object data ) throws CoreException
  {
    IConfigurationElement[] elements = config.getDeclaringExtension()
        .getConfigurationElements();
      for( IConfigurationElement element : elements ) {
        if( "job_creator".equals( element.getName() ) ) { //$NON-NLS-1$
          Object obj = element.createExecutableExtension( "class" ); //$NON-NLS-1$
          if( !( obj instanceof ICloudDeploymentCreator ) ) {
            String errorMessage = "Deployment Creator configured in class atribute for deployment_creator " //$NON-NLS-1$
                                  + "element in org.eclipse.camf.ui.wizards.NewDeploymentWizard " //$NON-NLS-1$
                                  + "is not implementing ICloudDeploymentCreator interface"; //$NON-NLS-1$
            Status status = new Status( IStatus.ERROR,
                                        Activator.PLUGIN_ID,
                                        IStatus.OK,
                                        errorMessage,
                                        null );
            throw new CoreException( status );
          }
          this.creator = ( ICloudDeploymentCreator )obj;
        }
      }    
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard#init(java.lang.Object)
   */
  @Override
  public boolean init( final Object data ) {
    boolean result = false;
    if( data instanceof WrapperInitObject ) {
      this.initObject = ( WrapperInitObject )data;
      this.applicationDescriptions = new ArrayList<ICloudApplicationDescription>( this.initObject.getApplicationDescriptions() );
//      this.jobNames = new ArrayList<String>( this.initObject.getJobNames() );
      result = true;
    }
    return result;
  }
  
  private Shell getWizardShell() {
    Shell shell = null;
    if( getContainer() != null ) {
      shell = getContainer().getShell();
    }
    return shell;
  }

}
