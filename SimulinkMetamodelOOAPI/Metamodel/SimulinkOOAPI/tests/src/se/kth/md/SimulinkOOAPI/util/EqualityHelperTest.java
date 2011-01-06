package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;
import se.kth.md.SimulinkOOAPI.impl.FactoryImpl;


public class EqualityHelperTest {
	
	EqualityHelper helper = new EqualityHelper();
	
	@Test
	public void testEmptyModelsAreEqual() throws ProtoObjectCreationException{
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("a");
		
		assertTrue(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual() throws ProtoObjectCreationException{
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("b");
		
		assertFalse(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testModelsAreEqual() throws ProtoObjectCreationException{
		Model modelA = FactoryImpl.newModelNamed("a");
		Model modelB = FactoryImpl.newModelNamed("a");
		
		FactoryImpl.newSystemNamedWithin("sysA", modelA);
		FactoryImpl.newSystemNamedWithin("sysB", modelA);
		FactoryImpl.newSystemNamedWithin("sysA", modelB);
		FactoryImpl.newSystemNamedWithin("sysB", modelB);
		
		assertTrue(helper.equals(modelA, modelB));
	}

}

