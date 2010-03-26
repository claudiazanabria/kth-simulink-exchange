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
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Simulink.Port#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see Simulink.SimulinkPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends ProtoObject {
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
	 * @see Simulink.SimulinkPackage#getPort_Connections()
	 * @see Simulink.Line#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Line> getConnections();

} // Port
