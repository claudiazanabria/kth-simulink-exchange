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
import org.junit.Before;
import org.junit.BeforeClass;

import se.kth.md.simulinkExchange.management.ModelManagerTest;
import se.kth.md.simulinkExchange.management.exceptions.InvalidURIException;

/**
 * Test cases for EastModelManager.
 * @author Alex Schenkman
 *
 */
public class EastModelManagerTest extends ModelManagerTest {

	
	@BeforeClass
	static public void init() {
		ePkgName 		= "eastadl";
		fileExtension 	= "uml";
		modelPath 		= "resources/testFiles/Empty_model.uml";
		deleteMe 		= "resources/testFiles/deleteMe.simulink";
		model 			= URI.createFileURI(modelPath);				
	}
	
	@Before
	public void setUp() throws InvalidURIException {
		modelManager = new EastModelManager(model);
	}


}
