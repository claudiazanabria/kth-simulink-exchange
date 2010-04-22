package se.kth.md.simulinkExchange;

import java.io.IOException;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.apache.commons.io.FilenameUtils;

import se.kth.md.simulinkExchange.exceptions.InvalidModelException;

/**
 * Resumen corto aca.
 * This class can read from file, validate, and write to file
 * ecore models. It can be used in Java standalone mode, 
 * as it first registers the metamodel.
 * In order to write models, subclasses should define initMetaModel method.
 * 
 * \author Alex Schenkman
 */
public abstract class ModelManager {

	protected URI model;
	protected Resource resource;
	protected ResourceSet resourceSet = new ResourceSetImpl();
	protected EPackage ePackage = null;
	protected String fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
	
	protected abstract void initMetaModel();

	/** 
	 * Brief desc ends here. The rest is the detailed description.
	 * or Am i wrong?
	 * 
	 */
	public ModelManager() {
		this( "unnamed.xmi" );
	}
	
	/**
	 * @param modelPath File path to a model file.
	 */
	public ModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	public ModelManager(URI model) {
		init( model );
	}

	public void loadIt() throws InvalidModelException {	
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
		
	public void saveAsWithPropperExtension(String originalPathName) throws IOException {
		String newFileName = replaceExtension(originalPathName, fileExtension); 
		saveAs( newFileName );
	}

	//This should be private, but I wanted a test case.
	public String replaceExtension(String pathName, String extension) {
		return FilenameUtils.removeExtension(pathName) + '.' + extension;
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

	public String getFileExtension() {
		return fileExtension;
	}

	protected void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

}
