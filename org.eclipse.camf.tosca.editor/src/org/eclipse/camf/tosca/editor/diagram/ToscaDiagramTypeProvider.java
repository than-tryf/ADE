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
package org.eclipse.camf.tosca.editor.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class ToscaDiagramTypeProvider extends AbstractDiagramTypeProvider {

  private IToolBehaviorProvider[] toolBehaviorProviders;

  public ToscaDiagramTypeProvider() {
    super();
    setFeatureProvider( new ToscaFeatureProvider( this ) );
  }

  @Override
  public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
    if( this.toolBehaviorProviders == null ) {
      this.toolBehaviorProviders = new IToolBehaviorProvider[]{
        new ToscaToolBehaviorProvider( this )
      };
    }
    return this.toolBehaviorProviders;
  }
}
