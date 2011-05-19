/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package Simulink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.Model#getParts <em>Parts</em>}</li>
 *   <li>{@link Simulink.Model#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ProtoObject {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link Simulink.System}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see Simulink.SimulinkPackage#getModel_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Simulink.System> getParts();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Simulink.System)
	 * @see Simulink.SimulinkPackage#getModel_Root()
	 * @model
	 * @generated
	 */
	Simulink.System getRoot();

	/**
	 * Sets the value of the '{@link Simulink.Model#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Simulink.System value);

} // Model
