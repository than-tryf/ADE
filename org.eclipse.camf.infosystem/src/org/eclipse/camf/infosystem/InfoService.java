/*******************************************************************************
 * Copyright (c) May 29, 2015 Laboratory for Internet Computing, University of Cyprus.
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
package org.eclipse.camf.infosystem;

import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.Root;
import org.eclipse.emf.common.util.EList;



/**
 * @author nickl
 *
 */
public class InfoService {
  
  private static InfoService instance  = null;
  private static InfoSystemFactory infoSystemFactory = null;
  private static Root root = null;
  

  public static InfoService getInstance() {
    if( instance == null ) {
      instance = new InfoService();
    }
    return instance;
  }

  private InfoService() {
    infoSystemFactory = InfoSystemPackage.eINSTANCE.getInfoSystemFactory();
    root = infoSystemFactory.createRoot();
  }

  public InfoSystemFactory getFactory() {
    return infoSystemFactory;
  }

  public Root getRoot() {
    return root;
  }
  
  public CloudProvider getCloudProvider( final ICloudProvider provider ) {
    CloudProvider result = null;
    if( root == null ) {
      getInstance();
    }
    EList<CloudProvider> cloudProviders = getRoot().getCloudProviders();
    for( CloudProvider cp : cloudProviders ) {
      if( cp.getName().equals( provider.getName() ) ) {
        result = cp;
      }
    }
    return result;
  }
  
   
}
