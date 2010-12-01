/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.util.ErrorMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class Outport extends Port implements IOutport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Outport() {
		super();
	}
	
	protected Outport(String name, ISystem parent) {
		super(name, parent);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.OUTPORT;
	}
	
	@Override
	public void ifOutportAddToList(IReflectionList<IOutport> list){
		list.add(this);
	}
	
	@Override
	public void addTo(IModel parent) {
		throw new IllegalArgumentException(ErrorMessages.PORT_ADD_TO_MODEL);		
	}	

	@Override
	public void addTo(ILibrary parent) {
		throw new IllegalArgumentException(ErrorMessages.PORT_ADD_TO_LIBRARY);		
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */	
	public static IOutport newNamedWithin(String name, ISystem parent){		
		return new Outport(name, parent);
	}
	
	
	public static IOutport newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException();		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);		
		ISystem parent = (ISystem) constructDict.get(Factory.keyWithin);
		
		return new Outport(name, parent);		
	}

} //Outport
