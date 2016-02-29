/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Keys</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Keys#getKeypairs <em>Keypairs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeys()
 * @model
 * @generated
 */
public interface Keys extends EObject
{
  /**
   * Returns the value of the '<em><b>Keypairs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.KeyPair}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keypairs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keypairs</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeys_Keypairs()
   * @model containment="true" required="true"
   * @generated
   */
  EList<KeyPair> getKeypairs();

} // Keys
