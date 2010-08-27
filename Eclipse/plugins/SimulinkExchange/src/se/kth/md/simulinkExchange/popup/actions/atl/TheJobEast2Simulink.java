/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.popup.actions.atl;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;
import se.kth.md.simulinkExchange.atl.XmlCombiner;
import se.kth.md.simulinkExchange.conversion.ToSimulink.postprocessing.NameTraverser;
import se.kth.md.simulinkExchange.management.IModelManager;
import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;
import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

public class TheJobEast2Simulink extends TheJob {

	public TheJobEast2Simulink(IPath aPath)  {
		super("Converting to Simlink", aPath);
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		umlModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(umlModel, ATLrunConfiguration.umlMetaModel);
		config.addSource(umlModel, ATLrunConfiguration.eastMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = umlModel.trimFileExtension().appendFileExtension("simulink");
		config.addDestination(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	public ATLrunConfiguration configureTransformation() throws URInotFound {
		URI atlSource = lookUpAbsolutePathWithinPlugin("./resources/ATL/east2simulink.atl");
		URI atlCompiled = lookUpAbsolutePathWithinPlugin("./resources/ATL/east2simulink.asm");

		ATLrunConfiguration config = new ATLrunConfiguration( atlSource, atlCompiled );
		addSources(config);
		addDestination(config);
		return config;

	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		super.run(monitor);
		if (monitor.isCanceled()) return Status.CANCEL_STATUS;
		monitor.subTask("Post-processing, setting names");
		try {
			runNameTraverser( new SimulinkModelManager( simulinkModel ) );
			plugin.log("Setting names done", Status.INFO);
		} catch (Exception e) {
			plugin.log(e.getMessage(), Status.ERROR);
		}
		return Status.OK_STATUS;
	}

	protected void runNameTraverser(IModelManager manager) 
	throws InvalidModelException, IOException {

		manager.loadIt();			
		//manager.traverseWith( new NameTraverser() );
		manager.saveIt();
	}

}
