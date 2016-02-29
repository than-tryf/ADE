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
package org.eclipse.camf.tosca.editor.dialog;

/**
 * @author stalo
 */


import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.infosystem.mockup.info.MockUpInfoSystem;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.PoliciesType1;
import org.eclipse.camf.tosca.TBoundaryDefinitions;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.example.sybl.BinaryRestriction;
import org.example.sybl.ConditionType;
import org.example.sybl.LeftHandSideType;
import org.example.sybl.RightHandSideType;
import org.example.sybl.SYBLSpecificationType;
import org.example.sybl.Strategy;
import org.example.sybl.SyblFactory;
import org.example.sybl.ToEnforceType;
import org.example.sybl.UnaryRestriction;

public class ElasticityConditionDialog extends Dialog {


	  private Label lblCondition;
	  private CCombo cmbCondition;
	  private boolean conditionSelected;
	  private Label lblCondition2;
	  private CCombo cmbCondition2;
	  private boolean conditionSelected2;
	  private ToscaModelLayer model;
	  private String condition;

	  
	  protected Text typeText;
	  protected Text valueText;
	  protected boolean editMode = false;
	  protected boolean addMode = false;
	  protected String newType;
	  protected String elasticityRequirement;
	  private CCombo cmbGlobalElasticityReq;
	  private CCombo cmbOperator;
	  private String component;
	  private Label unitLabel;

	  private String unit;

	  private String strategyName;
	  private Label strategyLabel;
	  
	  private String conditionLeft;
	  private String conditionRight;
	  private String conditionOperator;
	  
	  /**
	   * @param parentShell
	   * @param pe 
	   * @param existingDataStage
	   */
	  public ElasticityConditionDialog( final Shell parentShell,  String component,
			  ToscaModelLayer model, String strategyName
	                                        )
	  {
	    super( parentShell );
	    this.conditionSelected = false;
	    this.conditionSelected2 = false;
	    this.model = model;
	    this.component = component;
	    this.strategyName = strategyName;
	  }

	  @Override
	  protected void configureShell( final Shell shell ) {
	    super.configureShell( shell );
	    shell.setText( "Apply Strategy Under Condition" );
	    shell.setSize( 330, 400 );
	 
	  }

