package se.kth.md.SimulinkOOAPI.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;

import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.util.EqualityHelper;


/**
 * @generated NOT
 */
public class SimulinkList<T> extends BasicEList<T> implements ISimulinkList<T>{
	
	private static final long serialVersionUID = 1L;
	
	private Method getMethod(String methodName) throws ClassNotFoundException, NoSuchMethodException{

		Class cl = Class.forName("se.kth.md.SimulinkOOAPI.impl.ProtoObject");//ProtoObjectImpl.class;		
		
		return cl.getMethod(methodName, new Class[]{ISimulinkList.class});
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void apply(String methodName) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		//TODO: generate
	}

	/**
	 * @generated NOT
	 */
	@Override
	public ISimulinkList<T> collect(String methodName) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		ISimulinkList<T> result = new SimulinkList<T>();
		try {
			Method method = getMethod(methodName);
			ListIterator<T> iterator = basicListIterator();
			
			while (iterator.hasNext()) {
				T element = iterator.next();
				method.invoke(element, result);
			}
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ISimulinkList<T> select(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public boolean doesContain(EObject object) {
		if (object != null) {
	      for (int i = 0; i < size; ++i) {
	    	if(data[i] instanceof EObject){
	    		if (new EqualityHelper().equals((EObject)data[i], object))
	    			return true;
	    	}
	      }
	    }
	    else {
	      for (int i = 0; i < size; ++i) {
	        if (data[i] == object)	        
	          return true;	        
	      }
	    }

	    return false;		
	}

}
