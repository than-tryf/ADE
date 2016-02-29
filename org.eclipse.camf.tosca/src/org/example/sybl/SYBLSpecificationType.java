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
 * A representation of the model object '<em><b>SYBL Specification Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.SYBLSpecificationType#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.example.sybl.SYBLSpecificationType#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.example.sybl.SYBLSpecificationType#getId <em>Id</em>}</li>
 *   <li>{@link org.example.sybl.SYBLSpecificationType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getSYBLSpecificationType()
 * @model extendedMetaData="name='SYBLSpecification_._type' kind='elementOnly'"
 * @generated
 */
public interface SYBLSpecificationType extends EObject
{
  /**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.sybl.Constraint}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see org.example.sybl.SyblPackage#getSYBLSpecificationType_Constraint()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Constraint'"
	 * @generated
	 */
  EList<Constraint> getConstraint();

  /**
	 * Returns the value of the '<em><b>Strategy</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.sybl.Strategy}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strategy</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy</em>' containment reference list.
	 * @see org.example.sybl.SyblPackage#getSYBLSpecificationType_Strategy()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Strategy'"
	 * @generated
	 */
  EList<Strategy> getStrategy();

  /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.example.sybl.SyblPackage#getSYBLSpecificationType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
  String getId();

  /**
	 * Sets the value of the '{@link org.example.sybl.SYBLSpecificationType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(String value);

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
	 * @see org.example.sybl.SyblPackage#getSYBLSpecificationType_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
  String getType();

  /**
	 * Sets the value of the '{@link org.example.sybl.SYBLSpecificationType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
  void setType(String value);

} // SYBLSpecificationType
