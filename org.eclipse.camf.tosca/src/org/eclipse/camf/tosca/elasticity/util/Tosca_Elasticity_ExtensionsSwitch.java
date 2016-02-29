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
package org.eclipse.camf.tosca.elasticity.util;

import org.eclipse.camf.tosca.TBoundaryDefinitions;
import org.eclipse.camf.tosca.TEntityTemplate;
import org.eclipse.camf.tosca.TExtensibleElements;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.elasticity.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage
 * @generated
 */
public class Tosca_Elasticity_ExtensionsSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static Tosca_Elasticity_ExtensionsPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsSwitch()
  {
		if (modelPackage == null) {
			modelPackage = Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
		}
	}

  /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
		return ePackage == modelPackage;
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
		switch (classifierID) {
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE: {
				ImageArtifactPropertiesType imageArtifactPropertiesType = (ImageArtifactPropertiesType)theEObject;
				T result = caseImageArtifactPropertiesType(imageArtifactPropertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.MONITORING_PROBES_TYPE1: {
				MonitoringProbesType1 monitoringProbesType1 = (MonitoringProbesType1)theEObject;
				T result = caseMonitoringProbesType1(monitoringProbesType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.NODE_PROPERTIES_TYPE: {
				NodePropertiesType nodePropertiesType = (NodePropertiesType)theEObject;
				T result = caseNodePropertiesType(nodePropertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.SCRIPT_ARTIFACT_PROPERTIES_TYPE: {
				ScriptArtifactPropertiesType scriptArtifactPropertiesType = (ScriptArtifactPropertiesType)theEObject;
				T result = caseScriptArtifactPropertiesType(scriptArtifactPropertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.SERVICE_PROPERTIES_TYPE: {
				ServicePropertiesType servicePropertiesType = (ServicePropertiesType)theEObject;
				T result = caseServicePropertiesType(servicePropertiesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.TBOUNDARY_DEFINITIONS_EXTENSION: {
				TBoundaryDefinitionsExtension tBoundaryDefinitionsExtension = (TBoundaryDefinitionsExtension)theEObject;
				T result = caseTBoundaryDefinitionsExtension(tBoundaryDefinitionsExtension);
				if (result == null) result = caseTBoundaryDefinitions(tBoundaryDefinitionsExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.TMONITORING_PROBE: {
				TMonitoringProbe tMonitoringProbe = (TMonitoringProbe)theEObject;
				T result = caseTMonitoringProbe(tMonitoringProbe);
				if (result == null) result = caseTExtensibleElements(tMonitoringProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION: {
				TNodeTemplateExtension tNodeTemplateExtension = (TNodeTemplateExtension)theEObject;
				T result = caseTNodeTemplateExtension(tNodeTemplateExtension);
				if (result == null) result = caseTNodeTemplate(tNodeTemplateExtension);
				if (result == null) result = caseTEntityTemplate(tNodeTemplateExtension);
				if (result == null) result = caseTExtensibleElements(tNodeTemplateExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Tosca_Elasticity_ExtensionsPackage.TSERVICE_TEMPLATE_EXTENSION: {
				TServiceTemplateExtension tServiceTemplateExtension = (TServiceTemplateExtension)theEObject;
				T result = caseTServiceTemplateExtension(tServiceTemplateExtension);
				if (result == null) result = caseTServiceTemplate(tServiceTemplateExtension);
				if (result == null) result = caseTExtensibleElements(tServiceTemplateExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDocumentRoot(DocumentRoot object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Image Artifact Properties Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Artifact Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseImageArtifactPropertiesType(ImageArtifactPropertiesType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Monitoring Probes Type1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monitoring Probes Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMonitoringProbesType1(MonitoringProbesType1 object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Node Properties Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseNodePropertiesType(NodePropertiesType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Script Artifact Properties Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script Artifact Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseScriptArtifactPropertiesType(ScriptArtifactPropertiesType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Service Properties Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Properties Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseServicePropertiesType(ServicePropertiesType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TBoundary Definitions Extension</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBoundary Definitions Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TMonitoring Probe</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TMonitoring Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTMonitoringProbe(TMonitoringProbe object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TNode Template Extension</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TNode Template Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTNodeTemplateExtension(TNodeTemplateExtension object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TService Template Extension</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TService Template Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTServiceTemplateExtension(TServiceTemplateExtension object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>TBoundary Definitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBoundary Definitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBoundaryDefinitions(TBoundaryDefinitions object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleElements(TExtensibleElements object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>TEntity Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TEntity Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTEntityTemplate(TEntityTemplate object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>TNode Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TNode Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTNodeTemplate(TNodeTemplate object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>TService Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TService Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTServiceTemplate(TServiceTemplate object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  @Override
  public T defaultCase(EObject object)
  {
		return null;
	}

} //Tosca_Elasticity_ExtensionsSwitch
