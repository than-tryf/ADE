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
 * 	Andreas Kastanas - initial API and implementation
 *******************************************************************************/

package org.eclipse.camf.connectors.openstack.operation;

/**
 * This is an implementation of Custom Exceptions that are used to catch jClouds
 * exceptions and re-throw them in a more user-friendly way
 * 
 * @author Andreas Kastanas
 */

public class OpenStackOpExceptions extends Exception {
	private static final long serialVersionUID = 1L;

	public enum ExceptionType {
		FLAVORS, IMAGES, INSTANCE, KEYPAIR, NETWORK, SECURITY_GROUP, DEPLOY, TERMINATE
	};

	private String message = null;
	private ExceptionType extype;

	public OpenStackOpExceptions() {
		super();
	}

	/**
	 * Creates custom exception based on the parameters given
	 * 
	 * @param message
	 *            Custom Exception message
	 * @param type
	 *            Custom Exception type
	 */
	public OpenStackOpExceptions(String message, ExceptionType type) {
		super(message);
		this.message = type + " Exception: " + message;
		this.extype = type;
	}

	public OpenStackOpExceptions(Throwable cause) {
		super(cause);
	}

	public ExceptionType getExceptionType() {
		return this.extype;
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}