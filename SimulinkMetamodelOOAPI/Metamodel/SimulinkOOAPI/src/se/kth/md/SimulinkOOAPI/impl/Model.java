/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import se.kth.md.SimulinkOOAPI.IChildrenSupport;
import se.kth.md.SimulinkOOAPI.IGainBlock;
import se.kth.md.SimulinkOOAPI.ILibrary;
import se.kth.md.SimulinkOOAPI.ILine;
import se.kth.md.SimulinkOOAPI.IModel;
import se.kth.md.SimulinkOOAPI.IProtoObject;
import se.kth.md.SimulinkOOAPI.ISimulinkList;
import se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage;
import se.kth.md.SimulinkOOAPI.ISystem;
import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;
import se.kth.md.SimulinkOOAPI.exceptions.ErrorMessages;
import se.kth.md.SimulinkOOAPI.exceptions.ProtoObjectCreationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.impl.Model#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Model extends ProtoObject implements IModel {
	
	private IChildrenSupport children;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Model() {
		super();
		this.children = new ChildrenSupport();
	}	
	
	protected Model(String name) throws ProtoObjectCreationException {
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
		return ISimulinkOOAPIPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IChildrenSupport getChildren() {
		IChildrenSupport children = basicGetChildren();
		return children != null && children.eIsProxy() ? (IChildrenSupport)eResolveProxy((InternalEObject)children) : children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public IChildrenSupport basicGetChildren() {
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildren(IChildrenSupport newChildren) {
		// TODO: implement this method to set the 'Children' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ISimulinkOOAPIPackage.MODEL__CHILDREN:
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
			case ISimulinkOOAPIPackage.MODEL__CHILDREN:
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
			case ISimulinkOOAPIPackage.MODEL__CHILDREN:
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
			case ISimulinkOOAPIPackage.MODEL__CHILDREN:
				return basicGetChildren() != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void addChild(IProtoObject child) throws AddChildException {		
		child.addTo(this);		
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
	public ISimulinkList<IGainBlock> getChildrenOfTypeGainBlock() {		
		return children.getChildrenOfTypeGainBlock();
	}

	
	@Override
	public ISimulinkList<ILine> getChildrenOfTypeLine() {
		return children.getChildrenOfTypeLine();
	}

	@Override
	public ISimulinkList<ISystem> getChildrenOfTypeSystem() {
		return children.getChildrenOfTypeSystem();
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
	
	/**
	 * Returns new Model instance with the given name
	 * @throws ProtoObjectCreationException 
	 */	
	protected static Model newNamed(String name) throws ProtoObjectCreationException{						
		return new Model(name);
	}

	@Override
	public void addTo(IModel parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}

	@Override
	public void addTo(ISystem parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Override
	public void addTo(ILibrary parent) throws AddChildException {
		throw new AddChildException(this, parent);		
	}	
	
	@Deprecated
	public static IModel newFromDictionary(Map<String, Object> constructDict) throws ProtoObjectCreationException{
		//TODO: add error messages
		if (!constructDict.containsKey(Factory.keyWithName))			
			throw new ProtoObjectCreationException("");
		
		String name = (String) constructDict.get(Factory.keyWithName);
		return new Model(name);		
	}

} //Model
