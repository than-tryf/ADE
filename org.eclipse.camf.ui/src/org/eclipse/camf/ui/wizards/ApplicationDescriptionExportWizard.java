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
 * 	Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.ui.wizards.jobs.CSARExportOperation;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;


/**
 * @author nickl
 *
 */
public class ApplicationDescriptionExportWizard extends Wizard
  implements IExportWizard
{

  /* (non-Javadoc)
   * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
   */
  
  private ApplicationDescriptionExportWizardPage exportPage;
  private IStructuredSelection selection;
  
  @Override
  public void init( final IWorkbench workbench, final IStructuredSelection selection ) {
    this.selection = selection;
    setWindowTitle( "Application Description Export Wizard" );
    setNeedsProgressMonitor( true );
  }
  
  public void addPages() {
   super.addPages();
   IStructuredSelection modelSelection = null;
   if (this.selection instanceof TOSCAResource) {
     TOSCAModel model= ((TOSCAResource) this.selection.getFirstElement()).getTOSCAModel();
     modelSelection = (IStructuredSelection) model;
   }
   exportPage = new ApplicationDescriptionExportWizardPage( "Application", modelSelection );
   addPage( exportPage );
  }
  
  /**
   * Exports the CSAR.
   *
   * @param op the op
   * @return a boolean indicating success or failure
   */
  protected boolean executeExportOperation( CSARExportOperation op ) {
    try {
      getContainer().run( true, true, op );
    } catch( InterruptedException e ) {
      return false;
    } catch( InvocationTargetException ex ) {
      if( ex.getTargetException() != null ) {

        return false;
      }
    }
    /*IStatus status = op.getStatus();
    if( !status.isOK() ) {
      ErrorDialog.openError( getShell(),
                             "CSAR export title",
                             null,
                             status );
      return !( status.matches( IStatus.ERROR ) );
    }*/
    return true;
  }
  
  

  /* (non-Javadoc)
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    executeExportOperation( new CSARExportOperation( this.exportPage.getSelectedResources(), this.exportPage.getDestinationValue() ) );
    return true;
  }
}
