/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.util.ErrorMessages;

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
	
	protected InportImpl(String name, System parent) {
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
	public void ifInportAddToList(ReflectionList<Inport> list) {
			list.add(this);
	}
	
	/**
	 * Returns new instance of Inport with the given name within the given system	 
	 */
	@Deprecated
	public static Inport newNamedWithin(String name, System parent){
		Inport inport = new InportImpl(name, parent);		
		return inport;
	}	

	@Override
	public void addTo(Model parent) {
		throw new IllegalArgumentException(ErrorMessages.PORT_ADD_TO_MODEL);		
	}	

	@Override
	public void addTo(Library parent) {
		throw new IllegalArgumentException(ErrorMessages.PORT_ADD_TO_LIBRARY);		
	}
	
	public static InportImpl newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{		
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException();		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);		
		System parent = (System) constructDict.get(Factory.keyWithin);
		
		return new InportImpl(name, parent);		
	}

} //InportImpl
