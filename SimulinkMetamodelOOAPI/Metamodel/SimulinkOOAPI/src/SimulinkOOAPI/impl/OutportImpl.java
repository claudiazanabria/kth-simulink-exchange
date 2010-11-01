/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import org.eclipse.emf.ecore.EClass;

import SimulinkOOAPI.Library;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.util.ErrorMessages;

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
	
	protected OutportImpl(String name, System parent) {
		super(name, parent);		
	}
	
	protected OutportImpl(String name, Library parent) {
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
	
	public void ifOutportAddToList(ReflectionList<Outport> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */
	public static Outport newNamedWithin(String name, System parent){
		Outport inport = new OutportImpl(name, parent);
		return inport;
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given library	 
	 */
	public static Outport newNamedWithin(String name, Library parent){
		Outport inport = new OutportImpl(name, parent);
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

} //OutportImpl
