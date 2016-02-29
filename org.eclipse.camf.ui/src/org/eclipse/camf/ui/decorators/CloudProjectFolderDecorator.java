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
 *   Nicholas Loulloudes - initial API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.decorators;

import java.net.URL;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.ExtensionManager;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudProjectFolderDecorator extends LabelProvider
  implements ILightweightLabelDecorator
{

  private static final String ID = "org.eclipse.camf.ui.CloudProjectFolderDecorator"; //$NON-NLS-1$

private Hashtable< String, ImageDescriptor > images = new Hashtable< String, ImageDescriptor >();

public static CloudProjectFolderDecorator getDecorator() {
  
  CloudProjectFolderDecorator result = null;
  IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
  
  if ( decoratorManager.getEnabled( ID ) ) {
    result = 
      ( CloudProjectFolderDecorator ) decoratorManager.getBaseLabelProvider( ID );
  }
  
  return result;
  
}

public CloudProjectFolderDecorator() {
  
  ImageDescriptor standardImage = null;
  ImageDescriptor image = null;
  
  ExtensionManager extm = new ExtensionManager();
  List< IConfigurationElement > configurationElements
    = extm.getConfigurationElements( Extensions.PROJECT_FOLDER_POINT, Extensions.PROJECT_FOLDER_ELEMENT );
  
  for ( IConfigurationElement element : configurationElements ) {
    
    String id = element.getAttribute( Extensions.PROJECT_FOLDER_ID_ATTRIBUTE );
    String icon = element.getAttribute( Extensions.PROJECT_FOLDER_ICON_ATTRIBUTE );
    
    if ( icon != null ) {
      IExtension extension = element.getDeclaringExtension();
      IContributor contributor = extension.getContributor();
      String name = contributor.getName();
      Bundle bundle = Platform.getBundle( name );
      URL url = FileLocator.find( bundle, new Path( icon ), null );
      image = ImageDescriptor.createFromURL( url );
    }
    
    else {
      if ( standardImage == null ) {
        URL url = Activator.getDefault().getBundle()
                    .getEntry( "icons/ovr16/project_ovr.gif" ); //$NON-NLS-1$
        standardImage = ImageDescriptor.createFromURL( url );
      }
      image = standardImage;
    }
    
    this.images.put( id, image );
  }
}

/* (non-Javadoc)
 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
 */
@Override
public void decorate( final Object element, final IDecoration decoration ) {
  if ( element instanceof ICloudContainer ) {
    decorate( ( ICloudContainer ) element, decoration );
  }
}

public void refresh( final ICloudElement toUpdate ) {
  LabelProviderChangedEvent event = new LabelProviderChangedEvent( getDecorator(), toUpdate );
  fireLabelProviderChanged( event );
}

public void refresh( final ICloudElement[] toUpdate ) {
  LabelProviderChangedEvent event
    = new LabelProviderChangedEvent( getDecorator(), toUpdate );
  fireLabelProviderChanged( event );
}

private void decorate( final ICloudContainer container, final IDecoration decoration ) {
  ICloudContainer parent = container.getParent();
  if ( parent instanceof ICloudProject ) {
    String id = ( ( ICloudProject ) parent ).getProjectFolderID( container );
    if ( id != null ) {
      ImageDescriptor image = this.images.get( id );
      if ( image != null ) {
        decoration.addOverlay( image, IDecoration.TOP_RIGHT );
      }
    }
  }
}

}
