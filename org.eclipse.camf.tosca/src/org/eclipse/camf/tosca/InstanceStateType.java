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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance State Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.InstanceStateType#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getInstanceStateType()
 * @model extendedMetaData="name='InstanceState_._type' kind='empty'"
 * @generated
 */
public interface InstanceStateType extends EObject
{
  /**
   * Returns the value of the '<em><b>State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' attribute.
   * @see #setState(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getInstanceStateType_State()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
   *        extendedMetaData="kind='attribute' name='state'"
   * @generated
   */
  String getState();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.InstanceStateType#getState <em>State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' attribute.
   * @see #getState()
   * @generated
   */
  void setState(String value);

} // InstanceStateType
