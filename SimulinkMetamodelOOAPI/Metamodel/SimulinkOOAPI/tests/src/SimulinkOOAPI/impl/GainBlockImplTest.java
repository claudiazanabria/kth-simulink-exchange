package SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Identity;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;


@RunWith(JMock.class)
public class GainBlockImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	System systemMock = context.mock(System.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<GainBlock> listMock = context.mock(ReflectionList.class);	
    GainBlock gainBlock;
	
	@Before
	public void setUp(){	
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		gainBlock = GainBlockImpl.newNamedWithGainWithin("gainBlock", 1, systemMock);		
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
