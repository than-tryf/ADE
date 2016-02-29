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
 * A representation of the model object '<em><b>TPlans</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TPlans#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TPlans#getTargetNamespace <em>Target Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTPlans()
 * @model extendedMetaData="name='tPlans' kind='elementOnly'"
 * @generated
 */
public interface TPlans extends EObject
{
  /**
   * Returns the value of the '<em><b>Plan</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TPlan}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plan</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Plan</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTPlans_Plan()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Plan' namespace='##targetNamespace'"
   * @generated
   */
  EList<TPlan> getPlan();

  /**
   * Returns the value of the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Namespace</em>' attribute.
   * @see #setTargetNamespace(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTPlans_TargetNamespace()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
   *        extendedMetaData="kind='attribute' name='targetNamespace'"
   * @generated
   */
  String getTargetNamespace();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TPlans#getTargetNamespace <em>Target Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Namespace</em>' attribute.
   * @see #getTargetNamespace()
   * @generated
   */
  void setTargetNamespace(String value);

} // TPlans
