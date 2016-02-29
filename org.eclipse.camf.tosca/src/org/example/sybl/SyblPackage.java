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
package org.example.sybl;

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
 * @see org.example.sybl.SyblFactory
 * @model kind="package"
 * @generated
 */
public interface SyblPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "sybl";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.example.org/SYBL";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "sybl";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  SyblPackage eINSTANCE = org.example.sybl.impl.SyblPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.BinaryRestrictionImpl <em>Binary Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.BinaryRestrictionImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getBinaryRestriction()
	 * @generated
	 */
  int BINARY_RESTRICTION = 0;

  /**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_RESTRICTION__LEFT_HAND_SIDE = 0;

  /**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_RESTRICTION__RIGHT_HAND_SIDE = 1;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_RESTRICTION__TYPE = 2;

  /**
	 * The number of structural features of the '<em>Binary Restriction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int BINARY_RESTRICTION_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ConditionTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getConditionType()
	 * @generated
	 */
  int CONDITION_TYPE = 1;

  /**
	 * The feature id for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE__BINARY_RESTRICTIONS_CONJUNCTION = 0;

  /**
	 * The feature id for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE__UNARY_RESTRICTIONS_CONJUNCTION = 1;

  /**
	 * The number of structural features of the '<em>Condition Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ConditionType1Impl <em>Condition Type1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ConditionType1Impl
	 * @see org.example.sybl.impl.SyblPackageImpl#getConditionType1()
	 * @generated
	 */
  int CONDITION_TYPE1 = 2;

  /**
	 * The feature id for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION = 0;

  /**
	 * The feature id for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION = 1;

  /**
	 * The number of structural features of the '<em>Condition Type1</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONDITION_TYPE1_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ConstraintImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getConstraint()
	 * @generated
	 */
  int CONSTRAINT = 3;

  /**
	 * The feature id for the '<em><b>To Enforce</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRAINT__TO_ENFORCE = 0;

  /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRAINT__CONDITION = 1;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRAINT__ID = 2;

  /**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int CONSTRAINT_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.DocumentRootImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getDocumentRoot()
	 * @generated
	 */
  int DOCUMENT_ROOT = 4;

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
	 * The feature id for the '<em><b>Constraint Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__CONSTRAINT_PROPERTIES = 3;

  /**
	 * The feature id for the '<em><b>Strategy Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__STRATEGY_PROPERTIES = 4;

  /**
	 * The feature id for the '<em><b>SYBL Elasticity Requirements Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION = 5;

  /**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int DOCUMENT_ROOT_FEATURE_COUNT = 6;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.LeftHandSideTypeImpl <em>Left Hand Side Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.LeftHandSideTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getLeftHandSideType()
	 * @generated
	 */
  int LEFT_HAND_SIDE_TYPE = 5;

  /**
	 * The feature id for the '<em><b>Metric</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEFT_HAND_SIDE_TYPE__METRIC = 0;

  /**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEFT_HAND_SIDE_TYPE__NUMBER = 1;

  /**
	 * The number of structural features of the '<em>Left Hand Side Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int LEFT_HAND_SIDE_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ReferenceToTypeImpl <em>Reference To Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ReferenceToTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getReferenceToType()
	 * @generated
	 */
  int REFERENCE_TO_TYPE = 6;

  /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_TO_TYPE__VALUE = 0;

  /**
	 * The feature id for the '<em><b>Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_TO_TYPE__FUNCTION = 1;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_TO_TYPE__NAME = 2;

  /**
	 * The number of structural features of the '<em>Reference To Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int REFERENCE_TO_TYPE_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.RightHandSideTypeImpl <em>Right Hand Side Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.RightHandSideTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getRightHandSideType()
	 * @generated
	 */
  int RIGHT_HAND_SIDE_TYPE = 7;

  /**
	 * The feature id for the '<em><b>Metric</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RIGHT_HAND_SIDE_TYPE__METRIC = 0;

  /**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RIGHT_HAND_SIDE_TYPE__NUMBER = 1;

  /**
	 * The number of structural features of the '<em>Right Hand Side Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RIGHT_HAND_SIDE_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.StrategyImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getStrategy()
	 * @generated
	 */
  int STRATEGY = 8;

  /**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRATEGY__CONDITION = 0;

  /**
	 * The feature id for the '<em><b>To Enforce</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRATEGY__TO_ENFORCE = 1;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRATEGY__ID = 2;

  /**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int STRATEGY_FEATURE_COUNT = 3;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.SyblElasticityRequirementsDescriptionImpl <em>Elasticity Requirements Description</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.SyblElasticityRequirementsDescriptionImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getSyblElasticityRequirementsDescription()
	 * @generated
	 */
  int SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION = 9;

  /**
	 * The feature id for the '<em><b>SYBL Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION = 0;

  /**
	 * The number of structural features of the '<em>Elasticity Requirements Description</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION_FEATURE_COUNT = 1;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.SYBLSpecificationTypeImpl <em>SYBL Specification Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.SYBLSpecificationTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getSYBLSpecificationType()
	 * @generated
	 */
  int SYBL_SPECIFICATION_TYPE = 10;

  /**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_SPECIFICATION_TYPE__CONSTRAINT = 0;

  /**
	 * The feature id for the '<em><b>Strategy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_SPECIFICATION_TYPE__STRATEGY = 1;

  /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_SPECIFICATION_TYPE__ID = 2;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_SPECIFICATION_TYPE__TYPE = 3;

  /**
	 * The number of structural features of the '<em>SYBL Specification Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SYBL_SPECIFICATION_TYPE_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ToEnforceTypeImpl <em>To Enforce Type</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ToEnforceTypeImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getToEnforceType()
	 * @generated
	 */
  int TO_ENFORCE_TYPE = 11;

  /**
	 * The feature id for the '<em><b>Action Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE__ACTION_NAME = 0;

  /**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE__PARAMETER = 1;

  /**
	 * The number of structural features of the '<em>To Enforce Type</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.ToEnforceType1Impl <em>To Enforce Type1</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.ToEnforceType1Impl
	 * @see org.example.sybl.impl.SyblPackageImpl#getToEnforceType1()
	 * @generated
	 */
  int TO_ENFORCE_TYPE1 = 12;

  /**
	 * The feature id for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION = 0;

  /**
	 * The feature id for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION = 1;

  /**
	 * The number of structural features of the '<em>To Enforce Type1</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int TO_ENFORCE_TYPE1_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.example.sybl.impl.UnaryRestrictionImpl <em>Unary Restriction</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.example.sybl.impl.UnaryRestrictionImpl
	 * @see org.example.sybl.impl.SyblPackageImpl#getUnaryRestriction()
	 * @generated
	 */
  int UNARY_RESTRICTION = 13;

  /**
	 * The feature id for the '<em><b>Metric</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_RESTRICTION__METRIC = 0;

  /**
	 * The feature id for the '<em><b>Reference To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_RESTRICTION__REFERENCE_TO = 1;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_RESTRICTION__TYPE = 2;

  /**
	 * The number of structural features of the '<em>Unary Restriction</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int UNARY_RESTRICTION_FEATURE_COUNT = 3;


  /**
	 * Returns the meta object for class '{@link org.example.sybl.BinaryRestriction <em>Binary Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Restriction</em>'.
	 * @see org.example.sybl.BinaryRestriction
	 * @generated
	 */
  EClass getBinaryRestriction();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.BinaryRestriction#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.example.sybl.BinaryRestriction#getLeftHandSide()
	 * @see #getBinaryRestriction()
	 * @generated
	 */
  EReference getBinaryRestriction_LeftHandSide();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.BinaryRestriction#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Hand Side</em>'.
	 * @see org.example.sybl.BinaryRestriction#getRightHandSide()
	 * @see #getBinaryRestriction()
	 * @generated
	 */
  EReference getBinaryRestriction_RightHandSide();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.BinaryRestriction#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.example.sybl.BinaryRestriction#getType()
	 * @see #getBinaryRestriction()
	 * @generated
	 */
  EAttribute getBinaryRestriction_Type();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Type</em>'.
	 * @see org.example.sybl.ConditionType
	 * @generated
	 */
  EClass getConditionType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ConditionType#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ConditionType#getBinaryRestrictionsConjunction()
	 * @see #getConditionType()
	 * @generated
	 */
  EReference getConditionType_BinaryRestrictionsConjunction();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ConditionType#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ConditionType#getUnaryRestrictionsConjunction()
	 * @see #getConditionType()
	 * @generated
	 */
  EReference getConditionType_UnaryRestrictionsConjunction();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.ConditionType1 <em>Condition Type1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Type1</em>'.
	 * @see org.example.sybl.ConditionType1
	 * @generated
	 */
  EClass getConditionType1();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ConditionType1#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ConditionType1#getBinaryRestrictionsConjunction()
	 * @see #getConditionType1()
	 * @generated
	 */
  EReference getConditionType1_BinaryRestrictionsConjunction();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ConditionType1#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ConditionType1#getUnaryRestrictionsConjunction()
	 * @see #getConditionType1()
	 * @generated
	 */
  EReference getConditionType1_UnaryRestrictionsConjunction();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.example.sybl.Constraint
	 * @generated
	 */
  EClass getConstraint();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.Constraint#getToEnforce <em>To Enforce</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To Enforce</em>'.
	 * @see org.example.sybl.Constraint#getToEnforce()
	 * @see #getConstraint()
	 * @generated
	 */
  EReference getConstraint_ToEnforce();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.Constraint#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.example.sybl.Constraint#getCondition()
	 * @see #getConstraint()
	 * @generated
	 */
  EReference getConstraint_Condition();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.Constraint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.example.sybl.Constraint#getId()
	 * @see #getConstraint()
	 * @generated
	 */
  EAttribute getConstraint_Id();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.example.sybl.DocumentRoot
	 * @generated
	 */
  EClass getDocumentRoot();

  /**
	 * Returns the meta object for the attribute list '{@link org.example.sybl.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.example.sybl.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EAttribute getDocumentRoot_Mixed();

  /**
	 * Returns the meta object for the map '{@link org.example.sybl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.example.sybl.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_XMLNSPrefixMap();

  /**
	 * Returns the meta object for the map '{@link org.example.sybl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.example.sybl.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_XSISchemaLocation();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.DocumentRoot#getConstraintProperties <em>Constraint Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraint Properties</em>'.
	 * @see org.example.sybl.DocumentRoot#getConstraintProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_ConstraintProperties();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.DocumentRoot#getStrategyProperties <em>Strategy Properties</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Strategy Properties</em>'.
	 * @see org.example.sybl.DocumentRoot#getStrategyProperties()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_StrategyProperties();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.DocumentRoot#getSYBLElasticityRequirementsDescription <em>SYBL Elasticity Requirements Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SYBL Elasticity Requirements Description</em>'.
	 * @see org.example.sybl.DocumentRoot#getSYBLElasticityRequirementsDescription()
	 * @see #getDocumentRoot()
	 * @generated
	 */
  EReference getDocumentRoot_SYBLElasticityRequirementsDescription();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.LeftHandSideType <em>Left Hand Side Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Left Hand Side Type</em>'.
	 * @see org.example.sybl.LeftHandSideType
	 * @generated
	 */
  EClass getLeftHandSideType();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.LeftHandSideType#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metric</em>'.
	 * @see org.example.sybl.LeftHandSideType#getMetric()
	 * @see #getLeftHandSideType()
	 * @generated
	 */
  EAttribute getLeftHandSideType_Metric();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.LeftHandSideType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.example.sybl.LeftHandSideType#getNumber()
	 * @see #getLeftHandSideType()
	 * @generated
	 */
  EAttribute getLeftHandSideType_Number();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.ReferenceToType <em>Reference To Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference To Type</em>'.
	 * @see org.example.sybl.ReferenceToType
	 * @generated
	 */
  EClass getReferenceToType();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.ReferenceToType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.example.sybl.ReferenceToType#getValue()
	 * @see #getReferenceToType()
	 * @generated
	 */
  EAttribute getReferenceToType_Value();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.ReferenceToType#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function</em>'.
	 * @see org.example.sybl.ReferenceToType#getFunction()
	 * @see #getReferenceToType()
	 * @generated
	 */
  EAttribute getReferenceToType_Function();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.ReferenceToType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.example.sybl.ReferenceToType#getName()
	 * @see #getReferenceToType()
	 * @generated
	 */
  EAttribute getReferenceToType_Name();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.RightHandSideType <em>Right Hand Side Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Right Hand Side Type</em>'.
	 * @see org.example.sybl.RightHandSideType
	 * @generated
	 */
  EClass getRightHandSideType();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.RightHandSideType#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metric</em>'.
	 * @see org.example.sybl.RightHandSideType#getMetric()
	 * @see #getRightHandSideType()
	 * @generated
	 */
  EAttribute getRightHandSideType_Metric();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.RightHandSideType#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.example.sybl.RightHandSideType#getNumber()
	 * @see #getRightHandSideType()
	 * @generated
	 */
  EAttribute getRightHandSideType_Number();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy</em>'.
	 * @see org.example.sybl.Strategy
	 * @generated
	 */
  EClass getStrategy();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.Strategy#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.example.sybl.Strategy#getCondition()
	 * @see #getStrategy()
	 * @generated
	 */
  EReference getStrategy_Condition();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.Strategy#getToEnforce <em>To Enforce</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To Enforce</em>'.
	 * @see org.example.sybl.Strategy#getToEnforce()
	 * @see #getStrategy()
	 * @generated
	 */
  EReference getStrategy_ToEnforce();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.Strategy#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.example.sybl.Strategy#getId()
	 * @see #getStrategy()
	 * @generated
	 */
  EAttribute getStrategy_Id();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.SyblElasticityRequirementsDescription <em>Elasticity Requirements Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elasticity Requirements Description</em>'.
	 * @see org.example.sybl.SyblElasticityRequirementsDescription
	 * @generated
	 */
  EClass getSyblElasticityRequirementsDescription();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.SyblElasticityRequirementsDescription#getSYBLSpecification <em>SYBL Specification</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SYBL Specification</em>'.
	 * @see org.example.sybl.SyblElasticityRequirementsDescription#getSYBLSpecification()
	 * @see #getSyblElasticityRequirementsDescription()
	 * @generated
	 */
  EReference getSyblElasticityRequirementsDescription_SYBLSpecification();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.SYBLSpecificationType <em>SYBL Specification Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SYBL Specification Type</em>'.
	 * @see org.example.sybl.SYBLSpecificationType
	 * @generated
	 */
  EClass getSYBLSpecificationType();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.SYBLSpecificationType#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see org.example.sybl.SYBLSpecificationType#getConstraint()
	 * @see #getSYBLSpecificationType()
	 * @generated
	 */
  EReference getSYBLSpecificationType_Constraint();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.SYBLSpecificationType#getStrategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Strategy</em>'.
	 * @see org.example.sybl.SYBLSpecificationType#getStrategy()
	 * @see #getSYBLSpecificationType()
	 * @generated
	 */
  EReference getSYBLSpecificationType_Strategy();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.SYBLSpecificationType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.example.sybl.SYBLSpecificationType#getId()
	 * @see #getSYBLSpecificationType()
	 * @generated
	 */
  EAttribute getSYBLSpecificationType_Id();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.SYBLSpecificationType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.example.sybl.SYBLSpecificationType#getType()
	 * @see #getSYBLSpecificationType()
	 * @generated
	 */
  EAttribute getSYBLSpecificationType_Type();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.ToEnforceType <em>To Enforce Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Enforce Type</em>'.
	 * @see org.example.sybl.ToEnforceType
	 * @generated
	 */
  EClass getToEnforceType();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.ToEnforceType#getActionName <em>Action Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Name</em>'.
	 * @see org.example.sybl.ToEnforceType#getActionName()
	 * @see #getToEnforceType()
	 * @generated
	 */
  EAttribute getToEnforceType_ActionName();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.ToEnforceType#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see org.example.sybl.ToEnforceType#getParameter()
	 * @see #getToEnforceType()
	 * @generated
	 */
  EAttribute getToEnforceType_Parameter();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.ToEnforceType1 <em>To Enforce Type1</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Enforce Type1</em>'.
	 * @see org.example.sybl.ToEnforceType1
	 * @generated
	 */
  EClass getToEnforceType1();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ToEnforceType1#getBinaryRestrictionsConjunction <em>Binary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ToEnforceType1#getBinaryRestrictionsConjunction()
	 * @see #getToEnforceType1()
	 * @generated
	 */
  EReference getToEnforceType1_BinaryRestrictionsConjunction();

  /**
	 * Returns the meta object for the containment reference list '{@link org.example.sybl.ToEnforceType1#getUnaryRestrictionsConjunction <em>Unary Restrictions Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Unary Restrictions Conjunction</em>'.
	 * @see org.example.sybl.ToEnforceType1#getUnaryRestrictionsConjunction()
	 * @see #getToEnforceType1()
	 * @generated
	 */
  EReference getToEnforceType1_UnaryRestrictionsConjunction();

  /**
	 * Returns the meta object for class '{@link org.example.sybl.UnaryRestriction <em>Unary Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Restriction</em>'.
	 * @see org.example.sybl.UnaryRestriction
	 * @generated
	 */
  EClass getUnaryRestriction();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.UnaryRestriction#getMetric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metric</em>'.
	 * @see org.example.sybl.UnaryRestriction#getMetric()
	 * @see #getUnaryRestriction()
	 * @generated
	 */
  EAttribute getUnaryRestriction_Metric();

  /**
	 * Returns the meta object for the containment reference '{@link org.example.sybl.UnaryRestriction#getReferenceTo <em>Reference To</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reference To</em>'.
	 * @see org.example.sybl.UnaryRestriction#getReferenceTo()
	 * @see #getUnaryRestriction()
	 * @generated
	 */
  EReference getUnaryRestriction_ReferenceTo();

  /**
	 * Returns the meta object for the attribute '{@link org.example.sybl.UnaryRestriction#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.example.sybl.UnaryRestriction#getType()
	 * @see #getUnaryRestriction()
	 * @generated
	 */
  EAttribute getUnaryRestriction_Type();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  SyblFactory getSyblFactory();

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
		 * The meta object literal for the '{@link org.example.sybl.impl.BinaryRestrictionImpl <em>Binary Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.BinaryRestrictionImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getBinaryRestriction()
		 * @generated
		 */
    EClass BINARY_RESTRICTION = eINSTANCE.getBinaryRestriction();

    /**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference BINARY_RESTRICTION__LEFT_HAND_SIDE = eINSTANCE.getBinaryRestriction_LeftHandSide();

    /**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference BINARY_RESTRICTION__RIGHT_HAND_SIDE = eINSTANCE.getBinaryRestriction_RightHandSide();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute BINARY_RESTRICTION__TYPE = eINSTANCE.getBinaryRestriction_Type();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ConditionTypeImpl <em>Condition Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ConditionTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getConditionType()
		 * @generated
		 */
    EClass CONDITION_TYPE = eINSTANCE.getConditionType();

    /**
		 * The meta object literal for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONDITION_TYPE__BINARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getConditionType_BinaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONDITION_TYPE__UNARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getConditionType_UnaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ConditionType1Impl <em>Condition Type1</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ConditionType1Impl
		 * @see org.example.sybl.impl.SyblPackageImpl#getConditionType1()
		 * @generated
		 */
    EClass CONDITION_TYPE1 = eINSTANCE.getConditionType1();

    /**
		 * The meta object literal for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONDITION_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getConditionType1_BinaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONDITION_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getConditionType1_UnaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ConstraintImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getConstraint()
		 * @generated
		 */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
		 * The meta object literal for the '<em><b>To Enforce</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONSTRAINT__TO_ENFORCE = eINSTANCE.getConstraint_ToEnforce();

    /**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference CONSTRAINT__CONDITION = eINSTANCE.getConstraint_Condition();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute CONSTRAINT__ID = eINSTANCE.getConstraint_Id();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.DocumentRootImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Constraint Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__CONSTRAINT_PROPERTIES = eINSTANCE.getDocumentRoot_ConstraintProperties();

    /**
		 * The meta object literal for the '<em><b>Strategy Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__STRATEGY_PROPERTIES = eINSTANCE.getDocumentRoot_StrategyProperties();

    /**
		 * The meta object literal for the '<em><b>SYBL Elasticity Requirements Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference DOCUMENT_ROOT__SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION = eINSTANCE.getDocumentRoot_SYBLElasticityRequirementsDescription();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.LeftHandSideTypeImpl <em>Left Hand Side Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.LeftHandSideTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getLeftHandSideType()
		 * @generated
		 */
    EClass LEFT_HAND_SIDE_TYPE = eINSTANCE.getLeftHandSideType();

    /**
		 * The meta object literal for the '<em><b>Metric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LEFT_HAND_SIDE_TYPE__METRIC = eINSTANCE.getLeftHandSideType_Metric();

    /**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute LEFT_HAND_SIDE_TYPE__NUMBER = eINSTANCE.getLeftHandSideType_Number();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ReferenceToTypeImpl <em>Reference To Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ReferenceToTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getReferenceToType()
		 * @generated
		 */
    EClass REFERENCE_TO_TYPE = eINSTANCE.getReferenceToType();

    /**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute REFERENCE_TO_TYPE__VALUE = eINSTANCE.getReferenceToType_Value();

    /**
		 * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute REFERENCE_TO_TYPE__FUNCTION = eINSTANCE.getReferenceToType_Function();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute REFERENCE_TO_TYPE__NAME = eINSTANCE.getReferenceToType_Name();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.RightHandSideTypeImpl <em>Right Hand Side Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.RightHandSideTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getRightHandSideType()
		 * @generated
		 */
    EClass RIGHT_HAND_SIDE_TYPE = eINSTANCE.getRightHandSideType();

    /**
		 * The meta object literal for the '<em><b>Metric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RIGHT_HAND_SIDE_TYPE__METRIC = eINSTANCE.getRightHandSideType_Metric();

    /**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RIGHT_HAND_SIDE_TYPE__NUMBER = eINSTANCE.getRightHandSideType_Number();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.StrategyImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getStrategy()
		 * @generated
		 */
    EClass STRATEGY = eINSTANCE.getStrategy();

    /**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference STRATEGY__CONDITION = eINSTANCE.getStrategy_Condition();

    /**
		 * The meta object literal for the '<em><b>To Enforce</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference STRATEGY__TO_ENFORCE = eINSTANCE.getStrategy_ToEnforce();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute STRATEGY__ID = eINSTANCE.getStrategy_Id();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.SyblElasticityRequirementsDescriptionImpl <em>Elasticity Requirements Description</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.SyblElasticityRequirementsDescriptionImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getSyblElasticityRequirementsDescription()
		 * @generated
		 */
    EClass SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION = eINSTANCE.getSyblElasticityRequirementsDescription();

    /**
		 * The meta object literal for the '<em><b>SYBL Specification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION__SYBL_SPECIFICATION = eINSTANCE.getSyblElasticityRequirementsDescription_SYBLSpecification();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.SYBLSpecificationTypeImpl <em>SYBL Specification Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.SYBLSpecificationTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getSYBLSpecificationType()
		 * @generated
		 */
    EClass SYBL_SPECIFICATION_TYPE = eINSTANCE.getSYBLSpecificationType();

    /**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SYBL_SPECIFICATION_TYPE__CONSTRAINT = eINSTANCE.getSYBLSpecificationType_Constraint();

    /**
		 * The meta object literal for the '<em><b>Strategy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference SYBL_SPECIFICATION_TYPE__STRATEGY = eINSTANCE.getSYBLSpecificationType_Strategy();

    /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SYBL_SPECIFICATION_TYPE__ID = eINSTANCE.getSYBLSpecificationType_Id();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SYBL_SPECIFICATION_TYPE__TYPE = eINSTANCE.getSYBLSpecificationType_Type();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ToEnforceTypeImpl <em>To Enforce Type</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ToEnforceTypeImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getToEnforceType()
		 * @generated
		 */
    EClass TO_ENFORCE_TYPE = eINSTANCE.getToEnforceType();

    /**
		 * The meta object literal for the '<em><b>Action Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TO_ENFORCE_TYPE__ACTION_NAME = eINSTANCE.getToEnforceType_ActionName();

    /**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute TO_ENFORCE_TYPE__PARAMETER = eINSTANCE.getToEnforceType_Parameter();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.ToEnforceType1Impl <em>To Enforce Type1</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.ToEnforceType1Impl
		 * @see org.example.sybl.impl.SyblPackageImpl#getToEnforceType1()
		 * @generated
		 */
    EClass TO_ENFORCE_TYPE1 = eINSTANCE.getToEnforceType1();

    /**
		 * The meta object literal for the '<em><b>Binary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TO_ENFORCE_TYPE1__BINARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getToEnforceType1_BinaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '<em><b>Unary Restrictions Conjunction</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference TO_ENFORCE_TYPE1__UNARY_RESTRICTIONS_CONJUNCTION = eINSTANCE.getToEnforceType1_UnaryRestrictionsConjunction();

    /**
		 * The meta object literal for the '{@link org.example.sybl.impl.UnaryRestrictionImpl <em>Unary Restriction</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.example.sybl.impl.UnaryRestrictionImpl
		 * @see org.example.sybl.impl.SyblPackageImpl#getUnaryRestriction()
		 * @generated
		 */
    EClass UNARY_RESTRICTION = eINSTANCE.getUnaryRestriction();

    /**
		 * The meta object literal for the '<em><b>Metric</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute UNARY_RESTRICTION__METRIC = eINSTANCE.getUnaryRestriction_Metric();

    /**
		 * The meta object literal for the '<em><b>Reference To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EReference UNARY_RESTRICTION__REFERENCE_TO = eINSTANCE.getUnaryRestriction_ReferenceTo();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute UNARY_RESTRICTION__TYPE = eINSTANCE.getUnaryRestriction_Type();

  }

} //SyblPackage
