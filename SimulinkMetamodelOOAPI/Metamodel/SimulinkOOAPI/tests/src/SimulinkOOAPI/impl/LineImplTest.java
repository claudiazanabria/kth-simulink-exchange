package SimulinkOOAPI.impl;

//import junit.framework.AssertionFailedError;

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
import SimulinkOOAPI.ReflectionList;


@RunWith(JMock.class)
public class LineImplTest {
	Mockery context = new JUnit4Mockery();
	Model modelMock = context.mock(Model.class);
	Inport inportMock = context.mock(Inport.class);
	Outport outportMock = context.mock(Outport.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<Line> listMock = context.mock(ReflectionList.class);	
    Line line;
	
	@Before
	public void setUp(){	
		context.checking(new Expectations() {{
			ignoring(modelMock);			    
		}});
		
		line = LineImpl.newNamedWithinBetween("line", modelMock, inportMock, outportMock);					
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
