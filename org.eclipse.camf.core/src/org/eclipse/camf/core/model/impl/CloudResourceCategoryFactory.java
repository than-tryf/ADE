/*****************************************************************************
 * Copyright (c) 2006-2008 CAMF Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * CAMF project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.model.impl;

import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.ExtensionManager;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.internal.model.ResourceCategory;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Factory class for resource categories. The class looks up all extensions
 * of the org.eclipse.camf.core.gridResourceCategory extension point for possible
 * implementations.
 */
public class CloudResourceCategoryFactory {
  
  /**
   * Unique ID for the default applications category as defined by the CAMF core plug-in.
   */
  public static final String ID_ALL = "org.eclipse.camf.core.model.category.all"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default applications category as defined by the CAMF core plug-in.
   */
  public static final String ID_APPLICATIONS = "org.eclipse.camf.core.model.category.applications"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default computing category as defined by the CAMF core plug-in.
   */
  public static final String ID_COMPUTING = "org.eclipse.camf.core.model.category.computing"; //$NON-NLS-1$
 
  
  /**
   * Unique ID for the default data services category as defined by the CAMF core plug-in.
   */
  public static final String ID_DATA_SERVICES = "org.eclipse.camf.core.model.category.services.data"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default info services category as defined by the CAMF core plug-in.
   */
  public static final String ID_INFO_SERVICES = "org.eclipse.camf.core.model.category.services.info"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default job services category as defined by the CAMF core plug-in.
   */
  public static final String ID_JOB_SERVICES = "org.eclipse.camf.core.model.category.services.jobs"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default instrumentation services category as defined by the CAMF core plug-in.
   */
  public static final String ID_INSTRUMENTATION_SERVICES = "org.eclipse.camf.core.model.category.services.instrumentation"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default other services category as defined by the CAMF core plug-in.
   */
  public static final String ID_OTHER_SERVICES = "org.eclipse.camf.core.model.category.services.others"; //$NON-NLS-1$
  
  /**
   * Unique ID for the default storage category as defined by the CAMF core plug-in.
   */
  public static final String ID_STORAGE = "org.eclipse.camf.core.model.category.storage"; //$NON-NLS-1$
  
  
  
  /**
   * Unique ID for the default services category as defined by the CAMF core plug-in.
   */
  public static final String ID_SERVICES = "org.eclipse.camf.core.model.category.services"; //$NON-NLS-1$
 
  /**
   * Unique ID for the default job services category as defined by the CAMF core plug-in.
   */
  public static final String ID_DEPLOYMENT_SERVICES = "org.eclipse.camf.core.model.category.services.deployment"; //$NON-NLS-1$
  
  /**
   * Internal hashtable used to manage already loaded categories.
   */
  private static Hashtable< String, ICloudResourceCategory > categories
    = new Hashtable< String, ICloudResourceCategory >();
  
  /**
   * Internal extension manager used to look up for implementations.
   */
  private static ExtensionManager manager
    = new ExtensionManager();

  /**
   * Get the resource category with the specified ID or <code>null</code>
   * if no such category could be found.
   * 
   * @param id The ID of the category.
   * @return An implementation of {@link ICloudResourceCategory} filled with the
   * information from the corresponding extension or <code>null</code> if no
   * category with the specified ID could be found.
   */
  public static ICloudResourceCategory getCategory( final String id ) {
    
    ICloudResourceCategory result = categories.get( id );
    
    if ( result == null ) {
      List< IConfigurationElement > elements
        = manager.getConfigurationElements( Extensions.CLOUD_RESOURCE_CATEGORY_POINT, Extensions.CLOUD_RESOURCE_CATEGORY_ELEMENT );
      for ( IConfigurationElement element : elements ) {
        String extid = element.getAttribute( Extensions.CLOUD_RESOURCE_CATEGORY_ID_ATTRIBUTE );
        if ( id.equals( extid ) ) {
          
          String name = element.getAttribute( Extensions.CLOUD_RESOURCE_CATEGORY_NAME_ATTRIBUTE );
          String parent = element.getAttribute( Extensions.CLOUD_RESOURCE_CATEGORY_PARENT_ATTRIBUTE );
          String active = element.getAttribute( Extensions.CLOUD_RESOURCE_CATEGORY_ACTIVE_ATTRIBUTE );
          
          ICloudResourceCategory parentCategory = null;
          if ( parent != null ) {
            parentCategory = getCategory( parent );
          }
          
          boolean isActive = true;
          if ( active != null ) {
            isActive = Boolean.parseBoolean( active );
          }
          
          result = new ResourceCategory( name, parentCategory, isActive );
          categories.put( id, result );
          
        }
      }
    }
    
    return result;
    
  }

}
