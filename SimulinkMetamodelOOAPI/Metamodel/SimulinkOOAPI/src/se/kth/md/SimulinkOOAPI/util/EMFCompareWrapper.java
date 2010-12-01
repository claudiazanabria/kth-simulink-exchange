package se.kth.md.SimulinkOOAPI.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
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
	
	/**
	 * Returns the difference between the two models if the models are matched; null otherwise.
	 */
	public static DiffModel getDifference(EObject modelA, EObject modelB){
		MatchModel match = getMatch(modelA, modelB);
		if (matched(match))
			return new GenericDiffEngine().doDiff(match);		
		return null;
	}
	
	public static List<DiffElement> getDifferenceElements(EObject modelA, EObject modelB){
		DiffModel diff = getDifference(modelA, modelB);
		if (diff != null){
			final List<DiffElement> differences = new ArrayList<DiffElement>(diff.getOwnedElements());        
			//MergeService.merge(differences, true);
			return diff.getOwnedElements();
		}
		return new ArrayList<DiffElement>();
	}
	
	public static boolean matched(MatchModel match){		
		return match.getUnmatchedElements().isEmpty();
	}
	
//	public static ModelElementChangeLeftTarget isAdded(EObject instance, DiffModel diff) {
//		final EcoreUtil.CrossReferencer referencer = getCrossReferencer(instance, diff);
//		final Collection<EStructuralFeature.Setting> references = referencer.get(instance);
//		if (references != null && references.size() > 0) {
//			final Iterator<EStructuralFeature.Setting> it = references.iterator();
//			while (it.hasNext()) {
//				final EStructuralFeature.Setting setting = it.next();
//				final EObject eObj = setting.getEObject();
//				if (eObj instanceof ModelElementChangeLeftTarget
//						&& ((ModelElementChangeLeftTarget)eObj).getLeftElement() == instance)
//					return (ModelElementChangeLeftTarget)eObj;
//			}
//		}
//		return null;
//
//	}
//
//	public static EcoreUtil.CrossReferencer getCrossReferencer(EObject instance, DiffModel diff) {
//		final Collection<EObject> models = new ArrayList<EObject>(2);
//		models.add(instance);
//		models.add(diff);
//		final EcoreUtil.CrossReferencer referencer = new EcoreUtil.CrossReferencer(models) {
//			private static final long serialVersionUID = 1L;
//
//			// initializer for this anonymous class
//			{
//				crossReference();
//			}
//
//		};
//		return referencer;
//	}
	
	
}
