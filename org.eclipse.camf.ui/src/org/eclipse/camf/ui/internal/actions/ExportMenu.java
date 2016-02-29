/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
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
 * 	Nicholas Loulloudes - Initial Implementation
 ******************************************************************************/
package org.eclipse.camf.ui.internal.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudElementCreator;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.CompoundContributionItem;


/**
 * @author nickl
 *
 */
public class ExportMenu extends CompoundContributionItem
  implements ISelectionChangedListener
{
  
  private List<ExportAction> actions = new ArrayList<ExportAction>();
  
  private IWorkbenchSite site;
  
  public ExportMenu(final IWorkbenchSite site) {
    checkVisible();
    this.site = site;
  }

  protected void checkVisible() {
    setVisible( ( this.actions != null ) && ( this.actions.size() > 0 ) );
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
   */
  @Override
  public void selectionChanged( final SelectionChangedEvent event ) {
    ISelection selection = event.getSelection();
    if( selection instanceof IStructuredSelection ) {
      List<ICloudApplicationDescription> descList = new ArrayList<ICloudApplicationDescription>();
      List<?> selectionList = ( ( IStructuredSelection )selection ).toList();
      for( Object obj : selectionList ) {
        if( obj instanceof ICloudApplicationDescription ) {
          descList.add( ( ICloudApplicationDescription )obj );
        } else {
          descList = null;
          break;
        }
      }
      setSelectedDescriptions( descList );
    }
  }
  
  protected void setSelectedDescriptions( final List< ICloudApplicationDescription > descriptions ) {
    createActions( descriptions );
    checkVisible();
  }
  
  private void createActions( final List< ICloudApplicationDescription > descriptions ) {
    
    this.actions.clear();
    Class< ? extends ICloudApplicationDescription > sourceType = null;
    
    if ( ( descriptions != null ) && ( descriptions.size() > 0 ) ) {
      sourceType = descriptions.get( 0 ).getClass();
      for ( int i = 1 ; i < descriptions.size() ; i++ ) {
        if ( ! descriptions.get( i ).getClass().equals( sourceType ) ) {
          sourceType = null;
          break;
        }
      }
    }
    
    if ( sourceType != null ) {
      List< IConfigurationElement > configs
        = CloudModel.getCreatorRegistry().getConfigurations( sourceType, ICloudApplicationDescription.class );
      if ( ( configs != null ) && ( configs.size() > 0 ) ) {
        ICloudApplicationDescription[] array = descriptions.toArray( new ICloudApplicationDescription[ descriptions.size() ] );
        for ( IConfigurationElement element : configs ) {
          ExportAction action = getAction( element, array );
          if ( action != null ) {
            this.actions.add( action );
          }
        }
      }
    }
    
  }
  
  private ExportAction getAction( final IConfigurationElement fromElement,
                                     final ICloudApplicationDescription[] descriptions ) {
    
    ExportAction result = null;
    
    String name
      = fromElement.getAttribute( Extensions.CLOUD_ELEMENT_CREATOR_NAME_ATTRIBUTE );
    
    try {
      ICloudElementCreator creator
        = ( ICloudElementCreator ) fromElement.createExecutableExtension( Extensions.CLOUD_ELEMENT_CREATOR_EXECUTABLE );
      result = new ExportAction( name, creator, descriptions, this.site );
    } catch ( CoreException cExc ) {
      Activator.logException( cExc );
    }
    
    return result;
    
  }

  /* (non-Javadoc)
   * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
   */
  @Override
  protected IContributionItem[] getContributionItems() {
    IContributionItem[] result = new IContributionItem[ 0 ];
    if( ( this.actions != null ) && ( this.actions.size() > 0 ) ) {
      result = new IContributionItem[ this.actions.size() ];
      for( int i = 0; i < this.actions.size(); i++ ) {
        result[ i ] = new ActionContributionItem( ( IAction )this.actions.get( i ) );
      }
    }
    return result;
  }
}
