/*****************************************************************************
 * Copyright (c) 2006-2008 g-Eclipse Consortium 
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

import org.eclipse.camf.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface IDefaultCloudElementManager extends ICloudElementManager {
  /**
   * Sets this manager default element.
   * 
   * @param defaultElement The element that should be set as default.
   * If the element is not yet contained in the manager it will be
   * added to the managers children.
   * 
   * @throws ProblemException If this manager can not handle the
   * specified element.
   * @see ICloudElementManager#canManage(ICloudElement)
   */
  public void setDefault( final ICloudElement defaultElement ) throws ProblemException;
  
  /**
   * The current default element of this manager.
   * 
   * @return The default element.
   */
  public ICloudElement getDefault();
}
