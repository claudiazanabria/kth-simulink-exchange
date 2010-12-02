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
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.System#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class System extends Container implements ISystem {
	
	private IProtoObject parent;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated 
	 */
	protected System() {
		super();		
	}	
	
	protected System(String name, ISystem parent) throws ProtoObjectCreationException {
		super(name);	
		this.parent = parent;
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Systems can be added to systems.
		}
	}	
	
	protected System(String name, IModel parent) throws ProtoObjectCreationException {
		super(name);		
		this.parent = parent;
		try {
			parent.addChild(this);
		} catch (AddChildException e) {
			//Should not happen. Systems can be added to models.
		}
	}	
	
	protected System(String name, ILibrary parent) throws ProtoObjectCreationException {
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
		return ISimulinkOOAPIPackage.Literals.SYSTEM;
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProtoObject getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (IProtoObject)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ISimulinkOOAPIPackage.SYSTEM__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProtoObject basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(IProtoObject newParent) {
		IProtoObject oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ISimulinkOOAPIPackage.SYSTEM__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.SYSTEM__PARENT:
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
			case ISimulinkOOAPIPackage.SYSTEM__PARENT:
				setParent((IProtoObject)newValue);
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
			case ISimulinkOOAPIPackage.SYSTEM__PARENT:
				setParent((IProtoObject)null);
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
			case ISimulinkOOAPIPackage.SYSTEM__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemAddToList(ISimulinkList<ISystem> list){
		list.add(this);
	}
	
	@Override
	public ISimulinkList<ILine> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}

	@Override
	public ISimulinkList<IPort> getChildrenOfTypePort() {
		return children.getChildrenOfTypePort();
	}
	
	@Override
	public ISimulinkList<ISystemReference> getChildrenOfTypeSystemReference() {
		return children.getChildrenOfTypeSystemReference();
	}
	
	@Override
	public ISimulinkList<IInport> getChildrenOfTypeInport() {
		return children.getChildrenOfTypeInport();
	}

	@Override
	public ISimulinkList<IOutport> getChildrenOfTypeOutport() {		
		return children.getChildrenOfTypeOutport();
	}
	
	@Override
	public boolean isParentOf(ISystem system) {
		return getChildrenOfTypeSystem().contains(system);
	}
	
	@Override
	public boolean isParentOf(ISystemReference systemReference) {
		return getChildrenOfTypeSystemReference().contains(systemReference);
	}
	
	/**
	 * Returns new instance of System with the given name within the given model. 
	 * @throws ProtoObjectCreationException 
	 */
	protected static System newNamedWithin(String name, IModel parent) throws ProtoObjectCreationException{		
		return new System(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 * @throws ProtoObjectCreationException 
	 */
	protected static System newNamedWithin(String name, ISystem parent) throws ProtoObjectCreationException{		
		return new System(name, parent);
	}
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 * @throws ProtoObjectCreationException 
	 */	
	protected static System newNamedWithin(String name, ILibrary parent) throws ProtoObjectCreationException{
		return new System(name, parent);
	}
	
	@Deprecated
	public static ISystem newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException("");
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);
		ISystem system = null;
		ILibrary library = null;
		IModel model = null;
		Object parent = constructDict.get(Factory.keyWithin);
		if (parent instanceof ILibrary)
			library = (ILibrary) parent;
		else if (parent instanceof ISystem)
			system = (ISystem)parent;
		else 
			model = (IModel) parent;
		
		if (system != null)
			return new System(name, system);
		if (model != null)
			return new System(name, model);
		return new System(name, library);
	}	

} //System
