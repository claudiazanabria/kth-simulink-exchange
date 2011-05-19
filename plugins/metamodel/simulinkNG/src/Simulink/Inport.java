/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.Inport#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getInport()
 * @model
 * @generated
 */
public interface Inport extends Port {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Simulink.System#getInports <em>Inports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Simulink.System)
	 * @see Simulink.SimulinkPackage#getInport_Parent()
	 * @see Simulink.System#getInports
	 * @model opposite="inports" required="true" transient="false"
	 * @generated
	 */
	Simulink.System getParent();

	/**
	 * Sets the value of the '{@link Simulink.Inport#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Simulink.System value);

} // Inport
