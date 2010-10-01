package se.kth.md.simulinkExchange.integrationTests;


import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.model.management.IModelManager;
import se.kth.md.model.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.PluginServices;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import se.kth.md.simulinkExchange.popup.actions.ToSimulink.Dispatcher;


@RunWith(JMock.class)
public class ToSimulinkEcoreTest {	
	
	final String PATH_TO_FILE = "resources/testFiles/Eclipse2Matlab/Case1.uml";
	IPath fileName;
	Dispatcher dispatcher;
	
	Mockery context = new JUnit4Mockery();
	IAction actionMock = context.mock(IAction.class);
	
	@Before
	public void setUp(){
		URI uri = PluginServices.lookUpAbsolutePathWithinPlugin(PATH_TO_FILE);
		fileName = new Path(uri.toFileString());
		dispatcher = Dispatcher.forTestingWithFile(fileName);
	}
	
	@Test
	public void testGeneratedModelIsCorrect() throws InvalidModelException{
		dispatcher.run(actionMock);
		
		String generatedFileName = FilenameUtils.removeExtension(fileName.toOSString()) + ".simulink";
		IModelManager modelManager = new SimulinkModelManager(generatedFileName);
		modelManager.loadIt();
		modelManager.validateIt();
		
		//TODO: we should manually check that all elements were converted.
	}

}
