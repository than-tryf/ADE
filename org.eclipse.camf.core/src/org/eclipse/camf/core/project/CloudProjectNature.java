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

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudProjectNature implements IProjectNature {
  
  /**
   * The project this project nature belongs to.
   */
  private IProject project;

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#configure()
   */
  @Override
  public void configure() throws CoreException {
    addBuilder( CloudProjectBuilder.getID() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#deconfigure()
   */
  @Override
  public void deconfigure() throws CoreException {
    removeBuilder( CloudProjectBuilder.getID() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#getProject()
   */
  @Override
  public IProject getProject() {
    return this.project;
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
   */
  @Override
  public void setProject( IProject project ) {
    this.project = project;
  }
  
  
  /**
   * Add the builder with the specified name to this nature.
   * 
   * @param builderName The name of the builder to be added.
   * 
   * @throws CoreException If an exception occurs when trying to
   * add the specified builder.
   */
  private void addBuilder(final String builderName) throws CoreException {
    IProject proj = getProject();
    IProjectDescription desc = proj.getDescription();
    ICommand[] commands = desc.getBuildSpec();
    
    boolean found = false;
    for ( int i = 0 ; ( i < commands.length ) && !found ; i++ ) {
      if ( commands[ i ].getBuilderName().equals( builderName ) ) {
        found = true;
      }
    }
    
    if ( !found ) {
      ICommand command = desc.newCommand();
      command.setBuilderName( builderName );
      ICommand[] newCommands = new ICommand[ commands.length + 1 ];
      System.arraycopy( commands, 0, newCommands, 1, commands.length );
      newCommands[ 0 ] = command;
      desc.setBuildSpec( newCommands );
      proj.setDescription( desc, new NullProgressMonitor() );
    }    
  }
  
  /**
   * Remove the builder with the specified name from this project nature.
   * 
   * @param builderName The name of the builder to be removed.
   * 
   * @throws CoreException If an exception occurs while removing the
   * specified builder.
   */
  private void removeBuilder( final String builderName ) throws CoreException {
    
    IProject proj = getProject();
    IProjectDescription desc = proj.getDescription();
    ICommand[] commands = desc.getBuildSpec();
    
    boolean found = false;
    int index = 0;
    for ( ; ( index < commands.length ) && !found ; index++ ) {
      if ( commands[ index ].getBuilderName().equals( builderName ) ) {
        found = true;
      }
    }
    
    if ( found ) {
      ICommand[] newCommands = new ICommand[ commands.length - 1 ];
      System.arraycopy( commands, 0, newCommands, 0, index - 1 );
      System.arraycopy( commands, index, newCommands, index - 1, commands.length - index );
      desc.setBuildSpec( newCommands );
      proj.setDescription( desc, new NullProgressMonitor() );
    }
    
  }

public static String getID() {
  return CloudProjectNature.class.getName();
}
}
