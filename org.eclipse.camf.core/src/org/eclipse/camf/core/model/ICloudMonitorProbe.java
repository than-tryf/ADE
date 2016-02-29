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
package org.eclipse.camf.core.model;

import java.net.URI;

import org.eclipse.camf.core.reporting.ProblemException;


/**
 * 
 * An interface for Cloud Monitor probes
 */
public interface ICloudMonitorProbe extends ICloudApplicationComponent {
  
  public String getName();
  
  /**
   * @return The UID of the monitor probe.
   */
  public String getUID();
  
  /**
   * @return Free text of the probe description.
   */
  public String getDescription();
  
  /**
   * @return the probe refresh interval
   */
  public int getRefreshInterval();
  
  /**
   * @return the probe alert interval
   */
  public int getAlertInterval();
  
  /**
   * @return is this a user developed probe
   */
  public boolean isCustomProbe();
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException;
}
