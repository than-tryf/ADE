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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.sybl.Constraint;
import org.example.sybl.SYBLSpecificationType;
import org.example.sybl.Strategy;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SYBL Specification Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.SYBLSpecificationTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.example.sybl.impl.SYBLSpecificationTypeImpl#getStrategy <em>Strategy</em>}</li>
 *   <li>{@link org.example.sybl.impl.SYBLSpecificationTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.example.sybl.impl.SYBLSpecificationTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SYBLSpecificationTypeImpl extends EObjectImpl implements SYBLSpecificationType
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
  protected SYBLSpecificationTypeImpl()
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
		return SyblPackage.Literals.SYBL_SPECIFICATION_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<Constraint> getConstraint()
  {
		EList<Constraint> constraint = (EList<Constraint>)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT);
		if (constraint == null) {
			eVirtualSet(SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT, constraint = new EObjectContainmentEList<Constraint>(Constraint.class, this, SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT));
		}
		return constraint;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<Strategy> getStrategy()
  {
		EList<Strategy> strategy = (EList<Strategy>)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY);
		if (strategy == null) {
			eVirtualSet(SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY, strategy = new EObjectContainmentEList<Strategy>(Strategy.class, this, SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY));
		}
		return strategy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getId()
  {
		return (String)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__ID, ID_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setId(String newId)
  {
		String id = newId;
		Object oldId = eVirtualSet(SyblPackage.SYBL_SPECIFICATION_TYPE__ID, id);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.SYBL_SPECIFICATION_TYPE__ID, oldId == EVIRTUAL_NO_VALUE ? ID_EDEFAULT : oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getType()
  {
		return (String)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE, TYPE_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setType(String newType)
  {
		String type = newType;
		Object oldType = eVirtualSet(SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE, type);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE, oldType == EVIRTUAL_NO_VALUE ? TYPE_EDEFAULT : oldType, type));
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
			case SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
			case SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY:
				return ((InternalEList<?>)getStrategy()).basicRemove(otherEnd, msgs);
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
			case SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT:
				return getConstraint();
			case SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY:
				return getStrategy();
			case SyblPackage.SYBL_SPECIFICATION_TYPE__ID:
				return getId();
			case SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE:
				return getType();
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
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends Constraint>)newValue);
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY:
				getStrategy().clear();
				getStrategy().addAll((Collection<? extends Strategy>)newValue);
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__ID:
				setId((String)newValue);
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE:
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
			case SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT:
				getConstraint().clear();
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY:
				getStrategy().clear();
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE:
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
  @SuppressWarnings("unchecked")
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT:
				EList<Constraint> constraint = (EList<Constraint>)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__CONSTRAINT);
				return constraint != null && !constraint.isEmpty();
			case SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY:
				EList<Strategy> strategy = (EList<Strategy>)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__STRATEGY);
				return strategy != null && !strategy.isEmpty();
			case SyblPackage.SYBL_SPECIFICATION_TYPE__ID:
				String id = (String)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__ID, ID_EDEFAULT);
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE:
				String type = (String)eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE, TYPE_EDEFAULT);
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
		result.append(" (id: ");
		result.append(eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__ID, ID_EDEFAULT));
		result.append(", type: ");
		result.append(eVirtualGet(SyblPackage.SYBL_SPECIFICATION_TYPE__TYPE, TYPE_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //SYBLSpecificationTypeImpl
