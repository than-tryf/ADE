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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.example.sybl.ConditionType;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblPackage;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.ArtifactReferencesType;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.ImplementationArtifactType;
import org.eclipse.camf.tosca.PoliciesType;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TImplementationArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.TPolicy;
import org.eclipse.camf.tosca.TPolicyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditorInput;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.editor.diagram.ToscaFeatureProvider;
import org.eclipse.camf.tosca.editor.dialog.ElasticityConditionDialog;
import org.eclipse.camf.tosca.editor.dialog.ElasticityConstraintDialog;
import org.eclipse.camf.tosca.editor.dialog.ElasticityStrategyDialog;
import org.eclipse.camf.tosca.editor.features.CreateResizeActionFeature;
import org.eclipse.camf.tosca.editor.features.CreateVMIFeature;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.elementCreators.CreateArtifactTemplate;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Application Component Properties - Elasticity Tab
 */
public class ApplicationComponentElasticityRequirementsSection
extends GFPropertySection implements ITabbedPropertyConstants
{

Composite client;
Section section;
private Table table;
private Button addButton;
private Button removeButton;
private Button addExecutableButton;
TableViewer tableViewer;
List<TPolicy> appComponentElasticityRequirements = new ArrayList<TPolicy>();
Section sectionRA;
private Table tableResizingActions;
private Button removeButtonRA;
private Button addButtonRA;
private Button conditionButtonRA;
TableViewer tableResizingActionsViewer;
List<TPolicy> appComponentResizingActions = new ArrayList<TPolicy>();
protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;

@Override
public void createControls( final Composite parent,
                            TabbedPropertySheetPage tabbedPropertySheetPage )
{
  super.createControls( parent, tabbedPropertySheetPage );
  FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
  // Application Component Elasticity Requirements Section
  this.section = toolkit.createSection( parent, Section.TITLE_BAR );
  this.section.setText( "Application Component Elasticity Constraints" ); //$NON-NLS-1$
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
  GridData gd;
  this.table = new Table( client1, SWT.BORDER
                                   | SWT.VIRTUAL
                                   | SWT.MULTI
                                   | SWT.FULL_SELECTION );
  this.table.setHeaderVisible( true );
  this.table.setLinesVisible( false );
  this.table.getHorizontalBar().setEnabled( false );
  gd = new GridData( 300, this.table.getItemHeight() * 4 );
  gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
  this.table.setLayoutData( gd );
  TableLayout tableLayout = new TableLayout();
  this.table.setLayout( tableLayout );
  TableColumn nameColumn = new TableColumn( this.table, SWT.CENTER );
  ColumnLayoutData data = new ColumnWeightData( 100 );
  tableLayout.addColumnData( data );
  data = new ColumnWeightData( 100 );
  tableLayout.addColumnData( data );
  data = new ColumnWeightData( 150 );
  tableLayout.addColumnData( data );
  nameColumn.setText( "Constraint" ); //$NON-NLS-1$
  this.tableViewer = new TableViewer( this.table );
  ElasticityConstraintsProvider ERProvider = new ElasticityConstraintsProvider();
  IStructuredContentProvider contentProvider = ERProvider.ERContentProvider;
  this.tableViewer.setContentProvider( contentProvider );
  this.tableViewer.setLabelProvider( ERProvider.ERContentLabelProvider );
  this.tableViewer.setInput( this.appComponentElasticityRequirements );
  this.addButton = new Button( client2, SWT.PUSH );
  this.addButton.setText( "Add" ); //$NON-NLS-1$
  gd = new GridData();
  gd.widthHint = 60;
  gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.addButton.setLayoutData( gd );
  // Listener for Add button
  this.addButton.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( SelectionEvent e ) {
      editDataStagingEntry( null );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  this.removeButton = new Button( client2, SWT.PUSH );
  this.removeButton.setText( "Remove" ); //$NON-NLS-1$
  gd = new GridData();
  gd.widthHint = 60;
  gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.removeButton.setLayoutData( gd );
  // Listener for Remove button
  this.removeButton.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( final SelectionEvent e ) {
      removeApplicationComponentElasticityRequirement( getSelectedObject() );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  // Add section components to the toolkit
  toolkit.adapt( this.table, true, true );
  toolkit.adapt( this.addButton, true, true );
  toolkit.adapt( this.removeButton, true, true );
  this.section.setClient( client );
  // Application Component Elasticity Actions Section
  this.sectionRA = toolkit.createSection( parent, Section.TITLE_BAR );
  this.sectionRA.setText( "Elasticity Strategies" ); //$NON-NLS-1$
  Composite clientRA = toolkit.createComposite( this.sectionRA, SWT.WRAP );
  Composite clientRA1 = toolkit.createComposite( clientRA, SWT.WRAP );
  Composite clientRA2 = toolkit.createComposite( clientRA, SWT.WRAP );
  GridLayout layoutRA;
  layoutRA = new GridLayout();
  layoutRA.numColumns = 2;
  layoutRA.marginTop = 15;
  layoutRA.verticalSpacing = 15;
  layoutRA.marginWidth = 2;
  layoutRA.marginHeight = 2;
  clientRA.setLayout( layoutRA );
  layoutRA = new GridLayout();
  layoutRA.numColumns = 1;
  clientRA1.setLayout( layoutRA );
  layoutRA = new GridLayout();
  layoutRA.numColumns = 1;
  clientRA2.setLayout( layoutRA );
  this.tableResizingActions = new Table( clientRA1, SWT.BORDER
                                                    | SWT.VIRTUAL
                                                    | SWT.MULTI
                                                    | SWT.FULL_SELECTION );
  this.tableResizingActions.setHeaderVisible( true );
  this.tableResizingActions.setLinesVisible( false );
  this.tableResizingActions.getHorizontalBar().setEnabled( false );
  GridData gdRA;
  gdRA = new GridData( 300, this.tableResizingActions.getItemHeight() * 4 );
  gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  gdRA.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
  this.tableResizingActions.setLayoutData( gdRA );
  TableLayout tableLayoutRA = new TableLayout();
  this.tableResizingActions.setLayout( tableLayoutRA );
  TableColumn nameColumnRA = new TableColumn( this.tableResizingActions,
                                              SWT.CENTER );
  nameColumnRA.setText( "Strategy" ); //$NON-NLS-1$
  nameColumnRA.setWidth( 100 );
  ColumnWeightData dataRA = new ColumnWeightData( 100 );
  tableLayoutRA.addColumnData( dataRA );
  // Set the Elasticity Actions table viewer
  ResizingActionsProvider RAProvider = new ResizingActionsProvider();
  this.tableResizingActionsViewer = new TableViewer( this.tableResizingActions );
  IStructuredContentProvider contentProviderRA = RAProvider.RAContentProvider;
  this.tableResizingActionsViewer.setContentProvider( contentProviderRA );
  this.tableResizingActionsViewer.setLabelProvider( RAProvider.RAContentLabelProvider );
  this.tableResizingActionsViewer.setInput( this.appComponentResizingActions );
  // Add Elasticity Strategy button
  this.addButtonRA = new Button( clientRA2, SWT.PUSH );
  this.addButtonRA.setText( "Add" ); //$NON-NLS-1$
  // Listener for Adding Elasticity Strategy button
  this.addButtonRA.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( final SelectionEvent e ) {
      editDataStagingEntryRA( getSelectedObject() );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  gdRA = new GridData();
  gdRA.widthHint = 80;
  gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.addButtonRA.setLayoutData( gdRA );
  // //////////////////////////////////////////////////////////////////
  // Add Elasticity Strategy Executable button
  this.addExecutableButton = new Button( clientRA2, SWT.PUSH );
  this.addExecutableButton.setText( "Exectutable" ); //$NON-NLS-1$
  // Listener for Adding Elasticity Strategy button
  this.addExecutableButton.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( final SelectionEvent e ) {
      addResizingActionExecutable( parent, getSelectedElasticityStrategy() );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  gdRA = new GridData();
  gdRA.widthHint = 80;
  gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.addExecutableButton.setLayoutData( gdRA );
  // /////////////////////////////////////////////////////////////////
  this.removeButtonRA = new Button( clientRA2, SWT.PUSH );
  this.removeButtonRA.setText( "Remove" ); //$NON-NLS-1$
  // Listener for Remove Elasticity Strategy button
  this.removeButtonRA.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( final SelectionEvent e ) {
      removeApplicationComponentResizingAction( getSelectedElasticityStrategy() );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  gdRA = new GridData();
  gdRA.widthHint = 80;
  gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.removeButtonRA.setLayoutData( gdRA );
  this.conditionButtonRA = new Button( clientRA2, SWT.PUSH );
  this.conditionButtonRA.setText( "Condition" ); //$NON-NLS-1$
  // Listener for Remove Elasticity Strategy button
  this.conditionButtonRA.addSelectionListener( new SelectionListener() {

    @Override
    public void widgetSelected( final SelectionEvent e ) {
      addStrategyCondition( getSelectedElasticityStrategy() );
    }

    @Override
    public void widgetDefaultSelected( final SelectionEvent e ) {
      // TODO Auto-generated method stub
    }
  } );
  gdRA = new GridData();
  gdRA.widthHint = 80;
  gdRA.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
  this.conditionButtonRA.setLayoutData( gdRA );
  // Add section components to the toolkit
  toolkit.adapt( this.tableResizingActions, true, true );
  toolkit.adapt( this.removeButtonRA, true, true );
  toolkit.adapt( this.addButtonRA, true, true );
  // toolkit.adapt( this.uploadButtonRA, true, true );
  toolkit.adapt( this.conditionButtonRA, true, true );
  toolkit.adapt( this.addExecutableButton, true, true );
  this.sectionRA.setClient( clientRA );
}

// Add Application Component Elasticity Requirement
void editDataStagingEntry( final TPolicy selectedObject ) {
  ElasticityConstraintDialog dialog;
  if( selectedObject == null ) {
    // Add button is pressed
    dialog = new ElasticityConstraintDialog( this.section.getShell(),
                                             "Application Component" ); //$NON-NLS-1$
    if( dialog.open() == Window.OK ) {
      String newElasticityConstraint = dialog.getElasticityConstraint();

      if( newElasticityConstraint != null ) {
        
        if( newElasticityConstraint.contains( "<" ) ) {
          String[] cond = newElasticityConstraint.split( "<" );
          newElasticityConstraint = cond[ 0 ] + "&lt;" + cond[ 1 ];
        } else if( newElasticityConstraint.contains( ">" ) ) {
          String[] cond = newElasticityConstraint.split( ">" );
          newElasticityConstraint = cond[ 0 ] + "&gt;" + cond[ 1 ];
        }
        
        // Add Application Component Elasticity Requirement to TOSCA
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
        if( nodeTemplate.getPolicies() == null ) {
          final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE.createPoliciesType();
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTemplate );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                nodeTemplate.setPolicies( nodePolicyList );
              }
            } );
        }
        PoliciesType nodePolicyList = nodeTemplate.getPolicies();
        final EList<TPolicy> policy = nodePolicyList.getPolicy();
        final TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
        String type = "Constraint";
        QName policyTypeName = new QName( "http://www.example.org/SYBL",
                                          type,
                                          null );
        newPolicy.setPolicyType( policyTypeName );
        newPolicy.setName( type.toUpperCase() + " " + newElasticityConstraint );
        
        String id = "C" + ( ( Integer )nodeTemplate.hashCode() ).toString() + nodePolicyList.getPolicy().size();
        QName qnamePolicyTemplate = new QName( id );
        newPolicy.setPolicyRef( qnamePolicyTemplate );
        
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTemplate );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            @Override
            protected void doExecute() {
              policy.add( newPolicy );
            }
          } );
        // Add Application Component Elasticity Requirement to temp list
        this.appComponentElasticityRequirements.add( newPolicy );
        this.tableViewer.refresh();
      }
    }
  }
}

