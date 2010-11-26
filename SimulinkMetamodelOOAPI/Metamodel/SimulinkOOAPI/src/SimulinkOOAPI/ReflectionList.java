package SimulinkOOAPI;

import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import SimulinkOOAPI.util.EqualityHelper;

/**
 * 
 * TODO: javadoc
 * @generated NOT
 */
public interface ReflectionList<T> extends EList<T>{
	
	/***
	 * Applies (invokes) the given method on each list element.
	 * @param methodName
	 * @throws IllegalArgumentException if method is can not be called on a list element
	 * @throws IllegalAccessException if the method is private or protected
	 * @throws InvocationTargetException wraps an exception thrown by the invoked method.
	 * @generated NOT
	 */
	public void apply(String methodName) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException;
	
	/***
	 * Returns a new list that contains all elements with applied the given method on them.
	 * @param methodName
	 * @generated NOT
	 */
	public ReflectionList<T> collect(String methodName) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException;
	
	/***
	 * Returns a new list that contains all elements that answer true to the given method application.
	 * @param methodName
	 * @generated NOT
	 */
	public ReflectionList<T> select(String methodName);
	
	/**
	 * Method for calling from the matching test.
	 * Returns true if this list contains the specified element.
	 * I. e. if the passing object is equals to some list element, 
	 * where the equality is delegate to {@link EqualityHelper}
	 */
	public boolean doesContain(EObject object);
	

}
