/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
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
package org.eclipse.camf.internal.model.notify;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.camf.core.model.ICloudModelListener;
import org.eclipse.core.runtime.Assert;


/**
 * The <code>NotificationService</code> is the central point that
 * manages all event notifications from the Cloud model to the
 * outside world. It collects and merges events according to their
 * source. If there is no lock for the source the events are delivered
 * immediately. Otherwise the events are collected until the lock for
 * the owner is released. 
 */
public class CloudNotificationService {
  
private static CloudNotificationService instance;
  
  /**
   * List containing all registered listeners.
   */
  private List< ICloudModelListener > listeners
    = new ArrayList< ICloudModelListener >();
  
  /**
   * List containing all pending events.
   */
  private List< ICloudModelEvent > eventList
    = new ArrayList< ICloudModelEvent >();

  /**
   * Counter for all applied locks.
   */
  private Hashtable< ICloudElement, Integer > locks;
  
  /**
   * Private constructor.
   */
  private CloudNotificationService() {
    this.locks = new Hashtable< ICloudElement, Integer >();
  }
  
  /**
   * Get the singleton service instance.
   * 
   * @return The singleton instance.
   */
  public static CloudNotificationService getInstance() {
    
    if ( instance == null ) {
      instance = new CloudNotificationService();
    }
    
    return instance;
    
  }
  
  /**
   * Add a {@link ICloudModelListener} to the service. The listener will be
   * informed about all events.
   * 
   * @param listener The listener to be added.
   */
  public void addListener( final ICloudModelListener listener ) {
    synchronized ( this.listeners ) {
      if ( ! this.listeners.contains( listener ) ) {
        this.listeners.add( listener );
      }
    }
  }
  
  /**
   * Locks the notification service for a specific owner. A locked service will
   * collect all events having the owner as the events source without delivering
   * them to the listeners unless it is unlocked by this owner again.
   * For each lock an unlock has to be called. An internal counter in incremented
   * when {@link #lock(ICloudElement)} is called and decremented again when
   * {@link #unlock(ICloudElement)} is called. So only if all locks for a specific
   * owner are unlocked again the pending events will be delivered.
   * 
   * @param owner The owner of the lock.
   * @see #unlock(ICloudElement)
   */
  public void lock( final ICloudElement owner ) {
    
    Assert.isNotNull( owner );
    
    Integer counter = this.locks.get( owner );
    
    if ( counter == null ) {
      counter = Integer.valueOf( 1 );
    } else {
      counter = Integer.valueOf( counter.intValue() + 1 );
    }
    
    this.locks.put( owner, counter );
    
  }
  
  /**
   * Add an event to this service's event queue. If the service is not locked
   * the event is delivered immediately, otherwise it is stored until the
   * service is unlocked again.
   * 
   * @param event The event to be queued.
   */
  public void queueEvent( final ICloudModelEvent event ) {
    incorporateEvent( event );
    processEvents( event.getSource() );
  }
  
  /**
   * Remove the specified listener from the list of listeners. The listener
   * will not retrieve any further notifications.
   * 
   * @param listener The listener to be removed.
   */
  public void removeListener( final ICloudModelListener listener ) {
    synchronized ( this.listeners ) {
      this.listeners.remove( listener );
    }
  }
  
  /**
   * Unlock the service for the specified owner. If the lock counter
   * for the owner is equal or less than 0 all pending events are
   * delivered.
   * 
   * @param owner The owner of the lock.
   * @see #lock(ICloudElement)
   */
  public void unlock( final ICloudElement owner ) {
    
    Assert.isNotNull( owner );
    
    Integer counter = this.locks.get( owner );
    
    if ( counter != null ) {
      counter = Integer.valueOf( counter.intValue() - 1 );
    } else {
      counter = Integer.valueOf( 0 );
    }
    
    if ( counter.intValue() <= 0 ) {
      this.locks.remove( owner );
    } else {
      this.locks.put( owner, counter );
    }
    
    processEvents( owner );
    
  }
  
  /**
   * Try to merge the specified event with an event in the event queue.
   * Events with the same type and the same source are merged in order
   * to optimize the event notification.
   * 
   * @param event The event to be incorporated.
   */
  private void incorporateEvent( final ICloudModelEvent event ) {
    
    ICloudElement source = event.getSource();
    int type = event.getType();
    
    synchronized ( this.eventList ) {
      
      int index = 0;
      ICloudModelEvent oldEvent = null;
      
      // Test if the event list already contains an event from the source
      // and of the specified type
      for ( ; index < this.eventList.size() ; index++ ) {
        oldEvent = this.eventList.get( index );
        if ( ( source == oldEvent.getSource() ) && ( type == oldEvent.getType() ) ) {
          break;
        }
      }
      
      // If an event was found merge the two events
      if ( ( index < this.eventList.size() ) && ( oldEvent != null ) ) {
        
        ICloudElement[] elements = event.getElements();
        ICloudElement[] oldElements = oldEvent.getElements();
        List< ICloudElement > newElementList = new ArrayList< ICloudElement >();
        
        for ( ICloudElement e : oldElements ) {
          newElementList.add( e );
        }
        
        for ( ICloudElement e : elements ) {
          if ( ! newElementList.contains( e ) ) {
            newElementList.add( e );
          }
        }
        
        ICloudElement[] newElements = newElementList.toArray( new ICloudElement[ newElementList.size() ] );
        ICloudModelEvent newEvent = new CloudModelEvent( type, source, newElements );
        this.eventList.remove( index );
        this.eventList.add( index, newEvent );
        
      } else {
        this.eventList.add( event );
      }
      
    }
    
  }
  
  /**
   * Process all pending events. Tests if the service is locked. If the
   * service is not locked all pending events are delivered to the registered
   * listeners.
   */
  private void processEvents( final ICloudElement owner ) {
    
    Assert.isNotNull( owner );
    
    Integer counter = this.locks.get( owner );
    
    if ( ( counter == null ) || ( counter.intValue() <= 0 ) ) {
      
      List< ICloudModelEvent > localCopy = new ArrayList< ICloudModelEvent >();
    
      synchronized ( this.eventList ) {
        
        for ( ICloudModelEvent event : this.eventList ) {
          if ( ( owner == null ) || ( event.getSource() == owner ) ) {
            localCopy.add( event );
          }
        }
        
        for ( ICloudModelEvent event : localCopy ) {
          this.eventList.remove( event );
        }
        
      }
        
      for ( ICloudModelEvent event : localCopy ) {
        synchronized ( this.listeners ) {
          for ( ICloudModelListener listener : this.listeners ) {
            listener.modelChanged( event );
          }
        }
      }
      
    }
    
  }
}
