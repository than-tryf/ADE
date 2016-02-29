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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.sybl.BinaryRestriction;
import org.example.sybl.ConditionType1;
import org.example.sybl.SyblPackage;
import org.example.sybl.UnaryRestriction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Type1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.ConditionType1Impl#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}</li>
 *   <li>{@link org.example.sybl.impl.ConditionType1Impl#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionType1Impl extends EObjectImpl implements ConditionType1
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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ConditionType1Impl()
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
		return SyblPackage.Literals.CONDITION_TYPE1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<BinaryRestriction> getBinaryRestrictionsConjunction()
  {
		EList<BinaryRestriction> binaryRestrictionsConjunction = (EList<BinaryRestriction>)eVirtualGet(SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION);
		if (binaryRestrictionsConjunction == null) {
			eVirtualSet(SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION, binaryRestrictionsConjunction = new EObjectContainmentEList<BinaryRestriction>(BinaryRestriction.class, this, SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION));
		}
		return binaryRestrictionsConjunction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<UnaryRestriction> getUnaryRestrictionsConjunction()
  {
		EList<UnaryRestriction> unaryRestrictionsConjunction = (EList<UnaryRestriction>)eVirtualGet(SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION);
		if (unaryRestrictionsConjunction == null) {
			eVirtualSet(SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION, unaryRestrictionsConjunction = new EObjectContainmentEList<UnaryRestriction>(UnaryRestriction.class, this, SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION));
		}
		return unaryRestrictionsConjunction;
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
			case SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION:
				return ((InternalEList<?>)getBinaryRestrictionsConjunction()).basicRemove(otherEnd, msgs);
			case SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION:
				return ((InternalEList<?>)getUnaryRestrictionsConjunction()).basicRemove(otherEnd, msgs);
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
			case SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION:
				return getBinaryRestrictionsConjunction();
			case SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION:
				return getUnaryRestrictionsConjunction();
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
			case SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION:
				getBinaryRestrictionsConjunction().clear();
				getBinaryRestrictionsConjunction().addAll((Collection<? extends BinaryRestriction>)newValue);
				return;
			case SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION:
				getUnaryRestrictionsConjunction().clear();
				getUnaryRestrictionsConjunction().addAll((Collection<? extends UnaryRestriction>)newValue);
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
			case SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION:
				getBinaryRestrictionsConjunction().clear();
				return;
			case SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION:
				getUnaryRestrictionsConjunction().clear();
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
			case SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION:
				EList<BinaryRestriction> binaryRestrictionsConjunction = (EList<BinaryRestriction>)eVirtualGet(SyblPackage.CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION);
				return binaryRestrictionsConjunction != null && !binaryRestrictionsConjunction.isEmpty();
			case SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION:
				EList<UnaryRestriction> unaryRestrictionsConjunction = (EList<UnaryRestriction>)eVirtualGet(SyblPackage.CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION);
				return unaryRestrictionsConjunction != null && !unaryRestrictionsConjunction.isEmpty();
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

} //ConditionType1Impl
