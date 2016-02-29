/*****************************************************************************
 * Copyright (c) 2006, 2007 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.ui.views;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.ui.internal.actions.ActionGroupManager;
import org.eclipse.camf.ui.internal.actions.EditorActions;
import org.eclipse.camf.ui.internal.actions.ExportDescriptionActions;
import org.eclipse.camf.ui.internal.actions.NewWizardActions;
import org.eclipse.camf.ui.providers.CloudModelContentProvider;
import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * @author Nicholas Loulloudes
 *
 */
public class CloudProjectView extends TreeControlViewPart  {
  
  private EditorActions editorActions;
  
  private IPartListener2 partListener;
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#createPartControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createPartControl( final Composite parent ) {
    
    super.createPartControl( parent );
    
    this.partListener = new CloudProjectPartListener( this.editorActions );
    getSite().getPage().addPartListener( this.partListener );   
        
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#dispose()
   */
  @Override
  public void dispose() {
    getSite().getPage().removePartListener( this.partListener );
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#isDragSource(org.eclipse.camf.core.model.ICloudElement)
   */
  @Override
  public boolean isDragSource( final ICloudElement element ) {
    return super.isDragSource( element );
  }
  
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#contributeAdditionalActions(org.eclipse.camf.ui.internal.actions.ActionGroupManager)
   */
  @Override
  protected void contributeAdditionalActions( final ActionGroupManager groups ) {
    
    super.contributeAdditionalActions( groups );
    
    IWorkbenchPartSite site = getSite();
    IWorkbenchWindow window = site.getWorkbenchWindow();
    
    NewWizardActions newWizardActions = new NewWizardActions( window );
    groups.addGroup( newWizardActions );
    
    ProjectActions projectActions = new ProjectActions( site );
    groups.addGroup( projectActions );
    
    BuildActions buildActions = new BuildActions( site );
    groups.addGroup( buildActions );
    
    ExportDescriptionActions exportActions = new ExportDescriptionActions (site);
    groups.addGroup( exportActions );
        
    this.editorActions = new EditorActions( this );
    groups.addGroup( this.editorActions );
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#createContentProvider()
   */
  @Override
  protected IContentProvider createContentProvider() {
    IContentProvider contentProvider = new CloudModelContentProvider();
    return contentProvider;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#createLabelProvider()
   */
  @Override
  protected IBaseLabelProvider createLabelProvider() {
    CloudModelLabelProvider provider = new CloudModelLabelProvider();
    ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    DecoratingStyledCellLabelProvider result = new DecoratingStyledCellLabelProvider( provider, decorator, null );
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer( final Composite parent ) {
    StructuredViewer sViewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    return sViewer;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.ui.views.CloudModelViewPart#getRootElement()
   */
  @Override
  protected ICloudElement getRootElement() {
    ICloudElement rootElement = CloudModel.getRoot();
    return rootElement;
  }
  
}