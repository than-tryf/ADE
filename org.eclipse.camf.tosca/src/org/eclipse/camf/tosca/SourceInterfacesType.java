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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Interfaces Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.SourceInterfacesType#getInterface <em>Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getSourceInterfacesType()
 * @model extendedMetaData="name='SourceInterfaces_._type' kind='elementOnly'"
 * @generated
 */
public interface SourceInterfacesType extends EObject
{
  /**
   * Returns the value of the '<em><b>Interface</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TInterface}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getSourceInterfacesType_Interface()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='Interface' namespace='##targetNamespace'"
   * @generated
   */
  EList<TInterface> getInterface();

} // SourceInterfacesType
