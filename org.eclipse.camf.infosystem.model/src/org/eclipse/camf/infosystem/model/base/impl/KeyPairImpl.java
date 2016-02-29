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
 *  Andreas Kastanas - added public key
 *******************************************************************************/
/**
 */
package org.eclipse.camf.infosystem.model.base.impl;

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Pair</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl#getPublicKey <em>Public Key</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl#getURL <em>URL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyPairImpl extends EObjectImpl implements KeyPair
{
  /**
   * The default value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
  protected static final String UID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUID() <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUID()
   * @generated
   * @ordered
   */
  protected String uID = UID_EDEFAULT;

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
   * The default value of the '{@link #getPublicKey() <em>Public Key</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPublicKey()
   * @generated
   * @ordered
   */
	protected static final String PUBLIC_KEY_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getPublicKey() <em>Public Key</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getPublicKey()
   * @generated
   * @ordered
   */
	protected String publicKey = PUBLIC_KEY_EDEFAULT;

		/**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
	protected static final String DESCRIPTION_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
	protected String description = DESCRIPTION_EDEFAULT;

		/**
   * The default value of the '{@link #getURL() <em>URL</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getURL()
   * @generated
   * @ordered
   */
	protected static final String URL_EDEFAULT = null;

		/**
   * The cached value of the '{@link #getURL() <em>URL</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getURL()
   * @generated
   * @ordered
   */
	protected String url = URL_EDEFAULT;

		/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeyPairImpl()
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
    return InfoSystemPackage.Literals.KEY_PAIR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUID()
  {
    return uID;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUID(String newUID)
  {
    String oldUID = uID;
    uID = newUID;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.KEY_PAIR__UID, oldUID, uID));
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
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.KEY_PAIR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getPublicKey() {
    return publicKey;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setPublicKey(String newPublicKey) {
    String oldPublicKey = publicKey;
    publicKey = newPublicKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.KEY_PAIR__PUBLIC_KEY, oldPublicKey, publicKey));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getDescription() {
    return description;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.KEY_PAIR__DESCRIPTION, oldDescription, description));
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getURL() {
    return url;
  }

		/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setURL(String newURL) {
    String oldURL = url;
    url = newURL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.KEY_PAIR__URL, oldURL, url));
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
      case InfoSystemPackage.KEY_PAIR__UID:
        return getUID();
      case InfoSystemPackage.KEY_PAIR__NAME:
        return getName();
      case InfoSystemPackage.KEY_PAIR__PUBLIC_KEY:
        return getPublicKey();
      case InfoSystemPackage.KEY_PAIR__DESCRIPTION:
        return getDescription();
      case InfoSystemPackage.KEY_PAIR__URL:
        return getURL();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfoSystemPackage.KEY_PAIR__UID:
        setUID((String)newValue);
        return;
      case InfoSystemPackage.KEY_PAIR__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.KEY_PAIR__PUBLIC_KEY:
        setPublicKey((String)newValue);
        return;
      case InfoSystemPackage.KEY_PAIR__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case InfoSystemPackage.KEY_PAIR__URL:
        setURL((String)newValue);
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
      case InfoSystemPackage.KEY_PAIR__UID:
        setUID(UID_EDEFAULT);
        return;
      case InfoSystemPackage.KEY_PAIR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.KEY_PAIR__PUBLIC_KEY:
        setPublicKey(PUBLIC_KEY_EDEFAULT);
        return;
      case InfoSystemPackage.KEY_PAIR__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case InfoSystemPackage.KEY_PAIR__URL:
        setURL(URL_EDEFAULT);
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
      case InfoSystemPackage.KEY_PAIR__UID:
        return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
      case InfoSystemPackage.KEY_PAIR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.KEY_PAIR__PUBLIC_KEY:
        return PUBLIC_KEY_EDEFAULT == null ? publicKey != null : !PUBLIC_KEY_EDEFAULT.equals(publicKey);
      case InfoSystemPackage.KEY_PAIR__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case InfoSystemPackage.KEY_PAIR__URL:
        return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
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
    result.append(" (uID: ");
    result.append(uID);
    result.append(", name: ");
    result.append(name);
    result.append(", publicKey: ");
    result.append(publicKey);
    result.append(", Description: ");
    result.append(description);
    result.append(", URL: ");
    result.append(url);
    result.append(')');
    return result.toString();
  }

} //KeyPairImpl
