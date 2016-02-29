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

import java.math.BigInteger;

import javax.xml.namespace.QName;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateApplicationComponentFeature extends AbstractCreateFeature {
  
  private static int DEFAULT_MIN_INSTANCES = -1;
  
  //-1 means not specified by user
  private static int DEFAULT_MAX_INSTANCES = -1;
  
  private Object contextObject = null;

  public CreateApplicationComponentFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Application Component", "Create an Application Component" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  // Checks if user can create an application component object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return false;
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TServiceTemplate || parentBo instanceof EClass ) {
      return true;
    }
    return false;
  }
  
  public void setContextObject (final Object obj) {
    this.contextObject = obj;
  }
  
  // Creates the business object for the application component
  @Override
  public Object[] create( final ICreateContext context ) {
	    
	    if (this.contextObject == null) {
	      return null;
	    }
	    // create Application Component
	    TNodeTemplateExtension newClass = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
	        
	    //newClass.setYcsbmulti( 1 );
	    //newClass.setCasmulti( 1 );
	    
	    // initialize Application Component
	    // Max or Min instances == 0 => nothing specified by user
	    newClass.setMinInstances( DEFAULT_MIN_INSTANCES );
	    newClass.setMaxInstances(  BigInteger.valueOf( DEFAULT_MAX_INSTANCES ) );
	    newClass.setId( ( "C" + ( Integer )newClass.hashCode() ).toString() );
	    //newClass.setType(((TNodeTemplateExtension) this.contextObject ).getType());
	    
	    //Set X and Y required for reloading tosca model in tosca editor
	    newClass.setX(context.getX());
	    newClass.setY(context.getY());
	    // create the node template
	    ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );    
	    model.getDocumentRoot()
	      .getDefinitions()
	      .getServiceTemplate()
	      .get( 0 )
	      .getTopologyTemplate()
	      .getNodeTemplate()
	      .add( newClass );
	    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
	    TServiceTemplate serviceTemplate = null;
	    if( parentObject == null )
	      return null;
	    if( parentObject instanceof TServiceTemplate ) {
	      serviceTemplate = ( TServiceTemplate )parentObject;
	    }
	    TTopologyTemplate topology = null;
	    if( serviceTemplate.getTopologyTemplate() == null ) {
	      topology = ToscaFactory.eINSTANCE.createTTopologyTemplate();
	      serviceTemplate.setTopologyTemplate( topology );
	    } else {
	      topology = serviceTemplate.getTopologyTemplate();
	    }
	    
	    // Add object to domain model
	    topology.getNodeTemplate().add( newClass );
	        
	    // Add object to diagram model
	    //getDiagram().eResource().getContents().add(newClass);
	    
	    // do the add
	    addGraphicalRepresentation( context, newClass );
	    // activate direct editing after object creation
	    getFeatureProvider().getDirectEditingInfo().setActive( true );
	    // return newly created business object(s)
	    return new Object[]{
	      newClass
	    };
	  }
}
