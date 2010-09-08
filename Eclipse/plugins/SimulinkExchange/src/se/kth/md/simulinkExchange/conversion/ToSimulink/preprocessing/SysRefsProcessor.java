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
import Simulink.SystemReference;

/**
 * Adds a SystemReference, or subsystem, or system instance to the list.
 * @author Alex Schenkman
 */
@Deprecated
public class SysRefsProcessor {

	ArrayList<ProtoObject> list = new ArrayList<ProtoObject>();
	System theSystem;
	ISystemLayouter layouter;
	
	public static Collection<? extends ProtoObject> doIt(
			System aSystem, ISystemLayouter layouter) {

		SysRefsProcessor sp = new SysRefsProcessor();
		sp.theSystem = aSystem;
		sp.layouter = layouter;
		
		return sp.process();
	}


	private Collection<? extends ProtoObject> process() {
		layouter.startWithSystems();

		for (SystemReference sysRef : theSystem.getChildren()) {
			processSystemReference( sysRef );
		}
		return list;
	}

	private void processSystemReference(SystemReference sysRef) {
		computePosition( sysRef );
		System aSystem = sysRef.getTarget();
		list.addAll( SystemProcessor.doIt( aSystem ));
		list.add( sysRef );
	}

	private void computePosition(SystemReference sysRef) {
		String position = sysRef.getPosition(); 
		if ( (position==null) || (position.isEmpty()) ) {
			position = layouter.nextSystem();
			sysRef.setPosition(position);
		}
	}

}
