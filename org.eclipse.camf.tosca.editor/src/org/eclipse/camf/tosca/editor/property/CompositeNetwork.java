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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

// Application Component Properties - Network Tab
public class CompositeNetwork extends GFPropertySection
  implements ITabbedPropertyConstants
{

  private CCombo cmbCommunicationIntensity;
  private CCombo cmbNetworkConnection;

  @Override
  public void createControls( Composite parent,
                              TabbedPropertySheetPage tabbedPropertySheetPage )
  {
    super.createControls( parent, tabbedPropertySheetPage );
    TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
    FormToolkit toolkit = new FormToolkit( parent.getDisplay() );
    Section section = toolkit.createSection( parent, Section.TITLE_BAR );
    section.setText( "Communication/Network Properties" ); //$NON-NLS-1$
    Composite client = toolkit.createComposite( section, SWT.WRAP );
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginTop = 15;
    layout.verticalSpacing = 15;
    layout.marginWidth = 2;
    layout.marginHeight = 2;
    client.setLayout( layout );
    GridData gd;
    // Communication Intensity
    CLabel communicationIntensityLabel = factory.createCLabel( client,
                                                               "Communication Intensity:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    communicationIntensityLabel.setLayoutData( gd );
    // Combo - Communication Intensity
    this.cmbCommunicationIntensity = new CCombo( client, SWT.BORDER );
    this.cmbCommunicationIntensity.setEnabled( true );
    this.cmbCommunicationIntensity.add( "Heavy" ); //$NON-NLS-1$
    this.cmbCommunicationIntensity.setEditable( false );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.cmbCommunicationIntensity.setLayoutData( gd );
    // Network Connection
    CLabel networkConnectionLabel = factory.createCLabel( client,
                                                          "Network Connection:" ); //$NON-NLS-1$
    gd = new GridData();
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    // gd.widthHint=STANDARD_LABEL_WIDTH;
    networkConnectionLabel.setLayoutData( gd );
    // Combo - Network Connection
    this.cmbNetworkConnection = new CCombo( client, SWT.BORDER );
    this.cmbNetworkConnection.setEnabled( true );
    this.cmbNetworkConnection.add( "1 GB" ); //$NON-NLS-1$
    this.cmbNetworkConnection.setEditable( false );
    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
    gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
    gd.widthHint = 140;
    this.cmbNetworkConnection.setLayoutData( gd );
    // Add section components to the toolkit
    toolkit.adapt( this.cmbCommunicationIntensity );
    toolkit.adapt( communicationIntensityLabel );
    toolkit.adapt( this.cmbNetworkConnection );
    toolkit.adapt( networkConnectionLabel );
    section.setClient( client );
  }

  // Refresh Tab
  @Override
  public void refresh() {
  }
}
