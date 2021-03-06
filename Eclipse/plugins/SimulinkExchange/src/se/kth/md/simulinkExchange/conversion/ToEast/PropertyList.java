/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToEast;


import java.util.HashMap;

import Simulink.System;

/**
 * Data structure used to accommodate arbitrary number of parameters when creating 
 * instances of Systems, i.e. SystemReferences.
 *  
 * @author Alex Schenkman
 */
@SuppressWarnings("serial")
public class PropertyList extends HashMap<String, Object> {

	/**
	 * The minimal information required are the arguments of this constructor.
	 * @param name of the system to be instantiated.
	 * @param parent where this system belongs to.
	 * @param instanceName Name given in Simulink to this ModelReference.
	 */
	public PropertyList(String name, System parent, String instanceName) {
		super(5);
		assert( name != null );
		assert( parent != null );
		assert( instanceName != null );
		this.put("name", name);
		this.put("parent", parent);
		this.put("instanceName", instanceName);
	}

	public String getPosition() {
		return (String) this.get("position");
	}

	public String getName() {
		return (String) this.get("name");
	}

	public String getInstanceName() {
		return (String) this.get("instanceName");
	}

	public System getParent() {
		return (System) this.get("parent");
	}

}
