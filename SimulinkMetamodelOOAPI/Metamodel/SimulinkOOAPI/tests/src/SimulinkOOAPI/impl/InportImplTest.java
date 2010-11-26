package SimulinkOOAPI.impl;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;


public class InportImplTest {
	
	Mockery context = new JUnit4Mockery();
	System systemMock = context.mock(System.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<Port> listMock = context.mock(ReflectionList.class);
    Inport port;
	
	@Before
	public void setUp() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		port = Factory.createInport().withName("inport").within(systemMock).please();		 					
	}	
	
	@Test
	public void testIfPortAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(port));
			
			ignoring(listMock);
		}});
		
		port.ifPortAddToList(listMock);
	}	


}
