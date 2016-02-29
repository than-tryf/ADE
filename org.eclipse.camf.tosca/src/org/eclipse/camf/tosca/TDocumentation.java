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
package org.eclipse.camf.tosca;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDocumentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TDocumentation#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TDocumentation#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TDocumentation#getLang <em>Lang</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TDocumentation#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTDocumentation()
 * @model extendedMetaData="name='tDocumentation' kind='mixed'"
 * @generated
 */
public interface TDocumentation extends EObject
{
  /**
   * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mixed</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTDocumentation_Mixed()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
   *        extendedMetaData="kind='elementWildcard' name=':mixed'"
   * @generated
   */
  FeatureMap getMixed();

  /**
   * Returns the value of the '<em><b>Any</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Any</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Any</em>' attribute list.
   * @see org.eclipse.camf.tosca.ToscaPackage#getTDocumentation_Any()
   * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true" transient="true" volatile="true" derived="true"
   *        extendedMetaData="kind='elementWildcard' wildcards='##any' name=':1' processing='lax'"
   * @generated
   */
  FeatureMap getAny();

  /**
   * Returns the value of the '<em><b>Lang</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * 
   *     <div xmlns="http://www.w3.org/1999/xhtml">
   *      
   *       <h3>lang (as an attribute name)</h3>
   *       <p>
   *        denotes an attribute whose value
   *        is a language code for the natural language of the content of
   *        any element; its value is inherited.  This name is reserved
   *        by virtue of its definition in the XML specification.</p>
   *      
   *     </div>
   *     <div xmlns="http://www.w3.org/1999/xhtml">
   *      <h4>Notes</h4>
   *      <p>
   *       Attempting to install the relevant ISO 2- and 3-letter
   *       codes as the enumerated possible values is probably never
   *       going to be a realistic possibility.  
   *      </p>
   *      <p>
   *       See BCP 47 at <a href="http://www.rfc-editor.org/rfc/bcp/bcp47.txt">
   *        http://www.rfc-editor.org/rfc/bcp/bcp47.txt</a>
   *       and the IANA language subtag registry at
   *       <a href="http://www.iana.org/assignments/language-subtag-registry">
   *        http://www.iana.org/assignments/language-subtag-registry</a>
   *       for further information.
   *      </p>
   *      <p>
   *       The union allows for the 'un-declaration' of xml:lang with
   *       the empty string.
   *      </p>
   *     </div>
   *    
   * <!-- end-model-doc -->
   * @return the value of the '<em>Lang</em>' attribute.
   * @see #setLang(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTDocumentation_Lang()
   * @model dataType="org.eclipse.emf.ecore.xml.namespace.LangType"
   *        extendedMetaData="kind='attribute' name='lang' namespace='http://www.w3.org/XML/1998/namespace'"
   * @generated
   */
  String getLang();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TDocumentation#getLang <em>Lang</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lang</em>' attribute.
   * @see #getLang()
   * @generated
   */
  void setLang(String value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTDocumentation_Source()
   * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
   *        extendedMetaData="kind='attribute' name='source'"
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TDocumentation#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

} // TDocumentation
