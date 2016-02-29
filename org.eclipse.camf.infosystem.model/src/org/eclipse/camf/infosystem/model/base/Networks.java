/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Networks</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Networks#getNets <em>Nets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getNetworks()
 * @model
 * @generated
 */
public interface Networks extends EObject
{
  /**
   * Returns the value of the '<em><b>Nets</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.VirtualNetwork}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nets</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nets</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getNetworks_Nets()
   * @model containment="true" required="true"
   * @generated
   */
  EList<VirtualNetwork> getNets();

} // Networks
