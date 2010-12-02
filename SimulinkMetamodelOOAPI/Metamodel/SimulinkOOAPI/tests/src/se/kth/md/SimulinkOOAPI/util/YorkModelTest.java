package se.kth.md.SimulinkOOAPI.util;

import static org.junit.Assert.assertTrue;

//import org.eclipse.emf.compare.match.metamodel.MatchModel;
//import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.junit.Test;

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;


public class YorkModelTest {	
	
	
	@Test
	public void testModelsCompare() throws ProtoObjectCreationException, AddChildException{		
		IModel modelA = YorkModel.buildWithECoreAPI();
		IModel modelB = YorkModel.buildWithSimulinkOOAPI();    
		//MatchModel match = EMFCompareWrapper.getMatch(modelA, modelB);
		
		assertTrue(EMFCompareWrapper.matched(modelA, modelB));		
	}	
	

}
