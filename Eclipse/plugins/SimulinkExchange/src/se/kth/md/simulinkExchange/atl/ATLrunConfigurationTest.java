/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

/**
 * 
 */
package se.kth.md.simulinkExchange.atl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * We test a configuration for a transformation from east to simulink,
 * with two meta-models as input and one as output.
 * 
 * This test should be run as JUnit Plug-in Test, because it need an initialized EMF registry.
 * @author Alex Schenkman
 *
 */
public class ATLrunConfigurationTest {
		
	private final URI umlModel      = URI.createFileURI("./Resources/testing/demo.uml");
	private final URI simulinkModel = URI.createFileURI("./Resources/testing/demo.simulink");	
	private final URI atlSource 	= URI.createFileURI("./Resources/testing/east2simulink.atl");
	private final URI atlCompiled 	= URI.createFileURI("./Resources/testing/east2simulink.asm");
	private final URI wrongURI 		= URI.createURI("thisShouldFail");
	
	private ATLrunConfiguration config = null;
	
	@Before 
	public void setUp() {
		config = new ATLrunConfiguration( atlSource, atlCompiled );
	}
	
	@After
    public void tearDown() {
        config = null;
    }	

	
	@Test
	public void testConfigurationIsComplete() throws URInotFound {
		addSources();
		assertFalse( config.isComplete() );
		addDestination();
		assertTrue( config.isComplete() );
	}

	private void addDestination() throws URInotFound {
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	private void addSources() throws URInotFound {
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
	}
	
	@Test
	public void testPathMap() throws URInotFound {
		addSources();
		addDestination();
		Map<String, String> pMap = config.getPathsMap();
		assertEquals(ATLrunConfiguration.umlMetaModel.toString(), pMap.get("UML"));
		assertEquals(ATLrunConfiguration.simulinkMetaModel.toString(), pMap.get("SIM"));
		assertEquals(umlModel.toString(), pMap.get("IN1"));
		assertEquals(umlModel.toString(), pMap.get("IN2"));
		assertEquals(simulinkModel.toString(), pMap.get("OUT1"));
	}
	
	// @see ModelTowerListTest.java
	// modelID -> metamodelID
	@Test
	public void testInModelsIDMap() throws URInotFound {
		addSources();
		addDestination();
		Map<String, String> modelsIDs = config.getInModelsIDMap();
		assertEquals("UML", modelsIDs.get("IN1"));
		assertEquals("EST", modelsIDs.get("IN2"));
	}

	// @see ModelTowerListTest.java
	// modelID -> metamodelID
	@Test
	public void testOutModelsIDMap() throws URInotFound {
		addSources();
		addDestination();
		Map<String, String> modelsIDs = config.getOutModelsIDMap();
		assertEquals("SIM", modelsIDs.get("OUT1"));
	}

	@Test
	public void testInOutModelsIDMap() throws URInotFound {
		assertTrue( config.getInOutModelsIDMap().isEmpty() );
	}
	
	/**
	 * Error cases
	 * @throws URInotFound 
	 */
	
	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testWrongSourceMetaModel() throws URInotFound {
		config.addSource(simulinkModel, wrongURI);
	}

	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testWrongSourceModel() throws URInotFound {
		config.addSource(wrongURI, ATLrunConfiguration.simulinkMetaModel);
	}

	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testWrongDestMetaModel() throws URInotFound {
		config.addDestination(simulinkModel, wrongURI);
	}

	@Test(expected=se.kth.md.simulinkExchange.atl.URInotFound.class)
	public void testWrongDestModel() throws URInotFound {
		config.addDestination(wrongURI, ATLrunConfiguration.simulinkMetaModel);
	}

}
