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
	 * 
	 * @generated NOT
	 */
	public void addChild(ProtoObject child);
	
	/**
	 * Returns a number of all children.
	 * 
	 * @generated NOT
	 */
	public int getNumberOfChildren();
	
	/**
	 * Returns EList of all children.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<ProtoObject> getAllChildren();
	
	/**
	 * Returns EList of children of GainBlock type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<GainBlock> getChildrenOfTypeGainBlock();
	
	/**
	 * Returns EList of children of Line type.
	 * 
	 * @generated NOT
	 */	
	public ReflectionList<Line> getChildrenOfTypeLine();
	
	/**
	 * Returns EList of children of Port type.
	 * 
	 * @generated NOT
	 */
	public ReflectionList<Port> getChildrenOfTypePort();
	
	/**
	 * Returns EList of children of System type.
	 * 
	 * @generated NOT
	 */	
	public ReflectionList<System> getChildrenOfTypeSystem();
	
	/**
	 * Returns EList of children of SystemReference type.
	 * 
	 * @generated NOT
	 */	
	public ReflectionList<SystemReference> getChildrenOfTypeSystemReference();

} // System
