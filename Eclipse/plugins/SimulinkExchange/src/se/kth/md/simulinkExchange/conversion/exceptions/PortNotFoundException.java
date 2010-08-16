/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.exceptions;

import Simulink.System;

/**
 * Exception thrown mainly by code handling lines, as finding ports within models is complicated.
 * @author Alex Schenkman
 *
 */
public class PortNotFoundException extends Exception {

	System parent;
	String name;

	private static final long serialVersionUID = 1L;
	
	public PortNotFoundException(String name, System parent) {
		this.name = name;
		this.parent = parent;
	}

}
