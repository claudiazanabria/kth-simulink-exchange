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
		childrenSupport.addChild(new GainBlockImpl(identityMock, 2));
		childrenSupport.addChild(new GainBlockImpl(identityMock, 2));
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(new SystemImpl(identityMock));
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}
	
	@Test
	public void testGetChildrenOfTypeLine(){		
		childrenSupport.addChild(new LineImpl(identityMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		childrenSupport.addChild(new PortImpl(identityMock));
		assertEquals(1, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, childrenSupport.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference(){
		childrenSupport.addChild(new SystemReferenceImpl(identityMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
