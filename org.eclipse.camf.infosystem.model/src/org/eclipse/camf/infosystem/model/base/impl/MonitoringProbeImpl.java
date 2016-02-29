package org.eclipse.camf.infosystem.model.base.impl;


import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monitoring Probe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonitoringProbeImpl extends EObjectImpl implements MonitoringProbe
{
  /**
   * The default value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
  protected static final String UID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
  protected String uID = UID_EDEFAULT;

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
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetrics()
   * @generated
   * @ordered
   */
  protected static final String METRICS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetrics()
   * @generated
   * @ordered
   */
  protected String metrics = METRICS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MonitoringProbeImpl()
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
    return InfoSystemPackage.Literals.MONITORING_PROBE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUID()
  {
    return uID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUID(String newUID)
  {
    String oldUID = uID;
    uID = newUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MONITORING_PROBE__UID, oldUID, uID));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MONITORING_PROBE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MONITORING_PROBE__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMetrics()
  {
    return metrics;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMetrics(String newMetrics)
  {
    String oldMetrics = metrics;
    metrics = newMetrics;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.MONITORING_PROBE__METRICS, oldMetrics, metrics));
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
      case InfoSystemPackage.MONITORING_PROBE__UID:
        return getUID();
      case InfoSystemPackage.MONITORING_PROBE__NAME:
        return getName();
      case InfoSystemPackage.MONITORING_PROBE__DESCRIPTION:
        return getDescription();
      case InfoSystemPackage.MONITORING_PROBE__METRICS:
        return getMetrics();
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
    switch (featureID)
    {
      case InfoSystemPackage.MONITORING_PROBE__UID:
        setUID((String)newValue);
        return;
      case InfoSystemPackage.MONITORING_PROBE__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.MONITORING_PROBE__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case InfoSystemPackage.MONITORING_PROBE__METRICS:
        setMetrics((String)newValue);
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
      case InfoSystemPackage.MONITORING_PROBE__UID:
        setUID(UID_EDEFAULT);
        return;
      case InfoSystemPackage.MONITORING_PROBE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.MONITORING_PROBE__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case InfoSystemPackage.MONITORING_PROBE__METRICS:
        setMetrics(METRICS_EDEFAULT);
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
      case InfoSystemPackage.MONITORING_PROBE__UID:
        return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
      case InfoSystemPackage.MONITORING_PROBE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.MONITORING_PROBE__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case InfoSystemPackage.MONITORING_PROBE__METRICS:
        return METRICS_EDEFAULT == null ? metrics != null : !METRICS_EDEFAULT.equals(metrics);
    }
    return super.eIsSet(featureID);
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
    result.append(" (uID: ");
    result.append(uID);
    result.append(", name: ");
    result.append(name);
    result.append(", description: ");
    result.append(description);
    result.append(", metrics: ");
    result.append(metrics);
    result.append(')');
    return result.toString();
  }

} //MonitoringProbeImpl