package SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;

@RunWith(JMock.class)
public class ChildrenSupportImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	ChildrenSupportImpl childrenSupport;
	
	@Before
	public void setUp(){
		childrenSupport = new ChildrenSupportImpl();
		assertNotNull(childrenSupport.getChildren());
		
		childrenSupport.addChild(new SystemImpl(identityMock));
		childrenSupport.addChild(new SystemImpl(identityMock));
		childrenSupport.addChild(new GainBlockImpl(identityMock));
		childrenSupport.addChild(new GainBlockImpl(identityMock));
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(new SystemImpl(identityMock));
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGain(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}

}
