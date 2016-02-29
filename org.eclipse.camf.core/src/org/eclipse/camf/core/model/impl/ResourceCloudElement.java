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
package org.eclipse.camf.core.model.impl;

import java.net.URI;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ResourceCloudElement extends AbstractCloudElement {
  
  private IResource resource;

  
  protected ResourceCloudElement( final IResource resource ) {
    Assert.isNotNull( resource );
    this.resource = resource;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return this.resource.getName();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    URI uri = this.resource.getLocationURI();
    IFileSystem fileSystem = EFS.getLocalFileSystem();
    IFileStore fileStore = fileSystem.getStore( uri );
    return fileStore;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return this.resource.getFullPath();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return this.resource;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    ICloudContainer parent = null;
    IPath parentPath = getPath().removeLastSegments( 1 );
    ICloudElement parentElement = CloudModel.getRoot().findElement( parentPath );
    if ( parentElement instanceof ICloudContainer ) {
      parent = ( ICloudContainer ) parentElement;
    }
    return parent;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }
}
