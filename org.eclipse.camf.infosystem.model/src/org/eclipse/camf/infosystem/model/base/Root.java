/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Root#getCloudProviders <em>Cloud Providers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Cloud Providers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.CloudProvider}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cloud Providers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cloud Providers</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getRoot_CloudProviders()
   * @model containment="true" required="true"
   * @generated
   */
  EList<CloudProvider> getCloudProviders();

} // Root
