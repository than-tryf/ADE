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
 *  Andreas Kastanas - added proper comments, changed API to receive more details
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;

/**
 * This {@link IOperation} implementation uses the {@link nova} to send a query
 * to OpenStack. It fetches all available flavors.
 * 
 * @author Nicholas Loulloudes
 * @author Andreas Kastanas - change API to get more details for each flavor
 */
public class OpenStackOpDescribeFlavors extends AbstractOpenStackOpFlavors {

	private final FlavorApi flavorApi;

	/**
	 * Creates a new {@link OpenStackOpDescribeFlavors} to fetch available data
	 * 
	 * 
	 */
	
	public OpenStackOpDescribeFlavors( final OpenStackClient client ) {
      this.flavorApi = client.getFlavorApi();
    }

	public OpenStackOpDescribeFlavors() {
		this.flavorApi = OpenStackClient.getInstance().getFlavorApi();
	}

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<Flavor> flavors = this.flavorApi.listInDetail().concat()
					.toSet();

			setResult(new ArrayList<Flavor>(flavors));
		} catch (Exception ex) {
			setException(ex);
		}

	}

}
