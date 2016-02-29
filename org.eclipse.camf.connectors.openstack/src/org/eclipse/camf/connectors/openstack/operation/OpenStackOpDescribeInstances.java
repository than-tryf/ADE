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
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.ComputeMetadata;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to
 * send a query to OpenStack. It fetches all running instances.
 * 
 * @author Andreas Kastanas
 */
public class OpenStackOpDescribeInstances extends AbstractOpenStackOpInstances {

	private final ComputeService computeAPI;

	/**
	 * Creates a new {@link OpenStackOpDescribeInstances} to fetch available
	 * data.
	 * 
	 */

	public OpenStackOpDescribeInstances() {
		this.computeAPI = OpenStackClient.getInstance().getComputeService();
	}

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<? extends ComputeMetadata> instances = this.computeAPI
					.listNodes();

			setResult(new ArrayList<ComputeMetadata>(instances));
		} catch (Exception ex) {
			setException(ex);
		}
	}
}
