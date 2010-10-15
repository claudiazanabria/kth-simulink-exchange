/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.Outport;
import SimulinkOOAPI.SimulinkOOAPIPackage;

import org.eclipse.emf.ecore.EClass;

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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.OUTPORT;
	}
	
	/**
	 * Returns new instance of Outport with the given name within the given system	 
	 */
	public static Outport newNamedWithin(String name, SimulinkOOAPI.System system){
		Outport inport = new OutportImpl();
		inport.setIdentity(IdentityImpl.newNamed(name));
		system.addChild(inport);
		return inport;
	}

} //OutportImpl
