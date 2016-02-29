/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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
 *    Moritz Post - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.connectors.aws.ui.wizards;

import java.net.URL;
import java.util.List;

import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.AWSCloudProviderCreator;
import org.eclipse.camf.connectors.aws.AWSCloudProviderProperties;
import org.eclipse.camf.connectors.aws.IAWSService;
import org.eclipse.camf.connectors.aws.ui.Messages;
import org.eclipse.camf.connectors.aws.ui.internal.Activator;
import org.eclipse.camf.core.reporting.ProblemException;
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

import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.ui.dialogs.ProblemDialog;


/**
 * This {@link WizardPage} provides the form elements to input the details of a
 * new {@link AWSCloudProvider}. It also creates the
 * {@link AWSCloudProvider} in the {@link #createCloudProvider()} method.
 * Additionally a list of configured {@link IAWSService} is displayed
 * 
 * @author Moritz Post
 * @see AWSVoCreator
 */
public class AWSCloudProviderWizardPage extends WizardPage {

  /** Id of this Wizard page. */
  private static final String WIZARD_PAGE_ID = "org.eclipse.camf.connectors.aws.ui.awsCloudProviderWizardPage"; //$NON-NLS-1$

  /** The name of this {@link AWSCloudProvider}. */
  private Text cpNameText;

  /** Text widget to hold the aws access id. */
  private Text awsAccessIdText;

  /** The initial {@link AWSCloudProvider} to take data from. */
  private AWSCloudProvider initialCloudProvider;

  /** The table listing the installed services. */
  private Table tableServices;

  /** A list of configured grid elements implementing the {@link IAWSService}. */
  private List<IConfigurationElement> configurationElements;

