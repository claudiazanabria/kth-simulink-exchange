package se.kth.md.simulinkExchange.atl;


import java.io.FileNotFoundException;

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
	
	@Before
	public void setUp() throws Exception {
		config = new ATLrunConfiguration( atlSource );
		runner = new ATLrunner();		
	}

	@After
	public void tearDown() {
		config = null;
		runner = null;
	}

	@Test
	public void testRunWith() throws NullPointerException, FileNotFoundException, 
									ATLCoreException, URInotFound {
		
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);

		runner.runWith( config );		
	}
}
