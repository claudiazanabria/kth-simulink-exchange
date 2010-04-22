package se.kth.md.simulinkExchange.modelManagement.exceptions;


import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * Thrown by ModelValidator when a model does not comply with the metamodel
 * @author Alex Schenkman
 *
 */
public class InvalidModelException extends Exception {

	private static final long serialVersionUID = 1L;

	private Hashtable<EObject, String> invalidObjects;

	public InvalidModelException(Hashtable<EObject, String> invalidList) {
		invalidObjects = invalidList;
	}

	/**
	 * @return the invalid elements along with a short description on the failure.
	 */
	public Hashtable<EObject, String> getInvalidObjects() {
		return invalidObjects;
	}

	/**
	 * Dumps the invalid objects to the console. Very useful for debugging a model.
	 */
	public void dumpInvalidObjectsToConsole() {
		for(Map.Entry<EObject, String> entry: invalidObjects.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}

	}
}
