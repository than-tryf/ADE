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
package org.eclipse.camf.core.project;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScope;

/**
 * Project scope for the Cloud project that manages project related
 * settings and preferences.
 */
public class CloudProjectScope implements IScope {

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.preferences.IScope#create(org.eclipse.core.runtime.preferences.IEclipsePreferences, java.lang.String)
   */
  public IEclipsePreferences create( final IEclipsePreferences parent,
                                     final String name ) {
    IEclipsePreferences node
      = ( IEclipsePreferences ) parent.node( name );
    return node;
  }
  
}
