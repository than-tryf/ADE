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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor.diagram;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.camf.infosystem.mockup.info.MockUpInfoSystem;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageType;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;
import org.eclipse.camf.tosca.editor.features.CreateApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.CreateGroupFeature;
import org.eclipse.camf.tosca.editor.features.CreateKeyPairFeature;
import org.eclipse.camf.tosca.editor.features.CreateMonitorProbeFeature;
import org.eclipse.camf.tosca.editor.features.CreateNetworkFeature;
import org.eclipse.camf.tosca.editor.features.CreateReadyToUseArtifactFeature;
import org.eclipse.camf.tosca.editor.features.CreateResizeActionFeature;
import org.eclipse.camf.tosca.editor.features.CreateSoftwareDependencyFeature;
import org.eclipse.camf.tosca.editor.features.CreateUserApplicationFeature;
import org.eclipse.camf.tosca.editor.features.CreateVMIFeature;
import org.eclipse.camf.tosca.editor.features.RenameApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.RenameCompositeComponentFeature;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.impl.PropertiesTypeImpl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.IToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.*;

//import

//import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;

public class ToscaToolBehaviorProvider extends DefaultToolBehaviorProvider {

	MockUpInfoSystem mockUpInfoSystemInstance; 
	  
	private String typesPrefix = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getNsPrefix();
  
	private String typesNamespace = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getNsURI();
  
	private String imageType = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getImageArtifactPropertiesType().getName();

	private String scriptArtifactType = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getScriptArtifactPropertiesType().getName();
  
  public ToscaToolBehaviorProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }

  @Override
  public IContextButtonPadData getContextButtonPad( IPictogramElementContext context )
  {
    IContextButtonPadData data = super.getContextButtonPad( context );
    PictogramElement pe = context.getPictogramElement();
    // set the generic context buttons
    // note, that we do not add 'remove' (just as an example)
    setGenericContextButtons( data, pe, CONTEXT_BUTTON_DELETE
                                        | CONTEXT_BUTTON_UPDATE );
    CreateConnectionContext ccc = new CreateConnectionContext();
    ccc.setSourcePictogramElement( pe );
    Anchor anchor = null;
    if( pe instanceof Anchor ) {
      anchor = ( Anchor )pe;
    } else if( pe instanceof AnchorContainer ) {
      // assume, that our shapes always have chopbox anchors
      anchor = Graphiti.getPeService().getChopboxAnchor( ( AnchorContainer )pe );
    }
    ccc.setSourceAnchor( anchor );
    // create context button and add all applicable features
    ContextButtonEntry button = new ContextButtonEntry( null, context );
    button.setText( "Create connection" ); //$NON-NLS-1$      
    ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
    for( ICreateConnectionFeature feature : features ) {
      if( feature.isAvailable( ccc ) && feature.canStartConnection( ccc ) )
        button.addDragAndDropFeature( feature );
    }
    // add context button, if it contains at least one feature
    if( button.getDragAndDropFeatures().size() > 0 ) {
      data.getDomainSpecificContextButtons().add( button );
    }
    return data;
  }

  /**
   * 
   */
