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

import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;

public class CreateUserApplicationFeature extends AbstractCreateFeature {

  private Object contextObject = null;

  public CreateUserApplicationFeature( final IFeatureProvider fp ) {
    // set name and description of the creation feature
    super( fp, "User Application", "Create User Application" ); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public void setContextObject( final Object obj ) {
    this.contextObject = obj;
  }

  // Checks if user can create a user application object in the target
  // business object
  @Override
  public boolean canCreate( final ICreateContext context ) {
    if( context.getTargetContainer() instanceof Diagram )
      return false;
    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
    if( parentBo instanceof TNodeTemplate ) {
      return true;
    }
    return false;
  }

  // Creates the business object for the user application
  @Override
  public Object[] create( final ICreateContext context ) {
	  
	  
	    if( this.contextObject == null )
	        return null;

	      Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
	      TNodeTemplate tNode = null;
	      if( parentObject == null )
	        return null;
	      if( parentObject instanceof TNodeTemplate ) {
	        tNode = ( TNodeTemplate )parentObject;
	      }

	       if (tNode.getName()==null){
             MessageDialog.openError(null, "Error", "Give a Name to the selected Component and try again.");
             return null;
	       }

	      if( tNode.getDeploymentArtifacts() == null ) {
	        
	        final TNodeTemplate node = tNode;
	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	        editingDomain.getCommandStack()
	          .execute( new RecordingCommand( editingDomain ) {

	            protected void doExecute() {
	              node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
	            }
	          } );
	        
	        
	      } 
	      
	      
	      // Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = tNode.getDeploymentArtifacts();
	      TDeploymentArtifact tempDeploymentArtifact = ( TDeploymentArtifact )this.contextObject;
	      
	      TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( tempDeploymentArtifact.getName() );
	      deploymentArtifact.setArtifactType( tempDeploymentArtifact.getArtifactType() );
      
	      
	          
	      final TDeploymentArtifact tempArtifact = deploymentArtifact;
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( tempArtifact );
	          }
	        } );
	      
	      //addGraphicalRepresentation( context, vmi );
	      
	      /////////////////////////////////////////////
	      addGraphicalRepresentation( context, deploymentArtifact );
	      /////////////////////////////////////////////

	      // activate direct editing after object creation
	      getFeatureProvider().getDirectEditingInfo().setActive( true );
	      // return newly created business object(s)
	      return new Object[]{
	        deploymentArtifact
	      };

  }
}
