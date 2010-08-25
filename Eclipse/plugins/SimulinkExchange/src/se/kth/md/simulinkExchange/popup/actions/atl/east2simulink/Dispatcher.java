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
package se.kth.md.simulinkExchange.popup.actions.atl.east2simulink;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.popup.actions.atl.ConverterJob;
import se.kth.md.simulinkExchange.popup.actions.atl.EAST2SimulinkConverter;
import se.kth.md.simulinkExchange.popup.actions.atl.ITasksExecutor;

/**
 * @author Alex Schenkman
 *
 */
public class Dispatcher 
	extends se.kth.md.simulinkExchange.popup.actions.Dispatcher {

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		ITasksExecutor converter = new EAST2SimulinkConverter( this.selectedFilename() );
		//FIXME is ConverterJob really needed?
		ConverterJob aJob = new ConverterJob( converter );
		aJob.setUser(true);
		aJob.schedule();		
//		TheJob aJob = new TheJobEast2Simulink( this.selectedFilename() );
	}

}
