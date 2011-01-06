/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package se.kth.md.SimulinkOOAPI;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link se.kth.md.SimulinkOOAPI.SystemReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getSystemReference()
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
	 * @see #setTarget(se.kth.md.SimulinkOOAPI.System)
	 * @see se.kth.md.SimulinkOOAPI.SimulinkOOAPIPackage#getSystemReference_Target()
	 * @model required="true"
	 * @generated
	 */
	se.kth.md.SimulinkOOAPI.System getTarget();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.SystemReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(se.kth.md.SimulinkOOAPI.System value);

} // ISystemReference
