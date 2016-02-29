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
package org.eclipse.camf.internal.model.notify;

import org.eclipse.camf.core.internal.model.CloudRoot;
import org.eclipse.camf.core.internal.model.LocalFile;
import org.eclipse.camf.core.internal.model.LocalResourceCreator;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.camf.core.internal.Activator;


/**
 * The <code>CloudElementLifecycleManager</code> is an implementation
 * of {@link IResourceDeltaVisitor} that is used to visit resources
 * deltas coming from resource change events. This class handles
 * the creation and deletion of Grid model elements and therefore
 * keeps the Grid model in sync with the resource tree.
 */
public class CloudElementLifecycleManager implements IResourceDeltaVisitor {

  /**
   * Find an element creator for the specified {@link IResource}.
   * Searches first all externally registered creators and afterwards
   * the internal creators.
   * 
   * @param resource The resource for which to find a creator.
   * @return The creator or <code>null</code> if no such
   * creator could be found.
   * @see CloudModel#getElementCreators()
   * @see CloudModel#getStandardCreators()
   */
public static ICloudElementCreator findCreator( final IResource resource ) {
    
    ICloudElementCreator result = CloudModel.getCreatorRegistry().getCreator( resource, (Class)null );
    
    if ( result == null ) {
      result = new LocalResourceCreator();
    }
    
    result.setSource( resource );

    return result;
    
  }

  public boolean visit( final IResourceDelta delta ) throws CoreException {
    
    switch ( delta.getKind() ) {
      case IResourceDelta.ADDED:
        resourceAdded( delta.getResource() );
        break;
      case IResourceDelta.REMOVED:
        resourceRemoved( delta.getResource() );
        break;
      case IResourceDelta.CHANGED:
        resourceChanged( delta.getResource(), delta.getFlags() );
        break;
      default:
        break;
    }
    
    return true;
    
  }
    
  private void elementChanged( final ICloudElement element ) {
    
    int type = ICloudModelEvent.ELEMENTS_CHANGED;
    ICloudContainer source = element.getParent();
    ICloudElement[] elements = new ICloudElement[] { element };
    
    queueEvent( type, source, elements );
    
  }
  
  /**
   * Handle a project state changed, i.e. project opened or project closed.
   * 
   * @param project The project whose state has changed.
   */
  private void projectStateChanged( final ICloudProject project ) {
    
    int type
      = project.isOpen()
      ? ICloudModelEvent.PROJECT_OPENED
      : ICloudModelEvent.PROJECT_CLOSED;
    ICloudContainer source = project.getParent();
    ICloudElement[] elements = new ICloudElement[] { project };
    
    queueEvent( type, source, elements );
    
  }
  
  private void queueEvent( final int type,
                           final ICloudElement source,
                           final ICloudElement[] elements ) {
    
    ICloudElement src = source == null ? CloudModel.getRoot() : source;
    
    ICloudModelEvent event = new CloudModelEvent( type, src, elements );
    CloudRoot.getCloudNotificationService().queueEvent( event );
    
  }
  
  /**
   * Handle a resource added change.
   * 
   * @param resource The added resource.
   */
  private void resourceAdded( final IResource resource ) {
    if ( resource != null ) {
      ICloudElementCreator creator = findCreator( resource );
      if ( creator != null ) {
        IContainer parent = resource.getParent();
        if ( parent != null ) {
          ICloudContainer parentElement = ( ICloudContainer ) CloudRoot.getInstance().findElement( parent );
          if ( parentElement != null ) {
            try {
              parentElement.create( creator );
            } catch ( ProblemException pExc ) {
              Activator.logException( pExc );
            }
          }
        }
      }
    }
  }
  
  private void resourceChanged( final IResource resource,
                                final int flags ) {
    if ( resource != null ) {
      ICloudElement element = CloudRoot.getInstance().findElement( resource );
      if ( element != null ) {
        if ( ( element instanceof ICloudProject ) && ( ( flags & IResourceDelta.OPEN ) != 0 ) ) {
          projectStateChanged( ( ICloudProject ) element );
        } else if ( element instanceof LocalFile ) {
          LocalFile localFile = ( LocalFile ) element;
          if ( localFile.isProjectFoldersProperties() || localFile.isProjectProperties() ) {
            elementChanged( localFile.getProject() );
          } else {
            elementChanged( element );
          }
        } else {
          elementChanged( element );
        }
      }
    }
  }
  
  /**
   * Handle a resource removed change.
   * 
   * @param resource The removed resource.
   */
  private void resourceRemoved( final IResource resource ) {
    if ( resource != null ) {
      ICloudElement element = CloudRoot.getInstance().findElement( resource );
      if ( element != null ) {
        ICloudContainer parent = element.getParent();
        if ( parent != null ) {
          try {
            parent.delete( element );
          } catch ( ProblemException pExc ) {
            Activator.logException( pExc );
          }
        }
      }
    }
  }
}
