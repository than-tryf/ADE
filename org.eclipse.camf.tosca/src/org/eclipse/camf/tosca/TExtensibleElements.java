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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExtensible Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TExtensibleElements#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TExtensibleElements#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TExtensibleElements#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTExtensibleElements()
 * @model extendedMetaData="name='tExtensibleElements' kind='elementOnly'"
 * @generated
 */
public interface TExtensibleElements extends EObject
{
  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TDocumentation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentation</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTExtensibleElements_Documentation()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='documentation' namespace='##targetNamespace'"
   * @generated
   */
  EList<TDocumentation> getDocumentation();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTExtensibleElements_Any()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' wildcards='##other' name=':1' processing='lax'"
   * @generated
   */
  FeatureMap getAny();

  /**
   * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any Attribute</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTExtensibleElements_AnyAttribute()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':2' processing='lax'"
   * @generated
   */
  FeatureMap getAnyAttribute();

} // TExtensibleElements
