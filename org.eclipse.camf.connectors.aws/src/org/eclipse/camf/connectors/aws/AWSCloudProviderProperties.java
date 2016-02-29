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
package org.eclipse.camf.connectors.aws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.eclipse.camf.connectors.aws.internal.Activator;
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
 * The {@link AWSCloudProviderProperties} class is a javabean class able to store and
 * retrieve values to be used by a {@link AWSCloudProvider}. The storage
 * container used here is the {@link IFileStore}. The class uses plain
 * {@link BufferedReader} and {@link BufferedWriter} to read and write the data
 * from the store. Each storage element is serialized to a String and stored
 * line by line.
 * <p>
 * To explicitly identify this storage element, the {@link #STORAGE_NAME}
 * property holds the fixed key <code>".aws_vo_properties"</code>.
 * <p>
 * TODO: Implement a more sophisticated storage schema.
 * 
 * @author Moritz Post
 * @see AWSCloudProvider
 * @see AWSCloudProviderCreator
 */
public class AWSCloudProviderProperties extends AbstractCloudElement
  implements ISerializableElement, ICloudProviderProperties
{

  /** Name to reference the properties in the {@link CloudModel}. */
  public static final String STORAGE_NAME = ".aws_cp_properties"; //$NON-NLS-1$

  /** The virtual organization these properties belong to. */
  private AWSCloudProvider cp;

  /** The aws access id to bind this VO to a specific account. */
  private String awsAccessId;

  /**
   * This constructor creates a new instance of the {@link AWSCloudProviderProperties} with
   * the {@link AWSCloudProvider} provided and uses the property data in
   * the {@link AWSCloudProviderCreator} to populate its own bean fields.
   * 
   * @param cloudProvider to {@link AWSCloudProvider} to be
   *            associated with
   * @param cpCreator the {@link AWSCloudProviderCreator} to get the data from
   */
  public AWSCloudProviderProperties( final AWSCloudProvider cloudProvider,
                          final AWSCloudProviderCreator cpCreator )
  {
    this.cp = cloudProvider;
    if( cpCreator != null ) {
      this.awsAccessId = cpCreator.getAwsAccessId();
    }
  }

  /**
   * Convenience constructor to associate the properties with a
   * {@link AWSCloudProvider} but without populating any fields. Maps to
   * {@link #AWSCloudProviderProperties(AWSCloudProvider, AWSCloudProviderCreator)} where the
   * {@linkplain AWSCloudProviderCreator creator} is <code>null</code>.
   * 
   * @param cloudProvider the {@link AWSCloudProvider} to associate
   *            with
   */
  public AWSCloudProviderProperties( final AWSCloudProvider cloudProvider ) {
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
      this.awsAccessId = bufferedReader.readLine();
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioEx ) {
      Activator.log( "Could not load aws vo properties", ioEx ); //$NON-NLS-1$
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
      if ( this.awsAccessId != null ) {
        osWriter.write( this.awsAccessId + "\n" ); //$NON-NLS-1$
      }
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_SAVE_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    } catch ( IOException ioEx ) {
      Activator.log( "Could not save aws cp properties", ioEx ); //$NON-NLS-1$
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
    return AWSCloudProviderProperties.STORAGE_NAME;
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
   * A getter for the {@link #awsAccessId}.
   * 
   * @return the awsAccessId
   */
  public String getAwsAccessId() {
    return this.awsAccessId;
  }

  /**
   * A setter for the {@link #awsAccessId}.
   * 
   * @param awsAccessId the awsAccessId to set
   */
  public void setAwsAccessId( final String awsAccessId ) {
    this.awsAccessId = awsAccessId;
  }
}
