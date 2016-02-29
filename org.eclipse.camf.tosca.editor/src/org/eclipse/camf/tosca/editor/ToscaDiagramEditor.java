/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor;


import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.ImplementationArtifactType;
import org.eclipse.camf.tosca.SourceElementType;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.TargetElementType;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.editor.listener.ToscaModelChangeListener;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.camf.tosca.elasticity.TServiceTemplateExtension;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.AreaContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IDiagramBehavior;
//import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;


/**
 * @author Nicholas Loulloudes
 *
 */
public class ToscaDiagramEditor extends DiagramEditor {
	  
	  private static GraphicalViewer gViewer;
	  
	  public static IDiagramBehavior db = null;
	  
	  private ToscaModelChangeListener toscaModelChangeListener;
	  
	  private TransactionalEditingDomain transactionalEditingDomain;
	  
	  private static IProject activeProject = null;
	    
	  /**
	   * The Tosca Diagram Editor Constructor.
	   */
	  public ToscaDiagramEditor () {
		  
	    super ();
	    
	  }
	   
	  public static IProject getActiveProject(){
	    
	    return activeProject;
	    
	  }
	  
	  protected void registerBusinessObjectsListener() {
	    
	    this.toscaModelChangeListener = new ToscaModelChangeListener(this);

	    final TransactionalEditingDomain ted = getEditingDomain();
	    ted.addResourceSetListener(this.toscaModelChangeListener);
	  }

	  /* (non-Javadoc)
	   * @see org.eclipse.graphiti.ui.editor.DiagramEditor#getEditingDomain()
	   */
	  @Override
	  public TransactionalEditingDomain getEditingDomain() {
	    TransactionalEditingDomain ted = super.getEditingDomain();

	    if (ted == null) {
	      ted = this.transactionalEditingDomain;
	    }

	    return ted;
	  }

	  @Override
	  public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
	    
	    IEditorInput finalInput = null;

	    try {
	      if (input instanceof ToscaDiagramEditorInput) {
	        finalInput = input;
	      } else {
	        finalInput = createNewDiagramEditorInput(input);
	      }
	    } catch (CoreException exception) {
	      exception.printStackTrace();
	    }

	    if ( finalInput instanceof ToscaDiagramEditorInput ){
	      activeProject = ((ToscaDiagramEditorInput) finalInput).getToscaFile().getProject();
	    }

