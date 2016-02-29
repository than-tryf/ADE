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
package org.eclipse.camf.core.model.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResource;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.IProgressMonitor;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudInfoSystem extends AbstractCloudElement
  implements ICloudInfoService
{
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudInfoService#fetchResources(org.eclipse.camf.core.model.ICloudContainer, org.eclipse.camf.core.model.ICloudProvider, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final ICloudResourceCategory category,
                                          final IProgressMonitor monitor )
    throws ProblemException
  {
    return fetchResources( parent, cp, category, false, null, monitor );
  }

  protected ICloudResource[] filterResources( final ICloudResource[] resources,
                                             final Class< ? extends ICloudResource > type,
                                             final boolean remove ) {

    List< ICloudResource > resultList = new ArrayList< ICloudResource >();

    for ( ICloudResource resource : resources ) {
      boolean isType = type.isAssignableFrom( resource.getClass() );
      if ( ( remove && ! isType ) || ( ! remove && isType ) ) {
        resultList.add( resource );
      }
    }

    return resultList.toArray( new ICloudResource[ resultList.size() ] );
  }
}
