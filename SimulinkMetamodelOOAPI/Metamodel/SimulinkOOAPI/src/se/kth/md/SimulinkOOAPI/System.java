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
 *   <li>{@link se.kth.md.SimulinkOOAPI.System#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends Container {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(ProtoObject)
	 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getSystem_Parent()
	 * @model required="true"
	 * @generated
	 */
	ProtoObject getParent();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.System#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ProtoObject value);	
	
	/**
	 * Returns a list of children of Line type.
	 */	
	public SimulinkList<Line> getChildrenOfTypeLine();
	
	/**
	 * Returns a list of children of Port type.
	 */
	public SimulinkList<Port> getChildrenOfTypePort();
	
	/**
	 * Returns a list of children of Inport type.	
	 */	
	public SimulinkList<Inport> getChildrenOfTypeInport();
	
	/**
	 * Returns a list of children of Outport type.
	 */	
	public SimulinkList<Outport> getChildrenOfTypeOutport();	
	
	/**
	 * Returns a list of children of SystemReference type.
	 */	
	public SimulinkList<SystemReference> getChildrenOfTypeSystemReference();
	
	/**
	 * Returns true if the system is the parent of the given system.
	 */
	public boolean isParentOf(System system);
	
	/**
	 * Returns true if the system is the parent of the given system reference.
	 */
	public boolean isParentOf(SystemReference system);	
	

} // ISystem
