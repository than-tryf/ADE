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
import java.util.List;

import org.eclipse.camf.connectors.openstack.IOpenStackService;
import org.eclipse.camf.connectors.openstack.OpenStackCloudProvider;
import org.eclipse.camf.connectors.openstack.OpenStackCloudProviderCreator;
import org.eclipse.camf.connectors.openstack.OpenStackCloudProviderProperties;
import org.eclipse.camf.connectors.openstack.ui.Messages;
import org.eclipse.camf.connectors.openstack.ui.internal.Activator;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;


/**
 * This {@link WizardPage} provides the form elements to input the details of a
 * new {@link OpenStackCloudProvider}. It also creates the
 * {@link OpenStackCloudProvider} in the {@link #createCloudProvider()} method.
 * Additionally a list of configured {@link IOpenStackService} is displayed
 * 
 * @author Moritz Post
 * @see OpenStackCloudProviderCreator
 */
public class OpenStackCloudProviderWizardPage extends WizardPage {

  /** Id of this Wizard page. */
  private static final String WIZARD_PAGE_ID = "org.eclipse.camf.connectors.openstack.ui.openstackCloudProviderWizardPage"; //$NON-NLS-1$

  /** The name of this {@link OpenStackCloudProvider}. */
  private Text cpNameText;

  /** Text widget to hold the openstack access id. */
  private Text openstackAccessIdText;
  
  /** Text widget to hold the openstack endpoint URL. */
  private Text openstackEndPointText;

  /** The initial {@link OpenStackCloudProvider} to take data from. */
  private OpenStackCloudProvider initialCloudProvider;

  /** The table listing the installed services. */
  private Table tableServices;

  /** A list of configured grid elements implementing the {@link IOpenStackService}. */
  private List<IConfigurationElement> configurationElements;

