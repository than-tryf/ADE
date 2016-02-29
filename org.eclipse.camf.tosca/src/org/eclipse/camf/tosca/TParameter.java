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
 * A representation of the model object '<em><b>TParameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TParameter#getRequired <em>Required</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTParameter()
 * @model extendedMetaData="name='tParameter' kind='empty'"
 * @generated
 */
public interface TParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTParameter_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TParameter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Required</b></em>' attribute.
   * The default value is <code>"yes"</code>.
   * The literals are from the enumeration {@link org.eclipse.camf.tosca.TBoolean}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required</em>' attribute.
   * @see org.eclipse.camf.tosca.TBoolean
   * @see #isSetRequired()
   * @see #unsetRequired()
   * @see #setRequired(TBoolean)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTParameter_Required()
   * @model default="yes" unsettable="true"
   *        extendedMetaData="kind='attribute' name='required'"
   * @generated
   */
  TBoolean getRequired();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TParameter#getRequired <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required</em>' attribute.
   * @see org.eclipse.camf.tosca.TBoolean
   * @see #isSetRequired()
   * @see #unsetRequired()
   * @see #getRequired()
   * @generated
   */
  void setRequired(TBoolean value);

  /**
   * Unsets the value of the '{@link org.eclipse.camf.tosca.TParameter#getRequired <em>Required</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetRequired()
   * @see #getRequired()
   * @see #setRequired(TBoolean)
   * @generated
   */
  void unsetRequired();

  /**
   * Returns whether the value of the '{@link org.eclipse.camf.tosca.TParameter#getRequired <em>Required</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Required</em>' attribute is set.
   * @see #unsetRequired()
   * @see #getRequired()
   * @see #setRequired(TBoolean)
   * @generated
   */
  boolean isSetRequired();

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
   * @see org.eclipse.camf.tosca.ToscaPackage#getTParameter_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='attribute' name='type'"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TParameter#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // TParameter