void editDataStagingEntryRA( final TPolicy selectedObject ) {
  ElasticityStrategyDialog dialog;
  if( selectedObject == null ) {
    // Add button is pressed
    
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
    
    dialog = new ElasticityStrategyDialog( this.section.getShell(),
                                           "Application Component", nodeTemplate.getName() ); //$NON-NLS-1$
    if( dialog.open() == Window.OK ) {
      String newElasticityStrategy = dialog.getElasticityStrategy();
      if( newElasticityStrategy != null ) {
        // Add Application Component Elasticity Strategy to TOSCA

        if( nodeTemplate.getPolicies() == null ) {
          final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE.createPoliciesType();
          TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
          editingDomain.getCommandStack()
            .execute( new RecordingCommand( editingDomain ) {

              @Override
              protected void doExecute() {
                nodeTemplate.setPolicies( nodePolicyList );
              }
            } );
        }
        PoliciesType nodePolicyList = nodeTemplate.getPolicies();
        final EList<TPolicy> policy = nodePolicyList.getPolicy();
        final TPolicy newPolicy = ToscaFactory.eINSTANCE.createTPolicy();
        String type = "Strategy";
        QName policyTypeName = new QName( "http://www.example.org/SYBL",
                                          type,
                                          null );
        newPolicy.setPolicyType( policyTypeName );
        newPolicy.setName( type.toUpperCase() + " " + newElasticityStrategy );
        
        String id = "C" + ( ( Integer )nodeTemplate.hashCode() ).toString() + nodePolicyList.getPolicy().size();
        QName qnamePolicyTemplate = new QName( id );
        newPolicy.setPolicyRef( qnamePolicyTemplate );
        
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            @Override
            protected void doExecute() {
              policy.add( newPolicy );
            }
          } );
        this.appComponentResizingActions.add( newPolicy );
        this.tableResizingActionsViewer.refresh();
      } else {
        // Edit
      }
    }
  }
}

