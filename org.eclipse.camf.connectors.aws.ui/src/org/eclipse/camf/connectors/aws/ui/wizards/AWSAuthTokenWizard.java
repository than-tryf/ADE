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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.auth.AWSAuthToken;
import org.eclipse.camf.connectors.aws.auth.AWSAuthTokenDescription;
import org.eclipse.camf.connectors.aws.ui.Messages;
import org.eclipse.camf.connectors.aws.ui.internal.AWSKeyStoreCreationOperation;
import org.eclipse.camf.core.reporting.IProblem;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.camf.ui.wizards.CloudProviderSelectionWizardPage;
import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;


/**
 * A Wizard providing the infrastructure to create an {@link AWSAuthToken}. The
 * data input takes place in the {@link AWSAuthTokenWizardPage}. If the Wizard
 * is not able to create a {@link AWSAuthToken} with the provided details, an
 * {@link IProblem} with the id
 * <code>eu.geclipse.aws.ec2.problem.auth.authFailed</code> is evaluated and
 * displayed in a {@link ProblemDialog}.
 * 
 * @author Moritz Post
 * @see AWSAuthTokenWizardPage
 */
public class AWSAuthTokenWizard extends Wizard implements IInitializableWizard {

  /**
   * The {@link IAuthenticationTokenDescription} to generate the
   * {@link AWSAuthToken} from.
   */
  private AWSAuthTokenDescription authTokenDesc;

  /** The wizard page, which provides the form elements. */
  private AWSAuthTokenWizardPage authTokenWizardPage;

  /** The wizard page to select a Cloud Provider. */
  private CloudProviderSelectionWizardPage cpSelectionPage;

  /** A flag denoting if all the fields in the wizard are correctly filed. */
  private boolean canFinish;

  /**
   * The default constructor initializes the Wizard as unfinished.
   */
  public AWSAuthTokenWizard() {
    setCanFinish( false );
  }

  @Override
  public void addPages() {

    // show VO selection page if no vo is registered yet
    if( this.authTokenDesc != null ) {
      if( this.authTokenDesc.getAwsVo() == null ) {
        this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                          AWSCloudProvider.class );
        addPage( this.cpSelectionPage );
      }
      this.authTokenWizardPage = new AWSAuthTokenWizardPage( this,
                                                             this.authTokenDesc );
      addPage( this.authTokenWizardPage );
    } else {
      this.cpSelectionPage = new CloudProviderSelectionWizardPage( false,
                                                                   AWSCloudProvider.class );
      this.authTokenWizardPage = new AWSAuthTokenWizardPage( this, null );
      addPage( this.cpSelectionPage );
      addPage( this.authTokenWizardPage );
    }
    setNeedsProgressMonitor( true );
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "AWSAuthTokenWizard.wizard_title" ); //$NON-NLS-1$
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
    AWSAuthTokenDescription tokenDesc = this.authTokenWizardPage.getTokenDescription();
    AWSKeyStoreCreationOperation op = new AWSKeyStoreCreationOperation( tokenDesc );

    try {
      getContainer().run( false, false, op );
    } catch( InvocationTargetException itExc ) {
      Throwable cause = itExc.getCause();
      ProblemDialog.openProblem( getShell(),
                                 Messages.getString( "AWSAuthTokenWizard.problem_dialog_title" ), //$NON-NLS-1$
                                 Messages.getString( "AWSAuthTokenWizard.problem_dialog_description" ), //$NON-NLS-1$
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
    if( data instanceof AWSAuthTokenDescription ) {
      this.authTokenDesc = ( AWSAuthTokenDescription )data;
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
