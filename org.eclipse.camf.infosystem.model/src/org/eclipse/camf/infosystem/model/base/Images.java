/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Images</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Images#getVms <em>Vms</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getImages()
 * @model
 * @generated
 */
public interface Images extends EObject
{
  /**
   * Returns the value of the '<em><b>Vms</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vms</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vms</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getImages_Vms()
   * @model containment="true" required="true"
   * @generated
   */
  EList<VirtualMachineImage> getVms();

} // Images
