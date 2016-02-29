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
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AddServiceTemplateFeature extends AbstractAddShapeFeature {

  public static final int INVISIBLE_RECT_RIGHT = 6;
  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 255,
                                                                              250,
                                                                              240 );

  public AddServiceTemplateFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Service Template can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    if( context.getNewObject() instanceof TServiceTemplate
        && context.getTargetContainer() instanceof Diagram )
    {
      result = true;
    }
    return result;
  }

  // Adds a Service Template figure to the diagram
  @Override
  public PictogramElement add( final IAddContext context ) {
    TServiceTemplateExtension addedClass = ( TServiceTemplateExtension )context.getNewObject();
    Diagram targetDiagram = ( Diagram )context.getTargetContainer();
    
    int height = context.getHeight();
    int width = context.getWidth();
    
    if (! (height > 0))
      height = targetDiagram.getGraphicsAlgorithm().getHeight() - 10;
    if (! (width > 0))
      width = targetDiagram.getGraphicsAlgorithm().getWidth() - 10;
    

    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                          true );

    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle; 
    {
      
      
    // create and set visible rectangle inside invisible rectangle
    roundedRectangle = gaService.createPlainRoundedRectangle( containerShape,
                                                              5,
                                                              5 );
    
    // create and set graphics algorithm
    roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
    roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
    roundedRectangle.setLineWidth( 2 );
 
    gaService.setLocationAndSize( roundedRectangle,
                                  5,
                                  5,
                                  width,
                                  height );
      
      if( addedClass.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedClass );
      }
      // create link and wire it
      link( containerShape, addedClass );
    }
    // SHAPE WITH LINE
    {
      // create shape for line
      Shape shape = peCreateService.createShape( containerShape, false );
      // create and set graphics algorithm
      Polyline polyline = gaService.createPolyline( shape, new int[]{
        0, 20, width, 20
      } );
      polyline.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      polyline.setLineWidth( 2 );
    }
    // SHAPE WITH TEXT
    {
      // create shape for text
      Shape shape = peCreateService.createShape( containerShape, false );
      // create and set text graphics algorithm
      Text text = gaService.createText( shape, addedClass.getName() );
      text.setForeground( manageColor( E_CLASS_TEXT_FOREGROUND ) );
      text.setHorizontalAlignment( Orientation.ALIGNMENT_CENTER );
      // vertical alignment has as default value "center"
      text.setFont( gaService.manageDefaultFont( getDiagram(), false, true ) );
      gaService.setLocationAndSize( text, 0, 0, width, 20 );
      // create link and wire it
      link( shape, addedClass );
      
      // provide information to support direct-editing directly
      // after object creation (must be activated additionally)
      final IDirectEditingInfo directEditingInfo = getFeatureProvider().getDirectEditingInfo();
      // set container shape for direct editing after object creation
      directEditingInfo.setMainPictogramElement(containerShape);
      // set shape and graphics algorithm where the editor for
      // direct editing shall be opened after object creation
      directEditingInfo.setPictogramElement(shape);
      directEditingInfo.setGraphicsAlgorithm(text);
    }
    
    return containerShape;
  }
}
