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
 * Interface for listener called when job status is updated
 */
public interface ICloudDeploymentStatusListener {

  /**
   * Called when job status is changed. Warning! Can be called from working
   * thread, so please from statusChanged() don't call SWT methods directly. 
   * Rather use:
   * use: 
   *    display.syncExec ( new Runnable () { 
   *        public void run () { } 
   *        } );
   * 
   * @param deployment
   */
  public void statusChanged( ICloudDeployment deployment );
  
  /**
   * Called after every update of job status, even if status wasn't changed
   * during update. <br>
   * Warning: now this method is called only for listeners, which listen for
   * changes of all jobs registered using method
   * {@link JobManager#addJobStatusListener(ICloudDeploymentStatusListener)}
   * 
   * @param deployment for which, status has been updated
   */
  public void statusUpdated( ICloudDeployment deployment );
  
}
