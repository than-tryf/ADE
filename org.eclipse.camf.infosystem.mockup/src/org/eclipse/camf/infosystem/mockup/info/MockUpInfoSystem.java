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
package org.eclipse.camf.infosystem.mockup.info;

import java.util.ArrayList;

import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.core.resources.IFile;

/**
 * @author Nicholas Loulloudes MockUpInfoSystem - v1.0.1 another doc
 */
public class MockUpInfoSystem {

	private static MockUpInfoSystem instance = null;
//	 private AmazonAWSFetch resourceFetcher;
	private OpenStackFetch resourceFetcher;

	//private FetchJob resourceFetcher;

	/**
	 * @return The Mockup Information System
	 */
	public static MockUpInfoSystem getInstance() {
		if (instance == null) {
			instance = new MockUpInfoSystem();
		}
		return instance;
	}

	private MockUpInfoSystem() {
//		this.resourceFetcher = FetchJob
//				.getInstance( "Mockup Resource Fetcher" ); //$NON-NLS-1$
//		this.resourceFetcher = AmazonAWSFetch
//				.getInstance( "AWS Resource Fetcher" ); //$NON-NLS-1$
		this.resourceFetcher = OpenStackFetch
				.getInstance("OpenStack Resource Fetcher"); //$NON-NLS-1$
		this.resourceFetcher.schedule();
	}

	public static MockUpInfoSystem getInstance(IFile toscaFile) {
		if (instance == null) {
			instance = new MockUpInfoSystem(toscaFile);
		}
		return instance;
	}

	private MockUpInfoSystem(IFile toscaFile) {
//    	this.resourceFetcher = FetchJob.getInstance( "Mockup Resource Fetcher" ); //$NON-NLS-1$
//		this.resourceFetcher = AmazonAWSFetch.getInstance( "AWS Resource Fetcher" ); //$NON-NLS-1$
		this.resourceFetcher = OpenStackFetch
				.getInstance("OpenStack Resource Fetcher"); //$NON-NLS-1$
		this.resourceFetcher.schedule();
	}

	/**
	 * @return A list of available base machine images
	 */
	public ArrayList<VirtualMachineImage> getBaseMachineImages() {
		return this.resourceFetcher.getBaseMachineImages();
	}

	/**
	 * @return A list of available monitoring probes
	 */
	public ArrayList<MonitoringProbe> getMonitoringProbes() {
		return this.resourceFetcher.getMonitoringProbes();
	}

	/**
	 * @return A list of available resizing actions
	 */
	public ArrayList<ResizingAction> getResizingActions() {
		return this.resourceFetcher.getResizingActions();
	}

	// // TODO - nickl Reflect this to the infosystem model
	public ArrayList<VirtualMachineImageFlavor> getFlavors() {
		return this.resourceFetcher.getFlavors();
	}

	// public ArrayList<String> getInstanceTypes () {
	// return this.resourceFetcher.getInstanceTypes();
	// }

	public ArrayList<VirtualNetwork> getNetworks() {
		return this.resourceFetcher.getNetworks();
	}
	
	public ArrayList<KeyPair> getKeyPairs() {
		return this.resourceFetcher.getKeyPairs();
	}

}
