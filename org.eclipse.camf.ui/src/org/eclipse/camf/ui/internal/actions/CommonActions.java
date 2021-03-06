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

import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.camf.ui.internal.CloudElementSelectionAdapter;
import org.eclipse.camf.ui.views.CloudModelViewPart;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.window.SameShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CommonActions extends ActionGroup {
  
  /**
   * The refresh action.
   */
  RefreshAction refreshAction;
  
  /**
   * The {@link IWorkbenchSite} this action is associated with.
   */
  private IWorkbenchSite site;
  
  /**
   * The {@link CloudElementSelectionAdapter} used to map the current selection.
   */
  private CloudElementSelectionAdapter selectionAdapter;
  
  /**
   * The {@link PropertyDialogAction}.
   */
  private PropertyDialogAction propertyAction;
  
  /**
   * Construct a new <code>CommonActions</code> action group for the
   * specified {@link IWorkbenchSite}.
   * 
   * @param part The {@link CloudModelViewPart} this action is associated with.
   */
  public CommonActions( final CloudModelViewPart part ) {
  
    this.site = part.getSite();
    Shell shell = this.site.getShell();
    IShellProvider shellProvider = new SameShellProvider( shell );
    ISelectionProvider selectionProvider = this.site.getSelectionProvider();
    
    this.selectionAdapter = new CloudElementSelectionAdapter();
    selectionProvider.addSelectionChangedListener( this.selectionAdapter );
    
    this.propertyAction
      = new PropertyDialogAction( shellProvider, this.selectionAdapter );
    
    this.refreshAction = new RefreshAction( shell );
    this.refreshAction.setText( Messages.getString("CommonActions.refresh") ); //$NON-NLS-1$
    selectionProvider.addSelectionChangedListener( this.refreshAction );
    
    ImageRegistry imgReg = Activator.getDefault().getImageRegistry();
    Image image = imgReg.get( "refresh" ); //$NON-NLS-1$
    ImageDescriptor refreshImage = ImageDescriptor.createFromImage( image );
    this.refreshAction.setImageDescriptor( refreshImage );
    
    part.getViewer().getControl().addKeyListener( new KeyAdapter() {
      @Override
      public void keyPressed( final KeyEvent e ) {
        if ( e.keyCode == SWT.F5 ) {
          CommonActions.this.refreshAction.run();
        }
      }
    } );
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#dispose()
   */
  @Override
  public void dispose() {
    ISelectionProvider selectionProvider = this.site.getSelectionProvider();
    selectionProvider.removeSelectionChangedListener( this.selectionAdapter );
    selectionProvider.removeSelectionChangedListener( this.refreshAction );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu( final IMenuManager menu ) {
    if ( this.propertyAction.isEnabled() ) {
      menu.appendToGroup( ICommonMenuConstants.GROUP_PROPERTIES, 
                          this.propertyAction );
    }
    if ( this.refreshAction.isEnabled() ) {
      menu.appendToGroup( ICommonMenuConstants.GROUP_BUILD,
                          this.refreshAction );
    }
    super.fillContextMenu(menu);
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
    
    this.refreshAction.selectionChanged( selection );
    this.propertyAction.selectionChanged( selection );
  }
}
