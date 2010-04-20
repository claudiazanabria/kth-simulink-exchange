package modelManagement;

import modelManagement.exceptions.InvalidModelException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * @author alesch
 * This class represents the process of reading an ecore 
 * model from a file into memory.
 * It assumes the metamodel is already registered.
 */
public class ModelLoader {

	private URI model;
	private Resource resource;
	private ResourceSet resourceSet;
		
	public ModelLoader(URI model) {
		this.model = model;
		resourceSet = new ResourceSetImpl();
	}

	public void doIt() throws InvalidModelException {
		setResourceFactoryForFileExtension();
		loadModelFile();
		validateModel();
	}

	public EObject getTopElement() {
		return resource.getContents().get(0);
	}

	/**
	 * Register the appropriate resource factory to handle file extensions.
	 * In this case, all files (*) will handled by XMI resource Factory.
	 */
	private void setResourceFactoryForFileExtension() {
		resourceSet.getResourceFactoryRegistry().
			getExtensionToFactoryMap().
			put(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				new XMIResourceFactoryImpl());
	}

	private void loadModelFile() {
		resource = resourceSet.getResource(model, true);
	}

	private void validateModel() throws InvalidModelException {
		ModelValidator aModelValidator = new ModelValidator( resource );
		aModelValidator.doIt();
	}	
}
