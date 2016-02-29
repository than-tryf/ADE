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
 *   Nicholas Loulloudes - initial API and implementation
 *   Stalo Sofokleous
 *******************************************************************************/
package org.eclipse.camf.ui.views;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * @author Nicholas Loulloudes
 *
 */
public class DeploymentLabelProvider extends LabelProvider implements ITableLabelProvider {



	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage( Object element, int columnIndex ) {
		Image image = null;
		if( columnIndex == 0 ) {
			image = getImage( element );
		}
		return image;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText( Object element, int columnIndex ) {
		String text = ""; //$NON-NLS-1$
		if( element instanceof Deployment ) {
			Deployment deployment = ( Deployment )element;
			switch( columnIndex ) {            
			case 1: {
				String status = deployment.getStatus();
				if( status != null ) {
					text = status;
				}
				break;
			}
			case 2: {
				String ip = deployment.getID();
				if( ip != null ) {
					text = ip;
				}
				break;
			}
			case 3: {
				String ip = deployment.getIP();
				if( ip != null ) {
					text = ip;
				}
				break;
			}
			case 4: {
				String image = deployment.getImageId();
				if( image != null ) {
					text = image;
				}
				break;
			}
			case 5: {
				String flavor = deployment.getFlavorId();
				if( flavor != null ) {
					text = flavor;
				}
				break;
			}
			case 6: {
				String keyPair = deployment.getKeyPair();
				if( keyPair != null ) {
					text = keyPair;
				}
				break;
			}
			case 7: {
				text = "test";            
				break;
			  }
			}
		}


		return text;
	}

}
