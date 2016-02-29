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
package org.eclipse.camf.infosystem.jobs;

import java.util.ArrayList;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.infosystem.InfoServiceFactory;
import org.eclipse.camf.infosystem.internal.Activator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

/**
 * @author nickl
 *
 */
public class FetchJob extends Job {
	
	private static FetchJob instance = null;
	
	public FetchJob (final String name) {
		super ( name );
	}
	
	public static FetchJob getInstance( final String name ) {
		if (instance == null){
			instance = new FetchJob( name );
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(final IProgressMonitor monitor) {
		
		IProgressMonitor localMonitor
	    = ( monitor != null )
	      ? monitor
	      : new NullProgressMonitor();
		
		ArrayList<ICloudInfoService> infoServicesArray = null;
	    InfoServiceFactory myInfoServiceFactory = new InfoServiceFactory();
	    infoServicesArray = myInfoServiceFactory.getAllExistingInfoService();
	    
//	    // Get the number of projects. The number is used in the monitor.
//	    int gridProjectNumbers = 0;
//	    ICloudElement[] projectElements;
//	    try {
//	      projectElements = CloudModel.getRoot().getChildren( null );
//	      for (int i=0; projectElements != null && i<projectElements.length; i++)
//	      {
//	        ICloudProject igp = (ICloudProject)projectElements[i];
//	        if (igp != null && !igp.isHidden() && igp.getCloudProvider() != null)
//	        {
//	          gridProjectNumbers++;
//	        }
//	      }
//	    } catch ( ProblemException e ) {
//	      Activator.logException( e );
//	    }
//	    
	    localMonitor.beginTask( "Retrieving information", infoServicesArray.size() * 10 ); //$NON-NLS-1$
	    
	    // Get the information from the info systems to file the glue view.
	    for (int i=0; infoServicesArray!= null && !localMonitor.isCanceled() && i<infoServicesArray.size() ; i++)
	    {
	      try {
	        ICloudInfoService iCloudInfoService = infoServicesArray.get( i );
	        if (iCloudInfoService != null) {
	          ICloudResourceCategory category = CloudResourceCategoryFactory.getCategory(CloudResourceCategoryFactory.ID_ALL);
	          ICloudContainer parent = iCloudInfoService.getParent();
	          ICloudProvider provider = null;
	          if (parent instanceof ICloudProvider) {
	            provider = (ICloudProvider) parent;
	          }
	          iCloudInfoService.fetchResources( parent, provider , category, localMonitor );
	        }            
          } catch( Exception e ) {
            Activator.logException( e );
          }
	      
	    }
	    
	    localMonitor.done();
	    Status status = new Status( IStatus.OK,
	                         "org.eclipse.camf.infosystem", //$NON-NLS-1$
	                         "Information data fetched successfully." ); //$NON-NLS-1$
	    return status;

	}

}
