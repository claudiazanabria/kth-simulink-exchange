package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.impl.Factory;


public class EMFCompareWrapperTest {
	
	
	@Test
	public void testMatchEqualModels() throws Exception{
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("a").createModel();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws Exception{		
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("b").createModel();		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws Exception{		
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("a").createModel();
		new Factory.Builder().within(modelA).named("sys").createSystem();
		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}
	
	@Test	
	public void testNonMatchModels() throws Exception{		
		IModel modelA = new Factory.Builder().named("a").createModel();
		ISystem modelB = new Factory.Builder().within(modelA).named("sys").createSystem();		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}

}
