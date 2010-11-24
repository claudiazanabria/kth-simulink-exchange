/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import SimulinkOOAPI.ChildrenSupport;
import SimulinkOOAPI.GainBlock;
import SimulinkOOAPI.Library;
import SimulinkOOAPI.ProtoObject;
import SimulinkOOAPI.ReflectionList;
import SimulinkOOAPI.SimulinkOOAPIPackage;
import SimulinkOOAPI.System;
import SimulinkOOAPI.util.ErrorMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SimulinkOOAPI.impl.LibraryImpl#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends ProtoObjectImpl implements Library {
	
	/**
	 * @generated NOT
	 */
	ChildrenSupport children;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected LibraryImpl() {
		super();
		children = new ChildrenSupportImpl();
	}	
	
	protected LibraryImpl(String name) {
		super(name);
		children = new ChildrenSupportImpl();
	}	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimulinkOOAPIPackage.Literals.LIBRARY;
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
	 * @generated
	 */
	public ChildrenSupport basicGetChildren() {
		// TODO: implement this method to return the 'Children' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
				setChildren((ChildrenSupport)newValue);
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
				setChildren((ChildrenSupport)null);
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
			case SimulinkOOAPIPackage.LIBRARY__CHILDREN:
				return basicGetChildren() != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**	
	 * @generated NOT
	 */
	@Override
	public void addChild(ProtoObject child) {
		if (child instanceof Library)
			throw new IllegalArgumentException("Library can not contain libraries");	
		
		this.children.addChild(child);
	}

	/**	
	 * @generated NOT
	 */
	@Override
	public ReflectionList<ProtoObject> getAllChildren() {
		return this.children.getChildren();
	}

	/**	
	 * @generated NOT
	 */
	@Override
	public int getNumberOfChildren() {
		return this.children.getNumberOfChildren();
	}
	
	/**	
	 * @generated NOT
	 */
	@Override	
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock() {
		return this.children.getChildrenOfTypeGainBlock();
	}
	
	@Override
	public ReflectionList<System> getChildrenOfTypeSystem() {
		return children.getChildrenOfTypeSystem();
	}	
	
	/**
	 * Returns new Library instance with the given name.
	 */
	public static Library newNamed(String name){
		Library library = new LibraryImpl(name);		
		return library;
	}	

	@Override
	public void addTo(System parent) {
		throw new IllegalArgumentException(ErrorMessages.LIBRARY_ADD_TO_SYSTEM);		
	}

	@Override
	public void addTo(Library parent) {
		throw new IllegalArgumentException(ErrorMessages.LIBRARY_ADD_TO_LIBRARY);		
	}

} //LibraryImpl
