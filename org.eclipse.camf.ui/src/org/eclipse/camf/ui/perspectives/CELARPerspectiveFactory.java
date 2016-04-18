package org.eclipse.camf.ui.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class CELARPerspectiveFactory implements IPerspectiveFactory{

	  @Override
	  public void createInitialLayout( IPageLayout layout ) {
	    // TODO Auto-generated method stub
	    layout.setEditorAreaVisible(true);
	   
	    layout.addView( "eu.celar.ui.views.CloudProjectView", IPageLayout.LEFT,0.18f,layout.getEditorArea() );
	   // layout.addView("cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView", IPageLayout.LEFT,0.18f,layout.getEditorArea());
	    
	    IFolderLayout bottomFolder=layout.createFolder("bottomFolder",IPageLayout.BOTTOM,0.69f,layout.getEditorArea());
	    bottomFolder.addView("org.eclipse.ui.views.PropertySheet");
	    bottomFolder.addView( "org.eclipse.camf.ui.views.deploymentview" );
	    //bottomFolder.addView( "eu.celar.ui.views.deploymentview" );
	    bottomFolder.addView( "org.eclipse.ui.console.ConsoleView" );
	    bottomFolder.addView( "eu.celar.ui.views.authenticationTokenView" );
	    

	  }
	}