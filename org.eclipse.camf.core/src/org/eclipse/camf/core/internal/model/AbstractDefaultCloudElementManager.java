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

import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.IDefaultCloudElementManager;
import org.eclipse.camf.core.reporting.ProblemException;



/**
 * Internal abstract implementation of an {@link IDefaultCloudElementManager}.  
 */
public abstract class AbstractDefaultCloudElementManager
  extends AbstractCloudElementManager implements IDefaultCloudElementManager
{

  /**
   * The current default element.
   */
  private ICloudElement defaultElement;

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IDefaultCloudElementManager#getDefault()
   */
  public ICloudElement getDefault() {
    return this.defaultElement;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IDefaultCloudElementManager#setDefault(org.eclipse.camf.core.model.ICloudElement)
   */
  public void setDefault( final ICloudElement element ) throws ProblemException {
    if ( ( element != null ) && ( element != this.defaultElement ) ) {
      addElement( element );
      this.defaultElement = element;
      updateDefault();
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.internal.model.AbstractCloudElementManager#addElement(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean addElement( final ICloudElement element ) throws ProblemException {
    boolean result = super.addElement( element );
    if ( result ) {
      updateDefault();
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.internal.model.AbstractCloudElementManager#removeElement(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean removeElement( final ICloudElement element ) {
    boolean result = super.removeElement( element );
    if ( result ) {
      updateDefault();
    }
    return result;
  }
  
  /**
   * Update the default element.
   * 
   * @return True if the default element has changed during this
   * operation.
   */
  protected boolean updateDefault() {
    boolean changed = false;
    if ( ( this.defaultElement != null )
        && !contains( this.defaultElement ) ) {
      this.defaultElement = null;
      changed = true;
    }
    if ( ( this.defaultElement == null ) && hasChildren() ) {
      this.defaultElement = getChildren( null )[0];
      changed = true;
    }
    return changed;
  }

}
