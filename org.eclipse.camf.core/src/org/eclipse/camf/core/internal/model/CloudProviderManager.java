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

import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.IElementCreatorRegistry;
import org.eclipse.camf.core.model.ISerializableElement;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.camf.core.internal.Activator;


/**
 * @author Nicholas Loulloudes, Stalo Sofokleous
 *
 */
public class CloudProviderManager extends AbstractDefaultCloudElementManager
  implements ICloudProviderManager
{

  /**
   * The name of this manager. This is also used as the storage area.
   */
  public static final String NAME = ".cps"; //$NON-NLS-1$
  
  /**
   * The singleton.
   */
  private static CloudProviderManager singleton;
    
  /**
   * Private constructor to ensure to have only one instance of
   * this class. This can be obtained by {@link #getManager()}.
   */
  private CloudProviderManager() {
    try {
      deserializeElements();
    } catch ( ProblemException pExc ) {
      Activator.logException( pExc );
    }
  }
  
  /**
   * Get the singleton instance of the <code>VoManager</code>.
   * 
   * @return The singleton.
   */
  public static CloudProviderManager getManager() {
    if ( singleton == null ) {
      singleton = new CloudProviderManager();
    }
    return singleton;
  }
  
  /**
   * Static implementation of the {@link #getFileStore()} method that
   * is needed to avoid cyclic dependencies when the model is created.
   * 
   * @return The managers file store.
   */
  public static IFileStore getVoManagerStore() {
    IFileStore managerStore = getManagerStore();
    IFileStore childStore = managerStore.getChild( NAME );
    IFileInfo childInfo = childStore.fetchInfo();
    if ( !childInfo.exists() ) {
      try {
        childStore.mkdir( EFS.NONE, null );
      } catch( CoreException cExc ) {
        Activator.logException( cExc );
      }
    }
    return childStore;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElementManager#canManage(org.eclipse.camf.core.model.ICloudElement)
   */
  public boolean canManage( final ICloudElement element ) {
    return element instanceof ICloudProvider;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.internal.model.AbstractCloudElementManager#getName()
   */
  public String getName() {
    return NAME;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ISerializableElementManager#deserializeElements()
   */
  public void deserializeElements() throws ProblemException {
    
    IFileStore fileStore = getFileStore();
    
    IFileStore[] childStores;
    try {
      childStores = fileStore.childStores( EFS.NONE, null );
    } catch ( CoreException cExc ) {
      throw new ProblemException( ICoreProblems.MODEL_ELEMENT_LOAD_FAILED,
                                  cExc,
                                  Activator.PLUGIN_ID );
    }
    
    IElementCreatorRegistry registry = CloudModel.getCreatorRegistry();
    for ( IFileStore childStore : childStores ) {
      try {
        ICloudElementCreator creator = registry.getCreator( childStore, ICloudProvider.class );
        if ( creator != null ) {
          create( creator );
        }
      } catch ( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
    
    String defaultVoName = Preferences.getDefaultVoName();
    if ( defaultVoName != null ) {
      ICloudElement defaultVo = findChild( defaultVoName );
      setDefault( defaultVo );
    }
    
    if ( hasChildren() ) {
      updateDefault();
    }
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ISerializableElementManager#serializeElements()
   */
  public void serializeElements() throws ProblemException {
    
    ICloudElement[] elements = getChildren( null );
    for ( ICloudElement element : elements ) {
      if ( element instanceof ISerializableElement ) {
        ( ( ISerializableElement ) element ).serialize();  
      }
    }
    
    ICloudProvider defaultCloudProvider
      = ( ICloudProvider ) getDefault();
    if ( defaultCloudProvider != null ) {
      Preferences.setDefaultCloudProviderName( defaultCloudProvider.getName() );
      Preferences.save();
    }
    
  }
  
}
