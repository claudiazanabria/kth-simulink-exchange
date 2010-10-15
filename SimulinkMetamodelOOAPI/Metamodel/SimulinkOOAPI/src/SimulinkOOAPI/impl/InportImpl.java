/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.Inport;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.INPORT;
	}
	
	/**
	 * Returns new instance of Inport with the given name within the given system	 
	 */
	public static Inport newNamedWithin(String name, SimulinkOOAPI.System system){
		Inport inport = new InportImpl();
		inport.setIdentity(IdentityImpl.newNamed(name));
		system.addChild(inport);
		return inport;
	}

} //InportImpl
