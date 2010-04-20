package modelManagement.exceptions;


import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class InvalidModelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Hashtable<EObject, String> invalidObjects;

	public InvalidModelException(Hashtable<EObject, String> invalidList) {
		invalidObjects = invalidList;
	}

	public Hashtable<EObject, String> getInvalidObjects() {
		return invalidObjects;
	}

	public void dumpInvalidObjectsToConsole() {
		for(Map.Entry<EObject, String> entry: invalidObjects.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}

	}
}
