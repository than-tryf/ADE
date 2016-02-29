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
package org.eclipse.camf.tosca.editor.features;

import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.jface.dialogs.MessageDialog;

public class CreateVMIFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateVMIFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Base Image", "Base Image" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a VM image object in the target business object
  @Override
  public boolean canCreate( final ICreateContext context ) {

    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate || parentBo instanceof TServiceTemplate ) {
      return true;
    } else {
      return false;
    }
  }

  // Creates the business object for the VM image
  @Override
  public Object[] create( final ICreateContext context ) {
    if( this.contextObject == null )
      return null;

    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    TNodeTemplate tNode = null;
    if( parentObject == null )
      return null;
    if( parentObject instanceof TNodeTemplate ) {
      tNode = ( TNodeTemplate )parentObject;
    }

    if (tNode.getName()==null){
      MessageDialog.openError(null, "Error", "Give a Name to the selected Component and try again.");
      return null;
    }
    
    if( tNode.getDeploymentArtifacts() == null ) {
      //deploymentArtifacts = ToscaFactory.eINSTANCE.createTDeploymentArtifacts();
      //tNode.setDeploymentArtifacts( deploymentArtifacts );
      
      final TNodeTemplate node = tNode;
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          protected void doExecute() {
            node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
          }
        } );
      
    } 
    
    
//    else {
//      
//      // Check whether a VM image has been specified for the component
//      TDeploymentArtifact artifact;
//      TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
//      for( int i=0; i<deploymentArtifacts.getDeploymentArtifact().size(); i++ )
//      {
//        artifact = deploymentArtifacts.getDeploymentArtifact().get( i );
//        if( artifact.getArtifactType().toString().compareTo( "VMI" ) == 0 ) //$NON-NLS-1$
//          deploymentArtifacts.getDeploymentArtifact().remove( artifact );
//        
//      }
//    }
    
    
    // Add the new deployment artifact to the list
    final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
    
    final TDeploymentArtifact tempDeploymentArtifact;
    if( this.contextObject instanceof TDeploymentArtifact ) {
      tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
    } else {
      tempDeploymentArtifact = null;
    }
    
    if (tempDeploymentArtifact.getArtifactRef() == null ) {
      tempDeploymentArtifact.setArtifactRef( new QName (tNode.getName() + "Image" ));
    }
        
//    final TDeploymentArtifact tempArtifact = deploymentArtifact;
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        protected void doExecute() {
          deploymentArtifacts.getDeploymentArtifact().add( tempDeploymentArtifact );
        }
      } );
    
    //addGraphicalRepresentation( context, vmi );
    
    /////////////////////////////////////////////
    addGraphicalRepresentation( context, tempDeploymentArtifact );
    /////////////////////////////////////////////

    //Create Image Artifact Template
   
    createArtifactTemplate(tNode.getName(), "not_specified", tempDeploymentArtifact.getArtifactRef().toString());
    
    
    
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      tempDeploymentArtifact
    };
  }
  
  private void createArtifactTemplate(String nodeName, String description, String imageId){
    
    //Create Artifact Template
    final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
    
    //Create Image Artifact Properties
    ImageArtifactPropertiesType imageProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createImageArtifactPropertiesType();
    imageProperties.setDescription( description );
    
    if( imageId != null ) {
      imageProperties.setId( imageId );
    }
    
    // Set the Properties of the Policy Template    
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();   
    
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry( Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ImageArtifactProperties(),
                                          imageProperties );
    properties.getAny().add( e );   
    
    artifactTemplate.setProperties( properties );
    
    artifactTemplate.setId( nodeName + "Image" );
    
    // Add the new Artifact Template to the TOSCA Definitions element
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
       
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          model.getDocumentRoot().getDefinitions().getArtifactTemplate().add( artifactTemplate );
          
        }
      } );

  }
}
