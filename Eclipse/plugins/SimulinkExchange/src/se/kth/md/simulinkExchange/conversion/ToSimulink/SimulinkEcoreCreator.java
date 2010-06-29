package se.kth.md.simulinkExchange.conversion.ToSimulink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.BasicEList;

import se.kth.md.simulinkExchange.conversion.exceptions.PortNotFoundException;

import Simulink.Inport;
import Simulink.Line;
import Simulink.Model;
import Simulink.Outport;
import Simulink.Port;
import Simulink.ProtoObject;
import Simulink.SimulinkFactory;
import Simulink.System;
import Simulink.SystemReference;

/**
 * This is a convenience class to easily create ecore models.
 * It is mainly used from MATLAB, but it is useful if you want to build models programmatically
 * for example, for testing purposes.
 * This class keeps track of all elements it has created, with a UUID.
 * TODO: Should it be renamed to EcoreFactory maybe?
 * @author Alex Schenkman
 */
public class SimulinkEcoreCreator {
	
	protected SimulinkFactory factory; /**< The factory for the simulink metamodel. */
	protected Model theModel;	/**< The top element. */
	protected HashMap<String, System> systemRepository;	/**< Keeps a reference to all systems created by this class. */
	protected HashMap<UUID, ProtoObject> repository;	/**< Keeps a reference to all elements created by this class. */
	
	/**
	 * A convenience class to easily create ecore models.
	 * @param aFactory This can be obtained from a ModelManager.
	 */
	public SimulinkEcoreCreator(SimulinkFactory aFactory) {
		factory = aFactory;
		systemRepository 	= new HashMap<String, System>();
		repository 			= new HashMap<UUID, ProtoObject>();
	}

	/**
	 * Creates a model, the top element in the metamodel.
	 * @param modelName	Name of the model.
	 * @return the newly created model,
	 */
	public Model newModel(String modelName) {
		theModel = factory.createModel();
		theModel.setName( modelName );
		this.setUUIDAndAddToRepository( theModel );
		return theModel;
	}

	/**
	 * This class keeps track of all elements it has created, with a UUID.
	 * This allows to easily find elements given the UUID, which is stored by Simulink as well.
	 * @param object A UUID will be set for this object.
	 */
	private void setUUIDAndAddToRepository(ProtoObject object) {
		UUID uuid = UUID.randomUUID();
		object.setUuid(uuid.toString());
		repository.put(uuid, object);
	}


	/**
	 * @return the model element at the top of the hierarchy. 
	 */
	public Model getTopElement() {
		return theModel;
	}


	/**
	 * A System is obtained and treated as the root for this model.
	 * Note that if a system with the same name has previously been created, 
	 * it will be reused, instead of creating a new one.  
	 * @param name
	 * @return
	 */
	public System addRootSystem(String name) {
		System aSystem = obtainSystem(name);
		theModel.setRoot(aSystem);
		this.setUUIDAndAddToRepository( aSystem );		
		return aSystem;
	}


	/**
	 * If the system is not already in the systemRepository, it will be created.
	 * systems are identified by its name.
	 */
	private System obtainSystem(String name) {
		System aSystem = findSystem( name );
		if ( aSystem == null ) {
			aSystem = newSystem(name);
		}
		return aSystem;
	}


	/**
	 * Creates a new system and ads it to the systemRepository.
	 * @param name Name for the system to be created.
	 * @return the newly created system.
	 */
	private System newSystem(String name) {
		System aSystem = factory.createSystem();
		aSystem.setName(name);
		aSystem.setSimulinkName(name);
		systemRepository.put(name, aSystem);
		theModel.getParts().add(aSystem);
		this.setUUIDAndAddToRepository( aSystem );		
		return aSystem;
	}

	/**
	 * @param name Name of the system to be found.
	 * @return the found system or null if not found.
	 */
	public System findSystem(String name) {
		return systemRepository.get( name );
	}

	/**
	 * Find a given port within a system, and its first level children.
	 * This is used by MATLAB when creating lines.
	 * @param portName Name of the port.
	 * @param aSystem Where to start looking.
	 * @return the port if found, null otherwise.
	 */
	public static Port findPortWithin(String portName, System aSystem) {
		Port port = findOutportWithin(portName, aSystem);
		if ( port == null ) {
			port = findInportWithin(portName, aSystem);
		}
		return port;
	}
	
	/**
	 * TODO: Should this be private? Is MATLAB using this one directly?
	 */
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

	/**
	 * TODO: Should this be private? Is MATLAB using this one directly?
	 */
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

