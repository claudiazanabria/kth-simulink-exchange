package modelManagement.simulink;

import java.util.ArrayList;
import java.util.UUID;

import Simulink.System;

public class LineInfo {
	
	public String 	lineName;
	public UUID		srcPort;
	public UUID 	dstPort;
	public System	lineParent;
	
	
	
	public LineInfo(System lineParent) {
		this.lineParent = lineParent;
	}

	public void setName(String name) {
		this.lineName = name;
	}

	public String getName() {
		return lineName;
	}

	/*
	 * Method provided for Simulink, because it is not possible to
	 * create arrays with generics <LineInfo> there.
	 */
	public static ArrayList<LineInfo> createArray() {
		return new ArrayList<LineInfo>();
	}

	public System getLineParent() {
		return lineParent;
	}

	public void setSrcPort(String uuidStr) {
		this.setSrcPort( UUID.fromString(uuidStr) );
	}

	public void setSrcPort(UUID srcPort) {
		this.srcPort = srcPort;
	}

	public UUID getSrcPort() {
		return srcPort;
	}

	public void setDstPort(String uuidStr) {
		this.setDstPort(UUID.fromString(uuidStr)); 
	}
	
	public void setDstPort(UUID dstPort) {
		this.dstPort = dstPort;
	}

	public UUID getDstPort() {
		return dstPort;
	}

}
