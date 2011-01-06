/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import se.kth.md.SimulinkOOAPI.Container;
import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.ProtoObject;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.ContainerImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContainerImpl extends ProtoObjectImpl implements Container {
	
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtoObject> children;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ContainerImpl() {
		super();
		//this.children = new ChildrenSupportImpl();		
		this.children = new EObjectContainmentEList<ProtoObject>(ProtoObject.class, this, SimulinkOOAPIPackage.CONTAINER__CHILDREN);
	}	
	
	protected ContainerImpl(String name) throws ProtoObjectCreationException {
		super(name);
		//this.children = new ChildrenSupportImpl();
		this.children = new EObjectContainmentEList<ProtoObject>(ProtoObject.class, this, SimulinkOOAPIPackage.CONTAINER__CHILDREN);
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.CONTAINER;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtoObject> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<ProtoObject>(ProtoObject.class, this, SimulinkOOAPIPackage.CONTAINER__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case SimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */	
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimulinkOOAPIPackage.CONTAINER__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ProtoObject>)newValue);
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
			case SimulinkOOAPIPackage.CONTAINER__CHILDREN:
				getChildren().clear();
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
			case SimulinkOOAPIPackage.CONTAINER__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void addChild(ProtoObject child) throws AddChildException {		
		if (this instanceof ModelImpl)
			child.addTo((ModelImpl)this);		
		else if (this instanceof SystemImpl)
			child.addTo((SystemImpl)this);
		else if (this instanceof LibraryImpl)
			child.addTo((LibraryImpl)this);
	}

	@Override
	public EList<ProtoObject> getAllChildren() {
		return this.children;
	}
	
	@Override
	public int getNumberOfChildren() {
		return this.children.size();
	}
	
	@Override
	public ProtoObject childWith(String uuidOrName) {
		for (ProtoObject child : getAllChildren()){
			if (child.getName().equals(uuidOrName) || child.getUuid().equals(uuidOrName)){
				return child;
			}
		}		
		return null;
	}
	
	@Override
	public SimulinkList<GainBlock> getChildrenOfTypeGainBlock() {
		SimulinkList<GainBlock> result = new SimulinkListImpl<GainBlock>();

		for (ProtoObject child : this.children) {
			child.ifGainBlockAddToList(result);
		}
		return result;
	}
	
	@Override
	public SimulinkList<System> getChildrenOfTypeSystem() {
		SimulinkList<System> result = new SimulinkListImpl<System>();

		for (ProtoObject child : this.children) {
			child.ifSystemAddToList(result);
		}
		return result;
	}

	

} //Container
