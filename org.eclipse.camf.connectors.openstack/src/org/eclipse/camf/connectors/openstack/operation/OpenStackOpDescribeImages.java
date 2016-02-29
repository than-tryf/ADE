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
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.Image;

/**
 * This {@link IOperation} implementation uses the {@link ComputeService} to
 * send a query to OpenStack. It fetches all executable machine images, which we
 * can execute
 * 
 * @author Nicholas Loulloudes
 */
public class OpenStackOpDescribeImages extends
		AbstractOpenStackOpDescribeImages {

	private final ComputeService computeService;

	/**
	 * Creates a new {@link OpenStackOpDescribeImages} with the given owners as
	 * parameter.
	 * 
	 * @param computeService
	 *            the {@link ComputeService} to obtain data from
	 */
	public OpenStackOpDescribeImages(final ComputeService computeService) {
		this.computeService = computeService;
	}
	
    public OpenStackOpDescribeImages( final OpenStackClient client ) {
      this.computeService = client.getComputeService();
    }

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

			Set<Image> images = (Set<Image>) this.computeService.listImages();
			setResult(new ArrayList<Image>(images));
		} catch (Exception ex) {
			setException(ex);
		}

	}

}