  /**
   * This default constructor creates a new instance of this
   * {@link OpenStackCloudProviderWizardPage} and sets up the page decoration.
   */
  protected OpenStackCloudProviderWizardPage() {
    super( OpenStackCloudProviderWizardPage.WIZARD_PAGE_ID,
           Messages.getString( "OpenStackCloudProviderWizardPage.page_title" ), null ); //$NON-NLS-1$ 
    setDescription( Messages.getString( "OpenStackCloudProviderWizardPage.page_description" ) ); //$NON-NLS-1$
    URL imgUrl = Activator.getDefault()
      .getBundle()
      .getEntry( "icons/wizban/vomsvo_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );

    setPageComplete( false );
  }

  public void createControl( final Composite parent ) {
    GridData gData;

    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );

    // general vo information
    Group settingsGroup = new Group( mainComp, SWT.NONE );
    settingsGroup.setLayout( new GridLayout( 2, false ) );
    settingsGroup.setText( Messages.getString( "OpenStackCloudProviderWizardPage.label_cp_settings" ) ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    settingsGroup.setLayoutData( gData );

    Label nameLabel = new Label( settingsGroup, SWT.LEFT );
    nameLabel.setText( Messages.getString( "OpenStackCloudProviderWizardPage.label_cp_name" ) ); //$NON-NLS-1$
    nameLabel.setLayoutData( new GridData() );

    this.cpNameText = new Text( settingsGroup, SWT.LEFT
                                               | SWT.SINGLE
                                               | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.cpNameText.setLayoutData( gData );
    this.cpNameText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );

    Label osAccessIdLabel = new Label( settingsGroup, SWT.LEFT );
    osAccessIdLabel.setText( Messages.getString( "OpenStackCloudProviderWizardPage.label_os_access_id" ) ); //$NON-NLS-1$
    osAccessIdLabel.setLayoutData( new GridData() );

    this.openstackAccessIdText = new Text( settingsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.openstackAccessIdText.setLayoutData( gData );
    this.openstackAccessIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );
    
    Label osAccessEndPointLabel = new Label( settingsGroup, SWT.LEFT );
    osAccessEndPointLabel.setText( Messages.getString( "OpenStackCloudProviderWizardPage.label_os_endpoint" ) ); //$NON-NLS-1$
    osAccessEndPointLabel.setLayoutData( new GridData() );

    this.openstackEndPointText = new Text( settingsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.openstackEndPointText.setLayoutData( gData );
    this.openstackEndPointText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );

    // general cp information
    Group servicesGroup = new Group( mainComp, SWT.NONE );
    servicesGroup.setLayout( new GridLayout( 2, false ) );
    servicesGroup.setText( Messages.getString( "OpenStackCloudProviderWizardPage.group_title_services" ) ); //$NON-NLS-1$
    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData.grabExcessVerticalSpace = true;
    servicesGroup.setLayoutData( gData );

    this.tableServices = new Table( servicesGroup, SWT.BORDER
                                                   | SWT.V_SCROLL
                                                   | SWT.H_SCROLL
                                                   | SWT.SINGLE
                                                   | SWT.FULL_SELECTION );
    this.tableServices.setLinesVisible( true );
    this.tableServices.setHeaderVisible( true );

    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    this.tableServices.setLayoutData( gData );

    TableColumn tableColumnService = new TableColumn( this.tableServices,
                                                      SWT.NONE );
    tableColumnService.setText( Messages.getString( "OpenStackCloudProviderWizardPage.table_services_column_service_title" ) ); //$NON-NLS-1$
    tableColumnService.setWidth( 200 );
    TableColumn tableColumnUrl = new TableColumn( this.tableServices, SWT.NONE );
    tableColumnUrl.setText( Messages.getString( "OpenStackCloudProviderWizardPage.table_services_column_url_title" ) ); //$NON-NLS-1$
    tableColumnUrl.setWidth( 150 );

    setControl( mainComp );

    // set initial values
    if( this.initialCloudProvider != null ) {
      try {
        OpenStackCloudProviderProperties properties = this.initialCloudProvider.getProperties();
        if( properties != null ) {
          this.cpNameText.setText( this.initialCloudProvider.getName() );
          this.cpNameText.setEnabled( false );
          this.openstackAccessIdText.setText( properties.getOpenStackAccessId() );
          this.openstackEndPointText.setText( properties.getOpenStackEndpoint().toString() );
        }
      } catch( ProblemException problemEx ) {
        Activator.log( "Could not load properties from initial OpenStack Cloud Provider", //$NON-NLS-1$
                       problemEx );
      }
    } else {
      this.cpNameText.setEnabled( true );
    }

    // populate service table
    try {
      populateServiceTable( this.initialCloudProvider );
      tableColumnUrl.pack();
      tableColumnService.pack();
    } catch( InvalidRegistryObjectException invalidRegObjEx ) {
      Activator.log( "Could not populate services table", invalidRegObjEx ); //$NON-NLS-1$
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not populate services table from stored definitons", //$NON-NLS-1$
                     problemEx );
    }
  }

  /**
   * If the {@link OpenStackCloudProvider} provided is not <code>null</code>
   * the {@link #tableServices} table is filled with the present
   * {@link IOpenStackService} implementations. Otherwise the {@link #tableServices}
   * is populated with all Elements registered in the plugin register, which are
   * able to provide an IOpenStackService.
   * 
   * @param openstackCP the vo to get {@link IOpenStackService} implementation from
   * @throws InvalidRegistryObjectException when the registry could not be
   *             accessed
   * @throws ProblemException when accessing the grid model caused problems
   */
  private void populateServiceTable( final OpenStackCloudProvider openstackCP )
    throws InvalidRegistryObjectException, ProblemException
  {
    if( openstackCP == null ) {
      this.configurationElements = CloudModel.getCreatorRegistry().getConfigurations( null, IOpenStackService.class );
      String url = null;
      for( IConfigurationElement element : this.configurationElements ) {
        String name = element.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_NAME_ATTRIBUTE );
        IConfigurationElement[] sourceChildern = element.getChildren( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_ELEMENT );

        for( IConfigurationElement sourceElement : sourceChildern ) {
          String defaultSource = sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_DEFAULT_ATTRIBUTE );
          boolean isDefaultSource = Boolean.parseBoolean( defaultSource );
          if( isDefaultSource ) {
            url = sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_PATTERN_ATTRIBUTE );
          }
        }

