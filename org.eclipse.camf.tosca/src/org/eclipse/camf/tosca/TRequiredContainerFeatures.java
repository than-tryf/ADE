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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/
/**
 */
package org.eclipse.camf.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRequired Container Features</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TRequiredContainerFeatures#getRequiredContainerFeature <em>Required Container Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTRequiredContainerFeatures()
 * @model extendedMetaData="name='tRequiredContainerFeatures' kind='elementOnly'"
 * @generated
 */
public interface TRequiredContainerFeatures extends EObject
{
  /**
   * Returns the value of the '<em><b>Required Container Feature</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TRequiredContainerFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Container Feature</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Container Feature</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTRequiredContainerFeatures_RequiredContainerFeature()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='RequiredContainerFeature' namespace='##targetNamespace'"
   * @generated
   */
  EList<TRequiredContainerFeature> getRequiredContainerFeature();

} // TRequiredContainerFeatures