	/**
	 * @param aSystem where to start the search.
	 * @return a list with aSystem and only, its first level children.
	 */
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

	
	/**
	 * Adds a new instance of a system to the model, in the right place.
	 * This is implemented as ModelReferences in MATLAB, but it might change to libraries.
	 * This is the preferred way of adding new systems, as it opens the possibility to exchange 
	 * any given number of parameters.
	 * @param pList the information needed to create a system instance.   
	 * @return a newly created SystemReference.
	 */
	public SystemReference addSystem(PropertyList pList) {		
		
		String name 		= pList.getName();
		String instanceName = pList.getInstanceName();
		System parent		= pList.getParent();
		SystemReference sysRef = addSystemInstance(name, parent, instanceName);		
		return sysRef;
	}
	
	/**
	 * Adds a new SystemReference to this model, with all the appropriate links.
	 * @param name of the system to instantiate.
	 * @param parent the system that contains this instance.
	 * @param instanceName the name this instance gets in MATLAB.
	 * @return a newly created SystemReference.
	 */
	private SystemReference addSystemInstance(String name, System parent,
			String instanceName) {
		
		System aSystem = obtainSystem(name);
		SystemReference reference = factory.createSystemReference();
		reference.setName(instanceName);
		reference.setParent(parent);
		reference.setTarget(aSystem);
		parent.getChildren().add(reference);
		this.setUUIDAndAddToRepository( reference );		
		return reference;
	}


	@Deprecated
	public System addSystem(String name, System parent, String instanceName) {
		SystemReference sysRef = addSystemInstance(name, parent, instanceName);
		return sysRef.getTarget();
	}
	
	/*
	 * name and instanceName are the same
	 */
	@Deprecated
	public System addSystem(String name, System parent) {
		return addSystem(name, parent, name);
	}


	/**
	 * Adds an Inport to the given system.
	 * @param name of the port.
	 * @param parent the system where this port should be added.
	 * @return the newly created port.
	 */
	public Inport addInPort(String name, System parent) {
		Inport inport = factory.createInport();
		parent.getInports().add( inport );
		inport.setName(name);
		inport.setParent(parent);
		this.setUUIDAndAddToRepository( inport );		
		return inport;
	}

	/**
	 * Adds an Outport to the given system.
	 * @param name of the port.
	 * @param parent the system where this port should be added.
	 * @return the newly created port.
	 */
	public Outport addOutPort(String name, System parent) {
		Outport outport = factory.createOutport();
		parent.getOutports().add( outport );
		outport.setName(name);
		outport.setParent(parent);
		this.setUUIDAndAddToRepository( outport );		
		return outport;
	}

	/**
	 * Adds a line between the first outport of source and the first inport of destination.
	 * This is a convenience method to quickly create lines for tests. 
	 * @param lineName 
	 * @param source 
	 * @param destination
	 * @param parent the system this line belongs to.
	 * @return the newly created line.
	 */
	public Line addLineBetween(String lineName, System source, System destination, 
			System parent) {
		Outport outport = source.getOutports().get(0);
		Inport inport = destination.getInports().get(0);
		return addLine(lineName, outport, inport, parent);
	}
	
	/**
	 * Adds a line between two ports. Useful for tests.
	 * @param lineName
	 * @param source
	 * @param destination
	 * @param parent the system this line belongs to.
	 * @return the newly created line.
	 */
	public Line addLine(String lineName, Port source, Port destination, 
			System parent) {
		Line line = factory.createLine();
		line.setName(lineName);
		line.setSource(source);
		line.setDestination(destination);
		parent.getLines().add(line);
		this.setUUIDAndAddToRepository( line );
		return line;
	}
	
	/**
	 * Adds all lines contained in lines.
	 * This is the way MATLAB adds lines to a model.
	 * See LineInfo for mode information.
	 * @param lines a list of lines, prepared by MATLAB.
	 * @throws PortNotFoundException if port not found.
	 */
	public void addLines(ArrayList<LineInfo> lines) throws PortNotFoundException {
		String name;
		Port srcPort, dstPort;
		System parent;
		for ( LineInfo lineInfo : lines ) {
			name = lineInfo.getName();
			parent = lineInfo.getLineParent();
			srcPort = this.findPort( lineInfo.getSrcPort() );
			dstPort = this.findPort( lineInfo.getDstPort() );			
			addLine( name, srcPort, dstPort, parent );
		}
	}


	public System findSystem(UUID uuid) {
		return (System) repository.get(uuid);
	}

	public SystemReference findSystemReference(UUID uuid) {
		return (SystemReference) repository.get(uuid);
	}

	public Port findPort(UUID uuid) {
		return (Port) repository.get(uuid);
	}
		
	public Line findLine(UUID uuid) {
		return (Line) repository.get(uuid);
	}
	
}
