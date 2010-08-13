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

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.BeforeClass;

import se.kth.md.simulinkExchange.management.ModelManagerTest;
import se.kth.md.simulinkExchange.management.exceptions.InvalidURIException;

public class SimulinkModelManagerTest extends ModelManagerTest {

	
	@BeforeClass
	static public void init() {
		ePkgName 		= "Simulink";
		fileExtension 	= "simulink";
		modelPath 		= "resources/testFiles/demo.simulink";
		deleteMe 		= "resources/testFiles/deleteMe.simulink";
		model 			= URI.createFileURI(modelPath);				
	}
	
	@Before
	public void setUp() throws InvalidURIException {
		modelManager = new SimulinkModelManager(model);
	}

}
