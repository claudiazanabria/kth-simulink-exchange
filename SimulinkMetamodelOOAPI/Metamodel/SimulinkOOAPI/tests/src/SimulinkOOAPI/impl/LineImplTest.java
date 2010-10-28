package SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.System;
import SimulinkOOAPI.ReflectionList;


@RunWith(JMock.class)
public class LineImplTest {
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	System systemMock = context.mock(System.class);	
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<Line> listMock = context.mock(ReflectionList.class);	
    Line line;
	
	@Before
	public void setUp(){	
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("systen", modelMock);
		System subSystem = SystemImpl.newNamedWithin("systen", system);
		Inport inport = InportImpl.newNamedWithin("inport", system);
		Outport outport = OutportImpl.newNamedWithin("outport", subSystem);
		line = LineImpl.newNamedWithinFromTo("line", modelMock, outport, inport);					
	}
	
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
			one (listMock).add(with(line));			    
		}});
		
		line.ifLineAddToList(listMock);
	}	
	
	@Test
	public void testPortsBelongToTheSameSystem(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		Inport inport = InportImpl.newNamedWithin("port", systemMock);
		Outport outport = OutportImpl.newNamedWithin("outport", systemMock);
		
		assertTrue(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testPortsDoNotBelongToTheSameSystem(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("system", systemMock);
		Inport inport = InportImpl.newNamedWithin("port", systemMock);
		Outport outport = OutportImpl.newNamedWithin("outport", system);
		
		assertFalse(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("system", modelMock);
		System subSystem = SystemImpl.newNamedWithin("subSystem", system);		
		
		Outport outport = OutportImpl.newNamedWithin("outport", system);
		Inport inport = InportImpl.newNamedWithin("port", subSystem);
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels2(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("system", modelMock);
		System subSystem = SystemImpl.newNamedWithin("subSystem", system);		
		
		Outport outport = OutportImpl.newNamedWithin("outport", subSystem);
		Inport inport = InportImpl.newNamedWithin("port", system);
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("system", modelMock);
		System subSystem = SystemImpl.newNamedWithin("subSystem", system);
		System subSubSystem = SystemImpl.newNamedWithin("subSystem", subSystem);
		
		Outport outport = OutportImpl.newNamedWithin("outport", system);
		Inport inport = InportImpl.newNamedWithin("port", subSubSystem);
		
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels2(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = SystemImpl.newNamedWithin("system", modelMock);
		System subSystem = SystemImpl.newNamedWithin("subSystem", system);
		System subSubSystem = SystemImpl.newNamedWithin("subSystem", subSystem);
		
		Outport outport = OutportImpl.newNamedWithin("outport", subSubSystem);
		Inport inport = InportImpl.newNamedWithin("port", system);
		
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}

}
