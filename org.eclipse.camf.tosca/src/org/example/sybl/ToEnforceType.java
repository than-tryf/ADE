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
 * A representation of the model object '<em><b>To Enforce Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.ToEnforceType#getActionName <em>Action Name</em>}</li>
 *   <li>{@link org.example.sybl.ToEnforceType#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getToEnforceType()
 * @model extendedMetaData="name='ToEnforce_._1_._type' kind='empty'"
 * @generated
 */
public interface ToEnforceType extends EObject
{
  /**
	 * Returns the value of the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Name</em>' attribute.
	 * @see #setActionName(String)
	 * @see org.example.sybl.SyblPackage#getToEnforceType_ActionName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='ActionName'"
	 * @generated
	 */
  String getActionName();

  /**
	 * Sets the value of the '{@link org.example.sybl.ToEnforceType#getActionName <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Name</em>' attribute.
	 * @see #getActionName()
	 * @generated
	 */
  void setActionName(String value);

  /**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' attribute.
	 * @see #setParameter(String)
	 * @see org.example.sybl.SyblPackage#getToEnforceType_Parameter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Parameter'"
	 * @generated
	 */
  String getParameter();

  /**
	 * Sets the value of the '{@link org.example.sybl.ToEnforceType#getParameter <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' attribute.
	 * @see #getParameter()
	 * @generated
	 */
  void setParameter(String value);

} // ToEnforceType
