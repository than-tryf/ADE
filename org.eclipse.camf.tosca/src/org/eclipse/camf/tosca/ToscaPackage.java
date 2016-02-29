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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.camf.tosca.ToscaFactory
 * @model kind="package"
 * @generated
 */
public interface ToscaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tosca"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://docs.oasis-open.org/tosca/ns/2011/12"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tosca"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ToscaPackage eINSTANCE = org.eclipse.camf.tosca.impl.ToscaPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ArtifactReferencesTypeImpl <em>Artifact References Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ArtifactReferencesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getArtifactReferencesType()
   * @generated
   */
  int ARTIFACT_REFERENCES_TYPE = 0;

  /**
   * The feature id for the '<em><b>Artifact Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE = 0;

  /**
   * The number of structural features of the '<em>Artifact References Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTIFACT_REFERENCES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.CapabilitiesTypeImpl <em>Capabilities Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.CapabilitiesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilitiesType()
   * @generated
   */
  int CAPABILITIES_TYPE = 1;

  /**
   * The feature id for the '<em><b>Capability</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITIES_TYPE__CAPABILITY = 0;

  /**
   * The number of structural features of the '<em>Capabilities Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITIES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.CapabilitiesType1Impl <em>Capabilities Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.CapabilitiesType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilitiesType1()
   * @generated
   */
  int CAPABILITIES_TYPE1 = 2;

  /**
   * The feature id for the '<em><b>Capability</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITIES_TYPE1__CAPABILITY = 0;

  /**
   * The number of structural features of the '<em>Capabilities Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITIES_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.CapabilityDefinitionsTypeImpl <em>Capability Definitions Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.CapabilityDefinitionsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilityDefinitionsType()
   * @generated
   */
  int CAPABILITY_DEFINITIONS_TYPE = 3;

  /**
   * The feature id for the '<em><b>Capability Definition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITY_DEFINITIONS_TYPE__CAPABILITY_DEFINITION = 0;

  /**
   * The number of structural features of the '<em>Capability Definitions Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAPABILITY_DEFINITIONS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ConstraintsTypeImpl <em>Constraints Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ConstraintsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getConstraintsType()
   * @generated
   */
  int CONSTRAINTS_TYPE = 4;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINTS_TYPE__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Constraints Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINTS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ConstraintsType1Impl <em>Constraints Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ConstraintsType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getConstraintsType1()
   * @generated
   */
  int CONSTRAINTS_TYPE1 = 5;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINTS_TYPE1__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Constraints Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TExtensibleElementsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtensibleElements()
   * @generated
   */
  int TEXTENSIBLE_ELEMENTS = 64;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIBLE_ELEMENTS__DOCUMENTATION = 0;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIBLE_ELEMENTS__ANY = 1;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = 2;

  /**
   * The number of structural features of the '<em>TExtensible Elements</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIBLE_ELEMENTS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TDefinitionsImpl <em>TDefinitions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TDefinitionsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDefinitions()
   * @generated
   */
  int TDEFINITIONS = 56;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__EXTENSIONS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Import</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__IMPORT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__TYPES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__GROUP = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Service Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__SERVICE_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Node Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__NODE_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Node Type Implementation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__NODE_TYPE_IMPLEMENTATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Relationship Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__RELATIONSHIP_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Relationship Type Implementation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__RELATIONSHIP_TYPE_IMPLEMENTATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Requirement Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__REQUIREMENT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Capability Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__CAPABILITY_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Artifact Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__ARTIFACT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Artifact Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__ARTIFACT_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Policy Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__POLICY_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Policy Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__POLICY_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__ID = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 16;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 17;

  /**
   * The number of structural features of the '<em>TDefinitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEFINITIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 18;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.DefinitionsTypeImpl <em>Definitions Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.DefinitionsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDefinitionsType()
   * @generated
   */
  int DEFINITIONS_TYPE = 6;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__DOCUMENTATION = TDEFINITIONS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__ANY = TDEFINITIONS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__ANY_ATTRIBUTE = TDEFINITIONS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Extensions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__EXTENSIONS = TDEFINITIONS__EXTENSIONS;

  /**
   * The feature id for the '<em><b>Import</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__IMPORT = TDEFINITIONS__IMPORT;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__TYPES = TDEFINITIONS__TYPES;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__GROUP = TDEFINITIONS__GROUP;

  /**
   * The feature id for the '<em><b>Service Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__SERVICE_TEMPLATE = TDEFINITIONS__SERVICE_TEMPLATE;

  /**
   * The feature id for the '<em><b>Node Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__NODE_TYPE = TDEFINITIONS__NODE_TYPE;

  /**
   * The feature id for the '<em><b>Node Type Implementation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__NODE_TYPE_IMPLEMENTATION = TDEFINITIONS__NODE_TYPE_IMPLEMENTATION;

  /**
   * The feature id for the '<em><b>Relationship Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__RELATIONSHIP_TYPE = TDEFINITIONS__RELATIONSHIP_TYPE;

  /**
   * The feature id for the '<em><b>Relationship Type Implementation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION = TDEFINITIONS__RELATIONSHIP_TYPE_IMPLEMENTATION;

  /**
   * The feature id for the '<em><b>Requirement Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__REQUIREMENT_TYPE = TDEFINITIONS__REQUIREMENT_TYPE;

  /**
   * The feature id for the '<em><b>Capability Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__CAPABILITY_TYPE = TDEFINITIONS__CAPABILITY_TYPE;

  /**
   * The feature id for the '<em><b>Artifact Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__ARTIFACT_TYPE = TDEFINITIONS__ARTIFACT_TYPE;

  /**
   * The feature id for the '<em><b>Artifact Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__ARTIFACT_TEMPLATE = TDEFINITIONS__ARTIFACT_TEMPLATE;

  /**
   * The feature id for the '<em><b>Policy Type</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__POLICY_TYPE = TDEFINITIONS__POLICY_TYPE;

  /**
   * The feature id for the '<em><b>Policy Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__POLICY_TEMPLATE = TDEFINITIONS__POLICY_TEMPLATE;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__ID = TDEFINITIONS__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__NAME = TDEFINITIONS__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE__TARGET_NAMESPACE = TDEFINITIONS__TARGET_NAMESPACE;

  /**
   * The number of structural features of the '<em>Definitions Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITIONS_TYPE_FEATURE_COUNT = TDEFINITIONS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.DerivedFromTypeImpl <em>Derived From Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.DerivedFromTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType()
   * @generated
   */
  int DERIVED_FROM_TYPE = 7;

  /**
   * The feature id for the '<em><b>Relationship Type Implementation Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF = 0;

  /**
   * The number of structural features of the '<em>Derived From Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.DerivedFromType1Impl <em>Derived From Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.DerivedFromType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType1()
   * @generated
   */
  int DERIVED_FROM_TYPE1 = 8;

  /**
   * The feature id for the '<em><b>Node Type Implementation Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF = 0;

  /**
   * The number of structural features of the '<em>Derived From Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.DerivedFromType2Impl <em>Derived From Type2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.DerivedFromType2Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType2()
   * @generated
   */
  int DERIVED_FROM_TYPE2 = 9;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE2__TYPE_REF = 0;

  /**
   * The number of structural features of the '<em>Derived From Type2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_FROM_TYPE2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.DocumentRootImpl <em>Document Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.DocumentRootImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDocumentRoot()
   * @generated
   */
  int DOCUMENT_ROOT = 10;

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
   * The feature id for the '<em><b>Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__DEFINITIONS = 3;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT__DOCUMENTATION = 4;

  /**
   * The number of structural features of the '<em>Document Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_ROOT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ExcludeTypeImpl <em>Exclude Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ExcludeTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getExcludeType()
   * @generated
   */
  int EXCLUDE_TYPE = 11;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_TYPE__PATTERN = 0;

  /**
   * The number of structural features of the '<em>Exclude Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ExtensionsTypeImpl <em>Extensions Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ExtensionsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getExtensionsType()
   * @generated
   */
  int EXTENSIONS_TYPE = 12;

  /**
   * The feature id for the '<em><b>Extension</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSIONS_TYPE__EXTENSION = 0;

  /**
   * The number of structural features of the '<em>Extensions Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSIONS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TImplementationArtifactImpl <em>TImplementation Artifact</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TImplementationArtifactImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImplementationArtifact()
   * @generated
   */
  int TIMPLEMENTATION_ARTIFACT = 67;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Artifact Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__ARTIFACT_REF = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Artifact Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__ARTIFACT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__INTERFACE_NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT__OPERATION_NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>TImplementation Artifact</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACT_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ImplementationArtifactTypeImpl <em>Implementation Artifact Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ImplementationArtifactTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getImplementationArtifactType()
   * @generated
   */
  int IMPLEMENTATION_ARTIFACT_TYPE = 13;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__DOCUMENTATION = TIMPLEMENTATION_ARTIFACT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__ANY = TIMPLEMENTATION_ARTIFACT__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__ANY_ATTRIBUTE = TIMPLEMENTATION_ARTIFACT__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Artifact Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__ARTIFACT_REF = TIMPLEMENTATION_ARTIFACT__ARTIFACT_REF;

  /**
   * The feature id for the '<em><b>Artifact Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__ARTIFACT_TYPE = TIMPLEMENTATION_ARTIFACT__ARTIFACT_TYPE;

  /**
   * The feature id for the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__INTERFACE_NAME = TIMPLEMENTATION_ARTIFACT__INTERFACE_NAME;

  /**
   * The feature id for the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE__OPERATION_NAME = TIMPLEMENTATION_ARTIFACT__OPERATION_NAME;

  /**
   * The number of structural features of the '<em>Implementation Artifact Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLEMENTATION_ARTIFACT_TYPE_FEATURE_COUNT = TIMPLEMENTATION_ARTIFACT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.IncludeTypeImpl <em>Include Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.IncludeTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getIncludeType()
   * @generated
   */
  int INCLUDE_TYPE = 14;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TYPE__PATTERN = 0;

  /**
   * The number of structural features of the '<em>Include Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.InputParametersTypeImpl <em>Input Parameters Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.InputParametersTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInputParametersType()
   * @generated
   */
  int INPUT_PARAMETERS_TYPE = 15;

  /**
   * The feature id for the '<em><b>Input Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETERS_TYPE__INPUT_PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Input Parameters Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETERS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.InputParametersType1Impl <em>Input Parameters Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.InputParametersType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInputParametersType1()
   * @generated
   */
  int INPUT_PARAMETERS_TYPE1 = 16;

  /**
   * The feature id for the '<em><b>Input Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETERS_TYPE1__INPUT_PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Input Parameters Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_PARAMETERS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.InstanceStateTypeImpl <em>Instance State Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.InstanceStateTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInstanceStateType()
   * @generated
   */
  int INSTANCE_STATE_TYPE = 17;

  /**
   * The feature id for the '<em><b>State</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_STATE_TYPE__STATE = 0;

  /**
   * The number of structural features of the '<em>Instance State Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_STATE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.InterfacesTypeImpl <em>Interfaces Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.InterfacesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInterfacesType()
   * @generated
   */
  int INTERFACES_TYPE = 18;

  /**
   * The feature id for the '<em><b>Interface</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACES_TYPE__INTERFACE = 0;

  /**
   * The number of structural features of the '<em>Interfaces Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.InterfacesType1Impl <em>Interfaces Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.InterfacesType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInterfacesType1()
   * @generated
   */
  int INTERFACES_TYPE1 = 19;

  /**
   * The feature id for the '<em><b>Interface</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACES_TYPE1__INTERFACE = 0;

  /**
   * The number of structural features of the '<em>Interfaces Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACES_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.NodeOperationTypeImpl <em>Node Operation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.NodeOperationTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getNodeOperationType()
   * @generated
   */
  int NODE_OPERATION_TYPE = 20;

  /**
   * The feature id for the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_OPERATION_TYPE__INTERFACE_NAME = 0;

  /**
   * The feature id for the '<em><b>Node Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_OPERATION_TYPE__NODE_REF = 1;

  /**
   * The feature id for the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_OPERATION_TYPE__OPERATION_NAME = 2;

  /**
   * The number of structural features of the '<em>Node Operation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_OPERATION_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.NodeTypeReferenceTypeImpl <em>Node Type Reference Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.NodeTypeReferenceTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getNodeTypeReferenceType()
   * @generated
   */
  int NODE_TYPE_REFERENCE_TYPE = 21;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REFERENCE_TYPE__TYPE_REF = 0;

  /**
   * The number of structural features of the '<em>Node Type Reference Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REFERENCE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.OutputParametersTypeImpl <em>Output Parameters Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.OutputParametersTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getOutputParametersType()
   * @generated
   */
  int OUTPUT_PARAMETERS_TYPE = 22;

  /**
   * The feature id for the '<em><b>Output Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETERS_TYPE__OUTPUT_PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Output Parameters Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETERS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.OutputParametersType1Impl <em>Output Parameters Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.OutputParametersType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getOutputParametersType1()
   * @generated
   */
  int OUTPUT_PARAMETERS_TYPE1 = 23;

  /**
   * The feature id for the '<em><b>Output Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Output Parameters Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTPUT_PARAMETERS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PlanModelReferenceTypeImpl <em>Plan Model Reference Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PlanModelReferenceTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanModelReferenceType()
   * @generated
   */
  int PLAN_MODEL_REFERENCE_TYPE = 24;

  /**
   * The feature id for the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_MODEL_REFERENCE_TYPE__REFERENCE = 0;

  /**
   * The number of structural features of the '<em>Plan Model Reference Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_MODEL_REFERENCE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PlanModelTypeImpl <em>Plan Model Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PlanModelTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanModelType()
   * @generated
   */
  int PLAN_MODEL_TYPE = 25;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_MODEL_TYPE__ANY = 0;

  /**
   * The number of structural features of the '<em>Plan Model Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_MODEL_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PlanTypeImpl <em>Plan Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PlanTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanType()
   * @generated
   */
  int PLAN_TYPE = 26;

  /**
   * The feature id for the '<em><b>Plan Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_TYPE__PLAN_REF = 0;

  /**
   * The number of structural features of the '<em>Plan Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAN_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PoliciesTypeImpl <em>Policies Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PoliciesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPoliciesType()
   * @generated
   */
  int POLICIES_TYPE = 27;

  /**
   * The feature id for the '<em><b>Policy</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICIES_TYPE__POLICY = 0;

  /**
   * The number of structural features of the '<em>Policies Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICIES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PoliciesType1Impl <em>Policies Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PoliciesType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPoliciesType1()
   * @generated
   */
  int POLICIES_TYPE1 = 28;

  /**
   * The feature id for the '<em><b>Policy</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICIES_TYPE1__POLICY = 0;

  /**
   * The number of structural features of the '<em>Policies Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POLICIES_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertiesDefinitionTypeImpl <em>Properties Definition Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertiesDefinitionTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesDefinitionType()
   * @generated
   */
  int PROPERTIES_DEFINITION_TYPE = 29;

  /**
   * The feature id for the '<em><b>Element</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_DEFINITION_TYPE__ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_DEFINITION_TYPE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Properties Definition Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_DEFINITION_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertiesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesType()
   * @generated
   */
  int PROPERTIES_TYPE = 30;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_TYPE__ANY = 0;

  /**
   * The number of structural features of the '<em>Properties Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertiesType1Impl <em>Properties Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertiesType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesType1()
   * @generated
   */
  int PROPERTIES_TYPE1 = 31;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_TYPE1__ANY = 0;

  /**
   * The feature id for the '<em><b>Property Mappings</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_TYPE1__PROPERTY_MAPPINGS = 1;

  /**
   * The number of structural features of the '<em>Properties Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTIES_TYPE1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertyConstraintsTypeImpl <em>Property Constraints Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertyConstraintsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyConstraintsType()
   * @generated
   */
  int PROPERTY_CONSTRAINTS_TYPE = 32;

  /**
   * The feature id for the '<em><b>Property Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONSTRAINTS_TYPE__PROPERTY_CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Property Constraints Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONSTRAINTS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertyConstraintsType1Impl <em>Property Constraints Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertyConstraintsType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyConstraintsType1()
   * @generated
   */
  int PROPERTY_CONSTRAINTS_TYPE1 = 33;

  /**
   * The feature id for the '<em><b>Property Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Property Constraints Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_CONSTRAINTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.PropertyMappingsTypeImpl <em>Property Mappings Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.PropertyMappingsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyMappingsType()
   * @generated
   */
  int PROPERTY_MAPPINGS_TYPE = 34;

  /**
   * The feature id for the '<em><b>Property Mapping</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING = 0;

  /**
   * The number of structural features of the '<em>Property Mappings Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_MAPPINGS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RelationshipConstraintsTypeImpl <em>Relationship Constraints Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RelationshipConstraintsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipConstraintsType()
   * @generated
   */
  int RELATIONSHIP_CONSTRAINTS_TYPE = 35;

  /**
   * The feature id for the '<em><b>Relationship Constraint</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Relationship Constraints Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_CONSTRAINTS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RelationshipConstraintTypeImpl <em>Relationship Constraint Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RelationshipConstraintTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipConstraintType()
   * @generated
   */
  int RELATIONSHIP_CONSTRAINT_TYPE = 36;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_CONSTRAINT_TYPE__ANY = 0;

  /**
   * The feature id for the '<em><b>Constraint Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_CONSTRAINT_TYPE__CONSTRAINT_TYPE = 1;

  /**
   * The number of structural features of the '<em>Relationship Constraint Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_CONSTRAINT_TYPE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RelationshipOperationTypeImpl <em>Relationship Operation Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RelationshipOperationTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipOperationType()
   * @generated
   */
  int RELATIONSHIP_OPERATION_TYPE = 37;

  /**
   * The feature id for the '<em><b>Interface Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_OPERATION_TYPE__INTERFACE_NAME = 0;

  /**
   * The feature id for the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_OPERATION_TYPE__OPERATION_NAME = 1;

  /**
   * The feature id for the '<em><b>Relationship Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_OPERATION_TYPE__RELATIONSHIP_REF = 2;

  /**
   * The number of structural features of the '<em>Relationship Operation Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_OPERATION_TYPE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RequirementDefinitionsTypeImpl <em>Requirement Definitions Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RequirementDefinitionsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementDefinitionsType()
   * @generated
   */
  int REQUIREMENT_DEFINITIONS_TYPE = 38;

  /**
   * The feature id for the '<em><b>Requirement Definition</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION = 0;

  /**
   * The number of structural features of the '<em>Requirement Definitions Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_DEFINITIONS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RequirementsTypeImpl <em>Requirements Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RequirementsTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementsType()
   * @generated
   */
  int REQUIREMENTS_TYPE = 39;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENTS_TYPE__REQUIREMENT = 0;

  /**
   * The number of structural features of the '<em>Requirements Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENTS_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.RequirementsType1Impl <em>Requirements Type1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.RequirementsType1Impl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementsType1()
   * @generated
   */
  int REQUIREMENTS_TYPE1 = 40;

  /**
   * The feature id for the '<em><b>Requirement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENTS_TYPE1__REQUIREMENT = 0;

  /**
   * The number of structural features of the '<em>Requirements Type1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENTS_TYPE1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.SourceElementTypeImpl <em>Source Element Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.SourceElementTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getSourceElementType()
   * @generated
   */
  int SOURCE_ELEMENT_TYPE = 41;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_ELEMENT_TYPE__REF = 0;

  /**
   * The number of structural features of the '<em>Source Element Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_ELEMENT_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.SourceInterfacesTypeImpl <em>Source Interfaces Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.SourceInterfacesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getSourceInterfacesType()
   * @generated
   */
  int SOURCE_INTERFACES_TYPE = 42;

  /**
   * The feature id for the '<em><b>Interface</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_INTERFACES_TYPE__INTERFACE = 0;

  /**
   * The number of structural features of the '<em>Source Interfaces Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_INTERFACES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TAppliesToImpl <em>TApplies To</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TAppliesToImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTAppliesTo()
   * @generated
   */
  int TAPPLIES_TO = 43;

  /**
   * The feature id for the '<em><b>Node Type Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLIES_TO__NODE_TYPE_REFERENCE = 0;

  /**
   * The number of structural features of the '<em>TApplies To</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TAPPLIES_TO_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TargetElementTypeImpl <em>Target Element Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TargetElementTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTargetElementType()
   * @generated
   */
  int TARGET_ELEMENT_TYPE = 44;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_ELEMENT_TYPE__REF = 0;

  /**
   * The number of structural features of the '<em>Target Element Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_ELEMENT_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TargetInterfacesTypeImpl <em>Target Interfaces Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TargetInterfacesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTargetInterfacesType()
   * @generated
   */
  int TARGET_INTERFACES_TYPE = 45;

  /**
   * The feature id for the '<em><b>Interface</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_INTERFACES_TYPE__INTERFACE = 0;

  /**
   * The number of structural features of the '<em>Target Interfaces Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARGET_INTERFACES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl <em>TArtifact Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TArtifactReferenceImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactReference()
   * @generated
   */
  int TARTIFACT_REFERENCE = 46;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_REFERENCE__GROUP = 0;

  /**
   * The feature id for the '<em><b>Include</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_REFERENCE__INCLUDE = 1;

  /**
   * The feature id for the '<em><b>Exclude</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_REFERENCE__EXCLUDE = 2;

  /**
   * The feature id for the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_REFERENCE__REFERENCE = 3;

  /**
   * The number of structural features of the '<em>TArtifact Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_REFERENCE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TEntityTemplateImpl <em>TEntity Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TEntityTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTEntityTemplate()
   * @generated
   */
  int TENTITY_TEMPLATE = 60;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__PROPERTIES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__ID = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE__TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>TEntity Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TEMPLATE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TArtifactTemplateImpl <em>TArtifact Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TArtifactTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactTemplate()
   * @generated
   */
  int TARTIFACT_TEMPLATE = 47;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Artifact References</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__ARTIFACT_REFERENCES = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TArtifact Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TEMPLATE_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TEntityTypeImpl <em>TEntity Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TEntityTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTEntityType()
   * @generated
   */
  int TENTITY_TYPE = 61;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__TAGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__DERIVED_FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__PROPERTIES_DEFINITION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__ABSTRACT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__FINAL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>TEntity Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TENTITY_TYPE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TArtifactTypeImpl <em>TArtifact Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TArtifactTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactType()
   * @generated
   */
  int TARTIFACT_TYPE = 48;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The number of structural features of the '<em>TArtifact Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TARTIFACT_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TBoundaryDefinitionsImpl <em>TBoundary Definitions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TBoundaryDefinitionsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBoundaryDefinitions()
   * @generated
   */
  int TBOUNDARY_DEFINITIONS = 49;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__PROPERTIES = 0;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS = 1;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__REQUIREMENTS = 2;

  /**
   * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__CAPABILITIES = 3;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__POLICIES = 4;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS__INTERFACES = 5;

  /**
   * The number of structural features of the '<em>TBoundary Definitions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TBOUNDARY_DEFINITIONS_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TCapabilityImpl <em>TCapability</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TCapabilityImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapability()
   * @generated
   */
  int TCAPABILITY = 50;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TCapability</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TCapabilityDefinitionImpl <em>TCapability Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TCapabilityDefinitionImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityDefinition()
   * @generated
   */
  int TCAPABILITY_DEFINITION = 51;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__CONSTRAINTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Capability Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__CAPABILITY_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__LOWER_BOUND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION__UPPER_BOUND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>TCapability Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_DEFINITION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TCapabilityRefImpl <em>TCapability Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TCapabilityRefImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityRef()
   * @generated
   */
  int TCAPABILITY_REF = 52;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_REF__REF = 1;

  /**
   * The number of structural features of the '<em>TCapability Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TCapabilityTypeImpl <em>TCapability Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TCapabilityTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityType()
   * @generated
   */
  int TCAPABILITY_TYPE = 53;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The number of structural features of the '<em>TCapability Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCAPABILITY_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TConditionImpl <em>TCondition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TConditionImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCondition()
   * @generated
   */
  int TCONDITION = 54;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONDITION__ANY = 0;

  /**
   * The feature id for the '<em><b>Expression Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONDITION__EXPRESSION_LANGUAGE = 1;

  /**
   * The number of structural features of the '<em>TCondition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONDITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TConstraintImpl <em>TConstraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TConstraintImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTConstraint()
   * @generated
   */
  int TCONSTRAINT = 55;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT__ANY = 0;

  /**
   * The feature id for the '<em><b>Constraint Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT__CONSTRAINT_TYPE = 1;

  /**
   * The number of structural features of the '<em>TConstraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TCONSTRAINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TDeploymentArtifactImpl <em>TDeployment Artifact</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TDeploymentArtifactImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDeploymentArtifact()
   * @generated
   */
  int TDEPLOYMENT_ARTIFACT = 57;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Artifact Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__ARTIFACT_REF = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Artifact Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__ARTIFACT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TDeployment Artifact</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACT_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TDeploymentArtifactsImpl <em>TDeployment Artifacts</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TDeploymentArtifactsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDeploymentArtifacts()
   * @generated
   */
  int TDEPLOYMENT_ARTIFACTS = 58;

  /**
   * The feature id for the '<em><b>Deployment Artifact</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACTS__DEPLOYMENT_ARTIFACT = 0;

  /**
   * The number of structural features of the '<em>TDeployment Artifacts</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDEPLOYMENT_ARTIFACTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TDocumentationImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDocumentation()
   * @generated
   */
  int TDOCUMENTATION = 59;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDOCUMENTATION__MIXED = 0;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDOCUMENTATION__ANY = 1;

  /**
   * The feature id for the '<em><b>Lang</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDOCUMENTATION__LANG = 2;

  /**
   * The feature id for the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDOCUMENTATION__SOURCE = 3;

  /**
   * The number of structural features of the '<em>TDocumentation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TDOCUMENTATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TExportedInterfaceImpl <em>TExported Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TExportedInterfaceImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExportedInterface()
   * @generated
   */
  int TEXPORTED_INTERFACE = 62;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_INTERFACE__OPERATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_INTERFACE__NAME = 1;

  /**
   * The number of structural features of the '<em>TExported Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_INTERFACE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TExportedOperationImpl <em>TExported Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TExportedOperationImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExportedOperation()
   * @generated
   */
  int TEXPORTED_OPERATION = 63;

  /**
   * The feature id for the '<em><b>Node Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_OPERATION__NODE_OPERATION = 0;

  /**
   * The feature id for the '<em><b>Relationship Operation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_OPERATION__RELATIONSHIP_OPERATION = 1;

  /**
   * The feature id for the '<em><b>Plan</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_OPERATION__PLAN = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_OPERATION__NAME = 3;

  /**
   * The number of structural features of the '<em>TExported Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXPORTED_OPERATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TExtensionImpl <em>TExtension</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TExtensionImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtension()
   * @generated
   */
  int TEXTENSION = 65;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Must Understand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION__MUST_UNDERSTAND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION__NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TExtension</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TExtensionsImpl <em>TExtensions</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TExtensionsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtensions()
   * @generated
   */
  int TEXTENSIONS = 66;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIONS__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Extension</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIONS__EXTENSION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TExtensions</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXTENSIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TImplementationArtifactsImpl <em>TImplementation Artifacts</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TImplementationArtifactsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImplementationArtifacts()
   * @generated
   */
  int TIMPLEMENTATION_ARTIFACTS = 68;

  /**
   * The feature id for the '<em><b>Implementation Artifact</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT = 0;

  /**
   * The number of structural features of the '<em>TImplementation Artifacts</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPLEMENTATION_ARTIFACTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TImportImpl <em>TImport</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TImportImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImport()
   * @generated
   */
  int TIMPORT = 69;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Import Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__IMPORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__LOCATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT__NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TImport</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMPORT_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TInterfaceImpl <em>TInterface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TInterfaceImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTInterface()
   * @generated
   */
  int TINTERFACE = 70;

  /**
   * The feature id for the '<em><b>Operation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTERFACE__OPERATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTERFACE__NAME = 1;

  /**
   * The number of structural features of the '<em>TInterface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TINTERFACE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TNodeTemplateImpl <em>TNode Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TNodeTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeTemplate()
   * @generated
   */
  int TNODE_TEMPLATE = 71;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__REQUIREMENTS = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Capabilities</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__CAPABILITIES = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Policies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__POLICIES = TENTITY_TEMPLATE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Deployment Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS = TENTITY_TEMPLATE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Max Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__MAX_INSTANCES = TENTITY_TEMPLATE_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Min Instances</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__MIN_INSTANCES = TENTITY_TEMPLATE_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>TNode Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TEMPLATE_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TNodeTypeImpl <em>TNode Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TNodeTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeType()
   * @generated
   */
  int TNODE_TYPE = 72;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The feature id for the '<em><b>Requirement Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__REQUIREMENT_DEFINITIONS = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Capability Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__CAPABILITY_DEFINITIONS = TENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Instance States</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__INSTANCE_STATES = TENTITY_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE__INTERFACES = TENTITY_TYPE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>TNode Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TNodeTypeImplementationImpl <em>TNode Type Implementation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TNodeTypeImplementationImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeTypeImplementation()
   * @generated
   */
  int TNODE_TYPE_IMPLEMENTATION = 73;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__TAGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__DERIVED_FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Required Container Features</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Implementation Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Deployment Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__DEPLOYMENT_ARTIFACTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__ABSTRACT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__FINAL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Node Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__NODE_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>TNode Type Implementation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TNODE_TYPE_IMPLEMENTATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TOperationImpl <em>TOperation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TOperationImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTOperation()
   * @generated
   */
  int TOPERATION = 74;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Input Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__INPUT_PARAMETERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Output Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__OUTPUT_PARAMETERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TOperation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOPERATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TParameterImpl <em>TParameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TParameterImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTParameter()
   * @generated
   */
  int TPARAMETER = 75;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Required</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPARAMETER__REQUIRED = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPARAMETER__TYPE = 2;

  /**
   * The number of structural features of the '<em>TParameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPARAMETER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPlanImpl <em>TPlan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPlanImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPlan()
   * @generated
   */
  int TPLAN = 76;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Precondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__PRECONDITION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Input Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__INPUT_PARAMETERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Output Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__OUTPUT_PARAMETERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Plan Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__PLAN_MODEL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Plan Model Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__PLAN_MODEL_REFERENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__ID = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Plan Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__PLAN_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Plan Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN__PLAN_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>TPlan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLAN_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPlansImpl <em>TPlans</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPlansImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPlans()
   * @generated
   */
  int TPLANS = 77;

  /**
   * The feature id for the '<em><b>Plan</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLANS__PLAN = 0;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLANS__TARGET_NAMESPACE = 1;

  /**
   * The number of structural features of the '<em>TPlans</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPLANS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPolicyImpl <em>TPolicy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPolicyImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicy()
   * @generated
   */
  int TPOLICY = 78;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Policy Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__POLICY_REF = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Policy Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY__POLICY_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TPolicy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPolicyTemplateImpl <em>TPolicy Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPolicyTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicyTemplate()
   * @generated
   */
  int TPOLICY_TEMPLATE = 79;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TPolicy Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TEMPLATE_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPolicyTypeImpl <em>TPolicy Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPolicyTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicyType()
   * @generated
   */
  int TPOLICY_TYPE = 80;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The feature id for the '<em><b>Applies To</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__APPLIES_TO = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Policy Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE__POLICY_LANGUAGE = TENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>TPolicy Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPOLICY_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPropertyConstraintImpl <em>TProperty Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPropertyConstraintImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPropertyConstraint()
   * @generated
   */
  int TPROPERTY_CONSTRAINT = 81;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_CONSTRAINT__ANY = TCONSTRAINT__ANY;

  /**
   * The feature id for the '<em><b>Constraint Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_CONSTRAINT__CONSTRAINT_TYPE = TCONSTRAINT__CONSTRAINT_TYPE;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_CONSTRAINT__PROPERTY = TCONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TProperty Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_CONSTRAINT_FEATURE_COUNT = TCONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TPropertyMappingImpl <em>TProperty Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TPropertyMappingImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPropertyMapping()
   * @generated
   */
  int TPROPERTY_MAPPING = 82;

  /**
   * The feature id for the '<em><b>Service Template Property Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_MAPPING__SERVICE_TEMPLATE_PROPERTY_REF = 0;

  /**
   * The feature id for the '<em><b>Target Object Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_MAPPING__TARGET_OBJECT_REF = 1;

  /**
   * The feature id for the '<em><b>Target Property Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_MAPPING__TARGET_PROPERTY_REF = 2;

  /**
   * The number of structural features of the '<em>TProperty Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TPROPERTY_MAPPING_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTemplateImpl <em>TRelationship Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRelationshipTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipTemplate()
   * @generated
   */
  int TRELATIONSHIP_TEMPLATE = 83;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Source Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__SOURCE_ELEMENT = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__TARGET_ELEMENT = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Relationship Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__RELATIONSHIP_CONSTRAINTS = TENTITY_TEMPLATE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>TRelationship Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TEMPLATE_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTypeImpl <em>TRelationship Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRelationshipTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipType()
   * @generated
   */
  int TRELATIONSHIP_TYPE = 84;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The feature id for the '<em><b>Instance States</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__INSTANCE_STATES = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__SOURCE_INTERFACES = TENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target Interfaces</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__TARGET_INTERFACES = TENTITY_TYPE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Valid Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__VALID_SOURCE = TENTITY_TYPE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Valid Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE__VALID_TARGET = TENTITY_TYPE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>TRelationship Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTypeImplementationImpl <em>TRelationship Type Implementation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRelationshipTypeImplementationImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipTypeImplementation()
   * @generated
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION = 85;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__TAGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__DERIVED_FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Required Container Features</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Implementation Artifacts</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__ABSTRACT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__FINAL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Relationship Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__RELATIONSHIP_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>TRelationship Type Implementation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRELATIONSHIP_TYPE_IMPLEMENTATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequiredContainerFeatureImpl <em>TRequired Container Feature</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequiredContainerFeatureImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequiredContainerFeature()
   * @generated
   */
  int TREQUIRED_CONTAINER_FEATURE = 86;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIRED_CONTAINER_FEATURE__FEATURE = 0;

  /**
   * The number of structural features of the '<em>TRequired Container Feature</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIRED_CONTAINER_FEATURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequiredContainerFeaturesImpl <em>TRequired Container Features</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequiredContainerFeaturesImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequiredContainerFeatures()
   * @generated
   */
  int TREQUIRED_CONTAINER_FEATURES = 87;

  /**
   * The feature id for the '<em><b>Required Container Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIRED_CONTAINER_FEATURES__REQUIRED_CONTAINER_FEATURE = 0;

  /**
   * The number of structural features of the '<em>TRequired Container Features</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIRED_CONTAINER_FEATURES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequirementImpl <em>TRequirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequirementImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirement()
   * @generated
   */
  int TREQUIREMENT = 88;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__DOCUMENTATION = TENTITY_TEMPLATE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__ANY = TENTITY_TEMPLATE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__ANY_ATTRIBUTE = TENTITY_TEMPLATE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__PROPERTIES = TENTITY_TEMPLATE__PROPERTIES;

  /**
   * The feature id for the '<em><b>Property Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__PROPERTY_CONSTRAINTS = TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__ID = TENTITY_TEMPLATE__ID;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__TYPE = TENTITY_TEMPLATE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT__NAME = TENTITY_TEMPLATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TRequirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_FEATURE_COUNT = TENTITY_TEMPLATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequirementDefinitionImpl <em>TRequirement Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequirementDefinitionImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementDefinition()
   * @generated
   */
  int TREQUIREMENT_DEFINITION = 89;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Constraints</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__CONSTRAINTS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__LOWER_BOUND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Requirement Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__REQUIREMENT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION__UPPER_BOUND = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>TRequirement Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_DEFINITION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequirementRefImpl <em>TRequirement Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequirementRefImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementRef()
   * @generated
   */
  int TREQUIREMENT_REF = 90;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_REF__NAME = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_REF__REF = 1;

  /**
   * The number of structural features of the '<em>TRequirement Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_REF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TRequirementTypeImpl <em>TRequirement Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TRequirementTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementType()
   * @generated
   */
  int TREQUIREMENT_TYPE = 91;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__DOCUMENTATION = TENTITY_TYPE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__ANY = TENTITY_TYPE__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__ANY_ATTRIBUTE = TENTITY_TYPE__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__TAGS = TENTITY_TYPE__TAGS;

  /**
   * The feature id for the '<em><b>Derived From</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__DERIVED_FROM = TENTITY_TYPE__DERIVED_FROM;

  /**
   * The feature id for the '<em><b>Properties Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__PROPERTIES_DEFINITION = TENTITY_TYPE__PROPERTIES_DEFINITION;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__ABSTRACT = TENTITY_TYPE__ABSTRACT;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__FINAL = TENTITY_TYPE__FINAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__NAME = TENTITY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__TARGET_NAMESPACE = TENTITY_TYPE__TARGET_NAMESPACE;

  /**
   * The feature id for the '<em><b>Required Capability Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE = TENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>TRequirement Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREQUIREMENT_TYPE_FEATURE_COUNT = TENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TServiceTemplateImpl <em>TService Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TServiceTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTServiceTemplate()
   * @generated
   */
  int TSERVICE_TEMPLATE = 92;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Tags</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__TAGS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Boundary Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__BOUNDARY_DEFINITIONS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Topology Template</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__TOPOLOGY_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Plans</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__PLANS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__ID = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Substitutable Node Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__SUBSTITUTABLE_NODE_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>TService Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TSERVICE_TEMPLATE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TTagImpl <em>TTag</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TTagImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTag()
   * @generated
   */
  int TTAG = 93;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTAG__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTAG__VALUE = 1;

  /**
   * The number of structural features of the '<em>TTag</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTAG_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TTagsImpl <em>TTags</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TTagsImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTags()
   * @generated
   */
  int TTAGS = 94;

  /**
   * The feature id for the '<em><b>Tag</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTAGS__TAG = 0;

  /**
   * The number of structural features of the '<em>TTags</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTAGS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TTopologyElementInstanceStatesImpl <em>TTopology Element Instance States</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TTopologyElementInstanceStatesImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTopologyElementInstanceStates()
   * @generated
   */
  int TTOPOLOGY_ELEMENT_INSTANCE_STATES = 95;

  /**
   * The feature id for the '<em><b>Instance State</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_ELEMENT_INSTANCE_STATES__INSTANCE_STATE = 0;

  /**
   * The number of structural features of the '<em>TTopology Element Instance States</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_ELEMENT_INSTANCE_STATES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TTopologyTemplateImpl <em>TTopology Template</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TTopologyTemplateImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTopologyTemplate()
   * @generated
   */
  int TTOPOLOGY_TEMPLATE = 96;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__DOCUMENTATION = TEXTENSIBLE_ELEMENTS__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

  /**
   * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Group</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__GROUP = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Node Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__NODE_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Relationship Template</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>TTopology Template</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TTOPOLOGY_TEMPLATE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.TypesTypeImpl <em>Types Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.TypesTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTypesType()
   * @generated
   */
  int TYPES_TYPE = 97;

  /**
   * The feature id for the '<em><b>Any</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_TYPE__ANY = 0;

  /**
   * The number of structural features of the '<em>Types Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ValidSourceTypeImpl <em>Valid Source Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ValidSourceTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getValidSourceType()
   * @generated
   */
  int VALID_SOURCE_TYPE = 98;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALID_SOURCE_TYPE__TYPE_REF = 0;

  /**
   * The number of structural features of the '<em>Valid Source Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALID_SOURCE_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.impl.ValidTargetTypeImpl <em>Valid Target Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.impl.ValidTargetTypeImpl
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getValidTargetType()
   * @generated
   */
  int VALID_TARGET_TYPE = 99;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALID_TARGET_TYPE__TYPE_REF = 0;

  /**
   * The number of structural features of the '<em>Valid Target Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALID_TARGET_TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.MaxInstancesTypeMember1 <em>Max Instances Type Member1</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember1()
   * @generated
   */
  int MAX_INSTANCES_TYPE_MEMBER1 = 100;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.TBoolean <em>TBoolean</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.TBoolean
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBoolean()
   * @generated
   */
  int TBOOLEAN = 101;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.UpperBoundTypeMember1 <em>Upper Bound Type Member1</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER1 = 102;

  /**
   * The meta object id for the '{@link org.eclipse.camf.tosca.UpperBoundTypeMember11 <em>Upper Bound Type Member11</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember11()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER11 = 103;

  /**
   * The meta object id for the '<em>Imported URI</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.String
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getImportedURI()
   * @generated
   */
  int IMPORTED_URI = 104;

  /**
   * The meta object id for the '<em>Max Instances Type</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Object
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesType()
   * @generated
   */
  int MAX_INSTANCES_TYPE = 105;

  /**
   * The meta object id for the '<em>Max Instances Type Member0</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.math.BigInteger
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember0()
   * @generated
   */
  int MAX_INSTANCES_TYPE_MEMBER0 = 106;

  /**
   * The meta object id for the '<em>Max Instances Type Member1 Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember1Object()
   * @generated
   */
  int MAX_INSTANCES_TYPE_MEMBER1_OBJECT = 107;

  /**
   * The meta object id for the '<em>TBoolean Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.TBoolean
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBooleanObject()
   * @generated
   */
  int TBOOLEAN_OBJECT = 108;

  /**
   * The meta object id for the '<em>Upper Bound Type</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Object
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundType()
   * @generated
   */
  int UPPER_BOUND_TYPE = 109;

  /**
   * The meta object id for the '<em>Upper Bound Type1</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Object
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundType1()
   * @generated
   */
  int UPPER_BOUND_TYPE1 = 110;

  /**
   * The meta object id for the '<em>Upper Bound Type Member0</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.math.BigInteger
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember0()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER0 = 111;

  /**
   * The meta object id for the '<em>Upper Bound Type Member01</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.math.BigInteger
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember01()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER01 = 112;

  /**
   * The meta object id for the '<em>Upper Bound Type Member1 Object</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1Object()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER1_OBJECT = 113;

  /**
   * The meta object id for the '<em>Upper Bound Type Member1 Object1</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
   * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1Object1()
   * @generated
   */
  int UPPER_BOUND_TYPE_MEMBER1_OBJECT1 = 114;


  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ArtifactReferencesType <em>Artifact References Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Artifact References Type</em>'.
   * @see org.eclipse.camf.tosca.ArtifactReferencesType
   * @generated
   */
  EClass getArtifactReferencesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.ArtifactReferencesType#getArtifactReference <em>Artifact Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Artifact Reference</em>'.
   * @see org.eclipse.camf.tosca.ArtifactReferencesType#getArtifactReference()
   * @see #getArtifactReferencesType()
   * @generated
   */
  EReference getArtifactReferencesType_ArtifactReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.CapabilitiesType <em>Capabilities Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capabilities Type</em>'.
   * @see org.eclipse.camf.tosca.CapabilitiesType
   * @generated
   */
  EClass getCapabilitiesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.CapabilitiesType#getCapability <em>Capability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capability</em>'.
   * @see org.eclipse.camf.tosca.CapabilitiesType#getCapability()
   * @see #getCapabilitiesType()
   * @generated
   */
  EReference getCapabilitiesType_Capability();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.CapabilitiesType1 <em>Capabilities Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capabilities Type1</em>'.
   * @see org.eclipse.camf.tosca.CapabilitiesType1
   * @generated
   */
  EClass getCapabilitiesType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.CapabilitiesType1#getCapability <em>Capability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capability</em>'.
   * @see org.eclipse.camf.tosca.CapabilitiesType1#getCapability()
   * @see #getCapabilitiesType1()
   * @generated
   */
  EReference getCapabilitiesType1_Capability();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.CapabilityDefinitionsType <em>Capability Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Capability Definitions Type</em>'.
   * @see org.eclipse.camf.tosca.CapabilityDefinitionsType
   * @generated
   */
  EClass getCapabilityDefinitionsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.CapabilityDefinitionsType#getCapabilityDefinition <em>Capability Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capability Definition</em>'.
   * @see org.eclipse.camf.tosca.CapabilityDefinitionsType#getCapabilityDefinition()
   * @see #getCapabilityDefinitionsType()
   * @generated
   */
  EReference getCapabilityDefinitionsType_CapabilityDefinition();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ConstraintsType <em>Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraints Type</em>'.
   * @see org.eclipse.camf.tosca.ConstraintsType
   * @generated
   */
  EClass getConstraintsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.ConstraintsType#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint</em>'.
   * @see org.eclipse.camf.tosca.ConstraintsType#getConstraint()
   * @see #getConstraintsType()
   * @generated
   */
  EReference getConstraintsType_Constraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ConstraintsType1 <em>Constraints Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraints Type1</em>'.
   * @see org.eclipse.camf.tosca.ConstraintsType1
   * @generated
   */
  EClass getConstraintsType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.ConstraintsType1#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint</em>'.
   * @see org.eclipse.camf.tosca.ConstraintsType1#getConstraint()
   * @see #getConstraintsType1()
   * @generated
   */
  EReference getConstraintsType1_Constraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.DefinitionsType <em>Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definitions Type</em>'.
   * @see org.eclipse.camf.tosca.DefinitionsType
   * @generated
   */
  EClass getDefinitionsType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.DerivedFromType <em>Derived From Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived From Type</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType
   * @generated
   */
  EClass getDerivedFromType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.DerivedFromType#getRelationshipTypeImplementationRef <em>Relationship Type Implementation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relationship Type Implementation Ref</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType#getRelationshipTypeImplementationRef()
   * @see #getDerivedFromType()
   * @generated
   */
  EAttribute getDerivedFromType_RelationshipTypeImplementationRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.DerivedFromType1 <em>Derived From Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived From Type1</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType1
   * @generated
   */
  EClass getDerivedFromType1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.DerivedFromType1#getNodeTypeImplementationRef <em>Node Type Implementation Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node Type Implementation Ref</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType1#getNodeTypeImplementationRef()
   * @see #getDerivedFromType1()
   * @generated
   */
  EAttribute getDerivedFromType1_NodeTypeImplementationRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.DerivedFromType2 <em>Derived From Type2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived From Type2</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType2
   * @generated
   */
  EClass getDerivedFromType2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.DerivedFromType2#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Ref</em>'.
   * @see org.eclipse.camf.tosca.DerivedFromType2#getTypeRef()
   * @see #getDerivedFromType2()
   * @generated
   */
  EAttribute getDerivedFromType2_TypeRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Root</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot
   * @generated
   */
  EClass getDocumentRoot();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.DocumentRoot#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot#getMixed()
   * @see #getDocumentRoot()
   * @generated
   */
  EAttribute getDocumentRoot_Mixed();

  /**
   * Returns the meta object for the map '{@link org.eclipse.camf.tosca.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot#getXMLNSPrefixMap()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
   * Returns the meta object for the map '{@link org.eclipse.camf.tosca.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>XSI Schema Location</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot#getXSISchemaLocation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.DocumentRoot#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definitions</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot#getDefinitions()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_Definitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.DocumentRoot#getDocumentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Documentation</em>'.
   * @see org.eclipse.camf.tosca.DocumentRoot#getDocumentation()
   * @see #getDocumentRoot()
   * @generated
   */
  EReference getDocumentRoot_Documentation();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ExcludeType <em>Exclude Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exclude Type</em>'.
   * @see org.eclipse.camf.tosca.ExcludeType
   * @generated
   */
  EClass getExcludeType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.ExcludeType#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern</em>'.
   * @see org.eclipse.camf.tosca.ExcludeType#getPattern()
   * @see #getExcludeType()
   * @generated
   */
  EAttribute getExcludeType_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ExtensionsType <em>Extensions Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extensions Type</em>'.
   * @see org.eclipse.camf.tosca.ExtensionsType
   * @generated
   */
  EClass getExtensionsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.ExtensionsType#getExtension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extension</em>'.
   * @see org.eclipse.camf.tosca.ExtensionsType#getExtension()
   * @see #getExtensionsType()
   * @generated
   */
  EReference getExtensionsType_Extension();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ImplementationArtifactType <em>Implementation Artifact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implementation Artifact Type</em>'.
   * @see org.eclipse.camf.tosca.ImplementationArtifactType
   * @generated
   */
  EClass getImplementationArtifactType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.IncludeType <em>Include Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Type</em>'.
   * @see org.eclipse.camf.tosca.IncludeType
   * @generated
   */
  EClass getIncludeType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.IncludeType#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern</em>'.
   * @see org.eclipse.camf.tosca.IncludeType#getPattern()
   * @see #getIncludeType()
   * @generated
   */
  EAttribute getIncludeType_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.InputParametersType <em>Input Parameters Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Parameters Type</em>'.
   * @see org.eclipse.camf.tosca.InputParametersType
   * @generated
   */
  EClass getInputParametersType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.InputParametersType#getInputParameter <em>Input Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Input Parameter</em>'.
   * @see org.eclipse.camf.tosca.InputParametersType#getInputParameter()
   * @see #getInputParametersType()
   * @generated
   */
  EReference getInputParametersType_InputParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.InputParametersType1 <em>Input Parameters Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Parameters Type1</em>'.
   * @see org.eclipse.camf.tosca.InputParametersType1
   * @generated
   */
  EClass getInputParametersType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.InputParametersType1#getInputParameter <em>Input Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Input Parameter</em>'.
   * @see org.eclipse.camf.tosca.InputParametersType1#getInputParameter()
   * @see #getInputParametersType1()
   * @generated
   */
  EReference getInputParametersType1_InputParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.InstanceStateType <em>Instance State Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance State Type</em>'.
   * @see org.eclipse.camf.tosca.InstanceStateType
   * @generated
   */
  EClass getInstanceStateType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.InstanceStateType#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State</em>'.
   * @see org.eclipse.camf.tosca.InstanceStateType#getState()
   * @see #getInstanceStateType()
   * @generated
   */
  EAttribute getInstanceStateType_State();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.InterfacesType <em>Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interfaces Type</em>'.
   * @see org.eclipse.camf.tosca.InterfacesType
   * @generated
   */
  EClass getInterfacesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.InterfacesType#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface</em>'.
   * @see org.eclipse.camf.tosca.InterfacesType#getInterface()
   * @see #getInterfacesType()
   * @generated
   */
  EReference getInterfacesType_Interface();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.InterfacesType1 <em>Interfaces Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interfaces Type1</em>'.
   * @see org.eclipse.camf.tosca.InterfacesType1
   * @generated
   */
  EClass getInterfacesType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.InterfacesType1#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface</em>'.
   * @see org.eclipse.camf.tosca.InterfacesType1#getInterface()
   * @see #getInterfacesType1()
   * @generated
   */
  EReference getInterfacesType1_Interface();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.NodeOperationType <em>Node Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Operation Type</em>'.
   * @see org.eclipse.camf.tosca.NodeOperationType
   * @generated
   */
  EClass getNodeOperationType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.NodeOperationType#getInterfaceName <em>Interface Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Name</em>'.
   * @see org.eclipse.camf.tosca.NodeOperationType#getInterfaceName()
   * @see #getNodeOperationType()
   * @generated
   */
  EAttribute getNodeOperationType_InterfaceName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.NodeOperationType#getNodeRef <em>Node Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node Ref</em>'.
   * @see org.eclipse.camf.tosca.NodeOperationType#getNodeRef()
   * @see #getNodeOperationType()
   * @generated
   */
  EAttribute getNodeOperationType_NodeRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.NodeOperationType#getOperationName <em>Operation Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Name</em>'.
   * @see org.eclipse.camf.tosca.NodeOperationType#getOperationName()
   * @see #getNodeOperationType()
   * @generated
   */
  EAttribute getNodeOperationType_OperationName();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.NodeTypeReferenceType <em>Node Type Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Type Reference Type</em>'.
   * @see org.eclipse.camf.tosca.NodeTypeReferenceType
   * @generated
   */
  EClass getNodeTypeReferenceType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.NodeTypeReferenceType#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Ref</em>'.
   * @see org.eclipse.camf.tosca.NodeTypeReferenceType#getTypeRef()
   * @see #getNodeTypeReferenceType()
   * @generated
   */
  EAttribute getNodeTypeReferenceType_TypeRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.OutputParametersType <em>Output Parameters Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Parameters Type</em>'.
   * @see org.eclipse.camf.tosca.OutputParametersType
   * @generated
   */
  EClass getOutputParametersType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.OutputParametersType#getOutputParameter <em>Output Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Output Parameter</em>'.
   * @see org.eclipse.camf.tosca.OutputParametersType#getOutputParameter()
   * @see #getOutputParametersType()
   * @generated
   */
  EReference getOutputParametersType_OutputParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.OutputParametersType1 <em>Output Parameters Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Output Parameters Type1</em>'.
   * @see org.eclipse.camf.tosca.OutputParametersType1
   * @generated
   */
  EClass getOutputParametersType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.OutputParametersType1#getOutputParameter <em>Output Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Output Parameter</em>'.
   * @see org.eclipse.camf.tosca.OutputParametersType1#getOutputParameter()
   * @see #getOutputParametersType1()
   * @generated
   */
  EReference getOutputParametersType1_OutputParameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PlanModelReferenceType <em>Plan Model Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plan Model Reference Type</em>'.
   * @see org.eclipse.camf.tosca.PlanModelReferenceType
   * @generated
   */
  EClass getPlanModelReferenceType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.PlanModelReferenceType#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference</em>'.
   * @see org.eclipse.camf.tosca.PlanModelReferenceType#getReference()
   * @see #getPlanModelReferenceType()
   * @generated
   */
  EAttribute getPlanModelReferenceType_Reference();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PlanModelType <em>Plan Model Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plan Model Type</em>'.
   * @see org.eclipse.camf.tosca.PlanModelType
   * @generated
   */
  EClass getPlanModelType();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.PlanModelType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.PlanModelType#getAny()
   * @see #getPlanModelType()
   * @generated
   */
  EAttribute getPlanModelType_Any();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PlanType <em>Plan Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plan Type</em>'.
   * @see org.eclipse.camf.tosca.PlanType
   * @generated
   */
  EClass getPlanType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.PlanType#getPlanRef <em>Plan Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plan Ref</em>'.
   * @see org.eclipse.camf.tosca.PlanType#getPlanRef()
   * @see #getPlanType()
   * @generated
   */
  EAttribute getPlanType_PlanRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PoliciesType <em>Policies Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Policies Type</em>'.
   * @see org.eclipse.camf.tosca.PoliciesType
   * @generated
   */
  EClass getPoliciesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.PoliciesType#getPolicy <em>Policy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policy</em>'.
   * @see org.eclipse.camf.tosca.PoliciesType#getPolicy()
   * @see #getPoliciesType()
   * @generated
   */
  EReference getPoliciesType_Policy();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PoliciesType1 <em>Policies Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Policies Type1</em>'.
   * @see org.eclipse.camf.tosca.PoliciesType1
   * @generated
   */
  EClass getPoliciesType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.PoliciesType1#getPolicy <em>Policy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policy</em>'.
   * @see org.eclipse.camf.tosca.PoliciesType1#getPolicy()
   * @see #getPoliciesType1()
   * @generated
   */
  EReference getPoliciesType1_Policy();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertiesDefinitionType <em>Properties Definition Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Properties Definition Type</em>'.
   * @see org.eclipse.camf.tosca.PropertiesDefinitionType
   * @generated
   */
  EClass getPropertiesDefinitionType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element</em>'.
   * @see org.eclipse.camf.tosca.PropertiesDefinitionType#getElement()
   * @see #getPropertiesDefinitionType()
   * @generated
   */
  EAttribute getPropertiesDefinitionType_Element();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.PropertiesDefinitionType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.camf.tosca.PropertiesDefinitionType#getType()
   * @see #getPropertiesDefinitionType()
   * @generated
   */
  EAttribute getPropertiesDefinitionType_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertiesType <em>Properties Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Properties Type</em>'.
   * @see org.eclipse.camf.tosca.PropertiesType
   * @generated
   */
  EClass getPropertiesType();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.PropertiesType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.PropertiesType#getAny()
   * @see #getPropertiesType()
   * @generated
   */
  EAttribute getPropertiesType_Any();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertiesType1 <em>Properties Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Properties Type1</em>'.
   * @see org.eclipse.camf.tosca.PropertiesType1
   * @generated
   */
  EClass getPropertiesType1();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.PropertiesType1#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.PropertiesType1#getAny()
   * @see #getPropertiesType1()
   * @generated
   */
  EAttribute getPropertiesType1_Any();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.PropertiesType1#getPropertyMappings <em>Property Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property Mappings</em>'.
   * @see org.eclipse.camf.tosca.PropertiesType1#getPropertyMappings()
   * @see #getPropertiesType1()
   * @generated
   */
  EReference getPropertiesType1_PropertyMappings();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertyConstraintsType <em>Property Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Constraints Type</em>'.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType
   * @generated
   */
  EClass getPropertyConstraintsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.PropertyConstraintsType#getPropertyConstraint <em>Property Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Constraint</em>'.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType#getPropertyConstraint()
   * @see #getPropertyConstraintsType()
   * @generated
   */
  EReference getPropertyConstraintsType_PropertyConstraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertyConstraintsType1 <em>Property Constraints Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Constraints Type1</em>'.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType1
   * @generated
   */
  EClass getPropertyConstraintsType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.PropertyConstraintsType1#getPropertyConstraint <em>Property Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Constraint</em>'.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType1#getPropertyConstraint()
   * @see #getPropertyConstraintsType1()
   * @generated
   */
  EReference getPropertyConstraintsType1_PropertyConstraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.PropertyMappingsType <em>Property Mappings Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Mappings Type</em>'.
   * @see org.eclipse.camf.tosca.PropertyMappingsType
   * @generated
   */
  EClass getPropertyMappingsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.PropertyMappingsType#getPropertyMapping <em>Property Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Property Mapping</em>'.
   * @see org.eclipse.camf.tosca.PropertyMappingsType#getPropertyMapping()
   * @see #getPropertyMappingsType()
   * @generated
   */
  EReference getPropertyMappingsType_PropertyMapping();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RelationshipConstraintsType <em>Relationship Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship Constraints Type</em>'.
   * @see org.eclipse.camf.tosca.RelationshipConstraintsType
   * @generated
   */
  EClass getRelationshipConstraintsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.RelationshipConstraintsType#getRelationshipConstraint <em>Relationship Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relationship Constraint</em>'.
   * @see org.eclipse.camf.tosca.RelationshipConstraintsType#getRelationshipConstraint()
   * @see #getRelationshipConstraintsType()
   * @generated
   */
  EReference getRelationshipConstraintsType_RelationshipConstraint();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RelationshipConstraintType <em>Relationship Constraint Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship Constraint Type</em>'.
   * @see org.eclipse.camf.tosca.RelationshipConstraintType
   * @generated
   */
  EClass getRelationshipConstraintType();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.RelationshipConstraintType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.RelationshipConstraintType#getAny()
   * @see #getRelationshipConstraintType()
   * @generated
   */
  EAttribute getRelationshipConstraintType_Any();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.RelationshipConstraintType#getConstraintType <em>Constraint Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Type</em>'.
   * @see org.eclipse.camf.tosca.RelationshipConstraintType#getConstraintType()
   * @see #getRelationshipConstraintType()
   * @generated
   */
  EAttribute getRelationshipConstraintType_ConstraintType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RelationshipOperationType <em>Relationship Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship Operation Type</em>'.
   * @see org.eclipse.camf.tosca.RelationshipOperationType
   * @generated
   */
  EClass getRelationshipOperationType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.RelationshipOperationType#getInterfaceName <em>Interface Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Name</em>'.
   * @see org.eclipse.camf.tosca.RelationshipOperationType#getInterfaceName()
   * @see #getRelationshipOperationType()
   * @generated
   */
  EAttribute getRelationshipOperationType_InterfaceName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.RelationshipOperationType#getOperationName <em>Operation Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Name</em>'.
   * @see org.eclipse.camf.tosca.RelationshipOperationType#getOperationName()
   * @see #getRelationshipOperationType()
   * @generated
   */
  EAttribute getRelationshipOperationType_OperationName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.RelationshipOperationType#getRelationshipRef <em>Relationship Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relationship Ref</em>'.
   * @see org.eclipse.camf.tosca.RelationshipOperationType#getRelationshipRef()
   * @see #getRelationshipOperationType()
   * @generated
   */
  EAttribute getRelationshipOperationType_RelationshipRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RequirementDefinitionsType <em>Requirement Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Definitions Type</em>'.
   * @see org.eclipse.camf.tosca.RequirementDefinitionsType
   * @generated
   */
  EClass getRequirementDefinitionsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.RequirementDefinitionsType#getRequirementDefinition <em>Requirement Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement Definition</em>'.
   * @see org.eclipse.camf.tosca.RequirementDefinitionsType#getRequirementDefinition()
   * @see #getRequirementDefinitionsType()
   * @generated
   */
  EReference getRequirementDefinitionsType_RequirementDefinition();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RequirementsType <em>Requirements Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirements Type</em>'.
   * @see org.eclipse.camf.tosca.RequirementsType
   * @generated
   */
  EClass getRequirementsType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.RequirementsType#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement</em>'.
   * @see org.eclipse.camf.tosca.RequirementsType#getRequirement()
   * @see #getRequirementsType()
   * @generated
   */
  EReference getRequirementsType_Requirement();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.RequirementsType1 <em>Requirements Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirements Type1</em>'.
   * @see org.eclipse.camf.tosca.RequirementsType1
   * @generated
   */
  EClass getRequirementsType1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.RequirementsType1#getRequirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement</em>'.
   * @see org.eclipse.camf.tosca.RequirementsType1#getRequirement()
   * @see #getRequirementsType1()
   * @generated
   */
  EReference getRequirementsType1_Requirement();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.SourceElementType <em>Source Element Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Element Type</em>'.
   * @see org.eclipse.camf.tosca.SourceElementType
   * @generated
   */
  EClass getSourceElementType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.SourceElementType#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.camf.tosca.SourceElementType#getRef()
   * @see #getSourceElementType()
   * @generated
   */
  EAttribute getSourceElementType_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.SourceInterfacesType <em>Source Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Interfaces Type</em>'.
   * @see org.eclipse.camf.tosca.SourceInterfacesType
   * @generated
   */
  EClass getSourceInterfacesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.SourceInterfacesType#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface</em>'.
   * @see org.eclipse.camf.tosca.SourceInterfacesType#getInterface()
   * @see #getSourceInterfacesType()
   * @generated
   */
  EReference getSourceInterfacesType_Interface();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TAppliesTo <em>TApplies To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TApplies To</em>'.
   * @see org.eclipse.camf.tosca.TAppliesTo
   * @generated
   */
  EClass getTAppliesTo();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TAppliesTo#getNodeTypeReference <em>Node Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Type Reference</em>'.
   * @see org.eclipse.camf.tosca.TAppliesTo#getNodeTypeReference()
   * @see #getTAppliesTo()
   * @generated
   */
  EReference getTAppliesTo_NodeTypeReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TargetElementType <em>Target Element Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Element Type</em>'.
   * @see org.eclipse.camf.tosca.TargetElementType
   * @generated
   */
  EClass getTargetElementType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TargetElementType#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.camf.tosca.TargetElementType#getRef()
   * @see #getTargetElementType()
   * @generated
   */
  EAttribute getTargetElementType_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TargetInterfacesType <em>Target Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Target Interfaces Type</em>'.
   * @see org.eclipse.camf.tosca.TargetInterfacesType
   * @generated
   */
  EClass getTargetInterfacesType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TargetInterfacesType#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface</em>'.
   * @see org.eclipse.camf.tosca.TargetInterfacesType#getInterface()
   * @see #getTargetInterfacesType()
   * @generated
   */
  EReference getTargetInterfacesType_Interface();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TArtifactReference <em>TArtifact Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TArtifact Reference</em>'.
   * @see org.eclipse.camf.tosca.TArtifactReference
   * @generated
   */
  EClass getTArtifactReference();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TArtifactReference#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Group</em>'.
   * @see org.eclipse.camf.tosca.TArtifactReference#getGroup()
   * @see #getTArtifactReference()
   * @generated
   */
  EAttribute getTArtifactReference_Group();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TArtifactReference#getInclude <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Include</em>'.
   * @see org.eclipse.camf.tosca.TArtifactReference#getInclude()
   * @see #getTArtifactReference()
   * @generated
   */
  EReference getTArtifactReference_Include();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TArtifactReference#getExclude <em>Exclude</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exclude</em>'.
   * @see org.eclipse.camf.tosca.TArtifactReference#getExclude()
   * @see #getTArtifactReference()
   * @generated
   */
  EReference getTArtifactReference_Exclude();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TArtifactReference#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference</em>'.
   * @see org.eclipse.camf.tosca.TArtifactReference#getReference()
   * @see #getTArtifactReference()
   * @generated
   */
  EAttribute getTArtifactReference_Reference();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TArtifactTemplate <em>TArtifact Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TArtifact Template</em>'.
   * @see org.eclipse.camf.tosca.TArtifactTemplate
   * @generated
   */
  EClass getTArtifactTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TArtifactTemplate#getArtifactReferences <em>Artifact References</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Artifact References</em>'.
   * @see org.eclipse.camf.tosca.TArtifactTemplate#getArtifactReferences()
   * @see #getTArtifactTemplate()
   * @generated
   */
  EReference getTArtifactTemplate_ArtifactReferences();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TArtifactTemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TArtifactTemplate#getName()
   * @see #getTArtifactTemplate()
   * @generated
   */
  EAttribute getTArtifactTemplate_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TArtifactType <em>TArtifact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TArtifact Type</em>'.
   * @see org.eclipse.camf.tosca.TArtifactType
   * @generated
   */
  EClass getTArtifactType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TBoundaryDefinitions <em>TBoundary Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TBoundary Definitions</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions
   * @generated
   */
  EClass getTBoundaryDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Properties</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getProperties()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_Properties();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getPropertyConstraints <em>Property Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property Constraints</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getPropertyConstraints()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_PropertyConstraints();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirements</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getRequirements()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_Requirements();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getCapabilities <em>Capabilities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Capabilities</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getCapabilities()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_Capabilities();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getPolicies <em>Policies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Policies</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getPolicies()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_Policies();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TBoundaryDefinitions#getInterfaces <em>Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Interfaces</em>'.
   * @see org.eclipse.camf.tosca.TBoundaryDefinitions#getInterfaces()
   * @see #getTBoundaryDefinitions()
   * @generated
   */
  EReference getTBoundaryDefinitions_Interfaces();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TCapability <em>TCapability</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCapability</em>'.
   * @see org.eclipse.camf.tosca.TCapability
   * @generated
   */
  EClass getTCapability();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapability#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TCapability#getName()
   * @see #getTCapability()
   * @generated
   */
  EAttribute getTCapability_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TCapabilityDefinition <em>TCapability Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCapability Definition</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition
   * @generated
   */
  EClass getTCapabilityDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TCapabilityDefinition#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraints</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition#getConstraints()
   * @see #getTCapabilityDefinition()
   * @generated
   */
  EReference getTCapabilityDefinition_Constraints();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityDefinition#getCapabilityType <em>Capability Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Capability Type</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition#getCapabilityType()
   * @see #getTCapabilityDefinition()
   * @generated
   */
  EAttribute getTCapabilityDefinition_CapabilityType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityDefinition#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition#getLowerBound()
   * @see #getTCapabilityDefinition()
   * @generated
   */
  EAttribute getTCapabilityDefinition_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition#getName()
   * @see #getTCapabilityDefinition()
   * @generated
   */
  EAttribute getTCapabilityDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityDefinition#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition#getUpperBound()
   * @see #getTCapabilityDefinition()
   * @generated
   */
  EAttribute getTCapabilityDefinition_UpperBound();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TCapabilityRef <em>TCapability Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCapability Ref</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityRef
   * @generated
   */
  EClass getTCapabilityRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityRef#getName()
   * @see #getTCapabilityRef()
   * @generated
   */
  EAttribute getTCapabilityRef_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCapabilityRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityRef#getRef()
   * @see #getTCapabilityRef()
   * @generated
   */
  EAttribute getTCapabilityRef_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TCapabilityType <em>TCapability Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCapability Type</em>'.
   * @see org.eclipse.camf.tosca.TCapabilityType
   * @generated
   */
  EClass getTCapabilityType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TCondition <em>TCondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TCondition</em>'.
   * @see org.eclipse.camf.tosca.TCondition
   * @generated
   */
  EClass getTCondition();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TCondition#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.TCondition#getAny()
   * @see #getTCondition()
   * @generated
   */
  EAttribute getTCondition_Any();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TCondition#getExpressionLanguage <em>Expression Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression Language</em>'.
   * @see org.eclipse.camf.tosca.TCondition#getExpressionLanguage()
   * @see #getTCondition()
   * @generated
   */
  EAttribute getTCondition_ExpressionLanguage();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TConstraint <em>TConstraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TConstraint</em>'.
   * @see org.eclipse.camf.tosca.TConstraint
   * @generated
   */
  EClass getTConstraint();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TConstraint#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.TConstraint#getAny()
   * @see #getTConstraint()
   * @generated
   */
  EAttribute getTConstraint_Any();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TConstraint#getConstraintType <em>Constraint Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constraint Type</em>'.
   * @see org.eclipse.camf.tosca.TConstraint#getConstraintType()
   * @see #getTConstraint()
   * @generated
   */
  EAttribute getTConstraint_ConstraintType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TDefinitions <em>TDefinitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TDefinitions</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions
   * @generated
   */
  EClass getTDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TDefinitions#getExtensions <em>Extensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extensions</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getExtensions()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_Extensions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getImport <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Import</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getImport()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_Import();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TDefinitions#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Types</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getTypes()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_Types();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TDefinitions#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Group</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getGroup()
   * @see #getTDefinitions()
   * @generated
   */
  EAttribute getTDefinitions_Group();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getServiceTemplate <em>Service Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Service Template</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getServiceTemplate()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_ServiceTemplate();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getNodeType <em>Node Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getNodeType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_NodeType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getNodeTypeImplementation <em>Node Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Type Implementation</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getNodeTypeImplementation()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_NodeTypeImplementation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getRelationshipType <em>Relationship Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relationship Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getRelationshipType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_RelationshipType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getRelationshipTypeImplementation <em>Relationship Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relationship Type Implementation</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getRelationshipTypeImplementation()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_RelationshipTypeImplementation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getRequirementType <em>Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirement Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getRequirementType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_RequirementType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getCapabilityType <em>Capability Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Capability Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getCapabilityType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_CapabilityType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getArtifactType <em>Artifact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Artifact Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getArtifactType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_ArtifactType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getArtifactTemplate <em>Artifact Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Artifact Template</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getArtifactTemplate()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_ArtifactTemplate();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getPolicyType <em>Policy Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policy Type</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getPolicyType()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_PolicyType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDefinitions#getPolicyTemplate <em>Policy Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Policy Template</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getPolicyTemplate()
   * @see #getTDefinitions()
   * @generated
   */
  EReference getTDefinitions_PolicyTemplate();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDefinitions#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getId()
   * @see #getTDefinitions()
   * @generated
   */
  EAttribute getTDefinitions_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDefinitions#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getName()
   * @see #getTDefinitions()
   * @generated
   */
  EAttribute getTDefinitions_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDefinitions#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TDefinitions#getTargetNamespace()
   * @see #getTDefinitions()
   * @generated
   */
  EAttribute getTDefinitions_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TDeploymentArtifact <em>TDeployment Artifact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TDeployment Artifact</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifact
   * @generated
   */
  EClass getTDeploymentArtifact();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDeploymentArtifact#getArtifactRef <em>Artifact Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Artifact Ref</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifact#getArtifactRef()
   * @see #getTDeploymentArtifact()
   * @generated
   */
  EAttribute getTDeploymentArtifact_ArtifactRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDeploymentArtifact#getArtifactType <em>Artifact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Artifact Type</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifact#getArtifactType()
   * @see #getTDeploymentArtifact()
   * @generated
   */
  EAttribute getTDeploymentArtifact_ArtifactType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDeploymentArtifact#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifact#getName()
   * @see #getTDeploymentArtifact()
   * @generated
   */
  EAttribute getTDeploymentArtifact_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TDeploymentArtifacts <em>TDeployment Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TDeployment Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifacts
   * @generated
   */
  EClass getTDeploymentArtifacts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TDeploymentArtifacts#getDeploymentArtifact <em>Deployment Artifact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Deployment Artifact</em>'.
   * @see org.eclipse.camf.tosca.TDeploymentArtifacts#getDeploymentArtifact()
   * @see #getTDeploymentArtifacts()
   * @generated
   */
  EReference getTDeploymentArtifacts_DeploymentArtifact();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TDocumentation <em>TDocumentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TDocumentation</em>'.
   * @see org.eclipse.camf.tosca.TDocumentation
   * @generated
   */
  EClass getTDocumentation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TDocumentation#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Mixed</em>'.
   * @see org.eclipse.camf.tosca.TDocumentation#getMixed()
   * @see #getTDocumentation()
   * @generated
   */
  EAttribute getTDocumentation_Mixed();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TDocumentation#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.TDocumentation#getAny()
   * @see #getTDocumentation()
   * @generated
   */
  EAttribute getTDocumentation_Any();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDocumentation#getLang <em>Lang</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lang</em>'.
   * @see org.eclipse.camf.tosca.TDocumentation#getLang()
   * @see #getTDocumentation()
   * @generated
   */
  EAttribute getTDocumentation_Lang();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TDocumentation#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source</em>'.
   * @see org.eclipse.camf.tosca.TDocumentation#getSource()
   * @see #getTDocumentation()
   * @generated
   */
  EAttribute getTDocumentation_Source();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TEntityTemplate <em>TEntity Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TEntity Template</em>'.
   * @see org.eclipse.camf.tosca.TEntityTemplate
   * @generated
   */
  EClass getTEntityTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TEntityTemplate#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Properties</em>'.
   * @see org.eclipse.camf.tosca.TEntityTemplate#getProperties()
   * @see #getTEntityTemplate()
   * @generated
   */
  EReference getTEntityTemplate_Properties();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TEntityTemplate#getPropertyConstraints <em>Property Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property Constraints</em>'.
   * @see org.eclipse.camf.tosca.TEntityTemplate#getPropertyConstraints()
   * @see #getTEntityTemplate()
   * @generated
   */
  EReference getTEntityTemplate_PropertyConstraints();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityTemplate#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.camf.tosca.TEntityTemplate#getId()
   * @see #getTEntityTemplate()
   * @generated
   */
  EAttribute getTEntityTemplate_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityTemplate#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.camf.tosca.TEntityTemplate#getType()
   * @see #getTEntityTemplate()
   * @generated
   */
  EAttribute getTEntityTemplate_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TEntityType <em>TEntity Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TEntity Type</em>'.
   * @see org.eclipse.camf.tosca.TEntityType
   * @generated
   */
  EClass getTEntityType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TEntityType#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tags</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getTags()
   * @see #getTEntityType()
   * @generated
   */
  EReference getTEntityType_Tags();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TEntityType#getDerivedFrom <em>Derived From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derived From</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getDerivedFrom()
   * @see #getTEntityType()
   * @generated
   */
  EReference getTEntityType_DerivedFrom();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TEntityType#getPropertiesDefinition <em>Properties Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Properties Definition</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getPropertiesDefinition()
   * @see #getTEntityType()
   * @generated
   */
  EReference getTEntityType_PropertiesDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityType#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getAbstract()
   * @see #getTEntityType()
   * @generated
   */
  EAttribute getTEntityType_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityType#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getFinal()
   * @see #getTEntityType()
   * @generated
   */
  EAttribute getTEntityType_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityType#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getName()
   * @see #getTEntityType()
   * @generated
   */
  EAttribute getTEntityType_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TEntityType#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TEntityType#getTargetNamespace()
   * @see #getTEntityType()
   * @generated
   */
  EAttribute getTEntityType_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TExportedInterface <em>TExported Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TExported Interface</em>'.
   * @see org.eclipse.camf.tosca.TExportedInterface
   * @generated
   */
  EClass getTExportedInterface();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TExportedInterface#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operation</em>'.
   * @see org.eclipse.camf.tosca.TExportedInterface#getOperation()
   * @see #getTExportedInterface()
   * @generated
   */
  EReference getTExportedInterface_Operation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TExportedInterface#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TExportedInterface#getName()
   * @see #getTExportedInterface()
   * @generated
   */
  EAttribute getTExportedInterface_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TExportedOperation <em>TExported Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TExported Operation</em>'.
   * @see org.eclipse.camf.tosca.TExportedOperation
   * @generated
   */
  EClass getTExportedOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TExportedOperation#getNodeOperation <em>Node Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node Operation</em>'.
   * @see org.eclipse.camf.tosca.TExportedOperation#getNodeOperation()
   * @see #getTExportedOperation()
   * @generated
   */
  EReference getTExportedOperation_NodeOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TExportedOperation#getRelationshipOperation <em>Relationship Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relationship Operation</em>'.
   * @see org.eclipse.camf.tosca.TExportedOperation#getRelationshipOperation()
   * @see #getTExportedOperation()
   * @generated
   */
  EReference getTExportedOperation_RelationshipOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TExportedOperation#getPlan <em>Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plan</em>'.
   * @see org.eclipse.camf.tosca.TExportedOperation#getPlan()
   * @see #getTExportedOperation()
   * @generated
   */
  EReference getTExportedOperation_Plan();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TExportedOperation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TExportedOperation#getName()
   * @see #getTExportedOperation()
   * @generated
   */
  EAttribute getTExportedOperation_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TExtensibleElements <em>TExtensible Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TExtensible Elements</em>'.
   * @see org.eclipse.camf.tosca.TExtensibleElements
   * @generated
   */
  EClass getTExtensibleElements();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TExtensibleElements#getDocumentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Documentation</em>'.
   * @see org.eclipse.camf.tosca.TExtensibleElements#getDocumentation()
   * @see #getTExtensibleElements()
   * @generated
   */
  EReference getTExtensibleElements_Documentation();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TExtensibleElements#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.TExtensibleElements#getAny()
   * @see #getTExtensibleElements()
   * @generated
   */
  EAttribute getTExtensibleElements_Any();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TExtensibleElements#getAnyAttribute <em>Any Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any Attribute</em>'.
   * @see org.eclipse.camf.tosca.TExtensibleElements#getAnyAttribute()
   * @see #getTExtensibleElements()
   * @generated
   */
  EAttribute getTExtensibleElements_AnyAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TExtension <em>TExtension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TExtension</em>'.
   * @see org.eclipse.camf.tosca.TExtension
   * @generated
   */
  EClass getTExtension();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TExtension#getMustUnderstand <em>Must Understand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Must Understand</em>'.
   * @see org.eclipse.camf.tosca.TExtension#getMustUnderstand()
   * @see #getTExtension()
   * @generated
   */
  EAttribute getTExtension_MustUnderstand();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TExtension#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.camf.tosca.TExtension#getNamespace()
   * @see #getTExtension()
   * @generated
   */
  EAttribute getTExtension_Namespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TExtensions <em>TExtensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TExtensions</em>'.
   * @see org.eclipse.camf.tosca.TExtensions
   * @generated
   */
  EClass getTExtensions();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TExtensions#getExtension <em>Extension</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extension</em>'.
   * @see org.eclipse.camf.tosca.TExtensions#getExtension()
   * @see #getTExtensions()
   * @generated
   */
  EReference getTExtensions_Extension();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TImplementationArtifact <em>TImplementation Artifact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TImplementation Artifact</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifact
   * @generated
   */
  EClass getTImplementationArtifact();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactRef <em>Artifact Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Artifact Ref</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifact#getArtifactRef()
   * @see #getTImplementationArtifact()
   * @generated
   */
  EAttribute getTImplementationArtifact_ArtifactRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImplementationArtifact#getArtifactType <em>Artifact Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Artifact Type</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifact#getArtifactType()
   * @see #getTImplementationArtifact()
   * @generated
   */
  EAttribute getTImplementationArtifact_ArtifactType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImplementationArtifact#getInterfaceName <em>Interface Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Name</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifact#getInterfaceName()
   * @see #getTImplementationArtifact()
   * @generated
   */
  EAttribute getTImplementationArtifact_InterfaceName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImplementationArtifact#getOperationName <em>Operation Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Name</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifact#getOperationName()
   * @see #getTImplementationArtifact()
   * @generated
   */
  EAttribute getTImplementationArtifact_OperationName();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TImplementationArtifacts <em>TImplementation Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TImplementation Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifacts
   * @generated
   */
  EClass getTImplementationArtifacts();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TImplementationArtifacts#getImplementationArtifact <em>Implementation Artifact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Implementation Artifact</em>'.
   * @see org.eclipse.camf.tosca.TImplementationArtifacts#getImplementationArtifact()
   * @see #getTImplementationArtifacts()
   * @generated
   */
  EReference getTImplementationArtifacts_ImplementationArtifact();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TImport <em>TImport</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TImport</em>'.
   * @see org.eclipse.camf.tosca.TImport
   * @generated
   */
  EClass getTImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImport#getImportType <em>Import Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import Type</em>'.
   * @see org.eclipse.camf.tosca.TImport#getImportType()
   * @see #getTImport()
   * @generated
   */
  EAttribute getTImport_ImportType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImport#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see org.eclipse.camf.tosca.TImport#getLocation()
   * @see #getTImport()
   * @generated
   */
  EAttribute getTImport_Location();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TImport#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace</em>'.
   * @see org.eclipse.camf.tosca.TImport#getNamespace()
   * @see #getTImport()
   * @generated
   */
  EAttribute getTImport_Namespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TInterface <em>TInterface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TInterface</em>'.
   * @see org.eclipse.camf.tosca.TInterface
   * @generated
   */
  EClass getTInterface();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TInterface#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operation</em>'.
   * @see org.eclipse.camf.tosca.TInterface#getOperation()
   * @see #getTInterface()
   * @generated
   */
  EReference getTInterface_Operation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TInterface#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TInterface#getName()
   * @see #getTInterface()
   * @generated
   */
  EAttribute getTInterface_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TNodeTemplate <em>TNode Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TNode Template</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate
   * @generated
   */
  EClass getTNodeTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTemplate#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirements</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getRequirements()
   * @see #getTNodeTemplate()
   * @generated
   */
  EReference getTNodeTemplate_Requirements();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTemplate#getCapabilities <em>Capabilities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Capabilities</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getCapabilities()
   * @see #getTNodeTemplate()
   * @generated
   */
  EReference getTNodeTemplate_Capabilities();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTemplate#getPolicies <em>Policies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Policies</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getPolicies()
   * @see #getTNodeTemplate()
   * @generated
   */
  EReference getTNodeTemplate_Policies();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTemplate#getDeploymentArtifacts <em>Deployment Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Deployment Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getDeploymentArtifacts()
   * @see #getTNodeTemplate()
   * @generated
   */
  EReference getTNodeTemplate_DeploymentArtifacts();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances <em>Max Instances</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Max Instances</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getMaxInstances()
   * @see #getTNodeTemplate()
   * @generated
   */
  EAttribute getTNodeTemplate_MaxInstances();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTemplate#getMinInstances <em>Min Instances</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Min Instances</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getMinInstances()
   * @see #getTNodeTemplate()
   * @generated
   */
  EAttribute getTNodeTemplate_MinInstances();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TNodeTemplate#getName()
   * @see #getTNodeTemplate()
   * @generated
   */
  EAttribute getTNodeTemplate_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TNodeType <em>TNode Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TNode Type</em>'.
   * @see org.eclipse.camf.tosca.TNodeType
   * @generated
   */
  EClass getTNodeType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeType#getRequirementDefinitions <em>Requirement Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Requirement Definitions</em>'.
   * @see org.eclipse.camf.tosca.TNodeType#getRequirementDefinitions()
   * @see #getTNodeType()
   * @generated
   */
  EReference getTNodeType_RequirementDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeType#getCapabilityDefinitions <em>Capability Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Capability Definitions</em>'.
   * @see org.eclipse.camf.tosca.TNodeType#getCapabilityDefinitions()
   * @see #getTNodeType()
   * @generated
   */
  EReference getTNodeType_CapabilityDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeType#getInstanceStates <em>Instance States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instance States</em>'.
   * @see org.eclipse.camf.tosca.TNodeType#getInstanceStates()
   * @see #getTNodeType()
   * @generated
   */
  EReference getTNodeType_InstanceStates();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeType#getInterfaces <em>Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Interfaces</em>'.
   * @see org.eclipse.camf.tosca.TNodeType#getInterfaces()
   * @see #getTNodeType()
   * @generated
   */
  EReference getTNodeType_Interfaces();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TNodeTypeImplementation <em>TNode Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TNode Type Implementation</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation
   * @generated
   */
  EClass getTNodeTypeImplementation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tags</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getTags()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EReference getTNodeTypeImplementation_Tags();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getDerivedFrom <em>Derived From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derived From</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getDerivedFrom()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EReference getTNodeTypeImplementation_DerivedFrom();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getRequiredContainerFeatures <em>Required Container Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Required Container Features</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getRequiredContainerFeatures()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EReference getTNodeTypeImplementation_RequiredContainerFeatures();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getImplementationArtifacts <em>Implementation Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Implementation Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getImplementationArtifacts()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EReference getTNodeTypeImplementation_ImplementationArtifacts();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getDeploymentArtifacts <em>Deployment Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Deployment Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getDeploymentArtifacts()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EReference getTNodeTypeImplementation_DeploymentArtifacts();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getAbstract()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EAttribute getTNodeTypeImplementation_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getFinal()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EAttribute getTNodeTypeImplementation_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getName()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EAttribute getTNodeTypeImplementation_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getNodeType <em>Node Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Node Type</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getNodeType()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EAttribute getTNodeTypeImplementation_NodeType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TNodeTypeImplementation#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation#getTargetNamespace()
   * @see #getTNodeTypeImplementation()
   * @generated
   */
  EAttribute getTNodeTypeImplementation_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TOperation <em>TOperation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TOperation</em>'.
   * @see org.eclipse.camf.tosca.TOperation
   * @generated
   */
  EClass getTOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TOperation#getInputParameters <em>Input Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Input Parameters</em>'.
   * @see org.eclipse.camf.tosca.TOperation#getInputParameters()
   * @see #getTOperation()
   * @generated
   */
  EReference getTOperation_InputParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TOperation#getOutputParameters <em>Output Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Parameters</em>'.
   * @see org.eclipse.camf.tosca.TOperation#getOutputParameters()
   * @see #getTOperation()
   * @generated
   */
  EReference getTOperation_OutputParameters();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TOperation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TOperation#getName()
   * @see #getTOperation()
   * @generated
   */
  EAttribute getTOperation_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TParameter <em>TParameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TParameter</em>'.
   * @see org.eclipse.camf.tosca.TParameter
   * @generated
   */
  EClass getTParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TParameter#getName()
   * @see #getTParameter()
   * @generated
   */
  EAttribute getTParameter_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TParameter#getRequired <em>Required</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required</em>'.
   * @see org.eclipse.camf.tosca.TParameter#getRequired()
   * @see #getTParameter()
   * @generated
   */
  EAttribute getTParameter_Required();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TParameter#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.camf.tosca.TParameter#getType()
   * @see #getTParameter()
   * @generated
   */
  EAttribute getTParameter_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPlan <em>TPlan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPlan</em>'.
   * @see org.eclipse.camf.tosca.TPlan
   * @generated
   */
  EClass getTPlan();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPlan#getPrecondition <em>Precondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Precondition</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getPrecondition()
   * @see #getTPlan()
   * @generated
   */
  EReference getTPlan_Precondition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPlan#getInputParameters <em>Input Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Input Parameters</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getInputParameters()
   * @see #getTPlan()
   * @generated
   */
  EReference getTPlan_InputParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPlan#getOutputParameters <em>Output Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Parameters</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getOutputParameters()
   * @see #getTPlan()
   * @generated
   */
  EReference getTPlan_OutputParameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPlan#getPlanModel <em>Plan Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plan Model</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getPlanModel()
   * @see #getTPlan()
   * @generated
   */
  EReference getTPlan_PlanModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPlan#getPlanModelReference <em>Plan Model Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plan Model Reference</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getPlanModelReference()
   * @see #getTPlan()
   * @generated
   */
  EReference getTPlan_PlanModelReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPlan#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getId()
   * @see #getTPlan()
   * @generated
   */
  EAttribute getTPlan_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPlan#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getName()
   * @see #getTPlan()
   * @generated
   */
  EAttribute getTPlan_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPlan#getPlanLanguage <em>Plan Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plan Language</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getPlanLanguage()
   * @see #getTPlan()
   * @generated
   */
  EAttribute getTPlan_PlanLanguage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPlan#getPlanType <em>Plan Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plan Type</em>'.
   * @see org.eclipse.camf.tosca.TPlan#getPlanType()
   * @see #getTPlan()
   * @generated
   */
  EAttribute getTPlan_PlanType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPlans <em>TPlans</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPlans</em>'.
   * @see org.eclipse.camf.tosca.TPlans
   * @generated
   */
  EClass getTPlans();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TPlans#getPlan <em>Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Plan</em>'.
   * @see org.eclipse.camf.tosca.TPlans#getPlan()
   * @see #getTPlans()
   * @generated
   */
  EReference getTPlans_Plan();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPlans#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TPlans#getTargetNamespace()
   * @see #getTPlans()
   * @generated
   */
  EAttribute getTPlans_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPolicy <em>TPolicy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPolicy</em>'.
   * @see org.eclipse.camf.tosca.TPolicy
   * @generated
   */
  EClass getTPolicy();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPolicy#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TPolicy#getName()
   * @see #getTPolicy()
   * @generated
   */
  EAttribute getTPolicy_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPolicy#getPolicyRef <em>Policy Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Policy Ref</em>'.
   * @see org.eclipse.camf.tosca.TPolicy#getPolicyRef()
   * @see #getTPolicy()
   * @generated
   */
  EAttribute getTPolicy_PolicyRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPolicy#getPolicyType <em>Policy Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Policy Type</em>'.
   * @see org.eclipse.camf.tosca.TPolicy#getPolicyType()
   * @see #getTPolicy()
   * @generated
   */
  EAttribute getTPolicy_PolicyType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPolicyTemplate <em>TPolicy Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPolicy Template</em>'.
   * @see org.eclipse.camf.tosca.TPolicyTemplate
   * @generated
   */
  EClass getTPolicyTemplate();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPolicyTemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TPolicyTemplate#getName()
   * @see #getTPolicyTemplate()
   * @generated
   */
  EAttribute getTPolicyTemplate_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPolicyType <em>TPolicy Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TPolicy Type</em>'.
   * @see org.eclipse.camf.tosca.TPolicyType
   * @generated
   */
  EClass getTPolicyType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TPolicyType#getAppliesTo <em>Applies To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Applies To</em>'.
   * @see org.eclipse.camf.tosca.TPolicyType#getAppliesTo()
   * @see #getTPolicyType()
   * @generated
   */
  EReference getTPolicyType_AppliesTo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPolicyType#getPolicyLanguage <em>Policy Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Policy Language</em>'.
   * @see org.eclipse.camf.tosca.TPolicyType#getPolicyLanguage()
   * @see #getTPolicyType()
   * @generated
   */
  EAttribute getTPolicyType_PolicyLanguage();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPropertyConstraint <em>TProperty Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TProperty Constraint</em>'.
   * @see org.eclipse.camf.tosca.TPropertyConstraint
   * @generated
   */
  EClass getTPropertyConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPropertyConstraint#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.eclipse.camf.tosca.TPropertyConstraint#getProperty()
   * @see #getTPropertyConstraint()
   * @generated
   */
  EAttribute getTPropertyConstraint_Property();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TPropertyMapping <em>TProperty Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TProperty Mapping</em>'.
   * @see org.eclipse.camf.tosca.TPropertyMapping
   * @generated
   */
  EClass getTPropertyMapping();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPropertyMapping#getServiceTemplatePropertyRef <em>Service Template Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Service Template Property Ref</em>'.
   * @see org.eclipse.camf.tosca.TPropertyMapping#getServiceTemplatePropertyRef()
   * @see #getTPropertyMapping()
   * @generated
   */
  EAttribute getTPropertyMapping_ServiceTemplatePropertyRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPropertyMapping#getTargetObjectRef <em>Target Object Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Object Ref</em>'.
   * @see org.eclipse.camf.tosca.TPropertyMapping#getTargetObjectRef()
   * @see #getTPropertyMapping()
   * @generated
   */
  EAttribute getTPropertyMapping_TargetObjectRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TPropertyMapping#getTargetPropertyRef <em>Target Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Property Ref</em>'.
   * @see org.eclipse.camf.tosca.TPropertyMapping#getTargetPropertyRef()
   * @see #getTPropertyMapping()
   * @generated
   */
  EAttribute getTPropertyMapping_TargetPropertyRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRelationshipTemplate <em>TRelationship Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRelationship Template</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate
   * @generated
   */
  EClass getTRelationshipTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTemplate#getSourceElement <em>Source Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Element</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate#getSourceElement()
   * @see #getTRelationshipTemplate()
   * @generated
   */
  EReference getTRelationshipTemplate_SourceElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTemplate#getTargetElement <em>Target Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Element</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate#getTargetElement()
   * @see #getTRelationshipTemplate()
   * @generated
   */
  EReference getTRelationshipTemplate_TargetElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTemplate#getRelationshipConstraints <em>Relationship Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Relationship Constraints</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate#getRelationshipConstraints()
   * @see #getTRelationshipTemplate()
   * @generated
   */
  EReference getTRelationshipTemplate_RelationshipConstraints();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate#getName()
   * @see #getTRelationshipTemplate()
   * @generated
   */
  EAttribute getTRelationshipTemplate_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRelationshipType <em>TRelationship Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRelationship Type</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType
   * @generated
   */
  EClass getTRelationshipType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipType#getInstanceStates <em>Instance States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Instance States</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType#getInstanceStates()
   * @see #getTRelationshipType()
   * @generated
   */
  EReference getTRelationshipType_InstanceStates();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipType#getSourceInterfaces <em>Source Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source Interfaces</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType#getSourceInterfaces()
   * @see #getTRelationshipType()
   * @generated
   */
  EReference getTRelationshipType_SourceInterfaces();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipType#getTargetInterfaces <em>Target Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target Interfaces</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType#getTargetInterfaces()
   * @see #getTRelationshipType()
   * @generated
   */
  EReference getTRelationshipType_TargetInterfaces();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipType#getValidSource <em>Valid Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Valid Source</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType#getValidSource()
   * @see #getTRelationshipType()
   * @generated
   */
  EReference getTRelationshipType_ValidSource();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipType#getValidTarget <em>Valid Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Valid Target</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipType#getValidTarget()
   * @see #getTRelationshipType()
   * @generated
   */
  EReference getTRelationshipType_ValidTarget();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation <em>TRelationship Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRelationship Type Implementation</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation
   * @generated
   */
  EClass getTRelationshipTypeImplementation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tags</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getTags()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EReference getTRelationshipTypeImplementation_Tags();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getDerivedFrom <em>Derived From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derived From</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getDerivedFrom()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EReference getTRelationshipTypeImplementation_DerivedFrom();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getRequiredContainerFeatures <em>Required Container Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Required Container Features</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getRequiredContainerFeatures()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EReference getTRelationshipTypeImplementation_RequiredContainerFeatures();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getImplementationArtifacts <em>Implementation Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Implementation Artifacts</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getImplementationArtifacts()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EReference getTRelationshipTypeImplementation_ImplementationArtifacts();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getAbstract()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EAttribute getTRelationshipTypeImplementation_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getFinal()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EAttribute getTRelationshipTypeImplementation_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getName()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EAttribute getTRelationshipTypeImplementation_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getRelationshipType <em>Relationship Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relationship Type</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getRelationshipType()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EAttribute getTRelationshipTypeImplementation_RelationshipType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation#getTargetNamespace()
   * @see #getTRelationshipTypeImplementation()
   * @generated
   */
  EAttribute getTRelationshipTypeImplementation_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequiredContainerFeature <em>TRequired Container Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequired Container Feature</em>'.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeature
   * @generated
   */
  EClass getTRequiredContainerFeature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequiredContainerFeature#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeature#getFeature()
   * @see #getTRequiredContainerFeature()
   * @generated
   */
  EAttribute getTRequiredContainerFeature_Feature();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequiredContainerFeatures <em>TRequired Container Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequired Container Features</em>'.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeatures
   * @generated
   */
  EClass getTRequiredContainerFeatures();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TRequiredContainerFeatures#getRequiredContainerFeature <em>Required Container Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Container Feature</em>'.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeatures#getRequiredContainerFeature()
   * @see #getTRequiredContainerFeatures()
   * @generated
   */
  EReference getTRequiredContainerFeatures_RequiredContainerFeature();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequirement <em>TRequirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequirement</em>'.
   * @see org.eclipse.camf.tosca.TRequirement
   * @generated
   */
  EClass getTRequirement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TRequirement#getName()
   * @see #getTRequirement()
   * @generated
   */
  EAttribute getTRequirement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequirementDefinition <em>TRequirement Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequirement Definition</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition
   * @generated
   */
  EClass getTRequirementDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TRequirementDefinition#getConstraints <em>Constraints</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraints</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition#getConstraints()
   * @see #getTRequirementDefinition()
   * @generated
   */
  EReference getTRequirementDefinition_Constraints();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementDefinition#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition#getLowerBound()
   * @see #getTRequirementDefinition()
   * @generated
   */
  EAttribute getTRequirementDefinition_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition#getName()
   * @see #getTRequirementDefinition()
   * @generated
   */
  EAttribute getTRequirementDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementDefinition#getRequirementType <em>Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Requirement Type</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition#getRequirementType()
   * @see #getTRequirementDefinition()
   * @generated
   */
  EAttribute getTRequirementDefinition_RequirementType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementDefinition#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see org.eclipse.camf.tosca.TRequirementDefinition#getUpperBound()
   * @see #getTRequirementDefinition()
   * @generated
   */
  EAttribute getTRequirementDefinition_UpperBound();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequirementRef <em>TRequirement Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequirement Ref</em>'.
   * @see org.eclipse.camf.tosca.TRequirementRef
   * @generated
   */
  EClass getTRequirementRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TRequirementRef#getName()
   * @see #getTRequirementRef()
   * @generated
   */
  EAttribute getTRequirementRef_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref</em>'.
   * @see org.eclipse.camf.tosca.TRequirementRef#getRef()
   * @see #getTRequirementRef()
   * @generated
   */
  EAttribute getTRequirementRef_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TRequirementType <em>TRequirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TRequirement Type</em>'.
   * @see org.eclipse.camf.tosca.TRequirementType
   * @generated
   */
  EClass getTRequirementType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TRequirementType#getRequiredCapabilityType <em>Required Capability Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Capability Type</em>'.
   * @see org.eclipse.camf.tosca.TRequirementType#getRequiredCapabilityType()
   * @see #getTRequirementType()
   * @generated
   */
  EAttribute getTRequirementType_RequiredCapabilityType();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TServiceTemplate <em>TService Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TService Template</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate
   * @generated
   */
  EClass getTServiceTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TServiceTemplate#getTags <em>Tags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Tags</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getTags()
   * @see #getTServiceTemplate()
   * @generated
   */
  EReference getTServiceTemplate_Tags();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TServiceTemplate#getBoundaryDefinitions <em>Boundary Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Boundary Definitions</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getBoundaryDefinitions()
   * @see #getTServiceTemplate()
   * @generated
   */
  EReference getTServiceTemplate_BoundaryDefinitions();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TServiceTemplate#getTopologyTemplate <em>Topology Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Topology Template</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getTopologyTemplate()
   * @see #getTServiceTemplate()
   * @generated
   */
  EReference getTServiceTemplate_TopologyTemplate();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.camf.tosca.TServiceTemplate#getPlans <em>Plans</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plans</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getPlans()
   * @see #getTServiceTemplate()
   * @generated
   */
  EReference getTServiceTemplate_Plans();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TServiceTemplate#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getId()
   * @see #getTServiceTemplate()
   * @generated
   */
  EAttribute getTServiceTemplate_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TServiceTemplate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getName()
   * @see #getTServiceTemplate()
   * @generated
   */
  EAttribute getTServiceTemplate_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TServiceTemplate#getSubstitutableNodeType <em>Substitutable Node Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Substitutable Node Type</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getSubstitutableNodeType()
   * @see #getTServiceTemplate()
   * @generated
   */
  EAttribute getTServiceTemplate_SubstitutableNodeType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TServiceTemplate#getTargetNamespace <em>Target Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Namespace</em>'.
   * @see org.eclipse.camf.tosca.TServiceTemplate#getTargetNamespace()
   * @see #getTServiceTemplate()
   * @generated
   */
  EAttribute getTServiceTemplate_TargetNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TTag <em>TTag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTag</em>'.
   * @see org.eclipse.camf.tosca.TTag
   * @generated
   */
  EClass getTTag();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TTag#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.camf.tosca.TTag#getName()
   * @see #getTTag()
   * @generated
   */
  EAttribute getTTag_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.TTag#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.camf.tosca.TTag#getValue()
   * @see #getTTag()
   * @generated
   */
  EAttribute getTTag_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TTags <em>TTags</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTags</em>'.
   * @see org.eclipse.camf.tosca.TTags
   * @generated
   */
  EClass getTTags();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TTags#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tag</em>'.
   * @see org.eclipse.camf.tosca.TTags#getTag()
   * @see #getTTags()
   * @generated
   */
  EReference getTTags_Tag();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TTopologyElementInstanceStates <em>TTopology Element Instance States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTopology Element Instance States</em>'.
   * @see org.eclipse.camf.tosca.TTopologyElementInstanceStates
   * @generated
   */
  EClass getTTopologyElementInstanceStates();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TTopologyElementInstanceStates#getInstanceState <em>Instance State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instance State</em>'.
   * @see org.eclipse.camf.tosca.TTopologyElementInstanceStates#getInstanceState()
   * @see #getTTopologyElementInstanceStates()
   * @generated
   */
  EReference getTTopologyElementInstanceStates_InstanceState();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TTopologyTemplate <em>TTopology Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>TTopology Template</em>'.
   * @see org.eclipse.camf.tosca.TTopologyTemplate
   * @generated
   */
  EClass getTTopologyTemplate();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TTopologyTemplate#getGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Group</em>'.
   * @see org.eclipse.camf.tosca.TTopologyTemplate#getGroup()
   * @see #getTTopologyTemplate()
   * @generated
   */
  EAttribute getTTopologyTemplate_Group();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TTopologyTemplate#getNodeTemplate <em>Node Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Node Template</em>'.
   * @see org.eclipse.camf.tosca.TTopologyTemplate#getNodeTemplate()
   * @see #getTTopologyTemplate()
   * @generated
   */
  EReference getTTopologyTemplate_NodeTemplate();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.camf.tosca.TTopologyTemplate#getRelationshipTemplate <em>Relationship Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Relationship Template</em>'.
   * @see org.eclipse.camf.tosca.TTopologyTemplate#getRelationshipTemplate()
   * @see #getTTopologyTemplate()
   * @generated
   */
  EReference getTTopologyTemplate_RelationshipTemplate();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Types Type</em>'.
   * @see org.eclipse.camf.tosca.TypesType
   * @generated
   */
  EClass getTypesType();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.camf.tosca.TypesType#getAny <em>Any</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Any</em>'.
   * @see org.eclipse.camf.tosca.TypesType#getAny()
   * @see #getTypesType()
   * @generated
   */
  EAttribute getTypesType_Any();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ValidSourceType <em>Valid Source Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Valid Source Type</em>'.
   * @see org.eclipse.camf.tosca.ValidSourceType
   * @generated
   */
  EClass getValidSourceType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.ValidSourceType#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Ref</em>'.
   * @see org.eclipse.camf.tosca.ValidSourceType#getTypeRef()
   * @see #getValidSourceType()
   * @generated
   */
  EAttribute getValidSourceType_TypeRef();

  /**
   * Returns the meta object for class '{@link org.eclipse.camf.tosca.ValidTargetType <em>Valid Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Valid Target Type</em>'.
   * @see org.eclipse.camf.tosca.ValidTargetType
   * @generated
   */
  EClass getValidTargetType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.camf.tosca.ValidTargetType#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Ref</em>'.
   * @see org.eclipse.camf.tosca.ValidTargetType#getTypeRef()
   * @see #getValidTargetType()
   * @generated
   */
  EAttribute getValidTargetType_TypeRef();

  /**
   * Returns the meta object for enum '{@link org.eclipse.camf.tosca.MaxInstancesTypeMember1 <em>Max Instances Type Member1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Max Instances Type Member1</em>'.
   * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
   * @generated
   */
  EEnum getMaxInstancesTypeMember1();

  /**
   * Returns the meta object for enum '{@link org.eclipse.camf.tosca.TBoolean <em>TBoolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>TBoolean</em>'.
   * @see org.eclipse.camf.tosca.TBoolean
   * @generated
   */
  EEnum getTBoolean();

  /**
   * Returns the meta object for enum '{@link org.eclipse.camf.tosca.UpperBoundTypeMember1 <em>Upper Bound Type Member1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Upper Bound Type Member1</em>'.
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
   * @generated
   */
  EEnum getUpperBoundTypeMember1();

  /**
   * Returns the meta object for enum '{@link org.eclipse.camf.tosca.UpperBoundTypeMember11 <em>Upper Bound Type Member11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Upper Bound Type Member11</em>'.
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
   * @generated
   */
  EEnum getUpperBoundTypeMember11();

  /**
   * Returns the meta object for data type '{@link java.lang.String <em>Imported URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Imported URI</em>'.
   * @see java.lang.String
   * @model instanceClass="java.lang.String"
   *        extendedMetaData="name='importedURI' baseType='http://www.eclipse.org/emf/2003/XMLType#anyURI'"
   * @generated
   */
  EDataType getImportedURI();

  /**
   * Returns the meta object for data type '{@link java.lang.Object <em>Max Instances Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Max Instances Type</em>'.
   * @see java.lang.Object
   * @model instanceClass="java.lang.Object"
   *        extendedMetaData="name='maxInstances_._type' memberTypes='maxInstances_._type_._member_._0 maxInstances_._type_._member_._1'"
   * @generated
   */
  EDataType getMaxInstancesType();

  /**
   * Returns the meta object for data type '{@link java.math.BigInteger <em>Max Instances Type Member0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Max Instances Type Member0</em>'.
   * @see java.math.BigInteger
   * @model instanceClass="java.math.BigInteger"
   *        extendedMetaData="name='maxInstances_._type_._member_._0' baseType='http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger' pattern='([1-9]+[0-9]*)'"
   * @generated
   */
  EDataType getMaxInstancesTypeMember0();

  /**
   * Returns the meta object for data type '{@link org.eclipse.camf.tosca.MaxInstancesTypeMember1 <em>Max Instances Type Member1 Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Max Instances Type Member1 Object</em>'.
   * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
   * @model instanceClass="org.eclipse.camf.tosca.MaxInstancesTypeMember1"
   *        extendedMetaData="name='maxInstances_._type_._member_._1:Object' baseType='maxInstances_._type_._member_._1'"
   * @generated
   */
  EDataType getMaxInstancesTypeMember1Object();

  /**
   * Returns the meta object for data type '{@link org.eclipse.camf.tosca.TBoolean <em>TBoolean Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>TBoolean Object</em>'.
   * @see org.eclipse.camf.tosca.TBoolean
   * @model instanceClass="org.eclipse.camf.tosca.TBoolean"
   *        extendedMetaData="name='tBoolean:Object' baseType='tBoolean'"
   * @generated
   */
  EDataType getTBooleanObject();

  /**
   * Returns the meta object for data type '{@link java.lang.Object <em>Upper Bound Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type</em>'.
   * @see java.lang.Object
   * @model instanceClass="java.lang.Object"
   *        extendedMetaData="name='upperBound_._type' memberTypes='upperBound_._type_._member_._0 upperBound_._type_._member_._1'"
   * @generated
   */
  EDataType getUpperBoundType();

  /**
   * Returns the meta object for data type '{@link java.lang.Object <em>Upper Bound Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type1</em>'.
   * @see java.lang.Object
   * @model instanceClass="java.lang.Object"
   *        extendedMetaData="name='upperBound_._1_._type' memberTypes='upperBound_._1_._type_._member_._0 upperBound_._1_._type_._member_._1'"
   * @generated
   */
  EDataType getUpperBoundType1();

  /**
   * Returns the meta object for data type '{@link java.math.BigInteger <em>Upper Bound Type Member0</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type Member0</em>'.
   * @see java.math.BigInteger
   * @model instanceClass="java.math.BigInteger"
   *        extendedMetaData="name='upperBound_._type_._member_._0' baseType='http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger' pattern='([1-9]+[0-9]*)'"
   * @generated
   */
  EDataType getUpperBoundTypeMember0();

  /**
   * Returns the meta object for data type '{@link java.math.BigInteger <em>Upper Bound Type Member01</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type Member01</em>'.
   * @see java.math.BigInteger
   * @model instanceClass="java.math.BigInteger"
   *        extendedMetaData="name='upperBound_._1_._type_._member_._0' baseType='http://www.eclipse.org/emf/2003/XMLType#nonNegativeInteger' pattern='([1-9]+[0-9]*)'"
   * @generated
   */
  EDataType getUpperBoundTypeMember01();

  /**
   * Returns the meta object for data type '{@link org.eclipse.camf.tosca.UpperBoundTypeMember1 <em>Upper Bound Type Member1 Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type Member1 Object</em>'.
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
   * @model instanceClass="org.eclipse.camf.tosca.UpperBoundTypeMember1"
   *        extendedMetaData="name='upperBound_._type_._member_._1:Object' baseType='upperBound_._type_._member_._1'"
   * @generated
   */
  EDataType getUpperBoundTypeMember1Object();

  /**
   * Returns the meta object for data type '{@link org.eclipse.camf.tosca.UpperBoundTypeMember11 <em>Upper Bound Type Member1 Object1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Upper Bound Type Member1 Object1</em>'.
   * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
   * @model instanceClass="org.eclipse.camf.tosca.UpperBoundTypeMember11"
   *        extendedMetaData="name='upperBound_._1_._type_._member_._1:Object' baseType='upperBound_._1_._type_._member_._1'"
   * @generated
   */
  EDataType getUpperBoundTypeMember1Object1();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ToscaFactory getToscaFactory();

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
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ArtifactReferencesTypeImpl <em>Artifact References Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ArtifactReferencesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getArtifactReferencesType()
     * @generated
     */
    EClass ARTIFACT_REFERENCES_TYPE = eINSTANCE.getArtifactReferencesType();

    /**
     * The meta object literal for the '<em><b>Artifact Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE = eINSTANCE.getArtifactReferencesType_ArtifactReference();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.CapabilitiesTypeImpl <em>Capabilities Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.CapabilitiesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilitiesType()
     * @generated
     */
    EClass CAPABILITIES_TYPE = eINSTANCE.getCapabilitiesType();

    /**
     * The meta object literal for the '<em><b>Capability</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPABILITIES_TYPE__CAPABILITY = eINSTANCE.getCapabilitiesType_Capability();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.CapabilitiesType1Impl <em>Capabilities Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.CapabilitiesType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilitiesType1()
     * @generated
     */
    EClass CAPABILITIES_TYPE1 = eINSTANCE.getCapabilitiesType1();

    /**
     * The meta object literal for the '<em><b>Capability</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPABILITIES_TYPE1__CAPABILITY = eINSTANCE.getCapabilitiesType1_Capability();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.CapabilityDefinitionsTypeImpl <em>Capability Definitions Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.CapabilityDefinitionsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getCapabilityDefinitionsType()
     * @generated
     */
    EClass CAPABILITY_DEFINITIONS_TYPE = eINSTANCE.getCapabilityDefinitionsType();

    /**
     * The meta object literal for the '<em><b>Capability Definition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAPABILITY_DEFINITIONS_TYPE__CAPABILITY_DEFINITION = eINSTANCE.getCapabilityDefinitionsType_CapabilityDefinition();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ConstraintsTypeImpl <em>Constraints Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ConstraintsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getConstraintsType()
     * @generated
     */
    EClass CONSTRAINTS_TYPE = eINSTANCE.getConstraintsType();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINTS_TYPE__CONSTRAINT = eINSTANCE.getConstraintsType_Constraint();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ConstraintsType1Impl <em>Constraints Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ConstraintsType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getConstraintsType1()
     * @generated
     */
    EClass CONSTRAINTS_TYPE1 = eINSTANCE.getConstraintsType1();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINTS_TYPE1__CONSTRAINT = eINSTANCE.getConstraintsType1_Constraint();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.DefinitionsTypeImpl <em>Definitions Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.DefinitionsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDefinitionsType()
     * @generated
     */
    EClass DEFINITIONS_TYPE = eINSTANCE.getDefinitionsType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.DerivedFromTypeImpl <em>Derived From Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.DerivedFromTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType()
     * @generated
     */
    EClass DERIVED_FROM_TYPE = eINSTANCE.getDerivedFromType();

    /**
     * The meta object literal for the '<em><b>Relationship Type Implementation Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF = eINSTANCE.getDerivedFromType_RelationshipTypeImplementationRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.DerivedFromType1Impl <em>Derived From Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.DerivedFromType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType1()
     * @generated
     */
    EClass DERIVED_FROM_TYPE1 = eINSTANCE.getDerivedFromType1();

    /**
     * The meta object literal for the '<em><b>Node Type Implementation Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DERIVED_FROM_TYPE1__NODE_TYPE_IMPLEMENTATION_REF = eINSTANCE.getDerivedFromType1_NodeTypeImplementationRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.DerivedFromType2Impl <em>Derived From Type2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.DerivedFromType2Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDerivedFromType2()
     * @generated
     */
    EClass DERIVED_FROM_TYPE2 = eINSTANCE.getDerivedFromType2();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DERIVED_FROM_TYPE2__TYPE_REF = eINSTANCE.getDerivedFromType2_TypeRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.DocumentRootImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getDocumentRoot()
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
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__DEFINITIONS = eINSTANCE.getDocumentRoot_Definitions();

    /**
     * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_ROOT__DOCUMENTATION = eINSTANCE.getDocumentRoot_Documentation();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ExcludeTypeImpl <em>Exclude Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ExcludeTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getExcludeType()
     * @generated
     */
    EClass EXCLUDE_TYPE = eINSTANCE.getExcludeType();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCLUDE_TYPE__PATTERN = eINSTANCE.getExcludeType_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ExtensionsTypeImpl <em>Extensions Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ExtensionsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getExtensionsType()
     * @generated
     */
    EClass EXTENSIONS_TYPE = eINSTANCE.getExtensionsType();

    /**
     * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTENSIONS_TYPE__EXTENSION = eINSTANCE.getExtensionsType_Extension();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ImplementationArtifactTypeImpl <em>Implementation Artifact Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ImplementationArtifactTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getImplementationArtifactType()
     * @generated
     */
    EClass IMPLEMENTATION_ARTIFACT_TYPE = eINSTANCE.getImplementationArtifactType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.IncludeTypeImpl <em>Include Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.IncludeTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getIncludeType()
     * @generated
     */
    EClass INCLUDE_TYPE = eINSTANCE.getIncludeType();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_TYPE__PATTERN = eINSTANCE.getIncludeType_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.InputParametersTypeImpl <em>Input Parameters Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.InputParametersTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInputParametersType()
     * @generated
     */
    EClass INPUT_PARAMETERS_TYPE = eINSTANCE.getInputParametersType();

    /**
     * The meta object literal for the '<em><b>Input Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_PARAMETERS_TYPE__INPUT_PARAMETER = eINSTANCE.getInputParametersType_InputParameter();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.InputParametersType1Impl <em>Input Parameters Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.InputParametersType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInputParametersType1()
     * @generated
     */
    EClass INPUT_PARAMETERS_TYPE1 = eINSTANCE.getInputParametersType1();

    /**
     * The meta object literal for the '<em><b>Input Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INPUT_PARAMETERS_TYPE1__INPUT_PARAMETER = eINSTANCE.getInputParametersType1_InputParameter();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.InstanceStateTypeImpl <em>Instance State Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.InstanceStateTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInstanceStateType()
     * @generated
     */
    EClass INSTANCE_STATE_TYPE = eINSTANCE.getInstanceStateType();

    /**
     * The meta object literal for the '<em><b>State</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INSTANCE_STATE_TYPE__STATE = eINSTANCE.getInstanceStateType_State();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.InterfacesTypeImpl <em>Interfaces Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.InterfacesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInterfacesType()
     * @generated
     */
    EClass INTERFACES_TYPE = eINSTANCE.getInterfacesType();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACES_TYPE__INTERFACE = eINSTANCE.getInterfacesType_Interface();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.InterfacesType1Impl <em>Interfaces Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.InterfacesType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getInterfacesType1()
     * @generated
     */
    EClass INTERFACES_TYPE1 = eINSTANCE.getInterfacesType1();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACES_TYPE1__INTERFACE = eINSTANCE.getInterfacesType1_Interface();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.NodeOperationTypeImpl <em>Node Operation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.NodeOperationTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getNodeOperationType()
     * @generated
     */
    EClass NODE_OPERATION_TYPE = eINSTANCE.getNodeOperationType();

    /**
     * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_OPERATION_TYPE__INTERFACE_NAME = eINSTANCE.getNodeOperationType_InterfaceName();

    /**
     * The meta object literal for the '<em><b>Node Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_OPERATION_TYPE__NODE_REF = eINSTANCE.getNodeOperationType_NodeRef();

    /**
     * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_OPERATION_TYPE__OPERATION_NAME = eINSTANCE.getNodeOperationType_OperationName();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.NodeTypeReferenceTypeImpl <em>Node Type Reference Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.NodeTypeReferenceTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getNodeTypeReferenceType()
     * @generated
     */
    EClass NODE_TYPE_REFERENCE_TYPE = eINSTANCE.getNodeTypeReferenceType();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE_TYPE_REFERENCE_TYPE__TYPE_REF = eINSTANCE.getNodeTypeReferenceType_TypeRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.OutputParametersTypeImpl <em>Output Parameters Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.OutputParametersTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getOutputParametersType()
     * @generated
     */
    EClass OUTPUT_PARAMETERS_TYPE = eINSTANCE.getOutputParametersType();

    /**
     * The meta object literal for the '<em><b>Output Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PARAMETERS_TYPE__OUTPUT_PARAMETER = eINSTANCE.getOutputParametersType_OutputParameter();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.OutputParametersType1Impl <em>Output Parameters Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.OutputParametersType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getOutputParametersType1()
     * @generated
     */
    EClass OUTPUT_PARAMETERS_TYPE1 = eINSTANCE.getOutputParametersType1();

    /**
     * The meta object literal for the '<em><b>Output Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTPUT_PARAMETERS_TYPE1__OUTPUT_PARAMETER = eINSTANCE.getOutputParametersType1_OutputParameter();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PlanModelReferenceTypeImpl <em>Plan Model Reference Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PlanModelReferenceTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanModelReferenceType()
     * @generated
     */
    EClass PLAN_MODEL_REFERENCE_TYPE = eINSTANCE.getPlanModelReferenceType();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PLAN_MODEL_REFERENCE_TYPE__REFERENCE = eINSTANCE.getPlanModelReferenceType_Reference();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PlanModelTypeImpl <em>Plan Model Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PlanModelTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanModelType()
     * @generated
     */
    EClass PLAN_MODEL_TYPE = eINSTANCE.getPlanModelType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PLAN_MODEL_TYPE__ANY = eINSTANCE.getPlanModelType_Any();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PlanTypeImpl <em>Plan Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PlanTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPlanType()
     * @generated
     */
    EClass PLAN_TYPE = eINSTANCE.getPlanType();

    /**
     * The meta object literal for the '<em><b>Plan Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PLAN_TYPE__PLAN_REF = eINSTANCE.getPlanType_PlanRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PoliciesTypeImpl <em>Policies Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PoliciesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPoliciesType()
     * @generated
     */
    EClass POLICIES_TYPE = eINSTANCE.getPoliciesType();

    /**
     * The meta object literal for the '<em><b>Policy</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICIES_TYPE__POLICY = eINSTANCE.getPoliciesType_Policy();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PoliciesType1Impl <em>Policies Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PoliciesType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPoliciesType1()
     * @generated
     */
    EClass POLICIES_TYPE1 = eINSTANCE.getPoliciesType1();

    /**
     * The meta object literal for the '<em><b>Policy</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POLICIES_TYPE1__POLICY = eINSTANCE.getPoliciesType1_Policy();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertiesDefinitionTypeImpl <em>Properties Definition Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertiesDefinitionTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesDefinitionType()
     * @generated
     */
    EClass PROPERTIES_DEFINITION_TYPE = eINSTANCE.getPropertiesDefinitionType();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTIES_DEFINITION_TYPE__ELEMENT = eINSTANCE.getPropertiesDefinitionType_Element();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTIES_DEFINITION_TYPE__TYPE = eINSTANCE.getPropertiesDefinitionType_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertiesTypeImpl <em>Properties Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertiesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesType()
     * @generated
     */
    EClass PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTIES_TYPE__ANY = eINSTANCE.getPropertiesType_Any();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertiesType1Impl <em>Properties Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertiesType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertiesType1()
     * @generated
     */
    EClass PROPERTIES_TYPE1 = eINSTANCE.getPropertiesType1();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTIES_TYPE1__ANY = eINSTANCE.getPropertiesType1_Any();

    /**
     * The meta object literal for the '<em><b>Property Mappings</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTIES_TYPE1__PROPERTY_MAPPINGS = eINSTANCE.getPropertiesType1_PropertyMappings();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertyConstraintsTypeImpl <em>Property Constraints Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertyConstraintsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyConstraintsType()
     * @generated
     */
    EClass PROPERTY_CONSTRAINTS_TYPE = eINSTANCE.getPropertyConstraintsType();

    /**
     * The meta object literal for the '<em><b>Property Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONSTRAINTS_TYPE__PROPERTY_CONSTRAINT = eINSTANCE.getPropertyConstraintsType_PropertyConstraint();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertyConstraintsType1Impl <em>Property Constraints Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertyConstraintsType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyConstraintsType1()
     * @generated
     */
    EClass PROPERTY_CONSTRAINTS_TYPE1 = eINSTANCE.getPropertyConstraintsType1();

    /**
     * The meta object literal for the '<em><b>Property Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_CONSTRAINTS_TYPE1__PROPERTY_CONSTRAINT = eINSTANCE.getPropertyConstraintsType1_PropertyConstraint();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.PropertyMappingsTypeImpl <em>Property Mappings Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.PropertyMappingsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getPropertyMappingsType()
     * @generated
     */
    EClass PROPERTY_MAPPINGS_TYPE = eINSTANCE.getPropertyMappingsType();

    /**
     * The meta object literal for the '<em><b>Property Mapping</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_MAPPINGS_TYPE__PROPERTY_MAPPING = eINSTANCE.getPropertyMappingsType_PropertyMapping();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RelationshipConstraintsTypeImpl <em>Relationship Constraints Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RelationshipConstraintsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipConstraintsType()
     * @generated
     */
    EClass RELATIONSHIP_CONSTRAINTS_TYPE = eINSTANCE.getRelationshipConstraintsType();

    /**
     * The meta object literal for the '<em><b>Relationship Constraint</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONSHIP_CONSTRAINTS_TYPE__RELATIONSHIP_CONSTRAINT = eINSTANCE.getRelationshipConstraintsType_RelationshipConstraint();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RelationshipConstraintTypeImpl <em>Relationship Constraint Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RelationshipConstraintTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipConstraintType()
     * @generated
     */
    EClass RELATIONSHIP_CONSTRAINT_TYPE = eINSTANCE.getRelationshipConstraintType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_CONSTRAINT_TYPE__ANY = eINSTANCE.getRelationshipConstraintType_Any();

    /**
     * The meta object literal for the '<em><b>Constraint Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_CONSTRAINT_TYPE__CONSTRAINT_TYPE = eINSTANCE.getRelationshipConstraintType_ConstraintType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RelationshipOperationTypeImpl <em>Relationship Operation Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RelationshipOperationTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRelationshipOperationType()
     * @generated
     */
    EClass RELATIONSHIP_OPERATION_TYPE = eINSTANCE.getRelationshipOperationType();

    /**
     * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_OPERATION_TYPE__INTERFACE_NAME = eINSTANCE.getRelationshipOperationType_InterfaceName();

    /**
     * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_OPERATION_TYPE__OPERATION_NAME = eINSTANCE.getRelationshipOperationType_OperationName();

    /**
     * The meta object literal for the '<em><b>Relationship Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONSHIP_OPERATION_TYPE__RELATIONSHIP_REF = eINSTANCE.getRelationshipOperationType_RelationshipRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RequirementDefinitionsTypeImpl <em>Requirement Definitions Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RequirementDefinitionsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementDefinitionsType()
     * @generated
     */
    EClass REQUIREMENT_DEFINITIONS_TYPE = eINSTANCE.getRequirementDefinitionsType();

    /**
     * The meta object literal for the '<em><b>Requirement Definition</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION = eINSTANCE.getRequirementDefinitionsType_RequirementDefinition();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RequirementsTypeImpl <em>Requirements Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RequirementsTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementsType()
     * @generated
     */
    EClass REQUIREMENTS_TYPE = eINSTANCE.getRequirementsType();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENTS_TYPE__REQUIREMENT = eINSTANCE.getRequirementsType_Requirement();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.RequirementsType1Impl <em>Requirements Type1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.RequirementsType1Impl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getRequirementsType1()
     * @generated
     */
    EClass REQUIREMENTS_TYPE1 = eINSTANCE.getRequirementsType1();

    /**
     * The meta object literal for the '<em><b>Requirement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENTS_TYPE1__REQUIREMENT = eINSTANCE.getRequirementsType1_Requirement();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.SourceElementTypeImpl <em>Source Element Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.SourceElementTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getSourceElementType()
     * @generated
     */
    EClass SOURCE_ELEMENT_TYPE = eINSTANCE.getSourceElementType();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOURCE_ELEMENT_TYPE__REF = eINSTANCE.getSourceElementType_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.SourceInterfacesTypeImpl <em>Source Interfaces Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.SourceInterfacesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getSourceInterfacesType()
     * @generated
     */
    EClass SOURCE_INTERFACES_TYPE = eINSTANCE.getSourceInterfacesType();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOURCE_INTERFACES_TYPE__INTERFACE = eINSTANCE.getSourceInterfacesType_Interface();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TAppliesToImpl <em>TApplies To</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TAppliesToImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTAppliesTo()
     * @generated
     */
    EClass TAPPLIES_TO = eINSTANCE.getTAppliesTo();

    /**
     * The meta object literal for the '<em><b>Node Type Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TAPPLIES_TO__NODE_TYPE_REFERENCE = eINSTANCE.getTAppliesTo_NodeTypeReference();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TargetElementTypeImpl <em>Target Element Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TargetElementTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTargetElementType()
     * @generated
     */
    EClass TARGET_ELEMENT_TYPE = eINSTANCE.getTargetElementType();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARGET_ELEMENT_TYPE__REF = eINSTANCE.getTargetElementType_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TargetInterfacesTypeImpl <em>Target Interfaces Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TargetInterfacesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTargetInterfacesType()
     * @generated
     */
    EClass TARGET_INTERFACES_TYPE = eINSTANCE.getTargetInterfacesType();

    /**
     * The meta object literal for the '<em><b>Interface</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARGET_INTERFACES_TYPE__INTERFACE = eINSTANCE.getTargetInterfacesType_Interface();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl <em>TArtifact Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TArtifactReferenceImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactReference()
     * @generated
     */
    EClass TARTIFACT_REFERENCE = eINSTANCE.getTArtifactReference();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARTIFACT_REFERENCE__GROUP = eINSTANCE.getTArtifactReference_Group();

    /**
     * The meta object literal for the '<em><b>Include</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARTIFACT_REFERENCE__INCLUDE = eINSTANCE.getTArtifactReference_Include();

    /**
     * The meta object literal for the '<em><b>Exclude</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARTIFACT_REFERENCE__EXCLUDE = eINSTANCE.getTArtifactReference_Exclude();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARTIFACT_REFERENCE__REFERENCE = eINSTANCE.getTArtifactReference_Reference();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TArtifactTemplateImpl <em>TArtifact Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TArtifactTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactTemplate()
     * @generated
     */
    EClass TARTIFACT_TEMPLATE = eINSTANCE.getTArtifactTemplate();

    /**
     * The meta object literal for the '<em><b>Artifact References</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TARTIFACT_TEMPLATE__ARTIFACT_REFERENCES = eINSTANCE.getTArtifactTemplate_ArtifactReferences();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TARTIFACT_TEMPLATE__NAME = eINSTANCE.getTArtifactTemplate_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TArtifactTypeImpl <em>TArtifact Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TArtifactTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTArtifactType()
     * @generated
     */
    EClass TARTIFACT_TYPE = eINSTANCE.getTArtifactType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TBoundaryDefinitionsImpl <em>TBoundary Definitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TBoundaryDefinitionsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBoundaryDefinitions()
     * @generated
     */
    EClass TBOUNDARY_DEFINITIONS = eINSTANCE.getTBoundaryDefinitions();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__PROPERTIES = eINSTANCE.getTBoundaryDefinitions_Properties();

    /**
     * The meta object literal for the '<em><b>Property Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__PROPERTY_CONSTRAINTS = eINSTANCE.getTBoundaryDefinitions_PropertyConstraints();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__REQUIREMENTS = eINSTANCE.getTBoundaryDefinitions_Requirements();

    /**
     * The meta object literal for the '<em><b>Capabilities</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__CAPABILITIES = eINSTANCE.getTBoundaryDefinitions_Capabilities();

    /**
     * The meta object literal for the '<em><b>Policies</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__POLICIES = eINSTANCE.getTBoundaryDefinitions_Policies();

    /**
     * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TBOUNDARY_DEFINITIONS__INTERFACES = eINSTANCE.getTBoundaryDefinitions_Interfaces();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TCapabilityImpl <em>TCapability</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TCapabilityImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapability()
     * @generated
     */
    EClass TCAPABILITY = eINSTANCE.getTCapability();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY__NAME = eINSTANCE.getTCapability_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TCapabilityDefinitionImpl <em>TCapability Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TCapabilityDefinitionImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityDefinition()
     * @generated
     */
    EClass TCAPABILITY_DEFINITION = eINSTANCE.getTCapabilityDefinition();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TCAPABILITY_DEFINITION__CONSTRAINTS = eINSTANCE.getTCapabilityDefinition_Constraints();

    /**
     * The meta object literal for the '<em><b>Capability Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_DEFINITION__CAPABILITY_TYPE = eINSTANCE.getTCapabilityDefinition_CapabilityType();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_DEFINITION__LOWER_BOUND = eINSTANCE.getTCapabilityDefinition_LowerBound();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_DEFINITION__NAME = eINSTANCE.getTCapabilityDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_DEFINITION__UPPER_BOUND = eINSTANCE.getTCapabilityDefinition_UpperBound();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TCapabilityRefImpl <em>TCapability Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TCapabilityRefImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityRef()
     * @generated
     */
    EClass TCAPABILITY_REF = eINSTANCE.getTCapabilityRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_REF__NAME = eINSTANCE.getTCapabilityRef_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCAPABILITY_REF__REF = eINSTANCE.getTCapabilityRef_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TCapabilityTypeImpl <em>TCapability Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TCapabilityTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCapabilityType()
     * @generated
     */
    EClass TCAPABILITY_TYPE = eINSTANCE.getTCapabilityType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TConditionImpl <em>TCondition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TConditionImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTCondition()
     * @generated
     */
    EClass TCONDITION = eINSTANCE.getTCondition();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCONDITION__ANY = eINSTANCE.getTCondition_Any();

    /**
     * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCONDITION__EXPRESSION_LANGUAGE = eINSTANCE.getTCondition_ExpressionLanguage();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TConstraintImpl <em>TConstraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TConstraintImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTConstraint()
     * @generated
     */
    EClass TCONSTRAINT = eINSTANCE.getTConstraint();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCONSTRAINT__ANY = eINSTANCE.getTConstraint_Any();

    /**
     * The meta object literal for the '<em><b>Constraint Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TCONSTRAINT__CONSTRAINT_TYPE = eINSTANCE.getTConstraint_ConstraintType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TDefinitionsImpl <em>TDefinitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TDefinitionsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDefinitions()
     * @generated
     */
    EClass TDEFINITIONS = eINSTANCE.getTDefinitions();

    /**
     * The meta object literal for the '<em><b>Extensions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__EXTENSIONS = eINSTANCE.getTDefinitions_Extensions();

    /**
     * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__IMPORT = eINSTANCE.getTDefinitions_Import();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__TYPES = eINSTANCE.getTDefinitions_Types();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEFINITIONS__GROUP = eINSTANCE.getTDefinitions_Group();

    /**
     * The meta object literal for the '<em><b>Service Template</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__SERVICE_TEMPLATE = eINSTANCE.getTDefinitions_ServiceTemplate();

    /**
     * The meta object literal for the '<em><b>Node Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__NODE_TYPE = eINSTANCE.getTDefinitions_NodeType();

    /**
     * The meta object literal for the '<em><b>Node Type Implementation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__NODE_TYPE_IMPLEMENTATION = eINSTANCE.getTDefinitions_NodeTypeImplementation();

    /**
     * The meta object literal for the '<em><b>Relationship Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__RELATIONSHIP_TYPE = eINSTANCE.getTDefinitions_RelationshipType();

    /**
     * The meta object literal for the '<em><b>Relationship Type Implementation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__RELATIONSHIP_TYPE_IMPLEMENTATION = eINSTANCE.getTDefinitions_RelationshipTypeImplementation();

    /**
     * The meta object literal for the '<em><b>Requirement Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__REQUIREMENT_TYPE = eINSTANCE.getTDefinitions_RequirementType();

    /**
     * The meta object literal for the '<em><b>Capability Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__CAPABILITY_TYPE = eINSTANCE.getTDefinitions_CapabilityType();

    /**
     * The meta object literal for the '<em><b>Artifact Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__ARTIFACT_TYPE = eINSTANCE.getTDefinitions_ArtifactType();

    /**
     * The meta object literal for the '<em><b>Artifact Template</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__ARTIFACT_TEMPLATE = eINSTANCE.getTDefinitions_ArtifactTemplate();

    /**
     * The meta object literal for the '<em><b>Policy Type</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__POLICY_TYPE = eINSTANCE.getTDefinitions_PolicyType();

    /**
     * The meta object literal for the '<em><b>Policy Template</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEFINITIONS__POLICY_TEMPLATE = eINSTANCE.getTDefinitions_PolicyTemplate();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEFINITIONS__ID = eINSTANCE.getTDefinitions_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEFINITIONS__NAME = eINSTANCE.getTDefinitions_Name();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEFINITIONS__TARGET_NAMESPACE = eINSTANCE.getTDefinitions_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TDeploymentArtifactImpl <em>TDeployment Artifact</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TDeploymentArtifactImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDeploymentArtifact()
     * @generated
     */
    EClass TDEPLOYMENT_ARTIFACT = eINSTANCE.getTDeploymentArtifact();

    /**
     * The meta object literal for the '<em><b>Artifact Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEPLOYMENT_ARTIFACT__ARTIFACT_REF = eINSTANCE.getTDeploymentArtifact_ArtifactRef();

    /**
     * The meta object literal for the '<em><b>Artifact Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEPLOYMENT_ARTIFACT__ARTIFACT_TYPE = eINSTANCE.getTDeploymentArtifact_ArtifactType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDEPLOYMENT_ARTIFACT__NAME = eINSTANCE.getTDeploymentArtifact_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TDeploymentArtifactsImpl <em>TDeployment Artifacts</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TDeploymentArtifactsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDeploymentArtifacts()
     * @generated
     */
    EClass TDEPLOYMENT_ARTIFACTS = eINSTANCE.getTDeploymentArtifacts();

    /**
     * The meta object literal for the '<em><b>Deployment Artifact</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TDEPLOYMENT_ARTIFACTS__DEPLOYMENT_ARTIFACT = eINSTANCE.getTDeploymentArtifacts_DeploymentArtifact();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TDocumentationImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTDocumentation()
     * @generated
     */
    EClass TDOCUMENTATION = eINSTANCE.getTDocumentation();

    /**
     * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDOCUMENTATION__MIXED = eINSTANCE.getTDocumentation_Mixed();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDOCUMENTATION__ANY = eINSTANCE.getTDocumentation_Any();

    /**
     * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDOCUMENTATION__LANG = eINSTANCE.getTDocumentation_Lang();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TDOCUMENTATION__SOURCE = eINSTANCE.getTDocumentation_Source();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TEntityTemplateImpl <em>TEntity Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TEntityTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTEntityTemplate()
     * @generated
     */
    EClass TENTITY_TEMPLATE = eINSTANCE.getTEntityTemplate();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TENTITY_TEMPLATE__PROPERTIES = eINSTANCE.getTEntityTemplate_Properties();

    /**
     * The meta object literal for the '<em><b>Property Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TENTITY_TEMPLATE__PROPERTY_CONSTRAINTS = eINSTANCE.getTEntityTemplate_PropertyConstraints();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TEMPLATE__ID = eINSTANCE.getTEntityTemplate_Id();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TEMPLATE__TYPE = eINSTANCE.getTEntityTemplate_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TEntityTypeImpl <em>TEntity Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TEntityTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTEntityType()
     * @generated
     */
    EClass TENTITY_TYPE = eINSTANCE.getTEntityType();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TENTITY_TYPE__TAGS = eINSTANCE.getTEntityType_Tags();

    /**
     * The meta object literal for the '<em><b>Derived From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TENTITY_TYPE__DERIVED_FROM = eINSTANCE.getTEntityType_DerivedFrom();

    /**
     * The meta object literal for the '<em><b>Properties Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TENTITY_TYPE__PROPERTIES_DEFINITION = eINSTANCE.getTEntityType_PropertiesDefinition();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TYPE__ABSTRACT = eINSTANCE.getTEntityType_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TYPE__FINAL = eINSTANCE.getTEntityType_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TYPE__NAME = eINSTANCE.getTEntityType_Name();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TENTITY_TYPE__TARGET_NAMESPACE = eINSTANCE.getTEntityType_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TExportedInterfaceImpl <em>TExported Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TExportedInterfaceImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExportedInterface()
     * @generated
     */
    EClass TEXPORTED_INTERFACE = eINSTANCE.getTExportedInterface();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXPORTED_INTERFACE__OPERATION = eINSTANCE.getTExportedInterface_Operation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXPORTED_INTERFACE__NAME = eINSTANCE.getTExportedInterface_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TExportedOperationImpl <em>TExported Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TExportedOperationImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExportedOperation()
     * @generated
     */
    EClass TEXPORTED_OPERATION = eINSTANCE.getTExportedOperation();

    /**
     * The meta object literal for the '<em><b>Node Operation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXPORTED_OPERATION__NODE_OPERATION = eINSTANCE.getTExportedOperation_NodeOperation();

    /**
     * The meta object literal for the '<em><b>Relationship Operation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXPORTED_OPERATION__RELATIONSHIP_OPERATION = eINSTANCE.getTExportedOperation_RelationshipOperation();

    /**
     * The meta object literal for the '<em><b>Plan</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXPORTED_OPERATION__PLAN = eINSTANCE.getTExportedOperation_Plan();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXPORTED_OPERATION__NAME = eINSTANCE.getTExportedOperation_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TExtensibleElementsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtensibleElements()
     * @generated
     */
    EClass TEXTENSIBLE_ELEMENTS = eINSTANCE.getTExtensibleElements();

    /**
     * The meta object literal for the '<em><b>Documentation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXTENSIBLE_ELEMENTS__DOCUMENTATION = eINSTANCE.getTExtensibleElements_Documentation();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXTENSIBLE_ELEMENTS__ANY = eINSTANCE.getTExtensibleElements_Any();

    /**
     * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = eINSTANCE.getTExtensibleElements_AnyAttribute();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TExtensionImpl <em>TExtension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TExtensionImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtension()
     * @generated
     */
    EClass TEXTENSION = eINSTANCE.getTExtension();

    /**
     * The meta object literal for the '<em><b>Must Understand</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXTENSION__MUST_UNDERSTAND = eINSTANCE.getTExtension_MustUnderstand();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXTENSION__NAMESPACE = eINSTANCE.getTExtension_Namespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TExtensionsImpl <em>TExtensions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TExtensionsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTExtensions()
     * @generated
     */
    EClass TEXTENSIONS = eINSTANCE.getTExtensions();

    /**
     * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEXTENSIONS__EXTENSION = eINSTANCE.getTExtensions_Extension();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TImplementationArtifactImpl <em>TImplementation Artifact</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TImplementationArtifactImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImplementationArtifact()
     * @generated
     */
    EClass TIMPLEMENTATION_ARTIFACT = eINSTANCE.getTImplementationArtifact();

    /**
     * The meta object literal for the '<em><b>Artifact Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPLEMENTATION_ARTIFACT__ARTIFACT_REF = eINSTANCE.getTImplementationArtifact_ArtifactRef();

    /**
     * The meta object literal for the '<em><b>Artifact Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPLEMENTATION_ARTIFACT__ARTIFACT_TYPE = eINSTANCE.getTImplementationArtifact_ArtifactType();

    /**
     * The meta object literal for the '<em><b>Interface Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPLEMENTATION_ARTIFACT__INTERFACE_NAME = eINSTANCE.getTImplementationArtifact_InterfaceName();

    /**
     * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPLEMENTATION_ARTIFACT__OPERATION_NAME = eINSTANCE.getTImplementationArtifact_OperationName();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TImplementationArtifactsImpl <em>TImplementation Artifacts</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TImplementationArtifactsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImplementationArtifacts()
     * @generated
     */
    EClass TIMPLEMENTATION_ARTIFACTS = eINSTANCE.getTImplementationArtifacts();

    /**
     * The meta object literal for the '<em><b>Implementation Artifact</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMPLEMENTATION_ARTIFACTS__IMPLEMENTATION_ARTIFACT = eINSTANCE.getTImplementationArtifacts_ImplementationArtifact();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TImportImpl <em>TImport</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TImportImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTImport()
     * @generated
     */
    EClass TIMPORT = eINSTANCE.getTImport();

    /**
     * The meta object literal for the '<em><b>Import Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPORT__IMPORT_TYPE = eINSTANCE.getTImport_ImportType();

    /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPORT__LOCATION = eINSTANCE.getTImport_Location();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMPORT__NAMESPACE = eINSTANCE.getTImport_Namespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TInterfaceImpl <em>TInterface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TInterfaceImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTInterface()
     * @generated
     */
    EClass TINTERFACE = eINSTANCE.getTInterface();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TINTERFACE__OPERATION = eINSTANCE.getTInterface_Operation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TINTERFACE__NAME = eINSTANCE.getTInterface_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TNodeTemplateImpl <em>TNode Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TNodeTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeTemplate()
     * @generated
     */
    EClass TNODE_TEMPLATE = eINSTANCE.getTNodeTemplate();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE__REQUIREMENTS = eINSTANCE.getTNodeTemplate_Requirements();

    /**
     * The meta object literal for the '<em><b>Capabilities</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE__CAPABILITIES = eINSTANCE.getTNodeTemplate_Capabilities();

    /**
     * The meta object literal for the '<em><b>Policies</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE__POLICIES = eINSTANCE.getTNodeTemplate_Policies();

    /**
     * The meta object literal for the '<em><b>Deployment Artifacts</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS = eINSTANCE.getTNodeTemplate_DeploymentArtifacts();

    /**
     * The meta object literal for the '<em><b>Max Instances</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE__MAX_INSTANCES = eINSTANCE.getTNodeTemplate_MaxInstances();

    /**
     * The meta object literal for the '<em><b>Min Instances</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE__MIN_INSTANCES = eINSTANCE.getTNodeTemplate_MinInstances();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TEMPLATE__NAME = eINSTANCE.getTNodeTemplate_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TNodeTypeImpl <em>TNode Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TNodeTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeType()
     * @generated
     */
    EClass TNODE_TYPE = eINSTANCE.getTNodeType();

    /**
     * The meta object literal for the '<em><b>Requirement Definitions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE__REQUIREMENT_DEFINITIONS = eINSTANCE.getTNodeType_RequirementDefinitions();

    /**
     * The meta object literal for the '<em><b>Capability Definitions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE__CAPABILITY_DEFINITIONS = eINSTANCE.getTNodeType_CapabilityDefinitions();

    /**
     * The meta object literal for the '<em><b>Instance States</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE__INSTANCE_STATES = eINSTANCE.getTNodeType_InstanceStates();

    /**
     * The meta object literal for the '<em><b>Interfaces</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE__INTERFACES = eINSTANCE.getTNodeType_Interfaces();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TNodeTypeImplementationImpl <em>TNode Type Implementation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TNodeTypeImplementationImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTNodeTypeImplementation()
     * @generated
     */
    EClass TNODE_TYPE_IMPLEMENTATION = eINSTANCE.getTNodeTypeImplementation();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE_IMPLEMENTATION__TAGS = eINSTANCE.getTNodeTypeImplementation_Tags();

    /**
     * The meta object literal for the '<em><b>Derived From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE_IMPLEMENTATION__DERIVED_FROM = eINSTANCE.getTNodeTypeImplementation_DerivedFrom();

    /**
     * The meta object literal for the '<em><b>Required Container Features</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES = eINSTANCE.getTNodeTypeImplementation_RequiredContainerFeatures();

    /**
     * The meta object literal for the '<em><b>Implementation Artifacts</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS = eINSTANCE.getTNodeTypeImplementation_ImplementationArtifacts();

    /**
     * The meta object literal for the '<em><b>Deployment Artifacts</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TNODE_TYPE_IMPLEMENTATION__DEPLOYMENT_ARTIFACTS = eINSTANCE.getTNodeTypeImplementation_DeploymentArtifacts();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TYPE_IMPLEMENTATION__ABSTRACT = eINSTANCE.getTNodeTypeImplementation_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TYPE_IMPLEMENTATION__FINAL = eINSTANCE.getTNodeTypeImplementation_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TYPE_IMPLEMENTATION__NAME = eINSTANCE.getTNodeTypeImplementation_Name();

    /**
     * The meta object literal for the '<em><b>Node Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TYPE_IMPLEMENTATION__NODE_TYPE = eINSTANCE.getTNodeTypeImplementation_NodeType();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TNODE_TYPE_IMPLEMENTATION__TARGET_NAMESPACE = eINSTANCE.getTNodeTypeImplementation_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TOperationImpl <em>TOperation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TOperationImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTOperation()
     * @generated
     */
    EClass TOPERATION = eINSTANCE.getTOperation();

    /**
     * The meta object literal for the '<em><b>Input Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPERATION__INPUT_PARAMETERS = eINSTANCE.getTOperation_InputParameters();

    /**
     * The meta object literal for the '<em><b>Output Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TOPERATION__OUTPUT_PARAMETERS = eINSTANCE.getTOperation_OutputParameters();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TOPERATION__NAME = eINSTANCE.getTOperation_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TParameterImpl <em>TParameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TParameterImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTParameter()
     * @generated
     */
    EClass TPARAMETER = eINSTANCE.getTParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPARAMETER__NAME = eINSTANCE.getTParameter_Name();

    /**
     * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPARAMETER__REQUIRED = eINSTANCE.getTParameter_Required();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPARAMETER__TYPE = eINSTANCE.getTParameter_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPlanImpl <em>TPlan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPlanImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPlan()
     * @generated
     */
    EClass TPLAN = eINSTANCE.getTPlan();

    /**
     * The meta object literal for the '<em><b>Precondition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLAN__PRECONDITION = eINSTANCE.getTPlan_Precondition();

    /**
     * The meta object literal for the '<em><b>Input Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLAN__INPUT_PARAMETERS = eINSTANCE.getTPlan_InputParameters();

    /**
     * The meta object literal for the '<em><b>Output Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLAN__OUTPUT_PARAMETERS = eINSTANCE.getTPlan_OutputParameters();

    /**
     * The meta object literal for the '<em><b>Plan Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLAN__PLAN_MODEL = eINSTANCE.getTPlan_PlanModel();

    /**
     * The meta object literal for the '<em><b>Plan Model Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLAN__PLAN_MODEL_REFERENCE = eINSTANCE.getTPlan_PlanModelReference();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPLAN__ID = eINSTANCE.getTPlan_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPLAN__NAME = eINSTANCE.getTPlan_Name();

    /**
     * The meta object literal for the '<em><b>Plan Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPLAN__PLAN_LANGUAGE = eINSTANCE.getTPlan_PlanLanguage();

    /**
     * The meta object literal for the '<em><b>Plan Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPLAN__PLAN_TYPE = eINSTANCE.getTPlan_PlanType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPlansImpl <em>TPlans</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPlansImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPlans()
     * @generated
     */
    EClass TPLANS = eINSTANCE.getTPlans();

    /**
     * The meta object literal for the '<em><b>Plan</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPLANS__PLAN = eINSTANCE.getTPlans_Plan();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPLANS__TARGET_NAMESPACE = eINSTANCE.getTPlans_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPolicyImpl <em>TPolicy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPolicyImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicy()
     * @generated
     */
    EClass TPOLICY = eINSTANCE.getTPolicy();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPOLICY__NAME = eINSTANCE.getTPolicy_Name();

    /**
     * The meta object literal for the '<em><b>Policy Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPOLICY__POLICY_REF = eINSTANCE.getTPolicy_PolicyRef();

    /**
     * The meta object literal for the '<em><b>Policy Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPOLICY__POLICY_TYPE = eINSTANCE.getTPolicy_PolicyType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPolicyTemplateImpl <em>TPolicy Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPolicyTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicyTemplate()
     * @generated
     */
    EClass TPOLICY_TEMPLATE = eINSTANCE.getTPolicyTemplate();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPOLICY_TEMPLATE__NAME = eINSTANCE.getTPolicyTemplate_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPolicyTypeImpl <em>TPolicy Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPolicyTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPolicyType()
     * @generated
     */
    EClass TPOLICY_TYPE = eINSTANCE.getTPolicyType();

    /**
     * The meta object literal for the '<em><b>Applies To</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TPOLICY_TYPE__APPLIES_TO = eINSTANCE.getTPolicyType_AppliesTo();

    /**
     * The meta object literal for the '<em><b>Policy Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPOLICY_TYPE__POLICY_LANGUAGE = eINSTANCE.getTPolicyType_PolicyLanguage();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPropertyConstraintImpl <em>TProperty Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPropertyConstraintImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPropertyConstraint()
     * @generated
     */
    EClass TPROPERTY_CONSTRAINT = eINSTANCE.getTPropertyConstraint();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPROPERTY_CONSTRAINT__PROPERTY = eINSTANCE.getTPropertyConstraint_Property();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TPropertyMappingImpl <em>TProperty Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TPropertyMappingImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTPropertyMapping()
     * @generated
     */
    EClass TPROPERTY_MAPPING = eINSTANCE.getTPropertyMapping();

    /**
     * The meta object literal for the '<em><b>Service Template Property Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPROPERTY_MAPPING__SERVICE_TEMPLATE_PROPERTY_REF = eINSTANCE.getTPropertyMapping_ServiceTemplatePropertyRef();

    /**
     * The meta object literal for the '<em><b>Target Object Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPROPERTY_MAPPING__TARGET_OBJECT_REF = eINSTANCE.getTPropertyMapping_TargetObjectRef();

    /**
     * The meta object literal for the '<em><b>Target Property Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TPROPERTY_MAPPING__TARGET_PROPERTY_REF = eINSTANCE.getTPropertyMapping_TargetPropertyRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTemplateImpl <em>TRelationship Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRelationshipTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipTemplate()
     * @generated
     */
    EClass TRELATIONSHIP_TEMPLATE = eINSTANCE.getTRelationshipTemplate();

    /**
     * The meta object literal for the '<em><b>Source Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TEMPLATE__SOURCE_ELEMENT = eINSTANCE.getTRelationshipTemplate_SourceElement();

    /**
     * The meta object literal for the '<em><b>Target Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TEMPLATE__TARGET_ELEMENT = eINSTANCE.getTRelationshipTemplate_TargetElement();

    /**
     * The meta object literal for the '<em><b>Relationship Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TEMPLATE__RELATIONSHIP_CONSTRAINTS = eINSTANCE.getTRelationshipTemplate_RelationshipConstraints();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TEMPLATE__NAME = eINSTANCE.getTRelationshipTemplate_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTypeImpl <em>TRelationship Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRelationshipTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipType()
     * @generated
     */
    EClass TRELATIONSHIP_TYPE = eINSTANCE.getTRelationshipType();

    /**
     * The meta object literal for the '<em><b>Instance States</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE__INSTANCE_STATES = eINSTANCE.getTRelationshipType_InstanceStates();

    /**
     * The meta object literal for the '<em><b>Source Interfaces</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE__SOURCE_INTERFACES = eINSTANCE.getTRelationshipType_SourceInterfaces();

    /**
     * The meta object literal for the '<em><b>Target Interfaces</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE__TARGET_INTERFACES = eINSTANCE.getTRelationshipType_TargetInterfaces();

    /**
     * The meta object literal for the '<em><b>Valid Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE__VALID_SOURCE = eINSTANCE.getTRelationshipType_ValidSource();

    /**
     * The meta object literal for the '<em><b>Valid Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE__VALID_TARGET = eINSTANCE.getTRelationshipType_ValidTarget();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRelationshipTypeImplementationImpl <em>TRelationship Type Implementation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRelationshipTypeImplementationImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRelationshipTypeImplementation()
     * @generated
     */
    EClass TRELATIONSHIP_TYPE_IMPLEMENTATION = eINSTANCE.getTRelationshipTypeImplementation();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE_IMPLEMENTATION__TAGS = eINSTANCE.getTRelationshipTypeImplementation_Tags();

    /**
     * The meta object literal for the '<em><b>Derived From</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE_IMPLEMENTATION__DERIVED_FROM = eINSTANCE.getTRelationshipTypeImplementation_DerivedFrom();

    /**
     * The meta object literal for the '<em><b>Required Container Features</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE_IMPLEMENTATION__REQUIRED_CONTAINER_FEATURES = eINSTANCE.getTRelationshipTypeImplementation_RequiredContainerFeatures();

    /**
     * The meta object literal for the '<em><b>Implementation Artifacts</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRELATIONSHIP_TYPE_IMPLEMENTATION__IMPLEMENTATION_ARTIFACTS = eINSTANCE.getTRelationshipTypeImplementation_ImplementationArtifacts();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TYPE_IMPLEMENTATION__ABSTRACT = eINSTANCE.getTRelationshipTypeImplementation_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TYPE_IMPLEMENTATION__FINAL = eINSTANCE.getTRelationshipTypeImplementation_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TYPE_IMPLEMENTATION__NAME = eINSTANCE.getTRelationshipTypeImplementation_Name();

    /**
     * The meta object literal for the '<em><b>Relationship Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TYPE_IMPLEMENTATION__RELATIONSHIP_TYPE = eINSTANCE.getTRelationshipTypeImplementation_RelationshipType();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRELATIONSHIP_TYPE_IMPLEMENTATION__TARGET_NAMESPACE = eINSTANCE.getTRelationshipTypeImplementation_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequiredContainerFeatureImpl <em>TRequired Container Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequiredContainerFeatureImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequiredContainerFeature()
     * @generated
     */
    EClass TREQUIRED_CONTAINER_FEATURE = eINSTANCE.getTRequiredContainerFeature();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIRED_CONTAINER_FEATURE__FEATURE = eINSTANCE.getTRequiredContainerFeature_Feature();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequiredContainerFeaturesImpl <em>TRequired Container Features</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequiredContainerFeaturesImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequiredContainerFeatures()
     * @generated
     */
    EClass TREQUIRED_CONTAINER_FEATURES = eINSTANCE.getTRequiredContainerFeatures();

    /**
     * The meta object literal for the '<em><b>Required Container Feature</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREQUIRED_CONTAINER_FEATURES__REQUIRED_CONTAINER_FEATURE = eINSTANCE.getTRequiredContainerFeatures_RequiredContainerFeature();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequirementImpl <em>TRequirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequirementImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirement()
     * @generated
     */
    EClass TREQUIREMENT = eINSTANCE.getTRequirement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT__NAME = eINSTANCE.getTRequirement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequirementDefinitionImpl <em>TRequirement Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequirementDefinitionImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementDefinition()
     * @generated
     */
    EClass TREQUIREMENT_DEFINITION = eINSTANCE.getTRequirementDefinition();

    /**
     * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREQUIREMENT_DEFINITION__CONSTRAINTS = eINSTANCE.getTRequirementDefinition_Constraints();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_DEFINITION__LOWER_BOUND = eINSTANCE.getTRequirementDefinition_LowerBound();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_DEFINITION__NAME = eINSTANCE.getTRequirementDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Requirement Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_DEFINITION__REQUIREMENT_TYPE = eINSTANCE.getTRequirementDefinition_RequirementType();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_DEFINITION__UPPER_BOUND = eINSTANCE.getTRequirementDefinition_UpperBound();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequirementRefImpl <em>TRequirement Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequirementRefImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementRef()
     * @generated
     */
    EClass TREQUIREMENT_REF = eINSTANCE.getTRequirementRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_REF__NAME = eINSTANCE.getTRequirementRef_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_REF__REF = eINSTANCE.getTRequirementRef_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TRequirementTypeImpl <em>TRequirement Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TRequirementTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTRequirementType()
     * @generated
     */
    EClass TREQUIREMENT_TYPE = eINSTANCE.getTRequirementType();

    /**
     * The meta object literal for the '<em><b>Required Capability Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREQUIREMENT_TYPE__REQUIRED_CAPABILITY_TYPE = eINSTANCE.getTRequirementType_RequiredCapabilityType();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TServiceTemplateImpl <em>TService Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TServiceTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTServiceTemplate()
     * @generated
     */
    EClass TSERVICE_TEMPLATE = eINSTANCE.getTServiceTemplate();

    /**
     * The meta object literal for the '<em><b>Tags</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSERVICE_TEMPLATE__TAGS = eINSTANCE.getTServiceTemplate_Tags();

    /**
     * The meta object literal for the '<em><b>Boundary Definitions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSERVICE_TEMPLATE__BOUNDARY_DEFINITIONS = eINSTANCE.getTServiceTemplate_BoundaryDefinitions();

    /**
     * The meta object literal for the '<em><b>Topology Template</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSERVICE_TEMPLATE__TOPOLOGY_TEMPLATE = eINSTANCE.getTServiceTemplate_TopologyTemplate();

    /**
     * The meta object literal for the '<em><b>Plans</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TSERVICE_TEMPLATE__PLANS = eINSTANCE.getTServiceTemplate_Plans();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSERVICE_TEMPLATE__ID = eINSTANCE.getTServiceTemplate_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSERVICE_TEMPLATE__NAME = eINSTANCE.getTServiceTemplate_Name();

    /**
     * The meta object literal for the '<em><b>Substitutable Node Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSERVICE_TEMPLATE__SUBSTITUTABLE_NODE_TYPE = eINSTANCE.getTServiceTemplate_SubstitutableNodeType();

    /**
     * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TSERVICE_TEMPLATE__TARGET_NAMESPACE = eINSTANCE.getTServiceTemplate_TargetNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TTagImpl <em>TTag</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TTagImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTag()
     * @generated
     */
    EClass TTAG = eINSTANCE.getTTag();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TTAG__NAME = eINSTANCE.getTTag_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TTAG__VALUE = eINSTANCE.getTTag_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TTagsImpl <em>TTags</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TTagsImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTags()
     * @generated
     */
    EClass TTAGS = eINSTANCE.getTTags();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTAGS__TAG = eINSTANCE.getTTags_Tag();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TTopologyElementInstanceStatesImpl <em>TTopology Element Instance States</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TTopologyElementInstanceStatesImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTopologyElementInstanceStates()
     * @generated
     */
    EClass TTOPOLOGY_ELEMENT_INSTANCE_STATES = eINSTANCE.getTTopologyElementInstanceStates();

    /**
     * The meta object literal for the '<em><b>Instance State</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTOPOLOGY_ELEMENT_INSTANCE_STATES__INSTANCE_STATE = eINSTANCE.getTTopologyElementInstanceStates_InstanceState();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TTopologyTemplateImpl <em>TTopology Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TTopologyTemplateImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTTopologyTemplate()
     * @generated
     */
    EClass TTOPOLOGY_TEMPLATE = eINSTANCE.getTTopologyTemplate();

    /**
     * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TTOPOLOGY_TEMPLATE__GROUP = eINSTANCE.getTTopologyTemplate_Group();

    /**
     * The meta object literal for the '<em><b>Node Template</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTOPOLOGY_TEMPLATE__NODE_TEMPLATE = eINSTANCE.getTTopologyTemplate_NodeTemplate();

    /**
     * The meta object literal for the '<em><b>Relationship Template</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE = eINSTANCE.getTTopologyTemplate_RelationshipTemplate();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.TypesTypeImpl <em>Types Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.TypesTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTypesType()
     * @generated
     */
    EClass TYPES_TYPE = eINSTANCE.getTypesType();

    /**
     * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPES_TYPE__ANY = eINSTANCE.getTypesType_Any();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ValidSourceTypeImpl <em>Valid Source Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ValidSourceTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getValidSourceType()
     * @generated
     */
    EClass VALID_SOURCE_TYPE = eINSTANCE.getValidSourceType();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALID_SOURCE_TYPE__TYPE_REF = eINSTANCE.getValidSourceType_TypeRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.impl.ValidTargetTypeImpl <em>Valid Target Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.impl.ValidTargetTypeImpl
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getValidTargetType()
     * @generated
     */
    EClass VALID_TARGET_TYPE = eINSTANCE.getValidTargetType();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALID_TARGET_TYPE__TYPE_REF = eINSTANCE.getValidTargetType_TypeRef();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.MaxInstancesTypeMember1 <em>Max Instances Type Member1</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember1()
     * @generated
     */
    EEnum MAX_INSTANCES_TYPE_MEMBER1 = eINSTANCE.getMaxInstancesTypeMember1();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.TBoolean <em>TBoolean</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.TBoolean
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBoolean()
     * @generated
     */
    EEnum TBOOLEAN = eINSTANCE.getTBoolean();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.UpperBoundTypeMember1 <em>Upper Bound Type Member1</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1()
     * @generated
     */
    EEnum UPPER_BOUND_TYPE_MEMBER1 = eINSTANCE.getUpperBoundTypeMember1();

    /**
     * The meta object literal for the '{@link org.eclipse.camf.tosca.UpperBoundTypeMember11 <em>Upper Bound Type Member11</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember11()
     * @generated
     */
    EEnum UPPER_BOUND_TYPE_MEMBER11 = eINSTANCE.getUpperBoundTypeMember11();

    /**
     * The meta object literal for the '<em>Imported URI</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getImportedURI()
     * @generated
     */
    EDataType IMPORTED_URI = eINSTANCE.getImportedURI();

    /**
     * The meta object literal for the '<em>Max Instances Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Object
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesType()
     * @generated
     */
    EDataType MAX_INSTANCES_TYPE = eINSTANCE.getMaxInstancesType();

    /**
     * The meta object literal for the '<em>Max Instances Type Member0</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.math.BigInteger
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember0()
     * @generated
     */
    EDataType MAX_INSTANCES_TYPE_MEMBER0 = eINSTANCE.getMaxInstancesTypeMember0();

    /**
     * The meta object literal for the '<em>Max Instances Type Member1 Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.MaxInstancesTypeMember1
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getMaxInstancesTypeMember1Object()
     * @generated
     */
    EDataType MAX_INSTANCES_TYPE_MEMBER1_OBJECT = eINSTANCE.getMaxInstancesTypeMember1Object();

    /**
     * The meta object literal for the '<em>TBoolean Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.TBoolean
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getTBooleanObject()
     * @generated
     */
    EDataType TBOOLEAN_OBJECT = eINSTANCE.getTBooleanObject();

    /**
     * The meta object literal for the '<em>Upper Bound Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Object
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundType()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE = eINSTANCE.getUpperBoundType();

    /**
     * The meta object literal for the '<em>Upper Bound Type1</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Object
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundType1()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE1 = eINSTANCE.getUpperBoundType1();

    /**
     * The meta object literal for the '<em>Upper Bound Type Member0</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.math.BigInteger
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember0()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE_MEMBER0 = eINSTANCE.getUpperBoundTypeMember0();

    /**
     * The meta object literal for the '<em>Upper Bound Type Member01</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.math.BigInteger
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember01()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE_MEMBER01 = eINSTANCE.getUpperBoundTypeMember01();

    /**
     * The meta object literal for the '<em>Upper Bound Type Member1 Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.UpperBoundTypeMember1
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1Object()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE_MEMBER1_OBJECT = eINSTANCE.getUpperBoundTypeMember1Object();

    /**
     * The meta object literal for the '<em>Upper Bound Type Member1 Object1</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.camf.tosca.UpperBoundTypeMember11
     * @see org.eclipse.camf.tosca.impl.ToscaPackageImpl#getUpperBoundTypeMember1Object1()
     * @generated
     */
    EDataType UPPER_BOUND_TYPE_MEMBER1_OBJECT1 = eINSTANCE.getUpperBoundTypeMember1Object1();

  }

} //ToscaPackage
