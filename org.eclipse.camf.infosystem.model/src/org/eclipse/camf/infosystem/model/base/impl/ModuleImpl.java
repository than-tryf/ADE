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

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.Module;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl#getModID <em>Mod ID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl#getModuleName <em>Module Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl#getInitInstances <em>Init Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends EObjectImpl implements Module {
	/**
   * The default value of the '{@link #getModID() <em>Mod ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModID()
   * @generated
   * @ordered
   */
	protected static final String MOD_ID_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getModID() <em>Mod ID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModID()
   * @generated
   * @ordered
   */
	protected String modID = MOD_ID_EDEFAULT;

	/**
   * The default value of the '{@link #getModuleName() <em>Module Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModuleName()
   * @generated
   * @ordered
   */
	protected static final String MODULE_NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getModuleName() <em>Module Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getModuleName()
   * @generated
   * @ordered
   */
	protected String moduleName = MODULE_NAME_EDEFAULT;

	/**
   * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInstances()
   * @generated
   * @ordered
   */
	protected EList<VirtualInstance> instances;

	/**
   * The default value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInitInstances()
   * @generated
   * @ordered
   */
	protected static final String INIT_INSTANCES_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getInitInstances()
   * @generated
   * @ordered
   */
	protected String initInstances = INIT_INSTANCES_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ModuleImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return InfoSystemPackage.Literals.MODULE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getModID() {
    return modID;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setModID(String newModID) {
    String oldModID = modID;
    modID = newModID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MODULE__MOD_ID, oldModID, modID));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getModuleName() {
    return moduleName;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setModuleName(String newModuleName) {
    String oldModuleName = moduleName;
    moduleName = newModuleName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MODULE__MODULE_NAME, oldModuleName, moduleName));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<VirtualInstance> getInstances() {
    if (instances == null)
    {
      instances = new EObjectResolvingEList<VirtualInstance>(VirtualInstance.class, this, InfoSystemPackage.MODULE__INSTANCES);
    }
    return instances;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getInitInstances() {
    return initInstances;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setInitInstances(String newInitInstances) {
    String oldInitInstances = initInstances;
    initInstances = newInitInstances;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MODULE__INIT_INSTANCES, oldInitInstances, initInstances));
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
      case InfoSystemPackage.MODULE__MOD_ID:
        return getModID();
      case InfoSystemPackage.MODULE__MODULE_NAME:
        return getModuleName();
      case InfoSystemPackage.MODULE__INSTANCES:
        return getInstances();
      case InfoSystemPackage.MODULE__INIT_INSTANCES:
        return getInitInstances();
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
      case InfoSystemPackage.MODULE__MOD_ID:
        setModID((String)newValue);
        return;
      case InfoSystemPackage.MODULE__MODULE_NAME:
        setModuleName((String)newValue);
        return;
      case InfoSystemPackage.MODULE__INSTANCES:
        getInstances().clear();
        getInstances().addAll((Collection<? extends VirtualInstance>)newValue);
        return;
      case InfoSystemPackage.MODULE__INIT_INSTANCES:
        setInitInstances((String)newValue);
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
      case InfoSystemPackage.MODULE__MOD_ID:
        setModID(MOD_ID_EDEFAULT);
        return;
      case InfoSystemPackage.MODULE__MODULE_NAME:
        setModuleName(MODULE_NAME_EDEFAULT);
        return;
      case InfoSystemPackage.MODULE__INSTANCES:
        getInstances().clear();
        return;
      case InfoSystemPackage.MODULE__INIT_INSTANCES:
        setInitInstances(INIT_INSTANCES_EDEFAULT);
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
      case InfoSystemPackage.MODULE__MOD_ID:
        return MOD_ID_EDEFAULT == null ? modID != null : !MOD_ID_EDEFAULT.equals(modID);
      case InfoSystemPackage.MODULE__MODULE_NAME:
        return MODULE_NAME_EDEFAULT == null ? moduleName != null : !MODULE_NAME_EDEFAULT.equals(moduleName);
      case InfoSystemPackage.MODULE__INSTANCES:
        return instances != null && !instances.isEmpty();
      case InfoSystemPackage.MODULE__INIT_INSTANCES:
        return INIT_INSTANCES_EDEFAULT == null ? initInstances != null : !INIT_INSTANCES_EDEFAULT.equals(initInstances);
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
    result.append(" (modID: ");
    result.append(modID);
    result.append(", moduleName: ");
    result.append(moduleName);
    result.append(", initInstances: ");
    result.append(initInstances);
    result.append(')');
    return result.toString();
  }

} //ModuleImpl
