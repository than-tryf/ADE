package cy.ac.ucy.linc.cloudsoftwaremarketplace.dnd;

import java.math.BigInteger;

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
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
		event.doit=true;
		ISelection selection = viewer.getSelection();
		System.out.println("[!]" + getClass().getName()
				+ " Drag Start (SELECTION): " + selection.toString());
		LocalSelectionTransfer.getTransfer().setSelection(selection);
		LocalSelectionTransfer.getTransfer().setSelectionSetTime(
				event.time & 0xFFFFFFFFL);
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		// TODO Auto-generated method stub
		/*TNodeTemplateExtension appServer = Tosca_Elasticity_ExtensionsFactory.eINSTANCE
				.createTNodeTemplateExtension();
		appServer.setType(new QName("appserver"));
		appServer.setName("App Server");
		appServer.setMinInstances(-1);
		appServer.setMaxInstances(BigInteger.valueOf(-1));
		appServer.setId(("C" + (Integer) appServer.hashCode()).toString());*/
		// newClass.setType(((TNodeTemplateExtension) this.contextObject
		// ).getType());

		// Set X and Y required for reloading tosca model in tosca editor
		// appServer.setX(context.getX());
		// appServer.setY(context.getY());
		// IFeatureProvider featureProvider = getFeatureProvider();
		System.out.println("[*]" + getClass().getName() + " Drag Set Data");
		// event.data = appServer;
		/*TTopologyTemplate topology = ToscaFactory.eINSTANCE
				.createTTopologyTemplate();
		topology.getNodeTemplate().add(appServer);*/
		//System.out.println("[!]" + getClass().getName() + " Drag Topology: "+topology.getNodeTemplate().toString());
		event.data=LocalSelectionTransfer.getTransfer();

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
