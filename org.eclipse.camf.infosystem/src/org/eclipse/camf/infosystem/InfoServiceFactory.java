/*****************************************************************************
 * Copyright (c) 2007, 2008 g-Eclipse Consortium 
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
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.infosystem;

import java.util.ArrayList;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.internal.Activator;


/**
 * This class is responsible for returning existing information services.
 * 
 * @author tnikos
 */
public class InfoServiceFactory {
  
  
  /**
   * Returns existing information services.
   * @return An array with all the different kind of information services found
   * in the projects. Only one of each type is returned, the first that is found
   * by browsing the grid projects. 
   */
  public ArrayList<ICloudInfoService> getAllExistingInfoService()
  {
    ArrayList<ICloudInfoService> infoServiceArray = new ArrayList<ICloudInfoService>();
    ICloudInfoService infoService = null;
 
    ICloudElement[] projectElements;
    try {
      projectElements = CloudModel.getRoot().getChildren( null );
      for (int i=0; projectElements != null && i<projectElements.length; i++)
      {
        ICloudProject igp = (ICloudProject)projectElements[i];
        if (igp != null && !igp.isHidden() && igp.getCloudProvider() != null)
        {
          infoService = igp.getCloudProvider().getInfoService();
          if (infoService != null && !exists(infoServiceArray, infoService))
            infoServiceArray.add( infoService );
        }
      }
    } catch ( ProblemException e ) {
      Activator.logException( e );
    } catch ( Exception e ) {
      Activator.logException( e );
    }
    
    return infoServiceArray;
  }
  
  private boolean exists(final ArrayList<ICloudInfoService> infoServiceArray,
                         final ICloudInfoService infoService)
  {
    boolean result = false;
    for (int i=0; infoServiceArray!= null 
                  && i<infoServiceArray.size()
                  && !result; i++)
    {
      if (infoServiceArray.get( i ).getClass().equals( infoService.getClass() ))
        result = true;
    }
    
    return result;
  }
}