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

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;

@RunWith(JMock.class)
public class SystemImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Model modelMock = context.mock(Model.class);
	Port portMock = context.mock(Port.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<System> listMock = context.mock(ReflectionList.class);
    System system;
	
	@Before
	public void setUp(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		system = SystemImpl.newNamedWithin("sys", modelMock);					
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new SystemImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/	
	
	@Test
	public void testIfSystemAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(system));			    
		}});
		
		system.ifSystemAddToList(listMock);
	}	
	
	@Test
	//TODO: check that some elements cannot be added into system
	public void testAddChild(){
		assertEquals(0, system.getNumberOfChildren());
		system.addChild(new PortImpl(identityMock));
		assertEquals(1, system.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(ProtoObject child){
		boolean passed = false;
		try{
			system.addChild(child);
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
		GainBlockImpl.newNamedWithGainWithin("gainBlock1", 2, system);
		GainBlockImpl.newNamedWithGainWithin("gainBlock2", 2, system);
		assertEquals(2, system.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		system.addChild(new LineImpl(identityMock, portMock, portMock));
		assertEquals(1, system.getChildrenOfTypeLine().size());
	}
	
	@Test	
	public void testGetChildrenOfTypePort(){
		system.addChild(new PortImpl(identityMock));
		assertEquals(1, system.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		SystemImpl.newNamedWithin("sys", system);		
		assertEquals(1, system.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference(){
		SystemReferenceImpl.newNamedWithinTargeting("sysRef", system, system);
		assertEquals(1, system.getChildrenOfTypeSystemReference().size());
	}

}
