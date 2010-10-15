package SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ReflectionList;


@RunWith(JMock.class)
public class LineImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	Port portMock = context.mock(Port.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<Line> listMock = context.mock(ReflectionList.class);	
    LineImpl line;
	
	@Before
	public void setUp(){		
		line = new LineImpl(identityMock, portMock, portMock);					
	}
	
	//Incorrect test! Default constructor should be allowed in order not to break emf core api. 
	/*
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new LineImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}*/
	
	
	@Test
	public void testIfLineAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(line));			    
		}});
		
		line.ifLineAddToList(listMock);
	}	

}
