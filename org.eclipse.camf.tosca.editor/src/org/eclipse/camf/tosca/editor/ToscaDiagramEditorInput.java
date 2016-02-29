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
import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaDiagramEditorInput extends DiagramEditorInput {
  
  private IFile diagramFile = null;
  private IFile toscaFile = null;

  public ToscaDiagramEditorInput( final URI diagramUri, final String providerId ) {
    super( diagramUri, providerId );
  }

  public IFile getDiagramFile() {
    return this.diagramFile;
  }

  public void setDiagramFile( final IFile diagramFile ) {
    this.diagramFile = diagramFile;
  }

  public IFile getToscaFile() {
    return this.toscaFile;
  }

  public void setToscaFile( final IFile toscaFile ) {
    this.toscaFile = toscaFile;
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean result = false;

    if (obj == null) {
      return result;
    }

    if (obj instanceof ToscaDiagramEditorInput) {
      final ToscaDiagramEditorInput otherInput = (ToscaDiagramEditorInput) obj;

      if (this.diagramFile.equals(otherInput.diagramFile)) {
        result = true;
      }
    }

    return result;
  }
  
}
