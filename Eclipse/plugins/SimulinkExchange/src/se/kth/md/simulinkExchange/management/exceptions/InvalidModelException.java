package se.kth.md.simulinkExchange.management.exceptions;

/**
 * Thrown by ModelValidator when a model does not comply with the metamodel
 * @author Alex Schenkman
 *
 */
public class InvalidModelException extends Exception {

	private static final long serialVersionUID = 1L;

	protected InvalidObjectsTable invalidObjects;

	public InvalidModelException(InvalidObjectsTable invalidList) {
		super( invalidList.dumpToString() );
		invalidObjects = invalidList;
	}

	/**
	 * @return the invalid elements along with a short description on the failure.
	 */
	public InvalidObjectsTable getInvalidObjects() {
		return invalidObjects;
	}

}
