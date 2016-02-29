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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/

package org.eclipse.camf.tosca.core;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.core.resources.IFile;

public class TOSCACreator extends AbstractCloudElementCreator {

  @Override
  public ICloudElement create( ICloudContainer parent ) throws ProblemException
  {
    
    ICloudElement result = null;
    IFile file = ( IFile )getSource();
    // if ( file != null && !file.isLinked() ) {
    if( file != null ) {
      result = new TOSCAResource( file );
    }
    return result;
  }


}
