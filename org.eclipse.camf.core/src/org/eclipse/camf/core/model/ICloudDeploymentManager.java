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

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * A deployment manager is able to manage {@link ICloudDeployment}.
 */
public interface ICloudDeploymentManager
    extends ICloudElementManager {
  
  public void addJobStatusListener( ICloudDeploymentStatusListener listener );

  public void addJobStatusListener(ICloudDeployment[] deployments, int status, ICloudDeploymentStatusListener listener);

  public void removeJobStatusListener(ICloudDeploymentStatusListener listener);
  
  public void removeJobStatusListener(ICloudDeployment[] deployments, ICloudDeploymentStatusListener listener);

  /**
   * Stops refreshing all deployment status updaters
   */
  public void pauseAllUpdaters();
  
  /**
   * Starts refreshing all deployment status udapters
   */
  public void wakeUpAllUpdaters();
  
  /**
   * Tells updaters of the given deployments to update statues of the deployments.
   * @param selectedJobs to have its status updated
   */
  public void updateJobsStatus( final ArrayList< ICloudDeployment > selectedJobs );
  
  /**
   * Tells updater of the given deployment that status has been updated externally
   * (i.e. deployment status wasn't updated in deployment status updater).
   * @param deployment Deployment, which status has changed.
   * @param oldStatus status which was set, before deployment status was updated
   */
  public void deploymentStatusChanged( final ICloudDeployment deployment, final ICloudDeploymentStatus oldStatus );
  
  /**
   * Cancel current operation in deployment status updater and remove it from deployment scheduler
   * @param deployment the deployment, for which updater will be removed
   * @param waitForUpdater <code>true</code> if this method should wait to moment, when deployment updater finish current operation
   * @param monitor optionally monitor, which is checked during waiting for finishing updater
   */
  public void removeJobStatusUpdater( final ICloudDeployment deployment, final boolean waitForUpdater, final IProgressMonitor monitor );
}
