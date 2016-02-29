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

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementManager;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudRoot;
import org.eclipse.camf.core.model.IManageable;
import org.eclipse.camf.core.model.impl.ResourceCloudContainer;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.internal.model.notify.CloudNotificationService;
import org.eclipse.camf.internal.model.notify.ResourceNotificationService;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import org.eclipse.camf.core.internal.Activator;


/**
 * Core implementation of the {@link ICloudRoot} interface.
 * This Cloud root is associated with the underlying
 * {@link org.eclipse.core.resources.IWorkspaceRoot}. 
 */
public final class CloudRoot extends ResourceCloudContainer implements ICloudRoot {
  
  /**
   * The singleton instance.
   */
  private static CloudRoot singleton;
  
  /**
   * Private constructor to ensure to have only one instance of
   * this class. This can be obtained by {@link #getInstance()}.
   */
  private CloudRoot() {
    super( ResourcesPlugin.getWorkspace().getRoot() );    
    getCloudNotificationService();
    getResourceNotificationService();
  }
  
  /**
   * Get the singleton instance of this Cloud root. If the singleton is
   * not yet instantiated this method will instantiate it.
   * 
   * @return The singleton instance.
   */
  public final static CloudRoot getInstance() {
    if (singleton == null){
      singleton = new CloudRoot();
    }
    return singleton;
  }
  
  /**
   * Get the singleton instance of this Cloud root. If the singleton is
   * not yet instantiated this method will return <code>null</code>.
   * 
   * @return The singleton instance or <code>null</code> if the
   * singleton was not yet instantiated.
   */
  public final static CloudRoot getRoot() {
    return singleton;
  }

  /**
   * Get the {@link ResourceNotificationService} that is used to
   * notify the model about changes in the resource tree.
   * 
   * @return The resource notification service.
   */
  public static ResourceNotificationService getResourceNotificationService() {
    return ResourceNotificationService.getInstance();    
  }

  /**
   * Get the {@link CloudNotificationService} that is used to
   * notify model listeners about changes in the model.
   * 
   * @return The models notification service.
   */
  public static CloudNotificationService getCloudNotificationService() {
    return CloudNotificationService.getInstance();    
  }
  
  /**
   * This method is used to register any new element appearing in the model.
   * It takes care that managed elements are added to their manager.
   * 
   * @param element The element that appeared somewhere in the model.
   */
  public static void registerElement( final ICloudElement element ) {
    if ( element instanceof IManageable ) {
      ICloudElementManager manager
        = ( ( IManageable ) element ).getManager();
      try {
        manager.addElement( element );
      } catch ( ProblemException pExc ) {
        // Should never happen, therefore take no special measures
        Activator.logException( pExc );
      }
    }
  }
  

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#canContain(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return element instanceof ICloudProject;
  }
  
  /**
   * Distribute the specified event to all registered
   * {@link ICloudModelListener}s.
   * 
   * @param event The event to be distributed.
   */
  public void fireModelEvent( final ICloudModelEvent event ) {
    getCloudNotificationService().queueEvent( event );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudRoot#findElement(org.eclipse.core.runtime.IPath)
   */
  @Override
  public ICloudElement findElement( final IPath path ) {
    ICloudElement element = path.isRoot() ? this : null;
    String[] segments = path.segments();
    ICloudContainer container = this;
    for ( String segment : segments ) {
      element = container.findChild( segment );
      if ( element instanceof ICloudContainer ) {
        container = ( ICloudContainer ) element;
      } else {
        break;
      }
    }
    return element;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudRoot#findElement(org.eclipse.core.resources.IResource)
   */
  @Override
  public ICloudElement findElement( final IResource resource ) {
    ICloudElement result = null;
    IPath path = resource.getFullPath();
    if ( ( path.segmentCount() == 0 ) && !path.isEmpty() ) {
      result = CloudModel.getRoot();
    } else {
      ICloudContainer parent = this;
      for ( int i = 0 ; i < path.segmentCount() ; i++) {
        String name = path.segment( i );
        ICloudElement element = parent.findChildWithResource( name );
        if ( i == path.segmentCount() - 1 ) {
          result = element;
        } else if ( element instanceof ICloudContainer ) {
          parent = ( ICloudContainer ) element;
        } 
      }
    }
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.internal.notify.ICloudModelNotifier#addCloudModelListener(org.eclipse.camf.core.model.ICloudModelListener)
   */
  @Override
  public void addCloudModelListener( final ICloudModelListener listener ) {
    getCloudNotificationService().addListener( listener );
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.internal.notify.ICloudModelNotifier#removeCloudModelListener(org.eclipse.camf.core.model.ICloudModelListener)
   */
  @Override
  public void removeCloudModelListener( final ICloudModelListener listener ) {
    getCloudNotificationService().removeListener( listener );    
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.ResourceCloudContainer#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return null;
  }
}
