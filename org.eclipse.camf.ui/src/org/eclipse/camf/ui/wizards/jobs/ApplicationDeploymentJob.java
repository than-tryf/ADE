/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.wizards.jobs;

import org.eclipse.camf.ui.wizards.Messages;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;



/**
 * @author Nicholas Loulloudes
 *
 */
public class ApplicationDeploymentJob extends Job {
  

  /**
   * @param name
   */
  public ApplicationDeploymentJob( ) {
    super( Messages.getString( "NewDeploymentWizard.jobName" ) ); //$NON-NLS-1$
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus run( final IProgressMonitor monitor ) {
    boolean closeWizard = true;
//    Cloud
    return null;
  }
}
