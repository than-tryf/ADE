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
 *  Nicholas Loulloudes - Initial Implementation
 *  
 ********************************************************************************/

package org.eclipse.camf.ui.internal.actions;

import org.eclipse.camf.ui.views.CloudModelViewPart;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionGroup;


/**
 * @author Nicholas Loulloudes
 *
 */
public class EditorActions extends ActionGroup {
  
  private CloudModelViewPart view;
  
  /**
   * The link with editor action.
   */
  private LinkWithEditorAction linkWithEditorAction;
  
  /**
   * Construct a new editor actions group.
   * 
   * @param view The view this group belongs to.
   */
  public EditorActions( final CloudModelViewPart view ) {
    this.view = view;
    this.linkWithEditorAction = new LinkWithEditorAction( view );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars( final IActionBars actionBars ) {
    IToolBarManager manager = actionBars.getToolBarManager();
    manager.add( this.linkWithEditorAction );
  }
  
  /**
   * Get the associated view of this editor actions.
   * 
   * @return The associated view.
   */
  public CloudModelViewPart getView() {
    return this.view;
  }
  
  /**
   * Delegate a link editor action to the associated action's
   * run method.
   */
  public void delegateLinkEditorAction() {
    this.linkWithEditorAction.run();
  }
  
}
