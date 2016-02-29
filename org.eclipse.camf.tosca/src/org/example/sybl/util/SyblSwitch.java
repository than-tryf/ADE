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
package org.example.sybl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.example.sybl.*;

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
 * @see org.example.sybl.SyblPackage
 * @generated
 */
public class SyblSwitch<T> extends Switch<T>
{
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static SyblPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblSwitch()
  {
		if (modelPackage == null) {
			modelPackage = SyblPackage.eINSTANCE;
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
			case SyblPackage.BINARY_RESTRICTION: {
				BinaryRestriction binaryRestriction = (BinaryRestriction)theEObject;
				T result = caseBinaryRestriction(binaryRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.CONDITION_TYPE: {
				ConditionType conditionType = (ConditionType)theEObject;
				T result = caseConditionType(conditionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.CONDITION_TYPE1: {
				ConditionType1 conditionType1 = (ConditionType1)theEObject;
				T result = caseConditionType1(conditionType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.LEFT_HAND_SIDE_TYPE: {
				LeftHandSideType leftHandSideType = (LeftHandSideType)theEObject;
				T result = caseLeftHandSideType(leftHandSideType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.REFERENCE_TO_TYPE: {
				ReferenceToType referenceToType = (ReferenceToType)theEObject;
				T result = caseReferenceToType(referenceToType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.RIGHT_HAND_SIDE_TYPE: {
				RightHandSideType rightHandSideType = (RightHandSideType)theEObject;
				T result = caseRightHandSideType(rightHandSideType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.STRATEGY: {
				Strategy strategy = (Strategy)theEObject;
				T result = caseStrategy(strategy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.SYBL_ELASTICITY_REQUIREMENTS_DESCRIPTION: {
				SyblElasticityRequirementsDescription syblElasticityRequirementsDescription = (SyblElasticityRequirementsDescription)theEObject;
				T result = caseSyblElasticityRequirementsDescription(syblElasticityRequirementsDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.SYBL_SPECIFICATION_TYPE: {
				SYBLSpecificationType syblSpecificationType = (SYBLSpecificationType)theEObject;
				T result = caseSYBLSpecificationType(syblSpecificationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.TO_ENFORCE_TYPE: {
				ToEnforceType toEnforceType = (ToEnforceType)theEObject;
				T result = caseToEnforceType(toEnforceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.TO_ENFORCE_TYPE1: {
				ToEnforceType1 toEnforceType1 = (ToEnforceType1)theEObject;
				T result = caseToEnforceType1(toEnforceType1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SyblPackage.UNARY_RESTRICTION: {
				UnaryRestriction unaryRestriction = (UnaryRestriction)theEObject;
				T result = caseUnaryRestriction(unaryRestriction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Restriction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBinaryRestriction(BinaryRestriction object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConditionType(ConditionType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Type1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConditionType1(ConditionType1 object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseConstraint(Constraint object)
  {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Left Hand Side Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Left Hand Side Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseLeftHandSideType(LeftHandSideType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference To Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference To Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseReferenceToType(ReferenceToType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Right Hand Side Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Right Hand Side Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRightHandSideType(RightHandSideType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStrategy(Strategy object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Elasticity Requirements Description</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Elasticity Requirements Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSyblElasticityRequirementsDescription(SyblElasticityRequirementsDescription object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>SYBL Specification Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SYBL Specification Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSYBLSpecificationType(SYBLSpecificationType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>To Enforce Type</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Enforce Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseToEnforceType(ToEnforceType object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>To Enforce Type1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Enforce Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseToEnforceType1(ToEnforceType1 object)
  {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Restriction</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Restriction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUnaryRestriction(UnaryRestriction object)
  {
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

} //SyblSwitch
