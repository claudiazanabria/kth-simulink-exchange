/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Identity;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.SystemReferenceImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link SimulinkOOAPI.impl.SystemReferenceImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemReferenceImpl extends ProtoObjectImpl implements SystemReference {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SimulinkOOAPI.System target;
	
	private ChildrenSupport children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemReferenceImpl() {
		super();
	}
	
	/**
	 * @generated NOT
	 */
	//TODO: pass target system into constructor
	protected SystemReferenceImpl(Identity identity) {
		super(identity);
		children = new ChildrenSupportImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.SYSTEM_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPI.System getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (SimulinkOOAPI.System)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulinkOOAPI.System basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SimulinkOOAPI.System newTarget) {
		SimulinkOOAPI.System oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildrenSupport getChildren() {
		ChildrenSupport children = basicGetChildren();
		return children != null && children.eIsProxy() ? (ChildrenSupport)eResolveProxy((InternalEObject)children) : children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildrenSupport basicGetChildren() {
		// TODO: implement this method to return the 'Children' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(ChildrenSupport newChildren) {
		// TODO: implement this method to set the 'Children' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__CHILDREN:
				if (resolve) return getChildren();
				return basicGetChildren();
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
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				setTarget((SimulinkOOAPI.System)newValue);
				return;
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__CHILDREN:
				setChildren((ChildrenSupport)newValue);
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
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				setTarget((SimulinkOOAPI.System)null);
				return;
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__CHILDREN:
				setChildren((ChildrenSupport)null);
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
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				return target != null;
			case SimulinkOOAPIPackage.SYSTEM_REFERENCE__CHILDREN:
				return basicGetChildren() != null;
		}
		return super.eIsSet(featureID);
	}	

	/**	
	 * @generated NOT
	 */
	@Override
	public void addChild(ProtoObject child) {		
		this.children.addChild(child);
	}

	/**	
	 * @generated NOT
	 */
	@Override
	public ReflectionList<ProtoObject> getAllChildren() {
		return this.children.getChildren();
	}

	/**	
	 * @generated NOT
	 */
	@Override
	public int getNumberOfChildren() {
		return this.children.getNumberOfChildren();
	}
	
	/**	
	 * @generated NOT
	 */
	@Override	
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock() {
		return this.children.getChildrenOfTypeGainBlock();
	}

	
	@Override
	public ReflectionList<Line> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}

	@Override
	public ReflectionList<System> getChildrenOfTypeSystem() {
		return children.getChildrenOfTypeSystem();
	}

	@Override
	public ReflectionList<Port> getChildrenOfTypePort() {
		return children.getChildrenOfTypePort();
	}

	@Override
	public ReflectionList<SystemReference> getChildrenOfTypeSystemReference() {
		return children.getChildrenOfTypeSystemReference();
	}

	@Override
	public void ifSystemReferenceAddToList(ReflectionList<SystemReference> list){
		list.add(this);
	}
} //SystemReferenceImpl
