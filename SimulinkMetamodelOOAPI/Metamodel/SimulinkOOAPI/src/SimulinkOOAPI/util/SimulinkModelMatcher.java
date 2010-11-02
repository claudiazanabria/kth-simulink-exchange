package SimulinkOOAPI.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.ecore.EObject;

import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.ProtoObject;

public class SimulinkModelMatcher extends GenericMatchEngine{
	
	@SuppressWarnings("unchecked")
	private boolean areChildrenSimilar(EObject obj1, EObject obj2) throws FactoryException{		
		try {
			Class a1 = obj1.getClass();			
			Method numberChildren = a1.getMethod("getNumberOfChildren");			
			Method getChildren = a1.getMethod("getAllChildren");
			Integer count = (Integer) numberChildren.invoke(obj2);
			if (numberChildren.invoke(obj1).equals(count)){
				List<ProtoObject> children1 = (List<ProtoObject>) getChildren.invoke(obj1);
				List<ProtoObject> children2 = (List<ProtoObject>) getChildren.invoke(obj2);
				//TODO: the order of children is not important!
				for (int i=0;i<count.intValue();i++){
					if (!isSimilar(children1.get(i), children2.get(i))){
						return false;
					}
				}
								
			}else{				
				return false;
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return true;
		
	}
	
	@Override
	protected boolean isSimilar(EObject obj1, EObject obj2)	throws FactoryException {
	   // If the instance metaclasses are not the same, then we don't want to match them.		 
		if (obj1.eClass() != obj2.eClass())
		    return false;		
		 
		//If we've got an Identity, only check the name similarity.		 
		if (obj1 instanceof Identity || obj2 instanceof Identity)
			return nameSimilarity(obj1, obj2) > 0.8;
			
		if (obj1 instanceof Model && obj2 instanceof Model || 
				obj1 instanceof Library && obj2 instanceof Library || 
				obj1 instanceof SimulinkOOAPI.System && obj2 instanceof SimulinkOOAPI.System){
			
			if (!areChildrenSimilar(obj1, obj2))
				return false;
		}		 
		 
		return super.isSimilar(obj1, obj2);
	}

}
