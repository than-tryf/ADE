/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flavors</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Flavors#getFlavors <em>Flavors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getFlavors()
 * @model
 * @generated
 */
public interface Flavors extends EObject
{
  /**
   * Returns the value of the '<em><b>Flavors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flavors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flavors</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getFlavors_Flavors()
   * @model containment="true" required="true"
   * @generated
   */
  EList<VirtualMachineImageFlavor> getFlavors();

} // Flavors
