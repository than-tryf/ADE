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
 * A representation of the model object '<em><b>TDeployment Artifacts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TDeploymentArtifacts#getDeploymentArtifact <em>Deployment Artifact</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTDeploymentArtifacts()
 * @model extendedMetaData="name='tDeploymentArtifacts' kind='elementOnly'"
 * @generated
 */
public interface TDeploymentArtifacts extends EObject
{
  /**
   * Returns the value of the '<em><b>Deployment Artifact</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TDeploymentArtifact}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Deployment Artifact</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Deployment Artifact</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTDeploymentArtifacts_DeploymentArtifact()
   * @model containment="true" required="true"
   *        extendedMetaData="kind='element' name='DeploymentArtifact' namespace='##targetNamespace'"
   * @generated
   */
  EList<TDeploymentArtifact> getDeploymentArtifact();

} // TDeploymentArtifacts
