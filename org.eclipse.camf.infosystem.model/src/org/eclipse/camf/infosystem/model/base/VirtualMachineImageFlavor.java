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
 *  Andreas Kastanas - added RAM,HDD,VCPU
 *******************************************************************************/
/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Machine Image Flavor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getRam <em>Ram</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getHdd <em>Hdd</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getVCPU <em>VCPU</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor()
 * @model
 * @generated
 */
public interface VirtualMachineImageFlavor extends EObject
{
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
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>UID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>UID</em>' attribute.
   * @see #setUID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor_UID()
   * @model required="true"
   * @generated
   */
  String getUID();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getUID <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>UID</em>' attribute.
   * @see #getUID()
   * @generated
   */
  void setUID(String value);

		/**
   * Returns the value of the '<em><b>Ram</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ram</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Ram</em>' attribute.
   * @see #setRam(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor_Ram()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getRam();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getRam <em>Ram</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ram</em>' attribute.
   * @see #getRam()
   * @generated
   */
	void setRam(String value);

		/**
   * Returns the value of the '<em><b>Hdd</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hdd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Hdd</em>' attribute.
   * @see #setHdd(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor_Hdd()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getHdd();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getHdd <em>Hdd</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hdd</em>' attribute.
   * @see #getHdd()
   * @generated
   */
	void setHdd(String value);

		/**
   * Returns the value of the '<em><b>VCPU</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VCPU</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>VCPU</em>' attribute.
   * @see #setVCPU(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualMachineImageFlavor_VCPU()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
	String getVCPU();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getVCPU <em>VCPU</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>VCPU</em>' attribute.
   * @see #getVCPU()
   * @generated
   */
	void setVCPU(String value);

} // VirtualMachineImageFlavor
