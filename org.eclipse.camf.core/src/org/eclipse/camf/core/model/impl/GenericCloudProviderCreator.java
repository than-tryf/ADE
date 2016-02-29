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
package org.eclipse.camf.core.model.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICreatorSourceMatcher;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;

/**
 * Cloud element creator for the {@link GenericCloudProvider}.
 */
public class GenericCloudProviderCreator
    extends AbstractCloudElementCreator
    implements ICreatorSourceMatcher {
  
  /**
   * The creators extension ID.
   */
  private static final String EXTENSION_ID = "eu.geclipse.core.genericVoCreator"; //$NON-NLS-1$
  
  private String voName;
  private String voUri;
  private String voPort;
  
  private List< ICloudElementCreator > serviceCreators
    = new ArrayList< ICloudElementCreator >();


  
//  private List<ICloudService> serviceMaintainers = new ArrayList<ICloudService>();
  
  public void createService( final ICloudElementCreator creator,
                             final URI fromURI )
      throws ProblemException {
    creator.setSource( fromURI );
    this.serviceCreators.add( creator );
  }
  
//  public void maintainService( final ICloudService service ) {
//    this.serviceMaintainers.add( service );
//  }
//  
  /**
   * Apply this creators settings to the specified VO.
   * 
   * @param cp The {@link GenericVirtualOrganization} to which to
   * apply this creators settings.
   * @throws ProblemException 
   */
  public void apply( final GenericCloudProvider cp ) throws ProblemException {
    
    ICloudElement[] children = cp.getChildren( null );
    
    for ( ICloudElement child : children ) {
//      if ( ( child instanceof ICloudService ) && ! this.serviceMaintainers.contains( child ) ) {
//        cp.delete( child );
//      }
    }
    
    for ( ICloudElementCreator serviceCreator : this.serviceCreators ) {
      cp.create( serviceCreator );
    }

  }

  public boolean canCreate( final Object source ) {
    
    boolean result = false;
    
    if ( source instanceof IFileStore ) {
      IFileStore propertiesStore = ( ( IFileStore ) source ).getChild( GenericCloudProviderProperties.NAME );
      IFileInfo propertiesInfo = propertiesStore.fetchInfo();
      result = propertiesInfo.exists();
    }
    
    return result;
    
  }
  
  public ICloudElement create( final ICloudContainer parent ) throws ProblemException {
    GenericCloudProvider cp = null;
    Object source = getSource();
    if ( source == null ) {
      cp = new GenericCloudProvider( this );
    } else if ( source instanceof IFileStore ) {
      IFileStore fileStore = ( IFileStore ) source;
      cp = new GenericCloudProvider( fileStore );
    }
    return cp;
  }
  
  public String getExtensionID() {
    return EXTENSION_ID;
  }

  /**
   * Get the VO's name.
   * 
   * @return The unique name of the VO.
   */
  public String getVoName() {
    return this.voName;
  }
  
  public String getVoURI() {
    return this.voUri;
  }
  
  public String getVoPort() {
    return this.voPort;
  }
  
  /**
   * Set the VO's name.
   * 
   * @param name The unique name of the VO.
   */
  public void setVoName( final String name ) {
    this.voName = name;
  }
  
  public void setVoURI( final String uri ) {
    this.voUri = uri;
  }
  
  public void setVoPort( final String port ) {
    this.voPort = port;
  }

}
