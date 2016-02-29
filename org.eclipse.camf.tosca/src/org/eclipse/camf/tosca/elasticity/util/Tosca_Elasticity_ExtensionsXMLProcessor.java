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
 * 	Stalo Sofokleous - initial API and implementation
 * 	Nicholas Loulloudes - implementation extensions
 *******************************************************************************/
/**
 */
package org.eclipse.camf.tosca.elasticity.util;

import java.util.Map;

import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Tosca_Elasticity_ExtensionsXMLProcessor extends XMLProcessor
{

  /**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Tosca_Elasticity_ExtensionsXMLProcessor()
  {
		super((EPackage.Registry.INSTANCE));
		Tosca_Elasticity_ExtensionsPackage.eINSTANCE.eClass();
	}
  
  /**
	 * Register for "*" and "xml" file extensions the Tosca_Elasticity_ExtensionsResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new Tosca_Elasticity_ExtensionsResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new Tosca_Elasticity_ExtensionsResourceFactoryImpl());
		}
		return registrations;
	}

} //Tosca_Elasticity_ExtensionsXMLProcessor
