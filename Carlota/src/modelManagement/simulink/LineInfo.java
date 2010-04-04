package modelManagement.simulink;

import java.util.ArrayList;

import modelManagement.exceptions.PortNotFoundException;

import Simulink.Port;
import Simulink.System;

public class LineInfo {
	
	public String 	lineName;
	public Port	source;
	public Port	destination;
	public String	srcName;
	public String	dstName;
//	public String	srcParentName;
//	public String	dstParentName;
	public System	lineParent;
	
	
	
	public LineInfo(System lineParent) {
		this.lineParent = lineParent;
	}

	public void setName(String name) {
		this.lineName = name;
	}

	public void setSrcName(String srcName) {
		this.srcName = srcName;
	}

	public void setDstName(String dstName) {
		this.dstName = dstName;
	}

//	public void setDstParentName(String dstParentName) {
//		this.dstParentName = dstParentName;
//	}
//
//	public void setSrcParentName(String srcParentName) {
//		this.srcParentName = srcParentName;
//	}

	public String getName() {
		return lineName;
	}

	public Port getSource() throws PortNotFoundException {
		if ( this.source == null ) {
			this.source = 
				SimulinkEcoreCreator.findPortWithin(srcName, lineParent);
			if ( this.source == null ) { 
				throw new PortNotFoundException(srcName, lineParent); }
		}
		return source;
	}

	public Port getDestination() throws PortNotFoundException {
		if ( this.destination == null ) {
			this.destination = 
				SimulinkEcoreCreator.findPortWithin(dstName, lineParent);
			if ( this.source == null ) { 
				throw new PortNotFoundException(srcName, lineParent); }
		}
		return destination;
	}

//	private Port findPortNamed(String portName, String portParentName) {
//		Port port;
//		if ( lineParent.getSimulinkName().equalsIgnoreCase(portParentName) ) {
//			return port = findPortInSystem( lineParent, portName );
//		} else {
//			for (SystemReference sysRef : lineParent.getChildren() ) {
//				port = findPortInSystem(sysRef.getTarget(), portName);
//				if ( port != null ) {
//					return port;
//				}
//			}
//		}
//		return null;
//	}
//
//
//	private Port findPortInSystem(System system, String name) {
//		Port port;
//		port = findPortInList( system.getInports(), name );
//		if ( port == null ) {
//			port = findPortInList( system.getOutports(), name );
//		}
//		return port;
//	}
//
//	private Port findPortInList(EList<? extends Port> ports, String name) {
//		for (Port aPort : ports ) {
//			if ( aPort.getSimulinkName().equalsIgnoreCase(name) ) {
//				return aPort;
//			}
//		}
//		return null;
//	}

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

}
