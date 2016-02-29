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

import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeleteDeploymentArtifactFeature extends DefaultDeleteFeature{
	  
	  private boolean deleteDeploymentArtifact = false;
	  private TNodeTemplate parentNodeTemplate;

	  public DeleteDeploymentArtifactFeature( IFeatureProvider fp ) {
	    super( fp );
	  }
	  
	  @Override
	  public void preDelete(IDeleteContext context) {
	    // Checks whether the node template contained only the deleted deployment artifact  
	     
	    PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( context.getPictogramElement() );
	    
	    TNodeTemplate parentNodeTemplate = ( TNodeTemplate ) getFeatureProvider().getBusinessObjectForPictogramElement( parentPE );
	    
	    if ( parentNodeTemplate.getDeploymentArtifacts().getDeploymentArtifact().size() == 1 ){
	      this.deleteDeploymentArtifact = true;
	      this.parentNodeTemplate = parentNodeTemplate;
	    }
	    
	    //Delete corresponding TArtifactTemplate
	    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
	    TDeploymentArtifact deletedDeploymentArtifact = (TDeploymentArtifact) deletedObject;
	    String deletedDeploymentArtifactId = deletedDeploymentArtifact.getArtifactRef().toString();
	    
	    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
	    
	    for ( TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot().getDefinitions().getArtifactTemplate() ){
	      if (tempArtifactTemplate.getId().compareTo( deletedDeploymentArtifactId )==0){
	        model.getDocumentRoot().getDefinitions().getArtifactTemplate().remove( tempArtifactTemplate );
	      }
	    }
	  }
	  
	  @Override
	  public void postDelete(IDeleteContext context) {
	    // Removes the deployment artifacts element if no more artifacts left 
	     
	    if ( this.deleteDeploymentArtifact == true )
	      this.parentNodeTemplate.setDeploymentArtifacts( null );
	  }

	}