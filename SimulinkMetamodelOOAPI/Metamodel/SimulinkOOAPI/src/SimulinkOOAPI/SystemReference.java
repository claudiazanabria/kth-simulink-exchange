/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimulinkOOAPI.SystemReference#getTarget <em>Target</em>}</li>
 *   <li>{@link SimulinkOOAPI.SystemReference#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getSystemReference()
 * @model
 * @generated
 */
public interface SystemReference extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(SimulinkOOAPI.System)
	 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getSystemReference_Target()
	 * @model required="true"
	 * @generated
	 */
	SimulinkOOAPI.System getTarget();

	/**
	 * Sets the value of the '{@link SimulinkOOAPI.SystemReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(SimulinkOOAPI.System value);
	
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference.
	 * @see #isSetChildren()
	 * @see #unsetChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @see SimulinkOOAPI.SimulinkOOAPIPackage#getSystemReference_Children()
	 * @model unsettable="true" volatile="true"
	 * @generated
	 */
	ChildrenSupport getChildren();

	/**
	 * Sets the value of the '{@link SimulinkOOAPI.SystemReference#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Children</em>' reference.
	 * @see #isSetChildren()
	 * @see #unsetChildren()
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(ChildrenSupport value);

	/**
	 * Unsets the value of the '{@link SimulinkOOAPI.SystemReference#getChildren <em>Children</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetChildren()
	 * @see #getChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @generated
	 */
	void unsetChildren();

	/**
	 * Returns whether the value of the '{@link SimulinkOOAPI.SystemReference#getChildren <em>Children</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Children</em>' reference is set.
	 * @see #unsetChildren()
	 * @see #getChildren()
	 * @see #setChildren(ChildrenSupport)
	 * @generated
	 */
	boolean isSetChildren();

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
	//TODO: can system reference contain systems?
	public ReflectionList<System> getChildrenOfTypeSystem();
	
	/**
	 * Returns EList of children of SystemReference type.
	 * 
	 * @generated NOT
	 */	
	//TODO: can system reference contain system references?
	public ReflectionList<SystemReference> getChildrenOfTypeSystemReference();

} // SystemReference
