/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class Library extends Container implements ILibrary {
	
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated 
	 */
	protected Library() {
		super();		
	}	
	
	/**
	 * Constructs a new Library with the given name
	 * @throws ProtoObjectCreationException 
	 */
	protected Library(String name) throws ProtoObjectCreationException {
		super(name);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.LIBRARY;
	}

	@Override
	public void addTo(ISystem parent) throws AddChildException{
		throw new AddChildException(this, parent);		
	}

	@Override
	public void addTo(ILibrary parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	@Override
	public void addTo(IModel parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	/**
	 * Returns new Library instance with the given name.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static ILibrary newNamed(String name) throws ProtoObjectCreationException{				
		return new Library(name);
	}	
		
	
	@Deprecated
	public static ILibrary newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		
		String name = (String) constructDict.get(Factory.keyWithName);
		return new Library(name);		
	}

} //Library
