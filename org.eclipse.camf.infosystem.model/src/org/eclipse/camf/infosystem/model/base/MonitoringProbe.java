package org.eclipse.camf.infosystem.model.base;


import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring Probe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getMetrics <em>Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringProbe()
 * @model extendedMetaData="name='MonitoringProbe' kind='elementOnly'"
 * @generated
 */
public interface MonitoringProbe extends EObject
{
  /**
   * Returns the value of the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>UID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>UID</em>' attribute.
   * @see #setUID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringProbe_UID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='UID' namespace='##targetNamespace'"
   * @generated
   */
  String getUID();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getUID <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>UID</em>' attribute.
   * @see #getUID()
   * @generated
   */
  void setUID(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringProbe_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Name' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringProbe_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Description' namespace='##targetNamespace'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Metrics</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Metrics</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metrics</em>' attribute.
   * @see #setMetrics(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringProbe_Metrics()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='URL' namespace='##targetNamespace'"
   * @generated
   */
  String getMetrics();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getMetrics <em>Metrics</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metrics</em>' attribute.
   * @see #getMetrics()
   * @generated
   */
  void setMetrics(String value);

} // MonitoringProbe