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
		childrenSupport.addChild(new SystemImpl(new IdentityImpl()));
		childrenSupport.addChild(new SystemImpl(new IdentityImpl()));
		childrenSupport.addChild(new GainBlockImpl(new IdentityImpl()));
		childrenSupport.addChild(new GainBlockImpl(new IdentityImpl()));
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(new SystemImpl(new IdentityImpl()));
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}

}
