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

import org.eclipse.camf.core.internal.model.CloudProviderManager;
import org.eclipse.camf.core.internal.model.CloudRoot;
import org.eclipse.camf.core.internal.model.ElementCreatorRegistry;
import org.eclipse.camf.core.internal.model.HiddenProject;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.internal.model.notify.CloudNotificationService;


/**
 * The <code>CloudModel</code> class is mainly a helper class for dealing
 * with cloud model elements. It defines a method the retrieve the root
 * element of the model (@link {@link #getRoot()}) and several other methods
 * to get element creators for specific use cases. 
 */
public class CloudModel {
  
  /**
   * Get the root element of the Cloud model tree. This is an immutable
   * internal implementation of the {@link ICloudRoot} interface. It is
   * created as singleton the first time this method is called. In
   * subsequent calls this method returns the singleton instance that
   * was created formerly.
   * 
   * @return The root of all evil, i.e. the root element of the Cloud model.
   * @see CloudRoot#getInstance()
   */
  public static ICloudRoot getRoot() {
    return CloudRoot.getInstance();
  }
  
  /**
   * Get the element creator registry that holds a list of all registered
   * Cloud element creators.
   * 
   * @return The model's element creator registry.
   */
  public static IElementCreatorRegistry getCreatorRegistry() {
    return ElementCreatorRegistry.getRegistry();
  }
  
  /**
   * Add the specified {@link ICloudModelListener} to the list of listeners,
   * which be notified about modifications in Cloud model. This static method is
   * used within constructors and class initializers, where cannot call
   * CloudRoot.getInstance().
   * 
   * @see "bug 209160 for reason, why cannot call CloudRoot.getInstance() within constructors"
   * @param listener
   */
  public static void addCloudModelListener( final ICloudModelListener listener ) {
    CloudNotificationService.getInstance().addListener( listener );
  } 
  
  /**
   * Get the Cloud preferences.
   * 
   * @return An instance of {@link ICloudPreferences}.
   * @throws ProblemException If the preferences could not be found
   * or the creation of the preferences failed.
   */
  public static ICloudPreferences getPreferences() throws ProblemException {
    return HiddenProject.getInstance();
  }
  
  /**
   * Get the manager that is dedicated to the management of
   * {@link  CloudProviderManager }s.
   * 
   * @return The core implementation of the {@link ICloudProviderManager}
   * interface.
   */
  public static ICloudProviderManager getCloudProviderManager() {
    return CloudProviderManager.getManager();
  }
  
  public static ICloudDeploymentManager getDeploymentManager(){
    return null;
  }
}
