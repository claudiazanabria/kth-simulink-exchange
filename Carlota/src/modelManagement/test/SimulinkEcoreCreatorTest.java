package modelManagement.test;

import static org.junit.Assert.*;
import modelManagement.simulink.SimulinkEcoreCreator;
import modelManagement.simulink.SimulinkModelManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.SimulinkFactory;
import Simulink.System;
import Simulink.SystemReference;
import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

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
	public void testFindPorts(System aSystem) {
		Outport out = simulinkEcoreCreator.findOutportWithin("A1", aSystem);
		assertNotNull(out);
		assertTrue(out.getName().equalsIgnoreCase("A1"));
		Inport in = simulinkEcoreCreator.findInportWithin("B1", aSystem);
		assertNotNull(in);
		assertTrue(in.getName().equalsIgnoreCase("B1"));
		in = simulinkEcoreCreator.findInportWithin("xxx", aSystem);
		assertNull(in);
	}
}
