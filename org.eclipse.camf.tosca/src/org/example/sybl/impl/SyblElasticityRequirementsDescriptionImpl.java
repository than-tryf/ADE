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

import org.example.sybl.SYBLSpecificationType;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Elasticity Requirements Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.SyblElasticityRequirementsDescriptionImpl#getSYBLSpecification <em>SYBL Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SyblElasticityRequirementsDescriptionImpl extends EObjectImpl implements SyblElasticityRequirementsDescription
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
  protected SyblElasticityRequirementsDescriptionImpl()
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
		return SyblPackage.Literals.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EList<SYBLSpecificationType> getSYBLSpecification()
  {
		EList<SYBLSpecificationType> sYBLSpecification = (EList<SYBLSpecificationType>)eVirtualGet(SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION);
		if (sYBLSpecification == null) {
			eVirtualSet(SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION, sYBLSpecification = new EObjectContainmentEList<SYBLSpecificationType>(SYBLSpecificationType.class, this, SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION));
		}
		return sYBLSpecification;
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
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION:
				return ((InternalEList<?>)getSYBLSpecification()).basicRemove(otherEnd, msgs);
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
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION:
				return getSYBLSpecification();
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
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION:
				getSYBLSpecification().clear();
				getSYBLSpecification().addAll((Collection<? extends SYBLSpecificationType>)newValue);
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
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION:
				getSYBLSpecification().clear();
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
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION:
				EList<SYBLSpecificationType> sYBLSpecification = (EList<SYBLSpecificationType>)eVirtualGet(SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION);
				return sYBLSpecification != null && !sYBLSpecification.isEmpty();
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

} //SyblElasticityRequirementsDescriptionImpl
