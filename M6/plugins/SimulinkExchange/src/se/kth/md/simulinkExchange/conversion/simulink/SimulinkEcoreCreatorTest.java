package se.kth.md.simulinkExchange.conversion.simulink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.UUID;


import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.simulinkExchange.conversion.exceptions.PortNotFoundException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.SimulinkFactory;
import Simulink.System;
import Simulink.SystemReference;
import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

/**
 * Test cases for SimulinkEcoreCreator.
 * @author Alex Schenkman
 *
 */
@RunWith(JExample.class)
public class SimulinkEcoreCreatorTest {

	private SimulinkModelManager modelManager;
	private SimulinkEcoreCreator simulinkEcoreCreator;

	@Test
	public void testSimulinkEcoreCreator() {
		modelManager = new SimulinkModelManager("test.simulink");
		SimulinkFactory factory = modelManager.getFactory();
		simulinkEcoreCreator = new SimulinkEcoreCreator( factory );
		assertNotNull(simulinkEcoreCreator);
	}

	@Test
	@Given("#testSimulinkEcoreCreator")
	public Model testNewModel() {
		Model aModel = simulinkEcoreCreator.newModel("Pepito");
		assertSame(aModel, simulinkEcoreCreator.getTopElement() );
		return aModel;
	}

	@Test
	@Given("#testNewModel")
	public System testRootSystem(Model aModel) {
		System rootSystem = simulinkEcoreCreator.addRootSystem("TheRootSystem");
		assertSame(rootSystem, aModel.getRoot());
		return rootSystem;
	}

	@Test
	@Given("#testRootSystem(Simulink.Model)")
	public System testFindSystem(System rootSystem) {
		System aSystem = simulinkEcoreCreator.findSystem(rootSystem.getName());
		assertSame(rootSystem, aSystem);
		return rootSystem;
	}

	@Test
	@Given("#testFindSystem(Simulink.System)")
	public System testChild(System rootSystem) {
		System aSystem = simulinkEcoreCreator.addSystem("F1",rootSystem);
		assert(rootSystem.getChildren().size() == 1);
		assertSame(aSystem, rootSystem.getChildren().get(0).getTarget());
		return aSystem;
	}

	@Test
	@Given("#testChild(Simulink.System)")
	public System testReferences(System aSystem) {
		System child = simulinkEcoreCreator.addSystem("F11", aSystem);
		SystemReference reference = aSystem.getChildren().get(0);
		assertSame(child, simulinkEcoreCreator.findSystem("F11"));
		assertSame(child, reference.getTarget());
		return aSystem;
	}

	@Test
	@Given("#testReferences(Simulink.System)")
	public System testSystemContainment(System aSystem) {
		Model model  = simulinkEcoreCreator.getTopElement();
		Integer definedSystems = model.getParts().size();
		System root = model.getRoot();
		simulinkEcoreCreator.addSystem("F11", root);
		assertTrue(definedSystems == model.getParts().size() );
		return aSystem;
	}
	
	@Test
	@Given("#testSystemContainment(Simulink.System)")
	public System testPorts(System aSystem) {
		Inport inport1 = simulinkEcoreCreator.addInPort("P1In", aSystem);
		Inport inport2 = simulinkEcoreCreator.addInPort("P2In", aSystem);
		Outport outport1 = simulinkEcoreCreator.addOutPort("P1Out", aSystem);
		assertNotNull(inport1);
		assertNotNull(outport1);
		assert(aSystem.getInports().size() == 2);
		assert(aSystem.getOutports().size() == 1);
		assertTrue("P1In".equalsIgnoreCase(aSystem.getInports().get(0).getName()));
		assertSame(inport2.getParent(), aSystem);
		return aSystem;
	}

	@Test
	@Given("#testPorts(Simulink.System)")
	public System testLines(System parent) {
		System sysA = simulinkEcoreCreator.addSystem("SysA", parent);
		System sysB = simulinkEcoreCreator.addSystem("SysB", parent);
		Outport src = simulinkEcoreCreator.addOutPort("A1", sysA);
		Inport dst = simulinkEcoreCreator.addInPort("B1", sysB);

		Line lineA1B1 = simulinkEcoreCreator.addLine("A1B1",src,dst,parent);
		assertNotNull( lineA1B1 );
		assertTrue( parent.getLines().size() == 1);
		assertSame(lineA1B1, parent.getLines().get(0));
		return parent;
	}

