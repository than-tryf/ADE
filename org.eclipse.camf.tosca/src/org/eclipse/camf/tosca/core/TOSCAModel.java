/*******************************************************************************
 * Copyright (c) 2013, 2014 Laboratory for Internet Computing, University of Cyprus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/

package org.eclipse.camf.tosca.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.impl.AbstractCloudContainer;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.PropertiesType1;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.ToscaPackage;
import org.eclipse.camf.tosca.elasticity.ServicePropertiesType;
import org.eclipse.camf.tosca.elasticity.TBoundaryDefinitionsExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.util.ToscaResourceFactoryImpl;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.Resource.IOWrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.example.sybl.SyblPackage;



public class TOSCAModel extends AbstractCloudContainer
  implements ICloudApplicationDescription
{
  
  protected ToscaPackage toscaPackage = ToscaPackage.eINSTANCE;
  protected ToscaFactory toscaFactory = ToscaFactory.eINSTANCE;
  protected Tosca_Elasticity_ExtensionsFactory elasticityFactory = Tosca_Elasticity_ExtensionsFactory.eINSTANCE;
  private File fileResource;
  private DocumentRoot documentRoot;
  private DefinitionsType definitionsType;
  private TServiceTemplateExtension serviceTemplate;
  private TTopologyTemplate topologyTemplate;
  private TBoundaryDefinitionsExtension boundaryDef;
  public Resource resource;
  
  
  public TOSCAModel (final File file) throws IOWrappedException{
    this.fileResource = file;
    loadModel ();    
  }
  
  public void loadModel() throws IOWrappedException {
    if( this.fileResource.length() != 0 ) {
      String filePath = this.fileResource.getAbsolutePath();
      URI uri = URI.createFileURI( filePath );
      ResourceSet resourceSet = new ResourceSetImpl();
      this.resource = resourceSet.createResource( uri );
      XMLMapImpl baseToscaMap = new XMLMapImpl();
      baseToscaMap.setNoNamespacePackage( ToscaPackage.eINSTANCE );      
      XMLMapImpl elasticityToscaMap = new XMLMapImpl();
      elasticityToscaMap.setNoNamespacePackage( Tosca_Elasticity_ExtensionsPackage.eINSTANCE );
      
      XMLMapImpl syblMap = new XMLMapImpl();
      syblMap.setNoNamespacePackage( SyblPackage.eINSTANCE );
      
      Map<String, Object> options = new HashMap<String, Object>();
      options.put( XMLResource.OPTION_XML_MAP, baseToscaMap );
      options.put( XMLResource.OPTION_XML_MAP, elasticityToscaMap );
      
      options.put( XMLResource.OPTION_XML_MAP , syblMap );
      
      options.put( XMLResource.OPTION_ENCODING, "UTF-8" ); // TODO Stalo "UTF-8"  //$NON-NLS-1$
      try {
        this.resource.load( options );
        this.documentRoot = ( DocumentRoot )this.resource.getContents().get( 0 ); 
        
        this.serviceTemplate = (TServiceTemplateExtension) this.documentRoot.getDefinitions().getServiceTemplate().get( 0 );
        this.topologyTemplate = this.serviceTemplate.getTopologyTemplate();
        
      } catch( IOException ioEx ) {
        if( ioEx instanceof IOWrappedException ) {
          IOWrappedException ioWEx = ( IOWrappedException )ioEx;
          throw ioWEx;
        }
      }
    }
  }
  
  public static DocumentRoot loadModelFromFile (IFile file) throws IOWrappedException {
    DocumentRoot model = null;
    File fileResource = new File( file.getLocation().toOSString() );
    
    if( fileResource.length() != 0 ) {
      String filePath = fileResource.getAbsolutePath();
      URI uri = URI.createFileURI( filePath );
      ResourceSet resourceSet = new ResourceSetImpl();
      Resource resourceA = resourceSet.createResource( uri );
      XMLMapImpl baseToscaMap = new XMLMapImpl();
      baseToscaMap.setNoNamespacePackage( ToscaPackage.eINSTANCE );      
      XMLMapImpl elasticityToscaMap = new XMLMapImpl();
      elasticityToscaMap.setNoNamespacePackage( Tosca_Elasticity_ExtensionsPackage.eINSTANCE );
      
      XMLMapImpl syblMap = new XMLMapImpl();
      syblMap.setNoNamespacePackage( SyblPackage.eINSTANCE );
      
      Map<String, Object> options = new HashMap<String, Object>();
      options.put( XMLResource.OPTION_XML_MAP, baseToscaMap );
      options.put( XMLResource.OPTION_XML_MAP, elasticityToscaMap );
      
      options.put( XMLResource.OPTION_XML_MAP , syblMap );
      
      options.put( XMLResource.OPTION_ENCODING, "UTF-8" ); //TODO Stalo "UTF-8"  //$NON-NLS-1$
      try {
        resourceA.load( options );
        model = ( DocumentRoot )resourceA.getContents().get( 0 );        
//        this.serviceTemplate = this.documentRoot.getDefinitions().getServiceTemplate().get( 0 );
//        this.topologyTemplate = this.serviceTemplate.getTopologyTemplate();
      } catch( IOException ioEx ) {
        if( ioEx instanceof IOWrappedException ) {
          IOWrappedException ioWEx = ( IOWrappedException )ioEx;
          throw ioWEx;
        }
      }
    }
    return model;
  }

  @Override
  public boolean isLazy() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getName() {
    return this.fileResource.getName();
  }

  @Override
  public IFileStore getFileStore() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IPath getPath() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IResource getResource() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ICloudContainer getParent() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isLocal() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getApplicationName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationVersion() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getApplicationExecutable() {
    // TODO Auto-generated method stub
    return null;
  }
     
  public void setUpBasicStructure() {
    // Using the Factory create all other elements.
    // TODO Stalo - Nicholas

    // Create Document Root
    this.documentRoot = this.toscaFactory.createDocumentRoot();
   
    // Create Definitions Type
    
    this.definitionsType = this.toscaFactory.createDefinitionsType();
    
    // Create Service and Topology Templates
    this.serviceTemplate = this.elasticityFactory.createTServiceTemplateExtension();
    this.serviceTemplate.setId( "hello" ); //$NON-NLS-1$
   
    
    this.topologyTemplate = this.toscaFactory.createTTopologyTemplate();
    
    // Create the Boundary Definition for Elasticity
    this.boundaryDef = this.elasticityFactory.createTBoundaryDefinitionsExtension();
    
    //Add service version number
    //Create Service Artifact Properties
    ServicePropertiesType serviceProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createServicePropertiesType();
    serviceProperties.setVersion( "1.0" );
    
    // Set the Properties of the Boundary Definitions 
    // TODO Stalo replace PropertisType1 with PropertiesType
    PropertiesType1 properties = ToscaFactory.eINSTANCE.createPropertiesType1();   
    
    // Add the Service Properties to the FeatureMap of the Boundary Definition's Properties element
    FeatureMap.Entry e = FeatureMapUtil.createEntry(     Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ServiceProperties(),  serviceProperties );
    properties.getAny().add( e );      
    
    
    this.boundaryDef.setProperties( properties );
    
    // Associate Boundary Definition with the Service Topology
    // Associate Service and Topology templates
    this.serviceTemplate.setBoundaryDefinitions( this.boundaryDef ); 
    
    this.serviceTemplate.setTopologyTemplate( this.topologyTemplate );
    
    // Associate Service template with the Definition Type
    this.definitionsType.getServiceTemplate().add( this.serviceTemplate );
    
    // Finally- Add the Definition Type to the Document Root
    this.definitionsType.setId( "hi" ); //$NON-NLS-1$
    
    //this.definitionsType.setTargetNamespace( "http://docs.oasis-open.org/tosca/ns/2011/12" );    //$NON-NLS-1$    
    
    this.documentRoot.setDefinitions( this.definitionsType );
           
    EMap<String, String> map = this.documentRoot.getXMLNSPrefixMap();
    map.put( "sybl", "http://www.example.org/SYBL" );

    
  }
  
   public TServiceTemplate getServiceTemplate(){
     TServiceTemplate tempServiceTemplate = this.serviceTemplate;
     return tempServiceTemplate;
   }
   
   public DocumentRoot getDocumentRoot() {
     return this.documentRoot;
   }
   
   protected void writeModelToFile( final EObject toscaRoot ) {
     // Here you have to get the File's path...
     // This is where i couldn't do it , but with the
     // wizard this is easy to do.
     String filePath = this.fileResource.getAbsolutePath().toString();
     org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createFileURI( filePath );
     // Create resource set.
     ResourceSet resourceSet = new ResourceSetImpl();
     Registry factoryRegistry = resourceSet.getResourceFactoryRegistry();
     Map<String, Object> map = factoryRegistry.getExtensionToFactoryMap();
     map.put( "tosca", //$NON-NLS-1$
              new ToscaResourceFactoryImpl() );    
     this.resource = resourceSet.createResource( fileURI );
     if( toscaRoot != null ) {
       this.resource.getContents().add( toscaRoot );
     }

     // Setting XML encoding.. This could be changed later.
     Map<String, String> options = new HashMap<String, String>();
     options.put( XMLResource.OPTION_ENCODING, "UTF-8" );  //$NON-NLS-1$
     try {
       this.resource.save( options );
     } catch( IOException ioEx ) {
       ioEx.printStackTrace();
     }
   }
   
   
   public static void saveModelToFile( final IFile file, final DocumentRoot toscaRoot ) {
     File fileResource = new File( file.getLocation().toOSString() );
     String filePath = fileResource.getAbsolutePath().toString();
     URI uri = URI.createFileURI( filePath );
     // Create resource set.
     ResourceSet resourceSet = new ResourceSetImpl();
     Registry factoryRegistry = resourceSet.getResourceFactoryRegistry();
     Map<String, Object> map = factoryRegistry.getExtensionToFactoryMap();
     map.put( "tosca", //$NON-NLS-1$
              new ToscaResourceFactoryImpl() );
     Resource resource = resourceSet.createResource( uri );
     if( toscaRoot != null ) {
       resource.getContents().add( toscaRoot );
     }
     // Setting XML encoding.. This could be changed later.
     Map<String, String> options = new HashMap<String, String>();
     options.put( XMLResource.OPTION_ENCODING, "UTF-8" );  //$NON-NLS-1$
     try {
       resource.save( options );
     } catch( IOException ioEx ) {
       ioEx.printStackTrace();
     }
   }
   
   
   public Resource getToscaResource(){
     return this.resource;
   }
   
   
}
