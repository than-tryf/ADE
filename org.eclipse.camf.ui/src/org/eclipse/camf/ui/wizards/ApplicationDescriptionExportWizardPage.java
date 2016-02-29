/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package org.eclipse.camf.ui.wizards;

import java.io.File;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;


/**
 * @author nickl
 *
 */
public class ApplicationDescriptionExportWizardPage extends WizardExportResourcesPage {
  
  
  private static final String PAGE_ID = "org.eclipse.camf.ui.wizards.page.exportAppDescrPage";
  private IStructuredSelection selection;
  private Combo destinationCombo = null;
  private Button browseButton = null;

  protected ApplicationDescriptionExportWizardPage( final String pageName,
                                                    final IStructuredSelection selection )
  {
    super( pageName, selection );
    this.selection = selection;
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.dialogs.WizardExportPage#createDestinationGroup(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createDestinationGroup( final Composite parent ) {
    
    initializeDialogUnits( parent );
        
    Composite destinationComposite = new Composite( parent, SWT.NONE );
    GridLayout gLayout = new GridLayout();
    gLayout.numColumns = 3;
    destinationComposite.setLayout( gLayout );
    destinationComposite.setLayoutData( new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL) );
    
    // Destination Label box
    Label label = new Label( destinationComposite, SWT.NONE );
    label.setText( "Destination: " );
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = 1;
    label.setLayoutData(gd);
    
    // Destination combo box
    this.destinationCombo = new Combo( destinationComposite, SWT.SINGLE | SWT.BORDER );    
    this.destinationCombo.addListener(SWT.Modify, this);
    this.destinationCombo.addListener(SWT.Selection, this);
    GridData data= new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
    data.widthHint= SIZING_TEXT_FIELD_WIDTH;
    data.horizontalSpan = 1;
    this.destinationCombo.setLayoutData(data);
    
    // Destination browse button
    
    this.browseButton = new Button(destinationComposite, SWT.PUSH);
    this.browseButton.setText("Browse");
    this.browseButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
    this.browseButton.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            handleDestinationBrowseButtonPressed();
        }
    });
    
  }
  
  /**
   * Open an appropriate destination browser so that the user can specify a
   * source to import from
   */
  protected void handleDestinationBrowseButtonPressed() {
    String[] extenstions = new String[] {"*.csar;"};
    FileDialog dialog = new FileDialog( getContainer().getShell(), SWT.SAVE );
    dialog.setFilterExtensions( extenstions );
    
    String currentSourceString = getDestinationValue();
    int lastSeparatorIndex = currentSourceString.lastIndexOf( File.separator );
    if( lastSeparatorIndex != -1 ) {
      dialog.setFilterPath( currentSourceString.substring( 0,
                                                           lastSeparatorIndex ) );
      dialog.setFileName( currentSourceString.substring( lastSeparatorIndex + 1,
                                                         currentSourceString.length() ) );
    }
    
    String selectedFileName = dialog.open();
    if( selectedFileName != null ) {
      IContainer[] findContainersForLocation = ResourcesPlugin.getWorkspace()
        .getRoot()
        .findContainersForLocationURI( URIUtil.toURI( new Path( selectedFileName ).makeAbsolute() ) );
      if( findContainersForLocation.length > 0 ) {
        selectedFileName = findContainersForLocation[ 0 ].getFullPath()
          .makeRelative()
          .toString();
      }
      this.destinationCombo.setText( selectedFileName );
    }
  }
  
  protected String getDestinationValue() {
    String destinationText = this.destinationCombo.getText().trim();
    if( destinationText.indexOf( '.' ) < 0 )
      destinationText += getOutputSuffix();
    return destinationText;
  }
  
  protected String getOutputSuffix() {
    return ".csar"; //$NON-NLS-1$
}

  @Override
  public void handleEvent( final Event event ) {
    if( getControl() == null )
      return;
    update();
  }
  
  protected void update() {
    updateWidgetEnablements();
    updatePageCompletion();
  }

  @Override
  protected void updatePageCompletion() {
    boolean pageComplete = isPageComplete();
    setPageComplete( pageComplete );
    if( pageComplete )
      setErrorMessage( null );
  }
  
  @Override
  protected List getSelectedResources() {   
    return super.getSelectedResources();
  }
}
