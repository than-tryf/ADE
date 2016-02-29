package org.eclipse.camf.connectors.openstack;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.camf.connectors.openstack.info.OpenStackInfoService;
import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ISerializableElement;
import org.eclipse.camf.core.model.impl.AbstractCloudContainer;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

public class OpenStackService extends AbstractCloudContainer
  implements IOpenStackService, ISerializableElement
{
  /** Name to reference the service. */
  public static final String STORAGE_NAME = "org.eclipse.camf.connectors.openstack.service.osServiceCreator"; //$NON-NLS-1$

  /** The {@link OpenStackCloudProvider} this service is based on. */
  private OpenStackCloudProvider osCP;

  /** The categories introduced by this {@link IosService}. */
  public static ICloudResourceCategory[] standardResources = new ICloudResourceCategory[]{
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_ALL ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_MY_OWNED ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_IMAGES_MY_ACCESSIBLE ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_SECURITY_GROUPS ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_KEYPAIRS ),
//    CloudResourceCategoryFactory.getCategory( IEC2Categories.CATEGORY_EC2_ELASTIC_IP )
  };

  /**
   * Create a new {@link OpenStackService} with the service creator acting as the
   * source of initial configuration directives.
   * 
   * @param serviceCreator the initial configuration
   * @param cp the Vo to use for authentication
   */
  public OpenStackService( final OpenStackServiceCreator serviceCreator,
                     final OpenStackCloudProvider cp )
  {
    this.osCP = cp;
    try {
      addElement( new OpenStackInfoService( cp  ) );
      apply( serviceCreator );
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not populate OpenStackService with data from provided EC2 service creator and the infoservice", //$NON-NLS-1$
                     problemEx );
    }
  }

  /**
   * Creates a new {@link OpenStackService} where the properties are loaded from the
   * local storage.
   * 
   * @param cp the Vo to use for authentication
   */
  public OpenStackService( final OpenStackCloudProvider cp ) {
    this.osCP = cp;
    try {
      OpenStackServiceProperties serviceProperties = new OpenStackServiceProperties( this );
      serviceProperties.deserialize();
      addElement( serviceProperties );
      addElement( new OpenStackInfoService( cp ) );
    } catch( ProblemException e ) {
      Activator.log( "Could not load the ec2 service details from the filestore", //$NON-NLS-1$
                     e );
    }
  }

  @Override
  public boolean canContain( final ICloudElement element ) {
    return element instanceof OpenStackServiceProperties
           || element instanceof OpenStackInfoService;
  }

  /**
   * This Method transfers the name and the properties of the
   * {@link OpenStackServiceCreator} to the {@link OpenStackService}.
   * 
   * @param serviceCreator the {@link OpenStackServiceCreator} to apply the data from
   * @throws ProblemException
   */
  public void apply( final OpenStackServiceCreator serviceCreator )
    throws ProblemException
  {
    OpenStackServiceProperties properties = new OpenStackServiceProperties( this,
                                                                serviceCreator );
    // add properties to this service, replacing the existing properties
    addElement( properties );
  }

  public ICloudResourceCategory[] getSupportedResources() {
    return OpenStackService.standardResources;
  }

  public String getHostName() {
    OpenStackServiceProperties properties = null;
    try {
      properties = getProperties();
    } catch( ProblemException e ) {
      Activator.log( "Could not load the properties of the ec2 service", e ); //$NON-NLS-1$
    }
    if( properties != null ) {
      return properties.getOpenStackUrl();
    }
    return null;
  }

  public URI getURI() {
    String hostName = getHostName();
    try {
      if( hostName != null ) {
        return new URI( hostName );
      }
    } catch( URISyntaxException e ) {
      Activator.log( "Could not create EC2 service URI from " + hostName, e ); //$NON-NLS-1$
    }
    return null;
  }

  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( OpenStackService.STORAGE_NAME );
  }

  public String getName() {
    OpenStackServiceProperties properties = null;
    try {
      properties = getProperties();
    } catch( ProblemException gridModelEx ) {
      Activator.log( "Could not load the properties of the ec2 service", gridModelEx ); //$NON-NLS-1$
    }
    if( properties != null ) {
      return properties.getServiceName();
    }
    return null;
  }

  public ICloudContainer getParent() {
    return this.osCP;
  }

  public IPath getPath() {
    return getParent().getPath().append( OpenStackService.STORAGE_NAME );
  }

  public IResource getResource() {
    return null;
  }

  public boolean isLocal() {
    return true;
  }

  public boolean isLazy() {
    return false;
  }

  @Override
  public boolean equals( final Object obj ) {
    boolean result = false;
    if( obj instanceof OpenStackService ) {
      result = equals( ( OpenStackService )obj );
    }
    return result;
  }

  /**
   * A comparison method using the {@link OpenStackService#voName} as comparison
   * criteria.
   * 
   * @param service the {@link OpenStackService} to compare with
   * @return if the two services are equal in regards to their name
   */
  private boolean equals( final OpenStackService service ) {
    return getName().equals( service.getName() );
  }

  /**
   * Find the {@link OpenStackServiceProperties} in the list of children of this
   * service.
   * 
   * @return this services properties or <code>null</code> if no properties
   *         could be retrieved
   * @throws ProblemException if an error occurs while fetching the properties.
   */
  public OpenStackServiceProperties getProperties() throws ProblemException {
    OpenStackServiceProperties properties = null;
    ICloudElement[] children = getChildren( null );

    for( ICloudElement child : children ) {
      if( child instanceof OpenStackServiceProperties ) {
        properties = ( OpenStackServiceProperties )child;
        break;
      }
    }
    return properties;
  }

  public ICloudInfoService getInfoService() {
    ICloudInfoService infoService = null;
    try {
      ICloudElement[] children = getChildren( null );
      for( ICloudElement child : children ) {
        if( child instanceof ICloudInfoService ) {
          infoService = ( OpenStackInfoService )child;
          break;
        }
      }
    } catch( ProblemException cloudModelEx ) {
      Activator.log( "Could not get info service from OpenStackService", cloudModelEx ); //$NON-NLS-1$
    }
    return infoService;
  }

  public void deserialize() throws ProblemException {
    deleteAll();
    addElement( new OpenStackInfoService( this.osCP ) );
    IFileStore fileStore = getFileStore();
    try {
      IFileStore[] childStores = fileStore.childStores( EFS.NONE, null );
      for( IFileStore child : childStores ) {

        if( child.getName().equals( OpenStackServiceProperties.STORAGE_NAME ) ) {
          OpenStackServiceProperties serviceProperties = new OpenStackServiceProperties( this );
          serviceProperties.deserialize();
          addElement( serviceProperties );
        }
      }
    } catch( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
  }

  public void serialize() throws ProblemException {
    // create own storage directory
    IFileStore fileStore = getFileStore();
    if( !fileStore.fetchInfo().exists() ) {
      try {
        fileStore.mkdir( EFS.NONE, new NullProgressMonitor() );
      } catch( CoreException e ) {
        Activator.log( "Could not create storage dir for OpenStackService", e ); //$NON-NLS-1$
        return;
      }
    }

    // save children
    ICloudElement[] children = getChildren( null );
    for( ICloudElement child : children ) {
      if( child instanceof ISerializableElement ) {
        ( ( ISerializableElement )child ).serialize();
      }
    }
  }

  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

}
