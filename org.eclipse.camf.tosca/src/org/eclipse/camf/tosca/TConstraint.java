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

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TConstraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TConstraint#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TConstraint#getConstraintType <em>Constraint Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTConstraint()
 * @model extendedMetaData="name='tConstraint' kind='elementOnly'"
 * @generated
 */
public interface TConstraint extends EObject
{
  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTConstraint_Any()
   * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true" many="false"
   *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':0' processing='lax'"
   * @generated
   */
  FeatureMap getAny();

  /**
   * Returns the value of the '<em><b>Constraint Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint Type</em>' attribute.
   * @see #setConstraintType(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTConstraint_ConstraintType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI" required="true"
   *        extendedMetaData="kind='attribute' name='constraintType'"
   * @generated
   */
  String getConstraintType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TConstraint#getConstraintType <em>Constraint Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint Type</em>' attribute.
   * @see #getConstraintType()
   * @generated
   */
  void setConstraintType(String value);

} // TConstraint
