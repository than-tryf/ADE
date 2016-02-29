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

import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
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

// Application Component Properties - Application Tab
public class ApplicationNameSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener
{

  private Text nameText;
  //CCombo cmbOptimizationPolicy;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Application Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    // Application Name
    GridData gd;
    CLabel valueLabel = factory.createCLabel( client, "Name:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    nameText = factory.createText( client, "" ); //$NON-NLS-1$
    nameText.setEditable( true );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    nameText.setLayoutData( gd );
    nameText.addModifyListener( this );
//    // Optimization Policy
//    CLabel optPolicyLabel = factory.createCLabel( client,
//                                                  "Optimization Policy:" ); //$NON-NLS-1$
//    gd = new GridData();
//    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
//    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
//    // gd.widthHint=STANDARD_LABEL_WIDTH;
//    optPolicyLabel.setLayoutData( gd );
//    cmbOptimizationPolicy = new CCombo( client, SWT.BORDER );
//    cmbOptimizationPolicy.setEnabled( true );
//    cmbOptimizationPolicy.add( "Minimize Cost" );
//    cmbOptimizationPolicy.add( "Maximize Throughput" );
//    cmbOptimizationPolicy.setEditable( false );
//    gd = new GridData();
//    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
//    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
//    gd.widthHint = 140;
//    cmbOptimizationPolicy.setLayoutData( gd );
//    cmbOptimizationPolicy.addModifyListener( this );
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
//    toolkit.adapt( optPolicyLabel, true, true );
//    toolkit.adapt( cmbOptimizationPolicy, true, true );
    section.setClient( client );
  }

  // Refresh Tab
  @Override
  public void refresh() {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      Object bo = Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
      
      if( bo == null )
        return;
      
      // Refresh Application name field
      String name = ( ( TServiceTemplate )bo ).getName();
      nameText.setText( name == null
                                    ? "" : name ); //$NON-NLS-1$
      
//      // Refresh Optimization policy field
//      String optPolicy = ( ( TServiceTemplate )bo ).getBoundaryDefinitions()
//        .getPolicies()
//        .getPolicy()
//        .get( 0 )
//        .getName();
//      //optPolicyText.setText(optPolicy == null ? "" : optPolicy); //$NON-NLS-1$
//      cmbOptimizationPolicy.setText( optPolicy == null
//                                                      ? "" : optPolicy ); //$NON-NLS-1$
    }
  }

  // Updates optimization policy if corresponding listener is triggered
  @Override
  public void modifyText( ModifyEvent e ) {
    PictogramElement pe = getSelectedPictogramElement();
    if( pe != null ) {
      final TServiceTemplate bo = ( TServiceTemplate )Graphiti.getLinkService()
        .getBusinessObjectForLinkedPictogramElement( pe );
//      if( bo == null )
//        return;
//      // Optimization policy modified
//      if( e.widget == this.cmbOptimizationPolicy ) {
//        final String optPolicy = cmbOptimizationPolicy.getText();
//        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
//        editingDomain.getCommandStack()
//          .execute( new RecordingCommand( editingDomain ) {
//
//            protected void doExecute() {
//              bo.getBoundaryDefinitions()
//                .getPolicies()
//                .getPolicy()
//                .get( 0 )
//                .setName( optPolicy );
//            }
//          } );
//      }else
      // Application name modified
       if ( e.widget == this.nameText ){
        final String name = this.nameText.getText();
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            protected void doExecute() {
              bo.setName( name );
            }
          } );
      }
    }
  }
}
