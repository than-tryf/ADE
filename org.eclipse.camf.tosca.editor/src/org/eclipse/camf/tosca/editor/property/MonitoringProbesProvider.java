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
package org.eclipse.camf.tosca.editor.property;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;

// This class provides the content and label providers for table viewers related
// to monitoring probes
public class MonitoringProbesProvider {

  MonitoringProbesContentProvider MPContentProvider;
  MonitoringProbesContentLabelProvider MPContentLabelProvider;

  public MonitoringProbesProvider() {
    this.MPContentProvider = new MonitoringProbesContentProvider();
    this.MPContentLabelProvider = new MonitoringProbesContentLabelProvider();
  }
  class MonitoringProbesContentProvider implements IStructuredContentProvider {

    @Override
    public void dispose() {
      // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged( Viewer viewer, Object oldInput, Object newInput )
    {
      // TODO Auto-generated method stub
    }

    @Override
    public Object[] getElements( Object inputElement ) {
      String[] elements = new String[ 0 ];
      elements = ( String[] )( ( List )inputElement ).toArray( new String[ 0 ] );
      return elements;
    }
  }
  class MonitoringProbesContentLabelProvider extends LabelProvider
    implements ITableLabelProvider
  {

    @Override
    public Image getColumnImage( Object element, int columnIndex ) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getColumnText( Object element, int columnIndex ) {
      String result = null;
      if( element != null ) {
        String var = ( String )element;
        switch( columnIndex ) {
          case 0:
            result = var;
          break;
        }
      }
      return result;
    }
  }
}
