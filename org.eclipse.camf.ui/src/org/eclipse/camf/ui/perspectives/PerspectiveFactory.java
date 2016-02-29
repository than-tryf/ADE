/*******************************************************************************
 * Copyright (c) 2014 DHBW Mannheim
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
 *   Harald Kornmayer - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	private static final String PROJECT_VIEW_ID = "org.eclipse.camf.ui.views.CloudProjectView";
	private static final String CLOUD_AUTH_ID = "org.eclipse.camf.ui.views.authenticationTokenView";
	private static final String CLOUD_DEPLOY_ID = "org.eclipse.camf.ui.views.deploymentview";
	private static final String CLOUD_INFORMATION = "org.eclipse.camf.infosystem.ui.InfoSystemView";
	
	private static final String CLOUD_MARKETPLACE ="cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView";

	private static final String TOPLEFT = "topleft";
	private static final String RIGHT = "right";
	private static final String BOTTOM = "bottom";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		IFolderLayout topleftFolder = layout.createFolder(TOPLEFT,
				IPageLayout.LEFT, 0.2f, editorArea);
		topleftFolder.addView(PROJECT_VIEW_ID);
		topleftFolder.addPlaceholder(IPageLayout.ID_PROJECT_EXPLORER);

		IFolderLayout bottomFolder = layout.createFolder(BOTTOM,
				IPageLayout.BOTTOM, 0.66f, editorArea);

		bottomFolder.addView(IPageLayout.ID_PROP_SHEET);
		bottomFolder.addView(CLOUD_AUTH_ID);
		bottomFolder.addView(CLOUD_DEPLOY_ID);

		IFolderLayout rightFolder = layout.createFolder(RIGHT, IPageLayout.RIGHT,
				0.33f, editorArea);

		rightFolder.addView(CLOUD_INFORMATION);
		
		rightFolder.addView(CLOUD_MARKETPLACE);
	}

}