	  @Override
	  protected Control createDialogArea( final Composite parent ) {
	    Composite composite = ( Composite )super.createDialogArea( parent );
	    composite.setLayout( new GridLayout( 1, false ) );
	    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

	    this.strategyLabel = new Label( composite, SWT.NONE );
	    this.strategyLabel.setText( this.strategyName );
	    
	    GridData gd = new GridData( GridData.FILL_BOTH );
	    gd.verticalIndent = 7;
	    gd.heightHint = 10;
	    this.strategyLabel.setLayoutData( gd );
	    

	    
	    ////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    Group newConstraintGroup = new Group( composite, SWT.NONE );
	    newConstraintGroup.setLayout( new GridLayout( 1, false ) );
	    newConstraintGroup.setText( "&Specify New Condition" );
	    GridData gData = new GridData( SWT.FILL, SWT.FILL, true, true );
	    newConstraintGroup.setLayoutData( gData );
	    
	    
	    
	    Composite newConstraintComposite = new Composite( newConstraintGroup, SWT.NONE );
	    newConstraintComposite.setLayout( new GridLayout( 1, false ) );
	    //GridLayout gLayout = new GridLayout( 2, false );
	    newConstraintComposite.setLayout( new GridLayout( 1, false ) );
	    gData = new GridData( GridData.FILL_BOTH );
	    //gData.grabExcessHorizontalSpace = true;
	    //gData.grabExcessVerticalSpace = true;
	    newConstraintComposite.setLayoutData( gData );
	    
	    Composite typeComposite = new Composite( newConstraintComposite, SWT.NONE );
	    GridLayout gLayout = new GridLayout( 2, false );
	    typeComposite.setLayout( gLayout );
	    gData = new GridData( GridData.FILL_HORIZONTAL );
	    typeComposite.setLayoutData( gData );
	    
	    Label typeLabel = new Label( typeComposite, SWT.LEAD );
	    typeLabel.setText( "Type" ); //$NON-NLS-1$
	    gd = new GridData( 50, 20 );
	    typeLabel.setLayoutData( gd );
	    // Combo - GlobalElasticityReq
	    this.cmbGlobalElasticityReq = new CCombo( typeComposite, SWT.BORDER );
	    this.cmbGlobalElasticityReq.setEnabled( true );
	    gd = new GridData( 212, 20 );
	    this.cmbGlobalElasticityReq.setLayoutData( gd );

	    ArrayList<MonitoringProbe> mps = getMetrics();
	    for (MonitoringProbe mp : mps){
	      String metricsString = mp.getDescription();
	      if (metricsString.equals( "" )==false){
	        metricsString = metricsString.substring( 2, metricsString.length()-2 );
	        metricsString = metricsString.replace( "\"", "" );
	      String[] metrics = metricsString.split( "," );
	      for (String metric : metrics)
	        this.cmbGlobalElasticityReq.add(metric);
	      }
	      else{
	        this.cmbGlobalElasticityReq.add(mp.getName());
	      }
	    }
	    this.cmbGlobalElasticityReq.add("Cost");

	    Composite valueComposite = new Composite( newConstraintComposite, SWT.NONE );
	    gLayout = new GridLayout( 3, false );
	    valueComposite.setLayout( gLayout );
	    gData = new GridData( GridData.FILL_HORIZONTAL );
	    valueComposite.setLayoutData( gData );
	    
	    Label valueLabel = new Label( valueComposite, SWT.LEAD );
	    valueLabel.setText( "Value" ); //$NON-NLS-1$
	    gd = new GridData( 50, 20 );
	    valueLabel.setLayoutData( gd );
	    
	    // Combo - Operator
	    this.cmbOperator = new CCombo( valueComposite, SWT.BORDER );
	    this.cmbOperator.setEnabled( true );
	    gd = new GridData( 40, 20 );
	    this.cmbOperator.setLayoutData( gd );
	    this.cmbOperator.add( "=" ); //$NON-NLS-1$
	    this.cmbOperator.add( "<" ); //$NON-NLS-1$
	    this.cmbOperator.add( ">" );  //$NON-NLS-1$
	    this.cmbOperator.setText( this.cmbOperator.getItem( 0 ) );  
	    
	    this.valueText = new Text( valueComposite, SWT.BORDER );
	    gd = new GridData( 154, 20 );
	    this.valueText.setLayoutData( gd );

	    this.cmbGlobalElasticityReq.setEditable( false );
	    this.cmbGlobalElasticityReq.addModifyListener( new ModifyListener() {

	      public void modifyText( final ModifyEvent e ) {
	        
	        ElasticityConditionDialog.this.cmbCondition.setEnabled( true );
	        ElasticityConditionDialog.this.cmbCondition2.setEnabled( true );
	        
	        ElasticityConditionDialog.this.newType = ElasticityConditionDialog.this.cmbGlobalElasticityReq.getText();
	        
	    
	      }
	    } );
	 
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    Group constraintGroup = new Group( composite, SWT.NONE );
	    constraintGroup.setLayout( new GridLayout( 1, false ) );
	    constraintGroup.setText( "&Select Constraint" );
	    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
	    constraintGroup.setLayoutData( gData );
	    
	    Composite constraintComposite = new Composite( constraintGroup, SWT.NONE );
	    constraintComposite.setLayout( new GridLayout( 1, false ) );
	    gData = new GridData( GridData.GRAB_HORIZONTAL );
	    //gData.grabExcessHorizontalSpace = true;
	    //gData.grabExcessVerticalSpace = true;
	    constraintComposite.setLayoutData( gData );
	    
	    
	    // Condition label
	    this.lblCondition = new Label( constraintComposite, SWT.NONE );
	    this.lblCondition.setText( "When fulfilled Constraint:" );
	    gd = new GridData( GridData.FILL_HORIZONTAL );
	    gd.widthHint = 280;
	    this.lblCondition.setLayoutData( gd );

	    // Combo - Condition
	    this.cmbCondition = new CCombo( constraintComposite, SWT.BORDER );
	    this.cmbCondition.setEnabled( true );
	    gd = new GridData( GridData.FILL_HORIZONTAL );
	    gd.widthHint = 280;
	    this.cmbCondition.setLayoutData( gd );
	    this.cmbCondition.setEnabled( false );

	    
	    ArrayList<String> elasticityConstraints = getAllConstraints();
	    
	    if ( elasticityConstraints.size() > 0 ){
	        for ( String constraint : elasticityConstraints ){
	            this.cmbCondition.add(constraint);
	        }
	    }  
	    
	    this.cmbCondition.setText( "" );
	    
	    this.cmbCondition.addModifyListener( new ModifyListener() {

	      @Override
	      public void modifyText( ModifyEvent e ) {
	        if (ElasticityConditionDialog.this.cmbCondition.getText() != ""){
	          ElasticityConditionDialog.this.conditionSelected = true;
	        }
	        
	      }
	      
	    });

	    // Condition label
	    this.lblCondition2 = new Label( constraintComposite, SWT.NONE );
	    this.lblCondition2.setText( "When violated Constraint:" );
	    gd = new GridData( GridData.FILL_HORIZONTAL );
	    gd.widthHint = 280;
	    this.lblCondition2.setLayoutData( gd );

	    // Combo - Condition
	    this.cmbCondition2 = new CCombo( constraintComposite, SWT.BORDER );
	    this.cmbCondition2.setEnabled( true );
	    gd.widthHint = 280;
	    gd = new GridData( GridData.FILL_HORIZONTAL );
	    this.cmbCondition2.setLayoutData( gd );
	    
	    if ( elasticityConstraints.size() > 0 ){
	        for ( String constraint : elasticityConstraints ){
	            this.cmbCondition2.add(constraint);
	        }
	    }  
	    
	    this.cmbCondition2.setText( "" );
	    
	    this.cmbCondition2.addModifyListener( new ModifyListener() {

	      @Override
	      public void modifyText( ModifyEvent e ) {
	        if (ElasticityConditionDialog.this.cmbCondition2.getText() != ""){
	          ElasticityConditionDialog.this.conditionSelected2 = true;
	        }
	        
	      }
	      
	    });
	    
	    return composite;
	  }

