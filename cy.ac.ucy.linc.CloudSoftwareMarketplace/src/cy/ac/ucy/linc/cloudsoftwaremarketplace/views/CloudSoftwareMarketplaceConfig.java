package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;

public class CloudSoftwareMarketplaceConfig {

	protected Shell shell;

	/**
	 * Launch the application.
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage(CloudSoftwareMarketplaceConfig.class, "/icons/settings.png"));
		shell.setSize(450, 300);
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 10, 414, 64);
		CloudSoftwareRepo csr = new CloudSoftwareRepo();

	}
}
