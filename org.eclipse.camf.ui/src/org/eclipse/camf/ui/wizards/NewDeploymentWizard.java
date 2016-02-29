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
 *   Nicholas Loulloudes - initial API and implementation
 *   Stalo Sofokleous - TOSCA extensions
 *   Demetris Trihinas - Monitoring artifacts
 *   Andreas Kastanas -  Termination procedure and new 
 *   					 OpenStackOpDeployApplication constructor
 *******************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

//import org.eclipse.camf.connectors.openstack.OpenStackClient;
//import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDeployApplication;
//import org.eclipse.camf.connectors.openstack.operation.OperationExecuter;

/**
 * @author Nicholas Loulloudes
 */
public class NewDeploymentWizard extends Wizard implements INewWizard {

	private List<ICloudDeploymentService> deploymentServices = null;
	private TOSCAResource deploymentFile = null;
	private IStructuredSelection selection = null;
	private NewSubmissionWizardSecondPage secondPage = null;
	private TOSCAModel toscaModel;

	public NewDeploymentWizard() {
		setNeedsProgressMonitor(true);
		setForcePreviousAndNextButtons(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {

		try {
			getContainer().run(false, false, new IRunnableWithProgress() {

				@Override
				public void run(final IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
				  
		          ICloudDeploymentService deployService = getDeploymentService();
		          try {
		            deployService.deployApplication( NewDeploymentWizard.this.deploymentFile, monitor );
		          } catch( ProblemException e1 ) {
		            e1.printStackTrace();
		          }
					// EC2OpDeployApplication deployOperation = null;
//					OpenStackOpDeployApplication deployOperation = null;
//					try {
//						monitor.beginTask("Deploying VMIs", 2);
//						// deployOperation = new EC2OpDeployApplication(
//						// EC2Client.getEC2(),
//						// NewDeploymentWizard.this.deploymentFile );
//
//						deployOperation = new OpenStackOpDeployApplication(
//								OpenStackClient.getInstance(),
//								NewDeploymentWizard.this.deploymentFile,
//								OpenStackOpDeployApplication.ActionToDo.TERMINATE_AND_REVERT_ON_ERROR);
//
//						if (deployOperation.getException() != null) {
//							throw deployOperation.getException();
//						}
//
//						new OperationExecuter().execOp(deployOperation);
//
//						if (deployOperation.getActiontoDo().equals(
//								ActionToDo.TERMINATE_AND_REVERT_ON_ERROR)
//								&& !deployOperation.failed_to_deploy.isEmpty()) {
//							OpenStackOpTerminateApplication terminateOperation = new OpenStackOpTerminateApplication(
//									deployOperation.deployments,
//									deployOperation.depID,
//									deployOperation.modules,
//									deployOperation.instances);
//
//							if (terminateOperation.getException() != null) {
//								throw terminateOperation.getException();
//							}
//							new OperationExecuter().execOp(terminateOperation);
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//
//					} finally {
//						monitor.done();
//					}
				}
			});
		} catch (final Exception ex) {
			ex.printStackTrace();
			// Display display = PlatformUI.getWorkbench().getDisplay();
			// display.asyncExec( new Runnable() {
			//
			// public void run() {
			// IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
			// .getActiveWorkbenchWindow();
			// ProblemDialog.openProblem( workbenchWindow.getShell(),
			//                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_title"), //$NON-NLS-1$
			//                                     Messages.getString("AddAttributeWizard.problem_granting_access_permission_description"), //$NON-NLS-1$
			// ex );
			// }
			// } );
			return false;
		}

		return true;
	}

	@Override
	public void addPages() {
		this.deploymentServices = new ArrayList<ICloudDeploymentService>();
		getDeploymentServicesJob();
		this.secondPage = new NewSubmissionWizardSecondPage(
				Messages.getString("NewSubmissionWizardSecondPage.pageName")); //$NON-NLS-1$
		this.secondPage.setTitle(Messages
				.getString("NewSubmissionWizardSecondPage.pageTitle")); //$NON-NLS-1$
		this.secondPage.setDescription(Messages
				.getString("NewSubmissionWizardSecondPage.pageDescription")); //$NON-NLS-1$
		addPage(this.secondPage);
	}

	/**
   * 
   */
	private void getDeploymentServicesJob() {
		Job job = new Job("Retrieving list of job services") {

			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				// assert JobCreatorSelectionWizard.this.jobDescriptions !=
				// null;
				// assert JobCreatorSelectionWizard.this.jobDescriptions.get( 0
				// ) !=
				// null;
				ICloudDeploymentService[] allServices = null;
				ICloudProject project = NewDeploymentWizard.this.deploymentFile
						.getProject();
				assert project != null;
				assert project.getCloudProvider() != null;
				try {
					allServices = project.getCloudProvider()
							.getDeploymentServices(null);
					boolean valid;
					for (ICloudDeploymentService service : allServices) {
						valid = true;
						if (!service
								.canDeploy(NewDeploymentWizard.this.deploymentFile)) {
							valid = false;
						}
						if (valid == true) {
							NewDeploymentWizard.this.deploymentServices
									.add(service);
						}
					}
					IWorkbench workbench = PlatformUI.getWorkbench();
					Display display = workbench.getDisplay();
					display.syncExec(new Runnable() {

						public void run() {
							// List<IGridJobService> synchronizedList =
							// Collections.synchronizedList( jobServices );
							NewDeploymentWizard.this.secondPage
									.setServices(NewDeploymentWizard.this.deploymentServices);
						}
					});
				} catch (ProblemException e) {
					return Status.CANCEL_STATUS;
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(final IWorkbench workbench,
			final IStructuredSelection selection) {
		setWindowTitle(Messages
				.getString("NewApplicationSubmissionWizard.windowTitle")); //$NON-NLS-1$
		this.selection = selection;
		Object obj = this.selection.getFirstElement();
		if (obj instanceof TOSCAResource) {
			this.deploymentFile = (TOSCAResource) obj;
			this.toscaModel = this.deploymentFile.getTOSCAModel();
		}
		// if (obj instanceof IFile){
		// IFile file = (IFile) obj;
		// ICloudElement element = CloudModel.getRoot().findElement( file );
		//
		// if( element instanceof TOSCAResource ) {
		// this.deploymentFile = ( TOSCAResource )element;
		// this.toscaModel = this.deploymentFile.getTOSCAModel();
		// }
		// }
	}

	public void exportCSAR() throws IOException, CoreException {

		// Export monitoring probes to jar files
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject monitoringProbesProject = workspaceRoot
				.getProject("MonitoringProbe");
		IFolder srcFolder = monitoringProbesProject.getFolder("src");
		IResource[] monitoringProbes = srcFolder.members();

		for (IResource monitoringProbeFile : monitoringProbes)
			exportProbe((IFile) monitoringProbeFile);
	}

	void exportProbe(IFile file) throws IOException {
		// Move project under active project's Monitoring Folder
		IProject activeProject = ToscaDiagramEditor.getActiveProject();
		IFolder monitoringFolder = activeProject.getFolder("Monitoring");
		IPath jarFilePath = monitoringFolder.getRawLocation()
				.append(file.getName()).removeFileExtension()
				.addFileExtension("jar");
		byte buffer[] = new byte[10240];
		// Open archive file
		FileOutputStream stream = new FileOutputStream(jarFilePath.toString());
		JarOutputStream out = new JarOutputStream(stream, new Manifest());
		// Add probe file archive entry
		JarEntry jarAdd = new JarEntry(file.getName());
		out.putNextEntry(jarAdd);
		// Write file to archive
		FileInputStream in = new FileInputStream(file.getRawLocation()
				.toString());
		while (true) {
			int nRead = in.read(buffer, 0, buffer.length);
			if (nRead <= 0)
				break;
			out.write(buffer, 0, nRead);
		}
		in.close();
		// Add ProbePack.jar file archive entry
		jarAdd = new JarEntry("ProbePack.jar");
		out.putNextEntry(jarAdd);
		// Write file to archive
		in = new FileInputStream(
				"C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar");
		while (true) {
			int nRead = in.read(buffer, 0, buffer.length);
			if (nRead <= 0)
				break;
			out.write(buffer, 0, nRead);
		}
		in.close();
		out.close();
		stream.close();
		// Refresh Cloud Model
		IProgressMonitor monitor = null;
		try {
			CloudModel.getRoot().refresh(monitor);
		} catch (ProblemException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public ICloudDeploymentService getDeploymentService() {
		return this.secondPage.getCloudDeploymentService();
	}
}
