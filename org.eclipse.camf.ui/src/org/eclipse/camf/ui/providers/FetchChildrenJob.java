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
package org.eclipse.camf.ui.providers;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.core.util.MasterMonitor;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Shell;


/**
 * @author Nicholas Loulloudes
 *
 */
public class FetchChildrenJob extends Job {

  private ICloudContainer container;
  
  private IProgressMonitor externalMonitor;
  
  private Shell shell;
  
  /**
   * @param container
   * @param shell
   */
  public FetchChildrenJob( final ICloudContainer container, final Shell shell ) {
    super( "Fetching Children of " + container.getName() ); //$NON-NLS-1$
    this.container = container;
    this.shell = shell;
  }
  
  /**
   * @param monitor
   */
  public void setExternalMonitor( final IProgressMonitor monitor ) {
    this.externalMonitor = monitor;
  }

  @Override
  protected IStatus run( final IProgressMonitor monitor ) {

    IStatus result = Status.OK_STATUS;
    MasterMonitor mMonitor = new MasterMonitor( monitor, this.externalMonitor );
    
    try {
      this.container.setDirty();
      this.container.getChildren( mMonitor );
      result = Status.OK_STATUS;
    } catch ( ProblemException pExc ) {
      ProblemDialog.openProblem( this.shell,
                                 "Fetch Error", //$NON-NLS-1$
                                 "Error while fetching children of " + this.container.getName(), //$NON-NLS-1$
                                 pExc );
    } finally {
      mMonitor.done();
    }
    
    return result;
    
  }

}
