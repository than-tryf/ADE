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
package org.eclipse.camf.core.internal.model;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.impl.AbstractCloudContainer;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;


/**
 * This class implements the standard behaviour of a virtual grid
 * container. 
 */
public abstract class VirtualCloudContainer
    extends AbstractCloudContainer {
  
  /**
   * The parent container of this container.
   */
  private ICloudContainer parent;
  
  /**
   * The name of this container. 
   */
  private String name;
  
  /**
   * Create a new virtual grid container.
   *  
   * @param parent The parent element.
   * @param name The name of this container.
   */
  public VirtualCloudContainer( final ICloudContainer parent,
                               final String name ) {
    Assert.isNotNull( parent );
    Assert.isNotNull( name );
    this.parent = parent;
    this.name = name;
  }
  
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#getFileStore()
   */
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( getName() );
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#getName()
   */
  public String getName() {
    return this.name;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#getParent()
   */
  public ICloudContainer getParent() {
    return this.parent;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#getPath()
   */
  public IPath getPath() {
    IPath path = null;
    ICloudContainer par = getParent();
    if ( par != null ) {
      IPath parentPath = par.getPath();
      if ( parentPath != null ) {
        path = parentPath.append( getName() );
      }
    }
    return path;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridElement#getResource()
   */
  public IResource getResource() {
    return null;
  }
 
  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IGridContainer#isLazy()
   */
  public boolean isLazy() {
    return true;
  }

}
