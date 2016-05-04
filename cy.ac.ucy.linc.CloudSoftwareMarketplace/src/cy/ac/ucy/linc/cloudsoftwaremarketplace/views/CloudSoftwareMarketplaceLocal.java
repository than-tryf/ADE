package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;












import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.UserApplication;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.util.DelegatingDragAdapter;
import org.eclipse.jface.util.LocalSelectionTransfer;
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
import cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd.CSMTransferDnD;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd.CloudSoftwareMarketplaceDnDListener;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd.CloudSoftwareMarketplaceTransferDnDListener;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewContentProvider;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView.ViewLabelProvider;

import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

public class CloudSoftwareMarketplaceLocal extends ViewPart  {

	public static final String ID = "cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceLocal"; //$NON-NLS-1$
	public ArrayList<String> result = new ArrayList<String>();
	private Table table;
	private TableViewer tableViewer;
	private Action action1;
	private Action action2;
	
	public ArrayList<TNodeTemplate> dummy = new ArrayList<TNodeTemplate>();
	public ArrayList<ICloudElement> dummy2 = new ArrayList<ICloudElement>();
	
	private static String selectedArtifact;

	//private ;

	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			// return new String[] { "One", "Two", "Three", "Four", };
			//return result.toArray();
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
			//DragSource dragSource = new DragSource(table, DND.DROP_MOVE);
		}
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		/*
		tableViewer.addDragSupport(operations, new Transfer[]{
				LocalSelectionTransfer.getTransfer()
		}, new DragSourceAdapter(){
			 @Override
		      public void dragStart(DragSourceEvent event) {
		          LocalSelectionTransfer.getTransfer().setSelection(CloudSoftwareMarketplaceLocal.this.tableViewer.getSelection());
		      }
		});*/
		DelegatingDragAdapter adapter = new DelegatingDragAdapter();
		adapter.addDragSourceListener(new CSMTransferDnD(tableViewer));
	    //Transfer[] transferTypes = new Transfer[]{TextTransfer.getInstance()};
	    tableViewer.addDragSupport(operations, adapter.getTransfers(), adapter);
	    
		createActions();
		initializeToolBar();
		initializeMenu();
		//result.add("MySQL");
		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		tableViewer.setInput(result);
		File f = new File(CloudSoftwareRepo.getARTIFACTS_FOLDER());
		/*----------------------------------------------*/
		/*UserApplication uas = InfoSystemFactory.eINSTANCE.createUserApplication();
		uas.setName("Test");
		ArrayList<ICloudElement> tua = new ArrayList<ICloudElement>();
		ICloudElement ua = (ICloudElement)uas;
		tua.add(ua);
		//dummy2=tua;
		TNodeTemplate tnt = ToscaFactory.eINSTANCE.createTNodeTemplate();
		tnt.setName("Test");
		ArrayList<TNodeTemplate> tnt_ = new ArrayList<TNodeTemplate>();
		tnt_.add(tnt);
		dummy = tnt_;
		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		tableViewer.setInput(dummy2);*/
		/*--------------------------------------------------*/
		/*ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		result = new ArrayList<String>();
		result=names;
		tableViewer.setContentProvider(new ViewContentProvider());
		tableViewer.setLabelProvider(new ViewLabelProvider());
		tableViewer.setInput(result);*/
		
		
	}
	

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		action1 = new Action() {
			public void run() {
				File f = new File(CloudSoftwareRepo.getARTIFACTS_FOLDER());
				ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
				result = new ArrayList<String>();
				result=names;
				tableViewer.setContentProvider(new ViewContentProvider());
				tableViewer.setLabelProvider(new ViewLabelProvider());
				tableViewer.setInput(result);
			}
		};
		action1.setText("Refresh");
		action1.setToolTipText("Refresh");

		action1.setImageDescriptor(ResourceManager.getPluginImageDescriptor("cy.ac.ucy.linc.CloudSoftwareMarketplace", "icons/refresh.png"));
		
		action2 = new Action() {
			public void run(){
				System.out.println("[*] Clicked Add Software");
				int arIndex = tableViewer.getTable().getSelectionIndex();
				System.out.println("[*] Selected artifact: "+result.get(arIndex));
				CloudSoftwareMarketplaceLocal.setSelectedArtifact(result.get(arIndex));
				CloudSoftwareMarketplaceConfigureArt.main(null);
			}
		};
		action2.setImageDescriptor(ResourceManager.getImageDescriptor(CloudSoftwareMarketplaceLocal.class, "/icons/addsoft.png"));
		action1.setText("Add Artifact to Palette");
		action1.setToolTipText("Add Artifact to Palette");
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
		toolbarManager.add(action1);
		toolbarManager.add(action2);
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

	public static String getSelectedArtifact() {
		return selectedArtifact;
	}

	public static void setSelectedArtifact(String selectedArtifact) {
		CloudSoftwareMarketplaceLocal.selectedArtifact = selectedArtifact;
	}
	
	

}
