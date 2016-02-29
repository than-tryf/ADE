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
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.internal.model.notify.CloudElementLifecycleManager;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import org.eclipse.camf.core.internal.Activator;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ResourceCloudContainer extends AbstractCloudContainer {
  
  private IResource resource;
  
  protected ResourceCloudContainer( final IResource resource ) {
    Assert.isNotNull( resource );
    this.resource = resource;
    fetchChildren( null );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#isLazy()
   */
  @Override
  public boolean isLazy() {
    return false;
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
  
  protected IStatus fetchChildren( final IProgressMonitor monitor ) {
    
    IProgressMonitor localMonitor
      = monitor != null
      ? monitor
      : new NullProgressMonitor();

    IStatus result = Status.CANCEL_STATUS;
    
    deleteAll();
    if ( ( this.resource != null ) && ( this.resource instanceof IContainer ) ) {
      lock();
      try {
        IResource[] members = ( ( IContainer ) this.resource ).members();
        localMonitor.beginTask( Messages.getString( "AbstractCloudContainer.load_progress" ), members.length ); //$NON-NLS-1$
        for ( IResource member : members ) {
          try {
            ICloudElementCreator creator = findCreator( member );
            if ( creator != null ) {
              create( creator );
            }
  
            localMonitor.worked( 1 );
            if ( localMonitor.isCanceled() ) {
              break;
            }
          } catch ( Throwable throwable ) {
            Activator.logException( throwable );
          }
        }
        result = Status.OK_STATUS;
      } catch ( CoreException cExc ) {
        Activator.logException( cExc );
        result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, Messages.getString( "AbstractCloudContainer.fetch_error"), cExc ); //$NON-NLS-1$
      } finally {
        unlock();
      }
    }

    localMonitor.done();

    return result;
  }
  
  protected ICloudElementCreator findCreator( final IResource res ) {
    return CloudElementLifecycleManager.findCreator( res );
  }
}
