/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.camf.infosystem.model.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Virtual Machine Image Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageType()
 * @model extendedMetaData="name='VirtualMachineImageType'"
 * @generated
 */
public enum VirtualMachineImageType implements Enumerator
{
  /**
   * The '<em><b>Base Image</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BASE_IMAGE_VALUE
   * @generated
   * @ordered
   */
  BASE_IMAGE(0, "BaseImage", "Base Image"),

  /**
   * The '<em><b>Custom Image</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CUSTOM_IMAGE_VALUE
   * @generated
   * @ordered
   */
  CUSTOM_IMAGE(1, "CustomImage", "Custom Image");

  /**
   * The '<em><b>Base Image</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Base Image</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BASE_IMAGE
   * @model name="BaseImage" literal="Base Image"
   * @generated
   * @ordered
   */
  public static final int BASE_IMAGE_VALUE = 0;

  /**
   * The '<em><b>Custom Image</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Custom Image</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CUSTOM_IMAGE
   * @model name="CustomImage" literal="Custom Image"
   * @generated
   * @ordered
   */
  public static final int CUSTOM_IMAGE_VALUE = 1;

  /**
   * An array of all the '<em><b>Virtual Machine Image Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final VirtualMachineImageType[] VALUES_ARRAY =
    new VirtualMachineImageType[]
    {
      BASE_IMAGE,
      CUSTOM_IMAGE,
    };

  /**
   * A public read-only list of all the '<em><b>Virtual Machine Image Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<VirtualMachineImageType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Virtual Machine Image Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VirtualMachineImageType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VirtualMachineImageType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Virtual Machine Image Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VirtualMachineImageType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VirtualMachineImageType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Virtual Machine Image Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VirtualMachineImageType get(int value)
  {
    switch (value)
    {
      case BASE_IMAGE_VALUE: return BASE_IMAGE;
      case CUSTOM_IMAGE_VALUE: return CUSTOM_IMAGE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private VirtualMachineImageType(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //VirtualMachineImageType
