package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;

@RunWith(JMock.class)
public class SystemReferenceImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Port portMock = context.mock(Port.class);	
	System systemMock = context.mock(SimulinkOOAPI.System.class);
    SystemReference systemReference;
	
	@Before
	public void setUp(){		
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		systemReference = SystemReferenceImpl.newNamedWithinTargeting("sysRef", systemMock, systemMock);				
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new SystemReferenceImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/	
	
	@Test
	//TODO: check some other elements cannot be added into systemReference
	public void testAddChild(){
		assertEquals(0, systemReference.getNumberOfChildren());
		systemReference.addChild(new LineImpl(identityMock, portMock, portMock));
		assertEquals(1, systemReference.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		systemReference.addChild(GainBlockImpl.newNamedWithGainWithin("gainBlock1", 2, systemMock));
		systemReference.addChild(GainBlockImpl.newNamedWithGainWithin("gainBlock2", 2, systemMock));
		assertEquals(2, systemReference.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		systemReference.addChild(new LineImpl(identityMock, portMock, portMock));
		assertEquals(1, systemReference.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		systemReference.addChild(new PortImpl(identityMock));
		assertEquals(1, systemReference.getChildrenOfTypePort().size());
	}

	
//	@Test
//	public void testGetChildrenOfTypeSystem(){
//		systemReference.addChild(new SystemImpl(identityMock));
//		assertEquals(1, systemReference.getChildrenOfTypeSystem().size());
//	}
	
//	@Test
//	public void testGetChildrenOfTypeSystemReference(){
//		systemReference.addChild(new SystemReferenceImpl(identityMock, systemMock));
//		assertEquals(1, systemReference.getChildrenOfTypeSystemReference().size());
//	}

}

