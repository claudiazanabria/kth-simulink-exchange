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
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.System;


@RunWith(JMock.class)
public class ChildrenSupportImplTest {
	
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	Line lineMock = context.mock(Line.class);
	Port portMock = context.mock(Port.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	System systemMock = context.mock(System.class);
	ChildrenSupportImpl childrenSupport;	
	
	@Before
	public void setUp() throws Exception{
		childrenSupport = new ChildrenSupportImpl();
		assertNotNull(childrenSupport.getChildren());
		
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		System sys1 = Factory.createSystem().withName("sys1").within(modelMock).please();
		childrenSupport.addChild(sys1);
		childrenSupport.addChild(Factory.createSystem().within(sys1).withName("sys2").please());
		childrenSupport.addChild(Factory.createGainBlock().withGain(3).within(sys1).withName("gain1").please());
		childrenSupport.addChild(Factory.createGainBlock().withGain(3).within(sys1).withName("gain2").please());
	}
	
	@Test
	public void testAddChild() throws Exception{
		assertEquals(4, childrenSupport.getNumberOfChildren());
		childrenSupport.addChild(Factory.createSystem().within(modelMock).withName("sys1").please());
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
			ignoring(inportMock);
			ignoring(outportMock);
			ignoring(systemMock);					
		}});		
		
		childrenSupport.addChild(Factory.createLine().within(systemMock).from(outportMock).to(inportMock).withName("line").please());
		assertEquals(1, childrenSupport.getChildrenOfTypeLine().size());
	}
	
	@Test
	public void testGetChildrenOfTypePort() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.createInport().within(systemMock).withName("port1").please());
		childrenSupport.addChild(Factory.createOutport().within(systemMock).withName("port2").please());
		assertEquals(2, childrenSupport.getChildrenOfTypePort().size());
	}
	
	@Test
	public void testGetChildrenOfTypeOutport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.createOutport().within(systemMock).withName("port").please());
		assertEquals(1, childrenSupport.getChildrenOfTypeOutport().size());
	}
	
	@Test
	public void testGetChildrenOfTypeInport() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		childrenSupport.addChild(Factory.createInport().within(systemMock).withName("port").please());
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
		
		System system = Factory.createSystem().within(systemMock).withName("sys").please();
		childrenSupport.addChild(Factory.createSystemReference().within(systemMock).targeting(system).withName("sysRef").please());
		assertEquals(1, childrenSupport.getChildrenOfTypeSystemReference().size());
	}

}
