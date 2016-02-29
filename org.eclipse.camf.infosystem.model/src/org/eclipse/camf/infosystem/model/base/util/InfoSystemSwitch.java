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
package org.eclipse.camf.infosystem.model.base.util;

import org.eclipse.camf.infosystem.model.base.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage
 * @generated
 */
public class InfoSystemSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static InfoSystemPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = InfoSystemPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case InfoSystemPackage.MONITORING_PROBE:
      {
        MonitoringProbe monitoringProbe = (MonitoringProbe)theEObject;
        T result = caseMonitoringProbe(monitoringProbe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.RESIZING_ACTION:
      {
        ResizingAction resizingAction = (ResizingAction)theEObject;
        T result = caseResizingAction(resizingAction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.SOFTWARE_DEPENDENCY:
      {
        SoftwareDependency softwareDependency = (SoftwareDependency)theEObject;
        T result = caseSoftwareDependency(softwareDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.USER_APPLICATION:
      {
        UserApplication userApplication = (UserApplication)theEObject;
        T result = caseUserApplication(userApplication);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.KEY_PAIR:
      {
        KeyPair keyPair = (KeyPair)theEObject;
        T result = caseKeyPair(keyPair);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR:
      {
        VirtualMachineImageFlavor virtualMachineImageFlavor = (VirtualMachineImageFlavor)theEObject;
        T result = caseVirtualMachineImageFlavor(virtualMachineImageFlavor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.VIRTUAL_NETWORK:
      {
        VirtualNetwork virtualNetwork = (VirtualNetwork)theEObject;
        T result = caseVirtualNetwork(virtualNetwork);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.CLOUD_PROVIDER:
      {
        CloudProvider cloudProvider = (CloudProvider)theEObject;
        T result = caseCloudProvider(cloudProvider);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE:
      {
        VirtualMachineImage virtualMachineImage = (VirtualMachineImage)theEObject;
        T result = caseVirtualMachineImage(virtualMachineImage);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.DEPLOYMENT:
      {
        Deployment deployment = (Deployment)theEObject;
        T result = caseDeployment(deployment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.VIRTUAL_INSTANCE:
      {
        VirtualInstance virtualInstance = (VirtualInstance)theEObject;
        T result = caseVirtualInstance(virtualInstance);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.SECURITY_GROUP:
      {
        SecurityGroup securityGroup = (SecurityGroup)theEObject;
        T result = caseSecurityGroup(securityGroup);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.IMAGES:
      {
        Images images = (Images)theEObject;
        T result = caseImages(images);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.NETWORKS:
      {
        Networks networks = (Networks)theEObject;
        T result = caseNetworks(networks);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.SECURITY:
      {
        Security security = (Security)theEObject;
        T result = caseSecurity(security);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.KEYS:
      {
        Keys keys = (Keys)theEObject;
        T result = caseKeys(keys);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.GROUPS:
      {
        Groups groups = (Groups)theEObject;
        T result = caseGroups(groups);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.FLAVORS:
      {
        Flavors flavors = (Flavors)theEObject;
        T result = caseFlavors(flavors);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.MONITORING:
      {
        Monitoring monitoring = (Monitoring)theEObject;
        T result = caseMonitoring(monitoring);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case InfoSystemPackage.MONITORING_SERVICE:
      {
        MonitoringService monitoringService = (MonitoringService)theEObject;
        T result = caseMonitoringService(monitoringService);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Monitoring Probe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Monitoring Probe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMonitoringProbe(MonitoringProbe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Resizing Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Resizing Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResizingAction(ResizingAction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Software Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Software Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSoftwareDependency(SoftwareDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Virtual Machine Image</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Virtual Machine Image</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVirtualMachineImage(VirtualMachineImage object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Application</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Application</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserApplication(UserApplication object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key Pair</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key Pair</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyPair(KeyPair object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Virtual Machine Image Flavor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Virtual Machine Image Flavor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVirtualMachineImageFlavor(VirtualMachineImageFlavor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Virtual Network</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Virtual Network</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVirtualNetwork(VirtualNetwork object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Cloud Provider</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Cloud Provider</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCloudProvider(CloudProvider object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Virtual Instance</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Virtual Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseVirtualInstance(VirtualInstance object) {
    return null;
  }

		/**
   * Returns the result of interpreting the object as an instance of '<em>Security Group</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Security Group</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseSecurityGroup(SecurityGroup object) {
    return null;
  }

		/**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Images</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Images</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImages(Images object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Networks</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Networks</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNetworks(Networks object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Security</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Security</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecurity(Security object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Keys</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keys</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeys(Keys object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Groups</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Groups</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGroups(Groups object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Flavors</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Flavors</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFlavors(Flavors object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Monitoring</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Monitoring</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMonitoring(Monitoring object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Monitoring Service</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Monitoring Service</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMonitoringService(MonitoringService object)
  {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Deployment</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Deployment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseDeployment(Deployment object) {
    return null;
  }

		/**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T caseModule(Module object) {
    return null;
  }

		/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //InfoSystemSwitch
