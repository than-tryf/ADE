/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICreatorSourceMatcher;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackDeploymentServiceCreator extends AbstractCloudElementCreator implements ICreatorSourceMatcher {

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    OpenStackApplicationDeploymentService result = null;
    Object object = getSource();
    result = new OpenStackApplicationDeploymentService( parent );
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