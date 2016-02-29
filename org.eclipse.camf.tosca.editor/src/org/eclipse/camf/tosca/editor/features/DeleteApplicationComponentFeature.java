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

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TImplementationArtifact;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.TPolicy;
import org.eclipse.camf.tosca.TPolicyTemplate;
import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeleteApplicationComponentFeature extends DefaultDeleteFeature {

	  public DeleteApplicationComponentFeature( IFeatureProvider fp ) {
	    super( fp );
	    // TODO Auto-generated constructor stub
	  }

	  @Override
	  public void preDelete( IDeleteContext context ) {
	    // Removes the relationships related to the deleted application component
	    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
	    
	    
	    TNodeTemplate deletedNodeTemplate = ( TNodeTemplate )deletedObject;
	    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
	    // Delete Policy Templates
	    if ( deletedNodeTemplate.getPolicies() != null )
	    {
	      for( TPolicy tempPolicy : deletedNodeTemplate.getPolicies().getPolicy() )
	        for( TPolicyTemplate tempPolicyTemplate : model.getDocumentRoot()
	          .getDefinitions()
	          .getPolicyTemplate() )
	        {
	          if( tempPolicy.getPolicyRef()
	            .toString()
	            .compareTo( tempPolicyTemplate.getId() ) == 0 )
	          {
	            model.getDocumentRoot()
	              .getDefinitions()
	              .getPolicyTemplate()
	              .remove( tempPolicyTemplate );
	          }
	        }
	    }
	    // Delete Relationships
	    for( TServiceTemplate tempServiceTemplate : model.getDocumentRoot()
	      .getDefinitions()
	      .getServiceTemplate() )
	    {
	      if ( tempServiceTemplate.getTopologyTemplate() != null ){
	        for( TRelationshipTemplate tempRelationshipTemplate : tempServiceTemplate.getTopologyTemplate()
	          .getRelationshipTemplate() )
	        {
	          if( tempRelationshipTemplate.getSourceElement()
	            .getRef()
	            .compareTo( deletedNodeTemplate.getId() ) == 0
	              || tempRelationshipTemplate.getTargetElement()
	                .getRef()
	                .compareTo( deletedNodeTemplate.getId() ) == 0 )
	          {
	            tempServiceTemplate.getTopologyTemplate()
	              .getRelationshipTemplate()
	              .remove( tempRelationshipTemplate );
	          }
	        }
	      }
	    }
	    //Delete NodeTypeImplementations
	    if (model.getDocumentRoot()
	        .getDefinitions()
	        .getNodeTypeImplementation() != null){
	    QName[] artifactTemplatesIDs = new QName[1];
	    for( TNodeTypeImplementation tempNodeTypeImplementation : model.getDocumentRoot()
	        .getDefinitions()
	        .getNodeTypeImplementation() )
	      {
	        if ( tempNodeTypeImplementation.getNodeType().toString().equals( deletedNodeTemplate.getName()) ){
	          //Find Artifact Templates to be Deleted
	          {
	            for (TImplementationArtifact tempImplementationArtifact: tempNodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact()){
	              artifactTemplatesIDs[artifactTemplatesIDs.length-1]=tempImplementationArtifact.getArtifactRef();
	            }
	          }
	          //Delete NodeTypeImplementation
	            {
	              model.getDocumentRoot()
	              .getDefinitions()
	              .getNodeTypeImplementation()
	                .remove( tempNodeTypeImplementation );
	            }
	          } 
	      }
	    
	    //Find DeploymentArtifacts to be deleted
	    if (deletedNodeTemplate.getDeploymentArtifacts() != null){
	      for (TDeploymentArtifact tempDeploymentArtifact: deletedNodeTemplate.getDeploymentArtifacts().getDeploymentArtifact()){
	        artifactTemplatesIDs[artifactTemplatesIDs.length-1]=tempDeploymentArtifact.getArtifactRef();
	      }
	    }
	    
	    //Delete ArtifactTemplates
	    for( TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot()
	        .getDefinitions().getArtifactTemplate()){
	      for (QName tempArtifactTemplateID : artifactTemplatesIDs){
	        if (tempArtifactTemplateID != null && tempArtifactTemplate.getId().equals( tempArtifactTemplateID.toString() )){
	          //Delete Artifact Template
	          {
	            model.getDocumentRoot()
	            .getDefinitions()
	            .getArtifactTemplate()
	              .remove( tempArtifactTemplate );
	          }
	        }
	      }
	    }
	  }
	  }
	}
