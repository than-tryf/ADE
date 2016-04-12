package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
/*import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GCData;*/
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.ResourceManager;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepoConstants;
import cy.ac.ucy.linc.CloudSoftwareRepo.Entities.Artifacts;
import cy.ac.ucy.linc.CloudSoftwareRepo.Exceptions.RepoExceptions;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.Activator;

import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.sun.jna.platform.win32.ShlObj;
import org.eclipse.swt.widgets.Group;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class CloudSoftwareMarketplaceView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceView";

	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action action3;
	private Action doubleClickAction;
	private Text txtSearchArtifact;
	public CloudSoftwareRepo csr;
	
	public ArrayList<Artifacts> srchResults;
	public ArrayList<String> result=new ArrayList<String>();

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */

	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			//return new String[] { "One", "Two", "Three", "Four",  };
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
			
			//return PlatformUI.getWorkbench().getSharedImages()
			//		.getImage(ISharedImages.IMG_OBJ_ELEMENT);
			
			final Image image = Activator.getImageDescriptor("icons/artifact.png").createImage();
			return image;
			
		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public CloudSoftwareMarketplaceView() {
		csr = new CloudSoftwareRepo();
		
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(null);
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		Table table = viewer.getTable();
		table.setBounds(10, 46, 186, 361);

		Label lblSearchArtifact = new Label(parent, SWT.NONE);
		lblSearchArtifact.setBounds(10, 20, 88, 15);
		lblSearchArtifact.setText("Search Artifact:");

		txtSearchArtifact = new Text(parent, SWT.BORDER);
		txtSearchArtifact.setBounds(104, 17, 381, 21);

		Button btnSearch = new Button(parent, SWT.NONE);
		
		
		btnSearch.setBounds(509, 15, 75, 25);
		btnSearch.setText("Search");
		
		Group grpGav = new Group(parent, SWT.NONE);
		grpGav.setText("GAV");
		grpGav.setBounds(202, 46, 151, 134);
		
		Label lblGroupId = new Label(grpGav, SWT.NONE);
		lblGroupId.setBounds(10, 22, 55, 15);
		lblGroupId.setText("Group ID:");
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(viewer.getControl(),
						"cy.ac.ucy.linc.CloudSoftwareMarketplace.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CloudSoftwareRepo csr = new CloudSoftwareRepo();
				
				try {
					srchResults = csr.keywordSearch(CloudSoftwareRepo.getNEXUS_URL()+"/"+CloudSoftwareRepoConstants.NEXUS	+ CloudSoftwareRepoConstants.NEXUS_KEYWORD_SEARCH + txtSearchArtifact.getText() + "*");
					System.out.println("Number of results returned: " + srchResults.size());
					System.out.println("Search url: "+CloudSoftwareRepo.getNEXUS_URL()+"/"+CloudSoftwareRepoConstants.NEXUS	+ CloudSoftwareRepoConstants.NEXUS_KEYWORD_SEARCH + txtSearchArtifact.getText() + "*");
					result = new ArrayList<String>();
					for(int i=0;i<srchResults.size();i++){
						result.add(srchResults.get(i).artifactId+"-"+srchResults.get(i).version);
						//System.out.println(srchResults.get(i).artifactId+"-"+srchResults.get(i).version);
					}
					
					//Print-DEBUG
					
					for(int i=0;i<result.size();i++){
						System.out.println("In List: "+result.get(i));
					}
					
					viewer.setContentProvider(new ViewContentProvider());
					viewer.setLabelProvider(new ViewLabelProvider());
					viewer.setSorter(new NameSorter());
					viewer.setInput(getViewSite());
				} catch (RepoExceptions e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					/*MessageBox msBox = new MessageBox(ShlObj.getShell(), SWT.ICON_ERROR | SWT.OK);
					msBox.setText("Error");
					msBox.setMessage(e1.getMessage());
					msBox.open();*/
				}
			}
		});
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				CloudSoftwareMarketplaceView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(action3);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				//CloudSoftwareMarketplaceConfig csmc = new CloudSoftwareMarketplaceConfig();
				CloudSoftwareMarketplaceConfig.main(null);
				//showMessage("Action 1 executed");
			}
		};
		action1.setText("Repository Settings");
		action1.setToolTipText("Configure repository");

		action1.setImageDescriptor(ResourceManager
				.getPluginImageDescriptor(
						"cy.ac.ucy.linc.CloudSoftwareMarketplace",
						"icons/settings.png"));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Repository Information");
		action2.setToolTipText("Repository Information for current session");
		action2.setImageDescriptor(ResourceManager.getPluginImageDescriptor(
				"cy.ac.ucy.linc.CloudSoftwareMarketplace", "icons/info.png"));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				showMessage("Double-click detected on " + obj.toString());
			}
		};
		
		action3 = new Action() {
			public void run() {
				//CloudSoftwareMarketplaceConfig csmc = new CloudSoftwareMarketplaceConfig();
				CloudSoftwareMarketplaceConfig.main(null);
				//showMessage("Action 1 executed");
			}
		};
		action3.setImageDescriptor(ResourceManager.getImageDescriptor(CloudSoftwareMarketplaceView.class, "/icons/admin.png"));
		action3.setText("Repository Management");
		action3.setToolTipText("Repository Management");

		action3.setImageDescriptor(ResourceManager
				.getPluginImageDescriptor(
						"cy.ac.ucy.linc.CloudSoftwareMarketplace",
						"icons/admin.png"));
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"CloudSoftwareMarketplaceView", message);
	}
	/*
	private void openConfigWizard(){
		
	}
*/
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}