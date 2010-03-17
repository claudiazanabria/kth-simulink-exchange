/**
 * 
 */
package modelManagement.simulink;

import java.util.HashMap;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.SimulinkFactory;
import Simulink.System;
import Simulink.SystemReference;

/**
 * @author alesch
 *
 */
public class SimulinkEcoreCreator {
	
	protected SimulinkFactory factory;
	protected Model theModel;
	protected HashMap<String, System> systemRepository;
	
	public SimulinkEcoreCreator(SimulinkFactory aFactory) {
		factory = aFactory;
		systemRepository = new HashMap<String, System>();
	}


	public Model newModel(String modelName) {
		theModel = factory.createModel();
		theModel.setName( modelName );
		return theModel;
	}


	public Model getTopElement() {
		return theModel;
	}


	public System addRootSystem(String name) {
		System aSystem = obtainSystem(name);
		theModel.setRoot(aSystem);
		return aSystem;
	}

	/*
	 * If the system is not in the repository it will be created
	 */
	private System obtainSystem(String name) {
		System aSystem = findSystem( name );
		if ( aSystem == null ) {
			aSystem = newSystem(name);
		}
		return aSystem;
	}


	private System newSystem(String name) {
		System aSystem = factory.createSystem();
		aSystem.setName(name);
		systemRepository.put(name, aSystem);
		theModel.getParts().add(aSystem);
		return aSystem;
	}

	
	public System findSystem(String name) {
		return systemRepository.get( name );
	}


	public System addSystem(String name, System parent, String instanceName){
		System aSystem = obtainSystem(name);
		SystemReference reference = factory.createSystemReference();
		reference.setName(instanceName);
		reference.setParent(parent);
		reference.setTarget(aSystem);
		parent.getChildren().add(reference);
		return aSystem;
		
	}
	
	
	public System addSystem(String name, System parent) {
		return addSystem(name, parent, name);
	}


	public Inport addInPort(String name, System aSystem) {
		Inport inport = factory.createInport();
		aSystem.getInports().add( inport );
		inport.setName(name);
		inport.setParent(aSystem);
		return inport;
	}


	public Outport addOutPort(String name, System aSystem) {
		Outport outport = factory.createOutport();
		aSystem.getOutports().add( outport );
		outport.setName(name);
		outport.setParent(aSystem);
		return outport;
	}

	public Line addLineBetween(String name, System source, System destination, 
			System parent) {
		Outport outport = source.getOutports().get(0);
		Inport inport = destination.getInports().get(0);
		return addLine(name, outport, inport, parent);
	}
	
	public Line addLine(String name, Outport source, Inport destination, 
			System parent) {
		Line line = factory.createLine();
		line.setName(name);
		line.setSource(source);
		line.setDestination(destination);
		parent.getLines().add(line);
		return line;
	}

}
