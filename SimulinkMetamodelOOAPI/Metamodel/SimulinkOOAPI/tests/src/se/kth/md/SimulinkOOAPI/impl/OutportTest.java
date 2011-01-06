package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;


public class OutportTest {
	
	Mockery context = new JUnit4Mockery();
	System systemMock = context.mock(System.class);
	@SuppressWarnings("unchecked")	
	SimulinkList<Port> listMock = context.mock(SimulinkList.class);
    Outport port;
	
	@Before
	public void setUp() throws Exception, ProtoObjectCreationException {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		port = FactoryImpl.newOutportNamedWithin("outport", systemMock);
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
	public void testCreateOutport() throws Exception, ProtoObjectCreationException{
		context.checking(new Expectations() {{
			one(systemMock).addChild(with(any(Outport.class)));		    
		}});
		
		Outport port = OutportImpl.newNamedWithin("outport", systemMock);
		assertEquals("outport", port.getName());		
	}

}
