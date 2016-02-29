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
package org.eclipse.camf.connectors.openstack.ui.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.core.auth.AuthenticationException;
import org.eclipse.camf.core.auth.AuthenticationTokenManager;
import org.eclipse.camf.core.auth.IAuthenticationToken;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * This {@link IRunnableWithProgress} object encapsulates the token creation
 * process of an {@link OpenStackAuthToken}. The creation and validation is confined
 * within its own runnable container. Any failures in creating the
 * {@link OpenStackAuthToken} result in a {@link AuthenticationException}, bound to
 * the problem <code>org.eclipse.camf.connectors.openstack.problem.auth.authFailed</code>.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackKeyStoreCreationOperation implements IRunnableWithProgress {

  /**
   * The {@link IAuthenticationTokenDescription} to create the
   * {@link IAuthenticationToken} from
   */
  private OpenStackAuthTokenDescription description;

  /**
   * The constructor takes an {@link OpenStackAuthTokenDescription} object, which is
   * able to create the desired {@link OpenStackAuthToken}.
   * 
   * @param description the {@link IAuthenticationTokenDescription} to create
   *            the {@link IAuthenticationToken} from
   */
  public OpenStackKeyStoreCreationOperation( final OpenStackAuthTokenDescription description )
  {
    this.description = description;
  }

  public void run( final IProgressMonitor monitor )
    throws InvocationTargetException, InterruptedException
  {

    // create the new token and validate it if the creation was successful
    AuthenticationTokenManager manager = AuthenticationTokenManager.getManager();
    IAuthenticationToken token = null;
    try {
      token = manager.createToken( this.description );
      if( token != null ) {
        token.validate( monitor );
      }
    } catch( AuthenticationException authEx ) {
      if( token != null ) {
        try {
          manager.destroyToken( token );
        } catch( AuthenticationException authExDestroy ) {
          Activator.log( "Problems destroying invalid token", authExDestroy ); //$NON-NLS-1$
        }
      }
      throw new InvocationTargetException( authEx );
    }

  }

}
