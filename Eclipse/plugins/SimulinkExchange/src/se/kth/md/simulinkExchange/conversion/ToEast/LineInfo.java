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


import java.util.ArrayList;
import java.util.UUID;

import Simulink.System;

/**
 * Data structure used by Simulink to summarize the information needed to create a line.
 * This is used by LinesProcessor and SimulinkEcoreCreator.
 * @author Alex Schenkman
 */
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

	/**
	 * Method provided for Simulink, because it is not possible to
	 * create arrays with generics there.
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
