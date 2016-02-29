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

import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateServiceTemplateFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateServiceTemplateFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Service Template", "Add a Service Template" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if a service template business object can be created
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return true;
    return false;
  }

  // Creates the business object for the service template
  @Override
  public Object[] create( final ICreateContext context ) {
    
    if (this.contextObject == null) {
      return null;
    }
    
    TServiceTemplateExtension tService = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTServiceTemplateExtension();  
    
    // Add object to domain model
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .add( tService );

    // Add object to diagram model
    //getDiagram().eResource().getContents().add(tService);
    
    
    // do the add
    addGraphicalRepresentation( context, tService );
    // activate direct editing after object creation
    getFeatureProvider().getDirectEditingInfo().setActive( true );
    // return newly created business object(s)
    return new Object[]{
      tService
    };
  }
}
