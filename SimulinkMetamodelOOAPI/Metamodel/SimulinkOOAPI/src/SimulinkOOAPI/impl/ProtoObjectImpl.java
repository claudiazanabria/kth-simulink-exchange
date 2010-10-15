/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.SystemReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proto Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.ProtoObjectImpl#getIdentity <em>Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProtoObjectImpl extends EObjectImpl implements ProtoObject {
	/**
	 * The cached value of the '{@link #getIdentity() <em>Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentity()
	 * @generated
	 * @ordered
	 */
	protected Identity identity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ProtoObjectImpl() {
		//throw new UnsupportedOperationException();
	}
	
	protected ProtoObjectImpl(Identity identity) {
		super();
		this.identity = identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.PROTO_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identity getIdentity() {
		if (identity != null && identity.eIsProxy()) {
			InternalEObject oldIdentity = (InternalEObject)identity;
			identity = (Identity)eResolveProxy(oldIdentity);
			if (identity != oldIdentity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, oldIdentity, identity));
			}
		}
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Identity basicGetIdentity() {
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentity(Identity newIdentity) {
		Identity oldIdentity = identity;
		identity = newIdentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, oldIdentity, identity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				if (resolve) return getIdentity();
				return basicGetIdentity();
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
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				setIdentity((Identity)newValue);
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
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				setIdentity((Identity)null);
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
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				return identity != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**	 
	 * @generated NOT
	 */
	@Override
	public void ifGainBlockAddToList(ReflectionList<GainBlock> list) {}
	
	/**	 
	 * @generated NOT
	 */
	@Override
	public void ifSystemAddToList(ReflectionList<SimulinkOOAPI.System> list) {}
	
	/**	 
	 * @generated NOT
	 */
	@Override
	public void ifLineAddToList(ReflectionList<Line> list) {}
	
	/**	 
	 * @generated NOT
	 */
	@Override
	public void ifPortAddToList(ReflectionList<Port> list){}
	
	@Override
	public void ifSystemReferenceAddToList(ReflectionList<SystemReference> list){}

} //ProtoObjectImpl
