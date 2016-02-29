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
package org.eclipse.camf.infosystem.mockup.info;

import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeImages;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeMetrics;
import org.eclipse.camf.connectors.aws.operation.OperationExecuter;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.jclouds.cloudwatch.domain.Metric;
import org.jclouds.ec2.domain.Image;


/**
 * @author Nicholas Loulloudes
 *
 */
public class AmazonAWSFetch extends Job  {  
    
  private EC2Client ec2;
  private ArrayList<VirtualMachineImage> base_images = null;
  private ArrayList<VirtualMachineImage> custom_images = null;
  private ArrayList<SoftwareDependency> software_dependencies = new ArrayList<SoftwareDependency>();
  private ArrayList<MonitoringProbe> monitor_probes = new ArrayList<MonitoringProbe>();
  private ArrayList<ResizingAction> resize_actions = new ArrayList<ResizingAction>();
  private ArrayList<UserApplication> user_apps = new ArrayList<UserApplication>();
  /**
   * @param name
   */
  public AmazonAWSFetch( final String name ) {
    super( name );
  }

  private static AmazonAWSFetch instance = null;
  
  
  /**
   * @param name
   * @return
   */
  public static AmazonAWSFetch getInstance ( final String name) {
    if (instance == null) {
      instance = new AmazonAWSFetch( name );
    }
    return instance;
  }

  /* (non-Javadoc)
   * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected IStatus run( final IProgressMonitor monitor ) {
    IProgressMonitor localMonitor = ( monitor != null )
                                                       ? monitor
                                                       : new NullProgressMonitor();
    localMonitor.beginTask( "Authenticating with AWS", 3 ); //$NON-NLS-1$
    try {
      
      localMonitor.beginTask( "Creating AWS EC2 client", 6 * 10 ); //$NON-NLS-1$
      this.ec2 = EC2Client.getInstance();
      
      EC2OpDescribeImages imagesOperation = new EC2OpDescribeImages( this.ec2 );
      new OperationExecuter().execOp( imagesOperation );
      localMonitor.worked( 1 );
      
      if( imagesOperation.getException() == null ) {
        int size = imagesOperation.getResult().size();
        System.out.println("Images Size: " + size); //$NON-NLS-1$
        this.base_images = new ArrayList<VirtualMachineImage>( size );
        
        for( Image ami : imagesOperation.getResult() ) {
//          if( ami.getName() == null ) {
//            continue;
//          }
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( ami.getId() );
          vmi.setDescription( ami.getDescription() );
          vmi.setName( ami.getName() );
          vmi.setURL( ami.getImageLocation() );
          this.base_images.add( vmi );
        }
        
        localMonitor.worked( 2 );
      }  else {
        throw new Exception(imagesOperation.getException());
      }
      
      EC2OpDescribeMetrics metricsOperation = new EC2OpDescribeMetrics( this.ec2 );
      new OperationExecuter().execOp( metricsOperation );
      localMonitor.worked( 3 );
      
      if( metricsOperation.getException() == null ) {
        int size = metricsOperation.getResult().size();
        System.out.println("Metrics Size: " + size); //$NON-NLS-1$
        this.monitor_probes = new ArrayList<MonitoringProbe>( size );
        
        for( Metric metric : metricsOperation.getResult() ) {

          MonitoringProbe probe = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
          probe.setName( metric.getMetricName() );                    
          this.monitor_probes.add( probe );
        }
        
        localMonitor.worked( 2 );
      }  else {
        throw new Exception(metricsOperation.getException());
      }
      
      
      
      
    } catch( Exception e ) {
      e.printStackTrace();
    }
    localMonitor.done();
    Status status = new Status( IStatus.OK, "org.eclipse.camf.infosystem", //$NON-NLS-1$
                                "Information data fetched successfully." ); //$NON-NLS-1$
    return status;
  }
  
  /**
   * @return A list with the available Base Machine Images
   */
  public ArrayList<VirtualMachineImage> getBaseMachineImages () {
    return instance.base_images;
  }
  
  /**
   * @return A list with the available Custom Machine Images
   */
  public ArrayList<VirtualMachineImage> getCustomMachineImages () {
     return instance.custom_images;
  }
  
  /**
   * @return A list with the available Software Dependencies
   */
  public ArrayList<SoftwareDependency> getSoftwareDependencies () {
    return instance.software_dependencies;
  }
  
  /**
   * @return A list with available Monitoring Probes
   */
  public ArrayList<MonitoringProbe> getMonitoringProbes () {
    return instance.monitor_probes;
  }
  
  /**
   * @return A list with available Resizing Actions
   */
  public ArrayList<ResizingAction> getResizingActions () {
    return instance.resize_actions;
  }
  
  /**
   * @return A list with the available User Applications
   */
  public ArrayList<UserApplication> getUserApplications () {
    return instance.user_apps;
  }

  /**
   * @return
   */
  public ArrayList<VirtualMachineImageFlavor> getFlavors() {
    ArrayList<VirtualMachineImageFlavor> flavors = new ArrayList<VirtualMachineImageFlavor>(); 
    		
    return flavors;
  }
  
	public ArrayList<VirtualNetwork> getNetworks() {
		ArrayList<VirtualNetwork> vns = new ArrayList<VirtualNetwork>();

		return vns;
	}

	public ArrayList<KeyPair> getKeyPairs() {
		ArrayList<KeyPair> kps = new ArrayList<KeyPair>();

		return kps;
	}

  
}