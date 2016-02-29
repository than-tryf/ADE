/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.aws.operation;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface IOperation extends Runnable {
  
  /**
   * Returns the result of the operation executed in the {@link Runnable#run()}
   * method of this {@link IOperation}.
   * 
   * @return the result of the operation or <code>null</code> if an error
   *         occurred
   */
  public Object getResult();

  /**
   * Returns any exception which came up during the execution of the
   * {@link Runnable#run()} method.
   * 
   * @return the exception which might have come up or <code>null</code> if no
   *         error occurred
   */
  public Exception getException();
}
