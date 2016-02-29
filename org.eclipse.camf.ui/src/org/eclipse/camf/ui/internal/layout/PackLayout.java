/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *****************************************************************************/

package org.eclipse.camf.ui.internal.layout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Scrollable;


/**
 * @author Nicholas Loulloudes
 *
 */
public class PackLayout extends Layout {

  private int type;
  
  private int marginWidth;
  
  private int marginHeight;
  
  private int spacing;
  
  public PackLayout() {
    this( SWT.HORIZONTAL );
  }
  
  public PackLayout( final int type ) {
    this.setType( type );
    this.setMarginWidth( 0 );
    this.setMarginHeight( 0 );
    this.setSpacing( 0 );
  }

  @Override
  protected Point computeSize( final Composite composite,
                               final int wHint,
                               final int hHint,
                               final boolean flushCache ) {

    Control[] children = composite.getChildren();
    
    int width = 0;
    int height = 0;
    
    if ( children != null ) {
      
      for ( Control child : children ) {
        Point size = computeChildSize( child, wHint, hHint, flushCache );
        if ( this.getType() == SWT.VERTICAL ) {
          width = Math.max( size.x, width );
          height += size.y;
        } else {
          width += size.x;
          height = Math.max( size.y, height );
        }
      }
      
      if ( children.length > 1 ) {
        if ( this.getType() == SWT.VERTICAL ) {
          height += ( children.length - 1 ) * this.getSpacing();
        } else {
          width += ( children.length -1 ) * this.getSpacing();
        }
      }
        
    }
    
    width += 2 * this.getMarginWidth();
    height += 2 * this.getMarginHeight();
    
    return new Point( width, height );
    
  }
  
  @Override
  protected boolean flushCache ( final Control control ) {
    Object data = control.getLayoutData();
    if ( data != null ) ( ( PackData ) data ).flushCache();
    return true;
  }

  @Override
  protected void layout( final Composite composite,
                         final boolean flushCache ) {
    
    Rectangle area = composite.getClientArea();
    int x = area.x + this.getMarginWidth();
    int y = area.y + this.getMarginHeight();
    int w = area.width - 2 * this.getMarginWidth();
    int h = area.height - 2 * this.getMarginHeight();
    
    Control[] children = composite.getChildren();
    
    if ( children != null ) {
      
      for ( Control child : children ) {
      
        Point size = computeChildSize( child, SWT.DEFAULT, SWT.DEFAULT, flushCache );
        
        if ( this.getType() == SWT.VERTICAL ) {
          h = size.y;
        } else {
          w = size.x;
        }
        
        child.setBounds( x, y, w, h );
        
        if ( this.getType() == SWT.VERTICAL ) {
          y += this.getSpacing() + h;
        } else {
          x += this.getSpacing() + w;
        }
        
      }
      
    }

  }
  
  private Point computeChildSize( final Control control,
                                  final int wHint,
                                  final int hHint,
                                  final boolean flushCache ) {
    
    PackData data = ( PackData ) control.getLayoutData();
    
    if (data == null) {
      data = new PackData();
      control.setLayoutData( data );
    }
    
    Point size = null;
    
    if ( wHint == SWT.DEFAULT && hHint == SWT.DEFAULT ) {
      size = data.computeSize ( control, wHint, hHint, flushCache );
    } else {
      int trimX, trimY;
      if ( control instanceof Scrollable ) {
        Rectangle rect = ( ( Scrollable ) control ).computeTrim ( 0, 0, 0, 0 );
        trimX = rect.width;
        trimY = rect.height;
      } else {
        trimX = control.getBorderWidth () * 2;
        trimY = trimX; 
      }
      int w = wHint == SWT.DEFAULT ? wHint : Math.max ( 0, wHint - trimX );
      int h = hHint == SWT.DEFAULT ? hHint : Math.max ( 0, hHint - trimY );
      size = data.computeSize ( control, w, h, flushCache );
    }
    
    return size;
    
  }

  public int getType() {
    return this.type;
  }

  public void setType( final int type ) {
    this.type = type;
  }

  public int getMarginWidth() {
    return this.marginWidth;
  }

  public void setMarginWidth( final int marginWidth ) {
    this.marginWidth = marginWidth;
  }

  public int getMarginHeight() {
    return this.marginHeight;
  }

  public void setMarginHeight( final int marginHeight ) {
    this.marginHeight = marginHeight;
  }

  public int getSpacing() {
    return this.spacing;
  }

  public void setSpacing( final int spacing ) {
    this.spacing = spacing;
  }
}
