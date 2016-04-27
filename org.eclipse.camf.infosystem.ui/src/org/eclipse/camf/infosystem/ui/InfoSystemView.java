package org.eclipse.camf.infosystem.ui;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudProviderProperties;
import org.eclipse.camf.infosystem.InfoService;
import org.eclipse.camf.infosystem.jobs.FetchJob;
import org.eclipse.camf.infosystem.model.base.Root;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;


public class InfoSystemView extends ViewPart implements ISelectionProvider, ICloudModelListener {
  
  private TreeViewer treeViewer;
  private ComposedAdapterFactory composedAdapterFactory;
  private AdapterFactoryLabelProvider adapterFactoryLabelProvider;
  private AdapterFactoryContentProvider adapterFactoryContentProvider;


   
  public InfoSystemView() {
    CloudModel.getRoot().addCloudModelListener( InfoSystemView.this );
  }
  
  @Override
  public void addSelectionChangedListener( ISelectionChangedListener listener )
  {
    this.treeViewer.addSelectionChangedListener( listener );
  }

  @Override
  public ISelection getSelection() {
    return this.treeViewer.getSelection();
  }

  @Override
  public void removeSelectionChangedListener( ISelectionChangedListener listener )
  {
    this.treeViewer.removeSelectionChangedListener( listener );    
  }

  @Override
  public void setSelection( ISelection selection ) {
    this.treeViewer.setSelection( selection );    
  }

  @Override
  public void createPartControl( Composite parent ) {
    
    /* Create a grid layout object so the text and treeviewer
     * are layed out the way I want. */
    GridLayout layout = new GridLayout();
    layout.numColumns = 1;
    layout.verticalSpacing = 2;
    layout.marginWidth = 0;
    layout.marginHeight = 2;
    parent.setLayout(layout);
    
    /* Create a "label" to display information in. I'm
     * using a text field instead of a lable so you can
     * copy-paste out of it. */
    Text text = new Text(parent, SWT.READ_ONLY | SWT.SINGLE | SWT.BORDER);
    // layout the text field above the treeviewer
    GridData layoutData = new GridData();
    layoutData.grabExcessHorizontalSpace = true;
    layoutData.horizontalAlignment = GridData.FILL;
    text.setLayoutData(layoutData);
    
    
    treeViewer = new TreeViewer( parent, SWT.MULTI
                                  | SWT.H_SCROLL
                                  | SWT.V_SCROLL );    
    
 // layout the tree viewer below the text field
    layoutData = new GridData();
    layoutData.grabExcessHorizontalSpace = true;
    layoutData.grabExcessVerticalSpace = true;
    layoutData.horizontalAlignment = GridData.FILL;
    layoutData.verticalAlignment = GridData.FILL;
    treeViewer.getControl().setLayoutData(layoutData);
    
    adapterFactoryLabelProvider = new AdapterFactoryLabelProvider( getAdapterFactory() );
    treeViewer.setLabelProvider( adapterFactoryLabelProvider );
    adapterFactoryContentProvider = new AdapterFactoryContentProvider( getAdapterFactory() );
    treeViewer.setContentProvider( adapterFactoryContentProvider );
        
    treeViewer.setInput( getInfoRoot() );
    
    // add drag support
    int ops = DND.DROP_COPY | DND.DROP_MOVE;
    treeViewer.addDragSupport(ops, new Transfer[] { LocalSelectionTransfer.getTransfer() },
                              new DragSourceAdapter() {

      @Override
      public void dragStart(DragSourceEvent event) {
    	 System.out.println("Dragging from CAMF Tree");
          LocalSelectionTransfer.getTransfer().setSelection(InfoSystemView.this.treeViewer.getSelection());
      }

  });
  }
  @Override
  public void setFocus() {
    treeViewer.getControl().setFocus();
  }
  
  
  
  protected Root getInfoRoot(){
    Root root = InfoService.getInstance().getRoot(); 
    return root;
  }
  
  protected AdapterFactory getAdapterFactory() {
    if (composedAdapterFactory == null) {
        composedAdapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
    }
    return composedAdapterFactory;
}

  @Override
  public void modelChanged( ICloudModelEvent event ) {
    int type = event.getType();    
    switch ( type ) {
      case ICloudModelEvent.ELEMENTS_ADDED:
      case ICloudModelEvent.ELEMENTS_REMOVED:
      case ICloudModelEvent.PROJECT_CLOSED:
      case ICloudModelEvent.PROJECT_OPENED:

        for ( ICloudElement cloudElement : event.getElements() ) {

          if ( (cloudElement instanceof ICloudProject) || (cloudElement instanceof ICloudProviderProperties)){
            FetchJob myFetchJob = FetchJob.getInstance(" Retrieving Information"); //$NON-NLS-1$
            myFetchJob.schedule(); // Getting the information from the info services.
            break;
          }
        }
        break;
      default:
        break;
    }
  }    
}