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

import org.eclipse.camf.tosca.elasticity.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_Elasticity_ExtensionsFactoryImpl extends EFactoryImpl implements Tosca_Elasticity_ExtensionsFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static Tosca_Elasticity_ExtensionsFactory init()
  {
		try {
			Tosca_Elasticity_ExtensionsFactory theTosca_Elasticity_ExtensionsFactory = (Tosca_Elasticity_ExtensionsFactory)EPackage.Registry.INSTANCE.getEFactory(Tosca_Elasticity_ExtensionsPackage.eNS_URI);
			if (theTosca_Elasticity_ExtensionsFactory != null) {
				return theTosca_Elasticity_ExtensionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Tosca_Elasticity_ExtensionsFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsFactoryImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass)
  {
		switch (eClass.getClassifierID()) {
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE: return createImageArtifactPropertiesType();
			case Tosca_Elasticity_ExtensionsPackage.MONITORING_PROBES_TYPE1: return createMonitoringProbesType1();
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE: return createNodePropertiesType();
			case Tosca_Elasticity_ExtensionsPackage.SCRIPT_ARTIFACT_PROPERTIES_TYPE: return createScriptArtifactPropertiesType();
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE: return createServicePropertiesType();
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION: return createTBoundaryDefinitionsExtension();
			case Tosca_Elasticity_ExtensionsPackage.TMONITORING_PROBE: return createTMonitoringProbe();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION: return createTNodeTemplateExtension();
			case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION: return createTServiceTemplateExtension();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DocumentRoot createDocumentRoot()
  {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ImageArtifactPropertiesType createImageArtifactPropertiesType()
  {
		ImageArtifactPropertiesTypeImpl imageArtifactPropertiesType = new ImageArtifactPropertiesTypeImpl();
		return imageArtifactPropertiesType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MonitoringProbesType1 createMonitoringProbesType1()
  {
		MonitoringProbesType1Impl monitoringProbesType1 = new MonitoringProbesType1Impl();
		return monitoringProbesType1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NodePropertiesType createNodePropertiesType()
  {
		NodePropertiesTypeImpl nodePropertiesType = new NodePropertiesTypeImpl();
		return nodePropertiesType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ScriptArtifactPropertiesType createScriptArtifactPropertiesType()
  {
		ScriptArtifactPropertiesTypeImpl scriptArtifactPropertiesType = new ScriptArtifactPropertiesTypeImpl();
		return scriptArtifactPropertiesType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServicePropertiesType createServicePropertiesType()
  {
		ServicePropertiesTypeImpl servicePropertiesType = new ServicePropertiesTypeImpl();
		return servicePropertiesType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TBoundaryDefinitionsExtension createTBoundaryDefinitionsExtension()
  {
		TBoundaryDefinitionsExtensionImpl tBoundaryDefinitionsExtension = new TBoundaryDefinitionsExtensionImpl();
		return tBoundaryDefinitionsExtension;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TMonitoringProbe createTMonitoringProbe()
  {
		TMonitoringProbeImpl tMonitoringProbe = new TMonitoringProbeImpl();
		return tMonitoringProbe;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TNodeTemplateExtension createTNodeTemplateExtension()
  {
		TNodeTemplateExtensionImpl tNodeTemplateExtension = new TNodeTemplateExtensionImpl();
		return tNodeTemplateExtension;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TServiceTemplateExtension createTServiceTemplateExtension()
  {
		TServiceTemplateExtensionImpl tServiceTemplateExtension = new TServiceTemplateExtensionImpl();
		return tServiceTemplateExtension;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsPackage getTosca_Elasticity_ExtensionsPackage()
  {
		return (Tosca_Elasticity_ExtensionsPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static Tosca_Elasticity_ExtensionsPackage getPackage()
  {
		return Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
	}

} //Tosca_Elasticity_ExtensionsFactoryImpl
