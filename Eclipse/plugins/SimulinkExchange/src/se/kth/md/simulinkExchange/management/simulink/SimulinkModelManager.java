/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.management.simulink;


import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import se.kth.md.management.ModelManager;

import Simulink.SimulinkFactory;
import Simulink.SimulinkPackage;

/**
 * A ModelManager that can handle simulink-ecore models.
 * @author Alex Schenkman
 */
public class SimulinkModelManager extends ModelManager {
	/**
	 * Adds the metamodel the the global EMF registry and initializes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = SimulinkPackage.eINSTANCE;
	}

	/**
	 * @return the factory for this metamodel.
	 */	
	@Override
	public SimulinkFactory getFactory() {
		return (SimulinkFactory) super.getFactory();
	}
	
	/**
	 * Opens an empty simulink-ecore model named: "unnamed.simulink".
	 * Relies on SimulinkModelManager(String modelPath).
	 */
	public SimulinkModelManager() { 
		this( "unnamed.simulink" ); 
	}

	/**
	 * Opens a simulink-ecore model from file.
	 * @param modelPath
	 */	
	public SimulinkModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}

	/**
	 * Opens a simulink-ecore %model from the given model.
	 * @param model
	 */	
	public SimulinkModelManager(URI model) {
		super( model );
		setFileExtension("simulink");
		init( model );
	}
	
	@Test
	public void testReplacExtension() {
		SimulinkModelManager smm = new SimulinkModelManager();
		String newPath = smm.replaceExtension("test.txt", "zzz");
		assertTrue(newPath.equalsIgnoreCase("test.zzz"));
	}
	
}
