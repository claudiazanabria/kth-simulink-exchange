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
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends ContainerImpl implements Model {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}	
	
	protected ModelImpl(String name) throws ProtoObjectCreationException {
		super(name);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.MODEL;
	}	
	
	@Override
	public SimulinkList<Line> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}
	
	/**
	 * Returns new Model instance with the given name
	 * @throws ProtoObjectCreationException 
	 */	
	protected static ModelImpl newNamed(String name) throws ProtoObjectCreationException{						
		return new ModelImpl(name);
	}

	@Override
	public void addTo(Model parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}

	@Override
	public void addTo(System parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Override
	public void addTo(Library parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Deprecated
	public static Model newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		return new ModelImpl(name);		
	}

} //Model
