/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.management.east;


import org.eclipse.emf.common.util.URI;

import se.kth.md.model.management.ModelManager;

import com.cea.papyrus.uml4eastadl.eastadl.EastadlFactory;
import com.cea.papyrus.uml4eastadl.eastadl.EastadlPackage;

/**
 * A ModelManager that can handle EAST-ADL models.
 * @author Alex Schenkman
 */
public class EastModelManager  extends ModelManager {
	/**
	 * Adds the metamodel the the global EMF registry and initializes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = EastadlPackage.eINSTANCE;
	}

	/**
	 * @return the factory for this metamodel.
	 */
	@Override
	public EastadlFactory getFactory() {
		return (EastadlFactory) super.getFactory();
	}

	/**
	 * Opens an empty EAST-ADL model named: "unnamed.uml".
	 * Relies on EastModelManager(String modelPath).
	 */
	public EastModelManager() { 
		this( "unnamed.uml" ); 
	}
	
	/**
	 * Opens an EAST-ADL model from file.
	 * @param modelPath
	 */
	public EastModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	/**
	 * Opens an EAST-ADL model from the given URI
	 * @param model 
	 */
	public EastModelManager(URI model) {
		super( model );
		setFileExtension("uml");
		init( model );
	}
}
