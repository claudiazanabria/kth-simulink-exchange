package SimulinkOOAPI.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;

import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;

/**
 * @generated NOT
 */
public class ReflectionListImpl<T> extends BasicEList<T> implements ReflectionList<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Method getMethod(String methodName) throws ClassNotFoundException, NoSuchMethodException{

		Class<ProtoObject> cl = (Class<ProtoObject>)Class.forName("SimulinkOOAPI.impl.ProtoObjectImpl");//ProtoObjectImpl.class;		
		
		return cl.getMethod(methodName, new Class[]{ReflectionList.class});
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
	public ReflectionList<T> collect(String methodName) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		ReflectionList<T> result = new ReflectionListImpl<T>();
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
	public ReflectionList<T> select(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}

}