//  private void fetchResources() {
//    Job job = new Job( "Resource Fetching" ) { //$NON-NLS-1$
//
//      @Override
//      protected IStatus run( final IProgressMonitor monitor ) {
//        monitor.beginTask( "Fetching Resources from Cloud Provider", 100 );
//        MockUpInfoSystem.getInstance();
//        for( int i = 0; i < 5; i++ ) {
//          try {
//            // sleep a second
//            TimeUnit.SECONDS.sleep( 1 );
//            monitor.subTask( "Resource bundle #" + i );
//            // report that 20 additional units are done
//            monitor.worked( 20 );
//          } catch( InterruptedException e1 ) {
//            e1.printStackTrace();
//            return Status.CANCEL_STATUS;
//          }
//        }
//        System.out.println( "Called save" );
//        return Status.OK_STATUS;
//      }
//    };
//    job.schedule();
//  }

  // Creates the Palette. Palette entries are retrieved from an SQL database.
  @Override
  public IPaletteCompartmentEntry[] getPalette() {
    //    Job job = new Job("Resource Fetching") { //$NON-NLS-1$
    //
    // @Override
    // protected IStatus run( final IProgressMonitor monitor ) {
    //
    // monitor.beginTask("Fetching Resources from Cloud Provider", 100);
    // MockUpInfoSystem.getInstance();
    // for (int i = 0; i < 5; i++) {
    // try {
    // // sleep a second
    // TimeUnit.SECONDS.sleep(1);
    //
    // monitor.subTask("Resource bundle #" + i);
    //
    // // report that 20 additional units are done
    // monitor.worked(20);
    // } catch (InterruptedException e1) {
    // e1.printStackTrace();
    // return Status.CANCEL_STATUS;
    // }
    // }
    // return Status.OK_STATUS;
    // }
    // };
    // job.setUser( true );
    // job.schedule();
    // // TODO nickl - Workaround for resource fetcher in UI. should be done in
    // the background
    // fetchResources();
    // MockUpInfoSystem.getInstance();
    List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();
    // add compartments from super class - connections and objects
    // IPaletteCompartmentEntry[] superCompartments = super.getPalette();
    // for( int i = 0; i < superCompartments.length; i++ ) {
    // if (superCompartments[i].getLabel().equals( "Objects" )){
    // PaletteCompartmentEntry appCompartment =
    // getApplicationComponentCompartment(ret);
    // appCompartment.getToolEntries().addAll(
    // superCompartments[i].getToolEntries() );
    // ret.add( appCompartment );
    // } else {
    // ret.add( superCompartments[ i ] );
    // }
    //
    // }
    // addBaseMachineImageCompartment( ret );
    // add compartments from super class - connections and objects
    IPaletteCompartmentEntry[] superCompartments = super.getPalette();
    for( int i = 0; i < superCompartments.length; i++ ) {
      if( superCompartments[ i ].getLabel().equals( "Objects" ) == false )
        ret.add( superCompartments[ i ] );
    }
    addApplicationComponentsCompartment( ret );
    
//    this.mockUpInfoSystemInstance = MockUpInfoSystem.getInstance();
//    addVMImageCompartment( ret );
//    addNetworkCompartment( ret );
//      ProbeCompartment( ret );
//    addResizeActionsCompartment( ret );
//    
//    addJCatascopiaMonitorProbeCompartment( ret );
//    addUserAppsCompartment( ret );
 //   addKeyPairCompartment( ret );
//    addDeployScriptCompartment( ret );
    
    
    /*--------Repository compartment to palette-------*/
    	addRepositoryCompartment(ret);
    
    /*---------------------END------------------------*/

    return ret.toArray( new IPaletteCompartmentEntry[ ret.size() ] );
  }
  
  /*----------------------Implementation------------------------*/
  public void addRepositoryCompartment(List<IPaletteCompartmentEntry> ret ){

	  //Get the list with the configured artifacts
	  ArrayList<String> arts =CloudSoftwareMarketplaceConfigureArt.getReadyArtifacts();
	  for(int i =0; i<arts.size();i++){
		  System.out.println("[*] "+getClass().getSimpleName()+" : "+arts.get(i));
	  }
	  
	  //ArrayList with the NodeTemplates for each artifact
	  ArrayList<TNodeTemplateExtension> appComponents = new ArrayList<TNodeTemplateExtension>();
	  TNodeTemplateExtension applicationServerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
	  applicationServerComponent.setType( new QName( "SimpleComponent" ) );
	  applicationServerComponent.setName( "Component" );
	  // applicationServerComponent.setDeploymentArtifacts();
	  // applicationServerComponent.s
	  // applicationServerComponent.eSet("Username", "Hello");
	  //applicationServerComponent.setProperties(properties);
	  //applicationServerComponent.setDeploymentArtifacts(value);
	  
	  //Loop through all configured artifacts
	  for(int i =0; i<arts.size();i++){
		  applicationServerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
		  applicationServerComponent.setType( new QName( "SimpleComponent" ) );
		  applicationServerComponent.setName( arts.get(i) );
		  //Add to the palette compartment
		  appComponents.add( applicationServerComponent );
	  }

	  //appComponents.add( applicationServerComponent );
	  PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Ready-to-use Artifacts", null ); //$NON-NLS-1$
	  ret.add( compartmentEntry );
	  for( TNodeTemplateExtension appComponent : appComponents ) {
		  // add new stack entry to new compartment
		  StackEntry stackEntry = new StackEntry( appComponent.getName(),
				  appComponent.getName(),
				  null );
		  compartmentEntry.addToolEntry( stackEntry );
		  compartmentEntry.setInitiallyOpen( true );
		  // add all create-features to the new stack-entry
		  IFeatureProvider featureProvider = getFeatureProvider();
		  ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
		  for( ICreateFeature cf : createFeatures ) {
			  if( cf instanceof CreateReadyToUseArtifactFeature ) {
				  CreateReadyToUseArtifactFeature appCompCF = ( CreateReadyToUseArtifactFeature )cf;
				  appCompCF.setContextObject( appComponent );
				  ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( appComponent.getName(),
						  appCompCF.getDescription(),
						  appCompCF.getCreateImageId(),
						  appCompCF.getCreateLargeImageId(),
						  appCompCF );
				  stackEntry.addCreationToolEntry( objectCreationToolEntry );
				  break;
			  }
		  }
	  }
  }
  
  /*-----------------------END---------------------------*/

  private void addNetworkCompartment( final List<IPaletteCompartmentEntry> ret ) {
    
    ArrayList<VirtualNetwork> networks = this.mockUpInfoSystemInstance.getNetworks();
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Networks", null ); //$NON-NLS-1$
    compartmentEntry.setInitiallyOpen( false );
    ret.add( compartmentEntry );
    for( VirtualNetwork vn : networks ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( vn.getUID(), vn.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( false );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateNetworkFeature ) {
          CreateNetworkFeature vnCF = ( CreateNetworkFeature )cf;

          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vn.getUID() );
          deploymentArtifact.setArtifactType( new QName( "Network" ) );
          vnCF.setContextObject( deploymentArtifact );

          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( 
        		  																		vn.getName(),
        		  																		vn.getUID(),
                                                                                         null,
                                                                                         null,
                                                                                         vnCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
          
        }
      }
      
      // add all create-connection-features to the new stack-entry
//      ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();
//      for( ICreateConnectionFeature cf : createConnectionFeatures ) {
//        ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry( 
//        		//vn.getName(),
//        		vn.getUID(),
//                                                                                                   cf.getName(),
//                                                                                                   cf.getCreateImageId(),
//                                                                                                   cf.getCreateLargeImageId() );
//        connectionCreationToolEntry.addCreateConnectionFeature( cf );
//        stackEntry.addCreationToolEntry( connectionCreationToolEntry );
//      }
    }    
  }

  /**
   * @param ret
   */

  // Create Palette compartment for Application Components
  private void addApplicationComponentsCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<TNodeTemplateExtension> appComponents = new ArrayList<TNodeTemplateExtension>();
    TNodeTemplateExtension applicationServerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
    applicationServerComponent.setType( new QName( "SimpleComponent" ) );
    applicationServerComponent.setName( "Component" );
    appComponents.add( applicationServerComponent );
