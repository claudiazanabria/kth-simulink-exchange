package se.kth.md.SimulinkOOAPI.util;

import java.util.Collections;

import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;

public class EMFCompareWrapper {
	
	/**
	 * Returns the match between the two models.
	 */
	public static MatchModel getMatch(EObject modelA, EObject modelB){
		return new SimulinkModelMatcher().contentMatch(modelA, modelB, Collections.<String, Object> emptyMap());
	}
	
	/**
	 * Returns true if the two models are matched.	 
	 */
	public static boolean matched(EObject modelA, EObject modelB){
		MatchModel match = getMatch(modelA, modelB);
		return matched(match);
	}		
	
	private static boolean matched(MatchModel match){		
		return match.getUnmatchedElements().isEmpty();
	}
	
}
