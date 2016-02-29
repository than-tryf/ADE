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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.BinaryRestriction#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.example.sybl.BinaryRestriction#getRightHandSide <em>Right Hand Side</em>}</li>
 *   <li>{@link org.example.sybl.BinaryRestriction#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getBinaryRestriction()
 * @model extendedMetaData="name='BinaryRestriction' kind='elementOnly'"
 * @generated
 */
public interface BinaryRestriction extends EObject
{
  /**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #setLeftHandSide(LeftHandSideType)
	 * @see org.example.sybl.SyblPackage#getBinaryRestriction_LeftHandSide()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='LeftHandSide'"
	 * @generated
	 */
  LeftHandSideType getLeftHandSide();

  /**
	 * Sets the value of the '{@link org.example.sybl.BinaryRestriction#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
	 * @see #getLeftHandSide()
	 * @generated
	 */
  void setLeftHandSide(LeftHandSideType value);

  /**
	 * Returns the value of the '<em><b>Right Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Hand Side</em>' containment reference.
	 * @see #setRightHandSide(RightHandSideType)
	 * @see org.example.sybl.SyblPackage#getBinaryRestriction_RightHandSide()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='RightHandSide'"
	 * @generated
	 */
  RightHandSideType getRightHandSide();

  /**
	 * Sets the value of the '{@link org.example.sybl.BinaryRestriction#getRightHandSide <em>Right Hand Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Hand Side</em>' containment reference.
	 * @see #getRightHandSide()
	 * @generated
	 */
  void setRightHandSide(RightHandSideType value);

  /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.example.sybl.SyblPackage#getBinaryRestriction_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
  String getType();

  /**
	 * Sets the value of the '{@link org.example.sybl.BinaryRestriction#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
  void setType(String value);

} // BinaryRestriction
