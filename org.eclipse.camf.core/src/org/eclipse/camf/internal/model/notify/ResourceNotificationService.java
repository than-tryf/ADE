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
package org.eclipse.camf.internal.model.notify;

import org.eclipse.camf.core.internal.model.CloudRoot;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.camf.core.internal.Activator;


/**
 * This class tracks changes in the Eclipse resource tree and
 * processes them using the {@link CloudElementLifecycleManager}.
 */
public class ResourceNotificationService implements IResourceChangeListener {

private static ResourceNotificationService instance; 
  
  private ResourceNotificationService() {
    ResourcesPlugin.getWorkspace().addResourceChangeListener( this );
  }
  
  /**
   * Get the singleton of this class.
   * 
   * @return The singleton instance.
   */
  public static ResourceNotificationService getInstance() {
    
    if ( instance == null ) {
      instance = new ResourceNotificationService();
    }
    
    return instance;
    
  }
  
  @Override
  public void resourceChanged( final IResourceChangeEvent event ) {
    
    IResourceDelta delta = event.getDelta();
    
    if ( delta != null ) {
    
      CloudNotificationService cloudNotificationService = CloudRoot.getCloudNotificationService();
      
      cloudNotificationService.lock( CloudModel.getRoot() );
      
      CloudElementLifecycleManager visitor = new CloudElementLifecycleManager();
      
      try {
        delta.accept( visitor );
      } catch ( CoreException cExc ) {
        Activator.logException( cExc );
      }
      
      cloudNotificationService.unlock( CloudModel.getRoot() );
      
    }
    
  }
}
