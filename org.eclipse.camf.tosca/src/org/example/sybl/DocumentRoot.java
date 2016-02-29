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
package org.example.sybl;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.sybl.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.example.sybl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.example.sybl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.example.sybl.DocumentRoot#getConstraintProperties <em>Constraint Properties</em>}</li>
 *   <li>{@link org.example.sybl.DocumentRoot#getStrategyProperties <em>Strategy Properties</em>}</li>
 *   <li>{@link org.example.sybl.DocumentRoot#getSYBLElasticityRequirementsDescription <em>SYBL Elasticity Requirements Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.sybl.SyblPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject
{
  /**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
  FeatureMap getMixed();

  /**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
  EMap<String, String> getXMLNSPrefixMap();

  /**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
  EMap<String, String> getXSISchemaLocation();

  /**
	 * Returns the value of the '<em><b>Constraint Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Properties</em>' containment reference.
	 * @see #setConstraintProperties(Constraint)
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_ConstraintProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ConstraintProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  Constraint getConstraintProperties();

  /**
	 * Sets the value of the '{@link org.example.sybl.DocumentRoot#getConstraintProperties <em>Constraint Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Properties</em>' containment reference.
	 * @see #getConstraintProperties()
	 * @generated
	 */
  void setConstraintProperties(Constraint value);

  /**
	 * Returns the value of the '<em><b>Strategy Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Strategy Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy Properties</em>' containment reference.
	 * @see #setStrategyProperties(Strategy)
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_StrategyProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='StrategyProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  Strategy getStrategyProperties();

  /**
	 * Sets the value of the '{@link org.example.sybl.DocumentRoot#getStrategyProperties <em>Strategy Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy Properties</em>' containment reference.
	 * @see #getStrategyProperties()
	 * @generated
	 */
  void setStrategyProperties(Strategy value);

  /**
	 * Returns the value of the '<em><b>SYBL Elasticity Requirements Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>SYBL Elasticity Requirements Description</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>SYBL Elasticity Requirements Description</em>' containment reference.
	 * @see #setSYBLElasticityRequirementsDescription(SyblElasticityRequirementsDescription)
	 * @see org.example.sybl.SyblPackage#getDocumentRoot_SYBLElasticityRequirementsDescription()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='SYBLElasticityRequirementsDescription' namespace='##targetNamespace'"
	 * @generated
	 */
  SyblElasticityRequirementsDescription getSYBLElasticityRequirementsDescription();

  /**
	 * Sets the value of the '{@link org.example.sybl.DocumentRoot#getSYBLElasticityRequirementsDescription <em>SYBL Elasticity Requirements Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SYBL Elasticity Requirements Description</em>' containment reference.
	 * @see #getSYBLElasticityRequirementsDescription()
	 * @generated
	 */
  void setSYBLElasticityRequirementsDescription(SyblElasticityRequirementsDescription value);

} // DocumentRoot
