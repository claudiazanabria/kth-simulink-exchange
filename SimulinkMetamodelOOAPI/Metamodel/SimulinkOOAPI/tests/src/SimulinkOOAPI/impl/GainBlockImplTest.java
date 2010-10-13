package SimulinkOOAPI.impl;

import junit.framework.AssertionFailedError;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Identity;
import SimulinkOOAPI.ReflectionList;


@RunWith(JMock.class)
public class GainBlockImplTest {
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	@SuppressWarnings("unchecked")	
	ReflectionList<GainBlock> listMock = context.mock(ReflectionList.class);	
    GainBlockImpl gainBlock;
	
	@Before
	public void setUp(){		
		gainBlock = new GainBlockImpl(new IdentityImpl(), 3);					
	}
	
	@Test
	public void testDefaultConstructorIsNotAllowed(){
		try{
			new GainBlockImpl();
			//if constructor was called successfully, the test has not passed
			throw new AssertionFailedError();
		}catch(UnsupportedOperationException e){
			//test passed
		}
	}	
	
	@Test
	public void testIfGainBlockAddToList() throws Exception{		
		context.checking(new Expectations() {{
			one (listMock).add(with(gainBlock));			    
		}});
		
		gainBlock.ifGainBlockAddToList(listMock);
	}	
	

}
