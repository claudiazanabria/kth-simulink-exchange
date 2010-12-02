/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.ISystem#getChildren <em>Children</em>}</li>
 *   <li>{@link se.kth.md.SimulinkOOAPI.ISystem#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystem()
 * @model
 * @generated
 */
public interface ISystem extends IProtoObject {
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
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystem_Children()
	 * @model volatile="true"
	 * @generated
	 */
	IChildrenSupport getChildren();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ISystem#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(IChildrenSupport value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(IProtoObject)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystem_Parent()
	 * @model required="true"
	 * @generated
	 */
	IProtoObject getParent();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ISystem#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(IProtoObject value);
	
	/**
	 * Adds a ProtoObject to children list.
	 */
	public void addChild(IProtoObject child);
	
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
	 * Returns a list of children of Line type.
	 */	
	public ISimulinkList<ILine> getChildrenOfTypeLine();
	
	/**
	 * Returns a list of children of Port type.
	 */
	public ISimulinkList<IPort> getChildrenOfTypePort();
	
	/**
	 * Returns a list of children of Inport type.	
	 */	
	public ISimulinkList<IInport> getChildrenOfTypeInport();
	
	/**
	 * Returns a list of children of Outport type.
	 */	
	public ISimulinkList<IOutport> getChildrenOfTypeOutport();
	
	/**
	 * Returns a list of children of System type.
	 */	
	public ISimulinkList<ISystem> getChildrenOfTypeSystem();
	
	/**
	 * Returns a list of children of SystemReference type.
	 */	
	public ISimulinkList<ISystemReference> getChildrenOfTypeSystemReference();
	
	/**
	 * Returns true if the system is the parent of the given system.
	 */
	public boolean isParentOf(ISystem system);
	
	/**
	 * Returns true if the system is the parent of the given system reference.
	 */
	public boolean isParentOf(ISystemReference system);
	
	/**
	 * Returns a first child met with the given name or uuid.
	 * Returns null if there is no such child.
	 */
	public IProtoObject childWith(String uuidOrName);

} // ISystem
