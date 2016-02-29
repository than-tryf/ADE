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
 * A representation of the model object '<em><b>TNode Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getCapabilities <em>Capabilities</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getPolicies <em>Policies</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getDeploymentArtifacts <em>Deployment Artifacts</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TNodeTemplate#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate()
 * @model extendedMetaData="name='tNodeTemplate' kind='elementOnly'"
 * @generated
 */
public interface TNodeTemplate extends TEntityTemplate
{
  /**
   * Returns the value of the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requirements</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requirements</em>' containment reference.
   * @see #setRequirements(RequirementsType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_Requirements()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Requirements' namespace='##targetNamespace'"
   * @generated
   */
  RequirementsType getRequirements();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getRequirements <em>Requirements</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Requirements</em>' containment reference.
   * @see #getRequirements()
   * @generated
   */
  void setRequirements(RequirementsType value);

  /**
   * Returns the value of the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capabilities</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Capabilities</em>' containment reference.
   * @see #setCapabilities(CapabilitiesType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_Capabilities()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Capabilities' namespace='##targetNamespace'"
   * @generated
   */
  CapabilitiesType getCapabilities();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getCapabilities <em>Capabilities</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Capabilities</em>' containment reference.
   * @see #getCapabilities()
   * @generated
   */
  void setCapabilities(CapabilitiesType value);

  /**
   * Returns the value of the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Policies</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Policies</em>' containment reference.
   * @see #setPolicies(PoliciesType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_Policies()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='Policies' namespace='##targetNamespace'"
   * @generated
   */
  PoliciesType getPolicies();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getPolicies <em>Policies</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Policies</em>' containment reference.
   * @see #getPolicies()
   * @generated
   */
  void setPolicies(PoliciesType value);

  /**
   * Returns the value of the '<em><b>Deployment Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deployment Artifacts</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deployment Artifacts</em>' containment reference.
   * @see #setDeploymentArtifacts(TDeploymentArtifacts)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_DeploymentArtifacts()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='DeploymentArtifacts' namespace='##targetNamespace'"
   * @generated
   */
  TDeploymentArtifacts getDeploymentArtifacts();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getDeploymentArtifacts <em>Deployment Artifacts</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deployment Artifacts</em>' containment reference.
   * @see #getDeploymentArtifacts()
   * @generated
   */
  void setDeploymentArtifacts(TDeploymentArtifacts value);

  /**
   * Returns the value of the '<em><b>Max Instances</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Instances</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Instances</em>' attribute.
   * @see #isSetMaxInstances()
   * @see #unsetMaxInstances()
   * @see #setMaxInstances(Object)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_MaxInstances()
   * @model default="1" unsettable="true" dataType="org.eclipse.camf.tosca.MaxInstancesType"
   *        extendedMetaData="kind='attribute' name='maxInstances'"
   * @generated
   */
  Object getMaxInstances();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Instances</em>' attribute.
   * @see #isSetMaxInstances()
   * @see #unsetMaxInstances()
   * @see #getMaxInstances()
   * @generated
   */
  void setMaxInstances(Object value);

  /**
   * Unsets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMaxInstances()
   * @see #getMaxInstances()
   * @see #setMaxInstances(Object)
   * @generated
   */
  void unsetMaxInstances();

  /**
   * Returns whether the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Max Instances</em>' attribute is set.
   * @see #unsetMaxInstances()
   * @see #getMaxInstances()
   * @see #setMaxInstances(Object)
   * @generated
   */
  boolean isSetMaxInstances();

  /**
   * Returns the value of the '<em><b>Min Instances</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Instances</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Instances</em>' attribute.
   * @see #isSetMinInstances()
   * @see #unsetMinInstances()
   * @see #setMinInstances(int)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_MinInstances()
   * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
   *        extendedMetaData="kind='attribute' name='minInstances'"
   * @generated
   */
  int getMinInstances();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min Instances</em>' attribute.
   * @see #isSetMinInstances()
   * @see #unsetMinInstances()
   * @see #getMinInstances()
   * @generated
   */
  void setMinInstances(int value);

  /**
   * Unsets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSetMinInstances()
   * @see #getMinInstances()
   * @see #setMinInstances(int)
   * @generated
   */
  void unsetMinInstances();

  /**
   * Returns whether the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}' attribute is set.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return whether the value of the '<em>Min Instances</em>' attribute is set.
   * @see #unsetMinInstances()
   * @see #getMinInstances()
   * @see #setMinInstances(int)
   * @generated
   */
  boolean isSetMinInstances();

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
   * @see org.eclipse.camf.tosca.ToscaPackage#getTNodeTemplate_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TNodeTemplate#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // TNodeTemplate
