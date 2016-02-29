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

import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *     <h1>About the XML namespace</h1>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema document describes the XML namespace, in a form
 *       suitable for import by other schema documents.
 *      </p>
 *      <p>
 *       See <a href="http://www.w3.org/XML/1998/namespace.html">
 *       http://www.w3.org/XML/1998/namespace.html</a> and
 *       <a href="http://www.w3.org/TR/REC-xml">
 *       http://www.w3.org/TR/REC-xml</a> for information 
 *       about this namespace.
 *      </p>
 *      <p>
 *       Note that local names in this namespace are intended to be
 *       defined only by the World Wide Web Consortium or its subgroups.
 *       The names currently defined in this namespace are listed below.
 *       They should not be used with conflicting semantics by any Working
 *       Group, specification, or document instance.
 *      </p>
 *      <p>   
 *       See further below in this document for more information about <a href="#usage">how to refer to this schema document from your own
 *       XSD schema documents</a> and about <a href="#nsversioning">the
 *       namespace-versioning policy governing this schema document</a>.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *    
 *     <h3>Father (in any context at all)</h3> 
 * 
 *     <div class="bodytext">
 *      <p>
 *       denotes Jon Bosak, the chair of 
 *       the original XML Working Group.  This name is reserved by 
 *       the following decision of the W3C XML Plenary and 
 *       XML Coordination groups:
 *      </p>
 *      <blockquote>
 *        <p>
 * 	In appreciation for his vision, leadership and
 * 	dedication the W3C XML Plenary on this 10th day of
 * 	February, 2000, reserves for Jon Bosak in perpetuity
 * 	the XML name "xml:Father".
 *        </p>
 *      </blockquote>
 *     </div>
 *    </div>
 *   
 * 
 *    <div id="usage" xml:id="usage" xmlns="http://www.w3.org/1999/xhtml">
 *     <h2>
 *       <a name="usage">About this schema document</a>
 *     </h2>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema defines attributes and an attribute group suitable
 *       for use by schemas wishing to allow <code>xml:base</code>,
 *       <code>xml:lang</code>, <code>xml:space</code> or
 *       <code>xml:id</code> attributes on elements they define.
 *      </p>
 *      <p>
 *       To enable this, such a schema must import this schema for
 *       the XML namespace, e.g. as follows:
 *      </p>
 *      <pre>
 *           &lt;schema . . .&gt;
 *            . . .
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2001/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       or
 *      </p>
 *      <pre>
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2009/01/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       Subsequently, qualified reference to any of the attributes or the
 *       group defined below will have the desired effect, e.g.
 *      </p>
 *      <pre>
 *           &lt;type . . .&gt;
 *            . . .
 *            &lt;attributeGroup ref="xml:specialAttrs"/&gt;
 *      </pre>
 *      <p>
 *       will define a type which will schema-validate an instance element
 *       with any of those attributes.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div id="nsversioning" xml:id="nsversioning" xmlns="http://www.w3.org/1999/xhtml">
 *     <h2>
 *       <a name="nsversioning">Versioning policy for this schema document</a>
 *     </h2>
 *     <div class="bodytext">
 *      <p>
 *       In keeping with the XML Schema WG's standard versioning
 *       policy, this schema document will persist at
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd</a>.
 *      </p>
 *      <p>
 *       At the date of issue it can also be found at
 *       <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd</a>.
 *      </p>
 *      <p>
 *       The schema document at that URI may however change in the future,
 *       in order to remain compatible with the latest version of XML
 *       Schema itself, or with the XML namespace itself.  In other words,
 *       if the XML Schema or XML namespaces change, the version of this
 *       document at <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd 
 *       </a> 
 *       will change accordingly; the version at 
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd 
 *       </a> 
 *       will not change.
 *      </p>
 *      <p>
 *       Previous dated (and unchanging) versions of this schema 
 *       document are at:
 *      </p>
 *      <ul>
 *       <li>
 *           <a href="http://www.w3.org/2009/01/xml.xsd">
 * 	http://www.w3.org/2009/01/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2007/08/xml.xsd">
 * 	http://www.w3.org/2007/08/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2004/10/xml.xsd">
 * 	http://www.w3.org/2004/10/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2001/03/xml.xsd">
 * 	http://www.w3.org/2001/03/xml.xsd</a>
 *         </li>
 *      </ul>
 *     </div>
 *    </div>
 *   
 * <!-- end-model-doc -->
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory
 * @model kind="package"
 * @generated
 */
