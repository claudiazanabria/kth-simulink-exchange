package SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;

//import org.eclipse.emf.compare.match.metamodel.MatchModel;
//import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.junit.Test;

import SimulinkOOAPI.Model;


public class YorkModelTest {	
	
	
	@Test
	public void testModelsCompare() throws Exception{		
		Model modelA = YorkModel.buildWithECoreAPI();
		Model modelB = YorkModel.buildWithSimulinkOOAPI();    
		//MatchModel match = EMFCompareWrapper.getMatch(modelA, modelB);
		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}	
	

}
