package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISystem;


public class OutportTest {
	
	Mockery context = new JUnit4Mockery();
	ISystem systemMock = context.mock(ISystem.class);
	@SuppressWarnings("unchecked")	
	IReflectionList<IPort> listMock = context.mock(IReflectionList.class);
    IOutport port;
	
	@Before
	public void setUp() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		port = new Factory.Builder().
		                             within(systemMock).
		                             named("port").createOutport();					
	}	
	
	@Test
	public void testIfPortAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(port));
			
			ignoring(listMock);
		}});
		
		port.ifPortAddToList(listMock);
	}
	
	@Test
	public void testCreateOutport() throws Exception{
		context.checking(new Expectations() {{
			one(systemMock).addChild(with(any(IOutport.class)));		    
		}});
		
		IOutport port = Outport.newNamedWithin("outport", systemMock);
		assertEquals("outport", port.getName());		
	}

}
