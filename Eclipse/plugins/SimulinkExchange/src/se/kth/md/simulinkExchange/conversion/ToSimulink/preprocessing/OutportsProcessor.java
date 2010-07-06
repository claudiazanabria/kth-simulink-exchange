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

import java.util.Collection;


import Simulink.ProtoObject;
import Simulink.System;

/**
 * Gets the outports from a system, and adds them to the list.
 * @author Alex Schenkman
 *
 */
public class OutportsProcessor extends PortProcessor {
	
	public static Collection<? extends ProtoObject> doIt(
			System aSystem, SystemLayouter layouter) {
				
		OutportsProcessor pp = new OutportsProcessor();
		pp.init(aSystem, layouter);
		layouter.startWithOutports();
		return pp.process( aSystem.getOutports() );		
	}
	
}
