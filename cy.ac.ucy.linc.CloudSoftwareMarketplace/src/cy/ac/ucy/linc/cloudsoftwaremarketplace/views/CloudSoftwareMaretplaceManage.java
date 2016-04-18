package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.io.File;
import java.util.ArrayList;

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
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.widgets.Button;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.*;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.Activator;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.NameSorter;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewContentProvider;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewLabelProvider;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

public class CloudSoftwareMaretplaceManage extends Shell {
	private Table table;

	public ArrayList<Artifacts> inArt;
	public int artIndex;
	public ArrayList<String> artNames = new ArrayList<String>();

	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			// return new String[] { "One", "Two", "Three", "Four", };
			return artNames.toArray();
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {

			// return PlatformUI.getWorkbench().getSharedImages()
			// .getImage(ISharedImages.IMG_OBJ_ELEMENT);

			final Image image = Activator.getImageDescriptor(
					"icons/artifact.png").createImage();
			return image;

		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * Launch the application.
	 * 
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
	 * 
	 * @param display
	 */
	public CloudSoftwareMaretplaceManage(Display display) {
		super(display, SWT.CLOSE | SWT.TITLE);
		setSize(765, 493);
		setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		setImage(SWTResourceManager.getImage(
				CloudSoftwareMaretplaceManage.class, "/icons/admin.png"));
		setText("Repository Management");
		setLayout(new GridLayout(1, false));

		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1,
				1));

		TabItem tbtmCreateAndUpload = new TabItem(tabFolder, SWT.NONE);
		tbtmCreateAndUpload.setImage(SWTResourceManager.getImage(
				CloudSoftwareMaretplaceManage.class, "/icons/upload.png"));
		tbtmCreateAndUpload.setText("Create and Upload Artifact");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCreateAndUpload.setControl(composite);
		Button btnDummy = new Button(composite, SWT.NONE);
		btnDummy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(File.listRoots()[0].getAbsolutePath());
			}
		});
		btnDummy.setBounds(342, 43, 75, 25);
		btnDummy.setText("Dummy");

		TabItem tbtmDeleteArtifact = new TabItem(tabFolder, SWT.NONE);
		tbtmDeleteArtifact.setImage(SWTResourceManager.getImage(
				CloudSoftwareMaretplaceManage.class, "/icons/delete.png"));
		tbtmDeleteArtifact.setText("Delete Artifact");

		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmDeleteArtifact.setControl(composite_1);

		Group grpListOfUploaded = new Group(composite_1, SWT.NONE);
		grpListOfUploaded.setText("List of Uploaded Artifacts");
		grpListOfUploaded.setBounds(10, 10, 233, 338);

		TableViewer tableViewer = new TableViewer(grpListOfUploaded, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		table = tableViewer.getTable();
		table.setBounds(10, 24, 213, 304);

		Button btnPublishRepositoryIndex = new Button(composite_1, SWT.NONE);

		btnPublishRepositoryIndex.setBounds(374, 81, 224, 25);
		btnPublishRepositoryIndex.setText("Publish Repository Index");

		Button btnDeleteArtifact = new Button(composite_1, SWT.NONE);

		btnDeleteArtifact.setBounds(374, 133, 224, 25);
		btnDeleteArtifact.setText("Delete Artifact");
		createContents();
		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		//tableViewer.setSorter(new NameSorter());
		// tableViewer.setInput(getViewSite());

		btnPublishRepositoryIndex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CloudSoftwareRepo csr = new CloudSoftwareRepo();

				try {
					inArt = csr.indexRepository();
					System.out.println("Number of results returned: "
							+ inArt.size());
					artNames = new ArrayList<String>();
					for (int i = 0; i < inArt.size(); i++) {
						artNames.add(inArt.get(i).artifactId + "-"
								+ inArt.get(i).version);
						// System.out.println(srchResults.get(i).artifactId+"-"+srchResults.get(i).version);
					}

					tableViewer.setContentProvider(new ViewContentProvider());
					tableViewer.setLabelProvider(new ViewLabelProvider());
					//tableViewer.setSorter(new NameSorter());
					tableViewer.setInput(artNames);
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnDeleteArtifact.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				artIndex = tableViewer.getTable().getSelectionIndex();
				System.out.println("You have selected to delete artifact: "+artIndex+" which is: "+artNames.get(artIndex));
				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				csr.deleteArtifact(inArt.get(artIndex));
				
				try {
					inArt = csr.indexRepository();
					artNames = new ArrayList<String>();
					for (int i = 0; i < inArt.size(); i++) {
						artNames.add(inArt.get(i).artifactId + "-"
								+ inArt.get(i).version);
						// System.out.println(srchResults.get(i).artifactId+"-"+srchResults.get(i).version);
					}

					tableViewer.setContentProvider(new ViewContentProvider());
					tableViewer.setLabelProvider(new ViewLabelProvider());
					//tableViewer.setSorter(new NameSorter());
					tableViewer.setInput(artNames);
					
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
