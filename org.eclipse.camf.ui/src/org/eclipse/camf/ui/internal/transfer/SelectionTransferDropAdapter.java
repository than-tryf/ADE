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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Widget;


/**
 * @author Nicholas Loulloudes
 *
 */
public class SelectionTransferDropAdapter implements TransferDropTargetListener
{

  /**
   * The current target of the DND-operation.
   */
  private ICloudContainer lastTarget;
  
  /**
   * The last detail of the transfer.
   */
  private int lastDetail;
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.util.TransferDropTargetListener#getTransfer()
   */
  public Transfer getTransfer() {
	 System.out.println("[*]"+getClass().getName()+" Drop: getTransfer");
    return LocalSelectionTransfer.getTransfer();
	 //return TextTransfer.getInstance();
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.util.TransferDropTargetListener#isEnabled(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public boolean isEnabled( final DropTargetEvent event ) {
	System.out.println("IN drop -> isenabled");
    ICloudContainer target = getTarget( event );
    //System.out.println("[*]"+getClass().getName()+" @ICloudContainer target: "+target.toString());
    //return target != null;
	  return true;
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void dragEnter( final DropTargetEvent event ) {
	System.out.println("[*]"+getClass().getName()+" Drop: dragEnter");
    this.lastTarget = getTarget( event );
    this.lastDetail = event.detail;
    validateDrop( event );
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void dragLeave( final DropTargetEvent event ) {
	 System.out.println("[*]"+getClass().getName()+" Drop: dragLeave");
    this.lastTarget = null;
    this.lastDetail = DND.DROP_NONE;
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void dragOperationChanged( final DropTargetEvent event ) {
	  System.out.println("[*]"+getClass().getName()+" Drop: dragOperationChanged");
    this.lastDetail = event.detail;
    validateDrop( event );
    computeFeedback( event );
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void dragOver( final DropTargetEvent event ) {
	  System.out.println("[*]"+getClass().getName()+" Drop: dragOver");
    ICloudContainer newTarget = getTarget( event );
    if ( newTarget != this.lastTarget ) {
      this.lastTarget = newTarget;
      validateDrop( event );
    }
    computeFeedback( event );
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void drop( final DropTargetEvent event ) {
    
//    ICloudContainer target = getTarget( event );    
//    
//    ICloudElement[] elements = getElements();
//    CloudElementTransferOperation op = null;
//    
//    switch ( event.detail ) {
//      case DND.DROP_COPY:
//        op = new CloudElementTransferOperation( elements, target, false );
//        break;
//      case DND.DROP_MOVE:
//        op = new CloudElementTransferOperation( elements, target, true );
//        break;
//    }
//    
//    if ( op != null ) {
//      op.setUser( true );
//      op.setPriority( Job.LONG );
//      op.schedule();
//    } else {
//      event.detail = DND.DROP_NONE;
//    }
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.swt.dnd.DropTargetListener#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
   */
  public void dropAccept( final DropTargetEvent event ) {
	  System.out.println("[*]"+getClass().getName()+" Drop: dropAccept");
    this.lastTarget = getTarget( event );
    validateDrop( event );
    this.lastDetail = event.detail;
  }
  
  /**
   * Compute the drag over effect feedback for the specified
   * {@link DropTargetEvent}.
   * 
   * @param event The event to apply the computed feedback.
   */
  protected void computeFeedback( final DropTargetEvent event ) {
    event.feedback
      = DND.FEEDBACK_EXPAND
      | DND.FEEDBACK_SCROLL
      | DND.FEEDBACK_SELECT;
  }
  
  /**
   * Get the Cloud elements that are contained in the specified
   * {@link DropTargetEvent}. This methods returns <code>null</code>
   * if not all dragged elements are {@link ICloudElement}s.
   * 
   * @param event The event from which to get the elements.
   * @return All Cloud element that are contained in the specified
   * event.
   */
  protected ICloudElement[] getElements() {
    ICloudElement[] result = null;
    ISelection selection
      = LocalSelectionTransfer.getTransfer().getSelection();
    if ( selection instanceof IStructuredSelection ) {
      IStructuredSelection sSelection
        = ( IStructuredSelection ) selection;
      Iterator< ? > iter = sSelection.iterator();
      List< ICloudElement > elements = new ArrayList< ICloudElement >();
      while ( iter.hasNext() ) {
        Object obj = iter.next();
        if ( obj instanceof ICloudElement ) {
          elements.add( ( ICloudElement ) obj ); 
        }
      }
      if ( elements.size() == sSelection.size() ) {
        result = elements.toArray( new ICloudElement[ elements.size() ] );
      }
    }
    return result;
  }
  
  /**
   * Get the target that is contained in the specified event. If the
   * target is not present or the target is not an {@link ICloudContainer}
   * this method returns <code>null</code>.
   * 
   * @param event The event from which the retrieve the target.
   * @return The current target of the DND-operation. 
   */
  protected ICloudContainer getTarget( final DropTargetEvent event ) {
    ICloudContainer result = null;
    Widget item = event.item;
    if ( item != null ) {
      Object data = item.getData();
      if ( ( data != null ) && ( data instanceof ICloudContainer ) ) {
        result = ( ICloudContainer ) data;
      }
    }
    return result;
  }
  
  /**
   * Validate the drop, i.e. set the detail field of the specified
   * {@link DropTargetEvent} according to the policies of the
   * Cloud model.
   * 
   * @param event The event to be modified.
   */
  protected void validateDrop( final DropTargetEvent event ) {
	  System.out.println("I am at Validate Drop!");
    int ops = computeDropOperations( event );
    //if ( ( ops & event.detail ) == 0 ) {
    if ( ( ops & this.lastDetail ) != 0 ) {
      event.detail = this.lastDetail;
    } else {
      if ( ( ops & DND.DROP_DEFAULT ) != 0 ) {
        event.detail = DND.DROP_DEFAULT;
      } else if ( ( ops & DND.DROP_MOVE ) != 0 ) {
        event.detail = DND.DROP_MOVE;
      } else if ( ( ops & DND.DROP_COPY ) != 0 ) {
        event.detail = DND.DROP_COPY;
      } else {
        event.detail = DND.DROP_NONE;
      }
    }
  }
  
  /**
   * Compute the drop operation for the dragged elements.
   * 
   * @param event The drop target event.
   * @return The new drop operations.
   */
  protected int computeDropOperations( final DropTargetEvent event ) {
    int ops = DND.DROP_NONE;

    System.out.println("I am here");
    
    if ( this.lastTarget != null ) {
    	
      ICloudElement[] elements = getElements();
      if ( ( elements != null ) && ( elements.length > 0 ) ) {
        ops = event.operations;
        for ( ICloudElement element : elements ) {
          ops &= computeDropOperations( this.lastTarget, element );
          if ( ops == DND.DROP_NONE ) {
            break;
          }
        }
      }
    }
    return ops;
  }
  
  /**
   * Compute the drop operations that are allowed for the specified
   * combination of target and element.
   * 
   * @param target The target of the drop operation.
   * @param element The element beeing dragged.
   * @return A bitwise combination of {@link DND.DROP_COPY} and
   * {@link DND.DROP_MOVE} or simply {@link DND.DROP_NONE}.
   */
  protected int computeDropOperations( final ICloudContainer target,
                                       final ICloudElement element ) {
    
    int result = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_DEFAULT;
    
    if ( ( target == element )
        || ( target == element.getParent() )
        || !target.canContain( element ) ) {
      result = DND.DROP_NONE;
    }
    
    else {
      
      boolean tLocal = isLocal( target );
      boolean eLocal = isLocal( element );
      
      if ( !tLocal || !eLocal ) { // remote -> local || local -> remote || remote -> remote 

        if ( !tLocal && !eLocal ) { // remote -> remote
          ICloudElement tParent = findLastRemoteElement( target );
          ICloudElement eParent = findLastRemoteElement( element );
          if ( tParent != eParent ) { // different connections
            result = DND.DROP_COPY;
          } // else result = default
        }
        
        else { // remote -> local || local -> remote
          if ( !eLocal ) { // remote -> local
            ICloudElement eParent = findLastRemoteElement( element );
            if ( eParent != element ) { // not a connection root
              result = DND.DROP_COPY;
            } // else result = default
          } else { // local -> remote
            result = DND.DROP_COPY;
          }
        }
        
      }
      
    }
    
    return result;
    
  }
  
  /**
   * Find the last remote parent in the list of parents of the specified
   * element. This method walks down the list of parents of the element and
   * returns the first element whose {@link ICloudElement#isLocal()} method
   * returns false.
   * 
   * @param element The element to be queried.
   * @return The last parent of the specified element that is not local.
   */
  private ICloudElement findLastRemoteElement( final ICloudElement element ) {
    ICloudElement result = element;
    ICloudElement parent = element.getParent();
    while ( ( parent != null ) && !parent.isLocal() ) {
      result = parent;
      parent = parent.getParent(); 
    }
    return result;
  }
  
  private boolean isLocal( final ICloudElement element ) {
    boolean local = false;
    
    if( element.isLocal() ) {
      local = true;
    } 
    
    return local;    
  }

}
