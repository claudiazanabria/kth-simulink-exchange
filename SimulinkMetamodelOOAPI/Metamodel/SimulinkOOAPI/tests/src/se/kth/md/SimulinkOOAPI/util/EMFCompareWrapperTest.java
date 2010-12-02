package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.impl.Factory;


public class EMFCompareWrapperTest {
	
	
	@Test
	public void testMatchEqualModels() throws Exception{
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("a");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws Exception{		
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("b");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws Exception{		
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("a");
		Factory.newSystemNamedWithin("sys", modelA);
		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithEqualChild() throws Exception{		
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("a");
		Factory.newSystemNamedWithin("sys", modelA);
		Factory.newSystemNamedWithin("sys", modelB);
		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test	
	public void testNonMatchModels() throws Exception{		
		IModel modelA = Factory.newModelNamed("a");
		ISystem modelB = Factory.newSystemNamedWithin("sys", modelA);		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
	}

}
