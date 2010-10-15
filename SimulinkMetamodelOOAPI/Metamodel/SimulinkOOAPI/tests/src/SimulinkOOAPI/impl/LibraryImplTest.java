package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import junit.framework.AssertionFailedError;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;

@RunWith(JMock.class)
public class LibraryImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Port portMock = context.mock(Port.class);
    LibraryImpl library;
	
	@Before
	public void setUp(){		
		library = new LibraryImpl(identityMock);				
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
		assertEquals(0, library.getNumberOfChildren());
		library.addChild(new SystemImpl(identityMock));
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
		testAddWrongChild(new LibraryImpl(identityMock));		
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		library.addChild(new GainBlockImpl(identityMock, 2));
		library.addChild(new GainBlockImpl(identityMock, 3));
		assertEquals(2, library.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		library.addChild(new LineImpl(identityMock, portMock, portMock));
		assertEquals(1, library.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		library.addChild(new PortImpl(identityMock));
		assertEquals(1, library.getChildrenOfTypePort().size());
	}

	
	@Test
	public void testGetChildrenOfTypeSystem(){
		library.addChild(new SystemImpl(identityMock));
		assertEquals(1, library.getChildrenOfTypeSystem().size());
	}

}
