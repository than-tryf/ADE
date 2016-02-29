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
import org.eclipse.camf.core.model.impl.ResourceCloudContainer;
import org.eclipse.core.resources.IFolder;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LocalFolder extends ResourceCloudContainer {
  /**
   * Construct a new local folder with the specified parent and the specified
   * corresponding <code>IFolder</code>.
   * 
   * @param parent The parent element of this folder.
   * @param folder The corresponding <code>IFolder</code>.
   */
  LocalFolder( final IFolder folder ) {
    super( folder );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudContainer#canContain(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return true;
  }

  /**
   * Convenience method that returns the <code>IFolder</code> out of the
   * resource.
   * 
   * @return The corresponding <code>IFolder</code>.
   */
  public IFolder getFolder() {
    return ( IFolder )getResource();
  }
}
