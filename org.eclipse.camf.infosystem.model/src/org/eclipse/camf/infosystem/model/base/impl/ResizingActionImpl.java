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
package org.eclipse.camf.infosystem.model.base.impl;

import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resizing Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl#getURL <em>URL</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResizingActionImpl extends EObjectImpl implements ResizingAction
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
  protected String uRL = URL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ResizingActionImpl()
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
    return InfoSystemPackage.Literals.RESIZING_ACTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.RESIZING_ACTION__UID, oldUID, uID));
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
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.RESIZING_ACTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.RESIZING_ACTION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getURL()
  {
    return uRL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setURL(String newURL)
  {
    String oldURL = uRL;
    uRL = newURL;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfoSystemPackage.RESIZING_ACTION__URL, oldURL, uRL));
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
      case InfoSystemPackage.RESIZING_ACTION__UID:
        return getUID();
      case InfoSystemPackage.RESIZING_ACTION__NAME:
        return getName();
      case InfoSystemPackage.RESIZING_ACTION__DESCRIPTION:
        return getDescription();
      case InfoSystemPackage.RESIZING_ACTION__URL:
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
      case InfoSystemPackage.RESIZING_ACTION__UID:
        setUID((String)newValue);
        return;
      case InfoSystemPackage.RESIZING_ACTION__NAME:
        setName((String)newValue);
        return;
      case InfoSystemPackage.RESIZING_ACTION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case InfoSystemPackage.RESIZING_ACTION__URL:
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
      case InfoSystemPackage.RESIZING_ACTION__UID:
        setUID(UID_EDEFAULT);
        return;
      case InfoSystemPackage.RESIZING_ACTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case InfoSystemPackage.RESIZING_ACTION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case InfoSystemPackage.RESIZING_ACTION__URL:
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
      case InfoSystemPackage.RESIZING_ACTION__UID:
        return UID_EDEFAULT == null ? uID != null : !UID_EDEFAULT.equals(uID);
      case InfoSystemPackage.RESIZING_ACTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case InfoSystemPackage.RESIZING_ACTION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case InfoSystemPackage.RESIZING_ACTION__URL:
        return URL_EDEFAULT == null ? uRL != null : !URL_EDEFAULT.equals(uRL);
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
    result.append(", description: ");
    result.append(description);
    result.append(", uRL: ");
    result.append(uRL);
    result.append(')');
    return result.toString();
  }

} //ResizingActionImpl
