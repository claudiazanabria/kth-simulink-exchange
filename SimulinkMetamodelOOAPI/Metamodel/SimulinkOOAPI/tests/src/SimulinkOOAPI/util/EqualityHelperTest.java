package SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.impl.CreationFactory;


public class EqualityHelperTest {
	
	CreationFactory factory = new CreationFactory();
	
	@Test
	public void testEmptyModelsAreEqual() throws Exception{
		Model modelA = (Model) factory.createModel().withName("a").please();
		Model modelB = (Model) factory.createModel().withName("a").please();
		
		assertTrue(modelA.equals(modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual() throws Exception{
		Model modelA = (Model) factory.createModel().withName("a").please();
		Model modelB = (Model) factory.createModel().withName("b").please();
		
		assertFalse(modelA.equals(modelB));
	}
	
	@Test
	public void testModelsAreEqual() throws Exception{
		Model modelA = (Model) factory.createModel().withName("a").please();
		Model modelB = (Model) factory.createModel().withName("a").please();
		
		factory.createSystem().within(modelA).withName("sysA").please();
		factory.createSystem().within(modelA).withName("sysB").please();
		factory.createSystem().within(modelB).withName("sysA").please();
		factory.createSystem().within(modelB).withName("sysB").please();
		
		assertTrue(modelA.equals(modelB));
	}

}

