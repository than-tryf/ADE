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
package org.eclipse.camf.tosca;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTopology Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TTopologyTemplate#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TTopologyTemplate#getNodeTemplate <em>Node Template</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TTopologyTemplate#getRelationshipTemplate <em>Relationship Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTTopologyTemplate()
 * @model extendedMetaData="name='tTopologyTemplate' kind='elementOnly'"
 * @generated
 */
public interface TTopologyTemplate extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTTopologyTemplate_Group()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='group' name='group:3'"
   * @generated
   */
  FeatureMap getGroup();

  /**
   * Returns the value of the '<em><b>Node Template</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TNodeTemplate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Template</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node Template</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTTopologyTemplate_NodeTemplate()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='NodeTemplate' namespace='##targetNamespace' group='#group:3'"
   * @generated
   */
  EList<TNodeTemplate> getNodeTemplate();

  /**
   * Returns the value of the '<em><b>Relationship Template</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.tosca.TRelationshipTemplate}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relationship Template</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relationship Template</em>' containment reference list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTTopologyTemplate_RelationshipTemplate()
   * @model containment="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='element' name='RelationshipTemplate' namespace='##targetNamespace' group='#group:3'"
   * @generated
   */
  EList<TRelationshipTemplate> getRelationshipTemplate();

} // TTopologyTemplate
