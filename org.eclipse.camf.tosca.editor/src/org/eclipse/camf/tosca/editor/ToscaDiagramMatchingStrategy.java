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

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.ui.editor.DiagramEditorMatchingStrategy;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaDiagramMatchingStrategy implements IEditorMatchingStrategy {

  /* (non-Javadoc)
   * @see org.eclipse.ui.IEditorMatchingStrategy#matches(org.eclipse.ui.IEditorReference, org.eclipse.ui.IEditorInput)
   */
  @Override
  public boolean matches( final IEditorReference editorRef, final IEditorInput input ) {
    try {
      final IFile newDataFile = ToscaFileService.getDataFileForInput(input);
      final IFile openEditorDataFile = ToscaFileService.getDataFileForInput(editorRef.getEditorInput());

      if (null != newDataFile && newDataFile.equals(openEditorDataFile)) {
        return true;
      }
    } catch (PartInitException exception) {
      exception.printStackTrace();
    }

    return new DiagramEditorMatchingStrategy().matches(editorRef, input);
  }
}
