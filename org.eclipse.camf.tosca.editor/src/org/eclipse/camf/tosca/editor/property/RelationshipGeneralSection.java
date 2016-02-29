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

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.TRelationshipTemplate;
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

// Relationship Properties - Connection Tab
public class RelationshipGeneralSection extends GFPropertySection
  implements ITabbedPropertyConstants, ModifyListener
{

  private Text nameText;
  private CCombo cmbRelationshipType;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Relationship Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    GridData gd;
    // Relationship Name
    CLabel valueLabel = factory.createCLabel( client, "Name:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    valueLabel.setLayoutData( gd );
    // Text - Relationship Type
    this.nameText = factory.createText( client, "" ); //$NON-NLS-1$
    this.nameText.setEditable( true );
    this.nameText.addModifyListener( this );
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.nameText.setLayoutData( gd );
    // Relationship Type
    CLabel relationshipTypeLabel = factory.createCLabel( client,
                                                         "Relationship Type:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    relationshipTypeLabel.setLayoutData( gd );
    // Combo - Relationship Type
    this.cmbRelationshipType = new CCombo( client, SWT.BORDER );
    this.cmbRelationshipType.setEnabled( true );
    this.cmbRelationshipType.add( "Master-Slave" ); //$NON-NLS-1$
    this.cmbRelationshipType.add( "Peer-Peer" ); //$NON-NLS-1$
    this.cmbRelationshipType.add( "Producer-Consumer" ); //$NON-NLS-1$
    this.cmbRelationshipType.setEditable( false );
    this.cmbRelationshipType.addModifyListener( this );
    
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.cmbRelationshipType.setLayoutData( gd );
    // Add section components to the toolkit
    toolkit.adapt( valueLabel, true, true );
    toolkit.adapt( this.nameText, true, true );
    toolkit.adapt( relationshipTypeLabel, true, true );
    toolkit.adapt( this.cmbRelationshipType, true, true );
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
      String name = ( ( TRelationshipTemplate )bo ).getName();
      String type;
      
      if ( ( ( TRelationshipTemplate )bo ).getType() != null)
        type = ( ( TRelationshipTemplate )bo ).getType().toString();
      else type = null;
      
      if ( ( name.compareTo( "Relation" ) == 0 || name.compareTo( "Directed Relation" ) == 0 ) && type == null )
        return;
      
      this.nameText.setText( name == null
                                    ? "" : name ); //$NON-NLS-1$
      
     
      this.cmbRelationshipType.setText( type == null
                                    ? "" : type ); //$NON-NLS-1$
    }
  }

  @Override
  public void modifyText( ModifyEvent e ) {
//    PictogramElement pe = getSelectedPictogramElement();
//    if( pe != null ) {
//      final Object bo = Graphiti.getLinkService()
//        .getBusinessObjectForLinkedPictogramElement( pe );
//
//      if( bo == null )
//        return;
//      final TRelationshipTemplate relationshipTemplate = ( TRelationshipTemplate )bo;
//      
//      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( bo );
//      if (e.widget == this.nameText){
//        
//        editingDomain.getCommandStack().execute( new RecordingCommand( editingDomain ) {
//            protected void doExecute() {
//              relationshipTemplate.setName( RelationshipGeneralSection.this.nameText.getText() );
//            }
//          } );
//      }
//      else if ( e.widget == this.cmbRelationshipType){
//
//        editingDomain.getCommandStack().execute( new RecordingCommand( editingDomain ) {
//            protected void doExecute() {
//              relationshipTemplate.setType( new QName(RelationshipGeneralSection.this.cmbRelationshipType.getText()) );
//            }
//          } );
//      }
//    }
    
  }
}
