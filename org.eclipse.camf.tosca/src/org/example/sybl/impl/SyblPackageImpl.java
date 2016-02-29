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
package org.example.sybl.impl;

import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.elasticity.impl.Tosca_Elasticity_ExtensionsPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.example.sybl.BinaryRestriction;
import org.example.sybl.ConditionType;
import org.example.sybl.ConditionType1;
import org.example.sybl.Constraint;
import org.example.sybl.DocumentRoot;
import org.example.sybl.LeftHandSideType;
import org.example.sybl.ReferenceToType;
import org.example.sybl.RightHandSideType;
import org.example.sybl.SYBLSpecificationType;
import org.example.sybl.Strategy;
import org.example.sybl.SyblElasticityRequirementsDescription;
import org.example.sybl.SyblFactory;
import org.example.sybl.SyblPackage;
import org.example.sybl.ToEnforceType;
import org.example.sybl.ToEnforceType1;
import org.example.sybl.UnaryRestriction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyblPackageImpl extends EPackageImpl implements SyblPackage
{
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass binaryRestrictionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass conditionTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass conditionType1EClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass constraintEClass = null;

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
  private EClass leftHandSideTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass referenceToTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rightHandSideTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass strategyEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass syblElasticityRequirementsDescriptionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass syblSpecificationTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass toEnforceTypeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass toEnforceType1EClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass unaryRestrictionEClass = null;

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
	 * @see org.example.sybl.SyblPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private SyblPackageImpl()
  {
		super(eNS_URI, SyblFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SyblPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static SyblPackage init()
  {
		if (isInited) return (SyblPackage)EPackage.Registry.INSTANCE.getEPackage(SyblPackage.eNS_URI);

		// Obtain or create and register package
		SyblPackageImpl theSyblPackage = (SyblPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SyblPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SyblPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ToscaPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Tosca_Elasticity_ExtensionsPackageImpl theTosca_Elasticity_ExtensionsPackage = (Tosca_Elasticity_ExtensionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) instanceof Tosca_Elasticity_ExtensionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tosca_Elasticity_ExtensionsPackage.eNS_URI) : Tosca_Elasticity_ExtensionsPackage.eINSTANCE);

		// Create package meta-data objects
		theSyblPackage.createPackageContents();
		theTosca_Elasticity_ExtensionsPackage.createPackageContents();

		// Initialize created meta-data
		theSyblPackage.initializePackageContents();
		theTosca_Elasticity_ExtensionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSyblPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SyblPackage.eNS_URI, theSyblPackage);
		return theSyblPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBinaryRestriction()
  {
		return binaryRestrictionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getBinaryRestriction_LeftHandSide()
  {
		return (EReference)binaryRestrictionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getBinaryRestriction_RightHandSide()
  {
		return (EReference)binaryRestrictionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBinaryRestriction_Type()
  {
		return (EAttribute)binaryRestrictionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getConditionType()
  {
		return conditionTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConditionType_BinaryRestrictionsConjunction()
  {
		return (EReference)conditionTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConditionType_UnaryRestrictionsConjunction()
  {
		return (EReference)conditionTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getConditionType1()
  {
		return conditionType1EClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConditionType1_BinaryRestrictionsConjunction()
  {
		return (EReference)conditionType1EClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConditionType1_UnaryRestrictionsConjunction()
  {
		return (EReference)conditionType1EClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getConstraint()
  {
		return constraintEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConstraint_ToEnforce()
  {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getConstraint_Condition()
  {
		return (EReference)constraintEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getConstraint_Id()
  {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(2);
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
  public EReference getDocumentRoot_ConstraintProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_StrategyProperties()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDocumentRoot_SYBLElasticityRequirementsDescription()
  {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getLeftHandSideType()
  {
		return leftHandSideTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLeftHandSideType_Metric()
  {
		return (EAttribute)leftHandSideTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getLeftHandSideType_Number()
  {
		return (EAttribute)leftHandSideTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getReferenceToType()
  {
		return referenceToTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getReferenceToType_Value()
  {
		return (EAttribute)referenceToTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getReferenceToType_Function()
  {
		return (EAttribute)referenceToTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getReferenceToType_Name()
  {
		return (EAttribute)referenceToTypeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRightHandSideType()
  {
		return rightHandSideTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRightHandSideType_Metric()
  {
		return (EAttribute)rightHandSideTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRightHandSideType_Number()
  {
		return (EAttribute)rightHandSideTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStrategy()
  {
		return strategyEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getStrategy_Condition()
  {
		return (EReference)strategyEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getStrategy_ToEnforce()
  {
		return (EReference)strategyEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStrategy_Id()
  {
		return (EAttribute)strategyEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSyblElasticityRequirementsDescription()
  {
		return syblElasticityRequirementsDescriptionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSyblElasticityRequirementsDescription_SYBLSpecification()
  {
		return (EReference)syblElasticityRequirementsDescriptionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSYBLSpecificationType()
  {
		return syblSpecificationTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSYBLSpecificationType_Constraint()
  {
		return (EReference)syblSpecificationTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSYBLSpecificationType_Strategy()
  {
		return (EReference)syblSpecificationTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSYBLSpecificationType_Id()
  {
		return (EAttribute)syblSpecificationTypeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSYBLSpecificationType_Type()
  {
		return (EAttribute)syblSpecificationTypeEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getToEnforceType()
  {
		return toEnforceTypeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getToEnforceType_ActionName()
  {
		return (EAttribute)toEnforceTypeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getToEnforceType_Parameter()
  {
		return (EAttribute)toEnforceTypeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getToEnforceType1()
  {
		return toEnforceType1EClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getToEnforceType1_BinaryRestrictionsConjunction()
  {
		return (EReference)toEnforceType1EClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getToEnforceType1_UnaryRestrictionsConjunction()
  {
		return (EReference)toEnforceType1EClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getUnaryRestriction()
  {
		return unaryRestrictionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUnaryRestriction_Metric()
  {
		return (EAttribute)unaryRestrictionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getUnaryRestriction_ReferenceTo()
  {
		return (EReference)unaryRestrictionEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUnaryRestriction_Type()
  {
		return (EAttribute)unaryRestrictionEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblFactory getSyblFactory()
  {
		return (SyblFactory)getEFactoryInstance();
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
		binaryRestrictionEClass = createEClass(BINARY_RESTRICTION);
		createEReference(binaryRestrictionEClass, BINARY_RESTRICTION__LEFT_HAND_SIDE);
		createEReference(binaryRestrictionEClass, BINARY_RESTRICTION__RIGHT_HAND_SIDE);
		createEAttribute(binaryRestrictionEClass, BINARY_RESTRICTION__TYPE);

		conditionTypeEClass = createEClass(CONDITION_TYPE);
		createEReference(conditionTypeEClass, CONDITION_TYPE__BINARY_RESTRICTIONS_CONJUNCTION);
		createEReference(conditionTypeEClass, CONDITION_TYPE__UNARY_RESTRICTIONS_CONJUNCTION);

		conditionType1EClass = createEClass(CONDITION_TYPE1);
		createEReference(conditionType1EClass, CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION);
		createEReference(conditionType1EClass, CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__TO_ENFORCE);
		createEReference(constraintEClass, CONSTRAINT__CONDITION);
		createEAttribute(constraintEClass, CONSTRAINT__ID);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__CONSTRAINT_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__STRATEGY_PROPERTIES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION);

		leftHandSideTypeEClass = createEClass(LEFT_HAND_SIDE_TYPE);
		createEAttribute(leftHandSideTypeEClass, LEFT_HAND_SIDE_TYPE__METRIC);
		createEAttribute(leftHandSideTypeEClass, LEFT_HAND_SIDE_TYPE__NUMBER);

		referenceToTypeEClass = createEClass(REFERENCE_TO_TYPE);
		createEAttribute(referenceToTypeEClass, REFERENCE_TO_TYPE__VALUE);
		createEAttribute(referenceToTypeEClass, REFERENCE_TO_TYPE__FUNCTION);
		createEAttribute(referenceToTypeEClass, REFERENCE_TO_TYPE__NAME);

		rightHandSideTypeEClass = createEClass(RIGHT_HAND_SIDE_TYPE);
		createEAttribute(rightHandSideTypeEClass, RIGHT_HAND_SIDE_TYPE__METRIC);
		createEAttribute(rightHandSideTypeEClass, RIGHT_HAND_SIDE_TYPE__NUMBER);

		strategyEClass = createEClass(STRATEGY);
		createEReference(strategyEClass, STRATEGY__CONDITION);
		createEReference(strategyEClass, STRATEGY__TO_ENFORCE);
		createEAttribute(strategyEClass, STRATEGY__ID);

		syblElasticityRequirementsDescriptionEClass = createEClass(SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION);
		createEReference(syblElasticityRequirementsDescriptionEClass, SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION);

		syblSpecificationTypeEClass = createEClass(SYBL_SPECIFICATION_TYPE);
		createEReference(syblSpecificationTypeEClass, SYBL_SPECIFICATION_TYPE__CONSTRAINT);
		createEReference(syblSpecificationTypeEClass, SYBL_SPECIFICATION_TYPE__STRATEGY);
		createEAttribute(syblSpecificationTypeEClass, SYBL_SPECIFICATION_TYPE__ID);
		createEAttribute(syblSpecificationTypeEClass, SYBL_SPECIFICATION_TYPE__TYPE);

		toEnforceTypeEClass = createEClass(TO_ENFORCE_TYPE);
		createEAttribute(toEnforceTypeEClass, TO_ENFORCE_TYPE__ACTION_NAME);
		createEAttribute(toEnforceTypeEClass, TO_ENFORCE_TYPE__PARAMETER);

		toEnforceType1EClass = createEClass(TO_ENFORCE_TYPE1);
		createEReference(toEnforceType1EClass, TO_ENFORCE_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION);
		createEReference(toEnforceType1EClass, TO_ENFORCE_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION);

		unaryRestrictionEClass = createEClass(UNARY_RESTRICTION);
		createEAttribute(unaryRestrictionEClass, UNARY_RESTRICTION__METRIC);
		createEReference(unaryRestrictionEClass, UNARY_RESTRICTION__REFERENCE_TO);
		createEAttribute(unaryRestrictionEClass, UNARY_RESTRICTION__TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(binaryRestrictionEClass, BinaryRestriction.class, "BinaryRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryRestriction_LeftHandSide(), this.getLeftHandSideType(), null, "leftHandSide", null, 1, 1, BinaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryRestriction_RightHandSide(), this.getRightHandSideType(), null, "rightHandSide", null, 1, 1, BinaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryRestriction_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, BinaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionTypeEClass, ConditionType.class, "ConditionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionType_BinaryRestrictionsConjunction(), this.getBinaryRestriction(), null, "binaryRestrictionsConjunction", null, 1, -1, ConditionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionType_UnaryRestrictionsConjunction(), this.getUnaryRestriction(), null, "unaryRestrictionsConjunction", null, 1, -1, ConditionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionType1EClass, ConditionType1.class, "ConditionType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionType1_BinaryRestrictionsConjunction(), this.getBinaryRestriction(), null, "binaryRestrictionsConjunction", null, 1, -1, ConditionType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionType1_UnaryRestrictionsConjunction(), this.getUnaryRestriction(), null, "unaryRestrictionsConjunction", null, 1, -1, ConditionType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_ToEnforce(), this.getToEnforceType1(), null, "toEnforce", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Condition(), this.getConditionType1(), null, "condition", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ConstraintProperties(), this.getConstraint(), null, "constraintProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_StrategyProperties(), this.getStrategy(), null, "strategyProperties", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_SYBLElasticityRequirementsDescription(), this.getSyblElasticityRequirementsDescription(), null, "sYBLElasticityRequirementsDescription", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(leftHandSideTypeEClass, LeftHandSideType.class, "LeftHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLeftHandSideType_Metric(), theXMLTypePackage.getString(), "metric", null, 0, 1, LeftHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLeftHandSideType_Number(), theXMLTypePackage.getString(), "number", null, 0, 1, LeftHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceToTypeEClass, ReferenceToType.class, "ReferenceToType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceToType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ReferenceToType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceToType_Function(), theXMLTypePackage.getString(), "function", null, 0, 1, ReferenceToType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceToType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ReferenceToType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rightHandSideTypeEClass, RightHandSideType.class, "RightHandSideType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRightHandSideType_Metric(), theXMLTypePackage.getString(), "metric", null, 0, 1, RightHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRightHandSideType_Number(), theXMLTypePackage.getString(), "number", null, 0, 1, RightHandSideType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strategyEClass, Strategy.class, "Strategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStrategy_Condition(), this.getConditionType(), null, "condition", null, 1, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrategy_ToEnforce(), this.getToEnforceType(), null, "toEnforce", null, 1, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStrategy_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syblElasticityRequirementsDescriptionEClass, SyblElasticityRequirementsDescription.class, "SyblElasticityRequirementsDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSyblElasticityRequirementsDescription_SYBLSpecification(), this.getSYBLSpecificationType(), null, "sYBLSpecification", null, 1, -1, SyblElasticityRequirementsDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(syblSpecificationTypeEClass, SYBLSpecificationType.class, "SYBLSpecificationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSYBLSpecificationType_Constraint(), this.getConstraint(), null, "constraint", null, 1, -1, SYBLSpecificationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSYBLSpecificationType_Strategy(), this.getStrategy(), null, "strategy", null, 1, -1, SYBLSpecificationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSYBLSpecificationType_Id(), theXMLTypePackage.getString(), "id", null, 0, 1, SYBLSpecificationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSYBLSpecificationType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, SYBLSpecificationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toEnforceTypeEClass, ToEnforceType.class, "ToEnforceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getToEnforceType_ActionName(), theXMLTypePackage.getString(), "actionName", null, 1, 1, ToEnforceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getToEnforceType_Parameter(), theXMLTypePackage.getString(), "parameter", null, 0, 1, ToEnforceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toEnforceType1EClass, ToEnforceType1.class, "ToEnforceType1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToEnforceType1_BinaryRestrictionsConjunction(), this.getBinaryRestriction(), null, "binaryRestrictionsConjunction", null, 1, -1, ToEnforceType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToEnforceType1_UnaryRestrictionsConjunction(), this.getUnaryRestriction(), null, "unaryRestrictionsConjunction", null, 1, -1, ToEnforceType1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryRestrictionEClass, UnaryRestriction.class, "UnaryRestriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryRestriction_Metric(), theXMLTypePackage.getString(), "metric", null, 0, 1, UnaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryRestriction_ReferenceTo(), this.getReferenceToType(), null, "referenceTo", null, 0, 1, UnaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnaryRestriction_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, UnaryRestriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (binaryRestrictionEClass, 
		   source, 
		   new String[] {
			 "name", "BinaryRestriction",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getBinaryRestriction_LeftHandSide(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LeftHandSide"
		   });	
		addAnnotation
		  (getBinaryRestriction_RightHandSide(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RightHandSide"
		   });	
		addAnnotation
		  (getBinaryRestriction_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type"
		   });	
		addAnnotation
		  (conditionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "Condition_._1_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getConditionType_BinaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BinaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (getConditionType_UnaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UnaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (conditionType1EClass, 
		   source, 
		   new String[] {
			 "name", "Condition_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getConditionType1_BinaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BinaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (getConditionType1_UnaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UnaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (constraintEClass, 
		   source, 
		   new String[] {
			 "name", "Constraint",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getConstraint_ToEnforce(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ToEnforce"
		   });	
		addAnnotation
		  (getConstraint_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Condition"
		   });	
		addAnnotation
		  (getConstraint_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Id"
		   });	
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
		  (getDocumentRoot_ConstraintProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ConstraintProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_StrategyProperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "StrategyProperties",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_SYBLElasticityRequirementsDescription(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SYBLElasticityRequirementsDescription",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (leftHandSideTypeEClass, 
		   source, 
		   new String[] {
			 "name", "LeftHandSide_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getLeftHandSideType_Metric(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metric"
		   });	
		addAnnotation
		  (getLeftHandSideType_Number(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Number"
		   });	
		addAnnotation
		  (referenceToTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ReferenceTo_._type",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getReferenceToType_Value(), 
		   source, 
		   new String[] {
			 "name", ":0",
			 "kind", "simple"
		   });	
		addAnnotation
		  (getReferenceToType_Function(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Function"
		   });	
		addAnnotation
		  (getReferenceToType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });	
		addAnnotation
		  (rightHandSideTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RightHandSide_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRightHandSideType_Metric(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metric"
		   });	
		addAnnotation
		  (getRightHandSideType_Number(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Number"
		   });	
		addAnnotation
		  (strategyEClass, 
		   source, 
		   new String[] {
			 "name", "Strategy",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getStrategy_Condition(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Condition"
		   });	
		addAnnotation
		  (getStrategy_ToEnforce(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ToEnforce"
		   });	
		addAnnotation
		  (getStrategy_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Id"
		   });	
		addAnnotation
		  (syblElasticityRequirementsDescriptionEClass, 
		   source, 
		   new String[] {
			 "name", "syblElasticityRequirementsDescription",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSyblElasticityRequirementsDescription_SYBLSpecification(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SYBLSpecification"
		   });	
		addAnnotation
		  (syblSpecificationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "SYBLSpecification_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getSYBLSpecificationType_Constraint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Constraint"
		   });	
		addAnnotation
		  (getSYBLSpecificationType_Strategy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Strategy"
		   });	
		addAnnotation
		  (getSYBLSpecificationType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getSYBLSpecificationType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (toEnforceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ToEnforce_._1_._type",
			 "kind", "empty"
		   });	
		addAnnotation
		  (getToEnforceType_ActionName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ActionName"
		   });	
		addAnnotation
		  (getToEnforceType_Parameter(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Parameter"
		   });	
		addAnnotation
		  (toEnforceType1EClass, 
		   source, 
		   new String[] {
			 "name", "ToEnforce_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getToEnforceType1_BinaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "BinaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (getToEnforceType1_UnaryRestrictionsConjunction(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UnaryRestrictionsConjunction"
		   });	
		addAnnotation
		  (unaryRestrictionEClass, 
		   source, 
		   new String[] {
			 "name", "UnaryRestriction",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getUnaryRestriction_Metric(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metric"
		   });	
		addAnnotation
		  (getUnaryRestriction_ReferenceTo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ReferenceTo"
		   });	
		addAnnotation
		  (getUnaryRestriction_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Type"
		   });
	}

} //SyblPackageImpl