  /**
   * This default constructor creates a new instance of this
   * {@link AWSCloudProviderWizardPage} and sets up the page decoration.
   */
  protected AWSCloudProviderWizardPage() {
    super( AWSCloudProviderWizardPage.WIZARD_PAGE_ID,
           Messages.getString( "AWSCloudProviderWizardPage.page_title" ), null ); //$NON-NLS-1$ 
    setDescription( Messages.getString( "AWSCloudProviderWizardPage.page_description" ) ); //$NON-NLS-1$
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
    settingsGroup.setText( Messages.getString( "AWSCloudProviderWizardPage.label_vo_settings" ) ); //$NON-NLS-1$
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    settingsGroup.setLayoutData( gData );

    Label nameLabel = new Label( settingsGroup, SWT.LEFT );
    nameLabel.setText( Messages.getString( "AWSCloudProviderWizardPage.label_vo_name" ) ); //$NON-NLS-1$
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

    Label awsAccessIdLabel = new Label( settingsGroup, SWT.LEFT );
    awsAccessIdLabel.setText( Messages.getString( "AWSCloudProviderWizardPage.label_aws_access_id" ) ); //$NON-NLS-1$
    awsAccessIdLabel.setLayoutData( new GridData() );

    this.awsAccessIdText = new Text( settingsGroup, SWT.LEFT
                                                    | SWT.SINGLE
                                                    | SWT.BORDER );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    this.awsAccessIdText.setLayoutData( gData );
    this.awsAccessIdText.addModifyListener( new ModifyListener() {

      public void modifyText( final ModifyEvent e ) {
        validateInput();
      }

    } );

    // general vo information
    Group servicesGroup = new Group( mainComp, SWT.NONE );
    servicesGroup.setLayout( new GridLayout( 2, false ) );
    servicesGroup.setText( Messages.getString( "AWSCloudProviderWizardPage.group_title_services" ) ); //$NON-NLS-1$
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
    tableColumnService.setText( Messages.getString( "AWSCloudProviderWizardPage.table_services_column_service_title" ) ); //$NON-NLS-1$
    tableColumnService.setWidth( 200 );
    TableColumn tableColumnUrl = new TableColumn( this.tableServices, SWT.NONE );
    tableColumnUrl.setText( Messages.getString( "AWSCloudProviderWizardPage.table_services_column_url_title" ) ); //$NON-NLS-1$
    tableColumnUrl.setWidth( 150 );

    setControl( mainComp );

    // set initial values
    if( this.initialCloudProvider != null ) {
      try {
        AWSCloudProviderProperties properties = this.initialCloudProvider.getProperties();
        if( properties != null ) {
          this.cpNameText.setText( this.initialCloudProvider.getName() );
          this.cpNameText.setEnabled( false );
          this.awsAccessIdText.setText( properties.getAwsAccessId() );
        }
      } catch( ProblemException problemEx ) {
        Activator.log( "Could not load properties from initial AWS Cloud Provider", //$NON-NLS-1$
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
   * If the {@link AWSCloudProvider} provided is not <code>null</code>
   * the {@link #tableServices} table is filled with the present
   * {@link IAWSService} implementations. Otherwise the {@link #tableServices}
   * is populated with all Elements registered in the plugin register, which are
   * able to provide an IAWSService.
   * 
   * @param awsVo the vo to get {@link IAWSService} implementation from
   * @throws InvalidRegistryObjectException when the registry could not be
   *             accessed
   * @throws ProblemException when accessing the grid model caused problems
   */
  private void populateServiceTable( final AWSCloudProvider awsVo )
    throws InvalidRegistryObjectException, ProblemException
  {
    if( awsVo == null ) {
      this.configurationElements = CloudModel.getCreatorRegistry().getConfigurations( null, IAWSService.class );
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
      List<IAWSService> awsServices = awsVo.getChildren( new NullProgressMonitor(),
                                                         IAWSService.class );
      for( IAWSService service : awsServices ) {
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
      setErrorMessage( Messages.getString( "AWSCloudProviderWizardPage.error_vo_name_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if ( ( this.initialCloudProvider == null )
        && ( CloudModel.getCloudProviderManager().findChild( name ) != null ) ) {
      setErrorMessage( Messages.getString( "AWSCloudProviderWizardPage.error_vo_already_exists" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else if( this.awsAccessIdText.getText().trim().length() == 0 ) {
      setErrorMessage( Messages.getString( "AWSCloudProviderWizardPage.error_acces_id_required" ) ); //$NON-NLS-1$
      setPageComplete( false );
    } else {
      setErrorMessage( null );
      setPageComplete( true );
    }
  }

  /**
   * Set the initial {@link AWSCloudProvider} to populate the form fields.
   * 
   * @param initialVo the vo to take the initial values from
   */
  public void setInitialVo( final AWSCloudProvider initialVo ) {
    this.initialCloudProvider = initialVo;
  }

  /**
   * Create either a new AWS VO from the settings of this wizard page or change
   * the settings of the initial VO. If a new VO is created this VO is directly
   * added to the {@link IVoManager}.
   * 
   * @return True if the process was successful, false otherwise.
   */
  protected boolean createCloudProvider() {

    // create new vo creator
    AWSCloudProviderCreator cpCreator = new AWSCloudProviderCreator();
    cpCreator.setProvider( this.cpNameText.getText().trim() );
    cpCreator.setAwsAccessId( this.awsAccessIdText.getText().trim() );

    // get voManager to create new vo via voCreator
    ICloudProviderManager voManager = CloudModel.getCloudProviderManager();
    AWSCloudProvider awsCP = null;

    // create a new vo with the given manager and vo creator
    if( this.initialCloudProvider == null ) {
      try {
        // create new awsVo
        awsCP = ( AWSCloudProvider )voManager.create( cpCreator );
      } catch( ProblemException problemEx ) {
        Activator.log( "Could not create AWS Cloud Provider with provided AWSCloudProviderCreator via CloudProviderManager", //$NON-NLS-1$
                       problemEx );

        // cleanup and present error message
        try {
          voManager.delete( awsCP );
        } catch( ProblemException problemExDel ) {
          ProblemDialog.openProblem( this.getShell(),
                                     Messages.getString( "AWSCloudProviderWizardPage.error_dialog_title" ), //$NON-NLS-1$
                                     Messages.getString( "AWSCloudProviderWizardPage.error_dialog_description" ), //$NON-NLS-1$
                                     problemExDel );
          Activator.log( "Could not delete rudimentary AWS Cloud Provider", problemEx ); //$NON-NLS-1$
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
