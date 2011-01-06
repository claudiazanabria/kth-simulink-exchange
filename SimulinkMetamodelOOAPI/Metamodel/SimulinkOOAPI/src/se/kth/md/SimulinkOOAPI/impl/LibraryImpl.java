/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
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
public class LibraryImpl extends ContainerImpl implements Library {
	
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}	
	
	/**
	 * Constructs a new Library with the given name
	 * @throws ProtoObjectCreationException 
	 */
	protected LibraryImpl(String name) throws ProtoObjectCreationException {
		super(name);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.LIBRARY;
	}

	@Override
	public void addTo(System parent) throws AddChildException{
		throw new AddChildException(this, parent);		
	}

	@Override
	public void addTo(Library parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	@Override
	public void addTo(Model parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	/**
	 * Returns new Library instance with the given name.
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Library newNamed(String name) throws ProtoObjectCreationException{				
		return new LibraryImpl(name);
	}	
		
	
	@Deprecated
	public static Library newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		return new LibraryImpl(name);		
	}

} //Library
