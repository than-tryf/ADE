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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.camf.infosystem.model.base.impl;

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Machine Image Flavor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl#getRam <em>Ram</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl#getHdd <em>Hdd</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl#getVCPU <em>VCPU</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualMachineImageFlavorImpl extends EObjectImpl implements VirtualMachineImageFlavor
{
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
   * The default value of the '{@link #getRam() <em>Ram</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRam()
   * @generated
   * @ordered
   */
	protected static final String RAM_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getRam() <em>Ram</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getRam()
   * @generated
   * @ordered
   */
	protected String ram = RAM_EDEFAULT;

		/**
   * The default value of the '{@link #getHdd() <em>Hdd</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getHdd()
   * @generated
   * @ordered
   */
	protected static final String HDD_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getHdd() <em>Hdd</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getHdd()
   * @generated
   * @ordered
   */
	protected String hdd = HDD_EDEFAULT;

		/**
   * The default value of the '{@link #getVCPU() <em>VCPU</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVCPU()
   * @generated
   * @ordered
   */
	protected static final String VCPU_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getVCPU() <em>VCPU</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getVCPU()
   * @generated
   * @ordered
   */
	protected String vCPU = VCPU_EDEFAULT;

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VirtualMachineImageFlavorImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUID()
  {
    return uID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUID(String newUID)
  {
    String oldUID = uID;
    uID = newUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID, oldUID, uID));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getRam() {
    return ram;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setRam(String newRam) {
    String oldRam = ram;
    ram = newRam;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM, oldRam, ram));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getHdd() {
    return hdd;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setHdd(String newHdd) {
    String oldHdd = hdd;
    hdd = newHdd;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD, oldHdd, hdd));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getVCPU() {
    return vCPU;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setVCPU(String newVCPU) {
    String oldVCPU = vCPU;
    vCPU = newVCPU;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU, oldVCPU, vCPU));
  }

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME:
        return getName();
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID:
        return getUID();
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM:
        return getRam();
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD:
        return getHdd();
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU:
        return getVCPU();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID:
        setUID((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM:
        setRam((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD:
        setHdd((String)newValue);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU:
        setVCPU((String)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID:
        setUID(UID_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM:
        setRam(RAM_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD:
        setHdd(HDD_EDEFAULT);
        return;
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU:
        setVCPU(VCPU_EDEFAULT);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID:
        return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM:
        return RAM_EDEFAULT == null ? ram != null : !RAM_EDEFAULT.equals(ram);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD:
        return HDD_EDEFAULT == null ? hdd != null : !HDD_EDEFAULT.equals(hdd);
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU:
        return VCPU_EDEFAULT == null ? vCPU != null : !VCPU_EDEFAULT.equals(vCPU);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", uID: ");
    result.append(uID);
    result.append(", ram: ");
    result.append(ram);
    result.append(", hdd: ");
    result.append(hdd);
    result.append(", vCPU: ");
    result.append(vCPU);
    result.append(')');
    return result.toString();
  }

} //VirtualMachineImageFlavorImpl
