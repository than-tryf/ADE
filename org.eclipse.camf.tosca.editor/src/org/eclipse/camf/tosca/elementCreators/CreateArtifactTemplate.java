package org.eclipse.camf.tosca.elementCreators;

import java.io.File;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.camf.tosca.ArtifactReferencesType;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;


public class CreateArtifactTemplate {
  
  TArtifactTemplate newArtifactTemplate = null;
  
  public CreateArtifactTemplate(String artifactName, QName artifactType, final ToscaModelLayer model){
    if (templateExists(model, artifactName)){
      return;
    }
    
    // Create Artifact Template
    final TArtifactTemplate artifactTemplate = ToscaFactory.eINSTANCE.createTArtifactTemplate();
    // Create Script Artifact Properties
    ScriptArtifactPropertiesType scriptProperties = Tosca_Elasticity_ExtensionsFactory.eINSTANCE.createScriptArtifactPropertiesType();
    scriptProperties.setLanguage( "Shell" );
    // Set the Properties of the Policy Template
    PropertiesType properties = ToscaFactory.eINSTANCE.createPropertiesType();
    // Add the SYBL Policy to the FeatureMap of the Policy's Properties element
    Entry e = FeatureMapUtil.createEntry( Tosca_Elasticity_ExtensionsPackage.eINSTANCE.getDocumentRoot_ScriptArtifactProperties(),
                                          scriptProperties );
    properties.getAny().add( e );
    artifactTemplate.setProperties( properties );
    artifactTemplate.setId( artifactName );
    artifactTemplate.setName( "SD"+artifactName );
    artifactTemplate.setType( artifactType );
    // Set artifact ref
    TArtifactReference artifactRef = ToscaFactory.eINSTANCE.createTArtifactReference();
    artifactRef.setReference( "Scripts" + System.getProperty( "file.separator" ) + artifactName );
    ArtifactReferencesType artifactRefType = ToscaFactory.eINSTANCE.createArtifactReferencesType();
    artifactRefType.getArtifactReference().add( artifactRef );
    artifactTemplate.setArtifactReferences( artifactRefType );
    
    // Add the new Artifact Template to the TOSCA Definitions element
    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
    editingDomain.getCommandStack()
      .execute( new RecordingCommand( editingDomain ) {

        @Override
        protected void doExecute() {
          model.getDocumentRoot()
            .getDefinitions()
            .getArtifactTemplate()
            .add( artifactTemplate );
        }
      } );
    
    this.newArtifactTemplate = artifactTemplate;
    
  }
  
  private boolean templateExists(final ToscaModelLayer model, String artifactName){
    
    for (TArtifactTemplate tempArtifactTemplate : model.getDocumentRoot()
            .getDefinitions()
            .getArtifactTemplate()){
      if (tempArtifactTemplate.getId().equals( artifactName ))
        return true;
    }

    return false;
  }
  
  public TArtifactTemplate getNewArtifactTemplate(){
    return this.newArtifactTemplate;
  }
}
