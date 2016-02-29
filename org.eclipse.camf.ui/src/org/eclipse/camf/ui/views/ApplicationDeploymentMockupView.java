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
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpTerminateApplication;
import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.jface.viewers.IStructuredSelection;


public class ApplicationDeploymentMockupView extends ViewPart {

  private TreeViewer viewer;

  public void createPartControl( Composite parent ) {
    this.viewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
    Tree tree = this.viewer.getTree();
    tree.setHeaderVisible( true );    
    createTreeColumns(tree);
    this.viewer.setContentProvider( new MyTreeContentProvider() );
    this.viewer.setLabelProvider( new MyTreeLabelProvider() );
    this.viewer.setInput( DataProvider.getInputData() );
    this.viewer.setAutoExpandLevel(3);
    
    MenuManager menuMgr = new MenuManager();
    menuMgr.setRemoveAllWhenShown(true);

    Menu menu = menuMgr.createContextMenu(this.viewer.getControl());
    
    getSite().registerContextMenu(menuMgr, this.viewer);
    getSite().setSelectionProvider(this.viewer);
    
    menuMgr.addMenuListener(new IMenuListener() {
        @Override
        public void menuAboutToShow(IMenuManager manager) {

            if (viewer.getSelection() instanceof IStructuredSelection == false) {
                return;
            }

            Deployment deployment = null;
            IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
            if (selection!=null && selection instanceof IStructuredSelection) {
              if (selection.getFirstElement() instanceof Deployment){
                deployment = (Deployment) selection.getFirstElement();
              }

            }
            manager.add( new TerminateDeployment(deployment) );
        }
    });
    menuMgr.setRemoveAllWhenShown(true);
    this.viewer.getControl().setMenu(menu);


    Thread updateThread = new Thread() {
        public void run() {
            while (true) {
                Display.getDefault().syncExec(new Runnable() {

                    @Override
                    public void run() {
                        ApplicationDeploymentMockupView.this.viewer.setInput( DataProvider.getInputData() );
                        ApplicationDeploymentMockupView.this.viewer.setAutoExpandLevel(3);
                        
                    }
                });

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    // background thread
    updateThread.setDaemon(true);
    updateThread.start();
  }


    class TerminateDeployment extends Action {
        Deployment selectedDeployment;
      public TerminateDeployment(Deployment deployment) {
          super("Terminate");
          this.selectedDeployment = deployment;
      }
      public void run() {
        OpenStackOpTerminateApplication op = new OpenStackOpTerminateApplication(null, null, null, null );
        for (Deployment module: this.selectedDeployment.getChildren()){
            for (Deployment instance :  module.getChildren()){
                op.terminateModuleInstance(instance.getID());
            }
        }

        //Update Preferences file
        Preferences.removeDeploymentStatus(this.selectedDeployment.getName());
      }
    }

  /**
   * @param tree
   */
  private void createTreeColumns( Tree tree ) {
    
    TreeColumn deplName = new TreeColumn( tree, SWT.NONE );
    deplName.setText( "Application Name" ); //$NON-NLS-1$
    deplName.setAlignment( SWT.LEFT );
    deplName.setWidth( 300 );
        
    TreeColumn deplStatus = new TreeColumn( tree, SWT.NONE );
    deplStatus.setText( "Status" ); //$NON-NLS-1$
    deplStatus.setAlignment( SWT.CENTER );
    deplStatus.setWidth( 100 );   
    
    TreeColumn instanceID = new TreeColumn( tree, SWT.NONE );
    instanceID.setText( "Instance ID" ); //$NON-NLS-1$
    instanceID.setAlignment( SWT.CENTER );
    instanceID.setWidth( 300 );
    
    TreeColumn deplIP = new TreeColumn( tree, SWT.NONE );
    deplIP.setText( "IP Address" ); //$NON-NLS-1$
    deplIP.setAlignment( SWT.CENTER );
    deplIP.setWidth( 100 ); 
    
    TreeColumn imageID = new TreeColumn( tree, SWT.NONE );
    imageID.setText( "Image ID" ); //$NON-NLS-1$
    imageID.setAlignment( SWT.CENTER );
    imageID.setWidth( 100 ); 
    
    TreeColumn flavorID = new TreeColumn( tree, SWT.NONE );
    flavorID.setText( "Flavor ID" ); //$NON-NLS-1$
    flavorID.setAlignment( SWT.CENTER );
    flavorID.setWidth( 100 );
    
    TreeColumn keyPair = new TreeColumn( tree, SWT.NONE );
    keyPair.setText( "Key Pair" ); //$NON-NLS-1$
    keyPair.setAlignment( SWT.CENTER );
    keyPair.setWidth( 100 );
  }

  public void setFocus() {
    this.viewer.getControl().setFocus();
  }
}

class MyTreeLabelProvider extends DecoratingLabelProvider implements ITableLabelProvider {
  
  ITableLabelProvider tableLabelProvider;

  /**
   * @param provider
   * @param decorator
   */
  public MyTreeLabelProvider()
  {
    super(createPureLabelProvider(), PlatformUI.getWorkbench()
          .getDecoratorManager()
          .getLabelDecorator() );
          this.tableLabelProvider = ( ITableLabelProvider )getLabelProvider();
  }

  /**
   * @return
   */
  private static ILabelProvider createPureLabelProvider() {
    return new DeploymentLabelProvider();
  }

  ImageRegistry imgReg = Activator.getDefault().getImageRegistry();
  

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
   */
  @Override
  public Image getColumnImage( Object element, int columnIndex ) {
    Deployment person = ( Deployment )element;
    if(columnIndex == 0){
      if( person.getChildren() != null && person.getChildren().length > 0 && person.getCloudProvider() != null ) {
    	  if (person.getCloudProvider().equals( Deployment.AWS )){
              return this.imgReg.get( "aws" ); //$NON-NLS-1$
            } else if (person.getCloudProvider().equals( Deployment.OPENSTACK )) {
              return this.imgReg.get( "openstack" ); //$NON-NLS-1$
            } else if (person.getCloudProvider().equals(  Deployment.OKEANOS )) {
              return this.imgReg.get( "okeanos" ); //$NON-NLS-1$
            } else if (person.getCloudProvider().equals(  Deployment.FLEXISCALE )) {
              return this.imgReg.get( "flexiscale" ); //$NON-NLS-1$
            } else {
              return PlatformUI.getWorkbench()
                  .getSharedImages()
                  .getImage( ISharedImages.IMG_OBJ_FOLDER );  
            }        
      } 
    } else {
      return null;
    }
    
    if (person.getChildren() == null || person.getChildren().length==0){
        return null;
      }

    return PlatformUI.getWorkbench()
      .getSharedImages()
      .getImage( ISharedImages.IMG_OBJ_ELEMENT );
  }

  /* (non-Javadoc)
   * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
   */
  @Override
  public String getColumnText( Object element, int columnIndex ) {
    String text=""; //$NON-NLS-1$
        
    if( columnIndex == 0 && element instanceof Deployment ) {
      Deployment depl = ( Deployment )element;
      if( depl.getChildren().length > 0 ) {
        text = depl.getName() + " (" + depl.getChildren().length + ")";  //$NON-NLS-1$//$NON-NLS-2$
      } else {
        text = depl.getName();
      }
    } else {
      text = this.tableLabelProvider.getColumnText( element, columnIndex );
    }

    return text;
  }
}

class MyTreeContentProvider extends ArrayContentProvider
  implements ITreeContentProvider
{

  public Object[] getChildren( Object parent ) {
    Deployment person = ( Deployment )parent;
    return person.getChildren();
  }

  public Object getParent( Object element ) {
    Deployment person = ( Deployment )element;
    return person.getParent();
  }

  public boolean hasChildren( Object element ) {
    Deployment person = ( Deployment )element;
    return person.getChildren().length > 0;
  }
}

class DataProvider {

  public static Deployment[] getInputData(){
  
    String deploymentsString = Preferences.getDeploymentsStatus();
    Deployment[] deployments=null;
    try {
      JSONObject deploymentsInfo = new JSONObject(deploymentsString);
      JSONArray deploymentsArray = deploymentsInfo.getJSONArray( "Deployments" );
      deployments = new Deployment[deploymentsArray.length()];
      
      for (int i=0; i<deploymentsArray.length(); i++){
        JSONObject deployment = deploymentsArray.getJSONObject( i );
        
        String appName = deployment.getString( "appName" );
        String deploymentID = deployment.getString( "deploymentID" );
        String status = deployment.getString( "status" );
        
        JSONArray modules = deployment.getJSONArray( "Modules" );
        Deployment[] deploymentModules = new Deployment[modules.length()];
        for (int j=0; j<modules.length(); j++){
          JSONObject module = modules.getJSONObject( j );
          
          String moduleID = module.getString( "ModuleID" );
          String moduleName = module.getString( "ModuleName" );
          
          JSONArray instances = module.getJSONArray( "Instances" );
          Deployment[] moduleInstances = new Deployment[instances.length()];
          int instanceIndex;
          for (int k=0; k<instances.length(); k++){
            JSONObject instance = instances.getJSONObject( k );
            String instanceID = instance.getString( "instanceID" );
            String ImageID = instance.getString( "ImageID" );
            String FlavorID = instance.getString("FlavorID" );
            String KeyPair = instance.getString("KeyPair");
            instanceIndex = k+1;
            moduleInstances[k] = new Deployment("Instance "+ instanceIndex, instanceID, ImageID, FlavorID, KeyPair);
          }
          
          deploymentModules[j] = new Deployment(moduleName, null, null, moduleID, moduleInstances);
        }
        deployments[i] = new Deployment(appName, Deployment.OPENSTACK, status, deploymentID, deploymentModules);
      }

    } catch( JSONException e ) {
      e.printStackTrace();
    }

    return deployments;
  }

}