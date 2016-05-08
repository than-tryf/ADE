package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

import cy.ac.ucy.linc.CloudSoftwareRepo.CloudSoftwareRepo;
import cy.ac.ucy.linc.CloudSoftwareRepo.Interfaces.ICloudPropertiesViewer;
import cy.ac.ucy.linc.CloudSoftwareRepo.XML.Properties;
import cy.ac.ucy.linc.CloudSoftwareRepo.XML.Properties.Property;
import cy.ac.ucy.linc.CloudSoftwareRepo.XML.PropertiesFactory;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;


public class CloudSoftwareMarketplaceConfigureArt {

	protected Shell shlSwtConfigureArtifact;
	private Table table;

	private Button btnDone;
	private TableViewer tableViewer;
	private ArrayList<String> tItems;

	private static String selectedArtifact;

	private Properties props;




	// Set the table column property names
	private final String PROPERTY_NAME 		= "propertyname";
	private final String PROPERTY_VALUE 	= "propertyvalue";
	// Set column names
	private String[] columnNames = new String[] { 
			PROPERTY_NAME, 
			PROPERTY_VALUE
	};

	private static ArrayList<String> readyArtifacts=new ArrayList<String>();

	/*------------CELLMODIFIER------------*/
	class PropertiesCellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Object getValue(Object element, String property) {
			// TODO Auto-generated method stub

			// Find the index of the column
			int columnIndex = getColumnNames().indexOf(property);
			Object result=null;

			Properties.Property p = (Property) element;

			switch (columnIndex) {
			case 1 : // DESCRIPTION_COLUMN 
				result = p.getValue();
				break;
			default :
				result = "";
			}
			return result;
		}

