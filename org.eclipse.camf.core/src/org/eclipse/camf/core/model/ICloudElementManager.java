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
import org.eclipse.core.runtime.IProgressMonitor;


/**
 * Base interface for all element managers. A manager is a virtual
 * Cloud container that is a child of the {@link ICloudRoot} element
 * but is not accessible with the
 * {@link ICloudRoot#getChildren(IProgressMonitor monitor)}
 * method. A manager can always manage only one type of Cloud elements.
 * So there are dedicated managers for different Cloud element, e.g.
 * {@link ICloudProvider}. A manager can therefore always be seen
 * as a central repository for a special type of Cloud elements. The
 * {@link #canManage(ICloudElement)} method therefore determines the
 * type of elements that can be managed by a dedicated manager. To
 * get a certain manager make use of the getManager-methods of
 * {@link ICloudRoot}.
 * 
 * Note that dedicated managers are always singletons!
 */
public interface ICloudElementManager extends ICloudContainer, ICloudModelNotifier {
  
  /**
   * Add the specified element to the list of managed elements.
   * 
   * @param element The element to be added.
   * @return True if the element could be added successfully,
   * false otherwise.
   * @throws ProblemException If the element could not be added
   * due to a problem, e.g. the element could not be managed by
   * this manager.
   */
  public boolean addElement( final ICloudElement element ) throws ProblemException;
  
  /**
   * Remove the specified element from the list of managed elements.
   * 
   * @param element The element to be removed. 
   * @return True if the element was contained in this container and
   * could be successfully removed. 
   */
  public boolean removeElement( final ICloudElement element );
  
  /**
   * Determines if this manager is able to manage the specified
   * Cloud element. A manager is always dedicated to one special
   * type of Cloud elements so this method has only to return true
   * for this special type and its sub-types.
   * 
   * @param element The element that wants to be managed by this
   * manager.
   * @return True if the manager is able to manage the specified
   * Cloud element.
   */
  public boolean canManage( final ICloudElement element );
}
