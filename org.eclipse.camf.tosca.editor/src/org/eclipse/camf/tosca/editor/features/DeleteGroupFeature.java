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

import org.eclipse.camf.tosca.TNodeTemplate;
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


public class DeleteGroupFeature extends DefaultDeleteFeature {

  public DeleteGroupFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }

    @Override
    public boolean canDelete(IDeleteContext context) {
        // TODO Auto-generated method stub
        
        TServiceTemplate deletedObject = (TServiceTemplate) getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
        
        if (deletedObject.getSubstitutableNodeType() == null)
            return false;
        
        return true;
    }
    
  @Override
  public void preDelete(IDeleteContext context) {
    
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    TServiceTemplate deletedServiceTemplate = (TServiceTemplate) deletedObject;

    
//    // Delete Policy Templates

//
//    for( TPolicy tempPolicy : deletedNodeTemplate.getPolicies().getPolicy() )
//      for( TPolicyTemplate tempPolicyTemplate : model.getDocumentRoot()
//        .getDefinitions()
//        .getPolicyTemplate() )
//      {
//        if( tempPolicy.getPolicyRef()
//          .toString()
//          .compareTo( tempPolicyTemplate.getId() ) == 0 )
//        {
//          model.getDocumentRoot()
//            .getDefinitions()
//            .getPolicyTemplate()
//            .remove( tempPolicyTemplate );
//        }
//      }
    
    
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
            .compareTo( deletedServiceTemplate.getId() ) == 0
              || tempRelationshipTemplate.getTargetElement()
                .getRef()
                .compareTo( deletedServiceTemplate.getId() ) == 0 )
          {
            tempServiceTemplate.getTopologyTemplate()
              .getRelationshipTemplate()
              .remove( tempRelationshipTemplate );
          }
        }
      }
    }
   
    
    // Find the substitute TNodeTemplate
    TNodeTemplate substituteNode = null;

    for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .get( 0 )
      .getTopologyTemplate()
      .getNodeTemplate()){
       
      if (tempNodeTemplate.getId() ==  deletedServiceTemplate.getId() )
      {
        substituteNode = tempNodeTemplate;
        break;
      }
    }
    
    // Delete the substitute TNodeTemplate
    model.getDocumentRoot()
    .getDefinitions()
    .getServiceTemplate()
    .get( 0 )
    .getTopologyTemplate()
    .getNodeTemplate().remove( substituteNode );
    

    
  }
}
