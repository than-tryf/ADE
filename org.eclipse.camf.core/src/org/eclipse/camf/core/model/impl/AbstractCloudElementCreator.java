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
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudElementCreator implements ICloudElementCreator {
  
  /**
   * The source object for the element creation.
   */
  private Object internalSource;

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElementCreator#create(org.eclipse.camf.core.model.ICloudContainer, java.lang.Object)
   */
  @Override
  public ICloudElement create( final ICloudContainer parent, final Object source ) throws ProblemException {
    setSource( source );
    return create( parent );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElementCreator#getSource()
   */
  @Override
  public Object getSource() {
    return this.internalSource;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElementCreator#setSource(java.lang.Object)
   */
  @Override
  public void setSource( final Object source ) {
    this.internalSource = source;
  }
}
