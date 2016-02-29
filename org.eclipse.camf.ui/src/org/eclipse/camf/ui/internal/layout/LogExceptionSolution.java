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
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *****************************************************************************/

package org.eclipse.camf.ui.internal.layout;

import org.eclipse.camf.core.reporting.ISolution;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LogExceptionSolution implements ISolution {

  /**
   * The ID of the PDE log view.
   */
  public static final String LOG_VIEW_ID = "org.eclipse.pde.runtime.LogView"; //$NON-NLS-1$
  
  private Throwable exception;
  
  public LogExceptionSolution( final Throwable exc ) {
    this.exception = exc;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolution#getDescription()
   */
  @Override
  public String getDescription() {
    return "Log exception"; //$NON-NLS-1$
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolution#getID()
   */
  @Override
  public String getID() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolution#isActive()
   */
  @Override
  public boolean isActive() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolver#solve()
   */
  @Override
  public void solve() {
    
    Activator.logException( this.exception );
    
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage page = window.getActivePage();
  
    try {
      page.showView( LOG_VIEW_ID );
    } catch ( PartInitException piExc ) {
      Activator.logException( piExc );
    }
    
  }
}
