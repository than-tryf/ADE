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
 * A representation of the model object '<em><b>TRequirement Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TRequirementType#getRequiredCapabilityType <em>Required Capability Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTRequirementType()
 * @model extendedMetaData="name='tRequirementType' kind='elementOnly'"
 * @generated
 */
public interface TRequirementType extends TEntityType
{
  /**
   * Returns the value of the '<em><b>Required Capability Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Capability Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Capability Type</em>' attribute.
   * @see #setRequiredCapabilityType(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTRequirementType_RequiredCapabilityType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
   *        extendedMetaData="kind='attribute' name='requiredCapabilityType'"
   * @generated
   */
  QName getRequiredCapabilityType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TRequirementType#getRequiredCapabilityType <em>Required Capability Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required Capability Type</em>' attribute.
   * @see #getRequiredCapabilityType()
   * @generated
   */
  void setRequiredCapabilityType(QName value);

} // TRequirementType
