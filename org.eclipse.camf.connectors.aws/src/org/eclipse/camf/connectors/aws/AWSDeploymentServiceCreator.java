/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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
 *    Moritz Post - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.connectors.aws;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICreatorSourceMatcher;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class AWSDeploymentServiceCreator extends AbstractCloudElementCreator implements ICreatorSourceMatcher {

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    AWSApplicationDeploymentService result = null;
    Object object = getSource();
    result = new AWSApplicationDeploymentService( parent );
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICreatorSourceMatcher#canCreate(java.lang.Object)
   */
  @Override
  public boolean canCreate( Object source ) {
    return false;
  }

}