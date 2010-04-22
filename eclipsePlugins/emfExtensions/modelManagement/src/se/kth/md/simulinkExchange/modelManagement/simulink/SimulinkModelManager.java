package se.kth.md.simulinkExchange.modelManagement.simulink;


import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import se.kth.md.simulinkExchange.modelManagement.ModelManager;

import Simulink.SimulinkFactory;
import Simulink.SimulinkPackage;

/**
 * A ModelManager that can handle simulink-ecore models.
 * @author Alex Schenkman
 */
public class SimulinkModelManager  extends ModelManager {
	/**
	 * Adds the metamodel the the global EMF registry and initializes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = SimulinkPackage.eINSTANCE;
	}

	/**
	 * @return the factory for this metamodel.
	 */	
	@Override
	public SimulinkFactory getFactory() {
		return (SimulinkFactory) super.getFactory();
	}
	
	/**
	 * Opens an empty simulink-ecore model named: "unnamed.simulink".
	 * Relies on SimulinkModelManager(String modelPath).
	 */
	public SimulinkModelManager() { 
		this( "unnamed.simulink" ); 
	}

	/**
	 * Opens a simulink-ecore model from file.
	 * @param modelPath
	 */	
	public SimulinkModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}

	/**
	 * Opens a simulink-ecore %model from the given model.
	 * @param model
	 */	
	public SimulinkModelManager(URI model) {
		super( model );
		setFileExtension("simulink");
		init( model );
	}
	
	@Test
	public void testReplacExtension() {
		SimulinkModelManager smm = new SimulinkModelManager();
		String newPath = smm.replaceExtension("test.txt", "zzz");
		assertTrue(newPath.equalsIgnoreCase("test.zzz"));
	}
	
}
