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
package org.eclipse.camf.tosca.editor.listener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.notification.INotificationService;
import org.eclipse.graphiti.platform.IDiagramContainer;
import org.eclipse.swt.widgets.Display;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaModelChangeListener implements ResourceSetListener {
  
  private IDiagramContainer diagramEditor;

  /**
   * @param diagramEditor
   */
  public ToscaModelChangeListener (final IDiagramContainer diagramEditor) {
    super();
    this.diagramEditor = diagramEditor;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#getFilter()
   */
  @Override
  public NotificationFilter getFilter() {
    return NotificationFilter.NOT_TOUCH;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#isAggregatePrecommitListener()
   */
  @Override
  public boolean isAggregatePrecommitListener() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#isPostcommitOnly()
   */
  @Override
  public boolean isPostcommitOnly() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#isPrecommitOnly()
   */
  @Override
  public boolean isPrecommitOnly() {
    return false;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
   */
  @Override
  public void resourceSetChanged( final ResourceSetChangeEvent event ) {
    
    final IDiagramTypeProvider provider = this.diagramEditor.getDiagramTypeProvider();
    final Diagram diagram = provider.getDiagram();

    if (diagram != null && diagram.getPictogramLinks().isEmpty()) {
      return;
    }

    final Set<EObject> changedBOs = new HashSet<EObject>();
    final List<Notification> notifications = event.getNotifications();

    for (final Notification notification : notifications) {
      final Object notifier = notification.getNotifier();

      if (notifier instanceof EObject) {
        final EObject eNotifier = (EObject) notifier;

        changedBOs.add(eNotifier);
      }
    }

    final INotificationService notificationService = provider.getNotificationService();
    final PictogramElement[] dirtyPEs
      = notificationService.calculateRelatedPictogramElements(changedBOs.toArray());

    if (dirtyPEs.length > 0) {
      // do an asynchronous update in the UI thread
      Display.getDefault().asyncExec(new Runnable() {

        @Override
        public void run() {
//          IDiagramEditor dEditor = provider.getDiagramEditor();
//          if (provider.isAutoUpdateAtRuntime() && dEditor.isDirty()) {
          if (provider.isAutoUpdateAtRuntime() && diagramEditor.isDirty()) {
            notificationService.updatePictogramElements(dirtyPEs);
          } else {
//            dEditor.refresh();
            diagramEditor.getDiagramBehavior().refresh();
          }
        }

      });
    }
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.transaction.ResourceSetListener#transactionAboutToCommit(org.eclipse.emf.transaction.ResourceSetChangeEvent)
   */
  @Override
  public Command transactionAboutToCommit( final ResourceSetChangeEvent arg0 ) throws RollbackException
  {
    return null;
  }
}
