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

import org.eclipse.core.runtime.IProgressMonitor;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudApplicationSubmission extends ICloudContainer, IManageable {
  
  public ICloudSubmissionID getID();
  
  public String getApplicationName();
  
  public Date getSubmissionTime();
  
  public ICloudSubmissionStatus getStatus(final IProgressMonitor monitor);
  
}
