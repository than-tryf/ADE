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

import org.eclipse.camf.tosca.TDocumentation;
import org.eclipse.camf.tosca.TExtensibleElements;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TExtensible Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TExtensibleElementsImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TExtensibleElementsImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TExtensibleElementsImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TExtensibleElementsImpl extends EObjectImpl implements TExtensibleElements
{
  /**
   * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentation()
   * @generated
   * @ordered
   */
  protected EList<TDocumentation> documentation;

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
   * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnyAttribute()
   * @generated
   * @ordered
   */
  protected FeatureMap anyAttribute;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TExtensibleElementsImpl()
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
    return ToscaPackage.Literals.TEXTENSIBLE_ELEMENTS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TDocumentation> getDocumentation()
  {
    if (documentation == null)
    {
      documentation = new EObjectContainmentEList<TDocumentation>(TDocumentation.class, this, ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION);
    }
    return documentation;
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
      any = new BasicFeatureMap(this, ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY);
    }
    return any;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureMap getAnyAttribute()
  {
    if (anyAttribute == null)
    {
      anyAttribute = new BasicFeatureMap(this, ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE);
    }
    return anyAttribute;
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
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION:
        return ((InternalEList<?>)getDocumentation()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY:
        return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE:
        return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION:
        return getDocumentation();
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY:
        if (coreType) return getAny();
        return ((FeatureMap.Internal)getAny()).getWrapper();
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE:
        if (coreType) return getAnyAttribute();
        return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION:
        getDocumentation().clear();
        getDocumentation().addAll((Collection<? extends TDocumentation>)newValue);
        return;
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY:
        ((FeatureMap.Internal)getAny()).set(newValue);
        return;
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE:
        ((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION:
        getDocumentation().clear();
        return;
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY:
        getAny().clear();
        return;
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE:
        getAnyAttribute().clear();
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
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__DOCUMENTATION:
        return documentation != null && !documentation.isEmpty();
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY:
        return any != null && !any.isEmpty();
      case ToscaPackage.TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE:
        return anyAttribute != null && !anyAttribute.isEmpty();
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
    result.append(", anyAttribute: "); //$NON-NLS-1$
    result.append(anyAttribute);
    result.append(')');
    return result.toString();
  }

} //TExtensibleElementsImpl
