/**************************************************************************
 * Copyright (c) 2010 KTH, Mechatronics group and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0,
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: KTH, Mechatronics group
 **************************************************************************/

package se.kth.md.simulinkExchange.management;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import se.kth.md.simulinkExchange.management.exceptions.InvalidModelException;

/**
 * Reads, writes and validates models from memory and files.
 * 
 * It is mainly a convenience wrapper around EMF, to simplify these operations.
 * It can be used in Java stand alone mode, i.e. outside of Eclipse. 
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
	 * Opens a model from file.
	 * It relies on ModelManager(URI model).
	 * @param modelPath File path to a model.
	 */
	public ModelManager(String modelPath) {
		this( URI.createFileURI(modelPath) );
	}
	
	/**
	 * Opens a model from a URI.
	 * @param model URI path to a model.
	 */
	public ModelManager(URI model) {
		init( model );
	}

	/**
	 * Loads a previously opened model into memory.
	 * Models are opened with this class' constructor.
	 * @throws InvalidModelException If the model does not complies with the registered metamodel.
	 */
	public void loadIt() throws InvalidModelException {	
		resource = resourceSet.getResource(model, true);
	}

	/**
	 * Saves the model in memory to a file.
	 */
	public void saveIt() throws IOException {
		if ( resource == null ) {
			assert( getTopElement() != null );
			saveAs( model );
		}
		resource.save(null);
	}
	
	/** 
	 * Saves the model in memory to a file with the given name.
	 * @param pathname File name where to save the model.
	 * @throws IOException
	 */
	public void saveAs(String pathname) throws IOException {
		URI modelURI = URI.createFileURI(pathname);
		saveAs(modelURI);		
	}

	/** 
	 * Saves the model in memory to a URI with the given name.
	 * @param modelURI URI where to save the model.
	 * @throws IOException
	 */
	public void saveAs(URI modelURI) throws IOException {
		Resource aNewResource = createNewResource(modelURI);
		setTopElementIn( aNewResource );
		aNewResource.save(null);
	}
		
	/**
	 * Saves the model to a file, replacing the original extension.
	 * Extensions are specific for each metamodel, and defined by subclasses.
	 * @param originalPathName Original file name.
	 * @throws IOException
	 */
	public void saveAsWithPropperExtension(String originalPathName) throws IOException {
		String newFileName = replaceExtension(originalPathName, fileExtension); 
		saveAs( newFileName );
	}

	protected String replaceExtension(String pathName, String extension) {
		return FilenameUtils.removeExtension(pathName) + '.' + extension;
	}
	
	private void setTopElementIn(Resource aResource) {
		setTopElementIn(getTopElement(), aResource);
	}

	private void setTopElementIn(EObject topElement, Resource aResource) {
		aResource.getContents().add( topElement );		
	}

	/**
	 * Validates that the model in memory complies with the metamodel.
	 * It uses ModelValidator to achieve this.
	 * @throws InvalidModelException
	 */
	public void validateIt() throws InvalidModelException {
		assert(resource != null);
		ModelValidator aModelValidator = new ModelValidator( resource );
		aModelValidator.doIt();
	}

	/**
	 * @return the top element from the model.
	 */
	public EObject getTopElement() {
		EObject result = ( resource == null )? 
				null : resource.getContents().get(0);
		return result;
	}

	/**
	 * Sets topElement at the top if the model hierarchy.
	 * @param topElement
	 */
	public void setTopElement(EObject topElement ) {
		if ( resource == null ) {
			resource = createNewResource( model );
		}
		setTopElementIn(topElement, resource);
	}
	
	private Resource createNewResource(URI modelURI) {
		return resourceSet.createResource( modelURI );
	}

	/**
	 * @return the string that identifies this metamodel: NsURI.
	 */
	public String getNsURI() {
		return ePackage.getNsURI();
	}

	/**
	 * The factory is used to create elements from this metamodel.
	 * @return the factory class for this metamodel.
	 */
	public EFactory getFactory() {
		return ePackage.getEFactoryInstance();
	}

	/**
	 * Registers the appropriate resource factory to handle file extensions.
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

	/**
	 * @return the file extension used by this metamodel.
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	protected void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public void traverseWith(Traverser traverser) {		
		traverser.doIt( this );
		
	}

}