void addStrategyCondition( final TPolicy selectedObject ) {
  if( selectedObject == null )
    return;
  TNodeTemplate nodeTemplate = null;
  if( getSelectedPictogramElement() != null )
    nodeTemplate = ( TNodeTemplate )Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( getSelectedPictogramElement() );
  ElasticityConditionDialog dialog;
  ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
  dialog = new ElasticityConditionDialog( this.section.getShell(),
                                          "Application Component",
                                          model,
                                          selectedObject.getName() ); //$NON-NLS-1$
  String newElasticityCondition = null;
  if( dialog.open() == Window.OK ) {
    newElasticityCondition = dialog.getSelectedCondition();
  }
  if( newElasticityCondition == null )
    return;
  // final String condition = newElasticityCondition;
  String newCond = newElasticityCondition;
  if( newCond.contains( "<" ) ) {
    String[] cond = newCond.split( "<" );
    newCond = cond[ 0 ] + "&lt;" + cond[ 1 ];
  } else if( newCond.contains( ">" ) ) {
    String[] cond = newCond.split( ">" );
    newCond = cond[ 0 ] + "&gt;" + cond[ 1 ];
  }
  final String condition = newCond;
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTemplate );
  editingDomain.getCommandStack()
    .execute( new RecordingCommand( editingDomain ) {

      @Override
      protected void doExecute() {
        String[] strategy = selectedObject.getName().split( "STRATEGY" );
        selectedObject.setName( strategy[ 0 ]
                                + "STRATEGY "
                                + condition
                                + " :"
                                + strategy[ 1 ] );
      }
    } );
  this.tableResizingActionsViewer.refresh();
}

