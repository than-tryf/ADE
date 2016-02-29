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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import org.eclipse.camf.tosca.internal.ToscaUI;

/**
 * @author Nicholas Loulloudes
 */
public class ToscaDiagramCreator {

  /**
   * @param dataFile
   * @param diagramFile
   * @param diagramEditor
   * @param openEditor
   * @return The Tosca diagram editor input
   */
  public ToscaDiagramEditorInput createToscaDiagram( final IFile dataFile,
                                                     final IFile diagramFile,
                                                     final ToscaDiagramEditor diagramEditor,                                                     
                                                     final boolean openEditor )
  {
    IFile finalToscaFile = dataFile;
    final IPath diagramPath = diagramFile.getFullPath();
    final String diagramName = diagramPath.removeFileExtension().lastSegment();
    final URI uri = URI.createPlatformResourceURI( diagramPath.toString(), true );
    
    final Diagram diagram = Graphiti.getPeCreateService().createDiagram( "ToscaDiagram", diagramName, true ); //$NON-NLS-1$
    
    ToscaFileService.createEmfFileForDiagram( uri,
                                              diagram,
                                              diagramEditor,
                                              null,
                                              null );
    
    final String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId( diagram.getDiagramTypeId() );
    
    final ToscaDiagramEditorInput result = new ToscaDiagramEditorInput( EcoreUtil.getURI( diagram ),providerId );
    
    result.setToscaFile( finalToscaFile );
    result.setDiagramFile( diagramFile );
    if( openEditor ) {
      openEditor( result );
    }
    return result;
  }
  
  public void openEditor(final ToscaDiagramEditorInput editorInput) {
    final IWorkbench workbench = PlatformUI.getWorkbench();

    workbench.getDisplay().syncExec(new Runnable() {

      @Override
      public void run() {
        try {
          IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), editorInput, ToscaUI.DIAGRAM_EDITOR_ID);

        } catch (PartInitException exception) {
          exception.printStackTrace();
        }
      }
    });
  }
  
  /**
   * Delete the temporary diagram file. If the containing folder hierarchy is
   * empty, it will also be deleted.
   * 
   * @param file
   *          - the temporary diagram file.
   */
  public static void dispose(final IFile file) {
    try {
      IContainer container = file.getParent();
      file.delete(true, null);
      while (isEmptyFolder(container)) {
        container.delete(true, null);
        container = container.getParent();
      }
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  /**
   * Check if the given folder is empty. This is true if it contains no files,
   * or only empty folders.
   * 
   * @param container
   *          - folder to check
   * @return true if the folder is empty.
   */
  public static boolean isEmptyFolder(final IContainer container) {
    try {
      IResource[] members = container.members();
      for (IResource res : members) {
        int type = res.getType();
        if (type == IResource.FILE || type == IResource.PROJECT || type == IResource.ROOT) {
          return false;
        }
        if (!isEmptyFolder((IContainer) res)) {
          return false;
        }
      }
    } catch (CoreException e) {
      return false;
    }
    return true;
  }
}
