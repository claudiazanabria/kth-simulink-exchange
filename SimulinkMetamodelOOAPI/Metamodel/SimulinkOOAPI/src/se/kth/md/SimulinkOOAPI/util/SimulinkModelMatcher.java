package se.kth.md.SimulinkOOAPI.util;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;

import se.kth.md.SimulinkOOAPI.IIdentity;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISystem;

public class SimulinkModelMatcher extends GenericMatchEngine{
	
	@Override
	protected boolean isSimilar(EObject obj1, EObject obj2)	throws FactoryException {
	   // If the instance metaclasses are not the same, then we don't want to match them.		 
		if (obj1.eClass() != obj2.eClass())
		    return false;		
		 
		//If we've got an Identity, only check the name similarity.		 
		if (obj1 instanceof IIdentity || obj2 instanceof IIdentity)
			return ((IIdentity) obj1).getName().equals(((IIdentity) obj2).getName());
		
		//If we've got a Model, System, or Library, compare their children lists.	
		if (obj1 instanceof IModel && obj2 instanceof IModel){										
			if(!areChildrenSimilar((IModel) obj1, (IModel) obj2))
				return false;							
		}	
		
		if (obj1 instanceof ISystem && obj2 instanceof ISystem){
			if(!areChildrenSimilar((ISystem) obj1, (ISystem) obj2))
				return false;		
		}	
		
		if (obj1 instanceof ILibrary && obj2 instanceof ILibrary){
			if(!areChildrenSimilar((ILibrary) obj1, (ILibrary) obj2))
				return false;	
		}	 
		
		return super.isSimilar(obj1, obj2);
	}
	
	private boolean areChildrenSimilar(IModel obj1, IModel obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ISimulinkList<IProtoObject> children1 = obj1.getAllChildren();
			ISimulinkList<IProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(ISystem obj1, ISystem obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ISimulinkList<IProtoObject> children1 = obj1.getAllChildren();
			ISimulinkList<IProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(ILibrary obj1, ILibrary obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ISimulinkList<IProtoObject> children1 = obj1.getAllChildren();
			ISimulinkList<IProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(ISimulinkList<IProtoObject> children1, ISimulinkList<IProtoObject> children2){
		for (IProtoObject element: children1){
			if (!children2.doesContain(element)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean haveChildrenSameSize(IModel obj1, IModel obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}
	
	private boolean haveChildrenSameSize(ISystem obj1, ISystem obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}
	
	private boolean haveChildrenSameSize(ILibrary obj1, ILibrary obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}	
	
}
