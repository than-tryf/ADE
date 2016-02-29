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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage
 * @generated
 */
public class InfoSystemAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static InfoSystemPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = InfoSystemPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InfoSystemSwitch<Adapter> modelSwitch =
    new InfoSystemSwitch<Adapter>()
    {
      @Override
      public Adapter caseMonitoringProbe(MonitoringProbe object)
      {
        return createMonitoringProbeAdapter();
      }
      @Override
      public Adapter caseResizingAction(ResizingAction object)
      {
        return createResizingActionAdapter();
      }
      @Override
      public Adapter caseSoftwareDependency(SoftwareDependency object)
      {
        return createSoftwareDependencyAdapter();
      }
      @Override
      public Adapter caseUserApplication(UserApplication object)
      {
        return createUserApplicationAdapter();
      }
      @Override
      public Adapter caseKeyPair(KeyPair object)
      {
        return createKeyPairAdapter();
      }
      @Override
      public Adapter caseVirtualMachineImageFlavor(VirtualMachineImageFlavor object)
      {
        return createVirtualMachineImageFlavorAdapter();
      }
      @Override
      public Adapter caseVirtualNetwork(VirtualNetwork object)
      {
        return createVirtualNetworkAdapter();
      }
      @Override
      public Adapter caseCloudProvider(CloudProvider object)
      {
        return createCloudProviderAdapter();
      }
      @Override
      public Adapter caseVirtualMachineImage(VirtualMachineImage object)
      {
        return createVirtualMachineImageAdapter();
      }
      @Override
      public Adapter caseDeployment(Deployment object)
      {
        return createDeploymentAdapter();
      }
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseVirtualInstance(VirtualInstance object)
      {
        return createVirtualInstanceAdapter();
      }
      @Override
      public Adapter caseSecurityGroup(SecurityGroup object)
      {
        return createSecurityGroupAdapter();
      }
      @Override
      public Adapter caseRoot(Root object)
      {
        return createRootAdapter();
      }
      @Override
      public Adapter caseImages(Images object)
      {
        return createImagesAdapter();
      }
      @Override
      public Adapter caseNetworks(Networks object)
      {
        return createNetworksAdapter();
      }
      @Override
      public Adapter caseSecurity(Security object)
      {
        return createSecurityAdapter();
      }
      @Override
      public Adapter caseKeys(Keys object)
      {
        return createKeysAdapter();
      }
      @Override
      public Adapter caseGroups(Groups object)
      {
        return createGroupsAdapter();
      }
      @Override
      public Adapter caseFlavors(Flavors object)
      {
        return createFlavorsAdapter();
      }
      @Override
      public Adapter caseMonitoring(Monitoring object)
      {
        return createMonitoringAdapter();
      }
      @Override
      public Adapter caseMonitoringService(MonitoringService object)
      {
        return createMonitoringServiceAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe <em>Monitoring Probe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe
   * @generated
   */
  public Adapter createMonitoringProbeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.ResizingAction <em>Resizing Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.ResizingAction
   * @generated
   */
  public Adapter createResizingActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency <em>Software Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency
   * @generated
   */
  public Adapter createSoftwareDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage <em>Virtual Machine Image</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage
   * @generated
   */
  public Adapter createVirtualMachineImageAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.UserApplication <em>User Application</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.UserApplication
   * @generated
   */
  public Adapter createUserApplicationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.KeyPair <em>Key Pair</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.KeyPair
   * @generated
   */
  public Adapter createKeyPairAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor <em>Virtual Machine Image Flavor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor
   * @generated
   */
  public Adapter createVirtualMachineImageFlavorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.VirtualNetwork <em>Virtual Network</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.VirtualNetwork
   * @generated
   */
  public Adapter createVirtualNetworkAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.CloudProvider <em>Cloud Provider</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.CloudProvider
   * @generated
   */
  public Adapter createCloudProviderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance <em>Virtual Instance</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.VirtualInstance
   * @generated
   */
	public Adapter createVirtualInstanceAdapter() {
    return null;
  }

		/**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.SecurityGroup <em>Security Group</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.SecurityGroup
   * @generated
   */
	public Adapter createSecurityGroupAdapter() {
    return null;
  }

		/**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Root
   * @generated
   */
  public Adapter createRootAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Images <em>Images</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Images
   * @generated
   */
  public Adapter createImagesAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Networks <em>Networks</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Networks
   * @generated
   */
  public Adapter createNetworksAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Security <em>Security</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Security
   * @generated
   */
  public Adapter createSecurityAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Keys <em>Keys</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Keys
   * @generated
   */
  public Adapter createKeysAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Groups <em>Groups</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Groups
   * @generated
   */
  public Adapter createGroupsAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Flavors <em>Flavors</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Flavors
   * @generated
   */
  public Adapter createFlavorsAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Monitoring <em>Monitoring</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Monitoring
   * @generated
   */
  public Adapter createMonitoringAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.MonitoringService <em>Monitoring Service</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.MonitoringService
   * @generated
   */
  public Adapter createMonitoringServiceAdapter()
  {
    return null;
  }

    /**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Deployment <em>Deployment</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Deployment
   * @generated
   */
	public Adapter createDeploymentAdapter() {
    return null;
  }

		/**
   * Creates a new adapter for an object of class '{@link org.eclipse.camf.infosystem.model.base.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.camf.infosystem.model.base.Module
   * @generated
   */
	public Adapter createModuleAdapter() {
    return null;
  }

		/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //InfoSystemAdapterFactory
