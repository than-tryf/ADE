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
package org.eclipse.camf.tosca.editor.diagram;

import javax.xml.namespace.QName;

import org.eclipse.camf.core.model.impl.ResourceCloudElement;
import org.eclipse.camf.infosystem.model.base.KeyPair;
import org.eclipse.camf.infosystem.model.base.MonitoringProbe;
import org.eclipse.camf.infosystem.model.base.ResizingAction;
import org.eclipse.camf.infosystem.model.base.SecurityGroup;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor;
import org.eclipse.camf.infosystem.model.base.VirtualNetwork;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TRelationshipTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.features.AddApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.AddDirectedRelationFeature;
import org.eclipse.camf.tosca.editor.features.AddFlavorFeature;
import org.eclipse.camf.tosca.editor.features.AddGroupFeature;
import org.eclipse.camf.tosca.editor.features.AddKeyPairFeature;
import org.eclipse.camf.tosca.editor.features.AddMonitorProbeFeature;
import org.eclipse.camf.tosca.editor.features.AddNetworkFeature;
import org.eclipse.camf.tosca.editor.features.AddReadyToUseArtifactFeature;
import org.eclipse.camf.tosca.editor.features.AddResizingActionFeature;
import org.eclipse.camf.tosca.editor.features.AddSecurityGroupFeature;
import org.eclipse.camf.tosca.editor.features.AddServiceTemplateFeature;
import org.eclipse.camf.tosca.editor.features.AddSoftwareDependencyFeature;
import org.eclipse.camf.tosca.editor.features.AddUserApplicationFeature;
import org.eclipse.camf.tosca.editor.features.AddVirtualMachineFeature;
import org.eclipse.camf.tosca.editor.features.CreateApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.CreateDirectedRelationFeature;
import org.eclipse.camf.tosca.editor.features.CreateFlavorFeature;
import org.eclipse.camf.tosca.editor.features.CreateGroupFeature;
import org.eclipse.camf.tosca.editor.features.CreateKeyPairFeature;
import org.eclipse.camf.tosca.editor.features.CreateMonitorProbeFeature;
import org.eclipse.camf.tosca.editor.features.CreateNetworkFeature;
import org.eclipse.camf.tosca.editor.features.CreateResizeActionFeature;
import org.eclipse.camf.tosca.editor.features.CreateSecurityGroupFeature;
import org.eclipse.camf.tosca.editor.features.CreateServiceTemplateFeature;
import org.eclipse.camf.tosca.editor.features.CreateSoftwareDependencyFeature;
import org.eclipse.camf.tosca.editor.features.CreateUserApplicationFeature;
import org.eclipse.camf.tosca.editor.features.CreateVMIFeature;
import org.eclipse.camf.tosca.editor.features.DeleteApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.DeleteDeploymentArtifactFeature;
import org.eclipse.camf.tosca.editor.features.DeleteGroupFeature;
import org.eclipse.camf.tosca.editor.features.DirectEditApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.DirectEditCompositeComponentFeature;
import org.eclipse.camf.tosca.editor.features.LayoutApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.LayoutServiceTemplateFeature;
import org.eclipse.camf.tosca.editor.features.MoveApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.MoveCompositeComponentFeature;
import org.eclipse.camf.tosca.editor.features.RenameApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.RenameCompositeComponentFeature;
import org.eclipse.camf.tosca.editor.features.ResizeApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.ResizeCompositeComponentFeature;
import org.eclipse.camf.tosca.editor.features.UpdateApplicationComponentFeature;
import org.eclipse.camf.tosca.editor.features.UpdateCompositeComponentFeature;
import org.eclipse.camf.tosca.elasticity.NodePropertiesType;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

public class ToscaFeatureProvider extends DefaultFeatureProvider {

  public ToscaFeatureProvider( final IDiagramTypeProvider dtp ) {
    super( dtp );
  }

