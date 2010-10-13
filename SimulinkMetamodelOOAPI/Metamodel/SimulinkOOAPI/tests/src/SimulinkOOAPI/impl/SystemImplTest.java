package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;

@RunWith(JMock.class)
public class SystemImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<System> listMock = context.mock(ReflectionList.class);
    SystemImpl system;
	
	@Before
	public void setUp(){		
		system = new SystemImpl(identityMock);					
	}
	
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new SystemImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	
	
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
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		system.addChild(new GainBlockImpl(identityMock, 2));
		system.addChild(new GainBlockImpl(identityMock, 2));
		assertEquals(2, system.getChildrenOfTypeGainBlock().size());
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		system.addChild(new LineImpl(identityMock));
		assertEquals(1, system.getChildrenOfTypeLine().size());
	}
	
	@Test	
	public void testGetChildrenOfTypePort(){
		system.addChild(new PortImpl(identityMock));
		assertEquals(1, system.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		system.addChild(new SystemImpl(identityMock));
		assertEquals(1, system.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference(){
		system.addChild(new SystemReferenceImpl(identityMock));
		assertEquals(1, system.getChildrenOfTypeSystemReference().size());
	}

}
