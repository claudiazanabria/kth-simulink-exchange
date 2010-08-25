/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.management;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.management.exceptions.InvalidURIException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

import Simulink.Model;
import Simulink.SimulinkFactory;


/**
 * Test cases for ModelManager.
 * @author Alex Schenkman
 */
public abstract class ModelManagerTest {
	
	static protected String ePkgName;
	static protected String fileExtension;
	static protected String modelPath;
	static protected String deleteMe;
	static protected URI model;
	
	protected IModelManager modelManager;
	
	@Before
	public abstract void setUp() throws InvalidURIException;
	
	@After
	public void tearDown() {
		modelManager = null;
	}
	
	@Test
	public void testExtension() {
		assertTrue(modelManager.getFileExtension().equalsIgnoreCase( fileExtension ));
	}

	@Test
	public void testMetaModelRegistration() {		
		String nsURI = modelManager.getNsURI();
		Registry globalRegistry = EPackage.Registry.INSTANCE; 
		EPackage ePkg = globalRegistry.getEPackage( nsURI );

		// This asserts that the package has been registered
		// to the global EMF registry, in standalone mode.
		assertTrue(ePkg.getName().equalsIgnoreCase( ePkgName ));
	}
	
	@Test
	public void testLoadIt() throws InvalidModelException {
		modelManager.loadIt();
	}

	@Test
	public void testValidateIt() {
		try {
			modelManager.loadIt();
			modelManager.validateIt();
		}
		catch (InvalidModelException e) {
			java.lang.System.out.println( e.getMessage() );
			fail("Invalid Model, see stdout for details.");
		}
	}
	
	@Test
	public void testGetTopElement() throws InvalidModelException {
		modelManager.loadIt();
		EObject top = modelManager.getTopElement();
		assertNotNull(top);
		assertTrue(top.eClass().getName().equalsIgnoreCase("Model"));
	}	
	
	@Test
	public void testNewModel() throws InvalidModelException {
		this.createFile_deleteMe_WithAmodelNamed("Testy");
		Model newModel = this.loadItandGetModelElement();
		assertTrue( newModel.getName().equalsIgnoreCase("Testy"));
	}

	protected Model loadItandGetModelElement() throws InvalidModelException {
		SimulinkModelManager aManager = new SimulinkModelManager(deleteMe);
		aManager.loadIt();
		Model newModel = (Model) aManager.getTopElement();
		return newModel;
	}
	
	protected void createFile_deleteMe_WithAmodelNamed(String modelName) {
		SimulinkModelManager newModel = new SimulinkModelManager(deleteMe);
		SimulinkFactory factory = newModel.getFactory();
		Model model = factory.createModel();
		model.setName("Testy");
		newModel.setTopElement( model );
		try {
			newModel.saveIt();
		} catch (Exception e) {
			e.printStackTrace();
			fail(String.format("Could not save to file: %s", deleteMe));
		}		
	}
}
