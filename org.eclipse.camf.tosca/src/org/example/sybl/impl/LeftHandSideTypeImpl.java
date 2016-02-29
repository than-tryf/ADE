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

import org.example.sybl.LeftHandSideType;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Left Hand Side Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.LeftHandSideTypeImpl#getMetric <em>Metric</em>}</li>
 *   <li>{@link org.example.sybl.impl.LeftHandSideTypeImpl#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LeftHandSideTypeImpl extends EObjectImpl implements LeftHandSideType
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
	 * The default value of the '{@link #getMetric() <em>Metric</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMetric()
	 * @generated
	 * @ordered
	 */
  protected static final String METRIC_EDEFAULT = null;

  /**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
  protected static final String NUMBER_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected LeftHandSideTypeImpl()
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
		return SyblPackage.Literals.LEFT_HAND_SIDE_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getMetric()
  {
		return (String)eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC, METRIC_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMetric(String newMetric)
  {
		String metric = newMetric;
		Object oldMetric = eVirtualSet(SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC, metric);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC, oldMetric == EVIRTUAL_NO_VALUE ? METRIC_EDEFAULT : oldMetric, metric));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getNumber()
  {
		return (String)eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER, NUMBER_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNumber(String newNumber)
  {
		String number = newNumber;
		Object oldNumber = eVirtualSet(SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER, number);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER, oldNumber == EVIRTUAL_NO_VALUE ? NUMBER_EDEFAULT : oldNumber, number));
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
			case SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC:
				return getMetric();
			case SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER:
				return getNumber();
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
			case SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC:
				setMetric((String)newValue);
				return;
			case SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER:
				setNumber((String)newValue);
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
			case SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC:
				setMetric(METRIC_EDEFAULT);
				return;
			case SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER:
				setNumber(NUMBER_EDEFAULT);
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
			case SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC:
				String metric = (String)eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC, METRIC_EDEFAULT);
				return METRIC_EDEFAULT == null ? metric != null : !METRIC_EDEFAULT.equals(metric);
			case SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER:
				String number = (String)eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER, NUMBER_EDEFAULT);
				return NUMBER_EDEFAULT == null ? number != null : !NUMBER_EDEFAULT.equals(number);
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
		result.append(" (metric: ");
		result.append(eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__METRIC, METRIC_EDEFAULT));
		result.append(", number: ");
		result.append(eVirtualGet(SyblPackage.LEFT_HAND_SIDE_TYPE__NUMBER, NUMBER_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //LeftHandSideTypeImpl
