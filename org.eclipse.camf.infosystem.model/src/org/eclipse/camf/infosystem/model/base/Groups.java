/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Groups</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Groups#getSecurityGroups <em>Security Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getGroups()
 * @model
 * @generated
 */
public interface Groups extends EObject
{
  /**
   * Returns the value of the '<em><b>Security Groups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.SecurityGroup}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Security Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Security Groups</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getGroups_SecurityGroups()
   * @model containment="true" required="true"
   * @generated
   */
  EList<SecurityGroup> getSecurityGroups();

} // Groups
