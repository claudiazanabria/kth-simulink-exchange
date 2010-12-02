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

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISystem;

@RunWith(JMock.class)
public class LineTest {
	Mockery context = new JUnit4Mockery();
	IModel modelMock = context.mock(IModel.class);
	ISystem systemMock = context.mock(ISystem.class);	
	IInport inportMock = context.mock(IInport.class);
	IOutport outportMock = context.mock(IOutport.class);
	@SuppressWarnings("unchecked")	
	IReflectionList<ILine> listMock = context.mock(IReflectionList.class);	
    ILine line;	
	
	
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
	public void testIfLineAddToList() throws Exception{		
		context.checking(new Expectations() {{		
			one (listMock).add(with(any(ILine.class)));
			
			ignoring(modelMock);
		}});
		
		ISystem system = Factory.newSystemNamedWithin("sys", modelMock);
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);		
		IInport inport = Factory.newInportNamedWithin("inport", system);
		IOutport outport = Factory.newOutportNamedWithin("outport", subSystem);
		line = Factory.newLineNameWithinFromTo("line", modelMock, outport, inport);		
		
		line.ifLineAddToList(listMock);
	}	
	
	@Test
	public void testPortsBelongToTheSameSystem() throws Exception{
		context.checking(new Expectations() {{
			exactly(2).of(systemMock).addChild(with(any(IPort.class)));
			
			ignoring(systemMock);
		}});
		
		IInport inport = Factory.newInportNamedWithin("inport", systemMock);
		IOutport outport = Factory.newOutportNamedWithin("outport", systemMock);		
		
		assertTrue(Line.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testPortsDoNotBelongToTheSameSystem() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", systemMock);
		IInport inport = Factory.newInportNamedWithin("inport", systemMock);
		IOutport outport = Factory.newOutportNamedWithin("outport", system);		
		
		assertFalse(Line.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);		
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);		
		
		IOutport outport = Factory.newOutportNamedWithin("outport", system);	
		IInport inport = Factory.newInportNamedWithin("inport", subSystem);		
		
		assertTrue(Line.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);		
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);		
		
		IOutport outport = Factory.newOutportNamedWithin("outport", subSystem);	
		IInport inport = Factory.newInportNamedWithin("inport", system);		
		
		assertTrue(Line.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);		
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);
		ISystem subSubSystem = Factory.newSystemNamedWithin("subSystem", subSystem);
		
		IOutport outport = Factory.newOutportNamedWithin("outport", system);
		IInport inport = Factory.newInportNamedWithin("inport", subSubSystem);		
		
		assertFalse(Line.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);		
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);
		ISystem subSubSystem = Factory.newSystemNamedWithin("subSystem", subSystem);
		
		IOutport outport = Factory.newOutportNamedWithin("outport", subSubSystem);
		IInport inport = Factory.newInportNamedWithin("inport", system);
				
		assertFalse(Line.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);
		ISystem subSystemA = Factory.newSystemNamedWithin("subSystem1", system);
		ISystem subSystemB = Factory.newSystemNamedWithin("subSystem", system);		
		
		IOutport outport = Factory.newOutportNamedWithin("outport", subSystemA);
		IInport inport = Factory.newInportNamedWithin("inport", subSystemB);		
		
		assertTrue(Line.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		ISystem system = Factory.newSystemNamedWithin("system", modelMock);		
		ISystem subSystem = Factory.newSystemNamedWithin("sub", system);
		ISystem subSubSystem = Factory.newSystemNamedWithin("subSystem", subSystem);
		
		IOutport outport = Factory.newOutportNamedWithin("outport", subSystem);
		IInport inport = Factory.newInportNamedWithin("inport", subSubSystem);
		
		assertFalse(Line.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCreateLineWithinSystem() throws Exception{
		context.checking(new Expectations() {{			
			
			atLeast(1).of(outportMock).getParent(); will(returnValue(systemMock));
			atLeast(1).of(inportMock).getParent(); will(returnValue(systemMock));
			one(systemMock).addChild(with(any(ILine.class)));
			
			ignoring(systemMock);			
		}});	
		
		ILine line = Line.newNamedWithinFromTo("line", systemMock, outportMock, inportMock);		
		assertEquals("line", line.getName());	
	}
	
	@Test
	public void testCreateLineWithinModel() throws Exception{		
		context.checking(new Expectations() {{			
			
			atLeast(1).of(outportMock).getParent(); will(returnValue(systemMock));
			atLeast(1).of(inportMock).getParent(); will(returnValue(systemMock));
			one(modelMock).addChild(with(any(ILine.class)));
			
			ignoring(systemMock);	
		}});	
		
		ILine line = Line.newNamedWithinFromTo("line", modelMock, outportMock, inportMock);		
		assertEquals("line", line.getName());	
	}

}
