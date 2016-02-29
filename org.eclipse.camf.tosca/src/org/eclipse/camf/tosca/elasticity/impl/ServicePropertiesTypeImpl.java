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

import java.util.Collection;
import org.eclipse.camf.tosca.elasticity.ServicePropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Properties Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl#getHostingEnvironment <em>Hosting Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServicePropertiesTypeImpl extends EObjectImpl implements ServicePropertiesType
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
  protected static final String VERSION_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ServicePropertiesTypeImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.SERVICE_PROPERTIES_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getVersion()
  {
		return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION, VERSION_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVersion(String newVersion)
  {
		String version = newVersion;
		Object oldVersion = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION, version);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION, oldVersion == EVIRTUAL_NO_VALUE ? VERSION_EDEFAULT : oldVersion, version));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getHostingEnvironment() {
		EList<String> hostingEnvironment = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT);
		if (hostingEnvironment == null) {
			eVirtualSet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT, hostingEnvironment = new EDataTypeEList<String>(String.class, this, Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT));
		}
		return hostingEnvironment;
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
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION:
				return getVersion();
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT:
				return getHostingEnvironment();
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
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION:
				setVersion((String)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT:
				getHostingEnvironment().clear();
				getHostingEnvironment().addAll((Collection<? extends String>)newValue);
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
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT:
				getHostingEnvironment().clear();
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
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION:
				String version = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION, VERSION_EDEFAULT);
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT:
				EList<String> hostingEnvironment = (EList<String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT);
				return hostingEnvironment != null && !hostingEnvironment.isEmpty();
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
		result.append(" (version: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__VERSION, VERSION_EDEFAULT));
		result.append(", hostingEnvironment: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT));
		result.append(')');
		return result.toString();
	}

} //ServicePropertiesTypeImpl
