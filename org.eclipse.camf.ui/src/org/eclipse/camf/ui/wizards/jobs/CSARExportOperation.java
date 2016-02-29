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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.wizards.jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;


/**
 * @author nickl
 *
 */
public class CSARExportOperation implements IRunnableWithProgress {
  
  private String outputFile;
  private List selection;
  private IStatus status;
  private IFile appDescrFile = null;
  
  public CSARExportOperation(final List selection, final String outputFileName) {
    this.selection = selection;
    this.appDescrFile = findToscaFile( this.selection );
    this.outputFile = outputFileName;
  }

  private IFile findToscaFile( final List selection ) {
    IFile toscaFile = null;
    Iterator iter = selection.iterator();
    while( iter.hasNext() ) {
      Object obj = iter.next();
      if( obj instanceof IFile ) {
        IFile file = ( IFile )obj;
        if( file.getFileExtension().equals( "tosca" ) ) {
          toscaFile = file;
        }
      }
    }
    return toscaFile;
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public void run( final IProgressMonitor monitor )
    throws InvocationTargetException, InterruptedException
  {
   
    try {
      
      String csar = this.outputFile;
      ArrayList<String> zipEntries = new ArrayList<String>();
      
      IResource resourceName = null;
      IFile exportDescr = null;
//      = toscaResource.getResource();      
//      deploymentFile = (IFile) resourceName;
      
      
      ICloudElement findElement = CloudModel.getRoot().findElement( this.appDescrFile.getFullPath() );
      if (findElement instanceof TOSCAResource ){
        TOSCAResource tosca = (TOSCAResource) findElement;
        resourceName = tosca.getResource();
        exportDescr = (IFile) resourceName;
      }
      
      
      FileOutputStream fos = new FileOutputStream( csar );
      ZipOutputStream zos = new ZipOutputStream( fos );
      // File names
      String metaFile = "TOSCA.meta"; //$NON-NLS-1$
      String defFileName = "Application.tosca"; //$NON-NLS-1$
      String keyFileName = "celar.pub"; //$NON-NLS-1$
      // Create dummy TOSCA meta
      addToCSARFile( "TOSCA-Metadata", metaFile, getMetaContent( defFileName ), zos ); //$NON-NLS-1$
      // Create Valid TOSCA
//    DocumentRoot toscaDescription = toscaModel.getDocumentRoot();
//    addToCSARFile( "Definitions", defFileName, convertToXml( toscaDescription ), zos ); //$NON-NLS-1$
      addToCSARFile( "Definitions",
                     defFileName,
                     getFileContents( exportDescr ),
                     zos );    
      
      // Create a dummy SSH public key-pair file
//    addToCSARFile( "Keys", keyFileName, getKeyPair(), zos ); //$NON-NLS-1$   
      
//      IProject activeProject = ToscaDiagramEditor.getActiveProject();
      IProject project = this.appDescrFile.getProject();
      IFolder scriptsFolder = project.getFolder( new Path(File.separator + "Artifacts" + File.separator +"Deployment Scripts" )); //$NON-NLS-1$ //$NON-NLS-2$
      IResource[] scriptFiles = scriptsFolder.members();
      for (IResource resource : scriptFiles){
        IFile tempFile = (IFile) resource;
        String fileName = tempFile.getName();
        if (zipEntries.contains( fileName )){
          System.out.println("zip entry exists");
        }
        else{
          zipEntries.add( fileName );
          String content = getFileContents( tempFile );
          addToCSARFile("Scripts", fileName, content, zos ); //$NON-NLS-1$
        }
      }   
      
      IFolder resizingScriptsFolder = project.getFolder( new Path(File.separator + "Artifacts" + File.separator +"Reconfiguration Scripts" )); //$NON-NLS-1$ //$NON-NLS-2$
      scriptFiles = resizingScriptsFolder.members();
      for (IResource resource : scriptFiles){
        IFile tempFile = (IFile) resource;
        String fileName = tempFile.getName();
        if (zipEntries.contains( fileName )){
          System.out.println("zip entry exists");
        }
        else{
          String content = getFileContents( tempFile );
          addToCSARFile("Scripts", fileName, content, zos ); //$NON-NLS-1$
        }
        
      }   
      
      
      zos.close();
      fos.close();
    } catch( Exception e ) {
      e.printStackTrace();      
    }
  }

  private static String getFileContents( final IFile file ) {
    InputStream in = null;
    try {
      in = file.getContents();
    } catch( CoreException e ) {
      e.printStackTrace();
    }
    InputStreamReader is = new InputStreamReader( in );
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader( is );
    String read;
    try {
      read = br.readLine();
      while( read != null ) {
        sb.append( read );
        sb.append( System.getProperty( "line.separator" ) );
        read = br.readLine();
      }
    } catch( IOException e ) {
      e.printStackTrace();
    }
    return sb.toString();
  }

  private void addToCSARFile( final String dir,
                             final String fileName,
                             final String content,
                             final ZipOutputStream zos )
    throws FileNotFoundException, IOException
  {
    String tmpDir = System.getProperty( "java.io.tmpdir" ) + File.separator; //$NON-NLS-1$
    File file = new File( tmpDir + fileName );
    if( !file.exists() ) {
      file.createNewFile();
    }
    FileOutputStream fos = new FileOutputStream( file );
    byte[] contentInBytes = content.getBytes();
    fos.write( contentInBytes );
    fos.flush();
    fos.close();
    FileInputStream fis = new FileInputStream( file );
    ZipEntry zipEntry = new ZipEntry( dir + File.separator + fileName );
    zos.putNextEntry( zipEntry );
    byte[] bytes = new byte[ 1024 ];
    int length;
    while( ( length = fis.read( bytes ) ) >= 0 ) {
      zos.write( bytes, 0, length );
    }
    zos.closeEntry();
    fis.close();
  }

  /**
   * @param defFile
   * @return Meta Content
   */
  private static String getMetaContent( String defFile ) {
    StringBuilder sb = new StringBuilder();
    sb.append( "TOSCA-Meta-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "CSAR-Version: 1.0\n" ); //$NON-NLS-1$
    sb.append( "Created-By: c-Eclipse\n\n" ); //$NON-NLS-1$
    sb.append( "Name: Definitions" + File.separator + defFile + "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
    sb.append( "Content-Type: application/vnd.oasis.tosca.definitions\n" ); //$NON-NLS-1$
    return sb.toString();
  }
  
  public IStatus getStatus(){
    return this.status;
  }
}
