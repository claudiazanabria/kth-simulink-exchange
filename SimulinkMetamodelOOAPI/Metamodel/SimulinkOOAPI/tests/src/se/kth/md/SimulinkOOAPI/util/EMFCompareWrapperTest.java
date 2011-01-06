package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.*;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.impl.FactoryImpl;


public class EMFCompareWrapperTest {
	
	
	@Test
	public void testMatchEqualModels() throws ProtoObjectCreationException{
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("a");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));				
	}
	
	@Test
	public void testMatchModelsWithDiffNames() throws ProtoObjectCreationException{		
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("b");		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithDiffChild() throws ProtoObjectCreationException{		
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("a");
		FactoryImpl.newSystemNamedWithin("sys", modelA);
		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test
	public void testMatchModelsWithEqualChild() throws ProtoObjectCreationException{		
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("a");
		FactoryImpl.newSystemNamedWithin("sys", modelA);
		FactoryImpl.newSystemNamedWithin("sys", modelB);
		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}
	
	@Test	
	public void testNonMatchModels() throws ProtoObjectCreationException{		
		Model modelA = FactoryImpl.newModelNamed("a");
		System modelB = FactoryImpl.newSystemNamedWithin("sys", modelA);		
		assertFalse(EMFCompareWrapper.matched(modelA, modelB));		
	}

}
