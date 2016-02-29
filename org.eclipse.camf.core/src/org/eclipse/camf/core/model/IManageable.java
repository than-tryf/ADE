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


/**
 * Cloud elements that implement this interface have an associated
 * {@link ICloudElementManager} who is responsible to manage all
 * instances of this special type of element.
 */
public interface IManageable extends ICloudElement {
  
  /**
   * Get the manager that is responsible for the element.
   * 
   * @return This element's {@link ICloudElementManager}.
   */
  public ICloudElementManager getManager();
  
}
