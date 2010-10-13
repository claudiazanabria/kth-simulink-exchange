package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;


@RunWith(JMock.class)
public class ReflectionListImplTest {
	
	Mockery context = new JUnit4Mockery();
	Identity identityMock = context.mock(Identity.class);
	ReflectionListImpl<ProtoObject> list;
	
	@Before
	public void setUp(){
		list = new ReflectionListImpl<ProtoObject>();		
	}

	@Test
	public void testCollect() throws Exception{
//		list.apply("addInListIfGainBlock", new Class[]{
//				ReflectionList.class,				
//		});
		list.add(new GainBlockImpl(identityMock));
		ReflectionList<ProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(1, result.size());
	}
	
	@Test
	public void testCollect2() throws Exception{
		list.add(new ModelImpl(identityMock));
		ReflectionList<ProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(0, result.size());
	}
}
