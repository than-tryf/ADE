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
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.auth.AbstractAuthTokenProvider;
import org.eclipse.camf.core.internal.model.CloudRoot;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudElementManager;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.IManageable;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.core.util.MasterMonitor;
import org.eclipse.camf.internal.model.notify.CloudModelEvent;
import org.eclipse.camf.internal.model.notify.CloudNotificationService;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import org.eclipse.camf.core.internal.Activator;


/**
 * @author Nicholas Loulloudes
 *
 */
public abstract class AbstractCloudContainer extends AbstractCloudElement implements ICloudContainer {
  
  private static class ChildFetcher extends Job {

    private final AbstractCloudContainer container;
    private IProgressMonitor externalMonitor;
    private Throwable exception;

    /**
     * true if this cancel was called for that fetcher but run() hasn't finished
     * yet
     */
    private boolean canceling;

    /**
     * Construct a new child fetcher for the specified container.
     *
     * @param container The container whose children should be fetched.
     */
    public ChildFetcher( final AbstractCloudContainer container ) {
      super( "Child Fetcher @ " + container.getName() ); //$NON-NLS-1$
      this.container = container;
    }

    /**
     * Get an exception that occurred during child fetching or <code>null</code>
     * of no such exception occurred.
     *
     * @return The exception of <code>null</code> if either the fetcher did not
     *         yet run or no exception occurred.
     */
    public Throwable getException() {
      return this.exception;
    }

    /**
     * True if this fetcher has not yet run, i.e. it is currently scheduled, or
     * if it currently runs.
     *
     * @return True if the job has not yet finished.
     */
    public boolean isFetching() {
      return getState() != NONE;
    }
    
    /**
     * Set a progress monitor that is used in the run method in parallel with
     * the monitor provided by the run method parameter.
     *
     * @param monitor The external monitor.
     */
    public void setExternalMonitor( final IProgressMonitor monitor ) {
      this.externalMonitor = monitor;
    }

    /*
     * (non-Javadoc)
     * @seeorg.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
     * IProgressMonitor)
     */
    @Override
    protected IStatus run( final IProgressMonitor monitor ) {
      IProgressMonitor mon = new MasterMonitor( monitor, this.externalMonitor );
      this.canceling = false;
      this.exception = null;
      this.container.lock();

      try {
        this.container.deleteAll();
        IStatus status = this.container.fetchChildren( mon );
        if( !status.isOK() ) {
          Throwable exc = status.getException();
          if ( ! AbstractAuthTokenProvider.isTokenRequestCanceledException( exc ) ) {
            this.exception = status.getException();
          }
        }
      } catch( Throwable t ) {
        this.exception = t;
      } finally {
        if( !this.canceling ) {
          this.container.setDirty( false );
        }
        this.container.unlock();
        this.canceling = false;
      }
      return Status.OK_STATUS;
    }

    @Override
    protected void canceling() {
      this.canceling = true;
      super.canceling();
    }

    public boolean isCanceling() {
      return this.canceling;
    }
  }
  
  /**
   * List of currently know children.
   */
  private final List<ICloudElement> children = new ArrayList<ICloudElement>();

  /**
   * Dirty flag of this container.
   */
  private boolean dirty;

  /**
   * Job used internally for fetching the containers children.
   */
  private ChildFetcher fetcher;

