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

import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTopology Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.TTopologyTemplateImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TTopologyTemplateImpl#getNodeTemplate <em>Node Template</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.TTopologyTemplateImpl#getRelationshipTemplate <em>Relationship Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTopologyTemplateImpl extends TExtensibleElementsImpl implements TTopologyTemplate
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TTopologyTemplateImpl()
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
    return ToscaPackage.Literals.TTOPOLOGY_TEMPLATE;
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
      group = new BasicFeatureMap(this, ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP);
    }
    return group;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TNodeTemplate> getNodeTemplate()
  {
    return getGroup().list(ToscaPackage.Literals.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TRelationshipTemplate> getRelationshipTemplate()
  {
    return getGroup().list(ToscaPackage.Literals.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE);
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
      case ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP:
        return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE:
        return ((InternalEList<?>)getNodeTemplate()).basicRemove(otherEnd, msgs);
      case ToscaPackage.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE:
        return ((InternalEList<?>)getRelationshipTemplate()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP:
        if (coreType) return getGroup();
        return ((FeatureMap.Internal)getGroup()).getWrapper();
      case ToscaPackage.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE:
        return getNodeTemplate();
      case ToscaPackage.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE:
        return getRelationshipTemplate();
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
      case ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP:
        ((FeatureMap.Internal)getGroup()).set(newValue);
        return;
      case ToscaPackage.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE:
        getNodeTemplate().clear();
        getNodeTemplate().addAll((Collection<? extends TNodeTemplate>)newValue);
        return;
      case ToscaPackage.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE:
        getRelationshipTemplate().clear();
        getRelationshipTemplate().addAll((Collection<? extends TRelationshipTemplate>)newValue);
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
      case ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP:
        getGroup().clear();
        return;
      case ToscaPackage.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE:
        getNodeTemplate().clear();
        return;
      case ToscaPackage.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE:
        getRelationshipTemplate().clear();
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
      case ToscaPackage.TTOPOLOGY_TEMPLATE__GROUP:
        return group != null && !group.isEmpty();
      case ToscaPackage.TTOPOLOGY_TEMPLATE__NODE_TEMPLATE:
        return !getNodeTemplate().isEmpty();
      case ToscaPackage.TTOPOLOGY_TEMPLATE__RELATIONSHIP_TEMPLATE:
        return !getRelationshipTemplate().isEmpty();
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
    result.append(')');
    return result.toString();
  }

} //TTopologyTemplateImpl
