/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

/**
 * 
 */
package se.kth.md.simulinkExchange.popup.actions.atl.simulink2east;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.atl.TheJob;
import se.kth.md.simulinkExchange.popup.actions.atl.TheJobSimulink2East;

/**
 * @author alesch
 *
 */
public class Dispatcher 
	extends se.kth.md.simulinkExchange.popup.actions.Dispatcher {

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.popup.actions.ATLdispatcher#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		//FIXME this is old version
		TheJob aJob = new TheJobSimulink2East( this.selectedFilename() );
		aJob.setUser(true);
		aJob.schedule();		
	}

}
