package SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.System;


@RunWith(JMock.class)
public class ChildrenSupportImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Model modelMock = context.mock(Model.class);
	Port portMock = context.mock(Port.class);
	SimulinkOOAPI.System systemMock = context.mock(SimulinkOOAPI.System.class);
	ChildrenSupportImpl childrenSupport;
	
	@Before
	public void setUp(){
		childrenSupport = new ChildrenSupportImpl();
		assertNotNull(childrenSupport.getChildren());
		
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		System sys1 = SystemImpl.newNamedWithin("sys1", modelMock);
		childrenSupport.addChild(sys1);
		childrenSupport.addChild(SystemImpl.newNamedWithin("sys2", sys1));
		childrenSupport.addChild(GainBlockImpl.newNamedWithGainWithin("gain1", 3, sys1));
		childrenSupport.addChild(GainBlockImpl.newNamedWithGainWithin("gain2", 3, sys1));
	}
	
	@Test
	public void testAddChild(){
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(SystemImpl.newNamedWithin("sys1", modelMock));
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}
	
	@Test
	public void testGetChildrenOfTypeLine(){		
		childrenSupport.addChild(new LineImpl(identityMock, portMock, portMock));
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
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(SystemReferenceImpl.newNamedWithinTargeting("sysRef", systemMock, systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
