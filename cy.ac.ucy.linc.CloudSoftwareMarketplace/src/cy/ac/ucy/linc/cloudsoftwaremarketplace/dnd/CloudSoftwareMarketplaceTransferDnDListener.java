package cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;

public class CloudSoftwareMarketplaceTransferDnDListener implements
		TransferDragSourceListener {

	// private CloudModelViewPart view;
	private final TableViewer viewer;

	public CloudSoftwareMarketplaceTransferDnDListener(TableViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Start Dragging from Cloud Software Transfer");
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		//ISelection selection = viewer.getSelection();
		System.out.println("[*] "+selection.getFirstElement().toString());
		event.doit = true;
		LocalSelectionTransfer.getTransfer().setSelection(selection);
		LocalSelectionTransfer.getTransfer().setSelectionSetTime(
				event.time & 0xFFFFFFFFL);

	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Setting Data from Cloud Software Transfer");
		event.data = LocalSelectionTransfer.getTransfer().getSelection();

	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Finished Dragging from Cloud Software Transfer");
		LocalSelectionTransfer.getTransfer().setSelection(null);
		LocalSelectionTransfer.getTransfer().setSelectionSetTime(0);

	}

	@Override
	public Transfer getTransfer() {
		return LocalSelectionTransfer.getTransfer();
	}

}
