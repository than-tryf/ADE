package org.eclipse.camf.deployment;

import java.net.URI;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudDeploymentID;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudDeploymentStatus;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.impl.AbstractCloudElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.core.TOSCAResource;

/**
 * @author Nicholas Loulloudes, Stalo Sofokleous
 */
public class CELARApplicationDeploymentService extends AbstractCloudElement
  implements ICloudDeploymentService
{

  private ICloudContainer parent = null;

  public CELARApplicationDeploymentService( final ICloudContainer parent )
  {
    this.parent = parent;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
    return "OpenStack"; //$NON-NLS-1$
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getPath()
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
   * @see eu.celar.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.parent;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return false;
  }

  /*
   * (non-Javadoc)
   * @see eu.celar.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /*
   * (non-Javadoc)
   * @see
   * eu.celar.core.model.ICloudDeploymentService#canDeploy(eu.celar.core.model
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
   * eu.celar.core.model.ICloudDeploymentService#submitJob(eu.celar.core.model
   * .ICloudApplicationDescription, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final IProgressMonitor monitor )
    throws ProblemException
  {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * @see
   * eu.celar.core.model.ICloudDeploymentService#submitJob(eu.celar.core.model
   * .ICloudApplicationDescription, eu.celar.core.model.ICloudProvider,
   * org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentID deployApplication( final ICloudApplicationDescription description,
                                               final ICloudProvider vo,
                                               final IProgressMonitor monitor )
    throws ProblemException
  {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * @see
   * eu.celar.core.model.ICloudDeploymentService#getJobStatus(eu.celar.core.
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
