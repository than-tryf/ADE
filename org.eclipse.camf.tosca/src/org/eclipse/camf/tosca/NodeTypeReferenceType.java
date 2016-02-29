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
 * A representation of the model object '<em><b>Node Type Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.NodeTypeReferenceType#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getNodeTypeReferenceType()
 * @model extendedMetaData="name='NodeTypeReference_._type' kind='empty'"
 * @generated
 */
public interface NodeTypeReferenceType extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' attribute.
   * @see #setTypeRef(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getNodeTypeReferenceType_TypeRef()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='typeRef'"
   * @generated
   */
  QName getTypeRef();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.NodeTypeReferenceType#getTypeRef <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' attribute.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(QName value);

} // NodeTypeReferenceType
