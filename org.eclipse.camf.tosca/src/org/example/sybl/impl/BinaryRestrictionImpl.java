/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
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
package org.example.sybl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.example.sybl.BinaryRestriction;
import org.example.sybl.LeftHandSideType;
import org.example.sybl.RightHandSideType;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.BinaryRestrictionImpl#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.example.sybl.impl.BinaryRestrictionImpl#getRightHandSide <em>Right Hand Side</em>}</li>
 *   <li>{@link org.example.sybl.impl.BinaryRestrictionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryRestrictionImpl extends EObjectImpl implements BinaryRestriction
{
  /**
	 * An array of objects representing the values of non-primitive features.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Object[] eVirtualValues;

  /**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected int eVirtualIndexBits0;

  /**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
  protected static final String TYPE_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected BinaryRestrictionImpl()
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
		return SyblPackage.Literals.BINARY_RESTRICTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public LeftHandSideType getLeftHandSide()
  {
		return (LeftHandSideType)eVirtualGet(SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetLeftHandSide(LeftHandSideType newLeftHandSide, NotificationChain msgs)
  {
		Object oldLeftHandSide = eVirtualSet(SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE, newLeftHandSide);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE, oldLeftHandSide == EVIRTUAL_NO_VALUE ? null : oldLeftHandSide, newLeftHandSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLeftHandSide(LeftHandSideType newLeftHandSide)
  {
		LeftHandSideType leftHandSide = (LeftHandSideType)eVirtualGet(SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE);
		if (newLeftHandSide != leftHandSide) {
			NotificationChain msgs = null;
			if (leftHandSide != null)
				msgs = ((InternalEObject)leftHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE, null, msgs);
			if (newLeftHandSide != null)
				msgs = ((InternalEObject)newLeftHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE, null, msgs);
			msgs = basicSetLeftHandSide(newLeftHandSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE, newLeftHandSide, newLeftHandSide));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RightHandSideType getRightHandSide()
  {
		return (RightHandSideType)eVirtualGet(SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetRightHandSide(RightHandSideType newRightHandSide, NotificationChain msgs)
  {
		Object oldRightHandSide = eVirtualSet(SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE, newRightHandSide);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE, oldRightHandSide == EVIRTUAL_NO_VALUE ? null : oldRightHandSide, newRightHandSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRightHandSide(RightHandSideType newRightHandSide)
  {
		RightHandSideType rightHandSide = (RightHandSideType)eVirtualGet(SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE);
		if (newRightHandSide != rightHandSide) {
			NotificationChain msgs = null;
			if (rightHandSide != null)
				msgs = ((InternalEObject)rightHandSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE, null, msgs);
			if (newRightHandSide != null)
				msgs = ((InternalEObject)newRightHandSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE, null, msgs);
			msgs = basicSetRightHandSide(newRightHandSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE, newRightHandSide, newRightHandSide));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getType()
  {
		return (String)eVirtualGet(SyblPackage.BINARY_RESTRICTION__TYPE, TYPE_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setType(String newType)
  {
		String type = newType;
		Object oldType = eVirtualSet(SyblPackage.BINARY_RESTRICTION__TYPE, type);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.BINARY_RESTRICTION__TYPE, oldType == EVIRTUAL_NO_VALUE ? TYPE_EDEFAULT : oldType, type));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE:
				return basicSetLeftHandSide(null, msgs);
			case SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE:
				return basicSetRightHandSide(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE:
				return getLeftHandSide();
			case SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE:
				return getRightHandSide();
			case SyblPackage.BINARY_RESTRICTION__TYPE:
				return getType();
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
		switch (featureID) {
			case SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE:
				setLeftHandSide((LeftHandSideType)newValue);
				return;
			case SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE:
				setRightHandSide((RightHandSideType)newValue);
				return;
			case SyblPackage.BINARY_RESTRICTION__TYPE:
				setType((String)newValue);
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
		switch (featureID) {
			case SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE:
				setLeftHandSide((LeftHandSideType)null);
				return;
			case SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE:
				setRightHandSide((RightHandSideType)null);
				return;
			case SyblPackage.BINARY_RESTRICTION__TYPE:
				setType(TYPE_EDEFAULT);
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
		switch (featureID) {
			case SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE:
				return eVirtualGet(SyblPackage.BINARY_RESTRICTION__LEFT_HAND_SIDE) != null;
			case SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE:
				return eVirtualGet(SyblPackage.BINARY_RESTRICTION__RIGHT_HAND_SIDE) != null;
			case SyblPackage.BINARY_RESTRICTION__TYPE:
				String type = (String)eVirtualGet(SyblPackage.BINARY_RESTRICTION__TYPE, TYPE_EDEFAULT);
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Object[] eVirtualValues()
  {
		return eVirtualValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualValues(Object[] newValues)
  {
		eVirtualValues = newValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected int eVirtualIndexBits(int offset)
  {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualIndexBits(int offset, int newIndexBits)
  {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(" (type: ");
		result.append(eVirtualGet(SyblPackage.BINARY_RESTRICTION__TYPE, TYPE_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //BinaryRestrictionImpl
