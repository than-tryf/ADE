package org.eclipse.camf.ui.wizards;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.reporting.ProblemException;


public class NewDeploymentWizardPage extends WizardPage implements ModifyListener {
  
  private CCombo cmbCloudProvider;
  Composite container;
  private List<ICloudDeploymentService> deploymentServices;

  protected NewDeploymentWizardPage( String pageName ) {
    super( pageName );
    //setPageComplete(false);
    setPageComplete(true);
  }

  @Override
  public void createControl( Composite parent ) {

    this.container = new Composite( parent, SWT.NONE );
    GridLayout gLayout = new GridLayout( 2, false );
    gLayout.horizontalSpacing = 10;
    gLayout.verticalSpacing = 12;
    this.container.setLayout( gLayout );
    
    // Optimization Policy Label
    Label lblOptimizationPolicy = new Label( this.container,
                                             GridData.HORIZONTAL_ALIGN_BEGINNING
                                                 | GridData.VERTICAL_ALIGN_CENTER );
    lblOptimizationPolicy.setText( Messages.getString( "NewDeploymentWizardPage.cloudProviderLabel" ) ); //$NON-NLS-1$
    GridData layout = new GridData();
    layout.horizontalAlignment = GridData.FILL;
    lblOptimizationPolicy.setLayoutData( layout );
//    // Combo - Policy
//    this.cmbCloudProvider = new CCombo( this.container, SWT.BORDER );
//    this.cmbCloudProvider.setEnabled( true );
//    layout = new GridData();
//    layout.horizontalAlignment = GridData.FILL;
//    layout.horizontalSpan = 2;
//    this.cmbCloudProvider.setLayoutData( layout );
//    
//    ICloudProviderManager cpManager = CloudModel.getCloudProviderManager();
//    ICloudElement[] children;
//    
//    int i=0;
//    try {
//      children = cpManager.getChildren( new NullProgressMonitor() );
//      for( ICloudElement CloudElement : children ) {
//        if( CloudElement instanceof GenericCloudProvider ) {
//          GenericCloudProvider gCp = ( GenericCloudProvider )CloudElement;
//          this.cmbCloudProvider.add( gCp.getName(), i++);
//        }
//      }
//
//    } catch( ProblemException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }  
//    
//    this.cmbCloudProvider.setEditable( false );
//    
//    this.cmbCloudProvider.addModifyListener( this );
    
    setControl( this.container );
  }

  @Override
  public void modifyText( ModifyEvent e ) {
    // TODO Auto-generated method stub
    
  }
  
//  protected boolean validatePage() {
//    boolean result = !( this.cmbCloudProvider.getText().equals( "" ) );
//    if( result ) {
//      setPageComplete( true );
//      getContainer().updateButtons();
//    }
//    //return result;
//  return true;
//  }
//  
//  @Override
//  public void modifyText( ModifyEvent e ) {
//    if( e.widget == this.cmbCloudProvider )
//      validatePage();
//  }
  
//  public void setServices (final List<ICloudDeploymentService> deploymentServices){    
//    setMessage( null );
//    this.deploymentServices = deploymentServices;
//    
//    for (ICloudDeploymentService service : this.deploymentServices) {
//      this.cmbCloudProvider.add( service.getName() );
//    }
//
//    
//  }
  
//  /**
//   * @return the Cloud Provider
//   */
//  public ICloudDeploymentService getCloudDeploymentService() {
//    ICloudDeploymentService service = null;
//    int index = this.cmbCloudProvider.getSelectionIndex();
//    if( index != -1 ) {
//      service = this.deploymentServices.get( index );
//    }
//    return service;
//  }
}
