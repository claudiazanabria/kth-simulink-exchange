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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.atl.ATLrunConfiguration;
import se.kth.md.simulinkExchange.atl.URInotFound;

public class TheJobEast2Simulink extends TheJob {

	public TheJobEast2Simulink(IPath aPath)  {
		super("Converting to Simlink", aPath);
		String atlPath = "./resources/ATL/east2simulink.atl";
		String asmPath = "./resources/ATL/east2simulink.asm";
		this.initJob(atlPath, asmPath);
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

}
