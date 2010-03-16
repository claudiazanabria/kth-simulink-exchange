package modelManagement;

import java.io.IOException;

import modelManagement.exceptions.InvalidModelException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


/**
 * @author alesch
 * This class can read from file, validate, and write to file
 * ecore models. It can be used in Java standalone mode, 
 * as it first registers the metamodel.
 * In order to write models, subclasses should define initMetaModel method.
 */
public class ModelManager {

	protected URI model;
	protected Resource resource;
	protected ResourceSet resourceSet = new ResourceSetImpl();
	protected EPackage ePackage = null;
	protected String fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
	
	/*
	 * This method should be overridden by subclasses in order to save a model.
	 */
	protected void initMetaModel() {
		assert(1==2);
	}

	public ModelManager() {
		this( "unnamed.xmi" );
	}
	
	public ModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	public ModelManager(URI model) {
		init( model );
	}

	public void LoadIt() throws InvalidModelException {	
		resource = resourceSet.getResource(model, true);
	}

	public void saveIt() throws IOException {
		if ( resource == null ) {
			assert( getTopElement() != null );
			saveAs( model );
		}
		resource.save(null);
	}
	
	public void saveAs(String pathname) throws IOException {
		URI modelURI = URI.createFileURI(pathname);
		saveAs(modelURI);		
	}

	public void saveAs(URI modelURI) throws IOException {
		Resource aNewResource = createNewResource(modelURI);
		setTopElementIn( aNewResource );
		aNewResource.save(null);
	}
		
	private void setTopElementIn(Resource aResource) {
		setTopElementIn(getTopElement(), aResource);
	}

	private void setTopElementIn(EObject topElement, Resource aResource) {
		aResource.getContents().add( topElement );		
	}

	public void validateIt() throws InvalidModelException {
		assert(resource != null);
		ModelValidator aModelValidator = new ModelValidator( resource );
		aModelValidator.doIt();
	}

	public EObject getTopElement() {
		EObject result = ( resource == null )? 
				null : resource.getContents().get(0);
		return result;
	}

	public void setTopElement(EObject topElement ) {
		if ( resource == null ) {
			resource = createNewResource( model );
		}
		setTopElementIn(topElement, resource);
	}
	
	private Resource createNewResource(URI modelURI) {
		return resourceSet.createResource( modelURI );
	}

	public String getNsURI() {
		return ePackage.getNsURI();
	}

	public EFactory getFactory() {
		return ePackage.getEFactoryInstance();
	}

	/**
	 * Register the appropriate resource factory to handle file extensions.
	 * In this case, all files (*) will handled by XMI resource Factory.
	 */
	private void setResourceFactoryForFileExtension(String extension) {
		resourceSet.getResourceFactoryRegistry().
			getExtensionToFactoryMap().
			put(extension, 
				new XMIResourceFactoryImpl());
	}

	protected void init(URI model) {
		this.model = model;
		setResourceFactoryForFileExtension( fileExtension );
		initMetaModel();
	}

}
