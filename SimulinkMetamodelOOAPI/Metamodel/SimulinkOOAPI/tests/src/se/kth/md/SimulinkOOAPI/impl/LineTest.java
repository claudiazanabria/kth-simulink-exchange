package se.kth.md.SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.System;

@RunWith(JMock.class)
public class LineTest {
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	System systemMock = context.mock(System.class);	
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	@SuppressWarnings("unchecked")	
	SimulinkList<Line> listMock = context.mock(SimulinkList.class);	
    Line line;	
	
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new LineImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/
	
	
	@Test
	public void testIfLineAddToList() throws Exception {		
		context.checking(new Expectations() {{		
			one (listMock).add(with(any(Line.class)));
			
			ignoring(modelMock);
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("sys", modelMock);
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);		
		Inport inport = FactoryImpl.newInportNamedWithin("inport", system);
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", subSystem);
		line = FactoryImpl.newLineNameWithinFromTo("line", modelMock, outport, inport);		
		
		line.ifLineAddToList(listMock);
	}	
	
	@Test
	public void testPortsBelongToTheSameSystem() throws Exception {
		context.checking(new Expectations() {{
			exactly(2).of(systemMock).addChild(with(any(Port.class)));
			
			ignoring(systemMock);
		}});
		
		Inport inport = FactoryImpl.newInportNamedWithin("inport", systemMock);
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", systemMock);		
		
		assertTrue(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testPortsDoNotBelongToTheSameSystem() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", systemMock);
		Inport inport = FactoryImpl.newInportNamedWithin("inport", systemMock);
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", system);		
		
		assertFalse(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);		
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);		
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", system);	
		Inport inport = FactoryImpl.newInportNamedWithin("inport", subSystem);		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels2() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);		
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);		
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", subSystem);	
		Inport inport = FactoryImpl.newInportNamedWithin("inport", system);		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);		
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);
		System subSubSystem = FactoryImpl.newSystemNamedWithin("subSystem", subSystem);
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", system);
		Inport inport = FactoryImpl.newInportNamedWithin("inport", subSubSystem);		
		
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels2() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);		
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);
		System subSubSystem = FactoryImpl.newSystemNamedWithin("subSystem", subSystem);
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", subSubSystem);
		Inport inport = FactoryImpl.newInportNamedWithin("inport", system);
				
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtSameLevel() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);
		System subSystemA = FactoryImpl.newSystemNamedWithin("subSystem1", system);
		System subSystemB = FactoryImpl.newSystemNamedWithin("subSystem", system);		
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", subSystemA);
		Inport inport = FactoryImpl.newInportNamedWithin("inport", subSystemB);		
		
		assertTrue(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtSameLevel() throws Exception {
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("system", modelMock);		
		System subSystem = FactoryImpl.newSystemNamedWithin("sub", system);
		System subSubSystem = FactoryImpl.newSystemNamedWithin("subSystem", subSystem);
		
		Outport outport = FactoryImpl.newOutportNamedWithin("outport", subSystem);
		Inport inport = FactoryImpl.newInportNamedWithin("inport", subSubSystem);
		
		assertFalse(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCreateLineWithinSystem() throws Exception {
		context.checking(new Expectations() {{			
			
			atLeast(1).of(outportMock).getParent(); will(returnValue(systemMock));
			atLeast(1).of(inportMock).getParent(); will(returnValue(systemMock));
			one(systemMock).addChild(with(any(Line.class)));
			
			ignoring(systemMock);			
		}});	
		
		Line line = LineImpl.newNamedWithinFromTo("line", systemMock, outportMock, inportMock);		
		assertEquals("line", line.getName());	
	}
	
	@Test
	public void testCreateLineWithinModel() throws Exception{		
		context.checking(new Expectations() {{			
			
			atLeast(1).of(outportMock).getParent(); will(returnValue(systemMock));
			atLeast(1).of(inportMock).getParent(); will(returnValue(systemMock));
			one(modelMock).addChild(with(any(Line.class)));
			
			ignoring(systemMock);	
		}});	
		
		Line line = LineImpl.newNamedWithinFromTo("line", modelMock, outportMock, inportMock);		
		assertEquals("line", line.getName());	
	}

}
