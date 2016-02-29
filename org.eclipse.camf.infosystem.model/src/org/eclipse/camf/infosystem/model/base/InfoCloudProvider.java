/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
package org.eclipse.camf.infosystem.model.base;

import java.util.Hashtable;


public class InfoCloudProvider {
  
  private String name = null;
  private Hashtable<String, String> images = null;

  public InfoCloudProvider( final String name ) {
    this.name = name;
    this.images = new Hashtable<String, String>();
  }
    
  public Hashtable<String, String> getImages(){
    return this.images;
  }
  
  
}
