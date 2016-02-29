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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.elasticity.MonitoringProbesType1;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.camf.tosca.elasticity.TMonitoringProbe;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

// Application Properties - Monitoring Tab
public class ApplicationMonitoringSection extends GFPropertySection
  implements ITabbedPropertyConstants
{

  Section section;
  private Table tableMonitoringProbes;
  private Button removeButton;
  TableViewer tableMonitoringProbesViewer;
  List<String> appMonitoringProbes = new ArrayList<String>();

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    this.section = toolkit.createSection( parent, Section.TITLE_BAR );
    this.section.setText( "Monitoring Probes" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
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
    this.tableMonitoringProbesViewer.setInput( this.appMonitoringProbes );
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
    // Add section components to the toolkit
    toolkit.adapt( this.tableMonitoringProbes, true, true );
    toolkit.adapt( this.removeButton, true, true );
    section.setClient( client );
  }

  // Remove the selected Application Monitoring Probes from TOSCA
  void removeApplicationComponentMonitoringProbe( final String selectedObject )
  {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TServiceTemplate serviceTemplate = ( TServiceTemplate )bo;
    TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )serviceTemplate.getBoundaryDefinitions();
    final MonitoringProbesType1 monitoringProbes = boundaryDef.getMonitoringProbes();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        protected void doExecute() {
          for( TMonitoringProbe monitoringProbe : monitoringProbes.getMonitoringProbes() )
          {
            if( monitoringProbe.getName().compareTo( selectedObject ) == 0 ) {
              monitoringProbes.getMonitoringProbes().remove( monitoringProbe );
              break;
            }
          }
        }
      } );
    this.appMonitoringProbes.remove( selectedObject );
    this.tableMonitoringProbesViewer.refresh();
  }

  // Return the selected Monitoring Probe
  String getSelectedMonitoringProbe() {
    String result = null;
    IStructuredSelection selection = ( IStructuredSelection )this.tableMonitoringProbesViewer.getSelection();
    Object obj = selection.getFirstElement();
    result = ( String )obj;
    return result;
  }

  // Get Application Monitoring Probes from TOSCA
  public void getMonitoringProbes() {
    PictogramElement pe = getSelectedPictogramElement();
    Object bo = null;
    if( pe != null ) {
      bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
    }
    TServiceTemplate serviceTemplate = ( TServiceTemplate )bo;
    TBoundaryDefinitionsExtension boundaryDef = ( TBoundaryDefinitionsExtension )serviceTemplate.getBoundaryDefinitions();
    final MonitoringProbesType1 monitoringProbes = boundaryDef.getMonitoringProbes();
    if( monitoringProbes == null )
      return;
    for( TMonitoringProbe monitoringProbe : monitoringProbes.getMonitoringProbes() ) {
      
      this.appMonitoringProbes.add( monitoringProbe.getName() );
    }
  }

  // Refresh Tab
  @Override
  public void refresh() {
    // Refresh Monitoring Probes
    this.appMonitoringProbes.clear();
    getMonitoringProbes();
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      TServiceTemplate bo = ( TServiceTemplate )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      if( bo == null )
        return;
      this.tableMonitoringProbesViewer.refresh();
    }
  }
}
