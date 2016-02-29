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

import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.diagram.ToscaFeatureProvider;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
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

public class AddVirtualMachineFeature extends AbstractAddShapeFeature {

  private static final IColorConstant E_CLASS_TEXT_FOREGROUND = IColorConstant.BLACK;
  private static final IColorConstant E_CLASS_FOREGROUND = new ColorConstant( 98,
                                                                              131,
                                                                              167 );
  private static final IColorConstant E_CLASS_BACKGROUND = new ColorConstant( 32,
                                                                              178,
                                                                              170 );

  private String imageType = Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getImageArtifactPropertiesType().getName();

  public AddVirtualMachineFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a VM Image can be added to the target object
  @Override
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean diagraminstance = context.getTargetContainer() instanceof Diagram;
    // if( context.getNewObject() instanceof VirtualMachineImage
    // && !diagraminstance )
    // {
    // result = true;
    // }
    if( context.getNewObject() instanceof TDeploymentArtifact
        && !diagraminstance )
    {
      if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( imageType ) == 0 )
        result = true;
    } else if( context.getNewObject() instanceof VirtualMachineImage ) {
      result = true;
    }
    return result;
  }

  // Adds a VM Image figure to the target object
  @Override
  public PictogramElement add( final IAddContext context ) {
    TDeploymentArtifact addedArtifact;
    VirtualMachineImage vmi = null;
    
    if( context.getNewObject() instanceof VirtualMachineImage ) {
      vmi = ( VirtualMachineImage )context.getNewObject();
      addedArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
      addedArtifact.setName( vmi.getUID() );
      addedArtifact.setArtifactType( new QName( "VMI" ) );
      
      // Call the Create User Application Feature to create a deployment
      // artifact for the deployment script and add it to the artifacts
      // list
      CreateContext createContext = new CreateContext();
      createContext.setTargetContainer( context.getTargetContainer() );
      CreateVMIFeature createKPFeature = new CreateVMIFeature( new ToscaFeatureProvider( getDiagramBehavior().getDiagramContainer()
        .getDiagramTypeProvider() ) );      
      createKPFeature.setContextObject( addedArtifact );
      if( createKPFeature.canCreate( createContext ) ) {
        createKPFeature.create( createContext );
      }
      
    } else {
      addedArtifact = ( TDeploymentArtifact )context.getNewObject();
    }
    
    ContainerShape targetDiagram = ( ContainerShape )context.getTargetContainer();
    int targetContainerHeight = targetDiagram.getGraphicsAlgorithm()
      .getHeight();
    int targetContainerWidth = targetDiagram.getGraphicsAlgorithm().getWidth();
    // CONTAINER SHAPE WITH ROUNDED RECTANGLE
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShape = peCreateService.createContainerShape( targetDiagram,
                                                                          true );
    final int width = targetContainerWidth;
    final int height = 20;
    IGaService gaService = Graphiti.getGaService();
    RoundedRectangle roundedRectangle;
    {
      // create and set graphics algorithm
      roundedRectangle = gaService.createRoundedRectangle( containerShape, 5, 5 );
      roundedRectangle.setForeground( manageColor( E_CLASS_FOREGROUND ) );
      roundedRectangle.setBackground( manageColor( E_CLASS_BACKGROUND ) );
      roundedRectangle.setLineWidth( 2 );
      gaService.setLocationAndSize( roundedRectangle,
                                    0,
                                    targetContainerHeight - 20,
                                    width,
                                    height );
      if( addedArtifact.eResource() == null ) {
        getDiagram().eResource().getContents().add( addedArtifact );
      }
      // create link and wire it
      link( containerShape, addedArtifact );
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
      String name = vmi != null ? vmi.getName() : addedArtifact.getName();
      Text text = gaService.createText( shape, name );
      text.setForeground( manageColor( E_CLASS_TEXT_FOREGROUND ) );
      text.setHorizontalAlignment( Orientation.ALIGNMENT_CENTER );
      // vertical alignment has as default value "center"
      text.setFont( gaService.manageDefaultFont( getDiagram(), false, true ) );
      gaService.setLocationAndSize( text, 0, 0, width, 20 );
      // create link and wire it
      link( shape, addedArtifact );
    }
    // call the layout feature
    layoutPictogramElement( containerShape );
    return containerShape;
  }
}
