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

import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.editor.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class AddBidirectionalRelationFeature extends AbstractAddFeature {

  public AddBidirectionalRelationFeature( IFeatureProvider fp ) {
    super( fp );
  }

  // check if user can add a TRelationshipTemplate to the target object
  @Override
  public boolean canAdd( IAddContext context ) {
    if( context instanceof IAddConnectionContext
        && context.getNewObject() instanceof TRelationshipTemplate )
    {
      return true;
    }
    return false;
  }

  // Adds a relationship figure to the target object
  @Override
  public PictogramElement add( IAddContext context ) {
    IAddConnectionContext addConContext = ( IAddConnectionContext )context;
    TRelationshipTemplate addedEReference = ( TRelationshipTemplate )context.getNewObject();
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    // CONNECTION WITH POLYLINE
    Connection connection = peCreateService.createFreeFormConnection( getDiagram() );
    connection.setStart( addConContext.getSourceAnchor() );
    connection.setEnd( addConContext.getTargetAnchor() );
    IGaService gaService = Graphiti.getGaService();
    Polyline polyline = gaService.createPlainPolyline( connection );
    polyline.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    // create link and wire it
    link( connection, addedEReference );
    
//    // add dynamic text decorator for the reference name
//    ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator( connection,
//                                                                                   true,
//                                                                                   0.5,
//                                                                                   true );
//    Text text = gaService.createPlainText( textDecorator );
//    text.setStyle( StyleUtil.getStyleForTextDecorator( ( getDiagram() ) ) );
//    gaService.setLocation( text, 10, 0 );
//    // set reference name in the text decorator
//    TRelationshipTemplate eReference = ( TRelationshipTemplate )context.getNewObject();
//    text.setValue( eReference.getName() );
    
    // add static graphical decorators (composition and navigable)
    
    ConnectionDecorator cd;
    cd = peCreateService.createConnectionDecorator( connection,
                                                    false,
                                                    1.0,
                                                    true );
    createArrow( cd );
    ConnectionDecorator cd2;
    cd2 = peCreateService.createConnectionDecorator( connection, false, 0, true );
    createInverseArrow( cd2 );
    return connection;
  }

  private Polyline createArrow( GraphicsAlgorithmContainer gaContainer ) {
    Polyline polyline = Graphiti.getGaCreateService()
      .createPlainPolyline( gaContainer, new int[]{
        -15, 10, 0, 0, -15, -10
      } );
    polyline.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    return polyline;
  }

  private Polyline createInverseArrow( GraphicsAlgorithmContainer gaContainer )
  {
    Polyline polyline = Graphiti.getGaCreateService()
      .createPlainPolyline( gaContainer, new int[]{
        -15, -10, 0, 0, -15, 10
      } );
    polyline.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    return polyline;
  }
}
