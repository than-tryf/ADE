/*****************************************************************************
 * Copyright (c) 2006-2008 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Ariel Garcia      - switch to use a CheckboxTableViewer
 *                      - make it a IGridModelListener
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013                
 *****************************************************************************/

package org.eclipse.camf.ui.wizards;

import java.net.URL;
import java.util.ArrayList;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PreferencesUtil;



/**
 * A wizard page allowing to select a VO from the list of VOs registered
 * in the VO manager. It also allows to edit the VOs on the fly by opening
 * the VO preferences page.
 */
public class CloudProviderSelectionWizardPage extends WizardPage
    implements ICloudModelListener
{
  
  CheckboxTableViewer tableViewer;
  java.util.List< ICloudProvider > cpList;
  Class< ? > voType;
  boolean allowMultiSelection;
  
  private Text infoText;
  
  private final String PREFERENCE_PAGE_ID = "org.eclipse.camf.ui.internal.preference.CloudProviderPreferencePage"; //$NON-NLS-1$
  
  
  public CloudProviderSelectionWizardPage( final boolean allowMultiSelection ) {
    this( allowMultiSelection, null );
  }
  
  public CloudProviderSelectionWizardPage( final boolean allowMultiSelection,
                                final Class< ? > voType ) {
    super( "org.eclipse.camf.ui.voSelectionWizardPage", //$NON-NLS-1$
           "Cloud Provider Selection Page",
           null );
    setDescription( "Specify the Cloud Provider that should be used" );
    URL imgUrl = Activator.getDefault().getBundle().getEntry( "icons/wizban/vo_wiz.gif" ); //$NON-NLS-1$
    setImageDescriptor( ImageDescriptor.createFromURL( imgUrl ) );
    this.allowMultiSelection = allowMultiSelection;
    this.voType = voType;
    this.cpList = new ArrayList< ICloudProvider >();
  }

  public void createControl( final Composite parent ) {
    
    GridData gData;
    
    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );
    gData = new GridData( GridData.FILL_BOTH );
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    mainComp.setLayoutData( gData );
    
    Group voGroup = new Group( mainComp, SWT.NONE );
    voGroup.setLayout( new GridLayout( 2, false ) );
    voGroup.setText( "&Available Cloud Providers" );
    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData.heightHint = 120;
    voGroup.setLayoutData( gData );
    
    int style = SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE | SWT.CHECK;    
    Table voTable = new Table( voGroup, style );
    gData = new GridData( SWT.FILL, SWT.FILL, true, true);
    voTable.setLayoutData( gData );
    voTable.setHeaderVisible( false );
    
    this.tableViewer = new CheckboxTableViewer( voTable );
    this.tableViewer.setContentProvider( new ArrayContentProvider() );
    this.tableViewer.setLabelProvider( new LabelProvider() {
      @Override
      public String getText( final Object element ) {
        return ( (ICloudProvider) element ).getName();
      }
    } );
    
    this.tableViewer.setComparator( new ViewerComparator() {
      @Override
      public int compare( final Viewer viewer, final Object cp1, final Object cp2 ) {
        String name1 = ( (ICloudProvider) cp1 ).getName();
        String name2 = ( (ICloudProvider) cp2 ).getName();
        // Sort by VO name
        return name1.compareTo( name2 );
      }
    } );

    // Filter the VOs that can be used to create this type of auth-token
    this.tableViewer.addFilter( new ViewerFilter() {
      @Override
      public boolean select( final Viewer viewer,
                             final Object parentElement,
                             final Object element )
      {
        boolean ret = false;

        Class< ? > type = CloudProviderSelectionWizardPage.this.voType;
        if ( element instanceof ICloudProvider ) {
          ICloudProvider cp = (ICloudProvider) element;
          if ( ( type == null ) || type.isAssignableFrom( cp.getClass() ) ) {
            ret = true;
          }
        }
        return ret;
      }
    } );
    
    this.tableViewer.addSelectionChangedListener( new ISelectionChangedListener() {
      public void selectionChanged( final SelectionChangedEvent event ) {
        showSelectedInfo();
      }
    } );
    
    this.tableViewer.addCheckStateListener( new ICheckStateListener() {
      public void checkStateChanged( final CheckStateChangedEvent event ) {
        
        // If allowMultiSelection is not set, then implement a radio-button behavior
        if ( ! CloudProviderSelectionWizardPage.this.allowMultiSelection ) {
          Object element = event.getElement();
          if ( element instanceof ICloudProvider ) {
            ICloudProvider cp = ( ICloudProvider ) element;
            if ( event.getChecked() ) {
              CloudProviderSelectionWizardPage.this.tableViewer.setCheckedElements( new Object[] { cp } );
              CloudProviderSelectionWizardPage.this.tableViewer.refresh();
            }
          }
        }
        
        setPageComplete( getSelectedCloudProviders() != null );
      }
    } );
    
    updateVoList();
    this.tableViewer.setInput( this.cpList );
    
    // Listen on new VOs, this will update the tableViewer
    CloudModel.getCloudProviderManager().addCloudModelListener( this );
    
    Button editCPsButton = new Button( voGroup, SWT.PUSH );
    editCPsButton.setText( "Edit &Cloud Providers..." );
    gData = new GridData();
    gData.horizontalAlignment = GridData.BEGINNING;
    gData.verticalAlignment = GridData.BEGINNING;
    editCPsButton.setLayoutData( gData );
    editCPsButton.addSelectionListener( new SelectionAdapter() {
      @Override
      public void widgetSelected( final SelectionEvent e ) {
        PreferenceDialog dialog
          = PreferencesUtil.createPreferenceDialogOn( getShell(),
                CloudProviderSelectionWizardPage.this.PREFERENCE_PAGE_ID,
                null,
                null );
        
        /*
         * Even if the user pressed 'Cancel' VOs might have been
         * added/deleted, so ignore the dialog's return value.
         */
        dialog.open();
      }
    } );
    
    Group infoGroup = new Group( mainComp, SWT.NONE );
    infoGroup.setLayout( new GridLayout( 1, false ) );
    infoGroup.setText( "&Cloud Provider Info" );
    gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData.heightHint = 120;
    infoGroup.setLayoutData( gData );
    
    this.infoText = new Text( infoGroup, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    this.infoText.setEditable( false );
    gData = new GridData( GridData.FILL_BOTH );
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    this.infoText.setLayoutData( gData );
    
    setInitialSelection();
    showSelectedInfo();
    setPageComplete( getSelectedCloudProviders() != null );
    
    setControl( mainComp );
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelListener#modelChanged(org.eclipse.camf.core.model.ICloudModelEvent)
   */
  @Override
  public void modelChanged( final ICloudModelEvent event ) {
    ICloudElement[] elements = event.getElements();
    
    // We are a listener of the VoManager only
    assert elements[ 0 ] instanceof ICloudProvider
      : "CloudProviderSelectionWizardPage expects events whose source is an ICloudProvider."; //$NON-NLS-1$
    
    switch ( event.getType() ) {
      case ICloudModelEvent.ELEMENTS_ADDED:
        updateVoList();
        this.tableViewer.setInput( this.cpList );
        // Each event contains a single element
        setSelection( elements[ 0 ] );
        break;
      case ICloudModelEvent.ELEMENTS_REMOVED:
        updateVoList();
        this.tableViewer.setInput( this.cpList );
        // If the selected VO has been deleted select the default one
        ICloudProvider[] selectedVOs = getSelectedCloudProviders();
        if ( selectedVOs == null ) {
          setInitialSelection();
        }
        break;
      default:
        // Do nothing in other cases
    }
    setPageComplete( getSelectedCloudProviders() != null );        
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.dialogs.DialogPage#dispose()
   */
  @Override
  public void dispose() {
    CloudModel.getCloudProviderManager().removeCloudModelListener( this );
    super.dispose();
  }
  
  /**
   * Get the list of checked VOs
   * 
   * @return the array of VOs checked in the viewer
   */
  public ICloudProvider[] getSelectedCloudProviders() {
    
    java.util.List< ICloudProvider > selectedCPs
      = new ArrayList< ICloudProvider >();

    for ( Object cp : this.tableViewer.getCheckedElements() ) {
      selectedCPs.add( ( ICloudProvider ) cp );
    }
    
    if ( selectedCPs.size() == 0 ) {
      setErrorMessage( "No valid Cloud Provider is selected" );
    } else {
      setErrorMessage( null );
    }
    
    return
      selectedCPs.size() == 0
        ? null
        : selectedCPs.toArray( new ICloudProvider[ selectedCPs.size() ] );
  }
  
  /**
   * Select the given VOs by setting the checkboxes
   * 
   * @param cps an array of VOs to check on the viewer
   */
  public void setSelectedVos( final ICloudElement[] cps ) {
    if ( cps == null || cps.length == 0 ) {
      return;
    }
    
    if ( CloudProviderSelectionWizardPage.this.allowMultiSelection ) {
      this.tableViewer.setCheckedElements( cps );
    } else {
      assert cps.length == 1
        : "CloudProviderSelectionWizardPage got more than one VO to select while allowMultiSelection=false."; //$NON-NLS-1$
      this.tableViewer.setChecked( cps[ 0 ], true );
    }
    this.tableViewer.refresh();
  }
  
  protected void showSelectedInfo() {
    int index = this.tableViewer.getTable().getSelectionIndex();
    if ( index >= 0 ) {
      ICloudProvider cp
        = (ICloudProvider) this.tableViewer.getElementAt( index );
//      try {
        String text = ""; //$NON-NLS-1$
        text += "Name:\n\t" + cp.getName() + '\n';
        text += "Type:\n\t" + cp.getTypeName() + '\n';
//        IGridInfoService infoService = cp.getInfoService();
//        if ( infoService != null ) {
//          text += "\nInformation Service:\n\tName:\n\t\t" + infoService.getName();
//          text += "\n\tURI:\n\t\t" + infoService.getURI().toString(); 
//        }

        //
        // This forces an Infosystem query for every click on a VO!! 
        //   Don't show non-static info here!
        /*
        IGridService[] services = vo.getServices();
        text += "\n\nOther Services:";
        if ( ( services != null ) && ( services.length > 1 ) ) {
          for ( IGridService service : services ) {
            if ( service != infoService ) {
              text += "\n\tName:\n\t\t" + service.getName();
              URI uri = service.getURI();
              if ( uri != null ) {
                text += "\n\tURI:\n\t\t" + service.getURI().toString();
              } else {
                text += "\n\tURI:\n\t\tN/A";
              }
            }
          }
        } else {
          text += "\n\tNone";
        }
        */
        this.infoText.setText( text );
//      } catch ( ProblemException pExc ) {
//        ProblemDialog.openProblem( getShell(),
//                                   "Cloud Provider info problem",
//                                   "Unable to query services for Cloud Provider " + cp.getName(),
//                                   pExc );
//      }
    } else {
      this.infoText.setText( "" ); //$NON-NLS-1$
    }
    // This is needed if the text is changed while the dialog is not focused
    this.infoText.redraw();
  }
  
  /**
   * Load the list of VOs from the manager.
   */
  private void updateVoList() {
    this.cpList.clear();
    try {
      ICloudElement[] vos = CloudModel.getCloudProviderManager().getChildren( null );
      for ( ICloudElement cp : vos ) {
        this.cpList.add( ( ICloudProvider ) cp );
      }
    } catch ( ProblemException pExc ) {
      ProblemDialog.openProblem( getShell(),
                                 "Cloud Provider list problem",
                                 "Unable to query registered Cloud Providers",
                                 pExc );
    }
  }
  
  /**
   * Set the specified VO as selected (clicked and checked) in the viewer.
   * 
   * @param cp the VO to set as checked/selected
   */
  private void setSelection( final ICloudElement cp ) {
    
    // Do nothing if there is no VO to select
    if ( cp == null || ! ( cp instanceof ICloudProvider) ) {
      return;
    }
    
    // If allowMultiSelection is not set we implement a radio-button behavior
    if ( CloudProviderSelectionWizardPage.this.allowMultiSelection ) {
      this.tableViewer.setChecked( cp, true );
    } else {
      this.tableViewer.setCheckedElements( new Object[] { cp } );
    }
    this.tableViewer.refresh();
    
    StructuredSelection sel = new StructuredSelection( cp );
    this.tableViewer.setSelection( sel, true );
  }
  
  /**
   * Determines which VO to select initially in the viewer.
   */
  private void setInitialSelection() {
    ICloudElement defaultVo = CloudModel.getCloudProviderManager().getDefault();
    
    if ( defaultVo == null ) {
      // No default VO, take the first entry if any, null otherwise
      defaultVo = ( ICloudElement ) this.tableViewer.getElementAt( 0 );
    } else {
      // Check if the default VO is of the requested voType
      boolean show = true;
      for ( ViewerFilter filter: this.tableViewer.getFilters() ) {
        show &= filter.select( this.tableViewer, this.cpList, defaultVo );
      }
      // If it is not, then select the first of the list if any, null otherwise
      if ( ! show ) {
        defaultVo = ( ICloudElement ) this.tableViewer.getElementAt( 0 );
      }
    }
    
    setSelection( defaultVo );
  }

}
