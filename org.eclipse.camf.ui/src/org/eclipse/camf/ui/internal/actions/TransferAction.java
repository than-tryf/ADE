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

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.ui.actions.SelectionListenerAction;


/**
 * @author Nicholas Loulloudes
 *
 */
public class TransferAction extends SelectionListenerAction {
  /**
   * The clipboard used for the transfer.
   */
  private Clipboard clipboard;
  
  /**
   * Construct a new transfer action with the specified title that
   * uses the specified clipboard.
   * 
   * @param text The title of the action.
   * @param clipboard The {@link Clipboard} to be used for transfers.
   */
  protected TransferAction( final String text,
                            final Clipboard clipboard ) {
    super( text );
    this.clipboard = clipboard;
  }
  
  /**
   * Get the clipboard that is used for transfer within this action.
   * 
   * @return The {@link Clipboard} used for transfers.
   */
  public Clipboard getClipboard() {
    return this.clipboard;
  }
}
