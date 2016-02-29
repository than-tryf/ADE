/*****************************************************************************
 * Copyright (c) 2007-2008 g-Eclipse Consortium
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
 *    Nicholas Loulloudes - code adapter for CELAR Project, 2013
 *****************************************************************************/
package org.eclipse.camf.ui.internal;

import org.eclipse.camf.core.reporting.ISolution;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.internal.dialogs.ProblemReportDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ReportProblemSolution implements ISolution {

  /**
   * The throwable to be reported.
   */
  private Throwable exc;
  
  /**
   * The constructor. It will create a full error report if the parameter
   * is a {@link ProblemException}, a simpler one for generic throwables.
   * 
   * @param throwable the exception which has to be reported.
   */
  public ReportProblemSolution( final Throwable throwable ) {
    this.exc = throwable;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolution#getDescription()
   */
  @Override
  public String getDescription() {
    return "Create problem report"; //$NON-NLS-1$
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
    return this.exc != null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.reporting.ISolver#solve()
   */
  @Override
  public void solve() {
    ProblemReportDialog dialog = new ProblemReportDialog( getShell(), this.exc );
    dialog.open();
  }
  
  private Shell getShell() {
    
    Shell result = null;
    
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
    
    if ( window != null ) { 
      result = window.getShell();
    }

    return result;
    
  }
}
