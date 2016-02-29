/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringService#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.MonitoringService#getProbes <em>Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringService()
 * @model
 * @generated
 */
public interface MonitoringService extends EObject
{
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
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringService_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.MonitoringService#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Probes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.MonitoringProbe}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Probes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Probes</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoringService_Probes()
   * @model containment="true" required="true"
   * @generated
   */
  EList<MonitoringProbe> getProbes();

} // MonitoringService
