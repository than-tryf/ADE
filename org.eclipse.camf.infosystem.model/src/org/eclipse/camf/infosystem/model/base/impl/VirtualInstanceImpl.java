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

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl#getIPs <em>IPs</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl#getURI <em>URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualInstanceImpl extends EObjectImpl implements VirtualInstance {
	/**
   * The default value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
	protected static final String UID_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
	protected String uID = UID_EDEFAULT;

	/**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected static final String NAME_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected String name = NAME_EDEFAULT;

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
   * The default value of the '{@link #getIPs() <em>IPs</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIPs()
   * @generated
   * @ordered
   */
	protected static final String IPS_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getIPs() <em>IPs</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getIPs()
   * @generated
   * @ordered
   */
	protected String iPs = IPS_EDEFAULT;

	/**
   * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getURI()
   * @generated
   * @ordered
   */
	protected static final String URI_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getURI()
   * @generated
   * @ordered
   */
	protected String uri = URI_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected VirtualInstanceImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return InfoSystemPackage.Literals.VIRTUAL_INSTANCE;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getUID() {
    return uID;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setUID(String newUID) {
    String oldUID = uID;
    uID = newUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_INSTANCE__UID, oldUID, uID));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getName() {
    return name;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_INSTANCE__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_INSTANCE__STATUS, oldStatus, status));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getIPs() {
    return iPs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setIPs(String newIPs) {
    String oldIPs = iPs;
    iPs = newIPs;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_INSTANCE__IPS, oldIPs, iPs));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getURI() {
    return uri;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setURI(String newURI) {
    String oldURI = uri;
    uri = newURI;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_INSTANCE__URI, oldURI, uri));
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
      case InfoSystemPackage.VIRTUAL_INSTANCE__UID:
        return getUID();
      case InfoSystemPackage.VIRTUAL_INSTANCE__NAME:
        return getName();
      case InfoSystemPackage.VIRTUAL_INSTANCE__STATUS:
        return getStatus();
      case InfoSystemPackage.VIRTUAL_INSTANCE__IPS:
        return getIPs();
      case InfoSystemPackage.VIRTUAL_INSTANCE__URI:
        return getURI();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case InfoSystemPackage.VIRTUAL_INSTANCE__UID:
        setUID((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__STATUS:
        setStatus((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__IPS:
        setIPs((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__URI:
        setURI((String)newValue);
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
      case InfoSystemPackage.VIRTUAL_INSTANCE__UID:
        setUID(UID_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__STATUS:
        setStatus(STATUS_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__IPS:
        setIPs(IPS_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_INSTANCE__URI:
        setURI(URI_EDEFAULT);
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
      case InfoSystemPackage.VIRTUAL_INSTANCE__UID:
        return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
      case InfoSystemPackage.VIRTUAL_INSTANCE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.VIRTUAL_INSTANCE__STATUS:
        return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
      case InfoSystemPackage.VIRTUAL_INSTANCE__IPS:
        return IPS_EDEFAULT == null ? iPs != null : !IPS_EDEFAULT.equals(iPs);
      case InfoSystemPackage.VIRTUAL_INSTANCE__URI:
        return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
    result.append(" (uID: ");
    result.append(uID);
    result.append(", name: ");
    result.append(name);
    result.append(", status: ");
    result.append(status);
    result.append(", IPs: ");
    result.append(iPs);
    result.append(", URI: ");
    result.append(uri);
    result.append(')');
    return result.toString();
  }

} //VirtualInstanceImpl
