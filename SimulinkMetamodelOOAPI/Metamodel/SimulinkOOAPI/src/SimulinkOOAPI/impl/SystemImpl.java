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
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.SystemImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ProtoObjectImpl implements SimulinkOOAPI.System {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected ChildrenSupport children;

	/**
	 * This is true if the Children reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean childrenESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */	
	protected SystemImpl(Identity identity) {
		super(identity);
		this.children = new ChildrenSupportImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildrenSupport getChildren() {
		if (children != null && children.eIsProxy()) {
			InternalEObject oldChildren = (InternalEObject)children;
			children = (ChildrenSupport)eResolveProxy(oldChildren);
			if (children != oldChildren) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.SYSTEM__CHILDREN, oldChildren, children));
			}
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildrenSupport basicGetChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(ChildrenSupport newChildren) {
		ChildrenSupport oldChildren = children;
		children = newChildren;
		boolean oldChildrenESet = childrenESet;
		childrenESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.SYSTEM__CHILDREN, oldChildren, children, !oldChildrenESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetChildren() {
		ChildrenSupport oldChildren = children;
		boolean oldChildrenESet = childrenESet;
		children = null;
		childrenESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SimulinkOOAPIPackage.SYSTEM__CHILDREN, oldChildren, null, oldChildrenESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetChildren() {
		return childrenESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				unsetChildren();
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				return isSetChildren();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemAddToList(ReflectionList<System> list){
		list.add(this);
	}
	
	@Override
	public void addChild(ProtoObject child) {		
		this.children.addChild(child);
	}

	
	@Override
	public ReflectionList<ProtoObject> getAllChildren() {
		return this.children.getChildren();
	}

	
	@Override
	public int getNumberOfChildren() {
		return this.children.getNumberOfChildren();
	}

	@Override
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock() {		
		return children.getChildrenOfTypeGainBlock();
	}

	@Override
	public ReflectionList<Line> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}

	@Override
	public ReflectionList<Port> getChildrenOfTypePort() {
		return children.getChildrenOfTypePort();
	}

	@Override
	public ReflectionList<System> getChildrenOfTypeSystem() {
		return children.getChildrenOfTypeSystem();		
	}
	
	@Override
	public ReflectionList<SystemReference> getChildrenOfTypeSystemReference() {
		return children.getChildrenOfTypeSystemReference();
	}

} //SystemImpl
