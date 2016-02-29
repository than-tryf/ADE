/**
 */
package org.eclipse.camf.infosystem.model.base.impl;

import java.util.Collection;
import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.Flavors;
import org.eclipse.camf.infosystem.model.base.Images;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.Monitoring;
import org.eclipse.camf.infosystem.model.base.Networks;
import org.eclipse.camf.infosystem.model.base.Security;

import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cloud Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getImages <em>Images</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getNetworks <em>Networks</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getSecurity <em>Security</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getFlavors <em>Flavors</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.CloudProviderImpl#getMonitoring <em>Monitoring</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloudProviderImpl extends EObjectImpl implements CloudProvider
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getImages() <em>Images</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImages()
   * @generated
   * @ordered
   */
  protected Images images;

  /**
   * The cached value of the '{@link #getNetworks() <em>Networks</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNetworks()
   * @generated
   * @ordered
   */
  protected Networks networks;

  /**
   * The cached value of the '{@link #getSecurity() <em>Security</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecurity()
   * @generated
   * @ordered
   */
  protected Security security;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFlavors() <em>Flavors</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlavors()
   * @generated
   * @ordered
   */
  protected Flavors flavors;

  /**
   * The cached value of the '{@link #getMonitoring() <em>Monitoring</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMonitoring()
   * @generated
   * @ordered
   */
  protected Monitoring monitoring;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CloudProviderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return InfoSystemPackage.Literals.CLOUD_PROVIDER;
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
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Images getImages()
  {
    return images;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImages(Images newImages, NotificationChain msgs)
  {
    Images oldImages = images;
    images = newImages;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__IMAGES, oldImages, newImages);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImages(Images newImages)
  {
    if (newImages != images)
    {
      NotificationChain msgs = null;
      if (images != null)
        msgs = ((InternalEObject)images).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__IMAGES, null, msgs);
      if (newImages != null)
        msgs = ((InternalEObject)newImages).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__IMAGES, null, msgs);
      msgs = basicSetImages(newImages, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__IMAGES, newImages, newImages));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Networks getNetworks()
  {
    return networks;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNetworks(Networks newNetworks, NotificationChain msgs)
  {
    Networks oldNetworks = networks;
    networks = newNetworks;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__NETWORKS, oldNetworks, newNetworks);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNetworks(Networks newNetworks)
  {
    if (newNetworks != networks)
    {
      NotificationChain msgs = null;
      if (networks != null)
        msgs = ((InternalEObject)networks).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__NETWORKS, null, msgs);
      if (newNetworks != null)
        msgs = ((InternalEObject)newNetworks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__NETWORKS, null, msgs);
      msgs = basicSetNetworks(newNetworks, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__NETWORKS, newNetworks, newNetworks));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Security getSecurity()
  {
    return security;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecurity(Security newSecurity, NotificationChain msgs)
  {
    Security oldSecurity = security;
    security = newSecurity;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__SECURITY, oldSecurity, newSecurity);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecurity(Security newSecurity)
  {
    if (newSecurity != security)
    {
      NotificationChain msgs = null;
      if (security != null)
        msgs = ((InternalEObject)security).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__SECURITY, null, msgs);
      if (newSecurity != null)
        msgs = ((InternalEObject)newSecurity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__SECURITY, null, msgs);
      msgs = basicSetSecurity(newSecurity, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__SECURITY, newSecurity, newSecurity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Flavors getFlavors()
  {
    return flavors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFlavors(Flavors newFlavors, NotificationChain msgs)
  {
    Flavors oldFlavors = flavors;
    flavors = newFlavors;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__FLAVORS, oldFlavors, newFlavors);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFlavors(Flavors newFlavors)
  {
    if (newFlavors != flavors)
    {
      NotificationChain msgs = null;
      if (flavors != null)
        msgs = ((InternalEObject)flavors).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__FLAVORS, null, msgs);
      if (newFlavors != null)
        msgs = ((InternalEObject)newFlavors).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__FLAVORS, null, msgs);
      msgs = basicSetFlavors(newFlavors, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__FLAVORS, newFlavors, newFlavors));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Monitoring getMonitoring()
  {
    return monitoring;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMonitoring(Monitoring newMonitoring, NotificationChain msgs)
  {
    Monitoring oldMonitoring = monitoring;
    monitoring = newMonitoring;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__MONITORING, oldMonitoring, newMonitoring);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMonitoring(Monitoring newMonitoring)
  {
    if (newMonitoring != monitoring)
    {
      NotificationChain msgs = null;
      if (monitoring != null)
        msgs = ((InternalEObject)monitoring).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__MONITORING, null, msgs);
      if (newMonitoring != null)
        msgs = ((InternalEObject)newMonitoring).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.CLOUD_PROVIDER__MONITORING, null, msgs);
      msgs = basicSetMonitoring(newMonitoring, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.CLOUD_PROVIDER__MONITORING, newMonitoring, newMonitoring));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
        return basicSetImages(null, msgs);
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
        return basicSetNetworks(null, msgs);
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
        return basicSetSecurity(null, msgs);
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
        return basicSetFlavors(null, msgs);
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        return basicSetMonitoring(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case InfoSystemPackage.CLOUD_PROVIDER__NAME:
        return getName();
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
        return getImages();
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
        return getNetworks();
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
        return getSecurity();
      case InfoSystemPackage.CLOUD_PROVIDER__TYPE:
        return getType();
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
        return getFlavors();
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        return getMonitoring();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfoSystemPackage.CLOUD_PROVIDER__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
        setImages((Images)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
        setNetworks((Networks)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
        setSecurity((Security)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__TYPE:
        setType((String)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
        setFlavors((Flavors)newValue);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        setMonitoring((Monitoring)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case InfoSystemPackage.CLOUD_PROVIDER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
        setImages((Images)null);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
        setNetworks((Networks)null);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
        setSecurity((Security)null);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
        setFlavors((Flavors)null);
        return;
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        setMonitoring((Monitoring)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case InfoSystemPackage.CLOUD_PROVIDER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.CLOUD_PROVIDER__IMAGES:
        return images != null;
      case InfoSystemPackage.CLOUD_PROVIDER__NETWORKS:
        return networks != null;
      case InfoSystemPackage.CLOUD_PROVIDER__SECURITY:
        return security != null;
      case InfoSystemPackage.CLOUD_PROVIDER__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case InfoSystemPackage.CLOUD_PROVIDER__FLAVORS:
        return flavors != null;
      case InfoSystemPackage.CLOUD_PROVIDER__MONITORING:
        return monitoring != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (Name: ");
    result.append(name);
    result.append(", type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //CloudProviderImpl
