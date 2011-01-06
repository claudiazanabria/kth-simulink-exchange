/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import se.kth.md.SimulinkOOAPI.Model;
import se.kth.md.SimulinkOOAPI.SimulinkList;
import se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.System;
import se.kth.md.SimulinkOOAPI.SystemReference;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.SystemReferenceImpl#getTarget <em>Target</em>}</li>
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
	protected se.kth.md.SimulinkOOAPI.System target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemReferenceImpl() {
		super();
	}
	
	protected SystemReferenceImpl(String name, System parent, System target) throws ProtoObjectCreationException {
		super(name);		
		if (parent.equals(target))
			throw new ProtoObjectCreationException(ErrorMessages.SYS_REF_TARGET_EQUALS_PARENT);
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. System reference can be added to system.
		}
		this.target = target;
	}
	
	protected SystemReferenceImpl(String name, Model parent, System target) throws ProtoObjectCreationException {
		super(name);	
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. System references can be added to models.
		}
		this.target = target;
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
	public se.kth.md.SimulinkOOAPI.System getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (se.kth.md.SimulinkOOAPI.System)eResolveProxy(oldTarget);
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
	public se.kth.md.SimulinkOOAPI.System basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(se.kth.md.SimulinkOOAPI.System newTarget) {
		se.kth.md.SimulinkOOAPI.System oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET, oldTarget, target));
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
				setTarget((se.kth.md.SimulinkOOAPI.System)newValue);
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
				setTarget((se.kth.md.SimulinkOOAPI.System)null);
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
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemReferenceAddToList(SimulinkList<SystemReference> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given model, targeting to the given system
	 * @throws ProtoObjectCreationException 
	 */	
	protected static SystemReference newNamedWithinTargeting(String name, Model parent, System target) throws ProtoObjectCreationException{		
		return new SystemReferenceImpl(name, parent, target);
	}
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given system, targeting to the given system
	 * @throws ProtoObjectCreationException 
	 */	
	protected static SystemReference newNamedWithinTargeting(String name, System parent, System target) throws ProtoObjectCreationException{
		return new SystemReferenceImpl(name, parent, target);
	}
	
	@Deprecated
	public static SystemReference newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyTargeting))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		System target = (System) constructDict.get(FactoryImpl.keyTargeting);
		System system = null;
		Model model = null;
		Object parent = constructDict.get(FactoryImpl.keyWithin);
		if (parent instanceof Model)
			model = (Model) parent;
		else
			system = (System)parent;
		
		if (system != null)
			return new SystemReferenceImpl(name, system, target);
		else
			return new SystemReferenceImpl(name, model, target);		
	}

} //SystemReference
