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
package org.eclipse.camf.connectors.openstack;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICreatorSourceMatcher;
import org.eclipse.camf.core.model.impl.AbstractCloudElementCreator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * This {@link ICloudElementCreator} is able to create an
 * {@link OpenStackCloudProvider} from the input provided via its setter
 * methods. The currently required element is the {@link #providerName} to identify
 * the {@link OpenStackCloudProvider}. This input value is usually provided by
 * the user via some wizard page.
 * <p>
 * To make this {@link OpenStackCloudProviderCreator} available to the CELAR infrastructure
 * the extension point <code>org.eclipse.camf.core.cloudElementCreator</code> is
 * extended.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackCloudProvider
 * @see OpenStackCloudProviderProperties
 */
public class OpenStackCloudProviderCreator
    extends AbstractCloudElementCreator
    implements ICreatorSourceMatcher {

  /**
   * The list of {@link IOpenStackServiceCreator}s which are able to create an
   * {@link IOpenStackService}.
   */
  private static List<IOpenStackServiceCreator> serviceCreatorList;

  /** The creators extension ID. */
  private static final String EXTENSION_ID = "org.eclipse.camf.connectors.openstack.openstackCpCreator"; //$NON-NLS-1$

  /**
   * The name of the {@link ICloudProvider} which this
   * {@link ICloudElementCreator} is able to create.
   */
  private String providerName;

  /**
   * The OpenStack access id associated the {@link ICloudProvider} with an OpenStack
   * account.
   */
  private String openStackAccessId;
  
  /**
   * The OpenStack endpoint URI
   */
  private URI openStackEndPoint;

  /**
   * Default constructor used for initialization.
   */
  public OpenStackCloudProviderCreator() {
    // nothing to do here
  }

  @Override
  public boolean canCreate( final Object source ) {
      
    boolean result = false;

    if ( source instanceof IFileStore ) {
      IFileStore propertiesStore = ( ( IFileStore ) source ).getChild( OpenStackCloudProviderProperties.STORAGE_NAME );
      IFileInfo propertiesInfo = propertiesStore.fetchInfo();
      result = propertiesInfo.exists();
    }

    return result;

  }

  @Override
  public ICloudElement create( final ICloudContainer parent )
    throws ProblemException
  {
    OpenStackCloudProvider vo = null;
    Object source = getSource();
    if ( source == null ) {
      vo = new OpenStackCloudProvider( this );
    } else if ( source instanceof IFileStore ){
      vo = new OpenStackCloudProvider( ( IFileStore ) source );
    }
    return vo;
  }

  /**
   * This static method retrieves a list of all installed
   * {@link ICloudElementCreator}s (actually {@link IOpenStackServiceCreator}s),
   * which are able to produce {@link IOpenStackService} objects.
   * <p>
   * Additionally the {@link IOpenStackServiceCreator}s are initialized with the name
   * and default source pattern attribute as declared in the
   * <code>org.eclipse.camf.core.cloudElementCreator</code> extension point.
   * 
   * @return the list of configured and instantiated {@link IOpenStackServiceCreator}s
   *         or an empty {@link List}
   */
  public static synchronized List<IOpenStackServiceCreator> getOpenStackServiceCreators() {
    if( OpenStackCloudProviderCreator.serviceCreatorList == null ) {
      OpenStackCloudProviderCreator.serviceCreatorList = new ArrayList<IOpenStackServiceCreator>();

      // add registered IOpenStackServices to creator
      IOpenStackServiceCreator serviceCreator;
      List<IConfigurationElement> configurationElements
        = CloudModel.getCreatorRegistry().getConfigurations( null, IOpenStackService.class );
      for( IConfigurationElement configElem : configurationElements ) {
        try {
          // create element creator
          serviceCreator = ( IOpenStackServiceCreator )configElem.createExecutableExtension( Extensions.CLOUD_ELEMENT_CREATOR_EXECUTABLE );
          IConfigurationElement[] sourceChildern = configElem.getChildren( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_ELEMENT );

          // fetch default source element
          for( IConfigurationElement sourceElement : sourceChildern ) {
            String defaultSource = sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_DEFAULT_ATTRIBUTE );
            boolean isDefaultSource = Boolean.parseBoolean( defaultSource );
            if( isDefaultSource ) {
              // set properties on creator
              serviceCreator.setServiceURL( sourceElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_SOURCE_PATTERN_ATTRIBUTE ) );
              serviceCreator.setName( configElem.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_NAME_ATTRIBUTE ) );
            }
          }
          OpenStackCloudProviderCreator.serviceCreatorList.add( serviceCreator );
        } catch( CoreException coreEx ) {
          Activator.log( "Could not create OpenStack service creator from extension definition: " //$NON-NLS-1$
                             + configElem.getValue(),
                         coreEx );
        } catch( ClassCastException castEx ) {
          Activator.log( "Given creator is not an instance of IOpenStackServiceCreator: " //$NON-NLS-1$
                             + configElem.getValue(),
                         castEx );
        }
      }
    }
    return OpenStackCloudProviderCreator.serviceCreatorList;
  }

  /**
   * A getter for the {@link #providerName}.
   * 
   * @return the name of future {@link ICloudProvider}s
   */
  public String getCloudProviderName() {
    return this.providerName;
  }

  /**
   * A setter for the {@link #providerName}.
   * 
   * @param providerName the name to be set for future {@link ICloudProvider}s
   */
  public void setProvider( final String providerName ) {
    this.providerName = providerName;
  }
  
  
  /**
   * A setter for the {@link #openStackEndPoint}
   * 
   * @param endpoint The URI to set for future {@link ICloudProvider}s endpoint
   */
  public void setEndPoint (final URI endpoint) {
    this.openStackEndPoint = endpoint;
  }
  
  
  /**
   * A getter for the {@link #openStackEndPoint}.
   * 
   * @return the URI of future {@link ICloudProvider}s endpoint
   */
  public URI getEndPoint(){
    return this.openStackEndPoint;
  }

  /**
   * Transfers the details ({@link #providerName} of this {@link OpenStackCloudProviderCreator} to the
   * provided {@link OpenStackCloudProvider}.
   * 
   * @param openStackCP the {@link OpenStackCloudProvider} to populate
   */
  public void apply( final OpenStackCloudProvider openStackCP ) {
    try {
      openStackCP.apply( this );
    } catch ( ProblemException problemEx ) {
      Activator.log( "Could not populate OpenStackCloudProvider with the data from the OpenStackCloudProviderCreator", //$NON-NLS-1$
                     problemEx );
    }
  }

  public String getExtensionID() {
    return OpenStackCloudProviderCreator.EXTENSION_ID;
  }

  /**
   * A getter for the {@link #openStackAccessId}.
   * 
   * @return the openStackAccessId
   */
  public String getOpenStackAccessId() {
    return this.openStackAccessId;
  }

  /**
   * A setter for the {@link #openStackAccessId}.
   * 
   * @param openStackAccessId the openStackAccessId to set
   */
  public void setOpenStackAccessId( final String openStackAccessId ) {
    this.openStackAccessId = openStackAccessId;
  }
}