public interface Tosca_Elasticity_ExtensionsPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "elasticity";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.example.org/NewXMLSchema";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "elasticity";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  Tosca_Elasticity_ExtensionsPackage eINSTANCE = org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDocumentRoot()
	 * @generated
	 */
  int DOCUMENT_ROOT = 0;

  /**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__MIXED = 0;

  /**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

  /**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

  /**
	 * The feature id for the '<em><b>Image Artifact Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES = 3;

  /**
	 * The feature id for the '<em><b>Node Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__NODE_PROPERTIES = 4;

  /**
	 * The feature id for the '<em><b>Script Artifact Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES = 5;

  /**
	 * The feature id for the '<em><b>Service Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__SERVICE_PROPERTIES = 6;

  /**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT_FEATURE_COUNT = 7;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl <em>Image Artifact Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getImageArtifactPropertiesType()
	 * @generated
	 */
  int IMAGE_ARTIFACT_PROPERTIES_TYPE = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION = 0;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IMAGE_ARTIFACT_PROPERTIES_TYPE__ID = 1;

  /**
	 * The number of structural features of the '<em>Image Artifact Properties Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int IMAGE_ARTIFACT_PROPERTIES_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.MonitoringProbesType1Impl <em>Monitoring Probes Type1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.MonitoringProbesType1Impl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getMonitoringProbesType1()
	 * @generated
	 */
  int MONITORING_PROBES_TYPE1 = 2;

  /**
	 * The feature id for the '<em><b>Monitoring Probes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBES_TYPE1__MONITORING_PROBES = 0;

  /**
	 * The number of structural features of the '<em>Monitoring Probes Type1</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBES_TYPE1_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.NodePropertiesTypeImpl <em>Node Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.NodePropertiesTypeImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getNodePropertiesType()
	 * @generated
	 */
  int NODE_PROPERTIES_TYPE = 3;

  /**
	 * The feature id for the '<em><b>Flavor</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NODE_PROPERTIES_TYPE__FLAVOR = 0;

  /**
	 * The number of structural features of the '<em>Node Properties Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int NODE_PROPERTIES_TYPE_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.ScriptArtifactPropertiesTypeImpl <em>Script Artifact Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.ScriptArtifactPropertiesTypeImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getScriptArtifactPropertiesType()
	 * @generated
	 */
  int SCRIPT_ARTIFACT_PROPERTIES_TYPE = 4;

  /**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SCRIPT_ARTIFACT_PROPERTIES_TYPE__LANGUAGE = 0;

  /**
	 * The number of structural features of the '<em>Script Artifact Properties Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SCRIPT_ARTIFACT_PROPERTIES_TYPE_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl <em>Service Properties Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getServicePropertiesType()
	 * @generated
	 */
  int SERVICE_PROPERTIES_TYPE = 5;

  /**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVICE_PROPERTIES_TYPE__VERSION = 0;

  /**
	 * The feature id for the '<em><b>Hosting Environment</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT = 1;

		/**
	 * The number of structural features of the '<em>Service Properties Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SERVICE_PROPERTIES_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl <em>TBoundary Definitions Extension</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTBoundaryDefinitionsExtension()
	 * @generated
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION = 6;

  /**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__PROPERTIES = ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTIES;

  /**
	 * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__PROPERTY_CONSTRAINTS = ToscaPackage.TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS;

  /**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__REQUIREMENTS = ToscaPackage.TBOUNDARY_DEFINITIONS__REQUIREMENTS;

  /**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__CAPABILITIES = ToscaPackage.TBOUNDARY_DEFINITIONS__CAPABILITIES;

  /**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__POLICIES = ToscaPackage.TBOUNDARY_DEFINITIONS__POLICIES;

  /**
	 * The feature id for the '<em><b>Interfaces</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__INTERFACES = ToscaPackage.TBOUNDARY_DEFINITIONS__INTERFACES;

  /**
	 * The feature id for the '<em><b>Monitoring Probes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>TBoundary Definitions Extension</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TBOUNDARY_DEFINITIONS_EXTENSION_FEATURE_COUNT = ToscaPackage.TBOUNDARY_DEFINITIONS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.TMonitoringProbeImpl <em>TMonitoring Probe</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.TMonitoringProbeImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTMonitoringProbe()
	 * @generated
	 */
  int TMONITORING_PROBE = 7;

  /**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TMONITORING_PROBE__DOCUMENTATION = ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TMONITORING_PROBE__ANY = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY;

  /**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TMONITORING_PROBE__ANY_ATTRIBUTE = ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TMONITORING_PROBE__NAME = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
	 * The number of structural features of the '<em>TMonitoring Probe</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TMONITORING_PROBE_FEATURE_COUNT = ToscaPackage.TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
	 * @generated
	 */
  int TNODE_TEMPLATE_EXTENSION = 8;

  /**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__DOCUMENTATION = ToscaPackage.TNODE_TEMPLATE__DOCUMENTATION;

  /**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__ANY = ToscaPackage.TNODE_TEMPLATE__ANY;

  /**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__ANY_ATTRIBUTE = ToscaPackage.TNODE_TEMPLATE__ANY_ATTRIBUTE;

  /**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__PROPERTIES = ToscaPackage.TNODE_TEMPLATE__PROPERTIES;

  /**
	 * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__PROPERTY_CONSTRAINTS = ToscaPackage.TNODE_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__ID = ToscaPackage.TNODE_TEMPLATE__ID;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__TYPE = ToscaPackage.TNODE_TEMPLATE__TYPE;

  /**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__REQUIREMENTS = ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS;

  /**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__CAPABILITIES = ToscaPackage.TNODE_TEMPLATE__CAPABILITIES;

  /**
	 * The feature id for the '<em><b>Policies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__POLICIES = ToscaPackage.TNODE_TEMPLATE__POLICIES;

  /**
	 * The feature id for the '<em><b>Deployment Artifacts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__DEPLOYMENT_ARTIFACTS = ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS;

  /**
	 * The feature id for the '<em><b>Max Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__MAX_INSTANCES = ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES;

  /**
	 * The feature id for the '<em><b>Min Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__MIN_INSTANCES = ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__NAME = ToscaPackage.TNODE_TEMPLATE__NAME;

  /**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__HEIGHT = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Init Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__WIDTH = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__X = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 3;

  /**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION__Y = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 4;

  /**
	 * The number of structural features of the '<em>TNode Template Extension</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TNODE_TEMPLATE_EXTENSION_FEATURE_COUNT = ToscaPackage.TNODE_TEMPLATE_FEATURE_COUNT + 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.tosca.elasticity.impl.TServiceTemplateExtensionImpl <em>TService Template Extension</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.tosca.elasticity.impl.TServiceTemplateExtensionImpl
	 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTServiceTemplateExtension()
	 * @generated
	 */
  int TSERVICE_TEMPLATE_EXTENSION = 9;

  /**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__DOCUMENTATION = ToscaPackage.TSERVICE_TEMPLATE__DOCUMENTATION;

  /**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__ANY = ToscaPackage.TSERVICE_TEMPLATE__ANY;

  /**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__ANY_ATTRIBUTE = ToscaPackage.TSERVICE_TEMPLATE__ANY_ATTRIBUTE;

  /**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__TAGS = ToscaPackage.TSERVICE_TEMPLATE__TAGS;

  /**
	 * The feature id for the '<em><b>Boundary Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__BOUNDARY_DEFINITIONS = ToscaPackage.TSERVICE_TEMPLATE__BOUNDARY_DEFINITIONS;

  /**
	 * The feature id for the '<em><b>Topology Template</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__TOPOLOGY_TEMPLATE = ToscaPackage.TSERVICE_TEMPLATE__TOPOLOGY_TEMPLATE;

  /**
	 * The feature id for the '<em><b>Plans</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__PLANS = ToscaPackage.TSERVICE_TEMPLATE__PLANS;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__ID = ToscaPackage.TSERVICE_TEMPLATE__ID;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__NAME = ToscaPackage.TSERVICE_TEMPLATE__NAME;

  /**
	 * The feature id for the '<em><b>Substitutable Node Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__SUBSTITUTABLE_NODE_TYPE = ToscaPackage.TSERVICE_TEMPLATE__SUBSTITUTABLE_NODE_TYPE;

  /**
	 * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__TARGET_NAMESPACE = ToscaPackage.TSERVICE_TEMPLATE__TARGET_NAMESPACE;

  /**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__HEIGHT = ToscaPackage.TSERVICE_TEMPLATE_FEATURE_COUNT + 0;

  /**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__WIDTH = ToscaPackage.TSERVICE_TEMPLATE_FEATURE_COUNT + 1;

  /**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__X = ToscaPackage.TSERVICE_TEMPLATE_FEATURE_COUNT + 2;

  /**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION__Y = ToscaPackage.TSERVICE_TEMPLATE_FEATURE_COUNT + 3;

  /**
	 * The number of structural features of the '<em>TService Template Extension</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TSERVICE_TEMPLATE_EXTENSION_FEATURE_COUNT = ToscaPackage.TSERVICE_TEMPLATE_FEATURE_COUNT + 4;


  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot
	 * @generated
	 */
  EClass getDocumentRoot();

  /**
	 * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EAttribute getDocumentRoot_Mixed();

  /**
	 * Returns the meta object for the map '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
	 * Returns the meta object for the map '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getImageArtifactProperties <em>Image Artifact Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image Artifact Properties</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getImageArtifactProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_ImageArtifactProperties();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getNodeProperties <em>Node Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node Properties</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getNodeProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_NodeProperties();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getScriptArtifactProperties <em>Script Artifact Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Script Artifact Properties</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getScriptArtifactProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_ScriptArtifactProperties();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot#getServiceProperties <em>Service Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Properties</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot#getServiceProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_ServiceProperties();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType <em>Image Artifact Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Artifact Properties Type</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType
	 * @generated
	 */
  EClass getImageArtifactPropertiesType();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getDescription()
	 * @see #getImageArtifactPropertiesType()
	 * @generated
	 */
  EAttribute getImageArtifactPropertiesType_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getId()
	 * @see #getImageArtifactPropertiesType()
	 * @generated
	 */
  EAttribute getImageArtifactPropertiesType_Id();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.MonitoringProbesType1 <em>Monitoring Probes Type1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitoring Probes Type1</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.MonitoringProbesType1
	 * @generated
	 */
  EClass getMonitoringProbesType1();

  /**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes <em>Monitoring Probes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Monitoring Probes</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.MonitoringProbesType1#getMonitoringProbes()
	 * @see #getMonitoringProbesType1()
	 * @generated
	 */
  EReference getMonitoringProbesType1_MonitoringProbes();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.NodePropertiesType <em>Node Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Properties Type</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.NodePropertiesType
	 * @generated
	 */
  EClass getNodePropertiesType();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.NodePropertiesType#getFlavor <em>Flavor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flavor</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.NodePropertiesType#getFlavor()
	 * @see #getNodePropertiesType()
	 * @generated
	 */
  EAttribute getNodePropertiesType_Flavor();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType <em>Script Artifact Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script Artifact Properties Type</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType
	 * @generated
	 */
  EClass getScriptArtifactPropertiesType();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType#getLanguage()
	 * @see #getScriptArtifactPropertiesType()
	 * @generated
	 */
  EAttribute getScriptArtifactPropertiesType_Language();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.ServicePropertiesType <em>Service Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Properties Type</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ServicePropertiesType
	 * @generated
	 */
  EClass getServicePropertiesType();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.ServicePropertiesType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ServicePropertiesType#getVersion()
	 * @see #getServicePropertiesType()
	 * @generated
	 */
  EAttribute getServicePropertiesType_Version();

  /**
	 * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.elasticity.ServicePropertiesType#getHostingEnvironment <em>Hosting Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Hosting Environment</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.ServicePropertiesType#getHostingEnvironment()
	 * @see #getServicePropertiesType()
	 * @generated
	 */
	EAttribute getServicePropertiesType_HostingEnvironment();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBoundary Definitions Extension</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension
	 * @generated
	 */
  EClass getTBoundaryDefinitionsExtension();

  /**
	 * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes <em>Monitoring Probes</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Monitoring Probes</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension#getMonitoringProbes()
	 * @see #getTBoundaryDefinitionsExtension()
	 * @generated
	 */
  EReference getTBoundaryDefinitionsExtension_MonitoringProbes();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.TMonitoringProbe <em>TMonitoring Probe</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMonitoring Probe</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TMonitoringProbe
	 * @generated
	 */
  EClass getTMonitoringProbe();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TMonitoringProbe#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TMonitoringProbe#getName()
	 * @see #getTMonitoringProbe()
	 * @generated
	 */
  EAttribute getTMonitoringProbe_Name();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension <em>TNode Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TNode Template Extension</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension
	 * @generated
	 */
  EClass getTNodeTemplateExtension();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
  EAttribute getTNodeTemplateExtension_Height();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Instances</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
  EAttribute getTNodeTemplateExtension_InitInstances();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
  EAttribute getTNodeTemplateExtension_Width();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
  EAttribute getTNodeTemplateExtension_X();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY()
	 * @see #getTNodeTemplateExtension()
	 * @generated
	 */
  EAttribute getTNodeTemplateExtension_Y();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension <em>TService Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TService Template Extension</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension
	 * @generated
	 */
  EClass getTServiceTemplateExtension();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getHeight()
	 * @see #getTServiceTemplateExtension()
	 * @generated
	 */
  EAttribute getTServiceTemplateExtension_Height();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getWidth()
	 * @see #getTServiceTemplateExtension()
	 * @generated
	 */
  EAttribute getTServiceTemplateExtension_Width();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getX()
	 * @see #getTServiceTemplateExtension()
	 * @generated
	 */
  EAttribute getTServiceTemplateExtension_X();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension#getY()
	 * @see #getTServiceTemplateExtension()
	 * @generated
	 */
  EAttribute getTServiceTemplateExtension_Y();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  Tosca_Elasticity_ExtensionsFactory getTosca_Elasticity_ExtensionsFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getDocumentRoot()
		 * @generated
		 */
    EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

    /**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

    /**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

    /**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

    /**
		 * The meta object literal for the '<em><b>Image Artifact Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES = eINSTANCE.getDocumentRoot_ImageArtifactProperties();

    /**
		 * The meta object literal for the '<em><b>Node Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__NODE_PROPERTIES = eINSTANCE.getDocumentRoot_NodeProperties();

    /**
		 * The meta object literal for the '<em><b>Script Artifact Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES = eINSTANCE.getDocumentRoot_ScriptArtifactProperties();

    /**
		 * The meta object literal for the '<em><b>Service Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__SERVICE_PROPERTIES = eINSTANCE.getDocumentRoot_ServiceProperties();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl <em>Image Artifact Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getImageArtifactPropertiesType()
		 * @generated
		 */
    EClass IMAGE_ARTIFACT_PROPERTIES_TYPE = eINSTANCE.getImageArtifactPropertiesType();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION = eINSTANCE.getImageArtifactPropertiesType_Description();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute IMAGE_ARTIFACT_PROPERTIES_TYPE__ID = eINSTANCE.getImageArtifactPropertiesType_Id();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.MonitoringProbesType1Impl <em>Monitoring Probes Type1</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.MonitoringProbesType1Impl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getMonitoringProbesType1()
		 * @generated
		 */
    EClass MONITORING_PROBES_TYPE1 = eINSTANCE.getMonitoringProbesType1();

    /**
		 * The meta object literal for the '<em><b>Monitoring Probes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference MONITORING_PROBES_TYPE1__MONITORING_PROBES = eINSTANCE.getMonitoringProbesType1_MonitoringProbes();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.NodePropertiesTypeImpl <em>Node Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.NodePropertiesTypeImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getNodePropertiesType()
		 * @generated
		 */
    EClass NODE_PROPERTIES_TYPE = eINSTANCE.getNodePropertiesType();

    /**
		 * The meta object literal for the '<em><b>Flavor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute NODE_PROPERTIES_TYPE__FLAVOR = eINSTANCE.getNodePropertiesType_Flavor();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.ScriptArtifactPropertiesTypeImpl <em>Script Artifact Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.ScriptArtifactPropertiesTypeImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getScriptArtifactPropertiesType()
		 * @generated
		 */
    EClass SCRIPT_ARTIFACT_PROPERTIES_TYPE = eINSTANCE.getScriptArtifactPropertiesType();

    /**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SCRIPT_ARTIFACT_PROPERTIES_TYPE__LANGUAGE = eINSTANCE.getScriptArtifactPropertiesType_Language();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl <em>Service Properties Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.ServicePropertiesTypeImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getServicePropertiesType()
		 * @generated
		 */
    EClass SERVICE_PROPERTIES_TYPE = eINSTANCE.getServicePropertiesType();

    /**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SERVICE_PROPERTIES_TYPE__VERSION = eINSTANCE.getServicePropertiesType_Version();

    /**
		 * The meta object literal for the '<em><b>Hosting Environment</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT = eINSTANCE.getServicePropertiesType_HostingEnvironment();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl <em>TBoundary Definitions Extension</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.TBoundaryDefinitionsExtensionImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTBoundaryDefinitionsExtension()
		 * @generated
		 */
    EClass TBOUNDARY_DEFINITIONS_EXTENSION = eINSTANCE.getTBoundaryDefinitionsExtension();

    /**
		 * The meta object literal for the '<em><b>Monitoring Probes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES = eINSTANCE.getTBoundaryDefinitionsExtension_MonitoringProbes();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.TMonitoringProbeImpl <em>TMonitoring Probe</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.TMonitoringProbeImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTMonitoringProbe()
		 * @generated
		 */
    EClass TMONITORING_PROBE = eINSTANCE.getTMonitoringProbe();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TMONITORING_PROBE__NAME = eINSTANCE.getTMonitoringProbe_Name();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl <em>TNode Template Extension</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTNodeTemplateExtension()
		 * @generated
		 */
    EClass TNODE_TEMPLATE_EXTENSION = eINSTANCE.getTNodeTemplateExtension();

    /**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TNODE_TEMPLATE_EXTENSION__HEIGHT = eINSTANCE.getTNodeTemplateExtension_Height();

    /**
		 * The meta object literal for the '<em><b>Init Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES = eINSTANCE.getTNodeTemplateExtension_InitInstances();

    /**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TNODE_TEMPLATE_EXTENSION__WIDTH = eINSTANCE.getTNodeTemplateExtension_Width();

    /**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TNODE_TEMPLATE_EXTENSION__X = eINSTANCE.getTNodeTemplateExtension_X();

    /**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TNODE_TEMPLATE_EXTENSION__Y = eINSTANCE.getTNodeTemplateExtension_Y();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.tosca.elasticity.impl.TServiceTemplateExtensionImpl <em>TService Template Extension</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.tosca.elasticity.impl.TServiceTemplateExtensionImpl
		 * @see org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl#getTServiceTemplateExtension()
		 * @generated
		 */
    EClass TSERVICE_TEMPLATE_EXTENSION = eINSTANCE.getTServiceTemplateExtension();

    /**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TSERVICE_TEMPLATE_EXTENSION__HEIGHT = eINSTANCE.getTServiceTemplateExtension_Height();

    /**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TSERVICE_TEMPLATE_EXTENSION__WIDTH = eINSTANCE.getTServiceTemplateExtension_Width();

    /**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TSERVICE_TEMPLATE_EXTENSION__X = eINSTANCE.getTServiceTemplateExtension_X();

    /**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TSERVICE_TEMPLATE_EXTENSION__Y = eINSTANCE.getTServiceTemplateExtension_Y();

  }

} //Tosca_Elasticity_ExtensionsPackage
