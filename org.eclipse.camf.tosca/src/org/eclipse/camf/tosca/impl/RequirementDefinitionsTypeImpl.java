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
package org.eclipse.camf.tosca.impl;

import java.util.Collection;

import org.eclipse.camf.tosca.RequirementDefinitionsType;
import org.eclipse.camf.tosca.TRequirementDefinition;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Definitions Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.RequirementDefinitionsTypeImpl#getRequirementDefinition <em>Requirement Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementDefinitionsTypeImpl extends EObjectImpl implements RequirementDefinitionsType
{
  /**
   * The cached value of the '{@link #getRequirementDefinition() <em>Requirement Definition</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementDefinition()
   * @generated
   * @ordered
   */
  protected EList<TRequirementDefinition> requirementDefinition;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RequirementDefinitionsTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ToscaPackage.Literals.REQUIREMENT_DEFINITIONS_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TRequirementDefinition> getRequirementDefinition()
  {
    if (requirementDefinition == null)
    {
      requirementDefinition = new EObjectContainmentEList<TRequirementDefinition>(TRequirementDefinition.class, this, ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION);
    }
    return requirementDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION:
        return ((InternalEList<?>)getRequirementDefinition()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION:
        return getRequirementDefinition();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION:
        getRequirementDefinition().clear();
        getRequirementDefinition().addAll((Collection<? extends TRequirementDefinition>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION:
        getRequirementDefinition().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ToscaPackage.REQUIREMENT_DEFINITIONS_TYPE__REQUIREMENT_DEFINITION:
        return requirementDefinition != null && !requirementDefinition.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RequirementDefinitionsTypeImpl
