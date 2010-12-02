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
 *   <li>{@link se.kth.md.SimulinkOOAPI.ISystem#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystem()
 * @model
 * @generated
 */
public interface ISystem extends IContainer {
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
	

} // ISystem
