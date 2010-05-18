package modelManagement;

import modelManagement.exceptions.InvalidModelException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import com.cea.papyrus.uml4eastadl.eastadl.EastadlPackage;

public class EastModelLoader {

	protected ModelLoader modelLoader;
	protected EPackage ePackage;

	public EastModelLoader(URI model) {
		initMetaModel();
		modelLoader = new ModelLoader(model);
	}

	public void doIt() throws InvalidModelException { 
		modelLoader.doIt();
	}

	public EObject getTopElement() {
		return modelLoader.getTopElement();
	}

	public String getNsURI() {
		return ePackage.getNsURI();
	}
	
	/*
	 * Adds the metamodel the the global EMF registry
	 * and initializes the metamodel factory.
	 * After this call the package is ready to be used.
	 */
	private void initMetaModel() {
		ePackage = EastadlPackage.eINSTANCE;
	}

}
