/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.views;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.CloseResourceAction;
import org.eclipse.ui.actions.OpenResourceAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ProjectActions extends ActionGroup {
  /**
   * The workbench site for which to create this action group.
   */
  private IWorkbenchSite site;
  
  /**
   * Open action for projects.
   */
  private OpenResourceAction openAction;
  
  /**
   * Close action for projects.
   */
  private CloseResourceAction closeAction;
  
  /**
   * Construct a new project action group for the specified workbench site.
   * 
   * @param site The {@link IWorkbenchSite} for which to create this action group.
   */
  public ProjectActions( final IWorkbenchSite site ) {
  
    this.site = site;
    Shell shell = site.getShell();
    ISelectionProvider provider = site.getSelectionProvider();
    IWorkspace workspace= ResourcesPlugin.getWorkspace();
    this.openAction = new OpenResourceAction( shell );
    this.closeAction = new CloseResourceAction( shell );
    
    provider.addSelectionChangedListener( this.openAction );
    provider.addSelectionChangedListener( this.closeAction );
    
    workspace.addResourceChangeListener( this.openAction );
    workspace.addResourceChangeListener( this.closeAction );
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#dispose()
   */
  @Override
  public void dispose() {
    ISelectionProvider provider = this.site.getSelectionProvider();
    provider.removeSelectionChangedListener( this.openAction );
    provider.removeSelectionChangedListener( this.closeAction );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    super.fillContextMenu( menu );
    if ( this.openAction.isEnabled() ) {
      menu.appendToGroup( ICommonMenuConstants.GROUP_BUILD,
                          this.openAction );
    }
    if ( this.closeAction.isEnabled() ) {
      menu.appendToGroup( ICommonMenuConstants.GROUP_BUILD,
                          this.closeAction );
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
   */
  @Override
  public void updateActionBars() {
    super.updateActionBars();
    
    IStructuredSelection selection = null;
    
    if( getContext() != null
        && getContext().getSelection() instanceof IStructuredSelection ) {
      selection = (IStructuredSelection)getContext().getSelection();
    }
    
    this.openAction.selectionChanged( selection );
    this.closeAction.selectionChanged( selection );    
  }
}
