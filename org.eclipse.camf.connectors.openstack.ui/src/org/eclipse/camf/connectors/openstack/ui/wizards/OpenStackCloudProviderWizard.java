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

import org.eclipse.camf.connectors.openstack.OpenStackCloudProvider;
import org.eclipse.camf.connectors.openstack.ui.Messages;
import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

/**
 * This {@link Wizard} creates a new {@link OpenStackCloudProvider}.
 * 
 * @author Moritz Post
 */
public class OpenStackCloudProviderWizard extends Wizard implements IInitializableWizard {

  /** The {@link WizardPage} providing the form elements. */
  private OpenStackCloudProviderWizardPage wizardPage;

  /** The initial Cloud Provider. */
  private OpenStackCloudProvider initialCloudProvider;

  @Override
  public boolean performFinish() {
    return this.wizardPage.createCloudProvider();
  }

  public boolean init( final Object data ) {
    if( data instanceof OpenStackCloudProvider ) {
      this.initialCloudProvider = ( OpenStackCloudProvider )data;
      return true;
    }
    return false;
  }

  @Override
  public String getWindowTitle() {
    return Messages.getString( "OpenStackCloudProviderWizard.wizard_title" ); //$NON-NLS-1$
  }

  @Override
  public void addPages() {
    this.wizardPage = new OpenStackCloudProviderWizardPage();

    if( this.initialCloudProvider != null ) {
      this.wizardPage.setInitialCloudProvider( this.initialCloudProvider );
    }
    addPage( this.wizardPage );
  }
}
