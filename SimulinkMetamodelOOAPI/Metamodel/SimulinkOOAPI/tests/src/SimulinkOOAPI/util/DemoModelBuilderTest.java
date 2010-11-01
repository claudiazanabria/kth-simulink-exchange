package SimulinkOOAPI.util;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.junit.Test;

import SimulinkOOAPI.Model;
import SimulinkOOAPI.impl.ModelImpl;
import SimulinkOOAPI.impl.SystemImpl;


public class DemoModelBuilderTest {
	
	@Test
	//TODO: delete this test
	public void testDummy() throws Exception{
		Model modelA = ModelImpl.newNamed("model");
		Model modelB = ModelImpl.newNamed("model");		
		
		for (DiffElement element : EMFCompareWrapper.getDifferenceElements(modelA, modelB)){
			System.out.println(element);
		}
	}
	
	@Test
	//TODO: delete this test
	public void testDummy2() throws Exception{
		Model modelA = ModelImpl.newNamed("model");
		Model modelB = ModelImpl.newNamed("modelB");
		SystemImpl.newNamedWithin("sys", modelA);
		
		for (DiffElement element : EMFCompareWrapper.getDifferenceElements(modelA, modelB)){
			System.out.println(element);
		}
	}
	
	@Test
	//TODO: delete this test
	public void testDummy3() throws Exception{
		Model modelA = ModelImpl.newNamed("model");
		SimulinkOOAPI.System modelB = SystemImpl.newNamedWithin("sys", modelA);		
		
		for (DiffElement element : EMFCompareWrapper.getDifferenceElements(modelA, modelB)){
			System.out.println(element);
		}
	}
	
	@Test
	public void testModelsCompare() throws Exception{
		Model modelA = DemoModelBuilder.buildYorkModelWithECoreAPI();
		Model modelB = DemoModelBuilder.buildYorkModelWithSimulinkOOAPI();    
	 
		for (DiffElement element : EMFCompareWrapper.getDifferenceElements(modelA, modelB)){
			System.out.println(element);
		}

	}

}
