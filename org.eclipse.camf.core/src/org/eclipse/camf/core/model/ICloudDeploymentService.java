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

import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.IProgressMonitor;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudDeploymentService extends ICloudService {
  
  public boolean canDeploy( final ICloudApplicationDescription desc );

  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final IProgressMonitor monitor )
    throws ProblemException;

  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final ICloudProvider vo,
                                               final IProgressMonitor monitor )
    throws ProblemException;

  public ICloudDeploymentStatus getDeploymentStatus( final ICloudDeploymentID id,
                                                     final IProgressMonitor vo,
                                                     boolean fullStatus,
                                                     final IProgressMonitor monitor )
    throws ProblemException;
}
