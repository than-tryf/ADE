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

import org.example.sybl.ConditionType;
import org.example.sybl.Strategy;
import org.example.sybl.SyblPackage;
import org.example.sybl.ToEnforceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.StrategyImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.example.sybl.impl.StrategyImpl#getToEnforce <em>To Enforce</em>}</li>
 *   <li>{@link org.example.sybl.impl.StrategyImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StrategyImpl extends EObjectImpl implements Strategy
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected static final String ID_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected StrategyImpl()
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
		return SyblPackage.Literals.STRATEGY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConditionType getCondition()
  {
		return (ConditionType)eVirtualGet(SyblPackage.STRATEGY__CONDITION);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCondition(ConditionType newCondition, NotificationChain msgs)
  {
		Object oldCondition = eVirtualSet(SyblPackage.STRATEGY__CONDITION, newCondition);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyblPackage.STRATEGY__CONDITION, oldCondition == EVIRTUAL_NO_VALUE ? null : oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCondition(ConditionType newCondition)
  {
		ConditionType condition = (ConditionType)eVirtualGet(SyblPackage.STRATEGY__CONDITION);
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyblPackage.STRATEGY__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyblPackage.STRATEGY__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.STRATEGY__CONDITION, newCondition, newCondition));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ToEnforceType getToEnforce()
  {
		return (ToEnforceType)eVirtualGet(SyblPackage.STRATEGY__TO_ENFORCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetToEnforce(ToEnforceType newToEnforce, NotificationChain msgs)
  {
		Object oldToEnforce = eVirtualSet(SyblPackage.STRATEGY__TO_ENFORCE, newToEnforce);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyblPackage.STRATEGY__TO_ENFORCE, oldToEnforce == EVIRTUAL_NO_VALUE ? null : oldToEnforce, newToEnforce);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setToEnforce(ToEnforceType newToEnforce)
  {
		ToEnforceType toEnforce = (ToEnforceType)eVirtualGet(SyblPackage.STRATEGY__TO_ENFORCE);
		if (newToEnforce != toEnforce) {
			NotificationChain msgs = null;
			if (toEnforce != null)
				msgs = ((InternalEObject)toEnforce).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyblPackage.STRATEGY__TO_ENFORCE, null, msgs);
			if (newToEnforce != null)
				msgs = ((InternalEObject)newToEnforce).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyblPackage.STRATEGY__TO_ENFORCE, null, msgs);
			msgs = basicSetToEnforce(newToEnforce, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.STRATEGY__TO_ENFORCE, newToEnforce, newToEnforce));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getId()
  {
		return (String)eVirtualGet(SyblPackage.STRATEGY__ID, ID_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setId(String newId)
  {
		String id = newId;
		Object oldId = eVirtualSet(SyblPackage.STRATEGY__ID, id);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.STRATEGY__ID, oldId == EVIRTUAL_NO_VALUE ? ID_EDEFAULT : oldId, id));
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
			case SyblPackage.STRATEGY__CONDITION:
				return basicSetCondition(null, msgs);
			case SyblPackage.STRATEGY__TO_ENFORCE:
				return basicSetToEnforce(null, msgs);
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
			case SyblPackage.STRATEGY__CONDITION:
				return getCondition();
			case SyblPackage.STRATEGY__TO_ENFORCE:
				return getToEnforce();
			case SyblPackage.STRATEGY__ID:
				return getId();
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
			case SyblPackage.STRATEGY__CONDITION:
				setCondition((ConditionType)newValue);
				return;
			case SyblPackage.STRATEGY__TO_ENFORCE:
				setToEnforce((ToEnforceType)newValue);
				return;
			case SyblPackage.STRATEGY__ID:
				setId((String)newValue);
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
			case SyblPackage.STRATEGY__CONDITION:
				setCondition((ConditionType)null);
				return;
			case SyblPackage.STRATEGY__TO_ENFORCE:
				setToEnforce((ToEnforceType)null);
				return;
			case SyblPackage.STRATEGY__ID:
				setId(ID_EDEFAULT);
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
			case SyblPackage.STRATEGY__CONDITION:
				return eVirtualGet(SyblPackage.STRATEGY__CONDITION) != null;
			case SyblPackage.STRATEGY__TO_ENFORCE:
				return eVirtualGet(SyblPackage.STRATEGY__TO_ENFORCE) != null;
			case SyblPackage.STRATEGY__ID:
				String id = (String)eVirtualGet(SyblPackage.STRATEGY__ID, ID_EDEFAULT);
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
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
		result.append(" (id: ");
		result.append(eVirtualGet(SyblPackage.STRATEGY__ID, ID_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //StrategyImpl
