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

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.IConfigurableElementCreator;
import org.eclipse.camf.core.model.IConfiguration;
import org.eclipse.camf.core.reporting.ProblemException;

/**
 * Abstract implementation for VO creators adding the possibility to create VOs
 * from an {@link IConfiguration}.
 */
public abstract class AbstractCloudProviderCreator
    extends AbstractCloudElementCreator
    implements IConfigurableElementCreator {

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#create(eu.geclipse.core.model.ICloudContainer, eu.geclipse.core.config.IConfiguration)
   */
  public ICloudElement create( final ICloudContainer parent,
                              final IConfiguration configuration )
      throws ProblemException {
    setConfiguration( configuration );
    return create( parent );
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#getConfiguration()
   */
  public IConfiguration getConfiguration() {
    Object source = getSource();
    return source instanceof IConfiguration
      ? ( IConfiguration ) source
      : null;
  }

  /* (non-Javadoc)
   * @see eu.geclipse.core.model.IConfigurableElementCreator#setConfiguration(eu.geclipse.core.config.IConfiguration)
   */
  public void setConfiguration( final IConfiguration configuration ) {
    setSource( configuration );
  }

}
