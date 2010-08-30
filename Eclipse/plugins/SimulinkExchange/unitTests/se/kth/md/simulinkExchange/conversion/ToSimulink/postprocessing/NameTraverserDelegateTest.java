package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import Simulink.Inport;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.SimulinkFactory;
import Simulink.System;

public class NameTraverserDelegateTest {

	private static final String NAME = "Charly";
	private static final String FILENAME = "Charly.mdl";
	
/*	Mockery context 		= new JUnit4Mockery();
	Model	modelMock	= context.mock(Model.class);
	System  systemMock  = context.mock(System.class);
	SystemReference systemReferenceMock = context.mock(SystemReference.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	Line lineMock = context.mock(Line.class);
	
	Sequence aSequence 	= context.sequence("aSequence");
*/
	SimulinkModelManager manager = new SimulinkModelManager();
	SimulinkFactory factory = manager.getFactory();

	NameTraverserDelegate traverser;
	Model theModel;
	System rootSystem;
	Inport inport;
	Outport outport;

	
	@Before
	public void setUp() {
		traverser = new NameTraverserDelegate();
		theModel = factory.createModel();
		theModel.setName(NAME);
		rootSystem = factory.createSystem();
		inport 	= factory.createInport();
		outport = factory.createOutport();

	}
	
	
	@Test
	public void setRootSystemNameSameAsModelTest() {

		rootSystem.setName("this should be overwritten");
		theModel.setRoot(rootSystem);

		traverser.setRootSystemNameSameAsModel(theModel);
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
		assertEquals(FILENAME,rootSystem.getFilename());
		assertFalse(FILENAME.equals(rootSystem.getSimulinkName()));
	}
	
	@Test
	public void enclosingSimulinkNameTest() {
		final String simulinkName = NAME + '/' + rootSystem.getName();
		traverser.computeEnclosingSimulinkName(rootSystem, NAME);
		assertEquals(rootSystem.getSimulinkName(), simulinkName);
	}
	
	@Test
	public void addTypeSuffixBecauseMissingTest() {
		final String suffix = "something";
		inport = factory.createInport();
		inport.setName(NAME);
		traverser.addTypeSuffixIfNeeded(inport, suffix);
		assertEquals(NAME+suffix, inport.getName());
	}

	@Test
	public void dontAddTypeSuffixBecausePresentTest() {
		final String suffix = "something";
		inport = factory.createInport();
		inport.setName(NAME+suffix);
		traverser.addTypeSuffixIfNeeded(inport, suffix);
		assertEquals(NAME+suffix, inport.getName());
	}

	@Test
	public void getParentOnPortHackTest() {
		rootSystem.getInports().add(inport);
		rootSystem.getOutports().add(outport);
		Port port = inport;
		assertEquals(rootSystem, port.getParent());
		port = outport;
		assertEquals(rootSystem, port.getParent());
	}
	
	@Test
	public void findPositionWithinSystemTest() {
		rootSystem.getInports().add(inport);
		rootSystem.getOutports().add(outport);
		Inport inport2 = factory.createInport();
		rootSystem.getInports().add( inport2 );
		assertEquals(new Integer(2),traverser.findPositionWithinSystem(rootSystem, inport2));
		assertEquals(new Integer(1),traverser.findPositionWithinSystem(rootSystem, outport));
	}
	
	@Test
	public void positionWithinSystemNotFoundShouldReturnZeroTest() {
		assertEquals(new Integer(0),traverser.findPositionWithinSystem(rootSystem, inport));
	}

}
