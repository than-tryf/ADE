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
package org.eclipse.camf.ui.internal.actions;

import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenElementAction extends Action
  implements ISelectionChangedListener
{

  /**
   * Ordinary open file action.
   */
  private OpenFileAction openFileAction;
    
  /**
   * The currently active action.
   */
  private BaseSelectionListenerAction activeAction;
  
  /**
   * Create a new open element action for the specified workbench page.
   * 
   * @param page The {@link IWorkbenchPage} for which to create this
   * action.
   */
  protected OpenElementAction( final IWorkbenchSite site ) {
    
    super( Messages.getString("OpenElementAction.open_element_action_text") ); //$NON-NLS-1$
    
    IWorkbenchPage page = site.getPage();
    
    this.openFileAction = new OpenFileAction( page );
    
    ISelectionProvider provider = site.getSelectionProvider();
    if ( provider != null ) {
      ISelection selection = provider.getSelection();
      if ( selection instanceof IStructuredSelection ) {
        selectionChanged( ( IStructuredSelection ) selection );
      }
    }
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    if( this.activeAction != null ) {
      try {
        this.activeAction.run();
      } catch( RuntimeException exc ) {
        if( exc.getCause() instanceof ProblemException ) {
          ProblemException problemExc = ( ProblemException )exc.getCause();
          Shell shell = null;
          IWorkbench workbench = PlatformUI.getWorkbench();
          IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
          if( window != null ) {
            shell = window.getShell();
          }
          ProblemDialog.openProblem( shell,
                                     Messages.getString("OpenElementAction.problemDialogTitle"), //$NON-NLS-1$
                                     Messages.getString("OpenElementAction.problemCannotOpen"), //$NON-NLS-1$
                                     problemExc );
        } else {
          throw exc;
        }
      }
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
   */
  public void selectionChanged( final SelectionChangedEvent event ) {
    ISelection selection = event.getSelection();
    if ( selection instanceof IStructuredSelection ) {
      selectionChanged( ( IStructuredSelection ) selection );
    } else {
      selectionChanged( StructuredSelection.EMPTY );
    }
  }
  
  /**
   * Called whenever the selection of the action's selection provider has
   * changed.
   * 
   * @param selection The new selection.
   */
  public void selectionChanged( final IStructuredSelection selection ) {
    this.activeAction = null;
    if( selection != null ) {
      if( !selection.isEmpty() ) {
        this.activeAction = this.openFileAction;
      }
      if( this.activeAction != null ) {
        this.activeAction.selectionChanged( selection );
        setEnabled( this.activeAction.isEnabled() );
      } else {
        setEnabled( false );
      }
    } else {
      setEnabled( false );
    }
  }

}
