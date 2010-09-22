/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.atlHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelTowerList extends ArrayList<ModelTower> {

	private static int MaxAmountOfModels = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7328328473966725740L;

	public ModelTowerList() {
		super(MaxAmountOfModels); 
		// We do not use more than two models as inputs or outputs simultaneously
	}

	public Map<String, String> asPathMap() {
		Map<String, String> paths = new HashMap<String, String>();
		for ( ModelTower mt : this ) {
				paths.put(mt.getModelID(), mt.getModel().toString());
				paths.put(mt.getMetaModelID(), mt.getMetaModel().toString());
			}
		return paths;
	}

	public Map<String, String> asIDMap() {
		Map<String, String> models = new HashMap<String, String>();
		for ( ModelTower mt : this ) {
			models.put(mt.getModelID(), mt.getMetaModelID());
		}
		return models;
	}

	public Map<String, String> asHandlersMap() {
		Map<String, String> handlers = new HashMap<String, String>();
		for ( ModelTower mt : this ) {
			handlers.put(mt.getMetaModelID(), "EMF");
		}
		return handlers;
	}
}

