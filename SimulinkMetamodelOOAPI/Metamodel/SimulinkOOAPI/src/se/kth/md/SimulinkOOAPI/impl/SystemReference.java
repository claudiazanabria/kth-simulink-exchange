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

import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IReflectionList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.ISystemReference;
import se.kth.md.SimulinkOOAPI.util.ErrorMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.SystemReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemReference extends ProtoObject implements ISystemReference {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ISystem target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemReference() {
		super();
	}
	
	protected SystemReference(String name, ISystem parent, ISystem target) {
		super(name);		
		if (parent.equals(target))
			throw new IllegalArgumentException(ErrorMessages.SYS_REF_TARGET_EQUALS_PARENT);
		parent.addChild(this);
		this.target = target;
	}
	
	protected SystemReference(String name, IModel parent, ISystem target) {
		super(name);	
		parent.addChild(this);
		this.target = target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ISimulinkOOAPIPackage.Literals.SYSTEM_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISystem getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ISystem)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ISystem basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ISystem newTarget) {
		ISystem oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
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
			case ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				setTarget((ISystem)newValue);
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
			case ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				setTarget((ISystem)null);
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
			case ISimulinkOOAPIPackage.SYSTEM_REFERENCE__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemReferenceAddToList(IReflectionList<ISystemReference> list){
		list.add(this);
	}
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given model, targeting to the given system
	 */	
	public static ISystemReference newNamedWithinTargeting(String name, IModel parent, ISystem target){		
		return new SystemReference(name, parent, target);
	}
	
	/**
	 * Returns new instance of SystemReference with the given name, within the given system, targeting to the given system
	 */	
	public static ISystemReference newNamedWithinTargeting(String name, ISystem parent, ISystem target){
		return new SystemReference(name, parent, target);
	}
	
	public static ISystemReference newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{		
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyTargeting))			
			throw new ProtoObjectCreationException();
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);
		ISystem target = (ISystem) constructDict.get(Factory.keyTargeting);
		ISystem system = null;
		IModel model = null;
		Object parent = constructDict.get(Factory.keyWithin);
		if (parent instanceof IModel)
			model = (IModel) parent;
		else
			system = (ISystem)parent;
		
		if (system != null)
			return new SystemReference(name, system, target);
		else
			return new SystemReference(name, model, target);		
	}

} //SystemReference
