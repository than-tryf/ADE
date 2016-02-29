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

import org.eclipse.camf.tosca.TPlan;
import org.eclipse.camf.tosca.TPlans;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPlans</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TPlansImpl#getPlan <em>Plan</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TPlansImpl#getTargetNamespace <em>Target Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPlansImpl extends EObjectImpl implements TPlans
{
  /**
   * The cached value of the '{@link #getPlan() <em>Plan</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlan()
   * @generated
   * @ordered
   */
  protected EList<TPlan> plan;

  /**
   * The default value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNamespace()
   * @generated
   * @ordered
   */
  protected static final String TARGET_NAMESPACE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetNamespace() <em>Target Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNamespace()
   * @generated
   * @ordered
   */
  protected String targetNamespace = TARGET_NAMESPACE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TPlansImpl()
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
    return ToscaPackage.Literals.TPLANS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TPlan> getPlan()
  {
    if (plan == null)
    {
      plan = new EObjectContainmentEList<TPlan>(TPlan.class, this, ToscaPackage.TPLANS__PLAN);
    }
    return plan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetNamespace()
  {
    return targetNamespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetNamespace(String newTargetNamespace)
  {
    String oldTargetNamespace = targetNamespace;
    targetNamespace = newTargetNamespace;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TPLANS__TARGET_NAMESPACE, oldTargetNamespace, targetNamespace));
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
      case ToscaPackage.TPLANS__PLAN:
        return ((InternalEList<?>)getPlan()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.TPLANS__PLAN:
        return getPlan();
      case ToscaPackage.TPLANS__TARGET_NAMESPACE:
        return getTargetNamespace();
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
      case ToscaPackage.TPLANS__PLAN:
        getPlan().clear();
        getPlan().addAll((Collection<? extends TPlan>)newValue);
        return;
      case ToscaPackage.TPLANS__TARGET_NAMESPACE:
        setTargetNamespace((String)newValue);
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
      case ToscaPackage.TPLANS__PLAN:
        getPlan().clear();
        return;
      case ToscaPackage.TPLANS__TARGET_NAMESPACE:
        setTargetNamespace(TARGET_NAMESPACE_EDEFAULT);
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
      case ToscaPackage.TPLANS__PLAN:
        return plan != null && !plan.isEmpty();
      case ToscaPackage.TPLANS__TARGET_NAMESPACE:
        return TARGET_NAMESPACE_EDEFAULT == null ? targetNamespace != null : !TARGET_NAMESPACE_EDEFAULT.equals(targetNamespace);
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
    result.append(" (targetNamespace: "); //$NON-NLS-1$
    result.append(targetNamespace);
    result.append(')');
    return result.toString();
  }

} //TPlansImpl
