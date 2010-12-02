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

import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IIdentity;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISystem;


@RunWith(JMock.class)
public class GainBlockTest {
	Mockery context = new JUnit4Mockery();
	IIdentity identityMock = context.mock(IIdentity.class);
	IModel modelMock = context.mock(IModel.class);
	ISystem systemMock = context.mock(ISystem.class);
	ILibrary libraryMock = context.mock(ILibrary.class);
	@SuppressWarnings("unchecked")	
	IReflectionList<IGainBlock> listMock = context.mock(IReflectionList.class);	
    IGainBlock gainBlock;    
	
	@Before
	public void setUp() throws Exception{	
		context.checking(new Expectations() {{			
			one(systemMock).addChild(with(any(IGainBlock.class)));
		}});	
		
		gainBlock = Factory.newGainBlockNamedWithinWithGain("gblock", systemMock, 1);
				
	}
	
	@Test
	public void testCreateGainBlockWithinModel() throws Exception{		
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(IGainBlock.class)));
		}});	
		
		IGainBlock gBlock = GainBlock.newNamedWithinWithGain("gainBlock", modelMock , 5);
		assertEquals(5, gBlock.getGain());
		assertEquals("gainBlock", gBlock.getName());		
	}
	
	@Test
	public void testCreateGainBlockWithinSystem() throws Exception{
		context.checking(new Expectations() {{			
			one(systemMock).addChild(with(any(IGainBlock.class)));
		}});	
		
		IGainBlock gainBlock = GainBlock.newNamedWithinWithGain("gainBlock", systemMock , 5);
		assertEquals(5, gainBlock.getGain());
		assertEquals("gainBlock", gainBlock.getName());	
	}
	
	@Test
	public void testCreateGainBlockWithinLibrary() throws Exception{
		context.checking(new Expectations() {{			
			one(libraryMock).addChild(with(any(IGainBlock.class)));
		}});	
		
		IGainBlock gainBlock = GainBlock.newNamedWithinWithGain("gainBlock", libraryMock , 5);
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
