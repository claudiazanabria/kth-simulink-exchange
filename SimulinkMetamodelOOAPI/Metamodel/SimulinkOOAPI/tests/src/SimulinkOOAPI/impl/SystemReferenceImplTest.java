package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;
import SimulinkOOAPI.util.ErrorMessages;

@RunWith(JMock.class)
public class SystemReferenceImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Port portMock = context.mock(Port.class);	
	System systemMock = context.mock(SimulinkOOAPI.System.class);
    SystemReference systemReference;
	
	@Before
	public void setUp(){}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new SystemReferenceImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/
	
	@Test
	public void testCreateInvalidSystemReference() throws Exception{
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		try{
			Factory.createSystemReference().targeting(systemMock).within(systemMock).withName("sysRef").please();			
		}catch(IllegalArgumentException e){
			assertEquals(ErrorMessages.SYS_REF_TARGET_EQUALS_PARENT, e.getMessage());
		}
	}
	
}

