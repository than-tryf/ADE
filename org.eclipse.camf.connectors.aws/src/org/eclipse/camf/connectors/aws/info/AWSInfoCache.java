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
package org.eclipse.camf.connectors.aws.info;

import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.internal.Activator;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.model.base.AbstractInfoCache;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


/**
 * @author nickl
 *
 */
public class AWSInfoCache extends AbstractInfoCache {

  public AWSInfoCache( final ArrayList<ICloudProvider> providers ) {
    super( providers );
  }

  @Override
  public void setProviderList( ArrayList<ICloudProvider> providers ) {
    for (ICloudProvider cp : providers){
      try {
        ArrayList<String> awsCPList = null;
        ICloudInfoService infoService = cp.getInfoService();
        if( ( infoService != null ) && ( infoService instanceof AWSInfoService ) )
        {
          if (awsCPList == null) {
            awsCPList = new ArrayList<String>();
          }
          awsCPList.add( cp.getName() );
        }
      } catch( ProblemException e ) {
        IStatus status = new Status( IStatus.ERROR,
                                     Activator.PLUGIN_ID,
                                     IStatus.OK,
                                     null,
                                     e );
        Activator.getDefault().getLog().log( status );
      }
    }
  }
}
