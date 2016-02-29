/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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
 *    Moritz Post - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.connectors.aws.ec2;

/**
 * A container interface to hold category ids as specified in the
 * <code>plugin.xml</code>.
 * 
 * @author Moritz Post
 */
public interface IEC2Categories {

  /** A category for EC2 images. */
  public static final String CATEGORY_EC2_IMAGES = "org.eclipse.camf.connectors.aws.ec2.images"; //$NON-NLS-1$

//  /** A category for EC2 AMIs belonging to the current user. */
//  public static final String CATEGORY_EC2_IMAGES_MY_OWNED = "org.eclipse.camf.connectors.aws.ec2.myOwned"; //$NON-NLS-1$
//
//  /** A category for EC2 AMIs to which the user has execution rights. */
//  public static final String CATEGORY_EC2_IMAGES_MY_ACCESSIBLE = "org.eclipse.camf.connectors.aws.ec2.myAccessible"; //$NON-NLS-1$
//
//  /** A category for EC2 AMIs belonging to any user (all public AMIs). */
//  public static final String CATEGORY_EC2_IMAGES_ALL = "org.eclipse.camf.connectors.aws.ec2.allImages"; //$NON-NLS-1$
//
  /** A category to contain security groups. */
  public static final String CATEGORY_EC2_SECURITY = "org.eclipse.camf.connectors.aws.ec2.security"; //$NON-NLS-1$

  /** A category to contain keypairs. */
  public static final String CATEGORY_EC2_KEYPAIRS = "org.eclipse.camf.connectors.aws.ec2.keypairs"; //$NON-NLS-1$

  /** A category to contain elastic IPs. */
  public static final String CATEGORY_EC2_ELASTIC_IP = "org.eclipse.camf.connectors.aws.ec2.elasticIP"; //$NON-NLS-1$

}