//    TNodeTemplateExtension applicationServerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
//    applicationServerComponent.setType( new QName( "appserver" ) );
//    applicationServerComponent.setName( "ApplicationServer" );
//    appComponents.add( applicationServerComponent );
//    TNodeTemplateExtension databaseServerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
//    databaseServerComponent.setType( new QName( "dbserver" ) );
//    databaseServerComponent.setName( "DatabaseServer" );
//    appComponents.add( databaseServerComponent );
//    TNodeTemplateExtension loadBalancerComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
//    loadBalancerComponent.setType( new QName( "loadbalancer" ) );
//    loadBalancerComponent.setName( "LoadBalancer" );
//    appComponents.add( loadBalancerComponent );
    
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Application Components", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( TNodeTemplateExtension appComponent : appComponents ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( appComponent.getName(),
                                              appComponent.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( true );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateApplicationComponentFeature ) {
          CreateApplicationComponentFeature appCompCF = ( CreateApplicationComponentFeature )cf;
          appCompCF.setContextObject( appComponent );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( appComponent.getName(),
                                                                                         appCompCF.getDescription(),
                                                                                         appCompCF.getCreateImageId(),
                                                                                         appCompCF.getCreateLargeImageId(),
                                                                                         appCompCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
          break;
        }
      }
    }
    // Add Group Entry
    // add new stack entry to new compartment
    TServiceTemplateExtension groupComponent = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTServiceTemplateExtension();
    groupComponent.setName( null );
    StackEntry stackEntry = new StackEntry( "Composite Component",
                                            "Composite Component",
                                            null );
    compartmentEntry.addToolEntry( stackEntry );
    compartmentEntry.setInitiallyOpen( true );
    // add all create-features to the new stack-entry
    IFeatureProvider featureProvider = getFeatureProvider();
    ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
    for( ICreateFeature cf : createFeatures ) {
      if( cf instanceof CreateGroupFeature ) {
        CreateGroupFeature groupCF = ( CreateGroupFeature )cf;
        groupCF.setContextObject( groupComponent );
        ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( "Composite Component",
                                                                                       groupCF.getDescription(),
                                                                                       groupCF.getCreateImageId(),
                                                                                       groupCF.getCreateLargeImageId(),
                                                                                       groupCF );
        stackEntry.addCreationToolEntry( objectCreationToolEntry );
        break;
      }
    }
  }

  /**
   * @param ret
   */
  private void addDeployScriptCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<SoftwareDependency> deployScriptsList = new ArrayList<SoftwareDependency>();
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Deployment Scripts" );
      //IFolder artifactsFolder = activeProject.getFolder( CloudSoftwareRepo.getARTIFACTS_FOLDER() );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          IFile file = ( IFile )tempResource;
          if( file.getFileExtension() != null && !(file.getFileExtension().equals( "pub" )) ){            
            SoftwareDependency sd = InfoSystemFactory.eINSTANCE.createSoftwareDependency();
            sd.setName( file.getName() );
            sd.setURL( file.getFullPath().toString() );
            sd.setDescription( file.getName() );
            // add new keypair to list
            deployScriptsList.add( sd );
          }
        }
      }
      // add new compartment at the end of the existing compartments
      PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Deployment Scripts", null ); //$NON-NLS-1$
      ret.add( compartmentEntry );
      // TODO - nickl: Fix below. It should be Scripts and not Software
      // dependency. Maybe update sysinfo model.
      for( SoftwareDependency script : deployScriptsList ) {
        // add all create-features to the new stack-entry
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for( ICreateFeature cf : createFeatures ) {
          if( cf instanceof CreateSoftwareDependencyFeature ) {
            CreateSoftwareDependencyFeature sdCF = ( CreateSoftwareDependencyFeature )cf;
 
            
            TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
            artifactTemplate.setName( "SD"+script.getName() );
            artifactTemplate.setId( script.getName() );
            artifactTemplate.setType( new QName( typesNamespace, scriptArtifactType, typesPrefix ) );
            sdCF.setContextObject( artifactTemplate );
                        
            
            // add new stack entry to new compartment
            IToolEntry entry = new ObjectCreationToolEntry( script.getName(),
                                                            script.getDescription(),
                                                            null,
                                                            null,
                                                            sdCF );
            compartmentEntry.addToolEntry( entry );
            break;
          }
        }
      }
    }
  }
  

  // Create Palette compartment for User Applications
  private void addUserAppsCompartment( final List<IPaletteCompartmentEntry> ret )
  {
    
    ArrayList<UserApplication> uAppsCopy = new ArrayList<UserApplication> ();
    
    // Add custom images from project explorer
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Applications" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          UserApplication ua = InfoSystemFactory.eINSTANCE.createUserApplication();
          ua.setUID( "1" );
          ua.setName( tempResource.getName() );
          ua.setDescription( "h" );
          ua.setURL( "h" );
          ua.setType( "UA" );
          // add new base vmi to images list
          uAppsCopy.add( ua );
        }
      }
    }
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "User Applications", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( UserApplication app : uAppsCopy ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( app.getName(),
                                              app.getName(),
                                              null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( true );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateUserApplicationFeature ) {
          CreateUserApplicationFeature uaCF = ( CreateUserApplicationFeature )cf;

          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( app.getName() );
          deploymentArtifact.setArtifactType( new QName( "UA" ) );
          uaCF.setContextObject( deploymentArtifact );

          // add new stack entry to new compartment
          IToolEntry entry = new ObjectCreationToolEntry( app.getName(),
                                                          app.getDescription(),
                                                          null,
                                                          null,
                                                          uaCF );
          compartmentEntry.addToolEntry( entry );
          
        }
      }

    }
  }

  /**
   * @param ret
   */
  private void addKeyPairCompartment( List<IPaletteCompartmentEntry> ret ) {
    ArrayList<KeyPair> keyPairList = new ArrayList<KeyPair>();
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Deployment Scripts" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          IFile file = ( IFile )tempResource;
          if ( file.getFileExtension() != null && file.getFileExtension().equals( "pub" ) ){
            KeyPair kp = InfoSystemFactory.eINSTANCE.createKeyPair();
            kp.setName( file.getName() );
            kp.setURL( file.getFullPath().toString() );
            kp.setDescription( file.getName() );
            // add new keypair to list
            keyPairList.add( kp );
          }
        }
      }
      
      // Now check the InfoService for additional KeyPairs
      keyPairList.addAll( this.mockUpInfoSystemInstance.getKeyPairs() );
      
      // add new compartment at the end of the existing compartments
      PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Key Pairs", null ); //$NON-NLS-1$
      ret.add( compartmentEntry );
      for( KeyPair keyPair : keyPairList ) {
        // add all create-features to the new stack-entry
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for( ICreateFeature cf : createFeatures ) {
          if( cf instanceof CreateKeyPairFeature ) {
            CreateKeyPairFeature kpCF = ( CreateKeyPairFeature )cf;

            TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
            deploymentArtifact.setName( keyPair.getName() );
            deploymentArtifact.setArtifactType( new QName( "KeyPair" ) );
            kpCF.setContextObject( deploymentArtifact );

            // add new stack entry to new compartment
            IToolEntry entry = new ObjectCreationToolEntry( keyPair.getName(),
                                                            keyPair.getDescription(),
                                                            null,
                                                            null,
                                                            kpCF );
            compartmentEntry.addToolEntry( entry );
            break;
          }
        }
      }
    }
  }

  
  // Create Palette compartment for Custom Images
  private void addVMImageCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<VirtualMachineImage> vmis = this.mockUpInfoSystemInstance.getBaseMachineImages();
    
    ArrayList<VirtualMachineImage> vmisCopy = ( ArrayList<VirtualMachineImage> )vmis.clone();
    // Add custom images from project explorer
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Virtual Machine Images" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          
        /////////////////////////////////////////////////////

        // Get image Id
        final char[] buffer = new char[1024];
        final StringBuilder out = new StringBuilder();
        try {
          Reader in = null;
          try {
            in = new InputStreamReader(((IFile) tempResource).getContents(), "UTF-8");
          } catch( CoreException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          try {
            for (;;) {
              int rsz = in.read(buffer, 0, buffer.length);
              if (rsz < 0)
                break;
              out.append(buffer, 0, rsz);
            }
          }
          finally {
            in.close();
          }
        }
        catch (UnsupportedEncodingException ex) {
          /* ... */
        }
        catch (IOException ex) {
            /* ... */
        }
          String imageId = out.toString();
          
          /////////////////////////////////////////////////////
          
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( imageId );
          vmi.setName( tempResource.getName() );
          vmi.setDescription( "h" );
          vmi.setURL( "h" );
          vmi.setType( VirtualMachineImageType.BASE_IMAGE );
          // add new base vmi to images list
          vmisCopy.add( vmi );
        }
      }
    }
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Images", null ); //$NON-NLS-1$
    compartmentEntry.setInitiallyOpen( false );
    ret.add( compartmentEntry );
    for( VirtualMachineImage vmi : vmisCopy ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( vmi.getUID(), vmi.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( false );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateVMIFeature ) {
          CreateVMIFeature vmiCF = ( CreateVMIFeature )cf;

          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( vmi.getUID() );
          deploymentArtifact.setArtifactRef( new QName(vmi.getUID()) );
          //deploymentArtifact.setArtifactType( new QName( "VMI" ) );
          deploymentArtifact.setArtifactType( new QName( typesNamespace, imageType, typesPrefix ));
          vmiCF.setContextObject( deploymentArtifact );

          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(  vmi.getName(),
        		  //vmi.getUID(),
                                                                                         vmiCF.getName(),
                                                                                         vmiCF.getCreateImageId(),
                                                                                         vmiCF.getCreateLargeImageId(),
                                                                                         vmiCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
          break;
        }
      }
    }
  }
  
  // Create Palette compartment for Monitoring Probes
  private void addMonitorProbeCompartment( List<IPaletteCompartmentEntry> ret )
  {
    
  ArrayList<MonitoringProbe> mps = this.mockUpInfoSystemInstance.getMonitoringProbes();
  
  ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();

    // Add custom probes from project explorer

  IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
  IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );

  if( monitoringProbesProject.exists() ) {
    IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
    IResource[] artifactsResource = null;
    try {
      artifactsResource = srcFolder.members();
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if ( artifactsResource != null ){
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
          mp.setUID( tempResource.getName().replaceFirst( ".java", "" ));
          mp.setName( tempResource.getName().replaceFirst( ".java", "" ));
          mp.setDescription( "" );
          // add new probe to monitoring list
          mpsCopy.add( 0, mp );
        }
      }
    }
  }
  
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Monitor Probes", null ); //$NON-NLS-1$
    compartmentEntry.setInitiallyOpen( false );
    ret.add( compartmentEntry );
        
    for( MonitoringProbe mp : mpsCopy ) {

      String metricsString = mp.getDescription();
      if ( metricsString.equals( "" ) == false ){
        // add new Metric Probe entry to probes compartment
        StackEntry stackEntry = new StackEntry(  mp.getName(), mp.getName(), null );
        compartmentEntry.addToolEntry( stackEntry );
        compartmentEntry.setInitiallyOpen( false );   
        
        IFeatureProvider featureProvider = getFeatureProvider();
        ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
        for( ICreateFeature cf : createFeatures ) {
          if( cf instanceof CreateMonitorProbeFeature ) {
            CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

            TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
            deploymentArtifact.setName( mp.getName() );
            deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
            mpCF.setContextObject( deploymentArtifact );

            ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( mp.getName(),
                                                                                           mpCF.getName(),
                                                                                           mpCF.getCreateImageId(),
                                                                                           mpCF.getCreateLargeImageId(),
                                                                                           mpCF );
            stackEntry.addCreationToolEntry( objectCreationToolEntry );
            break;
          }
        }
        
        String[] metrics = (metricsString.substring( 1, metricsString.length()-1 )).split( "," );
        for ( String metric : metrics){
          String metricLabel = metric.replace( "\"", "" );
          // add all create-features to the new stack-entry
          featureProvider = getFeatureProvider();
          createFeatures = featureProvider.getCreateFeatures();
          for( ICreateFeature cf : createFeatures ) {
            if( cf instanceof CreateMonitorProbeFeature ) {
              CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

              TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
              deploymentArtifact.setName( metricLabel );
              deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
              mpCF.setContextObject( deploymentArtifact );

              ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( metricLabel,
                                                                                             mpCF.getName(),
                                                                                             mpCF.getCreateImageId(),
                                                                                             mpCF.getCreateLargeImageId(),
                                                                                             mpCF );
              
              stackEntry.addCreationToolEntry( objectCreationToolEntry );
              break;
            }            
          }
          
        }
      }
      else{
      // Custom Monitoring Probes
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateMonitorProbeFeature ) {
          CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

          TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
          deploymentArtifact.setName( mp.getName() );
          deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
          mpCF.setContextObject( deploymentArtifact );
          
          // add new stack entry to new compartment
          IToolEntry entry = new ObjectCreationToolEntry( mp.getName(),
                                                          mp.getDescription(),
                                                          null,
                                                          null,
                                                          mpCF );
          compartmentEntry.addToolEntry( entry );
          break;
        }
      }
    }
    }
  }


  // Create Palette compartment for Resizing Actions
  private void addResizeActionsCompartment( List<IPaletteCompartmentEntry> ret )
  {
    ArrayList<ResizingAction> ras = this.mockUpInfoSystemInstance.getResizingActions();
    
    ArrayList<ResizingAction> rasCopy = ( ArrayList<ResizingAction> )ras.clone();
    // Add custom images from project explorer
    IProject activeProject = ToscaDiagramEditor.getActiveProject();
    if( activeProject != null ) {
      IFolder artifactsFolder = activeProject.getFolder( "/Artifacts/Reconfiguration Scripts" );
      IResource[] artifactsResource = null;
      try {
        artifactsResource = artifactsFolder.members();
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      for( IResource tempResource : artifactsResource ) {
        if( tempResource instanceof IFile ) {
          ResizingAction rat = InfoSystemFactory.eINSTANCE.createResizingAction();
          rat.setUID( tempResource.getName() );
          rat.setName( tempResource.getName() );
          rat.setDescription( "h" );
          rat.setURL( "h" );
          // add new base vmi to images list
          rasCopy.add( rat );
        }
      }
    }
    
    // add new compartment at the end of the existing compartments
    PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Elasticity Actions", null ); //$NON-NLS-1$
    ret.add( compartmentEntry );
    for( ResizingAction ra : rasCopy ) {
      // add new stack entry to new compartment
      StackEntry stackEntry = new StackEntry( ra.getName(), ra.getName(), null );
      compartmentEntry.addToolEntry( stackEntry );
      compartmentEntry.setInitiallyOpen( false );
      // add all create-features to the new stack-entry
      IFeatureProvider featureProvider = getFeatureProvider();
      ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
      for( ICreateFeature cf : createFeatures ) {
        if( cf instanceof CreateResizeActionFeature ) {
          CreateResizeActionFeature raCF = ( CreateResizeActionFeature )cf;
          raCF.setContextObject( ra );
          ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( ra.getName(),
                                                                                         raCF.getDescription(),
                                                                                         raCF.getCreateImageId(),
                                                                                         raCF.getCreateLargeImageId(),
                                                                                         raCF );
          stackEntry.addCreationToolEntry( objectCreationToolEntry );
          break;
        }
      }
    }
  }

  @Override
  public IContextMenuEntry[] getContextMenu( final ICustomContext context ) {
    // create a sub-menu for all custom features
    ContextMenuEntry subMenu = new ContextMenuEntry( null, context );
    subMenu.setText( "Cu&stom" ); //$NON-NLS-1$
    subMenu.setDescription( "Custom features submenu" ); //$NON-NLS-1$
    // display sub-menu hierarchical or flat
    subMenu.setSubmenu( true );
    // create a menu-entry in the sub-menu for each custom feature
    ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures( context );
    for( int i = 0; i < customFeatures.length; i++ ) {
      ICustomFeature customFeature = customFeatures[ i ];
      if( customFeature.isAvailable( context ) ) {
        ContextMenuEntry menuEntry = new ContextMenuEntry( customFeature,
                                                           context );
        subMenu.add( menuEntry );
      }
    }
    IContextMenuEntry ret[] = new IContextMenuEntry[]{
      subMenu
    };
    return ret;
  }

  @Override
  public IDecorator[] getDecorators( final PictogramElement pe ) {
    IFeatureProvider featureProvider = getFeatureProvider();
    Object bo = featureProvider.getBusinessObjectForPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      TNodeTemplate eClass = ( TNodeTemplate )bo;
      String name = eClass.getName();
      if( name != null
          && name.length() > 0
          && !( name.charAt( 0 ) >= 'A' && name.charAt( 0 ) <= 'Z' ) )
      {
        IDecorator imageRenderingDecorator = new ImageDecorator( IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK );
        imageRenderingDecorator.setMessage( "Name should start with upper case letter" ); //$NON-NLS-1$
        return new IDecorator[]{
          imageRenderingDecorator
        };
      }
    }
    return super.getDecorators( pe );
  }
  

  
