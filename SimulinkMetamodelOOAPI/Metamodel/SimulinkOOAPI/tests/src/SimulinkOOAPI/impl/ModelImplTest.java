package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.System;

@RunWith(JMock.class)
public class ModelImplTest {
	
	Mockery context = new JUnit4Mockery();	
	System systemMock = context.mock(System.class);	
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
    Model model;    
	
	@Before
	public void setUp() throws Exception{		
		model = new Factory.Builder().named("model").createModel();
		
		new Factory.Builder().named("sys1").within(model).createSystem();
		new Factory.Builder().named("sys2").within(model).createSystem();						
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new ModelImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/	
	
	@Test	
	public void testAddChild() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		assertEquals(2, model.getNumberOfChildren());
		model.addChild(new Factory.Builder().within(systemMock).named("sys1").createSystem());
		assertEquals(3, model.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(ProtoObject child){
		boolean passed = false;
		try{
			model.addChild(child);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);
	}
	
	@Test
	public void testAddGainBlock() throws Exception{
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		testAddWrongChild(new Factory.Builder().within(systemMock).withGain(2).named("gainBlock").createGainBlock());		
	}
	
	@Test
	public void testAddLibrary() throws Exception{
		testAddWrongChild(new Factory.Builder().named("library").createLibrary());		
	}
	
	@Test
	public void testAddPort() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		testAddWrongChild(new Factory.Builder().within(systemMock).named("port").createInport());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine() throws Exception{
		context.checking(new Expectations() {{
			atLeast(1).of(inportMock).getParent();
				will(returnValue(systemMock));
			atLeast(1).of(outportMock).getParent();
				will(returnValue(systemMock));
			
			ignoring(systemMock);			
		}});
		
		new Factory.Builder().named("line").within(model).from(outportMock).to(inportMock).createLine();		
		assertEquals(1, model.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, model.getChildrenOfTypeSystem().size());
	}

}
