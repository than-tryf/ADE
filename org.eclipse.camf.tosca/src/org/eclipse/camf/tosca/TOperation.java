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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.TOperation#getInputParameters <em>Input Parameters</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TOperation#getOutputParameters <em>Output Parameters</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.TOperation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.ToscaPackage#getTOperation()
 * @model extendedMetaData="name='tOperation' kind='elementOnly'"
 * @generated
 */
public interface TOperation extends TExtensibleElements
{
  /**
   * Returns the value of the '<em><b>Input Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Parameters</em>' containment reference.
   * @see #setInputParameters(InputParametersType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTOperation_InputParameters()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='InputParameters' namespace='##targetNamespace'"
   * @generated
   */
  InputParametersType getInputParameters();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TOperation#getInputParameters <em>Input Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Parameters</em>' containment reference.
   * @see #getInputParameters()
   * @generated
   */
  void setInputParameters(InputParametersType value);

  /**
   * Returns the value of the '<em><b>Output Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Parameters</em>' containment reference.
   * @see #setOutputParameters(OutputParametersType)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTOperation_OutputParameters()
   * @model containment="true"
   *        extendedMetaData="kind='element' name='OutputParameters' namespace='##targetNamespace'"
   * @generated
   */
  OutputParametersType getOutputParameters();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TOperation#getOutputParameters <em>Output Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output Parameters</em>' containment reference.
   * @see #getOutputParameters()
   * @generated
   */
  void setOutputParameters(OutputParametersType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.camf.tosca.ToscaPackage#getTOperation_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
   *        extendedMetaData="kind='attribute' name='name'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.tosca.TOperation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // TOperation
