/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.SystemReference#getTarget <em>Target</em>}</li>
 *   <li>{@link Simulink.SystemReference#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getSystemReference()
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
	 * @see #setTarget(Simulink.System)
	 * @see Simulink.SimulinkPackage#getSystemReference_Target()
	 * @model required="true"
	 * @generated
	 */
	Simulink.System getTarget();

	/**
	 * Sets the value of the '{@link Simulink.SystemReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Simulink.System value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Simulink.System#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Simulink.System)
	 * @see Simulink.SimulinkPackage#getSystemReference_Parent()
	 * @see Simulink.System#getChildren
	 * @model opposite="children" required="true" transient="false"
	 * @generated
	 */
	Simulink.System getParent();

	/**
	 * Sets the value of the '{@link Simulink.SystemReference#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Simulink.System value);

} // SystemReference
