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
package se.kth.md.simulinkExchange.conversion.ToEast.tasks;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atlHelper.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atlHelper.URInotFound;
import se.kth.md.simulinkExchange.conversion.ToEast.XmlCombiner;

@Deprecated
public class TheJobSimulink2East  {
/*
	URI umlModel1;
	URI umlModel2;
	URI resultUML;

	public TheJobSimulink2East(IPath aPath)  {
		//super("Converting to EAST-ADL", aPath);
		String atlPath = "./resources/ATL/simulink2east.atl";
		String asmPath = "./resources/ATL/simulink2east.asm";
		//this.initJob(atlPath, asmPath);
		
	}

	public void addSources(ATLrunConfiguration config) throws URInotFound {
		simulinkModel = URI.createFileURI( inModelPath.toString() );
		config.addSource(simulinkModel, ATLrunConfiguration.simulinkMetaModel);
	}

	public void addDestination(ATLrunConfiguration config) throws URInotFound {
		boolean atl_Bug_cannotProduceSingleOutputFromTwoMetamodels = true;
		if ( atl_Bug_cannotProduceSingleOutputFromTwoMetamodels ) {
			useThisHackInstead( config ); 
		} else {
			// Original code
			umlModel = simulinkModel.trimFileExtension().appendFileExtension("uml");
			config.addDestination(umlModel, ATLrunConfiguration.umlMetaModel);
			config.addDestination(umlModel, ATLrunConfiguration.eastMetaModel);
		}
	}

	public void useThisHackInstead(ATLrunConfiguration config) throws URInotFound {
		umlModel1 = simulinkModel.trimFileExtension().appendFileExtension("1.uml");
		umlModel2 = simulinkModel.trimFileExtension().appendFileExtension("2.uml");
		resultUML = simulinkModel.trimFileExtension().appendFileExtension("uml");
		config.addDestination(umlModel1, ATLrunConfiguration.umlMetaModel);
		config.addDestination(umlModel2, ATLrunConfiguration.eastMetaModel);
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		super.run(monitor);
		try {
			XmlCombiner.doIt(umlModel2, umlModel1, resultUML);
		} catch (IOException e) {
			plugin.log("Error in XmlCombiner", Status.ERROR, e);
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	@Override
	ATLrunConfiguration configureTransformation() throws URInotFound {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
