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
		childrenSupport.addChild(new Factory.Builder().within(sys1).named("sys2").createSystem());
		childrenSupport.addChild(new Factory.Builder().withGain(3).within(sys1).named("gain1").createGainBlock());
		childrenSupport.addChild(new Factory.Builder().withGain(3).within(sys1).named("gain2").createGainBlock());
	}
	
	@Test
	public void testAddChild() throws Exception{
		context.checking(new Expectations() {{
			one(modelMock).addChild(with(any(System.class)));	    
		}});
		
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(new Factory.Builder().within(modelMock).named("sys1").createSystem());
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
		
		childrenSupport.addChild(new Factory.Builder().within(systemMock).from(outportMock).to(inportMock).named("line").createLine());
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(new Factory.Builder().within(systemMock).named("port1").createInport());
		childrenSupport.addChild(new Factory.Builder().within(systemMock).named("port2").createOutport());
		assertEquals(2, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(new Factory.Builder().within(systemMock).named("port").createOutport());
		assertEquals(1, childrenSupport.getChildrenOfTypeOutport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(new Factory.Builder().within(systemMock).named("port").createInport());
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
		
		ISystem system = new Factory.Builder().within(systemMock).named("sys").createSystem();
		childrenSupport.addChild(new Factory.Builder().within(systemMock).targeting(system).named("sysRef").createSystemReferemce());
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
