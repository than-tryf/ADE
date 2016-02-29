/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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

import org.eclipse.camf.tosca.elasticity.MonitoringProbesType1;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.impl.TBoundaryDefinitionsImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TBoundary Definitions Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl#getMonitoringProbes <em>Monitoring Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TBoundaryDefinitionsExtensionImpl extends TBoundaryDefinitionsImpl implements TBoundaryDefinitionsExtension
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
  protected TBoundaryDefinitionsExtensionImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.TBOUNDARY_DEFINITIONS_EXTENSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MonitoringProbesType1 getMonitoringProbes()
  {
		return (MonitoringProbesType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMonitoringProbes(MonitoringProbesType1 newMonitoringProbes, NotificationChain msgs)
  {
		Object oldMonitoringProbes = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES, newMonitoringProbes);
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES, oldMonitoringProbes == EVIRTUAL_NO_VALUE ? null : oldMonitoringProbes, newMonitoringProbes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMonitoringProbes(MonitoringProbesType1 newMonitoringProbes)
  {
		MonitoringProbesType1 monitoringProbes = (MonitoringProbesType1)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES);
		if (newMonitoringProbes != monitoringProbes) {
			NotificationChain msgs = null;
			if (monitoringProbes != null)
				msgs = ((InternalEObject)monitoringProbes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES, null, msgs);
			if (newMonitoringProbes != null)
				msgs = ((InternalEObject)newMonitoringProbes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES, null, msgs);
			msgs = basicSetMonitoringProbes(newMonitoringProbes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES, newMonitoringProbes, newMonitoringProbes));
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
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES:
				return basicSetMonitoringProbes(null, msgs);
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
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES:
				return getMonitoringProbes();
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
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES:
				setMonitoringProbes((MonitoringProbesType1)newValue);
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
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES:
				setMonitoringProbes((MonitoringProbesType1)null);
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
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES:
				return eVirtualGet(Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES) != null;
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

} //TBoundaryDefinitionsExtensionImpl
