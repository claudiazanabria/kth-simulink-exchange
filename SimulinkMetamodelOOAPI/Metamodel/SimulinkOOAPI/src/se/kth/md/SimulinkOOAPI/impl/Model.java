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
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
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
public class Model extends Container implements IModel {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Model() {
		super();		
	}	
	
	protected Model(String name) throws ProtoObjectCreationException {
		super(name);		
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.MODEL;
	}	
	
	@Override
	public ISimulinkList<ILine> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}
	
	/**
	 * Returns new Model instance with the given name
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Model newNamed(String name) throws ProtoObjectCreationException{						
		return new Model(name);
	}

	@Override
	public void addTo(IModel parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}

	@Override
	public void addTo(ISystem parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Override
	public void addTo(ILibrary parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Deprecated
	public static IModel newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		
		String name = (String) constructDict.get(Factory.keyWithName);
		return new Model(name);		
	}

} //Model
