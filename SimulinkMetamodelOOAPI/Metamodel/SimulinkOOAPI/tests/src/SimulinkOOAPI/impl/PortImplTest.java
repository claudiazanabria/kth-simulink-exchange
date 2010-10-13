package SimulinkOOAPI.impl;

import junit.framework.AssertionFailedError;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;

@RunWith(JMock.class)
public class PortImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
    PortImpl port;
	
	@Before
	public void setUp(){		
		port = new PortImpl(identityMock);					
	}
	
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new PortImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	

}
