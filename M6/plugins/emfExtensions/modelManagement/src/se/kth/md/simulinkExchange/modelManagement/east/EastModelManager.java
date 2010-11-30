package se.kth.md.simulinkExchange.modelManagement.east;


import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.eastadl.EastadlFactory;
import org.eclipse.papyrus.eastadl.EastadlPackage;

import se.kth.md.simulinkExchange.modelManagement.ModelManager;

/**
 * A ModelManager that can handle EAST-ADL models.
 * @author Alex Schenkman
 */
public class EastModelManager  extends ModelManager {
	/**
	 * Adds the metamodel the the global EMF registry and initializes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = EastadlPackage.eINSTANCE;
	}

	/**
	 * @return the factory for this metamodel.
	 */
	@Override
	public EastadlFactory getFactory() {
		return (EastadlFactory) super.getFactory();
	}

	/**
	 * Opens an empty EAST-ADL model named: "unnamed.uml".
	 * Relies on EastModelManager(String modelPath).
	 */
	public EastModelManager() { 
		this( "unnamed.uml" ); 
	}
	
	/**
	 * Opens an EAST-ADL model from file.
	 * @param modelPath
	 */
	public EastModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	/**
	 * Opens an EAST-ADL model from the given URI
	 * @param model 
	 */
	public EastModelManager(URI model) {
		super( model );
		setFileExtension("uml");
		init( model );
	}
}
