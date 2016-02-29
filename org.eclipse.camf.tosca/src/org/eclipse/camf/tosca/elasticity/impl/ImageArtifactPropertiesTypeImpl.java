/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
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
package org.eclipse.camf.tosca.elasticity.impl;

import org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Artifact Properties Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.ImageArtifactPropertiesTypeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageArtifactPropertiesTypeImpl extends EObjectImpl implements ImageArtifactPropertiesType
{
  /**
	 * An array of objects representing the values of non-primitive features.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Object[] eVirtualValues;

  /**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected int eVirtualIndexBits0;

  /**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
  protected static final String ID_EDEFAULT = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ImageArtifactPropertiesTypeImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.IMAGE_ARTIFACT_PROPERTIES_TYPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getDescription()
  {
		return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION, DESCRIPTION_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDescription(String newDescription)
  {
		String description = newDescription;
		Object oldDescription = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION, description);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION, oldDescription == EVIRTUAL_NO_VALUE ? DESCRIPTION_EDEFAULT : oldDescription, description));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getId()
  {
		return (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID, ID_EDEFAULT);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setId(String newId)
  {
		String id = newId;
		Object oldId = eVirtualSet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID, id);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID, oldId == EVIRTUAL_NO_VALUE ? ID_EDEFAULT : oldId, id));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION:
				return getDescription();
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID:
				return getId();
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID:
				setId((String)newValue);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID:
				setId(ID_EDEFAULT);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION:
				String description = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION, DESCRIPTION_EDEFAULT);
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID:
				String id = (String)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID, ID_EDEFAULT);
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Object[] eVirtualValues()
  {
		return eVirtualValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualValues(Object[] newValues)
  {
		eVirtualValues = newValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected int eVirtualIndexBits(int offset)
  {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualIndexBits(int offset, int newIndexBits)
  {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(" (description: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__DESCRIPTION, DESCRIPTION_EDEFAULT));
		result.append(", id: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.IMAGE_ARTIFACT_PROPERTIES_TYPE__ID, ID_EDEFAULT));
		result.append(')');
		return result.toString();
	}

} //ImageArtifactPropertiesTypeImpl
