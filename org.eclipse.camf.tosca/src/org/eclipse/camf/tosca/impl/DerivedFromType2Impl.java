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

import org.eclipse.camf.tosca.DerivedFromType2;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived From Type2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.DerivedFromType2Impl#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedFromType2Impl extends EObjectImpl implements DerivedFromType2
{
  /**
   * The default value of the '{@link #getTypeRef() <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected static final QName TYPE_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected QName typeRef = TYPE_REF_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DerivedFromType2Impl()
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
    return ToscaPackage.Literals.DERIVED_FROM_TYPE2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QName getTypeRef()
  {
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeRef(QName newTypeRef)
  {
    QName oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.DERIVED_FROM_TYPE2__TYPE_REF, oldTypeRef, typeRef));
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
      case ToscaPackage.DERIVED_FROM_TYPE2__TYPE_REF:
        return getTypeRef();
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
      case ToscaPackage.DERIVED_FROM_TYPE2__TYPE_REF:
        setTypeRef((QName)newValue);
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
      case ToscaPackage.DERIVED_FROM_TYPE2__TYPE_REF:
        setTypeRef(TYPE_REF_EDEFAULT);
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
      case ToscaPackage.DERIVED_FROM_TYPE2__TYPE_REF:
        return TYPE_REF_EDEFAULT == null ? typeRef != null : !TYPE_REF_EDEFAULT.equals(typeRef);
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
    result.append(" (typeRef: "); //$NON-NLS-1$
    result.append(typeRef);
    result.append(')');
    return result.toString();
  }

} //DerivedFromType2Impl
