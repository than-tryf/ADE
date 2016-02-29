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

import java.util.Date;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudDeploymentStatus {
  
  
  /**
   * <p>
   * Return true if the deployment was finished successfully. This method should be
   * called only if method canChange() returns true.
   * </p>
   * <p>
   * For statuses which are not final the behavior of is Successfull() method
   * is undefined.
   * </p>
   * <p>
   * To check if deployment succeeded use method isSuccessfull()
   * </p>
   * 
   * @return true if the deployment was finished successfully
   */
  public boolean isSuccessful();

  /**
   * Returns the name of the status. This can be any string and is not
   * interpreted. It will be just printed in the status window to show the
   * status to the user. To check the meaning of the status use methods
   * canChange(), isSuccessful() or middleware specific implementation.
   * 
   * @return Name of the status
   */
  public String getName();

  /**
   * Returns the type of the status. This is integer value and defines the
   * meaning of the status. This value will be used for filtering deployment list to
   * those with a given status type. Type can be also used by user interface to
   * mark deployments belonging to the same type with the same graphical elements (e.g.
   * icons, colors)
   * 
   * @return Name of the status
   */
  public int getType();

  /**
   * Returns the date of last status update. It should be the time of last
   * contact with middleware service and not the time of last status change.
   * 
   * @return time of last update
   */
  public Date getLastUpdateTime();

  /**
   * Return the explanation why the deployment is in the specific state. Can give more
   * detailed information than just status name.
   * 
   * @return String with explanation
   */
  public String getReason();
}
