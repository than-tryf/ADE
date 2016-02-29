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

import org.eclipse.camf.tosca.SourceElementType;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.TargetElementType;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ImageProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

public class CreateDirectedRelationFeature
  extends AbstractCreateConnectionFeature
{

  public CreateDirectedRelationFeature( IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "", "Create Directional Relation" );
  }

  // Checks if user can create relationship object in the target
  // business object
  @Override
  public boolean canCreate( ICreateConnectionContext context ) {
    // return true if both anchors belong to an object (TNodeTemplate or TServiceTemplate)
    // and those objects are not identical
      
      Object sourceObj = getTAnchorParent(context.getSourceAnchor());
      Object targetObj = getTAnchorParent(context.getTargetAnchor());
         if( sourceObj != null && targetObj != null && sourceObj != targetObj ) {
             return true;
           }
         
    return false;
  }
  
  // Returns the TNodeTemplate or TServiceTemplate belonging to the anchor, or null if not available
  private Object getTAnchorParent( Anchor anchor ) {
      Object obj = null;
    if( anchor != null ) {
      obj = getBusinessObjectForPictogramElement( anchor.getParent() );
    }
    return obj;
  }

  // Creates the business object for the relationship
  @Override
  public Connection create( ICreateConnectionContext context ) {
    Connection newConnection = null;
    
      Object sourceObj = getTAnchorParent(context.getSourceAnchor());
      Object targetObj = getTAnchorParent(context.getTargetAnchor());
      
      if (sourceObj==null || targetObj==null)
          return null;
      
      String sourceID = null, targetID = null;
      
      if (sourceObj instanceof TNodeTemplate){
            // get source TNodeTemplate 
            TNodeTemplate source = (TNodeTemplate) sourceObj;        
            sourceID = source.getId();
      }else if (sourceObj instanceof TServiceTemplate){
            // get TServiceTemplates which should be connected
            TServiceTemplate source = (TServiceTemplate) sourceObj;
            sourceID = source.getId();
      }
          
      if (targetObj instanceof TNodeTemplate){
            // get target TNodeTemplate 
            TNodeTemplate target = (TNodeTemplate) targetObj;        
            targetID = target.getId();
      }else if (targetObj instanceof TServiceTemplate){
            TServiceTemplate target = (TServiceTemplate) targetObj;
            targetID = target.getId();
      }
      

      // create new business object
      TRelationshipTemplate newClass = ToscaFactory.eINSTANCE.createTRelationshipTemplate();
      newClass.setName( "Directed Relation" );
      newClass.setId( ( "R" + ( Integer )newClass.hashCode() ).toString() );
      newClass.setType( new QName("Directed") );
      SourceElementType se = ToscaFactory.eINSTANCE.createSourceElementType();
      se.setRef( sourceID );
      newClass.setSourceElement( se );
      TargetElementType te = ToscaFactory.eINSTANCE.createTargetElementType();
      te.setRef( targetID );
      newClass.setTargetElement( te );

      ContainerShape sourceContainer = ( ContainerShape )context.getSourcePictogramElement();
      Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( sourceContainer.getContainer() );
      TServiceTemplate serviceTemplate = null;
      if( parentObject == null )
        return null;
      if( parentObject instanceof TServiceTemplate ) {
        serviceTemplate = ( TServiceTemplate )parentObject;
      }
      TTopologyTemplate topology = null;
      topology = serviceTemplate.getTopologyTemplate();
      topology.getRelationshipTemplate().add( newClass );
      // add connection for business object
      AddConnectionContext addContext = new AddConnectionContext( context.getSourceAnchor(),
                                                                  context.getTargetAnchor() );
      addContext.setNewObject( newClass );
      newConnection = ( Connection )getFeatureProvider().addIfPossible( addContext );
    
      
    return newConnection;
  }

  @Override
  public boolean canStartConnection( ICreateConnectionContext context ) {
    
    Object sourceObj = getTAnchorParent(context.getSourceAnchor());
    if (sourceObj != null){
        return true;
    }

    return false;
  }
  
  @Override
  public String getCreateImageId() {
    return ImageProvider.IMG_EREFERENCE;
  }
}
