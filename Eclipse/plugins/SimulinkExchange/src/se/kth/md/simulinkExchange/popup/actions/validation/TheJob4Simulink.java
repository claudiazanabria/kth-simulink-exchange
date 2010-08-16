/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.popup.actions.validation;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.management.simulink.SimulinkModelManager;

public class TheJob4Simulink extends TheJob {

	protected TheJob4Simulink(String name, IPath aPath) {
		super( name, aPath);
		URI modelFile = URI.createFileURI( inModelPath.toString() );
		modelManager = new SimulinkModelManager( modelFile );
	}
}