	@Test
	@Given("#testLines(Simulink.System)")
	public System testFindPorts(System parent) {
		Outport out = SimulinkEcoreCreator.findOutportWithin("A1", parent);
		assertNotNull(out);
		assertTrue(out.getName().equalsIgnoreCase("A1"));
		Port p = SimulinkEcoreCreator.findPortWithin("A1", parent);
		assertEquals(p, out);
		p = SimulinkEcoreCreator.findOutportWithin("xxx", parent);
		assertNull( p );
		Inport in = SimulinkEcoreCreator.findInportWithin("B1", parent);
		assertNotNull(in);
		assertTrue(in.getName().equalsIgnoreCase("B1"));
		in = SimulinkEcoreCreator.findInportWithin("xxx", parent);
		assertNull(in);
		return parent;
	}
	
	@Test
	@Given("#testFindPorts(Simulink.System)") 
	public System testAddLines(System parent) {
		// Create two new ports
		System sysA = simulinkEcoreCreator.findSystem("SysA");
		System sysB = simulinkEcoreCreator.findSystem("SysB");
		Outport a2 	= simulinkEcoreCreator.addOutPort("A2", sysA);
		Inport b2 	= simulinkEcoreCreator.addInPort("B2", sysB);
		Inport p2   = simulinkEcoreCreator.addInPort("P2", parent);
		// Create two lines in between them
		LineInfo line1 = new LineInfo( parent );
		line1.setName("A2B2");
		line1.setSrcPort( a2.getUuid() );
		line1.setDstPort( b2.getUuid() );
		LineInfo line2 = new LineInfo( parent );
		line2.setName("P2B2");
		line2.setSrcPort( p2.getUuid() );
		line2.setDstPort( b2.getUuid() );
		ArrayList<LineInfo> list = LineInfo.createArray();
		list.add(line1);
		list.add(line2);
		try {
			simulinkEcoreCreator.addLines( list );
		} catch (PortNotFoundException e) { fail(); }
		Boolean foundA2B2 = false;
		Boolean foundP2B2 = false;
		for (Line line : parent.getLines()) {
			if (line.getName().equalsIgnoreCase("A2B2")) {
				assertEquals(a2, line.getSource());
				assertEquals(b2, line.getDestination());
				foundA2B2 = true;
			} else if (line.getName().equalsIgnoreCase("P2B2")) {
				assertEquals(p2, line.getSource());
				assertEquals(b2, line.getDestination());				
				foundP2B2 = true;
			}
		}
		assertTrue( foundA2B2 );
		assertTrue( foundP2B2 );
		return parent;
	}

	@Test
	@Given("#testAddLines(Simulink.System)") 
	public System testPortNotFound(System parent) {
		return parent;
	}

/*	@Test
	@Given("#testAddLines(Simulink.System)") 
	public System testPortNotFound(System parent) {
		LineInfo line1 = new LineInfo( parent );
		line1.setName("aLine");
		line1.setSrcPort( UUID.randomUUID() );
		line1.setDstPort( UUID.randomUUID() );
		try {
			line1.getDestination();
		} catch (PortNotFoundException e){};
		
		try {
			line1.getSource();
		} catch (PortNotFoundException e){
			return parent;
		};
		
		fail();
		return parent;
	}
*/	
	@Test
	@Given("#testPortNotFound(Simulink.System)")
	public System testAddSystemWithPList(System parent) {
		PropertyList pList = new PropertyList("ale", parent, "alex");
		SystemReference sysRef = simulinkEcoreCreator.addSystem( pList );
		assertEquals(sysRef, simulinkEcoreCreator.findSystemReference(UUID.fromString(sysRef.getUuid())));
		System sys = sysRef.getTarget();
		assertTrue(sys.getName().equalsIgnoreCase("ale"));		
		return parent;
	}

	@Test
	@Given("#testAddSystemWithPList(Simulink.System)")
	public System testFindInRepository(System parent) {
		System sysA = simulinkEcoreCreator.findSystem("SysA");
		UUID uuid = UUID.fromString( sysA.getUuid() );
		assertEquals(simulinkEcoreCreator.findSystem(uuid), sysA);
		Port port = sysA.getOutports().get(0);
		uuid = UUID.fromString(port.getUuid());
		assertEquals(simulinkEcoreCreator.findPort(uuid), port);
		Line line = parent.getLines().get(0);
		uuid = UUID.fromString(line.getUuid());
		assertEquals(simulinkEcoreCreator.findLine(uuid), line);		
		return parent;
	}	
}
