/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
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
package org.eclipse.camf.tosca.elasticity.impl;

import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.impl.TNodeTemplateImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TNode Template Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getInitInstances <em>Init Instances</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.camf.tosca.elasticity.impl.TNodeTemplateExtensionImpl#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TNodeTemplateExtensionImpl extends TNodeTemplateImpl implements TNodeTemplateExtension
{
  /**
	 * An array of objects representing the values of non-primitive features.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected Object[] eVirtualValues;

  /**
	 * A bit field representing the indices of non-primitive feature values.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected int eVirtualIndexBits0;

  /**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
  protected static final int HEIGHT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
  protected int height = HEIGHT_EDEFAULT;

  /**
	 * This is true if the Height attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean heightESet;

  /**
	 * The default value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInitInstances()
	 * @generated
	 * @ordered
	 */
  protected static final int INIT_INSTANCES_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getInitInstances() <em>Init Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getInitInstances()
	 * @generated
	 * @ordered
	 */
  protected int initInstances = INIT_INSTANCES_EDEFAULT;

  /**
	 * This is true if the Init Instances attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean initInstancesESet;

  /**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
  protected static final int WIDTH_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
  protected int width = WIDTH_EDEFAULT;

  /**
	 * This is true if the Width attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean widthESet;

  /**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
  protected static final int X_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
  protected int x = X_EDEFAULT;

  /**
	 * This is true if the X attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean xESet;

  /**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
  protected static final int Y_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
  protected int y = Y_EDEFAULT;

  /**
	 * This is true if the Y attribute has been set.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  protected boolean yESet;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TNodeTemplateExtensionImpl()
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
		return Tosca_Elasticity_ExtensionsPackage.Literals.TNODE_TEMPLATE_EXTENSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getHeight()
  {
		return height;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setHeight(int newHeight)
  {
		int oldHeight = height;
		height = newHeight;
		boolean oldHeightESet = heightESet;
		heightESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT, oldHeight, height, !oldHeightESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetHeight()
  {
		int oldHeight = height;
		boolean oldHeightESet = heightESet;
		height = HEIGHT_EDEFAULT;
		heightESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT, oldHeight, HEIGHT_EDEFAULT, oldHeightESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetHeight()
  {
		return heightESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getInitInstances()
  {
		return initInstances;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setInitInstances(int newInitInstances)
  {
		int oldInitInstances = initInstances;
		initInstances = newInitInstances;
		boolean oldInitInstancesESet = initInstancesESet;
		initInstancesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES, oldInitInstances, initInstances, !oldInitInstancesESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetInitInstances()
  {
		int oldInitInstances = initInstances;
		boolean oldInitInstancesESet = initInstancesESet;
		initInstances = INIT_INSTANCES_EDEFAULT;
		initInstancesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES, oldInitInstances, INIT_INSTANCES_EDEFAULT, oldInitInstancesESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetInitInstances()
  {
		return initInstancesESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getWidth()
  {
		return width;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWidth(int newWidth)
  {
		int oldWidth = width;
		width = newWidth;
		boolean oldWidthESet = widthESet;
		widthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH, oldWidth, width, !oldWidthESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetWidth()
  {
		int oldWidth = width;
		boolean oldWidthESet = widthESet;
		width = WIDTH_EDEFAULT;
		widthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH, oldWidth, WIDTH_EDEFAULT, oldWidthESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetWidth()
  {
		return widthESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getX()
  {
		return x;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setX(int newX)
  {
		int oldX = x;
		x = newX;
		boolean oldXESet = xESet;
		xESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X, oldX, x, !oldXESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetX()
  {
		int oldX = x;
		boolean oldXESet = xESet;
		x = X_EDEFAULT;
		xESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X, oldX, X_EDEFAULT, oldXESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetX()
  {
		return xESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getY()
  {
		return y;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setY(int newY)
  {
		int oldY = y;
		y = newY;
		boolean oldYESet = yESet;
		yESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y, oldY, y, !oldYESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void unsetY()
  {
		int oldY = y;
		boolean oldYESet = yESet;
		y = Y_EDEFAULT;
		yESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y, oldY, Y_EDEFAULT, oldYESet));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetY()
  {
		return yESet;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT:
				return getHeight();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
				return getInitInstances();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH:
				return getWidth();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
				return getX();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
				return getY();
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
				setInitInstances((Integer)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH:
				setWidth((Integer)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
				setX((Integer)newValue);
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
				setY((Integer)newValue);
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT:
				unsetHeight();
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
				unsetInitInstances();
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH:
				unsetWidth();
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
				unsetX();
				return;
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
				unsetY();
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
		switch (featureID) {
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__HEIGHT:
				return isSetHeight();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__INIT_INSTANCES:
				return isSetInitInstances();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__WIDTH:
				return isSetWidth();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__X:
				return isSetX();
			case Tosca_Elasticity_ExtensionsPackage.TNODE_TEMPLATE_EXTENSION__Y:
				return isSetY();
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Object[] eVirtualValues()
  {
		return eVirtualValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualValues(Object[] newValues)
  {
		eVirtualValues = newValues;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected int eVirtualIndexBits(int offset)
  {
		switch (offset) {
			case 0 :
				return eVirtualIndexBits0;
			default :
				throw new IndexOutOfBoundsException();
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected void eSetVirtualIndexBits(int offset, int newIndexBits)
  {
		switch (offset) {
			case 0 :
				eVirtualIndexBits0 = newIndexBits;
				break;
			default :
				throw new IndexOutOfBoundsException();
		}
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
		result.append(" (height: ");
		if (heightESet) result.append(height); else result.append("<unset>");
		result.append(", initInstances: ");
		if (initInstancesESet) result.append(initInstances); else result.append("<unset>");
		result.append(", width: ");
		if (widthESet) result.append(width); else result.append("<unset>");
		result.append(", x: ");
		if (xESet) result.append(x); else result.append("<unset>");
		result.append(", y: ");
		if (yESet) result.append(y); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TNodeTemplateExtensionImpl