		@Override
		public void modify(Object element, String property, Object value) {
			// TODO Auto-generated method stub
			//int columnIndex	= tableViewerExample.getColumnNames().indexOf(property);
			int columnIndex	= getColumnNames().indexOf(property);
			TableItem item = (TableItem) element;
			Properties.Property p = (Property) item.getData();
			String valueString;

			switch (columnIndex) {
			case 0 : // COMPLETED_COLUMN 
				//task.setCompleted(((Boolean) value).booleanValue());
				break;
			case 1 : // DESCRIPTION_COLUMN 
				valueString = ((String) value).trim();
				p.setValue(valueString);
				break;
			default :
			}
			//((PropertiesEx)getProps()).propertyChanged(p);
			tableViewer.setContentProvider(new CloudSoftwareMarketplaceConfigureArt.PropertiesProvider());
			tableViewer.setLabelProvider(new CloudSoftwareMarketplaceConfigureArt.PropertiesLabelProvider());
			tableViewer.setInput(props);
		}

	}


	/*------------------------------------*/


	/*------CONTENTPROVIDER---------*/
	class PropertiesProvider implements IStructuredContentProvider, ICloudPropertiesViewer {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub


		}

		@Override
		public Object[] getElements(Object inputElement) {
			// TODO Auto-generated method stub
			//return new String[] { "One", "Two", "Three", "Four", };
			return props.getProperty().toArray();
		}

		@Override
		public void updateProperty(Property property) {
			// TODO Auto-generated method stub
			tableViewer.update(property, null);
		}

	}
	/*-------------------------------*/

	/*---------LABELPROVIDER----------*/
	class PropertiesLabelProvider extends LabelProvider implements ITableLabelProvider{

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			String result ="";
			Properties.Property p = (Property) element;
			switch(columnIndex){
			case 0:
				result=p.getName();
				break;
			case 1:
				result=p.getValue();
				break;
			default:
				break;
			}
			return result;
		}

	}


	/*----------------------------------*/

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CloudSoftwareMarketplaceConfigureArt window = new CloudSoftwareMarketplaceConfigureArt();
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
		shlSwtConfigureArtifact.open();
		shlSwtConfigureArtifact.layout();
		while (!shlSwtConfigureArtifact.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		/*-INIT-*/
		tItems = new ArrayList<>();
		tItems.add("One");
		tItems.add("Two");
		tItems.add("Three");
		CloudSoftwareMarketplaceConfigureArt.setSelectedArtifact(CloudSoftwareMarketplaceLocal.getSelectedArtifact());
		System.out.println("[*] "+getClass().getSimpleName()+" Selected artifact: "+CloudSoftwareMarketplaceConfigureArt.getSelectedArtifact());
		readProperties();
		/*----------------*/



		shlSwtConfigureArtifact = new Shell();
		shlSwtConfigureArtifact.setImage(SWTResourceManager.getImage(CloudSoftwareMarketplaceConfigureArt.class, "/icons/addsoft.png"));
		shlSwtConfigureArtifact.setSize(706, 464);
		shlSwtConfigureArtifact.setText("Configure Artifact and Add to Palette");
		shlSwtConfigureArtifact.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(shlSwtConfigureArtifact, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		tableViewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setImage(SWTResourceManager.getImage(CloudSoftwareMarketplaceConfigureArt.class, "/icons/artifact.png"));
		column.setWidth(191);
		column.setText("Property Name");

		// 2nd column with task Description
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setImage(SWTResourceManager.getImage(CloudSoftwareMarketplaceConfigureArt.class, "/icons/settings.png"));
		column.setWidth(153);
		column.setText("Property Value");


		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		new Label(composite_1, SWT.NONE);


		btnDone = new Button(composite_1, SWT.NONE);

		btnDone.setImage(SWTResourceManager.getImage(CloudSoftwareMarketplaceConfigureArt.class, "/icons/ok.png"));
		btnDone.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnDone.setText("Done");

		tableViewer.setColumnProperties(columnNames);
		/*-------MAKE THE CELLS EDITABLE------------*/
		CellEditor[] editors = new CellEditor[tableViewer.getTable().getColumnCount()];

		TextCellEditor textEditorValue = new TextCellEditor(table);

		editors[1] =textEditorValue;

		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new PropertiesCellModifier());
		/*------------------------------------------*/

		tableViewer.setContentProvider(new PropertiesProvider());
		tableViewer.setLabelProvider(new PropertiesLabelProvider());
		tableViewer.setInput(props);


		/*--------PROGRAM THE DONE BUTTON-------*/

		btnDone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*------Create the cfg file-------------*/
				File cfg = new File(CloudSoftwareRepo.getARTIFACTS_FOLDER()+"/"+CloudSoftwareMarketplaceConfigureArt.getSelectedArtifact()+"/"+"config/"+CloudSoftwareMarketplaceConfigureArt.getSelectedArtifact()+".cfg");
				if(cfg.exists()){
					System.out.println("[*] "+getClass().getSimpleName()+" : Exists ");
				} else {
					System.out.println("[*] "+getClass().getSimpleName()+" : No Exists ");
				}
				try {
					FileOutputStream fos = new FileOutputStream(cfg);
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

					for(int i=0;i<props.getProperty().size(); i++){
						bw.write(props.getProperty().get(i).getName()+"="+props.getProperty().get(i).getValue());
						bw.newLine();
						System.out.println("[-]...."+props.getProperty().get(i).getName()+" : "+props.getProperty().get(i).getValue());
					}
					bw.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/*--------------------------------------*/ 
				/*---ADD THE CONFIGURED ARTIFACT TO AN ARRAYLIST-----*/
				readyArtifacts.add(getSelectedArtifact());

				for(int j=0;j<readyArtifacts.size();j++){
					System.out.println("[+] Artifact: "+readyArtifacts.get(j));
				}
				
				//Refreshing the palette!
				ToscaDiagramEditor.db.refreshPalette();
				/*-------------------------------------------------*/


			}
		});

		/*---------------------------------------*/

		System.out.println("COLS: "+tableViewer.getTable().getColumnCount());

	}

	@SuppressWarnings("rawtypes")
	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}

	public static String getSelectedArtifact() {
		return selectedArtifact;
	}

	public static void setSelectedArtifact(String selectedArtifact) {
		CloudSoftwareMarketplaceConfigureArt.selectedArtifact = selectedArtifact;
	}


	public void readProperties(){
		File confFile = new File(CloudSoftwareRepo.getARTIFACTS_FOLDER()+"/"+CloudSoftwareMarketplaceConfigureArt.getSelectedArtifact()+"/"+"config/config.xml");
		if (confFile.exists()){
			System.out.println("[*] "+getClass().getSimpleName()+" : File Exists!");
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(PropertiesFactory.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				props = (Properties) jaxbUnmarshaller.unmarshal(confFile);
				System.out.println("[*] "+getClass().getSimpleName()+" :"+props.getProperty().get(0).getName());
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			//Handle file does not exist!
		}
	}


	/*----------GETTERS & SETTERS------------*/


	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public static ArrayList<String> getReadyArtifacts() {
		return readyArtifacts;
	}

	public static void setReadyArtifacts(ArrayList<String> readyArtifacts) {
		CloudSoftwareMarketplaceConfigureArt.readyArtifacts = readyArtifacts;
	}


}
