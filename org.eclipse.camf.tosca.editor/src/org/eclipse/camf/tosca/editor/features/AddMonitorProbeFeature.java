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

import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.editor.ImageProvider;
import org.eclipse.camf.tosca.editor.StyleUtil;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class AddMonitorProbeFeature extends AbstractFeature
  implements IAddFeature
{

  public AddMonitorProbeFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  // Checks whether a Monitoring Probe can be added to the target object
  public boolean canAdd( final IAddContext context ) {
    boolean result = false;
    boolean isDiagramInstance = context.getTargetContainer() instanceof Diagram
                                                                               ? true
                                                                               : false;
    if( context.getNewObject() instanceof MonitoringProbe && !isDiagramInstance )
    {
      result = true;
    }
    
    boolean monitoringProbe = false;
    monitoringProbe = context.getNewObject() instanceof TDeploymentArtifact && ((TDeploymentArtifact)context.getNewObject()).getArtifactType().toString().compareTo( "MonitoringProbe" )==0;
  
    if( monitoringProbe && !isDiagramInstance )
    {
      result = true;
    }
    
    return result;
  }

  // No figure for Monitoring Probe required
  @Override
  public PictogramElement add( final IAddContext context ) {
    
    ContainerShape targetDiagram = context.getTargetContainer();
    
    // Check if monitoring icon already exists
    Object[] targetDiagrams = targetDiagram.getChildren().toArray();
    for( int i = 0; i < targetDiagrams.length; i++ ) {
      if( ( ( Shape )targetDiagrams[ i ] ).getGraphicsAlgorithm() instanceof Image )
        return null;
    }
  
    // Add monitoring icon into the target application component
    IPeCreateService peCreateService = Graphiti.getPeCreateService();
    ContainerShape containerShapeImg = peCreateService.createContainerShape( targetDiagram,
                                                                          true );    
    IGaService gaService = Graphiti.getGaService();
    String imageId = ImageProvider.IMG_MONITORING;
    Image image = gaService.createImage( containerShapeImg, imageId );
    gaService.setLocationAndSize( image, StyleUtil.APP_COMPONENT_WIDTH-15, 5, 10, 10 );
    
    containerShapeImg.setVisible( true );
    
    return null;
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
