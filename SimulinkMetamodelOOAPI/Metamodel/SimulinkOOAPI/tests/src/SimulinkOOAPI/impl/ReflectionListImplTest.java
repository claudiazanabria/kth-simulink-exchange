package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;


public class ReflectionListImplTest {
	
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
		list.add(new GainBlockImpl(new IdentityImpl()));
		ReflectionList<ProtoObject> result = list.collect("addInListIfGainBlock");
		assertEquals(1, result.size());
	}
	
	@Test
	public void testCollect2() throws Exception{
		list.add(new ModelImpl(new IdentityImpl()));
		ReflectionList<ProtoObject> result = list.collect("addInListIfGainBlock");
		assertEquals(0, result.size());
	}
}
