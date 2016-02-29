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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.core.model;

import org.eclipse.camf.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ISerializableElementManager extends ICloudElementManager {
  /**
   * Save all currently managed elements. It is the managers
   * responsibility to save the elements to an appropriate
   * location. It is also the managers responsibility how the
   * elements should be saved (one per file or all in one big
   * file...).
   * 
   * @throws ProblemException If an error occurs during the
   * save operation. This may for example be due to an
   * <code>IOException</code>.
   */
  public void serializeElements() throws ProblemException;
  
  /**
   * Load the state of this manager from a predefined location.
   * It is the managers responsibility to determine the location
   * from which to load the state. It is also the managers
   * responsibility how the elements are loaded (one per file or
   * all elements in one big file...). Be aware of the fact that all
   * formerly contained elements are deleted before the managers loads
   * the new elements.
   * 
   * @throws ProblemException If an error occurs during the
   * load operation. This may for example be due to an
   * <code>IOException</code>.
   */
  public void deserializeElements() throws ProblemException;
}
