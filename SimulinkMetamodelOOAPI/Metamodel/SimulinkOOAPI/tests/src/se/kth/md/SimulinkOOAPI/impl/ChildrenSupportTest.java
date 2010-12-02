package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.ISystem;


@RunWith(JMock.class)
public class ChildrenSupportTest {
	
	Mockery context = new JUnit4Mockery();
	IModel modelMock = context.mock(IModel.class);
	ILine lineMock = context.mock(ILine.class);
	IPort portMock = context.mock(IPort.class);
	IInport inportMock = context.mock(IInport.class);
	IOutport outportMock = context.mock(IOutport.class);
	ISystem systemMock = context.mock(ISystem.class);
	IChildrenSupport childrenSupport;	
	
	@Before
	public void setUp() throws Exception{
		childrenSupport = new ChildrenSupport();
		assertNotNull(childrenSupport.getChildren());
		
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(System.class)));	    
		}});
		
		//System sys1 = new Factory.Builder().named("sys1").within(modelMock).createSystem();
		ISystem sys1 = System.newNamedWithin("sys1", modelMock);
		childrenSupport.addChild(sys1);
		childrenSupport.addChild(Factory.newSystemNamedWithin("sys2", sys1));
		childrenSupport.addChild(Factory.newGainBlockNamedWithinWithGain("gain1", sys1, 3));
		childrenSupport.addChild(Factory.newGainBlockNamedWithinWithGain("gain2", sys1, 3));		
	}
	
	@Test
	public void testAddChild() throws Exception{
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(System.class)));	    
		}});
		
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(Factory.newSystemNamedWithin("sys1", modelMock));
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
			one(systemMock).addChild(with(any(ILine.class)));	
			
			ignoring(inportMock);
			ignoring(outportMock);			
		}});		
		
		childrenSupport.addChild(Factory.newLineNameWithinFromTo("line", systemMock, outportMock, inportMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.newInportNamedWithin("port1", systemMock));
		childrenSupport.addChild(Factory.newOutportNamedWithin("port2", systemMock));
		assertEquals(2, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.newOutportNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeOutport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.newInportNamedWithin("port", systemMock));
		assertEquals(1, childrenSupport.getChildrenOfTypeInport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystem(){
		assertEquals(2, childrenSupport.getChildrenOfTypeSystem().size());
	}
	
	@Test
	public void testGetChildrenOfTypeSystemReference() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		ISystem system = Factory.newSystemNamedWithin("sys", systemMock);
		childrenSupport.addChild(Factory.newSystemReferemceNamedWithinTargeting("sysRef", systemMock, system));
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
