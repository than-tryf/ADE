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
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

//Tests whether a service template can be moved
public class MoveCompositeComponentFeature extends DefaultMoveShapeFeature {

  public MoveCompositeComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public boolean canMoveShape( final IMoveShapeContext context ) {
    
    boolean canMove = super.canMoveShape( context );
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TServiceTemplate ) {
      if (((TServiceTemplate) bo).getSubstitutableNodeType() != null && ((TServiceTemplate) bo).getSubstitutableNodeType().toString().equals( "substituteNode" )){
        //it is a Group feature
        canMove = true;
      }else{
        //it is the application service
        canMove = true;
      }
    }

    return canMove;
    
  }
  
  @Override
  protected void postMoveShape(IMoveShapeContext context) {
              
    Shape shape = context.getShape();
    TServiceTemplateExtension groupComponent = (TServiceTemplateExtension) getBusinessObjectForPictogramElement( shape );
    groupComponent.setX(context.getX());
    groupComponent.setY(context.getY());


  }
}
