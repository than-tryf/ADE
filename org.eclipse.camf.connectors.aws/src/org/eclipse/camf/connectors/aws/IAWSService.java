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
 *    Moritz Post - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.connectors.aws;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ICloudService;


/**
 * The {@link IAWSService} is the interface which allows to contribute an Amazon
 * Webservice (EC2, S3, DevPay...) to the AWS base Cloud Provider. The services use the
 * authentication infrastructure provided by the AWS plugin.
 * 
 * @author Moritz Post
 */
public interface IAWSService extends ICloudService, ICloudContainer {
	
  public ICloudInfoService getInfoService(); 


  /**
   * Provides an array of categories contributing to the AWS CP subfolders.
   * 
   * @return an array of categories
   */
  public ICloudResourceCategory[] getSupportedResources();

}