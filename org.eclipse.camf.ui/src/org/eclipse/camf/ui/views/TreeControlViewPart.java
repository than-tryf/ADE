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

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.ui.comparators.TreeColumnComparator;
import org.eclipse.camf.ui.listeners.TreeColumnListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class TreeControlViewPart extends CloudModelViewPart implements ISelectionListener {
  
  @Override
  public void refreshViewer( final ICloudElement element ) {
    if ( ( element != null ) && ( element instanceof ICloudContainer ) ) {
      final ICloudContainer container = ( ICloudContainer ) element;
      if ( container.isLazy() && container.isDirty() ) {
        Control control = this.viewer.getControl();
        if ( ! control.isDisposed() ) {
          Display display = control.getDisplay();
          display.syncExec( new Runnable() {
            public void run() {
              TreeViewer tViewer = ( TreeViewer ) getViewer();
              tViewer.setChildCount( container, container.getChildCount() );
              System.out.println("Refreshing");
            }
          } );
        }
      }
    }
    super.refreshViewer( element );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer( final Composite parent ) {
    TreeViewer tViewer = new TreeViewer( parent, SWT.VIRTUAL | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    Tree tree = tViewer.getTree();
    boolean hasColumns = createTreeColumns( tree );
    if ( hasColumns ) {
      tree.setHeaderVisible( true );

      // Add listener for column sorting
      TreeColumnListener columnListener = new TreeColumnListener( tViewer );
      for ( TreeColumn column : tree.getColumns() ) {
        column.addSelectionListener( columnListener );
      }
      
      // Initially sort by the first column, ascending
      TreeColumn firstColumn = tree.getColumn( 0 );
      tree.setSortColumn( firstColumn );
      tree.setSortDirection( SWT.UP );
      // Set also the first column as fallback sorting column
      tViewer.setComparator( new TreeColumnComparator( firstColumn ) );
      
      getViewSite().getPage().addSelectionListener(this);
    }
    
    return tViewer;
  }
  
  protected boolean createTreeColumns( @SuppressWarnings("unused") final Tree tree )
  {
    return false;
  }
  
  @Override
  public void selectionChanged( IWorkbenchPart part, ISelection selection ) {
    int i=0;
    if ( i==0 )
      System.out.println("hi");
    
  }
  
}
