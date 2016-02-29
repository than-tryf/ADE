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

import org.eclipse.camf.tosca.ArtifactReferencesType;
import org.eclipse.camf.tosca.TArtifactReference;
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
 * An implementation of the model object '<em><b>Artifact References Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.ArtifactReferencesTypeImpl#getArtifactReference <em>Artifact Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArtifactReferencesTypeImpl extends EObjectImpl implements ArtifactReferencesType
{
  /**
   * The cached value of the '{@link #getArtifactReference() <em>Artifact Reference</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArtifactReference()
   * @generated
   * @ordered
   */
  protected EList<TArtifactReference> artifactReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArtifactReferencesTypeImpl()
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
    return ToscaPackage.Literals.ARTIFACT_REFERENCES_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TArtifactReference> getArtifactReference()
  {
    if (artifactReference == null)
    {
      artifactReference = new EObjectContainmentEList<TArtifactReference>(TArtifactReference.class, this, ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE);
    }
    return artifactReference;
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
      case ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE:
        return ((InternalEList<?>)getArtifactReference()).basicRemove(otherEnd, msgs);
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
      case ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE:
        return getArtifactReference();
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
      case ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE:
        getArtifactReference().clear();
        getArtifactReference().addAll((Collection<? extends TArtifactReference>)newValue);
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
      case ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE:
        getArtifactReference().clear();
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
      case ToscaPackage.ARTIFACT_REFERENCES_TYPE__ARTIFACT_REFERENCE:
        return artifactReference != null && !artifactReference.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ArtifactReferencesTypeImpl
