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
package org.eclipse.camf.connectors.aws.operation;

import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.jclouds.cloudwatch.CloudWatchApi;
import org.jclouds.cloudwatch.domain.Metric;

import com.google.common.collect.ImmutableSet;

/**
 * This {@link IOperation} implementation uses the {@link EC2} to send a query
 * to the Amazon CloudWatch. It fetches a list of all the Monitoring metrics
 * 
 * 
 * 
 */
public class EC2OpDescribeMetrics extends AbstractEC2OpDescribeMetrics {

  private final EC2Client ec2;
  private final CloudWatchApi cloudWatch;
  /**
   * Creates a new {@link EC2OpDescribeMetrics} with the given owners as
   * parameter.
   * 
   * @param ec2 the {@link AmazonEC2} to obtain data from
   */
  public EC2OpDescribeMetrics( final EC2Client ec2 ) {
    this.ec2 = ec2;
    this.cloudWatch = ec2.getCloudWatchApi();
//    this.cloudWatch = new AmazonCloudWatchClient( EC2Client.getCredentials() );
//    this.cloudWatch.setRegion( RegionUtils.getRegion( "eu-west-1" ) );
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
    	ImmutableSet<Metric> metrics = cloudWatch.getMetricApiForRegion("AWS/EC2").list().concat().toSet();
//     ListMetricsRequest request = new ListMetricsRequest();
//     request.setNamespace( "AWS/EC2");
//     ListMetricsResult listMetrics = this.cloudWatch.listMetrics( request );
//     List<Metric> metrics = listMetrics.getMetrics();
      setResult( new ArrayList<Metric>(metrics) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
