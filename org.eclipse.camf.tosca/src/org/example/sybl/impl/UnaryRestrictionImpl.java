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

import org.example.sybl.ReferenceToType;
import org.example.sybl.SyblPackage;
import org.example.sybl.UnaryRestriction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.UnaryRestrictionImpl#getMetric <em>Metric</em>}</li>
 *   <li>{@link org.example.sybl.impl.UnaryRestrictionImpl#getReferenceTo <em>Reference To</em>}</li>
 *   <li>{@link org.example.sybl.impl.UnaryRestrictionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnaryRestrictionImpl extends EObjectImpl implements UnaryRestriction
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
  protected UnaryRestrictionImpl()
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
		return SyblPackage.Literals.UNARY_RESTRICTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getMetric()
  {
		return (String)eVirtualGet(SyblPackage.UNARY_RESTRICTION__METRIC, METRIC_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMetric(String newMetric)
  {
		String metric = newMetric;
		Object oldMetric = eVirtualSet(SyblPackage.UNARY_RESTRICTION__METRIC, metric);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.UNARY_RESTRICTION__METRIC, oldMetric == EVIRTUAL_NO_VALUE ? METRIC_EDEFAULT : oldMetric, metric));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ReferenceToType getReferenceTo()
  {
		return (ReferenceToType)eVirtualGet(SyblPackage.UNARY_RESTRICTION__REFERENCE_TO);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetReferenceTo(ReferenceToType newReferenceTo, NotificationChain msgs)
  {
		Object oldReferenceTo = eVirtualSet(SyblPackage.UNARY_RESTRICTION__REFERENCE_TO, newReferenceTo);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SyblPackage.UNARY_RESTRICTION__REFERENCE_TO, oldReferenceTo == EVIRTUAL_NO_VALUE ? null : oldReferenceTo, newReferenceTo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setReferenceTo(ReferenceToType newReferenceTo)
  {
		ReferenceToType referenceTo = (ReferenceToType)eVirtualGet(SyblPackage.UNARY_RESTRICTION__REFERENCE_TO);
		if (newReferenceTo != referenceTo) {
			NotificationChain msgs = null;
			if (referenceTo != null)
				msgs = ((InternalEObject)referenceTo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SyblPackage.UNARY_RESTRICTION__REFERENCE_TO, null, msgs);
			if (newReferenceTo != null)
				msgs = ((InternalEObject)newReferenceTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SyblPackage.UNARY_RESTRICTION__REFERENCE_TO, null, msgs);
			msgs = basicSetReferenceTo(newReferenceTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.UNARY_RESTRICTION__REFERENCE_TO, newReferenceTo, newReferenceTo));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getType()
  {
		return (String)eVirtualGet(SyblPackage.UNARY_RESTRICTION__TYPE, TYPE_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setType(String newType)
  {
		String type = newType;
		Object oldType = eVirtualSet(SyblPackage.UNARY_RESTRICTION__TYPE, type);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.UNARY_RESTRICTION__TYPE, oldType == EVIRTUAL_NO_VALUE ? TYPE_EDEFAULT : oldType, type));
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
			case SyblPackage.UNARY_RESTRICTION__REFERENCE_TO:
				return basicSetReferenceTo(null, msgs);
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
			case SyblPackage.UNARY_RESTRICTION__METRIC:
				return getMetric();
			case SyblPackage.UNARY_RESTRICTION__REFERENCE_TO:
				return getReferenceTo();
			case SyblPackage.UNARY_RESTRICTION__TYPE:
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
			case SyblPackage.UNARY_RESTRICTION__METRIC:
				setMetric((String)newValue);
				return;
			case SyblPackage.UNARY_RESTRICTION__REFERENCE_TO:
				setReferenceTo((ReferenceToType)newValue);
				return;
			case SyblPackage.UNARY_RESTRICTION__TYPE:
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
			case SyblPackage.UNARY_RESTRICTION__METRIC:
				setMetric(METRIC_EDEFAULT);
				return;
			case SyblPackage.UNARY_RESTRICTION__REFERENCE_TO:
				setReferenceTo((ReferenceToType)null);
				return;
			case SyblPackage.UNARY_RESTRICTION__TYPE:
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
			case SyblPackage.UNARY_RESTRICTION__METRIC:
				String metric = (String)eVirtualGet(SyblPackage.UNARY_RESTRICTION__METRIC, METRIC_EDEFAULT);
				return METRIC_EDEFAULT == null ? metric != null : !METRIC_EDEFAULT.equals(metric);
			case SyblPackage.UNARY_RESTRICTION__REFERENCE_TO:
				return eVirtualGet(SyblPackage.UNARY_RESTRICTION__REFERENCE_TO) != null;
			case SyblPackage.UNARY_RESTRICTION__TYPE:
				String type = (String)eVirtualGet(SyblPackage.UNARY_RESTRICTION__TYPE, TYPE_EDEFAULT);
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
		result.append(" (metric: ");
		result.append(eVirtualGet(SyblPackage.UNARY_RESTRICTION__METRIC, METRIC_EDEFAULT));
		result.append(", type: ");
		result.append(eVirtualGet(SyblPackage.UNARY_RESTRICTION__TYPE, TYPE_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //UnaryRestrictionImpl
