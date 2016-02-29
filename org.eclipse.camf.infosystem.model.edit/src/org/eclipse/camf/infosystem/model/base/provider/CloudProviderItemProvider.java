/**
 */
package org.eclipse.camf.infosystem.model.base.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.camf.infosystem.model.base.CloudProvider} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CloudProviderItemProvider 
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
  public CloudProviderItemProvider(AdapterFactory adapterFactory)
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
      addTypePropertyDescriptor(object);
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
         getString("_UI_CloudProvider_Name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CloudProvider_Name_feature", "_UI_CloudProvider_type"),
         InfoSystemPackage.Literals.CLOUD_PROVIDER__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Type feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTypePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_CloudProvider_type_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_CloudProvider_type_feature", "_UI_CloudProvider_type"),
         InfoSystemPackage.Literals.CLOUD_PROVIDER__TYPE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(InfoSystemPackage.Literals.CLOUD_PROVIDER__IMAGES);
      childrenFeatures.add(InfoSystemPackage.Literals.CLOUD_PROVIDER__NETWORKS);
      childrenFeatures.add(InfoSystemPackage.Literals.CLOUD_PROVIDER__SECURITY);
      childrenFeatures.add(InfoSystemPackage.Literals.CLOUD_PROVIDER__FLAVORS);
      childrenFeatures.add(InfoSystemPackage.Literals.CLOUD_PROVIDER__MONITORING);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns CloudProvider.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public Object getImage(Object object)
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint extensionPoint = registry.getExtensionPoint( "org.eclipse.camf.ui.cloudProviderIcon" );
    if (extensionPoint != null) {
      IExtension[] extensions = extensionPoint.getExtensions();
      for( IExtension extension : extensions ) {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for( IConfigurationElement element : elements ) {
          if( element.getAttribute( "type" ).equals( ( (CloudProvider) object).getType() ) ) {
            String location = element.getAttribute( "location" );
            Image icon = null;
            ImageDescriptor iconDesc = null;
            if( location != null ) {
              String pluginId = element.getContributor().getName();
              iconDesc = AbstractUIPlugin.imageDescriptorFromPlugin( pluginId, location );
              return iconDesc;
            }
          }
        }
      }
      return overlayImage(object, getResourceLocator().getImage("full/obj16/CloudProvider"));
    } else {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/CloudProvider"));      
    }
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getText(Object object)
  {
    String label = ((CloudProvider)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_CloudProvider_type") :
      label;
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

    switch (notification.getFeatureID(CloudProvider.class))
    {
      case InfoSystemPackage.CLOUD_PROVIDER__NAME:
      case InfoSystemPackage.CLOUD_PROVIDER__TYPE:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

    newChildDescriptors.add
      (createChildParameter
        (InfoSystemPackage.Literals.CLOUD_PROVIDER__IMAGES,
         InfoSystemFactory.eINSTANCE.createImages()));

    newChildDescriptors.add
      (createChildParameter
        (InfoSystemPackage.Literals.CLOUD_PROVIDER__NETWORKS,
         InfoSystemFactory.eINSTANCE.createNetworks()));

    newChildDescriptors.add
      (createChildParameter
        (InfoSystemPackage.Literals.CLOUD_PROVIDER__SECURITY,
         InfoSystemFactory.eINSTANCE.createSecurity()));

    newChildDescriptors.add
      (createChildParameter
        (InfoSystemPackage.Literals.CLOUD_PROVIDER__FLAVORS,
         InfoSystemFactory.eINSTANCE.createFlavors()));

    newChildDescriptors.add
      (createChildParameter
        (InfoSystemPackage.Literals.CLOUD_PROVIDER__MONITORING,
         InfoSystemFactory.eINSTANCE.createMonitoring()));
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
