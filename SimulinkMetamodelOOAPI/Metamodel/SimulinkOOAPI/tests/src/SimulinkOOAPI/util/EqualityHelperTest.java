package SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.impl.ModelImpl;
import SimulinkOOAPI.impl.SystemImpl;


public class EqualityHelperTest {
	
	@Test
	public void testEmptyModelsAreEqual(){
		Model modelA = ModelImpl.newNamed("a");
		Model modelB = ModelImpl.newNamed("a");
		
		assertTrue(modelA.equals(modelB));
	}
	
	@Test
	public void testEmptyModelsAreNotEqual(){
		Model modelA = ModelImpl.newNamed("a");
		Model modelB = ModelImpl.newNamed("b");
		
		assertFalse(modelA.equals(modelB));
	}
	
	@Test
	public void testModelsAreEqual(){
		Model modelA = ModelImpl.newNamed("a");
		Model modelB = ModelImpl.newNamed("a");
		
		SystemImpl.newNamedWithin("sysA", modelA);
		SystemImpl.newNamedWithin("sysB", modelA);
		SystemImpl.newNamedWithin("sysA", modelB);
		SystemImpl.newNamedWithin("sysB", modelA);
		
		assertTrue(modelA.equals(modelB));
	}

}

