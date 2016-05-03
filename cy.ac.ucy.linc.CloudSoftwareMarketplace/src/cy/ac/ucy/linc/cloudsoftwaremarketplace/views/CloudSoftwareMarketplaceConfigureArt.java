package cy.ac.ucy.linc.cloudsoftwaremarketplace.views;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.custom.SashForm;
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
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceLocal.ViewContentProvider;
import cy.ac.ucy.linc.cloudsoftwaremarketplace.views.CloudSoftwareMarketplaceLocal.ViewLabelProvider;

public class CloudSoftwareMarketplaceConfigureArt {

	protected Shell shlSwtConfigureArtifact;
	private Table table;
	private TableColumn tblclmnPropertyName;
	private TableViewerColumn tableViewerColumn;
	private TableColumn tblclmnPropertyValue;
	private TableViewerColumn tableViewerColumn_1;
	private Button btnDone;
	private TableViewer tableViewer;
	private ArrayList<String> tItems;
	
	

	// Set the table column property names
	private final String PROPERTY_NAME 		= "propertyname";
	private final String PROPERTY_VALUE 	= "propertyvalue";
	// Set column names
	private String[] columnNames = new String[] { 
			PROPERTY_NAME, 
			PROPERTY_VALUE
	};

	
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
			switch (columnIndex) {
			case 1 : // DESCRIPTION_COLUMN 
				result = new String("TR");
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
/*
			switch (columnIndex) {
			case 0 : // COMPLETED_COLUMN 
				task.setCompleted(((Boolean) value).booleanValue());
				break;
			case 1 : // DESCRIPTION_COLUMN 
				valueString = ((String) value).trim();
				task.setDescription(valueString);
				break;
			default :
			}*/
		}
		
	}
	
	
	/*------------------------------------*/
	
	
	/*------CONTENTPROVIDER---------*/
	class PropertiesProvider implements IStructuredContentProvider {

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
			return tItems.toArray();
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
			switch(columnIndex){
			case 0:
				result=getText(element);
				break;
			case 1:
				result="World";
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
		column.setWidth(191);
		column.setText("Property Name");

		// 2nd column with task Description
		column = new TableColumn(table, SWT.LEFT, 1);
		column.setWidth(153);
		column.setText("Property Value");
		
		/*tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnPropertyName = tableViewerColumn.getColumn();
		tblclmnPropertyName.setWidth(191);
		tblclmnPropertyName.setText("Property Name");*/
		
		
		
		/*tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnPropertyValue = tableViewerColumn_1.getColumn();
		tblclmnPropertyValue.setWidth(153);
		tblclmnPropertyValue.setText("Property Value");*/
		
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

		TextCellEditor textEditor = new TextCellEditor(table);
		editors[0] =textEditor;

		TextCellEditor textEditorValue = new TextCellEditor(table);
		editors[1] =textEditorValue;

		tableViewer.setCellEditors(editors);
		tableViewer.setCellModifier(new PropertiesCellModifier());
		/*------------------------------------------*/
		
		tableViewer.setContentProvider(new PropertiesProvider());
		tableViewer.setLabelProvider(new PropertiesLabelProvider());
		tableViewer.setInput(tItems);
		
		
		 
		 
		System.out.println("COLS: "+tableViewer.getTable().getColumnCount());

	}
	
	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}
}
