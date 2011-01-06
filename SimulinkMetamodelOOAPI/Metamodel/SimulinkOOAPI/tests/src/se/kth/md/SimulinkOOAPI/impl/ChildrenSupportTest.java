package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.ChildrenSupport;
import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.System;

@RunWith(JMock.class)
public class ChildrenSupportTest {
	
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	Line lineMock = context.mock(Line.class);
	Port portMock = context.mock(Port.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	System systemMock = context.mock(System.class);
	ChildrenSupport childrenSupport;	
	
	@Before
	public void setUp() throws Exception {
		childrenSupport = new ChildrenSupportImpl();
		assertNotNull(childrenSupport.getChildren());
		
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(SystemImpl.class)));	    
		}});
		
		//System sys1 = new Factory.Builder().named("sys1").within(modelMock).createSystem();
		System sys1 = SystemImpl.newNamedWithin("sys1", modelMock);
		childrenSupport.addChild(sys1);
		childrenSupport.addChild(FactoryImpl.newSystemNamedWithin("sys2", sys1));
		childrenSupport.addChild(FactoryImpl.newGainBlockNamedWithinWithGain("gain1", sys1, 3));
		childrenSupport.addChild(FactoryImpl.newGainBlockNamedWithinWithGain("gain2", sys1, 3));		
	}
	
	@Test
	public void testAddChild() throws Exception {
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(SystemImpl.class)));	    
		}});
		
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(FactoryImpl.newSystemNamedWithin("sys1", modelMock));
		assertEquals(5, childrenSupport.getNumberOfChildren());
	}
	
	@Test
	public void testGetChildrenOfTypeGainBlock(){
		assertEquals(2, childrenSupport.getChildrenOfTypeGainBlock().size());
	}
	
	@Test
	public void testGetChildrenOfTypeLine() throws Exception{
		//final System subsystem = SystemImpl.newNamedWithin("subSystem", systemMock);
		
		context.checking(new Expectations() {{
			one(inportMock).getParent();
			    will(returnValue(systemMock));
		    one(outportMock).getParent();
			    will(returnValue(systemMock));
			one(systemMock).addChild(with(any(Line.class)));	
			
			ignoring(inportMock);
			ignoring(outportMock);			
		}});		
		
		childrenSupport.addChild(FactoryImpl.newLineNameWithinFromTo("line", systemMock, outportMock, inportMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(FactoryImpl.newInportNamedWithin("port1", systemMock));
		childrenSupport.addChild(FactoryImpl.newOutportNamedWithin("port2", systemMock));
		assertEquals(2, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(FactoryImpl.newOutportNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeOutport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(FactoryImpl.newInportNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeInport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, childrenSupport.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		System system = FactoryImpl.newSystemNamedWithin("sys", systemMock);
		childrenSupport.addChild(FactoryImpl.newSystemReferemceNamedWithinTargeting("sysRef", systemMock, system));
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
