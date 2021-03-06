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
package se.kth.md.simulinkExchange.popup.actions.atl;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

import se.kth.md.simulinkExchange.Activator;
import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.ATLrunner;
import se.kth.md.simulinkExchange.atl.URInotFound;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.NameTraverser;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;


/**
 * @author alesch
 *
 */
public abstract class TheJob extends Job {

	protected IPath inModelPath;
	protected Activator plugin;
	protected Bundle pluginBundle;
	
	protected URI atlSource;
	protected URI atlCompiled;
	protected URI umlModel;
	protected URI simulinkModel;
	

	protected TheJob(String name, IPath aPath) {
		super(name);
		this.inModelPath = aPath;
		plugin = Activator.getDefault();
		pluginBundle = plugin.getBundle();

	}

	protected void initJob(String atlSourcePath, String atlCompiledPath) {
		try {
			atlSource 	= plugin.locateFile( atlSourcePath );
			atlCompiled = plugin.locateFile( atlCompiledPath );
		} catch (IOException e) {
			plugin.log("Internal error: ATL source not bundled within plugin.", Status.ERROR, e);
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "ATL source not found. See Error log for details.");
			StatusManager.getManager().handle(status, StatusManager.SHOW);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		ATLrunConfiguration config;
		int activitiesTotal = 4;
		int scale = 100;
		SimulinkModelManager manager;
		
		plugin.log("started job", Status.INFO);
		try {
			monitor.beginTask("Converting", activitiesTotal*scale);

			if (monitor.isCanceled()) return Status.CANCEL_STATUS;			
			monitor.subTask("Configure transformation");
			config = this.configureTransformation();
			monitor.worked(1*scale);
			plugin.log("ATL configuration ready", Status.INFO);
			
			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
			monitor.subTask("Run transformation");
			ATLrunner.with( config );		
			monitor.worked(1*scale);
			plugin.log("ATL run done", Status.INFO);

//			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
//			monitor.subTask("Post-processing, setting parents");
//			manager.traverseWith( new ParentTraverser() );
//			monitor.worked(1*scale);
//			plugin.log("Setting parents done", Status.INFO);

			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
			monitor.subTask("Post-processing, setting names");
			manager = new SimulinkModelManager( simulinkModel );
			manager.loadIt();			
			manager.traverseWith( new NameTraverser() );
			manager.saveIt();
			monitor.worked(1*scale);
			plugin.log("Setting names done", Status.INFO);

//			if (monitor.isCanceled()) return Status.CANCEL_STATUS;
//			monitor.subTask("Post-processing, saving model file");
//			monitor.worked(1*scale);
//			plugin.log("Saving model done", Status.INFO);

			
		} catch (Exception e) {
			plugin.log("exception thrown", Status.ERROR, e);
		} finally {
			monitor.done();
		}
		
		return Status.OK_STATUS;
	}

	protected ATLrunConfiguration configureTransformation() throws URInotFound {
		ATLrunConfiguration config = new ATLrunConfiguration( atlSource, atlCompiled );
		addSources(config);
		addDestination(config);
		return config;
	}

	abstract void addDestination(ATLrunConfiguration config) throws URInotFound;
	abstract void addSources(ATLrunConfiguration config) throws URInotFound;

}
