/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
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
package org.eclipse.camf.core.project;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;


/**
 * Incremental project builder dedicated to Cloud related projects.
 * 
 */

public class CloudProjectBuilder extends IncrementalProjectBuilder {

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IncrementalProjectBuilder#build(int, java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IProject[] build( final int kind,
                              final Map<String, String> args,
                              final IProgressMonitor monitor ) throws CoreException {

    return null;
  }
  
  /**
   * Get the ID of this project builder.
   * 
   * @return A unique id used to reference this project builder.
   */
  public static String getID() {
    return CloudProjectBuilder.class.getName();
  }
}
