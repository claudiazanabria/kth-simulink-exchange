/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import se.kth.md.SimulinkOOAPI.IIdentity;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Identity#getUuid <em>Uuid</em>}</li>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Identity#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Identity extends EObjectImpl implements IIdentity {	
	
	private String uuid;
	
	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Identity() {
		super();
		this.uuid = EcoreUtil.generateUUID();
	}
	
	/**
	 * Constructs an Identity with the given name. Uuid is generated.
	 */
	protected Identity(String name) throws ProtoObjectCreationException {
		this();		
		try{
			setName(name);
		}catch(IllegalArgumentException e){
			throw new ProtoObjectCreationException(e.getMessage());
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.IDENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUuid(String newUuid) {		
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a new name to the identity.	  
	 * @generated NOT
	 * @throws IllegalArgumentException - If a new name starts with a number, contains spaces or special symbols except for . _ -
	 */
	public void setName(String newName) {
		Pattern pattern = Pattern.compile("([a-zA-Z]){1}([a-zA-Z0-9._-]+)*");
		Matcher matcher = pattern.matcher(newName);
		if (!matcher.matches())
		    throw new IllegalArgumentException(ErrorMessages.INVALID_SIMULINK_NAME);
		
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.IDENTITY__NAME, oldName, name));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.IDENTITY__UUID:
				return getUuid();
			case ISimulinkOOAPIPackage.IDENTITY__NAME:
				return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.IDENTITY__UUID:
				setUuid((String)newValue);
				return;
			case ISimulinkOOAPIPackage.IDENTITY__NAME:
				setName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.IDENTITY__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case ISimulinkOOAPIPackage.IDENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.IDENTITY__UUID:
				return UUID_EDEFAULT == null ? getUuid() != null : !UUID_EDEFAULT.equals(getUuid());
			case ISimulinkOOAPIPackage.IDENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Returns new Identity instance with the given name.
	 * @param aName
	 * @return
	 * @throws ProtoObjectCreationException 
	 */
	public static IIdentity newNamed(String name) throws ProtoObjectCreationException{
		Identity identity = new Identity(name);
		return identity;
	}

} //Identity
