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

import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.ui.Messages;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;

/**
 * This {@link Wizard} creates a new {@link AWSCloudProvider}.
 * 
 * @author Moritz Post
 */
public class AWSCloudProviderWizard extends Wizard implements IInitializableWizard {

  /** The {@link WizardPage} providing the form elements. */
  private AWSCloudProviderWizardPage wizardPage;

  /** The initial Cloud Provider. */
  private AWSCloudProvider initialCloudProvider;

  @Override
  public boolean performFinish() {
    return this.wizardPage.createCloudProvider();
  }

  public boolean init( final Object data ) {
    if( data instanceof AWSCloudProvider ) {
      this.initialCloudProvider = ( AWSCloudProvider )data;
      return true;
    }
    return false;
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "AWSCloudProviderWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public void addPages() {
    this.wizardPage = new AWSCloudProviderWizardPage();

    if( this.initialCloudProvider != null ) {
      this.wizardPage.setInitialVo( this.initialCloudProvider );
    }
    addPage( this.wizardPage );
  }
}
