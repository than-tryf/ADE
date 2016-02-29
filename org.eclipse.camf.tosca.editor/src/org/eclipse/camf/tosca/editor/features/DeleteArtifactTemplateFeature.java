package org.eclipse.camf.tosca.editor.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TImplementationArtifact;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;


public class DeleteArtifactTemplateFeature extends DefaultDeleteFeature{
  
  private TNodeTypeImplementation parentNodeTypeImplementation;

  public DeleteArtifactTemplateFeature( IFeatureProvider fp ) {
    super( fp );
  }
  
  @Override
  public void preDelete(IDeleteContext context) {

    //TArtifactTemplate
    Object deletedObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getPictogramElement() );
    
    TArtifactTemplate deletedArtifactTemplate = (TArtifactTemplate) deletedObject;
    
    String deletedArtifactTemplateId = deletedArtifactTemplate.getId();
    
    //TNodeTemplate parent of TArtifactTemplate
    PictogramElement parentPE = Graphiti.getPeService().getPictogramElementParent( context.getPictogramElement() );
    
    TNodeTemplate parentNodeTemplate = ( TNodeTemplate ) getFeatureProvider().getBusinessObjectForPictogramElement( parentPE );
    
    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
    
    final EList<TNodeTypeImplementation> nodeTypeImplementations = model.getDocumentRoot().getDefinitions().getNodeTypeImplementation();
    
    this.parentNodeTypeImplementation = null;
    for (final TNodeTypeImplementation tempNodeTypeImplementation : nodeTypeImplementations){
      if (tempNodeTypeImplementation.getNodeType().toString().compareTo( parentNodeTemplate.getName() )==0){
        this.parentNodeTypeImplementation = tempNodeTypeImplementation;
        break;
      }
    }
    
    if (this.parentNodeTypeImplementation == null)
      return;
    
    final TNodeTypeImplementation nodeTypeImplementation = parentNodeTypeImplementation;
    //for (final TImplementationArtifact tempImplementationArtifact : nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact()){
    for (int i=0; i<nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact().size(); i++){
      final TImplementationArtifact tempImplementationArtifact = nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact().get( i );
      if (tempImplementationArtifact.getArtifactRef().toString().compareTo( deletedArtifactTemplateId )==0){
        //Implementation artifact refers to the TArtifactTemplate to be deleted
        TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
        editingDomain.getCommandStack()
          .execute( new RecordingCommand( editingDomain ) {

            @Override
            protected void doExecute() {
              nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact().remove( tempImplementationArtifact );
            }
          } );

      }
    }

    //if there are no more implementation artifacts, delete implementation artifacts element
    if (nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact().size()==0){
      nodeTypeImplementations.remove( nodeTypeImplementation );
    }
      
  }
    
}
