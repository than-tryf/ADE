package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class CloudSoftwareMaretplaceManage extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			CloudSoftwareMaretplaceManage shell = new CloudSoftwareMaretplaceManage(
					display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public CloudSoftwareMaretplaceManage(Display display) {
		super(display, SWT.CLOSE | SWT.RESIZE | SWT.TITLE);
		setImage(SWTResourceManager.getImage(CloudSoftwareMaretplaceManage.class, "/icons/admin.png"));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Repository Management");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
