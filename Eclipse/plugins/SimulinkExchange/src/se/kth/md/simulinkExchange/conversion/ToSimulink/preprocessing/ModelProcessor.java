/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing;

/**
 * \package se.kth.md.simulinkExchange.conversion.ToSimulink.preprocessing
 * This package contains classes that process ecore models to be easily parsed by MATLAB.
 * The hierarchical model is translated into a flat list, with elements ordered in such a way
 * that they can added by MATLAB sequentially.
 * 
 * Some information relevant to Simulink is added as well: the position and a full path name.
 * The entry point is ModelProcessor.
 */

import java.util.ArrayList;

import Simulink.Model;
import Simulink.ProtoObject;

/**
 * Adds the model as the first element in the list, and lets the root system continue.
 * @author Alex Schenkman
 *
 */
@Deprecated
public class ModelProcessor {
	
	Model theModel;
	ArrayList<ProtoObject> allElements = new ArrayList<ProtoObject>();
	
	/**
	 * This is the entry point for the package.  
	 * @param aModel the model to be processed (flattened and completed) 
	 * @return a list with all elements, ready to be parsed by MATLAB.
	 */
	public static ArrayList<ProtoObject> doIt(Model aModel ) {
		
		ModelProcessor mp = new ModelProcessor();
		mp.theModel = aModel;
		return mp.process();
	}
		
	private ArrayList<ProtoObject> process() {
				
		allElements.add( theModel );
		allElements.addAll( SystemProcessor.doIt( theModel.getRoot() ));
		
		//ArrayList<ProtoObject> reorderedList = ListOrganizer.reorder( allElements );
		return allElements;
	}
	
}