	    super.init(site, finalInput);
	    // Refresh Palette Compartments
	    ToscaDiagramEditor.db = getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior();
	    getDiagramTypeProvider().getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refreshPalette();
	    
	  }
	  

	  private ToscaDiagramEditorInput createNewDiagramEditorInput(final IEditorInput input) throws CoreException {

	    final IFile dataFile = ToscaFileService.getDataFileForInput(input);

	    // now generate the temporary diagram file
	    final IPath dataFilePath = dataFile.getFullPath();

	    // get or create the corresponding temporary folder
	    final IFolder tempFolder = ToscaFileService.getOrCreateTempFolder(dataFilePath);

	    // finally get the diagram file that corresponds to the data file
	    final IFile diagramFile = ToscaFileService.getTemporaryDiagramFile(dataFilePath, tempFolder);

	    // Create new temporary diagram file
	    ToscaDiagramCreator creator = new ToscaDiagramCreator();

	    return creator.createToscaDiagram(dataFile, diagramFile, this, false);
	  }
	  
	  @Override
	  public void doSave(final IProgressMonitor monitor) {
	    super.doSave(monitor);
	    
//	    final ToscaDiagramEditorInput tdei = (ToscaDiagramEditorInput) getEditorInput();
	    
	    ((BasicCommandStack) getEditingDomain().getCommandStack()).saveIsDone();
	    updateDirtyState();
	  }
	  
	  @Override
	  public boolean isDirty() {
	    TransactionalEditingDomain editingDomain = getEditingDomain();
	    // Check that the editor is not yet disposed
	    if (editingDomain != null && editingDomain.getCommandStack() != null) {
	      return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	    }
	    return false;
	  }
	  
	  @Override
	  protected void setInput(final IEditorInput input) {
	    super.setInput(input);

	    final ToscaDiagramEditorInput tdei = (ToscaDiagramEditorInput) input;
	    final IFile dataFile = tdei.getToscaFile();
	    
	    final ToscaModelLayer model = new ToscaModelLayer(getDiagramTypeProvider().getFeatureProvider(), dataFile);
	    ModelHandler.addModel(EcoreUtil.getURI(getDiagramTypeProvider().getDiagram()), model);
	    
	    DocumentRoot documentRoot = null;
	    TOSCAResource toscaResource = null ;
	    ICloudElement findElement = CloudModel.getRoot().findElement( dataFile );
	    if (findElement instanceof TOSCAResource) {
	      toscaResource = (TOSCAResource) findElement;
	    }
	    
	    URI resourceURI = null;
	    //IEditorInput eInput = getEditorInput();
	   
	    if( getEditorInput() instanceof ToscaDiagramEditorInput ) {
	      IFile modelFile = ((ToscaDiagramEditorInput) getEditorInput()).getToscaFile();      
	      resourceURI = URI.createPlatformResourceURI( modelFile.getFullPath().toString(), false );      
	    } 
	    
	    Exception exception = null;
	    Resource resource = null;
	    try {
	      /* Load the resource through the editing domain. */
	      resource = getEditingDomain().getResourceSet().getResource( resourceURI, true );
	    } catch( Exception e ) {
	      exception = e;
	      resource = getEditingDomain().getResourceSet().getResource( resourceURI, false );
	    }
	    Diagnostic diagnostic = analyzeResourceProblems( resource, exception );
	        
	    if( diagnostic.getSeverity() != Diagnostic.OK ) {
	      //todo
	    } else {
	      documentRoot = getDocumentRoot( resource );
//	      documentRoot = toscaResource.getTOSCAModel().getDocumentRoot();
	    }

	    
	    if( documentRoot != null ) {
	      model.setDocumentRoot( documentRoot );
	      BasicCommandStack basicCommandStack = ( BasicCommandStack )getEditingDomain().getCommandStack();
	      if( input instanceof DiagramEditorInput ) {
	        basicCommandStack.execute( new RecordingCommand( getEditingDomain() ) {

	          @Override
	          protected void doExecute() {
	            importDiagram( model );
	          }
	        } );
	      }
	      basicCommandStack.saveIsDone();
	      basicCommandStack.flush();
	    }
	  }
	  
	  private final DocumentRoot getDocumentRoot( final Resource resource ) {
	    // Get an iterator to iterate through all contents of the resource.
	    TreeIterator<EObject> iterator = resource.getAllContents();
	    DocumentRoot result = null;
	    while( iterator.hasNext() ) {
	      EObject testElement = iterator.next();
	      /*
	       * Instance-of checks for each EObject that appears in the resource. We
	       * want to get the DocumentRoot EObject which is the root Element inside a
	       * Tosca Document.
	       */
	      if( testElement instanceof DocumentRoot ) {
	        result = ( DocumentRoot ) testElement;
	      }
	    }
	    return result;
	  }
	  
	  
	  /**
	   * @param resource
	   * @param exception
	   * @return
	   */
	  private Diagnostic analyzeResourceProblems( final Resource resource,
	                                             final Exception exception )
	  {
	    Diagnostic basicDiagnostic = null;
	    if( !resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty() ) {
	      basicDiagnostic = new BasicDiagnostic( Diagnostic.ERROR,
	                                             Activator.PLUGIN_ID,
	                                             0,
	                                             String.format( Messages.getString( "ToscaEditor.CreateModelErrorMessage" ), //$NON-NLS-1$
	                                                            resource.getURI() ),
	                                             new Object[]{
	                                               exception == null
	                                                                ? ( Object )resource
	                                                                : exception
	                                             } );
	      ( ( BasicDiagnostic )basicDiagnostic ).merge( EcoreUtil.computeDiagnostic( resource,
	                                                                                 true ) );
	    } else if( exception != null ) {
	      basicDiagnostic = new BasicDiagnostic( Diagnostic.ERROR,
	                                             Activator.PLUGIN_ID,
	                                             0,
	                                             Messages.getString( "ToscaEditor.CreateModelErrorMessage" ), //$NON-NLS-1$
	                                             new Object[]{
	                                               exception
	                                             } );
	    } else {
	      basicDiagnostic = Diagnostic.OK_INSTANCE;
	    }
	    return basicDiagnostic;
	  }
	  
	  
	  protected void importDiagram( final ToscaModelLayer model ) {
	    final Diagram diagram = getDiagramTypeProvider().getDiagram();
	    diagram.setActive( true );
	    getEditingDomain().getCommandStack()
	      .execute( new RecordingCommand( getEditingDomain() ) {

	        @Override
	        protected void doExecute() {
	          if (model.getDocumentRoot() != null) {
	            DocumentRoot documentRoot = model.getDocumentRoot();
	            DefinitionsType definitionsType = documentRoot.getDefinitions();
	            EList<TServiceTemplate> serviceTemplates = definitionsType.getServiceTemplate();
	            EList<TNodeTypeImplementation> nodeTypesImplementation = definitionsType.getNodeTypeImplementation();
	            EList<TArtifactTemplate> artifactTemplates = definitionsType.getArtifactTemplate();        
	            
	            Boolean substitute = false;
	            ContainerShape containerShapeTST = null;
	            
	            for (TServiceTemplate tst : serviceTemplates) { 
	                
	              if ( tst.getSubstitutableNodeType() != null ){
	                //tst is a group component
	                TServiceTemplateExtension tstG = (TServiceTemplateExtension) tst;
	                addContainerElement (tst, containerShapeTST, tstG.getX(), tstG.getY(), tstG.getWidth(), tstG.getHeight());
	                substitute = true;
	              }
	              
	              else{
	                TServiceTemplateExtension tste = (TServiceTemplateExtension) tst;
	                addContainerElement (tst, diagram, 0, 0, tste.getWidth(), tste.getHeight());
	                containerShapeTST = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                    .getPictogramElementForBusinessObject( tst );
	              }
	              
	              ContainerShape containerShape = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                .getPictogramElementForBusinessObject( tst ); 
	              
	              TTopologyTemplate topology = tst.getTopologyTemplate();
	              
	              if (topology == null)
	                break;
	                           
	                for (TNodeTemplate tnt : topology.getNodeTemplate()) {

	                  if ( (tnt.getType()!=null) && (tnt.getType().toString().contains( "substituteNode" )) ) {//$NON-NLS-1$
	                    continue;
	                  }
	                  
	                  TNodeTemplateExtension tnte = (TNodeTemplateExtension) tnt;
	                  addContainerElement( tnt, containerShape, tnte.getX(), tnte.getY(), tnte.getWidth(), tnte.getHeight() );
	                  
	                  ContainerShape containerShapeTNT = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                      .getPictogramElementForBusinessObject( tnt ); 
	                  
	                  //Add Deployment Artifacts
	                  if ( tnt.getDeploymentArtifacts() != null && tnt.getDeploymentArtifacts().getDeploymentArtifact() != null ){
	                      for (TDeploymentArtifact tda : tnt.getDeploymentArtifacts().getDeploymentArtifact() ){

	                                addContainerElement( tda, containerShapeTNT, 0, 0, 0, 0 );
	                          
	                      }
	                  }
	                  
	                  //Find NodeTypeImplementation
	                  TNodeTypeImplementation nodeTypeImplementation = null;
	                  for (TNodeTypeImplementation tempNodeImplementation : nodeTypesImplementation){
	                    if (tnt.getName().equals( tempNodeImplementation.getNodeType().toString())){
	                      nodeTypeImplementation = tempNodeImplementation;
	                      break;
	                    }
	                  }
	                  if (nodeTypeImplementation!=null && nodeTypeImplementation.getImplementationArtifacts()!=null){
	                    EList<ImplementationArtifactType> implementationArtifacts = nodeTypeImplementation.getImplementationArtifacts().getImplementationArtifact();
	                    for (ImplementationArtifactType tempImplementationArtifact : implementationArtifacts){
	                      if (tempImplementationArtifact.getOperationName().equals( "execute" ))
	                      {
	                        for (TArtifactTemplate tempArtifactTemplate : artifactTemplates){
	                          if (tempArtifactTemplate.getId().equals(tempImplementationArtifact.getArtifactRef().toString()))
	                            addContainerElement( tempArtifactTemplate, containerShapeTNT, 0, 0, 0, 0 );
	                        }
	                      }
	     
	                    }
	                  }
	 
	                }                
	                
	                if ( substitute ){
	                  //Composite Component Service Template
	                  //Add deployment artifacts to composite component's service template
	                  
	                  for (TServiceTemplate tempTst : serviceTemplates) { 
	                    for (TNodeTemplate tnt : tempTst.getTopologyTemplate().getNodeTemplate()) {
	  
	                          
	                          if ( tst.getSubstitutableNodeType() != null && (tnt.getType()!=null) && tnt.getType().toString().equals( tst.getSubstitutableNodeType().toString()) ){
	                            //Found the service template that substitutes the specific node template
	                            
	                            ContainerShape containerShapeTNT = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                                .getPictogramElementForBusinessObject( tst ); 
	                            
	                            //Add Deployment Artifacts
	                            if ( tnt.getDeploymentArtifacts() != null && tnt.getDeploymentArtifacts().getDeploymentArtifact() != null ){
	                                for (TDeploymentArtifact tda : tnt.getDeploymentArtifacts().getDeploymentArtifact() ){

	                                          addContainerElement( tda, containerShapeTNT, 0, 0, 0, 0 );
	                                    
	                                }
	                            } 
	                            break;
	                          }
	                        
	                      
	                    }
	                  }
	                  substitute = false;
	                }
	                else{
	                  //Application Service Template
	                  //Add deployment artifacts to application's service template
	                  
	                }

	            }
	            
	            //Add Relationships
	            for (TServiceTemplate tst : serviceTemplates) { 
	              
	              if ( tst.getTopologyTemplate() == null )
	                continue;
	              
	              for (TRelationshipTemplate trt : tst.getTopologyTemplate().getRelationshipTemplate()) {    
	                  
	               SourceElementType se = trt.getSourceElement();
	               TargetElementType te = trt.getTargetElement();
	               String sourceID = se.getRef();
	               String targetID = te.getRef();
	               Anchor sourceAnchor = null, targetAnchor = null;
	               for (TServiceTemplate tstTemp : serviceTemplates) {
	                   for (TNodeTemplate tnt : tstTemp.getTopologyTemplate().getNodeTemplate()) {
	                     
	                       ContainerShape containerShapeTNT;
	                       
	                       if ( tnt.getId().equals(sourceID) ){
	                           if ( (tnt.getType()!=null) && (tnt.getType().toString().contains( "substituteNode" ) == true) ){
	                               containerShapeTNT = getAnchorContainer(model, tnt);
	                           }else{
	                               containerShapeTNT = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                                       .getPictogramElementForBusinessObject( tnt ); 
	                           }
	                           if ( containerShapeTNT.getAnchors() != null ){
	                                for ( Anchor anchor : containerShapeTNT.getAnchors() ){
	                                    if (anchor instanceof ChopboxAnchor){
	                                        sourceAnchor = anchor;
	                                        break;
	                                    }
	                                }
	                           }
	                      
	                       } else if ( tnt.getId().equals(targetID) ){
	                           if ( ((tnt.getType()!=null)) && (tnt.getType().toString().contains( "substituteNode" ) == true) ){
	                               containerShapeTNT = getAnchorContainer(model, tnt);
	                           }else{
	                               containerShapeTNT = ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                                       .getPictogramElementForBusinessObject( tnt ); 
	                           }
	                           if ( containerShapeTNT.getAnchors() != null ){
	                                for ( Anchor anchor : containerShapeTNT.getAnchors() ){
	                                    if (anchor instanceof ChopboxAnchor){
	                                        targetAnchor = anchor;
	                                        break;
	                                    }
	                                }
	                           }
	                       }
	                   }
	               }
	       
	                
	               addRelationshipContainerElement( trt, sourceAnchor, targetAnchor );
	              }
	          }
	          }
	        }

	      } );
	  }
	  
	  
	  private ContainerShape getAnchorContainer(final ToscaModelLayer model, TNodeTemplate nodeTemplate){
	        // Find the substitute TServiceTemplate
	      TServiceTemplate substituteNode = null;

	        for (TServiceTemplate tempServiceTemplate : model.getDocumentRoot()
	          .getDefinitions()
	          .getServiceTemplate()){
	           
	          if (tempServiceTemplate.getSubstitutableNodeType() != null &&
	                  tempServiceTemplate.getId().equals(nodeTemplate.getId())) 
	          {
	            substituteNode = tempServiceTemplate;
	            break;
	          }
	        }
	        return ( ContainerShape )getDiagramTypeProvider().getFeatureProvider()
	                .getPictogramElementForBusinessObject( substituteNode ); 
	  }
	  
	  protected PictogramElement addContainerElement( final EObject element,
	                                                  final ContainerShape parent, int x_axis, int y_axis, int width, int height )
	  {
	    
	    final IFeatureProvider featureProvider = getDiagramTypeProvider().getFeatureProvider();
	    
	    AddContext context = new AddContext( new AreaContext(), element );
	    IAddFeature addFeature = featureProvider.getAddFeature( context );
	    context.setNewObject( element );    
	    context.setTargetContainer( parent );
	    context.setLocation(x_axis, y_axis);
	    context.setSize( width, height );
	    PictogramElement pictElement = null;
	    
	    boolean canAdd  = false;
	    if (addFeature != null) {
	      canAdd = addFeature.canAdd( context ) ;
	    }
	      
	    if( canAdd ) {
	      pictElement = addFeature.add( context );
	      
	      if (element instanceof TDeploymentArtifact && ((TDeploymentArtifact) element).getArtifactType().toString().compareTo( "MonitoringProbe" )==0){
	        //There is no pictogram element linked to the monitoring image
	        return pictElement;
	      }    
	      else{
	        featureProvider.link( pictElement, new Object[]{ element } );
	        return pictElement;
	      }
	    }
	    
	    return null;

	  }

	  protected PictogramElement addRelationshipContainerElement( final EObject element,
	          final Anchor sourceAnchor, final Anchor targetAnchor ){
	      
	      if (sourceAnchor == null)
	          return null;
	      
	      if (targetAnchor == null)
	          return null;
	      
	      AddConnectionContext context = new AddConnectionContext(sourceAnchor, targetAnchor);
	      context.setNewObject( element );
	      
	      final IFeatureProvider featureProvider = getDiagramTypeProvider().getFeatureProvider();
	      IAddFeature addFeature = featureProvider.getAddFeature( context );
	      
	        PictogramElement pictElement = null;
	        
	        boolean canAdd = addFeature.canAdd( context ) ;
	            
	        if( canAdd ) {
	          pictElement = addFeature.add( context );
	          featureProvider.link( pictElement, new Object[]{ element } );
	        }
	        
	        return pictElement;

	  }

	  
	  
	  @Override
	  public void createPartControl(Composite parent) {
	    super.createPartControl(parent);
	    // hides grid on diagram, but you can reenable it
	    if (getGraphicalViewer() != null && getGraphicalViewer().getEditPartRegistry() != null) {
	      ScalableFreeformRootEditPart rootEditPart = (ScalableFreeformRootEditPart) getGraphicalViewer().getEditPartRegistry().get(LayerManager.ID);
	      IFigure gridFigure = ((LayerManager) rootEditPart).getLayer(LayerConstants.GRID_LAYER);
	      gridFigure.setVisible(true);
	    }
	    // setPartName("MyDiagram2");
	  }

	//  @Override
	//  protected ContextMenuProvider createContextMenuProvider() {
//	    return new ActivitiEditorContextMenuProvider(getGraphicalViewer(), getActionRegistry(), getDiagramTypeProvider());
	//  }

	  public static GraphicalViewer getActiveGraphicalViewer() {
	    return gViewer;
	  }

	  @Override
	  public void dispose() {
	    super.dispose();

	    final ToscaDiagramEditorInput tdei = (ToscaDiagramEditorInput) getEditorInput();

	    ModelHandler.removeModel(EcoreUtil.getURI(getDiagramTypeProvider().getDiagram()));
	    ToscaDiagramCreator.dispose(tdei.getDiagramFile());
	  }
	  
	}
