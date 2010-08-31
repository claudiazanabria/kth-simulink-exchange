package se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;
import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.SimulinkFactory;
import Simulink.System;
import Simulink.SystemReference;

public class NameTraverserDelegateTest {

	private static final String NAME = "Charly";
	private static final String SYSREF_NAME = "Pelle";
	private static final String FILENAME = "Charly.mdl";
	
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
	
	@Test
	public void findSysRefWhosTargetIsGivenSystemPositiveTest() {
		SystemReference sysRef = factory.createSystemReference();
		System targetSystem = factory.createSystem();
		sysRef.setTarget(targetSystem);
		rootSystem.getChildren().add( sysRef );
		SystemReference result = traverser.findSysRefWhosTargetIsGivenSystem(rootSystem, targetSystem);
		assertEquals(sysRef, result);
	}

	@Test
	public void findSysRefWhosTargetIsGivenSystemNegativeest() {
		SystemReference sysRef = factory.createSystemReference();
		System anotherSystem = factory.createSystem();
		System targetSystem = factory.createSystem();
		sysRef.setTarget(targetSystem);
		rootSystem.getChildren().add( sysRef );
		SystemReference result = traverser.findSysRefWhosTargetIsGivenSystem(rootSystem, anotherSystem);
		assertNull( result );
	}

	@Test
	public void processPortWithSameParentTest() {
		// TODO refactor this with our own model creation wrapper
		System sysA = factory.createSystem();
		SystemReference sysRefA = factory.createSystemReference();
		sysRefA.setTarget(sysA);
		rootSystem.getChildren().add(sysRefA);
		Outport srcPort = factory.createOutport();
		sysA.getOutports().add( srcPort );
		Outport dstPort = factory.createOutport();
		dstPort.setName(NAME);
		rootSystem.getOutports().add( dstPort );
		Line line = factory.createLine();
		rootSystem.getLines().add(line);
		line.setSource(srcPort);
		line.setDestination(dstPort);
		
		String result = traverser.computeNameForLineEndpoint(line, dstPort);
		assertEquals(NAME+"/1", result);
	}

	@Test
	public void processPortWithDifferentParentTest() {
		System sysA = factory.createSystem();
		SystemReference sysRefA = factory.createSystemReference();
		sysRefA.setTarget(sysA);
		sysRefA.setName(SYSREF_NAME);
		rootSystem.getChildren().add(sysRefA);
		Outport srcPort = factory.createOutport();
		sysA.getOutports().add( srcPort );
		Outport dstPort = factory.createOutport();
		srcPort.setName(NAME);
		rootSystem.getOutports().add( dstPort );
		Line line = factory.createLine();
		rootSystem.getLines().add(line);
		line.setSource(srcPort);
		line.setDestination(dstPort);
		
		String result = traverser.computeNameForLineEndpoint(line, srcPort);
		assertEquals(SYSREF_NAME+"/1", result);
	}

}
