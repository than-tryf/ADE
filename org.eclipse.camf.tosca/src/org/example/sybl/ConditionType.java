/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
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
package org.example.sybl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.ConditionType#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}</li>
 *   <li>{@link org.example.sybl.ConditionType#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getConditionType()
 * @model extendedMetaData="name='Condition_._1_._type' kind='elementOnly'"
 * @generated
 */
public interface ConditionType extends EObject
{
  /**
	 * Returns the value of the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.sybl.BinaryRestriction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binary Restrictions Conjunction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary Restrictions Conjunction</em>' containment reference list.
	 * @see org.example.sybl.SyblPackage#getConditionType_BinaryRestrictionsConjunction()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='BinaryRestrictionsConjunction'"
	 * @generated
	 */
  EList<BinaryRestriction> getBinaryRestrictionsConjunction();

  /**
	 * Returns the value of the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.sybl.UnaryRestriction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unary Restrictions Conjunction</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Restrictions Conjunction</em>' containment reference list.
	 * @see org.example.sybl.SyblPackage#getConditionType_UnaryRestrictionsConjunction()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='UnaryRestrictionsConjunction'"
	 * @generated
	 */
  EList<UnaryRestriction> getUnaryRestrictionsConjunction();

} // ConditionType
