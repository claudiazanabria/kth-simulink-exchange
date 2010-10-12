package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ModelImplTest {
	
    ChildrenSupportImpl childrenSupport;
    ModelImpl model;
	
	@Before
	public void setUp(){
		childrenSupport = new ChildrenSupportImpl();
		model = new ModelImpl();
		model.setChildren(childrenSupport);
		
		model.addChild(new SystemImpl());
		model.addChild(new SystemImpl());
		model.addChild(new GainBlockImpl());
		model.addChild(new GainBlockImpl());		
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, model.getNumberOfChildren());
		model.addChild(new SystemImpl());
		assertEquals(5, model.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, model.getChildrenOfTypeGainBlock().size());
	}

}
