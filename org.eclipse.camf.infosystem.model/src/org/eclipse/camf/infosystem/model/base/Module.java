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
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Module#getModID <em>Mod ID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Module#getModuleName <em>Module Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Module#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Module#getInitInstances <em>Init Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject {
	/**
   * Returns the value of the '<em><b>Mod ID</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mod ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Mod ID</em>' attribute.
   * @see #setModID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getModule_ModID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getModID();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Module#getModID <em>Mod ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mod ID</em>' attribute.
   * @see #getModID()
   * @generated
   */
	void setModID(String value);

	/**
   * Returns the value of the '<em><b>Module Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Module Name</em>' attribute.
   * @see #setModuleName(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getModule_ModuleName()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getModuleName();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Module#getModuleName <em>Module Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Module Name</em>' attribute.
   * @see #getModuleName()
   * @generated
   */
	void setModuleName(String value);

	/**
   * Returns the value of the '<em><b>Instances</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.VirtualInstance}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Instances</em>' reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getModule_Instances()
   * @model required="true"
   * @generated
   */
	EList<VirtualInstance> getInstances();

	/**
   * Returns the value of the '<em><b>Init Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Init Instances</em>' attribute.
   * @see #setInitInstances(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getModule_InitInstances()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getInitInstances();

	/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Module#getInitInstances <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Instances</em>' attribute.
   * @see #getInitInstances()
   * @generated
   */
	void setInitInstances(String value);

} // Module
