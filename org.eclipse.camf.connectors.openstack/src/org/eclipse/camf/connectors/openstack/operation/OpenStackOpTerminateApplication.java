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
import java.util.HashMap;
import java.util.List;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.eclipse.camf.infosystem.model.base.Deployment;
import org.eclipse.camf.infosystem.model.base.Module;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;
import org.eclipse.emf.common.util.EList;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;

/**
 * Main class that according to Constructor inputs, terminates the whole
 * deployment, or a specific module or instance
 *
 * @author Andreas Kastanas
 */

public class OpenStackOpTerminateApplication extends
		AbstractOpenStackOpTerminateApplication {

	private HashMap<String, Deployment> deployments = new HashMap<String, Deployment>();
	private String depID = new String();
	private List<String> modules = new ArrayList<String>();
	private List<String> instances = new ArrayList<String>();

	private NovaApi nova = OpenStackClient.getInstance().getNova();
	private String zone = OpenStackClient.getInstance().getOpenStackZone();

	public OpenStackOpTerminateApplication(HashMap<String, Deployment> dep,
			String depid, List<String> mods, List<String> inst) {
		this.deployments = dep;
		this.depID = depid;
		this.modules = mods;
		this.instances = inst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDeployApplication
	 * #run()
	 */
	@Override
	public void run() {

		setResult(null);
		setException(null);
		try {
			// loop through all modules, get their instances and try to
			// terminate them and finally remove the modules
			for (int i = 0; i < this.modules.size(); i++) {
				if (this.terminateModule(this.depID, this.modules.get(i)))
					System.out
							.println("Successfully terminate module with modID: "
									+ modules.get(i)
									+ ", for deployment with depID: "
									+ this.depID);
				else
					System.out
							.println("Failed to terminate module with modID: "
									+ this.modules.get(i)
									+ ", for deployment with depID: "
									+ this.depID);
			}

			// remove the deployment that contained the modules we removed above
			if (this.terminateDeployment(this.depID))
				System.out
						.println("Successfully terminated deployment with depID: "
								+ this.depID);
			else
				System.out
						.println("Failed to terminated deployment with depID: "
								+ this.depID);

		} catch (Exception ex) {
			this.setException(ex);
			ex.printStackTrace();
		}
	}

	public Object getResult() {
		return null;
	}

	/**
	 * Terminates all instances inside a module and then removes the module
	 * itself
	 * 
	 * @param depID
	 *            a DeploymentID
	 * @param modID
	 *            a ModuleID
	 * @return true if termination was successful else false
	 */
	private boolean terminateModule(String depID, String modID) {
		Deployment d = this.deployments.get(depID);
		if (d != null) {
			Module module = null;
			for (Module m : d.getModules()) {
				if (m.getModID().equals(modID)) {
					module = m;
					EList<VirtualInstance> ilist = module.getInstances();
					for (int i = ilist.size(); i > 0; i--)
						this.removeInstanceFromModule(depID, modID,
								ilist.get(i - 1).getUID());

					removeModule(d, modID);

					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Removes an instance from a module given a deployment id, module id and
	 * the instance id we want to remove
	 * 
	 * @param depID
	 *            a DeploymentID
	 * @param modID
	 *            a ModuleID
	 * @param vID
	 *            an InstanceID
	 * @return true if instance removed successfully
	 */
	private boolean removeInstanceFromModule(String depID, String modID,
			String vID) {
		Deployment d = this.deployments.get(depID);
		if (d != null) {
			Module module = null;
			for (Module m : d.getModules()) {
				if (m.getModID().equals(modID))
					module = m;
			}

			if (module != null) {
				if (terminateInstance(vID)) {
					removeInstance(module, vID);
					System.out.println("Successfully removed instance: " + vID);
					return true;
				} else
					System.out.println("Instance does not exist: " + vID);
			} else
				System.out
						.println("module ID does not exist, please create a module in a valid deployment first");
		}
		System.out
				.println("deployment ID does not exist, please create a deployment first");

		return false;
	}

	/**
	 * Terminates an instance from the provider based on the parameter that was
	 * given
	 * 
	 * @param vID
	 *            an InstanceID
	 * @return true if the termination from the provides was successful
	 */
	private boolean terminateInstance(String vID) {
		ServerApi serverAPI = this.nova.getServerApiForZone(this.zone);
		try {
			if (serverAPI.delete(vID)) {
				return true;
			}
		} catch (Exception ex) {
			try {
				throw new OpenStackOpExceptions(
						"Failed to terminate. Please contact your system administrator.",
						OpenStackOpExceptions.ExceptionType.TERMINATE);
			} catch (OpenStackOpExceptions CustomExcpetion) {
				this.setException(ex);
				System.err.println(CustomExcpetion.getLocalizedMessage());
				// CustomExcpetion.printStackTrace();
			}
		}
		return false;
	}

	public boolean terminateModuleInstance(String vID){
		return terminateInstance(vID);
	}
	/**
	 * Terminates a deployment based on the deployment ID
	 * 
	 * @param depID
	 *            a DeploymentID
	 * @return true if deployment terminated successfully
	 */
	private boolean terminateDeployment(String depID) {
		boolean response = (this.deployments.remove(depID) != null) ? true
				: false;

		return response;
	}

	/**
	 * Removes a module from a deployment
	 * 
	 * @param dep
	 *            a Deployment Object
	 * @param modID
	 *            a ModuleID
	 */
	private void removeModule(Deployment dep, String modID) {
		for (int i = 0; i < dep.getModules().size(); i++) {
			Module m = dep.getModules().get(i);
			if (m.getModID().equals(modID))
				dep.getModules().remove(i);
		}
	}

	/**
	 * Removes an instance from the module that was given
	 * 
	 * @param m
	 * @param instID
	 */
	private void removeInstance(Module mod, String instID) {
		for (int i = 0; i < mod.getInstances().size(); i++) {
			VirtualInstance obj = mod.getInstances().get(i);
			if (obj.getUID().equals(instID))
				mod.getInstances().remove(i);
		}
	}
}