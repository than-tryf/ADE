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

import org.eclipse.camf.tosca.DerivedFromType;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derived From Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.DerivedFromTypeImpl#getRelationshipTypeImplementationRef <em>Relationship Type Implementation Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedFromTypeImpl extends EObjectImpl implements DerivedFromType
{
  /**
   * The default value of the '{@link #getRelationshipTypeImplementationRef() <em>Relationship Type Implementation Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationshipTypeImplementationRef()
   * @generated
   * @ordered
   */
  protected static final QName RELATIONSHIP_TYPE_IMPLEMENTATION_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRelationshipTypeImplementationRef() <em>Relationship Type Implementation Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelationshipTypeImplementationRef()
   * @generated
   * @ordered
   */
  protected QName relationshipTypeImplementationRef = RELATIONSHIP_TYPE_IMPLEMENTATION_REF_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DerivedFromTypeImpl()
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
    return ToscaPackage.Literals.DERIVED_FROM_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QName getRelationshipTypeImplementationRef()
  {
    return relationshipTypeImplementationRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelationshipTypeImplementationRef(QName newRelationshipTypeImplementationRef)
  {
    QName oldRelationshipTypeImplementationRef = relationshipTypeImplementationRef;
    relationshipTypeImplementationRef = newRelationshipTypeImplementationRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF, oldRelationshipTypeImplementationRef, relationshipTypeImplementationRef));
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
      case ToscaPackage.DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF:
        return getRelationshipTypeImplementationRef();
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
      case ToscaPackage.DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF:
        setRelationshipTypeImplementationRef((QName)newValue);
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
      case ToscaPackage.DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF:
        setRelationshipTypeImplementationRef(RELATIONSHIP_TYPE_IMPLEMENTATION_REF_EDEFAULT);
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
      case ToscaPackage.DERIVED_FROM_TYPE__RELATIONSHIP_TYPE_IMPLEMENTATION_REF:
        return RELATIONSHIP_TYPE_IMPLEMENTATION_REF_EDEFAULT == null ? relationshipTypeImplementationRef != null : !RELATIONSHIP_TYPE_IMPLEMENTATION_REF_EDEFAULT.equals(relationshipTypeImplementationRef);
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
    result.append(" (relationshipTypeImplementationRef: "); //$NON-NLS-1$
    result.append(relationshipTypeImplementationRef);
    result.append(')');
    return result.toString();
  }

} //DerivedFromTypeImpl
