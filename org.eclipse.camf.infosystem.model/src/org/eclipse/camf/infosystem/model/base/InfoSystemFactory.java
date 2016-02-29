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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage
 * @generated
 */
public interface InfoSystemFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InfoSystemFactory eINSTANCE = org.eclipse.camf.infosystem.model.base.impl.InfoSystemFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Monitoring Probe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monitoring Probe</em>'.
   * @generated
   */
  MonitoringProbe createMonitoringProbe();

  /**
   * Returns a new object of class '<em>Resizing Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Resizing Action</em>'.
   * @generated
   */
  ResizingAction createResizingAction();

  /**
   * Returns a new object of class '<em>Software Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Dependency</em>'.
   * @generated
   */
  SoftwareDependency createSoftwareDependency();

  /**
   * Returns a new object of class '<em>Virtual Machine Image</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Virtual Machine Image</em>'.
   * @generated
   */
  VirtualMachineImage createVirtualMachineImage();

  /**
   * Returns a new object of class '<em>User Application</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Application</em>'.
   * @generated
   */
  UserApplication createUserApplication();

  /**
   * Returns a new object of class '<em>Key Pair</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Pair</em>'.
   * @generated
   */
  KeyPair createKeyPair();

  /**
   * Returns a new object of class '<em>Virtual Machine Image Flavor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Virtual Machine Image Flavor</em>'.
   * @generated
   */
  VirtualMachineImageFlavor createVirtualMachineImageFlavor();

  /**
   * Returns a new object of class '<em>Virtual Network</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Virtual Network</em>'.
   * @generated
   */
  VirtualNetwork createVirtualNetwork();

  /**
   * Returns a new object of class '<em>Cloud Provider</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cloud Provider</em>'.
   * @generated
   */
  CloudProvider createCloudProvider();

  /**
   * Returns a new object of class '<em>Virtual Instance</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Virtual Instance</em>'.
   * @generated
   */
	VirtualInstance createVirtualInstance();

		/**
   * Returns a new object of class '<em>Security Group</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Security Group</em>'.
   * @generated
   */
	SecurityGroup createSecurityGroup();

		/**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

    /**
   * Returns a new object of class '<em>Images</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Images</em>'.
   * @generated
   */
  Images createImages();

    /**
   * Returns a new object of class '<em>Networks</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Networks</em>'.
   * @generated
   */
  Networks createNetworks();

    /**
   * Returns a new object of class '<em>Security</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Security</em>'.
   * @generated
   */
  Security createSecurity();

    /**
   * Returns a new object of class '<em>Keys</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Keys</em>'.
   * @generated
   */
  Keys createKeys();

    /**
   * Returns a new object of class '<em>Groups</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Groups</em>'.
   * @generated
   */
  Groups createGroups();

    /**
   * Returns a new object of class '<em>Flavors</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Flavors</em>'.
   * @generated
   */
  Flavors createFlavors();

    /**
   * Returns a new object of class '<em>Monitoring</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monitoring</em>'.
   * @generated
   */
  Monitoring createMonitoring();

    /**
   * Returns a new object of class '<em>Monitoring Service</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monitoring Service</em>'.
   * @generated
   */
  MonitoringService createMonitoringService();

    /**
   * Returns a new object of class '<em>Deployment</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Deployment</em>'.
   * @generated
   */
	Deployment createDeployment();

		/**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
	Module createModule();

		/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  InfoSystemPackage getInfoSystemPackage();

} //InfoSystemFactory
