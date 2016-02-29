/**
 */
package org.eclipse.camf.infosystem.model.base.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualMachineImageFlavorItemProvider 
  extends ItemProviderAdapter
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VirtualMachineImageFlavorItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addNamePropertyDescriptor(object);
      addUIDPropertyDescriptor(object);
      addRamPropertyDescriptor(object);
      addHddPropertyDescriptor(object);
      addVCPUPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_VirtualMachineImageFlavor_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_VirtualMachineImageFlavor_name_feature", "_UI_VirtualMachineImageFlavor_type"),
         InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the UID feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addUIDPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_VirtualMachineImageFlavor_uID_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_VirtualMachineImageFlavor_uID_feature", "_UI_VirtualMachineImageFlavor_type"),
         InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Ram feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addRamPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_VirtualMachineImageFlavor_ram_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_VirtualMachineImageFlavor_ram_feature", "_UI_VirtualMachineImageFlavor_type"),
         InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Hdd feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addHddPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_VirtualMachineImageFlavor_hdd_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_VirtualMachineImageFlavor_hdd_feature", "_UI_VirtualMachineImageFlavor_type"),
         InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the VCPU feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addVCPUPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_VirtualMachineImageFlavor_vCPU_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_VirtualMachineImageFlavor_vCPU_feature", "_UI_VirtualMachineImageFlavor_type"),
         InfoSystemPackage.Literals.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This returns VirtualMachineImageFlavor.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/VirtualMachineImageFlavor"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((VirtualMachineImageFlavor)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_VirtualMachineImageFlavor_type") :
      getString("_UI_VirtualMachineImageFlavor_type") + " " + label;
  }
  

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(VirtualMachineImageFlavor.class))
    {
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME:
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__UID:
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM:
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD:
      case InfoSystemPackage.VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return InfoSystemEditPlugin.INSTANCE;
  }

}