// Remove the selected Application Component Elasticity Requirement from TOSCA
void removeApplicationComponentElasticityRequirement( final TPolicy selectedObject )
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
  PoliciesType nodePolicyList = nodeTemplate.getPolicies();
  final EList<TPolicy> policy = nodePolicyList.getPolicy();
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
  editingDomain.getCommandStack()
    .execute( new RecordingCommand( editingDomain ) {

      @Override
      protected void doExecute() {
        for( TPolicy tempPolicy : policy ) {
          if( tempPolicy.getPolicyType().toString().contains( "Constraint" ) ) //$NON-NLS-1$
            if( tempPolicy.getName().compareTo( selectedObject.getName() ) == 0 )
            {
              policy.remove( tempPolicy );
              if( policy.size() == 0 )
                nodeTemplate.setPolicies( null );
              break;
            }
        }
      }
    } );
  this.appComponentElasticityRequirements.remove( selectedObject );
  this.tableViewer.refresh();
}

// Return the selected Elasticity Requirement
TPolicy getSelectedObject() {
  TPolicy result = null;
  IStructuredSelection selection = ( IStructuredSelection )this.tableViewer.getSelection();
  Object obj = selection.getFirstElement();
  result = ( TPolicy )obj;
  return result;
}

// Return the selected Elasticity Action
TPolicy getSelectedElasticityStrategy() {
  TPolicy result = null;
  IStructuredSelection selection = ( IStructuredSelection )this.tableResizingActionsViewer.getSelection();
  Object obj = selection.getFirstElement();
  result = ( TPolicy )obj;
  return result;
}

/**
 * Get Application Component Elasticity Actions
 */
public void getResizingActions() {
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

  if( appComponent == null || appComponent.getPolicies() == null )
    return;
  PoliciesType nodePolicyList = appComponent.getPolicies();
  for( TPolicy tempPolicy : nodePolicyList.getPolicy() ) {
    if( tempPolicy.getPolicyType().toString().contains( "Strategy" ) ) //$NON-NLS-1$
      this.appComponentResizingActions.add( tempPolicy );
  }
}

