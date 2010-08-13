/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.atl;


import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATLrunnerTest {

	protected ATLrunConfiguration config;
	protected ATLrunner runner;

	private final URI umlModel      = URI.createFileURI("./Resources/testing/demo.uml");
	private final URI simulinkModel = URI.createFileURI("./Resources/testing/deleteme.simulink");
	
	private final URI atlSource 	= URI.createFileURI("./Resources/testing/east2simulink.atl");
	private final URI atlCompiled 	= URI.createFileURI("./Resources/testing/east2simulink.asm");
	
	@Before
	public void setUp() throws Exception {
		config = new ATLrunConfiguration( atlSource, atlCompiled );
		runner = new ATLrunner();		
	}

	@After
	public void tearDown() {
		config = null;
		runner = null;
	}

	@Test
	public void testRunWith() throws NullPointerException, ATLCoreException, URInotFound, IOException {
		
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);

		runner.runWith( config );		
	}
}
