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
package org.eclipse.camf.tosca.editor.features;

import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class RenameApplicationComponentFeature extends AbstractCustomFeature {

  private boolean hasDoneChanges = false;

  public RenameApplicationComponentFeature( final IFeatureProvider fp ) {
    super( fp );
  }

  @Override
  public String getName() {
    return "Re&name Application Component"; //$NON-NLS-1$
  }

  @Override
  public String getDescription() {
    return "Change the name of the Application Component"; //$NON-NLS-1$
  }

  @Override
  public boolean canExecute( final ICustomContext context ) {
    // allow rename if exactly one pictogram element
    // representing an EClass is selected
    boolean ret = false;
    PictogramElement[] pes = context.getPictogramElements();
    if( pes != null && pes.length == 1 ) {
      Object bo = getBusinessObjectForPictogramElement( pes[ 0 ] );
      if( bo instanceof TNodeTemplate ) {
        ret = true;
      }
    }
    return ret;
  }

  // Open rename Application Component Name Dialog
  @Override
  public void execute( final ICustomContext context ) {
    PictogramElement[] pes = context.getPictogramElements();
    if( pes != null && pes.length == 1 ) {
      Object bo = getBusinessObjectForPictogramElement( pes[ 0 ] );
      TNodeTemplate tNode = ( TNodeTemplate )bo;
      String currentName = tNode.getName();
      // ask user for a new application component name
      String newName = null;
      Shell shell = PlatformUI.getWorkbench()
        .getActiveWorkbenchWindow()
        .getShell();
      InputDialog inputDialog = new InputDialog( shell,
                                                 "Rename Application Component",
                                                 getDescription(),
                                                 currentName,
                                                 null );
      int newNameDialog = inputDialog.open();
      if( newNameDialog == Window.OK ) {
        newName = inputDialog.getValue();
      }
      if( newName != null && !newName.equals( currentName ) ) {
        this.hasDoneChanges = true;
        tNode.setName( newName );
        updatePictogramElement( pes[ 0 ] );
      }
    }
  }

  @Override
  public boolean hasDoneChanges() {
    return this.hasDoneChanges;
  }
}
