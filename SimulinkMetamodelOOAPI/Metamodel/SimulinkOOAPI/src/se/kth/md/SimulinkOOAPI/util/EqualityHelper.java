package se.kth.md.SimulinkOOAPI.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * A helper for determining whether two {@link EObject}s are structurally equal.
 * The class is extending {@link EcoreUtil.EqualityHelper}.
 * The only override method is {@link EcoreUtil.EqualityHelper#haveEqualAttribute}.
 * The method ignores uuids comparing i e returns true for attributes with 'uuid' name.
 */
public class EqualityHelper extends EcoreUtil.EqualityHelper{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2,
			EAttribute attribute) {
		if ("uuid".equals(attribute.getName()))
				return true;
		return super.haveEqualAttribute(eObject1, eObject2, attribute);
	}	 
	 

}
