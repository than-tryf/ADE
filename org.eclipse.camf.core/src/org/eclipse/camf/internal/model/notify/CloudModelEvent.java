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
package org.eclipse.camf.internal.model.notify;

import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudModelEvent;
import org.eclipse.core.runtime.Assert;


/**
 * Implementation of the {@link ICloudModelEvent} interface. Grid model events
 * are used to track changes in the Grid model.
 */
public class CloudModelEvent implements ICloudModelEvent {
  
  /**
  * The type of the event.
  */
 private int type;
 
 /**
  * The source where the event occurred.
  */
 private ICloudElement source;
 
 /**
  * The elements that are affected by this event.
  */
 private ICloudElement[] elements;
 
 /**
  * Construct a new Cloud model event.
  * 
  * @param type The type of this event. This may be one of
  * {@link ICloudModelEvent#ELEMENTS_ADDED} and
  * {@link ICloudModelEvent#ELEMENTS_REMOVED}.
  * @param source The element where the event occurred.
  * @param elements The elements that are affected by this event.
  */
 public CloudModelEvent( final int type,
                        final ICloudElement source,
                        final ICloudElement[] elements ) {
   
   Assert.isNotNull( source );
   
   this.type = type;
   this.source = source;
   this.elements = null;
   if ( elements != null ) {
     int length = elements.length;
     this.elements = new ICloudElement[ length ];
     System.arraycopy( elements, 0, this.elements, 0, length );
   }
   
 }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelEvent#getElements()
   */
  @Override
  public ICloudElement[] getElements() {
    return this.elements;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelEvent#getSource()
   */
  @Override
  public ICloudElement getSource() {
    return this.source;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudModelEvent#getType()
   */
  @Override
  public int getType() {
    return this.type;
  }
  
  @Override
  public String toString() {
    
    StringBuffer buffer = new StringBuffer( "CloudModelEvent("); //$NON-NLS-1$
    
    switch ( this.type ) {
    
      case ICloudModelEvent.ELEMENTS_ADDED:
        buffer.append( "ELEMENTS_ADDED, " ); //$NON-NLS-1$
        break;
        
      case ICloudModelEvent.ELEMENTS_REMOVED:
        buffer.append( "ELEMENTS_REMOVED, " ); //$NON-NLS-1$
        break;
        
      case ICloudModelEvent.ELEMENTS_CHANGED:
        buffer.append( "ELEMENTS_CHANGED, " ); //$NON-NLS-1$
        break;
        
      case ICloudModelEvent.PROJECT_CLOSED:
        buffer.append( "PROJECT_CLOSED, " ); //$NON-NLS-1$
        break;
        
      case ICloudModelEvent.PROJECT_FOLDER_CHANGED:
        buffer.append( "PROJECT_FOLDER_CHANGES, " ); //$NON-NLS-1$
        break;
        
      case ICloudModelEvent.PROJECT_OPENED:
        buffer.append( "PROJECT_OPENED, " ); //$NON-NLS-1$
        break;
        
      default:
        buffer.append( "INVALID, " ); //$NON-NLS-1$
        break;
      
    }
    
    if ( this.source != null ) {
      buffer.append( this.source.getName() + ", " ); //$NON-NLS-1$
    } else {
      buffer.append( "null, " ); //$NON-NLS-1$
    }
    
    if ( this.elements != null ) {
      buffer.append( "{" ); //$NON-NLS-1$
      for ( int i = 0 ; i < this.elements.length ; i++ ) {
        if ( i > 0 ) {
          buffer.append( ", " ); //$NON-NLS-1$
        }
        if ( this.elements[ i ] != null ) {
          buffer.append( this.elements[ i ].getName() );
        } else {
          buffer.append( "null" ); //$NON-NLS-1$
        }
      }
      buffer.append( "}" ); //$NON-NLS-1$
    } else {
      buffer.append( "null" ); //$NON-NLS-1$
    }
    
    buffer.append( ")" ); //$NON-NLS-1$
    
    return buffer.toString();
    
  }
}
