/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/
/**
 */
package org.eclipse.camf.tosca.impl;

import org.eclipse.camf.tosca.NodeOperationType;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Operation Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.impl.NodeOperationTypeImpl#getInterfaceName <em>Interface Name</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.NodeOperationTypeImpl#getNodeRef <em>Node Ref</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.impl.NodeOperationTypeImpl#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeOperationTypeImpl extends EObjectImpl implements NodeOperationType
{
  /**
   * The default value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceName()
   * @generated
   * @ordered
   */
  protected static final String INTERFACE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInterfaceName() <em>Interface Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfaceName()
   * @generated
   * @ordered
   */
  protected String interfaceName = INTERFACE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getNodeRef() <em>Node Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeRef()
   * @generated
   * @ordered
   */
  protected static final String NODE_REF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getNodeRef() <em>Node Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNodeRef()
   * @generated
   * @ordered
   */
  protected String nodeRef = NODE_REF_EDEFAULT;

  /**
   * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName()
   * @generated
   * @ordered
   */
  protected static final String OPERATION_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationName()
   * @generated
   * @ordered
   */
  protected String operationName = OPERATION_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NodeOperationTypeImpl()
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
    return ToscaPackage.Literals.NODE_OPERATION_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInterfaceName()
  {
    return interfaceName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterfaceName(String newInterfaceName)
  {
    String oldInterfaceName = interfaceName;
    interfaceName = newInterfaceName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME, oldInterfaceName, interfaceName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getNodeRef()
  {
    return nodeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNodeRef(String newNodeRef)
  {
    String oldNodeRef = nodeRef;
    nodeRef = newNodeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__NODE_REF, oldNodeRef, nodeRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperationName()
  {
    return operationName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationName(String newOperationName)
  {
    String oldOperationName = operationName;
    operationName = newOperationName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME, oldOperationName, operationName));
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
      case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
        return getInterfaceName();
      case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
        return getNodeRef();
      case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
        return getOperationName();
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
      case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
        setInterfaceName((String)newValue);
        return;
      case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
        setNodeRef((String)newValue);
        return;
      case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
        setOperationName((String)newValue);
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
      case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
        setInterfaceName(INTERFACE_NAME_EDEFAULT);
        return;
      case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
        setNodeRef(NODE_REF_EDEFAULT);
        return;
      case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
        setOperationName(OPERATION_NAME_EDEFAULT);
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
      case ToscaPackage.NODE_OPERATION_TYPE__INTERFACE_NAME:
        return INTERFACE_NAME_EDEFAULT == null ? interfaceName != null : !INTERFACE_NAME_EDEFAULT.equals(interfaceName);
      case ToscaPackage.NODE_OPERATION_TYPE__NODE_REF:
        return NODE_REF_EDEFAULT == null ? nodeRef != null : !NODE_REF_EDEFAULT.equals(nodeRef);
      case ToscaPackage.NODE_OPERATION_TYPE__OPERATION_NAME:
        return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
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
    result.append(" (interfaceName: "); //$NON-NLS-1$
    result.append(interfaceName);
    result.append(", nodeRef: "); //$NON-NLS-1$
    result.append(nodeRef);
    result.append(", operationName: "); //$NON-NLS-1$
    result.append(operationName);
    result.append(')');
    return result.toString();
  }

} //NodeOperationTypeImpl
