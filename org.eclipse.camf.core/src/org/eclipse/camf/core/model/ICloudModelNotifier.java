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
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.model;

import org.eclipse.camf.internal.model.notify.CloudModelEvent;

/**
 * Definition of a notification service for {@link CloudModelEvent}s.
 */
public interface ICloudModelNotifier {
  
  /**
   * Add the specified {@link ICloudModelListener} to the list
   * of listeners.
   * 
   * @param listener The listener to be added.
   */
  public void addCloudModelListener( final ICloudModelListener listener );
  /**
   * Remove the specified {@link ICloudModelListener} from the list
   * of listeners.
   * 
   * @param listener The listener to be removed. 
   */
  public void removeCloudModelListener( final ICloudModelListener listener );
}
