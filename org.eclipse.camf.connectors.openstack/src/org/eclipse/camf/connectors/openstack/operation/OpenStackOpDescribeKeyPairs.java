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
 *  Andreas Kastanas - added proper comments
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;

/**
 * This {@link IOperation} implementation uses the {@link nova} to send a query
 * to OpenStack. It fetches all available Key Pairs.
 * 
 * @author Nicholas Loulloudes, Andreas Kastanas
 */
public class OpenStackOpDescribeKeyPairs extends AbstractOpenStackOpKeyPairs {

	private final KeyPairApi keyApi;

	/**
	 * Creates a new {@link OpenStackOpDescribeKeyPairs} to fetch available data
	 * 
	 */

  public OpenStackOpDescribeKeyPairs() {
    this.keyApi = OpenStackClient.getInstance().getKeyPairApi();
  }

  public OpenStackOpDescribeKeyPairs( final OpenStackClient client ) {
    this.keyApi = client.getKeyPairApi();
  }

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<KeyPair> keypairs = this.keyApi.list().toSet();

			setResult(new ArrayList<KeyPair>(keypairs));
		} catch (Exception ex) {
			setException(ex);
		}

	}

}
