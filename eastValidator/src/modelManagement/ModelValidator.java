package modelManagement;

import java.util.Hashtable;

import modelManagement.exceptions.InvalidModelException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

public class ModelValidator {

	Resource resource;
	Hashtable<EObject, String> invalidObjects;
	StringBuffer strBuffer;
	
	public ModelValidator(Resource resource) {
		this.resource 	= resource;
		invalidObjects  = new Hashtable<EObject, String>();
	}
	
	public void doIt() throws InvalidModelException {
		validateEachElement();
		
		if (! invalidObjects.isEmpty() ) {
			throw new InvalidModelException( invalidObjects );
		}
	}

	/**
	 * 
	 */
	private void validateEachElement() {
		for (EObject eObject : resource.getContents()) {
			addToListIfInvalid(eObject);
		}
	}

	private void addToListIfInvalid(EObject eObject) {
		if (! validateEObject(eObject) ) {
			invalidObjects.put(eObject, strBuffer.toString());
		}		
	}
	
	private Boolean validateEObject(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resetStringBuffer();
			printDiagnostic(diagnostic, "");
			return false;
		}
		return true;
	}

	private void resetStringBuffer() {
		//I don't know how to reset a buffer, so I create a new one.
		strBuffer = new StringBuffer(500);
	}

	private void printDiagnostic(Diagnostic diagnostic, 
			String indent) {
		recordIndentedMessage(diagnostic.getMessage(), indent);
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child, indent + "  ");
		}
	}

	/**
	 * @param message
	 * @param indent
	 */
	private void recordIndentedMessage(String message, String indent) {
		strBuffer.append(indent);
		strBuffer.append(message);
		strBuffer.append('\n');
	}
}
