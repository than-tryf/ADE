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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditorInput;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Application Component Properties - Monitoring Tab
 */
public class ApplicationComponentMonitoringSectionNoDeploymentArtifact extends GFPropertySection
  implements ITabbedPropertyConstants
{

  Section section;
  private Table tableMonitoringProbes;
  private Button removeButton;
  private Button createButton;
  TableViewer tableMonitoringProbesViewer;
  List<String> appComponentMonitoringProbes = new ArrayList<String>();

  @Override
  public void createControls( final Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    this.section = toolkit.createSection( parent, Section.TITLE_BAR );
    this.section.setText( "Monitoring Probes" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( this.section, SWT.WRAP );
    Composite client1 = toolkit.createComposite( client, SWT.WRAP );
    Composite client2 = toolkit.createComposite( client, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    layout = new GridLayout();
    layout.numColumns = 1;
    client1.setLayout( layout );
    layout = new GridLayout();
    layout.numColumns = 1;
    client2.setLayout( layout );
    // Monitoring Probes Section
    GridData gd;
    this.tableMonitoringProbes = new Table( client1, SWT.BORDER
                                                     | SWT.VIRTUAL
                                                     | SWT.MULTI
                                                     | SWT.FULL_SELECTION );
    this.tableMonitoringProbes.setHeaderVisible( true );
    this.tableMonitoringProbes.setLinesVisible( false );
    this.tableMonitoringProbes.getHorizontalBar().setEnabled( false );
    gd = new GridData( 300, this.tableMonitoringProbes.getItemHeight() * 4 );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableMonitoringProbes.setLayoutData( gd );
    TableLayout tableLayout = new TableLayout();
    this.tableMonitoringProbes.setLayout( tableLayout );
    TableColumn nameColumn = new TableColumn( this.tableMonitoringProbes,
                                              SWT.CENTER );
    nameColumn.setText( "Monitoring Probes" ); //$NON-NLS-1$
    nameColumn.setWidth( 200 );
    ColumnLayoutData data = new ColumnWeightData( 200 );
    tableLayout.addColumnData( data );
    // Set the Monitoring Probes table viewer
    MonitoringProbesProvider MPProvider = new MonitoringProbesProvider();
    this.tableMonitoringProbesViewer = new TableViewer( this.tableMonitoringProbes );
    IStructuredContentProvider contentProvider = MPProvider.MPContentProvider;
    this.tableMonitoringProbesViewer.setContentProvider( contentProvider );
    this.tableMonitoringProbesViewer.setLabelProvider( MPProvider.MPContentLabelProvider );
    this.tableMonitoringProbesViewer.setInput( this.appComponentMonitoringProbes );
    // Monitoring Probe Remove Button
    this.removeButton = new Button( client2, SWT.PUSH );
    this.removeButton.setText( "Remove" ); //$NON-NLS-1$
    this.removeButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
        removeApplicationComponentMonitoringProbe( getSelectedMonitoringProbe() );
      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.removeButton.setLayoutData( gd );
    
    // Monitoring Probe Create Button
    this.createButton = new Button( client2, SWT.PUSH );
    this.createButton.setText( "Create" ); //$NON-NLS-1$
    this.createButton.addSelectionListener( new SelectionListener() {

      @Override
      public void widgetSelected( SelectionEvent e ) {
  
        // Get probe name
        String probeName = null;
        FileDialog dialog = new FileDialog(parent.getShell(), SWT.OPEN);
        dialog.setText( "Select Image File" ); //$NON-NLS-1$
        //dialog.setFilterExtensions(new String [] {"*.html"});
        //dialog.setFilterPath("c:\\temp");
        String result = dialog.open();
        if (result != null){
          probeName = dialog.getFileName();
        }

        addMonitoringProbe(probeName);

      }

      @Override
      public void widgetDefaultSelected( SelectionEvent e ) {
        // TODO Auto-generated method stub
      }
    } );
    gd = new GridData();
    gd.widthHint = 60;
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    this.createButton.setLayoutData( gd );
    
    // Add section components to the toolkit
    toolkit.adapt( this.tableMonitoringProbes, true, true );
    toolkit.adapt( this.removeButton, true, true );
    toolkit.adapt( this.createButton, true, true );
    this.section.setClient( client );
  }

  /**
   * Get Application Component Monitoring Probes from TOSCA
   */
  public void getMonitoringProbes() {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    final TNodeTemplateExtension appComponent;
    if( bo instanceof TDeploymentArtifact ) {
      PictogramElement parentPE = Graphiti.getPeService()
        .getPictogramElementParent( pe );
      appComponent = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( parentPE );
    } else { // bo instanceof TNodeTemplate
      appComponent = ( TNodeTemplateExtension )bo;
    }
    TDeploymentArtifacts deploymentArtifacts = appComponent.getDeploymentArtifacts();
    if( deploymentArtifacts == null )
      return;
    for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
    {
      if( artifact.getArtifactType().toString().compareTo( "MonitoringProbe" ) == 0 ) //$NON-NLS-1$
        this.appComponentMonitoringProbes.add( artifact.getName() );
    }
  }

  // Remove the selected Application Component Monitoring Probes from TOSCA
  void removeApplicationComponentMonitoringProbe( final String selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    final TNodeTemplateExtension nodeTemplate;
    if( bo instanceof TDeploymentArtifact ) {
      PictogramElement parentPE = Graphiti.getPeService()
        .getPictogramElementParent( pe );
      nodeTemplate = ( TNodeTemplateExtension )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( parentPE );
    } else { // bo instanceof TNodeTemplate
      nodeTemplate = ( TNodeTemplateExtension )bo;
    }
    final TDeploymentArtifacts deploymentArtifacts = nodeTemplate.getDeploymentArtifacts();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        protected void doExecute() {
          for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
          {
            if( artifact.getArtifactType()
              .toString()
              .compareTo( "MonitoringProbe" ) == 0 ) //$NON-NLS-1$
              if( artifact.getName() == selectedObject ) {
                deploymentArtifacts.getDeploymentArtifact().remove( artifact );
                break;
              }
          }
        }
      } );
    this.appComponentMonitoringProbes.remove( selectedObject );
    this.tableMonitoringProbesViewer.refresh();
    // If 0 Monitoring Probes left remove monitoring icon
    if( this.appComponentMonitoringProbes.size() == 0 ) {
      // Object[] targetDiagrams = ((ContainerShape)
      // pe).getChildren().toArray();
      // for( int i = 0; i < targetDiagrams.length; i++ ) {
      // Shape imageShape = ( Shape )targetDiagrams[ i ];
      // GraphicsAlgorithm imageGA = imageShape.getGraphicsAlgorithm();
      // if( imageGA instanceof Image ){
      // imageShape.setVisible( false );
      // //OR
      // imageGA.setTransparency( 1.0 );
      // break;
      // }
      // }
    }
  }

  // Return the selected Monitoring Probe
  String getSelectedMonitoringProbe() {
    String result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableMonitoringProbesViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( String )obj;
    return result;
  }

  /*
   * Refresh Tab(non-Javadoc)
   * @see
   * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
   */
  @Override
  public void refresh() {
    // Refresh Monitoring Probes
    this.appComponentMonitoringProbes.clear();
    getMonitoringProbes();
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      final TNodeTemplateExtension nodeTemplate;
      if( bo instanceof TDeploymentArtifact ) {
        PictogramElement parentPE = Graphiti.getPeService()
          .getPictogramElementParent( pe );
        nodeTemplate = ( TNodeTemplateExtension )Graphiti.getLinkService()
          .getBusinessObjectForLinkedPictogramElement( parentPE );
      } else { // bo instanceof TNodeTemplate
        nodeTemplate = ( TNodeTemplateExtension )bo;
      }
      if( nodeTemplate == null )
        return;
      this.tableMonitoringProbesViewer.refresh();
    }
  }

  public void addMonitoringProbe( String probeName ){
    
    //Find the Cloud project to which the probe will be added
    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IEditorInput input = activePage.getActiveEditor().getEditorInput();
    
    IFile file = null;
    if ( input instanceof ToscaDiagramEditorInput ){
      file = ((ToscaDiagramEditorInput) input).getToscaFile();
    }
              
    IProject project = file.getProject();
    
    MonitoringProbe mp = new MonitoringProbe( probeName );
    try {
      mp.createProbeProject();
    } catch( PartInitException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( JavaModelException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // Add newly created probe to Cloud project
    //mp.addProbeToCloudProject(probeName, project);
    
    // Refresh Palette Compartments
    getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
   
    // Add Monitoring Deployment Artifact and Refresh Monitoring Table
    mp.addProbeToMonitoringTable(probeName, (ContainerShape) getSelectedPictogramElement(), getDiagramTypeProvider());
    refresh();
  }
  
}
