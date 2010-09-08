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

import Simulink.ProtoObject;
import Simulink.System;

/**
 * Adds lines to the list. Lines are complicated in Simulink.
 * @author Alex Schenkman
 *
 */
@Deprecated
public class LinesProcessor {
	
	System theSystem;
	
	public static Collection<? extends ProtoObject> doIt(System aSystem) {
		
		LinesProcessor lp = new LinesProcessor();
		lp.theSystem = aSystem;
		return lp.process();
	}

	private Collection<? extends ProtoObject> process() {
		ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
		list.addAll( theSystem.getLines() );
		return list;
	}
}
