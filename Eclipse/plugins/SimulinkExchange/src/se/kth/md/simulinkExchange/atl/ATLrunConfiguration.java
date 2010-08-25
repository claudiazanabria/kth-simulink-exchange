/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.atl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

public class ATLrunConfiguration {

	// FIXME: Hard-coded values !?!
	private Map<URI, String> hardcodedIDs = this.createHardcodedIDs();	
	public static URI eastMetaModel 	  = URI.createURI("http://www.papyrusuml.org/EAST-ADL2/1");
	public static URI umlMetaModel        = URI.createURI("http://www.eclipse.org/uml2/2.1.0/UML");
	public static URI simulinkMetaModel   = URI.createURI("http:///se.kth.md.attest2/Simulink/3.0");

	protected ModelTowerList sourceList      = new ModelTowerList();
	protected ModelTowerList destinationList = new ModelTowerList();
	protected URI transformationSource;
	protected URI transformationCompiled;
	
	
	public ATLrunConfiguration( URI atlSource, URI atlCompiled ) {
		this.transformationSource 	= atlSource;
		this.transformationCompiled = atlCompiled;
	}

	
	public void addSource(URI model, URI metamodel) throws URInotFound {
		Utils.validateReadableURI( model );
		ModelTower mt = newTower(model, metamodel);
		sourceList.add( mt );
		mt.setModelID("IN" + String.valueOf( sourceList.size() ));
	}
	
	
	public void addDestination(URI model, URI metamodel) throws URInotFound {
		Utils.validateWriteableURI( model );
		ModelTower mt = newTower(model, metamodel);
		destinationList.add( mt );
		mt.setModelID("OUT" + String.valueOf( destinationList.size() ));
	}

	
	private ModelTower newTower(URI model, URI metamodel) throws URInotFound {
		Utils.validateRegisteredMetamodel( metamodel );
		ModelTower mt = new ModelTower();
		mt.setModel( model );
		String metaModelID = getHardCodedID(metamodel);
		mt.setMetaModelID( metaModelID );
		mt.setMetaModel( metamodel );
		return mt;
	}


	private String getHardCodedID(URI metamodel) throws NullPointerException {
		String metaModelID = hardcodedIDs.get( metamodel );		
		if ( metaModelID == null) {
			String errMsg = String.format("Hardcoded ID for %s NOT found!", metamodel);
			throw new NullPointerException( errMsg );
		}
		return metaModelID;
	}
		
	
	// FIXME: This should be read from the ATL source or ASM file.
	private Map<URI, String> createHardcodedIDs() {
		Map<URI, String> hardcodedIDs = new HashMap<URI, String>(5);
		hardcodedIDs.put(eastMetaModel, "EST");
		hardcodedIDs.put(umlMetaModel, "UML");
		hardcodedIDs.put(simulinkMetaModel, "SIM");
		return hardcodedIDs;
	}

	public boolean isComplete() {
		return ( !sourceList.isEmpty() && !destinationList.isEmpty() );
	}

		
	public InputStream getCompiledTransformationAsStream() throws IOException {
		String path = transformationCompiled.toFileString(); 
		return new FileInputStream( path );
	}

	public Map<String, String> getPathsMap() {
		Map<String, String> paths = new HashMap<String, String>(10);
		paths.putAll( sourceList.asPathMap() );
		paths.putAll( destinationList.asPathMap() );
		return paths;
	}
	

	public Map<String, String> getInModelsIDMap() {
		Map<String, String> inModelsID = new HashMap<String, String>(2);
		inModelsID.putAll( sourceList.asIDMap() );
		return inModelsID;
	}

	
	public Map<String, String> getOutModelsIDMap() {
		Map<String, String> inModelsID = new HashMap<String, String>(2);
		inModelsID.putAll( destinationList.asIDMap() );
		return inModelsID;
	}
	
	public Map<String, String> getInOutModelsIDMap() {
		return Collections.emptyMap();
	}


	public Map<String, String> defineModelHandlers() {
		Map<String, String> handlers = new HashMap<String,String>();
		handlers.putAll( sourceList.asHandlersMap() );
		handlers.putAll( destinationList.asHandlersMap() );
		return null;
	}


	public URI getFirstDestinationFileName() {
		// FIXME: get the simulink filename from the destination list.
		// FIXME: a better name
		return null;
	}

}
