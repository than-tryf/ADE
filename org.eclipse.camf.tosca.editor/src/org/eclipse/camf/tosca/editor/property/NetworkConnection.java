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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class NetworkConnection extends GFPropertySection implements ITabbedPropertyConstants {

  private CCombo cmbNetworkConnection;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);

    FormData data;
    // Combo - RelationshipType
    this.cmbNetworkConnection = new CCombo( composite, SWT.BORDER );
    this.cmbNetworkConnection.setEnabled( true );
    this.cmbNetworkConnection.add( "Master - Slave" ); //$NON-NLS-1$
    this.cmbNetworkConnection.add( "Peer - Peer" ); //$NON-NLS-1$
    this.cmbNetworkConnection.add( "Producer - Consumer" ); //$NON-NLS-1$
    this.cmbNetworkConnection.setEditable( false );
    data = new FormData();
    data.left = new FormAttachment( 0, STANDARD_LABEL_WIDTH + 60 );
    data.right = new FormAttachment( 40, 0 );
    data.top = new FormAttachment( 0, VSPACE );
    this.cmbNetworkConnection.setLayoutData( data );

    // RelationshipType Label
    CLabel valueLabel = factory.createCLabel( composite,
                                              "Network Connection:" ); //$NON-NLS-1$
    data = new FormData();
    data.left = new FormAttachment( 0, 0 );
    data.right = new FormAttachment( this.cmbNetworkConnection, -HSPACE );
    data.top = new FormAttachment( this.cmbNetworkConnection, 0, SWT.CENTER );
    valueLabel.setLayoutData( data );

    }

    @Override
    public void refresh() {

    }
}

