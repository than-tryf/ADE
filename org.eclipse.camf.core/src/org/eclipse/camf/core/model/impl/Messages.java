/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.core.model.impl;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author Nicholas Loulloudes
 *
 */
public class Messages {
  private static final String BUNDLE_NAME = "org.eclipse.camf.core.model.impl.messages"; //$NON-NLS-1$
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle( BUNDLE_NAME );

  private Messages() {
    // empty implementation
  }

  /**
   * Auto-generated method.
   * 
   * @param key The key.
   * @return The value.
   */
  public static String getString( final String key ) {
    String result = '!' + key + '!';
    try {
      result = RESOURCE_BUNDLE.getString( key );
    } catch( MissingResourceException e ) {
      // Nothing to do;
    }
    return result;
  }
}
