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
