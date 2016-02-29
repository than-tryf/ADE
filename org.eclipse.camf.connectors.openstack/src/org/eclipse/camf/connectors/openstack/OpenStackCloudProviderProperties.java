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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;

import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudProviderProperties;
import org.eclipse.camf.core.model.ISerializableElement;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;


/**
 * The {@link OpenStackCloudProviderProperties} class is a javabean class able to store and
 * retrieve values to be used by a {@link OpenStackCloudProvider}. The storage
 * container used here is the {@link IFileStore}. The class uses plain
 * {@link BufferedReader} and {@link BufferedWriter} to read and write the data
 * from the store. Each storage element is serialized to a String and stored
 * line by line.
 * <p>
 * To explicitly identify this storage element, the {@link #STORAGE_NAME}
 * property holds the fixed key <code>".openstack_vo_properties"</code>.
 * <p>
 * TODO: Implement a more sophisticated storage schema.
 * 
 * @author Nicholas Loulloudes
 * @see OpenStackCloudProvider
 * @see OpenStackCloudProviderCreator
 */
public class OpenStackCloudProviderProperties extends AbstractCloudElement
  implements ISerializableElement, ICloudProviderProperties
{

  /** Name to reference the properties in the {@link CloudModel}. */
  public static final String STORAGE_NAME = ".openstack_cp_properties"; //$NON-NLS-1$

  /** The virtual organization these properties belong to. */
  private OpenStackCloudProvider cp;

  /** The OpenStack access id to bind this CP to a specific account. */
  private String openstackAccessId;
  
  /** The OpenStack endpoint URI to bind this CP to a specific account. */
  private URI openstackEndPoint;

  /**
   * This constructor creates a new instance of the {@link OpenStackCloudProviderProperties} with
   * the {@link OpenStackCloudProvider} provided and uses the property data in
   * the {@link OpenStackCloudProviderCreator} to populate its own bean fields.
   * 
   * @param cloudProvider to {@link OpenStackCloudProvider} to be
   *            associated with
   * @param cpCreator the {@link OpenStackCloudProviderCreator} to get the data from
   */
  public OpenStackCloudProviderProperties( final OpenStackCloudProvider cloudProvider,
                          final OpenStackCloudProviderCreator cpCreator )
  {
    this.cp = cloudProvider;
    if( cpCreator != null ) {
      this.openstackAccessId = cpCreator.getOpenStackAccessId();
      this.openstackEndPoint = cpCreator.getEndPoint();
    }
  }

  /**
   * Convenience constructor to associate the properties with a
   * {@link OpenStackCloudProvider} but without populating any fields. Maps to
   * {@link #OpenStackCloudProviderProperties(OpenStackCloudProvider, OpenStackCloudProviderCreator)} where the
   * {@linkplain OpenStackCloudProviderCreator creator} is <code>null</code>.
   * 
   * @param cloudProvider the {@link OpenStackCloudProvider} to associate
   *            with
   */
  public OpenStackCloudProviderProperties( final OpenStackCloudProvider cloudProvider ) {
    this( cloudProvider, null );
  }

  @Override
  public void deserialize() throws ProblemException {
    BufferedReader bufferedReader = null;
    try {
      IFileStore fileStore = getFileStore();
      InputStream iStream = fileStore.openInputStream( EFS.NONE, null );
      InputStreamReader iReader = new InputStreamReader( iStream );
      bufferedReader = new BufferedReader( iReader );

      // load from file
      this.openstackAccessId = bufferedReader.readLine();
      this.openstackEndPoint = URI.create( bufferedReader.readLine() );
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioEx ) {
      Activator.log( "Could not load OpenStack Cloud Provider properties", ioEx ); //$NON-NLS-1$
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  ioEx,
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

  @Override
  public void serialize() throws ProblemException {
    IFileStore fileStore = getFileStore();
    OutputStreamWriter osWriter = null;
    try {
      OutputStream oStream = fileStore.openOutputStream( EFS.NONE, null );
      osWriter = new OutputStreamWriter( oStream );

      // write output
      if ( this.openstackAccessId != null ) {
        osWriter.write( this.openstackAccessId + "\n" ); //$NON-NLS-1$
      }
      if ( this.openstackEndPoint != null ) {
        osWriter.write( this.openstackEndPoint.toString() + "\n" ); //$NON-NLS-1$
      }
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioEx ) {
      Activator.log( "Could not save OpenStack cp properties", ioEx ); //$NON-NLS-1$
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  ioEx,
                                  Activator.PLUGIN_ID );
    } finally {
      try {
        if ( osWriter != null ) {
          osWriter.close();
        }
      } catch ( IOException ioExc ) {
        throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                    ioExc,
                                    Activator.PLUGIN_ID );
      }
    }
  }

  @Override
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( getName() );
  }

  @Override
  public String getName() {
    return OpenStackCloudProviderProperties.STORAGE_NAME;
  }

  @Override
  public ICloudContainer getParent() {
    return this.cp;
  }

  @Override
  public IPath getPath() {
    return getParent().getPath().append( getName() );
  }

  @Override
  public IResource getResource() {
    return null;
  }

  @Override
  public boolean isLocal() {
    return true;
  }

  /**
   * A getter for the {@link #openstackAccessId}.
   * 
   * @return the openstackAccessId
   */
  public String getOpenStackAccessId() {
    return this.openstackAccessId;
  }
  
  
  /**
   * A getter for the {@link #openstackEndPoint}.
   * 
   * @return the openstackEndPoint
   */
  public URI getOpenStackEndpoint() {
    return this.openstackEndPoint;
  }

  /**
   * A setter for the {@link #openstackAccessId}.
   * 
   * @param openstackAccessId the openstackAccessId to set
   */
  public void setOpenStackAccessId( final String openstackAccessId ) {
    this.openstackAccessId = openstackAccessId;
  }
  
  /**
   * A setter for the {@link #openstackEndPoint}.
   * 
   * @param openstackEndPoint the openstackEndPoint to set
   */
  public void setOpenStackEndPoint( final URI openstackEndPoint ) {
    this.openstackEndPoint = openstackEndPoint;
  }
}
