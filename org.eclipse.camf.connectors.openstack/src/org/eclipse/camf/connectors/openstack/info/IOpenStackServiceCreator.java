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
package org.eclipse.camf.connectors.openstack.info;

import org.eclipse.camf.core.model.ICloudElementCreator;

/**
 * @author nickl
 *
 */
public interface IOpenStackServiceCreator extends ICloudElementCreator {

	public void setName(String name);

	public String getName();

	/**
	 * Set the url the service interacts with.
	 * 
	 * @param url
	 * the url to set
	 */
	public void setServiceURL(String url);

	/**
	 * Gets the service url of the service to be created.
	 * 
	 * @return the service url to get
	 */
	public String getServiceURL();

}
