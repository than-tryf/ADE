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


/**
 * An element that describes a Cloud application and its properties.
 * Such descriptions are used to submit and deploy applications to
 * one ore more Cloud providers.  
 *
 */
public interface ICloudApplicationDescription extends ICloudContainer {
  
  /**
   * @return Free text of the application's name
   */
  public String getApplicationName();
  
  /**
   * @return Free text of the application's description
   */
  public String getApplicationDescription();
  
  /**
   * @return free text of the application version
   */
  public String getApplicationVersion();
  
  /**
   * @return free text of the application executable
   */
  public String getApplicationExecutable();
}
