package SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.junit.Test;

import SimulinkOOAPI.Model;


public class DemoModelBuilderTest {	
	
	
	@Test
	public void testModelsCompare() throws Exception{		
		Model modelA = DemoModelBuilder.buildYorkModelWithECoreAPI();
		Model modelB = DemoModelBuilder.buildYorkModelWithSimulinkOOAPI();    
		MatchModel match = EMFCompareWrapper.getMatch(modelA, modelB);
		for (UnmatchElement element: match.getUnmatchedElements()){
			System.out.println(element);
			System.out.println(element.getElement());
		}
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}

}