//Create Palette compartment for Monitoring Probes
 private void addJCatascopiaMonitorProbeCompartment( List<IPaletteCompartmentEntry> ret )
 {
   
 ArrayList<MonitoringProbe> mps = this.mockUpInfoSystemInstance.getMonitoringProbes();
 
 @SuppressWarnings("unchecked")
 ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();


 
   // add new compartment at the end of the existing compartments
   PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry( "Monitor Probes", null ); //$NON-NLS-1$
   compartmentEntry.setInitiallyOpen( false );
   ret.add( compartmentEntry );
       
   for( MonitoringProbe mp : mpsCopy ) {

     String metricsString = "";
     if ( metricsString.equals( "" ) == false ){
       // add new Metric Probe entry to probes compartment
       StackEntry stackEntry = new StackEntry(  mp.getName(), mp.getDescription(), null );
       compartmentEntry.addToolEntry( stackEntry );
       compartmentEntry.setInitiallyOpen( false );   
       
       IFeatureProvider featureProvider = getFeatureProvider();
       ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
       for( ICreateFeature cf : createFeatures ) {
         if( cf instanceof CreateMonitorProbeFeature ) {
           CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

           TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
           deploymentArtifact.setName( mp.getName() );
           deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
           mpCF.setContextObject( deploymentArtifact );

           ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( mp.getName(),
                                                                                          mp.getDescription(),
                                                                                          mpCF.getCreateImageId(),
                                                                                          mpCF.getCreateLargeImageId(),
                                                                                          mpCF );
           stackEntry.addCreationToolEntry( objectCreationToolEntry );
           break;
         }
       }
       
       String metrics = "{\"metrics\":" + metricsString + "}";
       JSONObject obj = null;
       JSONArray metrics_array = null;
       try {
         obj = new JSONObject( metrics );
         metrics_array = obj.getJSONArray( "metrics" );
       } catch( JSONException e ) {
         // TODO Auto-generated catch block
         e.printStackTrace();
       } //$NON-NLS-1$

       for ( int i=0; i < metrics_array.length(); i++){
         String metricLabel = null;
         String metricDescription = null;
         try {
           metricLabel = metrics_array.getJSONObject( i ).getString( "name" );
           metricDescription = metrics_array.getJSONObject( i ).getString( "desc" );
         } catch( JSONException e ) {
           // TODO Auto-generated catch block
           e.printStackTrace();
         }
         // add all create-features to the new stack-entry
         featureProvider = getFeatureProvider();
         createFeatures = featureProvider.getCreateFeatures();
         for( ICreateFeature cf : createFeatures ) {
           if( cf instanceof CreateMonitorProbeFeature ) {
             CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

             TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
             deploymentArtifact.setName( metricLabel );
             deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
             mpCF.setContextObject( deploymentArtifact );

             ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry( metricLabel,
                                                                                            metricDescription,
                                                                                            mpCF.getCreateImageId(),
                                                                                            mpCF.getCreateLargeImageId(),
                                                                                            mpCF );
             
             stackEntry.addCreationToolEntry( objectCreationToolEntry );
             break;
           }
         }
         
       }
     }
     else{
     // Custom Monitoring Probes
     // add all create-features to the new stack-entry
     IFeatureProvider featureProvider = getFeatureProvider();
     ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();
     for( ICreateFeature cf : createFeatures ) {
       if( cf instanceof CreateMonitorProbeFeature ) {
         CreateMonitorProbeFeature mpCF = ( CreateMonitorProbeFeature )cf;

         TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
         deploymentArtifact.setName( mp.getName() );
         deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) );
         mpCF.setContextObject( deploymentArtifact );
         
         // add new stack entry to new compartment
         IToolEntry entry = new ObjectCreationToolEntry( mp.getName(),
                                                         mp.getDescription(),
                                                         null,
                                                         null,
                                                         mpCF );
         compartmentEntry.addToolEntry( entry );

       }
     }
   }
   }
 }

  @Override
  public ICustomFeature getDoubleClickFeature( final IDoubleClickContext context )
  {

    ICustomFeature customFeature = new RenameApplicationComponentFeature( getFeatureProvider() );
    // canExecute() tests especially if the context contains a EClass
    if( customFeature.canExecute( context ) ) {
      return customFeature;
    }
    
    customFeature = new RenameCompositeComponentFeature( getFeatureProvider() );
    // canExecute() tests especially if the context contains a EClass
    if( customFeature.canExecute( context ) ) {
      return customFeature;
    }
    
    return super.getDoubleClickFeature( context );
  }

  @Override
  public GraphicsAlgorithm[] getClickArea( final PictogramElement pe ) {
    IFeatureProvider featureProvider = getFeatureProvider();
    Object bo = featureProvider.getBusinessObjectForPictogramElement( pe );
    
    if (bo instanceof TNodeTemplate)
      if ( ((TNodeTemplate) bo)==null || ((TNodeTemplate) bo).getType() == null)
        return null;
    
    if( bo instanceof TNodeTemplate && ((TNodeTemplate) bo).getType().toString().contains("substituteNode")==false) {
      GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
      GraphicsAlgorithm rectangle = invisible.getGraphicsAlgorithmChildren()
        .get( 0 );
      return new GraphicsAlgorithm[]{
        rectangle
      };
    }
    return super.getClickArea( pe );
  }

  @Override
  public GraphicsAlgorithm getSelectionBorder( final PictogramElement pe ) {
    if( pe instanceof ContainerShape ) {
      GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
      if( !invisible.getLineVisible().booleanValue() ) {
        EList<GraphicsAlgorithm> graphicsAlgorithmChildren = invisible.getGraphicsAlgorithmChildren();
        if( !graphicsAlgorithmChildren.isEmpty() ) {
          return graphicsAlgorithmChildren.get( 0 );
        }
      }
    }
    return super.getSelectionBorder( pe );
  }
}
