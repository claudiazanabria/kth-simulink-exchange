package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import junit.framework.AssertionFailedError;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;

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
		model.addChild(new GainBlockImpl(identityMock));
		model.addChild(new GainBlockImpl(identityMock));		
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
		assertEquals(4, model.getNumberOfChildren());
		model.addChild(new SystemImpl(identityMock));
		assertEquals(5, model.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, model.getChildrenOfTypeGainBlock().size());
	}

}
