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
 * A representation of the model object '<em><b>TImplementation Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactRef <em>Artifact Ref</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactType <em>Artifact Type</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TImplementationArtifact#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TImplementationArtifact#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTImplementationArtifact()
 * @model extendedMetaData="name='tImplementationArtifact' kind='elementOnly'"
 * @generated
 */
public interface TImplementationArtifact extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Artifact Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Artifact Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Artifact Ref</em>' attribute.
   * @see #setArtifactRef(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTImplementationArtifact_ArtifactRef()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName"
   *        extendedMetaData="kind='attribute' name='artifactRef'"
   * @generated
   */
  QName getArtifactRef();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactRef <em>Artifact Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Artifact Ref</em>' attribute.
   * @see #getArtifactRef()
   * @generated
   */
  void setArtifactRef(QName value);

  /**
   * Returns the value of the '<em><b>Artifact Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Artifact Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Artifact Type</em>' attribute.
   * @see #setArtifactType(QName)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTImplementationArtifact_ArtifactType()
   * @model dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
   *        extendedMetaData="kind='attribute' name='artifactType'"
   * @generated
   */
  QName getArtifactType();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactType <em>Artifact Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Artifact Type</em>' attribute.
   * @see #getArtifactType()
   * @generated
   */
  void setArtifactType(QName value);

  /**
   * Returns the value of the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface Name</em>' attribute.
   * @see #setInterfaceName(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTImplementationArtifact_InterfaceName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
   *        extendedMetaData="kind='attribute' name='interfaceName'"
   * @generated
   */
  String getInterfaceName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TImplementationArtifact#getInterfaceName <em>Interface Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface Name</em>' attribute.
   * @see #getInterfaceName()
   * @generated
   */
  void setInterfaceName(String value);

  /**
   * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Name</em>' attribute.
   * @see #setOperationName(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTImplementationArtifact_OperationName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.NCName"
   *        extendedMetaData="kind='attribute' name='operationName'"
   * @generated
   */
  String getOperationName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TImplementationArtifact#getOperationName <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Name</em>' attribute.
   * @see #getOperationName()
   * @generated
   */
  void setOperationName(String value);

} // TImplementationArtifact
