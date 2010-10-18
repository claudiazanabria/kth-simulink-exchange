package SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;


@RunWith(JMock.class)
public class ReflectionListImplTest {
	
	Mockery context = new JUnit4Mockery();	
	System systemMock = context.mock(System.class);
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
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		list.add(GainBlockImpl.newNamedWithinWithGain("gainblock", systemMock, 2));
		ReflectionList<ProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(1, result.size());
	}
	
	@Test
	public void testCollect2() throws Exception{
		list.add(ModelImpl.newNamed("model"));
		ReflectionList<ProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(0, result.size());
	}
}
