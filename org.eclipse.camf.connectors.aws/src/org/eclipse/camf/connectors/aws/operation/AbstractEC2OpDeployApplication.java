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
public abstract class AbstractEC2OpDeployApplication implements IOperation {
  
  /** Any exception which came up during the inquiry. */
  private Exception exception;
  
  private Object result;

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  abstract public void run();

  /* (non-Javadoc)
   * @see org.eclipse.camf.connectors.aws.operation.IOperation#getResult()
   */
  @Override
  public Object getResult() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.connectors.aws.operation.IOperation#getException()
   */
  @Override
  public Exception getException() {
    // TODO Auto-generated method stub
    return this.exception;
  }
  
  protected void setException( final Exception ex ) {
    this.exception = ex;
  }
  
  protected void setResult (final Object result) {
    this.result = result;
  }
}
