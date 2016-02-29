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
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.ExtensionManager;
import org.eclipse.camf.core.Extensions;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.dialogs.WizardNewProjectReferencePage;

/**
 * @author Nicholas Loulloudes
 */
public class NewCloudProjectWizard extends Wizard implements INewWizard {

  private WizardNewProjectCreationPage creationPage;
  private CloudProviderSelectionWizardPage cloudProviderPage;
  private WizardNewProjectReferencePage referencePage;
  private IProject project = null;

  /**
   * when the wizard is finished, the Cloud project is created.
   */
  @Override
  public boolean performFinish() {
    IProject proj = createNewProject();
    if( proj != null ) {
    }
    return proj != null;
  }

  /**
   * Initialize the Cloud project in the Cloud project in the workspace
   */
  public void init( final IWorkbench workbench,
                    final IStructuredSelection selection )
  {
    setWindowTitle( Messages.getString( "NewCloudProjectWizard.windowTitle" ) ); //$NON-NLS-1$
    //    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/newCloudprj_wiz.gif" ); //$NON-NLS-1$
    // setDefaultPageImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
  }

  /**
   * Adds the different pages for the wizard i.e. for VO selection, Project
   * Structure, reference projects.
   */
  @Override
  public void addPages() {
    this.creationPage = new WizardNewProjectCreationPage( "newCloudProjectBasicPage" ); //$NON-NLS-1$
    this.creationPage.setTitle( Messages.getString( "NewCloudProjectWizard.basic_page_title" ) ); //$NON-NLS-1$
    this.creationPage.setDescription( Messages.getString( "NewCloudProjectWizard.basic_page_description" ) ); //$NON-NLS-1$
    addPage( this.creationPage );
     this.cloudProviderPage = new CloudProviderSelectionWizardPage( false );
     addPage( this.cloudProviderPage );
    if( ResourcesPlugin.getWorkspace().getRoot().getProjects().length > 0 ) {
      this.referencePage = new WizardNewProjectReferencePage( "newCloudProjectReferencePage" ); //$NON-NLS-1$
      this.referencePage.setTitle( Messages.getString( "NewCloudProjectWizard.reference_page_title" ) ); //$NON-NLS-1$
      this.referencePage.setDescription( Messages.getString( "NewCloudProjectWizard.reference_page_description" ) ); //$NON-NLS-1$
      addPage( this.referencePage );
    }
  }

  @Override
  public boolean canFinish() {
    boolean result = false;
    IWizardPage currentPage = getContainer().getCurrentPage();
    if( currentPage != this.creationPage ) {
//      if( validatePage() == false )
//        result = false;
//      else
        result = super.canFinish();
    }
    return result;
  }

  protected boolean validatePage() {
    // TODO - stalo
    boolean validPage = !( this.creationPage.getProjectName().equals( "" ) );
    return validPage;
  }

  /**
   * Creates the Cloud Project in the workspace and
   * 
   * @return
   */
  private IProject createNewProject() {
    if( ( this.project == null ) && ( this.creationPage != null ) ) {
      CloudProjectProperties properties = new CloudProjectProperties();
      properties.setProjectName( this.creationPage.getProjectName() );
      properties.setProjectLocation( this.creationPage.useDefaults()
                                                                    ? null
                                                                    : this.creationPage.getLocationPath() );
      properties.setCloudProvider( this.cloudProviderPage.getSelectedCloudProviders()[0] );
      properties.addProjectFolders( getProjectFolders() );
      if( this.referencePage != null ) {
        properties.setReferencesProjects( this.referencePage.getReferencedProjects() );
      }
      CloudProjectCreationOperation creationOp = new CloudProjectCreationOperation( properties );
      WorkspaceModifyDelegatingOperation modifyOp = new WorkspaceModifyDelegatingOperation( creationOp );
      // Create the new project
      try {
        getContainer().run( true, true, modifyOp );
        this.project = creationOp.getProject();
      } catch( InterruptedException intExc ) {
        org.eclipse.camf.ui.internal.Activator.logException( intExc );
      } catch( InvocationTargetException itExc ) {
        org.eclipse.camf.ui.internal.Activator.logException( itExc );
      }
    }
    
    IFolder vmisFolder = this.project.getFolder( "Artifacts/Virtual Machine Images" );
    try {
      vmisFolder.create( false, true, null );
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    IFolder applicationsFolder = this.project.getFolder( "Artifacts/Applications" );
    try {
      applicationsFolder.create( false, true, null );
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    IFolder deploymentScriptsFolder = this.project.getFolder( "Artifacts/Deployment Scripts" );
    try {
      deploymentScriptsFolder.create( false, true, null );
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    IFolder reconfigurationScriptsFolder = this.project.getFolder( "Artifacts/Reconfiguration Scripts" );
    try {
      reconfigurationScriptsFolder.create( false, true, null );
    } catch( CoreException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return this.project;
  }

  private Hashtable<String, String> getProjectFolders() {
    Hashtable<String, String> folders = new Hashtable<String, String>();
    ExtensionManager extm = new ExtensionManager();
    List<IConfigurationElement> configElements = extm.getConfigurationElements( Extensions.PROJECT_FOLDER_POINT,
                                                                                Extensions.PROJECT_FOLDER_ELEMENT );
    for( IConfigurationElement element : configElements ) {
      String id = element.getAttribute( Extensions.PROJECT_FOLDER_ID_ATTRIBUTE );
      String label = element.getAttribute( Extensions.PROJECT_FOLDER_LABEL_ATTRIBUTE );
      boolean preset = Boolean.parseBoolean( element.getAttribute( Extensions.PROJECT_FOLDER_PRESET_ATTRIBUTE ) );
      if( preset ) {
        folders.put( id, label );
      }
    }
    return folders;
  }
}
