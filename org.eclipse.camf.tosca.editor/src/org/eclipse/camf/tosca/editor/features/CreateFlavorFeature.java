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

import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public class CreateFlavorFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateFlavorFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "Flavor", "Flavor" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a monitoring probe object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplateExtension
        || parentBo instanceof TServiceTemplateExtension )
    {
      return true;
    }
    return false;
  }
  
  // Creates the business object for the Monitoring Probe
  @Override
  public Object[] create( final ICreateContext context ) {
    if( this.contextObject == null )
      return null;
    
    NodePropertiesType nodeProperties = ( NodePropertiesType ) this.contextObject;

    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    
    final TNodeTemplate tNode;
    final PropertiesType properties;
    
    if( parentObject == null )
      return null;
    
    if( parentObject instanceof TNodeTemplate ) {
      tNode = ( TNodeTemplate ) parentObject;
      
      Entry e = null;
      if( tNode.getProperties() == null ) {
        // Set the Properties of the Policy Template
        properties = ToscaFactory.eINSTANCE.createPropertiesType();
        // Add the SYBL Policy to the FeatureMap of the Policy's Properties
        // element
        e = FeatureMapUtil.createEntry( Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_NodeProperties(),
                                        nodeProperties );
      } else {
        properties = tNode.getProperties();
      }
      properties.getAny().add( e );
      
      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( tNode );
      editingDomain.getCommandStack()
        .execute( new RecordingCommand( editingDomain ) {

          @Override
          protected void doExecute() {
            tNode.setProperties( properties );
          }
        } );

      
      //addGraphicalRepresentation( context, vmi );
      
      /////////////////////////////////////////////
      addGraphicalRepresentation( context, properties );
      /////////////////////////////////////////////

      // activate direct editing after object creation
      getFeatureProvider().getDirectEditingInfo().setActive( true );
    } else {
      tNode = null;
      properties = null;
    }
    
    
    // return newly created business object(s)
    return new Object[]{
      properties
    };
  }


  

}
