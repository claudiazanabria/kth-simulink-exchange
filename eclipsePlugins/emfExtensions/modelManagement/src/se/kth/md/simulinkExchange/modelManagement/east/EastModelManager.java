package se.kth.md.simulinkExchange.modelManagement.east;


import org.eclipse.emf.common.util.URI;

import se.kth.md.simulinkExchange.modelManagement.ModelManager;

import com.cea.papyrus.uml4eastadl.eastadl.EastadlFactory;
import com.cea.papyrus.uml4eastadl.eastadl.EastadlPackage;

/*
 * This class can read from file, validate, and write to file
 * eastADL XMI models. It can be used in Java standalone mode, 
 * as it first registers the metamodel
 */
public class EastModelManager  extends ModelManager {
	/*
	 * Adds the metamodel the the global EMF registry
	 * and initilizes the metamodel factory.
	 */
	@Override
	protected void initMetaModel() {
		ePackage = EastadlPackage.eINSTANCE;
	}

	@Override
	public EastadlFactory getFactory() {
		return (EastadlFactory) super.getFactory();
	}

	/*
	 * Constructors are NOT inherited in Java, so...
	 */
	public EastModelManager() { 
		this( "unnamed.uml" ); 
	}
	
	public EastModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	public EastModelManager(URI model) {
		super( model );
		setFileExtension("uml");
		init( model );
	}

}
