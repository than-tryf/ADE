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

import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.PoliciesType;
import org.eclipse.camf.tosca.PoliciesType1;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TPolicy;
import org.eclipse.camf.tosca.TPolicyTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.camf.tosca.elementCreators.CreateArtifactTemplate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

public class CreateResizeActionFeature extends AbstractCreateFeature {

	  private Object contextObject = null;

	  public CreateResizeActionFeature( final IFeatureProvider fp ) {
	    // set name and description of the creation feature
	    super( fp, "Resizing Action", "Resizing Action" ); //$NON-NLS-1$ //$NON-NLS-2$
	  }

	  public void setContextObject( final Object obj ) {
	    this.contextObject = obj;
	  }

	  // Checks if user can create an elasticity action object in the target
	  // business object
	  @Override
	  public boolean canCreate( final ICreateContext context ) {
	    Object parentBo = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
	    if( parentBo instanceof TNodeTemplate || parentBo instanceof TServiceTemplate ) {
	      return true;
	    }
	    return false;
	  }

	  // Creates the business object for the elasticity action
	  @Override
	  public Object[] create( final ICreateContext context ) {
	    // MessageConsole myConsole = findConsole("MyConsole");
	    // MessageConsoleStream out = myConsole.newMessageStream();
	    if( this.contextObject == null )
	      return null;
	    
	    String level = null;
	    
	    ResizingAction ra = ( ResizingAction )this.contextObject;
	    
	    CreateArtifactTemplate artTempl = new CreateArtifactTemplate(ra.getName(), new QName("RA"), ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) ));
	    
	    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );

	    if( parentObject == null )
	      return null;
	    
	    TNodeTemplate tNode = null;
	    TServiceTemplate tService = null;
	    
	    // Application Component
	    if( parentObject instanceof TNodeTemplate ) {
	      level = "C";
	      tNode = ( TNodeTemplate )parentObject;
	      
	      if (tNode.getName()==null){
	        MessageDialog.openError(null, "Error", "Give a Name to the selected Component and try again.");
	        return null;
	      }
	    }
	    
	    else if ( parentObject instanceof TServiceTemplate ){
	      level = "G";
	      tService = ( TServiceTemplate )parentObject;
	      if (tService.getSubstitutableNodeType() != null){
	     // Composite Application Component
	     
	      // Find the substitute TNodeTemplate
	      TNodeTemplate substituteNode = null;
	      ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
	      for (TNodeTemplate tempNodeTemplate : model.getDocumentRoot()
	        .getDefinitions()
	        .getServiceTemplate()
	        .get( 0 )
	        .getTopologyTemplate()
	        .getNodeTemplate()){
	           
	        if ( tempNodeTemplate.getId().toString().equals( tService.getId().toString()) )
	        {
	          substituteNode = tempNodeTemplate;
	          break;
	        }
	                 
	      }
	                  
	      tNode = substituteNode;
	      

	        
	      }
	      else{
	     // Application
	        
	        level = "A";
	        final TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )( ( ( TServiceTemplate )parentObject ).getBoundaryDefinitions() );        
	        
	        
	        if ( boundaryDef.getPolicies() == null ){
	          
	          final PoliciesType1 boundaryPolicies = ToscaFactory.eINSTANCE.createPoliciesType1();
	          
	          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	          editingDomain.getCommandStack()
	            .execute( new RecordingCommand( editingDomain ) {

	              @Override
	              protected void doExecute() {
	                boundaryDef.setPolicies( boundaryPolicies );
	              }
	            } );
	          
	         
	        }
	        
	        PoliciesType1 nodePolicyList = boundaryDef.getPolicies();
	        
	        final EList<TPolicy> policy = nodePolicyList.getPolicy();
	        
	        final TPolicy newPolicy = createNewPolicy(level, ra.getName());
	        
//	        final TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
//	        
//	        final String policyUniqueName = "G" + policy.size();
//	        
//	        newPolicy.setPolicyType( new QName("SYBLStrategy") );          
//	        
////	        newPolicy.setName( "S" + policyUniqueName + ":STRATEGY " + ra.getName() );
	//
//	        newPolicy.setName( "STRATEGY " + ra.getName() );
	        
	        
	        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	        editingDomain.getCommandStack()
	          .execute( new RecordingCommand( editingDomain ) {

	            @Override
	            protected void doExecute() {
	              policy.add( newPolicy );
	            }
	          } );
	        
	        return new Object[]{
	          newPolicy
	        };
	      }
	        
	    }

	    
	    final TNodeTemplate nodeTemplate = tNode;
	    
	    if ( nodeTemplate.getPolicies() == null ){
	      final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE.createPoliciesType();
	      
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          @Override
	          protected void doExecute() {
	            nodeTemplate.setPolicies( nodePolicyList );
	          }
	        } );
	      
	     
	    }
	    
	    final EList<TPolicy> policy = nodeTemplate.getPolicies().getPolicy();
	    
	    final TPolicy newPolicy = createNewPolicy(level, ra.getName());
	    
//	    final TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
	//    
//	    final String policyUniqueName = nodeTemplate.getId() + policy.size();
	//    
//	    newPolicy.setPolicyType( new QName("SYBLStrategy") );         
	//    
////	    newPolicy.setName( "S" + policyUniqueName + ":STRATEGY " + ra.getName() );
//	    newPolicy.setName( "STRATEGY " + ra.getName() );
	    
	    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	    editingDomain.getCommandStack()
	      .execute( new RecordingCommand( editingDomain ) {

	        @Override
	        protected void doExecute() {
	          policy.add( newPolicy );
	        }
	      } );
	    
	    
	    // do the add
	    addGraphicalRepresentation( context, ra );
	    // activate direct editing after object creation
	    getFeatureProvider().getDirectEditingInfo().setActive( true );
	    // return newly created business object(s)
	    return new Object[]{
	      newPolicy
	    };
	  }

	  //level can be "C" for Application Component, "G" for Composite Component, "A" for Application
	  TPolicy createNewPolicy(String level, String policyName){

	    // Create Policy Template 
	    
	    final TPolicyTemplate newPolicyTemplate = ToscaFactory.eINSTANCE.createTPolicyTemplate();
	    
	    QName policyTypeName = new QName( "http://www.example.org/SYBL", "Strategy" );
	    
	    newPolicyTemplate.setType( policyTypeName );
	    
	    String id = level + ( ( Integer )newPolicyTemplate.hashCode() ).toString();
	    
	    newPolicyTemplate.setId( id );
	    
	    // Add the new Policy Template to the TOSCA Definitions element
	    
	    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
	    
	    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
	    
	    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
	    editingDomain.getCommandStack()
	      .execute( new RecordingCommand( editingDomain ) {

	        @Override
	        protected void doExecute() {
	          model.getDocumentRoot().getDefinitions().getPolicyTemplate().add( newPolicyTemplate );
	        }
	      } );
	    
	    // Assign the created Policy Template to the new Policy
	    
	    TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
	    
	    QName qnamePolicyTemplate = new QName( newPolicyTemplate.getId() );
	    
	    newPolicy.setPolicyType( policyTypeName );  
	    
	    newPolicy.setPolicyRef( qnamePolicyTemplate );
	    
	    newPolicy.setName( "STRATEGY " + policyName );
	    
	    return newPolicy;
	  }
	  
	}