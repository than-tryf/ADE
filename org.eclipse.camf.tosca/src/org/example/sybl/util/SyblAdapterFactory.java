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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.example.sybl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.example.sybl.SyblPackage
 * @generated
 */
public class SyblAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static SyblPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SyblAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = SyblPackage.eINSTANCE;
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
  protected SyblSwitch<Adapter> modelSwitch =
    new SyblSwitch<Adapter>() {
			@Override
			public Adapter caseBinaryRestriction(BinaryRestriction object) {
				return createBinaryRestrictionAdapter();
			}
			@Override
			public Adapter caseConditionType(ConditionType object) {
				return createConditionTypeAdapter();
			}
			@Override
			public Adapter caseConditionType1(ConditionType1 object) {
				return createConditionType1Adapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseLeftHandSideType(LeftHandSideType object) {
				return createLeftHandSideTypeAdapter();
			}
			@Override
			public Adapter caseReferenceToType(ReferenceToType object) {
				return createReferenceToTypeAdapter();
			}
			@Override
			public Adapter caseRightHandSideType(RightHandSideType object) {
				return createRightHandSideTypeAdapter();
			}
			@Override
			public Adapter caseStrategy(Strategy object) {
				return createStrategyAdapter();
			}
			@Override
			public Adapter caseSyblElasticityRequirementsDescription(SyblElasticityRequirementsDescription object) {
				return createSyblElasticityRequirementsDescriptionAdapter();
			}
			@Override
			public Adapter caseSYBLSpecificationType(SYBLSpecificationType object) {
				return createSYBLSpecificationTypeAdapter();
			}
			@Override
			public Adapter caseToEnforceType(ToEnforceType object) {
				return createToEnforceTypeAdapter();
			}
			@Override
			public Adapter caseToEnforceType1(ToEnforceType1 object) {
				return createToEnforceType1Adapter();
			}
			@Override
			public Adapter caseUnaryRestriction(UnaryRestriction object) {
				return createUnaryRestrictionAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.example.sybl.BinaryRestriction <em>Binary Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.BinaryRestriction
	 * @generated
	 */
  public Adapter createBinaryRestrictionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.ConditionType
	 * @generated
	 */
  public Adapter createConditionTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.ConditionType1 <em>Condition Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.ConditionType1
	 * @generated
	 */
  public Adapter createConditionType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.Constraint
	 * @generated
	 */
  public Adapter createConstraintAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.DocumentRoot
	 * @generated
	 */
  public Adapter createDocumentRootAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.LeftHandSideType <em>Left Hand Side Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.LeftHandSideType
	 * @generated
	 */
  public Adapter createLeftHandSideTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.ReferenceToType <em>Reference To Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.ReferenceToType
	 * @generated
	 */
  public Adapter createReferenceToTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.RightHandSideType <em>Right Hand Side Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.RightHandSideType
	 * @generated
	 */
  public Adapter createRightHandSideTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.Strategy
	 * @generated
	 */
  public Adapter createStrategyAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.SyblElasticityRequirementsDescription <em>Elasticity Requirements Description</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.SyblElasticityRequirementsDescription
	 * @generated
	 */
  public Adapter createSyblElasticityRequirementsDescriptionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.SYBLSpecificationType <em>SYBL Specification Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.SYBLSpecificationType
	 * @generated
	 */
  public Adapter createSYBLSpecificationTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.ToEnforceType <em>To Enforce Type</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.ToEnforceType
	 * @generated
	 */
  public Adapter createToEnforceTypeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.ToEnforceType1 <em>To Enforce Type1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.ToEnforceType1
	 * @generated
	 */
  public Adapter createToEnforceType1Adapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link org.example.sybl.UnaryRestriction <em>Unary Restriction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.example.sybl.UnaryRestriction
	 * @generated
	 */
  public Adapter createUnaryRestrictionAdapter()
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

} //SyblAdapterFactory
