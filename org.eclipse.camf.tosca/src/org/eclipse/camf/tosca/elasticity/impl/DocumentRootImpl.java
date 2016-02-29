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

import org.eclipse.camf.tosca.elasticity.DocumentRoot;
import org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.ServicePropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getImageArtifactProperties <em>Image Artifact Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getNodeProperties <em>Node Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getScriptArtifactProperties <em>Script Artifact Properties</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.DocumentRootImpl#getServiceProperties <em>Service Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends EObjectImpl implements DocumentRoot
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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DocumentRootImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public FeatureMap getMixed()
  {
		FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
		if (mixed == null) {
			eVirtualSet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED, mixed = new BasicFeatureMap(this, Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
		}
		return mixed;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EMap<String, String> getXMLNSPrefixMap()
  {
		EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		if (xMLNSPrefixMap == null) {
			eVirtualSet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP, xMLNSPrefixMap = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP));
		}
		return xMLNSPrefixMap;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  public EMap<String, String> getXSISchemaLocation()
  {
		EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		if (xSISchemaLocation == null) {
			eVirtualSet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION, xSISchemaLocation = new EcoreEMap<String,String>(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION));
		}
		return xSISchemaLocation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ImageArtifactPropertiesType getImageArtifactProperties()
  {
		return (ImageArtifactPropertiesType)getMixed().get(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES, true);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetImageArtifactProperties(ImageArtifactPropertiesType newImageArtifactProperties, NotificationChain msgs)
  {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES, newImageArtifactProperties, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setImageArtifactProperties(ImageArtifactPropertiesType newImageArtifactProperties)
  {
		((FeatureMap.Internal)getMixed()).set(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES, newImageArtifactProperties);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NodePropertiesType getNodeProperties()
  {
		return (NodePropertiesType)getMixed().get(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__NODE_PROPERTIES, true);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetNodeProperties(NodePropertiesType newNodeProperties, NotificationChain msgs)
  {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__NODE_PROPERTIES, newNodeProperties, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNodeProperties(NodePropertiesType newNodeProperties)
  {
		((FeatureMap.Internal)getMixed()).set(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__NODE_PROPERTIES, newNodeProperties);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ScriptArtifactPropertiesType getScriptArtifactProperties()
  {
		return (ScriptArtifactPropertiesType)getMixed().get(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES, true);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetScriptArtifactProperties(ScriptArtifactPropertiesType newScriptArtifactProperties, NotificationChain msgs)
  {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES, newScriptArtifactProperties, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScriptArtifactProperties(ScriptArtifactPropertiesType newScriptArtifactProperties)
  {
		((FeatureMap.Internal)getMixed()).set(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES, newScriptArtifactProperties);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ServicePropertiesType getServiceProperties()
  {
		return (ServicePropertiesType)getMixed().get(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SERVICE_PROPERTIES, true);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetServiceProperties(ServicePropertiesType newServiceProperties, NotificationChain msgs)
  {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SERVICE_PROPERTIES, newServiceProperties, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setServiceProperties(ServicePropertiesType newServiceProperties)
  {
		((FeatureMap.Internal)getMixed()).set(Tosca_Elasticity_ExtensionsPackage.Literals.DOCUMENT_ROOT__SERVICE_PROPERTIES, newServiceProperties);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
				return ((InternalEList<?>)getMixed()).basicRemove(otherEnd, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList<?>)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList<?>)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES:
				return basicSetImageArtifactProperties(null, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__NODE_PROPERTIES:
				return basicSetNodeProperties(null, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES:
				return basicSetScriptArtifactProperties(null, msgs);
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SERVICE_PROPERTIES:
				return basicSetServiceProperties(null, msgs);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES:
				return getImageArtifactProperties();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__NODE_PROPERTIES:
				return getNodeProperties();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES:
				return getScriptArtifactProperties();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SERVICE_PROPERTIES:
				return getServiceProperties();
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
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES:
				setImageArtifactProperties((ImageArtifactPropertiesType)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__NODE_PROPERTIES:
				setNodeProperties((NodePropertiesType)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES:
				setScriptArtifactProperties((ScriptArtifactPropertiesType)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SERVICE_PROPERTIES:
				setServiceProperties((ServicePropertiesType)newValue);
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
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
				getMixed().clear();
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES:
				setImageArtifactProperties((ImageArtifactPropertiesType)null);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__NODE_PROPERTIES:
				setNodeProperties((NodePropertiesType)null);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES:
				setScriptArtifactProperties((ScriptArtifactPropertiesType)null);
				return;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SERVICE_PROPERTIES:
				setServiceProperties((ServicePropertiesType)null);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED:
				FeatureMap mixed = (FeatureMap)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED);
				return mixed != null && !mixed.isEmpty();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
				EMap<String, String> xMLNSPrefixMap = (EMap<String, String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
				EMap<String, String> xSISchemaLocation = (EMap<String, String>)eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__IMAGE_ARTIFACT_PROPERTIES:
				return getImageArtifactProperties() != null;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__NODE_PROPERTIES:
				return getNodeProperties() != null;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SCRIPT_ARTIFACT_PROPERTIES:
				return getScriptArtifactProperties() != null;
			case Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__SERVICE_PROPERTIES:
				return getServiceProperties() != null;
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
		result.append(" (mixed: ");
		result.append(eVirtualGet(Tosca_Elasticity_ExtensionsPackage.DOCUMENT_ROOT__MIXED));
		result.append(')');
		return result.toString();
	}

} //DocumentRootImpl
