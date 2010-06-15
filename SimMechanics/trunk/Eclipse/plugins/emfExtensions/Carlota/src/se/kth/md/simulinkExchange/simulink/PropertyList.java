package se.kth.md.simulinkExchange.simulink;

import java.util.HashMap;

import Simulink.System;

@SuppressWarnings("serial")
public class PropertyList extends HashMap<String, Object> {

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
