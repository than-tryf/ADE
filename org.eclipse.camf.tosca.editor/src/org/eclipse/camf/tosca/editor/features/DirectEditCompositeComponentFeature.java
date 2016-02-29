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

import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.AbstractDirectEditingFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public class DirectEditCompositeComponentFeature
  extends AbstractDirectEditingFeature
{

  public DirectEditCompositeComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  public int getEditingType() {
    // there are several possible editor-types supported:
    // text-field, checkbox, color-chooser, combobox, ...
    return TYPE_TEXT;
  }

  @Override
  public boolean canDirectEdit( final IDirectEditingContext context ) {
    PictogramElement pe = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pe );
    GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
    // support direct editing, if it is a EClass, and the user clicked
    // directly on the text and not somewhere else in the rectangle
    if( bo instanceof TServiceTemplate && ga instanceof Text ) {
      return true;
    }
    // direct editing not supported in all other cases
    return false;
  }

  @Override
  public String getInitialValue( final IDirectEditingContext context ) {
    // return the current name of the EClass
    PictogramElement pe = context.getPictogramElement();
    TServiceTemplate tService = ( TServiceTemplate )getBusinessObjectForPictogramElement( pe );
    return tService.getName();
  }

  @Override
  public String checkValueValid( final String value,
                                 final IDirectEditingContext context )
  {
    if( value.length() < 1 )
      return "Please enter any text as class name."; //$NON-NLS-1$
    if( value.contains( " " ) ) //$NON-NLS-1$
      return "Spaces are not allowed in class names."; //$NON-NLS-1$
    if( value.contains( "\n" ) ) //$NON-NLS-1$
      return "Line breakes are not allowed in class names."; //$NON-NLS-1$
    // null means, that the value is valid
    return null;
  }

  @Override
  public void setValue( final String value, final IDirectEditingContext context )
  {
    // set the new name for the EClass
    PictogramElement pe = context.getPictogramElement();
    TServiceTemplate tService = ( TServiceTemplate )getBusinessObjectForPictogramElement( pe );
    tService.setName( value );
    // Explicitly update the shape to display the new value in the diagram
    // Note, that this might not be necessary in future versions of Graphiti
    // (currently in discussion)
    // we know, that pe is the Shape of the Text, so its container is the
    // main shape of the EClass
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    tService.setSubstitutableNodeType(new QName("substituteNode_"+value));
    
    // Find the substitute TNodeTemplate
    TNodeTemplate substituteNode = null;
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .get( 0 )
      .getTopologyTemplate()
      .getNodeTemplate()){
       
      if (tempNodeTemplate.getId() ==  tService.getId() )
      {
        substituteNode = tempNodeTemplate;
        break;
      }

    }
    
    substituteNode.setType(new QName("substituteNode_"+value));
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    updatePictogramElement( ( ( Shape )pe ).getContainer() );
  }
}
