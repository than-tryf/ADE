/**
 * 
 */
package org.eclipse.camf.infosystem.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.ui.internal.Activator;
import org.eclipse.camf.ui.dialogs.ProblemDialog;
import org.eclipse.camf.ui.providers.CloudModelComparator;
import org.eclipse.camf.ui.providers.FetchChildrenJob;
import org.eclipse.camf.ui.providers.Messages;
import org.eclipse.camf.ui.providers.ProgressTreeNode;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;


/**
 * @author nickl
 *
 */
public class InfoViewContentProvider
  implements IStructuredContentProvider, ITreeContentProvider, ITreeViewerListener
{
  /**
   * The associated tree viewer.
   */
  protected TreeViewer treeViewer;
  
  private Hashtable< ICloudContainer, ProgressTreeNode > progressNodes = new Hashtable< ICloudContainer, ProgressTreeNode >();
  /**
   * The comparator used for sorting the children of a node.
   */
  private CloudModelComparator comparator = new CloudModelComparator();

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#dispose()
   */
  @Override
  public void dispose() {
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  @Override
  public void inputChanged( final Viewer viewer, final Object oldInput, final Object newInput ) {
    if ( viewer instanceof TreeViewer ) {
      treeViewerChanged( this.treeViewer, ( TreeViewer ) viewer );
    }
  }
  
  /**
   * Called when a new tree viewer was set and/or an old viewer
   * was unset.
   * 
   * @param oldViewer The old viewer.
   * @param newViewer The new viewer.
   */
  protected void treeViewerChanged( final TreeViewer oldViewer,
                                    final TreeViewer newViewer ) {
    if ( oldViewer != newViewer ) {
      this.treeViewer = newViewer;
      if ( oldViewer != null ) {
        oldViewer.removeTreeListener( this );
      }
      if ( newViewer != null ) {
        newViewer.addTreeListener( this );
      }
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
   */
  @Override
  public Object[] getChildren( final Object parentElement ) {
    Object[] children = null;
    if ( hasChildren( parentElement ) ) {
      children = getChildren( ( ICloudContainer ) parentElement );
    }
    if ( children != null ) {
      Arrays.sort( children, this.comparator );
    }
    return children;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
   */
  @Override
  public Object getParent( final Object element ) {
    Object parent = null;
    if ( element instanceof ICloudElement ) {
      parent = ( ( ICloudElement ) element ).getParent();
    }
    return parent;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
   */
  @Override
  public boolean hasChildren( final Object element ) {
    boolean result = false;
    if ( element instanceof ICloudContainer ) {
      result = ( ( ICloudContainer ) element ).hasChildren();
    }
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
   */
  @Override
  public Object[] getElements( final Object inputElement ) {
    Object[] elements = getChildren( inputElement );
    if ( elements == null ) {
      elements = new Object[0];
    }
    return elements;
  }
  
  /**
   * Get the children of the specified container. If the container
   * is lazy and dirty the returned array will contain only one
   * element, i.e. a {@link ProgressRunner} that is used to monitor
   * the progress of the children fetching operation that will
   * be started immediately by this method.
   * 
   * @param container The container from which to fetch the children.
   * @return An array containing either the list of children or a
   * {@link ProgressRunner} object.
   */
  protected Object[] getChildren( final ICloudContainer container ) {
    
    Object[] children = null;
    
    if ( container.isLazy() && container.isDirty() ) {
      
      ProgressTreeNode monitor = this.progressNodes.get( container );
      
      if ( monitor == null ) {
      
        FetchChildrenJob fetcher = new FetchChildrenJob( container, this.treeViewer.getControl().getShell() );
        monitor = new ProgressTreeNode( this.treeViewer );
        this.progressNodes.put( container, monitor );
        fetcher.setExternalMonitor( monitor );
        fetcher.setSystem( true );
        fetcher.schedule();
        
      }
      
      children = new Object[] { monitor };
      
    } else {
      
      this.progressNodes.remove( container );
      
      try {
        ICloudElement[] childElements = container.getChildren( null );
        List< ICloudElement > visibleChildren = new ArrayList< ICloudElement >();
        for ( ICloudElement child : childElements ) {
          if( !child.isHidden() ) {
            System.out.println(child.getName() + " Local: " + child.isLocal() + " - Virtual: " + child.isVirtual()) ;
            visibleChildren.add( child );
          }
        }
        children = visibleChildren.toArray( new ICloudElement[ visibleChildren.size() ] );
      } catch ( ProblemException pExc ) {
        if ( this.treeViewer != null ) {
          Shell shell = this.treeViewer.getControl().getShell();
          ProblemDialog.openProblem( shell,
                                     Messages.getString("CloudModelContentProvider.problem_title"), //$NON-NLS-1$
                                     Messages.getString("CloudModelContentProvider.problem_text") + container.getName(), //$NON-NLS-1$
                                     pExc );
        } else {
          Activator.logException( pExc );
        }
      }
      
    }
    
    return children;
    
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeViewerListener#treeCollapsed(org.eclipse.jface.viewers.TreeExpansionEvent)
   */
  public void treeCollapsed( final TreeExpansionEvent event ) {
    Object element = event.getElement();
    if ( ( element instanceof ICloudContainer ) && ( ( ICloudContainer ) element ).isLazy() ) {
      ICloudContainer container = ( ICloudContainer ) element;
      this.progressNodes.remove( container );
      container.setDirty();
      try {
        container.deleteAll();
      } catch( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITreeViewerListener#treeExpanded(org.eclipse.jface.viewers.TreeExpansionEvent)
   */
  public void treeExpanded( final TreeExpansionEvent event ) {
    // empty implementation
  }


}
