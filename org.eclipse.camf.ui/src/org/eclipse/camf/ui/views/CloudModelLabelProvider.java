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
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.ui.views;

import java.net.URL;
import java.util.Hashtable;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.impl.ContainerMarker;
import org.eclipse.camf.core.model.impl.ContainerMarker.MarkerType;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudModelLabelProvider extends LabelProvider
  implements IStyledLabelProvider
{
  /**
   * The info marker image path.
   */
  public static final String INFO_MARKER = "icons/obj16/info_obj.gif"; //$NON-NLS-1$

  /**
   * The error marker image path.
   */
  public static final String ERROR_MARKER = "icons/obj16/ihigh_obj.gif"; //$NON-NLS-1$
  
  private static final String APPLICATION_ELEMENT = "icons/obj16/application_obj.gif"; //$NON-NLS-1$
  
  private static Hashtable< String, Image > images = new Hashtable< String, Image >();

  private Image computingImage;
  
  private Image jobImage;
  
  private Image jobDescriptionImage;
  
  private Image serviceImage;
  
  private Image serviceUnsupportedImage;
  
  private Image storageImage;
  
  private Image voImage;
  
  private Image virtualContainerImage;
  
  private Image virtualElementImage;
  
  private ILabelProvider workbenchLabelProvider = WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider();
  
  /**
   * Construct a new <code>CloudModelLabelProvider</code>.
   */
  public CloudModelLabelProvider() {
    // empty implementation
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
   */
  @Override
  public Image getImage( final Object element ) {
    
    Image result = null;
    
    if ( element instanceof ICloudElement ) {
      result = getImage( ( ICloudElement ) element );
    } else {
      result = super.getImage( element );
    }
    
    return result;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
   */
  @Override
  public String getText( final Object element ) {
    
    String resultText = null;
    
    if ( element instanceof ICloudElement ) {
      resultText = ( ( ICloudElement ) element ).getName();
    } else {
      resultText = element.toString();
    }
    
    return resultText;
  }
  
  private Image getImage( final ICloudElement element ) {

    Image result = null;
    
    if ( element.isVirtual() ) {
      result = getVirtualElementImage( element );
    } else {
      result = getRealElementImage( element );
    }
    
    return result;
  }
  
  private Image getRealElementImage( final ICloudElement element ) {
    
    Image result = null;
    
    if ( element instanceof ICloudApplicationDescription ) {
      result = getApplicationDescriptionImage();
    } else {
      IResource resource = element.getResource();
      result = this.workbenchLabelProvider.getImage( resource );
    }
    
    return result;
  }
  
  private Image getVirtualElementImage( final ICloudElement element ) {
    
    Image result = null;
    
    if ( element instanceof ICloudProvider ) {
      result = getCloudProviderImage();
    } else if ( element instanceof ICloudContainer ) {
      result = getVirtualContainerImage();
    } else if ( element instanceof ContainerMarker ) {
      result = getContainerMarkerImage( ( ContainerMarker ) element );
    } else {
      result = getVirtualElementImage();
    }
    
    return result;
  }
  
  private Image getContainerMarkerImage( final ContainerMarker marker ) {
    
    Image result = null;
    ContainerMarker.MarkerType type = marker.getType();
    
    if ( type == MarkerType.INFO ) {
      result = getImage( INFO_MARKER );
    } else if ( type == MarkerType.ERROR ) {
      result = getImage( ERROR_MARKER );
    }
    
    return result;
  }
  
  private Image getApplicationDescriptionImage() {
    if ( this.jobDescriptionImage == null ) {
      this.jobDescriptionImage = Activator.getDefault().getImageRegistry().get( "applicationdescription" ); //$NON-NLS-1$
    }
    return this.jobDescriptionImage;
  }
  
  private Image getVirtualContainerImage() {
    if ( this.virtualContainerImage == null ) {
      this.virtualContainerImage = Activator.getDefault().getImageRegistry().get( "virtualfolder" ); //$NON-NLS-1$
    }
    return this.virtualContainerImage;
  }
  
  private Image getVirtualElementImage() {
    if ( this.virtualElementImage == null ) {
      this.virtualElementImage = Activator.getDefault().getImageRegistry().get( "virtualfile" ); //$NON-NLS-1$
    }
    return this.virtualElementImage;
  }

  /**
   * Get an image that represents a Cloud Provider
   * 
   * @return The image for a VO.
   */
  private Image getCloudProviderImage() {
    if ( this.voImage == null ) {
      this.voImage = Activator.getDefault().getImageRegistry().get( "cloudprovider" ); //$NON-NLS-1$
    }
    return this.voImage;
  }
    
  private static Image getImage( final String path ) {
    
    Image image = images.get( path );
    
    if ( image == null ) {
      image = loadImage( path );
      images.put( path, image );
    }
    
    return image;
  }
  
  private static Image loadImage( final String path ) {
    URL url = Activator.getDefault().getBundle().getEntry( path );
    ImageDescriptor descriptor = ImageDescriptor.createFromURL( url );
    return descriptor.createImage();
  }

  public StyledString getStyledText( final Object element ) {
    String text = getText( element );
    if ( text == null ) {
      text = ""; //$NON-NLS-1$
    }
    return new StyledString( text );
  }
}
