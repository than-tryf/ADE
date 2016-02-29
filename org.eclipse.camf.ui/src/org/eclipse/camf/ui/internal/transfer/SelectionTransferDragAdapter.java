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

package org.eclipse.camf.ui.internal.transfer;

import java.util.Iterator;

import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.ui.views.CloudModelViewPart;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;


/**
 * @author Nicholas Loulloudes
 *
 */
public class SelectionTransferDragAdapter implements TransferDragSourceListener
{

private CloudModelViewPart view;
  

  public SelectionTransferDragAdapter( final CloudModelViewPart view ) {
    Assert.isNotNull( view );
    this.view = view;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.util.TransferDragSourceListener#getTransfer()
   */
  public Transfer getTransfer() {
    return LocalSelectionTransfer.getTransfer();
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
   */
  public void dragFinished( final DragSourceEvent event ) {
    LocalSelectionTransfer.getTransfer().setSelection(null);
    LocalSelectionTransfer.getTransfer().setSelectionSetTime(0);
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
   */
  public void dragSetData( final DragSourceEvent event ) {
    event.data = LocalSelectionTransfer.getTransfer().getSelection();
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
   */
  public void dragStart( final DragSourceEvent event ) {
    ISelection selection = this.view.getViewer().getSelection();
    event.doit = isDragable( selection );
    if ( event.doit ) {
      LocalSelectionTransfer.getTransfer().setSelection( selection );
      LocalSelectionTransfer.getTransfer().setSelectionSetTime( event.time & 0xFFFFFFFFL );
    }
  }
  
  /**
   * Determines if the specified selection contains only dragable elements.
   * 
   * @param selection The selection to be tested.
   * @return True if {@link CloudModelViewPart#isDragSource(ICloudElement)} returns
   * true for all elements contained in the specified selection.
   */
  protected boolean isDragable( final ISelection selection ) {
    boolean result = true;
    if ( !selection.isEmpty() && ( selection instanceof IStructuredSelection ) ) {
      IStructuredSelection sSelection = ( IStructuredSelection ) selection;
      Iterator< ? > iter = sSelection.iterator();
      while ( iter.hasNext() && result ) {
        Object obj = iter.next();
        if ( !( obj instanceof ICloudElement )
            || !this.view.isDragSource( ( ICloudElement ) obj ) ) {
          result = false;
        }
      }
    }
    return result;
  }
}
