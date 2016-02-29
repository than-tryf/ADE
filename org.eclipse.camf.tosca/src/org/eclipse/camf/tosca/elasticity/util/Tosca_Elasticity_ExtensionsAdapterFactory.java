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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage
 * @generated
 */
public class Tosca_Elasticity_ExtensionsAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static Tosca_Elasticity_ExtensionsPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = Tosca_Elasticity_ExtensionsPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object)
  {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Tosca_Elasticity_ExtensionsSwitch<Adapter> modelSwitch =
    new Tosca_Elasticity_ExtensionsSwitch<Adapter>() {
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseImageArtifactPropertiesType(ImageArtifactPropertiesType object) {
				return createImageArtifactPropertiesTypeAdapter();
			}
			@Override
			public Adapter caseMonitoringProbesType1(MonitoringProbesType1 object) {
				return createMonitoringProbesType1Adapter();
			}
			@Override
			public Adapter caseNodePropertiesType(NodePropertiesType object) {
				return createNodePropertiesTypeAdapter();
			}
			@Override
			public Adapter caseScriptArtifactPropertiesType(ScriptArtifactPropertiesType object) {
				return createScriptArtifactPropertiesTypeAdapter();
			}
			@Override
			public Adapter caseServicePropertiesType(ServicePropertiesType object) {
				return createServicePropertiesTypeAdapter();
			}
			@Override
			public Adapter caseTBoundaryDefinitionsExtension(TBoundaryDefinitionsExtension object) {
				return createTBoundaryDefinitionsExtensionAdapter();
			}
			@Override
			public Adapter caseTMonitoringProbe(TMonitoringProbe object) {
				return createTMonitoringProbeAdapter();
			}
			@Override
			public Adapter caseTNodeTemplateExtension(TNodeTemplateExtension object) {
				return createTNodeTemplateExtensionAdapter();
			}
			@Override
			public Adapter caseTServiceTemplateExtension(TServiceTemplateExtension object) {
				return createTServiceTemplateExtensionAdapter();
			}
			@Override
			public Adapter caseTBoundaryDefinitions(TBoundaryDefinitions object) {
				return createTBoundaryDefinitionsAdapter();
			}
			@Override
			public Adapter caseTExtensibleElements(TExtensibleElements object) {
				return createTExtensibleElementsAdapter();
			}
			@Override
			public Adapter caseTEntityTemplate(TEntityTemplate object) {
				return createTEntityTemplateAdapter();
			}
			@Override
			public Adapter caseTNodeTemplate(TNodeTemplate object) {
				return createTNodeTemplateAdapter();
			}
			@Override
			public Adapter caseTServiceTemplate(TServiceTemplate object) {
				return createTServiceTemplateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target)
  {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.DocumentRoot
	 * @generated
	 */
  public Adapter createDocumentRootAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType <em>Image Artifact Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType
	 * @generated
	 */
  public Adapter createImageArtifactPropertiesTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.MonitoringProbesType1 <em>Monitoring Probes Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.MonitoringProbesType1
	 * @generated
	 */
  public Adapter createMonitoringProbesType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.NodePropertiesType <em>Node Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.NodePropertiesType
	 * @generated
	 */
  public Adapter createNodePropertiesTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType <em>Script Artifact Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType
	 * @generated
	 */
  public Adapter createScriptArtifactPropertiesTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.ServicePropertiesType <em>Service Properties Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.ServicePropertiesType
	 * @generated
	 */
  public Adapter createServicePropertiesTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension <em>TBoundary Definitions Extension</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension
	 * @generated
	 */
  public Adapter createTBoundaryDefinitionsExtensionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.TMonitoringProbe <em>TMonitoring Probe</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.TMonitoringProbe
	 * @generated
	 */
  public Adapter createTMonitoringProbeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension <em>TNode Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension
	 * @generated
	 */
  public Adapter createTNodeTemplateExtensionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension <em>TService Template Extension</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension
	 * @generated
	 */
  public Adapter createTServiceTemplateExtensionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TBoundaryDefinitions <em>TBoundary Definitions</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.TBoundaryDefinitions
	 * @generated
	 */
  public Adapter createTBoundaryDefinitionsAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.TExtensibleElements
	 * @generated
	 */
  public Adapter createTExtensibleElementsAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TEntityTemplate <em>TEntity Template</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.TEntityTemplate
	 * @generated
	 */
  public Adapter createTEntityTemplateAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TNodeTemplate <em>TNode Template</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.TNodeTemplate
	 * @generated
	 */
  public Adapter createTNodeTemplateAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TServiceTemplate <em>TService Template</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.camf.tosca.TServiceTemplate
	 * @generated
	 */
  public Adapter createTServiceTemplateAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter()
  {
		return null;
	}

} //Tosca_Elasticity_ExtensionsAdapterFactory
