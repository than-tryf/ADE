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

import org.eclipse.camf.tosca.TConstraint;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TConstraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TConstraintImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TConstraintImpl#getConstraintType <em>Constraint Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TConstraintImpl extends EObjectImpl implements TConstraint
{
  /**
   * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAny()
   * @generated
   * @ordered
   */
  protected FeatureMap any;

  /**
   * The default value of the '{@link #getConstraintType() <em>Constraint Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintType()
   * @generated
   * @ordered
   */
  protected static final String CONSTRAINT_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConstraintType() <em>Constraint Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstraintType()
   * @generated
   * @ordered
   */
  protected String constraintType = CONSTRAINT_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TConstraintImpl()
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
    return ToscaPackage.Literals.TCONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getAny()
  {
    if (any == null)
    {
      any = new BasicFeatureMap(this, ToscaPackage.TCONSTRAINT__ANY);
    }
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getConstraintType()
  {
    return constraintType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConstraintType(String newConstraintType)
  {
    String oldConstraintType = constraintType;
    constraintType = newConstraintType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TCONSTRAINT__CONSTRAINT_TYPE, oldConstraintType, constraintType));
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
      case ToscaPackage.TCONSTRAINT__ANY:
        return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.TCONSTRAINT__ANY:
        if (coreType) return getAny();
        return ((FeatureMap.Internal)getAny()).getWrapper();
      case ToscaPackage.TCONSTRAINT__CONSTRAINT_TYPE:
        return getConstraintType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ToscaPackage.TCONSTRAINT__ANY:
        ((FeatureMap.Internal)getAny()).set(newValue);
        return;
      case ToscaPackage.TCONSTRAINT__CONSTRAINT_TYPE:
        setConstraintType((String)newValue);
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
      case ToscaPackage.TCONSTRAINT__ANY:
        getAny().clear();
        return;
      case ToscaPackage.TCONSTRAINT__CONSTRAINT_TYPE:
        setConstraintType(CONSTRAINT_TYPE_EDEFAULT);
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
      case ToscaPackage.TCONSTRAINT__ANY:
        return any != null && !any.isEmpty();
      case ToscaPackage.TCONSTRAINT__CONSTRAINT_TYPE:
        return CONSTRAINT_TYPE_EDEFAULT == null ? constraintType != null : !CONSTRAINT_TYPE_EDEFAULT.equals(constraintType);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (any: "); //$NON-NLS-1$
    result.append(any);
    result.append(", constraintType: "); //$NON-NLS-1$
    result.append(constraintType);
    result.append(')');
    return result.toString();
  }

} //TConstraintImpl
