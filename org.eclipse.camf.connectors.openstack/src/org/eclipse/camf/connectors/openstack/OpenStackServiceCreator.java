package org.eclipse.camf.connectors.openstack;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.IFileStore;

public class OpenStackServiceCreator extends AbstractCloudElementCreator
  implements IOpenStackServiceCreator
{

  /** The creators extension ID. */
  private static final String EXTENSION_ID = "org.eclipse.camf.connectors.openstack.service.osServiceCreator"; //$NON-NLS-1$
  /**
   * An {@link IFileStore} handle containing this {@link AWSVoCreator} and its
   * children.
   */
  private IFileStore osServiceCreatorFileStore;
  /** The URL to the OpenStack Computing Cloud service. */
  private String osUrl;
  /**
   * The name of the service which this {@link ICloudElementCreator} can create.
   */
  private String serviceName;

  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    OpenStackService ec2Service = null;
    if( parent instanceof OpenStackCloudProvider ) {
      OpenStackCloudProvider awsCP = ( OpenStackCloudProvider )parent;
      if( this.osServiceCreatorFileStore == null ) {
        ec2Service = new OpenStackService( this, awsCP );
      } else {
        ec2Service = new OpenStackService( awsCP );
      }
    }
    return ec2Service;
  }

  public String getExtensionID() {
    return OpenStackServiceCreator.EXTENSION_ID;
  }

  /**
   * @return the serviceName
   */
  public String getServiceName() {
    return this.serviceName;
  }

  /**
   * @param serviceName the serviceName to set
   */
  public void setServiceName( final String serviceName ) {
    this.serviceName = serviceName;
  }

  public String getName() {
    return this.serviceName;
  }

  public String getServiceURL() {
    return this.osUrl;
  }

  public void setName( final String name ) {
    this.serviceName = name;
  }

  public void setServiceURL( final String url ) {
    this.osUrl = url;
  }
}
