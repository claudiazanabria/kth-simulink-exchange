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
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.LibraryImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends ProtoObjectImpl implements Library {
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
	protected LibraryImpl() {
		super();
	}
	
	/**
	 * @generated NOT
	 */
	protected LibraryImpl(Identity identity) {
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
		return SimulinkOOAPIPackage.Literals.LIBRARY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.LIBRARY__CHILDREN, oldChildren, children));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.LIBRARY__CHILDREN, oldChildren, children, !oldChildrenESet));
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
			eNotify(new ENotificationImpl(this, Notification.UNSET, SimulinkOOAPIPackage.LIBRARY__CHILDREN, oldChildren, null, oldChildrenESet));
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
				return isSetChildren();
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

} //LibraryImpl
