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
 *  Andreas Kastanas - added proper comments, removed unnecessary import
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.openstack.neutron.v2.domain.Network;
import org.jclouds.openstack.neutron.v2.features.NetworkApi;

/**
 * This {@link IOperation} implementation uses the {@link NeutronAPI} to send a
 * query to OpenStack. It fetches all available Networks.
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeNetworks extends
		AbstractOpenStackOpDescribeNetworks {

	private final NetworkApi networkApi;

	/**
	 * Creates a new {@link OpenStackOpDescribeNetworks} to fetch available
	 * networks.
	 * 
	 */
    public OpenStackOpDescribeNetworks( final OpenStackClient client ) {
      this.networkApi = client.getNetworkApi();
    }

	public OpenStackOpDescribeNetworks() {
		this.networkApi = OpenStackClient.getInstance().getNetworkApi();
	}

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {
			Set<Network> netSet = this.networkApi.list().concat().toSet();
			setResult(new ArrayList<Network>(netSet));
		} catch (Exception ex) {
			setException(ex);
		}
	}

}
