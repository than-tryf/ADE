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
package org.eclipse.camf.tosca.elasticity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitoring Probes Type1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes <em>Monitoring Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getMonitoringProbesType1()
 * @model extendedMetaData="name='MonitoringProbesType1' kind='elementOnly'"
 * @generated
 */
public interface MonitoringProbesType1 extends EObject
{
  /**
	 * Returns the value of the '<em><b>Monitoring Probes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.camf.tosca.elasticity.TMonitoringProbe}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitoring Probes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring Probes</em>' containment reference list.
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getMonitoringProbesType1_MonitoringProbes()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='monitoringProbes' namespace='##targetNamespace'"
	 * @generated
	 */
  EList<TMonitoringProbe> getMonitoringProbes();

} // MonitoringProbesType1
