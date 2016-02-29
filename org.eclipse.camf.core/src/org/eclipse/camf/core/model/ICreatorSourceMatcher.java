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
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013 
 *****************************************************************************/
package org.eclipse.camf.core.model;


/**
 * This class is used by the org.eclipse.camf.core.cloudElementCreator extension point
 * in order to match a source object against a specific element creator.
 */
public interface ICreatorSourceMatcher {
  
  /**
   * Matcher method that determines if the corresponding
   * {@link ICloudElementCreator} can create an ICloudElement from the specified
   * object.
   * 
   * @param source The object from which to create an element.
   * @return True if the corresponding creator is potentially able to
   * create elements from the specified object. 
   */
  public boolean canCreate( final Object source );
  
}
