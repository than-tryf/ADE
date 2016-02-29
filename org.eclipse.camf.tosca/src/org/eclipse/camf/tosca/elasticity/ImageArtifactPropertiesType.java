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
package org.eclipse.camf.tosca.elasticity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Artifact Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType()
 * @model extendedMetaData="name='ImageArtifactPropertiesType' kind='elementOnly'"
 * @generated
 */
public interface ImageArtifactPropertiesType extends EObject
{
  /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Description' namespace='##targetNamespace'"
	 * @generated
	 */
  String getDescription();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
  void setDescription(String value);

  /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getImageArtifactPropertiesType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Id' namespace='##targetNamespace'"
	 * @generated
	 */
  String getId();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.ImageArtifactPropertiesType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(String value);

} // ImageArtifactPropertiesType
