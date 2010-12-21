/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.IIdentity;
import se.kth.md.SimulinkOOAPI.IInport;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IOutport;
import se.kth.md.SimulinkOOAPI.IPort;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proto Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.ProtoObject#getIdentity <em>Identity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProtoObject extends EObjectImpl implements IProtoObject {
	/**
	 * The cached value of the '{@link #getIdentity() <em>Identity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentity()
	 * @generated
	 * @ordered
	 */
	protected IIdentity identity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ProtoObject() {
		//throw new UnsupportedOperationException();
		super();
		this.identity = new Identity();
	}
	
	protected ProtoObject(String name) throws ProtoObjectCreationException {
		super();
		this.identity = Identity.newNamed(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.PROTO_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IIdentity getIdentity() {
		if (identity != null && identity.eIsProxy()) {
			InternalEObject oldIdentity = (InternalEObject)identity;
			identity = (IIdentity)eResolveProxy(oldIdentity);
			if (identity != oldIdentity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, oldIdentity, identity));
			}
		}
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IIdentity basicGetIdentity() {
		return identity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentity(IIdentity newIdentity) {
		IIdentity oldIdentity = identity;
		identity = newIdentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY, oldIdentity, identity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
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
			case ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				setIdentity((IIdentity)newValue);
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
			case ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				setIdentity((IIdentity)null);
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
			case ISimulinkOOAPIPackage.PROTO_OBJECT__IDENTITY:
				return identity != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifGainBlockAddToList(ISimulinkList<IGainBlock> list) {}
	
	@Override
	public void ifSystemAddToList(ISimulinkList<ISystem> list) {}
	
	@Override
	public void ifLineAddToList(ISimulinkList<ILine> list) {}
	
	@Override
	public void ifPortAddToList(ISimulinkList<IPort> list){}
	
	@Override
	public void ifSystemReferenceAddToList(ISimulinkList<ISystemReference> list){}
	
	@Override
	public void ifOutportAddToList(ISimulinkList<IOutport> list){}
	
	@Override
	public void ifInportAddToList(ISimulinkList<IInport> list){}
	
	@Override
	public void addTo(IModel parent) throws AddChildException{
		parent.getAllChildren().add(this);
	}

	@Override
	public void addTo(ISystem parent) throws AddChildException{
		parent.getAllChildren().add(this);		
	}
	
	@Override
	public void addTo(ILibrary parent) throws AddChildException{
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
	public IProtoObject childWith(String nameOrUuid) {	
		return null;
	}
	
	@Override
	public ISimulinkList<IProtoObject> getAllChildren() {	
		return new SimulinkList<IProtoObject>();
	}
	
	@Override
	public IProtoObject searchInModel(String nameOrUuid) {
		if (this.getName().equals(nameOrUuid) || this.getUuid().equals(nameOrUuid))
			return this;
		
		return childWith(nameOrUuid, this);
	}
	
	private IProtoObject childWith(String name, IProtoObject container){			
		if (container.childWith(name)!=null)
			return container.childWith(name);
		
		for (IProtoObject child: container.getAllChildren()){			
			return childWith(name, child);			
		}
		return null;
	}

} //ProtoObject
