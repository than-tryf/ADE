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
 *    Harald Gjermundrod - added the getHostName method
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/

package org.eclipse.camf.core.model;

import java.net.URI;

import org.eclipse.camf.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudResource extends ICloudElement, IShareableElement {
  
  /**
   * Get the <code>URI</code> that corresponds to this grid resource.
   * 
   * @return The resource's contact string. May be <code>null</code>
   * if the resource may not be represented by a <code>URI</code>.
   */
  public URI getURI() throws ProblemException;
}
