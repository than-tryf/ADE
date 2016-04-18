package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.Activator;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewContentProvider;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewLabelProvider;

import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;

public class CloudSoftwareMarketplaceLocal extends ViewPart {

	public static final String ID = "cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceLocal"; //$NON-NLS-1$
	public ArrayList<String> result = new ArrayList<String>();
	private Table table;
	private TableViewer tableViewer;

	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			// return new String[] { "One", "Two", "Three", "Four", };
			return result.toArray();
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

	public CloudSoftwareMarketplaceLocal() {

	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		{
			TableViewerColumn tableViewerColumn = new TableViewerColumn(
					tableViewer, SWT.NONE);
			TableColumn tblclmnArtifactName = tableViewerColumn.getColumn();
			tblclmnArtifactName.setWidth(272);
			tblclmnArtifactName.setText("Artifact Name");
		}
		{
			DragSource dragSource = new DragSource(table, DND.DROP_MOVE);
		}
		createActions();
		initializeToolBar();
		initializeMenu();
		//result.add("MySQL");
		File f = new File(CloudSoftwareRepo.getARTIFACTS_FOLDER());
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		result = new ArrayList<String>();
		result=names;
		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		tableViewer.setInput(result);
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	private void createTreeColumns(Tree tree) {

		/*
		 * TreeColumn deplStatus = new TreeColumn(tree, SWT.NONE);
		 * deplStatus.setText("Status"); //$NON-NLS-1$
		 * deplStatus.setAlignment(SWT.CENTER); deplStatus.setWidth(100);
		 * 
		 * TreeColumn instanceID = new TreeColumn(tree, SWT.NONE);
		 * instanceID.setText("Instance ID"); //$NON-NLS-1$
		 * instanceID.setAlignment(SWT.CENTER); instanceID.setWidth(300);
		 * 
		 * TreeColumn deplIP = new TreeColumn(tree, SWT.NONE);
		 * deplIP.setText("IP Address"); //$NON-NLS-1$
		 * deplIP.setAlignment(SWT.CENTER); deplIP.setWidth(100);
		 * 
		 * TreeColumn imageID = new TreeColumn(tree, SWT.NONE);
		 * imageID.setText("Image ID"); //$NON-NLS-1$
		 * imageID.setAlignment(SWT.CENTER); imageID.setWidth(100);
		 * 
		 * TreeColumn flavorID = new TreeColumn(tree, SWT.NONE);
		 * flavorID.setText("Flavor ID"); //$NON-NLS-1$
		 * flavorID.setAlignment(SWT.CENTER); flavorID.setWidth(100);
		 * 
		 * TreeColumn keyPair = new TreeColumn(tree, SWT.NONE);
		 * keyPair.setText("Key Pair"); //$NON-NLS-1$
		 * keyPair.setAlignment(SWT.CENTER); keyPair.setWidth(100);
		 */
	}

}
