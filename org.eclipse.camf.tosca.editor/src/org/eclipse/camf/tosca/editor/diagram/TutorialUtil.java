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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.camf.tosca.util.ToscaResourceFactoryImpl;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class TutorialUtil {

	public static Collection<Diagram> getDiagrams(IProject p) {
		final List<IFile> files = getDiagramFiles(p);
		final List<Diagram> diagramList = new ArrayList<Diagram>();
		final ResourceSet rSet = new ResourceSetImpl();
		for (final IFile file : files) {
			final Diagram diagram = getDiagramFromFile(file, rSet);
			if (diagram != null) {
				diagramList.add(diagram);
			}
		}
		return diagramList;
	}

  public static void saveToModelFile( final EObject obj, final Diagram d )
    throws CoreException, IOException
  {
    URI uri = d.eResource().getURI();
    uri = uri.trimFragment();
    uri = uri.trimFileExtension();
    uri = uri.appendFileExtension( "tosca" ); //$NON-NLS-1$
    ResourceSet resourceSet = d.eResource().getResourceSet();
    final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
      .getRoot();
    IResource file = workspaceRoot.findMember( uri.toPlatformString( true ) );
    if( file == null || !file.exists() ) {
      Registry factoryRegistry = resourceSet.getResourceFactoryRegistry();
      Map<String, Object> map = factoryRegistry.getExtensionToFactoryMap();
      map.put( "tosca", new ToscaResourceFactoryImpl() ); //$NON-NLS-1$
      Resource resource = resourceSet.createResource( uri );
      
      if( obj != null ) {        
        resource.getContents().add( obj );
      }
      
      // Setting XML encoding.. This could be changed later.
      Map<String, String> options = new HashMap<String, String>();
      options.put( XMLResource.OPTION_ENCODING, "UTF-8" ); //$NON-NLS-1$
      try {
        resource.save( options );
        resource.setTrackingModification( true );
      } catch( IOException ioEx ) {
        ioEx.printStackTrace();
      }
    }

    // ResourceSet rSet = d.eResource().getResourceSet();
    // final IWorkspaceRoot workspaceRoot =
    // ResourcesPlugin.getWorkspace().getRoot();
    // IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
    // if (file == null || !file.exists()) {
    // Resource createResource = rSet.createResource(uri);
    // createResource.save(Collections.emptyMap());
    // createResource.setTrackingModification(true);
    // }
    // final Resource resource = rSet.getResource(uri, true);
    // resource.getContents().add(obj);
  }

	private static List<IFile> getDiagramFiles(IContainer folder) {
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members();
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					ret.addAll(getDiagramFiles((IContainer) resource));
				} else if (resource instanceof IFile) {
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) { //$NON-NLS-1$
						ret.add(file);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private static Diagram getDiagramFromFile(IFile file, ResourceSet resourceSet) {
		// Get the URI of the model file.
		final URI resourceURI = getFileURI(file, resourceSet);

		// Demand load the resource for this file.
		Resource resource;
		try {
			resource = resourceSet.getResource(resourceURI, true);
			if (resource != null) {
				// does resource contain a diagram as root object?
				final EList<EObject> contents = resource.getContents();
				for (final EObject object : contents) {
					if (object instanceof Diagram) {
						return (Diagram) object;
					}
				}
			}
		} catch (final WrappedException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static URI getFileURI(IFile file, ResourceSet resourceSet) {
		final String pathName = file.getFullPath().toString();
		URI resourceURI = URI.createFileURI(pathName);
		resourceURI = resourceSet.getURIConverter().normalize(resourceURI);
		return resourceURI;
	}

}
