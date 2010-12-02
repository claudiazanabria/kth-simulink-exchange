/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;

import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
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
public class Inport extends Port implements IInport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Inport() {
		super();
	}
	
	/**
	 * Constructs an Inport with the given name within the given system.
	 * @throws ProtoObjectCreationException 
	 */
	protected Inport(String name, ISystem parent) throws ProtoObjectCreationException {
		super(name, parent);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.INPORT;
	}
	
	@Override
	public void ifInportAddToList(ISimulinkList<IInport> list) {
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
	 * Returns new instance of Inport with the given name within the given system	 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static IInport newNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException{		
		return new Inport(name, parent);
	}		
	
	@Deprecated
	public static IInport newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException("");		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);		
		ISystem parent = (ISystem) constructDict.get(Factory.keyWithin);
		
		return new Inport(name, parent);		
	}

} //Inport
