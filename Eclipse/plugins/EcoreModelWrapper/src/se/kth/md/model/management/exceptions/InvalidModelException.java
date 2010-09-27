/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.model.management.exceptions;

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
