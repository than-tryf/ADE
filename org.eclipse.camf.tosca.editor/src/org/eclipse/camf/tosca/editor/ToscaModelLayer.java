/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor;

import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.features.IFeatureProvider;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaModelLayer {
  protected IFile modelFile;
  private IFeatureProvider featureProvider;
  private TTopologyTemplate topology;
  private DocumentRoot documentRoot;
  
  public ToscaModelLayer (final IFeatureProvider featureProvider, final IFile modelFile) {
    this.featureProvider = featureProvider;
    this.modelFile = modelFile;
  }
  
  public IFeatureProvider getFeatureProvider() {
    return this.featureProvider;
  }
  
  public void setFeatureProvider(final IFeatureProvider featureProvider) {
    this.featureProvider = featureProvider;
  }
  
  public TTopologyTemplate getTopology() {
    return this.documentRoot.getDefinitions().getServiceTemplate().get( 0 ).getTopologyTemplate();
  }
  
  public void setTopology(final TTopologyTemplate topology) {
    this.topology = topology;
  }
  
  public IFile getModelFile() {
    return this.modelFile;
}

  public DocumentRoot getDocumentRoot() {
    return this.documentRoot;
  }

  public void setDocumentRoot( final DocumentRoot documentRoot ) {
    this.documentRoot = documentRoot;
  }
  
}
