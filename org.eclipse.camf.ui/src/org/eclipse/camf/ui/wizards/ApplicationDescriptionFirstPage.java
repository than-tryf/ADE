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
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ApplicationDescriptionFirstPage extends WizardNewFileCreationPage {

  public ApplicationDescriptionFirstPage( final String pageName,
                                          final IStructuredSelection selection )
  {
    super( pageName, selection );
  }

  public void createControl( Composite parent ) {
    super.createControl( parent );
    setFileName( "myApplicationDescription" );
  }

  @Override
  protected boolean validatePage() {
    boolean result = true;
    if( !super.validatePage() ) {
      result = false;
    }
    if( result ) {
      setPageComplete( true );
      getContainer().updateButtons();
    }
    return result;
  }
}
