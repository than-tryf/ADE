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
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class AddApplicationComponentFeature extends AbstractAddShapeFeature {

  public static final int INVISIBLE_RECT_RIGHT = 6;

  public AddApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // check if user can add a TNodeTemplate to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    if( context.getNewObject() instanceof TNodeTemplateExtension ) {
      Object parentObject = getBusinessObjectForPictogramElement( context.getTargetContainer() );
      if( parentObject instanceof TServiceTemplate
          || parentObject instanceof EClass )
      {
        result = true;
      }
    }
    return result;
  }

  // Adds an application component figure to the target object
  @Override
  public PictogramElement add( final IAddContext context ) {
    
    int height = context.getHeight();
    int width = context.getWidth();
    
    if (! (height > 0))
      height = StyleUtil.APP_COMPONENT_HEIGHT;
    if (! (width > 0))
      width = StyleUtil.APP_COMPONENT_WIDTH;
    
    final TNodeTemplateExtension addedClass = ( TNodeTemplateExtension )context.getNewObject();
    final ContainerShape targetDiagram = context.getTargetContainer();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    final IPeCreateService peCreateService = Graphiti.getPeCreateService();
    final ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                                true );
    final IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle;
    {
      // create invisible outer rectangle expanded by
      // the width needed for the anchor
      final Rectangle invisibleRectangle = gaService.createInvisibleRectangle( containerShape );
      gaService.setLocationAndSize( invisibleRectangle,
                                    context.getX(),
                                    context.getY(),
                                    width,
                                    height );
      // create and set visible rectangle inside invisible rectangle
      roundedRectangle = gaService.createPlainRoundedRectangle( invisibleRectangle,
                                                                5,
                                                                5 );
      roundedRectangle.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
      gaService.setLocationAndSize( roundedRectangle,
                                    0,
                                    0,
                                    width,
                                    height );
      
      if( addedClass.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedClass );
      } 
      
      
      // create link and wire it
      link( containerShape, addedClass );
    }
    
    final Shape shapeSD = peCreateService.createShape( containerShape, false );
    shapeSD.setVisible( false );
    final Rectangle roundedRectangleSD = gaService.createPlainRectangle( shapeSD );
    // final Rectangle roundedRectangleSD =
    // gaService.createPlainRectangle(roundedRectangle);
    roundedRectangleSD.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    gaService.setLocationAndSize( roundedRectangleSD,
                                  ( width - StyleUtil.SOFT_DEPENDENCIES_COMP_WIDTH ) / 2,
                                  40,
                                  50,
                                  StyleUtil.SOFT_DEPENDENCIES_COMP_INIT_HEIGHT );

    
    // SHAPE WITH LINE
    {
      // create shape for line
      final Shape shape = peCreateService.createShape( containerShape, false );
      // create and set graphics algorithm
      final Polyline polyline = gaService.createPlainPolyline( shape,
                                                               new int[]{
                                                                 0,
                                                                 20,
                                                                 width,
                                                                 20
                                                               } );
      polyline.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
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
    boxAnchor.setReferencedGraphicsAlgorithm( roundedRectangle );
    // assign a graphics algorithm for the box relative anchor
    final Ellipse ellipse = gaService.createPlainEllipse( boxAnchor );
    // anchor is located on the right border of the visible rectangle
    // and touches the border of the invisible rectangle
    final int w = INVISIBLE_RECT_RIGHT;
    gaService.setLocationAndSize( ellipse, -w, -w, 2 * w, 2 * w );
    ellipse.setStyle( StyleUtil.getStyleForTNodeTemplate( getDiagram() ) );
    // call the layout feature
    layoutPictogramElement( containerShape );
    
    //PictogramElement pic = getFeatureProvider().getPictogramElementForBusinessObject( (TNodeTemplateExtension) addedClass );
    
    return containerShape;
  }
}
