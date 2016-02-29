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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.example.sybl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SyblFactoryImpl extends EFactoryImpl implements SyblFactory
{
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static SyblFactory init()
  {
		try {
			SyblFactory theSyblFactory = (SyblFactory)EPackage.Registry.INSTANCE.getEFactory(SyblPackage.eNS_URI);
			if (theSyblFactory != null) {
				return theSyblFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SyblFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblFactoryImpl()
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
			case SyblPackage.BINARY_RESTRICTION: return createBinaryRestriction();
			case SyblPackage.CONDITION_TYPE: return createConditionType();
			case SyblPackage.CONDITION_TYPE1: return createConditionType1();
			case SyblPackage.CONSTRAINT: return createConstraint();
			case SyblPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case SyblPackage.LEFT_HAND_SIDE_TYPE: return createLeftHandSideType();
			case SyblPackage.REFERENCE_TO_TYPE: return createReferenceToType();
			case SyblPackage.RIGHT_HAND_SIDE_TYPE: return createRightHandSideType();
			case SyblPackage.STRATEGY: return createStrategy();
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION: return createSyblElasticityRequirementsDescription();
			case SyblPackage.SYBL_SPECIFICATION_TYPE: return createSYBLSpecificationType();
			case SyblPackage.TO_ENFORCE_TYPE: return createToEnforceType();
			case SyblPackage.TO_ENFORCE_TYPE1: return createToEnforceType1();
			case SyblPackage.UNARY_RESTRICTION: return createUnaryRestriction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BinaryRestriction createBinaryRestriction()
  {
		BinaryRestrictionImpl binaryRestriction = new BinaryRestrictionImpl();
		return binaryRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConditionType createConditionType()
  {
		ConditionTypeImpl conditionType = new ConditionTypeImpl();
		return conditionType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConditionType1 createConditionType1()
  {
		ConditionType1Impl conditionType1 = new ConditionType1Impl();
		return conditionType1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Constraint createConstraint()
  {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
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
  public LeftHandSideType createLeftHandSideType()
  {
		LeftHandSideTypeImpl leftHandSideType = new LeftHandSideTypeImpl();
		return leftHandSideType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ReferenceToType createReferenceToType()
  {
		ReferenceToTypeImpl referenceToType = new ReferenceToTypeImpl();
		return referenceToType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RightHandSideType createRightHandSideType()
  {
		RightHandSideTypeImpl rightHandSideType = new RightHandSideTypeImpl();
		return rightHandSideType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Strategy createStrategy()
  {
		StrategyImpl strategy = new StrategyImpl();
		return strategy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblElasticityRequirementsDescription createSyblElasticityRequirementsDescription()
  {
		SyblElasticityRequirementsDescriptionImpl syblElasticityRequirementsDescription = new SyblElasticityRequirementsDescriptionImpl();
		return syblElasticityRequirementsDescription;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SYBLSpecificationType createSYBLSpecificationType()
  {
		SYBLSpecificationTypeImpl syblSpecificationType = new SYBLSpecificationTypeImpl();
		return syblSpecificationType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ToEnforceType createToEnforceType()
  {
		ToEnforceTypeImpl toEnforceType = new ToEnforceTypeImpl();
		return toEnforceType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ToEnforceType1 createToEnforceType1()
  {
		ToEnforceType1Impl toEnforceType1 = new ToEnforceType1Impl();
		return toEnforceType1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public UnaryRestriction createUnaryRestriction()
  {
		UnaryRestrictionImpl unaryRestriction = new UnaryRestrictionImpl();
		return unaryRestriction;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblPackage getSyblPackage()
  {
		return (SyblPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static SyblPackage getPackage()
  {
		return SyblPackage.eINSTANCE;
	}

} //SyblFactoryImpl
