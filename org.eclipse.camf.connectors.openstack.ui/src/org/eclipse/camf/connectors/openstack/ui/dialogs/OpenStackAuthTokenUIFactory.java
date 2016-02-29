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
package org.eclipse.camf.connectors.openstack.ui.dialogs;

import java.net.URI;

import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.core.auth.IAuthenticationToken;
import org.eclipse.camf.core.auth.IAuthenticationTokenDescription;
import org.eclipse.camf.ui.AbstractAuthTokenUIFactory;
import org.eclipse.camf.ui.IAuthTokenUIFactory;
import org.eclipse.camf.ui.dialogs.AuthTokenInfoDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;


/**
 * This {@link IAuthTokenUIFactory} provides the {@link OpenStackAuthTokenInfoDialog}
 * {@link Composite} used to provide custom information for the
 * {@link OpenStackAuthToken} info dialog.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackAuthTokenUIFactory extends AbstractAuthTokenUIFactory {

  /** A dummy openstack access id. */
  private static final String DEFAULT = "default"; //$NON-NLS-1$
  /** A dummy openstack endpoint URI. */
  private static final URI DEFAULT_ENDPOINT = URI.create( "http://localhost" ); //$NON-NLS-1$

  /**
   * Default constructor
   */
  public OpenStackAuthTokenUIFactory() {
    // nothing to do here
  }

  public AuthTokenInfoDialog getInfoDialog( final IAuthenticationToken token,
                                            final Shell parentShell )
  {
    return new OpenStackAuthTokenInfoDialog( token, parentShell );
  }

  public IAuthenticationTokenDescription getSupportedDescription() {
    return new OpenStackAuthTokenDescription( OpenStackAuthTokenUIFactory.DEFAULT,
                                              OpenStackAuthTokenUIFactory.DEFAULT_ENDPOINT );
  }

}
