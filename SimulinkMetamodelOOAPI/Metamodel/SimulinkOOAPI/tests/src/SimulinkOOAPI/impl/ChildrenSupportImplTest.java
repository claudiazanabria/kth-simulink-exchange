package SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.System;


@RunWith(JMock.class)
public class ChildrenSupportImplTest {
	
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	Port portMock = context.mock(Port.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
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
		childrenSupport.addChild(GainBlockImpl.newNamedWithinWithGain("gain1", sys1, 3));
		childrenSupport.addChild(GainBlockImpl.newNamedWithinWithGain("gain2", sys1, 2));
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
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(LineImpl.newNamedWithinBetween("line", systemMock, inportMock, outportMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(InportImpl.newNamedWithin("port1", systemMock));
		childrenSupport.addChild(OutportImpl.newNamedWithin("port2", systemMock));
		assertEquals(2, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(OutportImpl.newNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeOutport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport(){
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(InportImpl.newNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeInport().size());
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
