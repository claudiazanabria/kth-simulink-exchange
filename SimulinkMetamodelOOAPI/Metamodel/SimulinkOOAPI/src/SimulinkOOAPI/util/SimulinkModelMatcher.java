package SimulinkOOAPI.util;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;

public class SimulinkModelMatcher extends GenericMatchEngine{
	
	@Override
	protected boolean isSimilar(EObject obj1, EObject obj2)	throws FactoryException {
	   // If the instance metaclasses are not the same, then we don't want to match them.		 
		if (obj1.eClass() != obj2.eClass())
		    return false;		
		 
		//If we've got an Identity, only check the name similarity.		 
		if (obj1 instanceof Identity || obj2 instanceof Identity)
			return nameSimilarity(obj1, obj2) > 0.8;
		
		//If we've got a Model, System, or Library, compare their children lists.	
		if (obj1 instanceof Model && obj2 instanceof Model){										
			if(!areChildrenSimilar((Model) obj1, (Model) obj2))
				return false;							
		}	
		
		if (obj1 instanceof System && obj2 instanceof System){
			if(!areChildrenSimilar((System) obj1, (System) obj2))
				return false;		
		}	
		
		if (obj1 instanceof Library && obj2 instanceof Library){
			if(!areChildrenSimilar((Library) obj1, (Library) obj2))
				return false;	
		}	 
		
		return super.isSimilar(obj1, obj2);
	}
	
	private boolean areChildrenSimilar(Model obj1, Model obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ReflectionList<ProtoObject> children1 = obj1.getAllChildren();
			ReflectionList<ProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(System obj1, System obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ReflectionList<ProtoObject> children1 = obj1.getAllChildren();
			ReflectionList<ProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(Library obj1, Library obj2){
		if (haveChildrenSameSize(obj1, obj2)){
			ReflectionList<ProtoObject> children1 = obj1.getAllChildren();
			ReflectionList<ProtoObject> children2 = obj2.getAllChildren();		
			if(!areChildrenSimilar(children1, children2))
				return false;
		
			return true;
		}
		
		return false;
	}
	
	private boolean areChildrenSimilar(ReflectionList<ProtoObject> children1, ReflectionList<ProtoObject> children2){
		for (ProtoObject element: children1){
			if (!children2.doesContain(element)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean haveChildrenSameSize(Model obj1, Model obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}
	
	private boolean haveChildrenSameSize(System obj1, System obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}
	
	private boolean haveChildrenSameSize(Library obj1, Library obj2){
		return obj1.getNumberOfChildren() == obj2.getNumberOfChildren();
	}	
	
}
