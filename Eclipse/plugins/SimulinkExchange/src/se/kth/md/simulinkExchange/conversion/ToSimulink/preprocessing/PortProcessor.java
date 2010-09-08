/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;


import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.System;

/**
 * Common functionality used by InportsProcessor and OutportsProcessor
 * @author Alex Schenkman
 *
 */
@Deprecated
public abstract class PortProcessor {

	ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
	System theSystem;
	ISystemLayouter layouter;

	protected void init(System aSystem, ISystemLayouter layouter) {
		this.theSystem = aSystem;
		this.layouter = layouter;
	}

	protected <P extends Port> Collection<? extends ProtoObject> 
		process(EList<P> ports) {
		
		for (P port : ports ) {
			processPort( port );
			list.add( port );
		}
		return list;
	}

	protected <P extends Port> void processPort(P port) {
		computePosition( port );
	}

	protected void computePosition(Port port) {
		String position = port.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextPortPosition();
			port.setPosition(position);
		}
	}
	
}
