/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *    Stalo Sofokleous
 *****************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.net.URL;
import java.util.regex.Pattern;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.model.impl.GenericCloudProviderCreator;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * Wizard page for the {@link GenericVirtualOrganization}.
 */
public class CELARCloudProviderWizardPage
    extends WizardPage {
  
  private GenericCloudProvider initialCloudProvider;
    
  /** A pattern for matching the VO name */
  private Pattern cpNamePattern = Pattern.compile( "^[\\w.-]+$" ); //$NON-NLS-1$
  
  /** The name of the CloudProvider. */
  private CCombo cpNameCombo;
  
  /** The name of the CloudProvider. */
  private Text cpNameText;
  
  /** The name of the monitoring system. */
  private Text monitoringNameText;
  
  /** Text widget to hold the cloud provider access id. */
  private Text cpAccessIdText;
  
  /** Text widget to hold the monitoring access id. */
  private Text monitoringAccessIdText;
  
  /** Text widget to hold the cloud provider endpoint URL. */
  private Text cpEndPointText;
  
  /** Text widget to hold the monitoring endpoint URL. */
  private Text monitoringEndPointText;
  
  /**
   * Standard constructor.
   */
  public CELARCloudProviderWizardPage() {
    super( "CELARCOPage", //$NON-NLS-1$
           "CELAR Cloud Provider",
           null );
    setDescription( "Specify the attributes of the CELAR Cloud Provider" );
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/vo_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
  }

  public void createControl( final Composite parent ) {
    
    GridData gData;

    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );

    // general cloud provider information
    Group settingsGroup = new Group( mainComp, SWT.NONE );
    settingsGroup.setLayout( new GridLayout( 2, false ) );
    settingsGroup.setText( Messages.getString( "CELARCloudProviderWizardPage.label_cp_settings" ) ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    settingsGroup.setLayoutData( gData );

    Label nameLabel = new Label( settingsGroup, SWT.LEFT );
    nameLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_cp_name" ) ); //$NON-NLS-1$
    nameLabel.setLayoutData( new GridData() );

    this.cpNameText = new Text( settingsGroup, SWT.LEFT
                                               | SWT.SINGLE
                                               | SWT.BORDER );
    this.cpNameCombo.setEnabled( true );
    this.cpNameCombo.add( "Flexiant" );
    this.cpNameCombo.add( "Okeanos" );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.cpNameCombo.setLayoutData( gData );
    
//  this.cpNameText = new Text( settingsGroup, SWT.LEFT
//  | SWT.SINGLE
//  | SWT.BORDER );
//gData = new GridData( GridData.FILL_HORIZONTAL );
//gData.grabExcessHorizontalSpace = true;
//this.cpNameText.setLayoutData( gData );
//this.cpNameText.addModifyListener( new ModifyListener() {
//
//public void modifyText( final ModifyEvent e ) {
//validateInput();
//}
//
//} );
    
    
    this.cpNameText.setLayoutData( gData );
    this.cpNameText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );
    
    //

    Label osAccessIdLabel = new Label( settingsGroup, SWT.LEFT );
    //osAccessIdLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_os_access_id" ) ); //$NON-NLS-1$
    osAccessIdLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_username" ) ); 
    osAccessIdLabel.setLayoutData( new GridData() );

    this.cpAccessIdText = new Text( settingsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.cpAccessIdText.setLayoutData( gData );
    this.cpAccessIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );
    
    Label cpAccessEndPointLabel = new Label( settingsGroup, SWT.LEFT );
    //cpAccessEndPointLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_os_endpoint" ) ); //$NON-NLS-1$
    cpAccessEndPointLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_password" ) ); //$NON-NLS-1$
    cpAccessEndPointLabel.setLayoutData( new GridData() );

    this.cpEndPointText = new Text( settingsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.cpEndPointText.setLayoutData( gData );
    this.cpEndPointText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );

    // general monitoring system information
//    Group monitoringGroup = new Group( mainComp, SWT.NONE );
//    monitoringGroup.setLayout( new GridLayout( 2, false ) );
//    monitoringGroup.setText( Messages.getString( "CELARCloudProviderWizardPage.label_ms_settings" ) ); //$NON-NLS-1$
//    gData = new GridData( GridData.FILL_HORIZONTAL );
//    gData.grabExcessHorizontalSpace = true;
//    monitoringGroup.setLayoutData( gData );
//
//    Label monitoringNameLabel = new Label( monitoringGroup, SWT.LEFT );
//    monitoringNameLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_ms_name" ) ); //$NON-NLS-1$
//    monitoringNameLabel.setLayoutData( new GridData() );
//
//    this.monitoringNameText = new Text( monitoringGroup, SWT.LEFT
//                                               | SWT.SINGLE
//                                               | SWT.BORDER );
//    gData = new GridData( GridData.FILL_HORIZONTAL );
//    gData.grabExcessHorizontalSpace = true;
//    this.monitoringNameText.setLayoutData( gData );
//    this.monitoringNameText.addModifyListener( new ModifyListener() {
//
//      public void modifyText( final ModifyEvent e ) {
//        validateInput();
//      }
//
//    } );
//
//    Label msAccessIdLabel = new Label( monitoringGroup, SWT.LEFT );
//    msAccessIdLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_ms_access_id" ) ); //$NON-NLS-1$
//    msAccessIdLabel.setLayoutData( new GridData() );
//
//    this.monitoringAccessIdText = new Text( monitoringGroup, SWT.LEFT
//                                                    | SWT.SINGLE
//                                                    | SWT.BORDER );
//    gData = new GridData( GridData.FILL_HORIZONTAL );
//    gData.grabExcessHorizontalSpace = true;
//    this.monitoringAccessIdText.setLayoutData( gData );
//    this.monitoringAccessIdText.addModifyListener( new ModifyListener() {
//
//      public void modifyText( final ModifyEvent e ) {
//        validateInput();
//      }
//
//    } );
//    
//    Label msAccessEndPointLabel = new Label( monitoringGroup, SWT.LEFT );
//    msAccessEndPointLabel.setText( Messages.getString( "CELARCloudProviderWizardPage.label_ms_endpoint" ) ); //$NON-NLS-1$
//    msAccessEndPointLabel.setLayoutData( new GridData() );
//
//    this.monitoringEndPointText = new Text( monitoringGroup, SWT.LEFT
//                                                    | SWT.SINGLE
//                                                    | SWT.BORDER );
//    gData = new GridData( GridData.FILL_HORIZONTAL );
//    gData.grabExcessHorizontalSpace = true;
//    this.monitoringEndPointText.setLayoutData( gData );
//    this.monitoringEndPointText.addModifyListener( new ModifyListener() {
//
//      public void modifyText( final ModifyEvent e ) {
//        validateInput();
//      }
//
//    } );

    setControl( mainComp );
    
  }
  
  public IStatus apply( final GenericCloudProviderCreator creator ) {
    
    IStatus result = Status.OK_STATUS;
    
    String name = this.cpNameText.getText();
    if ( ! validateVoName( name ) ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "You have to specify a valid Cloud Provider name" );
    } else if ( ( this.initialCloudProvider == null )
        && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, "A Cloud Provider with the same name already exists" );
    } else {
      creator.setVoName( name );
    }
    
    return result;
    
  }
  
  /**
   * Initializes the controls of this wizard page with the attributes
   * of the specified CP.
   * 
   * @param cp The  Cloud Provider whose attributes should be set to the page's controls.
   */
  protected void initVo( final GenericCloudProvider cp ) {
    this.cpNameText.setText( cp != null ? cp.getName() : "" ); //$NON-NLS-1$
    this.cpNameText.setEnabled( cp == null );
  }
  
  /**
   * Set the specified VO as initial CP. This means that the controls
   * of the page will be initialized with the attributes of the specified
   * VO.
   * 
   * @param cp The initial Cloud Provider.
   */
  protected void setInitialVo( final GenericCloudProvider cp ) {
    this.initialCloudProvider = cp;
  }
  
  /**
   * Helper method to validate the VO name entered by the user.
   * 
   * @param voName the VO name to validate
   * @return true if the VO name matches the allowed pattern
   */
  private boolean validateVoName( final String voName ) {
    return this.cpNamePattern.matcher( voName ).matches();
  }
  
  /**
   * Check if the input of the form is valid.
   */
  protected void validateInput() {
    String name = this.cpNameText.getText().trim();
    if( name.length() == 0 ) {
      setErrorMessage( Messages.getString( "CELARWizardPage.error_cp_name_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if ( ( this.initialCloudProvider == null )
        && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
      setErrorMessage( Messages.getString( "CELARWizardPage.error_cp_already_exists" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if( this.cpAccessIdText.getText().trim().length() == 0 ) {
      setErrorMessage( Messages.getString( "CELARWizardPage.error_acces_id_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if( this.cpEndPointText.getText().trim().length() == 0 ) {
      setErrorMessage( Messages.getString( "CELARWizardPage.error_access_endpoint_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else {
      setErrorMessage( null );
      setPageComplete( true );
    }
  }

}
