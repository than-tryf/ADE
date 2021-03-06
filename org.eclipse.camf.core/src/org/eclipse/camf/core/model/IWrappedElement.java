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
 * Wrapped elements are elements that wrap other elements. This
 * is used in the grid model to show up elements at certain
 * locations that are located elsewhere in the model.
 */
public interface IWrappedElement extends ICloudElement {
  
  /**
   * Get the original (wrapped) element.
   * 
   * @return The wrapped element.
   */
  public ICloudElement getWrappedElement();
}
