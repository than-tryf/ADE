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
 * An <code>ICloudContainer</code> is an {@link ICloudElement} that
 * is able to contain other Cloud elements as children.
 */
public interface ICloudContainer extends ICloudElement {
  
  /**
   * Determines if this may contain the specified element.
   * This method works type specific, i.e. a container may
   * or may not contain elements of a specified type.
   * 
   * @param element The element that may be contained in
   * this container.
   * @return If this container may contain the specified element.
   */
  public boolean canContain( final ICloudElement element );
  
  /**
   * Determines if this container holds the specified element
   * as child.
   * 
   * @param element The element to be checked if it is contained
   * in this container.
   * @return True if the specified element is defined as a child
   * of this container.
   */
  public boolean contains( final ICloudElement element );
   
  /**
   * Create a new Cloud element from the specified
   * {@link ICloudElementCreator} and add the newly created element
   * to the list of children. If a child with the same name already
   * exists this old child is replaced by the new child.
   * 
   * Note that this is the only way to add children to an
   * <code>ICloudContainer</code>.
   *  
   * @param creator The {@link ICloudElementCreator} from which to
   * create the new element.
   * @return The element itself or the old element if the specified
   * element is <code>null</code> and there was such an old element
   * found. <code>null</code> in all other cases. 
   * @throws ProblemException
   */
  public ICloudElement create( final ICloudElementCreator creator ) throws ProblemException;
  
  /**
   * Delete the specified child. Deletion in the terms of an
   * {@ICloudContainer} means removing the specified element from
   * the list of children and calling the element's dispose
   * method.
   * 
   * @param child The element to be deleted.
   * @throws ProblemException If a problem occurs during the deletion.
   * @see ICloudElement#dispose()
   */
  public void delete( final ICloudElement child ) throws ProblemException;

  /**
   * Delete all children from this container. Subsequent model notifications
   * are cached and delivered in one bunch.
   * 
   * @throws ProblemException If a problem occurs during the deletion.
   * @see #delete(ICloudElement)
   */
  public void deleteAll() throws ProblemException;
  
  /**
   * Search for a child with the specified name and return it.
   * Returns <code>null</code> if no such element was found.
   * 
   * @param name The name of the element to be searched for.
   * @return The element with the specified name or <code>null</code>.
   */
  public ICloudElement findChild( final String name );
 
  /**
   * Search for a child that has an <code>IResource</code> with the
   * specified name. If the child is not virtual this method is
   * equivalent to {@link #findChild(String)}.
   * 
   * @param resourceName The name of the corresponding resource of
   * the child.
   * @return The child containing a corresponding resource with the
   * specified name or <code>null</code>.
   */
  public ICloudElement findChildWithResource( final String resourceName );
 
  /**
   * Get the number of children currently contained in this container.
   * 
   * @return The number of children in this container.
   */
  public int getChildCount();
  
  /**
   * Get the children that are currently contained in this container.
   * 
   * @param monitor A progress monitor that is used to indicate progress
   * for lazy containers. May be null. 
   * @return This container's children.
   * @throws ProblemException If this is a lazy container it may be
   * possible that an exception occurs while the children are fetched.
   */
  public ICloudElement[] getChildren( final IProgressMonitor monitor ) throws ProblemException;

  /**
   * Determine if this container contains any children.
   * 
   * @return True if this container is not empty and contains
   * at least one child.
   */
  public boolean hasChildren();
 
  /**
   * Returns if this container is dirty. This has no meaning if this
   * is not a lazy container. For lazy containers it means that the
   * list of children will be reloaded the next time when
   * {@link #getChildren(IProgressMonitor monitor)} is called.
   * To avoid confusions non-lazy containers should always return true here.
   * 
   * @return True if the container is dirty. Does not have a meaning
   * for non-lazy containers.
   */
  public boolean isDirty();
 
  /**
   * Determines if this container is using a lazy loading mechanism
   * to manage its children. In that case the children are not
   * loaded when the container is constructed but when the
   * {@link #getChildren(IProgressMonitor monitor)} methode is
   * called the first time. On subsequent calls of
   * {@link #getChildren(IProgressMonitor monitor)} the formerly loaded
   * children are returned unless the {@link #setDirty()} method was
   * called. In that case a call to
   * {@link #getChildren(IProgressMonitor monitor)} will cause a
   * reload of this containers children.
   * 
   * Lazy containers always have to return true if they are asked
   * if they contain any children with {@link #hasChildren()}.
   * 
   * @return True if this container uses lazy loading.
   */
  public boolean isLazy();
 
  /**
   * Refresh the content of this container. This method re-fetches the children
   * of this container even if it is a non-lazy container.
   * 
   * @param monitor A progress monitor used to give the caller feedback about
   * the progress of the operation.
   * @throws ProblemException If a problem occurs during the refresh
   * operation.
   */
  public void refresh( final IProgressMonitor monitor ) throws ProblemException;
  
  /**
   * Mark this container as dirty. A dirty and lazy container will
   * reload its children when {@link #getChildren(IProgressMonitor monitor)}
   * is called. This methods does not affect non-lazy containers.
   */
  public void setDirty();

  /**
   * Clean up all resources that this element uses internally.
   */
  @Override
  void dispose();
}