  protected AbstractCloudContainer() {
    setDirty();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#canContain(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return false;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#contains(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean contains( final ICloudElement element ) {
    return this.children.contains( element  );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#create(org.eclipse.camf.core.model.ICloudElementCreator)
   */
  @Override
  public ICloudElement create( final ICloudElementCreator creator )
      throws ProblemException {
    ICloudElement element = creator.create( this );
    element = addElement( element );
    return element;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#delete(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public void delete( final ICloudElement child )
      throws ProblemException {
    removeElement( child );
    unregisterFromManager( child );
    child.dispose();
  }
  
  /**
   * Remove all children from this container and call their
   * {@link #dispose()} methods.
   */
  public void deleteAll() {
    if ( this.children != null && !this.children.isEmpty() ) {
      for ( ICloudElement child : this.children ) {
        unregisterFromManager( child );
        child.dispose();
      }
      ICloudElement[] elements
        = this.children.toArray( new ICloudElement[ this.children.size() ] );
      fireCloudModelEvent( ICloudModelEvent.ELEMENTS_REMOVED, elements );
      this.children.clear();
    }
  }
  
  private void unregisterFromManager( final ICloudElement child ) {
    if ( child instanceof IManageable ) {
      ICloudElementManager manager
        = ( ( IManageable ) child ).getManager();
      manager.removeElement( child );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#dispose()
   */
  @Override
  public void dispose() {
    deleteAll();
    super.dispose();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#getChildCount()
   */
  @Override
  public int getChildCount() {
    int result;
    if ( isLazy() && isDirty() ) {
      result = 1;
    } else {
      result = this.children.size();
    }
    return result;
  }
  
  
  public ICloudElement[] getChildren( final IProgressMonitor monitor )
      throws ProblemException {
    if ( isLazy() && isDirty() ) {
      try {
        startFetch( monitor );
      } catch ( Throwable t ) {
        if ( t instanceof ProblemException ) {
          throw ( ProblemException ) t;
        }
        throw new ProblemException( ICoreProblems.MODEL_FETCH_CHILDREN_FAILED, t, Activator.PLUGIN_ID );
      }
    }
    return this.children.toArray( new ICloudElement[ this.children.size() ] );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#hasChildren()
   */
  @Override
  public boolean hasChildren() {
    return isLazy() || !this.children.isEmpty();
  }
  
  public ICloudElement findChild( final String name ) {
    ICloudElement result = null;
    for ( ICloudElement child : this.children ) {
      if ( child.getName().equals( name ) ) {
        result = child;
        break;
      }
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#findChildWithResource(java.lang.String)
   */
  @Override
  public ICloudElement findChildWithResource( final String resourceName ) {
    ICloudElement result = null;
    for ( ICloudElement child : this.children ) {
      if ( !child.isVirtual() ) {
        if ( child.getResource().getName().equals( resourceName ) ) {
          result = child;
          break;
        }
      }
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#refresh(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void refresh( final IProgressMonitor monitor ) throws ProblemException {
    if ( ! isVirtual() ) {
      IContainer container = ( IContainer ) getResource();
      try {
        lock();
        container.refreshLocal( IResource.DEPTH_INFINITE, monitor );
      } catch( CoreException cExc ) {
        throw new ProblemException( ICoreProblems.MODEL_REFRESH_FAILED,
            cExc,
            Activator.PLUGIN_ID );
      } finally {
        unlock();
      }
    }

    else {
      setDirty();
      try {
        startFetch( monitor );
      } catch ( Throwable t ) {
        if ( t instanceof ProblemException ) {
          throw ( ProblemException ) t;
        }
        throw new ProblemException( ICoreProblems.MODEL_REFRESH_FAILED,
            t,
            Activator.PLUGIN_ID );
      }
    }

  }
  
  protected ICloudElement addElement( final ICloudElement element ) throws ProblemException {
    if ( element != null ) {
      testCanContain( element );
      ICloudElement oldChild = findChild( element.getName() );
      if ( oldChild != null ) {
        delete( oldChild );
      }
      this.children.add( element );
      CloudRoot.registerElement( element );
      fireCloudModelEvent( ICloudModelEvent.ELEMENTS_ADDED, element );

      if ( isLazy() && ! ( element instanceof ContainerMarker ) ) {
        for ( ICloudElement child : this.children ) {
          if ( child instanceof ContainerMarker ) {
            removeElement( child );
            break;
          }
        }
      }

    }

    return element;

  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#setDirty()
   */
  @Override
  public void setDirty() {
    setDirty( true );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#isDirty()
   */
  @Override
  public boolean isDirty() {
    return this.dirty;
  }
  
  protected IStatus fetchChildren( final IProgressMonitor monitor )
      throws ProblemException {
    return Status.OK_STATUS;
  }

  protected void removeElement( final ICloudElement element )
      throws ProblemException {
    boolean result = this.children.remove( element );
    if ( result ) {
      fireCloudModelEvent( ICloudModelEvent.ELEMENTS_REMOVED, element );
      if ( this.children.isEmpty() && isLazy() && ! ( element instanceof ContainerMarker ) ) {
        ContainerMarker marker = ContainerMarker.getEmptyFolderMarker( this );
        if ( canContain( marker ) ) {
          addElement( marker );
        }
      }
    }
  }
  
  protected void setDirty( final boolean d ) {
    this.dirty = d;
    if ( d ) {
      if ( this.fetcher != null && this.fetcher.isFetching() ) {
        this.fetcher.cancel();
      }
      List< ICloudElement > synchronizedList = Collections.synchronizedList( this.children );
      synchronized ( synchronizedList ) {
        for ( ICloudElement child : synchronizedList ) {
          if ( child instanceof ICloudContainer ) {
            ( ( ICloudContainer ) child ).setDirty();
          }
        }
      }
    }
  }

  protected void lock() {
    getCloudNotificationService().lock( this );
  }

  protected void unlock() {
    getCloudNotificationService().unlock( this );
  }
  
  protected void fireCloudModelEvent( final int type, final ICloudElement element ){
    fireCloudModelEvent( type, new ICloudElement[]{ element  } );
  }

  protected void fireCloudModelEvent( final int type, final ICloudElement[] elements ) {
    if( elements != null && elements.length > 0 ) {
      ICloudModelEvent event = new CloudModelEvent( type, this, elements );
      getCloudNotificationService().queueEvent( event );
    }
  }
  
  static private CloudNotificationService getCloudNotificationService() {
    return CloudNotificationService.getInstance();
  }

  static protected void staticAddCloudModelListener( final ICloudModelListener listener ) {
    getCloudNotificationService().addListener( listener );
  }
  
  private void startFetch( final IProgressMonitor monitor ) throws Throwable {
    if ( this.fetcher == null ) {
      this.fetcher = new ChildFetcher( this );
    }

    this.fetcher.setExternalMonitor( monitor );

    // if canceling, then schedule again (don't wait for finish cancellation - scheduler start job again).
    if ( ! this.fetcher.isFetching()
        || this.fetcher.isCanceling() ) {
      this.fetcher.schedule();
    }

    try {
      this.fetcher.join();
    } catch ( InterruptedException intExc ) {
      // Silently ignored
    }

    Throwable exc = this.fetcher.getException();

    if ( exc != null ) {
      throw exc;
    }
  }
  
  private void testCanContain( final ICloudElement element )
      throws ProblemException {
    if ( ! canContain( element ) ) {
      throw new ProblemException( ICoreProblems.MODEL_CONTAINER_CAN_NOT_CONTAIN,
          String.format(
              Messages.getString("AbstractCloudContainer.can_not_contain_error"), //$NON-NLS-1$
              getClass().getName(), element.getClass().getName() ),
          Activator.PLUGIN_ID );
    }
  }
  
  protected List<ICloudElement> getCachedChildren() {
    return this.children;
  }

}


