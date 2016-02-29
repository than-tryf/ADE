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

import org.eclipse.camf.tosca.TBoundaryDefinitions;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TBoundary Definitions Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTBoundaryDefinitionsExtension()
 * @model extendedMetaData="name='TBoundaryDefinitionsExtension' kind='elementOnly'"
 * @generated
 */
public interface TBoundaryDefinitionsExtension extends TBoundaryDefinitions
{
  /**
	 * Returns the value of the '<em><b>Monitoring Probes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitoring Probes</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitoring Probes</em>' containment reference.
	 * @see #setMonitoringProbes(MonitoringProbesType1)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTBoundaryDefinitionsExtension_MonitoringProbes()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='monitoringProbes' namespace='##targetNamespace'"
	 * @generated
	 */
  MonitoringProbesType1 getMonitoringProbes();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitoring Probes</em>' containment reference.
	 * @see #getMonitoringProbes()
	 * @generated
	 */
  void setMonitoringProbes(MonitoringProbesType1 value);

} // TBoundaryDefinitionsExtension
