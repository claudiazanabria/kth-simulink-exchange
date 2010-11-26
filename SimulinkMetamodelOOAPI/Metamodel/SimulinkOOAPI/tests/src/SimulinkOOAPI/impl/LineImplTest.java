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
		
		System system = Factory.createSystem().withName("sys").within(modelMock).please();
		System subSystem = Factory.createSystem().withName("sub").within(system).please();		
		Inport inport = Factory.createInport().withName("inport").within(system).please();
		Outport outport = Factory.createOutport().withName("outport").within(subSystem).please();
		line = Factory.createLine().withName("line").within(modelMock).from(outport).to(inport).please();		
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
		
		Inport inport = Factory.createInport().withName("inport").within(systemMock).please();
		Outport outport = Factory.createOutport().withName("outport").within(systemMock).please();		
		
		assertTrue(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testPortsDoNotBelongToTheSameSystem() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			
		}});
		
		System system = Factory.createSystem().within(systemMock).withName("system").please();
		Inport inport = Factory.createInport().withName("inport").within(systemMock).please();
		Outport outport = Factory.createOutport().withName("outport").within(system).please();		
		
		assertFalse(LineImpl.portsBelongToTheSameSystem(inport, outport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();		
		System subSystem = Factory.createSystem().within(system).withName("sub").please();		
		
		Outport outport = Factory.createOutport().withName("outport").within(system).please();	
		Inport inport = Factory.createInport().withName("inport").within(subSystem).please();		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();		
		System subSystem = Factory.createSystem().within(system).withName("sub").please();		
		
		Outport outport = Factory.createOutport().withName("outport").within(subSystem).please();	
		Inport inport = Factory.createInport().withName("inport").within(system).please();		
		
		assertTrue(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();		
		System subSystem = Factory.createSystem().within(system).withName("sub").please();
		System subSubSystem = Factory.createSystem().within(subSystem).withName("subSystem").please();
		
		Outport outport = Factory.createOutport().withName("outport").within(system).please();
		Inport inport = Factory.createInport().withName("inport").within(subSubSystem).please();		
		
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtDifferentLevels2() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();		
		System subSystem = Factory.createSystem().within(system).withName("sub").please();
		System subSubSystem = Factory.createSystem().within(subSystem).withName("subSystem").please();
		
		Outport outport = Factory.createOutport().withName("outport").within(subSubSystem).please();
		Inport inport = Factory.createInport().withName("inport").within(system).please();
				
		assertFalse(LineImpl.canConnectPortsAtDifferentLevels(outport, inport));
	}
	
	@Test
	public void testCanConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();
		System subSystemA = Factory.createSystem().within(system).withName("subSystem1").please();
		System subSystemB = Factory.createSystem().within(system).withName("subSystem").please();		
		
		Outport outport = Factory.createOutport().withName("outport").within(subSystemA).please();
		Inport inport = Factory.createInport().withName("inport").within(subSystemB).please();		
		
		assertTrue(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}
	
	@Test
	public void testCanNotConnectPortsAtSameLevel() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			
		}});
		
		System system = Factory.createSystem().within(modelMock).withName("system").please();		
		System subSystem = Factory.createSystem().within(system).withName("sub").please();
		System subSubSystem = Factory.createSystem().within(subSystem).withName("subSystem").please();
		
		Outport outport = Factory.createOutport().withName("outport").within(subSystem).please();
		Inport inport = Factory.createInport().withName("inport").within(subSubSystem).please();
		
		assertFalse(LineImpl.canConnectPortsAtTheSameLevel(outport, inport));
	}

}
