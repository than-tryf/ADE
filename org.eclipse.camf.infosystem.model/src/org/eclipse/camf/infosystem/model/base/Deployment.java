/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Andreas Kastanas - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Deployment#getDepID <em>Dep ID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Deployment#getDeploymentName <em>Deployment Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Deployment#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Deployment#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getDeployment()
 * @model
 * @generated
 */
public interface Deployment extends EObject {
	/**
   * Returns the value of the '<em><b>Dep ID</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dep ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Dep ID</em>' attribute.
   * @see #setDepID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getDeployment_DepID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getDepID();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Deployment#getDepID <em>Dep ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dep ID</em>' attribute.
   * @see #getDepID()
   * @generated
   */
	void setDepID(String value);

	/**
   * Returns the value of the '<em><b>Deployment Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Deployment Name</em>' attribute.
   * @see #setDeploymentName(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getDeployment_DeploymentName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getDeploymentName();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Deployment#getDeploymentName <em>Deployment Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Deployment Name</em>' attribute.
   * @see #getDeploymentName()
   * @generated
   */
	void setDeploymentName(String value);

	/**
   * Returns the value of the '<em><b>Modules</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.Module}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getDeployment_Modules()
   * @model required="true"
   * @generated
   */
	EList<Module> getModules();

	/**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see #setStatus(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getDeployment_Status()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getStatus();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Deployment#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see #getStatus()
   * @generated
   */
	void setStatus(String value);

} // Deployment
