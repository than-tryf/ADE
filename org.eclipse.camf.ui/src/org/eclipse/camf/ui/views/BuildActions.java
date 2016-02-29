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
package org.eclipse.camf.ui.views;

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.BuildAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;


/**
 * @author Nicholas Loulloudes
 *
 */
public class BuildActions extends ActionGroup {
  /**
   * Workbench site that is used to create the build actions.
   */
  private IWorkbenchSite site;
  
  /**
   * The build action itself.
   */
  private BuildAction buildAction;
  
  /**
   * Construct a new build actions group for the specified
   * workbench site.
   * 
   * @param site The {@link IWorkbenchSite} for which to create
   * this build action group.
   */
  public BuildActions( final IWorkbenchSite site ) {
    
    this.site = site;
    ISelectionProvider provider = site.getSelectionProvider();
    
    this.buildAction = new BuildAction( site, IncrementalProjectBuilder.INCREMENTAL_BUILD );

    provider.addSelectionChangedListener( this.buildAction );
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#dispose()
   */
  @Override
  public void dispose() {
    ISelectionProvider provider = this.site.getSelectionProvider();
    provider.removeSelectionChangedListener( this.buildAction );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    if ( this.buildAction.isEnabled() ) {
      menu.appendToGroup( ICommonMenuConstants.GROUP_BUILD, 
                          this.buildAction );
    }
    super.fillContextMenu(menu);
  }
}
