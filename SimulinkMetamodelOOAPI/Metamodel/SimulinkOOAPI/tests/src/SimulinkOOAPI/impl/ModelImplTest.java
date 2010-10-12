package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class ModelImplTest {
	
    ChildrenSupportImpl childrenSupport;
    ModelImpl model;
	
	@Before
	public void setUp(){
		childrenSupport = new ChildrenSupportImpl();
		model = new ModelImpl();
		assertNotNull(childrenSupport.getChildren());
		childrenSupport.addChild(new SystemImpl());
		childrenSupport.addChild(new SystemImpl());
		childrenSupport.addChild(new GainBlockImpl());
		childrenSupport.addChild(new GainBlockImpl());
		model.setChildren(childrenSupport);
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, model.getNumberOfChildren());
		childrenSupport.addChild(new SystemImpl());
		assertEquals(5, model.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, model.getChildrenOfTypeGainBlock().size());
	}

}
