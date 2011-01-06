package se.kth.md.SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;

import static org.junit.Assert.assertEquals;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Identity;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.System;


@RunWith(JMock.class)
public class GainBlockTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Model modelMock = context.mock(Model.class);
	System systemMock = context.mock(System.class);
	Library libraryMock = context.mock(Library.class);
	@SuppressWarnings("unchecked")	
	SimulinkList<GainBlock> listMock = context.mock(SimulinkList.class);	
    GainBlock gainBlock;    
	
	@Before
	public void setUp() throws Exception{	
		context.checking(new Expectations() {{			
			one(systemMock).addChild(with(any(GainBlock.class)));
		}});	
		
		gainBlock = FactoryImpl.newGainBlockNamedWithinWithGain("gblock", systemMock, 1);
				
	}
	
	@Test
	public void testCreateGainBlockWithinModel() throws Exception {		
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(GainBlock.class)));
		}});	
		
		GainBlock gBlock = GainBlockImpl.newNamedWithinWithGain("gainBlock", modelMock , 5);
		assertEquals(5, gBlock.getGain());
		assertEquals("gainBlock", gBlock.getName());		
	}
	
	@Test
	public void testCreateGainBlockWithinSystem() throws Exception{
		context.checking(new Expectations() {{			
			one(systemMock).addChild(with(any(GainBlock.class)));
		}});	
		
		GainBlock gainBlock = GainBlockImpl.newNamedWithinWithGain("gainBlock", systemMock , 5);
		assertEquals(5, gainBlock.getGain());
		assertEquals("gainBlock", gainBlock.getName());	
	}
	
	@Test
	public void testCreateGainBlockWithinLibrary() throws Exception{
		context.checking(new Expectations() {{			
			one(libraryMock).addChild(with(any(GainBlock.class)));
		}});	
		
		GainBlock gainBlock = GainBlockImpl.newNamedWithinWithGain("gainBlock", libraryMock , 5);
		assertEquals(5, gainBlock.getGain());
		assertEquals("gainBlock", gainBlock.getName());		
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new GainBlockImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	*/
	
	@Test
	public void testIfGainBlockAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(gainBlock));		
		}});
		
		gainBlock.ifGainBlockAddToList(listMock);
	}	
	

}
