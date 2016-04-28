package cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd;

import javax.swing.text.TableView;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.Transfer;

public class CSMTransferDnD implements TransferDragSourceListener {

	private TableViewer viewer;

	public CSMTransferDnD(TableViewer viewer) {
		super();
		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("[*]" + getClass().getName() + " Drag Start");

	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("[*]" + getClass().getName() + " Drag Set Data");
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
		System.out.println("[*]" + getClass().getName() + " Drag Finished");
		LocalSelectionTransfer.getTransfer().setSelection(null);
		LocalSelectionTransfer.getTransfer().setSelectionSetTime(0);

	}

	@Override
	public Transfer getTransfer() {
		// TODO Auto-generated method stub
		System.out.println("[*]" + getClass().getName() + " Drag Get Transfer");
		System.out.println("[!]" + getClass().getName() + " Get Transfer: "
				+ LocalSelectionTransfer.getTransfer());
		return LocalSelectionTransfer.getTransfer();
	}

}
