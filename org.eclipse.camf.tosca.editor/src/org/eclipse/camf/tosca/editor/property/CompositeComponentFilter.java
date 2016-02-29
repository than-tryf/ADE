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
package org.eclipse.camf.tosca.editor.property;

import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

/** Filters out all other object than composite application component for
 *  displaying properties
 *
 */
public class CompositeComponentFilter extends AbstractPropertySectionFilter {

  @Override
  protected boolean accept( PictogramElement pe ) {
    EObject bo = Graphiti.getLinkService()
      .getBusinessObjectForLinkedPictogramElement( pe );
    if( bo instanceof TServiceTemplate
        && ( ( TServiceTemplate )bo ).getSubstitutableNodeType() != null )
    {
      return true;
    }
    return false;
  }
}
