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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.infosystem.mockup.info;

import java.net.URI;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudVirtualMachineImage;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OldVirtualMachineImage extends ApplicationComponent implements ICloudVirtualMachineImage {

  private URI uri;
  private String name;
  private String uid;
  private String descr;
  /**
   * @param parent The parent Cloud Container
   */
  public OldVirtualMachineImage( final ICloudContainer parent ) {
    super( parent );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudVirtualMachineImage#getDescription()
   */
  @Override
  public String getDescription() {
    return this.descr;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudVirtualMachineImage#getUID()
   */
  @Override
  public String getUID() {
    return this.uid;
  }
  
  
  /**
   * @param uri
   */
  public void setURI(final URI uri) {
    this.uri = uri;
  }
    
  /**
   * @param description
   */
  public void setDescription( final String description ) {
    this.descr = description;
  }

  
  /**
   * @param uid
   */
  public void setUID( final String uid ) {
    this.uid = uid;
  }
  
  /**
   * 
   */
  @Override
  public URI getURI() {
    return this.uri;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.mockup.info.ApplicationComponent#getName()
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  /**
   * @param name
   */
  public void setName(final String name) {
    this.name = name;
  }
  
}
