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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.example.sybl.SyblPackage;
import org.example.sybl.ToEnforceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>To Enforce Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.ToEnforceTypeImpl#getActionName <em>Action Name</em>}</li>
 *   <li>{@link org.example.sybl.impl.ToEnforceTypeImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ToEnforceTypeImpl extends EObjectImpl implements ToEnforceType
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
	 * The default value of the '{@link #getActionName() <em>Action Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActionName()
	 * @generated
	 * @ordered
	 */
  protected static final String ACTION_NAME_EDEFAULT = null;

  /**
	 * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
  protected static final String PARAMETER_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ToEnforceTypeImpl()
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
		return SyblPackage.Literals.TO_ENFORCE_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getActionName()
  {
		return (String)eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActionName(String newActionName)
  {
		String actionName = newActionName;
		Object oldActionName = eVirtualSet(SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME, actionName);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME, oldActionName == EVIRTUAL_NO_VALUE ? ACTION_NAME_EDEFAULT : oldActionName, actionName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getParameter()
  {
		return (String)eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__PARAMETER, PARAMETER_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParameter(String newParameter)
  {
		String parameter = newParameter;
		Object oldParameter = eVirtualSet(SyblPackage.TO_ENFORCE_TYPE__PARAMETER, parameter);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.TO_ENFORCE_TYPE__PARAMETER, oldParameter == EVIRTUAL_NO_VALUE ? PARAMETER_EDEFAULT : oldParameter, parameter));
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
			case SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME:
				return getActionName();
			case SyblPackage.TO_ENFORCE_TYPE__PARAMETER:
				return getParameter();
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
			case SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME:
				setActionName((String)newValue);
				return;
			case SyblPackage.TO_ENFORCE_TYPE__PARAMETER:
				setParameter((String)newValue);
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
			case SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME:
				setActionName(ACTION_NAME_EDEFAULT);
				return;
			case SyblPackage.TO_ENFORCE_TYPE__PARAMETER:
				setParameter(PARAMETER_EDEFAULT);
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
			case SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME:
				String actionName = (String)eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT);
				return ACTION_NAME_EDEFAULT == null ? actionName != null : !ACTION_NAME_EDEFAULT.equals(actionName);
			case SyblPackage.TO_ENFORCE_TYPE__PARAMETER:
				String parameter = (String)eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__PARAMETER, PARAMETER_EDEFAULT);
				return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
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
		result.append(" (actionName: ");
		result.append(eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__ACTION_NAME, ACTION_NAME_EDEFAULT));
		result.append(", parameter: ");
		result.append(eVirtualGet(SyblPackage.TO_ENFORCE_TYPE__PARAMETER, PARAMETER_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //ToEnforceTypeImpl
