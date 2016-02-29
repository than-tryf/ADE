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

import org.example.sybl.ReferenceToType;
import org.example.sybl.SyblPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference To Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.sybl.impl.ReferenceToTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.example.sybl.impl.ReferenceToTypeImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.example.sybl.impl.ReferenceToTypeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceToTypeImpl extends EObjectImpl implements ReferenceToType
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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected static final String VALUE_EDEFAULT = null;

  /**
	 * The default value of the '{@link #getFunction() <em>Function</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
  protected static final String FUNCTION_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ReferenceToTypeImpl()
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
		return SyblPackage.Literals.REFERENCE_TO_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getValue()
  {
		return (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__VALUE, VALUE_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(String newValue)
  {
		String value = newValue;
		Object oldValue = eVirtualSet(SyblPackage.REFERENCE_TO_TYPE__VALUE, value);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.REFERENCE_TO_TYPE__VALUE, oldValue == EVIRTUAL_NO_VALUE ? VALUE_EDEFAULT : oldValue, value));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFunction()
  {
		return (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__FUNCTION, FUNCTION_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFunction(String newFunction)
  {
		String function = newFunction;
		Object oldFunction = eVirtualSet(SyblPackage.REFERENCE_TO_TYPE__FUNCTION, function);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.REFERENCE_TO_TYPE__FUNCTION, oldFunction == EVIRTUAL_NO_VALUE ? FUNCTION_EDEFAULT : oldFunction, function));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName()
  {
		return (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__NAME, NAME_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName)
  {
		String name = newName;
		Object oldName = eVirtualSet(SyblPackage.REFERENCE_TO_TYPE__NAME, name);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SyblPackage.REFERENCE_TO_TYPE__NAME, oldName == EVIRTUAL_NO_VALUE ? NAME_EDEFAULT : oldName, name));
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
			case SyblPackage.REFERENCE_TO_TYPE__VALUE:
				return getValue();
			case SyblPackage.REFERENCE_TO_TYPE__FUNCTION:
				return getFunction();
			case SyblPackage.REFERENCE_TO_TYPE__NAME:
				return getName();
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
			case SyblPackage.REFERENCE_TO_TYPE__VALUE:
				setValue((String)newValue);
				return;
			case SyblPackage.REFERENCE_TO_TYPE__FUNCTION:
				setFunction((String)newValue);
				return;
			case SyblPackage.REFERENCE_TO_TYPE__NAME:
				setName((String)newValue);
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
			case SyblPackage.REFERENCE_TO_TYPE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SyblPackage.REFERENCE_TO_TYPE__FUNCTION:
				setFunction(FUNCTION_EDEFAULT);
				return;
			case SyblPackage.REFERENCE_TO_TYPE__NAME:
				setName(NAME_EDEFAULT);
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
			case SyblPackage.REFERENCE_TO_TYPE__VALUE:
				String value = (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__VALUE, VALUE_EDEFAULT);
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SyblPackage.REFERENCE_TO_TYPE__FUNCTION:
				String function = (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__FUNCTION, FUNCTION_EDEFAULT);
				return FUNCTION_EDEFAULT == null ? function != null : !FUNCTION_EDEFAULT.equals(function);
			case SyblPackage.REFERENCE_TO_TYPE__NAME:
				String name = (String)eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__NAME, NAME_EDEFAULT);
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (value: ");
		result.append(eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__VALUE, VALUE_EDEFAULT));
		result.append(", function: ");
		result.append(eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__FUNCTION, FUNCTION_EDEFAULT));
		result.append(", name: ");
		result.append(eVirtualGet(SyblPackage.REFERENCE_TO_TYPE__NAME, NAME_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //ReferenceToTypeImpl
