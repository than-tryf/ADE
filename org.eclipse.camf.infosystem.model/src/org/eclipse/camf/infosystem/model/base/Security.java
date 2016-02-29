/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Security#getKeys <em>Keys</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Security#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getSecurity()
 * @model
 * @generated
 */
public interface Security extends EObject
{
  /**
   * Returns the value of the '<em><b>Keys</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keys</em>' containment reference.
   * @see #setKeys(Keys)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getSecurity_Keys()
   * @model containment="true" required="true"
   * @generated
   */
  Keys getKeys();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Security#getKeys <em>Keys</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Keys</em>' containment reference.
   * @see #getKeys()
   * @generated
   */
  void setKeys(Keys value);

  /**
   * Returns the value of the '<em><b>Groups</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groups</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groups</em>' containment reference.
   * @see #setGroups(Groups)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getSecurity_Groups()
   * @model containment="true" required="true"
   * @generated
   */
  Groups getGroups();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.Security#getGroups <em>Groups</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Groups</em>' containment reference.
   * @see #getGroups()
   * @generated
   */
  void setGroups(Groups value);

} // Security
