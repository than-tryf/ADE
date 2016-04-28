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

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;
import org.eclipse.camf.ui.decorators.CloudProjectFolderDecorator;
import org.eclipse.camf.ui.internal.actions.ActionGroupManager;
import org.eclipse.camf.ui.internal.actions.CommonActions;
import org.eclipse.camf.ui.internal.actions.FileActions;
import org.eclipse.camf.ui.internal.actions.OpenActions;
import org.eclipse.camf.ui.internal.actions.TreeViewerActions;
import org.eclipse.camf.ui.internal.transfer.SelectionTransferDragAdapter;
import org.eclipse.camf.ui.internal.transfer.SelectionTransferDropAdapter;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.util.DelegatingDragAdapter;
import org.eclipse.jface.util.DelegatingDropAdapter;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.ViewPart;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class CloudModelViewPart extends ViewPart implements ICloudModelListener {
	public CloudModelViewPart() {
	}
  
  StructuredViewer viewer;
  
  private ActionGroup actions;
  
  private OpenActions openActions;

  /* (non-Javadoc)
   * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createPartControl( Composite parent ) {
    this.viewer = createViewer( parent );
    initViewer( this.viewer );
    
    this.getSite().setSelectionProvider( this.viewer );
    
    this.actions = createActions();
    fillActionBars( this.actions );
    createContextMenu( this.viewer );
    
    CloudModel.getRoot().addCloudModelListener( this );
    
    updateActionBars();
  }
  
  private void updateActionBars() {
    if( this.actions != null) {
      ISelection selection = this.viewer.getSelection();
      this.actions.setContext(new ActionContext(selection));
      this.actions.updateActionBars();
    }
  }
  
  @Override
  public void dispose() {
    if( this.actions != null ) {
      this.actions.dispose();
    }
    CloudModel.getRoot().removeCloudModelListener( this );
    super.dispose();
  }
  
  public StructuredViewer getViewer() {
    return this.viewer;
  }
  
  @Override
  public void modelChanged( final ICloudModelEvent event ) {
    if ( ( event.getType() == ICloudModelEvent.ELEMENTS_ADDED )
        || ( event.getType() == ICloudModelEvent.ELEMENTS_REMOVED ) ) {
      refreshViewer( event.getSource() );
    } else if ( event.getType() == ICloudModelEvent.PROJECT_FOLDER_CHANGED ) {
      CloudProjectFolderDecorator decorator = CloudProjectFolderDecorator.getDecorator();
      if ( decorator != null ) {
        decorator.refresh( event.getElements() );
      }
    }
    
	 // Refresh Palette Compartments
    Display.getDefault().asyncExec(new Runnable() {
    	@Override
    	public void run() {
    		if (ToscaDiagramEditor.db != null){          
    			ToscaDiagramEditor.db.refreshPalette(); 
    		}
    	}
	  });
  }
  
  public boolean isDragSource( final ICloudElement element ) {
    return !element.isVirtual();
  }
  
  public void refreshViewer() {
    refreshViewer( null );
  }
  
  public void refreshViewer( final ICloudElement element ) {
    if ( this.viewer != null ) {
      Control control = this.viewer.getControl();
      if ( ! control.isDisposed() ) {
        Display display = control.getDisplay();
        display.asyncExec( new Runnable() {
          public void run() {
            if ( ! CloudModelViewPart.this.viewer.getControl().isDisposed() ) {
              if ( element == null ) {
                CloudModelViewPart.this.viewer.refresh( false );
              } else {
                CloudModelViewPart.this.viewer.refresh( element, false );
              }
            }
          }
        } );
      }
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
   */
  @Override
  public void setFocus() {
    this.viewer.getControl().setFocus();
  }
  
  protected void addDragSourceListeners( final DelegatingDragAdapter adapter ) {
    adapter.addDragSourceListener( new SelectionTransferDragAdapter( this ) );
  }
  
  protected void addDropTargetListeners( final DelegatingDropAdapter adapter ) {
    adapter.addDropTargetListener( new SelectionTransferDropAdapter() );
  }

  
  protected ActionGroup createActions() {
    ActionGroupManager manager = new ActionGroupManager();
    contributeAdditionalActions( manager );
    contributeStandardActions( manager );
    return manager;
  }
  
  protected void contributeAdditionalActions( final ActionGroupManager groups ) {
    // empty implementation
}
  
  protected void contributeStandardActions( final ActionGroupManager groups ) {
    this.openActions = new OpenActions( this );
    groups.addGroup( this.openActions );
    FileActions fileActions = new FileActions( this );
    groups.addGroup( fileActions );

    CommonActions commonActions = new CommonActions( this );
    groups.addGroup( commonActions );
    StructuredViewer sViewer = getViewer();
    if( sViewer instanceof TreeViewer ) {
      TreeViewer tViewer = ( TreeViewer )sViewer;
      TreeViewerActions treeViewerActions = new TreeViewerActions( tViewer );
      groups.addGroup( treeViewerActions );
    }
  }

  protected abstract IContentProvider createContentProvider();

  protected void createContextMenu( final StructuredViewer sViewer ) {
    MenuManager manager = new MenuManager();
    manager.setRemoveAllWhenShown( true );
    manager.addMenuListener( new IMenuListener() {

      public void menuAboutToShow( final IMenuManager mgr ) {
        fillContextMenu( mgr );
      }
    } );
    Menu menu = manager.createContextMenu( sViewer.getControl() );
    sViewer.getControl().setMenu( menu );
    getSite().registerContextMenu( manager, sViewer );
  }
  
  protected void createContextMenuGroups( final IMenuManager menu ) {
    menu.add( new Separator( ICommonMenuConstants.GROUP_NEW ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_GOTO ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_OPEN ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_OPEN_WITH ) );    
    menu.add( new Separator( ICommonMenuConstants.GROUP_EDIT ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_SHOW ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_REORGANIZE ) );
    menu.add( new GroupMarker( ICommonMenuConstants.GROUP_PORT ) );
    menu.add( new Separator( ICommonMenuConstants.GROUP_GENERATE ) );
    menu.add( new Separator( ICommonMenuConstants.GROUP_SEARCH ) );
    menu.add( new Separator( ICommonMenuConstants.GROUP_BUILD ) );
    menu.add( new Separator( ICommonMenuConstants.GROUP_ADDITIONS ) );
    menu.add( new Separator( ICommonMenuConstants.GROUP_PROPERTIES ) );
  }
  
  protected abstract IBaseLabelProvider createLabelProvider();
  
  protected abstract StructuredViewer createViewer( final Composite parent );
  
  protected void fillActionBars( final ActionGroup group ) {
    IActionBars actionBars = getViewSite().getActionBars();
    group.fillActionBars( actionBars );
  }
  
  protected void fillContextMenu( final IMenuManager menu ) {
    ISelection selection = this.viewer.getSelection();
    ActionContext context = new ActionContext( selection );
    createContextMenuGroups( menu );
    this.actions.setContext( context );
    this.actions.fillContextMenu( menu );
    this.actions.setContext( null );
  }
  
  protected abstract ICloudElement getRootElement();
  
  protected void handleDoubleClick( final DoubleClickEvent event ) {
    if ( this.viewer instanceof TreeViewer ) {
      TreeViewer treeViewer = ( TreeViewer ) this.viewer;
      ISelection selection = event.getSelection();
      if ( selection instanceof IStructuredSelection ) {
        Object element
          = ( ( IStructuredSelection ) selection ).getFirstElement();
        if ( treeViewer.isExpandable( element ) ) {
          boolean state = treeViewer.getExpandedState( element );
          treeViewer.setExpandedState( element, !state );
        }
      }
    }
  }
  
  protected void handleOpen( final OpenEvent event ) {
    this.openActions.delegateOpenEvent( event );
  }
  
  protected void initDragAndDrop( final StructuredViewer sViewer ) {
    initDrag( sViewer );
    initDrop( sViewer );
  }
  
  protected void initDrag( final StructuredViewer sViewer ) {
    int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
    DelegatingDragAdapter adapter = new DelegatingDragAdapter();
    addDragSourceListeners( adapter );
    sViewer.addDragSupport( operations, adapter.getTransfers(), adapter );
  }
  
  protected void initDrop( final StructuredViewer sViewer ) {
    int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
    DelegatingDropAdapter adapter = new DelegatingDropAdapter();
    addDropTargetListeners( adapter );
    sViewer.addDropSupport( operations, adapter.getTransfers(), adapter );
  }
  
  protected void initViewer( final StructuredViewer sViewer ) {
    sViewer.setLabelProvider( createLabelProvider() );
    sViewer.setContentProvider( createContentProvider() );
    sViewer.setInput( getRootElement() );
    registerViewerListeners( sViewer );
    initDragAndDrop( sViewer );
  }
  
  protected void registerViewerListeners( final StructuredViewer sViewer ) {
    sViewer.addDoubleClickListener( new IDoubleClickListener() {
      @Override
      public void doubleClick( final DoubleClickEvent event ) {
        handleDoubleClick( event );
      }
    } );
    sViewer.addOpenListener( new IOpenListener() {
      @Override
      public void open( final OpenEvent event ) {
        handleOpen( event );
      }
    } );
  }


}
