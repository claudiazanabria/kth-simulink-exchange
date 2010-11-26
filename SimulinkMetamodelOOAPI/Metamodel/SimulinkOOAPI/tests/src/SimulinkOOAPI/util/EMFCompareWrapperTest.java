package SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.System;
import SimulinkOOAPI.impl.Factory;


public class EMFCompareWrapperTest {
	
	
	@Test
	public void testMatchEqualModels() throws Exception{
		Model modelA = Factory.createModel().withName("a").please();
		Model modelB = Factory.createModel().withName("a").please();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws Exception{		
		Model modelA = Factory.createModel().withName("a").please();
		Model modelB = Factory.createModel().withName("b").please();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws Exception{		
		Model modelA = Factory.createModel().withName("a").please();
		Model modelB = Factory.createModel().withName("a").please();
		Factory.createSystem().within(modelA).withName("sys");
		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}
	
	@Test	
	public void testNonMatchModels() throws Exception{		
		Model modelA = Factory.createModel().withName("a").please();
		System modelB = Factory.createSystem().within(modelA).withName("sys").please();		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}

}
