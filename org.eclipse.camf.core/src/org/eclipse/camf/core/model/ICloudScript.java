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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.core.model;

/**
 * This is the base interface that all Cloud script should implement.
 *
 */
public interface ICloudScript extends ICloudContainer {
  
  /**
   * @return The script name
   */
  public String getScriptName();
  
  /**
   * @return free text of what the script does
   */
  public String getScriptDescription();
  
  /**
   * @return the script version
   */
  public String getScriptVersion();  
}
