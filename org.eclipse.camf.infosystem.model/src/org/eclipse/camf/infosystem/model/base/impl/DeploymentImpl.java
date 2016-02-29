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
package org.eclipse.camf.infosystem.model.base.impl;

import java.util.Collection;

import org.eclipse.camf.infosystem.model.base.Deployment;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.Module;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl#getDepID <em>Dep ID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl#getDeploymentName <em>Deployment Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl#getStatus <em>Status</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeploymentImpl extends EObjectImpl implements Deployment {
	/**
   * The default value of the '{@link #getDepID() <em>Dep ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDepID()
   * @generated
   * @ordered
   */
	protected static final String DEP_ID_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getDepID() <em>Dep ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDepID()
   * @generated
   * @ordered
   */
	protected String depID = DEP_ID_EDEFAULT;

	/**
   * The default value of the '{@link #getDeploymentName() <em>Deployment Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDeploymentName()
   * @generated
   * @ordered
   */
	protected static final String DEPLOYMENT_NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getDeploymentName() <em>Deployment Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDeploymentName()
   * @generated
   * @ordered
   */
	protected String deploymentName = DEPLOYMENT_NAME_EDEFAULT;

	/**
   * The cached value of the '{@link #getModules() <em>Modules</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModules()
   * @generated
   * @ordered
   */
	protected EList<Module> modules;

	/**
   * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
	protected static final String STATUS_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
	protected String status = STATUS_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DeploymentImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return InfoSystemPackage.Literals.DEPLOYMENT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getDepID() {
    return depID;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setDepID(String newDepID) {
    String oldDepID = depID;
    depID = newDepID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.DEPLOYMENT__DEP_ID, oldDepID, depID));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getDeploymentName() {
    return deploymentName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setDeploymentName(String newDeploymentName) {
    String oldDeploymentName = deploymentName;
    deploymentName = newDeploymentName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.DEPLOYMENT__DEPLOYMENT_NAME, oldDeploymentName, deploymentName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<Module> getModules() {
    if (modules == null)
    {
      modules = new EObjectResolvingEList<Module>(Module.class, this, InfoSystemPackage.DEPLOYMENT__MODULES);
    }
    return modules;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getStatus() {
    return status;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setStatus(String newStatus) {
    String oldStatus = status;
    status = newStatus;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.DEPLOYMENT__STATUS, oldStatus, status));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case InfoSystemPackage.DEPLOYMENT__DEP_ID:
        return getDepID();
      case InfoSystemPackage.DEPLOYMENT__DEPLOYMENT_NAME:
        return getDeploymentName();
      case InfoSystemPackage.DEPLOYMENT__MODULES:
        return getModules();
      case InfoSystemPackage.DEPLOYMENT__STATUS:
        return getStatus();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case InfoSystemPackage.DEPLOYMENT__DEP_ID:
        setDepID((String)newValue);
        return;
      case InfoSystemPackage.DEPLOYMENT__DEPLOYMENT_NAME:
        setDeploymentName((String)newValue);
        return;
      case InfoSystemPackage.DEPLOYMENT__MODULES:
        getModules().clear();
        getModules().addAll((Collection<? extends Module>)newValue);
        return;
      case InfoSystemPackage.DEPLOYMENT__STATUS:
        setStatus((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case InfoSystemPackage.DEPLOYMENT__DEP_ID:
        setDepID(DEP_ID_EDEFAULT);
        return;
      case InfoSystemPackage.DEPLOYMENT__DEPLOYMENT_NAME:
        setDeploymentName(DEPLOYMENT_NAME_EDEFAULT);
        return;
      case InfoSystemPackage.DEPLOYMENT__MODULES:
        getModules().clear();
        return;
      case InfoSystemPackage.DEPLOYMENT__STATUS:
        setStatus(STATUS_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case InfoSystemPackage.DEPLOYMENT__DEP_ID:
        return DEP_ID_EDEFAULT == null ? depID != null : !DEP_ID_EDEFAULT.equals(depID);
      case InfoSystemPackage.DEPLOYMENT__DEPLOYMENT_NAME:
        return DEPLOYMENT_NAME_EDEFAULT == null ? deploymentName != null : !DEPLOYMENT_NAME_EDEFAULT.equals(deploymentName);
      case InfoSystemPackage.DEPLOYMENT__MODULES:
        return modules != null && !modules.isEmpty();
      case InfoSystemPackage.DEPLOYMENT__STATUS:
        return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
    }
    return super.eIsSet(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (depID: ");
    result.append(depID);
    result.append(", deploymentName: ");
    result.append(deploymentName);
    result.append(", Status: ");
    result.append(status);
    result.append(')');
    return result.toString();
  }

} //DeploymentImpl
