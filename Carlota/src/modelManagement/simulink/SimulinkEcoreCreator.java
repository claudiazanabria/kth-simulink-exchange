/**
 * 
 */
package modelManagement.simulink;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
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
		cleanRootSystemStatus( theModel.getRoot() ); 
		System aSystem = obtainSystem(name);
		theModel.setRoot(aSystem);
		defineSimulinkNameONLYForRootSystem( aSystem );
		return aSystem;
	}

	private void defineSimulinkNameONLYForRootSystem(System aSystem) {
		aSystem.setSimulinkName( aSystem.getName() ); 
	}

	
	private void cleanRootSystemStatus(System aSystem) {
		if (aSystem != null) {
			aSystem.setSimulinkName(null);
		}
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
		aSystem.setSimulinkName(name);
		systemRepository.put(name, aSystem);
		theModel.getParts().add(aSystem);
		return aSystem;
	}

	
	public System findSystem(String name) {
		return systemRepository.get( name );
	}

	public static Port findPortWithin(String portName, System aSystem) {
		Port port = findOutportWithin(portName, aSystem);
		if ( port == null ) {
			port = findInportWithin(portName, aSystem);
		}
		return port;
	}
	
	public static Outport findOutportWithin(String portName, System aSystem) {
		Outport port = null;
		EList<System> targetSystems = 
			createSystemListWithParentAndFirstLevelChldren(aSystem);
		for (System sys : targetSystems ) {
				port = findOutportInSystem( portName, sys );
				if (port != null) { return port; }
		}
		return port;
	}

	public static Inport findInportWithin(String portName, System aSystem) {
		Inport port = null;
		EList<System> targetSystems = 
			createSystemListWithParentAndFirstLevelChldren(aSystem);
		for (System sys : targetSystems ) {
				port = findInportInSystem( portName, sys );
				if (port != null) { return port; }
		}
		return port;
	}

	private static EList<System> createSystemListWithParentAndFirstLevelChldren(
			System aSystem) {
		EList<SystemReference> childrenList = aSystem.getChildren();
		EList<System> targetSystems = getAllTargets( childrenList );
		targetSystems.add(aSystem);
		return targetSystems;
	}


	private static EList<System> getAllTargets(EList<SystemReference> childrenList) {
		BasicEList<System> result = new BasicEList<System>( childrenList.size() );
		for (SystemReference aRef : childrenList) {
			result.add( aRef.getTarget() );
		}
		return result;
	}


	private static Outport findOutportInSystem(String portName, System aSystem) {
		return findPortInList( portName, aSystem.getOutports());
	}

	private static Inport findInportInSystem(String portName, System aSystem) {
		return findPortInList( portName, aSystem.getInports());
	}
	
	private static <IOPort extends Port> IOPort findPortInList(String portName, 
			EList<IOPort> ports) {
		for (IOPort aPort : ports) {
			if (aPort.getName().equalsIgnoreCase(portName)) {
				return aPort;
			}
		}
		return null;
	}

	public System addSystem(String name, System parent, String instanceName){
		System aSystem = obtainSystem(name);
		SystemReference reference = factory.createSystemReference();
		reference.setName(instanceName);
		reference.setParent(parent);
		reference.setTarget(aSystem);
		reference.setSimulinkName(parent.getSimulinkName()+'/'+instanceName);
		parent.getChildren().add(reference);
		return aSystem;
		
	}
	
	
	public System addSystem(String name, System parent) {
		return addSystem(name, parent, name);
	}


	public Inport addInPort(String name, System parent) {
		Inport inport = factory.createInport();
		parent.getInports().add( inport );
		inport.setName(name);
		inport.setSimulinkName(parent.getSimulinkName()+'/'+name);
		inport.setParent(parent);
		return inport;
	}


	public Outport addOutPort(String name, System parent) {
		Outport outport = factory.createOutport();
		parent.getOutports().add( outport );
		outport.setName(name);
		outport.setSimulinkName(parent.getSimulinkName()+'/'+name);
		outport.setParent(parent);
		return outport;
	}

	public Line addLineBetween(String name, System source, System destination, 
			System parent) {
		Outport outport = source.getOutports().get(0);
		Inport inport = destination.getInports().get(0);
		return addLine(name, outport, inport, parent);
	}
	
	public Line addLine(String name, Port source, Port destination, 
			System parent) {
		Line line = factory.createLine();
		line.setName(name);
		line.setSource(source);
		line.setDestination(destination);
		parent.getLines().add(line);
		return line;
	}
	
	public void addLines(ArrayList<LineInfo> lines) {
		for ( LineInfo lineInfo : lines ) {
			addLine( lineInfo.getName(), lineInfo.getSource(), 
					lineInfo.getDestination(), lineInfo.getLineParent());
		}
	}

}
