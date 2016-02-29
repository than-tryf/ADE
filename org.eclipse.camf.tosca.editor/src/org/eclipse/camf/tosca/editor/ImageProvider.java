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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

/**
 * Provides icons for directed and bi-directed relationships
 *
 */
public class ImageProvider extends AbstractImageProvider {

  /**
   *  The prefix for all identifiers of this image provider
   */
  protected static final String PREFIX = "org.eclipse.camf.tosca.editor."; //$NON-NLS-1$
  /**
   *  The image identifier for an EReference.
   */
  public static final String IMG_EREFERENCE = PREFIX + "ereference"; //$NON-NLS-1$
  /**
   *  The image identifier for an EReference.
   */
  public static final String IMG_EREFERENCE2 = PREFIX + "ereference2"; //$NON-NLS-1$
  
  /**
   *  The image identifier for a Monitoring Probe.
   */
  public static final String IMG_MONITORING = PREFIX + "monitoring"; //$NON-NLS-1$
  /**
   *  The image identifier for a VM Flavor.
   */
  public static final String IMG_FLAVOR = PREFIX + "flavor"; //$NON-NLS-1$

  @Override
  protected void addAvailableImages() {
    // register the path for each image identifier
    addImageFilePath( IMG_EREFERENCE, "icons/ereference.gif" ); //$NON-NLS-1$
    addImageFilePath( IMG_EREFERENCE2, "icons/ereference2.gif" ); //$NON-NLS-1$
    addImageFilePath( IMG_MONITORING, "icons/monitoring.png" ); //$NON-NLS-1$
    addImageFilePath( IMG_FLAVOR, "icons/flavor.gif" ); //$NON-NLS-1$
  }
}
