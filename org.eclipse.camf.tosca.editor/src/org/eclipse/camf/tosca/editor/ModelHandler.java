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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;


/**
 * @author Nicholas Loulloudes
 * Operations for handling the TOSCA model
 */
public class ModelHandler {
  private static Map<URI, ToscaModelLayer> modelMap = new HashMap<URI, ToscaModelLayer>();
  
  public static void addModel(final URI uri, final ToscaModelLayer model) {
      modelMap.put(uri, model);
  }
  
  public static ToscaModelLayer getModel(final URI uri) {
      return modelMap.get(uri);
  }
  
  public static void removeModel(URI uri) {
      modelMap.remove(uri);
  }
  
  public static List<String> getModelURIList() {
      List<String> modelURIList = new ArrayList<String>();
      for(ToscaModelLayer model : modelMap.values()) {
          modelURIList.add(model.getModelFile().getRawLocationURI().toString());
      }
      return modelURIList;
  }
}
