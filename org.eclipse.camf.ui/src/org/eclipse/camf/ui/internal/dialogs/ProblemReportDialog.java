/*****************************************************************************
 * Copyright (c) 2008 g-Eclipse Consortium 
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
 *    Ariel Garcia      - modified to work for any Throwable
 *    Nicholas Loulloudes - code adapted for CELAR project, 2013
 *****************************************************************************/

package org.eclipse.camf.ui.internal.dialogs;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.camf.core.reporting.IProblem;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.ui.internal.Activator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ProblemReportDialog extends TitleAreaDialog {
  /**
   * ID of the send button.
   */
  private static final int SEND_ID = 0x01;
  
  /**
   * ID of the save button.
   */
  private static final int SAVE_ID = 0x02;
  
  /**
   * ID of the copy button.
   */
  private static final int COPY_ID = 0x03;
  
  /**
   * The throwable to be reported.
   */
  private Throwable exc;
  
  /**
   * The associated problem to be reported, if any.
   */
  private IProblem problem;
  
  /**
   * Text field for the email address.
   */
  private Text mailtoText;
  
  /**
   * The text holding the problem report.
   */
  private Text reportText;
  
  /**
   * Create a new problem report dialog for the specified problem.
   * 
   * @param parentShell The dialog's parent {@link Shell}.
   * @param throwable The {@link Throwable} to be reported.
   */
  public ProblemReportDialog( final Shell parentShell, final Throwable throwable ) {
    super( parentShell );
    this.exc = throwable;
    
    if ( this.exc instanceof ProblemException ) {
      this.problem = ( ( ProblemException ) this.exc ).getProblem();
    } else {
      this.problem = null;
    }
    
    setShellStyle( SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE );
    URL imgURL = Activator.getDefault().getBundle()
                   .getResource( "icons/extras/problem_report_dlg.gif" ); //$NON-NLS-1$
    ImageDescriptor imgDesc = ImageDescriptor.createFromURL( imgURL );
    setTitleImage( imgDesc.createImage() );
  }
  
  /*
   * (non-Javadoc)
   * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
   */
  @Override
  protected void configureShell( final Shell shell ) {
    super.configureShell( shell );
    shell.setText( "Problem Report" ); //$NON-NLS-1$
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
   */
  @Override
  protected void buttonPressed( final int buttonId ) {
    if ( buttonId == IDialogConstants.CLIENT_ID + SEND_ID ) {
      sendPressed();
    } else if ( buttonId == IDialogConstants.CLIENT_ID + SAVE_ID ) {
      savePressed();
    } else if ( buttonId == IDialogConstants.CLIENT_ID + COPY_ID ) {
      copyPressed();
    } else if ( buttonId == IDialogConstants.CLOSE_ID ) {
      closePressed();
    } else {
      super.buttonPressed( buttonId );
    }
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createButtonsForButtonBar( final Composite parent ) {
    createButton( parent, IDialogConstants.CLIENT_ID + SEND_ID, "Send", true ); //$NON-NLS-1$
    createButton( parent, IDialogConstants.CLIENT_ID + SAVE_ID, "Save", false ); //$NON-NLS-1$
    createButton( parent, IDialogConstants.CLIENT_ID + COPY_ID, "Copy", false ); //$NON-NLS-1$
    createButton( parent, IDialogConstants.CLOSE_ID, IDialogConstants.CLOSE_LABEL, false );
    updateUI();
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected Control createDialogArea( final Composite parent ) {
    
    Label topRule = new Label( parent, SWT.HORIZONTAL | SWT.SEPARATOR );
    topRule.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ) );
    
    Composite mainComp = new Composite( parent, SWT.NONE );
    mainComp.setLayout( new GridLayout( 1, false ) );
    mainComp.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
    
    Label mailtoLabel = new Label( mainComp, SWT.NONE );
    mailtoLabel.setText( "Email address:" ); //$NON-NLS-1$
    mailtoLabel.setLayoutData( new GridData() );
    
    this.mailtoText = new Text( mainComp, SWT.BORDER );
    String mailto = null;
    if ( this.problem != null ) {
      mailto = this.problem.getMailTo();
    }
    this.mailtoText.setText( mailto == null ? "" : mailto ); //$NON-NLS-1$
    this.mailtoText.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );
    
    Label reportLabel = new Label( mainComp, SWT.NONE );
    reportLabel.setText( "Problem Report:" ); //$NON-NLS-1$
    reportLabel.setLayoutData( new GridData() );
    
    this.reportText = new Text( mainComp, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER );
    ProblemReport factory = new ProblemReport( this.exc );
    this.reportText.setText( factory.createReport() );
    GridData gData = new GridData( SWT.FILL, SWT.FILL, true, true );
    gData.widthHint = 500;
    gData.heightHint = 400;
    this.reportText.setLayoutData( gData );
    
    Label bottomRule = new Label( parent, SWT.HORIZONTAL | SWT.SEPARATOR );
    bottomRule.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ) );
    
    this.mailtoText.addModifyListener( new ModifyListener() {
      public void modifyText( final ModifyEvent e ) {
        updateUI();
      }
    } );
    
    setTitle( "Problem Report" ); //$NON-NLS-1$
    setMessage( "A problem report was created, you may save it, send it via email, or copy it to clipboard." ); //$NON-NLS-1$
    
    updateUI();
    
    return mainComp;
        
  }
  
  /**
   * Called when the close button is pressed.
   */
  protected void closePressed() {
    setReturnCode( OK );
    close();
  }
  
  /**
   * Called when the copy button is pressed.
   */
  protected void copyPressed() {
    
    try {
    
      Transfer[] dataTypes = new Transfer[] {
          TextTransfer.getInstance()
      };
      Object[] data = new Object[] {
          this.reportText.getText()
      };
      Clipboard clipboard = new Clipboard( getShell().getDisplay() );
      clipboard.setContents( data, dataTypes );
      clipboard.dispose();
      
      setMessage(
          "The problem report was copied to the system clipboard", //$NON-NLS-1$
          IMessageProvider.INFORMATION );
      
    } catch ( Throwable t ) {
      setErrorMessage( String.format( "Copy failed: %s", t.getLocalizedMessage() ) ); //$NON-NLS-1$
    }
    
  }
  
  /**
   * Called when the save button is pressed.
   */
  protected void savePressed() {
    // Do nothing for now    
  }
  
  /**
   * Called when the send button is pressed.
   */
  protected void sendPressed() {
    
    try {
      
      String mailto = this.mailtoText.getText();
      if ( ( mailto == null ) || ( mailto.length() == 0 ) ) {
        throw new IllegalArgumentException( "The mailto address is empty" ); //$NON-NLS-1$
      }
      
      URL link = getMailToLink( this.reportText.getText(), mailto );
      IWorkbenchBrowserSupport browserSupport
        = PlatformUI.getWorkbench().getBrowserSupport();
      IWebBrowser externalBrowser
        = browserSupport.getExternalBrowser();
      externalBrowser.openURL( link );
      setMessage(
          String.format( "An attempt was made to send to problem report to %s", mailto ), //$NON-NLS-1$
          IMessageProvider.INFORMATION );
      
    } catch ( Throwable t ) {
      setErrorMessage( String.format( "Send failed: %s", t.getLocalizedMessage() ) ); //$NON-NLS-1$
    }
    
  }
  
  protected void updateUI() {
    Button sendButton = getButton( IDialogConstants.CLIENT_ID + SEND_ID );
    if ( sendButton != null ) {
      String mailto = this.mailtoText.getText();
      sendButton.setEnabled( ( mailto != null ) && ( mailto.length() > 0 ) );
    }
  }
  
  /**
   * Get the mailto link for the send action.
   * 
   * @param report The report to be send.
   * @return The mailto link as {@link URL}.
   * @throws MalformedURLException If the {@link URL} is malformed.
   */
  private URL getMailToLink( final String report, final String address )
      throws MalformedURLException {
    if ( ( address == null ) || ( address.length() == 0 ) ) {
      throw new IllegalArgumentException( "The mailto address is empty" ); //$NON-NLS-1$
    }
    return new URL(
        "mailto:" + address //$NON-NLS-1$
        + "?subject=Problem Report: " + this.problem.getDescription() //$NON-NLS-1$
        + "&body=" + report //$NON-NLS-1$
    );
  } 

}
