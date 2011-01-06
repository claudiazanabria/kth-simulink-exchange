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
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OutportImpl extends PortImpl implements Outport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutportImpl() {
		super();
	}
	
	protected OutportImpl(String name, System parent) throws ProtoObjectCreationException {
		super(name, parent);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.OUTPORT;
	}
	
	@Override
	public void ifOutportAddToList(SimulinkList<Outport> list){
		list.add(this);
	}
	
	@Override
	public void addTo(Model parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	

	@Override
	public void addTo(Library parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Outport newNamedWithin(String name, System parent) throws ProtoObjectCreationException{		
		return new OutportImpl(name, parent);
	}
	
	
	@Deprecated
	public static Outport newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);		
		System parent = (System) constructDict.get(FactoryImpl.keyWithin);
		
		return new OutportImpl(name, parent);		
	}

} //Outport
