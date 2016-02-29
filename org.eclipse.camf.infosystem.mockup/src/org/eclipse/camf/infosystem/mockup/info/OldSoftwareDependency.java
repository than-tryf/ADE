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
import org.eclipse.camf.core.model.ICloudSoftwareDependency;


/**
 * @author Nicholas Loulloudes
 *
 */
public class OldSoftwareDependency extends ApplicationComponent implements ICloudSoftwareDependency
{
  
  private String uid;
  private URI uri;
  private String name;
  private String description;
  private String type;
    
  public OldSoftwareDependency( final ICloudContainer parent ) {
    super( parent );
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public String getType() {
    return this.type;
  }
  
  public void setType( final String type ) {
    this.type = type;
  }

  @Override
  public String getUID() {
    return this.uid;
  }

  public void setUID( final String uid ) {
    this.uid = uid;
  }

  public URI getURI() {
    return this.uri;
  }

  public void setURI( final URI uri ) {
    this.uri = uri;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public void setName( final String name ) {
    this.name = name;
  }
  

}
