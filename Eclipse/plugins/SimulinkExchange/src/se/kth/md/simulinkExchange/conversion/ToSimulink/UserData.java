/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToSimulink;


import java.lang.Object;
import java.util.HashMap;
import java.util.UUID;

/**
 * OBS: I think this Data structure is not used any longer !
 * 
 * Data structure used to store arbitrary data within elements in Simulink.
 * Simulink allows the user to attach an arbitrary object (even Java) to an element. 
 * This object is then preserved along with the simulink element.
 * By using a HashMap we can attach any number of objects.
 * 
 * @author Alex Schenkman
 */
public class UserData extends HashMap<String, Object> {

	private static final long serialVersionUID = 8929529445623898408L;

	/**
	 * Default makes room for three elements, of which the mandatory UUID is the first one.
	 */
	public UserData() {
		super(3);
		super.put( "UUID", UUID.randomUUID() );
	}
}
