/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimulinkOOAPI.System#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference.
	 * @see #setChildren(ChildrenSupport)
	 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getSystem_Children()
	 * @model volatile="true"
	 * @generated
	 */
	ChildrenSupport getChildren();

	/**
	 * Sets the value of the '{@link SimulinkOOAPI.System#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(ChildrenSupport value);
	
	/**
	 * Adds a ProtoObject to children list.
	 */
	public void addChild(ProtoObject child);
	
	/**
	 * Returns a number of all children.
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.
	 */
	public ReflectionList<ProtoObject> getAllChildren();
	
	/**
	 * Returns EList of children of GainBlock type.
	 */
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns EList of children of Line type.
	 */	
	public ReflectionList<Line> getChildrenOfTypeLine();
	
	/**
	 * Returns EList of children of Port type.
	 */
	public ReflectionList<Port> getChildrenOfTypePort();
	
	/**
	 * Returns EList of children of Inport type.	
	 */	
	public ReflectionList<Inport> getChildrenOfTypeInport();
	
	/**
	 * Returns EList of children of Outport type.
	 */	
	public ReflectionList<Outport> getChildrenOfTypeOutport();
	
	/**
	 * Returns EList of children of System type.
	 */	
	public ReflectionList<System> getChildrenOfTypeSystem();
	
	/**
	 * Returns EList of children of SystemReference type.
	 */	
	public ReflectionList<SystemReference> getChildrenOfTypeSystemReference();
	
	/**
	 * Returns true if the system is the parent of the given system.
	 */
	public boolean isParentOf(System system);
	
	/**
	 * Returns true if the system is the parent of the given system reference.
	 */
	public boolean isParentOf(SystemReference system);

} // System
