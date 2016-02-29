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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.camf.connectors.openstack.OpenStackCloudProvider;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.connectors.openstack.ui.Messages;
import org.eclipse.camf.connectors.openstack.ui.internal.OpenStackKeyStoreCreationOperation;
import org.eclipse.camf.core.reporting.IProblem;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.camf.ui.wizards.CloudProviderSelectionWizardPage;
import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;


/**
 * A Wizard providing the infrastructure to create an {@link OpenStackAuthToken}. The
 * data input takes place in the {@link OpenStackAuthTokenWizardPage}. If the Wizard
 * is not able to create a {@link OpenStackAuthToken} with the provided details, an
 * {@link IProblem} with the id
 * <code>org.eclipse.camf.connectors.openstack.problem.auth.authFailed</code> is evaluated and
 * displayed in a {@link ProblemDialog}.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackAuthTokenWizardPage
 */
public class OpenStackAuthTokenWizard extends Wizard implements IInitializableWizard {

  /**
   * The {@link IAuthenticationTokenDescription} to generate the
   * {@link OpenStackAuthToken} from.
   */
  private OpenStackAuthTokenDescription authTokenDesc;

  /** The wizard page, which provides the form elements. */
  private OpenStackAuthTokenWizardPage authTokenWizardPage;

  /** The wizard page to select a Cloud Provider. */
  private CloudProviderSelectionWizardPage cpSelectionPage;

  /** A flag denoting if all the fields in the wizard are correctly filed. */
  private boolean canFinish;

  /**
   * The default constructor initializes the Wizard as unfinished.
   */
  public OpenStackAuthTokenWizard() {
    setCanFinish( false );
  }

  @Override
  public void addPages() {

    // show VO selection page if no vo is registered yet
    if( this.authTokenDesc != null ) {
      if( this.authTokenDesc.getOpenStackCloudProvider() == null ) {
        this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                          OpenStackCloudProvider.class );
        addPage( this.cpSelectionPage );
      }
      this.authTokenWizardPage = new OpenStackAuthTokenWizardPage( this,
                                                             this.authTokenDesc );
      addPage( this.authTokenWizardPage );
    } else {
      this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                                   OpenStackCloudProvider.class );
      this.authTokenWizardPage = new OpenStackAuthTokenWizardPage( this, null );
      addPage( this.cpSelectionPage );
      addPage( this.authTokenWizardPage );
    }
    setNeedsProgressMonitor( true );
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "OpenStackAuthTokenWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public boolean performFinish() {

    WizardPage currentPage = ( WizardPage )getContainer().getCurrentPage();
    if( currentPage == this.authTokenWizardPage ) {
      if( !this.authTokenWizardPage.isValid() ) {
        this.authTokenWizardPage.registerFormListener();
        return false;
      }
    }
    OpenStackAuthTokenDescription tokenDesc = this.authTokenWizardPage.getTokenDescription();
    OpenStackKeyStoreCreationOperation op = new OpenStackKeyStoreCreationOperation( tokenDesc );

    try {
      getContainer().run( false, false, op );
    } catch( InvocationTargetException itExc ) {
      Throwable cause = itExc.getCause();
      ProblemDialog.openProblem( getShell(),
                                 Messages.getString( "OpenStackAuthTokenWizard.problem_dialog_title" ), //$NON-NLS-1$
                                 Messages.getString( "OpenStackAuthTokenWizard.problem_dialog_description" ), //$NON-NLS-1$
                                 cause );
      currentPage.setErrorMessage( cause.getLocalizedMessage() );
    } catch( InterruptedException intExc ) {
      currentPage.setErrorMessage( intExc.getLocalizedMessage() );
    }

    String errorMessage = currentPage.getErrorMessage();

    if( errorMessage == null || errorMessage.length() == 0 ) {
      return true;
    }
    return false;
  }

  public boolean init( final Object data ) {
    if( data instanceof OpenStackAuthTokenDescription ) {
      this.authTokenDesc = ( OpenStackAuthTokenDescription )data;
    }
    return true;
  }

  @Override
  public boolean canFinish() {
    return this.canFinish;
  }

  /**
   * Sets the flag whether this wizard page can be finished.
   * 
   * @param canFinish the flag to set
   */
  public void setCanFinish( final boolean canFinish ) {
    this.canFinish = canFinish;
  }

}
