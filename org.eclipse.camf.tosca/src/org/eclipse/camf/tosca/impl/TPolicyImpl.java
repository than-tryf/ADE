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

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.TPolicy;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPolicy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TPolicyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TPolicyImpl#getPolicyRef <em>Policy Ref</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TPolicyImpl#getPolicyType <em>Policy Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPolicyImpl extends TExtensibleElementsImpl implements TPolicy
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPolicyRef() <em>Policy Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolicyRef()
   * @generated
   * @ordered
   */
  protected static final QName POLICY_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPolicyRef() <em>Policy Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolicyRef()
   * @generated
   * @ordered
   */
  protected QName policyRef = POLICY_REF_EDEFAULT;

  /**
   * The default value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolicyType()
   * @generated
   * @ordered
   */
  protected static final QName POLICY_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPolicyType() <em>Policy Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPolicyType()
   * @generated
   * @ordered
   */
  protected QName policyType = POLICY_TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TPolicyImpl()
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
    return ToscaPackage.Literals.TPOLICY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TPOLICY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QName getPolicyRef()
  {
    return policyRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPolicyRef(QName newPolicyRef)
  {
    QName oldPolicyRef = policyRef;
    policyRef = newPolicyRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TPOLICY__POLICY_REF, oldPolicyRef, policyRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QName getPolicyType()
  {
    return policyType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPolicyType(QName newPolicyType)
  {
    QName oldPolicyType = policyType;
    policyType = newPolicyType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TPOLICY__POLICY_TYPE, oldPolicyType, policyType));
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
      case ToscaPackage.TPOLICY__NAME:
        return getName();
      case ToscaPackage.TPOLICY__POLICY_REF:
        return getPolicyRef();
      case ToscaPackage.TPOLICY__POLICY_TYPE:
        return getPolicyType();
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
      case ToscaPackage.TPOLICY__NAME:
        setName((String)newValue);
        return;
      case ToscaPackage.TPOLICY__POLICY_REF:
        setPolicyRef((QName)newValue);
        return;
      case ToscaPackage.TPOLICY__POLICY_TYPE:
        setPolicyType((QName)newValue);
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
      case ToscaPackage.TPOLICY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ToscaPackage.TPOLICY__POLICY_REF:
        setPolicyRef(POLICY_REF_EDEFAULT);
        return;
      case ToscaPackage.TPOLICY__POLICY_TYPE:
        setPolicyType(POLICY_TYPE_EDEFAULT);
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
      case ToscaPackage.TPOLICY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ToscaPackage.TPOLICY__POLICY_REF:
        return POLICY_REF_EDEFAULT == null ? policyRef != null : !POLICY_REF_EDEFAULT.equals(policyRef);
      case ToscaPackage.TPOLICY__POLICY_TYPE:
        return POLICY_TYPE_EDEFAULT == null ? policyType != null : !POLICY_TYPE_EDEFAULT.equals(policyType);
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
    result.append(" (name: "); //$NON-NLS-1$
    result.append(name);
    result.append(", policyRef: "); //$NON-NLS-1$
    result.append(policyRef);
    result.append(", policyType: "); //$NON-NLS-1$
    result.append(policyType);
    result.append(')');
    return result.toString();
  }

} //TPolicyImpl
