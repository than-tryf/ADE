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
 * A representation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.Strategy#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.example.sybl.Strategy#getToEnforce <em>To Enforce</em>}</li>
 *   <li>{@link org.example.sybl.Strategy#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getStrategy()
 * @model extendedMetaData="name='Strategy' kind='elementOnly'"
 * @generated
 */
public interface Strategy extends EObject
{
  /**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionType)
	 * @see org.example.sybl.SyblPackage#getStrategy_Condition()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Condition'"
	 * @generated
	 */
  ConditionType getCondition();

  /**
	 * Sets the value of the '{@link org.example.sybl.Strategy#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
  void setCondition(ConditionType value);

  /**
	 * Returns the value of the '<em><b>To Enforce</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Enforce</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>To Enforce</em>' containment reference.
	 * @see #setToEnforce(ToEnforceType)
	 * @see org.example.sybl.SyblPackage#getStrategy_ToEnforce()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='ToEnforce'"
	 * @generated
	 */
  ToEnforceType getToEnforce();

  /**
	 * Sets the value of the '{@link org.example.sybl.Strategy#getToEnforce <em>To Enforce</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Enforce</em>' containment reference.
	 * @see #getToEnforce()
	 * @generated
	 */
  void setToEnforce(ToEnforceType value);

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
	 * @see org.example.sybl.SyblPackage#getStrategy_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Id'"
	 * @generated
	 */
  String getId();

  /**
	 * Sets the value of the '{@link org.example.sybl.Strategy#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(String value);

} // Strategy
