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

import java.io.File;

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.ArtifactReferencesType;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.ImplementationArtifactType;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TImplementationArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
//import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;

public class CreateSoftwareDependencyFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateSoftwareDependencyFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Software Dependency", "Software Dependency" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a software dependency object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram ){
      return false;
    }
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the software dependency
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
	        
	        final TNodeTemplate node = tNode;
	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	        editingDomain.getCommandStack()
	          .execute( new RecordingCommand( editingDomain ) {

	            protected void doExecute() {
	              node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
	            }
	          } );
	        
	      } 
	            
	      
	      // Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
	      TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
	      
	      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( tempDeploymentArtifact.getName() );
	      deploymentArtifact.setArtifactType( tempDeploymentArtifact.getArtifactType() );
	      deploymentArtifact.setArtifactRef( new QName (tNode.getName() + "Script" ));
	          
	      final TDeploymentArtifact tempArtifact = deploymentArtifact;
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( tempArtifact );
	          }
	        } );
	      
//	      ImplementationArtifactType tempImplementationArtifact = (ImplementationArtifactType) this.contextObject;
//
//	       //Create Image Artifact Template
//	       createArtifactTemplate(tNode.getName(), tempImplementationArtifact.getArtifactType().toString());
//	       
//	       //Create Implementation Artifact
//	       ImplementationArtifactType implementationArtifact = createImplementationArtifact( tNode.getName()+"Script", tempImplementationArtifact.getArtifactType(), new QName(tNode.getName()+"Script"));
//	       
//        addGraphicalRepresentation( context, implementationArtifact );
//
//
//       // activate direct editing after object creation
//       getFeatureProvider().getDirectEditingInfo().setActive( true );
//       // return newly created business object(s)
//       return new Object[]{
//         implementationArtifact
//       };
	      
	      addGraphicalRepresentation( context, deploymentArtifact );

	      //Create Image Artifact Template
	      createArtifactTemplate(tNode.getName(), tempDeploymentArtifact.getName());
	      
	      //Create Implementation Artifact
	      createImplementationArtifact( tempDeploymentArtifact.getName(), new QName(tNode.getName()), new QName(tNode.getName()+"Script"));

	      // activate direct editing after object creation
	      getFeatureProvider().getDirectEditingInfo().setActive( true );
	      // return newly created business object(s)
	      return new Object[]{
	        deploymentArtifact
	      };

  }
  
  private void createArtifactTemplate(String nodeName, String artifactName){
    
    //Create Artifact Template
    final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
    
    //Create Script Artifact Properties
    ScriptArtifactPropertiesType scriptProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createScriptArtifactPropertiesType();
    scriptProperties.setLanguage( "Shell" );
    
    // Set the Properties of the Policy Template    
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();   
    
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry(     Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ScriptArtifactProperties(),  scriptProperties );
    properties.getAny().add( e );      
    
    artifactTemplate.setProperties( properties );
    
    artifactTemplate.setId( nodeName + "Script" );
    
    
    // Set artifact ref
    TArtifactReference artifactRef = ToscaFactory.eINSTANCE.createTArtifactReference();
    artifactRef.setReference( "Scripts"+ File.separator + artifactName);

    ArtifactReferencesType artifactRefType = ToscaFactory.eINSTANCE.createArtifactReferencesType();
    artifactRefType.getArtifactReference().add( artifactRef );
    
    artifactTemplate.setArtifactReferences( artifactRefType );
    
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
  
  
  //Creates the install implementation artifact
  private ImplementationArtifactType createImplementationArtifact(String artifactName, QName nodeType, QName artifactID){
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    final DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
    
    TNodeTypeImplementation nodeTypeImplementation = null;
    
    //Test if NodeTypeImplementation for nodeType already exists
    for ( TNodeTypeImplementation tempNodeTypeImplementation : definitions.getNodeTypeImplementation() ){
      if ( tempNodeTypeImplementation.getNodeType().toString().equals(nodeType.toString()) ){
        //NodeTypeImplementation already exists
        //We are going to add the artifact to the existing implementation
        nodeTypeImplementation = tempNodeTypeImplementation;
      }
    }
    
    if ( nodeTypeImplementation == null ){
      //NodeTypeImplementation does not exists
      final TNodeTypeImplementation newNodeTypeImplementation = ToscaFactory.eINSTANCE.createTNodeTypeImplementation();
      newNodeTypeImplementation.setNodeType( nodeType );
      TImplementationArtifacts implementationArtifacts = ToscaFactory.eINSTANCE.createTImplementationArtifacts();
      newNodeTypeImplementation.setImplementationArtifacts( implementationArtifacts );
      
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          @Override
          protected void doExecute() {
            definitions.getNodeTypeImplementation().add( newNodeTypeImplementation );
            
          }
        } );
      nodeTypeImplementation = newNodeTypeImplementation;
    }

    //Create Implementation Artifact
    final ImplementationArtifactType installArtifactType = ToscaFactory.eINSTANCE.createImplementationArtifactType();
    installArtifactType.setArtifactType( new QName("ScriptArtifact") );
    installArtifactType.setArtifactRef( artifactID );
    installArtifactType.setInterfaceName( "Lifecycle" );
    installArtifactType.setOperationName( "execute" );
    
    final TNodeTypeImplementation nodeImplementation = nodeTypeImplementation;
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          nodeImplementation.getImplementationArtifacts().getImplementationArtifact().add( installArtifactType );
          
        }
      } );    

    return installArtifactType;
  }
}
