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
package org.eclipse.camf.tosca.elasticity.impl;

import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Properties Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.NodePropertiesTypeImpl#getFlavor <em>Flavor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodePropertiesTypeImpl extends EObjectImpl implements NodePropertiesType
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
	 * The default value of the '{@link #getFlavor() <em>Flavor</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFlavor()
	 * @generated
	 * @ordered
	 */
  protected static final String FLAVOR_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected NodePropertiesTypeImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.NODE_PROPERTIES_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getFlavor()
  {
		return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR, FLAVOR_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFlavor(String newFlavor)
  {
		String flavor = newFlavor;
		Object oldFlavor = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR, flavor);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR, oldFlavor == EVIRTUAL_NO_VALUE ? FLAVOR_EDEFAULT : oldFlavor, flavor));
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
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR:
				return getFlavor();
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
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR:
				setFlavor((String)newValue);
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
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR:
				setFlavor(FLAVOR_EDEFAULT);
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
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR:
				String flavor = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR, FLAVOR_EDEFAULT);
				return FLAVOR_EDEFAULT == null ? flavor != null : !FLAVOR_EDEFAULT.equals(flavor);
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
		result.append(" (flavor: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE__FLAVOR, FLAVOR_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //NodePropertiesTypeImpl
