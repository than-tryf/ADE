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

import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.editor.StyleUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class AddUserApplicationFeature extends AbstractFeature
  implements IAddFeature
{

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 255,
                                                                              228,
                                                                              225 );

  public AddUserApplicationFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Software Dependency can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
	  
	    boolean result = false;
	    boolean diagraminstance = context.getTargetContainer() instanceof Diagram;

	    if( context.getNewObject() instanceof TDeploymentArtifact
	        && !diagraminstance )
	    {
	      if (((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "UA" )==0)
	        result = true;
	    }
	    return result;
	    
  }

  // Adds a User Application figure to the target object
  @Override
  public PictogramElement add( final IAddContext context ) {

    TDeploymentArtifact addedClass = ( TDeploymentArtifact )context.getNewObject();
    
    ContainerShape targetDiagram = ( ContainerShape )context.getTargetContainer();
    Object[] targetDiagrams = targetDiagram.getChildren().toArray();
    int ySD = 0;
    int interdist = 0;
    for( int i = 0; i < targetDiagrams.length; i++ ) {
      Object o = getBusinessObjectForPictogramElement( ( Shape )targetDiagrams[ i ] );
      if( o instanceof UserApplication )
        interdist = 3;
    }
    for( int i = 0; i < targetDiagrams.length; i++ ) {
      Object o = getBusinessObjectForPictogramElement( ( Shape )targetDiagrams[ i ] );
      if( ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm() instanceof Rectangle
          || ( o instanceof SoftwareDependency ) )
      {
        if( ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm() instanceof Rectangle )
        {
          ySD = ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm().getY();
        }
        ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm()
          .setY( ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm().getY()
                 + 20
                 + interdist );
      }
    }
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                          true );
    final int width = StyleUtil.SOFT_DEPENDENCY_WIDTH;
    final int height = 20;
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle;
    {
      // create and set graphics algorithm
      int x = ( StyleUtil.APP_COMPONENT_WIDTH - width ) / 2;
      roundedRectangle = gaService.createRoundedRectangle( containerShape, 5, 5 );
      roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
      roundedRectangle.setLineWidth( 2 );
      gaService.setLocationAndSize( roundedRectangle,
                                    x,
                                    ySD - 10 + interdist,
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
    }
    return containerShape;
  }

  @Override
  public boolean canExecute( final IContext context ) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void execute( final IContext context ) {
    // TODO Auto-generated method stub
  }
}
