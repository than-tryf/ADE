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
 *  Andreas Kastanas - added security groups API, changed neutron api 
 *  					return statement, added getOpenStackZone()
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack;

import java.net.URI;

import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthToken;
import org.eclipse.camf.connectors.openstack.auth.OpenStackAuthTokenDescription;
import org.eclipse.camf.core.auth.AbstractAuthTokenProvider;
import org.eclipse.camf.core.auth.AuthTokenRequest;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.jclouds.ContextBuilder;
import org.jclouds.apis.ApiMetadata;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.neutron.v2.NeutronApi;
import org.jclouds.openstack.neutron.v2.NeutronApiMetadata;
import org.jclouds.openstack.neutron.v2.features.NetworkApi;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.NovaApiMetadata;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;
import org.jclouds.openstack.nova.v2_0.extensions.SecurityGroupApi;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackClient {

	private static OpenStackClient instance = null;
	//  private static String provider = "openstack-nova"; //$NON-NLS-1$
	// private static String network_provider = "openstack-neutron";
	private static NovaApi nova = null;
	private static NeutronApi neutron = null;
	private static ContextBuilder computeContextBuilder = null;
	private static ContextBuilder networkContextBuilder = null;
	private static ComputeService computeService;
	private static final String ZONE = "regionOne";

	public static OpenStackClient getInstance() {
		if (instance == null) {
			instance = new OpenStackClient();
		}
		return instance;
	}

	private OpenStackClient() {

		if (computeContextBuilder == null) {
			computeContextBuilder = getContextBuilder(new NovaApiMetadata());
		}

		if (networkContextBuilder == null) {
			networkContextBuilder = getContextBuilder(new NeutronApiMetadata());
			neutron = networkContextBuilder.buildApi(NeutronApi.class);
		}

		if (computeService == null) {
			computeService = getContextBuilder(new NovaApiMetadata())
					.buildView(ComputeServiceContext.class).getComputeService();
			nova = computeContextBuilder.buildApi(NovaApi.class);
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
			URI endpoint = null;
			for (ICloudElement CloudElement : children) {
				if (CloudElement instanceof OpenStackCloudProvider) {
					OpenStackCloudProvider opCp = (OpenStackCloudProvider) CloudElement;
					accessId = opCp.getProperties().getOpenStackAccessId();
					endpoint = opCp.getProperties().getOpenStackEndpoint();
				}
			}
			if (accessId != null) {
				// get the auth token
				OpenStackAuthTokenDescription openStackAuthTokenDesc = new OpenStackAuthTokenDescription(
						accessId, endpoint);
				AuthTokenRequest request = new AuthTokenRequest(
						openStackAuthTokenDesc, "OpenStackFetch", //$NON-NLS-1$
						"Fectch OpenStack Info"); //$NON-NLS-1$

				OpenStackAuthToken openStackAuthToken = (OpenStackAuthToken) AbstractAuthTokenProvider
						.staticRequestToken(request);

				if (openStackAuthToken != null) {
					Iterable<Module> modules = ImmutableSet
							.<Module> of(new SLF4JLoggingModule());
					cb = ContextBuilder
							.newBuilder(metadata)
							.endpoint(endpoint.toString())
							.credentials(
									openStackAuthTokenDesc
											.getOpenStackAccessId(),
									openStackAuthTokenDesc
											.getOpenStackSecretId())
							.modules(modules);

				}
			}
		} catch (ProblemException e) {
			e.printStackTrace();
		}

		return cb;
	}

	// private static ContextBuilder getContextBuilder() {
	// ContextBuilder builder = null;
	// ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
	// ICloudElement[] children;
	// try {
	// children = cpManager.getChildren( new NullProgressMonitor() );
	// String accessId = null;
	// URI endpoint = null;
	// for( ICloudElement CloudElement : children ) {
	// if( CloudElement instanceof OpenStackCloudProvider ) {
	// OpenStackCloudProvider opCp = ( OpenStackCloudProvider )CloudElement;
	// accessId = opCp.getProperties().getOpenStackAccessId();
	// endpoint = opCp.getProperties().getOpenStackEndpoint();
	// }
	// }
	// if( accessId != null ) {
	// // get the auth token
	// OpenStackAuthTokenDescription openStackAuthTokenDesc = new
	// OpenStackAuthTokenDescription( accessId, endpoint );
	// AuthTokenRequest request = new AuthTokenRequest( openStackAuthTokenDesc,
	//                                                         "OpenStackFetch", //$NON-NLS-1$
	//                                                         "Fectch OpenStack Info" ); //$NON-NLS-1$
	// OpenStackAuthToken openStackAuthToken = ( OpenStackAuthToken
	// )AbstractAuthTokenProvider.staticRequestToken( request );
	// if( openStackAuthToken != null ) {
	// Iterable<Module> modules = ImmutableSet.<Module> of(new
	// SLF4JLoggingModule());
	// builder = ContextBuilder.newBuilder( new NovaApiMetadata() )
	// .endpoint( endpoint.toString() )
	// .credentials( openStackAuthTokenDesc.getOpenStackAccessId(),
	// openStackAuthTokenDesc.getOpenStackSecretId())
	// .modules( modules );
	//
	// networkBuilder = ContextBuilder.newBuilder( new NeutronApiMetadata() )
	// .endpoint( endpoint.toString() )
	// .credentials( openStackAuthTokenDesc.getOpenStackAccessId(),
	// openStackAuthTokenDesc.getOpenStackSecretId() )
	// .modules( modules );
	//
	//
	// }
	// }
	// } catch( ProblemException e ) {
	// e.printStackTrace();
	// }
	//
	//
	// return builder;
	// }

	public NovaApi getNova() {
		return OpenStackClient.nova;
	}

	public ComputeService getComputeService() {
		return OpenStackClient.computeService;
	}

	public NetworkApi getNetworkApi() {
		return OpenStackClient.neutron.getNetworkApi(ZONE);
	}

	public KeyPairApi getKeyPairApi() {
		return OpenStackClient.nova.getKeyPairExtensionForZone(ZONE).get();
	}

	public FlavorApi getFlavorApi() {
		return OpenStackClient.nova.getFlavorApiForZone(ZONE);
	}

	public SecurityGroupApi getSecurityGroupApi() {
		return OpenStackClient.nova.getSecurityGroupExtensionForZone(ZONE)
				.get();
	}

	public String getOpenStackZone() {
		return this.ZONE;
	}
}
