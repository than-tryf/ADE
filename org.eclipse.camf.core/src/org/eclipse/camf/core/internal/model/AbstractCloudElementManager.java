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
 *    Ariel Garcia      - updated to new problem reporting
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.internal.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudElementManager;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.internal.model.notify.CloudModelEvent;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.camf.core.internal.Activator;


/**
 * Internal abstract implementation of an {@link ICloudElementManager}.  
 */
public abstract class AbstractCloudElementManager extends AbstractCloudElement
  implements ICloudElementManager
{

  /**
   * The internal element table that holds the managed elements.
   */
  private Hashtable< IPath, ICloudElement > elements
    = new Hashtable< IPath, ICloudElement >();
  
  /**
   * The list of {@link ICloudModelListener}s.
   */
  private List< ICloudModelListener > listeners
    = new ArrayList< ICloudModelListener >();
  
  /**
   * Standard constructor.
   */
  protected AbstractCloudElementManager() {
    super();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelNotifier#addCloudModelListener(org.eclipse.camf.core.model.ICloudModelListener)
   */
  @Override
  public void addCloudModelListener( final ICloudModelListener listener ) {
    if ( !this.listeners.contains( listener ) ) {
      this.listeners.add( listener );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#canContain(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean canContain( final ICloudElement element ) {
    return canManage( element );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#contains(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean contains( final ICloudElement element ) {
    return this.elements.values().contains( element );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#create(org.eclipse.camf.core.model.ICloudElementCreator)
   */
  @Override
  public ICloudElement create( final ICloudElementCreator creator ) throws ProblemException {
    ICloudElement newElement = creator.create( this );
    if ( newElement != null ) {
      addElement( newElement );
    }
    return newElement;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#delete(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public void delete( final ICloudElement child ) {
    if ( removeElement( child ) ) {
      child.dispose();
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#deleteAll()
   */
  @Override
  public void deleteAll() {
    if ( ( this.elements != null ) && !this.elements.isEmpty() ) {
      Collection< ICloudElement > values = this.elements.values();
      for ( ICloudElement element : values ) {
        element.dispose();
      }
      ICloudElement[] elementArray
        = values.toArray( new ICloudElement[ this.elements.size() ] );
      fireCloudModelEvent( ICloudModelEvent.ELEMENTS_REMOVED, elementArray );
      this.elements.clear();
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#findChild(java.lang.String)
   */
  @Override
  public ICloudElement findChild( final String name ) {
    ICloudElement result = null;
    for ( ICloudElement element : this.elements.values() ) {
      if ( element.getName().equals( name ) ) {
        result = element;
        break;
      }
    } 
    return result;
  }
  
  /**
   * Try to find the element with the specified path.
   * 
   * @param path The path of the element.
   * @return The element matching the specified path or
   * <code>null</code> if no such element could be found.
   */
  public ICloudElement findChild( final IPath path ) {
    return this.elements.get( path );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#findChildWithResource(java.lang.String)
   */
  @Override
  public ICloudElement findChildWithResource( final String resourceName ) {
    ICloudElement result = null;
    for ( ICloudElement element : this.elements.values() ) {
      IResource resource = element.getResource();
      if ( resource != null ) {
        if ( resource.getName().equals( resourceName ) ) {
          result = element;
          break;
        }
      } 
    }
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#getChildCount()
   */
  @Override
  public int getChildCount() {
    return this.elements.size();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#getChildren()
   */
  @Override
  public ICloudElement[] getChildren( final IProgressMonitor monitor ) {
    Collection< ICloudElement > values = this.elements.values();
    return values.toArray( new ICloudElement[ values.size() ] );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#hasChildren()
   */
  @Override
  public boolean hasChildren() {
    return !this.elements.isEmpty();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#isDirty()
   */
  @Override
  public boolean isDirty() {
    return false;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    IFileStore managerStore = getManagerStore();
    IFileStore childStore = managerStore.getChild( getName() );
    IFileInfo childInfo = childStore.fetchInfo();
    if ( !childInfo.exists() ) {
      try {
        childStore.mkdir( EFS.NONE, null );
      } catch( CoreException cExc ) {
        Activator.logException( cExc );
      }
    }
    return childStore;
  }
  
  /**
   * Get the {@link IFileStore} were managers store their data.
   * 
   * @return The file store were all managers should save their
   * data to.
   */
  public static IFileStore getManagerStore() {
    Activator activator = Activator.getDefault();
    IPath statePath = null;
    if (activator!=null){
      statePath=activator.getStateLocation();
    }
    return EFS.getLocalFileSystem().getStore( statePath );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return CloudModel.getRoot();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IPath rootPath = root.getFullPath();
    return rootPath.append( getName() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#getProject()
   */
  @Override
  public ICloudProject getProject() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#isLazy()
   */
  @Override
  public boolean isLazy() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.impl.AbstractCloudElement#getAdapter(java.lang.Class)
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object getAdapter( final Class adapter ) {
    return null;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#refresh(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void refresh( final IProgressMonitor monitor ) {
    // empty implementation
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelNotifier#removeCloudModelListener(org.eclipse.camf.core.model.ICloudModelListener)
   */
  @Override
  public void removeCloudModelListener( final ICloudModelListener listener ) {
    this.listeners.remove( listener );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#setDirty()
   */
  @Override
  public void setDirty() {
    // empty implementation
  }
  
  /**
   * Add the specified element to the managed elements of this manager.
   * If an old element with the same name exists this old element will
   * be deleted before the new one is added.
   * 
   * @param element The element to be added.
   * @return True if the operation was successful. 
   * @throws ProblemException If an error occurs.
   */
  @Override
  public boolean addElement( final ICloudElement element ) throws ProblemException {
    boolean result = false;
    testCanManage( element );
    IPath path = element.getPath();
    ICloudElement oldElement = findChild( path );
    if ( element != oldElement ) {
      if ( oldElement != null ) {
        delete( oldElement );
      }
      this.elements.put( path, element );
      ICloudModelEvent event
        = new CloudModelEvent( ICloudModelEvent.ELEMENTS_ADDED,
                              this,
                              new ICloudElement[] { element } );
      fireCloudModelEvent( event );
      result = true;
    }
    return result;
  }
  
  /**
   * Remove the specified element from this manager.
   * 
   * @param element The element to be removed.
   * @return True if the element was found and could be removed.
   */
  @Override
  public boolean removeElement( final ICloudElement element ) {
    IPath path = element.getPath();
    boolean removed = ( this.elements.remove( path ) != null);
    if ( removed ) {
      ICloudModelEvent event
        = new CloudModelEvent( ICloudModelEvent.ELEMENTS_REMOVED,
                              this,
                              new ICloudElement[] { element } );
      fireCloudModelEvent( event );
    }
    return removed;
  }
  
  /**
   * Issue a new {@link CloudModelEvent} of the specified type for the specified
   * elements and distribute it to all registered listener.
   * 
   * @param type The event's type.
   * @param elementArray The elements.
   * @see #fireCloudModelEvent(ICloudModelEvent)
   */
  protected void fireCloudModelEvent( final int type,
                                     final ICloudElement[] elementArray ) {
    if ( ( elementArray != null ) && ( elementArray.length > 0 ) ) {
      ICloudModelEvent event = new CloudModelEvent( type, this, elementArray );
      fireCloudModelEvent( event );
    }
  }
  
  /**
   * Distribute the specified event to all registered
   * {@link ICloudModelListener}s.
   * 
   * @param event The event to be distributed.
   */
  protected void fireCloudModelEvent( final ICloudModelEvent event ) {
    for ( ICloudModelListener listener : this.listeners ) {
      listener.modelChanged( event );
    }
  }
  
  /**
   * Test if the specified element can be managed by this manager.
   * Throw an exception if this is not the case.
   * 
   * @param element The element to be tested.
   * @throws ProblemException If the tested element can not be
   * managed by this manager.
   */
  protected void testCanManage( final ICloudElement element ) throws ProblemException {
    if ( ! canManage( element ) ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_NOT_MANAGEABLE,
                                  Activator.PLUGIN_ID );
    }
  }
}