/**
 * Get Application Component Elasticity Constraints
 */
public void getElasticityConstraints() {
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

  if( appComponent == null || appComponent.getPolicies() == null )
    return;
  PoliciesType nodePolicyList = appComponent.getPolicies();
  for( TPolicy tempPolicy : nodePolicyList.getPolicy() ) {
    if( tempPolicy.getPolicyType().toString().contains( "Constraint" ) ) //$NON-NLS-1$
      this.appComponentElasticityRequirements.add( tempPolicy );
  }
}

// Remove Application Component Elasticity Action
void removeApplicationComponentResizingAction( final TPolicy selectedObject )
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
  PoliciesType nodePolicyList = nodeTemplate.getPolicies();
  final EList<TPolicy> policy = nodePolicyList.getPolicy();
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
  editingDomain.getCommandStack()
    .execute( new RecordingCommand( editingDomain ) {

      @Override
      protected void doExecute() {
        for( TPolicy tempPolicy : policy ) {
          if( tempPolicy.getPolicyType().toString().contains( "Strategy" ) ) //$NON-NLS-1$
            if( tempPolicy.getName().compareTo( selectedObject.getName() ) == 0 )
            {
              policy.remove( tempPolicy );
              if( policy.size() == 0 )
                nodeTemplate.setPolicies( null );
              break;
            }
        }
      }
    } );
  this.appComponentResizingActions.remove( selectedObject );
  this.tableResizingActionsViewer.refresh();
}

void addResizingActionExecutable( final Composite parent,
                                  final TPolicy selectedObject )
{
  if( selectedObject == null )
    return;
  FileDialog dialog = new FileDialog( parent.getShell(), SWT.OPEN );
  dialog.setText( "Select Executable File" ); //$NON-NLS-1$
  String result = dialog.open();
  if( result != null ) {
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
    // Create Resizing Artifact Template
    
    CreateArtifactTemplate artTempl = new CreateArtifactTemplate(dialog.getFileName(), new QName("RA"), ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) ));
    
    // Create Implementation Artifact
    String operationName = selectedObject.getName();
    // String operationName = "";
    createImplementationArtifact( operationName,
                                  dialog.getFileName(),
                                  new QName( appComponent.getName() ),
                                  new QName( dialog.getFileName() ) );
    
    // Add uploaded resizing scripts to Project Artifacts folder
    IWorkbenchPage activePage = PlatformUI.getWorkbench()
      .getActiveWorkbenchWindow()
      .getActivePage();
    IEditorInput input = activePage.getActiveEditor().getEditorInput();
    IFile file = null;
    if( input instanceof ToscaDiagramEditorInput ) {
      file = ( ( ToscaDiagramEditorInput )input ).getToscaFile();
    }
    IProject project = file.getProject();
    String targetPath = Platform.getLocation()
                        + System.getProperty( "file.separator" )
                        + project.getName()
                        + System.getProperty( "file.separator" )
                        + "Artifacts" + System.getProperty( "file.separator" ) + "Reconfiguration Scripts" + System.getProperty( "file.separator" ) + dialog.getFileName(); //$NON-NLS-1$ //$NON-NLS-2$
    File tmp = new File( targetPath );
    try {
      tmp.createNewFile();
    } catch( IOException e1 ) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    copySelectedFileToCloudProject( new File( result ), tmp );
    IProgressMonitor monitor = null;
    try {
      CloudModel.getRoot().refresh( monitor );
    } catch( ProblemException e2 ) {
      e2.printStackTrace();
    }
//    // Refresh Palette Compartments
//    getDiagramTypeProvider().getFeatureProvider()
//      .getDiagramTypeProvider()
//      .getDiagramBehavior()
//      .refreshPalette();
  }
}

