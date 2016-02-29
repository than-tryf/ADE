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

import org.eclipse.camf.tosca.editor.StyleUtil;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;


public class ResizeApplicationComponentFeature extends DefaultResizeShapeFeature{

  public ResizeApplicationComponentFeature( IFeatureProvider fp ) {
    super( fp );
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public boolean canResizeShape(IResizeShapeContext context) {

     return true;
    
  }
  
  @Override
  public void resizeShape(IResizeShapeContext context) {
    Shape shape = context.getShape();
    int x = context.getX();
    int y = context.getY();
    
    //Application Component Width cannot be changed
    int width = StyleUtil.APP_COMPONENT_WIDTH;
    
    int height = context.getHeight();

    if (shape.getGraphicsAlgorithm() != null) {
        Graphiti.getGaService().setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, width, height);
    }

    
    layoutPictogramElement(shape);
    
    TNodeTemplateExtension applicationComponent = (TNodeTemplateExtension) getBusinessObjectForPictogramElement( shape );
    applicationComponent.setX(x);
    applicationComponent.setY(y);
    applicationComponent.setWidth( width );
    applicationComponent.setHeight( height );
    
        
}
}
