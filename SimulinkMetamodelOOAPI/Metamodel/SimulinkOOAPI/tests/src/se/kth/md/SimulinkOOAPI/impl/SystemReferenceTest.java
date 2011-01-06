package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;
//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.Identity;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;


@RunWith(JMock.class)
public class SystemReferenceTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Port portMock = context.mock(Port.class);
	Model modelMock = context.mock(Model.class);
	System systemMock = context.mock(System.class);
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
	public void testCreateInvalidSystemReference() throws Exception {
		context.checking(new Expectations() {{
			ignoring(systemMock);			    
		}});
		
		try{
			FactoryImpl.newSystemReferemceNamedWithinTargeting("sysRef", systemMock, systemMock);			
		}catch(ProtoObjectCreationException e){
			assertEquals(ErrorMessages.SYS_REF_TARGET_EQUALS_PARENT, e.getMessage());
		}
	}
	
	@Test
	public void testCreateWithinModel() throws Exception{		
		context.checking(new Expectations() {{					
			one(modelMock).addChild(with(any(SystemReference.class)));			
			ignoring(systemMock);	
		}});	
		
		SystemReference sysRef = SystemReferenceImpl.newNamedWithinTargeting("sysRef", modelMock, systemMock);		
		assertEquals("sysRef", sysRef.getName());
		assertEquals(systemMock, sysRef.getTarget());
	}
	
	@Test
	public void testCreateWithinSystem() throws Exception{		
		context.checking(new Expectations() {{					
			one(systemMock).addChild(with(any(SystemReference.class)));
			
			ignoring(systemMock);
			ignoring(modelMock);
		}});	
		
		System targetSystem = SystemImpl.newNamedWithin("target", modelMock);
		SystemReference sysRef = SystemReferenceImpl.newNamedWithinTargeting("sysRef", systemMock, targetSystem);		
		assertEquals("sysRef", sysRef.getName());
		assertEquals(targetSystem, sysRef.getTarget());
	}
	
}

