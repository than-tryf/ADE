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
package org.eclipse.camf.connectors.aws.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.jclouds.ec2.domain.SecurityGroup;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;


/**
 * This {@link IOperation} implementation uses the {@link nova} to send a query
 * to OpenStack. It fetches all available Security Groups
 * 
 * @author Andreas Kastanas
 */

public class EC2OpDescribeSecurityGroups extends
		AbstractEC2OpSecurityGroups {

  private Optional<? extends org.jclouds.ec2.features.SecurityGroupApi> securityGroupApi;
  private final EC2Client ec2;

  /**
   * Creates a new {@link EC2OpDescribeSecurityGroups} to fetch available
   * data
   */
  public EC2OpDescribeSecurityGroups( final EC2Client client ) {
    this.ec2 = client;
    securityGroupApi = client.getEC2Api().getSecurityGroupApi();
  }

  public EC2OpDescribeSecurityGroups() {
    this.ec2 = EC2Client.getInstance();
    this.securityGroupApi = this.ec2.getEC2Api().getSecurityGroupApi();
  }

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {

		  Builder<String, String> filter = ImmutableMultimap.<String, String>builder();
		  Set<? extends SecurityGroup> securityGroups = this.securityGroupApi.get().describeSecurityGroupsInRegionWithFilter( this.ec2.getRegion(), filter.build() );

			setResult(new ArrayList<SecurityGroup>(securityGroups));
		} catch (Exception ex) {
			setException(ex);
		}
	}
}
