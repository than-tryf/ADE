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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNode Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TNodeType#getRequirementDefinitions <em>Requirement Definitions</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeType#getCapabilityDefinitions <em>Capability Definitions</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeType#getInstanceStates <em>Instance States</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeType#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeType()
 * @model extendedMetaData="name='tNodeType' kind='elementOnly'"
 * @generated
 */
public interface TNodeType extends TEntityType
{
  /**
   * Returns the value of the '<em><b>Requirement Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirement Definitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirement Definitions</em>' containment reference.
   * @see #setRequirementDefinitions(RequirementDefinitionsType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeType_RequirementDefinitions()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='RequirementDefinitions' namespace='##targetNamespace'"
   * @generated
   */
  RequirementDefinitionsType getRequirementDefinitions();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeType#getRequirementDefinitions <em>Requirement Definitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirement Definitions</em>' containment reference.
   * @see #getRequirementDefinitions()
   * @generated
   */
  void setRequirementDefinitions(RequirementDefinitionsType value);

  /**
   * Returns the value of the '<em><b>Capability Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capability Definitions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capability Definitions</em>' containment reference.
   * @see #setCapabilityDefinitions(CapabilityDefinitionsType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeType_CapabilityDefinitions()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='CapabilityDefinitions' namespace='##targetNamespace'"
   * @generated
   */
  CapabilityDefinitionsType getCapabilityDefinitions();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeType#getCapabilityDefinitions <em>Capability Definitions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capability Definitions</em>' containment reference.
   * @see #getCapabilityDefinitions()
   * @generated
   */
  void setCapabilityDefinitions(CapabilityDefinitionsType value);

  /**
   * Returns the value of the '<em><b>Instance States</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance States</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance States</em>' containment reference.
   * @see #setInstanceStates(TTopologyElementInstanceStates)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeType_InstanceStates()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='InstanceStates' namespace='##targetNamespace'"
   * @generated
   */
  TTopologyElementInstanceStates getInstanceStates();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeType#getInstanceStates <em>Instance States</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance States</em>' containment reference.
   * @see #getInstanceStates()
   * @generated
   */
  void setInstanceStates(TTopologyElementInstanceStates value);

  /**
   * Returns the value of the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interfaces</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interfaces</em>' containment reference.
   * @see #setInterfaces(InterfacesType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeType_Interfaces()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Interfaces' namespace='##targetNamespace'"
   * @generated
   */
  InterfacesType getInterfaces();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeType#getInterfaces <em>Interfaces</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interfaces</em>' containment reference.
   * @see #getInterfaces()
   * @generated
   */
  void setInterfaces(InterfacesType value);

} // TNodeType