	  public ArrayList<MonitoringProbe> getMetrics(){
	    
	    ArrayList<MonitoringProbe> mps = MockUpInfoSystem.getInstance()
	        .getMonitoringProbes();
	        
	        ArrayList<MonitoringProbe> mpsCopy = ( ArrayList<MonitoringProbe> )mps.clone();
	        
	    IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	    IProject monitoringProbesProject = workspaceRoot.getProject( "MonitoringProbe" );

	    if( monitoringProbesProject.exists() ) {
	      IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
	      IResource[] artifactsResource = null;
	      try {
	        artifactsResource = srcFolder.members();
	      } catch( CoreException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      for( IResource tempResource : artifactsResource ) {
	        if( tempResource instanceof IFile ) {
	          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
	          mp.setUID( tempResource.getName().replaceFirst( ".java", "" ));
	          mp.setName( tempResource.getName().replaceFirst( ".java", "" ));
	          mp.setDescription( "" );
	          // add new probe to monitoring list
	          mpsCopy.add( 0, mp );
	        }
	      }
	    }
	    
	    return mpsCopy;
	  }
	  
	  // Returns all global, composite and component level elasticity constraints;
	  private ArrayList<String> getAllConstraints(){
		  
		  ArrayList<String> constraints = new ArrayList<String>();
		  
		  DocumentRoot toscaRoot = this.model.getDocumentRoot();
		  EList<TServiceTemplate> toscaServiceTemplates = toscaRoot.getDefinitions().getServiceTemplate();
		  EList<TNodeTemplate> tempNodeTemplates;
		  for ( TServiceTemplate tempServiceTemplate : toscaServiceTemplates ){
			  
			  //TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension ) tempServiceTemplate.getBoundaryDefinitions();
			  
		    TBoundaryDefinitions boundaryDef = ( TBoundaryDefinitions ) tempServiceTemplate.getBoundaryDefinitions();
		    
			  if ( boundaryDef != null ){
		
				  PoliciesType1 globalPolicies = boundaryDef.getPolicies();
				  
				  if ( globalPolicies != null ){
				
					  for ( int k=0; k<globalPolicies.getPolicy().size(); k++){
							  
						  if ( globalPolicies.getPolicy().get(k).getPolicyType().toString().contains( "Constraint" ) ){
							  constraints.add(globalPolicies.getPolicy().get(k).getName());
						  }
					  }

				  }
			  }
			  
			  if ( tempServiceTemplate.getTopologyTemplate() != null && tempServiceTemplate.getTopologyTemplate().getNodeTemplate() != null ){
				  
				  tempNodeTemplates = tempServiceTemplate.getTopologyTemplate().getNodeTemplate();
		
				  for ( final TNodeTemplate tempNodeTemplate : tempNodeTemplates ){
					  
					  if ( tempNodeTemplate.getPolicies() != null && tempNodeTemplate.getPolicies().getPolicy() != null ){
						  for ( int j=0; j<tempNodeTemplate.getPolicies().getPolicy().size(); j++){
							  
							  if (tempNodeTemplate.getPolicies().getPolicy().get(j).getPolicyType().toString().contains( "Constraint" ) ){
								  constraints.add(tempNodeTemplate.getPolicies().getPolicy().get(j).getName());
							  }
						  }
					  }
				  }

				  
			  }

		  }
		  
		  return constraints;

	  }

	  
	  /**
	   * Access to the List of Data Stage-In elements.
	   * 
	   * @return DataStage-In list set by the user.
	   */
	  public String getSelectedCondition() {
	    return ElasticityConditionDialog.this.condition;
	  }
	  
	  public ConditionType getSYBLCondition() {
	    
	    ConditionType strategyCondition = SyblFactory.eINSTANCE.createConditionType();
	    BinaryRestriction br = SyblFactory.eINSTANCE.createBinaryRestriction();
	    br.setType( this.conditionOperator );
	    LeftHandSideType conditionLeft = SyblFactory.eINSTANCE.createLeftHandSideType();
	    conditionLeft.setMetric( this.conditionLeft );
	    br.setLeftHandSide( conditionLeft );
	    RightHandSideType conditionRight = SyblFactory.eINSTANCE.createRightHandSideType();
	    conditionRight.setNumber( this.conditionRight );
	    br.setRightHandSide( conditionRight );
	    UnaryRestriction ur = SyblFactory.eINSTANCE.createUnaryRestriction();
	    ur.setType( "hi4" );
	    strategyCondition.getBinaryRestrictionsConjunction().add( br );
	    strategyCondition.getUnaryRestrictionsConjunction().add( ur );
	    
	    return strategyCondition;

	  }

	  @SuppressWarnings("boxing")
	  @Override
	  protected void okPressed() {
	           
	    ElasticityConditionDialog.this.conditionLeft = this.cmbGlobalElasticityReq.getText();
	    ElasticityConditionDialog.this.conditionRight = this.valueText.getText();
	    ElasticityConditionDialog.this.conditionOperator = this.cmbOperator.getText();
	    if ( this.conditionSelected ){
	      ElasticityConditionDialog.this.condition = "CASE fulfilled(" + this.cmbCondition.getText().split( ":" )[0] + "):";
	    }
	    else if ( this.conditionSelected2 ){
	    	ElasticityConditionDialog.this.condition = "CASE violated(" + this.cmbCondition2.getText().split( ":" )[0] + "):";
	    }
	    else {      
	      ElasticityConditionDialog.this.condition = "CASE " + this.cmbGlobalElasticityReq.getText() + this.cmbOperator.getText() + this.valueText.getText();
	    }
	                                                                                             
	    super.okPressed();
	  }
	}

