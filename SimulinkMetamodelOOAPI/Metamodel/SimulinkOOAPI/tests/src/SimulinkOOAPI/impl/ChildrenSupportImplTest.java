package SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ChildrenSupportImplTest {
	
	ChildrenSupportImpl childrenSupport;
	
	@Before
	public void setUp(){
		childrenSupport = new ChildrenSupportImpl();
		assertNotNull(childrenSupport.getChildren());
		childrenSupport.addChild(new SystemImpl());
		childrenSupport.addChild(new SystemImpl());
		childrenSupport.addChild(new GainBlockImpl());
		childrenSupport.addChild(new GainBlockImpl());
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(new SystemImpl());
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}

}
