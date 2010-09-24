package se.kth.md.management;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

import se.kth.md.management.exceptions.InvalidModelException;

public interface IModelManager {

	/**
	 * Loads a previously opened model into memory.
	 * Models are opened with this class' constructor.
	 * @throws InvalidModelException If the model does not complies with the registered metamodel.
	 */
	public void loadIt() throws InvalidModelException;

	/**
	 * Saves the model in memory to a file.
	 */
	public void saveIt() throws IOException;

	/** 
	 * Saves the model in memory to a file with the given name.
	 * @param pathname File name where to save the model.
	 * @throws IOException
	 */
	public void saveAs(String pathname) throws IOException;

	/** 
	 * Saves the model in memory to a URI with the given name.
	 * @param modelURI URI where to save the model.
	 * @throws IOException
	 */
	public void saveAs(URI modelURI) throws IOException;

	/**
	 * Saves the model to a file, replacing the original extension.
	 * Extensions are specific for each metamodel, and defined by subclasses.
	 * @param originalPathName Original file name.
	 * @throws IOException
	 */
	public void saveAsWithPropperExtension(String originalPathName)
			throws IOException;

	/**
	 * Validates that the model in memory complies with the metamodel.
	 * It uses ModelValidator to achieve this.
	 * @throws InvalidModelException
	 */
	public void validateIt() throws InvalidModelException;

	/**
	 * @return the top element from the model.
	 */
	public EObject getTopElement();

	/**
	 * Sets topElement at the top if the model hierarchy.
	 * @param topElement
	 */
	public void setTopElement(EObject topElement);

	/**
	 * @return the string that identifies this metamodel: NsURI.
	 */
	public String getNsURI();

	/**
	 * The factory is used to create elements from this metamodel.
	 * @return the factory class for this metamodel.
	 */
	public EFactory getFactory();

	/**
	 * @return the file extension used by this metamodel.
	 */
	public String getFileExtension();

}