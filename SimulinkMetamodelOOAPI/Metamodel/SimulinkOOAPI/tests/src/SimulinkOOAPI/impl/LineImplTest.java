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
	public void setUp() throws Exception{	
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().named("sys").within(modelMock).createSystem();
		System subSystem = new Factory.Builder().named("sub").within(system).createSystem();		
		Inport inport = new Factory.Builder().named("inport").within(system).createInport();
		Outport outport = new Factory.Builder().named("outport").within(subSystem).createOutport();
		line = new Factory.Builder().named("line").within(modelMock).from(outport).to(inport).createLine();		
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
	public void testPortsBelongToTheSameSystem() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		Inport inport = new Factory.Builder().named("inport").within(systemMock).createInport();
		Outport outport = new Factory.Builder().named("outport").within(systemMock).createOutport();		
		
		assertTrue(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testPortsDoNotBelongToTheSameSystem() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		System system = new Factory.Builder().within(systemMock).named("system").createSystem();
		Inport inport = new Factory.Builder().named("inport").within(systemMock).createInport();
		Outport outport = new Factory.Builder().named("outport").within(system).createOutport();		
		
		assertFalse(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();		
		System subSystem = new Factory.Builder().within(system).named("sub").createSystem();		
		
		Outport outport = new Factory.Builder().named("outport").within(system).createOutport();	
		Inport inport = new Factory.Builder().named("inport").within(subSystem).createInport();		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();		
		System subSystem = new Factory.Builder().within(system).named("sub").createSystem();		
		
		Outport outport = new Factory.Builder().named("outport").within(subSystem).createOutport();	
		Inport inport = new Factory.Builder().named("inport").within(system).createInport();		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();		
		System subSystem = new Factory.Builder().within(system).named("sub").createSystem();
		System subSubSystem = new Factory.Builder().within(subSystem).named("subSystem").createSystem();
		
		Outport outport = new Factory.Builder().named("outport").within(system).createOutport();
		Inport inport = new Factory.Builder().named("inport").within(subSubSystem).createInport();		
		
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();		
		System subSystem = new Factory.Builder().within(system).named("sub").createSystem();
		System subSubSystem = new Factory.Builder().within(subSystem).named("subSystem").createSystem();
		
		Outport outport = new Factory.Builder().named("outport").within(subSubSystem).createOutport();
		Inport inport = new Factory.Builder().named("inport").within(system).createInport();
				
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();
		System subSystemA = new Factory.Builder().within(system).named("subSystem1").createSystem();
		System subSystemB = new Factory.Builder().within(system).named("subSystem").createSystem();		
		
		Outport outport = new Factory.Builder().named("outport").within(subSystemA).createOutport();
		Inport inport = new Factory.Builder().named("inport").within(subSystemB).createInport();		
		
		assertTrue(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = new Factory.Builder().within(modelMock).named("system").createSystem();		
		System subSystem = new Factory.Builder().within(system).named("sub").createSystem();
		System subSubSystem = new Factory.Builder().within(subSystem).named("subSystem").createSystem();
		
		Outport outport = new Factory.Builder().named("outport").within(subSystem).createOutport();
		Inport inport = new Factory.Builder().named("inport").within(subSubSystem).createInport();
		
		assertFalse(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}

}
