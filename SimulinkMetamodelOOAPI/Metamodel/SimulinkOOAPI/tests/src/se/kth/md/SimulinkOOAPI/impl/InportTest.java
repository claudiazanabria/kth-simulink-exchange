package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.System;


public class InportTest {
	
	Mockery context = new JUnit4Mockery();
	System systemMock = context.mock(System.class);
	@SuppressWarnings("unchecked")	
	SimulinkList<Port> listMock = context.mock(SimulinkList.class);
    Inport port;
	
	@Before
	public void setUp() throws Exception {
		context.checking(new Expectations() {{
			one(systemMock).addChild(with(any(Inport.class)));		    
		}});
		
		port = FactoryImpl.newInportNamedWithin("inport", systemMock);		 					
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
	public void testCreateInport() throws Exception {
		context.checking(new Expectations() {{
			one(systemMock).addChild(with(any(Inport.class)));		    
		}});
		
		Inport inport = InportImpl.newNamedWithin("inport", systemMock);
		assertEquals("inport", inport.getName());		
	}

}
