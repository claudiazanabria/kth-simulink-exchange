package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISystem;

@RunWith(JMock.class)
public class SystemTest {
	Mockery context = new JUnit4Mockery();	
	IModel modelMock = context.mock(IModel.class);
	IPort portMock = context.mock(IPort.class);
	ISystem systemMock = context.mock(ISystem.class);
	ILibrary libraryMock = context.mock(ILibrary.class);
	IInport inportMock = context.mock(IInport.class);
	IOutport outportMock = context.mock(IOutport.class);
	@SuppressWarnings("unchecked")	
	IReflectionList<ISystem> listMock = context.mock(IReflectionList.class);
    ISystem system;    
	
	@Before
	public void setUp() throws Exception{
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(ISystem.class)));			    
		}});
		system = System.newNamedWithin("sys", modelMock);
		Factory.newInportNamedWithin("inport", system);
		Outport.newNamedWithin("outport", system);		
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
			
			ignoring(listMock);
		}});
		
		system.ifSystemAddToList(listMock);
	}	
	
	@Test
	//TODO: check that some elements cannot be added into system
	public void testAddChild() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		assertEquals(2, system.getNumberOfChildren());
		system.addChild(System.newNamedWithin("sys", modelMock));
		assertEquals(3, system.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(IProtoObject child){
		boolean passed = false;
		try{
			system.addChild(child);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);
	}

	@Test
	public void testAddLibrary() throws Exception{
		testAddWrongChild(Library.newNamed("lib"));		
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock() throws Exception{
		GainBlock.newNamedWithinWithGain("gainBlock1", system, 1);
		GainBlock.newNamedWithinWithGain("gainBlock2", system, 1);		
		assertEquals(2, system.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine() throws Exception{
		context.checking(new Expectations() {{
			atLeast(1).of(inportMock).getParent();
				will(returnValue(system));
			atLeast(1).of(outportMock).getParent();
				will(returnValue(system));								    
		}});
		Line.newNamedWithinFromTo("line", system, outportMock, inportMock);				
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
	public void testGetChildrenOfTypeSystem() throws Exception{
		System.newNamedWithin("sys", system);		
		assertEquals(1, system.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);								    
		}});
		
		SystemReference.newNamedWithinTargeting("sysref", system, systemMock);		
		assertEquals(1, system.getChildrenOfTypeSystemReference().size());
	}
	
	@Test
	public void testIsParentOfSystem() throws Exception{
		ISystem subsystem = Factory.newSystemNamedWithin("sub", system);		
		assertTrue(system.isParentOf(subsystem));
	}
	
	@Test
	public void testIsNotParentOfSystem() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		ISystem subsystem = Factory.newSystemNamedWithin("sub", modelMock);		
		assertFalse(system.isParentOf(subsystem));
	}
	
	@Test
	public void testCreateWithinModel() throws Exception{		
		context.checking(new Expectations() {{					
			one(modelMock).addChild(with(any(ISystem.class)));
		}});	
		
		ISystem system = System.newNamedWithin("sys", modelMock);		
		assertEquals("sys", system.getName());		
	}
	
	@Test
	public void testCreateWithinSystem() throws Exception{		
		context.checking(new Expectations() {{					
			one(systemMock).addChild(with(any(ISystem.class)));
		}});	
		
		ISystem system = System.newNamedWithin("sys", systemMock);		
		assertEquals("sys", system.getName());		
	}
	
	@Test
	public void testCreateWithinLibrary() throws Exception{		
		context.checking(new Expectations() {{					
			one(libraryMock).addChild(with(any(ISystem.class)));
		}});	
		
		ISystem system = System.newNamedWithin("sys", libraryMock);		
		assertEquals("sys", system.getName());		
	}
	
	@Test
	public void testChildWithName(){
		assertNotNull(system.childWith("inport"));
		assertNotNull(system.childWith("outport"));
	}
	
	@Test
	public void testChildWithUuid(){
		String inportUuid = system.childWith("inport").getUuid();
		String outportUuid = system.childWith("outport").getUuid();
		assertNotNull(system.childWith(inportUuid));
		assertNotNull(system.childWith(outportUuid));
	}
	
	@Test
	public void testNoChildWithName(){
		assertTrue(system.childWith("somenameOrUuid") == null);		
	}
	
	

}
