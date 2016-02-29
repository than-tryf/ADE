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
 * A representation of the model object '<em><b>Script Artifact Properties Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getScriptArtifactPropertiesType()
 * @model extendedMetaData="name='ScriptArtifactPropertiesType' kind='elementOnly'"
 * @generated
 */
public interface ScriptArtifactPropertiesType extends EObject
{
  /**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Language</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getScriptArtifactPropertiesType_Language()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='Language' namespace='##targetNamespace'"
	 * @generated
	 */
  String getLanguage();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
  void setLanguage(String value);

} // ScriptArtifactPropertiesType
