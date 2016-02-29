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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.infosystem.ui;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.InfoService;
import org.eclipse.camf.infosystem.jobs.FetchJob;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

public class InfoSystemViewOld extends ViewPart
  implements ISelectionProvider, ICloudModelListener
{

  TreeViewer viewer;
  FetchJob fetchJob;
  private boolean showOnlyFilledInfoElements = false;
  private DrillDownAdapter drillDownAdapter = null;
  private ICloudProvider[] cpList;
  private boolean SHOW_CP_LIST = false;
  private Combo comboCPList;
  private Label label = null;
  private String currentCP;

  public InfoSystemViewOld() {
    this.cpList = getCloudProviderList();
//    this.fetchJob = FetchJob.getInstance( " Retrieving Information" ); //$NON-NLS-1$
//    // Fill in the InfoSystem info when this view is opened
//    this.fetchJob.schedule();
  }

  @Override
  public void addSelectionChangedListener( final ISelectionChangedListener listener )
  {
    this.viewer.addSelectionChangedListener( listener );
  }

  @Override
  public ISelection getSelection() {
    this.viewer.getSelection();
    return null;
  }

  @Override
  public void removeSelectionChangedListener( final ISelectionChangedListener listener )
  {
    this.viewer.removeSelectionChangedListener( listener );
  }

  @Override
  public void setSelection( ISelection selection ) {
    this.viewer.setSelection( selection );
  }

  @Override
  public void createPartControl( final Composite parent ) {
    GridLayout parentLayout = new GridLayout( 3, false );
    parentLayout.marginTop = 0;
    parentLayout.marginBottom = parentLayout.marginTop;
    parentLayout.marginLeft = parentLayout.marginTop;
    parentLayout.marginRight = parentLayout.marginTop;
    parentLayout.marginHeight = 0;
    parentLayout.marginWidth = 0;
    // parentLayout.horizontalSpacing = 0;
    // parentLayout.verticalSpacing = 0;
    parent.setLayout( parentLayout );
    GridData gData;
    if( this.SHOW_CP_LIST ) {
      this.label = new Label( parent, SWT.NONE );
      this.label.setText( "VO:" ); //$NON-NLS-1$
      gData = new GridData();
      this.label.setLayoutData( gData );
      this.comboCPList = new Combo( parent, SWT.NONE );
      gData = new GridData( GridData.FILL_HORIZONTAL );
      gData.widthHint = 150;
      gData.verticalAlignment = GridData.CENTER;
      this.comboCPList.setLayoutData( gData );
    }
    this.viewer = new TreeViewer( parent, SWT.MULTI
                                          | SWT.H_SCROLL
                                          | SWT.V_SCROLL );
    gData = new GridData( GridData.FILL_BOTH );
    gData.grabExcessHorizontalSpace = true;
    gData.grabExcessVerticalSpace = true;
    gData.horizontalSpan = 3;
    this.viewer.getTree().setLayoutData( gData );
    this.drillDownAdapter = new DrillDownAdapter( this.viewer );
    
    ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory( ComposedAdapterFactory.Descriptor.Registry.INSTANCE );
    AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider( composedAdapterFactory );
    AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider( composedAdapterFactory );
    this.viewer.setContentProvider( contentProvider );
    this.viewer.setLabelProvider( labelProvider );
    this.viewer.setInput( InfoService.getInstance().getRoot() );
        
//    this.viewer.setContentProvider( new InfoViewContentProvider() );
//    this.viewer.setLabelProvider( new InfoViewLabelProvider() );
//    // this.viewer.setSorter( new NameSorter() );
//    this.viewer.setInput( getViewInput() );
    // this.viewer.setComparer( new GlueInfoComparator() );
    // The viewerFilter that is used consists of 2 filters. One to show all or
    // only filled info
    // elements and another to show all/glite/gria elements.
    // ViewerFilter[] initialFilters = new ViewerFilter[2];
    // initialFilters[0] = new InfoViewerFilter();
    // initialFilters[1] = new InfoViewerFilter();
    // this.viewer.setFilters( initialFilters );
//    if( this.SHOW_CP_LIST ) {
//      // Label filler = new Label(parent, SWT.NONE);
//      this.comboCPList.addSelectionListener( new SelectionAdapter() {
//
//        @Override
//        public void widgetDefaultSelected( final SelectionEvent e ) {
//          updateVOList();
//        }
//
//        @SuppressWarnings("synthetic-access")
//        @Override
//        public void widgetSelected( final SelectionEvent arg0 ) {
//          setCurrentCP( InfoSystemView.this.comboCPList.getText() );
//          InfoSystemView.this.viewer.refresh();
//        }
//      } );
//    }
//    // hookContextMenu();
//    // contributeToActionBars();
//    setCurrentCP( "none" ); //$NON-NLS-1$
  }

  /**
   * @param currentVO
   */
  public void setCurrentCP( final String currentVO ) {
    this.currentCP = currentVO;
  }
  
  private Object getViewInput() {
    return CloudModel.getRoot();
  }
  
  private ICloudProvider[] getCloudProviderList() {
    ArrayList<ICloudProvider> cps = new ArrayList<ICloudProvider>();
    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
    ICloudElement[] children;
    try {
      children = cpManager.getChildren( new NullProgressMonitor() );
      for( ICloudElement cloudElement : children ) {
        if( cloudElement instanceof ICloudProvider ) {
          ICloudProvider cp = ( ICloudProvider )cloudElement;
          cps.add( cp );
        }
      }
    } catch( ProblemException e ) {
      // TODO Fix PRoblem Reporting
      e.printStackTrace();
    }
    return cps.toArray( new ICloudProvider[ cps.size() ] );
  }

  void updateVOList() {
    ArrayList<String> cps = new ArrayList<String>();
    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
    ICloudElement[] children;
    int i = 0;
    try {
      children = cpManager.getChildren( new NullProgressMonitor() );
      for( ICloudElement CloudElement : children ) {
        if( CloudElement instanceof GenericCloudProvider ) {
          GenericCloudProvider gCp = ( GenericCloudProvider )CloudElement;
          cps.add( gCp.getName() );
        }
      }
    } catch( ProblemException e ) {
      // TODO Fix PRoblem Reporting
      e.printStackTrace();
    }
    String[] cpArray = new String[ cps.size() ];
    i = 0;
    for( String voString : cps ) {
      cpArray[ i++ ] = voString;
    }
    Arrays.sort( cpArray );
    this.comboCPList.setItems( cpArray );
  }

  @Override
  public void setFocus() {
    this.viewer.getControl().setFocus();
  }

  @Override
  public void modelChanged( ICloudModelEvent event ) {
    int type = event.getType();
    switch( type ) {
      case ICloudModelEvent.ELEMENTS_ADDED:
      case ICloudModelEvent.ELEMENTS_REMOVED:
      case ICloudModelEvent.PROJECT_CLOSED:
      case ICloudModelEvent.PROJECT_OPENED:
        for( ICloudElement gridElement : event.getElements() ) {
          if( gridElement instanceof ICloudProject ) {
            FetchJob myFetchJob = FetchJob.getInstance( " Retrieving Information" ); //$NON-NLS-1$
            myFetchJob.schedule(); // Getting the information from the info
                                   // services.
            break;
          }
        }
      break;
      default:
      break;
    }
  }

  public String getCurrentCP() {
    return this.currentCP;
  }
}
