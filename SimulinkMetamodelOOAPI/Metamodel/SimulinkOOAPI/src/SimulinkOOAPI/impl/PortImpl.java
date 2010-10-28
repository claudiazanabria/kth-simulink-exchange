/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.Library;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import org.eclipse.emf.common.notify.Notification;
import SimulinkOOAPI.System;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.PortImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PortImpl extends ProtoObjectImpl implements Port {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected SimulinkOOAPI.System parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}
	
	protected PortImpl(String name, System parent) {
		super(name);
		parent.addChild(this);
		this.parent = parent;
	}
	
	//TODO: can we add ports to library?
	protected PortImpl(String name, Library parent) {
		super(name);
		parent.addChild(this);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.PORT;
	}	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPI.System getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (SimulinkOOAPI.System)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.PORT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPI.System basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(SimulinkOOAPI.System newParent) {
		SimulinkOOAPI.System oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.PORT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.PORT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
			case SimulinkOOAPIPackage.PORT__PARENT:
				setParent((SimulinkOOAPI.System)newValue);
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
			case SimulinkOOAPIPackage.PORT__PARENT:
				setParent((SimulinkOOAPI.System)null);
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
			case SimulinkOOAPIPackage.PORT__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}

	public void ifPortAddToList(ReflectionList<Port> list){
		list.add(this);
	}

} //PortImpl
