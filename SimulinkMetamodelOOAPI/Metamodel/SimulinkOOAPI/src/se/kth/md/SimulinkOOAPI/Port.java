/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.Port#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(se.kth.md.SimulinkOOAPI.System)
	 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getPort_Parent()
	 * @model required="true"
	 * @generated
	 */
	se.kth.md.SimulinkOOAPI.System getParent();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.Port#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(se.kth.md.SimulinkOOAPI.System value);

} // IPort
