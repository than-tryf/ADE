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
 *  Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package org.eclipse.camf.ui.internal.actions;


import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionGroup;


/**
 * @author nickl
 *
 */
public class ExportDescriptionActions extends ActionGroup {
  
  private IWorkbenchSite site;
  
  private ExportMenu menu;
  
  public ExportDescriptionActions (final IWorkbenchSite site) {
    this.site = site;
    this.menu = new ExportMenu( site );
    ISelectionProvider provider = site.getSelectionProvider();
    provider.addSelectionChangedListener( this.menu );
  }
  
  
  @Override
  public void dispose() {
    ISelectionProvider selectionProvider = this.site.getSelectionProvider();
    selectionProvider.removeSelectionChangedListener( this.menu );
    this.menu.dispose();
  }
  
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    
    if ( this.menu.isVisible() ) {
      IMenuManager subMenu = new MenuManager(Messages.getString( "ExportActions.ExportTo" )); //$NON-NLS-1$
      menu.appendToGroup( IContextMenuConstants.GROUP_GENERATE, subMenu );
      subMenu.add( this.menu );
    }
    
    super.fillContextMenu( menu );
    
  }
  
}
