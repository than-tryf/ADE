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
 *****************************************************************************/
package org.eclipse.camf.ui.wizards;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.model.impl.GenericCloudProviderCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.camf.ui.wizards.wizardselection.IInitializableWizard;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;



public class GenericCloudProviderWizard
extends Wizard
implements IInitializableWizard {

	private GenericCloudProvider initialVo;

	private static GenericCloudProvider newGenericCloudProvider;

	private GenericCloudProviderWizardPage cpPage;


	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {

		this.cpPage = new GenericCloudProviderWizardPage();

		if ( this.initialVo != null ) {
			this.cpPage.setInitialVo( this.initialVo );
		}

		addPage( this.cpPage );

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getWindowTitle()
	 */
	@Override
	public String getWindowTitle() {
		return "Generic Cloud Provider";
	}

	public boolean init( final Object initialData ) {
		boolean result = false;
		if ( initialData instanceof GenericCloudProvider ) {
			this.initialVo = ( GenericCloudProvider ) initialData;
			result = true;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		GenericCloudProviderCreator creator = new GenericCloudProviderCreator();


		IStatus result = this.cpPage.apply( creator );

		if ( result.isOK() ) {
			result = createVo( creator );
		}

		if ( ! result.isOK() ) {
			( ( WizardPage ) getContainer().getCurrentPage() ).setErrorMessage( result.getMessage() );
		}

		return result.isOK();

	}

	private IStatus createVo( final GenericCloudProviderCreator creator ) {

		IStatus result = Status.OK_STATUS;

		GenericCloudProvider vo = null;
		ICloudProviderManager manager = CloudModel.getCloudProviderManager();

		try {
			if ( this.initialVo != null ) {
				this.initialVo.setUri( creator.getVoURI() );
				this.initialVo.setPort( creator.getVoPort() );
				creator.apply( this.initialVo );
				GenericCloudProviderWizard.newGenericCloudProvider = this.initialVo;
			} else {
				vo = ( GenericCloudProvider ) manager.create( creator );
				GenericCloudProviderWizard.newGenericCloudProvider = vo;
			}
		} catch ( ProblemException pExc ) {
			result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, pExc.getLocalizedMessage(), pExc );
		}

		if ( ! result.isOK() && ( vo != null ) ) {
			try {
				manager.delete( vo );
			} catch ( ProblemException pExc ) {
				Activator.logException( pExc );
			}
		}   

		return result;

	}

	public static GenericCloudProvider getNewCloudProvider(){
		return GenericCloudProviderWizard.newGenericCloudProvider;
	}

}
