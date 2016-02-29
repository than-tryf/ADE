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

import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDeployApplication;
import org.eclipse.camf.connectors.openstack.operation.OperationExecuter;
import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudDeploymentID;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudDeploymentStatus;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Nicholas Loulloudes
 */
public class OpenStackApplicationDeploymentService extends AbstractCloudElement
  implements ICloudDeploymentService
{

  private ICloudContainer parent = null;

  public OpenStackApplicationDeploymentService( final ICloudContainer parent )
  {
    this.parent = parent;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return "OpenStack"; //$NON-NLS-1$
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    IPath result = null;
    ICloudContainer par = getParent();
    if( par != null ) {
      result = par.getPath().append( getName() );
    }
    return result;
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
    return this.parent;
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
   * org.eclipse.camf.core.model.ICloudDeploymentService#canDeploy(org.eclipse.camf.core.model
   * .ICloudApplicationDescription)
   */
  @Override
  public boolean canDeploy( ICloudApplicationDescription desc ) {
    boolean result = false;
    if( desc instanceof TOSCAResource ) {
      result = true;
    }
    return result;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.camf.core.model.ICloudDeploymentService#submitJob(org.eclipse.camf.core.model
   * .ICloudApplicationDescription, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final IProgressMonitor monitor )
    throws ProblemException
  {
    OpenStackOpDeployApplication deployOperation = null;
    try {
      monitor.beginTask( "Deploying VMIs", 2 );
      deployOperation = new OpenStackOpDeployApplication( OpenStackClient.getInstance(),
                                                   description );
      
        if( deployOperation.getException() != null ) {
        throw deployOperation.getException();
      }
      new OperationExecuter().execOp( deployOperation );
    } catch( Exception e ) {
      e.printStackTrace( );
      
    } finally {
      monitor.done();
    }
    
    return null;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.camf.core.model.ICloudDeploymentService#submitJob(org.eclipse.camf.core.model
   * .ICloudApplicationDescription, org.eclipse.camf.core.model.ICloudProvider,
   * org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final ICloudProvider vo,
                                               final IProgressMonitor monitor )
    throws ProblemException
  {
    OpenStackOpDeployApplication deployOperation = null;
    try {
      monitor.beginTask( "Deploying VMIs", 2 );
      TOSCAModel model;
      if (description instanceof TOSCAModel){
        model = (TOSCAModel) description;
      }

      deployOperation = new OpenStackOpDeployApplication( OpenStackClient.getInstance(),
                                                   (TOSCAResource) description );
      
        if( deployOperation.getException() != null ) {
        throw deployOperation.getException();
      }
      new OperationExecuter().execOp( deployOperation );
    } catch( Exception e ) {
      e.printStackTrace( );
      
    } finally {
      monitor.done();
    }
    
    return null;
  }

  /*
   * (non-Javadoc)
   * @see
   * org.eclipse.camf.core.model.ICloudDeploymentService#getJobStatus(org.eclipse.camf.core.
   * model.ICloudDeploymentID, org.eclipse.core.runtime.IProgressMonitor,
   * boolean, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentStatus getDeploymentStatus( final ICloudDeploymentID id,
                                                     final IProgressMonitor vo,
                                                     final boolean fullStatus,
                                                     final IProgressMonitor monitor )
    throws ProblemException
  {
    // TODO Auto-generated method stub
    return null;
  }
}
