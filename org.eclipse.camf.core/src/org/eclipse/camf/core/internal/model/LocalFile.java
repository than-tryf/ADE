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

import org.eclipse.camf.core.model.impl.ResourceCloudElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.service.prefs.Preferences;


/**
 * @author Nicholas Loulloudes
 *
 */
public class LocalFile extends ResourceCloudElement {
  
  LocalFile (final IFile file) {
    super (file);
  }
  
  public boolean isProjectFoldersProperties() {
    return isPropertiesFile( CloudProject.PROJECT_FOLDER_NODE );
  }
  
  public boolean isProjectProperties() {
    return isPropertiesFile( CloudProject.PROJECT_NODE );
  }
  
  /**
   * Convenience method that returns the <code>IFile</code> out
   * of the resource.
   * 
   * @return The corresponding <code>IFile</code>.
   */
  protected IFile getFile() {
    return ( IFile ) getResource();
  }
  
  private boolean isPropertiesFile( final String nodeName ) {
    
    IPath folderPath = getPath();
    IPath folderComparePath = folderPath.removeFileExtension();
    
    IPath propertiesPath = getPropertiesPath( nodeName );
    IPath propertiesComparePath = new Path( getProject().getName() );
    propertiesComparePath = propertiesComparePath.append( ".settings" ); //$NON-NLS-1$
    propertiesComparePath.append( propertiesPath.lastSegment() );

    return folderComparePath.equals( propertiesComparePath );
    
  }
  
  private IPath getPropertiesPath( @SuppressWarnings("unused")
                                   final String node ) {
    IProject project = ( IProject ) getProject().getResource();
    ProjectScope projectScope = new ProjectScope( project );
    Preferences folderNode = projectScope.getNode( CloudProject.PROJECT_FOLDER_NODE );
    return new Path( folderNode.absolutePath() );
  }
  
}
