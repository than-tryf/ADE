/**
 */
package org.eclipse.camf.infosystem.model.base.impl;

import java.util.Collection;

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.Monitoring;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;

import org.eclipse.camf.infosystem.model.base.MonitoringService;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monitoring</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringImpl#getMonitoringService <em>Monitoring Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoringImpl extends EObjectImpl implements Monitoring
{
  /**
   * The cached value of the '{@link #getMonitoringService() <em>Monitoring Service</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMonitoringService()
   * @generated
   * @ordered
   */
  protected EList<MonitoringService> monitoringService;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MonitoringImpl()
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
    return InfoSystemPackage.Literals.MONITORING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MonitoringService> getMonitoringService()
  {
    if (monitoringService == null)
    {
      monitoringService = new EObjectContainmentEList<MonitoringService>(MonitoringService.class, this, InfoSystemPackage.MONITORING__MONITORING_SERVICE);
    }
    return monitoringService;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING__MONITORING_SERVICE:
        return ((InternalEList<?>)getMonitoringService()).basicRemove(otherEnd, msgs);
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
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING__MONITORING_SERVICE:
        return getMonitoringService();
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
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING__MONITORING_SERVICE:
        getMonitoringService().clear();
        getMonitoringService().addAll((Collection<? extends MonitoringService>)newValue);
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
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING__MONITORING_SERVICE:
        getMonitoringService().clear();
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
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING__MONITORING_SERVICE:
        return monitoringService != null && !monitoringService.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MonitoringImpl
