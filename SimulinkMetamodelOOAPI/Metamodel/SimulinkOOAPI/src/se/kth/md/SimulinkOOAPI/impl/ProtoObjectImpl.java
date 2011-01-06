/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import se.kth.md.SimulinkOOAPI.GainBlock;
import se.kth.md.SimulinkOOAPI.Identity;
import se.kth.md.SimulinkOOAPI.Inport;
import se.kth.md.SimulinkOOAPI.Library;
import se.kth.md.SimulinkOOAPI.Line;
import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.Outport;
import se.kth.md.SimulinkOOAPI.Port;
import se.kth.md.SimulinkOOAPI.ProtoObject;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proto Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.ProtoObjectImpl#getIdentity <em>Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProtoObjectImpl extends EObjectImpl implements ProtoObject {
	/**
	 * The cached value of the '{@link #getIdentity() <em>Identity</em>}' containment reference.
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
		super();
		this.identity = new IdentityImpl();
	}
	
	protected ProtoObjectImpl(String name) throws ProtoObjectCreationException {
		super();
		this.identity = IdentityImpl.newNamed(name);
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
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentity(Identity newIdentity, NotificationChain msgs) {
		Identity oldIdentity = identity;
		identity = newIdentity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, oldIdentity, newIdentity);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentity(Identity newIdentity) {
		if (newIdentity != identity) {
			NotificationChain msgs = null;
			if (identity != null)
				msgs = ((InternalEObject)identity).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, null, msgs);
			if (newIdentity != null)
				msgs = ((InternalEObject)newIdentity).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, null, msgs);
			msgs = basicSetIdentity(newIdentity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, newIdentity, newIdentity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				return basicSetIdentity(null, msgs);
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
			case SimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				return getIdentity();
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
	
	@Override
	public void ifGainBlockAddToList(SimulinkList<GainBlock> list) {}
	
	@Override
	public void ifSystemAddToList(SimulinkList<System> list) {}
	
	@Override
	public void ifLineAddToList(SimulinkList<Line> list) {}
	
	@Override
	public void ifPortAddToList(SimulinkList<Port> list){}
	
	@Override
	public void ifSystemReferenceAddToList(SimulinkList<SystemReference> list){}
	
	@Override
	public void ifOutportAddToList(SimulinkList<Outport> list){}
	
	@Override
	public void ifInportAddToList(SimulinkList<Inport> list){}
	
	@Override
	public void addTo(Model parent) throws AddChildException{
		parent.getAllChildren().add(this);
	}

	@Override
	public void addTo(System parent) throws AddChildException{
		parent.getAllChildren().add(this);		
	}
	
	@Override
	public void addTo(Library parent) throws AddChildException{
		parent.getAllChildren().add(this);
	}
	
	@Override
	public String getName() {	
		return this.identity.getName();
	}
	
	@Override
	public String getUuid() {	
		return this.identity.getUuid();
	}
	
	
	@Override
	public ProtoObject childWith(String nameOrUuid) {	
		return null;
	}
	
	@Override
	public EList<ProtoObject> getAllChildren() {	
		return new BasicEList<ProtoObject>();
	}
	
	@Override
	public ProtoObject searchInModel(String nameOrUuid) {
		if (this.getName().equals(nameOrUuid) || this.getUuid().equals(nameOrUuid))
			return this;
		
		return childWith(nameOrUuid, this);
	}
	
	private ProtoObject childWith(String name, ProtoObject container){			
		if (container.childWith(name)!=null)
			return container.childWith(name);
		
		for (ProtoObject child: container.getAllChildren()){			
			return childWith(name, child);			
		}
		return null;
	}

} //ProtoObject
