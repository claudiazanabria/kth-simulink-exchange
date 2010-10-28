package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import junit.framework.AssertionFailedError;

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
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;

@RunWith(JMock.class)
public class SystemImplTest {
	Mockery context = new JUnit4Mockery();	
	Model modelMock = context.mock(Model.class);
	Port portMock = context.mock(Port.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<System> listMock = context.mock(ReflectionList.class);
    System system;
	
	@Before
	public void setUp(){
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		system = SystemImpl.newNamedWithin("sys", modelMock);
		InportImpl.newNamedWithin("inport", system);
		OutportImpl.newNamedWithin("outport", system);
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
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		assertEquals(2, system.getNumberOfChildren());
		system.addChild(SystemImpl.newNamedWithin("sys", modelMock));
		assertEquals(3, system.getNumberOfChildren());
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
		GainBlockImpl.newNamedWithinWithGain("gainBlock1", system, 5);
		GainBlockImpl.newNamedWithinWithGain("gainBlock2", system, 6);
		assertEquals(2, system.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		context.checking(new Expectations() {{
			atLeast(1).of(inportMock).getParent();
				will(returnValue(system));
			atLeast(1).of(outportMock).getParent();
				will(returnValue(system));								    
		}});
		LineImpl.newNamedWithinFromTo("line", system, outportMock, inportMock);		
		assertEquals(1, system.getChildrenOfTypeLine().size());
	}
	
	@Test	
	public void testGetChildrenOfTypePort(){			
		assertEquals(2, system.getChildrenOfTypePort().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeInport(){				
		assertEquals(1, system.getChildrenOfTypeInport().size());
	}

	@Test	
	public void testGetChildrenOfTypeOutport(){				
		assertEquals(1, system.getChildrenOfTypeOutport().size());
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
	
	@Test
	public void testIsParentOfSystem(){
		System subsystem = SystemImpl.newNamedWithin("subSystem", system);
		assertTrue(system.isParentOf(subsystem));
	}
	
	@Test
	public void testIsNotParentOfSystem(){
		System subsystem = SystemImpl.newNamedWithin("subSystem", modelMock);
		assertFalse(system.isParentOf(subsystem));
	}

}
