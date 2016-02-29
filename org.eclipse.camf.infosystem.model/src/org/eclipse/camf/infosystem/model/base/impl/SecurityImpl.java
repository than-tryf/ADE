/**
 */
package org.eclipse.camf.infosystem.model.base.impl;

import java.util.Collection;

import org.eclipse.camf.infosystem.model.base.Groups;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.Keys;
import org.eclipse.camf.infosystem.model.base.Security;

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
 * An implementation of the model object '<em><b>Security</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.SecurityImpl#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.SecurityImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecurityImpl extends EObjectImpl implements Security
{
  /**
   * The cached value of the '{@link #getKeys() <em>Keys</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeys()
   * @generated
   * @ordered
   */
  protected Keys keys;

  /**
   * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroups()
   * @generated
   * @ordered
   */
  protected Groups groups;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SecurityImpl()
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
    return InfoSystemPackage.Literals.SECURITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Keys getKeys()
  {
    return keys;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKeys(Keys newKeys, NotificationChain msgs)
  {
    Keys oldKeys = keys;
    keys = newKeys;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.SECURITY__KEYS, oldKeys, newKeys);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeys(Keys newKeys)
  {
    if (newKeys != keys)
    {
      NotificationChain msgs = null;
      if (keys != null)
        msgs = ((InternalEObject)keys).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.SECURITY__KEYS, null, msgs);
      if (newKeys != null)
        msgs = ((InternalEObject)newKeys).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.SECURITY__KEYS, null, msgs);
      msgs = basicSetKeys(newKeys, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.SECURITY__KEYS, newKeys, newKeys));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Groups getGroups()
  {
    return groups;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGroups(Groups newGroups, NotificationChain msgs)
  {
    Groups oldGroups = groups;
    groups = newGroups;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfoSystemPackage.SECURITY__GROUPS, oldGroups, newGroups);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGroups(Groups newGroups)
  {
    if (newGroups != groups)
    {
      NotificationChain msgs = null;
      if (groups != null)
        msgs = ((InternalEObject)groups).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.SECURITY__GROUPS, null, msgs);
      if (newGroups != null)
        msgs = ((InternalEObject)newGroups).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfoSystemPackage.SECURITY__GROUPS, null, msgs);
      msgs = basicSetGroups(newGroups, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.SECURITY__GROUPS, newGroups, newGroups));
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
      case InfoSystemPackage.SECURITY__KEYS:
        return basicSetKeys(null, msgs);
      case InfoSystemPackage.SECURITY__GROUPS:
        return basicSetGroups(null, msgs);
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
      case InfoSystemPackage.SECURITY__KEYS:
        return getKeys();
      case InfoSystemPackage.SECURITY__GROUPS:
        return getGroups();
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
      case InfoSystemPackage.SECURITY__KEYS:
        setKeys((Keys)newValue);
        return;
      case InfoSystemPackage.SECURITY__GROUPS:
        setGroups((Groups)newValue);
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
      case InfoSystemPackage.SECURITY__KEYS:
        setKeys((Keys)null);
        return;
      case InfoSystemPackage.SECURITY__GROUPS:
        setGroups((Groups)null);
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
      case InfoSystemPackage.SECURITY__KEYS:
        return keys != null;
      case InfoSystemPackage.SECURITY__GROUPS:
        return groups != null;
    }
    return super.eIsSet(featureID);
  }

} //SecurityImpl
