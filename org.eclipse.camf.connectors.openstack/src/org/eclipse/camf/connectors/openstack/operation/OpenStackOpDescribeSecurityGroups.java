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
 * 	Andreas Kastanas - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.openstack.nova.v2_0.domain.SecurityGroup;
import org.jclouds.openstack.nova.v2_0.extensions.SecurityGroupApi;

/**
 * This {@link IOperation} implementation uses the {@link nova} to send a query
 * to OpenStack. It fetches all available Security Groups
 * 
 * @author Andreas Kastanas
 */

public class OpenStackOpDescribeSecurityGroups extends
		AbstractOpenStackOpSecurityGroups {

	private final SecurityGroupApi SecurityGroupApi;

  /**
   * Creates a new {@link OpenStackOpDescribeSecurityGroups} to fetch available
   * data
   */
  public OpenStackOpDescribeSecurityGroups( final OpenStackClient client ) {
    this.SecurityGroupApi = client.getSecurityGroupApi();
  }

  public OpenStackOpDescribeSecurityGroups() {
    this.SecurityGroupApi = OpenStackClient.getInstance().getSecurityGroupApi();
  }

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<SecurityGroup> SecurityGroups = this.SecurityGroupApi.list()
					.toSet();

			setResult(new ArrayList<SecurityGroup>(SecurityGroups));
		} catch (Exception ex) {
			setException(ex);
		}
	}
}
