package se.kth.md.simulinkExchange.modelManagement;


import java.util.Hashtable;


import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

import se.kth.md.simulinkExchange.modelManagement.exceptions.InvalidModelException;

/**
 * Validates that a resource complies with the metamodel.
 * An EMF file contains a resource set. In other words, there can be many models within one file.
 * @author Alex Schenkman
 */
public class ModelValidator {

	Resource resource;
	Hashtable<EObject, String> invalidObjects;
	StringBuffer strBuffer;
	
	/**
	 * Creates a validator for resource.
	 * @param resource An EMF resource.
	 */
	public ModelValidator(Resource resource) {
		this.resource 	= resource;
		invalidObjects  = new Hashtable<EObject, String>();
	}
	
	/**
	 * Starts the validation. Screen output is generated for invalid elements.
	 * @throws InvalidModelException if the model is invalid.
	 */
	public void doIt() throws InvalidModelException {
		validateEachElement();
		
		if (! invalidObjects.isEmpty() ) {
			throw new InvalidModelException( invalidObjects );
		}
	}

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

	private void recordIndentedMessage(String message, String indent) {
		strBuffer.append(indent);
		strBuffer.append(message);
		strBuffer.append('\n');
	}
}
