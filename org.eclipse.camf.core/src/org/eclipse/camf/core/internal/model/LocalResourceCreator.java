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
package org.eclipse.camf.core.internal.model;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;

import org.eclipse.camf.core.internal.Activator;


/**
 * Creator for local resources like files and folders.
 */
public class LocalResourceCreator extends AbstractCloudElementCreator {

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElementCreator#create(org.eclipse.camf.core.model.ICloudContainer)
   */
  @Override
  public ICloudElement create( final ICloudContainer parent ) throws ProblemException {
    ICloudElement result = null;
    
    Object source = getSource();
    
    if ( source instanceof IProject ) {
      IProject project = ( IProject ) source;
      if ( project.getName().equals( HiddenProject.NAME ) ) {
        try {
          result = HiddenProject.getInstance( project );
        } catch ( ProblemException pExc ) {
          Activator.logException( pExc );
        }
      } else {
        result = new CloudProject( project );
      }
    }
    
    else if ( source instanceof IFile ) {
      result = new LocalFile( ( IFile ) source );
    }
    
    else if ( source instanceof IFolder ) {
      result = new LocalFolder( ( IFolder ) source );
    }
    
    return result;
    
  }  
}
