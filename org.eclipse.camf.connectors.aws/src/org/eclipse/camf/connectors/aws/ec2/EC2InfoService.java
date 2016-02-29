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
package org.eclipse.camf.connectors.aws.ec2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.eclipse.camf.connectors.aws.AWSApplicationDeploymentService;
import org.eclipse.camf.connectors.aws.AWSCloudProvider;
import org.eclipse.camf.connectors.aws.EC2Client;
import org.eclipse.camf.connectors.aws.info.AWSInfoCache;
import org.eclipse.camf.connectors.aws.internal.Activator;
import org.eclipse.camf.connectors.aws.internal.JCatascopiaProbeRepo;
import org.eclipse.camf.connectors.aws.internal.JCatascopiaProbeRepoException;
import org.eclipse.camf.connectors.aws.internal.Messages;
import org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDescribeImages;
import org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDescribeKeypair;
import org.eclipse.camf.connectors.aws.operation.AbstractEC2OpSecurityGroups;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeImages;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeKeypairs;
import org.eclipse.camf.connectors.aws.operation.EC2OpDescribeSecurityGroups;
import org.eclipse.camf.connectors.aws.operation.OperationExecuter;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResource;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ICloudService;
import org.eclipse.camf.core.model.impl.AbstractCloudInfoSystem;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.InfoService;
import org.eclipse.camf.infosystem.model.base.AbstractInfoCache;
import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.Groups;
import org.eclipse.camf.infosystem.model.base.IExtendedInfoService;
import org.eclipse.camf.infosystem.model.base.Images;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.Keys;
import org.eclipse.camf.infosystem.model.base.Monitoring;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.MonitoringService;
import org.eclipse.camf.infosystem.model.base.Root;
import org.eclipse.camf.infosystem.model.base.Security;
import org.eclipse.camf.infosystem.model.base.VMI;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.jclouds.ec2.domain.Image;
import org.jclouds.ec2.domain.KeyPair;
import org.jclouds.ec2.domain.SecurityGroup;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author nickl
 */
public class EC2InfoService extends AbstractCloudInfoSystem implements IExtendedInfoService {

  /** The name of the file to save this cloud element in. */
  public static String STORAGE_NAME = ".ec2InfoService"; //$NON-NLS-1$
  private static String CP_TYPE = "org.eclipse.camf.connectors.aws";
  private AWSCloudProvider awsCP;
  private EC2Service ec2Service;
  public static AWSInfoCache infoCache = null;
  

  public EC2InfoService( final AWSCloudProvider cp, final EC2Service ec2Service ) {
    this.awsCP = cp;
    this.ec2Service = ec2Service;
  }
  
