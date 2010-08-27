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
public abstract class ModelManager implements IModelManager {

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

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#loadIt()
	 */
	public void loadIt() throws InvalidModelException {	
		resource = resourceSet.getResource(model, true);
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#saveIt()
	 */
	public void saveIt() throws IOException {
		if ( resource == null ) {
			assert( getTopElement() != null );
			saveAs( model );
		}
		resource.save(null);
	}
	
	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#saveAs(java.lang.String)
	 */
	public void saveAs(String pathname) throws IOException {
		URI modelURI = URI.createFileURI(pathname);
		saveAs(modelURI);		
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#saveAs(org.eclipse.emf.common.util.URI)
	 */
	public void saveAs(URI modelURI) throws IOException {
		Resource aNewResource = createNewResource(modelURI);
		setTopElementIn( aNewResource );
		aNewResource.save(null);
	}
		
	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#saveAsWithPropperExtension(java.lang.String)
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

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#validateIt()
	 */
	public void validateIt() throws InvalidModelException {
		assert(resource != null);
		ModelValidator aModelValidator = new ModelValidator( resource );
		aModelValidator.doIt();
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#getTopElement()
	 */
	public EObject getTopElement() {
		EObject result = ( resource == null )? 
				null : resource.getContents().get(0);
		return result;
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#setTopElement(org.eclipse.emf.ecore.EObject)
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

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#getNsURI()
	 */
	public String getNsURI() {
		return ePackage.getNsURI();
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#getFactory()
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

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#getFileExtension()
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	protected void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	/* (non-Javadoc)
	 * @see se.kth.md.simulinkExchange.management.IModelManager#traverseWith(se.kth.md.simulinkExchange.management.Traverser)
	 */
	//FIXME this method should be removed
	public void traverseWith(ITraverser traverser) {		
		traverser.doIt( this );
		
	}
	
	public void acceptVisitor(IModelVisitor aVisitor) {
		aVisitor.visit( this.getTopElement() );
	}
}
