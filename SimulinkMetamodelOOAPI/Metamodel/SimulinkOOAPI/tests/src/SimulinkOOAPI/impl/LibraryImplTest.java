package SimulinkOOAPI.impl;

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

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.System;

@RunWith(JMock.class)
public class LibraryImplTest {
	
	Mockery context = new JUnit4Mockery();	
	System systemMock = context.mock(System.class);	
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
    Library library;
	
	@Before
	public void setUp(){		
		library = LibraryImpl.newNamed("library");				
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
	public void testAddChild(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		assertEquals(0, library.getNumberOfChildren());
		library.addChild(SystemImpl.newNamedWithin("system", systemMock));
		assertEquals(1, library.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(ProtoObject child){
		boolean passed = false;
		try{
			library.addChild(child);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);
	}

	@Test
	public void testAddLibrary(){
		testAddWrongChild(LibraryImpl.newNamed("library"));		
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		library.addChild(GainBlockImpl.newNamedWithGainWithin("gainBlock1", 1, systemMock));
		library.addChild(GainBlockImpl.newNamedWithGainWithin("gainBlock2", 1, systemMock));
		assertEquals(2, library.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		library.addChild(LineImpl.newNamedWithinBetween("line", systemMock, inportMock, outportMock));
		assertEquals(1, library.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		library.addChild(InportImpl.newNamedWithin("port", systemMock));
		library.addChild(OutportImpl.newNamedWithin("port", systemMock));
		assertEquals(2, library.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport(){
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		library.addChild(InportImpl.newNamedWithin("port", systemMock));
		assertEquals(1, library.getChildrenOfTypeInport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport(){
		context.checking(new Expectations() {{
			ignoring(systemMock);
		}});
		
		library.addChild(OutportImpl.newNamedWithin("port", systemMock));
		assertEquals(1, library.getChildrenOfTypeOutport().size());
	}

	
	@Test
	public void testGetChildrenOfTypeSystem(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		library.addChild(SystemImpl.newNamedWithin("system", systemMock));
		assertEquals(1, library.getChildrenOfTypeSystem().size());
	}

}
