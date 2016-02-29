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
 *    Katarzyna Bylec
 *****************************************************************************/

package org.eclipse.camf.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.core.ExtensionManager;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.camf.ui.properties.IPropertiesFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * This is a helper class that holds static fields and methods to easily access
 * extension of the g-Eclipse ui extension points.
 * 
 * @author stuempert-m
 */
public class Extensions {

  /**
   * The ID of the authentication token ui extension point.
   */
  public static final String AUTH_TOKEN_UI_POINT = "org.eclipse.camf.ui.authTokenUI"; //$NON-NLS-1$
  /**
   * The ID of the authentication token ui factory element contained in the
   * authentication token ui extension point.
   */
  public static final String AUTH_TOKEN_FACTORY_ELEMENT = "factory"; //$NON-NLS-1$
  /**
   * The ID of the executable extension of the authentication token ui factory
   * configuration element.
   */
  public static final String AUTH_TOKEN_FACTORY_EXECUTABLE = "class"; //$NON-NLS-1$
  /**
   * The ID of the connection wizard extension point.
   */  
  
  /**
   * The ID of the wizard extension wizard element.
   */
  public static final String WIZARD_EXTENSION_ELEMENT = "wizard"; //$NON-NLS-1$
  
  /**
   * The ID of the wizard extension wizard element's refid attribute.
   */
  public static final String WIZARD_EXTENSION_REFID_ATTRIBUTE = "refid"; //$NON-NLS-1$
  
  /**
   * The ID of the wizard extension wizard element's executable.
   */
  public static final String WIZARD_EXTENSION_EXECUTABLE = "class"; //$NON-NLS-1$
  
  /**
   * The ID of the wizard extension wizard element's executable.
   */
  public static final String WIZARD_EXTENSION_CLOUD_ICON = "cloudicon"; //$NON-NLS-1$
  
  
  private static final String PROPERTIES_FACTORY_POINT = "org.eclipse.camf.ui.propertiesFactory";  //$NON-NLS-1$
  private static final String PROPERTIES_FACTORY_ELEMENT = "PropertiesFactory"; //$NON-NLS-1$
  private static final String PROPERTIES_FACTORY_SOURCECLASS_ATTR = "sourceObjectClass"; //$NON-NLS-1$
  private static final String PROPERTIES_FACTORY_CLASS_ATTR = "class"; //$NON-NLS-1$


  /**
   * Get a list of all currently registered authentication token ui factories.
   * 
   * @return A list containing instances of all currently registered extensions
   *         of the authentication token ui configuration elements.
   */
  static public List<IAuthTokenUIFactory> getRegisteredAuthTokenUIFactories() {
    List<IAuthTokenUIFactory> resultList = new ArrayList<IAuthTokenUIFactory>();
    ExtensionManager browser = new ExtensionManager();
    List<Object> objectList = browser.getExecutableExtensions( AUTH_TOKEN_UI_POINT,
                                                               AUTH_TOKEN_FACTORY_ELEMENT,
                                                               AUTH_TOKEN_FACTORY_EXECUTABLE );
    for( Object o : objectList ) {
      if( o instanceof IAuthTokenUIFactory ) {
        resultList.add( ( IAuthTokenUIFactory )o );
      }
    }
    return resultList;
  }

  /**
   * Scan registered plugins and return all {@link IPropertiesFactory}, which support properties for 
   * class <code>sourceObjectClass</code>, or for <code>sourceObjectClass</code> base classes, or for
   *  <code>sourceObjectClass</code> interfaces.   
   * @param sourceObjectClass class of object, for which we need properties 
   * @return all factories, which can produces properties for sourceObjectClass 
   */
  static public List<IPropertiesFactory> getPropertiesFactories( final Class<?> sourceObjectClass )
  {
    List<IPropertiesFactory> propertiesFactoryList = new ArrayList<IPropertiesFactory>();
    ExtensionManager extManager = new ExtensionManager();
    List<IConfigurationElement> confElementsList = extManager.getConfigurationElements( PROPERTIES_FACTORY_POINT,
                                                                                        PROPERTIES_FACTORY_ELEMENT );
    for( IConfigurationElement element : confElementsList ) {
      String currentSourceObjectString = element.getAttribute( PROPERTIES_FACTORY_SOURCECLASS_ATTR );
      if( currentSourceObjectString != null ) {
        try {
          if( isInstanceOf( sourceObjectClass, currentSourceObjectString ) ) {
            IPropertiesFactory factory = ( IPropertiesFactory )element.createExecutableExtension( PROPERTIES_FACTORY_CLASS_ATTR );
            propertiesFactoryList.add( factory );
          }
        } catch( CoreException exception ) {
          Activator.logException( exception );
        }
      } else {
        Activator.logStatus( new Status( IStatus.ERROR,
                                         Activator.PLUGIN_ID,
                                         IStatus.ERROR,
                                         "Attribute " //$NON-NLS-1$
                                             + PROPERTIES_FACTORY_SOURCECLASS_ATTR
                                             + " not found", //$NON-NLS-1$
                                         null ) );
      }
    }
    return propertiesFactoryList;
  }
  
  /**
   * Make the same what {@link Class#isAssignableFrom(Class)}
   * <p>
   * Why we cannot use {@link Class#isAssignableFrom(Class)}?<br>
   * {@link Class#isAssignableFrom(Class)} needs instance of Class as parameter.
   * Unfortunately we have only full class name, and we don't want to load this
   * class if wasn't loaded yet. So, instead to compare {@link Class} objects,
   * we just compare class name. Similar solution was used in Eclipse. See:
   * <code>TabbedPropertyRegistryClassSectionFilter.appliesToEffectiveType()</code>
   * 
   * @param checkedObjectClass
   * @param fullyClassNameString
   * @return true if: <br>
   *         checkedObjectClass is instance of fullyClassNameString <br>
   *         or checkedObjectClass inherit fullyClassNameString <br>
   *         or checkedObjectClass implement interface fullyClassNameString <br>
   */
  static private boolean isInstanceOf( final Class<?> checkedObjectClass,
                                       final String fullyClassNameString )
  {
    boolean isInstance = false;
    if( checkedObjectClass.getName().equals( fullyClassNameString ) ) {
      isInstance = true;
    } else {      
      // check interfaces of this class
      isInstance = ( findInterface( checkedObjectClass, fullyClassNameString ) != null );
    }
    
    // check base class
    if( isInstance == false && checkedObjectClass.getSuperclass() != null ) {
      isInstance = isInstanceOf( checkedObjectClass.getSuperclass(),
                                 fullyClassNameString );
    }
    return isInstance;
  }
  
  static private Class<?> findInterface( final Class<?> checkedObjectClass, 
                                               final String fullyInterfaceNameString ) {
    Class<?> foundInterface = null;
    Class<?>[] interfaces = checkedObjectClass.getInterfaces();
    
    for( int index = 0; index < interfaces.length && foundInterface == null; index++ ) {
      if( interfaces[index].getName().equals( fullyInterfaceNameString ) ) {
        foundInterface = interfaces[index];
      }
      else {
        foundInterface = findInterface( interfaces[index], fullyInterfaceNameString );
      }
    }
    
    return foundInterface;
  }



}
