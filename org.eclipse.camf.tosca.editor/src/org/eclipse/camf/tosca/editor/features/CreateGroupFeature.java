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

import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateGroupFeature extends AbstractCreateFeature {
  
  private Object contextObject = null;

  public CreateGroupFeature( IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Component Group", "Create Group" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  // Checks if user can create a group component object in the target
  // business object
  @Override
  public boolean canCreate( ICreateContext context ) {
    // return context.getTargetContainer() instanceof TServiceTemplate;
    return true;
  }
  
  public void setContextObject (final Object obj) {
    this.contextObject = obj;
  }

  // Creates the business object for the group component
  @Override
  public Object[] create( ICreateContext context ) {
    
    if (this.contextObject == null) {
      return null;
    }
    // create substitutableNodeType
    TServiceTemplateExtension tService = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTServiceTemplateExtension();
    
    String id = "G" + ( ( Integer )tService.hashCode() ).toString();
    
    //set the Service Template as substitutable so that it can be composed into another Service Template   
    QName qname = new QName("substituteNode");
    tService.setSubstitutableNodeType( qname );
    tService.setId( id );
    
    //Set X and Y required for reloading tosca model in tosca editor
    tService.setX(context.getX());
    tService.setY(context.getY());
    
    //Add substituted node type to parent Service Template
    TServiceTemplate parentServiceTemplate = (TServiceTemplate) getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    
    TNodeTemplateExtension newNodeTemplate = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
    newNodeTemplate.setType( qname );
    
    //newNodeTemplate.setId( "G" + ( ( Integer )newNodeTemplate.hashCode() ).toString() );    
    newNodeTemplate.setId( id );   
    
    parentServiceTemplate.getTopologyTemplate().getNodeTemplate().add( newNodeTemplate );  
    
    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    model.getDocumentRoot()
      .getDefinitions()
      .getServiceTemplate()
      .add( tService );
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
