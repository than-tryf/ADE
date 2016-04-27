package cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd;

import org.eclipse.camf.ui.views.CloudModelViewPart;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;

public class CloudSoftwareMarketplaceTransferDnDListener implements
		TransferDragSourceListener {
	
	//private CloudModelViewPart view;

	public CloudSoftwareMarketplaceTransferDnDListener() {
		super();
		//this.view = view;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Start Dragging from Cloud Software Transfer");

	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub

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
