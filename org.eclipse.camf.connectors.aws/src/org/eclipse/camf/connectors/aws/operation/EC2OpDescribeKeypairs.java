/*******************************************************************************
 * Copyright (c) 2015 Laboratory for Internet Computing, University of Cyprus.
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
 *  Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.aws.operation;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.jclouds.ec2.domain.KeyPair;
import org.jclouds.ec2.features.KeyPairApi;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;


public class EC2OpDescribeKeypairs extends AbstractEC2OpDescribeKeypair {

  private final EC2Client ec2;
  /**
   * Creates a new {@link EC2OpDescribeKeypairs} with the given owners as
   * parameter.
   * 
   * @param ec2 the {@link AmazonEC2} to obtain data from
   */
  public EC2OpDescribeKeypairs( final EC2Client ec2 ) {
    this.ec2 = ec2;
  }
 

  @Override
  public void run() {
    setResult( null );
    setException( null );
    try {
    	
    	Optional<? extends KeyPairApi> keyPairApi = ec2.getEC2Api().getKeyPairApi();    	
    	Builder<String, String> filter = ImmutableMultimap.<String, String>builder();
    	Set<? extends KeyPair> keypairs = keyPairApi.get().describeKeyPairsInRegionWithFilter( ec2.getRegion(), filter.build() );

      setResult( new ArrayList<KeyPair>(keypairs) );
    } catch( Exception ex ) {
      setException( ex );
    }

  }

}
