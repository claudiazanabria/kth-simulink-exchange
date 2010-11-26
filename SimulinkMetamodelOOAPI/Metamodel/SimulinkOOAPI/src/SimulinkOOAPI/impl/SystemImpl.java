/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Inport;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.Line;
import SimulinkOOAPI.Model;
import SimulinkOOAPI.Outport;
import SimulinkOOAPI.Port;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import org.eclipse.emf.common.notify.Notification;
import SimulinkOOAPI.System;
import SimulinkOOAPI.SystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.SystemImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link SimulinkOOAPI.impl.SystemImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ProtoObjectImpl implements SimulinkOOAPI.System {
	
	/**
	 * @generated NOT
	 */
	ChildrenSupport children;
	/**
	 * @generated NOT
	 */
	ProtoObject parent;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected SystemImpl() {
		super();
		this.children = new ChildrenSupportImpl();
	}	
	
	protected SystemImpl(String name, System parent) {
		super(name);
		this.children = new ChildrenSupportImpl();
		this.parent = parent;
		parent.addChild(this);
	}	
	
	protected SystemImpl(String name, Model parent) {
		super(name);
		this.children = new ChildrenSupportImpl();
		this.parent = parent;
		parent.addChild(this);
	}	
	
	protected SystemImpl(String name, Library parent) {
		super(name);
		this.children = new ChildrenSupportImpl();
		this.parent = parent;
		parent.addChild(this);
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
		ChildrenSupport children = basicGetChildren();
		return children != null && children.eIsProxy() ? (ChildrenSupport)eResolveProxy((InternalEObject)children) : children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ChildrenSupport basicGetChildren() {
		// TODO: implement this method to return the 'Children' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		//throw new UnsupportedOperationException();
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(ChildrenSupport newChildren) {
		// TODO: implement this method to set the 'Children' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	 * @generated NOT
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				if (resolve) return getChildren();
				return basicGetChildren();
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				setChildren((ChildrenSupport)newValue);
				return;
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				setChildren((ChildrenSupport)null);
				return;
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
			case SimulinkOOAPIPackage.SYSTEM__CHILDREN:
				return basicGetChildren() != null;
			case SimulinkOOAPIPackage.SYSTEM__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void ifSystemAddToList(ReflectionList<System> list){
		list.add(this);
	}
	
	@Override
	public void addChild(ProtoObject child) {	
		if (child instanceof Library)
			throw new IllegalArgumentException("System can not contain libraries");		
		
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
	
	@Override
	public ReflectionList<Inport> getChildrenOfTypeInport() {
		return children.getChildrenOfTypeInport();
	}

	@Override
	public ReflectionList<Outport> getChildrenOfTypeOutport() {		
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
	 */
	@Deprecated
	public static System newNamedWithin(String name, Model parent){
		System system = new SystemImpl(name, parent);
		return system;
	}
	
	/**
	 * Returns new instance of System with the given name within the given system. 
	 */
	@Deprecated
	public static System newNamedWithin(String name, System parent){
		System returnSystem = new SystemImpl(name, parent);		
		return returnSystem;
	}
	
	/**
	 * Returns new instance of System with the given name within the given library. 
	 */
	@Deprecated
	public static System newNamedWithin(String name, Library parent){
		System returnSystem = new SystemImpl(name, parent);		
		return returnSystem;
	}
	
	public static System newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{		
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException();
		if (!constructDict.containsKey(Factory.keyWithin))			
			throw new ProtoObjectCreationException();
		
		//TODO: add check for the type casting		
		String name = (String) constructDict.get(Factory.keyWithName);
		System system = null;
		Library library = null;
		Model model = null;
		Object parent = constructDict.get(Factory.keyWithin);
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
	

} //SystemImpl
