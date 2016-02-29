/*******************************************************************************
 * Copyright (c) 2014 CELAR Consortium.
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
 * Andreas Kastanas - initial API and implementation
 *******************************************************************************/

package org.eclipse.camf.connectors.openstack.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.infosystem.model.base.Deployment;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.Module;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Gathers all necessary items and writes them to a JSON object stored in
 * Preferences. Also, has the functionality to retrieve it
 * 
 * @author Andreas Kastanas
 * 
 */

public class OpenStackOpCreateJSON {

	public OpenStackOpCreateJSON() {

	}

	/**
	 * @Writes the necessary JSON data on Preferences in case of unsuccessful
	 *         deployment
	 * 
	 * @param List
	 *            containing the details of the deployment modules and instances
	 *            to obtain project details
	 * @param String
	 *            appName the description name
	 * @param List
	 *            instances that failed to deploy
	 * @param String
	 *            deploymentID
	 * @param List
	 *            a list that contains the module IDs
	 * @param List
	 *            a list that contains the instance IDs
	 * @param String
	 *            time that the deployment started
	 * @param String
	 *            time that the deployment finished
	 *
	 */
	protected void write_data(List<HashMap<String, String>> xmlinfo,
			String appName, List<String> failed_to_deploy, String depID,
			List<String> modules, List<String> instance, String start_time,
			String finish_time) {

		System.out.println("Creating JSON file...");

		int instance_count = 0;

		JSONObject json = new JSONObject();
		JSONArray deploymentArray = new JSONArray();
		JSONObject deployment = new JSONObject();
		JSONArray modulesArray = new JSONArray();

		try {
			// create deployment details
			deployment.put("appName", appName);
			deployment.put("deploymentID", depID);
			deployment.put("startDeployTime", start_time);
			deployment.put("finishDeployTime", finish_time);

			// check if we have any errors for the appropriate
			// status field
			if (failed_to_deploy.isEmpty())
				deployment.put("status", "deployed");
			else
				deployment.put("status",
						"Failed to deploy instances with name "
								+ failed_to_deploy);

			deployment.put("provider", "OpenStack");
			deploymentArray.put(deployment);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// loop through all the modules we created
		// and create their details
		for (int i = 0; i < modules.size(); i++) {
			try {
				JSONObject module = new JSONObject();
				JSONObject instances = null;
				JSONArray instancesArray = new JSONArray();
				module.put("ModuleID", modules.get(i));
				module.put("ModuleName", xmlinfo.get(i).get("name"));
				module.put("initInstances", xmlinfo.get(i).get("initInstances"));

				// loop through all instances that belongs to the current
				// module and create their details
				for (int j = 0; j < Integer.parseInt(xmlinfo.get(i).get(
						"initInstances"))
						&& j < instance.size(); j++) {
					try {
						instances = new JSONObject();
						instances.put("instanceID",
								instance.get(instance_count));
						instances.put("ImageID", xmlinfo.get(i).get("VMI"));
						instances.put("FlavorID", xmlinfo.get(i).get("flavor"));
						instances.put("KeyPair", xmlinfo.get(i).get("KeyPair"));
						instance_count++;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					instancesArray.put(instances);
					module.put("Instances", instancesArray);
				}
				modulesArray.put(module);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {
			deployment.put("Modules", modulesArray);
			json.put("Deployments", deploymentArray);
			// write json object to deps preferences
			Preferences.setDeploymentStatus(json.toString());
			Preferences.save();
			System.out.println("JSON file created!");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the JSON created and creates the deployment model on the memory
	 * 
	 * @return Deployment Model
	 */
	public List<Deployment[]> getInputData() {

		// read the JSON object from preferences
		String deploymentsString = Preferences.getDeploymentsStatus();
		List<Deployment[]> deploymentdata = new ArrayList<Deployment[]>();
		try {
			JSONObject deploymentsInfo = new JSONObject(deploymentsString);
			JSONArray deploymentsArray = deploymentsInfo
					.getJSONArray("Deployments");
			Deployment[] deployments = new Deployment[deploymentsArray.length()];

			// loop through deployment data and collect each element
			// the store it to a Deployment Object
			for (int i = 0; i < deploymentsArray.length(); i++) {
				try {
					deployments[i] = InfoSystemFactory.eINSTANCE
							.createDeployment();
					JSONObject deployment = deploymentsArray.getJSONObject(i);
					deployments[i].setDepID(deployment
							.getString("deploymentID"));
					deployments[i].setDeploymentName(deployment
							.getString("appName"));
					deployments[i].setStatus(deployment.getString("status"));

					JSONArray modules = deployment.getJSONArray("Modules");
					Module[] Modules = new Module[modules.length()];

					// loop through each module and collect each element
					// then store it to a Module Object
					for (int j = 0; j < modules.length(); j++) {
						try {
							JSONObject module = modules.getJSONObject(j);
							Modules[j] = InfoSystemFactory.eINSTANCE
									.createModule();
							Modules[j].setModID(module.getString("ModuleID"));
							Modules[j].setModuleName(module
									.getString("ModuleName"));
							Modules[j].setInitInstances(module
									.getString("initInstances"));

							JSONArray instances = module
									.getJSONArray("Instances");
							VirtualInstance[] Instances = new VirtualInstance[instances
									.length()];

							// loop through each VM that belongs to the current
							// module and collect his details. Then store them
							// to an instance element
							for (int k = 0; k < instances.length(); k++) {
								try {
									JSONObject instance = instances
											.getJSONObject(k);
									Instances[k] = InfoSystemFactory.eINSTANCE
											.createVirtualInstance();
									Instances[k].setUID(instance
											.getString("instanceID"));
									// add instance to module
									Modules[j].getInstances().add(Instances[k]);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							// add module to deployment
							deployments[i].getModules().add(Modules[j]);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					// add all fetched data to the list we return
					deploymentdata.add(deployments);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return deploymentdata;
	}
}