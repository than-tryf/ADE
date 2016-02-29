/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 *  Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package org.eclipse.camf.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.camf.ui.internal.dialogs.FileOverwriteDialog;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchSite;


public class ExportAction extends Action {
  
  protected ICloudElementCreator creator;
  
  protected ICloudApplicationDescription[] input;
  
  private IWorkbenchSite site;
  
  public ExportAction (final String title,
                       final ICloudElementCreator creator,
                       final ICloudApplicationDescription[] input,
                       final IWorkbenchSite site){
    super (title);
    this.creator = creator;
    this.input = input;
    this.site = site;
    
  }
  
  @Override
  public void run() {
    
 for (ICloudApplicationDescription description : this.input ){
   boolean runJob = true;
      
      IFile file = getFile( description );
      
      if ( file.exists() ){
        FileOverwriteDialog dialog = new FileOverwriteDialog( this.site.getShell(), file.getName() );
        if (dialog.open() == SWT.YES ){        
          try {
            file.delete( true, null );

          } catch( CoreException e ) {
            Activator.logException( e );
        }
      } else {
        runJob = false;
      }
    }
    
    if (true == runJob) {
      WorkspaceJob job = new WorkspaceJob( "transformer" ) { //$NON-NLS-1$
        @Override
        public IStatus runInWorkspace( final IProgressMonitor monitor )
            throws CoreException {
          return transform( ExportAction.this.creator, ExportAction.this.input, monitor );
        }
      };
      job.setUser( true );
      job.schedule();
     }
   }
         
  }
  
  protected IStatus transform( final ICloudElementCreator creator,
                               final ICloudApplicationDescription[] input,
                               final IProgressMonitor monitor ) {

    IStatus result = Status.OK_STATUS;
    List< IStatus > errors = new ArrayList< IStatus >();
    
    IProgressMonitor lMonitor
      = monitor == null
      ? new NullProgressMonitor()
      : monitor;
      
    lMonitor.beginTask( "Transforming job descriptions", input.length );
    
    try {
      for ( ICloudApplicationDescription description : input ) {
        lMonitor.subTask( description.getName() );
        IStatus status = transform( creator, description );
        if ( ! status.isOK() ) {
          errors.add( status );
        }
        lMonitor.worked( 1 );
      }
    } finally {
      lMonitor.done();
    }
    
    if ( ( errors != null ) && ( errors.size() > 0 ) ) {
      if ( errors.size() == 1 ) {
        result = errors.get( 0 );
      } else {
        result = new MultiStatus(
            Activator.PLUGIN_ID,
            0,
            errors.toArray( new IStatus[ errors.size() ] ),
            "Transformation problems",
            null
        );
      }
    }
    
    return result;
  }
  
   
  private IStatus transform( final ICloudElementCreator creator,
                             final ICloudApplicationDescription input ) {
    
    IStatus result = Status.OK_STATUS;
    
    creator.setSource( input );    
    ICloudContainer parent = input.getParent();

    try {
      creator.create( parent );
    } catch ( ProblemException pExc ) {
      result = new Status(
                          IStatus.ERROR,
                          Activator.PLUGIN_ID,
                          String.format( "Transformation failed for %s", input.getName() ), //$NON-NLS-1$
                          pExc
      );
    }
    
    return result;
    
  }
  
  private IFile getFile( final ICloudApplicationDescription inputDescr ){
    
    IFile returnFile = null;
        
    IPath csarName = new Path( inputDescr.getName() ).removeFileExtension().addFileExtension( "csar" ); //$NON-NLS-1$
    IFile csarFile = ( ( IContainer ) inputDescr.getParent().getResource() ).getFile( csarName );
    
    returnFile = csarFile;
    
    return returnFile;
  }
  
  
  
}
