package org.eclipse.camf.tosca.impl;

import org.eclipse.camf.tosca.CapabilitiesType;
import org.eclipse.camf.tosca.PoliciesType;
import org.eclipse.camf.tosca.RequirementsType;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TReadyToUse;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class TReadyToUseImpl extends TEntityTemplateImpl implements TReadyToUse{

	/**
	   * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getRequirements()
	   * @generated
	   * @ordered
	   */
	  protected RequirementsType requirements;

	  /**
	   * The cached value of the '{@link #getCapabilities() <em>Capabilities</em>}' containment reference.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getCapabilities()
	   * @generated
	   * @ordered
	   */
	  protected CapabilitiesType capabilities;

	  /**
	   * The cached value of the '{@link #getPolicies() <em>Policies</em>}' containment reference.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getPolicies()
	   * @generated
	   * @ordered
	   */
	  protected PoliciesType policies;

	  /**
	   * The cached value of the '{@link #getDeploymentArtifacts() <em>Deployment Artifacts</em>}' containment reference.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getDeploymentArtifacts()
	   * @generated
	   * @ordered
	   */
	  protected TDeploymentArtifacts deploymentArtifacts;

	  /**
	   * The default value of the '{@link #getMaxInstances() <em>Max Instances</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getMaxInstances()
	   * @generated
	   * @ordered
	   */
	  protected static final Object MAX_INSTANCES_EDEFAULT = ToscaFactory.eINSTANCE.createFromString(ToscaPackage.eINSTANCE.getMaxInstancesType(), "1"); //$NON-NLS-1$

	  /**
	   * The cached value of the '{@link #getMaxInstances() <em>Max Instances</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getMaxInstances()
	   * @generated
	   * @ordered
	   */
	  protected Object maxInstances = MAX_INSTANCES_EDEFAULT;

	  /**
	   * This is true if the Max Instances attribute has been set.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   * @ordered
	   */
	  protected boolean maxInstancesESet;

	  /**
	   * The default value of the '{@link #getMinInstances() <em>Min Instances</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getMinInstances()
	   * @generated
	   * @ordered
	   */
	  protected static final int MIN_INSTANCES_EDEFAULT = 1;

	  /**
	   * The cached value of the '{@link #getMinInstances() <em>Min Instances</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getMinInstances()
	   * @generated
	   * @ordered
	   */
	  protected int minInstances = MIN_INSTANCES_EDEFAULT;

	  /**
	   * This is true if the Min Instances attribute has been set.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   * @ordered
	   */
	  protected boolean minInstancesESet;

	  /**
	   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getName()
	   * @generated
	   * @ordered
	   */
	  protected static final String NAME_EDEFAULT = null;

	  /**
	   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @see #getName()
	   * @generated
	   * @ordered
	   */
	  protected String name = NAME_EDEFAULT;

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  protected TReadyToUseImpl()
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
	    return ToscaPackage.Literals.TNODE_TEMPLATE;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public RequirementsType getRequirements()
	  {
	    return this.requirements;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public NotificationChain basicSetRequirements(RequirementsType newRequirements, NotificationChain msgs)
	  {
	    RequirementsType oldRequirements = this.requirements;
	    this.requirements = newRequirements;
	    if (eNotificationRequired())
	    {
	      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS, oldRequirements, newRequirements);
	      if (msgs == null) msgs = notification; else msgs.add(notification);
	    }
	    return msgs;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setRequirements(RequirementsType newRequirements)
	  {
	    if (newRequirements != this.requirements)
	    {
	      NotificationChain msgs = null;
	      if (this.requirements != null)
	        msgs = ((InternalEObject)this.requirements).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS, null, msgs);
	      if (newRequirements != null)
	        msgs = ((InternalEObject)newRequirements).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS, null, msgs);
	      msgs = basicSetRequirements(newRequirements, msgs);
	      if (msgs != null) msgs.dispatch();
	    }
	    else if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS, newRequirements, newRequirements));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public CapabilitiesType getCapabilities()
	  {
	    return this.capabilities;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public NotificationChain basicSetCapabilities(CapabilitiesType newCapabilities, NotificationChain msgs)
	  {
	    CapabilitiesType oldCapabilities = this.capabilities;
	    this.capabilities = newCapabilities;
	    if (eNotificationRequired())
	    {
	      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__CAPABILITIES, oldCapabilities, newCapabilities);
	      if (msgs == null) msgs = notification; else msgs.add(notification);
	    }
	    return msgs;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setCapabilities(CapabilitiesType newCapabilities)
	  {
	    if (newCapabilities != this.capabilities)
	    {
	      NotificationChain msgs = null;
	      if (this.capabilities != null)
	        msgs = ((InternalEObject)this.capabilities).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__CAPABILITIES, null, msgs);
	      if (newCapabilities != null)
	        msgs = ((InternalEObject)newCapabilities).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__CAPABILITIES, null, msgs);
	      msgs = basicSetCapabilities(newCapabilities, msgs);
	      if (msgs != null) msgs.dispatch();
	    }
	    else if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__CAPABILITIES, newCapabilities, newCapabilities));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public PoliciesType getPolicies()
	  {
	    return this.policies;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public NotificationChain basicSetPolicies(PoliciesType newPolicies, NotificationChain msgs)
	  {
	    PoliciesType oldPolicies = this.policies;
	    this.policies = newPolicies;
	    if (eNotificationRequired())
	    {
	      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__POLICIES, oldPolicies, newPolicies);
	      if (msgs == null) msgs = notification; else msgs.add(notification);
	    }
	    return msgs;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setPolicies(PoliciesType newPolicies)
	  {
	    if (newPolicies != this.policies)
	    {
	      NotificationChain msgs = null;
	      if (this.policies != null)
	        msgs = ((InternalEObject)this.policies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__POLICIES, null, msgs);
	      if (newPolicies != null)
	        msgs = ((InternalEObject)newPolicies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__POLICIES, null, msgs);
	      msgs = basicSetPolicies(newPolicies, msgs);
	      if (msgs != null) msgs.dispatch();
	    }
	    else if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__POLICIES, newPolicies, newPolicies));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public TDeploymentArtifacts getDeploymentArtifacts()
	  {
	    return this.deploymentArtifacts;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public NotificationChain basicSetDeploymentArtifacts(TDeploymentArtifacts newDeploymentArtifacts, NotificationChain msgs)
	  {
	    TDeploymentArtifacts oldDeploymentArtifacts = this.deploymentArtifacts;
	    this.deploymentArtifacts = newDeploymentArtifacts;
	    if (eNotificationRequired())
	    {
	      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS, oldDeploymentArtifacts, newDeploymentArtifacts);
	      if (msgs == null) msgs = notification; else msgs.add(notification);
	    }
	    return msgs;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setDeploymentArtifacts(TDeploymentArtifacts newDeploymentArtifacts)
	  {
	    if (newDeploymentArtifacts != this.deploymentArtifacts)
	    {
	      NotificationChain msgs = null;
	      if (this.deploymentArtifacts != null)
	        msgs = ((InternalEObject)this.deploymentArtifacts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS, null, msgs);
	      if (newDeploymentArtifacts != null)
	        msgs = ((InternalEObject)newDeploymentArtifacts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS, null, msgs);
	      msgs = basicSetDeploymentArtifacts(newDeploymentArtifacts, msgs);
	      if (msgs != null) msgs.dispatch();
	    }
	    else if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS, newDeploymentArtifacts, newDeploymentArtifacts));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public Object getMaxInstances()
	  {
	    return this.maxInstances;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setMaxInstances(Object newMaxInstances)
	  {
	    Object oldMaxInstances = this.maxInstances;
	    this.maxInstances = newMaxInstances;
	    boolean oldMaxInstancesESet = this.maxInstancesESet;
	    this.maxInstancesESet = true;
	    if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES, oldMaxInstances, this.maxInstances, !oldMaxInstancesESet));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void unsetMaxInstances()
	  {
	    Object oldMaxInstances = this.maxInstances;
	    boolean oldMaxInstancesESet = this.maxInstancesESet;
	    this.maxInstances = MAX_INSTANCES_EDEFAULT;
	    this.maxInstancesESet = false;
	    if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.UNSET, ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES, oldMaxInstances, MAX_INSTANCES_EDEFAULT, oldMaxInstancesESet));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public boolean isSetMaxInstances()
	  {
	    return this.maxInstancesESet;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public int getMinInstances()
	  {
	    return this.minInstances;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setMinInstances(int newMinInstances)
	  {
	    int oldMinInstances = this.minInstances;
	    this.minInstances = newMinInstances;
	    boolean oldMinInstancesESet = this.minInstancesESet;
	    this.minInstancesESet = true;
	    if( eNotificationRequired() )
	      eNotify( new ENotificationImpl( this,
	                                      Notification.SET,
	                                      ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES,
	                                      oldMinInstances,
	                                      this.minInstances,
	                                      !oldMinInstancesESet ) );
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void unsetMinInstances()
	  {
	    int oldMinInstances = this.minInstances;
	    boolean oldMinInstancesESet = this.minInstancesESet;
	    this.minInstances = MIN_INSTANCES_EDEFAULT;
	    this.minInstancesESet = false;
	    if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.UNSET, ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES, oldMinInstances, MIN_INSTANCES_EDEFAULT, oldMinInstancesESet));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public boolean isSetMinInstances()
	  {
	    return this.minInstancesESet;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public String getName()
	  {
	    return this.name;
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  public void setName(String newName)
	  {
	    String oldName = this.name;
	    this.name = newName;
	    if (eNotificationRequired())
	      eNotify(new ENotificationImpl(this, Notification.SET, ToscaPackage.TNODE_TEMPLATE__NAME, oldName, this.name));
	  }

	  /**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated
	   */
	  @Override
	  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	  {
	    switch (featureID)
	    {
	      case ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS:
	        return basicSetRequirements(null, msgs);
	      case ToscaPackage.TNODE_TEMPLATE__CAPABILITIES:
	        return basicSetCapabilities(null, msgs);
	      case ToscaPackage.TNODE_TEMPLATE__POLICIES:
	        return basicSetPolicies(null, msgs);
	      case ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS:
	        return basicSetDeploymentArtifacts(null, msgs);
	    }
	    return super.eInverseRemove(otherEnd, featureID, msgs);
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
	      case ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS:
	        return getRequirements();
	      case ToscaPackage.TNODE_TEMPLATE__CAPABILITIES:
	        return getCapabilities();
	      case ToscaPackage.TNODE_TEMPLATE__POLICIES:
	        return getPolicies();
	      case ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS:
	        return getDeploymentArtifacts();
	      case ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES:
	        return getMaxInstances();
	      case ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES:
	        return getMinInstances();
	      case ToscaPackage.TNODE_TEMPLATE__NAME:
	        return getName();
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
	      case ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS:
	        setRequirements((RequirementsType)newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__CAPABILITIES:
	        setCapabilities((CapabilitiesType)newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__POLICIES:
	        setPolicies((PoliciesType)newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS:
	        setDeploymentArtifacts((TDeploymentArtifacts)newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES:
	        setMaxInstances(newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES:
	        setMinInstances((Integer)newValue);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__NAME:
	        setName((String)newValue);
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
	      case ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS:
	        setRequirements((RequirementsType)null);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__CAPABILITIES:
	        setCapabilities((CapabilitiesType)null);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__POLICIES:
	        setPolicies((PoliciesType)null);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS:
	        setDeploymentArtifacts((TDeploymentArtifacts)null);
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES:
	        unsetMaxInstances();
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES:
	        unsetMinInstances();
	        return;
	      case ToscaPackage.TNODE_TEMPLATE__NAME:
	        setName(NAME_EDEFAULT);
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
	      case ToscaPackage.TNODE_TEMPLATE__REQUIREMENTS:
	        return this.requirements != null;
	      case ToscaPackage.TNODE_TEMPLATE__CAPABILITIES:
	        return this.capabilities != null;
	      case ToscaPackage.TNODE_TEMPLATE__POLICIES:
	        return this.policies != null;
	      case ToscaPackage.TNODE_TEMPLATE__DEPLOYMENT_ARTIFACTS:
	        return this.deploymentArtifacts != null;
	      case ToscaPackage.TNODE_TEMPLATE__MAX_INSTANCES:
	        return isSetMaxInstances();
	      case ToscaPackage.TNODE_TEMPLATE__MIN_INSTANCES:
	        return isSetMinInstances();
	      case ToscaPackage.TNODE_TEMPLATE__NAME:
	        return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals(this.name);
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
	    result.append(" (maxInstances: "); //$NON-NLS-1$
	    if (this.maxInstancesESet) result.append(this.maxInstances); else result.append("<unset>"); //$NON-NLS-1$
	    result.append(", minInstances: "); //$NON-NLS-1$
	    if (this.minInstancesESet) result.append(this.minInstances); else result.append("<unset>"); //$NON-NLS-1$
	    result.append(", name: "); //$NON-NLS-1$
	    result.append(this.name);
	    result.append(')');
	    return result.toString();
	  }
}
