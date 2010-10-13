package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.AssertionFailedError;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.ProtoObject;

@RunWith(JMock.class)
public class ModelImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
    ModelImpl model;
	
	@Before
	public void setUp(){		
		model = new ModelImpl(identityMock);		
		
		model.addChild(new SystemImpl(identityMock));
		model.addChild(new SystemImpl(identityMock));				
	}
	
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new ModelImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	
	
	@Test	
	public void testAddChild(){
		assertEquals(2, model.getNumberOfChildren());
		model.addChild(new SystemImpl(identityMock));
		assertEquals(3, model.getNumberOfChildren());
	}
	
	protected void testAddWrongChild(ProtoObject child){
		boolean passed = false;
		try{
			model.addChild(child);
		}catch(IllegalArgumentException e){
			passed = true;
		}
		assertTrue(passed);
	}
	
	@Test
	public void testAddGainBlock(){
		testAddWrongChild(new GainBlockImpl(identityMock, 3));		
	}
	
	@Test
	public void testAddLibrary(){
		testAddWrongChild(new LibraryImpl(identityMock));		
	}
	
	@Test
	public void testAddPort(){
		testAddWrongChild(new PortImpl(identityMock));
	}
	
	@Test	
	public void testGetChildrenOfTypeLine(){
		model.addChild(new LineImpl(identityMock));
		assertEquals(1, model.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, model.getChildrenOfTypeSystem().size());
	}

}
