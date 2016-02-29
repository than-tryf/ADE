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
package org.eclipse.camf.tosca.editor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import org.eclipse.camf.tosca.internal.ToscaUI;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaFileService {
  
  public static IFile getTemporaryDiagramFile(IPath dataFilePath, IFolder diagramFileTempFolder) {

    final IPath path = dataFilePath.removeFileExtension().addFileExtension(ToscaUI.TOSCA_DIAGRAM_FILE_EXTENSION);
    final IFile tempFile = diagramFileTempFolder.getFile(path.lastSegment());

    // We don't need anything from that file and to be sure there are no side
    // effects we delete the file
    if (tempFile.exists()) {
      try {
        tempFile.delete(true, null);
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
    return tempFile;
  }
  
  /**
   * Returns or constructs a temporary folder for diagram files used as Graphiti editor input
   * files. The given path reflects the path where the original data file is located. The folder
   * is constructed in the project root named after the data file extension
   * {@link #DATA_FILE_EXTENSION_RAW}.
   *
   * @param dataFilePath path of the actual BPMN2 model file
   * @return an IFolder for the temporary folder.
   * @throws CoreException in case the folder could not be created.
   */
  public static IFolder getOrCreateTempFolder(final IPath dataFilePath) throws CoreException {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

    String name = dataFilePath.getFileExtension();
    if (name == null || name.length() == 0) {
      name = "tosca"; //$NON-NLS-1$
    }

    String dir = dataFilePath.segment(0);
    IFolder folder = root.getProject(dir).getFolder("." + name); //$NON-NLS-1$
    if (!folder.exists()) {
      folder.create(true, true, null);
    }
    String[] segments = dataFilePath.segments();
    for (int i = 1; i < segments.length - 1; i++) {
      String segment = segments[i];
      folder = folder.getFolder(segment);
      if (!folder.exists()) {
        folder.create(true, true, null);
      }
    }
    return folder;
  }
  
  /**
   * Recreates the data file from the given input path. In case the given path reflects a temporary
   * diagram file, it's path is used to recreate the data file, otherwise the given path is simply
   * made absolute and returned.
   *
   * @param inputPath the path to recreate the data file from
   * @return a file object representing the data file
   */
  public static IFile recreateDataFile(final IPath inputPath) {
    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    final IProject project = root.getFile(inputPath).getProject();

    final int matchingSegments = project.getFullPath().matchingFirstSegments(inputPath);
    final int totalSegments = inputPath.segmentCount();
    final String extension = inputPath.getFileExtension();

    IFile result = null;

    if (totalSegments > matchingSegments) {
      // it shall be more than just the project

      IPath resultPath = null;

      if (ToscaUI.TOSCA_DIAGRAM_FILE_EXTENSION.equals(extension)) {
        // we got a temporary file here, so rebuild the file of the model from its path
        String originalExtension = inputPath.segment(matchingSegments);
        if (originalExtension.startsWith(".")) { //$NON-NLS-1$
          originalExtension = originalExtension.substring(1);
        }

        final String[] segments = inputPath.segments();
        IPath originalPath = project.getFullPath();
        for (int index = matchingSegments + 1; index < segments.length; ++index) {
          originalPath = originalPath.append(segments[index]);
        }

        resultPath = originalPath.removeFileExtension().addFileExtension(originalExtension);
      }
      else {
        resultPath = inputPath.makeAbsolute();
      }

      result = root.getFile(resultPath);
    }

    return result;
  }
  
  public static IFile getDataFileForInput(final IEditorInput input) {
    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

    if (input instanceof ToscaDiagramEditorInput) {
      final ToscaDiagramEditorInput tdei = (ToscaDiagramEditorInput) input;

      return tdei.getToscaFile();
    } else if (input instanceof DiagramEditorInput) {
      final DiagramEditorInput dei = (DiagramEditorInput) input;

      IPath path = new Path(dei.getUri().trimFragment().toPlatformString(true));

      return recreateDataFile(path);
    } else if (input instanceof FileEditorInput) {
      final FileEditorInput fei = (FileEditorInput) input;

      return fei.getFile();
    } else if (input instanceof IURIEditorInput) {
      // opened externally to Eclipse
      final IURIEditorInput uei = (IURIEditorInput) input;
      final java.net.URI uri = uei.getURI();
      final String path = uri.getPath();

      try {
        final IProject importProject = root.getProject("import"); //$NON-NLS-1$
        if (!importProject.exists()) {
          importProject.create(null);
        }

        importProject.open(null);

        final InputStream is = new FileInputStream(path);

        final String fileName;
        if (path.contains("/")) { //$NON-NLS-1$
          fileName = path.substring(path.lastIndexOf("/") + 1); //$NON-NLS-1$
        } else {
          fileName = path.substring(path.lastIndexOf("\\") + 1); //$NON-NLS-1$
        }

        IFile importFile = importProject.getFile(fileName);
        if (importFile.exists()) {
          importFile.delete(true, null);
        }

        importFile.create(is, true, null);

        return importProject.getFile(fileName);
      } catch (CoreException exception) {
        exception.printStackTrace();
      } catch (FileNotFoundException exception) {
        exception.printStackTrace();
      }
    }

    return null;
  }
  
  /**
   * @param diagramResourceUri
   * @param diagram
   * @param diagramEditor
   * @param contentStream
   * @param resourceFile
   * @return
   */
  public static TransactionalEditingDomain createEmfFileForDiagram(final URI diagramResourceUri
                                                                   , final Diagram diagram
                                                                   , final ToscaDiagramEditor diagramEditor
                                                                   , final InputStream contentStream
                                                                   , final IFile resourceFile) {

        TransactionalEditingDomain editingDomain = null;
        ResourceSet resourceSet = null;
       

        if (diagramEditor == null /*|| diagramEditor.getEditingDomain().getResourceSet() == null*/ || diagramEditor.getEditDomain() == null) {
          // nothing found, create a new one
          resourceSet = new ResourceSetImpl();

          // try to retrieve an editing domain for this resource set
          editingDomain = TransactionUtil.getEditingDomain(resourceSet);

          if (editingDomain == null) {
            // not existing yet, create a new one
            editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
          }
        } else {
          editingDomain = diagramEditor.getEditingDomain();
          resourceSet = diagramEditor.getEditingDomain().getResourceSet();
        }

        // Create a resource for this file.
        final Resource resource = resourceSet.createResource(diagramResourceUri);
        final CommandStack commandStack = editingDomain.getCommandStack();
        commandStack.execute(new RecordingCommand(editingDomain) {

            @Override
            protected void doExecute() {
                resource.setTrackingModification(true);

                if (contentStream == null || resourceFile == null) {
                  resource.getContents().add(diagram);
                } else {
                  try {
                    resourceFile.create(contentStream, true, null);
                  } catch (CoreException exception) {
                    exception.printStackTrace();
                  }
                }

            }
        });

        save(editingDomain, Collections.<Resource, Map<?, ?>> emptyMap());
        return editingDomain;
    }
  
  private static void save(TransactionalEditingDomain editingDomain, Map<Resource, Map<?, ?>> options) {
    saveInWorkspaceRunnable(editingDomain, options);
}
  
  private static void saveInWorkspaceRunnable( final TransactionalEditingDomain editingDomain,
                                               final Map<Resource, Map<?, ?>> options )
  {
    final Map<URI, Throwable> failedSaves = new HashMap<URI, Throwable>();
    final IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {

      @Override
      public void run( final IProgressMonitor monitor ) throws CoreException {
        final Runnable runnable = new Runnable() {

          @Override
          public void run() {
            Transaction parentTx;
            if( editingDomain != null
                && ( parentTx = ( ( TransactionalEditingDomainImpl )editingDomain ).getActiveTransaction() ) != null )
            {
              do {
                if( !parentTx.isReadOnly() ) {
                  throw new IllegalStateException( "ToscaFileService.save() called from within a command (likely produces a deadlock)" ); //$NON-NLS-1$
                }
              } while( ( parentTx = ( ( TransactionalEditingDomainImpl )editingDomain ).getActiveTransaction()
                .getParent() ) != null );
            }
            final EList<Resource> resources = editingDomain.getResourceSet()
              .getResources();
            // Copy list to an array to prevent
            // ConcurrentModificationExceptions
            // during the saving of the dirty resources
            Resource[] resourcesArray = new Resource[ resources.size() ];
            resourcesArray = resources.toArray( resourcesArray );
            final Set<Resource> savedResources = new HashSet<Resource>();
            for( final Resource resource : resourcesArray ) {
              if( resource.isModified() ) {
                try {
                  resource.save( options.get( resource ) );
                  savedResources.add( resource );
                } catch( final Throwable t ) {
                  failedSaves.put( resource.getURI(), t );
                }
              }
            }
          }
        };
        try {
          editingDomain.runExclusive( runnable );
        } catch( final InterruptedException e ) {
          throw new RuntimeException( e );
        }
        editingDomain.getCommandStack().flush();
      }
    };
    try {
      ResourcesPlugin.getWorkspace().run( wsRunnable, null );
      if( !failedSaves.isEmpty() ) {
        throw new WrappedException( createMessage( failedSaves ),
                                    new RuntimeException() );
      }
    } catch( final CoreException e ) {
      final Throwable cause = e.getStatus().getException();
      if( cause instanceof RuntimeException ) {
        throw ( RuntimeException )cause;
      }
      throw new RuntimeException( e );
    }
  }
  
  private static String createMessage(Map<URI, Throwable> failedSaves) {
    final StringBuilder buf = new StringBuilder("The following resources could not be saved:"); //$NON-NLS-1$
    for (final Entry<URI, Throwable> entry : failedSaves.entrySet()) {
        buf.append("\nURI: ").append(entry.getKey().toString()).append(", cause: \n") //$NON-NLS-1$ //$NON-NLS-2$
                .append(getExceptionAsString(entry.getValue()));
    }
    return buf.toString();
}

private static String getExceptionAsString(Throwable t) {
    final StringWriter stringWriter = new StringWriter();
    final PrintWriter printWriter = new PrintWriter(stringWriter);
    t.printStackTrace(printWriter);
    final String result = stringWriter.toString();
    try {
        stringWriter.close();
    } catch (final IOException e) {
        // $JL-EXC$ ignore
    }
    printWriter.close();
    return result;
}

}
