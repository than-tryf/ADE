/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Monitoring#getMonitoringService <em>Monitoring Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoring()
 * @model
 * @generated
 */
public interface Monitoring extends EObject
{
  /**
   * Returns the value of the '<em><b>Monitoring Service</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.MonitoringService}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitoring Service</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Monitoring Service</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getMonitoring_MonitoringService()
   * @model containment="true" required="true"
   * @generated
   */
  EList<MonitoringService> getMonitoringService();

} // Monitoring
