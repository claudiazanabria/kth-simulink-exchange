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
 *   <li>{@link se.kth.md.SimulinkOOAPI.ISystemReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystemReference()
 * @model
 * @generated
 */
public interface ISystemReference extends IProtoObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ISystem)
	 * @see se.kth.md.SimulinkOOAPI.ISimulinkOOAPIPackage#getSystemReference_Target()
	 * @model required="true"
	 * @generated
	 */
	ISystem getTarget();

	/**
	 * Sets the value of the '{@link se.kth.md.SimulinkOOAPI.ISystemReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ISystem value);

} // ISystemReference
