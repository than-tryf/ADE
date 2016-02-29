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

import java.util.List;


/**
 * An element that describes a Cloud application monitoring details.
 * Such descriptions are used for presenting monitoring details of
 * a particular application and getting probe details.
 *
 */
public interface ICloudApplicationMonitorDescription extends ICloudContainer {
  
  /**
   * @return free text of the application's name
   */
  public String getApplicationName();
  
  /**
   * @return free text of the current monitoring description version
   */
  public String getVersion();
  
  /**
   * @return number of monitoring probes.
   */
  public int getProbeCount();
  
  /**
   * @return list of {@link ICloudMonitorProbe}s
   */
  public List<ICloudMonitorProbe> getMonitorProbes();
}
