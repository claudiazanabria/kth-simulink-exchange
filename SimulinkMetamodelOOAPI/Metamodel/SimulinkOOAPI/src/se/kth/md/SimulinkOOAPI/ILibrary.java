/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;


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
	public void addChild(IProtoObject child);
	
	/**
	 * Returns a number of all children.
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.
	 */
	public IReflectionList<IProtoObject> getAllChildren();
	
	/**
	 * Returns EList of children of GainBlock type.
	 */
	public IReflectionList<IGainBlock> getChildrenOfTypeGainBlock();	
	
	/**
	 * Returns EList of children of System type.
	 */	
	public IReflectionList<ISystem> getChildrenOfTypeSystem();

} // ILibrary
