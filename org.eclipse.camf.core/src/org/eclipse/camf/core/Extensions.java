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
 *    Pawel Wolniewicz, PSNC
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013 
 *****************************************************************************/
package org.eclipse.camf.core;


/**
 * This is a helper class that holds static fields and methods to
 * easily access extension of the g-Eclipse core extension points.
 * 
 */
public class Extensions {
  
  /**
   * The ID of the cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_POINT
    = "org.eclipse.camf.core.cloudElementCreator"; //$NON-NLS-1$
  
  /**
   * The ID of the Cloud element creator configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_ELEMENT
    = "creator"; //$NON-NLS-1$
  
  /**
   * The ID of the Cloud element creator's id attribute.
   */
  public static final String CLOUD_ELEMENT_CREATOR_ID_ATTRIBUTE
    = "id"; //$NON-NLS-1$
  
  /**
   * The ID of the Cloud element creator's name attribute.
   */
  public static final String CLOUD_ELEMENT_CREATOR_NAME_ATTRIBUTE
    = "name"; //$NON-NLS-1$
  
  /**
   * The ID of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_ELEMENT
    = "source"; //$NON-NLS-1$
  
  /**
   * The ID of the class attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_CLASS_ATTRIBUTE
    = "class"; //$NON-NLS-1$
  
  /**
   * The ID of the pattern attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_PATTERN_ATTRIBUTE
    = "pattern"; //$NON-NLS-1$
  
  /**
   * The ID of the priority attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_PRIORITY_ATTRIBUTE
    = "priority"; //$NON-NLS-1$
  
  /**
   * The ID of the default attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_DEFAULT_ATTRIBUTE
    = "default"; //$NON-NLS-1$
  
  /**
   * The ID of the matcher attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_SOURCE_MATCHER_ATTRIBUTE
    = "matcher"; //$NON-NLS-1$
  
  /**
   * The ID of the target configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_TARGET_ELEMENT
    = "target"; //$NON-NLS-1$
  
  /**
   * The ID of the class attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_TARGET_CLASS_ATTRIBUTE
    = "class"; //$NON-NLS-1$
  
  /**
   * The ID of the name attribute of the source configuration element
   * contained in the Cloud element creator extension point.
   */
  public static final String CLOUD_ELEMENT_CREATOR_TARGET_NAME_ATTRIBUTE
    = "name"; //$NON-NLS-1$
  
  /**
   * The ID of the executable extension of the Cloud element creator
   * configuration element.
   */
  public static final String CLOUD_ELEMENT_CREATOR_EXECUTABLE
    = "class"; //$NON-NLS-1$
  
  /**
   * The ID of the resource category extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_POINT
    = "org.eclipse.camf.core.cloudResourceCategory"; //$NON-NLS-1$
  
  /**
   * The ID of the category element of the resource category
   * extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_ELEMENT
    = "category"; //$NON-NLS-1$
  
  /**
   * The ID of the id attribute of the category element
   * of the resource category extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_ID_ATTRIBUTE
    = "id"; //$NON-NLS-1$
  
  /**
   * The ID of the name attribute of the category element
   * of the resource category extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_NAME_ATTRIBUTE
    = "name"; //$NON-NLS-1$
  
  /**
   * The ID of the parent attribute of the category element
   * of the resource category extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_PARENT_ATTRIBUTE
    = "parent"; //$NON-NLS-1$
  
  /**
   * The ID of the active attribute of the category element
   * of the resource category extension point.
   */
  public static final String CLOUD_RESOURCE_CATEGORY_ACTIVE_ATTRIBUTE
    = "active"; //$NON-NLS-1$
  
  /**
   * The ID of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_POINT
    = "org.eclipse.camf.core.cloudProjectFolder"; //$NON-NLS-1$
  
  /**
   * The ID of the folder element of the project folder
   * extension point.
   */
  public static final String PROJECT_FOLDER_ELEMENT
    = "folder"; //$NON-NLS-1$
  
  /**
   * The ID of the id attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_ID_ATTRIBUTE
    = "id"; //$NON-NLS-1$
  
  /**
   * The ID of the name attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_NAME_ATTRIBUTE
    = "name"; //$NON-NLS-1$
  
  /**
   * The ID of the label attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_LABEL_ATTRIBUTE
    = "label"; //$NON-NLS-1$
  
  /**
   * The ID of the element class attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_ELEMENTCLASS_ATTRIBUTE
    = "elementClass"; //$NON-NLS-1$
  
  /**
   * The ID of the preset attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_PRESET_ATTRIBUTE
    = "preset"; //$NON-NLS-1$
  
  /**
   * The ID of the icon attribute of the folder element
   * of the project folder extension point.
   */
  public static final String PROJECT_FOLDER_ICON_ATTRIBUTE
    = "icon"; //$NON-NLS-1$
  
  /**
   * The ID of the authentication token extension point.
   */
  public static final String AUTH_TOKEN_POINT
    = "org.eclipse.camf.core.authTokens"; //$NON-NLS-1$
  
  /**
   * The ID of the authentication token configuration element contained
   * in the authentication token management extension point. 
   */
  public static final String AUTH_TOKEN_ELEMENT
    = "token"; //$NON-NLS-1$
  
  /**
   * The ID of the name attribute of the token element of the
   * authentication token extension point.
   */
  public static final String AUTH_TOKEN_NAME_ATTRIBUTE
    = "name"; //$NON-NLS-1$
  
  /**
   * The ID of the wizard attribute of the token element of the
   * authentication token extension point.
   */
  public static final String AUTH_TOKEN_WIZARD_ATTRIBUTE
    = "wizard"; //$NON-NLS-1$

  /**
   * The ID of the executable extension of the authentication token description
   * configuration element.
   */
  public static final String AUTH_TOKEN_DESCRIPTION_EXECUTABLE
    = "description"; //$NON-NLS-1$
  
  /**
   * The ID of the authentication token provider extension point.
   */
  public static final String AUTH_TOKEN_PROVIDER_POINT
    = "org.eclipse.camf.core.authTokenProvider"; //$NON-NLS-1$
  
  /**
   * The ID of the authentication token provider configuration element
   * contained in the authentication token management extension point. 
   */
  public static final String AUTH_TOKEN_PROVIDER_ELEMENT
    = "provider"; //$NON-NLS-1$
  
  /**
   * The ID of the executable extension of the authentication token
   * provider element.
   */
  public static final String AUTH_TOKEN_PROVIDER_EXECUTABLE
    = "class"; //$NON-NLS-1$
  
  /**
   * The ID of the priority attribute of the provider element of the
   * authentication token provider extension point.
   */
  public static final String AUTH_TOKEN_PROVIDER_PRIORITY_ATTRIBUTE
    = "priority"; //$NON-NLS-1$
}
