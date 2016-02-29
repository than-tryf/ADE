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
 * A representation of the model object '<em><b>Unary Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.UnaryRestriction#getMetric <em>Metric</em>}</li>
 *   <li>{@link org.example.sybl.UnaryRestriction#getReferenceTo <em>Reference To</em>}</li>
 *   <li>{@link org.example.sybl.UnaryRestriction#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getUnaryRestriction()
 * @model extendedMetaData="name='UnaryRestriction' kind='elementOnly'"
 * @generated
 */
public interface UnaryRestriction extends EObject
{
  /**
	 * Returns the value of the '<em><b>Metric</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metric</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric</em>' attribute.
	 * @see #setMetric(String)
	 * @see org.example.sybl.SyblPackage#getUnaryRestriction_Metric()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Metric'"
	 * @generated
	 */
  String getMetric();

  /**
	 * Sets the value of the '{@link org.example.sybl.UnaryRestriction#getMetric <em>Metric</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric</em>' attribute.
	 * @see #getMetric()
	 * @generated
	 */
  void setMetric(String value);

  /**
	 * Returns the value of the '<em><b>Reference To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference To</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference To</em>' containment reference.
	 * @see #setReferenceTo(ReferenceToType)
	 * @see org.example.sybl.SyblPackage#getUnaryRestriction_ReferenceTo()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ReferenceTo'"
	 * @generated
	 */
  ReferenceToType getReferenceTo();

  /**
	 * Sets the value of the '{@link org.example.sybl.UnaryRestriction#getReferenceTo <em>Reference To</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference To</em>' containment reference.
	 * @see #getReferenceTo()
	 * @generated
	 */
  void setReferenceTo(ReferenceToType value);

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
	 * @see org.example.sybl.SyblPackage#getUnaryRestriction_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
  String getType();

  /**
	 * Sets the value of the '{@link org.example.sybl.UnaryRestriction#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
  void setType(String value);

} // UnaryRestriction
