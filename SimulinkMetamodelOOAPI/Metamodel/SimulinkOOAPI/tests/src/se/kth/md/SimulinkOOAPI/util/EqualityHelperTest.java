package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.impl.Factory;


public class EqualityHelperTest {
	
	EqualityHelper helper = new EqualityHelper();
	
	@Test
	public void testEmptyModelsAreEqual() throws Exception{
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("a");
		
		assertTrue(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual() throws Exception{
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("b");
		
		assertFalse(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testModelsAreEqual() throws Exception{
		IModel modelA = Factory.newModelNamed("a");
		IModel modelB = Factory.newModelNamed("a");
		
		Factory.newSystemNamedWithin("sysA", modelA);
		Factory.newSystemNamedWithin("sysB", modelA);
		Factory.newSystemNamedWithin("sysA", modelB);
		Factory.newSystemNamedWithin("sysB", modelB);
		
		assertTrue(helper.equals(modelA, modelB));
	}

}

