/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/

package org.eclipse.camf.tosca.core;

import java.io.File;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.impl.ResourceCloudContainer;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.IOWrappedException;

public class TOSCAResource extends ResourceCloudContainer implements ICloudApplicationDescription {
  
  private TOSCAModel model;
  protected ToscaFactory toscaFactory = ToscaFactory.eINSTANCE;
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;
  
  public TOSCAResource(final IFile file) {
    super (file);
    try {
      this.model = new TOSCAModel( new File( file.getLocation().toOSString() ) );
    } catch( IOWrappedException e ) {
      e.printStackTrace();
    }
  }
  
  /**
   * @return the complete TOSCAModel
   */
  public TOSCAModel getTOSCAModel(){
    return this.model;
  }

  @Override
  public String getApplicationName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationVersion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationExecutable() {
    // TODO Auto-generated method stub
    return null;
  }
  
  /**
   * @param name
   */
  public void setApplicationName(final String name) {
    this.model.getServiceTemplate().setName( name );
  }
    
  public void setUpBasicTOSCAStructure() {
    this.model.setUpBasicStructure();
  }
  
  public void save() {
    writeModelToFile( this.model.getDocumentRoot() );
  }
  
  private void writeModelToFile( final EObject toscaRoot ) {
    this.model.writeModelToFile( toscaRoot );
    try {
      this.getResource().refreshLocal( 0, new NullProgressMonitor() );
    } catch( CoreException exc ) {
      exc.printStackTrace();
    }
  }
 
}
