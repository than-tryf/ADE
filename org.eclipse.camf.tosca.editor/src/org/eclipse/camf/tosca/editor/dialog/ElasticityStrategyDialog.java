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
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.example.sybl.SYBLSpecificationType;
import org.example.sybl.Strategy;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblFactory;
import org.example.sybl.ToEnforceType;

public class ElasticityStrategyDialog extends Dialog {

	protected Text typeText;
  protected Text valueText;
  protected boolean editMode = false;
  protected boolean addMode = false;
  protected String newType;
  protected String elasticityStrategy;
  private CCombo cmbStrategy;
  private CCombo cmbMetric;
  private CCombo cmbElasticityAction;
  private String nodeName;

  /**
   * @param parentShell
   */
  public ElasticityStrategyDialog( final Shell parentShell, String component, String nodeName ) {
    super( parentShell );
    this.addMode = true;
    this.nodeName = nodeName;
  }

  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Add Elasticity Strategy" );
    shell.setSize( 300, 250 );
  }

  @Override
  protected Control createDialogArea( final Composite parent ) {
    Composite composite = ( Composite )super.createDialogArea( parent );
    composite.setLayout( new GridLayout( 1, false ) );
    composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
    // Choose from Supported Elasticity Actions Group
    Group elasticityActionsGroup = new Group( composite, SWT.NONE );
    elasticityActionsGroup.setLayout( new GridLayout( 1, false ) );
    elasticityActionsGroup.setText( "&Select Strategy" );
    GridData gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    elasticityActionsGroup.setLayoutData( gData );
    // Combo - GlobalElasticityReq
    this.cmbElasticityAction = new CCombo( elasticityActionsGroup, SWT.BORDER );
    this.cmbElasticityAction.setEnabled( true );
    GridData gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbElasticityAction.setLayoutData( gd );
//	    this.cmbElasticityAction.add( "AddVM" );
//	    this.cmbElasticityAction.add( "RemoveVM" );
    this.cmbElasticityAction.add( "scaleIn" );
    this.cmbElasticityAction.add( "scaleOut" );
    this.cmbElasticityAction.setText( this.cmbElasticityAction.getItem( 0 ) );
    this.cmbElasticityAction.setEditable( false );
    // Create New Strategy Group
    Group customStrategyGroup = new Group( composite, SWT.NONE );
    customStrategyGroup.setLayout( new GridLayout( 1, false ) );
    customStrategyGroup.setText( "&Specify New Strategy" );
    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    customStrategyGroup.setLayoutData( gData );
    // Combo - GlobalElasticityReq
    this.cmbStrategy = new CCombo( customStrategyGroup, SWT.BORDER );
    this.cmbStrategy.setEnabled( true );
    gd = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbStrategy.setLayoutData( gd );
    this.cmbStrategy.add( "Maximize" );
    this.cmbStrategy.add( "Minimize" );
    this.cmbStrategy.setText( this.cmbStrategy.getItem( 0 ) );
    this.cmbStrategy.setEditable( false );
    // Combo - Metric
    this.cmbMetric = new CCombo( customStrategyGroup, SWT.BORDER );
    this.cmbMetric.setEnabled( true );
    this.cmbMetric.setEditable( false );
    GridData gdMetric = new GridData( GridData.FILL_HORIZONTAL );
    this.cmbMetric.setLayoutData( gdMetric );
    this.cmbMetric.add( "Cost" );
    this.cmbMetric.add( "Throughput" );
    this.cmbMetric.add( "Response Time" );
    return composite;
  }

  /**
   * Access to the List of Data Stage-In elements.
   * 
   * @return DataStage-In list set by the user.
   */
  public String getElasticityStrategy() {
    return ElasticityStrategyDialog.this.elasticityStrategy;
  }

  @SuppressWarnings("boxing")
  @Override
  protected void okPressed() {
    if( !( this.cmbMetric.getText().equals( "" ) ) ) {
      ElasticityStrategyDialog.this.elasticityStrategy = this.cmbStrategy.getText()
                                                         + " ("
                                                         + this.cmbMetric.getText()
                                                         + ")";
    } else {
      //ElasticityStrategyDialog.this.elasticityStrategy = this.cmbElasticityAction.getText();
      ElasticityStrategyDialog.this.elasticityStrategy = this.cmbElasticityAction.getText()
          + " ("
          + this.nodeName
          + ")";
    }
    super.okPressed();
  }
}

