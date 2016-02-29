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

import org.eclipse.camf.tosca.TCondition;
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
 * An implementation of the model object '<em><b>TCondition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TConditionImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TConditionImpl#getExpressionLanguage <em>Expression Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TConditionImpl extends EObjectImpl implements TCondition
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
   * The default value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionLanguage()
   * @generated
   * @ordered
   */
  protected static final String EXPRESSION_LANGUAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExpressionLanguage() <em>Expression Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionLanguage()
   * @generated
   * @ordered
   */
  protected String expressionLanguage = EXPRESSION_LANGUAGE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TConditionImpl()
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
    return ToscaPackage.Literals.TCONDITION;
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
      any = new BasicFeatureMap(this, ToscaPackage.TCONDITION__ANY);
    }
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExpressionLanguage()
  {
    return expressionLanguage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionLanguage(String newExpressionLanguage)
  {
    String oldExpressionLanguage = expressionLanguage;
    expressionLanguage = newExpressionLanguage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TCONDITION__EXPRESSION_LANGUAGE, oldExpressionLanguage, expressionLanguage));
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
      case ToscaPackage.TCONDITION__ANY:
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
      case ToscaPackage.TCONDITION__ANY:
        if (coreType) return getAny();
        return ((FeatureMap.Internal)getAny()).getWrapper();
      case ToscaPackage.TCONDITION__EXPRESSION_LANGUAGE:
        return getExpressionLanguage();
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
      case ToscaPackage.TCONDITION__ANY:
        ((FeatureMap.Internal)getAny()).set(newValue);
        return;
      case ToscaPackage.TCONDITION__EXPRESSION_LANGUAGE:
        setExpressionLanguage((String)newValue);
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
      case ToscaPackage.TCONDITION__ANY:
        getAny().clear();
        return;
      case ToscaPackage.TCONDITION__EXPRESSION_LANGUAGE:
        setExpressionLanguage(EXPRESSION_LANGUAGE_EDEFAULT);
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
      case ToscaPackage.TCONDITION__ANY:
        return any != null && !any.isEmpty();
      case ToscaPackage.TCONDITION__EXPRESSION_LANGUAGE:
        return EXPRESSION_LANGUAGE_EDEFAULT == null ? expressionLanguage != null : !EXPRESSION_LANGUAGE_EDEFAULT.equals(expressionLanguage);
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
    result.append(", expressionLanguage: "); //$NON-NLS-1$
    result.append(expressionLanguage);
    result.append(')');
    return result.toString();
  }

} //TConditionImpl
