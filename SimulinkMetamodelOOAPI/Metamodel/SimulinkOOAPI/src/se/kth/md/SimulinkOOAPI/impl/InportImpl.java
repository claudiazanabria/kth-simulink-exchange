/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InportImpl extends PortImpl implements Inport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InportImpl() {
		super();
	}
	
	/**
	 * Constructs an Inport with the given name within the given system.
	 * @throws ProtoObjectCreationException 
	 */
	protected InportImpl(String name, System parent) throws ProtoObjectCreationException {
		super(name, parent);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.INPORT;
	}
	
	@Override
	public void ifInportAddToList(SimulinkList<Inport> list) {
		list.add(this);
	}
	
	@Override
	public void addTo(Model parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	@Override
	public void addTo(Library parent) throws AddChildException{
		throw new AddChildException(this, parent);		
	}
	
	/**
	 * Returns new instance of Inport with the given name within the given system	 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Inport newNamedWithin(String name, System parent) throws ProtoObjectCreationException{		
		return new InportImpl(name, parent);
	}		
	
	@Deprecated
	public static Inport newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);		
		System parent = (System) constructDict.get(FactoryImpl.keyWithin);
		
		return new InportImpl(name, parent);		
	}

} //Inport
