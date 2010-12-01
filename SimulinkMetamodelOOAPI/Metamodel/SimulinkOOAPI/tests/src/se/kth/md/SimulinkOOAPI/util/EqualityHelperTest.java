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
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("a").createModel();
		
		assertTrue(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual() throws Exception{
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("b").createModel();
		
		assertFalse(helper.equals(modelA, modelB));
	}
	
	@Test
	public void testModelsAreEqual() throws Exception{
		IModel modelA = new Factory.Builder().named("a").createModel();
		IModel modelB = new Factory.Builder().named("a").createModel();
		
		new Factory.Builder().within(modelA).named("sysA").createSystem();
		new Factory.Builder().within(modelA).named("sysB").createSystem();
		new Factory.Builder().within(modelB).named("sysA").createSystem();
		new Factory.Builder().within(modelB).named("sysB").createSystem();
		
		assertTrue(helper.equals(modelA, modelB));
	}

}

