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
package se.kth.md.simulinkExchange.popup.actions.ToSimulink;

import org.eclipse.jface.action.IAction;

import se.kth.md.simulinkExchange.conversion.ToSimulink.tasks.ExecutorBuilder;
import se.kth.md.simulinkExchange.conversion.tasks.ITasksExecutor;

/**
 * This class will created appropiate tasks for an EAST to Simulink conversion,
 * and start en Eclipse background job to execute them.
 * 
 * @author Alex Schenkman
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
