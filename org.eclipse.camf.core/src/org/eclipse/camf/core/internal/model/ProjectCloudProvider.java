/*****************************************************************************
 * Copyright (c) 2006-2008 g-Eclipse Consortium 
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
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.internal.model;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudInfoService;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResource;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ICloudService;
import org.eclipse.camf.core.model.IWrappedElement;
import org.eclipse.camf.core.model.impl.AbstractCloudContainer;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import org.eclipse.camf.core.internal.Activator;


/**
 * Wrapper of a VO in order to map the VO from the manager to a
 * project.
 */
public class ProjectCloudProvider extends AbstractCloudContainer
  implements ICloudProvider, IWrappedElement
{
  
  private static final String NA_STRING = "N/A"; //$NON-NLS-1$

  private ICloudProject project;
  
  private String providerName;
  
  /**
   * Definition of standard categories that are used whenever a VO does not specify
   * dedicated categories.
   */
  public static final ICloudResourceCategory[] standardCategories
    = new ICloudResourceCategory[] {
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_APPLICATIONS ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_COMPUTING ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_DATA_SERVICES ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_INFO_SERVICES ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_JOB_SERVICES ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_OTHER_SERVICES ),
      CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_STORAGE )
  };
  
  protected ProjectCloudProvider (final ICloudProject project,
                                  final ICloudProvider cloudProvider) {
    super();
    this.project = project;
    this.providerName = cloudProvider.getName();
    
    ICloudResourceCategory[] supportedCategories = cloudProvider.getSupportedCategories();
    for( ICloudResourceCategory category : supportedCategories ) {
      try {
        getResourceContainer( category );
      } catch( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
  }
  
  @Override
  public boolean canContain( final ICloudElement element ) {
    return element instanceof ResourceCategoryContainer; // QueryContainer;
  }
  
  public ICloudResource[] getAvailableResources( final ICloudResourceCategory category,
                                                final boolean exclusive,
                                                final IProgressMonitor monitor )
      throws ProblemException {
    ICloudResource[] result = null;
    ICloudProvider vo = getSlave();
    if ( vo != null ) {
      ICloudInfoService infoService = vo.getInfoService();
      if ( infoService != null ) {
        result = infoService.fetchResources( this, vo, category, false, null, monitor );
      }
    }
    return result;
  }
  
  public ICloudResourceCategory[] getSupportedCategories() {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getSupportedCategories() : standardCategories;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudContainer#isLazy()
   */
  @Override
  public boolean isLazy() {    
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getProject().getFileStore().getChild( getName() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return this.project.getPath().append( getName() );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }
  
  @Override
  public ICloudProject getProject() {
    return this.project;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.project;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ISerializableElement#serialize()
   */
  @Override
  public void serialize() throws ProblemException {
    // TODO Auto-generated method stub
  }
  
  public ICloudInfoService getInfoService()
      throws ProblemException {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getInfoService() : null;
  }
  
  @SuppressWarnings( "unchecked" )
  @Override
  public Object getAdapter( final Class adapter ) {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getAdapter( adapter ) : null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ISerializableElement#deserialize()
   */
  @Override
  public void deserialize() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IWrappedElement#getWrappedElement()
   */
  @Override
  public ICloudElement getWrappedElement() {
    return getSlave();
  }
  
  @Override
  public void refresh( final IProgressMonitor monitor ) throws ProblemException {
    
    ICloudElement[] children = getChildren( null );
    
    SubMonitor sMonitor = SubMonitor.convert( monitor, "Refreshing Cloud Provider resources", children.length );
    
    for ( ICloudElement elem : children ) {
      if ( elem instanceof ICloudContainer ) {
        ( ( ICloudContainer ) elem ).refresh( sMonitor.newChild( 1 ) );
      }
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getName()
   */
  @Override
  public String getName() {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getName() : "CloudProvider-Wrapper";     //$NON-NLS-1$
  }
  
  protected ICloudProvider getSlave() {
    ICloudProvider result
      = ( ICloudProvider ) CloudProviderManager.getManager().findChild( this.providerName );
    return result;
  }
  
  public ICloudService[] getServices( final IProgressMonitor monitor )
      throws ProblemException {
    
    ICloudService[] result = null;
    ICloudProvider vo = getSlave();
    
    if ( vo != null ) {
      
      ICloudInfoService infoService = vo.getInfoService();
      ICloudResource[] resources = infoService.fetchResources(
          this,
          vo,
          CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_SERVICES ),
          false,
          ICloudService.class,
          monitor );
      
      if ( resources != null ) {
        result = new ICloudService[ resources.length ];
        for ( int i = 0 ; i < resources.length ; i++ ) {
          result[ i ] = ( ICloudService ) resources[ i ];
        }
      }
      
    }
    
    return result;
    
  }
  
  @Override
  public void setDirty() {
    try {
      for ( ICloudElement child : getChildren( null ) ) {
        if ( child instanceof ICloudContainer ) {
          ( ( ICloudContainer ) child ).setDirty();
        }
      }
    } catch ( ProblemException pExc ) {
      // Should never happen, if it does we will at least log it
      Activator.logException( pExc );
    }
  }  

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getId()
   */
  public String getId() {
    ICloudProvider vo = getSlave();
    return vo != null ? vo.getId() : NA_STRING;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getDescription()
   */
  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getTypeName()
   */
  @Override
  public String getTypeName() {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getTypeName() : NA_STRING;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getWizardId()
   */
  @Override
  public String getWizardId() {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getWizardId() : null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudProvider#getDeploymentServices(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudDeploymentService[] getDeploymentServices( final IProgressMonitor monitor )
    throws ProblemException
  {
    ICloudProvider cp = getSlave();
    return cp != null ? cp.getDeploymentServices( monitor ) : new ICloudDeploymentService[ 0 ];
  }
  
  private ResourceCategoryContainer getResourceContainer( final ICloudResourceCategory category )
      throws ProblemException {
    
    ResourceCategoryContainer result = null;
    
    String name = category.getName();
    ICloudResourceCategory parentCategory = category.getParent();
    
    ICloudContainer parentContainer
      = parentCategory == null
        ? this
        : getResourceContainer( parentCategory );
    
    ICloudElement child = parentContainer.findChild( name );
    
    if ( ( child == null ) || ! ( child instanceof ResourceCategoryContainer ) ) {
      result = new ResourceCategoryContainer( parentContainer, category );
      if ( parentContainer == this ) {
        addElement( result );
      } else {
        ( ( ResourceCategoryContainer ) parentContainer ).addChild( result );
      }
    } else {
      result = ( ResourceCategoryContainer ) child;
    }
    
    return result;
    
  }
}
