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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Definition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getPropertiesDefinitionType()
 * @model extendedMetaData="name='PropertiesDefinition_._type' kind='empty'"
 * @generated
 */
public interface PropertiesDefinitionType extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' attribute.
   * @see #setElement(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getPropertiesDefinitionType_Element()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
   *        extendedMetaData="kind='attribute' name='element'"
   * @generated
   */
  QName getElement();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getElement <em>Element</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' attribute.
   * @see #getElement()
   * @generated
   */
  void setElement(QName value);

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
   * @see org.eclipse.camf.tosca.ToscaPackage#getPropertiesDefinitionType_Type()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
   *        extendedMetaData="kind='attribute' name='type'"
   * @generated
   */
  QName getType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(QName value);

} // PropertiesDefinitionType
