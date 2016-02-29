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

import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

// Application Properties - Data/Load Tab
public class ApplicationDataHintsSection extends GFPropertySection
  implements ITabbedPropertyConstants
{

  Section sectionDH;
  Section sectionLH;
  private Table tableDataHints;
  private Table tableLoadHints;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    // TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    // Application Data Hints Section
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Data Hints" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    GridData gd;
    this.tableDataHints = new Table( client, SWT.BORDER
                                             | SWT.VIRTUAL
                                             | SWT.MULTI
                                             | SWT.FULL_SELECTION
                                             | SWT.CHECK );
    gd = new GridData( 300, this.tableDataHints.getItemHeight() * 4 );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableDataHints.setLayoutData( gd );
    TableItem item = new TableItem( this.tableDataHints, SWT.NONE );
    item.setText( "JSON" ); //$NON-NLS-1$
    item = new TableItem( this.tableDataHints, SWT.NONE );
    item.setText( "XML" ); //$NON-NLS-1$
    // Add section components to the toolkit
    toolkit.adapt( this.tableDataHints, true, true );
    section.setClient( client );
    // Application Load Hints Section
    Section sectionInstances = toolkit.createSection( parent, Section.TITLE_BAR );
    sectionInstances.setText( "Load Hints" ); //$NON-NLS-1$
    Composite clientInstances = toolkit.createComposite( sectionInstances,
                                                         SWT.WRAP );
    GridLayout layoutInstances = new GridLayout();
    layoutInstances.numColumns = 2;
    layoutInstances.marginTop = 15;
    layoutInstances.verticalSpacing = 15;
    layoutInstances.marginWidth = 2;
    layoutInstances.marginHeight = 2;
    clientInstances.setLayout( layoutInstances );
    GridData gdLH;
    this.tableLoadHints = new Table( clientInstances, SWT.BORDER
                                                      | SWT.VIRTUAL
                                                      | SWT.MULTI
                                                      | SWT.FULL_SELECTION
                                                      | SWT.CHECK );
    gdLH = new GridData( 300, this.tableLoadHints.getItemHeight() * 4 );
    gdLH.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gdLH.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
    this.tableLoadHints.setLayoutData( gdLH );
    item = new TableItem( this.tableLoadHints, SWT.NONE );
    item.setText( "Read Only" ); //$NON-NLS-1$
    item = new TableItem( this.tableLoadHints, SWT.NONE );
    item.setText( "Write Only" ); //$NON-NLS-1$
    item = new TableItem( this.tableLoadHints, SWT.NONE );
    item.setText( "Read / Write" ); //$NON-NLS-1$
    // Add section components to the toolkit
    toolkit.adapt( this.tableLoadHints, true, true );
    sectionInstances.setClient( clientInstances );
  }

  // Refresh Tab
  @Override
  public void refresh() {
  }
}