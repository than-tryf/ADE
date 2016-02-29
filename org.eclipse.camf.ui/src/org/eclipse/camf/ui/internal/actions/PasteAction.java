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

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


/**
 * @author Nicholas Loulloudes
 *
 */
public class PasteAction extends TransferAction {
  /**
   * Create a new paste action for the specified view using the specified
   * clipboard.
   * 
   * @param clipboard The {@link Clipboard} used for the copy/paste operation.
   */
  public PasteAction( final Clipboard clipboard ) {
    super( Messages.getString("PasteAction.paste_action_text"), clipboard ); //$NON-NLS-1$
    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    ImageDescriptor pasteImage = sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_PASTE );
    setImageDescriptor( pasteImage );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    Clipboard clipboard = getClipboard();
    LocalSelectionTransfer transfer = LocalSelectionTransfer.getTransfer();
    IStructuredSelection source = ( IStructuredSelection ) clipboard.getContents( transfer );
    IStructuredSelection target = getStructuredSelection();
    startTransfer( source, target );
  }
  
  protected void startTransfer( final IStructuredSelection source,
                                final IStructuredSelection target ) {
    
    if ( ! isEmpty( source ) && ! ( isEmpty( target ) ) ) {
      
      Object[] sourceArray
        = source.toArray();
      ICloudElement[] sourceElements
        = new ICloudElement[ source.size() ];
      
      for ( int i = 0 ; i < sourceArray.length ; i++ ) {
        
        if ( sourceArray[ i ] instanceof ICloudElement ) {
          sourceElements[ i ] = ( ICloudElement ) sourceArray[ i ];
        } else {
          // TODO mathias error handling
        }
        
      }
      
      Object targetObject
        = target.getFirstElement();
      ICloudContainer targetContainer = null;
      
      if ( targetObject instanceof ICloudContainer ) {
        targetContainer = ( ICloudContainer ) targetObject;
      } else {
        // TODO mathias error handling
      }
      
      if ( targetContainer != null ) {
        startTransfer( sourceElements, targetContainer );
      }
      
    }
    
  }
  
  protected void startTransfer( final ICloudElement[] sources,
                                final ICloudContainer target ) {
    
//    CloudElementTransferOperation op
//      = new CloudElementTransferOperation( sources, target, false );
//    op.setUser( true );
//    op.schedule();
    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.BaseSelectionListenerAction#updateSelection(org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  protected boolean updateSelection( final IStructuredSelection selection ) {
    
    boolean result = super.updateSelection( selection );
    
    if ( result
        && ( selection.size() == 1 )
        && ( selection.getFirstElement() instanceof ICloudContainer ) ) {
      
      Clipboard clipboard
        = getClipboard();
      TransferData[] data
        = clipboard.getAvailableTypes();
      LocalSelectionTransfer transfer = LocalSelectionTransfer.getTransfer();
      
      result = false;
      
      for ( TransferData d : data ) {
        if ( transfer.isSupportedType( d ) ) {
          result = true;
          break;
        }
      }
      
    }
    
    return result;
    
  }
  
  private boolean isEmpty( final ISelection selection ) {
    return ( selection == null ) || ( selection.isEmpty() ); 
  }
}
