/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.management;


import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;

import se.kth.md.management.exceptions.InvalidModelException;
import se.kth.md.management.exceptions.InvalidObjectsTable;

/**
 * Validates that a resource complies with the metamodel.
 * An EMF file contains a resource set. In other words, there can be many models within one file.
 * @author Alex Schenkman
 */
public class ModelValidator {

	Resource resource;
	InvalidObjectsTable invalidObjects;
	StringBuffer strBuffer;
	
	/**
	 * Creates a validator for resource.
	 * @param resource An EMF resource.
	 */
	public ModelValidator(Resource resource) {
		this.resource 	= resource;
		invalidObjects  = new InvalidObjectsTable();
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
