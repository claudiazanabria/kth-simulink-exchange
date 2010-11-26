package SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.impl.Factory;


public class EqualityHelperTest {	
	
	@Test
	public void testEmptyModelsAreEqual() throws Exception{
		Model modelA = (Model) Factory.createModel().withName("a").please();
		Model modelB = (Model) Factory.createModel().withName("a").please();
		
		assertTrue(modelA.equals(modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual() throws Exception{
		Model modelA = (Model) Factory.createModel().withName("a").please();
		Model modelB = (Model) Factory.createModel().withName("b").please();
		
		assertFalse(modelA.equals(modelB));
	}
	
	@Test
	public void testModelsAreEqual() throws Exception{
		Model modelA = (Model) Factory.createModel().withName("a").please();
		Model modelB = (Model) Factory.createModel().withName("a").please();
		
		Factory.createSystem().within(modelA).withName("sysA").please();
		Factory.createSystem().within(modelA).withName("sysB").please();
		Factory.createSystem().within(modelB).withName("sysA").please();
		Factory.createSystem().within(modelB).withName("sysB").please();
		
		assertTrue(modelA.equals(modelB));
	}

}

