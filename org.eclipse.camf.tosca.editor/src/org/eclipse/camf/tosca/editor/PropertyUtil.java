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

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {

	public static final String SHAPE_KEY = "shape-id"; //$NON-NLS-1$

	public static final String SHAPE_VALUE_E_CLASS = "e-class"; //$NON-NLS-1$

	public static final void setEClassShape(PictogramElement pe) {
		Graphiti.getPeService().setPropertyValue(pe, SHAPE_KEY, SHAPE_VALUE_E_CLASS);
	}

	public static boolean isEClassShape(PictogramElement pe) {
		return SHAPE_VALUE_E_CLASS.equals(Graphiti.getPeService().getPropertyValue(pe, SHAPE_KEY));
	}
}
