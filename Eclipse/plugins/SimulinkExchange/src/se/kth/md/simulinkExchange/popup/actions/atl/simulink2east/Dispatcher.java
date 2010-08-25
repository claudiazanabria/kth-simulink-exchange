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

import se.kth.md.simulinkExchange.popup.actions.atl.ITasksExecutor;

/**
 * This class will choose the appropriate executor builder a Simulink to EAST conversion,
 * and start an Eclipse background job to execute them.
 *
 * @author alesch
 *
 */
public class Dispatcher 
	extends se.kth.md.simulinkExchange.popup.actions.Dispatcher {

	@Override
	public void run(IAction action) {
		ITasksExecutor executor = ExecutorBuilder.doIt( this.selectedFilename() );
		this.runInBackground(action, executor);
	}

}
