/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Szymon Mueller
 *    Nicholas Loulloudes - code adapter for CELAR Project, 2013
 *    Andreas Kastanas - added json deployment string
 *****************************************************************************/

package org.eclipse.camf.core;

/**
 * Preference Constants that will be used throughout the CAMF framework.
 */
public class PreferenceConstants {

	/**
	 * The id for the defined Cloud Providers .
	 */
	public static final String DEFINED_CPS_ID = "cps"; //$NON-NLS-1$

	/**
	 * The id for the name of the default Cloud Provider.
	 */
	public static final String DEFAULT_CLOUD_PROVIDER_ID = "def_cp"; //$NON-NLS-1$

	/**
	 * The JSON deployment string
	 */
	public static final String DEPLOYMENTS = "deps";
}
