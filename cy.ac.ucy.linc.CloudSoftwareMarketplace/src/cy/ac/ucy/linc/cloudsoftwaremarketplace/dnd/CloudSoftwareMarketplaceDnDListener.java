package cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.TextTransfer;

public class CloudSoftwareMarketplaceDnDListener implements DragSourceListener {
	
	private TableViewer viewer;
	

	public CloudSoftwareMarketplaceDnDListener(TableViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Start Drag");
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		selection.getFirstElement();
		if(TextTransfer.getInstance().isSupportedType(event.dataType)){
			System.out.println("OK Drag");
		}
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub

	}

}
