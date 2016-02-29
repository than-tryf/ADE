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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.camf.connectors.openstack.info.IOpenStackCategories;
import org.eclipse.camf.connectors.openstack.info.OpenStackInfoService;
import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.connectors.openstack.internal.Messages;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ISerializableElement;
import org.eclipse.camf.core.model.impl.AbstractCloudProvider;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;



public class OpenStackCloudProvider extends AbstractCloudProvider {

  /**
   * The id of the wizard to use for Cloud Provider creation as specified in the
   * <code>plugin.xml</code>.
   */
  private static final String OPENSTACK_CP_WIZARD_ID = "org.eclipse.camf.connectors.openstack.ui.wizard.OSCloudProviderWizard"; //$NON-NLS-1$

  /**
   * The type name of this VO implementation.
   */
  private static final String CP_TYPE_NAME = Messages.getString( "OSCloudProvider.cp_type_name" ); //$NON-NLS-1$

  /**
   * Name of this Cloud Provider used in the {@link IFileStore}.
   */
  private String cpName;
  
  /** The categories published by this {@link IVirtualOrganization}. */
  public static ICloudResourceCategory[] STANDARD_RESOURCE_CATEGORIES = new ICloudResourceCategory[]{
    CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_IMAGES ),
    CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_NETWORKING ),
    CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_SECURITY),
    CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_STORAGE )
  };


  /**
   * Standard constructor used to Instantiate Cloud Provider in the wizard.
   */
  public OpenStackCloudProvider() {
    // nothing to do here
  }

  /**
   * This constructor takes an {@link IFileStore} handle which contains a
   * reference to a {@link OpenStackCloudProviderCreator}. The content of the creator is loaded
   * and thereby populating this {@link OpenStackCloudProvider}.
   * 
   * @param fileStore the {@link OpenStackCloudProviderCreator} to obtain the data from
   */
  public OpenStackCloudProvider( final IFileStore fileStore ) {
    if( fileStore != null ) {

      this.cpName = fileStore.getName();
      try {
        deserialize();
        addElement( new OpenStackInfoService( this ) );
      } catch( ProblemException e ) {
        Activator.log( "Could not load the openStackCloudProvider details from the filestore", e ); //$NON-NLS-1$
      }
    } else {
      Activator.log( "Could not populate OpenStackCloudProvider with data from fileStore" //$NON-NLS-1$
                     + " since given filestore was 'null'" ); //$NON-NLS-1$
    }
  }

  /**
   * This constructor takes an {@link OpenStackCloudProviderCreator} with the
   * {@link OpenStackCloudProvider} specific data. The details of the
   * {@linkplain OpenStackCloudProviderCreator creator} are {@linkplain #apply(OpenStackCloudProviderCreator)
   * applied} to this {@link OpenStackCloudProvider}.
   * 
   * @param voCreator the {@link OpenStackCloudProviderCreator} to get the data from
   */
  protected OpenStackCloudProvider( final OpenStackCloudProviderCreator voCreator ) {
    try {
      apply( voCreator );
      addElement( new OpenStackInfoService( this ) );
    } catch( ProblemException e ) {
      Activator.log( "Could not populate openStackCloudProvider with data from provided openStackCloudProvider creator", //$NON-NLS-1$
                     e );
    }
  }

  /**
   * This Method transfers the name and the properties of the
   * {@link OpenStackCloudProviderCreator} to the {@link OpenStackCloudProvider}.
   * 
   * @param voCreator the {@link OpenStackCloudProviderCreator} to apply the data from
   * @throws GridModelExc8eption arises when interaction with the
   *           {@link GridModel} fails
   */
  void apply( final OpenStackCloudProviderCreator voCreator ) throws ProblemException {
    this.cpName = voCreator.getCloudProviderName();
    OpenStackCloudProviderProperties voProperties = new OpenStackCloudProviderProperties( this, voCreator );
    // add properties to this vo, replacing the existing props
    addElement( voProperties );

    List<IOpenStackServiceCreator> serviceCreators = OpenStackCloudProviderCreator.getOpenStackServiceCreators();
    for( IOpenStackServiceCreator serviceCreator : serviceCreators ) {
      create( serviceCreator );
    }
  }

  @Override
  public void deserialize() throws ProblemException {
    deleteAll();
    IFileStore fileStore = getFileStore();
    List<IConfigurationElement> configurationElements = CloudModel.getCreatorRegistry()
      .getConfigurations( null, IOpenStackService.class );
    try {
      IFileStore[] childStores = fileStore.childStores( EFS.NONE, null );

      for( IFileStore child : childStores ) {
        ICloudElement cloudElement = null;
        String childName = child.getName();

        if( childName.equals( OpenStackCloudProviderProperties.STORAGE_NAME ) ) {
          OpenStackCloudProviderProperties properties = new OpenStackCloudProviderProperties( this );
          properties.deserialize();
          cloudElement = properties;
        } else {
          for( IConfigurationElement configElement : configurationElements ) {
            String creatorId = configElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_ID_ATTRIBUTE );
            if( childName.equals( creatorId ) ) {
              ICloudElementCreator serviceCreator = ( ICloudElementCreator )configElement.createExecutableExtension( Extensions.CLOUD_ELEMENT_CREATOR_EXECUTABLE );
              cloudElement = serviceCreator.create( this );
              if( cloudElement instanceof ISerializableElement ) {
                ( ( ISerializableElement )cloudElement ).deserialize();
              }
            }
          }
        }

        if( cloudElement != null ) {
          addElement( cloudElement );
        }
      }
    } catch( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
  }

  @Override
  public ICloudResourceCategory[] getSupportedCategories() {
    ArrayList<ICloudResourceCategory> categoriesList = new ArrayList<ICloudResourceCategory>();
    try {
      List<IOpenStackService> openStackServices = getChildren( new NullProgressMonitor(),
                                                   IOpenStackService.class );

      for( IOpenStackService service : openStackServices ) {
        ICloudResourceCategory[] supportedResources = service.getSupportedResources();
        if( supportedResources != null ) {
          Collections.addAll( categoriesList, supportedResources );
        }
      }
    } catch( ProblemException problemEx ) {
      Activator.log( "Could not fetch the OpenStackServices from the OpenStack Cloud Provider", //$NON-NLS-1$
                     problemEx );
    }

    Collections.addAll( categoriesList,
                        OpenStackCloudProvider.STANDARD_RESOURCE_CATEGORIES );
    return categoriesList.toArray( new ICloudResourceCategory[ categoriesList.size() ] );
  }

  /**
   * This method is not used. The entire loading procedure happens in
   * {@link #load()};
   */
  @Override
  protected ICloudElement loadChild( final String childName ) {
    return null;
  }

  @Override
  public boolean canContain( final ICloudElement element ) {
    return super.canContain( element ) || element instanceof OpenStackCloudProviderProperties;
  }

  public String getTypeName() {
    return OpenStackCloudProvider.CP_TYPE_NAME;
  }

  public String getWizardId() {
    return OpenStackCloudProvider.OPENSTACK_CP_WIZARD_ID;
  }

  public boolean isLazy() {
    return false;
  }

  public String getName() {
    return this.cpName;
  }

  @Override
  public boolean equals( final Object obj ) {
    boolean result = false;
    if( obj instanceof OpenStackCloudProvider ) {
      result = equals( ( OpenStackCloudProvider )obj );
    }
    return result;
  }

  /**
   * A comparison method using the {@link OpenStackCloudProvider#cpName} as
   * comparison criteria.
   * 
   * @param vo the {@link OpenStackCloudProvider} to compare with
   * @return if the two Cloud Providers are equal in regards to their name
   */
  private boolean equals( final OpenStackCloudProvider vo ) {
    return getName().equals( vo.getName() );
  }

  /**
   * Find the {@link OpenStackCloudProviderProperties} in the list of children of this VO.
   * 
   * @return This VO's properties.
   * @throws ProblemException if an error occurs while fetching the list of
   *           children.
   */
  public OpenStackCloudProviderProperties getProperties() throws ProblemException {
    OpenStackCloudProviderProperties properties = null;
    ICloudElement[] children = getChildren( null );

    for( ICloudElement child : children ) {
      if( child instanceof OpenStackCloudProviderProperties ) {
        properties = ( OpenStackCloudProviderProperties )child;
        break;
      }
    }
    return properties;
  }

  /**
   * Gets all the children in this {@link ICloudContainer}, which are an instance
   * of the passed elementType.
   * <p>
   * Method is defined not to check type conversions because it is ensured via
   * {@link Class#isInstance(Object)}.
   * 
   * @param <T> the type extending the {@link ICloudElement}
   * @param monitor the monitor to track progress
   * @param elementType the element type to filter by
   * @return a list of {@link ICloudElement}s which are an implementation of
   *         <code>&lt;T&gt;</code> or an empty {@link List}
   *         <code>&lt;T&gt;</code>
   * @throws ProblemException when the extraction of the children was not
   *           successful
   */
  @SuppressWarnings("unchecked")
  public <T extends ICloudElement> List<T> getChildren( final IProgressMonitor monitor,
                                                       final Class<T> elementType )
    throws ProblemException
  {
    ICloudElement[] children = getChildren( monitor );
    List<T> childrenList = new ArrayList<T>();
    if( elementType != null ) {
      for( ICloudElement cloudElement : children ) {
        if( elementType.isInstance( cloudElement ) ) {
          childrenList.add( ( T )cloudElement );
        }
      }
    }
    return childrenList;
  }

  public String getId() {
    return this.getClass().getName();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getDescription()
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
