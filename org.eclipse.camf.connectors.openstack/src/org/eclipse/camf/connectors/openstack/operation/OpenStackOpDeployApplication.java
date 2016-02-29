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
 *  Andreas Kastanas    - added deployment policies, auxiliary functions for the
 *  					 deployment model, deployment status
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.operation;

import static org.jclouds.compute.options.TemplateOptions.Builder.runScript;
import static org.jclouds.scriptbuilder.domain.Statements.exec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.infosystem.model.base.Deployment;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.Module;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.jclouds.compute.ComputeService;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.Flavor;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;
import org.jclouds.openstack.nova.v2_0.domain.ServerCreated;
import org.jclouds.openstack.nova.v2_0.extensions.KeyPairApi;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;
import org.jclouds.scriptbuilder.ScriptBuilder;
import org.jclouds.scriptbuilder.domain.OsFamily;

import com.google.common.base.Charsets;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Ordering;
import com.google.common.io.Files;

/**
 * Main class that gathers the necessary elements from the TOSCA description and
 * makes the deployment to the OpenStack provider
 * 
 * @author Nicholas Loulloudes
 * @author Andreas Kastanas
 * 
 */
public class OpenStackOpDeployApplication extends
		AbstractOpenStackOpDeployApplication {

	private TOSCAResource toscaResource;
	private ICloudProject project;
	private final static String DEP_SCRIPTS = "/Artifacts/Deployment Scripts/";

	public enum ActionToDo {
		CONTINUE_ON_ERROR, STOP_ON_ERROR, TERMINATE_AND_REVERT_ON_ERROR
	};

	public String depID;
	public HashMap<String, Deployment> deployments = new HashMap<String, Deployment>();
	public List<String> modules = new ArrayList<String>();
	public List<String> instances = new ArrayList<String>();
	public List<String> failed_to_deploy = new ArrayList<String>();
	private ActionToDo ActiontoDo;
	private HashMap<String, String> params = new HashMap<String, String>();
	private OpenStackOpCreateJSON json = new OpenStackOpCreateJSON();;
	private String zone = OpenStackClient.getInstance().getOpenStackZone();
	private NovaApi nova = OpenStackClient.getInstance().getNova();
	private KeyPairApi keyPairApi = nova.getKeyPairExtensionForZone(this.zone)
			.get();
	private ServerApi serverApi = nova.getServerApiForZone(this.zone);
	private TOSCAModel toscaModel = null;

	public OpenStackOpDeployApplication(final OpenStackClient client,
	                                    final ICloudApplicationDescription description) {
	  if( description instanceof TOSCAResource ) {
	      this.toscaResource = ( TOSCAResource ) description;
	      this.toscaModel = this.toscaResource.getTOSCAModel();
	      this.project = this.toscaResource.getProject();
	    } else if (description instanceof TOSCAModel) {
	      this.toscaModel = (TOSCAModel) description;
	      this.project = this.toscaModel.getProject();
	    } else {
	      this.toscaResource = null;
	      this.toscaModel = null;
	    }		
	}

	public OpenStackOpDeployApplication(final OpenStackClient client,
			final TOSCAResource tosca, ActionToDo action) {
		this.toscaResource = tosca;
		this.project = this.toscaResource.getProject();
		this.ActiontoDo = action;
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
			// set Start time of the deployment
			String start_time = new SimpleDateFormat("dd/M/yyyy hh:mm:ss")
					.format(Calendar.getInstance().getTime());

	
//			TOSCAModel toscaModel = this.toscaResource.getTOSCAModel();
			TServiceTemplate serviceTemplate = toscaModel.getServiceTemplate();
			List<HashMap<String, String>> xmlinfo = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> array = null;

			if (serviceTemplate != null) {
				TTopologyTemplate topologyTemplate = serviceTemplate
						.getTopologyTemplate();

				// get AppName and create the Deployment object
				this.depID = this.createDeployment(serviceTemplate.getName());
				System.out.println("Created new Deployment with depID: "
						+ this.depID);

				if (topologyTemplate != null) {
					EList<TNodeTemplate> nodeTemplateList = topologyTemplate
							.getNodeTemplate();
					if (nodeTemplateList != null) {
						// Instantiate each node in the topology
						for (TNodeTemplate node : nodeTemplateList) {

							String modID = this.createModule(this.depID,
									node.getName());
							this.modules.add(modID);
							System.out
									.println("Created new module with modID: "
											+ modID + ", name: "
											+ node.getName());

							// get initInstance number and maxInstances number
							int minCount = node.getMinInstances();
							int maxCount = ((BigInteger) node.getMaxInstances())
									.intValue();

							PropertiesType properties = node.getProperties();
							String nodeFlavor = null;

							FeatureMap propFeatMap = properties.getAny();
							for (Entry entry : propFeatMap) {
								if (entry instanceof NodePropertiesType)
									nodeFlavor = ((NodePropertiesType) entry)
											.getFlavor();
							}

							// Get Deployment Artifacts
							TDeploymentArtifacts deploymentArtifacts = node
									.getDeploymentArtifacts();

							String amiID = null;
							String flavorID = null;
							String keyPairArtifact = null;
							String keypairName = null;
							KeyPair keyPair = null;
							boolean keyPairExists = false;
							String networks = null;
							String scriptName = null;
							String script = null;
							String vID = null;

							for (TDeploymentArtifact artifact : deploymentArtifacts
									.getDeploymentArtifact()) {

								array = new HashMap<String, String>();

								// Find the VMI Keypair, Network
								// and Script artifacts
								String artifactType = artifact
										.getArtifactType().toString();

								
								if (artifactType.equals("{http://www.example.org/NewXMLSchema}ImageArtifactPropertiesType")) { //$NON-NLS-1$
									amiID = artifact.getName();
//								if (artifactType.equals("VMI")) { //$NON-NLS-1$
//									amiID = artifact.getName();
								} else if (artifactType.equals("KeyPair")) { //$NON-NLS-1$
									keyPairArtifact = artifact.getName();
								} else if (artifactType.equals("Network")) {
									networks = artifact.getName();
								} else if (artifactType.equals("SD")) {
									scriptName = artifact.getName();
									if (artifact.getName().endsWith( ".sh" )){
									  String string = Files.toString(importScript( artifact.getName(), project ), Charsets.UTF_8 );
					                  script = new ScriptBuilder().addStatement( exec (string ) ).render( OsFamily.UNIX );
									}
								}

								// get Key Pair
								if (keyPairArtifact != null) {
									String encodedPublicKey = importKeyPair(
											keyPairArtifact, this.project);

									// Strip extension. - Get file name only
									if (encodedPublicKey != null) {
										keypairName = keyPairArtifact
												.substring(0, keyPairArtifact
														.indexOf(".")); //$NON-NLS-1$
									} else {
										keypairName = keyPairArtifact;
									}
									keyPairExists = keyPairExists(
											this.keyPairApi, keypairName);
									if (!keyPairExists) {
										keyPair = this.keyPairApi
												.createWithPublicKey(
														keypairName,
														encodedPublicKey);
									}
								}

								// get instance flavor ID
								if (nodeFlavor != null) {
									flavorID = flavorRefForRegion(this.nova,
											this.zone);
								} else {
									flavorID = "3";
								}

//								String statements = null;
//								if (scriptName != null) {
//									statements = importScript(scriptName,
//											this.project);
//								}
							}

							CreateServerOptions sv;
							if (networks != null)
								sv = CreateServerOptions.Builder.adminPass(
										"test").networks(networks); //$NON-NLS-1$
							else
								sv = CreateServerOptions.Builder
										.adminPass("test"); //$NON-NLS-1$

							if (!keyPairExists) {
								if (keyPair != null) {
									sv.keyPairName(keypairName);
								}
							} else {
								sv.keyPairName(keypairName);
							}
							
							if (script != null) {
							  sv.userData( script.getBytes() );
							}

							// create each instance for each module
							// based on the initInstance parameter
							for (int i = 1; i <= minCount; i++) {
								this.params.put("name", node.getName() + "_"
										+ i);
								this.params.put("amiID", amiID);
								this.params.put("flavor", flavorID);

								try {
									// try to create VM based on the data
									// collected above.
									// if an error occurs throw a Custom
									// Exception and proceed
									// to the next step based on the deployment
									// policy
									vID = this.addInstanceToModule(this.depID,
											modID, this.params, sv);
								} catch (Exception ex) {
									try {
										throw new OpenStackOpExceptions(
												"Failed to deploy. Please contact your system administrator.",
												OpenStackOpExceptions.ExceptionType.DEPLOY);
									} catch (OpenStackOpExceptions CustomExcpetion) {
										this.setException(ex);
										System.err.println(CustomExcpetion
												.getLocalizedMessage());
									}
								}
								// if instance creation failed, enter a dummy id
								if (vID == null) {
									this.failed_to_deploy.add(node.getName());
									this.instances.add("Unknown InstanceID");
									// we have an error! check deployment policy
									// to see how we must proceed
									if (!ActiontoDo
											.equals(ActionToDo.CONTINUE_ON_ERROR))
										break;
								} else {
									this.instances.add(vID);
								}
								System.out
										.println("Added new Instance to module with id: "
												+ vID);
							}
							// save info for later usage on JSON creation
							array.put("name", node.getName());
							array.put("VMI", amiID);
							array.put("flavor", flavorID);
							array.put("KeyPair", keypairName);
							array.put("initInstances", String.valueOf(minCount));
							xmlinfo.add(array);
							// if an error occurred above and we must stop then
							// terminate the deployment
							if (!this.failed_to_deploy.isEmpty()
									&& !ActiontoDo
											.equals(ActionToDo.CONTINUE_ON_ERROR))
								break;
						}
					}
				}

				// set the time that the deployment finished
				String finish_time = new SimpleDateFormat("dd/M/yyyy hh:mm:ss")
						.format(Calendar.getInstance().getTime());

				// create JSON file with the details of the deployment
				this.json.write_data(xmlinfo, serviceTemplate.getName(),
						this.failed_to_deploy, this.depID, this.modules,
						this.instances, start_time, finish_time);
			}
			getDeploymentStatus();
		} catch (Exception ex) {
			this.setException(ex);
			ex.printStackTrace();
		}
	}

	protected String flavorRefForRegion(NovaApi api, String regionId) {
		FlavorApi flavorApi = api.getFlavorApiForZone(regionId);
		return DEFAULT_FLAVOR_ORDERING.min(flavorApi.listInDetail().concat())
				.getId();
	}

	static final Ordering<Flavor> DEFAULT_FLAVOR_ORDERING = new Ordering<Flavor>() {
		public int compare(Flavor left, Flavor right) {
			return ComparisonChain.start()
					.compare(left.getVcpus(), right.getVcpus())
					.compare(left.getRam(), right.getRam())
					.compare(left.getDisk(), right.getDisk()).result();
		}
	};

	public Object getResult() {
		return null;
	}

	/**
	 * Check if user's keypair exists
	 * 
	 * @param keyPairApi
	 *            jclouds API
	 * @param keyPairName
	 *            that the user gave
	 * @return true if Key Pair exists
	 */
	private static boolean keyPairExists(final KeyPairApi keyPairApi,
			final String keyPairName) {
		if (keyPairApi != null && keyPairName != null) {
			FluentIterable<? extends KeyPair> list = keyPairApi.list();
			Iterator<? extends KeyPair> iterator = list.iterator();

			while (iterator.hasNext()) {
				KeyPair keypair = iterator.next();
				if (keypair.getName().equals(keyPairName)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param publicKeyFile
	 * @param project
	 * @return
	 * @throws IOException
	 */
	private static String importKeyPair(final String publicKeyFile,
			final ICloudProject project) throws IOException {
		/* Read Public Key */
		String encodedPublicKey = null;
		BufferedReader br = null;
		try {
			// ICloudElement element =
			// CloudModel.getRoot().findChildWithResource(
			// publicKeyFile );
			// For now get the File
			// TODO - Incorporate Keypairs in CloudModel
			File file = new File(Platform.getLocation()
					+ "/" + project.getName() + DEP_SCRIPTS + publicKeyFile); //$NON-NLS-1$ //$NON-NLS-2$
			if (file.exists()) {
				br = new BufferedReader(new FileReader(file));
				encodedPublicKey = br.readLine();
				encodedPublicKey.trim();
			}
		} catch (IOException ioe) {
			throw ioe;
		} finally {
			if (br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException ioe) {
					throw ioe;
				}
			}
		}
		return encodedPublicKey;
	}
	
	  private static File importScript (final String file, final ICloudProject project) throws IOException {
	    File f = null;
	   
	    f = new File(Platform.getLocation() + "/" + project.getName() + "/Artifacts/Deployment Scripts/" + file); //$NON-NLS-1$ //$NON-NLS-2$
	    
	    return f;
	  }

//	/**
//	 * 
//	 * @param scriptFile
//	 * @param project
//	 * @return
//	 * @throws IOException
//	 */
//	private static String importScript(final String scriptFile,
//			final ICloudProject project) throws IOException {
//
//		/* Read Script */
//		String scriptContent = null;
//		BufferedReader br = null;
//		try {
//			// ICloudElement element =
//			// CloudModel.getRoot().findChildWithResource(
//			// publicKeyFile );
//			// For now get the File
//			// TODO - Incorporate Keypairs in CloudModel
//			File file = new File(Platform.getLocation()
//					+ "/" + project.getName() + DEP_SCRIPTS + scriptFile); //$NON-NLS-1$ //$NON-NLS-2$
//			if (file.exists()) {
//				br = new BufferedReader(new FileReader(file));
//				scriptContent = br.readLine();
//				scriptContent.trim();
//			}
//		} catch (IOException ioe) {
//			throw ioe;
//		} finally {
//			if (br != null) {
//				try {
//					br.close();
//					br = null;
//				} catch (IOException ioe) {
//					throw ioe;
//				}
//			}
//		}
//		return scriptContent;
//	}

	/**
	 * Creates a deployment object
	 * 
	 * @param appName
	 *            Application Name
	 * @return deploymentID
	 */
	private String createDeployment(String appName) {
		Deployment dep = InfoSystemFactory.eINSTANCE.createDeployment();
		dep.setDepID(UUID.randomUUID().toString());
		dep.setDeploymentName(appName);
		this.deployments.put(dep.getDepID(), dep);

		return dep.getDepID();
	}

	/**
	 * Creates a module for a specific deployment
	 * 
	 * @param depID
	 *            deploymentID we want to associate with the module
	 * @param modName
	 *            module name
	 * @return moduleID
	 */
	private String createModule(String depID, String modName) {
		Deployment d = this.deployments.get(depID);
		Module module = null;
		String modID = null;

		if (d != null) {
			module = InfoSystemFactory.eINSTANCE.createModule();
			module.setModID(UUID.randomUUID().toString());
			module.setModuleName(modName);
			modID = module.getModID();
			addModule(d, module);
		}

		return modID;
	}

	/**
	 * Adds an Instance on a specific module and creates it on the OpenStack
	 * Provider
	 * 
	 * @param depID
	 *            deploymentID
	 * @param modID
	 *            ModuleID
	 * @param params
	 *            instance details
	 * @param sv
	 *            Server options
	 * @return instanceID
	 * @throws Exception
	 * 
	 */
	private String addInstanceToModule(String depID, String modID,
			HashMap<String, String> params, CreateServerOptions sv)
			throws Exception {
		String instID = null;

		Deployment d = this.deployments.get(depID);
		if (d != null) {
			Module module = null;
			for (Module m : d.getModules()) {
				if (m.getModID().equals(modID))
					module = m;
			}

			if (module != null) {
				ServerCreated newServer = this.serverApi.create(
						params.get("name"), params.get("amiID"),
						params.get("flavor"), sv);
				instID = newServer.getId();
				addInstance(module, instID);
			} else
				System.out
						.println("module ID does not exist, please create a module in a valid deployment first");
		} else
			System.out
					.println("deployment ID does not exist, please create a deployment first");

		return instID;
	}

	/**
	 * Adds a specific Module Object to a Deployment Object
	 * 
	 * @param dep
	 * @param module
	 */
	private void addModule(Deployment dep, Module module) {
		dep.getModules().add(module);
	}

	/**
	 * Adds a Virtual Instance Object to a Module Object
	 * 
	 * @param mod
	 * @param instID
	 */
	private void addInstance(Module mod, String instID) {
		VirtualInstance vi = InfoSystemFactory.eINSTANCE
				.createVirtualInstance();
		vi.setUID(instID);
		mod.getInstances().add(vi);
	}

	/**
	 * Gets from getInputData the deployment model and check the instances for
	 * their status
	 */
	private void getDeploymentStatus() {
		List<Deployment[]> deploymentData = this.json.getInputData();
		ComputeService computeService = OpenStackClient.getInstance()
				.getComputeService();

		for (int i = 0; i < deploymentData.size(); i++) {
			Deployment[] dep = deploymentData.get(i);
			for (int j = 0; j < dep[i].getModules().size(); j++) {
				Module mods = dep[i].getModules().get(j);
				for (int k = 0; k < mods.getInstances().size(); k++) {
					VirtualInstance vi = mods.getInstances().get(k);
					try {
						if (!computeService
								.getNodeMetadata(this.zone + "/" + vi.getUID())
								.getStatus().equals("RUNNING")) {
							// do nothing instance exists
						}
					} catch (Exception ex) {
						System.err.println("Instance with id:" + vi.getUID()
								+ " NOT found!");
					}
				}
			}
		}
	}

	/**
	 * Returns the ActionToDo
	 * 
	 * @return ActiontoDo
	 */
	public ActionToDo getActiontoDo() {
		return this.ActiontoDo;
	}
}
