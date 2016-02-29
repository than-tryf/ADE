package org.eclipse.camf.infosystem.model.base.impl;


import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.Deployment;
import org.eclipse.camf.infosystem.model.base.Flavors;
import org.eclipse.camf.infosystem.model.base.Groups;
import org.eclipse.camf.infosystem.model.base.Images;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.InfoSystemPackage;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.Keys;
import org.eclipse.camf.infosystem.model.base.Module;
import org.eclipse.camf.infosystem.model.base.Monitoring;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.MonitoringService;
import org.eclipse.camf.infosystem.model.base.Networks;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.Root;
import org.eclipse.camf.infosystem.model.base.Security;
import org.eclipse.camf.infosystem.model.base.SecurityGroup;
import org.eclipse.camf.infosystem.model.base.SoftwareDependency;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.infosystem.model.base.VirtualInstance;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageType;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoSystemPackageImpl extends EPackageImpl implements InfoSystemPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass monitoringProbeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resizingActionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass softwareDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass userApplicationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keyPairEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualMachineImageFlavorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualNetworkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cloudProviderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualMachineImageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass deploymentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass virtualInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass securityGroupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass imagesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass networksEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass securityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keysEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass flavorsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass monitoringEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass monitoringServiceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum virtualMachineImageTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType virtualMachineImageTypeObjectEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private InfoSystemPackageImpl()
  {
    super(eNS_URI, InfoSystemFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link InfoSystemPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static InfoSystemPackage init()
  {
    if (isInited) return (InfoSystemPackage)EPackage.Registry.INSTANCE.getEPackage(InfoSystemPackage.eNS_URI);

    // Obtain or create and register package
    InfoSystemPackageImpl theInfoSystemPackage = (InfoSystemPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InfoSystemPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InfoSystemPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    XMLTypePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theInfoSystemPackage.createPackageContents();

    // Initialize created meta-data
    theInfoSystemPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInfoSystemPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(InfoSystemPackage.eNS_URI, theInfoSystemPackage);
    return theInfoSystemPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMonitoringProbe()
  {
    return monitoringProbeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_UID()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_Name()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_Description()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringProbe_Metrics()
  {
    return (EAttribute)monitoringProbeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResizingAction()
  {
    return resizingActionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_UID()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_Name()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_Description()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResizingAction_URL()
  {
    return (EAttribute)resizingActionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSoftwareDependency()
  {
    return softwareDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_UID()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Name()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Description()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_URL()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSoftwareDependency_Type()
  {
    return (EAttribute)softwareDependencyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUserApplication()
  {
    return userApplicationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_UID()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Name()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Description()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_URL()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUserApplication_Type()
  {
    return (EAttribute)userApplicationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyPair()
  {
    return keyPairEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_UID()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_Name()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_PublicKey()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_Description()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyPair_URL()
  {
    return (EAttribute)keyPairEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualMachineImageFlavor()
  {
    return virtualMachineImageFlavorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_Name()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_UID()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_Ram()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_Hdd()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImageFlavor_VCPU()
  {
    return (EAttribute)virtualMachineImageFlavorEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualNetwork()
  {
    return virtualNetworkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_UID()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_Name()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_Description()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualNetwork_URL()
  {
    return (EAttribute)virtualNetworkEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCloudProvider()
  {
    return cloudProviderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCloudProvider_Name()
  {
    return (EAttribute)cloudProviderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCloudProvider_Images()
  {
    return (EReference)cloudProviderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCloudProvider_Networks()
  {
    return (EReference)cloudProviderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCloudProvider_Security()
  {
    return (EReference)cloudProviderEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCloudProvider_Type()
  {
    return (EAttribute)cloudProviderEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCloudProvider_Flavors()
  {
    return (EReference)cloudProviderEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCloudProvider_Monitoring()
  {
    return (EReference)cloudProviderEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualMachineImage()
  {
    return virtualMachineImageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_UID()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Name()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Description()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_Type()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualMachineImage_URL()
  {
    return (EAttribute)virtualMachineImageEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeployment()
  {
    return deploymentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeployment_DepID()
  {
    return (EAttribute)deploymentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeployment_DeploymentName()
  {
    return (EAttribute)deploymentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDeployment_Modules()
  {
    return (EReference)deploymentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeployment_Status()
  {
    return (EAttribute)deploymentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_ModID()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_ModuleName()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Instances()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_InitInstances()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVirtualInstance()
  {
    return virtualInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualInstance_UID()
  {
    return (EAttribute)virtualInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualInstance_Name()
  {
    return (EAttribute)virtualInstanceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualInstance_Status()
  {
    return (EAttribute)virtualInstanceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualInstance_IPs()
  {
    return (EAttribute)virtualInstanceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVirtualInstance_URI()
  {
    return (EAttribute)virtualInstanceEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecurityGroup()
  {
    return securityGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSecurityGroup_UID()
  {
    return (EAttribute)securityGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSecurityGroup_Name()
  {
    return (EAttribute)securityGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSecurityGroup_Description()
  {
    return (EAttribute)securityGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_CloudProviders()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImages()
  {
    return imagesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getImages_Vms()
  {
    return (EReference)imagesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNetworks()
  {
    return networksEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNetworks_Nets()
  {
    return (EReference)networksEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecurity()
  {
    return securityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecurity_Keys()
  {
    return (EReference)securityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecurity_Groups()
  {
    return (EReference)securityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeys()
  {
    return keysEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKeys_Keypairs()
  {
    return (EReference)keysEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGroups()
  {
    return groupsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGroups_SecurityGroups()
  {
    return (EReference)groupsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFlavors()
  {
    return flavorsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFlavors_Flavors()
  {
    return (EReference)flavorsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMonitoring()
  {
    return monitoringEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMonitoring_MonitoringService()
  {
    return (EReference)monitoringEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMonitoringService()
  {
    return monitoringServiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMonitoringService_Name()
  {
    return (EAttribute)monitoringServiceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMonitoringService_Probes()
  {
    return (EReference)monitoringServiceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVirtualMachineImageType()
  {
    return virtualMachineImageTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getVirtualMachineImageTypeObject()
  {
    return virtualMachineImageTypeObjectEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfoSystemFactory getInfoSystemFactory()
  {
    return (InfoSystemFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    monitoringProbeEClass = createEClass(MONITORING_PROBE);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__UID);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__NAME);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__DESCRIPTION);
    createEAttribute(monitoringProbeEClass, MONITORING_PROBE__METRICS);

    resizingActionEClass = createEClass(RESIZING_ACTION);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__UID);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__NAME);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__DESCRIPTION);
    createEAttribute(resizingActionEClass, RESIZING_ACTION__URL);

    softwareDependencyEClass = createEClass(SOFTWARE_DEPENDENCY);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__UID);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__NAME);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__DESCRIPTION);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__URL);
    createEAttribute(softwareDependencyEClass, SOFTWARE_DEPENDENCY__TYPE);

    userApplicationEClass = createEClass(USER_APPLICATION);
    createEAttribute(userApplicationEClass, USER_APPLICATION__UID);
    createEAttribute(userApplicationEClass, USER_APPLICATION__NAME);
    createEAttribute(userApplicationEClass, USER_APPLICATION__DESCRIPTION);
    createEAttribute(userApplicationEClass, USER_APPLICATION__URL);
    createEAttribute(userApplicationEClass, USER_APPLICATION__TYPE);

    keyPairEClass = createEClass(KEY_PAIR);
    createEAttribute(keyPairEClass, KEY_PAIR__UID);
    createEAttribute(keyPairEClass, KEY_PAIR__NAME);
    createEAttribute(keyPairEClass, KEY_PAIR__PUBLIC_KEY);
    createEAttribute(keyPairEClass, KEY_PAIR__DESCRIPTION);
    createEAttribute(keyPairEClass, KEY_PAIR__URL);

    virtualMachineImageFlavorEClass = createEClass(VIRTUAL_MACHINE_IMAGE_FLAVOR);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__UID);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD);
    createEAttribute(virtualMachineImageFlavorEClass, VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU);

    virtualNetworkEClass = createEClass(VIRTUAL_NETWORK);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__UID);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__NAME);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__DESCRIPTION);
    createEAttribute(virtualNetworkEClass, VIRTUAL_NETWORK__URL);

    cloudProviderEClass = createEClass(CLOUD_PROVIDER);
    createEAttribute(cloudProviderEClass, CLOUD_PROVIDER__NAME);
    createEReference(cloudProviderEClass, CLOUD_PROVIDER__IMAGES);
    createEReference(cloudProviderEClass, CLOUD_PROVIDER__NETWORKS);
    createEReference(cloudProviderEClass, CLOUD_PROVIDER__SECURITY);
    createEAttribute(cloudProviderEClass, CLOUD_PROVIDER__TYPE);
    createEReference(cloudProviderEClass, CLOUD_PROVIDER__FLAVORS);
    createEReference(cloudProviderEClass, CLOUD_PROVIDER__MONITORING);

    virtualMachineImageEClass = createEClass(VIRTUAL_MACHINE_IMAGE);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__UID);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__NAME);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__DESCRIPTION);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__TYPE);
    createEAttribute(virtualMachineImageEClass, VIRTUAL_MACHINE_IMAGE__URL);

    deploymentEClass = createEClass(DEPLOYMENT);
    createEAttribute(deploymentEClass, DEPLOYMENT__DEP_ID);
    createEAttribute(deploymentEClass, DEPLOYMENT__DEPLOYMENT_NAME);
    createEReference(deploymentEClass, DEPLOYMENT__MODULES);
    createEAttribute(deploymentEClass, DEPLOYMENT__STATUS);

    moduleEClass = createEClass(MODULE);
    createEAttribute(moduleEClass, MODULE__MOD_ID);
    createEAttribute(moduleEClass, MODULE__MODULE_NAME);
    createEReference(moduleEClass, MODULE__INSTANCES);
    createEAttribute(moduleEClass, MODULE__INIT_INSTANCES);

    virtualInstanceEClass = createEClass(VIRTUAL_INSTANCE);
    createEAttribute(virtualInstanceEClass, VIRTUAL_INSTANCE__UID);
    createEAttribute(virtualInstanceEClass, VIRTUAL_INSTANCE__NAME);
    createEAttribute(virtualInstanceEClass, VIRTUAL_INSTANCE__STATUS);
    createEAttribute(virtualInstanceEClass, VIRTUAL_INSTANCE__IPS);
    createEAttribute(virtualInstanceEClass, VIRTUAL_INSTANCE__URI);

    securityGroupEClass = createEClass(SECURITY_GROUP);
    createEAttribute(securityGroupEClass, SECURITY_GROUP__UID);
    createEAttribute(securityGroupEClass, SECURITY_GROUP__NAME);
    createEAttribute(securityGroupEClass, SECURITY_GROUP__DESCRIPTION);

    rootEClass = createEClass(ROOT);
    createEReference(rootEClass, ROOT__CLOUD_PROVIDERS);

    imagesEClass = createEClass(IMAGES);
    createEReference(imagesEClass, IMAGES__VMS);

    networksEClass = createEClass(NETWORKS);
    createEReference(networksEClass, NETWORKS__NETS);

    securityEClass = createEClass(SECURITY);
    createEReference(securityEClass, SECURITY__KEYS);
    createEReference(securityEClass, SECURITY__GROUPS);

    keysEClass = createEClass(KEYS);
    createEReference(keysEClass, KEYS__KEYPAIRS);

    groupsEClass = createEClass(GROUPS);
    createEReference(groupsEClass, GROUPS__SECURITY_GROUPS);

    flavorsEClass = createEClass(FLAVORS);
    createEReference(flavorsEClass, FLAVORS__FLAVORS);

    monitoringEClass = createEClass(MONITORING);
    createEReference(monitoringEClass, MONITORING__MONITORING_SERVICE);

    monitoringServiceEClass = createEClass(MONITORING_SERVICE);
    createEAttribute(monitoringServiceEClass, MONITORING_SERVICE__NAME);
    createEReference(monitoringServiceEClass, MONITORING_SERVICE__PROBES);

    // Create enums
    virtualMachineImageTypeEEnum = createEEnum(VIRTUAL_MACHINE_IMAGE_TYPE);

    // Create data types
    virtualMachineImageTypeObjectEDataType = createEDataType(VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(monitoringProbeEClass, MonitoringProbe.class, "MonitoringProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMonitoringProbe_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMonitoringProbe_Metrics(), theXMLTypePackage.getString(), "metrics", null, 1, 1, MonitoringProbe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resizingActionEClass, ResizingAction.class, "ResizingAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResizingAction_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getResizingAction_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, ResizingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(softwareDependencyEClass, SoftwareDependency.class, "SoftwareDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSoftwareDependency_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSoftwareDependency_Type(), theXMLTypePackage.getString(), "type", "", 1, 1, SoftwareDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(userApplicationEClass, UserApplication.class, "UserApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUserApplication_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUserApplication_Type(), theXMLTypePackage.getString(), "type", "", 1, 1, UserApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keyPairEClass, KeyPair.class, "KeyPair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyPair_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_PublicKey(), theXMLTypePackage.getString(), "publicKey", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_Description(), theXMLTypePackage.getString(), "Description", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyPair_URL(), theXMLTypePackage.getString(), "URL", null, 1, 1, KeyPair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualMachineImageFlavorEClass, VirtualMachineImageFlavor.class, "VirtualMachineImageFlavor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualMachineImageFlavor_Name(), ecorePackage.getEString(), "name", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImageFlavor_UID(), ecorePackage.getEString(), "uID", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImageFlavor_Ram(), theXMLTypePackage.getString(), "ram", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImageFlavor_Hdd(), theXMLTypePackage.getString(), "hdd", null, 1, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImageFlavor_VCPU(), theXMLTypePackage.getString(), "vCPU", null, 0, 1, VirtualMachineImageFlavor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualNetworkEClass, VirtualNetwork.class, "VirtualNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualNetwork_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualNetwork_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, VirtualNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cloudProviderEClass, CloudProvider.class, "CloudProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCloudProvider_Name(), theXMLTypePackage.getString(), "Name", null, 0, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCloudProvider_Images(), this.getImages(), null, "images", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCloudProvider_Networks(), this.getNetworks(), null, "networks", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCloudProvider_Security(), this.getSecurity(), null, "security", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCloudProvider_Type(), theXMLTypePackage.getString(), "type", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCloudProvider_Flavors(), this.getFlavors(), null, "flavors", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCloudProvider_Monitoring(), this.getMonitoring(), null, "monitoring", null, 1, 1, CloudProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualMachineImageEClass, VirtualMachineImage.class, "VirtualMachineImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualMachineImage_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Description(), theXMLTypePackage.getString(), "description", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_Type(), this.getVirtualMachineImageType(), "type", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualMachineImage_URL(), theXMLTypePackage.getString(), "uRL", null, 1, 1, VirtualMachineImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(deploymentEClass, Deployment.class, "Deployment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDeployment_DepID(), theXMLTypePackage.getString(), "depID", null, 1, 1, Deployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDeployment_DeploymentName(), theXMLTypePackage.getString(), "deploymentName", null, 1, 1, Deployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDeployment_Modules(), this.getModule(), null, "modules", null, 1, -1, Deployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDeployment_Status(), theXMLTypePackage.getString(), "Status", null, 1, 1, Deployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_ModID(), theXMLTypePackage.getString(), "modID", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_ModuleName(), theXMLTypePackage.getString(), "moduleName", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Instances(), this.getVirtualInstance(), null, "instances", null, 1, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_InitInstances(), theXMLTypePackage.getString(), "initInstances", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(virtualInstanceEClass, VirtualInstance.class, "VirtualInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVirtualInstance_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, VirtualInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualInstance_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, VirtualInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualInstance_Status(), theXMLTypePackage.getString(), "status", null, 1, 1, VirtualInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualInstance_IPs(), theXMLTypePackage.getString(), "IPs", null, 1, 1, VirtualInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVirtualInstance_URI(), theXMLTypePackage.getString(), "URI", null, 1, 1, VirtualInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(securityGroupEClass, SecurityGroup.class, "SecurityGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSecurityGroup_UID(), theXMLTypePackage.getString(), "uID", null, 1, 1, SecurityGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSecurityGroup_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, SecurityGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSecurityGroup_Description(), theXMLTypePackage.getString(), "description", "", 1, 1, SecurityGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoot_CloudProviders(), this.getCloudProvider(), null, "cloudProviders", null, 1, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(imagesEClass, Images.class, "Images", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getImages_Vms(), this.getVirtualMachineImage(), null, "vms", null, 1, -1, Images.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(networksEClass, Networks.class, "Networks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNetworks_Nets(), this.getVirtualNetwork(), null, "nets", null, 1, -1, Networks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(securityEClass, Security.class, "Security", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecurity_Keys(), this.getKeys(), null, "keys", null, 1, 1, Security.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSecurity_Groups(), this.getGroups(), null, "groups", null, 1, 1, Security.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keysEClass, Keys.class, "Keys", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getKeys_Keypairs(), this.getKeyPair(), null, "keypairs", null, 1, -1, Keys.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupsEClass, Groups.class, "Groups", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGroups_SecurityGroups(), this.getSecurityGroup(), null, "securityGroups", null, 1, -1, Groups.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(flavorsEClass, Flavors.class, "Flavors", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFlavors_Flavors(), this.getVirtualMachineImageFlavor(), null, "flavors", null, 1, -1, Flavors.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(monitoringEClass, Monitoring.class, "Monitoring", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMonitoring_MonitoringService(), this.getMonitoringService(), null, "monitoringService", null, 1, -1, Monitoring.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(monitoringServiceEClass, MonitoringService.class, "MonitoringService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMonitoringService_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, MonitoringService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMonitoringService_Probes(), this.getMonitoringProbe(), null, "probes", null, 1, -1, MonitoringService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(virtualMachineImageTypeEEnum, VirtualMachineImageType.class, "VirtualMachineImageType");
    addEEnumLiteral(virtualMachineImageTypeEEnum, VirtualMachineImageType.BASE_IMAGE);
    addEEnumLiteral(virtualMachineImageTypeEEnum, VirtualMachineImageType.CUSTOM_IMAGE);

    // Initialize data types
    initEDataType(virtualMachineImageTypeObjectEDataType, VirtualMachineImageType.class, "VirtualMachineImageTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
    createExtendedMetaDataAnnotations();
  }

  /**
   * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createExtendedMetaDataAnnotations()
  {
    String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
    addAnnotation
      (monitoringProbeEClass, 
       source, 
       new String[] 
       {
       "name", "MonitoringProbe",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getMonitoringProbe_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getMonitoringProbe_Metrics(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (resizingActionEClass, 
       source, 
       new String[] 
       {
       "name", "ResizingAction",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getResizingAction_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getResizingAction_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (softwareDependencyEClass, 
       source, 
       new String[] 
       {
       "name", "SoftwareDependency",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getSoftwareDependency_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getSoftwareDependency_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualMachineImageTypeEEnum, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImageType"
       });	
    addAnnotation
      (virtualMachineImageTypeObjectEDataType, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImageType:Object",
       "baseType", "VirtualMachineImageType"
       });	
    addAnnotation
      (userApplicationEClass, 
       source, 
       new String[] 
       {
       "name", "SoftwareDependency",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getUserApplication_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getUserApplication_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (keyPairEClass, 
       source, 
       new String[] 
       {
       "name", "KeyPair",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getKeyPair_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getKeyPair_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getKeyPair_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualNetworkEClass, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImage",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getVirtualNetwork_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualNetwork_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (virtualMachineImageEClass, 
       source, 
       new String[] 
       {
       "name", "VirtualMachineImage",
       "kind", "elementOnly"
       });	
    addAnnotation
      (getVirtualMachineImage_UID(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "UID",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Name(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Name",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Description(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Description",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_Type(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "Type",
       "namespace", "##targetNamespace"
       });	
    addAnnotation
      (getVirtualMachineImage_URL(), 
       source, 
       new String[] 
       {
       "kind", "element",
       "name", "URL",
       "namespace", "##targetNamespace"
       });
  }

} //InfoSystemPackageImpl