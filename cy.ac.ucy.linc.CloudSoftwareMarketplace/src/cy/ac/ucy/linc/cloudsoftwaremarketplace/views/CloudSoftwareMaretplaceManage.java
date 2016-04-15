package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;

public class CloudSoftwareMaretplaceManage extends Shell {
	private Table table;

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
		super(display, SWT.CLOSE | SWT.TITLE);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		setImage(SWTResourceManager.getImage(CloudSoftwareMaretplaceManage.class, "/icons/admin.png"));
		setText("Repository Management");
		setLayout(new GridLayout(1, false));
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TabItem tbtmCreateAndUpload = new TabItem(tabFolder, SWT.NONE);
		tbtmCreateAndUpload.setImage(SWTResourceManager.getImage(CloudSoftwareMaretplaceManage.class, "/icons/upload.png"));
		tbtmCreateAndUpload.setText("Create and Upload Artifact");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCreateAndUpload.setControl(composite);
		
		TabItem tbtmDeleteArtifact = new TabItem(tabFolder, SWT.NONE);
		tbtmDeleteArtifact.setImage(SWTResourceManager.getImage(CloudSoftwareMaretplaceManage.class, "/icons/delete.png"));
		tbtmDeleteArtifact.setText("Delete Artifact");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDeleteArtifact.setControl(composite_1);
		
		Group grpListOfUploaded = new Group(composite_1, SWT.NONE);
		grpListOfUploaded.setText("List of Uploaded Artifacts");
		grpListOfUploaded.setBounds(10, 10, 233, 338);
		
		TableViewer tableViewer = new TableViewer(grpListOfUploaded, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(10, 24, 213, 304);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
