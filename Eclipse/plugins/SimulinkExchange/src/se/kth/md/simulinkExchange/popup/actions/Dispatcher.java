/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


/**
 * This class keeps track of which file is selected in the Workspace,
 * and will start a background job when a menu option is selected.
 * 
 * @author alex
 *
 */
public abstract class Dispatcher implements IObjectActionDelegate {

	protected Shell shell;
	protected ISelection selection;

	
	/**
	 * Constructor for Action1.
	 */
	public Dispatcher() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public abstract void run(IAction action);

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	protected IPath selectedFilename() {
		//Cast to StructuredSelection
		StructuredSelection aSelection = (StructuredSelection) this.selection;
		IFile filen = (IFile) aSelection.getFirstElement();
		return filen.getLocation();
	}

	protected void runInBackground(IAction action, ITasksExecutor executor) {
		BackgroundJob aJob = new BackgroundJob( executor );
		aJob.setUser(true);
		aJob.schedule();		
	}
}
