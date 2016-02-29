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

import org.eclipse.camf.tosca.ExcludeType;
import org.eclipse.camf.tosca.IncludeType;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TArtifact Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl#getInclude <em>Include</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl#getExclude <em>Exclude</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TArtifactReferenceImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TArtifactReferenceImpl extends EObjectImpl implements TArtifactReference
{
  /**
   * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroup()
   * @generated
   * @ordered
   */
  protected FeatureMap group;

  /**
   * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected static final String REFERENCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected String reference = REFERENCE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TArtifactReferenceImpl()
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
    return ToscaPackage.Literals.TARTIFACT_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getGroup()
  {
    if (group == null)
    {
      group = new BasicFeatureMap(this, ToscaPackage.TARTIFACT_REFERENCE__GROUP);
    }
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IncludeType> getInclude()
  {
    return getGroup().list(ToscaPackage.Literals.TARTIFACT_REFERENCE__INCLUDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExcludeType> getExclude()
  {
    return getGroup().list(ToscaPackage.Literals.TARTIFACT_REFERENCE__EXCLUDE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReference(String newReference)
  {
    String oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TARTIFACT_REFERENCE__REFERENCE, oldReference, reference));
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
      case ToscaPackage.TARTIFACT_REFERENCE__GROUP:
        return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TARTIFACT_REFERENCE__INCLUDE:
        return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TARTIFACT_REFERENCE__EXCLUDE:
        return ((InternalEList<?>)getExclude()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.TARTIFACT_REFERENCE__GROUP:
        if (coreType) return getGroup();
        return ((FeatureMap.Internal)getGroup()).getWrapper();
      case ToscaPackage.TARTIFACT_REFERENCE__INCLUDE:
        return getInclude();
      case ToscaPackage.TARTIFACT_REFERENCE__EXCLUDE:
        return getExclude();
      case ToscaPackage.TARTIFACT_REFERENCE__REFERENCE:
        return getReference();
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
      case ToscaPackage.TARTIFACT_REFERENCE__GROUP:
        ((FeatureMap.Internal)getGroup()).set(newValue);
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__INCLUDE:
        getInclude().clear();
        getInclude().addAll((Collection<? extends IncludeType>)newValue);
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__EXCLUDE:
        getExclude().clear();
        getExclude().addAll((Collection<? extends ExcludeType>)newValue);
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__REFERENCE:
        setReference((String)newValue);
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
      case ToscaPackage.TARTIFACT_REFERENCE__GROUP:
        getGroup().clear();
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__INCLUDE:
        getInclude().clear();
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__EXCLUDE:
        getExclude().clear();
        return;
      case ToscaPackage.TARTIFACT_REFERENCE__REFERENCE:
        setReference(REFERENCE_EDEFAULT);
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
      case ToscaPackage.TARTIFACT_REFERENCE__GROUP:
        return group != null && !group.isEmpty();
      case ToscaPackage.TARTIFACT_REFERENCE__INCLUDE:
        return !getInclude().isEmpty();
      case ToscaPackage.TARTIFACT_REFERENCE__EXCLUDE:
        return !getExclude().isEmpty();
      case ToscaPackage.TARTIFACT_REFERENCE__REFERENCE:
        return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
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
    result.append(" (group: "); //$NON-NLS-1$
    result.append(group);
    result.append(", reference: "); //$NON-NLS-1$
    result.append(reference);
    result.append(')');
    return result.toString();
  }

} //TArtifactReferenceImpl
