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
	System systemMock = context.mock(System.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<System> listMock = context.mock(ReflectionList.class);
    System system;    
	
	@Before
	public void setUp() throws Exception{
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		system = new Factory.Builder().within(modelMock).named("sys").createSystem();
		new Factory.Builder().named("inport").within(system).createInport();
		new Factory.Builder().named("outport").within(system).createOutport();		
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
		system.addChild(new Factory.Builder().within(modelMock).named("sys").createSystem());
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
	public void testAddLibrary() throws Exception{
		testAddWrongChild(new Factory.Builder().named("sys").createLibrary());		
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock() throws Exception{
		new Factory.Builder().named("gainBlock1").withGain(5).within(system).createGainBlock();
		new Factory.Builder().named("gainBlock2").withGain(5).within(system).createGainBlock();
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
		new Factory.Builder().within(system).named("line").from(outportMock).to(inportMock).createLine();		
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
		new Factory.Builder().within(system).named("sys").createSystem();		
		assertEquals(1, system.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);								    
		}});
		
		new Factory.Builder().targeting(systemMock).within(system).named("sysRef").createSystemReferemce();		
		assertEquals(1, system.getChildrenOfTypeSystemReference().size());
	}
	
	@Test
	public void testIsParentOfSystem() throws Exception{
		System subsystem = new Factory.Builder().within(system).named("sub").createSystem();		
		assertTrue(system.isParentOf(subsystem));
	}
	
	@Test
	public void testIsNotParentOfSystem() throws Exception{
		System subsystem = new Factory.Builder().within(modelMock).named("sub").createSystem();		
		assertFalse(system.isParentOf(subsystem));
	}

}
