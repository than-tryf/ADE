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

import org.eclipse.camf.tosca.TNodeTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension()
 * @model extendedMetaData="name='TNodeTemplateExtension' kind='elementOnly'"
 * @generated
 */
public interface TNodeTemplateExtension extends TNodeTemplate
{
  /**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Height</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #setHeight(int)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Height()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='height'"
	 * @generated
	 */
  int getHeight();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #isSetHeight()
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @generated
	 */
  void setHeight(int value);

  /**
	 * Unsets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
  void unsetHeight();

  /**
	 * Returns whether the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getHeight <em>Height</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Height</em>' attribute is set.
	 * @see #unsetHeight()
	 * @see #getHeight()
	 * @see #setHeight(int)
	 * @generated
	 */
  boolean isSetHeight();

  /**
	 * Returns the value of the '<em><b>Init Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Instances</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Instances</em>' attribute.
	 * @see #isSetInitInstances()
	 * @see #unsetInitInstances()
	 * @see #setInitInstances(int)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_InitInstances()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='initInstances'"
	 * @generated
	 */
  int getInitInstances();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Instances</em>' attribute.
	 * @see #isSetInitInstances()
	 * @see #unsetInitInstances()
	 * @see #getInitInstances()
	 * @generated
	 */
  void setInitInstances(int value);

  /**
	 * Unsets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetInitInstances()
	 * @see #getInitInstances()
	 * @see #setInitInstances(int)
	 * @generated
	 */
  void unsetInitInstances();

  /**
	 * Returns whether the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getInitInstances <em>Init Instances</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Init Instances</em>' attribute is set.
	 * @see #unsetInitInstances()
	 * @see #getInitInstances()
	 * @see #setInitInstances(int)
	 * @generated
	 */
  boolean isSetInitInstances();

  /**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Width</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #setWidth(int)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Width()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='width'"
	 * @generated
	 */
  int getWidth();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #isSetWidth()
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @generated
	 */
  void setWidth(int value);

  /**
	 * Unsets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
  void unsetWidth();

  /**
	 * Returns whether the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getWidth <em>Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Width</em>' attribute is set.
	 * @see #unsetWidth()
	 * @see #getWidth()
	 * @see #setWidth(int)
	 * @generated
	 */
  boolean isSetWidth();

  /**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>X</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #isSetX()
	 * @see #unsetX()
	 * @see #setX(int)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_X()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='x'"
	 * @generated
	 */
  int getX();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #isSetX()
	 * @see #unsetX()
	 * @see #getX()
	 * @generated
	 */
  void setX(int value);

  /**
	 * Unsets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetX()
	 * @see #getX()
	 * @see #setX(int)
	 * @generated
	 */
  void unsetX();

  /**
	 * Returns whether the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getX <em>X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>X</em>' attribute is set.
	 * @see #unsetX()
	 * @see #getX()
	 * @see #setX(int)
	 * @generated
	 */
  boolean isSetX();

  /**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Y</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #isSetY()
	 * @see #unsetY()
	 * @see #setY(int)
	 * @see org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage#getTNodeTemplateExtension_Y()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='y'"
	 * @generated
	 */
  int getY();

  /**
	 * Sets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #isSetY()
	 * @see #unsetY()
	 * @see #getY()
	 * @generated
	 */
  void setY(int value);

  /**
	 * Unsets the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetY()
	 * @see #getY()
	 * @see #setY(int)
	 * @generated
	 */
  void unsetY();

  /**
	 * Returns whether the value of the '{@link org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension#getY <em>Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Y</em>' attribute is set.
	 * @see #unsetY()
	 * @see #getY()
	 * @see #setY(int)
	 * @generated
	 */
  boolean isSetY();

} // TNodeTemplateExtension
