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

public class CreateBidirectionalRelationFeature
  extends AbstractCreateConnectionFeature
{

  public CreateBidirectionalRelationFeature( IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "", "Create Bidirectional Relation" );
  }

  // Checks if user can create relationship object in the target
  // business object
  @Override
  public boolean canCreate( ICreateConnectionContext context ) {
    // return true if both anchors belong to a TNodeTemplate
    // and those TNodeTemplates are not identical
    TNodeTemplate source = getTNodeTemplate( context.getSourceAnchor() );
    TNodeTemplate target = getTNodeTemplate( context.getTargetAnchor() );
    if( source != null && target != null && source != target ) {
      return true;
    }
    return false;
  }

  // Returns the TNodeTemplate belonging to the anchor, or null if not available
  private TNodeTemplate getTNodeTemplate( Anchor anchor ) {
    if( anchor != null ) {
      Object obj = getBusinessObjectForPictogramElement( anchor.getParent() );
      if( obj instanceof TNodeTemplate ) {
        return ( TNodeTemplate )obj;
      }
    }
    return null;
  }

  // Creates the business object for the relationship
  @Override
  public Connection create( ICreateConnectionContext context ) {
    Connection newConnection = null;
    // get TNodeTemplates which should be connected
    TNodeTemplate source = getTNodeTemplate( context.getSourceAnchor() );
    TNodeTemplate target = getTNodeTemplate( context.getTargetAnchor() );
    if( source != null && target != null ) {
      // create new business object
      TRelationshipTemplate newClass = ToscaFactory.eINSTANCE.createTRelationshipTemplate();
      newClass.setName( "Relation" );
      newClass.setId( ( "R" + ( Integer )newClass.hashCode() ).toString() );
      newClass.setType( new QName("Bidirected") );
//      newClass.setType( new QName("Peer - Peer") );
      SourceElementType se = ToscaFactory.eINSTANCE.createSourceElementType();
      se.setRef( source.getId() );
      newClass.setSourceElement( se );
      TargetElementType te = ToscaFactory.eINSTANCE.createTargetElementType();
      te.setRef( target.getId() );
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
    }
    return newConnection;
  }

  @Override
  public boolean canStartConnection( ICreateConnectionContext context ) {
    // return true if start anchor belongs to a TNodeTemplate
    if( getTNodeTemplate( context.getSourceAnchor() ) != null ) {
      return true;
    }
    return false;
  }

  @Override
  public String getCreateImageId() {
    return ImageProvider.IMG_EREFERENCE2;
  }
}
