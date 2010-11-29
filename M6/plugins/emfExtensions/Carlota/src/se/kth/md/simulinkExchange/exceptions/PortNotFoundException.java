package se.kth.md.simulinkExchange.exceptions;

import Simulink.System;

public class PortNotFoundException extends Exception {

	System parent;
	String name;

	private static final long serialVersionUID = 1L;
	
	public PortNotFoundException(String name, System parent) {
		this.name = name;
		this.parent = parent;
	}

}
