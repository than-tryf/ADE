
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

import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.editor.StyleUtil;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;

public class AddGroupFeature extends AbstractAddShapeFeature {

      public static final int INVISIBLE_RECT_RIGHT = 6;
      
  public AddGroupFeature( IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Group figure can be added to the target object
  @Override
  public boolean canAdd( IAddContext context ) {
    return true;
  }

  // Adds a group figure to the target object
  @Override
  public PictogramElement add( IAddContext context ) {
    
    int height = context.getHeight();
    int width = context.getWidth();
    
    if (! (height > 0))
      height = StyleUtil.APP_COMPONENT_WIDTH * 2;
    if (! (width > 0))
      width = StyleUtil.APP_COMPONENT_WIDTH * 3;
    
    final TServiceTemplate addedClass = ( TServiceTemplate )context.getNewObject();
    final ContainerShape targetDiagram = context.getTargetContainer();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    final IPeCreateService peCreateService = Graphiti.getPeCreateService();
    final ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                                true );
    final IGaService gaService = Graphiti.getGaService();

    final Rectangle invisibleRectangle;
    
    {
      // create invisible outer rectangle expanded by
      // the width needed for the anchor
      invisibleRectangle = gaService.createInvisibleRectangle( containerShape );
      gaService.setLocationAndSize( invisibleRectangle,
                                    context.getX(),
                                    context.getY(),
                                    width,
                                    height );
      
      invisibleRectangle.setBackground( manageColor( new ColorConstant( 255,
                                                                      255,
                                                                      255 ) ) );
      
      invisibleRectangle.setLineWidth( 1 );
      invisibleRectangle.setLineVisible( true );
      
      
      // if addedClass has no resource we add it to the resource of the diagram
      // in a real scenario the business model would have its own resource
      if( addedClass.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedClass );
      }
      // create link and wire it
      link( containerShape, addedClass );
    }
    
    
    // SHAPE WITH TEXT
    {
      // create shape for text
      final Shape shape = peCreateService.createShape( containerShape, false );
      // create and set text graphics algorithm
      final Text text = gaService.createPlainText( shape, addedClass.getName() );
      
      text.setStyle( StyleUtil.getStyleForTNodeTemplateText( getDiagram() ) );
      gaService.setLocationAndSize( text,
                                    0,
                                    0,
                                    width,
                                    20 );
      // create link and wire it
      link( shape, addedClass );
      final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
      directEditingInfo.setMainPictogramElement( containerShape );
      directEditingInfo.setPictogramElement( shape );
      directEditingInfo.setGraphicsAlgorithm( text );
    }
    
    
    
    
    // add a chopbox anchor to the shape
    peCreateService.createChopboxAnchor( containerShape );
    // create an additional box relative anchor at middle-right
    final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor( containerShape );
    boxAnchor.setRelativeWidth( 1.0 );
    boxAnchor.setRelativeHeight( 0.38 ); // Use golden section
    boxAnchor.setVisible( false );
    // anchor references visible rectangle instead of invisible rectangle
    boxAnchor.setReferencedGraphicsAlgorithm( invisibleRectangle );
    // assign a graphics algorithm for the box relative anchor
    final Ellipse ellipse = gaService.createPlainEllipse( boxAnchor );
    // anchor is located on the right border of the visible rectangle
    // and touches the border of the invisible rectangle
    final int w = INVISIBLE_RECT_RIGHT;
    gaService.setLocationAndSize( ellipse, -w, -w, 2 * w, 2 * w );
    ellipse.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    

    
    // call the layout feature
    layoutPictogramElement( containerShape );
    return containerShape;
    
  }
}

