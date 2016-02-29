/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor.property;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.diagram.ToscaFeatureProvider;
import org.eclipse.camf.tosca.editor.features.CreateMonitorProbeFeature;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;


public class MonitoringProbe {
  
  String probeName;
  
  public MonitoringProbe( String probeName ){
    this.probeName = probeName;
  }
  
  public void createProbeProject()
      throws JavaModelException, PartInitException, IOException
    {

      // Create java project
      IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
      IProject project = workspaceRoot.getProject( "MonitoringProbe" );
      IJavaProject monitoringProbeProject;
      
      try {
        if (project.exists() && project.hasNature(JavaCore.NATURE_ID)){
          
          monitoringProbeProject = JavaCore.create( project );
          
          IPackageFragmentRoot root = monitoringProbeProject.getPackageFragmentRoot( project.getFolder( "src" ) );       
          
          createProbeClass(root);
          return;
        }
      } catch( CoreException e ) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      try {
        project.create( null );
        project.open( null );
      } catch( CoreException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      IProjectDescription description;
      try {
        description = project.getDescription();
        description.setNatureIds( new String[]{
          JavaCore.NATURE_ID
        } );
        project.setDescription( description, null );
      } catch( CoreException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      IJavaProject javaProject = JavaCore.create( project );
      IFolder binFolder = project.getFolder( "bin" );
      try {
        binFolder.create( false, true, null );
        javaProject.setOutputLocation( binFolder.getFullPath(), null );
      } catch( CoreException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
      IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
      LibraryLocation[] locations = JavaRuntime.getLibraryLocations( vmInstall );
      for( LibraryLocation element : locations ) {
        entries.add( JavaCore.newLibraryEntry( element.getSystemLibraryPath(),
                                               null,
                                               null ) );
      }
      // Add probes.jar
      IPath probeJarPath = new Path( "C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar" );
      LibraryLocation probeJarLocation = new LibraryLocation( probeJarPath,
                                                              Path.EMPTY,
                                                              Path.EMPTY );
      entries.add( JavaCore.newLibraryEntry( probeJarLocation.getSystemLibraryPath(),
                                             null,
                                             null ) );
      // add libs to project class path
      try {
        javaProject.setRawClasspath( entries.toArray( new IClasspathEntry[ entries.size() ] ),
                                     null );
      } catch( JavaModelException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      IFolder sourceFolder = project.getFolder( "src" );
      try {
        sourceFolder.create( false, true, null );
      } catch( CoreException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      
      IPackageFragmentRoot root = javaProject.getPackageFragmentRoot( sourceFolder );
      
      IClasspathEntry[] oldEntries = null;
      try {
        oldEntries = javaProject.getRawClasspath();
      } catch( JavaModelException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      IClasspathEntry[] newEntries = new IClasspathEntry[ oldEntries.length + 1 ];
      System.arraycopy( oldEntries, 0, newEntries, 0, oldEntries.length );
      newEntries[ oldEntries.length ] = JavaCore.newSourceEntry( root.getPath() );
      try {
        javaProject.setRawClasspath( newEntries, null );
      } catch( JavaModelException e3 ) {
        // TODO Auto-generated catch block
        e3.printStackTrace();
      }
      
      createProbeClass( root );
    }
  
  public void createProbeClass( IPackageFragmentRoot root ){
    
    String className = this.probeName + ".java";
    ICompilationUnit icu = null;
    
    // Check if probe name is already used    
    ICompilationUnit[] compilationUnits = null;
    try {
      compilationUnits = root.getPackageFragment( "" ).getCompilationUnits();
    } catch( JavaModelException e4 ) {
      // TODO Auto-generated catch block
      e4.printStackTrace();
    }
    
    boolean exists = false;
    for ( ICompilationUnit cu : compilationUnits ){
      if ( cu.getElementName().equals( className )){
        icu = root.getPackageFragment( "" ).getCompilationUnit( className );
        exists = true;
        break;
      }
       
    }
    
    if ( exists ){
      IFile probeFile = ( IFile )icu.getResource();

      IWorkbenchPage page = PlatformUI.getWorkbench()
          .getActiveWorkbenchWindow()
          .getActivePage();
        IEditorDescriptor desc = PlatformUI.getWorkbench()
          .getEditorRegistry()
          .getDefaultEditor( probeFile.getName() );
        try {
          page.openEditor( new FileEditorInput( probeFile ), desc.getId() );
        } catch( PartInitException e1 ) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      return;
    }
    
    //addProbeToMonitoringTable(probeName);
    
    //addProbeToCloudProject(probeName);
    
    String source = "public class " + this.probeName + " extends Probe{} ";
    StringBuffer buffer = new StringBuffer();
    buffer.append( source );
    
    try {
      icu = root.getPackageFragment( "" )
        .createCompilationUnit( className, buffer.toString(), false, null );
    } catch( JavaModelException e3 ) {
      // TODO Auto-generated catch block
      e3.printStackTrace();
    }
    try {
      icu.createImport( "java.util.HashMap", null, null );
      icu.createImport( "eu.celarcloud.jcatascopia.probepack.Probe", null, null );
      icu.createImport( "eu.celarcloud.jcatascopia.probepack.ProbeMetric",
                        null,
                        null );
      icu.createImport( "eu.celarcloud.jcatascopia.probepack.ProbePropertyType",
                        null,
                        null );
      
      IType probeType = icu.getAllTypes()[ 0 ];
      probeType.createField( "private static int DEFAULT_SAMPLING_PERIOD = 20;",
                             null,
                             false,
                             null );
      probeType.createField( "private static String DEFAULT_PROBE_NAME = "
                             + "\""
                             + this.probeName
                             + "\""
                             + ";", null, false, null );
      String constructorComments = "\n"
                                   + "/* define metrics that will be collected as ProbeProperties."
                                   + "\n"
                                   + " * addProbeProperty (int id, String name, ProbePropertyType type,String units, String description)"
                                   + "\n"
                                   + " * e.g. addProbeProperty(0,\"cpuUsage\",ProbePropertyType.DOUBLE,\"%\",\"Current system cpu usage\");"
                                   + "\n"
                                   + "*/";
      
      probeType.createMethod( "public " + this.probeName + "(String name, int freq) {super(name, freq);"
                                                        + constructorComments
                                                        + "\n"
                                                        + "}",
                                                    null,
                                                    false,
                                                    null );
      probeType.createMethod( "public " + this.probeName + "() {this(DEFAULT_PROBE_NAME, DEFAULT_SAMPLING_PERIOD);}",
                                                           null,
                                                           false,
                                                           null );
      probeType.createMethod( "@Override public ProbeMetric collect() { HashMap<Integer,Object> values = new HashMap<Integer,Object>();"
                                                    + "/* add to HashMap the values for each defined metric e.g. values.put(0,71.32) */"
                                                    + "return new ProbeMetric(values);}",
                                                null,
                                                false,
                                                null );
      probeType.createMethod( "@Override public String getDescription() {return \"Probe description\";}",
                                                       null,
                                                       false,
                                                       null );
      probeType.createMethod( "public static void main(String[] args) { " + this.probeName + " p = new " + this.probeName + "(); p.activate();}",
                                             null,
                                             false,
                                             null );
    } catch( JavaModelException e2 ) {
      // TODO Auto-generated catch block
      e2.printStackTrace();
    }
    
    try {
      formatCode( icu );
    } catch( PartInitException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch( JavaModelException e ) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    IFile probeFile = ( IFile )icu.getResource();

    IWorkbenchPage page = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getActivePage();
      IEditorDescriptor desc = PlatformUI.getWorkbench()
        .getEditorRegistry()
        .getDefaultEditor( probeFile.getName() );
      try {
        page.openEditor( new FileEditorInput( probeFile ), desc.getId() );
      } catch( PartInitException e1 ) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    
  }
  
  void formatCode( ICompilationUnit unit )
    throws JavaModelException, PartInitException
  {
    // Create working copy of the ICompilationUnit
    unit.becomeWorkingCopy( null );
    // Format
    // take default Eclipse formatting options
    Map<String, String> options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
    // initialize the compiler settings to be able to format 1.5 code
    options.put( JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_6 );
    options.put( JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM,
                 JavaCore.VERSION_1_6 );
    options.put( JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_6 );
    CodeFormatter formatter = ToolFactory.createCodeFormatter( options );
    ISourceRange range = unit.getSourceRange();
    TextEdit formatEdit = formatter.format( CodeFormatter.K_COMPILATION_UNIT,
                                            unit.getSource(),
                                            range.getOffset(),
                                            range.getLength(),
                                            0,
                                            null );
    if( formatEdit != null && formatEdit.hasChildren() ) {
      unit.applyTextEdit( formatEdit, null );
    } else {
      // monitor.done();
    }
    unit.commitWorkingCopy( true, null );
    // JavaUI.openInEditor(unit);
  }
//  
//  public void addProbeToCloudProject( String probeName, IProject cloudProject ){
//    
//    // Add a file for the newly created probe to Monitoring folder
//    
//    IProject project = cloudProject;
//    
//    String targetPath =  Platform.getLocation() + "/" + project.getName() + "/Monitoring/" +  probeName; 
//    File tmp = new File( targetPath );
//    try {
//      tmp.createNewFile();
//    } catch( IOException e1 ) {
//      // TODO Auto-generated catch block
//      e1.printStackTrace();
//    }
//
//    IProgressMonitor monitor = null;
//    try {
//      CloudModel.getRoot().refresh( monitor );
//    } catch( ProblemException e2 ) {
//      e2.printStackTrace();
//    }
//  }
  
  public void addProbeToMonitoringTable( String probeName, ContainerShape pictogramElement, IDiagramTypeProvider diagramTypeProvider ){
    
    CreateMonitorProbeFeature createMonitoringProbeFeature = new CreateMonitorProbeFeature( new ToscaFeatureProvider(diagramTypeProvider) );
    
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( probeName );
    deploymentArtifact.setArtifactType( new QName( "MonitoringProbe" ) ); //$NON-NLS-1$
    
    createMonitoringProbeFeature.setContextObject( deploymentArtifact );
    
    CreateContext createContext = new CreateContext();
    createContext.setTargetContainer( pictogramElement );
    
    if ( createMonitoringProbeFeature.canCreate( createContext ))
      createMonitoringProbeFeature.create( createContext );
  }
}
