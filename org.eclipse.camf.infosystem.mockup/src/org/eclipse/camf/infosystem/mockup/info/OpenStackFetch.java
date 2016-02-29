/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *  Andreas Kastanas - Added Security groups, running instances
 *******************************************************************************/
package org.eclipse.camf.infosystem.mockup.info;

import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeFlavors;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeImages;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeInstances;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeKeyPairs;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeNetworks;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeSecurityGroups;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpExceptions;
import org.eclipse.camf.connectors.openstack.operation.OperationExecuter;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.SecurityGroup;
import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.domain.ComputeMetadata;
import org.jclouds.compute.domain.Image;
import org.jclouds.openstack.neutron.v2.domain.Network;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackFetch extends Job {

	private ComputeService computeService;
	private ArrayList<VirtualMachineImage> base_images = null;
	private ArrayList<SoftwareDependency> software_dependencies = new ArrayList<SoftwareDependency>();
	private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
	private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
	private ArrayList<UserApplication> user_apps = new ArrayList<UserApplication>();
	private ArrayList<VirtualNetwork> networks = new ArrayList<VirtualNetwork>();
	private ArrayList<KeyPair> keypairs = new ArrayList<KeyPair>();
	private ArrayList<VirtualMachineImageFlavor> flavors = new ArrayList<VirtualMachineImageFlavor>();
	private ArrayList<VirtualInstance> instances = new ArrayList<VirtualInstance>();
	private ArrayList<SecurityGroup> securityGroups = new ArrayList<SecurityGroup>();

	/**
	 * @param name
	 */
	public OpenStackFetch(final String name) {
		super(name);
	}

	private static OpenStackFetch instance = null;

	/**
	 * @param name
	 * @return
	 */
	public static OpenStackFetch getInstance(final String name) {
		if (instance == null) {
			instance = new OpenStackFetch(name);
		}
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		IProgressMonitor localMonitor = (monitor != null) ? monitor
				: new NullProgressMonitor();
		localMonitor.beginTask("Authenticating with OpenStack endpoint", 9); //$NON-NLS-1$
		try {

			//localMonitor.beginTask( "Creating OpenStack client", 1 ); //$NON-NLS-1$      
			this.computeService = OpenStackClient.getInstance()
					.getComputeService();
			localMonitor.worked(1);

			OpenStackOpDescribeImages operation = new OpenStackOpDescribeImages(
					this.computeService);

			new OperationExecuter().execOp(operation);
			localMonitor.worked(2);
			if (operation.getException() == null) {
				int size = operation.getResult().size();
				this.base_images = new ArrayList<VirtualMachineImage>(size);

				for (Image ami : operation.getResult()) {
					VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE
							.createVirtualMachineImage();
					vmi.setUID(ami.getId());
					vmi.setDescription(ami.getDescription());
					vmi.setName(ami.getName());
					vmi.setURL(ami.getLocation().toString());
					this.base_images.add(vmi);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to get images  list. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.IMAGES);
			}
			localMonitor.worked(3);

			OpenStackOpDescribeNetworks oper_networks = new OpenStackOpDescribeNetworks();
			new OperationExecuter().execOp(oper_networks);

			if (oper_networks.getException() == null) {
				for (Network network : oper_networks.getResult()) {
					VirtualNetwork vn = InfoSystemFactory.eINSTANCE
							.createVirtualNetwork();
					vn.setUID(network.getId());
					vn.setName(network.getName());
					this.networks.add(vn);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to get networks list. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.NETWORK);
			}
			localMonitor.worked(4);

			OpenStackOpDescribeKeyPairs oper_keypairs = new OpenStackOpDescribeKeyPairs();
			new OperationExecuter().execOp(oper_keypairs);

			if (oper_keypairs.getException() == null) {

				for (org.jclouds.openstack.nova.v2_0.domain.KeyPair kp : oper_keypairs
						.getResult()) {
					KeyPair key = InfoSystemFactory.eINSTANCE.createKeyPair();
					key.setName(kp.getName());
					key.setUID(kp.getFingerprint());
					key.setPublicKey(kp.getPublicKey());
					this.keypairs.add(key);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to get keypairs. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.KEYPAIR);
			}
			localMonitor.worked(5);

			OpenStackOpDescribeFlavors oper_flavors = new OpenStackOpDescribeFlavors();
			new OperationExecuter().execOp(oper_flavors);

			if (oper_flavors.getException() == null) {

				for (Flavor flavor : oper_flavors.getResult()) {
					VirtualMachineImageFlavor vmFlavor = InfoSystemFactory.eINSTANCE
							.createVirtualMachineImageFlavor();
					vmFlavor.setName(flavor.getName());
					vmFlavor.setUID(flavor.getId());
					vmFlavor.setHdd(String.valueOf(flavor.getDisk()));
					vmFlavor.setRam(String.valueOf(flavor.getRam()));
					vmFlavor.setVCPU(String.valueOf(flavor.getVcpus()));
					this.flavors.add(vmFlavor);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to get flavor list. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.FLAVORS);
			}
			localMonitor.worked(6);

			OpenStackOpDescribeInstances oper_instances = new OpenStackOpDescribeInstances();
			new OperationExecuter().execOp(oper_instances);

			if (oper_instances.getException() == null) {

				for (ComputeMetadata metadata : oper_instances.getResult()) {
					VirtualInstance vInstance = InfoSystemFactory.eINSTANCE
							.createVirtualInstance();

					vInstance.setName(metadata.getName());
					vInstance.setUID(metadata.getId());
					vInstance.setStatus(this.computeService
							.getNodeMetadata(metadata.getId()).getStatus()
							.toString());
					vInstance.setIPs(this.computeService
							.getNodeMetadata(metadata.getId())
							.getPrivateAddresses().toString());
					vInstance.setURI(metadata.getUri().toString());
					this.instances.add(vInstance);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to create Instance. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.INSTANCE);
			}
			localMonitor.worked(7);

			OpenStackOpDescribeSecurityGroups oper_securitygroups = new OpenStackOpDescribeSecurityGroups();
			new OperationExecuter().execOp(oper_securitygroups);

			if (oper_securitygroups.getException() == null) {

				for (org.jclouds.openstack.nova.v2_0.domain.SecurityGroup securitygroup : oper_securitygroups
						.getResult()) {
					SecurityGroup secgroup = InfoSystemFactory.eINSTANCE
							.createSecurityGroup();
					secgroup.setName(securitygroup.getName());
					secgroup.setUID(securitygroup.getId());
					secgroup.setDescription(securitygroup.getDescription());
					this.securityGroups.add(secgroup);
				}
			} else {
				throw new OpenStackOpExceptions(
						"Failed to get security groups list. Please contact your system administrator",
						OpenStackOpExceptions.ExceptionType.SECURITY_GROUP);
			}
			localMonitor.worked(8);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Status status = new Status(IStatus.OK, "org.eclipse.camf.infosystem", //$NON-NLS-1$
				"Information data fetched successfully."); //$NON-NLS-1$
		
		try {
			fetchJCatascopiaMonitorProbes( localMonitor );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		localMonitor.done();
		return status;
	}

	  //fetch probes from JCatascopia Probe Library
	  private void fetchJCatascopiaMonitorProbes (final IProgressMonitor monitor) throws SQLException, JSONException {
	    
	    //CELAR Manager call : Get Monitoring Probes
	    String probes = getJCatascopiaProbes();
	    
	    if ( probes.equals( "" ) == false ) {
	      
	      probes = "{\"probes\":" + probes + "}";
	      String output_json = probes;
	      JSONObject obj = new JSONObject( output_json );
	      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
	      
	      if ( probes_array != null ){
	        for (int i=0; i < probes_array.length(); i++){
	          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
	          /*
	           * get the necessary mp fields
	           */
	          mp.setName( probes_array.getJSONObject( i ).getString( "probe" )); //$NON-NLS-1$ );
	          mp.setMetrics( probes_array.getJSONObject( i ).getString( "metrics" ) );
	          mp.setDescription( probes_array.getJSONObject( i ).getString( "desc" ) );
	                    
	          //add new monitor probe to probes list
	          this.monitor_probes.add(mp);
	          //instance.monitor_probes.add( mp ); 
	        }
	        
	      }
	    }    
	  }
	  
	  String getJCatascopiaProbes(){
		    JCatascopiaProbeRepo repo = new JCatascopiaProbeRepo();
		    String probes = null;
		    try {
		      probes = repo.getProbes();

		    } catch( JCatascopiaProbeRepoException e ) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    //System.out.println(probes);
		    return probes;
		  }
	/**
	 * @return A list with the available Base Machine Images
	 */
	public ArrayList<VirtualMachineImage> getBaseMachineImages() {
		return instance.base_images;
	}

	/**
	 * @return A list with the available Custom Machine Images
	 */
	// public ArrayList<VirtualMachineImage> getCustomMachineImages () {
	// return instance.custom_images;
	// }

	/**
	 * @return A list with the available Software Dependencies
	 */
	public ArrayList<SoftwareDependency> getSoftwareDependencies() {
		return instance.software_dependencies;
	}

	/**
	 * @return A list with available Monitoring Probes
	 */
	public ArrayList<MonitoringProbe> getMonitoringProbes() {
		return instance.monitor_probes;
	}

	/**
	 * @return A list with available Resizing Actions
	 */
	public ArrayList<ResizingAction> getResizingActions() {
		return instance.resize_actions;
	}

	/**
	 * @return A list with the available User Applications
	 */
	public ArrayList<UserApplication> getUserApplications() {
		return instance.user_apps;
	}

	/**
	 * @return A list with the available Flavors
	 */
	public ArrayList<VirtualMachineImageFlavor> getFlavors() {

		return instance.flavors;
	}

	/**
	 * @return A list with the available Virtual Networks
	 */
	public ArrayList<VirtualNetwork> getNetworks() {
		return instance.networks;
	}

	/**
	 * @return A list with the available User Keypairs
	 */
	public ArrayList<KeyPair> getKeyPairs() {
		return instance.keypairs;
	}

	/**
	 * @return A list with the active instances
	 */
	public ArrayList<VirtualInstance> getInstances() {
		return instance.instances;
	}

	/**
	 * @return A list with the available Security Groups
	 */
	public ArrayList<SecurityGroup> getSecurityGroups() {
		return instance.securityGroups;
	}

}