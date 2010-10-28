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
	public void setUp(){		
		model = ModelImpl.newNamed("model");		
		
		SystemImpl.newNamedWithin("sys1", model);
		SystemImpl.newNamedWithin("sys2", model);				
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
	public void testAddChild(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		assertEquals(2, model.getNumberOfChildren());
		model.addChild(SystemImpl.newNamedWithin("sys1", systemMock));
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
	public void testAddGainBlock(){
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		testAddWrongChild(GainBlockImpl.newNamedWithinWithGain("gainBlock", systemMock, 2));		
	}
	
	@Test
	public void testAddLibrary(){
		testAddWrongChild(LibraryImpl.newNamed("library"));		
	}
	
	@Test
	public void testAddPort(){
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		testAddWrongChild(InportImpl.newNamedWithin("port", systemMock));
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		context.checking(new Expectations() {{
			atLeast(1).of(inportMock).getParent();
				will(returnValue(systemMock));
			atLeast(1).of(outportMock).getParent();
				will(returnValue(systemMock));
			
			ignoring(systemMock);			
		}});
		
		LineImpl.newNamedWithinFromTo("line", model, outportMock, inportMock);		
		assertEquals(1, model.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, model.getChildrenOfTypeSystem().size());
	}

}
