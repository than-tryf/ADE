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

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ContainerMarker extends AbstractCloudElement {
  
  /**
   * The type of this marker. May have influence how the marker
   * will be presented in the UI,
   */
  public static enum MarkerType {
    
    /**
     * Tag for an info marker.
     */
    INFO,
    
    /**
     * Tag for an error marker. 
     */
    ERROR
    
  }
  
  private ICloudContainer container;
  
  private MarkerType type;
  
  private String message;
  
  public ContainerMarker( final ICloudContainer container, final MarkerType type, final String message ) {
    this.container = container;
    this.type = type;
    this.message = message;
  }
  
  public static ContainerMarker getEmptyFolderMarker( final ICloudContainer container ) {
    return new ContainerMarker( container, MarkerType.INFO, "Folder is empty" );
  }
  
  public static ContainerMarker getErrorMarker( final ICloudContainer container, final Throwable t ) {
    return new ContainerMarker( container, MarkerType.ERROR, t.getLocalizedMessage() );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return this.message;
  }
  
  public ICloudContainer getParent() {
    return this.container;
  }
  
  public IPath getPath() {
    return getParent().getPath().append( getName() );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }
  
  /**
   * Get the type of this marker.
   * 
   * @return The marker's type.
   */
  public MarkerType getType() {
    return this.type;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }
  
}
