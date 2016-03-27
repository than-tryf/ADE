package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class CloudSoftwareMarketplaceConfig {

	protected Shell shlConfigureRepository;
	private Text txtRepo;
	private Text txtUsername;
	private Text txtPassword;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CloudSoftwareMarketplaceConfig window = new CloudSoftwareMarketplaceConfig();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlConfigureRepository.open();
		shlConfigureRepository.layout();
		while (!shlConfigureRepository.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConfigureRepository = new Shell(SWT.CLOSE | SWT.TITLE);
		shlConfigureRepository.setText("Configure Repository");
		shlConfigureRepository.setImage(SWTResourceManager.getImage(
				CloudSoftwareMarketplaceConfig.class, "/icons/settings.png"));
		shlConfigureRepository.setSize(450, 300);

		Composite composite = new Composite(shlConfigureRepository, SWT.BORDER);
		composite.setBounds(10, 10, 414, 199);

		Label lblRepositoryUrl = new Label(composite, SWT.NONE);
		lblRepositoryUrl.setBounds(10, 10, 98, 15);
		lblRepositoryUrl.setText("Repository URL:");

		txtRepo = new Text(composite, SWT.BORDER);
		txtRepo.setBounds(114, 7, 286, 21);

		Button btnPing = new Button(composite, SWT.NONE);

		btnPing.setImage(SWTResourceManager.getImage(
				CloudSoftwareMarketplaceConfig.class, "/icons/ping.png"));
		btnPing.setBounds(130, 63, 135, 25);
		btnPing.setText("Ping Repository");

		Label lblRepositoryAdminUsername = new Label(composite, SWT.NONE);
		lblRepositoryAdminUsername.setBounds(10, 128, 160, 15);
		lblRepositoryAdminUsername.setText("Repository Admin Username");

		txtUsername = new Text(composite, SWT.BORDER);
		txtUsername.setBounds(174, 128, 226, 21);

		Label lblRepositoryAdminPassword = new Label(composite, SWT.NONE);
		lblRepositoryAdminPassword.setText("Repository Admin Password");
		lblRepositoryAdminPassword.setBounds(10, 170, 160, 15);

		txtPassword = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setBounds(174, 164, 226, 21);

		Button btnOK = new Button(shlConfigureRepository, SWT.NONE);
		
		btnOK.setImage(SWTResourceManager.getImage(
				CloudSoftwareMarketplaceConfig.class, "/icons/ok.png"));
		btnOK.setBounds(81, 236, 111, 25);
		btnOK.setText("OK");

		Button btnClose = new Button(shlConfigureRepository, SWT.NONE);
		
		btnClose.setText("Close");
		btnClose.setImage(SWTResourceManager.getImage(
				CloudSoftwareMarketplaceConfig.class, "/icons/cancel.png"));
		btnClose.setBounds(259, 236, 111, 25);
		CloudSoftwareRepo csr = new CloudSoftwareRepo();
		btnPing.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//csr.setNEXUS_URL(txtRepo.getText());
				try {
					csr.pingRepository(txtRepo.getText());
					MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_INFORMATION | SWT.OK);
					msBox.setText("Information");
					msBox.setMessage("Repository online.");
					msBox.open();
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					/*Display display = new Display();
					Shell shell = new Shell(display);*/

					MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_ERROR | SWT.OK);
					msBox.setText("Error");
					msBox.setMessage(e1.getMessage());
					msBox.open();
				}
			}
		});
		
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlConfigureRepository.dispose();
			}
		});
		
		btnOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(txtRepo.getText().equals("") || txtRepo.getText()==null){
					MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_WARNING | SWT.OK);
					msBox.setText("Warning");
					msBox.setMessage("You must provide a valid repository URL.");
					msBox.open();
				} else {
					if(txtUsername.getText().equals("")|| txtUsername.getText()==null){
						MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_WARNING | SWT.OK);
						msBox.setText("Warning");
						msBox.setMessage("You must provide an administrator username for the repository");
						msBox.open();
					} else {
						if(txtPassword.getText().equals("") ||txtPassword.getText()==null){
							MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_WARNING | SWT.OK);
							msBox.setText("Warning");
							msBox.setMessage("You must provide an administrator password for the repository");
							msBox.open();
						}else {
							CloudSoftwareRepo.setNEXUS_URL(txtRepo.getText());
							CloudSoftwareRepo.setUsername(txtUsername.getText());
							CloudSoftwareRepo.setPassword(txtPassword.getText());
							MessageBox msBox = new MessageBox(shlConfigureRepository.getShell(), SWT.ICON_INFORMATION | SWT.OK);
							msBox.setText("Information");
							msBox.setMessage("Necessary repository information has been provided. You may now proceed and close the repository configuration window if you like.");
							msBox.open();
						}
					}
					
				}
			}
		});

	}
}
