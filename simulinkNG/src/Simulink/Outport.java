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
 * A representation of the model object '<em><b>Outport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.Outport#getParent <em>Parent</em>}</li>
 *   <li>{@link Simulink.Outport#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getOutport()
 * @model
 * @generated
 */
public interface Outport extends Port {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Simulink.System#getOutports <em>Outports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Simulink.System)
	 * @see Simulink.SimulinkPackage#getOutport_Parent()
	 * @see Simulink.System#getOutports
	 * @model opposite="outports" required="true" transient="false"
	 * @generated
	 */
	Simulink.System getParent();

	/**
	 * Sets the value of the '{@link Simulink.Outport#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Simulink.System value);

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link Simulink.Line}.
	 * It is bidirectional and its opposite is '{@link Simulink.Line#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see Simulink.SimulinkPackage#getOutport_Connections()
	 * @see Simulink.Line#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Line> getConnections();
} // Outport
