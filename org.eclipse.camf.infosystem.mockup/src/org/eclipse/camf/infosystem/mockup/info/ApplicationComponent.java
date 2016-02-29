/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.infosystem.mockup.info;

import java.net.URI;

import org.eclipse.camf.core.model.ICloudApplicationComponent;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class ApplicationComponent extends AbstractCloudElement
  implements ICloudApplicationComponent
{

  
  private ICloudContainer parent;
  
  public ApplicationComponent (final ICloudContainer parent)
  {
    this.parent = parent;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
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

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.parent;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }
}
