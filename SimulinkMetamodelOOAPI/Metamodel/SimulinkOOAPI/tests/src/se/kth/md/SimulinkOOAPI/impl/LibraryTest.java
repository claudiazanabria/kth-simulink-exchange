package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISystem;

@RunWith(JMock.class)
public class LibraryTest {
	
	Mockery context = new JUnit4Mockery();	
	ISystem systemMock = context.mock(ISystem.class);	
	IInport inportMock = context.mock(IInport.class);
	IOutport outportMock = context.mock(IOutport.class);
    ILibrary library;    
	
	@Before
	public void setUp() throws Exception{		
		library = new Factory.Builder().named("library").createLibrary();			
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new LibraryImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}
	*/	
	
	@Test
	public void testAddChild() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		assertEquals(0, library.getNumberOfChildren());
		library.addChild(new Factory.Builder().named("sys").within(systemMock).createSystem());
		assertEquals(1, library.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(IProtoObject child){
		boolean passed = false;
		try{
			library.addChild(child);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);
	}

	@Test
	public void testAddLibrary() throws Exception{
		testAddWrongChild(new Factory.Builder().named("library").createLibrary());		
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock() throws Exception {
		new Factory.Builder().within(library).withGain(1).named("gBlock1").createGainBlock();
		new Factory.Builder().within(library).withGain(1).named("gBlock2").createGainBlock();				
		assertEquals(2, library.getChildrenOfTypeGainBlock().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem() throws Exception{
		new Factory.Builder().within(library).named("system").createSystem();		
		assertEquals(1, library.getChildrenOfTypeSystem().size());
	}

}
