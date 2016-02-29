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

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TEntity Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TEntityTemplate#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TEntityTemplate#getPropertyConstraints <em>Property Constraints</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TEntityTemplate#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TEntityTemplate#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTEntityTemplate()
 * @model abstract="true"
 *        extendedMetaData="name='tEntityTemplate' kind='elementOnly'"
 * @generated
 */
public interface TEntityTemplate extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference.
   * @see #setProperties(PropertiesType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTEntityTemplate_Properties()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Properties' namespace='##targetNamespace'"
   * @generated
   */
  PropertiesType getProperties();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TEntityTemplate#getProperties <em>Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' containment reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(PropertiesType value);

  /**
   * Returns the value of the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property Constraints</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property Constraints</em>' containment reference.
   * @see #setPropertyConstraints(PropertyConstraintsType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTEntityTemplate_PropertyConstraints()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='PropertyConstraints' namespace='##targetNamespace'"
   * @generated
   */
  PropertyConstraintsType getPropertyConstraints();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TEntityTemplate#getPropertyConstraints <em>Property Constraints</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property Constraints</em>' containment reference.
   * @see #getPropertyConstraints()
   * @generated
   */
  void setPropertyConstraints(PropertyConstraintsType value);

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
   * @see org.eclipse.camf.tosca.ToscaPackage#getTEntityTemplate_Id()
   * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
   *        extendedMetaData="kind='attribute' name='id'"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TEntityTemplate#getId <em>Id</em>}' attribute.
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
   * @see #setType(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTEntityTemplate_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='type'"
   * @generated
   */
  QName getType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TEntityTemplate#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(QName value);

} // TEntityTemplate
