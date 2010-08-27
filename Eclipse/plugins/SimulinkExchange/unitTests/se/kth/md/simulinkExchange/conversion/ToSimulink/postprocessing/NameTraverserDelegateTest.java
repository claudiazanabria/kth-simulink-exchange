package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;


import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.SimulinkFactory;
import Simulink.SimulinkPackage;
import Simulink.System;
import Simulink.SystemReference;

@RunWith(JMock.class)
public class NameTraverserDelegateTest {

	private static final String NAME = "Charly";
	private static final String FILENAME = "Charly.mdl";
	
	Mockery context 		= new JUnit4Mockery();
	Model	modelMock	= context.mock(Model.class);
	System  systemMock  = context.mock(System.class);
	SystemReference systemReferenceMock = context.mock(SystemReference.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	Line lineMock = context.mock(Line.class);
	
	Sequence aSequence 	= context.sequence("aSequence");

	SimulinkModelManager manager = new SimulinkModelManager();
	SimulinkFactory factory = manager.getFactory();

	NameTraverserDelegate traverser;
	Model theModel;
	System rootSystem;

	
	@Before
	public void setUp() {
		traverser = new NameTraverserDelegate();
		theModel = factory.createModel();
		theModel.setName(NAME);
		rootSystem = factory.createSystem();
	}
	
	
	@Test
	public void setRootSystemNameSameAsModelTest() {

		rootSystem.setName("this should be overwritten");
		theModel.setRoot(rootSystem);

		traverser.setRootSystemNameSameAsModel(modelMock);
		assertEquals(rootSystem.getName(),NAME);
	}
	
	@Test
	public void computeGenericSimulinkNameTest() {
		assertFalse(NAME.equals(theModel.getSimulinkName()));
		traverser.computeGenericSimulinkName( theModel );
		assertEquals( theModel.getSimulinkName(), NAME );
	}
	
	@Test
	public void fileNameShouldBeNamePlusExtensionTest() {
		rootSystem.setName(NAME);
		assertFalse(FILENAME.equals(rootSystem.getFilename()));
		traverser.computeSystemFileName(rootSystem);
		assertEquals(rootSystem.getFilename(),FILENAME);
		assertFalse(rootSystem.getSimulinkName().equals(FILENAME));
	}
	
	//TODO computeEnclosingSimulinkNameTest

}
