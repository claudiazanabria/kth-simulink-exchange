/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SimulinkOOAPIPackage;

import org.eclipse.emf.ecore.EClass;

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
	
	protected InportImpl(String name, Library parent) {
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
	public static Inport newNamedWithin(String name, System parent){
		Inport inport = new InportImpl(name, parent);		
		return inport;
	}
	
	/**
	 * Returns new instance of Inport with the given name within the given library	 
	 */
	public static Inport newNamedWithin(String name, Library parent){
		Inport inport = new InportImpl(name, parent);		
		return inport;
	}

} //InportImpl
