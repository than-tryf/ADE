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
package org.eclipse.camf.tosca.util;

import org.eclipse.camf.tosca.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.tosca.ToscaPackage
 * @generated
 */
public class ToscaAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ToscaPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ToscaAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ToscaPackage.eINSTANCE;
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
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
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
  protected ToscaSwitch<Adapter> modelSwitch =
    new ToscaSwitch<Adapter>()
    {
      @Override
      public Adapter caseArtifactReferencesType(ArtifactReferencesType object)
      {
        return createArtifactReferencesTypeAdapter();
      }
      @Override
      public Adapter caseCapabilitiesType(CapabilitiesType object)
      {
        return createCapabilitiesTypeAdapter();
      }
      @Override
      public Adapter caseCapabilitiesType1(CapabilitiesType1 object)
      {
        return createCapabilitiesType1Adapter();
      }
      @Override
      public Adapter caseCapabilityDefinitionsType(CapabilityDefinitionsType object)
      {
        return createCapabilityDefinitionsTypeAdapter();
      }
      @Override
      public Adapter caseConstraintsType(ConstraintsType object)
      {
        return createConstraintsTypeAdapter();
      }
      @Override
      public Adapter caseConstraintsType1(ConstraintsType1 object)
      {
        return createConstraintsType1Adapter();
      }
      @Override
      public Adapter caseDefinitionsType(DefinitionsType object)
      {
        return createDefinitionsTypeAdapter();
      }
      @Override
      public Adapter caseDerivedFromType(DerivedFromType object)
      {
        return createDerivedFromTypeAdapter();
      }
      @Override
      public Adapter caseDerivedFromType1(DerivedFromType1 object)
      {
        return createDerivedFromType1Adapter();
      }
      @Override
      public Adapter caseDerivedFromType2(DerivedFromType2 object)
      {
        return createDerivedFromType2Adapter();
      }
      @Override
      public Adapter caseDocumentRoot(DocumentRoot object)
      {
        return createDocumentRootAdapter();
      }
      @Override
      public Adapter caseExcludeType(ExcludeType object)
      {
        return createExcludeTypeAdapter();
      }
      @Override
      public Adapter caseExtensionsType(ExtensionsType object)
      {
        return createExtensionsTypeAdapter();
      }
      @Override
      public Adapter caseImplementationArtifactType(ImplementationArtifactType object)
      {
        return createImplementationArtifactTypeAdapter();
      }
      @Override
      public Adapter caseIncludeType(IncludeType object)
      {
        return createIncludeTypeAdapter();
      }
      @Override
      public Adapter caseInputParametersType(InputParametersType object)
      {
        return createInputParametersTypeAdapter();
      }
      @Override
      public Adapter caseInputParametersType1(InputParametersType1 object)
      {
        return createInputParametersType1Adapter();
      }
      @Override
      public Adapter caseInstanceStateType(InstanceStateType object)
      {
        return createInstanceStateTypeAdapter();
      }
      @Override
      public Adapter caseInterfacesType(InterfacesType object)
      {
        return createInterfacesTypeAdapter();
      }
      @Override
      public Adapter caseInterfacesType1(InterfacesType1 object)
      {
        return createInterfacesType1Adapter();
      }
      @Override
      public Adapter caseNodeOperationType(NodeOperationType object)
      {
        return createNodeOperationTypeAdapter();
      }
      @Override
      public Adapter caseNodeTypeReferenceType(NodeTypeReferenceType object)
      {
        return createNodeTypeReferenceTypeAdapter();
      }
      @Override
      public Adapter caseOutputParametersType(OutputParametersType object)
      {
        return createOutputParametersTypeAdapter();
      }
      @Override
      public Adapter caseOutputParametersType1(OutputParametersType1 object)
      {
        return createOutputParametersType1Adapter();
      }
      @Override
      public Adapter casePlanModelReferenceType(PlanModelReferenceType object)
      {
        return createPlanModelReferenceTypeAdapter();
      }
      @Override
      public Adapter casePlanModelType(PlanModelType object)
      {
        return createPlanModelTypeAdapter();
      }
      @Override
      public Adapter casePlanType(PlanType object)
      {
        return createPlanTypeAdapter();
      }
      @Override
      public Adapter casePoliciesType(PoliciesType object)
      {
        return createPoliciesTypeAdapter();
      }
      @Override
      public Adapter casePoliciesType1(PoliciesType1 object)
      {
        return createPoliciesType1Adapter();
      }
      @Override
      public Adapter casePropertiesDefinitionType(PropertiesDefinitionType object)
      {
        return createPropertiesDefinitionTypeAdapter();
      }
      @Override
      public Adapter casePropertiesType(PropertiesType object)
      {
        return createPropertiesTypeAdapter();
      }
      @Override
      public Adapter casePropertiesType1(PropertiesType1 object)
      {
        return createPropertiesType1Adapter();
      }
      @Override
      public Adapter casePropertyConstraintsType(PropertyConstraintsType object)
      {
        return createPropertyConstraintsTypeAdapter();
      }
      @Override
      public Adapter casePropertyConstraintsType1(PropertyConstraintsType1 object)
      {
        return createPropertyConstraintsType1Adapter();
      }
      @Override
      public Adapter casePropertyMappingsType(PropertyMappingsType object)
      {
        return createPropertyMappingsTypeAdapter();
      }
      @Override
      public Adapter caseRelationshipConstraintsType(RelationshipConstraintsType object)
      {
        return createRelationshipConstraintsTypeAdapter();
      }
      @Override
      public Adapter caseRelationshipConstraintType(RelationshipConstraintType object)
      {
        return createRelationshipConstraintTypeAdapter();
      }
      @Override
      public Adapter caseRelationshipOperationType(RelationshipOperationType object)
      {
        return createRelationshipOperationTypeAdapter();
      }
      @Override
      public Adapter caseRequirementDefinitionsType(RequirementDefinitionsType object)
      {
        return createRequirementDefinitionsTypeAdapter();
      }
      @Override
      public Adapter caseRequirementsType(RequirementsType object)
      {
        return createRequirementsTypeAdapter();
      }
      @Override
      public Adapter caseRequirementsType1(RequirementsType1 object)
      {
        return createRequirementsType1Adapter();
      }
      @Override
      public Adapter caseSourceElementType(SourceElementType object)
      {
        return createSourceElementTypeAdapter();
      }
      @Override
      public Adapter caseSourceInterfacesType(SourceInterfacesType object)
      {
        return createSourceInterfacesTypeAdapter();
      }
      @Override
      public Adapter caseTAppliesTo(TAppliesTo object)
      {
        return createTAppliesToAdapter();
      }
      @Override
      public Adapter caseTargetElementType(TargetElementType object)
      {
        return createTargetElementTypeAdapter();
      }
      @Override
      public Adapter caseTargetInterfacesType(TargetInterfacesType object)
      {
        return createTargetInterfacesTypeAdapter();
      }
      @Override
      public Adapter caseTArtifactReference(TArtifactReference object)
      {
        return createTArtifactReferenceAdapter();
      }
      @Override
      public Adapter caseTArtifactTemplate(TArtifactTemplate object)
      {
        return createTArtifactTemplateAdapter();
      }
      @Override
      public Adapter caseTArtifactType(TArtifactType object)
      {
        return createTArtifactTypeAdapter();
      }
      @Override
      public Adapter caseTBoundaryDefinitions(TBoundaryDefinitions object)
      {
        return createTBoundaryDefinitionsAdapter();
      }
      @Override
      public Adapter caseTCapability(TCapability object)
      {
        return createTCapabilityAdapter();
      }
      @Override
      public Adapter caseTCapabilityDefinition(TCapabilityDefinition object)
      {
        return createTCapabilityDefinitionAdapter();
      }
      @Override
      public Adapter caseTCapabilityRef(TCapabilityRef object)
      {
        return createTCapabilityRefAdapter();
      }
      @Override
      public Adapter caseTCapabilityType(TCapabilityType object)
      {
        return createTCapabilityTypeAdapter();
      }
      @Override
      public Adapter caseTCondition(TCondition object)
      {
        return createTConditionAdapter();
      }
      @Override
      public Adapter caseTConstraint(TConstraint object)
      {
        return createTConstraintAdapter();
      }
      @Override
      public Adapter caseTDefinitions(TDefinitions object)
      {
        return createTDefinitionsAdapter();
      }
      @Override
      public Adapter caseTDeploymentArtifact(TDeploymentArtifact object)
      {
        return createTDeploymentArtifactAdapter();
      }
      @Override
      public Adapter caseTDeploymentArtifacts(TDeploymentArtifacts object)
      {
        return createTDeploymentArtifactsAdapter();
      }
      @Override
      public Adapter caseTDocumentation(TDocumentation object)
      {
        return createTDocumentationAdapter();
      }
      @Override
      public Adapter caseTEntityTemplate(TEntityTemplate object)
      {
        return createTEntityTemplateAdapter();
      }
      @Override
      public Adapter caseTEntityType(TEntityType object)
      {
        return createTEntityTypeAdapter();
      }
      @Override
      public Adapter caseTExportedInterface(TExportedInterface object)
      {
        return createTExportedInterfaceAdapter();
      }
      @Override
      public Adapter caseTExportedOperation(TExportedOperation object)
      {
        return createTExportedOperationAdapter();
      }
      @Override
      public Adapter caseTExtensibleElements(TExtensibleElements object)
      {
        return createTExtensibleElementsAdapter();
      }
      @Override
      public Adapter caseTExtension(TExtension object)
      {
        return createTExtensionAdapter();
      }
      @Override
      public Adapter caseTExtensions(TExtensions object)
      {
        return createTExtensionsAdapter();
      }
      @Override
      public Adapter caseTImplementationArtifact(TImplementationArtifact object)
      {
        return createTImplementationArtifactAdapter();
      }
      @Override
      public Adapter caseTImplementationArtifacts(TImplementationArtifacts object)
      {
        return createTImplementationArtifactsAdapter();
      }
      @Override
      public Adapter caseTImport(TImport object)
      {
        return createTImportAdapter();
      }
      @Override
      public Adapter caseTInterface(TInterface object)
      {
        return createTInterfaceAdapter();
      }
      @Override
      public Adapter caseTNodeTemplate(TNodeTemplate object)
      {
        return createTNodeTemplateAdapter();
      }
      @Override
      public Adapter caseTNodeType(TNodeType object)
      {
        return createTNodeTypeAdapter();
      }
      @Override
      public Adapter caseTNodeTypeImplementation(TNodeTypeImplementation object)
      {
        return createTNodeTypeImplementationAdapter();
      }
      @Override
      public Adapter caseTOperation(TOperation object)
      {
        return createTOperationAdapter();
      }
      @Override
      public Adapter caseTParameter(TParameter object)
      {
        return createTParameterAdapter();
      }
      @Override
      public Adapter caseTPlan(TPlan object)
      {
        return createTPlanAdapter();
      }
      @Override
      public Adapter caseTPlans(TPlans object)
      {
        return createTPlansAdapter();
      }
      @Override
      public Adapter caseTPolicy(TPolicy object)
      {
        return createTPolicyAdapter();
      }
      @Override
      public Adapter caseTPolicyTemplate(TPolicyTemplate object)
      {
        return createTPolicyTemplateAdapter();
      }
      @Override
      public Adapter caseTPolicyType(TPolicyType object)
      {
        return createTPolicyTypeAdapter();
      }
      @Override
      public Adapter caseTPropertyConstraint(TPropertyConstraint object)
      {
        return createTPropertyConstraintAdapter();
      }
      @Override
      public Adapter caseTPropertyMapping(TPropertyMapping object)
      {
        return createTPropertyMappingAdapter();
      }
      @Override
      public Adapter caseTRelationshipTemplate(TRelationshipTemplate object)
      {
        return createTRelationshipTemplateAdapter();
      }
      @Override
      public Adapter caseTRelationshipType(TRelationshipType object)
      {
        return createTRelationshipTypeAdapter();
      }
      @Override
      public Adapter caseTRelationshipTypeImplementation(TRelationshipTypeImplementation object)
      {
        return createTRelationshipTypeImplementationAdapter();
      }
      @Override
      public Adapter caseTRequiredContainerFeature(TRequiredContainerFeature object)
      {
        return createTRequiredContainerFeatureAdapter();
      }
      @Override
      public Adapter caseTRequiredContainerFeatures(TRequiredContainerFeatures object)
      {
        return createTRequiredContainerFeaturesAdapter();
      }
      @Override
      public Adapter caseTRequirement(TRequirement object)
      {
        return createTRequirementAdapter();
      }
      @Override
      public Adapter caseTRequirementDefinition(TRequirementDefinition object)
      {
        return createTRequirementDefinitionAdapter();
      }
      @Override
      public Adapter caseTRequirementRef(TRequirementRef object)
      {
        return createTRequirementRefAdapter();
      }
      @Override
      public Adapter caseTRequirementType(TRequirementType object)
      {
        return createTRequirementTypeAdapter();
      }
      @Override
      public Adapter caseTServiceTemplate(TServiceTemplate object)
      {
        return createTServiceTemplateAdapter();
      }
      @Override
      public Adapter caseTTag(TTag object)
      {
        return createTTagAdapter();
      }
      @Override
      public Adapter caseTTags(TTags object)
      {
        return createTTagsAdapter();
      }
      @Override
      public Adapter caseTTopologyElementInstanceStates(TTopologyElementInstanceStates object)
      {
        return createTTopologyElementInstanceStatesAdapter();
      }
      @Override
      public Adapter caseTTopologyTemplate(TTopologyTemplate object)
      {
        return createTTopologyTemplateAdapter();
      }
      @Override
      public Adapter caseTypesType(TypesType object)
      {
        return createTypesTypeAdapter();
      }
      @Override
      public Adapter caseValidSourceType(ValidSourceType object)
      {
        return createValidSourceTypeAdapter();
      }
      @Override
      public Adapter caseValidTargetType(ValidTargetType object)
      {
        return createValidTargetTypeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ArtifactReferencesType <em>Artifact References Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ArtifactReferencesType
   * @generated
   */
  public Adapter createArtifactReferencesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.CapabilitiesType <em>Capabilities Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.CapabilitiesType
   * @generated
   */
  public Adapter createCapabilitiesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.CapabilitiesType1 <em>Capabilities Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.CapabilitiesType1
   * @generated
   */
  public Adapter createCapabilitiesType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.CapabilityDefinitionsType <em>Capability Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.CapabilityDefinitionsType
   * @generated
   */
  public Adapter createCapabilityDefinitionsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ConstraintsType <em>Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ConstraintsType
   * @generated
   */
  public Adapter createConstraintsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ConstraintsType1 <em>Constraints Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ConstraintsType1
   * @generated
   */
  public Adapter createConstraintsType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.DefinitionsType <em>Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.DefinitionsType
   * @generated
   */
  public Adapter createDefinitionsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.DerivedFromType <em>Derived From Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.DerivedFromType
   * @generated
   */
  public Adapter createDerivedFromTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.DerivedFromType1 <em>Derived From Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.DerivedFromType1
   * @generated
   */
  public Adapter createDerivedFromType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.DerivedFromType2 <em>Derived From Type2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.DerivedFromType2
   * @generated
   */
  public Adapter createDerivedFromType2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.DocumentRoot
   * @generated
   */
  public Adapter createDocumentRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ExcludeType <em>Exclude Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ExcludeType
   * @generated
   */
  public Adapter createExcludeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ExtensionsType <em>Extensions Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ExtensionsType
   * @generated
   */
  public Adapter createExtensionsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ImplementationArtifactType <em>Implementation Artifact Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ImplementationArtifactType
   * @generated
   */
  public Adapter createImplementationArtifactTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.IncludeType <em>Include Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.IncludeType
   * @generated
   */
  public Adapter createIncludeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.InputParametersType <em>Input Parameters Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.InputParametersType
   * @generated
   */
  public Adapter createInputParametersTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.InputParametersType1 <em>Input Parameters Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.InputParametersType1
   * @generated
   */
  public Adapter createInputParametersType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.InstanceStateType <em>Instance State Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.InstanceStateType
   * @generated
   */
  public Adapter createInstanceStateTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.InterfacesType <em>Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.InterfacesType
   * @generated
   */
  public Adapter createInterfacesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.InterfacesType1 <em>Interfaces Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.InterfacesType1
   * @generated
   */
  public Adapter createInterfacesType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.NodeOperationType <em>Node Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.NodeOperationType
   * @generated
   */
  public Adapter createNodeOperationTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.NodeTypeReferenceType <em>Node Type Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.NodeTypeReferenceType
   * @generated
   */
  public Adapter createNodeTypeReferenceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.OutputParametersType <em>Output Parameters Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.OutputParametersType
   * @generated
   */
  public Adapter createOutputParametersTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.OutputParametersType1 <em>Output Parameters Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.OutputParametersType1
   * @generated
   */
  public Adapter createOutputParametersType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PlanModelReferenceType <em>Plan Model Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PlanModelReferenceType
   * @generated
   */
  public Adapter createPlanModelReferenceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PlanModelType <em>Plan Model Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PlanModelType
   * @generated
   */
  public Adapter createPlanModelTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PlanType <em>Plan Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PlanType
   * @generated
   */
  public Adapter createPlanTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PoliciesType <em>Policies Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PoliciesType
   * @generated
   */
  public Adapter createPoliciesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PoliciesType1 <em>Policies Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PoliciesType1
   * @generated
   */
  public Adapter createPoliciesType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertiesDefinitionType <em>Properties Definition Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertiesDefinitionType
   * @generated
   */
  public Adapter createPropertiesDefinitionTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertiesType <em>Properties Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertiesType
   * @generated
   */
  public Adapter createPropertiesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertiesType1 <em>Properties Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertiesType1
   * @generated
   */
  public Adapter createPropertiesType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertyConstraintsType <em>Property Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType
   * @generated
   */
  public Adapter createPropertyConstraintsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertyConstraintsType1 <em>Property Constraints Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertyConstraintsType1
   * @generated
   */
  public Adapter createPropertyConstraintsType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.PropertyMappingsType <em>Property Mappings Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.PropertyMappingsType
   * @generated
   */
  public Adapter createPropertyMappingsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RelationshipConstraintsType <em>Relationship Constraints Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RelationshipConstraintsType
   * @generated
   */
  public Adapter createRelationshipConstraintsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RelationshipConstraintType <em>Relationship Constraint Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RelationshipConstraintType
   * @generated
   */
  public Adapter createRelationshipConstraintTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RelationshipOperationType <em>Relationship Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RelationshipOperationType
   * @generated
   */
  public Adapter createRelationshipOperationTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RequirementDefinitionsType <em>Requirement Definitions Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RequirementDefinitionsType
   * @generated
   */
  public Adapter createRequirementDefinitionsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RequirementsType <em>Requirements Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RequirementsType
   * @generated
   */
  public Adapter createRequirementsTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.RequirementsType1 <em>Requirements Type1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.RequirementsType1
   * @generated
   */
  public Adapter createRequirementsType1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.SourceElementType <em>Source Element Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.SourceElementType
   * @generated
   */
  public Adapter createSourceElementTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.SourceInterfacesType <em>Source Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.SourceInterfacesType
   * @generated
   */
  public Adapter createSourceInterfacesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TAppliesTo <em>TApplies To</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TAppliesTo
   * @generated
   */
  public Adapter createTAppliesToAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TargetElementType <em>Target Element Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TargetElementType
   * @generated
   */
  public Adapter createTargetElementTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TargetInterfacesType <em>Target Interfaces Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TargetInterfacesType
   * @generated
   */
  public Adapter createTargetInterfacesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TArtifactReference <em>TArtifact Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TArtifactReference
   * @generated
   */
  public Adapter createTArtifactReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TArtifactTemplate <em>TArtifact Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TArtifactTemplate
   * @generated
   */
  public Adapter createTArtifactTemplateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TArtifactType <em>TArtifact Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TArtifactType
   * @generated
   */
  public Adapter createTArtifactTypeAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TCapability <em>TCapability</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TCapability
   * @generated
   */
  public Adapter createTCapabilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TCapabilityDefinition <em>TCapability Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TCapabilityDefinition
   * @generated
   */
  public Adapter createTCapabilityDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TCapabilityRef <em>TCapability Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TCapabilityRef
   * @generated
   */
  public Adapter createTCapabilityRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TCapabilityType <em>TCapability Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TCapabilityType
   * @generated
   */
  public Adapter createTCapabilityTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TCondition <em>TCondition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TCondition
   * @generated
   */
  public Adapter createTConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TConstraint <em>TConstraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TConstraint
   * @generated
   */
  public Adapter createTConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TDefinitions <em>TDefinitions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TDefinitions
   * @generated
   */
  public Adapter createTDefinitionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TDeploymentArtifact <em>TDeployment Artifact</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TDeploymentArtifact
   * @generated
   */
  public Adapter createTDeploymentArtifactAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TDeploymentArtifacts <em>TDeployment Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TDeploymentArtifacts
   * @generated
   */
  public Adapter createTDeploymentArtifactsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TDocumentation <em>TDocumentation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TDocumentation
   * @generated
   */
  public Adapter createTDocumentationAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TEntityType <em>TEntity Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TEntityType
   * @generated
   */
  public Adapter createTEntityTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TExportedInterface <em>TExported Interface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TExportedInterface
   * @generated
   */
  public Adapter createTExportedInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TExportedOperation <em>TExported Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TExportedOperation
   * @generated
   */
  public Adapter createTExportedOperationAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TExtension <em>TExtension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TExtension
   * @generated
   */
  public Adapter createTExtensionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TExtensions <em>TExtensions</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TExtensions
   * @generated
   */
  public Adapter createTExtensionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TImplementationArtifact <em>TImplementation Artifact</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TImplementationArtifact
   * @generated
   */
  public Adapter createTImplementationArtifactAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TImplementationArtifacts <em>TImplementation Artifacts</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TImplementationArtifacts
   * @generated
   */
  public Adapter createTImplementationArtifactsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TImport <em>TImport</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TImport
   * @generated
   */
  public Adapter createTImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TInterface <em>TInterface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TInterface
   * @generated
   */
  public Adapter createTInterfaceAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TNodeType <em>TNode Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TNodeType
   * @generated
   */
  public Adapter createTNodeTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TNodeTypeImplementation <em>TNode Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TNodeTypeImplementation
   * @generated
   */
  public Adapter createTNodeTypeImplementationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TOperation <em>TOperation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TOperation
   * @generated
   */
  public Adapter createTOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TParameter <em>TParameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TParameter
   * @generated
   */
  public Adapter createTParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPlan <em>TPlan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPlan
   * @generated
   */
  public Adapter createTPlanAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPlans <em>TPlans</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPlans
   * @generated
   */
  public Adapter createTPlansAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPolicy <em>TPolicy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPolicy
   * @generated
   */
  public Adapter createTPolicyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPolicyTemplate <em>TPolicy Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPolicyTemplate
   * @generated
   */
  public Adapter createTPolicyTemplateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPolicyType <em>TPolicy Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPolicyType
   * @generated
   */
  public Adapter createTPolicyTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPropertyConstraint <em>TProperty Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPropertyConstraint
   * @generated
   */
  public Adapter createTPropertyConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TPropertyMapping <em>TProperty Mapping</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TPropertyMapping
   * @generated
   */
  public Adapter createTPropertyMappingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRelationshipTemplate <em>TRelationship Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRelationshipTemplate
   * @generated
   */
  public Adapter createTRelationshipTemplateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRelationshipType <em>TRelationship Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRelationshipType
   * @generated
   */
  public Adapter createTRelationshipTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRelationshipTypeImplementation <em>TRelationship Type Implementation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRelationshipTypeImplementation
   * @generated
   */
  public Adapter createTRelationshipTypeImplementationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequiredContainerFeature <em>TRequired Container Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeature
   * @generated
   */
  public Adapter createTRequiredContainerFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequiredContainerFeatures <em>TRequired Container Features</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequiredContainerFeatures
   * @generated
   */
  public Adapter createTRequiredContainerFeaturesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequirement <em>TRequirement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequirement
   * @generated
   */
  public Adapter createTRequirementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequirementDefinition <em>TRequirement Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequirementDefinition
   * @generated
   */
  public Adapter createTRequirementDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequirementRef <em>TRequirement Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequirementRef
   * @generated
   */
  public Adapter createTRequirementRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TRequirementType <em>TRequirement Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TRequirementType
   * @generated
   */
  public Adapter createTRequirementTypeAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TTag <em>TTag</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TTag
   * @generated
   */
  public Adapter createTTagAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TTags <em>TTags</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TTags
   * @generated
   */
  public Adapter createTTagsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TTopologyElementInstanceStates <em>TTopology Element Instance States</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TTopologyElementInstanceStates
   * @generated
   */
  public Adapter createTTopologyElementInstanceStatesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TTopologyTemplate <em>TTopology Template</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TTopologyTemplate
   * @generated
   */
  public Adapter createTTopologyTemplateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.TypesType
   * @generated
   */
  public Adapter createTypesTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ValidSourceType <em>Valid Source Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ValidSourceType
   * @generated
   */
  public Adapter createValidSourceTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.tosca.ValidTargetType <em>Valid Target Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.tosca.ValidTargetType
   * @generated
   */
  public Adapter createValidTargetTypeAdapter()
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

} //ToscaAdapterFactory
