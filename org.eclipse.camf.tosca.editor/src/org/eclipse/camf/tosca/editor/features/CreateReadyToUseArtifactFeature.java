package org.eclipse.camf.tosca.editor.features;

import java.math.BigInteger;

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateReadyToUseArtifactFeature extends AbstractCreateFeature {

	private Object contextObject = null;

	private static int DEFAULT_MIN_INSTANCES = -1;

	//-1 means not specified by user
	private static int DEFAULT_MAX_INSTANCES = -1;



	public CreateReadyToUseArtifactFeature(IFeatureProvider fp) {
		super(fp, "Ready To Use Artifact", "Create a Ready to use artifact");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		if (context.getTargetContainer() instanceof Diagram)
			return false;
		Object parentBo = getFeatureProvider()
				.getBusinessObjectForPictogramElement(
						context.getTargetContainer());
		if (parentBo instanceof TServiceTemplate || parentBo instanceof EClass) {
			return true;
		}
		return false;
	}


	public void setContextObject (final Object obj) {
		this.contextObject = obj;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO Auto-generated method stub

		if (this.contextObject == null) {
			return null;
		}
		TNodeTemplateExtension newClass = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createTNodeTemplateExtension();
		newClass.setMinInstances( DEFAULT_MIN_INSTANCES );
		newClass.setMaxInstances(  BigInteger.valueOf( DEFAULT_MAX_INSTANCES ) );
		newClass.setId( ( "THANASIS" + ( Integer )newClass.hashCode() ).toString() );
		//newClass.setType(((TNodeTemplateExtension) this.contextObject ).getType());

		//Set X and Y required for reloading tosca model in tosca editor
		newClass.setX(context.getX());
		newClass.setY(context.getY());

		ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );    
		model.getDocumentRoot()
		.getDefinitions()
		.getServiceTemplate()
		.get( 0 )
		.getTopologyTemplate()
		.getNodeTemplate()
		.add( newClass );

		Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
		TServiceTemplate serviceTemplate = null;
		if( parentObject == null )
			return null;
		if( parentObject instanceof TServiceTemplate ) {
			serviceTemplate = ( TServiceTemplate )parentObject;
		}
		TTopologyTemplate topology = null;
		if( serviceTemplate.getTopologyTemplate() == null ) {
			topology = ToscaFactory.eINSTANCE.createTTopologyTemplate();
			serviceTemplate.setTopologyTemplate( topology );
		} else {
			topology = serviceTemplate.getTopologyTemplate();
		}
		// Add object to domain model
		topology.getNodeTemplate().add( newClass );

		// Add object to diagram model
		//getDiagram().eResource().getContents().add(newClass);


		TNodeTemplate nt = topology.getNodeTemplate().get(0);
		if( nt.getDeploymentArtifacts() == null ) {

			final TNodeTemplate node = nt;
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
			editingDomain.getCommandStack()
			.execute( new RecordingCommand( editingDomain ) {

				protected void doExecute() {
					node.setDeploymentArtifacts( ToscaFactory.eINSTANCE.createTDeploymentArtifacts() );
				}
			} );


		}
		
		// Add the new deployment artifact to the list
	      final TDeploymentArtifacts deploymentArtifacts = nt.getDeploymentArtifacts();
	      
	      final TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
	      deploymentArtifact.setName( "ThanasisArtifact" );
	      deploymentArtifact.setArtifactType( new QName("WOW") );
	      
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( parentObject );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          protected void doExecute() {
	            deploymentArtifacts.getDeploymentArtifact().add( deploymentArtifact );
	          }
	        } );



		// do the add
		addGraphicalRepresentation( context, newClass );
		// activate direct editing after object creation
		getFeatureProvider().getDirectEditingInfo().setActive( true );
		// return newly created business object(s)
		return new Object[]{
				newClass
		};

	}

}
