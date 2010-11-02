package SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.impl.ModelImpl;
import SimulinkOOAPI.impl.SystemImpl;


public class EMFCompareWrapperTest {
	
	@Test
	public void testMatchEqualModels(){
		Model modelA = ModelImpl.newNamed("model");
		Model modelB = ModelImpl.newNamed("model");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws Exception{		
		Model modelA = ModelImpl.newNamed("model");
		Model modelB = ModelImpl.newNamed("modelB");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws Exception{		
		Model modelA = ModelImpl.newNamed("model");
		Model modelB = ModelImpl.newNamed("model");
		SystemImpl.newNamedWithin("sys", modelA);
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}
	
	@Test	
	public void testNonMatchModels() throws Exception{		
		Model modelA = ModelImpl.newNamed("model");
		SimulinkOOAPI.System modelB = SystemImpl.newNamedWithin("sys", modelA);		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));
		assertNull(EMFCompareWrapper.getDifference(modelA, modelB));
	}

}
