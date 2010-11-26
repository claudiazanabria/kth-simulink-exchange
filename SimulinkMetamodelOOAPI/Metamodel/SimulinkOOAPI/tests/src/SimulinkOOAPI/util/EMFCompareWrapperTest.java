package SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.System;
import SimulinkOOAPI.impl.Factory;


public class EMFCompareWrapperTest {
	
	
	@Test
	public void testMatchEqualModels() throws Exception{
		Model modelA = new Factory.Builder().named("a").createModel();
		Model modelB = new Factory.Builder().named("a").createModel();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws Exception{		
		Model modelA = new Factory.Builder().named("a").createModel();
		Model modelB = new Factory.Builder().named("b").createModel();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws Exception{		
		Model modelA = new Factory.Builder().named("a").createModel();
		Model modelB = new Factory.Builder().named("a").createModel();
		new Factory.Builder().within(modelA).named("sys").createSystem();
		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}
	
	@Test	
	public void testNonMatchModels() throws Exception{		
		Model modelA = new Factory.Builder().named("a").createModel();
		System modelB = new Factory.Builder().within(modelA).named("sys").createSystem();		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}

}
