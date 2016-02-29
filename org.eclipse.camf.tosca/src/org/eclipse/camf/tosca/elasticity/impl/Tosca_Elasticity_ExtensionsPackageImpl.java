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
package org.eclipse.camf.tosca.elasticity.impl;

import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.camf.tosca.elasticity.DocumentRoot;
import org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.MonitoringProbesType1;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.ServicePropertiesType;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.camf.tosca.elasticity.TMonitoringProbe;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.example.sybl.SyblPackage;
import org.example.sybl.impl.SyblPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_Elasticity_ExtensionsPackageImpl extends EPackageImpl implements Tosca_Elasticity_ExtensionsPackage
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass documentRootEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass imageArtifactPropertiesTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass monitoringProbesType1EClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass nodePropertiesTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass scriptArtifactPropertiesTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass servicePropertiesTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass tBoundaryDefinitionsExtensionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass tMonitoringProbeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass tNodeTemplateExtensionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass tServiceTemplateExtensionEClass = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private Tosca_Elasticity_ExtensionsPackageImpl()
  {
		super(eNS_URI, Tosca_Elasticity_ExtensionsFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Tosca_Elasticity_ExtensionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static Tosca_Elasticity_ExtensionsPackage init()
  {
		if (isInited) return (Tosca_Elasticity_ExtensionsPackage)EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI);

		// Obtain or create and register package
		Tosca_Elasticity_ExtensionsPackageImpl theTosca_Elasticity_ExtensionsPackage = (Tosca_Elasticity_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tosca_Elasticity_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tosca_Elasticity_ExtensionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ToscaPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SyblPackageImpl theSyblPackage = (SyblPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SyblPackage.eNS_URI) instanceof SyblPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SyblPackage.eNS_URI) : SyblPackage.eINSTANCE);

		// Create package meta-data objects
		theTosca_Elasticity_ExtensionsPackage.createPackageContents();
		theSyblPackage.createPackageContents();

		// Initialize created meta-data
		theTosca_Elasticity_ExtensionsPackage.initializePackageContents();
		theSyblPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTosca_Elasticity_ExtensionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Tosca_Elasticity_ExtensionsPackage.eNS_URI, theTosca_Elasticity_ExtensionsPackage);
		return theTosca_Elasticity_ExtensionsPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDocumentRoot()
  {
		return documentRootEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDocumentRoot_Mixed()
  {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_XMLNSPrefixMap()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_XSISchemaLocation()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_ImageArtifactProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_NodeProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_ScriptArtifactProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_ServiceProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getImageArtifactPropertiesType()
  {
		return imageArtifactPropertiesTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getImageArtifactPropertiesType_Description()
  {
		return (EAttribute)imageArtifactPropertiesTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getImageArtifactPropertiesType_Id()
  {
		return (EAttribute)imageArtifactPropertiesTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMonitoringProbesType1()
  {
		return monitoringProbesType1EClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMonitoringProbesType1_MonitoringProbes()
  {
		return (EReference)monitoringProbesType1EClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getNodePropertiesType()
  {
		return nodePropertiesTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getNodePropertiesType_Flavor()
  {
		return (EAttribute)nodePropertiesTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getScriptArtifactPropertiesType()
  {
		return scriptArtifactPropertiesTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getScriptArtifactPropertiesType_Language()
  {
		return (EAttribute)scriptArtifactPropertiesTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getServicePropertiesType()
  {
		return servicePropertiesTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServicePropertiesType_Version()
  {
		return (EAttribute)servicePropertiesTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServicePropertiesType_HostingEnvironment() {
		return (EAttribute)servicePropertiesTypeEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTBoundaryDefinitionsExtension()
  {
		return tBoundaryDefinitionsExtensionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTBoundaryDefinitionsExtension_MonitoringProbes()
  {
		return (EReference)tBoundaryDefinitionsExtensionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTMonitoringProbe()
  {
		return tMonitoringProbeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTMonitoringProbe_Name()
  {
		return (EAttribute)tMonitoringProbeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTNodeTemplateExtension()
  {
		return tNodeTemplateExtensionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTNodeTemplateExtension_Height()
  {
		return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTNodeTemplateExtension_InitInstances()
  {
		return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTNodeTemplateExtension_Width()
  {
		return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTNodeTemplateExtension_X()
  {
		return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTNodeTemplateExtension_Y()
  {
		return (EAttribute)tNodeTemplateExtensionEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTServiceTemplateExtension()
  {
		return tServiceTemplateExtensionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTServiceTemplateExtension_Height()
  {
		return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTServiceTemplateExtension_Width()
  {
		return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTServiceTemplateExtension_X()
  {
		return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTServiceTemplateExtension_Y()
  {
		return (EAttribute)tServiceTemplateExtensionEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsFactory getTosca_Elasticity_ExtensionsFactory()
  {
		return (Tosca_Elasticity_ExtensionsFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents()
  {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__NODE_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SERVICE_PROPERTIES);

		imageArtifactPropertiesTypeEClass = createEClass(IMAGE_ARTIFACT_PROPERTIES_TYPE);
		createEAttribute(imageArtifactPropertiesTypeEClass, IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION);
		createEAttribute(imageArtifactPropertiesTypeEClass, IMAGE_ARTIFACT_PROPERTIES_TYPE__ID);

		monitoringProbesType1EClass = createEClass(MONITORING_PROBES_TYPE1);
		createEReference(monitoringProbesType1EClass, MONITORING_PROBES_TYPE1__MONITORING_PROBES);

		nodePropertiesTypeEClass = createEClass(NODE_PROPERTIES_TYPE);
		createEAttribute(nodePropertiesTypeEClass, NODE_PROPERTIES_TYPE__FLAVOR);

		scriptArtifactPropertiesTypeEClass = createEClass(SCRIPT_ARTIFACT_PROPERTIES_TYPE);
		createEAttribute(scriptArtifactPropertiesTypeEClass, SCRIPT_ARTIFACT_PROPERTIES_TYPE__LANGUAGE);

		servicePropertiesTypeEClass = createEClass(SERVICE_PROPERTIES_TYPE);
		createEAttribute(servicePropertiesTypeEClass, SERVICE_PROPERTIES_TYPE__VERSION);
		createEAttribute(servicePropertiesTypeEClass, SERVICE_PROPERTIES_TYPE__HOSTING_ENVIRONMENT);

		tBoundaryDefinitionsExtensionEClass = createEClass(TBOUNDARY_DEFINITIONS_EXTENSION);
		createEReference(tBoundaryDefinitionsExtensionEClass, TBOUNDARY_DEFINITIONS_EXTENSION__MONITORING_PROBES);

		tMonitoringProbeEClass = createEClass(TMONITORING_PROBE);
		createEAttribute(tMonitoringProbeEClass, TMONITORING_PROBE__NAME);

		tNodeTemplateExtensionEClass = createEClass(TNODE_TEMPLATE_EXTENSION);
		createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__HEIGHT);
		createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES);
		createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__WIDTH);
		createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__X);
		createEAttribute(tNodeTemplateExtensionEClass, TNODE_TEMPLATE_EXTENSION__Y);

		tServiceTemplateExtensionEClass = createEClass(TSERVICE_TEMPLATE_EXTENSION);
		createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__HEIGHT);
		createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__WIDTH);
		createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__X);
		createEAttribute(tServiceTemplateExtensionEClass, TSERVICE_TEMPLATE_EXTENSION__Y);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents()
  {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		ToscaPackage theToscaPackage = (ToscaPackage)EPackage.Registry.INSTANCE.getEPackage(ToscaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tBoundaryDefinitionsExtensionEClass.getESuperTypes().add(theToscaPackage.getTBoundaryDefinitions());
		tMonitoringProbeEClass.getESuperTypes().add(theToscaPackage.getTExtensibleElements());
		tNodeTemplateExtensionEClass.getESuperTypes().add(theToscaPackage.getTNodeTemplate());
		tServiceTemplateExtensionEClass.getESuperTypes().add(theToscaPackage.getTServiceTemplate());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ImageArtifactProperties(), this.getImageArtifactPropertiesType(), null, "imageArtifactProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_NodeProperties(), this.getNodePropertiesType(), null, "nodeProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ScriptArtifactProperties(), this.getScriptArtifactPropertiesType(), null, "scriptArtifactProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ServiceProperties(), this.getServicePropertiesType(), null, "serviceProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(imageArtifactPropertiesTypeEClass, ImageArtifactPropertiesType.class, "ImageArtifactPropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageArtifactPropertiesType_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, ImageArtifactPropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageArtifactPropertiesType_Id(), theXMLTypePackage.getString(), "id", null, 1, 1, ImageArtifactPropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(monitoringProbesType1EClass, MonitoringProbesType1.class, "MonitoringProbesType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMonitoringProbesType1_MonitoringProbes(), this.getTMonitoringProbe(), null, "monitoringProbes", null, 1, -1, MonitoringProbesType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodePropertiesTypeEClass, NodePropertiesType.class, "NodePropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNodePropertiesType_Flavor(), theXMLTypePackage.getString(), "flavor", null, 1, 1, NodePropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scriptArtifactPropertiesTypeEClass, ScriptArtifactPropertiesType.class, "ScriptArtifactPropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptArtifactPropertiesType_Language(), theXMLTypePackage.getString(), "language", null, 1, 1, ScriptArtifactPropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicePropertiesTypeEClass, ServicePropertiesType.class, "ServicePropertiesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServicePropertiesType_Version(), theXMLTypePackage.getString(), "version", null, 1, 1, ServicePropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServicePropertiesType_HostingEnvironment(), theXMLTypePackage.getString(), "hostingEnvironment", null, 1, -1, ServicePropertiesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBoundaryDefinitionsExtensionEClass, TBoundaryDefinitionsExtension.class, "TBoundaryDefinitionsExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBoundaryDefinitionsExtension_MonitoringProbes(), this.getMonitoringProbesType1(), null, "monitoringProbes", null, 0, 1, TBoundaryDefinitionsExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tMonitoringProbeEClass, TMonitoringProbe.class, "TMonitoringProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTMonitoringProbe_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TMonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tNodeTemplateExtensionEClass, TNodeTemplateExtension.class, "TNodeTemplateExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTNodeTemplateExtension_Height(), theXMLTypePackage.getInt(), "height", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplateExtension_InitInstances(), theXMLTypePackage.getInt(), "initInstances", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplateExtension_Width(), theXMLTypePackage.getInt(), "width", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplateExtension_X(), theXMLTypePackage.getInt(), "x", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTNodeTemplateExtension_Y(), theXMLTypePackage.getInt(), "y", null, 0, 1, TNodeTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tServiceTemplateExtensionEClass, TServiceTemplateExtension.class, "TServiceTemplateExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTServiceTemplateExtension_Height(), theXMLTypePackage.getInt(), "height", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplateExtension_Width(), theXMLTypePackage.getInt(), "width", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplateExtension_X(), theXMLTypePackage.getInt(), "x", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTServiceTemplateExtension_Y(), theXMLTypePackage.getInt(), "y", null, 0, 1, TServiceTemplateExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

  /**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createExtendedMetaDataAnnotations()
  {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_ImageArtifactProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ImageArtifactProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_NodeProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_ScriptArtifactProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ScriptArtifactProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_ServiceProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (imageArtifactPropertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ImageArtifactPropertiesType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getImageArtifactPropertiesType_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Description",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getImageArtifactPropertiesType_Id(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Id",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (monitoringProbesType1EClass, 
		   source, 
		   new String[] {
			 "name", "MonitoringProbesType1",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getMonitoringProbesType1_MonitoringProbes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "monitoringProbes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (nodePropertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NodePropertiesType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getNodePropertiesType_Flavor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Flavor",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (scriptArtifactPropertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ScriptArtifactPropertiesType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getScriptArtifactPropertiesType_Language(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Language",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (servicePropertiesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ServicePropertiesType",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getServicePropertiesType_Version(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Version",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getServicePropertiesType_HostingEnvironment(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HostingEnvironment",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tBoundaryDefinitionsExtensionEClass, 
		   source, 
		   new String[] {
			 "name", "TBoundaryDefinitionsExtension",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTBoundaryDefinitionsExtension_MonitoringProbes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "monitoringProbes",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (tMonitoringProbeEClass, 
		   source, 
		   new String[] {
			 "name", "TMonitoringProbe",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTMonitoringProbe_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });	
		addAnnotation
		  (tNodeTemplateExtensionEClass, 
		   source, 
		   new String[] {
			 "name", "TNodeTemplateExtension",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTNodeTemplateExtension_Height(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "height"
		   });	
		addAnnotation
		  (getTNodeTemplateExtension_InitInstances(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "initInstances"
		   });	
		addAnnotation
		  (getTNodeTemplateExtension_Width(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "width"
		   });	
		addAnnotation
		  (getTNodeTemplateExtension_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x"
		   });	
		addAnnotation
		  (getTNodeTemplateExtension_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y"
		   });	
		addAnnotation
		  (tServiceTemplateExtensionEClass, 
		   source, 
		   new String[] {
			 "name", "TServiceTemplateExtension",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getTServiceTemplateExtension_Height(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "height"
		   });	
		addAnnotation
		  (getTServiceTemplateExtension_Width(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "width"
		   });	
		addAnnotation
		  (getTServiceTemplateExtension_X(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "x"
		   });	
		addAnnotation
		  (getTServiceTemplateExtension_Y(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "y"
		   });
	}

} //Tosca_Elasticity_ExtensionsPackageImpl