  // Returns the add feature for the context
  @Override
  public IAddFeature getAddFeature( final IAddContext context ) {
    if( context.getNewObject() instanceof TNodeTemplate ) {
    	//new AddApplicationComponentFeature( this );
    	return new AddReadyToUseArtifactFeature(this);
      //return new AddApplicationComponentFeature( this );
    }
    // else if( context.getNewObject() instanceof TRelationshipTemplate
    //               && ( ( TRelationshipTemplate )context.getNewObject() ).getType().toString().compareTo("Bidirected") == 0 ) //$NON-NLS-1$
    // {
    // return new AddBidirectionalRelationFeature( this );
    // }
    else if( context.getNewObject() instanceof TRelationshipTemplate ) {
      return new AddDirectedRelationFeature( this );
    } else if( context.getNewObject() instanceof TDeploymentArtifact ) {
      if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "UA" ) == 0 )
        return new AddUserApplicationFeature( this );
      else if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "SD" ) == 0 )
        return new AddSoftwareDependencyFeature( this );
      else if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "VMI" ) == 0 )
        return new AddVirtualMachineFeature( this );
      else if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "KeyPair" ) == 0 )
        return new AddKeyPairFeature( this );
      else if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "Network" ) == 0 )
        return new AddNetworkFeature( this );
      else if( ( ( TDeploymentArtifact )context.getNewObject() ).getArtifactType()
        .toString()
        .compareTo( "MonitoringProbe" ) == 0 )
        return new AddMonitorProbeFeature( this );
    } else if( context.getNewObject() instanceof ResourceCloudElement ) {
      return getIFileFeature( context );
    } else if( context.getNewObject() instanceof VirtualMachineImage ) {
      return new AddVirtualMachineFeature( this );
    } else if( context.getNewObject() instanceof KeyPair ) {
      return new AddKeyPairFeature( this );
    } else if( context.getNewObject() instanceof VirtualNetwork ) {
      return new AddNetworkFeature( this );
    } else if( context.getNewObject() instanceof ResizingAction ) {
      return new AddResizingActionFeature( this );
    } else if( context.getNewObject() instanceof VirtualMachineImageFlavor ) {
      return new AddFlavorFeature( this );
    } else if( context.getNewObject() instanceof SecurityGroup ) {
      return new AddSecurityGroupFeature( this );
    } else if( context.getNewObject() instanceof MonitoringProbe ) {
      return new AddMonitorProbeFeature( this );
    }
    // its a substitutional Service Template
    else if( context.getNewObject() instanceof TServiceTemplate
             && ( ( TServiceTemplate )context.getNewObject() ).getSubstitutableNodeType() != null )
    {
      return new AddGroupFeature( this );
    } else if( context.getNewObject() instanceof TServiceTemplate ) {
      return new AddServiceTemplateFeature( this );
    }
    return super.getAddFeature( context );
  }

  /**
   * @return
   */
  private AbstractAddShapeFeature getIFileFeature( final IAddContext context ) {
    ResourceCloudElement element = ( ResourceCloudElement )context.getNewObject();
    AbstractAddShapeFeature result = null;
    String extension = element.getResource().getFileExtension();
    TDeploymentArtifact deploymentArtifact = ToscaFactory.eINSTANCE.createTDeploymentArtifact();
    deploymentArtifact.setName( element.getName() );
    CreateContext createContext = new CreateContext();
    createContext.setTargetContainer( context.getTargetContainer() );
    if( extension.equals( "pub" ) ) { //$NON-NLS-1$
      // Call the Create User Application Feature to create a deployment
      // artifact for the deployment script and add it to the artifacts
      // list
      CreateKeyPairFeature createKPFeature = new CreateKeyPairFeature( new ToscaFeatureProvider( getDiagramTypeProvider() ) );
      deploymentArtifact.setArtifactType( new QName( "KeyPair" ) );
      createKPFeature.setContextObject( deploymentArtifact );
      if( createKPFeature.canCreate( createContext ) ) {
        createKPFeature.create( createContext );
      }
    } else if( extension.equals( "sh" ) ) {
      CreateSoftwareDependencyFeature createSDFeature = new CreateSoftwareDependencyFeature( new ToscaFeatureProvider( getDiagramTypeProvider() ) );
      deploymentArtifact.setName( element.getName() );
      deploymentArtifact.setArtifactType( new QName( "SD" ) );
      createSDFeature.setContextObject( deploymentArtifact );
      if( createSDFeature.canCreate( createContext ) ) {
        createSDFeature.create( createContext );
      }
    }
    return result;
  }

  // Initializes all create features
  @Override
  public ICreateFeature[] getCreateFeatures() {
    return new ICreateFeature[]{
      new CreateApplicationComponentFeature( this ),
      new CreateVMIFeature( this ),
      new CreateNetworkFeature( this ),
      new CreateSoftwareDependencyFeature( this ),
      new CreateMonitorProbeFeature( this ),
      new CreateFlavorFeature( this ),
      new CreateServiceTemplateFeature( this ),
      new CreateResizeActionFeature( this ),
      new CreateUserApplicationFeature( this ),
      new CreateGroupFeature( this ),
      new CreateKeyPairFeature( this ),
      new CreateSecurityGroupFeature( this )
    };
  }

  // Custom delete feature for application components and composite components
  @Override
  public IDeleteFeature getDeleteFeature( IDeleteContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    if( bo instanceof TServiceTemplate ) {
      // TServiceTemplate representing Composite Component
      return new DeleteGroupFeature( this );
    } else if( bo instanceof TNodeTemplate ) {
      return new DeleteApplicationComponentFeature( this );
    } else if( bo instanceof TDeploymentArtifact ) {
      return new DeleteDeploymentArtifactFeature( this );
    }
    return super.getDeleteFeature( context );
  }

  // Enables direct editing
  @Override
  public IDirectEditingFeature getDirectEditingFeature( final IDirectEditingContext context )
  {
    PictogramElement pe = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pe );
    if( bo instanceof TNodeTemplate ) {
      return new DirectEditApplicationComponentFeature( this );
    } else if( bo instanceof TServiceTemplate ) {
      return new DirectEditCompositeComponentFeature( this );
    }
    return super.getDirectEditingFeature( context );
  }

  // Returns layout features
  @Override
  public ILayoutFeature getLayoutFeature( final ILayoutContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    Object bo = getBusinessObjectForPictogramElement( pictogramElement );
    if( bo instanceof TNodeTemplate ) {
      return new LayoutApplicationComponentFeature( this );
    }
    if( bo instanceof TServiceTemplate ) {
      return new LayoutServiceTemplateFeature( this );
    }
    return super.getLayoutFeature( context );
  }

  // Enables update features
  @Override
  public IUpdateFeature getUpdateFeature( final IUpdateContext context ) {
    PictogramElement pictogramElement = context.getPictogramElement();
    if( pictogramElement instanceof ContainerShape ) {
      Object bo = getBusinessObjectForPictogramElement( pictogramElement );
      if( bo instanceof TNodeTemplate ) {
        return new UpdateApplicationComponentFeature( this );
      } else if( bo instanceof TServiceTemplate ) {
        return new UpdateCompositeComponentFeature( this );
      }
    }
    return super.getUpdateFeature( context );
  }

  // Enables moving of figures
  @Override
  public IMoveShapeFeature getMoveShapeFeature( final IMoveShapeContext context )
  {
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TNodeTemplate ) {
      return new MoveApplicationComponentFeature( this );
    }
    if( bo instanceof TServiceTemplate ) {
      return new MoveCompositeComponentFeature( this );
    }
    return super.getMoveShapeFeature( context );
  }

  // Feature for renaming application components
  @Override
  public ICustomFeature[] getCustomFeatures( ICustomContext context ) {
    return new ICustomFeature[]{
      new RenameApplicationComponentFeature( this ),
      new RenameCompositeComponentFeature( this ),
    };
  }

  // Initializes relationships' create features
  @Override
  public ICreateConnectionFeature[] getCreateConnectionFeatures() {
    return new ICreateConnectionFeature[]{
      new CreateDirectedRelationFeature( this )
    // ,
    // new CreateBidirectionalRelationFeature( this )
    };
  }

  @Override
  public IResizeShapeFeature getResizeShapeFeature( IResizeShapeContext context )
  {
    Shape shape = context.getShape();
    Object bo = getBusinessObjectForPictogramElement( shape );
    if( bo instanceof TNodeTemplate ) {
      return new ResizeApplicationComponentFeature( this );
    }
    if( bo instanceof TServiceTemplate ) {
      return new ResizeCompositeComponentFeature( this );
    }
    return super.getResizeShapeFeature( context );
  }
}
