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


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudDeploymentCreator extends ICloudElementCreator {
  /**
   * Test if this creator can create a job from the specified job description.
   * 
   * @param description The description from which to create the job.
   * @return True if a job can be created from the specified description.
   */
  public boolean canCreate( final ICloudApplicationDescription description );
  
  /**
   * Creates ApplicationDeploymentJob and add this to CloudProjectView. This method is called
   * after successful application deployment.
   * 
   * @param parent - The parent node in GridProjectView
   * @param id - Identifier of deployment
   * @param deploymentService 
   * @param deploymentName - name under which job should be stored in the workspace
   * @return created deployment
   * @throws ProblemException
   */
  public ICloudDeployment create( final ICloudContainer parent, ICloudDeploymentID id, final ICloudDeploymentService deploymentService, final String deploymentName )
    throws ProblemException;
  
  
}
