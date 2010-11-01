package SimulinkOOAPI.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.EObject;

public class EMFCompareWrapper {
	
	public static DiffModel getDifference(EObject modelA, EObject modelB){
		/**
		 * Returns the difference between the two models.
		 */		
		MatchModel match = new GenericMatchEngine().contentMatch(modelA, modelB, Collections.<String, Object> emptyMap());
		DiffModel diff =  new GenericDiffEngine().doDiff(match);
//		try {
//			System.out.println(ModelUtils.serialize(diff));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return diff;
	}
	
	public static List<DiffElement> getDifferenceElements (EObject modelA, EObject modelB){
		/**
		 * Merges the two models and returns list of different elements or empty list if the two models are equals.
		 */
		DiffModel diff = getDifference(modelA, modelB);
		
		final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());    
        MergeService.merge(differences, true);
        
        return diff.getOwnedElements();
	}	

}
