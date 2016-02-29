package org.eclipse.camf.infosystem.model.base;


import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getIPs <em>IPs</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getURI <em>URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance()
 * @model
 * @generated
 */
public interface VirtualInstance extends EObject
{
  /**
   * Returns the value of the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>UID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>UID</em>' attribute.
   * @see #setUID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance_UID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getUID();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getUID <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>UID</em>' attribute.
   * @see #getUID()
   * @generated
   */
  void setUID(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status</em>' attribute.
   * @see #setStatus(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance_Status()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getStatus();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getStatus <em>Status</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' attribute.
   * @see #getStatus()
   * @generated
   */
  void setStatus(String value);

  /**
   * Returns the value of the '<em><b>IPs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>IPs</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>IPs</em>' attribute.
   * @see #setIPs(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance_IPs()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getIPs();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getIPs <em>IPs</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>IPs</em>' attribute.
   * @see #getIPs()
   * @generated
   */
  void setIPs(String value);

  /**
   * Returns the value of the '<em><b>URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>URI</em>' attribute.
   * @see #setURI(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getVirtualInstance_URI()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
  String getURI();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getURI <em>URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>URI</em>' attribute.
   * @see #getURI()
   * @generated
   */
  void setURI(String value);

} // VirtualInstance