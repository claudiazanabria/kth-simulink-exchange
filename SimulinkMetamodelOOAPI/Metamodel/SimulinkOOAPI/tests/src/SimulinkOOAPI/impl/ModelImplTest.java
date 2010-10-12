package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import junit.framework.AssertionFailedError;

import org.junit.Before;
import org.junit.Test;

import SimulinkOOAPI.Identity;


public class ModelImplTest {
	
    Identity identity;
    ModelImpl model;
	
	@Before
	public void setUp(){		
		model = new ModelImpl(new IdentityImpl());		
		
		model.addChild(new SystemImpl(new IdentityImpl()));
		model.addChild(new SystemImpl(new IdentityImpl()));
		model.addChild(new GainBlockImpl(new IdentityImpl()));
		model.addChild(new GainBlockImpl(new IdentityImpl()));		
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
		model.addChild(new SystemImpl(new IdentityImpl()));
		assertEquals(5, model.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, model.getChildrenOfTypeGainBlock().size());
	}

}
