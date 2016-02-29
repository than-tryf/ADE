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
package org.eclipse.camf.connectors.openstack.auth;

import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.connectors.openstack.internal.Messages;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.auth.AbstractAuthenticationToken;
import org.eclipse.camf.core.auth.AuthenticationException;
import org.eclipse.camf.core.auth.IAuthenticationTokenDescription;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * This {@link OpenStackAuthToken} class is able to provide detailed information
 * regarding the credentials. It acts as a container to hand around, providing
 * authorization credentials.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackAuthToken extends AbstractAuthenticationToken {

  /** The counter used to generate unique ids. */
  private static int openstackAuthTokenCounter;

  /** The flag indicating the validity state of the token */
  private boolean isValid;

  /** The flag denoting the active state. */
  private boolean isActive;

  /** The id of this token. */
  private String tokenId;

  /**
   * Creates a new {@link OpenStackAuthToken} and generate a uniquely identifying id
   * for it.
   * 
   * @param description the {@link OpenStackAuthTokenDescription} to fill this token
   *          with credentials
   */
  public OpenStackAuthToken( final IAuthenticationTokenDescription description ) {
    super( description );
    this.tokenId = generateId();
    this.isActive = true;
  }

  public String getID() {
    return this.tokenId;
  }

  /**
   * Generates an Id used to display a unique identifier to the user.
   * 
   * @return the {@link String} identifying the {@link OpenStackAuthToken}
   */
  private String generateId() {
    OpenStackAuthTokenDescription description = ( OpenStackAuthTokenDescription )getDescription();
    String name = description.getTokenTypeName();

    String openstackAccessId = null;
    if( description.getOpenStackAccessId() != null ) {
      openstackAccessId = description.getOpenStackAccessId();
    }

    Integer counter = Integer.valueOf( ++OpenStackAuthToken.openstackAuthTokenCounter );

    StringBuilder strBuilder = new StringBuilder( name );
    strBuilder.append( " # " + counter ); //$NON-NLS-1$
    if( openstackAccessId != null ) {
      strBuilder.append( " @ " + openstackAccessId ); //$NON-NLS-1$
    }

    return strBuilder.toString();
  }

  public long getTimeLeft() {
    return -1;
  }

  public boolean isActive() {
    return this.isActive;
  }

  public boolean isValid() {
    return this.isValid;
  }

  public void setActive( final boolean active, final IProgressMonitor monitor )
    throws AuthenticationException
  {
    // Check if the token is valid, otherwise throw an exception
    validate();
    if( !isValid() ) {
      throw new AuthenticationException( ICoreProblems.AUTH_TOKEN_NOT_YET_VALID,
                                         Activator.PLUGIN_ID );
    }

    // Check the description of this description for validity
    IAuthenticationTokenDescription aDesc = getDescription();
    if( !( aDesc instanceof OpenStackAuthTokenDescription ) ) {
      throw new AuthenticationException( ICoreProblems.AUTH_INVALID_TOKEN_DESCRIPTION,
                                         Activator.PLUGIN_ID );
    }

    this.isActive = active;
  }

  @Override
  public void setActive( final boolean active ) throws AuthenticationException {
    IProgressMonitor monitor = new NullProgressMonitor();
    setActive( active, monitor );
  }

  public void validate( IProgressMonitor monitor )
    throws AuthenticationException
  {
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    monitor.beginTask( Messages.getString( "OSAuthToken.validation_progress_title" ), 2 ); //$NON-NLS-1$

    // TODO validate token against one of the OpenStack services if desired

    monitor.worked( 1 );

    this.isValid = true;
    monitor.done();
  }

  @Override
  public void validate() throws AuthenticationException {
    IProgressMonitor monitor = new NullProgressMonitor();
    validate( monitor );
  }
}