        TableItem tableItem = new TableItem( this.tableServices, SWT.NONE );
        tableItem.setData( element );
        tableItem.setText( new String[]{
          name, url
        } );
      }
    } else {
      List<IOpenStackService> openstackServices = openstackCP.getChildren( new NullProgressMonitor(),
                                                         IOpenStackService.class );
      for( IOpenStackService service : openstackServices ) {
        TableItem tableItem = new TableItem( this.tableServices, SWT.NONE );
        tableItem.setData( service );
        tableItem.setText( service.getName() );
      }
    }
  }

  /**
   * Check if the input of the form is valid.
   */
  protected void validateInput() {
    String name = this.cpNameText.getText().trim();
    if( name.length() == 0 ) {
      setErrorMessage( Messages.getString( "OpenStackWizardPage.error_cp_name_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if ( ( this.initialCloudProvider == null )
        && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
      setErrorMessage( Messages.getString( "OpenStackWizardPage.error_cp_already_exists" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if( this.openstackAccessIdText.getText().trim().length() == 0 ) {
      setErrorMessage( Messages.getString( "OpenStackCloudProviderWizardPage.error_acces_id_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if( this.openstackEndPointText.getText().trim().length() == 0 ) {
      setErrorMessage( Messages.getString( "OpenStackCloudProviderWizardPage.error_access_endpoint_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else {
      setErrorMessage( null );
      setPageComplete( true );
    }
  }

  /**
   * Set the initial {@link OpenStackCloudProvider} to populate the form fields.
   * 
   * @param initialVo the cp to take the initial values from
   */
  public void setInitialCloudProvider( final OpenStackCloudProvider initialVo ) {
    this.initialCloudProvider = initialVo;
  }

  /**
   * Create either a new OpenStack CP from the settings of this wizard page or change
   * the settings of the initial CP. If a new CP is created this CP is directly
   * added to the {@link IVoManager}.
   * 
   * @return True if the process was successful, false otherwise.
   */
  protected boolean createCloudProvider() {

    // create new vo creator
    OpenStackCloudProviderCreator cpCreator = new OpenStackCloudProviderCreator();
    cpCreator.setProvider( this.cpNameText.getText().trim() );
    cpCreator.setOpenStackAccessId( this.openstackAccessIdText.getText().trim() );
    cpCreator.setEndPoint( URI.create( this.openstackEndPointText.getText().trim() ) );

    // get cpManager to create new cp via cpCreator
    ICloudProviderManager voManager = CloudModel.getCloudProviderManager();
    OpenStackCloudProvider openstackCP = null;

    // create a new cp with the given manager and cp creator
    if( this.initialCloudProvider == null ) {
      try {
        // create new openstackCP
        openstackCP = ( OpenStackCloudProvider )voManager.create( cpCreator );
      } catch( ProblemException problemEx ) {
        Activator.log( "Could not create OpenStack Cloud Provider with provided OpenStackCloudProviderCreator via CloudProviderManager", //$NON-NLS-1$
                       problemEx );

        // cleanup and present error message
        try {
          voManager.delete( openstackCP );
        } catch( ProblemException problemExDel ) {
          ProblemDialog.openProblem( this.getShell(),
                                     Messages.getString( "OpenStackCloudProviderWizardPage.error_dialog_title" ), //$NON-NLS-1$
                                     Messages.getString( "OpenStackCloudProviderWizardPage.error_dialog_description" ), //$NON-NLS-1$
                                     problemExDel );
          Activator.log( "Could not delete rudimentary OpenStack Cloud Provider", problemEx ); //$NON-NLS-1$
        }
        return false;
      }
    } else {
      // work with existing vo
      cpCreator.apply( this.initialCloudProvider );
    }

    return true;
  }
}
