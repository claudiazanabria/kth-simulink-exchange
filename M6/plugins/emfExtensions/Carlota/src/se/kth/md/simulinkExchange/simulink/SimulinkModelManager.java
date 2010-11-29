package se.kth.md.simulinkExchange.simulink;


import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.ModelManager;

import Simulink.SimulinkFactory;
import Simulink.SimulinkPackage;

/*
 * This class can read from file, validate, and write to file
 * simulink ecore models. It can be used in Java standalone mode, 
 * as it first registers the metamodel
 */
public class SimulinkModelManager  extends ModelManager {
	/*
	 * Adds the metamodel the the global EMF registry
	 * and initilizes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = SimulinkPackage.eINSTANCE;
	}

	@Override
	public SimulinkFactory getFactory() {
		return (SimulinkFactory) super.getFactory();
	}
	
	/*
	 * Constructors are NOT inherited in Java, so...
	 */
	public SimulinkModelManager() { 
		this( "unnamed.simulink" ); 
	}
	
	public SimulinkModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	public SimulinkModelManager(URI model) {
		setFileExtension("simulink");
		init( model );
	}
}
