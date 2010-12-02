/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

import se.kth.md.SimulinkOOAPI.exceptions.AddChildException;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.ILibrary#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getLibrary()
 * @model
 * @generated
 */
public interface ILibrary extends IProtoObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference.
	 * @see #setChildren(IChildrenSupport)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getLibrary_Children()
	 * @model volatile="true"
	 * @generated
	 */
	IChildrenSupport getChildren();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ILibrary#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(IChildrenSupport value);
	
	/**
	 * Adds a ProtoObject to children list.
	 */
	public void addChild(IProtoObject child) throws AddChildException;
	
	/**
	 * Returns a number of all children.
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns a list of all children.
	 */
	public ISimulinkList<IProtoObject> getAllChildren();
	
	/**
	 * Returns a list of children of GainBlock type.
	 */
	public ISimulinkList<IGainBlock> getChildrenOfTypeGainBlock();	
	
	/**
	 * Returns a list of children of System type.
	 */	
	public ISimulinkList<ISystem> getChildrenOfTypeSystem();
	
	/**
	 * Returns a first child met with the given name or uuid.
	 * Returns null if there is no such child.
	 */
	public IProtoObject childWith(String uuidOrName);

} // ILibrary