  public String getHostName() {
    try {
      EC2ServiceProperties properties = this.ec2Service.getProperties();
      if( properties != null ) {
        return properties.getEc2Url();
      }
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not load properties from ec2Service", problemEx ); //$NON-NLS-1$
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    String hostName = getHostName();
    try {
      if( hostName != null ) {
        return new URI( hostName );
      }
    } catch( URISyntaxException uriEx ) {
      Activator.log( "Could not creat URI from " + hostName, uriEx ); //$NON-NLS-1$
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return EC2InfoService.STORAGE_NAME;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( EC2InfoService.STORAGE_NAME );
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return getParent().getPath().append( EC2InfoService.STORAGE_NAME );
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.ec2Service;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return false;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.camf.core.model.ICloudInfoService#fetchResources(org.eclipse.camf.core.model
   * .ICloudContainer, org.eclipse.camf.core.model.ICloudProvider,
   * org.eclipse.camf.core.model.ICloudResourceCategory, boolean, java.lang.Class,
   * org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final ICloudResourceCategory category,
                                          final boolean exclusive,
                                          final Class<? extends ICloudResource> typeFilter,
                                          final IProgressMonitor monitor )
    throws ProblemException
  {
    
    initInfoCache();
    
    ICloudResource[] result = null;
    
    if( category.equals( CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES ) ) )
    {

      result = fetchImages( parent,
                            cp,
                            monitor,
                            new EC2OpDescribeImages( getEc2() ) );
    } else if ( category.equals( CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_SECURITY ) ) )
    {

      fetchKeyPairs( parent,
                            cp,
                            monitor,
                            new EC2OpDescribeKeypairs( getEc2() ) );
      fetchSecurityGroups( parent,
                           cp,
                           monitor,
                           new EC2OpDescribeSecurityGroups( getEc2() ) );
    } else if( category.equals( CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_DEPLOYMENT_SERVICES ) ) )
    {
      result = fetchDeploymentServices( parent, cp, monitor );
    } else if (category.equals( CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_ALL ) )) {
      fetchImages( parent,
                   cp,
                   monitor,
                   new EC2OpDescribeImages( getEc2() ) );
      fetchKeyPairs( parent,
                     cp,
                     monitor,
                     new EC2OpDescribeKeypairs( getEc2() ) );
      fetchSecurityGroups( parent,
                     cp,
                     monitor,
                     new EC2OpDescribeSecurityGroups( getEc2() ) );
      fetchJCatascopiaProbes( parent, cp, monitor );
    }

    if (result == null)
      result = new ICloudResource[0];

    return result;
  }
  
  private void initInfoCache() {
    
    ArrayList<ICloudProvider> cloudProviders = new ArrayList<ICloudProvider>();
    try {
      ICloudElement[] projectElements = CloudModel.getRoot().getChildren( null );
      for( ICloudElement element : projectElements ) {
        ICloudProject icp = ( ICloudProject )element;
        if( icp.isOpen() && icp.getCloudProvider() != null ) {
          cloudProviders.add( icp.getCloudProvider() );
        }
      }
      
      infoCache = new AWSInfoCache( cloudProviders ) ;
        
    } catch ( ProblemException e ) {
      Activator.logException( e );
    }
  }

  /**
   * Fetches the available AMIs of the EC2 service using the owner as a filter.
   * 
   * @param parent the parent of this {@link IGridInfoService}
   * @param vo the vo initiating the query
   * @param monitor the monitor to notify of progress
   * @param operation the operation to execute
   * @return an array of {@link EC2AMIImage}s.
   */
  public ICloudResource[] fetchImages( final ICloudContainer parent,
                                      final ICloudProvider cp,
                                      IProgressMonitor monitor,
                                      final AbstractEC2OpDescribeImages operation )
  {
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }

    // fetch existing AMI images from EC2 service
    monitor.beginTask( Messages.getString( "EC2InfoService.monitor_task_description" ), //$NON-NLS-1$
                       2 );

    new OperationExecuter().execOp( operation );

    monitor.worked( 1 );
    if( operation.getException() == null ) {
      // transform answer into gEclipse format
      ArrayList<ICloudResource> resultCloudService = new ArrayList<ICloudResource>( operation.getResult()
        .size() );
      
      Root root = InfoService.getInstance().getRoot();
      boolean newCP = false;
      
      CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
      if( infoCP == null ) {
        infoCP = InfoService.getInstance().getFactory().createCloudProvider();
        infoCP.setName( cp.getName() );
        infoCP.setType( CP_TYPE );
        newCP = true;
      }
      
      Images images = InfoService.getInstance().getFactory().createImages();
      infoCP.setImages( images );      
      
      VirtualMachineImage vmCustom = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
      vmCustom.setUID( "ami-13471c23" );
      vmCustom.setName( "Ubuntu-12-04-precise" );
      images.getVms().add(vmCustom);
      
      for( Image ami : operation.getResult() ) {
        VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
        vmi.setUID( ami.getId() );
        vmi.setDescription( ami.getDescription() );
        vmi.setName( ami.getName() );
        vmi.setURL( ami.getImageLocation() );
        resultCloudService.add( new VMI( parent, vmi ) );
        images.getVms().add( vmi );
      }
      
      
            
      if (newCP)
        root.getCloudProviders().add( infoCP );
      
      monitor.worked( 2 );
      monitor.done();
      return resultCloudService.toArray( new ICloudResource[ resultCloudService.size() ] );
    }
    return null;
  }
  
  /**
   * Fetches the available KeyPairs of the EC2 service using the owner as a filter.
   * 
   * @param parent the parent of this {@link IGridInfoService}
   * @param vo the vo initiating the query
   * @param monitor the monitor to notify of progress
   * @param operation the operation to execute
   * @return an array of {@link EC2AMIImage}s.
   */
  public ICloudResource[] fetchKeyPairs( final ICloudContainer parent,
                                      final ICloudProvider cp,
                                      IProgressMonitor monitor,
                                      final AbstractEC2OpDescribeKeypair operation )
  {
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }

    // fetch existing AMI images from EC2 service
    monitor.beginTask( Messages.getString( "EC2InfoService.monitor_task_description" ), //$NON-NLS-1$
                       2 );

    new OperationExecuter().execOp( operation );

    monitor.worked( 1 );
    if( operation.getException() == null ) {
      
      Root root = InfoService.getInstance().getRoot();
      boolean newCP = false;
      
      CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
      if( infoCP == null ) {
        infoCP = InfoService.getInstance().getFactory().createCloudProvider();
        infoCP.setName( cp.getName() );
        infoCP.setType( CP_TYPE );
        newCP = true;
      }
             
      Security security = InfoService.getInstance().getFactory().createSecurity();
      Keys keys = InfoService.getInstance().getFactory().createKeys();
      security.setKeys( keys );
      infoCP.setSecurity( security );      
      
      for( KeyPair remoteKeyPair : operation.getResult() ) {
        org.eclipse.camf.infosystem.model.base.KeyPair kp = InfoSystemFactory.eINSTANCE.createKeyPair();
        kp.setName( remoteKeyPair.getKeyName() );        
        kp.setUID( remoteKeyPair.getFingerprint() );
        keys.getKeypairs().add( kp );
      }
      
      if (newCP)
        root.getCloudProviders().add( infoCP );

      monitor.worked( 2 );
      monitor.done();
      return null;
    }
    return null;
  }
  
  public ICloudResource[] fetchSecurityGroups( final ICloudContainer parent,
                                         final ICloudProvider cp,
                                         IProgressMonitor monitor,
                                         final AbstractEC2OpSecurityGroups operation )
     {
       if( monitor == null ) {
         monitor = new NullProgressMonitor();
       }

       // fetch existing AMI images from EC2 service
       monitor.beginTask( Messages.getString( "EC2InfoService.monitor_task_description" ), //$NON-NLS-1$
                          2 );

       new OperationExecuter().execOp( operation );

       monitor.worked( 1 );
       if( operation.getException() == null ) {
         
         Root root = InfoService.getInstance().getRoot();
         boolean newCP = false;
         
         CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
         if( infoCP == null ) {
           infoCP = InfoService.getInstance().getFactory().createCloudProvider();
           infoCP.setName( cp.getName() );
           infoCP.setType( CP_TYPE );
           newCP = true;
         }
                
         Security security = null;
         if (infoCP.getSecurity() == null) {
           security = InfoService.getInstance().getFactory().createSecurity();           
         } else {
           security = infoCP.getSecurity();
         }
         Groups groups = InfoService.getInstance().getFactory().createGroups();
         security.setGroups( groups );
         infoCP.setSecurity( security );      
         
         for( SecurityGroup remoteSG : operation.getResult() ) {
           org.eclipse.camf.infosystem.model.base.SecurityGroup sg = InfoSystemFactory.eINSTANCE.createSecurityGroup();
           sg.setName( remoteSG.getName() );        
           sg.setUID( remoteSG.getId() );
           groups.getSecurityGroups().add( sg );
         }
         
         if (newCP)
           root.getCloudProviders().add( infoCP );

         monitor.worked( 2 );
         monitor.done();
         return null;
       }
       return null;
     }
  
  private ICloudService[] fetchJCatascopiaProbes( final ICloudContainer parent,
                                                            final ICloudProvider cp,
                                                            IProgressMonitor monitor )
  {
    ICloudService[] result = null;
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    monitor.beginTask( "Fetching JCatascopia Probes ...", 1 ); //$NON-NLS-1$
    
    
    Root root = InfoService.getInstance().getRoot();
    boolean newCP = false;
    
    CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
    if( infoCP == null ) {
      infoCP = InfoService.getInstance().getFactory().createCloudProvider();
      infoCP.setName( cp.getName() );
      infoCP.setType( CP_TYPE );
      newCP = true;
    }
    
    Monitoring monitoring = null;
    MonitoringService jCatascopiaService = null;
    if (infoCP.getMonitoring() != null){
      monitoring = infoCP.getMonitoring();
    } else {
      monitoring = InfoService.getInstance().getFactory().createMonitoring();
      infoCP.setMonitoring( monitoring );
      jCatascopiaService = InfoService.getInstance().getFactory().createMonitoringService();
      jCatascopiaService.setName( "jCatascopia" );
      monitoring.getMonitoringService().add( jCatascopiaService );
    }
    
    
    try {
      
    
    //CELAR Manager call : Get Monitoring Probes
    String probes = getJCatascopiaProbes();
    
    if ( probes.equals( "" ) == false ) {
      
      probes = "{\"probes\":" + probes + "}";
      String output_json = probes;
      JSONObject obj = new JSONObject( output_json );
      JSONArray probes_array = obj.getJSONArray( "probes" ); //$NON-NLS-1$
      
      if ( probes_array != null ){
        for (int i=0; i < probes_array.length(); i++){
          MonitoringProbe mp = InfoSystemFactory.eINSTANCE.createMonitoringProbe();
          /*
           * get the necessary mp fields
           */
          mp.setName( probes_array.getJSONObject( i ).getString( "probe" )); //$NON-NLS-1$ );
          mp.setMetrics( probes_array.getJSONObject( i ).getString( "metrics" ) );
          mp.setDescription( probes_array.getJSONObject( i ).getString( "desc" ) );
                    
          //add new monitor probe to probes list
          jCatascopiaService.getProbes().add(mp);
          //instance.monitor_probes.add( mp ); 
        }
        
      }
    }  
    } catch( Exception e ) {
      Activator.log( e );
    }
    
    return result;
  }
  
  String getJCatascopiaProbes(){
    JCatascopiaProbeRepo repo = new JCatascopiaProbeRepo();
    String probes = null;
    try {
      probes = repo.getProbes();

    } catch( JCatascopiaProbeRepoException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //System.out.println(probes);
    return probes;
  }
  
  private ICloudService[] fetchDeploymentServices( final ICloudContainer parent,
                                           final ICloudProvider cp,
                                           IProgressMonitor monitor )
  {
    ArrayList<ICloudService> totalJobDeploymentServicesArray = new ArrayList<ICloudService>();
    ICloudService[] result = null;
    
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    
    monitor.beginTask( "Fetching Deployment Services ...", 1 ); //$NON-NLS-1$

    AWSApplicationDeploymentService ads = new AWSApplicationDeploymentService( parent );
    totalJobDeploymentServicesArray.add( ads );
    
    monitor.done();
        
    result = totalJobDeploymentServicesArray.toArray(new ICloudService[totalJobDeploymentServicesArray.size()]);
    return result;
    
  }
  
  private EC2Client getEc2() {
    return EC2Client.getInstance();
 }

  @Override
  public AbstractInfoCache getInfoCache() {
    return infoCache;
  }

  
}
