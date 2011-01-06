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
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.SystemImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ContainerImpl implements se.kth.md.SimulinkOOAPI.System {
	
	private ProtoObject parent;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}	
	
	protected SystemImpl(String name, System parent) throws ProtoObjectCreationException {
		super(name);	
		this.parent = parent;
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Systems can be added to systems.
		}
	}	
	
	protected SystemImpl(String name, Model parent) throws ProtoObjectCreationException {
		super(name);		
		this.parent = parent;
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Systems can be added to models.
		}
	}	
	
	protected SystemImpl(String name, Library parent) throws ProtoObjectCreationException {
		super(name);
		this.parent = parent;
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Systems can be added to libraries.
		}
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
	public ProtoObject getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (ProtoObject)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimulinkOOAPIPackage.SYSTEM__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtoObject basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(ProtoObject newParent) {
		ProtoObject oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimulinkOOAPIPackage.SYSTEM__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.SYSTEM__PARENT:
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
			case SimulinkOOAPIPackage.SYSTEM__PARENT:
				setParent((ProtoObject)newValue);
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
			case SimulinkOOAPIPackage.SYSTEM__PARENT:
				setParent((ProtoObject)null);
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
			case SimulinkOOAPIPackage.SYSTEM__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemAddToList(SimulinkList<System> list){
		list.add(this);
	}
	
	@Override
	public SimulinkList<Line> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}

	@Override
	public SimulinkList<Port> getChildrenOfTypePort() {
		return children.getChildrenOfTypePort();
	}
	
	@Override
	public SimulinkList<SystemReference> getChildrenOfTypeSystemReference() {
		return children.getChildrenOfTypeSystemReference();
	}
	
	@Override
	public SimulinkList<Inport> getChildrenOfTypeInport() {
		return children.getChildrenOfTypeInport();
	}

	@Override
	public SimulinkList<Outport> getChildrenOfTypeOutport() {		
		return children.getChildrenOfTypeOutport();
	}
	
	@Override
	public boolean isParentOf(System system) {
		return getChildrenOfTypeSystem().contains(system);
	}
	
	@Override
	public boolean isParentOf(SystemReference systemReference) {
		return getChildrenOfTypeSystemReference().contains(systemReference);
	}
	
	/**
	 * Returns new instance of System with the given name within the given model. 
	 * @throws ProtoObjectCreationException 
	 */
	protected static SystemImpl newNamedWithin(String name, Model parent) throws ProtoObjectCreationException{		
		return new SystemImpl(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 * @throws ProtoObjectCreationException 
	 */
	protected static SystemImpl newNamedWithin(String name, System parent) throws ProtoObjectCreationException{		
		return new SystemImpl(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static SystemImpl newNamedWithin(String name, Library parent) throws ProtoObjectCreationException{
		return new SystemImpl(name, parent);
	}
	
	@Deprecated
	public static System newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: error messages
		if (!constructDict.containsKey(FactoryImpl.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(FactoryImpl.keyWithin))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(FactoryImpl.keyWithName);
		System system = null;
		Library library = null;
		Model model = null;
		Object parent = constructDict.get(FactoryImpl.keyWithin);
		if (parent instanceof Library)
			library = (Library) parent;
		else if (parent instanceof System)
			system = (System)parent;
		else 
			model = (Model) parent;
		
		if (system != null)
			return new SystemImpl(name, system);
		if (model != null)
			return new SystemImpl(name, model);
		return new SystemImpl(name, library);
	}	

} //System
