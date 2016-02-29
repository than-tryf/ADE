/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.ui.wizards;

import java.net.URI;
import java.net.URL;

import org.eclipse.camf.connectors.openstack.OpenStackCloudProvider;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.connectors.openstack.ui.Messages;
import org.eclipse.camf.connectors.openstack.ui.internal.Activator;
import org.eclipse.camf.core.auth.PasswordManager;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.wizards.CloudProviderSelectionWizardPage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


/**
 * This wizard page provides the form elements to input the details required to
 * create an {@link OpenStackAuthToken}.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackAuthTokenWizardPage extends WizardPage {

  /** The ID of the wizard page. */
  private static final String WIZARD_PAGE_ID = "org.eclipse.camf.connectors.openstack.ui.openstackAuthTokenWizardPage"; //$NON-NLS-1$

  /** The {@link Text} widget to hold the access id. */
  private Text accessIdText;

  /** The {@link Text} widget to hold the secret id. */
  private Text secretIdText;
  
  /** The {@link Text} widget to hold the secret id. */
  private Text endpointText;

  /** The initial datasource for the token. */
  private OpenStackAuthTokenDescription openstackAuthTokenDesc;

  /** The parent {@link Wizard} of this page. */
  private OpenStackAuthTokenWizard authTokenWizard;

  /**
   * Create a new {@link OpenStackAuthTokenWizardPage} and provide initial content via
   * the awsAuthTokenDesc
   * 
   * @param authTokenWizard the parent {@link Wizard}
   * @param openstackAuthTokenDesc the initial {@link OpenStackAuthTokenDescription}
   */
  protected OpenStackAuthTokenWizardPage( final OpenStackAuthTokenWizard authTokenWizard,
                                    final OpenStackAuthTokenDescription openstackAuthTokenDesc )
  {
    super( OpenStackAuthTokenWizardPage.WIZARD_PAGE_ID,
           Messages.getString( "OpenStackAuthTokenWizardPage.wizard_page_title" ), //$NON-NLS-1$
           null );

    this.openstackAuthTokenDesc = openstackAuthTokenDesc;
    this.authTokenWizard = authTokenWizard;

    setDescription( Messages.getString( "OpenStackAuthTokenWizardPage.wizard_page_description" ) ); //$NON-NLS-1$
    URL imgUrl = Activator.getDefault()
      .getBundle()
      .getEntry( "icons/wizban/credentials_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );

  }

  @Override
  public void setVisible( final boolean visible ) {
    super.setVisible( visible );
    this.authTokenWizard.setCanFinish( true );
    if( visible ) {
      initPage();
    }
  }

  public void createControl( final Composite parent ) {

    GridData gData;

    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );

    // credentials group
    Group credentialsGroup = new Group( mainComp, SWT.NONE );
    credentialsGroup.setLayout( new GridLayout( 2, false ) );
    credentialsGroup.setText( Messages.getString( "OpenStackAuthTokenWizardPage.group_credentials_title" ) ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    credentialsGroup.setLayoutData( gData );

    // access id text
    Label accessIdLabel = new Label( credentialsGroup, SWT.LEFT );
    accessIdLabel.setText( Messages.getString( "OpenStackAuthTokenWizardPage.label_access_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    accessIdLabel.setLayoutData( gData );

    this.accessIdText = new Text( credentialsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER
                                                    | SWT.READ_ONLY );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.accessIdText.setLayoutData( gData );
    
    // secret id
    Label endpointLabel = new Label( credentialsGroup, SWT.LEFT );
    endpointLabel.setText( Messages.getString( "OpenStackAuthTokenWizardPage.label_endpoint" ) ); //$NON-NLS-1$
    gData = new GridData();
    endpointLabel.setLayoutData( gData );

    this.endpointText = new Text( credentialsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER
                                                    | SWT.READ_ONLY );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.endpointText.setLayoutData( gData );

    // secret id
    Label secretIdLabel = new Label( credentialsGroup, SWT.LEFT );
    secretIdLabel.setText( Messages.getString( "OpenStackAuthTokenWizardPage.label_secret_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    secretIdLabel.setLayoutData( gData );

    this.secretIdText = new Text( credentialsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER
                                                    | SWT.PASSWORD );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.secretIdText.setLayoutData( gData );

    setControl( mainComp );
  }

  /**
   * Initializes the pages form based on either a provided
   * {@link OpenStackAuthTokenDescription} or the {@link OpenStackCloudProvider}
   * selected in the previous wizard page.
   */
  private void initPage() {
    // populate fields if possible
    String emptyString = ""; //$NON-NLS-1$
    this.accessIdText.setText( emptyString );
    this.secretIdText.setText( emptyString );
    this.endpointText.setText( emptyString );

    if( this.openstackAuthTokenDesc != null ) {
      String openstackAccessId = this.openstackAuthTokenDesc.getOpenStackAccessId();
      URI endpoint = this.openstackAuthTokenDesc.getOpenStackEndPoint();
      if( openstackAccessId != null ) {
        String openstackSecretId = PasswordManager.getPassword( OpenStackAuthTokenDescription.SECURE_STORAGE_NODE
                                                                + openstackAccessId
                                                                + endpoint.getHost() );

        this.accessIdText.setText( openstackAccessId );
        this.endpointText.setText( endpoint.toString() );
        if( openstackSecretId != null ) {
          this.secretIdText.setText( openstackSecretId );
        } else {
          this.secretIdText.setFocus();
        }
      }
    } else {
      ICloudProvider[] selectedCPs = getCPSelectionPage().getSelectedCloudProviders();

      if( selectedCPs[ 0 ] != null ) {
        OpenStackCloudProvider osCP = ( OpenStackCloudProvider )selectedCPs[ 0 ];
        try {
          String openstackAccessId = osCP.getProperties().getOpenStackAccessId();
          String endpoint = osCP.getProperties().getOpenStackEndpoint().toString().trim();
          this.accessIdText.setText( openstackAccessId );
          this.endpointText.setText( endpoint );
          String openstackSecretId = PasswordManager.getPassword( OpenStackAuthTokenDescription.SECURE_STORAGE_NODE
                                                            + openstackAccessId );
          if( openstackSecretId != null ) {
            this.secretIdText.setText( openstackSecretId );
          } else {
            this.secretIdText.setFocus();
          }
        } catch( ProblemException problemEx ) {
          Activator.log( "Could not extract openstack access id from openstack cp properties", //$NON-NLS-1$
                         problemEx );
        }
      } else {
        this.accessIdText.setEnabled( true );
        this.accessIdText.setFocus();
      }

    }
  }

  /**
   * Construct an {@link OpenStackAuthTokenDescription} from the specified settings of
   * the UI components.
   * 
   * @return A token description that holds the values that were specified using
   *         the UI components.
   */
  public OpenStackAuthTokenDescription getTokenDescription() {
    String accessId = this.accessIdText.getText().trim();
    URI endpoint = URI.create( this.endpointText.getText().trim() );
    String secretId = this.secretIdText.getText().trim();

    OpenStackCloudProvider awsCP = null;
    if( this.openstackAuthTokenDesc == null
        || this.openstackAuthTokenDesc.getOpenStackCloudProvider() == null )
    {
      ICloudProvider[] selectedCPs = getCPSelectionPage().getSelectedCloudProviders();

      for( ICloudProvider cloudProvider : selectedCPs ) {
        awsCP = ( OpenStackCloudProvider ) cloudProvider;
      }
    } else {
      awsCP = this.openstackAuthTokenDesc.getOpenStackCloudProvider();
    }

    OpenStackAuthTokenDescription authTokenDesc = new OpenStackAuthTokenDescription( awsCP );
    PasswordManager.registerPassword( OpenStackAuthTokenDescription.SECURE_STORAGE_NODE
                                          + accessId
                                          + endpoint.getHost(),
                                      secretId );

    return authTokenDesc;
  }

  /**
   * Validate the input of this form. Check if the secret id and the access id
   * is present.
   * 
   * @return if this pages form data is valid or not
   */
  public boolean isValid() {
    String error = null;
    if( this.accessIdText.getText().trim().length() == 0 ) {
      error = Messages.getString( "OpenStackAuthTokenWizardPage.form_error_access_id_required" ); //$NON-NLS-1$
    }
    if( this.secretIdText.getText().trim().length() == 0 ) {
      error = Messages.getString( "OpenStackAuthTokenWizardPage.form_error_secret_id_required" ); //$NON-NLS-1$
    }
    
    if( this.endpointText.getText().trim().length() == 0 ) {
      error = Messages.getString( "OpenStackAuthTokenWizardPage.form_error_endpoint_required" ); //$NON-NLS-1$
    }
    if( error != null ) {
      setErrorMessage( error );
      this.authTokenWizard.setCanFinish( false );
      getWizard().getContainer().updateButtons();
      return false;
    }
    setErrorMessage( null );
    this.authTokenWizard.setCanFinish( true );
    getWizard().getContainer().updateButtons();
    return true;

  }

  /**
   * Fetch the vo selection page to choose a VO.
   * 
   * @return the {@link VoSelectionWizardPage}
   */
  private CloudProviderSelectionWizardPage getCPSelectionPage() {
    IWizardPage page = getPreviousPage();
    while( page != null && !( page instanceof CloudProviderSelectionWizardPage ) ) {
      page = page.getPreviousPage();
    }
    return ( CloudProviderSelectionWizardPage )page;
  }

  /**
   * Register listeners on the form input fields so that after a first press of
   * the "Finish" button, any subsequent key strokes trigger validation of the
   * {@link Text} input widgets.
   */
  public void registerFormListener() {
    this.accessIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        isValid();
      }
    } );

    this.secretIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        isValid();
      }
    } );
    
    this.endpointText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        isValid();
      }
    } );
  }
}
