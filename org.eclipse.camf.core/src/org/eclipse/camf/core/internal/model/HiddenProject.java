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
 *    Ariel Garcia      - updated to new problem reporting
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.internal.model;

import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudPreferences;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudRoot;
import org.eclipse.camf.core.model.impl.ResourceCloudContainer;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import org.eclipse.camf.core.internal.Activator;



/**
 * The hidden project is a project that is not visible in the Grid model views.
 * It implements {@link ICloudPreferences} and therefore stores all global
 * preferences in a well defined structure within a project.
 */
public class HiddenProject extends ResourceCloudContainer implements ICloudProject, ICloudPreferences {
  
  /**
   * The name of the project.
   */
  public static final String NAME = ".camf"; //$NON-NLS-1$
  /**
   * Folder name of the temporary folder.
   */
  private static final String DIR_TEMP = ".temp"; //$NON-NLS-1$
  
  private HiddenProject( final IProject resource ) {
    super( resource );
  }
  
  /**
   * Get the singleton instance of the hidden project.
   * 
   * @return The singleton. If not yet happened the singleton will be created.
   * @throws ProblemException If the creation of the singleton fails.
   */
  public static HiddenProject getInstance() throws ProblemException {
    ICloudRoot cloudRoot = CloudModel.getRoot();
    HiddenProject result = ( HiddenProject )cloudRoot.findChild( NAME );
    if( result == null ) {
      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      String projectName = NAME;
      IProject project = workspaceRoot.getProject( projectName );
      result = getInstance( project );
    }
    return result;
  }
  
  /**
   * Get the singleton instance of the hidden project.
   * 
   * @param project The {@link IProject} from which to create the singleton.
   * @return The hidden project.
   * @throws ProblemException If the creation of the project fails.
   */
  public static HiddenProject getInstance( final IProject project ) throws ProblemException   {
    if ( !project.exists() ) {
      String projectName = project.getName();
      IPath projectPath = null;
      IStatus status = ResourcesPlugin.getWorkspace()
        .validateProjectLocation( project, projectPath );
      if ( status.getSeverity() != IStatus.OK ) {
        throw new ProblemException( ICoreProblems.MODEL_PREFERENCE_CREATION_FAILED,
                                    status.getMessage(),
                                    status.getException(),
                                    Activator.PLUGIN_ID );
      }
      IProjectDescription desc = project.getWorkspace()
        .newProjectDescription( projectName );
      desc.setLocation( projectPath );
      try {
        project.create( desc, null );
      } catch ( CoreException cExc ) {
        throw new ProblemException( ICoreProblems.MODEL_PREFERENCE_CREATION_FAILED,
                                    cExc,
                                    Activator.PLUGIN_ID );
      }
    }
    return new HiddenProject( project );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudContainer#canContain(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return true;
  }
  
  @Override
  public ICloudProject getProject() {
    return this;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#getProjectFolder(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public ICloudContainer getProjectFolder( final ICloudElement element ) {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#getProjectFolder(java.lang.Class)
   */
  @Override
  public ICloudContainer getProjectFolder( final Class<? extends ICloudElement> elementType )
  {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#getProjectFolderID(org.eclipse.camf.core.model.ICloudContainer)
   */
  @Override
  public String getProjectFolderID( final ICloudContainer folder ) {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#getCloudProvider()
   */
  @Override
  public ICloudProvider getCloudProvider() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#isOpen()
   */
  @Override
  public boolean isOpen() {    
    return ( ( IProject )getResource() ).isOpen();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProject#hasCloudNature()
   */
  @Override
  public boolean hasCloudNature() {
    return false;
  }
  
  @Override
  protected IStatus fetchChildren( final IProgressMonitor monitor ) {
    IStatus result = Status.CANCEL_STATUS;
    if( isOpen() ) {
      result = super.fetchChildren( monitor );
    }
    return result;
  }
  
  protected IProject getAccessibleProject() throws ProblemException {
    IProject project = ( IProject )getResource();
    if( !project.isOpen() ) {
      try {
        project.open( null );
      } catch( CoreException exception ) {
        throw new ProblemException( "org.eclipse.camf.core.problem.io.openProjectFailed", exception, Activator.PLUGIN_ID ); //$NON-NLS-1$
      }
    }
    return project;
  }
  
  /**
   * Create and/or retrieve a directory within the project.
   * 
   * @param name The name of the new directory.
   * @throws CoreException If the creation of the directory failed.
   */
  private IFolder getProjectFolder( final String name ) throws ProblemException
  {
    IProject project = getAccessibleProject();
    IFolder folder = project.getFolder( new Path( name ) );
    if( !folder.exists() ) {
      try {
        folder.create( IResource.FORCE, true, null );
      } catch( CoreException exception ) {
        String msg = String.format( Messages.getString( "HiddenProject.folder_creation_error" ), name, project.getName() ); //$NON-NLS-1$
        throw new ProblemException( "org.eclipse.camf.core.problem.io.createFolderFailed", msg, exception, Activator.PLUGIN_ID ); //$NON-NLS-1$
      }
    }
    return folder;
  }

  @Override
  public IFolder getTemporaryFolder() throws CoreException {
    IFolder folder = getProjectFolder( DIR_TEMP );
    return folder;
  }
}
