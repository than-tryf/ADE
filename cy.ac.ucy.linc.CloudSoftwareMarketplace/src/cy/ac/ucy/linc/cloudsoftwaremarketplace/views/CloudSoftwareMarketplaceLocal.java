package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.jface.viewers.TreeViewerColumn;

public class CloudSoftwareMarketplaceLocal extends ViewPart {

	public static final String ID = "cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceLocal"; //$NON-NLS-1$

	private TreeViewer viewer;

	public CloudSoftwareMarketplaceLocal() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.viewer = new TreeViewer( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );
		Tree tree = this.viewer.getTree();
		tree.setHeaderVisible(true);
		createTreeColumns(tree);
		createActions();
		initializeToolBar();
		initializeMenu();
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

		TreeColumn artName = new TreeColumn(tree, SWT.NONE);
		artName.setText("Artifact Name"); //$NON-NLS-1$
		artName.setAlignment(SWT.LEFT);
		artName.setWidth(300);

		/*TreeColumn deplStatus = new TreeColumn(tree, SWT.NONE);
		deplStatus.setText("Status"); //$NON-NLS-1$
		deplStatus.setAlignment(SWT.CENTER);
		deplStatus.setWidth(100);

		TreeColumn instanceID = new TreeColumn(tree, SWT.NONE);
		instanceID.setText("Instance ID"); //$NON-NLS-1$
		instanceID.setAlignment(SWT.CENTER);
		instanceID.setWidth(300);

		TreeColumn deplIP = new TreeColumn(tree, SWT.NONE);
		deplIP.setText("IP Address"); //$NON-NLS-1$
		deplIP.setAlignment(SWT.CENTER);
		deplIP.setWidth(100);

		TreeColumn imageID = new TreeColumn(tree, SWT.NONE);
		imageID.setText("Image ID"); //$NON-NLS-1$
		imageID.setAlignment(SWT.CENTER);
		imageID.setWidth(100);

		TreeColumn flavorID = new TreeColumn(tree, SWT.NONE);
		flavorID.setText("Flavor ID"); //$NON-NLS-1$
		flavorID.setAlignment(SWT.CENTER);
		flavorID.setWidth(100);

		TreeColumn keyPair = new TreeColumn(tree, SWT.NONE);
		keyPair.setText("Key Pair"); //$NON-NLS-1$
		keyPair.setAlignment(SWT.CENTER);
		keyPair.setWidth(100);*/
	}

}
