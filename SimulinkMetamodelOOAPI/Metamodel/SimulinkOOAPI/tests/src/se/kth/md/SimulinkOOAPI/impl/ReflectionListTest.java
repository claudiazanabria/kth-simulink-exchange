package se.kth.md.SimulinkOOAPI.impl;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISystem;


@RunWith(JMock.class)
public class ReflectionListTest {
	
	Mockery context = new JUnit4Mockery();	
	ISystem systemMock = context.mock(ISystem.class);
	IReflectionList<IProtoObject> list;	
	
	@Before
	public void setUp(){
		list = new ReflectionList<IProtoObject>();		
	}

	@Test
	public void testCollect() throws Exception{
//		list.apply("addInListIfGainBlock", new Class[]{
//				ReflectionList.class,				
//		});
		context.checking(new Expectations() {{			
			ignoring(systemMock);
		}});
		
		list.add(Factory.newGainBlockNamedWithinWithGain("gain", systemMock, 3));
		IReflectionList<IProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(1, result.size());
	}
	
	@Test
	public void testCollect2() throws Exception{
		list.add(Factory.newModelNamed("model"));
		IReflectionList<IProtoObject> result = list.collect("ifGainBlockAddToList");
		assertEquals(0, result.size());
	}
}
