/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.management.exceptions;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class InvalidObjectsTable extends Hashtable<EObject, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8042801816811465291L;

	/**
	 * Dumps the invalid objects to the console. Very useful for debugging a model.
	 */
	public void dumpToStdout() {
		for(Map.Entry<EObject, String> entry: this.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}
	}
	
	/**
	 * Dumps the invalid objects to the console. Very useful for debugging a model.
	 */
	public String dumpToString() {
		StringBuffer buffer = new StringBuffer(1000);
		for(Map.Entry<EObject, String> entry: this.entrySet()) {
			buffer.append(entry.getKey());
			buffer.append(": ");
			buffer.append(entry.getValue());
			buffer.append("\n");
		}
		return buffer.toString();
	}
}
