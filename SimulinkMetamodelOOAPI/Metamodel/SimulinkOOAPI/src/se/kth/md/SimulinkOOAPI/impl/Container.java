/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IContainer;
import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Container#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Container extends ProtoObject implements IContainer {
	
	protected IChildrenSupport children;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Container() {
		super();
		this.children = new ChildrenSupport();
	}	
	
	protected Container(String name) throws ProtoObjectCreationException {
		super(name);
		this.children = new ChildrenSupport();
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IChildrenSupport getChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildren(IChildrenSupport newChildren, NotificationChain msgs) {
		IChildrenSupport oldChildren = children;
		children = newChildren;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.CONTAINER__CHILDREN, oldChildren, newChildren);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(IChildrenSupport newChildren) {
		if (newChildren != children) {
			NotificationChain msgs = null;
			if (children != null)
				msgs = ((InternalEObject)children).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ISimulinkOOAPIPackage.CONTAINER__CHILDREN, null, msgs);
			if (newChildren != null)
				msgs = ((InternalEObject)newChildren).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ISimulinkOOAPIPackage.CONTAINER__CHILDREN, null, msgs);
			msgs = basicSetChildren(newChildren, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.CONTAINER__CHILDREN, newChildren, newChildren));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return basicSetChildren(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return getChildren();
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
			case ISimulinkOOAPIPackage.CONTAINER__CHILDREN:
				setChildren((IChildrenSupport)newValue);
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
			case ISimulinkOOAPIPackage.CONTAINER__CHILDREN:
				setChildren((IChildrenSupport)null);
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
			case ISimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return children != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void addChild(IProtoObject child) throws AddChildException {		
		if (this instanceof Model)
			child.addTo((Model)this);		
		else if (this instanceof System)
			child.addTo((System)this);
		else if (this instanceof Library)
			child.addTo((Library)this);
	}

	@Override
	public ISimulinkList<IProtoObject> getAllChildren() {
		return this.children.getChildren();
	}
	
	@Override
	public int getNumberOfChildren() {
		return this.children.getNumberOfChildren();
	}
	
	@Override
	public IProtoObject childWith(String uuidOrName) {
		for (IProtoObject child : getAllChildren()){
			if (child.getName().equals(uuidOrName) || child.getUuid().equals(uuidOrName)){
				return child;
			}
		}		
		return null;
	}
	
	@Override	
	public ISimulinkList<IGainBlock> getChildrenOfTypeGainBlock() {
		return this.children.getChildrenOfTypeGainBlock();
	}
	
	@Override
	public ISimulinkList<ISystem> getChildrenOfTypeSystem() {
		return children.getChildrenOfTypeSystem();
	}	

} //Container
