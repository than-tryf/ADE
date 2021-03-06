package org.eclipse.camf.tosca.editor.features;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.nio.file.*;
import java.nio.file.StandardCopyOption.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditorInput;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.FeatureMapEntry;
import org.eclipse.emf.ecore.change.impl.FeatureMapEntryImpl;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jdt.internal.corext.codemanipulation.tostringgeneration.ToStringTemplateParser;
import org.eclipse.ui.*;
import org.eclipse.ui.part.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;




public class CreateReadyToUseArtifactFeature extends AbstractCreateFeature {

	private Object contextObject = null;

	private static int DEFAULT_MIN_INSTANCES = -1;

	//-1 means not specified by user
	private static int DEFAULT_MAX_INSTANCES = -1;

	private String artName;

	public CreateReadyToUseArtifactFeature(IFeatureProvider fp) {
		super(fp, "Ready To Use Artifact", "Create a Ready to use artifact");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram)
			return false;
		Object parentBo = getFeatureProvider()
				.getBusinessObjectForPictogramElement(
						context.getTargetContainer());
		if (parentBo instanceof TServiceTemplate || parentBo instanceof EClass) {
			return true;
		}
		return false;
	}


	public void setContextObject (final Object obj) {
		this.contextObject = obj;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO Auto-generated method stub

		if (this.contextObject == null) {
			return null;
		}
		TNodeTemplateExtension newClass = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
		newClass.setMinInstances( DEFAULT_MIN_INSTANCES );
		newClass.setMaxInstances(  BigInteger.valueOf( DEFAULT_MAX_INSTANCES ) );
		newClass.setId( ( "RUA" + ( Integer )newClass.hashCode() ).toString() );
		newClass.setName(getArtName());



		//Set X and Y required for reloading tosca model in tosca editor
		newClass.setX(context.getX());
		newClass.setY(context.getY());

		ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );    
		model.getDocumentRoot()
		.getDefinitions()
		.getServiceTemplate()
		.get( 0 )
		.getTopologyTemplate()
		.getNodeTemplate()
		.add( newClass );

		Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
		TServiceTemplate serviceTemplate = null;
		if( parentObject == null )
			return null;
		if( parentObject instanceof TServiceTemplate ) {
			serviceTemplate = ( TServiceTemplate )parentObject;
		}
		TTopologyTemplate topology = null;
		if( serviceTemplate.getTopologyTemplate() == null ) {
			topology = ToscaFactory.eINSTANCE.createTTopologyTemplate();
			serviceTemplate.setTopologyTemplate( topology );
		} else {
			topology = serviceTemplate.getTopologyTemplate();
		}
		// Add object to domain model
		topology.getNodeTemplate().add( newClass );
		//System.out.println("[*]"+getClass().getSimpleName()+" PROPERTY: "+model.getModelFile().getFullPath().getDevice().toString());


		// Add object to diagram model
		//getDiagram().eResource().getContents().add(newClass);

		int n_nt = topology.getNodeTemplate().size();
		
		TNodeTemplate nt = topology.getNodeTemplate().get(n_nt-1);
		if( nt.getDeploymentArtifacts() == null ) {

			final TNodeTemplate node = nt;
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
			editingDomain.getCommandStack()
			.execute( new RecordingCommand( editingDomain ) {

				protected void doExecute() {
					node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
				}
			} );


		}
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot(); 
		IProject[] projects = root.getProjects(); 
		String project_name = projects[0].getLocation().toOSString();
		String destination_fodler = project_name+"/Artifacts/Applications";
		File desFolder = new File(destination_fodler);
		if(desFolder.exists()){
			System.out.println("[**] Destination folder exists: "+desFolder.getAbsolutePath().toString());
		}
		System.out.println("[*] Project Name: "+project_name);
		
		/*------------------LOOK INTO THE FOLDER OF THE ARTIFACT-----------------------*/
		final TDeploymentArtifacts dArts = nt.getDeploymentArtifacts();
		String aFolder = CloudSoftwareRepo.getARTIFACTS_FOLDER();
		String arF = getArtName();
		System.out.println("[*] The artifact:  "+getClass().getSimpleName()+" : "+ aFolder+"/"+arF);
		File locArtFolder = new File(aFolder+"/"+arF);
		if(locArtFolder.exists()){
			/*-----------CHECK IF THE FODLER INSTALL EXISTS-------*/
			String install_folder = aFolder+"/"+arF+"/install";
			File install = new File(install_folder);
			if(install.exists()){
				int nFilesInstall = install.listFiles().length;
				for(int i=0;i<nFilesInstall;i++){

					System.out.println("[* File path: ] "+install.listFiles()[i].getAbsolutePath().toString());	
					try {
						File copFile = new File(destination_fodler+"/"+install.list()[i]);
						File originFile = install.listFiles()[i];
						InputStream inStream = new FileInputStream(originFile);
						OutputStream outStream = new FileOutputStream(copFile);
						byte[] buffer = new byte[1024];
						int length;
						while((length=inStream.read(buffer))>0){
							outStream.write(buffer, 0, length);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					final TDeploymentArtifact dArt = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
					dArt.setArtifactType(new QName("RUA"));
					dArt.setName(install.list()[i]);
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nt );
					editingDomain.getCommandStack().execute(new RecordingCommand( editingDomain ) {

						protected void doExecute() {
							dArts.getDeploymentArtifact().add( dArt );
						}
					} );
					
					//Copy the files to the directory
					System.out.println("[*] "+getClass().getSimpleName()+" : folder "+install.getAbsolutePath()+" : "+install.list()[i]);

				}

			}
			
			/*---------------------------------------------------*/
			
			/*----------CHECK IF THE FOLDER CONFIG EXISTS---------*/
			String config_folder = aFolder+"/"+arF+"/config";
			File config = new File(config_folder);
			if(config.exists()){
				
				//Check if there is a file named confg.cfg
				File cfg = new File(config_folder+"/"+arF+".cfg");
				if(cfg.exists()){
					
					try {
						File copFile = new File(destination_fodler+"/"+arF+".cfg");
						File originFile = cfg;
						InputStream inStream = new FileInputStream(originFile);
						OutputStream outStream = new FileOutputStream(copFile);
						byte[] buffer = new byte[1024];
						int length;
						while((length=inStream.read(buffer))>0){
							outStream.write(buffer, 0, length);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					final TDeploymentArtifact dArt = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
					dArt.setArtifactType(new QName("RUA"));
					dArt.setName(arF+".cfg");
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nt );
					editingDomain.getCommandStack().execute(new RecordingCommand( editingDomain ) {

						protected void doExecute() {
							dArts.getDeploymentArtifact().add( dArt );
						}
					} );
					System.out.println("[*] "+getClass().getSimpleName()+" : folder "+config.getAbsolutePath()+" : "+arF+".cfg");
					//Copy the file to the directory
				}

			}
			
			/*---------------------------------------------------*/
			
			/*--------------CHECK IF THE FOLDER BIN EXISTS-------*/
			String bin_folder = aFolder+"/"+arF+"/bin";
			File bin = new File(bin_folder);
			if(bin.exists()){
				int nFilesBin = bin.listFiles().length;
				for(int i=0;i<nFilesBin;i++){
					
					try {
						File copFile = new File(destination_fodler+"/"+bin.list()[i]);
						File originFile = bin.listFiles()[i];
						InputStream inStream = new FileInputStream(originFile);
						OutputStream outStream = new FileOutputStream(copFile);
						byte[] buffer = new byte[1024];
						int length;
						while((length=inStream.read(buffer))>0){
							outStream.write(buffer, 0, length);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					final TDeploymentArtifact dArt = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
					dArt.setArtifactType(new QName("RUA"));
					dArt.setName(bin.list()[i]);
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nt );
					editingDomain.getCommandStack().execute(new RecordingCommand( editingDomain ) {

						protected void doExecute() {
							dArts.getDeploymentArtifact().add( dArt );
						}
					} );
					
					//Copy the files to the directory
					System.out.println("[*] "+getClass().getSimpleName()+" : folder "+bin.getAbsolutePath()+" : "+bin.list()[i]);

				}

			}
			
			/*---------------------------------------------------*/
			/*--------CHECK IF THE SOURCE FOLDER EXISTS----------*/
			String src_folder = aFolder+"/"+arF+"/src";
			File src = new File(src_folder);
			if(src.exists()){
				int nFilesSrc = src.listFiles().length;
				for(int i=0;i<nFilesSrc;i++){
					
					try {
						File copFile = new File(destination_fodler+"/"+src.list()[i]);
						File originFile = src.listFiles()[i];
						InputStream inStream = new FileInputStream(originFile);
						OutputStream outStream = new FileOutputStream(copFile);
						byte[] buffer = new byte[1024];
						int length;
						while((length=inStream.read(buffer))>0){
							outStream.write(buffer, 0, length);
						}
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					final TDeploymentArtifact dArt = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
					dArt.setArtifactType(new QName("RUA"));
					dArt.setName(src.list()[i]);
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nt );
					editingDomain.getCommandStack().execute(new RecordingCommand( editingDomain ) {

						protected void doExecute() {
							dArts.getDeploymentArtifact().add( dArt );
						}
					} );
					
					//Copy the files to the directory
					System.out.println("[*] "+getClass().getSimpleName()+" : folder "+src.getAbsolutePath()+" : "+src.list()[i]);

				}

			}
			
			/*-------------------------------------------------*/
			
			
			

		

		} else{
			System.out.println("[*] The artifact:  Does not exisst");
		}
		//File localArtFolder = new File(aFolder+)
		
		
		/*----------------------------------------------------------------------------*/
		/*
		// Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = nt.getDeploymentArtifacts();
	     // final PropertiesType pt = nt.getProperties();
	      //nt.setProperties(pt);
	      final TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( "ThanasisArtifact" );
	      deploymentArtifact.setArtifactType( new QName("RUA") );
	      //deploymentArtifact.s
	      
	      
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nt );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
	          }
	        } );*/


//	      PropertiesType prop = ToscaFactory.eINSTANCE.createPropertiesType();
	     // Entry e = FeatureMapUtil.createTextEntry("THanasis");
	      
	      //newClass.setProperties(prop);
	      
	      //System.out.println("[*]"+getClass().getSimpleName()+" : "+TOSCAModel.this.getApplicationName());
	 

		// do the add
		addGraphicalRepresentation( context, newClass );
		//addGraphicalRepresentation(context, deploymentArtifact);
		// activate direct editing after object creation
		getFeatureProvider().getDirectEditingInfo().setActive( true );


		
		
		// return newly created business object(s)
		return new Object[]{
				newClass,
				//deploymentArtifact
		};

	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

}
