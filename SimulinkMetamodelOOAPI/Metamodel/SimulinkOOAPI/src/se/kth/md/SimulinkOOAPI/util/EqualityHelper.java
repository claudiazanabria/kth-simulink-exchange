package se.kth.md.SimulinkOOAPI.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class EqualityHelper extends EcoreUtil.EqualityHelper{

	
	private static final long serialVersionUID = 1L;

	public boolean equals(EObject eObject1, EObject eObject2) {
		// If the first object is null, the second object must be null.
		//
		if (eObject1 == null) {
			return eObject2 == null;
		}

		// We know the first object isn't null, so if the second one is, it
		// can't be equal.
		//
		if (eObject2 == null) {
			return false;
		}

		// If they don't have the same class, they can't be equal.
		//
		EClass eClass = eObject1.eClass();
		if (eClass != eObject2.eClass()) {
			return false;
		}

	
		for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
			// Ignore derived features.
			//
			EStructuralFeature feature = eClass.getEStructuralFeature(i);
			if (!feature.isDerived()) {
				
				if (!haveEqualFeature(eObject1, eObject2, feature)) {
//					System.out.println("not equal: ");
//					if (eObject1 instanceof SimulinkOOAPI.System){
//					System.out.println( ((SimulinkOOAPI.System)eObject1).getIdentity().getName());
//					System.out.println( ((SimulinkOOAPI.System)eObject2).getIdentity().getName());
//					}
////					System.out.println(eObject2);
//					System.out.println(feature);
					return false;
				}
			}
		}

		// There's no reason they aren't equal, so they are.
		//		
		return true;
	}
	
	@Override
	protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2,
			EAttribute attribute) {
		if ("uuid".equals(attribute.getName()))
				return true;
		return super.haveEqualAttribute(eObject1, eObject2, attribute);
	}	 
	 

}
