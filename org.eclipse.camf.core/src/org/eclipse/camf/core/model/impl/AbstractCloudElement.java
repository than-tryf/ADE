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
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.PlatformObject;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudElement extends PlatformObject implements ICloudElement {

  
  private static final String HIDDEN_PREFIX = "."; //$NON-NLS-1$
  
  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.PlatformObject#getAdapter(java.lang.Class)
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object getAdapter( final Class adapter ) {
    Object result = null;
    if ( adapter.isAssignableFrom( getClass() ) ) {
      result = this;
    } else if ( adapter.isAssignableFrom( IResource.class ) ) {
      result = getResource();
    }
    if ( result == null ) {
      result = super.getAdapter( adapter );
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getProject()
   */
  @Override
  public ICloudProject getProject() {
    ICloudContainer parent = getParent();
    return parent == null ? null : parent.getProject();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isHidden()
   */
  @Override
  public boolean isHidden() {
    String name = getName();
    return ( name != null ) && ( getName().startsWith( HIDDEN_PREFIX ) );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isVirtual()
   */
  @Override
  public boolean isVirtual() {
    return getResource() == null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#dispose()
   */
  @Override
  public void dispose() {
    // empty implementation
  }
}
