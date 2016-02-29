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
package org.eclipse.camf.connectors.aws;

import org.eclipse.camf.connectors.aws.auth.AWSAuthToken;
import org.eclipse.camf.connectors.aws.auth.AWSAuthTokenDescription;
import org.eclipse.camf.core.auth.AbstractAuthTokenProvider;
import org.eclipse.camf.core.auth.AuthTokenRequest;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.jclouds.ContextBuilder;
import org.jclouds.apis.ApiMetadata;
import org.jclouds.cloudwatch.CloudWatchApi;
import org.jclouds.cloudwatch.CloudWatchApiMetadata;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.ec2.EC2Api;
import org.jclouds.ec2.EC2ApiMetadata;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

/**
 * @author Nicholas Loulloudes
 *
 */
public class EC2Client {

	private static EC2Client instance = null;
	private static EC2Api ec2Api = null;
	private static CloudWatchApi cloudWatchApi;
	private static ContextBuilder computeContextBuilder = null;
	private static ContextBuilder cloudWatchContextBuilder = null;
	private static ComputeService computeService = null;
//	private static String REGION = "eu-west-1"; // IRELAND
	private static String REGION = "us-west-2"; // OREGON

	// public static AmazonEC2Client getInstance() {
	// if( ec2 == null ) {
	// awsCredentials = getAWSAuthCredentials();
	// if( awsCredentials != null ) {
	// ec2 = new AmazonEC2Client( awsCredentials );
	//        ec2.setRegion( RegionUtils.getRegion( "eu-west-1" ) ); //$NON-NLS-1$        
	// }
	// }
	// return ec2;
	// }

	public static EC2Client getInstance() {
		if (instance == null) {
			instance = new EC2Client();
		}
		return instance;
	}


	// public static AWSCredentials getCredentials() {
	// if (awsCredentials != null) {
	// awsCredentials = getAWSAuthCredentials();
	// }
	// return awsCredentials;
	// }

	private EC2Client() {
		if (computeContextBuilder == null) {
			computeContextBuilder = getContextBuilder(new EC2ApiMetadata());
			if (computeContextBuilder != null) {
				ec2Api = computeContextBuilder.buildApi(EC2Api.class);
				computeContextBuilder.buildView(ComputeServiceContext.class).getComputeService();
			}
		}
		
		if (cloudWatchContextBuilder == null) {
			cloudWatchContextBuilder = getContextBuilder(new CloudWatchApiMetadata());
			if (cloudWatchContextBuilder != null) {
				cloudWatchApi = cloudWatchContextBuilder.buildApi(CloudWatchApi.class);
			}
		}
	}

	private static ContextBuilder getContextBuilder(final ApiMetadata metadata) {
		ContextBuilder cb = null;

		ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
		ICloudElement[] children;

		/*
		 * Get the Authentication details for the specific Cloud provider
		 */
		try {
			children = cpManager.getChildren(new NullProgressMonitor());
			String accessId = null;
			for (ICloudElement CloudElement : children) {
				if (CloudElement instanceof AWSCloudProvider) {
					AWSCloudProvider awsCp = (AWSCloudProvider) CloudElement;
					accessId = awsCp.getProperties().getAwsAccessId();
				}
			}
			if (accessId != null) {
				// get the auth token
				AWSAuthTokenDescription awsAuthTokenDesc = new AWSAuthTokenDescription(
						accessId);
				AuthTokenRequest request = new AuthTokenRequest(
						awsAuthTokenDesc, "AmazonAWSFetch", //$NON-NLS-1$
						"Fectch AWS Info"); //$NON-NLS-1$
				AWSAuthToken awsAuthToken = (AWSAuthToken) AbstractAuthTokenProvider
						.staticRequestToken(request);
				if (awsAuthToken != null) {
					Iterable<Module> modules = ImmutableSet
							.<Module> of(new SLF4JLoggingModule());
					cb = ContextBuilder
							.newBuilder(metadata)
							.credentials(awsAuthTokenDesc.getAwsAccessId(),
									awsAuthTokenDesc.getAwsSecretId())
							.modules(modules);
				}
			}
		} catch (ProblemException e) {
			e.printStackTrace();
		}

		return cb;
	}

	// private static AWSCredentials getAWSAuthCredentials() {
	// AWSCredentials credentials = null;
	// ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
	// ICloudElement[] children;
	// try {
	// children = cpManager.getChildren( new NullProgressMonitor() );
	// String accessId = null;
	// for( ICloudElement CloudElement : children ) {
	// if( CloudElement instanceof AWSCloudProvider ) {
	// AWSCloudProvider awsCp = ( AWSCloudProvider )CloudElement;
	// accessId = awsCp.getProperties().getAwsAccessId();
	// }
	// }
	// if( accessId != null ) {
	// // get the auth token
	// AWSAuthTokenDescription awsAuthTokenDesc = new AWSAuthTokenDescription(
	// accessId );
	// AuthTokenRequest request = new AuthTokenRequest( awsAuthTokenDesc,
	//                                                         "AmazonAWSFetch", //$NON-NLS-1$
	//                                                         "Fectch AWS Info" ); //$NON-NLS-1$
	// AWSAuthToken awsAuthToken = ( AWSAuthToken
	// )AbstractAuthTokenProvider.staticRequestToken( request );
	// if( awsAuthToken != null ) {
	// credentials = new BasicAWSCredentials( awsAuthTokenDesc.getAwsAccessId(),
	// awsAuthTokenDesc.getAwsSecretId() );
	// }
	// }
	// } catch( ProblemException e ) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	// return credentials;
	// }

	public ComputeService getComputeService() {
		return EC2Client.computeService;
	}
	
	public EC2Api getEC2Api(){
		return EC2Client.ec2Api;
	}
	
	public String getRegion(){
		return EC2Client.REGION;
	}
	
	public CloudWatchApi getCloudWatchApi() {
		return cloudWatchApi;
	}
}
