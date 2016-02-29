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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor.property;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.namespace.QName;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.editor.diagram.ToscaFeatureProvider;
import org.eclipse.camf.tosca.editor.features.CreateSoftwareDependencyFeature;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


/**
 *  Application Component Properties - Custom Scripts Tab
 */
public class ApplicationComponentScriptSection extends GFPropertySection
implements ITabbedPropertyConstants, ModifyListener
{

Section section;
private Text deploymentScriptText;

@Override
public void createControls( Composite parent,
                            TabbedPropertySheetPage tabbedPropertySheetPage )
{
  super.createControls( parent, tabbedPropertySheetPage );
  // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
  FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
  this.section = toolkit.createSection( parent, Section.TITLE_BAR );
  this.section.setText( "Deployment Script" ); //$NON-NLS-1$
  Composite client = toolkit.createComposite( this.section, SWT.WRAP );
  GridLayout layout = new GridLayout();
  layout.numColumns = 1;
  layout.marginTop = 15;
  layout.marginWidth = 2;
  layout.marginHeight = 2;
  client.setLayout( layout );
  TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
  deploymentScriptText = factory.createText( client,
                                             "", SWT.V_SCROLL | SWT.H_SCROLL ); //$NON-NLS-1$
  GridData gd = new GridData();
  gd.widthHint = 1100;
  gd.heightHint = 150;
  gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
  this.deploymentScriptText.setLayoutData( gd );
  deploymentScriptText.addModifyListener( this );
  // Add section components to the toolkit
  toolkit.adapt( this.deploymentScriptText, true, true );
  this.section.setClient( client );
}

/*
 * Refresh Tab(non-Javadoc)
 * @see
 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
 */
@Override
public void refresh() {
  PictogramElement pe = getSelectedPictogramElement();
  PictogramElement parentPE = Graphiti.getPeService()
    .getPictogramElementParent( pe );
  TNodeTemplateExtension appComponent = null;
  if( pe != null ) {
    Object bo = Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( pe );
    if( bo == null )
      return;
    if( bo instanceof TArtifactTemplate ) {
      appComponent = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( parentPE );
    } else { // bo instanceof TNodeTemplate
      appComponent = ( TNodeTemplateExtension )bo;
    }
  }
  
  String fileName = findImplementationArtifactName(appComponent.getName()+"Script");
//  String fileName = null;
//  // Find NodeTypeImplementation
//   ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI(
//   getDiagram() ) );
//   DocumentRoot dr = model.getDocumentRoot();
//   DefinitionsType dt = dr.getDefinitions();
//   EList<TNodeTypeImplementation> nodeTypesImplementation =
//   dt.getNodeTypeImplementation();
//   EList<TArtifactTemplate> artifactTemplates = dt.getArtifactTemplate();
//   TNodeTypeImplementation nodeTypeImplementation = null;
//   for (TNodeTypeImplementation tempNodeImplementation :
//   nodeTypesImplementation){
//   if (appComponent.getName().equals(
//   tempNodeImplementation.getNodeType().toString())){
//   nodeTypeImplementation = tempNodeImplementation;
//   break;
//   }
//   }
//   if (nodeTypeImplementation!=null &&
//   nodeTypeImplementation.getImplementationArtifacts()!=null){
//   EList<ImplementationArtifactType> implementationArtifacts =
//   nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact();
//   for (ImplementationArtifactType tempImplementationArtifact :
//   implementationArtifacts){
//   for (TArtifactTemplate tempArtifactTemplate : artifactTemplates){
//   if
//   (tempArtifactTemplate.getId().equals(tempImplementationArtifact.getArtifactRef().toString())){
//   fileName=tempArtifactTemplate.getId();
//   break;
//   }
//   }
//  
//   }
//   }
  //fileName = appComponent.getName() + "Deployment.sh";
  IProject activeProject = ToscaDiagramEditor.getActiveProject();
  if( activeProject != null ) {
    IFile file = activeProject.getFile( new Path( "/Artifacts/Deployment Scripts/"
                                                  + fileName ) );
    if( file.exists() == true ) {
      // if ( file.exists() == true ){
      // Convert deployment script file to String
      BufferedReader br = null;
      StringBuilder sb = new StringBuilder();
      String line;
      try {
        br = new BufferedReader( new InputStreamReader( file.getContents() ) );
      } catch( CoreException e1 ) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      try {
        while( ( line = br.readLine() ) != null ) {
          sb.append( line + "\n" );
        }
      } catch( IOException e1 ) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      this.deploymentScriptText.setText( sb.toString() );
    } else {
      this.deploymentScriptText.setText( "" );
    }
  }
}

@Override
public void modifyText( ModifyEvent e ) {
  if( this.deploymentScriptText.getText().equals( "" ) ) {
    // this is also the case where the Deployment Script tab is preopened
    return;
  }
  IProject activeProject = ToscaDiagramEditor.getActiveProject();
  if( activeProject != null ) {
    createDeploymentScript( activeProject );
  }
}

// Creates the Application Deployment file
public IFile createDeploymentScript( IProject activeProject ) {
  IFile file = null;
  PictogramElement pe = getSelectedPictogramElement();
  TNodeTemplateExtension appComponent = null;
  if( pe != null ) {
    Object bo = Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( pe );
    if( bo == null )
      return null;
    if( bo instanceof TDeploymentArtifact ) {
      PictogramElement parentPE = Graphiti.getPeService()
        .getPictogramElementParent( pe );
      pe = parentPE;
      appComponent = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( parentPE );
    } else { // bo instanceof TNodeTemplate
      appComponent = ( TNodeTemplateExtension )bo;
    }
  }
  String fileName = appComponent.getName() + "Deployment.sh";
  file = activeProject.getFile( new Path( "/Artifacts/Deployment Scripts/"
                                          + fileName ) );
  if( file.exists() ) {
    // Deployment file exists, update its contents
    try {
      file.setContents( new ByteArrayInputStream( this.deploymentScriptText.getText()
                          .getBytes() ),
                        false,
                        false,
                        null );
    } catch( CoreException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return null;
  }
  // Deployment file does not exists, create one
  try {
    file.create( new ByteArrayInputStream( this.deploymentScriptText.getText()
                   .getBytes() ),
                 false,
                 null );
  } catch( CoreException e1 ) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
    return null;
  }
  try {
    activeProject.refreshLocal( IResource.DEPTH_INFINITE,
                                new NullProgressMonitor() );
  } catch( CoreException e1 ) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
  }
  IProgressMonitor monitor = null;
  try {
    CloudModel.getRoot().refresh( monitor );
  } catch( ProblemException e ) {
    e.printStackTrace();
  }
  // Refresh Palette Compartments
  // getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
  // Call the Create User Application Feature to create a deployment artifact
  // for the deployment script and add it to the artifacts list
  CreateSoftwareDependencyFeature createSDFeature = new CreateSoftwareDependencyFeature( new ToscaFeatureProvider( getDiagramTypeProvider() ) );
  TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
  artifactTemplate.setName( "SD"+fileName );
  artifactTemplate.setId( fileName );
  artifactTemplate.setType( new QName( "ScriptArtifact" ) );
  createSDFeature.setContextObject( artifactTemplate );
  CreateContext createContext = new CreateContext();
  createContext.setTargetContainer( ( ContainerShape )pe );
  if( createSDFeature.canCreate( createContext ) )
    createSDFeature.create( createContext );
  return file;
}

private String findImplementationArtifactName(String artifactId){
  ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
  DocumentRoot dr = model.getDocumentRoot();
  DefinitionsType dt = dr.getDefinitions();
  EList<TArtifactTemplate> artifactTemplates =
  dt.getArtifactTemplate();

  for (TArtifactTemplate tempArtifactTemplate : artifactTemplates){
    if (tempArtifactTemplate.getId().equals( artifactId )){
      TArtifactReference artifactRef = tempArtifactTemplate.getArtifactReferences().getArtifactReference().get( 0 );
      String artifactReference = artifactRef.getReference();
      String artifactName = artifactReference.substring( artifactReference.indexOf( "\\" ) +1);
      return artifactName;
    }
  }

 return null;
}
}
