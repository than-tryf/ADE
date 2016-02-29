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

import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.connectors.openstack.ui.Messages;
import org.eclipse.camf.core.auth.IAuthenticationToken;
import org.eclipse.camf.ui.dialogs.AuthTokenInfoDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This Dialog extension show details specific to the {@link OpenStackAuthToken}.
 * 
 * @author Moritz Post
 */
public class OpenStackAuthTokenInfoDialog extends AuthTokenInfoDialog {

  /**
   * Create a new {@link OpenStackAuthTokenInfoDialog} with the given token as its
   * information host.
   * 
   * @param token the token to take the information from
   * @param parentShell the shell to open the dialog with
   */
  public OpenStackAuthTokenInfoDialog( final IAuthenticationToken token,
                                 final Shell parentShell )
  {
    super( token, parentShell );
  }

  @Override
  protected Control createInfoArea( final Composite parent ) {

    OpenStackAuthTokenDescription desc = ( OpenStackAuthTokenDescription )getToken().getDescription();
    GridData gData;

    Label spacerLabel = new Label( parent, SWT.LEFT );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    gData.horizontalSpan = 2;
    spacerLabel.setLayoutData( gData );

    // access id text
    Label accessIdLabel = new Label( parent, SWT.LEFT );
    accessIdLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_access_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    accessIdLabel.setLayoutData( gData );

    Text accessIdText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.READ_ONLY );
    accessIdText.setText( desc.getOpenStackAccessId() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    accessIdText.setLayoutData( gData );
    
    // endpoint text
    Label endpointLabel = new Label( parent, SWT.LEFT );
    endpointLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_endpoint" ) ); //$NON-NLS-1$
    gData = new GridData();
    endpointLabel.setLayoutData( gData );

    Text endpointText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.READ_ONLY );
    accessIdText.setText( desc.getOpenStackEndPoint().toString() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    accessIdText.setLayoutData( gData );

    // secret id
    Label secretIdLabel = new Label( parent, SWT.LEFT );
    secretIdLabel.setText( Messages.getString( "OpenStackAuthTokenInfoDialog.label_os_secret_id" ) ); //$NON-NLS-1$
    gData = new GridData();
    secretIdLabel.setLayoutData( gData );

    Text secretIdText = new Text( parent, SWT.LEFT
                                          | SWT.SINGLE
                                          | SWT.BORDER
                                          | SWT.PASSWORD
                                          | SWT.READ_ONLY );
    secretIdText.setText( desc.getOpenStackSecretId() );
    gData = new GridData( GridData.FILL_HORIZONTAL );
    gData.grabExcessHorizontalSpace = true;
    secretIdText.setLayoutData( gData );

    return parent;
  }
}