private void copySelectedFileToCloudProject( File source, File destination ) {
  InputStream selection = null;
  OutputStream output = null;
  try {
    try {
      selection = new FileInputStream( source );
    } catch( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      output = new FileOutputStream( destination );
    } catch( FileNotFoundException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    byte[] buf = new byte[ 1024 ];
    int bytesRead;
    try {
      while( ( bytesRead = selection.read( buf ) ) > 0 ) {
        output.write( buf, 0, bytesRead );
      }
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  } finally {
    try {
      selection.close();
      output.close();
    } catch( IOException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

private void createArtifactTemplate( String nodeName, String artifactName ) {
  // Create Artifact Template
  final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
  // Create Script Artifact Properties
  ScriptArtifactPropertiesType scriptProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createScriptArtifactPropertiesType();
  scriptProperties.setLanguage( "Shell" );
  // Set the Properties of the Policy Template
  PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();
  // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
  Entry e = FeatureMapUtil.createEntry( Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ScriptArtifactProperties(),
                                        scriptProperties );
  properties.getAny().add( e );
  artifactTemplate.setProperties( properties );
  artifactTemplate.setId( nodeName + "_" + artifactName + "_" + "Script" );
  artifactTemplate.setType( new QName( "ScriptArtifact" ) );
  // Set artifact ref
  TArtifactReference artifactRef = ToscaFactory.eINSTANCE.createTArtifactReference();
  artifactRef.setReference( "Scripts" + System.getProperty( "file.separator" ) + artifactName );
  ArtifactReferencesType artifactRefType = ToscaFactory.eINSTANCE.createArtifactReferencesType();
  artifactRefType.getArtifactReference().add( artifactRef );
  artifactTemplate.setArtifactReferences( artifactRefType );
  // Add the new Artifact Template to the TOSCA Definitions element
  final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
  DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
  editingDomain.getCommandStack()
    .execute( new RecordingCommand( editingDomain ) {

      @Override
      protected void doExecute() {
        model.getDocumentRoot()
          .getDefinitions()
          .getArtifactTemplate()
          .add( artifactTemplate );
      }
    } );
}

// Creates the install implementation artifact
private ImplementationArtifactType createImplementationArtifact( String resizingActionName,
                                                                 String artifactName,
                                                                 QName nodeType,
                                                                 QName artifactID )
{
  final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
  final DefinitionsType definitions = model.getDocumentRoot()
    .getDefinitions();
  TNodeTypeImplementation nodeTypeImplementation = null;
  // Test if NodeTypeImplementation for nodeType already exists
  for( TNodeTypeImplementation tempNodeTypeImplementation : definitions.getNodeTypeImplementation() )
  {
    if( tempNodeTypeImplementation.getNodeType()
      .toString()
      .equals( nodeType.toString() ) )
    {
      // NodeTypeImplementation already exists
      // We are going to add the artifact to the existing implementation
      nodeTypeImplementation = tempNodeTypeImplementation;
    }
  }
  if( nodeTypeImplementation == null ) {
    // NodeTypeImplementation does not exists
    final TNodeTypeImplementation newNodeTypeImplementation = ToscaFactory.eINSTANCE.createTNodeTypeImplementation();
    newNodeTypeImplementation.setNodeType( nodeType );
    TImplementationArtifacts implementationArtifacts = ToscaFactory.eINSTANCE.createTImplementationArtifacts();
    newNodeTypeImplementation.setImplementationArtifacts( implementationArtifacts );
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          definitions.getNodeTypeImplementation()
            .add( newNodeTypeImplementation );
        }
      } );
    nodeTypeImplementation = newNodeTypeImplementation;
  }
  // Create Implementation Artifact
  final ImplementationArtifactType installArtifactType = ToscaFactory.eINSTANCE.createImplementationArtifactType();
  installArtifactType.setArtifactType( new QName( "ScriptArtifact" ) );
  installArtifactType.setArtifactRef( artifactID );
  installArtifactType.setInterfaceName( "Lifecycle" );
  installArtifactType.setOperationName( resizingActionName );
  final TNodeTypeImplementation nodeImplementation = nodeTypeImplementation;
  TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
  editingDomain.getCommandStack()
    .execute( new RecordingCommand( editingDomain ) {

      @Override
      protected void doExecute() {
        nodeImplementation.getImplementationArtifacts()
          .getImplementationArtifact()
          .add( installArtifactType );
      }
    } );
  return installArtifactType;
}

/*
 * Refresh Elasticity Tab(non-Javadoc)
 * @see
 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
 */
@Override
public void refresh() {
  // Refresh Elasticity Constraints
  this.appComponentElasticityRequirements.clear();
  getElasticityConstraints();
  this.tableViewer.refresh();
  // Refresh Elasticity Actions
  this.appComponentResizingActions.clear();
  getResizingActions();
  this.tableResizingActionsViewer.refresh();
}
}
