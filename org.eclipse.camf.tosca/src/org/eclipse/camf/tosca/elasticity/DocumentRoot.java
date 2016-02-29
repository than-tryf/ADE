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
package org.eclipse.camf.tosca.elasticity;

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
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getImageArtifactProperties <em>Image Artifact Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getNodeProperties <em>Node Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getScriptArtifactProperties <em>Script Artifact Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getServiceProperties <em>Service Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot()
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
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_Mixed()
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
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_XMLNSPrefixMap()
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
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
  EMap<String, String> getXSISchemaLocation();

  /**
	 * Returns the value of the '<em><b>Image Artifact Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Image Artifact Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Artifact Properties</em>' containment reference.
	 * @see #setImageArtifactProperties(ImageArtifactPropertiesType)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ImageArtifactProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ImageArtifactProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  ImageArtifactPropertiesType getImageArtifactProperties();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getImageArtifactProperties <em>Image Artifact Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Artifact Properties</em>' containment reference.
	 * @see #getImageArtifactProperties()
	 * @generated
	 */
  void setImageArtifactProperties(ImageArtifactPropertiesType value);

  /**
	 * Returns the value of the '<em><b>Node Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Properties</em>' containment reference.
	 * @see #setNodeProperties(NodePropertiesType)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_NodeProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='NodeProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  NodePropertiesType getNodeProperties();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getNodeProperties <em>Node Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Properties</em>' containment reference.
	 * @see #getNodeProperties()
	 * @generated
	 */
  void setNodeProperties(NodePropertiesType value);

  /**
	 * Returns the value of the '<em><b>Script Artifact Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Artifact Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Artifact Properties</em>' containment reference.
	 * @see #setScriptArtifactProperties(ScriptArtifactPropertiesType)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ScriptArtifactProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ScriptArtifactProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  ScriptArtifactPropertiesType getScriptArtifactProperties();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getScriptArtifactProperties <em>Script Artifact Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Artifact Properties</em>' containment reference.
	 * @see #getScriptArtifactProperties()
	 * @generated
	 */
  void setScriptArtifactProperties(ScriptArtifactPropertiesType value);

  /**
	 * Returns the value of the '<em><b>Service Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Service Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Properties</em>' containment reference.
	 * @see #setServiceProperties(ServicePropertiesType)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getDocumentRoot_ServiceProperties()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='ServiceProperties' namespace='##targetNamespace'"
	 * @generated
	 */
  ServicePropertiesType getServiceProperties();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getServiceProperties <em>Service Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Properties</em>' containment reference.
	 * @see #getServiceProperties()
	 * @generated
	 */
  void setServiceProperties(ServicePropertiesType value);

} // DocumentRoot
