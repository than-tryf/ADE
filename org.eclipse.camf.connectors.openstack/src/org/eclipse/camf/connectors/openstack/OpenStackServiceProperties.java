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
package org.eclipse.camf.connectors.openstack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ISerializableElement;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;




/**
 * The {@link OpenStackServiceProperties} hold the various properties specific to the
 * OpenStack infrastructure. Both in terms of OpenStack specific as well as CAMF
 * specific means. The currently kept properties are:
 * <ul>
 * <li>{@link #ec2Url}</li>
 * <li>{@link #serviceName}</li>
 * </ul>
 * These properties are kept on persistent storage under the key provided by
 * {@link #STORAGE_NAME}.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackService
 */
public class OpenStackServiceProperties extends AbstractCloudElement
  implements ISerializableElement
{

  /** Name to reference the properties. */
  public static final String STORAGE_NAME = ".os_service_properties"; //$NON-NLS-1$

  /** The parent {@link IGridElement}. */
  private OpenStackService osService;

  /** The url to access OpenStack webservices. */
  private String osUrl;

  /** The name of this {@link IOpenStackService} */
  private String serviceName;

  /**
   * Create a new properties object with the given {@link OpenStackService} as parent.
   * 
   * @param osService the parent {@link ICloudElement}
   */
  public OpenStackServiceProperties( final OpenStackService osService ) {
    this.osService = osService;
  }

  /**
   * Create a new properties object with the given {@link EC2Service} as parent.
   * The {@link OpenStackServiceCreator} provides the initial properties.
   * 
   * @param osService the parent {@link IGridElement}
   * @param serviceCreator the provider for configuration directives
   */
  public OpenStackServiceProperties( final OpenStackService osService,
                               final OpenStackServiceCreator serviceCreator )
  {
    this.osService = osService;
    this.osUrl = serviceCreator.getServiceURL();
    this.serviceName = serviceCreator.getServiceName();
  }

  public void deserialize() throws ProblemException {
    BufferedReader bufferedReader = null;
    try {
      IFileStore fileStore = getFileStore();
      InputStream iStream = fileStore.openInputStream( EFS.NONE, null );
      InputStreamReader iReader = new InputStreamReader( iStream );
      bufferedReader = new BufferedReader( iReader );

      String serviceName = bufferedReader.readLine();
      if ( serviceName != null && serviceName.trim().length() != 0 ) {
        this.serviceName = serviceName;
      }

      String url = bufferedReader.readLine();
      if ( url != null && url.trim().length() != 0 ) {
        this.osUrl = url;
      }
    } catch ( IOException ioExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  ioExc,
                                  Activator.PLUGIN_ID );
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } finally {
      if ( bufferedReader != null ) {
        try {
          bufferedReader.close();
        } catch ( IOException ioExc ) {
          throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                    ioExc,
                                    Activator.PLUGIN_ID );
        }
      }
    }
  }

  public void serialize() throws ProblemException {
    IFileStore fileStore = getFileStore();
    BufferedWriter bWriter = null;
    try {
      OutputStream oStream = fileStore.openOutputStream( EFS.NONE, null );
      OutputStreamWriter osWriter = new OutputStreamWriter( oStream );
      bWriter = new BufferedWriter( osWriter );

      if ( this.serviceName != null ) {
        bWriter.write( this.serviceName );
      }
      bWriter.write( '\n' );

      if ( this.osUrl != null ) {
        bWriter.write( this.osUrl );
      }
      bWriter.write( '\n' );
    } catch ( IOException ioExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  ioExc,
                                  Activator.PLUGIN_ID );
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } finally {
      try {
        if ( bWriter != null ) {
          bWriter.close();
        }
      } catch ( IOException ioExc ) {
        throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                    ioExc,
                                    Activator.PLUGIN_ID );
      }
    }
  }

  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( getName() );
  }

  public String getName() {
    return OpenStackServiceProperties.STORAGE_NAME;
  }

  public ICloudContainer getParent() {
    return this.osService;
  }

  public IPath getPath() {
    return getParent().getPath().append( getName() );
  }

  public IResource getResource() {
    return null;
  }

  public boolean isLocal() {
    return true;
  }

  /**
   * A getter for the OpenStack {@link URL}.
   * 
   * @return the {@link URL} to the OpenStack service.
   */
  public String getOpenStackUrl() {
    return this.osUrl;
  }

  /**
   * A setter for the OpenStack {@link URL}
   * 
   * @param osUrl the url to set
   */
  public void getOpenStackUrl( final String osUrl ) {
    this.osUrl = osUrl;
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
}
