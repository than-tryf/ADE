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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.example.sybl.SyblPackage
 * @generated
 */
public interface SyblFactory extends EFactory
{
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  SyblFactory eINSTANCE = org.example.sybl.impl.SyblFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Binary Restriction</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Restriction</em>'.
	 * @generated
	 */
  BinaryRestriction createBinaryRestriction();

  /**
	 * Returns a new object of class '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Type</em>'.
	 * @generated
	 */
  ConditionType createConditionType();

  /**
	 * Returns a new object of class '<em>Condition Type1</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Type1</em>'.
	 * @generated
	 */
  ConditionType1 createConditionType1();

  /**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
  Constraint createConstraint();

  /**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
  DocumentRoot createDocumentRoot();

  /**
	 * Returns a new object of class '<em>Left Hand Side Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Left Hand Side Type</em>'.
	 * @generated
	 */
  LeftHandSideType createLeftHandSideType();

  /**
	 * Returns a new object of class '<em>Reference To Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference To Type</em>'.
	 * @generated
	 */
  ReferenceToType createReferenceToType();

  /**
	 * Returns a new object of class '<em>Right Hand Side Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Right Hand Side Type</em>'.
	 * @generated
	 */
  RightHandSideType createRightHandSideType();

  /**
	 * Returns a new object of class '<em>Strategy</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Strategy</em>'.
	 * @generated
	 */
  Strategy createStrategy();

  /**
	 * Returns a new object of class '<em>Elasticity Requirements Description</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Elasticity Requirements Description</em>'.
	 * @generated
	 */
  SyblElasticityRequirementsDescription createSyblElasticityRequirementsDescription();

  /**
	 * Returns a new object of class '<em>SYBL Specification Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>SYBL Specification Type</em>'.
	 * @generated
	 */
  SYBLSpecificationType createSYBLSpecificationType();

  /**
	 * Returns a new object of class '<em>To Enforce Type</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Enforce Type</em>'.
	 * @generated
	 */
  ToEnforceType createToEnforceType();

  /**
	 * Returns a new object of class '<em>To Enforce Type1</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Enforce Type1</em>'.
	 * @generated
	 */
  ToEnforceType1 createToEnforceType1();

  /**
	 * Returns a new object of class '<em>Unary Restriction</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Restriction</em>'.
	 * @generated
	 */
  UnaryRestriction createUnaryRestriction();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  SyblPackage getSyblPackage();

} //SyblFactory
