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
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
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
public class Outport extends Port implements IOutport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Outport() {
		super();
	}
	
	protected Outport(String name, ISystem parent) throws ProtoObjectCreationException {
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
	public void ifOutportAddToList(ISimulinkList<IOutport> list){
		list.add(this);
	}
	
	@Override
	public void addTo(IModel parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	

	@Override
	public void addTo(ILibrary parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static IOutport newNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException{		
		return new Outport(name, parent);
	}
	
	
	@Deprecated
	public static IOutport newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException("");		
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);		
		ISystem parent = (ISystem) constructDict.get(Factory.keyWithin);
		
		return new Outport(name, parent);		
	}

} //Outport
